package botton;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import technique.CheckSign;
import accesarrySQL.OneRecord_Update;
import accesarrySQL.SEPARATE_CHECK;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.logWriting;
import controller.CONTOLLBOTTON;
import controller.GetCodeList;

public class cloringDate {
	public void getDayDate(){
		GetCodeList a = new GetCodeList();
		CONTOLLBOTTON CB = new CONTOLLBOTTON();
		long start = System.currentTimeMillis();

		//日々ファイルの出力先
		String folderPath = "D:" + PROPARTY.SQL_SEPA + "orderList";

		//前日動かしたかどうかのチェック
//		if (checkPreTodayLog(folderPath)==false){
//			return;
//		}

		S s = new S();
		//コードリストテーブルを作る、日々の更新をする。

		s.getCon();
		//統計
		CB.everyDayBottonContoroll	(	controllDay.getMAX_DD_STATISTICS(s) 		,
										controllDay.getAJUSTMAXDAY_STATISTICS (s) 	,
										ReCord.CODE_02_SATISTICS					,
										s											);

		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		s.resetConnection();


		CB.everyDayBottonContoroll	(	controllDay.getMAX_DD_STOCK_ETF(s) 			,
										controllDay.getAJUSTMAXDAY_STOCK_ETF(s)		,
										ReCord.CODE_01_STOCK						,
										s											);

		s.resetConnection();


		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		CB.everyDayBottonContoroll	(	controllDay.getMAX_DD_INDEX(s) 	 			,
										controllDay.getAJUSTMAXDAY_INDEX(s)			,
										ReCord.CODE_03_INDEX						,
										s											);



		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();


		//各テーブルのMAXMINなど、一レコード内で完結するデータを挿入する。
		OneRecord_Update.OneRecord(s);

		s.closeConection();

		if ( checkTodayLog() ==false ){
			//一致しない場合は終了する。
			return;
		}

		//分割チェック。sはこの中で独自に作る。
		SEPARATE_CHECK.checkSEPARATE_controll();


		//今日のサインの点灯をチェックする。
		CheckSign.checkTodaySign();

		//最後に今日の売買ファイルを出力する。

		switch (outPutKeepTable(folderPath)) {
			case 0:
				//成功
				break;
			case 1086:
				//ファイルが既に存在する
				break;
			case 1:
				//指定したディレクトリが存在しない
				System.out.println(folderPath+"が存在しない");
				break;
			default:
				System.out.println("なんかエラー");
				break;
		}

		s.closeConection();
		long stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

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

		filePath = folderPath + PROPARTY.SQL_SEPA + fileNameL;

		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ column
				+ " FROM " + TBL_Name.LASTORDER
				+	" where "
				+	COLUMN.SIGN_FLG  + " is true "
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";

		//戻り値1086の時はファイルが存在する
		s.exportFile(SQL);

		filePath = folderPath + PROPARTY.SQL_SEPA + fileNameS;
		SQL =	" SELECT "
				+ heddaColumn
				+ " union "
				+ " SELECT "
				+ column
				+ " FROM " + TBL_Name.LASTORDER
				+	" where "
				+	COLUMN.SIGN_FLG  + " is false "
				+	" INTO OUTFILE '" + filePath +  "'"
				+	" FIELDS TERMINATED BY ','"
				+	" OPTIONALLY ENCLOSED BY '\"'";

		resultInt = s.exportFile(SQL);

		s.closeConection();
		return resultInt;
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
			if(outPutKeepTable(folderPath)==1086){
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
