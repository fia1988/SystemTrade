package controller;

import proparty.S;
import proparty.TBL_Name;
import sql.createDB;
import sql.createTBL;
import constant.CATE_FLG;

public class Create {
	String SQL;
	
	
	public void createDB_CodeTBL(){

		createTBL a = new createTBL();
		S s = new S();
		s.getCon();

		createDB CDB = new createDB();
		//DBを作るる
//		CDB.CreateDB(s);

		//初期テーブルを作る
		a.createStartTBL(s);

		s.closeConection();


	}

	//テーブルリストTBLから一覧テーブルを作る。証券とETF
	public void createTimeSereisTBL_DD(){
		long start = System.currentTimeMillis();
		createTBL a = new createTBL();
		S s = new S();
		s.getCon();
		TBL_Name.setCodeList_HauhunReplace(s);

		for (int i = 0;i<TBL_Name.getCodeList_HauhunReplace().size();i++){
			//DBをつくるので-を_に変換
			a.dayTable_Stock((TBL_Name.getCodeList_HauhunReplace().get(i)).replace("-",CATE_FLG.replaceLetter),s);
		}

		s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
	}

}
