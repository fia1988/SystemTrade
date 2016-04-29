package botton;

import controller.Create;
import controller.GetCodeList;

public class setUp {
	public void firstSetUp(){
		long start = System.currentTimeMillis();
		GetCodeList GC = new GetCodeList();
		Create aa = new Create();

		aa.createDB_CodeTBL();

//		GC.controllCreateDB_GetList();

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");


	}
}
