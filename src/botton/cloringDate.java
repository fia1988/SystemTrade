package botton;

import proparty.S;
import proparty.controllDay;
import accesarrySQL.OneRecord_Update;
import accesarrySQL.SEPARATE_CHECK;
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
		CB.everyDayBottonContoroll_STATISTICS (controllDay.getMAX_DD_STATISTICS(s) 		 ,
											   controllDay.getAJUSTMAXDAY_STATISTICS (s) ,
//											   "2007-01-15",
											   s											);
		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();
		s.resetConnection();

//		株,ETF
		CB.everyDayBottonContoroll_STOCK_ETF(controllDay.getMAX_DD_STOCK_ETF(s) 	 ,
											controllDay.getAJUSTMAXDAY_STOCK_ETF(s) ,
//											   "2007-01-15",
											   s											);

		s.resetConnection();

		//INDEX
		CB.everyDayBottonContoroll_INDEX(controllDay.getMAX_DD_INDEX(s) 	 ,
										controllDay.getAJUSTMAXDAY_INDEX(s) ,
												s							);

		//CBのなかを破棄する。メモリ解放
		CB = new CONTOLLBOTTON();


		//各テーブルのMAXMINなど、一レコード内で完結するデータを挿入する。
		OneRecord_Update.OneRecord(s);

		s.closeConection();

		//分割チェック。sはこの中で独自に作る。
		SEPARATE_CHECK.checkSEPARATE_controll();



		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start)/1000 + " 秒です。");

	}
}
