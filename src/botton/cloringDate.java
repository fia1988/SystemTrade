package botton;

import java.io.File;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import technique.CheckSign;
import GamenDTO.TAB_MainDTO;
import accesarrySQL.OneRecord_Update;
import accesarrySQL.SEPARATE_CHECK;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.TimerShoriConst;
import constant.logWriting;
import controller.CONTOLLBOTTON;

public class cloringDate {
	public String getDayDate(TAB_MainDTO mainDTO){
//		GetCodeList a = new GetCodeList();

		long start = System.currentTimeMillis();

		//日々売買ファイルの出力先

		String folderPath = mainDTO.getEntryFolderPath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		String folderPath = "D:" + ReturnCodeConst.SQL_SEPA + "orderList";
//		String folderPath = "C:" + ReturnCodeConst.SQL_SEPA + "Users" + ReturnCodeConst.SQL_SEPA + "NOBORU1988" + ReturnCodeConst.SQL_SEPA + "Dropbox" + ReturnCodeConst.SQL_SEPA + "everyfolder";
//		String folderPath = "D:" + ReturnCodeConst.SQL_SEPA + "orderList";
		//前日動かしたかどうかのチェック
//		if (checkPreTodayLog(folderPath)==false){
//			return;
//		}

		//時系列データの更新
		switch (zikeiretuDataUpdate()){
			case ReturnCodeConst.EVERY_UPDATE_SUCSESS:
				break;
			case ReturnCodeConst.EVERY_UPDATE_NOTHING:
				commonAP.writeInLog("アップデートなし" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.NO_UPDATE;
//				break;
			case ReturnCodeConst.EVERY_UPDATE_ERR:
				commonAP.writeInLog("なんかエラー1" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.ERR_1;
			default:
				commonAP.writeInLog("なんかエラー2" ,logWriting.DATEDATE_LOG_FLG);
				return TimerShoriConst.ERR_2;
		}



		if ( checkTodayLog() == false ){
			//更新日が一致しない場合は終了する。
			return TimerShoriConst.UPDATE_BARABARA;
		}

		//分割チェック。sはこの中で独自に作る。
		SEPARATE_CHECK.checkSEPARATE_controll();


		//今日のサインの点灯をチェックする。
		CheckSign.checkTodaySign();

		//最後に今日の売買ファイルを出力する。

		switch (outPutKeepTable(folderPath)) {
			case ReturnCodeConst.SQL_ERR_0:
				//成功
				break;
			case ReturnCodeConst.SQL_ERR_1086:
				//ファイルが既に存在する
				break;
			case ReturnCodeConst.SQL_ERR_1:
				//指定したディレクトリが存在しない
				System.out.println(folderPath+"が存在しない");
				break;
			default:
				System.out.println("なんかエラー");
				break;
		}


		long stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

		return TimerShoriConst.SUCCESS;

	}


	//時系列データの更新
	private int zikeiretuDataUpdate(){
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
	private int outPutKeepTable(String folderPath){
		String SQL = "";
		S s = new S();
		s.getCon();
		int resultInt = 0;


		String fileNameL;
		String fileNameS;
		String filePath;
		String column = COLUMN.CODE			 	+ " , " //
						+ COLUMN.DAYTIME		+ " , " //
						+ COLUMN.TYPE			+ " , " //
						+ COLUMN.ENTRYMETHOD	+ " , " //
						+ COLUMN.EXITMETHOD		+ " " ;

		String heddaColumn = "'" +  COLUMN.CODE		 	+ "' , " //
						   + "'" +  COLUMN.DAYTIME		+ "' , " //
						   + "'" +  COLUMN.TYPE			+ "' , " //
						   + "'" +  COLUMN.ENTRYMETHOD	+ "' , " //
						   + "'" +  COLUMN.EXITMETHOD	+ "' " ;;


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

	private String getOutFileSQL(String heddaColumn,String column,String filePath,String judge){
		String SQL;

		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ column
				+ " FROM " + TBL_Name.LASTORDER
				+	" where "
				+	COLUMN.SIGN_FLG  + " is  " + judge + " "
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";

		return SQL;
	}


	//株と指数の更新日付、出力ログをみて実行するか否かを判断する。
	private boolean checkPreTodayLog(String folderPath){
		S s = new S();
		s.getCon();
		String today = controllDay.getMAX_DD_INDEX(s);

		//更新日付が同じであるかをチェック
		//同じであれば、売買ファイルが出力されているかを調べる。
		//売買ファイルが存在すれば処理しない。falseを返す。
		if ( today.equals(controllDay.getMAX_DD_STOCK_ETF(s)) ){
			//一致して、なおかつファイルが存在する場合はfalse



			//戻り値1086の時はファイルが存在する
			if(outPutKeepTable(folderPath)==ReturnCodeConst.SQL_ERR_1086){
				System.out.println("ファイルあり");
				s.closeConection();
				return false;
			}


		}

		s.closeConection();
		return true;
	}

	//株と指数の更新日付が同じなら処理しない。
	private boolean checkTodayLog(){
		S s = new S();
		s.getCon();
		String today = controllDay.getMAX_DD_INDEX(s);

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


		return true;
	}
}
