package botton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

import makekickfile.Digest;
import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import technique.CheckSign;
import GamenDTO.TAB_MainDTO;
import accesarrySQL.OneRecord_Update;
import analysis.SagyoSpace;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.TimerShoriConst;
import constant.logWriting;
import constant.nyuryokuCheckResultConst;
import controller.CONTOLLBOTTON;

public class cloringDate {
	public String getDayDate(TAB_MainDTO mainDTO){
//		GetCodeList a = new GetCodeList();

		long start = System.currentTimeMillis();
		long stop = System.currentTimeMillis();
		//日々売買ファイルの出力先

		String folderPath = mainDTO.getEntryFolderPath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		String folderPath = "D:" + ReturnCodeConst.SQL_SEPA + "orderList";
//		String folderPath = "C:" + ReturnCodeConst.SQL_SEPA + "Users" + ReturnCodeConst.SQL_SEPA + "NOBORU1988" + ReturnCodeConst.SQL_SEPA + "Dropbox" + ReturnCodeConst.SQL_SEPA + "everyfolder";
//		String folderPath = "D:" + ReturnCodeConst.SQL_SEPA + "orderList";
		//前日動かしたかどうかのチェック
//		if (checkPreTodayLog(folderPath)==false){
//			return;
//		}

//		outPutKeepTable(1.1,folderPath);

		//時系列データの更新
		switch (zikeiretuDataUpdate(mainDTO)){
			case ReturnCodeConst.EVERY_UPDATE_SUCSESS:
				break;
			case ReturnCodeConst.EVERY_UPDATE_NOTHING:
				stop = System.currentTimeMillis();
				commonAP.writeInLog("アップデートなし" + "。実行にかかった時間は " + (stop - start) + " ﾐﾘ秒です。" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.NO_UPDATE;
			case ReturnCodeConst.EVERY_UPDATE_ERR:
				stop = System.currentTimeMillis();
				commonAP.writeInLog("なんかエラー1" + "。実行にかかった時間は " + (stop - start) + " ﾐﾘ秒です。" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.ERR_1;
			default:
				stop = System.currentTimeMillis();
				commonAP.writeInLog("なんかエラー2" + "。実行にかかった時間は " + (stop - start) + " ﾐﾘ秒です。" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.ERR_2;
		}



		if ( checkTodayLog() == false ){
			//更新日が一致しない場合は終了する。
			stop = System.currentTimeMillis();
			commonAP.writeInLog("一部分のみが更新されている。" + "。実行にかかった時間は " + (stop - start)/1000 + " 秒です。" ,logWriting.DATEDATE_LOG_FLG);
			return TimerShoriConst.UPDATE_BARABARA;
		}


		//今日のサインの点灯をチェックする。LSファイルの元ネタ作成
		CheckSign.checkTodaySign();

		//最後に今日の売買ファイルを出力する。
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);

//		LSファイル作成
		commonAP.writeInLog("日々ファイル作成します。",logWriting.DATEDATE_LOG_FLG);
		switch (outPutKeepTable(paraDTO.getEntryMoney(),folderPath)) {
			case ReturnCodeConst.SQL_ERR_0:
				//成功
				commonAP.writeInLog("日々ファイル作成成功しました。",logWriting.DATEDATE_LOG_FLG);
				break;
			case ReturnCodeConst.SQL_ERR_1086:
				//ファイルが既に存在する
				break;
			case ReturnCodeConst.SQL_ERR_1:
				//指定したディレクトリが存在しない
				stop = System.currentTimeMillis();
				commonAP.writeInLog(folderPath+"が存在しない。" + "実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);
				break;
			default:
				commonAP.writeInLog("日々売買ファイルの出力でなんかエラー。" + "実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);
				break;
		}





		//売買ファイル（LSファイル）を各個人フォルダにコピーする
		S s = new S();
		s.getCon();
		String LS_TODAY = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
		String TODAY = controllDay.getTODAY();
		String checkDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_BACK_UP, s);
		s.closeConection();

		//分割ファイルの作成/取込を行う。
		CreateSepaComFile sepaComCheck = new CreateSepaComFile();
		sepaComCheck.checkSepaComFile(mainDTO,LS_TODAY);

		//LSファイルばら撒き、FBS用ファイル(保有銘柄一覧、キックファイル、分割併合ファイル確認用ファイル)のばら撒きとか
		fileCOPY(mainDTO,TODAY,LS_TODAY);

		//backUp開始
		backUpLogic(mainDTO,LS_TODAY,checkDay);


		stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

		return TimerShoriConst.SUCCESS;

	}

	//DBのbackUp開始
	private void backUpLogic(TAB_MainDTO mainDTO,String TODAY,String checkDay){
		if (mainDTO.isAutoBackUp()){
			BackUp BU = new BackUp();

			//最適化フラグがtrueの場合最適化もやる
			if (mainDTO.isOptimazeFLG()){
				BU.optimizeDB(mainDTO);
			}

			if (commonAP.checkSabunDay(TODAY,checkDay,PROPARTY.BACK_UP_KANkAKU)==false){
				//同名ファイルのチェック
				//バックアップファイルの出力先にバックアップファイルが存在するかどうかのチェック
//
				String todayDump = mainDTO.getOutBackUpFolderPath() + File.separator + TODAY + ".dump";
				String todayFolder = mainDTO.getOutBackUpFolderPath();
				File file =  new File(todayDump);
				if (file.isFile()==true){
					BU = new BackUp();
					commonAP.writeInLog(todayDump,logWriting.DATEDATE_LOG_FLG);
					commonAP.writeInLog("↑同名ファイルが存在するため、バックアップは行いません。",logWriting.DATEDATE_LOG_FLG);
				}else{
					//バックアップ成功時の処理
					mainDTO.setOutBackUpFilePath(todayDump);
					String resultBackOut = BU.backUpOut(mainDTO);
					//画面の入力値とDTOの値を一致させる。
					mainDTO.setOutBackUpFilePath(todayFolder);
					if (resultBackOut.equals(nyuryokuCheckResultConst.SUCCESS)){
						BU.checkDumpFileNumbers(mainDTO);
					}
				}
			}


			BU = new BackUp();
		}
	}


	//LSファイルばら撒き、FBS用ファイルのばら撒きとか
	private void fileCOPY(TAB_MainDTO mainDTO,String TODAY,String LS_TODAY){

		//LSファイルばら撒き
		copyParsonalFolder(LS_TODAY,mainDTO.getEntryFolderPath(),true);
		copyParsonalFolder(LS_TODAY,mainDTO.getEntryFolderPath(),false);

		//今日のセパコンバインレコードの作成
		String fileName = "FBSsepaCombine.csv";
		createTODAYSepaComBine(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//		createTODAYSepaComBine("2017-09-26",mainDTO.getEntryFolderPath(),fileName);

		//FBS_KICK_2017-07-31.fbs
        fileName = "FBS_KICK_" + TODAY + ".fbs";
		//暗号化ファイル作成（キックファイル）
		createSecureFile(TODAY,mainDTO.getEntryFolderPath(),fileName);
		//ばら撒き
		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//		//暗号化ファイルばら撒き、ただし無料ユーザーのみ
//		copyFile_for_KICK_USER(TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
//		//有料ユーザー分のキックファイルばらまき
//		copyFile_for_KICK_USER(TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL);

		//保有銘柄一覧作成
		fileName = LS_TODAY + "_fias_keep.csv";
		createKeepListFile(mainDTO.getEntryFolderPath(),fileName);
		//ばら撒き
		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//		//保有銘柄一覧ばら撒き、ただし無料ユーザーのみ
//		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
//		//有料ユーザー分の保有銘柄一覧ばら撒き
//		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL);
		//有料ユーザー後処理
		afterDealPayingUser(LS_TODAY);
	}

	public void createTODAYSepaComBine(String TODAY,String folderPath,String fileName){
		S s = new S();
		s.getCon();
		String TBL = TBL_Name.SEPARATE_DD;
		String SQL1 = "select * from " + TBL + " where "+ COLUMN.DAYTIME_KENRI_LAST + " = '" + TODAY + "'";
		try {
			s.rs = s.sqlGetter().executeQuery(SQL1);

			if (s.rs.next()){
				//レコードが存在する場合はココ
				String filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileName;
				filePath = filePath.replace(File.separator,ReturnCodeConst.SQL_SEPA);

				String column = COLUMN.CODE						 + " , "
								+ COLUMN.CHECKSEPA_COMBINE		 + " , "//falseは併合、trueは分割
//								+ COLUMN.DAYTIME_KENRI_LAST		 + " , " //権利付最終売買日。効力は権利付最終日の翌営業日から発生する
								+ COLUMN.AJUSTRATE				 + "  "; //調整レート。仕様はまだ決まっていないが、

				String heddaColumn =  "'" +  COLUMN.CODE		 			+ "' , "
									+ "'" +  COLUMN.CHECKSEPA_COMBINE		+ "' , "
//									+ "'" +  COLUMN.DAYTIME_KENRI_LAST		+ "' , "
									+ "'" +  COLUMN.AJUSTRATE				+ "'  ";

				String SQL2 =	" SELECT "
							+ heddaColumn
							+ " union "
							+ " SELECT "
							+ " " + column + " "
							+ " FROM " + TBL
							+ " where "+ COLUMN.DAYTIME_KENRI_LAST + " = '" + TODAY + "'"
							+	" INTO OUTFILE '" + filePath +  "'"
							+	" FIELDS TERMINATED BY ','"
							+	" OPTIONALLY ENCLOSED BY '\"'";

				s.exportFile(SQL2);
				//セパコンバインレコードばら撒き
				copyFile_for_KICK_USER(TODAY,folderPath,fileName);

				//作ったファイルの削除
		        File file = new File(filePath);

		        if(file.delete()){
		        	//成功
		        	commonAP.writeInLog(file + "の削除に成功しました。",logWriting.DATEDATE_LOG_FLG);
		        }else{
		        	//失敗
		        	commonAP.writeInLog(file + "の削除に失敗しました。",logWriting.DATEDATE_LOG_FLG);
		        }
			};

		} catch (SQLException e) {}

		s.closeConection();
	}

	//有料ユーザー後処理
	public void afterDealPayingUser(String TODAY){
		S s = new S();
		s.getCon();
		String SQL;
		String TBL = TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL;

		SQL = "update " + TBL
				+ " set "
				+ COLUMN.KOSIN_DAYTIME + " = '" + TODAY + "'";
		s.freeUpdateQuery(SQL);


		SQL = " delete from " + TBL
			+	" where "
			+	COLUMN.KOSIN_DAYTIME + " >= " + COLUMN.LIMIT_DAYTIME;
		s.freeUpdateQuery(SQL);


		s.closeConection();
	}

	//保有銘柄一覧作成
	public void createKeepListFile(String folderPath,String fileName){

		S s = new S();
		s.getCon();

		String SQL;
		String filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileName;

		filePath = filePath.replace(File.separator,ReturnCodeConst.SQL_SEPA);

		String column = COLUMN.CODE										 + " , " //
						+ COLUMN.ENTRYDAY								 + " , " //
						+ COLUMN.LASTENTRYDAY							 + " , " //
						+ COLUMN.ENTRYTIMES								 + " , " //
						+ COLUMN.AVERAGEPRICE							 + " , " //
						+ COLUMN.TYPE									 + " , " //
						+ COLUMN.ENTRYMETHOD							 + " , " //
						+ COLUMN.EXITMETHOD								 + " ,  " //
						+ COLUMN.MINI_CHECK_FLG							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
						+ COLUMN.IDEA_VOLUME							 + " ,  "  //理想的保持数
						+ COLUMN.IDEA_AVERAGEPRICE						 + " ,  "  //理想的平均取得価格
						+ COLUMN.IDEA_TOTAL_ENTRY_MONEY					 + " ,  "  //理想的合計投資金額
						+ COLUMN.REAL_ENTRY_VOLUME						 + " ,  "  //現実保有数
						+ COLUMN.REAL_AVERAGEPRICE						 + " ,  "  //現実平均取得価格
						+ COLUMN.REAL_TOTAL_ENTRY_MONEY					 + "   " ;	//現実的合計投資金額

//		String heddaColumn = "'" +  COLUMN.CODE		 			+ "' , " //
//							+ "'" +  COLUMN.DAYTIME				+ "' , " //
//							+ "'" +  COLUMN.TYPE					+ "' , " //
//							+ "'" +  COLUMN.ENTRYMETHOD			+ "' , " //
//							+ "'" +  COLUMN.EXITMETHOD			+ "' , "
//							+ "'" +  COLUMN.MINI_CHECK_FLG		+ "' , "
//							+ "'" +  COLUMN.REAL_ENTRY_VOLUME	+ "' , "
//							+ "'" +  COLUMN.ENTRY_MONEY			+ "'" ;


		String heddaColumn =  "'" + COLUMN.CODE								 + "' , " //
					+  "'" + COLUMN.ENTRYDAY								 + "' , " //
					+  "'" + COLUMN.LASTENTRYDAY							 + "' , " //
					+  "'" + COLUMN.ENTRYTIMES								 + "' , "  //
					+  "'" + COLUMN.AVERAGEPRICE							 + "' , "  //
					+  "'" + COLUMN.TYPE								 	 + "' , "  //
					+  "'" + COLUMN.ENTRYMETHOD								 + "' , "  //
					+  "'" + COLUMN.EXITMETHOD								 + "' , "  //
					+  "'" + COLUMN.MINI_CHECK_FLG							 + "' , "  //ミニ株本株チェック trueミニ株、false普通株
					+  "'" + COLUMN.IDEA_VOLUME								 + "' , "   //理想的保持数
					+  "'" + COLUMN.IDEA_AVERAGEPRICE						 + "' , "   //理想的平均取得価格
					+  "'" + COLUMN.IDEA_TOTAL_ENTRY_MONEY					 + "' , "   //理想的合計投資金額
					+  "'" + COLUMN.REAL_ENTRY_VOLUME						 + "' , "   //現実保有数
					+  "'" + COLUMN.REAL_AVERAGEPRICE						 + "' , "   //現実平均取得価格
					+  "'" + COLUMN.REAL_TOTAL_ENTRY_MONEY					 +  "'  "  ;	//現実的合計投資金額

		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ " " + column + " "
				+ " FROM " + TBL_Name.KEEPLISTTBL
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";

//		SQL =	" SELECT "
//				+ " * "
//				+ " FROM " + TBL_Name.KEEPLISTTBL
//				+	" INTO OUTFILE '" + filePath +  "'"
//				+	" FIELDS TERMINATED BY ','"
//				+	" OPTIONALLY ENCLOSED BY '\"'";



		s.exportFile(SQL);

		s.closeConection();
	}



	//暗号化ファイル作成メソッド()
	//TODAY = YYYY-MM-DD
	public void createSecureFile(String TODAY,String folderPath,String fileName){
		S s = new S();
		s.getCon();

		String FBS_KEY = commonAP.getParametaChoseTBL(TBL_Name.PROPARTY_TBL,COLUMN.ITEMNAME,COLUMN.ITEMNAME_DESC,PROPARTY.FBS_KEY,s);
		FBS_KEY = FBS_KEY + "_" + TODAY;

		//FBS_KICK_2017-07-31.fbs
		String filePath = folderPath + File.separator + fileName;
		s.closeConection();

		Digest digest = new Digest();
		digest.makeDigestFile(filePath, FBS_KEY, 0);



	}

	private void copyFile_for_KICK_USER(String TODAY,String folderPath,String fileName){
		//ばら撒き、ただし無料ユーザーのみ
		copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
		//有料ユーザーユーザー分のばら撒き
		copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL);
	}


	//暗号化ファイルばら撒きメソッド、キックファイルユーザーリストから抽出する。
	private void copyFile_for_KICK_USER(String TODAY,String folderPath,String fileName,String TBL){
        //ディレクトリ指定
        File dir = new File(folderPath);


        Path copyMoto = Paths.get(folderPath + File.separator + fileName);



        //キックファイル配布リスト取得
        S s = new S();
        s.getCon();

        //キックファイルユーザーリスト
        ArrayList<String> kickFileUserList = new ArrayList<String>();

        String SQL = " select * from " + TBL;


		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				kickFileUserList.add(s.rs.getString(COLUMN.KICK_FILE_USER_FOLDER));
			}
		} catch (SQLException e) {}
        s.closeConection();


        //全フォルダーを取得（fileを除く）
        String[] folderList = dir.list();

        for(String personalFolderPath : folderList){

        	File parsonalFolderPath = new File(personalFolderPath);
        	String parsonalFolderName = parsonalFolderPath.getName();

        	if(kickFileUserList.indexOf(parsonalFolderName) != -1){
        		//自動売買ツールを使う場合はこれ
				Path targetPath = Paths.get(folderPath + File.separator + personalFolderPath + File.separator + fileName);
				copyFile(copyMoto,targetPath,(folderPath + File.separator + personalFolderPath));
        	};

        }
	}

	private void copyFile(Path copyMoto,Path targetPath,String checkPath){
		try {
			//ファイルかディレクトリかをチェックする。ディレクトリの場合は処理する。
        	File checkFile = new File(checkPath);
        	if(checkFile.isDirectory()){
        		//ディレクトリのとき
        		File file = new File(targetPath.toString());
		        if(file.delete()){
		        	//成功
		        	commonAP.writeInLog(file + "が存在するので上書きします。",logWriting.DATEDATE_LOG_FLG);
		        };

        		Files.copy(copyMoto, targetPath);
        	}else if(checkFile.isFile()){
        		//ファイルのとき
        	}else{
        		//それ以外のとき
        		commonAP.writeInLog("以下のファイル？何か変なの来ています。",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("コピー元と思われるもの："+copyMoto,logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("コピー先と思われるもの："+targetPath,logWriting.DATEDATE_LOG_FLG);
        	}
//		} catch (IOSuch a) {

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			commonAP.writeInLog("以下のファイルのコピーが失敗したっぽいです",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("コピー元："+copyMoto,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("コピー先："+targetPath,logWriting.DATEDATE_LOG_FLG);
			e.printStackTrace();
		}
	}

	//売買ファイルを各個人フォルダにコピーする
	//true:買い
	//false:売り
	private void copyParsonalFolder(String TODAY,String folderPath,boolean checkFLG){
        //ディレクトリ指定
        File dir = new File(folderPath);

        String fileName = "";

        if (checkFLG){
        	//2017-06-20_L.csv
        	fileName = TODAY + "_L.csv";
        }else{
        	//2017-06-20_S.csv
        	fileName = TODAY + "_S.csv";
        }

//        File copyMoto = new File(folderPath + File.separator + fileName);
        Path copyMoto = Paths.get(folderPath + File.separator + fileName);


        //全フォルダーを取得（fileを除く）
        String[] folderList = dir.list();

        for(String personalFolderPath : folderList){


        	File parsonalFolderPath = new File(personalFolderPath);
        	String parsonalFolderName = parsonalFolderPath.getName();
        	switch (parsonalFolderName) {
				case "00000.commonBoard_typeA":
					break;
				case "10000.commonBoard_typeB":
					break;
				case "old":
					break;
				default:

					Path targetPath = Paths.get(folderPath + File.separator + personalFolderPath + File.separator + fileName);
					copyFile(copyMoto,targetPath,(folderPath + File.separator + personalFolderPath));

					break;
			}

        }

	}

	//時系列データの更新
	private int zikeiretuDataUpdate(TAB_MainDTO mainDTO){
		CONTOLLBOTTON CB = new CONTOLLBOTTON();
		S s = new S();
		s.getCon();

		int stockResult;
		int statisticsResult;
		int indexResult;

		//コードリストテーブルを作る、日々の更新をする。
		//統計
		statisticsResult = CB.everyDayBottonContoroll(	controllDay.getMAX_DD_STATISTICS(s) 		,
														controllDay.getAJUSTMAXDAY_STATISTICS (s) 	,
														ReCord.CODE_02_SATISTICS					,
														s											);

		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		s.resetConnection();

		stockResult = CB.everyDayBottonContoroll	(	controllDay.getMAX_DD_STOCK_ETF(s) 			,
														controllDay.getAJUSTMAXDAY_STOCK_ETF(s)		,
														ReCord.CODE_01_STOCK						,
														s											);

		s.resetConnection();
		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		indexResult = CB.everyDayBottonContoroll	(	controllDay.getMAX_DD_INDEX(s) 	 			,
														controllDay.getAJUSTMAXDAY_INDEX(s)			,
														ReCord.CODE_03_INDEX						,
														s											);



		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		s.resetConnection();

		//一つでも異常があれば停止する。
		if ( stockResult == ReturnCodeConst.EVERY_UPDATE_ERR){
			s.closeConection();
			return ReturnCodeConst.EVERY_UPDATE_ERR;
		}

		if ( statisticsResult == ReturnCodeConst.EVERY_UPDATE_ERR){
			s.closeConection();
			return ReturnCodeConst.EVERY_UPDATE_ERR;
		}

		if ( indexResult == ReturnCodeConst.EVERY_UPDATE_ERR){
			s.closeConection();
			return ReturnCodeConst.EVERY_UPDATE_ERR;
		}

		//３つとも更新なしなら更新なし
		if ( indexResult == stockResult && stockResult == statisticsResult && statisticsResult == ReturnCodeConst.EVERY_UPDATE_NOTHING ){
			s.closeConection();
			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
		}

//		//一部分しか更新がなかった
//		if ( indexResult == stockResult && stockResult == statisticsResult && statisticsResult == ReturnCodeConst.EVERY_UPDATE_NOTHING ){
//			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
//		}

		//各テーブルのMAXMINなど、一レコード内で完結するデータを挿入する。
		OneRecord_Update.OneRecord(s);

		s.closeConection();

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;
	}



	//今日の注文をログファイルとして出力
	private int outPutKeepTable(double oneShotMoney,String folderPath){
		String SQL = "";
		S s = new S();
		s.getCon();



		copyOutPutTBL(oneShotMoney,s);

		s.resetConnection();
		int resultInt = 0;


		String fileNameL;
		String fileNameS;
		String filePath;
		String column 	= COLUMN.CODE			 	+ " , " //
						+ COLUMN.DAYTIME			+ " , " //
						+ COLUMN.TYPE				+ " , " //
						+ COLUMN.ENTRYMETHOD		+ " , " //
						+ COLUMN.EXITMETHOD			+ " , "
						+ COLUMN.MINI_CHECK_FLG		+ " , "
						+ COLUMN.REAL_ENTRY_VOLUME	+ " , "
						+ COLUMN.ENTRY_MONEY;

		String heddaColumn = "'" +  COLUMN.CODE		 			+ "' , " //
						   + "'" +  COLUMN.DAYTIME				+ "' , " //
						   + "'" +  COLUMN.TYPE					+ "' , " //
						   + "'" +  COLUMN.ENTRYMETHOD			+ "' , " //
						   + "'" +  COLUMN.EXITMETHOD			+ "' , "
						   + "'" +  COLUMN.MINI_CHECK_FLG		+ "' , "
						   + "'" +  COLUMN.REAL_ENTRY_VOLUME	+ "' , "
						   + "'" +  COLUMN.ENTRY_MONEY			+ "'" ;




		String today = controllDay.getMAX_DD_INDEX(s);
		fileNameL = today + "_" + "L.csv";
		fileNameS = today + "_" + "S.csv";

		filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileNameL;

		SQL = getOutFileSQL(heddaColumn, column, filePath, "true");
		//戻り値1086の時はファイルが存在する
		s.exportFile(SQL);

		filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileNameS;
		SQL = getOutFileSQL(heddaColumn, column, filePath, "false");

		resultInt = s.exportFile(SQL);
//		System.out.println(SQL);
		s.closeConection();
		return resultInt;
	}

	private void copyOutPutTBL(double oneShotMoney,S s){



		String SQL = "delete from " + TBL_Name.OUT_PUT_LASTORDER;
		s.freeUpdateQuery(SQL);

		SQL = " insert into " + TBL_Name.OUT_PUT_LASTORDER
					+ " select "
					+ COLUMN.CODE										 + " , " //
					+ COLUMN.DAYTIME									 + " , " //
					+ COLUMN.TYPE									 	 + " , " //
					+ COLUMN.CATE_FLG									 + " , " //
					+ COLUMN.SIGN_FLG								 	 + " , " //売買サインフラグ。true買い、false売り
					+ COLUMN.ENTRYMETHOD								 + " , " //
					+ COLUMN.CLOSE										 + " ,  "//今日の終値
					+ COLUMN.EXITMETHOD									 + " ,  " //
					+ COLUMN.VOLUME_UNIT								 + " ,  " //売買単位
					+ COLUMN.MINI_CHECK_FLG								 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
					+ COLUMN.REAL_ENTRY_VOLUME							 + " ,  " //現実的購入枚数
					+ COLUMN.VOLUME_UNIT	+	" as "	+ COLUMN.ENTRY_MONEY + "   " //アウトプットテーブルにコピーするに辺り、設定しないとエラーが出るのでダミーとして入れる。
					+ " from "
					+ TBL_Name.LASTORDER;

		s.freeUpdateQuery(SQL);

		//COLUMN.ENTRY_MONEYがダミーなので正しい値を入れる
//		COLUMN.ENTRY_MONEY

		SQL  = " update "+ TBL_Name.OUT_PUT_LASTORDER
				+ " set "
				+ COLUMN.ENTRY_MONEY + " = " + (oneShotMoney*10000);
		s.freeUpdateQuery(SQL);


		//TBL_Name.OUT_PUT_LASTORDERをCODE列を数字4桁にする。
		SQL  = " update "+ TBL_Name.OUT_PUT_LASTORDER
				+ " set "
				+ COLUMN.CODE + " = " + " left(" + COLUMN.CODE + ",4)";
		s.freeUpdateQuery(SQL);

		String TBL = TBL_Name.OUT_PUT_LASTORDER;
		SQL  = " update "+ TBL
				 + " set "
				 + COLUMN.MINI_CHECK_FLG + " = false "
				 + " where "
				 + COLUMN.VOLUME_UNIT + " = " + COLUMN.REAL_ENTRY_VOLUME;
		s.freeUpdateQuery(SQL);

		//売買単位をいい感じにする。
		editVolumeUnit(s);

	}


	private void editVolumeUnit(S s){



		checkMINI_NORMAL(s);

		//91_outPutlastOrderTBLにある、購入数0株の銘柄を削除する
		String SQL = " delete from " + TBL_Name.OUT_PUT_LASTORDER + " where " + COLUMN.REAL_ENTRY_VOLUME + " = 0 ";
		s.freeUpdateQuery(SQL);
	}

	private void checkMINI_NORMAL(S s){
		String SQL1;
		String SQL2;
		String SQL3;
		String TBL = TBL_Name.OUT_PUT_LASTORDER;
//		update 99_separate_DD set SEPA_FLG = true  where dayTime_kenri_last = '2017-06-27' and code = '8011' and SEPA_FLG is false
		//minicheckFLGがtrueのものに対して売買単位をチェックする。単元株数を超えるものをfalseで新規にインサートする。
		SQL1 = " select * from " + TBL
			+ " where "
			+ COLUMN.VOLUME_UNIT + " < " + COLUMN.REAL_ENTRY_VOLUME
			+ " and "
			+ COLUMN.MINI_CHECK_FLG + " is true ";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL1);

			while ( s.rs.next() ) {
				int volumeUnit = s.rs.getInt(COLUMN.VOLUME_UNIT);
				int entryVolume = s.rs.getInt(COLUMN.REAL_ENTRY_VOLUME);
				int miniVolume = entryVolume % volumeUnit;
				int tangenVolume = entryVolume - miniVolume;
				String code = s.rs.getString	(COLUMN.CODE);
				String dayTYPE = s.rs.getString	(COLUMN.TYPE);
				int cate = s.rs.getInt	(COLUMN.CATE_FLG);
				boolean signFLG = s.rs.getBoolean(COLUMN.SIGN_FLG);
				String entryMETHOD = s.rs.getString	(COLUMN.ENTRYMETHOD);
				String exitMETHOD = s.rs.getString	(COLUMN.EXITMETHOD);
				//単元株用の作成
				SQL2 = " insert into " + TBL
					+ " ( "
					+ COLUMN.CODE										 + " , " //
					+ COLUMN.DAYTIME									 + " , " //
					+ COLUMN.TYPE									 	 + " , " //
					+ COLUMN.CATE_FLG									 + " , " //
					+ COLUMN.SIGN_FLG								 	 + " , " //売買サインフラグ。true買い、false売り
					+ COLUMN.ENTRYMETHOD								 + " , " //
					+ COLUMN.CLOSE										 + " , " //今日の終値
					+ COLUMN.EXITMETHOD								 + " ,  " //
					+ COLUMN.VOLUME_UNIT								 + " ,  " //売買単位
					+ COLUMN.MINI_CHECK_FLG							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
					+ COLUMN.REAL_ENTRY_VOLUME							 + " ,  " //現実的購入枚数
					+ COLUMN.ENTRY_MONEY								 + "   "//一回辺り投資金額
					+ " ) "
					+ "values "
					+ " ( "
					+ "'" + code 			+ "'" + ","
					+ "'" + s.rs.getString	(COLUMN.DAYTIME) 		+ "'" + ","
					+ "'" + dayTYPE 			+ "'" + ","
					+ " " + cate 		+ " " + ","
					+ " " + signFLG 		+ " " + ","
					+ "'" + entryMETHOD	+ "'" + ","
					+ " " + s.rs.getDouble	(COLUMN.CLOSE) 			+ " " + ","
					+ "'" + exitMETHOD 	+ "'" + ","
					+ " " + s.rs.getInt	(COLUMN.VOLUME_UNIT) 	+ " " + ","
					+ " " + "false" 									+ " " + ","
					+ " " + tangenVolume								+ " " + ","
					+ " " + s.rs.getInt	(COLUMN.ENTRY_MONEY) 	+ " " + " "
					+ " ) ";
				s.freeUpdateQuery(SQL2);


				//ミニ株用のレコード作成
//				s.rs.updateInt(COLUMN.REAL_ENTRY_VOLUME,miniVolume);
//				s.rs.updateRow();
				SQL3 = " update " + TBL
					 + " set "
					 + COLUMN.REAL_ENTRY_VOLUME + " = " + miniVolume
					 + " where "
					 + COLUMN.MINI_CHECK_FLG + " is true"
					 + " and "
					 + COLUMN.CODE + " = '" + code + "'"
					 + " and "
					 + COLUMN.ENTRYMETHOD + " = '" + entryMETHOD + "'"
					 + " and "
					 + COLUMN.EXITMETHOD + " = '" + exitMETHOD + "'"
					 + " and "
					 + COLUMN.TYPE + " = '" + dayTYPE + "'";

				s.freeUpdateQuery(SQL3);

				s.rs = s.sqlGetter().executeQuery(SQL1);

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


	private String getOutFileSQL(String heddaColumn,String column,String filePath,String judge){
		String SQL;

		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ column
				+ " FROM " + TBL_Name.OUT_PUT_LASTORDER
				+	" where "
				+	COLUMN.SIGN_FLG  + " is  " + judge + " "
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";
//		System.out.println(SQL);
//		String column = COLUMN.CODE			 	+ " , " //
//				+ COLUMN.TYPE			+ " , " //
//				+ COLUMN.ENTRYMETHOD	+ " , " //
//				+ COLUMN.EXITMETHOD		+ " , "

		return SQL;
	}



	//株と指数の更新日付が同じなら処理しない。
	private boolean checkTodayLog(){
		S s = new S();
		s.getCon();
		String today = controllDay.getMAX_DD_INDEX(s);
		String satisDay = controllDay.getMAX_DD_STATISTICS(s);
		if ( today.equals(controllDay.getMAX_DD_STOCK_ETF(s)) ){
			//一致する場合、ヘッダを出力する。
//			commonAP.writeInLog("売買区分,日付,code,Lmethod,Smethod",logWriting.STOCK_RESULT_LOG_FLG_L);
//			commonAP.writeInLog("売買区分,日付,code,Lmethod,Smethod",logWriting.STOCK_RESULT_LOG_FLG_S);
			//更新日付を更新する。
			s.closeConection();

		}else{
			//一致しないエラーを出す。
			System.out.println("株か指数かどっちかが更新できず。");
			s.closeConection();
			return false;
		};

		if ( today.equals(satisDay)){
			//更新日付を更新する。
			s.closeConection();

		}else{
			//一致しないエラーを出す。
			System.out.println("株か指数かどっちかが更新できず。");
			s.closeConection();
			return false;
		};


		return true;
	}
}
