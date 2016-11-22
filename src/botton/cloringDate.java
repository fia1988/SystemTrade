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

		//分割チェック。sはこの中で独自に作る。
		SEPARATE_CHECK.checkSEPARATE_controll();


		//今日のサインの点灯をチェックする。
		CheckSign.checkTodaySign();

		s.closeConection();
		long stop = System.currentTimeMillis();
		commonAP.writeInLog("実行にかかった時間は " + (stop - start)/1000 + " 秒です。",logWriting.DATEDATE_LOG_FLG);

	}
}
