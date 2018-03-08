package botton;

import hesoGomaEdit.editHesogomaFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

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

import constant.AccesarryParameta;
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
				PROPARTY.CLOALING_TIME = PROPARTY.CLOALING_TIME_CONST;
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



		if ( checkTodayLog(mainDTO) == false ){
			//更新日が一致しない場合は終了する。
			stop = System.currentTimeMillis();
			commonAP.writeInLog("一部分のみが更新されている。" + "。実行にかかった時間は " + (stop - start)/1000 + " 秒です。" ,logWriting.DATEDATE_LOG_FLG);
			return TimerShoriConst.UPDATE_BARABARA;
		}

		if ( checkBasicCode() == false){
			return TimerShoriConst.NO_BASIC_CODE;
		}else{

		}


		//今日のサインの点灯をチェックする。LSファイルの元ネタ作成
		CheckSign.checkTodaySign();

		//最後に今日の売買ファイルを出力する。
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO,true);

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

//		//分割ファイルの作成/取込を行う。
//		CreateSepaComFile sepaComCheck = new CreateSepaComFile();
//		sepaComCheck.checkSepaComFile(mainDTO,LS_TODAY);

		//LSファイルばら撒き、FBS用ファイル(保有銘柄一覧、キックファイル、分割併合ファイル確認用ファイル)のばら撒きとか
		fileCOPY(mainDTO,TODAY,LS_TODAY,folderPath);

		//backUp開始
		backUpLogic(mainDTO,LS_TODAY,checkDay);

		stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

		return TimerShoriConst.SUCCESS;

	}
	//common.getStartDayを使う直前に起動させること。
	private boolean checkBasicCode(){

		if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){

			//候補1を候補２とする。
			commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_02 + "で再トライします。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
			commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_02 + "で再トライします。" ,logWriting.DATEDATE_LOG_FLG);
			ReCord.BASIC_CODE_01 = ReCord.BASIC_CODE_02;

			if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){
				commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_03 + "で再トライします。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
				commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_03 + "で再トライします。" ,logWriting.DATEDATE_LOG_FLG);
				ReCord.BASIC_CODE_01 = ReCord.BASIC_CODE_03;

				if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){
					commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_04 + "で再トライします。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
					commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_04 + "で再トライします。" ,logWriting.DATEDATE_LOG_FLG);
					ReCord.BASIC_CODE_01 = ReCord.BASIC_CODE_04;

					if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){
						commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_05 + "で再トライします。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
						commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_05 + "で再トライします。" ,logWriting.DATEDATE_LOG_FLG);
						ReCord.BASIC_CODE_01 = ReCord.BASIC_CODE_05;

						if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){
							commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_06 + "で再トライします。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
							commonAP.writeInLog(ReCord.BASIC_CODE_01 + "が存在しません。" + ReCord.BASIC_CODE_06 + "で再トライします。" ,logWriting.DATEDATE_LOG_FLG);
							ReCord.BASIC_CODE_01 = ReCord.BASIC_CODE_06;

							if ( commonAP.checkStandardCode(ReCord.BASIC_CODE_01,ReCord.BASIC_TBL) == false){
								commonAP.writeInLog("getDayDate：基準コードが存在しません。処理を停止します。" ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
								commonAP.writeInLog("getDayDate：基準コードが存在しません。処理を停止します。" ,logWriting.DATEDATE_LOG_FLG);
								return false;
							}
						}
					}
				}
			}
			commonAP.writeInLog("基準コードが存在しないものがありました。今回はうまくいっているけれど近日中に、ReCord.BASIC_CODE_01を修正してください。今回利用した基準コード：" + ReCord.BASIC_CODE_01 ,logWriting.CODE_SEPACON_ERR_LOG_FLG);
			commonAP.writeInLog("基準コードが存在しないものがありました。今回はうまくいっているけれど近日中に、ReCord.BASIC_CODE_01を修正してください。今回利用した基準コード：" + ReCord.BASIC_CODE_01 ,logWriting.DATEDATE_LOG_FLG);
		}else{

		}

		return true;
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
					String resultBackOut = BU.backUpOut(mainDTO,TODAY);
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

	//Lファイル
	//2017-06-20_L.csv
	private final String L_FILE = "_L.csv";
	//Sファイル
	//2017-06-20_S.csv
	private final String S_FILE = "_S.csv";
	//今日のセパコンバインレコードの作成
	private final String FBSsepaCombine = "FBSsepaCombine.csv";
	//キックファイル,FBS_KICK_2017-07-31.fbs
	private final String YYYY_MM_DD_FBS_KICK = "_FBS_KICK" + ".fbs";
	//保有銘柄一覧作成
	private final String YYYY_MM_DD_FIAS_KEEP = "_fias_keep.csv";
	//エリートファイルの作成
	private final String YYYY_MM_DD_ORDER_STOCK_LIST = "_order_STOCK_LIST.csv";

	private boolean createFiasFiles(TAB_MainDTO mainDTO,String TODAY,String LS_TODAY){

		//LSファイルばらまき
		//全てのユーザーにばら撒く必要がある。ただし有料ユーザーはタイミングはずらすが全員に配る
		//これだけクリエイトはもう済んでいる。



		String fileName = TODAY + YYYY_MM_DD_FBS_KICK;
		//暗号化ファイル作成（キックファイル）
		createSecureFile(TODAY,mainDTO.getEntryFolderPath(),fileName);


		//保有銘柄一覧作成
		fileName = LS_TODAY + YYYY_MM_DD_FIAS_KEEP;
		createKeepListFile(mainDTO.getEntryFolderPath(),fileName);

		//エリートファイルの作成
		fileName = LS_TODAY + YYYY_MM_DD_ORDER_STOCK_LIST;
		createOrderListFile(mainDTO.getEntryFolderPath(),fileName);


		//今日のセパコンバインレコードの作成
		//作った後にフォルダから消す処理が必要
		//作成に成功したらtrue
		//作成しない場合はfalse
		fileName = FBSsepaCombine;
		return createTODAYSepaComBine(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);


	}

	//true：我々
	//false:客
	private void distributeFile_SUPER_USER(TAB_MainDTO mainDTO,String TODAY,String LS_TODAY,boolean judge,boolean FBSsepaCombineJudge){

		//今日のセパコンバインレコードのばら撒き
		//作った後にフォルダから消す処理が必要
		String fileName = FBSsepaCombine;
		if (FBSsepaCombineJudge){
			distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);
		}


		//暗号化ファイル（キックファイル）のばら撒き
        fileName = TODAY + YYYY_MM_DD_FBS_KICK;
        distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);

		//保有銘柄一覧のばら撒き
		fileName = LS_TODAY + YYYY_MM_DD_FIAS_KEEP;
		distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);

		//エリートファイルのばら撒き
		fileName = LS_TODAY + YYYY_MM_DD_ORDER_STOCK_LIST;
		distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);

		//LSファイルばらまき
		//Lファイルのばら撒き
		if (judge){
			fileName = LS_TODAY + L_FILE;
			distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);
			//Sファイルのばら撒き
			fileName = LS_TODAY + S_FILE;
			distributeFile(TODAY,mainDTO.getEntryFolderPath(),fileName,judge);
		}else{
			fileName = LS_TODAY + L_FILE;
			commonAP.writeInLog(fileName + "を管理者以外の各フォルダにばらまきます。",logWriting.DATEDATE_LOG_FLG);
			copyL_S_File_for_PAY_USER(TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
			commonAP.writeInLog(fileName + "を管理者以外の各フォルダにばらまきました。",logWriting.DATEDATE_LOG_FLG);
			fileName = LS_TODAY + S_FILE;
			commonAP.writeInLog(fileName + "を管理者以外の各フォルダにばらまきます。",logWriting.DATEDATE_LOG_FLG);
			copyL_S_File_for_PAY_USER(TODAY,mainDTO.getEntryFolderPath(),fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
			commonAP.writeInLog(fileName + "を管理者以外の各フォルダにばらまきました。",logWriting.DATEDATE_LOG_FLG);
//			ArrayList<String> array = new ArrayList<String>();
//
//		    array.add("東京");
//		    int last = array.lastIndexOf("東京");
//		    if (last != -1){
//		      System.out.println("最後のインデックス番号は " + last);
//		    }
//			select kick_file_user from 88_kickfileuserfolderlisttbl union select kick_file_user from 87_kickfilepayinguserfolderlisttbl
		}

	}


	//true：我々
	//false:客
	private void distributeFile(String TODAY,String folderPath,String fileName,boolean checkFLG){
		commonAP.writeInLog(fileName + "を各フォルダにばらまきます。",logWriting.DATEDATE_LOG_FLG);
		if (checkFLG) {
			//true
			//ばら撒き、ただし無料ユーザーのみ
			copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
		}else{
			//false
			//有料ユーザーユーザー分のばら撒き
			copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL);
		}
		commonAP.writeInLog(fileName + "を各フォルダにばらまきました。",logWriting.DATEDATE_LOG_FLG);
	}
	//LSファイルばら撒き、FBS用ファイルのばら撒きとか
	private void fileCOPY(TAB_MainDTO mainDTO,String TODAY,String LS_TODAY,String folderPath){

		//ファイルを作る
		boolean resultSepaCombineCreateFile = createFiasFiles(mainDTO,TODAY,LS_TODAY);

		//特権階級
		commonAP.writeInLog("管理者にファイルをばらまきます",logWriting.DATEDATE_LOG_FLG);
		distributeFile_SUPER_USER(mainDTO,TODAY,LS_TODAY,true,resultSepaCombineCreateFile);
		commonAP.writeInLog("管理者のファイルをばらまきおえました",logWriting.DATEDATE_LOG_FLG);

		//無料会員は管理者よりあとに動かす
		int sleepTime = PROPARTY.CLOALING_TIME * 2;
		commonAP.writeInLog(sleepTime + "ミリ秒停止します。",logWriting.DATEDATE_LOG_FLG);
		try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
		//時間がばれないように再作成する。
		outPutLSfile(folderPath);
		//タイムスパンを固定値に挿入する。即座に取込モードを行っている場合対策・
		PROPARTY.CLOALING_TIME = PROPARTY.CLOALING_TIME_CONST;

		//有料会員、たっぷり時間をかける
		commonAP.writeInLog("お客様にファイルをばらまきます",logWriting.DATEDATE_LOG_FLG);
		distributeFile_SUPER_USER(mainDTO,TODAY,LS_TODAY,false,resultSepaCombineCreateFile);
		commonAP.writeInLog("お客様のファイルをばらまきおえました",logWriting.DATEDATE_LOG_FLG);
		//あとで削除する必要のあるファイルは削除する。
		if (resultSepaCombineCreateFile){
			String fileName = FBSsepaCombine;
			String filePath = mainDTO.getEntryFolderPath() + ReturnCodeConst.SQL_SEPA + fileName;
			filePath = filePath.replace(File.separator,ReturnCodeConst.SQL_SEPA);
			//作ったファイルの削除
	        File file = new File(filePath);
	        if(file.delete()){
	        	//成功
	        	commonAP.writeInLog(file + "の削除に成功しました。",logWriting.DATEDATE_LOG_FLG);
	        }else{
	        	//失敗
	        	commonAP.writeInLog(file + "の削除に失敗しました。",logWriting.DATEDATE_LOG_FLG);
	        }
		}
		//有料ユーザー後処理
		afterDealPayingUser(LS_TODAY);


//		//LSファイルばら撒き
//		copyParsonalFolder(LS_TODAY,mainDTO.getEntryFolderPath(),true);
//		copyParsonalFolder(LS_TODAY,mainDTO.getEntryFolderPath(),false);
//
//		//今日のセパコンバインレコードの作成
//		String fileName = "FBSsepaCombine.csv";
//		createTODAYSepaComBine(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//
//		//FBS_KICK_2017-07-31.fbs
////        fileName = "FBS_KICK_" + TODAY + ".fbs";
//        fileName = TODAY + "_FBS_KICK" + ".fbs";
//		//暗号化ファイル作成（キックファイル）
//		createSecureFile(TODAY,mainDTO.getEntryFolderPath(),fileName);
//		//ばら撒き
//		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//
//		//保有銘柄一覧作成
//		fileName = LS_TODAY + "_fias_keep.csv";
//		createKeepListFile(mainDTO.getEntryFolderPath(),fileName);
//		//ばら撒き
//		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//
//		//エリートファイルの作成
//		fileName = LS_TODAY + "_order_STOCK_LIST.csv";
//		createOrderListFile(mainDTO.getEntryFolderPath(),fileName);
//		//ばら撒き
//		copyFile_for_KICK_USER(LS_TODAY,mainDTO.getEntryFolderPath(),fileName);
//
//		//有料ユーザー後処理
//		afterDealPayingUser(LS_TODAY);
	}

	public boolean createTODAYSepaComBine(String TODAY,String folderPath,String fileName){
		S s = new S();
		s.getCon();
		boolean resultBoolean = false;
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

				resultBoolean = true;

//				//セパコンバインレコードばら撒き
//				copyFile_for_KICK_USER(TODAY,folderPath,fileName);
//
//				//作ったファイルの削除
//		        File file = new File(filePath);
//
//		        if(file.delete()){
//		        	//成功
//		        	commonAP.writeInLog(file + "の削除に成功しました。",logWriting.DATEDATE_LOG_FLG);
//		        }else{
//		        	//失敗
//		        	commonAP.writeInLog(file + "の削除に失敗しました。",logWriting.DATEDATE_LOG_FLG);
//		        }
			};

		} catch (SQLException e) {}

		s.closeConection();

		return resultBoolean;
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

	//エリートリスト作成
	public void createOrderListFile(String folderPath,String fileName){

		S s = new S();
		s.getCon();

		String SQL;
		String filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileName;
		String TBL = TBL_Name.ELETE_LIST_TBL;

		filePath = filePath.replace(File.separator,ReturnCodeConst.SQL_SEPA);

		String column =  COLUMN.ENTRYMETHOD							 + " , " //
						+ COLUMN.EXITMETHOD							 + " ,  " //
						+ COLUMN.TYPE								 + " , " //
						+ COLUMN.CODE								 + "   "; //


		String heddaColumn =   "'" + COLUMN.ENTRYMETHOD				 + "' , " //
							+  "'" + COLUMN.EXITMETHOD				 + "' , " //
							+  "'" + COLUMN.TYPE					 + "' , " //
							+  "'" + COLUMN.CODE					 + "'  ";  //

		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ " " + column + " "
				+ " FROM " + TBL
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";

		s.exportFile(SQL);

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
		commonAP.writeInLog(fileName + "を各フォルダにばらまきます。",logWriting.DATEDATE_LOG_FLG);
		copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_USER_LIST_TBL);
		//有料ユーザーユーザー分のばら撒き
		copyFile_for_KICK_USER(TODAY,folderPath,fileName,TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL);
		commonAP.writeInLog(fileName + "を各フォルダにばらまきました。",logWriting.DATEDATE_LOG_FLG);
	}


	private void copyL_S_File_for_PAY_USER(String TODAY,String folderPath,String fileName,String TBL){
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

        	switch (parsonalFolderName) {
				case "00000.commonBoard_typeA":
					break;
				case "10000.commonBoard_typeB":
					break;
				case "old":
					break;
				default:
		        	if(kickFileUserList.indexOf(parsonalFolderName) == -1){
		        		//自動売買ツールを使う場合はこれ
						Path targetPath = Paths.get(folderPath + File.separator + personalFolderPath + File.separator + fileName);
						copyFile(copyMoto,targetPath,(folderPath + File.separator + personalFolderPath));
		        	};

					break;
			}


        }
	}

	//暗号化ファイルばら撒きメソッド、キックファイルユーザーリストから抽出する。
	//なんやかんやでTODAYは必要ない引数となった
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
		commonAP.writeInLog(fileName + "を各フォルダにばらまきます。",logWriting.DATEDATE_LOG_FLG);
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

		commonAP.writeInLog(fileName + "を各フォルダにばらまきました。",logWriting.DATEDATE_LOG_FLG);

	}

	//時系列データの更新
	private int zikeiretuDataUpdate(TAB_MainDTO mainDTO){


		if ( mainDTO.isCloringSokuzaCheck() == false ){
			PROPARTY.CLOALING_TIME = PROPARTY.CLOALING_TIME_CONST;
			//16時以前のお軌道は却下する。
			Calendar now = Calendar.getInstance(); //インスタンス化

			int h = now.get(now.HOUR_OF_DAY);//時を取得
			int m = now.get(now.MINUTE);     //分を取得
			int second = now.get(now.SECOND);      //秒を取得

			int baseHour = 17;
			int baseMinitu = 20;

			if ( h < baseHour ){
//				System.out.println(h+"時"+m+"分"+second+"秒");
				return ReturnCodeConst.EVERY_UPDATE_NOTHING;
			}else{
				if ( h == baseHour ){
					if ( m < baseMinitu ){
						int sleepTime = 1000 * 60 * ( baseMinitu - m );
						commonAP.writeInLog("zikeiretuDataUpdate：今の時間は：" + h + "時" + m + "分" + second + "秒" + "です。" + (sleepTime / (1000*60)) + "分間停止します。",logWriting.DATEDATE_LOG_FLG);
						try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
						commonAP.writeInLog("zikeiretuDataUpdate：動き始めます。",logWriting.DATEDATE_LOG_FLG);
					}
				}
			}
		}else{
			commonAP.writeInLog("即座モードで動かします。ただし一回だけ。ばらまきも即座にやる。",logWriting.DATEDATE_LOG_FLG);
			PROPARTY.CLOALING_TIME = 1;
		}



		S s = new S();
		s.getCon();

		if (mainDTO.isHesogomaFile()){
			//へそのごま使う
			editHesogomaFile editHeso = new editHesogomaFile();

			commonAP.writeInLog("チェック開始！",logWriting.DATEDATE_LOG_FLG);

			String TODAY = controllDay.getTODAY();

			//株の更新ができたらリストの更新をやる
			String lastUpdateDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
			int stockCloalingResult = editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_01_STOCK		,lastUpdateDay,lastUpdateDay	, TODAY , s);

			//一つでも異常があれば停止する。
			if ( stockCloalingResult == ReturnCodeConst.EVERY_UPDATE_ERR){
				commonAP.writeInLog("へそごまの株で何かエラー",logWriting.DATEDATE_LOG_FLG);
				s.closeConection();
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}

			if (stockCloalingResult == ReturnCodeConst.EVERY_UPDATE_SUCSESS){
				lastUpdateDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_LIST, s);
				editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_00_CODE_LIST	,lastUpdateDay,lastUpdateDay, TODAY , s);
			}

			int stockInvestResult = editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_02_INVEST		,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_INVEST_CHECK_POINT, s)	,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_INVEST, s)			, TODAY , s);



			//一つでも異常があれば停止する。
			if ( stockInvestResult == ReturnCodeConst.EVERY_UPDATE_ERR){
				s.closeConection();
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}


			//2つとも更新なしなら更新なし
			if ( stockInvestResult == stockCloalingResult && stockCloalingResult == ReturnCodeConst.EVERY_UPDATE_NOTHING ){
				s.closeConection();
				return ReturnCodeConst.EVERY_UPDATE_NOTHING;
			}

			commonAP.writeInLog("株と投資情報の更新成功したので他のもチェックしま！",logWriting.DATEDATE_LOG_FLG);

			editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_06_REIT	,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_TOSHO_REIT, s)	,controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_TOSHO_REIT, s)	, TODAY , s);
			editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_07_ETF	,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_TOSHO_ETF, s)	,controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_TOSHO_ETF, s)	, TODAY , s);


			editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_03_FINANCE	,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_FINANCIAL_CHECK_POINT, s)	,controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_FINANCIAL, s)	, TODAY , s);
			editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_04_RATIO		,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_FORRIGN_RATIO_CHECK_POINT	, s),controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_FORRIGN_RATIO	, s), TODAY , s);
			editHeso.editHesoGomaString(mainDTO, ReCord.CODE_HESO_05_CREDIT		,	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_CREDIT_CHECK_POINT, s),	controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_CREDIT, s)			, TODAY , s);



			//各テーブルのMAXMINなど、一レコード内で完結するデータを挿入する。
			OneRecord_Update.OneRecord(s);

		}else{
			//使わない
			CONTOLLBOTTON CB = new CONTOLLBOTTON();


			int stockResult;
			int statisticsResult;
			int indexResult;

			//コードリストテーブルを作る、日々の更新をする。
			//統計
			statisticsResult = CB.everyDayBottonContoroll(	mainDTO										,
															controllDay.getMAX_DD_STATISTICS(s) 		,
															controllDay.getAJUSTMAXDAY_STATISTICS (s) 	,
															ReCord.CODE_02_SATISTICS					,
															s											);


			s.resetConnection();
			//CBのなかを破棄する。メモリ解放
			CB = new CONTOLLBOTTON();
			indexResult = CB.everyDayBottonContoroll	(	mainDTO										,
															controllDay.getMAX_DD_INDEX(s) 	 			,
															controllDay.getAJUSTMAXDAY_INDEX(s)			,
															ReCord.CODE_03_INDEX						,
															s											);

			//CBのなかを破棄する。メモリ解放
			CB = new CONTOLLBOTTON();
			s.resetConnection();

			stockResult = CB.everyDayBottonContoroll	(	mainDTO										,
															controllDay.getMAX_DD_STOCK_ETF(s) 			,
															controllDay.getAJUSTMAXDAY_STOCK_ETF(s)		,
															ReCord.CODE_01_STOCK						,
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



			//各テーブルのMAXMINなど、一レコード内で完結するデータを挿入する。
			OneRecord_Update.OneRecord(s);


		}

		s.closeConection();

		//マーケットテーブル作成
		insertMarketTBL();
		//株主資本コストの計算
		calculateCAPM();
		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;
	}

	private void insertMarketTBL(){
		S s = new S();
		s.getCon();
		String TODAY = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
		String lastUpdateDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_MARKET_TBL, s);
		String column = COLUMN.CODE									 + " , " //銘柄名
				+ COLUMN.DAYTIME								 + " , " //日付
				+ COLUMN.OPEN									 + " , " //始値
				+ COLUMN.MAX									 + " , " //最高値
				+ COLUMN.MIN									 + " , " //最安値
				+ COLUMN.CLOSE									 + " , " //終値
				+ COLUMN.DEKI									 + " , " //出来高
				+ COLUMN.BAYBAY								 + " , " //売買代金
				//+ COLUMN.STOCK_NUM								 + " , " //発行済み株式数
				//+ COLUMN.MARKET_CAP							 + " , " //時価総額
				//+ COLUMN.M_AND_A_FLG							 + " , " //合併フラグ
//				+ COLUMN.LONG_FLG								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE							 + " , " //前日比
				+ COLUMN.CHANGERATE							 + " , " //前日比率
				+ COLUMN.SHORTIDO								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.SHORTIDO_RATIO						 + " , " //株価短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_RATIO						 + " , " //株価中期間移動平均線前日比率
				+ COLUMN.LONGIDO_RATIO							 + " , " //株価長期間移動平均線前日比率
				+ COLUMN.MAXMIN								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO							 + " , " //（1-最安値)/最高値
				+ COLUMN.CANDLE_AREA							 + " , " //ローソク足の面積
				+ COLUMN.CANDLE_AREA_SCALE						 + " , " //ひげの長さと比較したローソク足面積の比率
				+ COLUMN.WINDOW								 + " , " //前日の終値-今日の始値
				+ COLUMN.DEKI_CHANGERATE						 + " , " //出来高前日比
				+ COLUMN.DEKI_RATIO							 + " , " //出来高前日比率
				+ COLUMN.BAYBAY_CHANGERATE						 + " , " //売買代金前日比
				+ COLUMN.BAYBAY_RATIO							 + " , " //売買代金前日比率
				+ COLUMN.SHORTIDO_DEKI							 + " , " //出来高短期移動平均線
				+ COLUMN.MIDDLEIDO_DEKI						 + " , " //出来高中期移動平均線
				+ COLUMN.LONGIDO_DEKI							 + " , " //出来高長期移動平均線
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE				 + " , " //出来高短期移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE				 + " , " //出来高中期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE				 + " , " //出来高長期移動平均線前日比
				+ COLUMN.SHORTIDO_DEKI_RATIO					 + " , " //出来高短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_DEKI_RATIO					 + " , " //出来高中期移動平均線前日比率
				+ COLUMN.LONGIDO_DEKI_RATIO					 + " , " //出来高長期移動平均線前日比率
				+ COLUMN.SHORTIDO_BAYBAY						 + " , " //売買代金短期移動平均線
				+ COLUMN.MIDDLEIDO_BAYBAY						 + " , " //売買代金中期移動平均線
				+ COLUMN.LONGIDO_BAYBAY						 + " , " //売買代金長期移動平均線
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE			 + " , " //売買代金短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE			 + " , " //売買代金中期間移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE				 + " , " //売買代金長期移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_RATIO					 + " , " //売買代金短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_BAYBAY_RATIO				 + " , " //売買代金中期間移動平均線前日比率
				+ COLUMN.LONGIDO_BAYBAY_RATIO					 + " , " //売買代金長期移動平均線前日比率
				+ COLUMN.CREDIT_LONG							 + " , " //信用買い残
				+ COLUMN.CREDIT_SHORT							 + " , " //信用売り残
				+ COLUMN.CREDIT_RATIO							 + " , " //信用倍率＝信用買い残÷信用売り残
				+ COLUMN.CREDIT_LONG_CHANGERATE				 + " , " //信用買い残前日比
				+ COLUMN.CREDIT_SHORT_CHANGERATE				 + " , " //信用売り残前日比
				+ COLUMN.CREDIT_RATIO_CHANGERATE				 + " , " //信用倍率前日比
				+ COLUMN.SHORT_DEV								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA						 + " , " //短期間内で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.SHORT_1_H_SIGMA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA						 + " , " //中期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.MIDDLE_1_H_SIGMA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA						 + " , " //長期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.LONG_1_H_SIGMA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORTIDO_HEKATU						 + " , " //指数平滑移動平均短期
				+ COLUMN.MIDDLEIDO_HEKATU						 + " , " //指数平滑移動平均中期
				+ COLUMN.LONGIDO_HEKATU				 	 	 + " , " //指数平滑移動平均長期
				+ COLUMN.SHORTIDO_HEKATU_CHANGERATE			 + " , " //指数平滑移動平均短期前日比
				+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE			 + " , " //指数平滑移動平均中期前日比
				+ COLUMN.LONGIDO_HEKATU_CHANGERATE		 	 	 + " , " //指数平滑移動平均長期前日比
				+ COLUMN.SHORTIDO_HEKATU_RATIO					 + " , " //指数平滑移動平均短期前日比率
				+ COLUMN.MIDDLEIDO_HEKATU_RATIO				 + " , " //指数平滑移動平均中期前日比率
				+ COLUMN.LONGIDO_HEKATU_RATIO		 	 		 + " , " //指数平滑移動平均長期前日比率
				+ COLUMN.SHORT_MACD							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL						 + "  "; //長期MACDシグナル線;

		String SQL = " insert into " + TBL_Name.MARKET_DD_TBL
					+ " ( " + column + " ) "
					+ " select "
					+ column
					+ " from "
					+ TBL_Name.ETF_DD
					+ " where " + COLUMN.CODE + " = " + "'" + ReCord.MARKET_CODE_1306 + "'"
					+ " and "
					+ COLUMN.DAYTIME + " >  '" + lastUpdateDay + "'";

//		deleteRecord = s.sqlGetter().executeUpdate(SQL);
//		インサート
		try {
			int addRecord = s.sqlGetter().executeUpdate(SQL);
//			System.out.println("calculateCAPM():" + SQL);
		} catch (SQLException e) {
			commonAP.writeInLog("insertMarketTBL：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		controllDay.update_KOSHINBI(TODAY,ReCord.KOSHINBI_MARKET_TBL, s);
		commonAP.writeInLog(ReCord.KOSHINBI_MARKET_TBL + ":" + TODAY,logWriting.DATEDATE_LOG_FLG);
		s.closeConection();

	}

	private void calculateCAPM(){
		commonAP.writeInLog("【calculateCAPM()：CAPMの計算開始】",logWriting.DATEDATE_LOG_FLG);
		if ( checkBasicCode() == false){
			commonAP.writeInLog("calculateCAPM()：基準日がありません。",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("calculateCAPM()：基準日がありません。",logWriting.CODE_SEPACON_ERR_LOG_FLG);
			return;
		}
		S s = new S();
		s.getCon();
		//今日の日付
		String TODAY = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
		//今日の日付からX日前。
		//例：2018-05-05が今日なら2018-05-03が２日前
		//上記ケースは引数が３のとき
		//とりあえず245を引数にする＝244日前
		String beforeDay = commonAP.getStartDay(TODAY, AccesarryParameta.MARKET_OBSERVATION_TERM, s);


		calculateCAPM_MARLET_TBL	(TODAY,beforeDay,AccesarryParameta.MARKET_OBSERVATION_TERM);
		calculateCAPM_STOCK_TBL		(TODAY,beforeDay,AccesarryParameta.MARKET_OBSERVATION_TERM);
		s.closeConection();
		commonAP.writeInLog("【calculateCAPM()：CAPMの計算終了】",logWriting.DATEDATE_LOG_FLG);
	}

	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL(String TBL,String TODAY,String beforeDay,String updateColumn,String calculateColumn,String calculateLetter,boolean marketFLG){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN = "dummyCOLUMN";

		SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
				+ " ( "
				+ " select "
				+ COLUMN.CODE + " , "
				+ " " + calculateLetter +  "(" + calculateColumn + ") as " + dummyCOLUMN + "  "
				+ " from " + TBL
				+ " where "
				+ COLUMN.DAYTIME + " <= " + "'" + TODAY + "'"
				+ " and "
				+ COLUMN.DAYTIME + " >= " + "'" + beforeDay + "'"
				+ " group by "+ COLUMN.CODE
				+ " )  " + selectLetter
		+ " set "
				+ updateLetter + "." + updateColumn	 + " = " + selectLetter + "." + dummyCOLUMN + "   "
		+ " where "
				+ updateLetter + "." + COLUMN.CODE + " = "+ selectLetter + "." + COLUMN.CODE
				+ " and "
				+ updateLetter + "." + COLUMN.DAYTIME + " = " + "'" +  TODAY + "'";

		if (marketFLG){
//			SQL = SQL+ " and "
//					+ updateLetter + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		}
		return SQL;
	}

	private void calculateCAPM_MARLET_TBL(String TODAY,String beforeDay, int term){
		String TBL = TBL_Name.MARKET_DD_TBL;
		S s = new S();
		s.getCon();

		String SQL="";


		//標準偏差の計算、リターンの計算
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",true);
		commonAP.writeInLog(TBL + "リターンの計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN.MARKET_RETURN_FOR_BETA,TODAY,s);

		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",true);
		commonAP.writeInLog(TBL + "の標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN.MARKET_RISK_FOR_BETA,TODAY,s);

//		+ COLUMN.MARKET_RISK_PREMIUM_KATA					 + " , "
//		//分散、リスクフリーレート計算
		//リスクフリーレートは0.8%とする。
		SQL = " update " + TBL
			+ " set "
			+ COLUMN.MARKET_RISK_Squaring_FOR_BETA + " = " + COLUMN.MARKET_RISK_FOR_BETA + " * " + COLUMN.MARKET_RISK_FOR_BETA + " , "
			+ COLUMN.RISK_FREE_RATE + " = " + AccesarryParameta.RISK_FREE_RATE
			+ " where "
			+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'"
			+ " and "
			+ COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog(TBL + "の分散、リスクフリーレート計算(" + AccesarryParameta.RISK_FREE_RATE + ")：" + SQL,logWriting.DATEDATE_LOG_FLG);

		s.freeUpdateQuery(SQL);
		//マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）
		SQL = " update " + TBL
				+ " set "
				+ COLUMN.MARKET_RISK_PREMIUM + " = " + COLUMN.MARKET_RETURN_FOR_BETA + " - " + COLUMN.RISK_FREE_RATE + "  "
				+ " where "
				+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'"
				+ " and "
				+ COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog(TBL + "マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		//標準偏差平均、リターンの平均、マーケットリスクプレミアムの平均
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA_AVE,COLUMN.MARKET_RETURN_FOR_BETA,"avg",true);
		commonAP.writeInLog(TBL + "リターンの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_FOR_BETA_AVE,COLUMN.MARKET_RISK_FOR_BETA,"avg",true);
		commonAP.writeInLog(TBL + "標準偏差平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_PREMIUM_AVE,COLUMN.MARKET_RISK_PREMIUM,"avg",true);
		commonAP.writeInLog(TBL + "マーケットリスクプレミアムの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		

		s.closeConection();
	}

	
	//0.008⇒0.8％にする。
	//100倍にする。
	private void persentUpdate(String TBL,String column,String dayTime, S s){
		String SQL="";

		SQL = " update " + TBL
				+ " set "
				+ column + " = " + column + " * 100 "
				+ " where "
				+ COLUMN.DAYTIME + " = '" + dayTime + "'";

		s.freeUpdateQuery(SQL);
	}

	//個別銘柄リターンとTOPIXリターンの相関係数を求める
	private void calculateCAPM_STOCK_TBL_createTMP_TBL(String TODAY,String beforeDay,S s){
		//参考
		//http://txqz.net/memo/2005-0619-2152.html
		String avg = TBL_Name.TMP_01_AVE;
		String sd  = TBL_Name.TMP_02_SD;
		String marketstock  = TBL_Name.TMP_03_marketstock;
		String DAYTIME = "dayterm";
		String stockTBL = TBL_Name.STOCK_DD;
		String marketTBL = TBL_Name.MARKET_DD_TBL;
		String stockTBL_RETURN = COLUMN.RETURN_FOR_BETA_AVE;
		String marketTBL_RETURN = COLUMN.MARKET_RETURN_FOR_BETA_AVE;



		String stockTBL_COLUMN = "A_COLUMN";
		String stockTBL_marketstock_COLUMN = "A_marketstock_COLUMN";
		String stockTBL_avg_COLUMN = "A_avg_COLUMN";

		String marketTBL_COLUMN = "B_COLUMN";
		String marketTBL_marketstock_COLUMN = "B_marketstock_COLUMN";
		String marketTBL_avg_COLUMN = "B_avg_COLUMN";

		String stockTBL_sd_COLUMN = "stockTBL_sd_COLUMN";
		String marketTBL_sd_COLUMN = "marketTBL_marketstock_COLUMN";


		String SQL = "";
		SQL = " CREATE TEMPORARY TABLE " + marketstock
				+ " select "
					+ TBL_Name.STOCK_DD + "." + stockTBL_RETURN + " as " + stockTBL_marketstock_COLUMN + " , "
					+ TBL_Name.MARKET_DD_TBL + "." + marketTBL_RETURN + " as " + marketTBL_marketstock_COLUMN + " , "
					+ TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " as " + DAYTIME + "  "
					+ " from "
					+ TBL_Name.MARKET_DD_TBL
					+ " left outer join " +  TBL_Name.STOCK_DD + " "
					+	" on " +  TBL_Name.STOCK_DD + "." + COLUMN.DAYTIME + " = " + TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " "
					+ " where "
					+ TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " <= '" + TODAY + "'"
					+ " and "
					+ TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " >= " + "'" + beforeDay + "'"
					+ " and "
					+ TBL_Name.MARKET_DD_TBL + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog("一時保管テーブル作成「" + marketstock + "」：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		SQL = " CREATE TEMPORARY TABLE " + avg
				+ " select "
					+ TBL_Name.STOCK_DD + "." + stockTBL_RETURN + " as " + stockTBL_avg_COLUMN + " , "
					+ TBL_Name.MARKET_DD_TBL + "." + marketTBL_RETURN + " as " + marketTBL_avg_COLUMN + "  "
					+ " from "
					+ TBL_Name.MARKET_DD_TBL
					+ " left outer join " + TBL_Name.STOCK_DD
					+	" on " +  TBL_Name.STOCK_DD + "." + COLUMN.DAYTIME + " = " + TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " "
					+ " where "
					+  TBL_Name.MARKET_DD_TBL + "." + COLUMN.DAYTIME + " = '" + TODAY + "'"
					+ " and "
					+ TBL_Name.MARKET_DD_TBL + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";;
		commonAP.writeInLog("一時保管テーブル作成「" + avg + "」：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);



//		CREATE TEMPORARY TABLE sd SELECT POW(x - xavg, 2) AS xsd, POW(y - yavg, 2) AS ysd, (x - xavg) * (y - yavg) AS covariance FROM correl CROSS JOIN avg;
		SQL = " CREATE TEMPORARY TABLE " + sd
				+ " select "
					+ " pow(" + stockTBL_marketstock_COLUMN + " - " + stockTBL_avg_COLUMN + ",2) as " + stockTBL_sd_COLUMN + " , "
					+ " pow(" + marketTBL_marketstock_COLUMN + " - " + marketTBL_avg_COLUMN + ",2) as " + marketTBL_sd_COLUMN + " , "
					+ " (" + stockTBL_marketstock_COLUMN + " - " + stockTBL_avg_COLUMN + ")"
					+ " * "
					+ " (" + marketTBL_marketstock_COLUMN + " - " + marketTBL_avg_COLUMN + ") as covariance  "
					+ " from "
					+ marketstock
					+ " CROSS JOIN " + avg;
		commonAP.writeInLog("一時保管テーブル作成「" + sd + "」：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//SELECT SUM(covariance) / (POW(SUM(xsd), 0.5) * POW(SUM(ysd), 0.5)) AS correlation FROM sd
		SQL = " select "
					+ " sum(covariance) "
					+ " / "
					+ " ( "
						+ "POW(SUM(" + marketTBL_sd_COLUMN + "),0.5)"
						+ " * "
						+ "POW(SUM(" + stockTBL_sd_COLUMN + "),0.5)"
					+ " ) "
					+ " AS correlation FROM "
				+ sd;
		commonAP.writeInLog("一時保管テーブル表示"+"：" + SQL,logWriting.DATEDATE_LOG_FLG);

	}

	private void calculateCAPM_STOCK_TBL(String TODAY,String beforeDay, int term){
		String TBL = TBL_Name.STOCK_DD;
		String dummyCOLUMN_A = "dummyCOLUMN_A";
		String dummyCOLUMN_B = "dummyCOLUMN_B";
		String dummyCOLUMN_C = "dummyCOLUMN_C";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		S s = new S();
		s.getCon();
		String SQL="";

//		+ COLUMN.DIVIDEND_PER_KATA							 + " , " //配当利回り
//		+ COLUMN.BETA_KATA									 + " , " //(個別銘柄リターンとTOPIXリターンの共分散)/(TOPIXの分散)
//		+ COLUMN.Certainty_FOR_BETA_KATA					 + " , " //ベータの確実度=相関係数=(個別銘柄リターンとTOPIXリターンの共分散)/(個別銘柄標準偏差*TOPIX標準偏差)



//		+ COLUMN.CAPM_KATA							 + " , " //CAPM				//CAPM株主資本コスト（リスクフリーレート+ベータ*マーケットリスクプレミアム）
//		+ COLUMN.WACC_KATA							 + " , " //WACC
//		+ COLUMN.WACC_AVE_KATA							 + " , " //WACC_AVE







		//標準偏差の計算、リターンの計算
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",false);
		commonAP.writeInLog(TBL + "リターンの計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN.RETURN_FOR_BETA,TODAY,s);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",true);
		commonAP.writeInLog(TBL + "の標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN.RISK_FOR_BETA,TODAY,s);

		//分散の計算
		SQL = " update " + TBL
			+ " set "
			+ COLUMN.RISK_Squaring_FOR_BETA + " = " + COLUMN.RISK_FOR_BETA + " * " + COLUMN.RISK_FOR_BETA + "  "
			+ " where "
			+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'";
		commonAP.writeInLog(TBL + "の分散：" + SQL,logWriting.DATEDATE_LOG_FLG);

		//個別銘柄リターンとTOPIXリターンの、共分散相関係数を求める
		calculateCAPM_STOCK_TBL_createTMP_TBL(TODAY,beforeDay,s);

		//標準偏差平均、過去データの基づく理論上リターンの平均、CAPMの平均、ベータの平均
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.RETURN_FOR_BETA_AVE,COLUMN.RETURN_FOR_BETA,"avg",true);
		commonAP.writeInLog(TBL + "リターンの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.RISK_FOR_BETA_AVE,COLUMN.RISK_FOR_BETA,"avg",true);
		commonAP.writeInLog(TBL + "標準偏差平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.CAPM_AVE,COLUMN.CAPM,"avg",true);
		commonAP.writeInLog(TBL + "CAPMの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		SQL = calculateSQL(TBL,TODAY,beforeDay,COLUMN.Certainty_FOR_BETA_AVE,COLUMN.Certainty_FOR_BETA,"avg",true);
		commonAP.writeInLog(TBL + "確実性の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		s.closeConection();
	}

	//今日の注文をログファイルとして出力
	private int outPutKeepTable(double oneShotMoney,String folderPath){

		S s = new S();
		s.getCon();

		copyOutPutTBL(oneShotMoney,s);

		s.closeConection();;

		int resultInt = outPutLSfile(folderPath);

		return resultInt;
	}

	private int outPutLSfile(String folderPath){
		int resultInt = 0;

		S s = new S();
		s.getCon();

		String SQL = "";

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



		String today = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
		fileNameL = today + "_" + "L.csv";
		fileNameS = today + "_" + "S.csv";

		filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileNameL;

		SQL = getOutFileSQL(heddaColumn, column, filePath, "true");
		//戻り値1086の時はファイルが存在する
		String LSfilePath = filePath.replace(ReturnCodeConst.SQL_SEPA, File.separator);
		File file = new File(LSfilePath);
        if(file.delete()){
        	//成功
        	commonAP.writeInLog(file + "が存在するので上書きします。",logWriting.DATEDATE_LOG_FLG);
        };
		s.exportFile(SQL);



		filePath = folderPath + ReturnCodeConst.SQL_SEPA + fileNameS;
		SQL = getOutFileSQL(heddaColumn, column, filePath, "false");
		LSfilePath = filePath.replace(ReturnCodeConst.SQL_SEPA, File.separator);
		file = new File(LSfilePath);
        if(file.delete()){
        	//成功
        	commonAP.writeInLog(file + "が存在するので上書きします。",logWriting.DATEDATE_LOG_FLG);
        };
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
					+ " ( " + COLUMN.CLOSE + " * " + COLUMN.IDEA_VOLUME	+	" ) as "	+ COLUMN.ENTRY_MONEY + "   " //エントリーマネーを出す。
					+ " from "
					+ TBL_Name.LASTORDER;
//		System.out.println(SQL);
		s.freeUpdateQuery(SQL);

		//COLUMN.ENTRY_MONEYがダミーなので正しい値を入れる
//		COLUMN.ENTRY_MONEY

//		SQL  = " update "+ TBL_Name.OUT_PUT_LASTORDER
//				+ " set "
//				+ COLUMN.ENTRY_MONEY + " = " + (oneShotMoney*10000);
//		s.freeUpdateQuery(SQL);


		//TBL_Name.OUT_PUT_LASTORDERをCODE列を数字4桁にする。
		//へそのゴマに移行したら消す
//		SQL  = " update "+ TBL_Name.OUT_PUT_LASTORDER
//				+ " set "
//				+ COLUMN.CODE + " = " + " left(" + COLUMN.CODE + ",4)";
//		s.freeUpdateQuery(SQL);

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
	private boolean checkTodayLog(TAB_MainDTO mainDTO){
		S s = new S();
		s.getCon();

		if (mainDTO.isHesogomaFile()){
			//へそのごま使う
			String stockDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
			String investDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_INVEST, s);

			if ( stockDay.equals(investDay)){
				//更新日付を更新する。
				s.closeConection();

			}else{
				//一致しないエラーを出す。
				System.out.println("株か投資指標かどっちかが更新できず。");
				s.closeConection();
				return false;
			};

			return true;
		}

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
