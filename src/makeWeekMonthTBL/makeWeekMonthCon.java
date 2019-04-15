package makeWeekMonthTBL;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;





public class makeWeekMonthCon {
	public void createWeekMonth(String TODAY) {
		S s = new S();
		s.getCon();

		String SQLomajinai = COLUMN_TBL.CODE
						  + " in "
						  + " ( "
						  	+ " select " + COLUMN_TBL.CODE
						  	+ " from "
						  	+ TBL_Name.CODELISTTBL
						  	+ " where " 
						  	+ COLUMN_TBL.CATE_FLG + " = '" + ReCord.CODE_01_STOCK + "'"
						  + " ) ";
		
		Bean_calendarBean calBean = new Bean_calendarBean();
		calBean.setCalendarBean(TODAY, s);

		//前営業日が月/週の最終営業日でなければピックアップフラグをfalseにする。
		checkEndTerm(CATE_FLG.W_STOCK_F,calBean,s,SQLomajinai);
		checkEndTerm(CATE_FLG.M_STOCK_F,calBean,s,SQLomajinai);
		//月/週足の始値(仮)、高値、安値、終値、売買高、出来高をつくる。
		checkBaseW_M(CATE_FLG.W_STOCK_F,calBean,s,SQLomajinai);
		checkBaseW_M(CATE_FLG.M_STOCK_F,calBean,s,SQLomajinai);

		//始値以外の列を作る
		updateCol(CATE_FLG.W_STOCK_F,calBean,s,SQLomajinai);
		updateCol(CATE_FLG.M_STOCK_F,calBean,s,SQLomajinai);
		
//		//始値をつくる
//		updateStart(CATE_FLG.W_STOCK_F,calBean,s,SQLomajinai);
//		updateStart(CATE_FLG.M_STOCK_F,calBean,s,SQLomajinai);
		
		s.closeConection();
	}

	//始値以外の列を作る(高値、安値、出来高、売買高、ピックアップフラグ(=true))
	private void updateCol(String cate,Bean_calendarBean calBean,S s,String SQL_CODE_WHERE){
		String checkCol = "";
		boolean resultCheck = false;
		String targetDay = "'" + calBean.getDAYTIME_BEFORE() + "'";
		String TBL = "";
		String fromTBL = TBL_Name.STOCK_DD;
		String TODAY = "'" + calBean.getDAYTIME() + "'";
		String nowTerm = "";
		String nowTerm_before = "";
		String nowTerm_col = "";
		String nowTerm_before_col = "";
		String w_mLetter = "";

		switch (cate) {
			case CATE_FLG.M_STOCK_F:
				w_mLetter = "月";
				resultCheck = calBean.getMONTH_CHANGE_FLG();
				TBL = TBL_Name.STOCK_MM_REAL_TIME;
				nowTerm = "'" + calBean.getMONTH_NOW() + "'";
				nowTerm_col = COLUMN_TBL.MONTH_NOW;
				nowTerm_before_col = COLUMN_TBL.MONTH_BEFORE;
				if ( calBean.getMONTH_BEFORE() != null){
					nowTerm_before =  "'" + calBean.getMONTH_BEFORE() + "'";
				}
				break;
			case CATE_FLG.W_STOCK_F:
				resultCheck = calBean.getWEEK_CHANGE_FLG();
				w_mLetter = "週";
				TBL = TBL_Name.STOCK_WW_REAL_TIME;
				nowTerm = "'" + calBean.getWEEK_NOW() + "'";
				nowTerm_col = COLUMN_TBL.WEEK_NOW;
				nowTerm_before_col = COLUMN_TBL.WEEK_BEFORE;
				if (calBean.getWEEK_BEFORE() != null){
					nowTerm_before = "'" + calBean.getWEEK_BEFORE() + "'";
				}

				break;

			default:
				break;
		}
		
//		始値以外の列を作る(高値、安値、出来高、売買高、ピックアップフラグ(=true))
		String SQL;
		String maxSQL = " ( select max(" + COLUMN_TBL.MAX + ") from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.DAYTIME + " <= " + TODAY + " and " + COLUMN_TBL.PICK_UP_FLG + " = false " + " and " + nowTerm_col + " = " + nowTerm + " and " +  SQL_CODE_WHERE + " ) ";
		String minSQL = " ( select min( " + COLUMN_TBL.MIN + ") from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.DAYTIME + " <= " + TODAY + " and " + COLUMN_TBL.PICK_UP_FLG + " = false " + " and " + nowTerm_col + " = " + nowTerm + " and " +  SQL_CODE_WHERE + " ) ";
		String dekiSQL = " ( select sum( " + COLUMN_TBL.DEKI + ") from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.DAYTIME + " <= " + TODAY + " and " + COLUMN_TBL.PICK_UP_FLG + " = false " + " and " + nowTerm_col + " = " + nowTerm + " and " +  SQL_CODE_WHERE + " ) ";
		String baybaySQL = " ( select sum( " + COLUMN_TBL.BAYBAY + ") from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.DAYTIME + " <= " + TODAY + " and " + COLUMN_TBL.PICK_UP_FLG + " = false " + " and " + nowTerm_col + " = " + nowTerm + " and " +  SQL_CODE_WHERE + " ) ";
		SQL = " update "
			+ TBL
			+ " set "
			+ COLUMN_TBL.MAX		 + " = " + maxSQL +  " , "
			+ COLUMN_TBL.MIN		 + " = " + minSQL +  " , "
			+ COLUMN_TBL.DEKI		 + " = " + dekiSQL +  " , "
			+ COLUMN_TBL.BAYBAY		 + " = " + baybaySQL +  " , "
			+ COLUMN_TBL.PICK_UP_FLG + " = true " + "  "
			+ " where "
			+ COLUMN_TBL.DAYTIME + " = " + TODAY
			+ " and "
			  + SQL_CODE_WHERE;
		
		commonAP.writeInLog("updateCol:" + w_mLetter + "足の各列の月足基本情報作成：" + SQL,logWriting.DATEDATE_LOG_FLG);
		
//		s.freeUpdateQuery(SQL);
	}
	
	
	//月/週足の始値(仮)、高値、安値、終値、売買高、出来高をつくる。
	private void checkBaseW_M(String cate,Bean_calendarBean calBean,S s,String SQL_CODE_WHERE){
		String checkCol = "";
		boolean resultCheck = false;
		String targetDay = "'" + calBean.getDAYTIME_BEFORE() + "'";
		String TBL = "";
		String fromTBL = TBL_Name.STOCK_DD;
		String TODAY = "'" + calBean.getDAYTIME() + "'";
		String nowTerm = "";
		String nowTerm_before = "";
		String nowTerm_col = "";
		String nowTerm_before_col = "";
		String w_mLetter = "";

		switch (cate) {
			case CATE_FLG.M_STOCK_F:
				w_mLetter = "月";
				resultCheck = calBean.getMONTH_CHANGE_FLG();
				TBL = TBL_Name.STOCK_MM_REAL_TIME;
				nowTerm = "'" + calBean.getMONTH_NOW() + "'";
				nowTerm_col = COLUMN_TBL.MONTH_NOW;
				nowTerm_before_col = COLUMN_TBL.MONTH_BEFORE;
				if ( calBean.getMONTH_BEFORE() != null){
					nowTerm_before =  "'" + calBean.getMONTH_BEFORE() + "'";
				}
				break;
			case CATE_FLG.W_STOCK_F:
				resultCheck = calBean.getWEEK_CHANGE_FLG();
				w_mLetter = "週";
				TBL = TBL_Name.STOCK_WW_REAL_TIME;
				nowTerm = "'" + calBean.getWEEK_NOW() + "'";
				nowTerm_col = COLUMN_TBL.WEEK_NOW;
				nowTerm_before_col = COLUMN_TBL.WEEK_BEFORE;
				if (calBean.getWEEK_BEFORE() != null){
					nowTerm_before = "'" + calBean.getWEEK_BEFORE() + "'";
				}

				break;

			default:
				break;
		}

		String col =  COLUMN_TBL.CODE	 + " , "
					+ COLUMN_TBL.DAYTIME + " , "
					+ COLUMN_TBL.OPEN	 + " , "
					+ COLUMN_TBL.MAX	 + " , "
					+ COLUMN_TBL.MIN	 + " , "
					+ COLUMN_TBL.DEKI	 + " , "
					+ COLUMN_TBL.BAYBAY	 + " , "
					+ COLUMN_TBL.CLOSE;
		String selectSQL;
		selectSQL = " select "
				  + col 
				  + " from " + fromTBL 
				  + " where " 
				  + COLUMN_TBL.DAYTIME + " = " + TODAY
				  + " and "
				  + SQL_CODE_WHERE;
					 
		String insSQL;
		insSQL = "insert into "
				+ TBL
				+ " ( "
				+ col
				+ ")"
				+ selectSQL;

		commonAP.writeInLog("checkBaseW_M:" + w_mLetter + "足の銘柄名、本日日付、終値作成：" + insSQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(insSQL);

	}

	//前営業日が月/週の最終営業日でなければピックアップフラグをfalseにする。
	private boolean checkEndTerm(String cate,Bean_calendarBean calBean,S s,String SQL_CODE_WHERE){
		boolean thisResult = true;
		String checkCol = "";
		boolean resultCheck = false;
		String targetDay = "'" + calBean.getDAYTIME_BEFORE() + "'";
		String TBL = "";
		String TODAY = "'" + calBean.getDAYTIME() + "'";
		String w_mLetter = "";

		switch (cate) {
			case CATE_FLG.M_STOCK_F:
				resultCheck = calBean.getMONTH_CHANGE_FLG();
				TBL = TBL_Name.STOCK_MM_REAL_TIME;
				w_mLetter = "月";
				break;
			case CATE_FLG.W_STOCK_F:
				resultCheck = calBean.getWEEK_CHANGE_FLG();
				TBL = TBL_Name.STOCK_WW_REAL_TIME;
				w_mLetter = "週";
				break;

			default:
				break;
		}

		//true処理終了
		//true=週/月の始まりなので前営業日が週/月の最終日になるので編集しなくてもよい。
		//ピックアップフラグは基本trueで作成されて前営業日をひたすらfalseに変えていく。
		if (resultCheck == true){
			return thisResult;
		}

		if(targetDay.equals("null")){
			thisResult = false;
			return thisResult;
		}

		String SQL;
		SQL = " update "
			+ TBL
			+ " set "
			+ COLUMN_TBL.PICK_UP_FLG + " = false"
			+ " where "
			+ COLUMN_TBL.DAYTIME + " = " + targetDay
			+ " and "
			  + SQL_CODE_WHERE;
		commonAP.writeInLog("checkEndTerm:" + w_mLetter + "足のピックアップチェック："+SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		return thisResult;
	}


}
