package botton;

import proparty.S;
import proparty.controllDay;
import technique.CheckSign;
import accesarrySQL.OneRecord_Update;
import accesarrySQL.SEPARATE_CHECK;

import common.commonAP;

import constant.ReCord;
import constant.logWriting;
import controller.CONTOLLBOTTON;
import controller.GetCodeList;

public class cloringDate {
	public void getDayDate(){
		GetCodeList a = new GetCodeList();
		CONTOLLBOTTON CB = new CONTOLLBOTTON();
		long start = System.currentTimeMillis();


//		if (checkPreTodayLog()==false){
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

		s.closeConection();
		long stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

	}


	//株と指数の更新日付、出力ログをみて実行するか否かを判断する。
	private boolean checkPreTodayLog(){
		S s = new S();
		s.getCon();

		//更新日付が同じであるかをチェック
		//同じであれば、ログが出力されているかを調べる。
		//ログが存在すれば処理しない。falseを返す。
		if ( controllDay.getMAX_DD_INDEX(s).equals(controllDay.getMAX_DD_STOCK_ETF(s)) ){
			//一致して、なおかつファイルが存在する場合はfalse

			s.closeConection();
			return false;
		}

		s.closeConection();
		return true;
	}

	//株と指数の更新日付が同じなら処理しない。
	private boolean checkTodayLog(){
		S s = new S();
		s.getCon();

		if ( controllDay.getMAX_DD_INDEX(s).equals(controllDay.getMAX_DD_STOCK_ETF(s)) ){
			//一致する場合、ヘッダを出力する。
			commonAP.writeInLog("売買区分,日付,code,Lmethod,Smethod",logWriting.STOCK_RESULT_LOG_FLG_L);
			commonAP.writeInLog("売買区分,日付,code,Lmethod,Smethod",logWriting.STOCK_RESULT_LOG_FLG_S);

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
