package botton;

import proparty.S;
import sql.createTBL;
import sql.createView;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;
import controller.Create;
import controller.GetCodeList;

public class setUp {



	public String nyuryokuChecker(TAB_MainDTO mainDTO){

		//タイマーチェック
		//TRUEのときはタイマー起動中なのでオフを返す。
		if(mainDTO.isJudgeTimer()==true){
			return nyuryokuCheckResultConst.ON_TIMER_ERR;
		}
		//MYSQLのアカウントチェック
		S s = new S();
		if ( s.getCon() != ReturnCodeConst.SQL_ERR_0){
			return nyuryokuCheckResultConst.MYSQL_ERR;
		};
		s.closeConection();

		return nyuryokuCheckResultConst.SUCCESS;
	}


	public void createDB(){
		S s = new S();
		s.getCon();

//
//		try {
//			s.sqlGetter().executeUpdate("CREATE DATABASE kabudata");
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			e.getErrorCode();
//		}



		s.closeConection();
	}


	public String createTBL(){
		createTBL a = new createTBL();
		S s = new S();
		s.getCon();

		//初期テーブルを作る
		String resultStr = a.createStartTBL(s);

		//ついでにビューも作る
		createView b = new createView();
		b.createStartView(s);
		
		
		s.closeConection();
		return resultStr;
	}


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
