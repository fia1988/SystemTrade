package timeSeriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import proparty.ALLList;
import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;

import common.commonAP;

import constant.COLUMN_TBL;

public class DayTimeSeries {
	String SQL;
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();
	private List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
	HashMap<String,List<Bean_CodeList>> map = new HashMap<String,List<Bean_CodeList>>();


	public void setCodeDTO_DD(String code,String startDay,String endDay,S s){
		B_Cs  = new ArrayList<Bean_CodeList>();
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6

		switch (ALLList.getCateFlg(code, s)){
		case "1":
			setCode1_DD(code,startDay,endDay,s);
			break;
		case "2":
			setCode2_DD(code,startDay,endDay,s);
			break;
		case "3":
			setCode3_DD(code,startDay,endDay,s);
			break;
		case "4":
			setCode4_DD(code,startDay,endDay,s);
			break;
		case "5":
			setCode5_DD(code,startDay,endDay,s);
			break;
		case "6":
			setCode6_DD(code,startDay,endDay,s);
			break;
		default:
			break;
		}


	}


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	private void setCode1_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
		//

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_CLOSE)		)	);
				B_C.setDeki   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_DEKI)		)	);
				B_C.setBaybay (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_BAYBAY)	)	);
				B_C.setCatelfg("1");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	private void setCode2_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.STATISTICS_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay		  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME)			)	);
				B_C.setDeki		  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DEKI)			)	);
				B_C.setBaybay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BAYBAY)			)	);
				B_C.setStockCount (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_NAME_NUM)	)	);
				B_C.setTakePrice  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_GETPRICE)	)	);
				B_C.setUpPrice	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_UPSTOCK)	)	);
				B_C.setNoChange   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_NOCHANGE)	)	);
				B_C.setDownPrice  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_DOWNSTOCK)	)	);
				B_C.setCatelfg("2");


				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	private void setCode3_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.INDEX_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.CLOSE)		)	);
				B_C.setCatelfg("3");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private void setCode4_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.ETF_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.CLOSE)		)	);
				B_C.setDeki   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DEKI)		)	);
				B_C.setBaybay (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BAYBAY)	)	);
				B_C.setCatelfg("4");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private void setCode5_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.SAKIMONO_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
	}

	private void setCode6_DD(String code,String startDay,String endDay,S s){
		SQL = "select * from " + TBL_Name.CURRENCY_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "' and " + COLUMN_TBL.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
	}







	public void setCodeDTO_DD(String code,S s){

		B_Cs  = new ArrayList<Bean_CodeList>();
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6

		switch (ALLList.getCateFlg(code, s)){
		case "1":
			setCode1_DD(code,s);
			break;
		case "2":
			setCode2_DD(code,s);
			break;
		case "3":
			setCode3_DD(code,s);
			break;
		case "4":
			setCode4_DD(code,s);
			break;
		case "5":
			setCode5_DD(code,s);
			break;
		case "6":
			setCode6_DD(code,s);
			break;
		default:
			break;
		}


	}


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	private void setCode1_DD(String code,S s){
		SQL = "select * from " + TBL_Name.STOCK_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";


		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_CLOSE)		)	);
				B_C.setDeki   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_DEKI)		)	);
				B_C.setBaybay (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BEFORE_BAYBAY)	)	);
				B_C.setCatelfg("1");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	private void setCode2_DD(String code,S s){
		SQL = "select * from " + TBL_Name.STATISTICS_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay		  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME)			)	);
				B_C.setDeki		  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DEKI)			)	);
				B_C.setBaybay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BAYBAY)			)	);
				B_C.setStockCount (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_NAME_NUM)	)	);
				B_C.setTakePrice  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_GETPRICE)	)	);
				B_C.setUpPrice	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_UPSTOCK)	)	);
				B_C.setNoChange   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_NOCHANGE)	)	);
				B_C.setDownPrice  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.STOCK_DOWNSTOCK)	)	);
				B_C.setCatelfg("2");


				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	private void setCode3_DD(String code,S s){
		SQL = "select * from " + TBL_Name.INDEX_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.CLOSE)		)	);
				B_C.setCatelfg("3");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private void setCode4_DD(String code,S s){
		SQL = "select * from " + TBL_Name.ETF_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				B_C.setDay	  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DAYTIME	 )		)	);
				B_C.setOpen   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.OPEN)		)	);
				B_C.setMax    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MAX)		)	);
				B_C.setMin    (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.MIN)		)	);
				B_C.setClose  (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.CLOSE)		)	);
				B_C.setDeki   (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.DEKI)		)	);
				B_C.setBaybay (s.rs.getString(commonAP.cutBlank(COLUMN_TBL.BAYBAY)	)	);
				B_C.setCatelfg("4");
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private void setCode5_DD(String code,S s){
		SQL = "select * from " + TBL_Name.SAKIMONO_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";
	}

	private void setCode6_DD(String code,S s){
		SQL = "select * from " + TBL_Name.CURRENCY_DD + " where " + COLUMN_TBL.CODE + "= '" + code + "'";
	}

	public List<Bean_CodeList> getCodeDTO_DD(){
		return B_Cs;
	}
}
