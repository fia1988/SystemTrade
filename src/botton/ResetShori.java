package botton;

import proparty.S;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class ResetShori {
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

	public int resetDB(){
		S s = new S();
		s.getCon();

//
//		try {
//			s.sqlGetter().executeUpdate("drop DATABASE "  + TBL_Name.KABU_DB);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			s.closeConection();
//			return e.getErrorCode();
//		}


		s.closeConection();
		return ReturnCodeConst.SQL_ERR_0;
	}

	public void resetRecord(){
		S s = new S();
		s.getCon();

		String SQL;

//		SQL = "delete from " + TBL_Name.CODELISTTBL;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.STOCK_DD;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.STATISTICS_DD;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.INDEX_DD;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.ETF_DD;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.LASTORDER;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.KEEPLISTTBL;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.RESULTHISTROYTBL;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.UPDATE_MANAGE;
//		s.freeUpdateQuery(SQL);
//		//分割情報のみをリセット
//		SQL = " update " + TBL_Name.STOCK_DD	+ " set "
//						 + COLUMN.OPEN			+ " = " + COLUMN.BEFORE_OPEN	+ " , "
//						 + COLUMN.MAX			+ " = " + COLUMN.BEFORE_MAX		+ " , "
//						 + COLUMN.MIN			+ " = " + COLUMN.BEFORE_MIN		+ " , "
//						 + COLUMN.CLOSE			+ " = " + COLUMN.BEFORE_CLOSE	+ " , "
//						 + COLUMN.DEKI			+ " = " + COLUMN.BEFORE_DEKI	+ "   ";
//		s.freeUpdateQuery(SQL);
//
//		SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = false ";
//		s.freeUpdateQuery(SQL);
//
//		SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = true  where dayTime_kenri_last <= '2006-12-31'";
//		s.freeUpdateQuery(SQL);


		s.closeConection();
	}

	public void resetSepaCombine(){
		S s = new S();
		s.getCon();

		String SQL;

//		//分割情報のみをリセット
//		SQL = " update " + TBL_Name.STOCK_DD	+ " set "
//						 + COLUMN.OPEN			+ " = " + COLUMN.BEFORE_OPEN	+ " , "
//						 + COLUMN.MAX			+ " = " + COLUMN.BEFORE_MAX		+ " , "
//						 + COLUMN.MIN			+ " = " + COLUMN.BEFORE_MIN		+ " , "
//						 + COLUMN.CLOSE			+ " = " + COLUMN.BEFORE_CLOSE	+ " , "
//						 + COLUMN.DEKI			+ " = " + COLUMN.BEFORE_DEKI	+ "   ";
//		s.freeUpdateQuery(SQL);
//
//		SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = false ";
//		s.freeUpdateQuery(SQL);
//
//		SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = true  where dayTime_kenri_last <= '2006-12-31'";
//		s.freeUpdateQuery(SQL);


		s.closeConection();
	}

	public void resetKeepResult(){
		S s = new S();
		s.getCon();

		String SQL;

//		SQL = "delete from " + TBL_Name.LASTORDER;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.KEEPLISTTBL;
//		s.freeUpdateQuery(SQL);
//
//		SQL = "delete from " + TBL_Name.RESULTHISTROYTBL;
//		s.freeUpdateQuery(SQL);

		s.closeConection();
	}
}
