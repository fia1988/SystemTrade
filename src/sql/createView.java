package sql;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN_TBL;
import constant.ReCord;

public class createView {


	public String createStartView(S s){

//		createViewTBL(TBL_Name.STOCK_WW_REAL_TIME		,VIEW_Name.STOCK_WW_VIEW	,s,true);
//		createViewTBL(TBL_Name.STOCK_MM_REAL_TIME		,VIEW_Name.STOCK_MM_VIEW	,s,true);
//		createViewTBL(TBL_Name.MARKET_WW_REAL_TIME_TBL	,VIEW_Name.MARKET_WW_VIEW	,s,false);
//		createViewTBL(TBL_Name.MARKET_MM_REAL_TIME_TBL	,VIEW_Name.MARKET_MM_VIEW	,s,false);
		return "";
	}

	private void createViewTBL(String TBL,String viewName,S s,boolean checkStock){

		String SQL_CODE_WHERE = "";
		if (checkStock){
			SQL_CODE_WHERE = COLUMN_TBL.CODE
					  + " in "
					  + " ( "
					  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
					  	+ " from "
					  	+ TBL_Name.CODELISTTBL
					  	+ " where "
					  	+ COLUMN_TBL.CATE_FLG + " = '" + ReCord.CODE_01_STOCK + "'"
					  + " ) ";
			SQL_CODE_WHERE = " and " + SQL_CODE_WHERE;
		}



		//SQL全文
		String SQL = " select * from " + TBL + " where " + COLUMN_TBL.PICK_UP_FLG + " = true " + SQL_CODE_WHERE;

		SQL = " create view " + viewName + " as " + SQL;

		s.createTBL(SQL);
	}

}
