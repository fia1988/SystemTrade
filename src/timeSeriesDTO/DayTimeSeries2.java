package timeSeriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;

import common.commonAP;

import constant.COLUMN;

public class DayTimeSeries2 {
	String SQL;
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();
	private List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
	HashMap<String,List<Bean_CodeList>> map = new HashMap<String,List<Bean_CodeList>>();
	Bean_CodeList B_C = new Bean_CodeList();


	public void setCodeDTO_DD(String startDay,String endDay,S s){
		//一応、実行のたびに変数をリセットする
		B_C = new Bean_CodeList();
		B_Cs  = new ArrayList<Bean_CodeList>();
		map = new HashMap<String,List<Bean_CodeList>>();

		setCodeDTO_01_STOCK_DD(startDay,endDay,s);

		setCodeDTO_02_STATISTICS_DD(startDay,endDay,s);

		setCodeDTO_03_INDEX_DD(startDay,endDay,s);

		setCodeDTO_04_ETF_DD(startDay,endDay,s);

		setCodeDTO_05_SAKIMONO_DD(startDay,endDay,s);

		setCodeDTO_06_CURRENCY_DD(startDay,endDay,s);

	}

	public void setCodeDTO_DD(String cate,String startDay,String endDay,S s){
		//一応、実行のたびに変数をリセットする
		B_C = new Bean_CodeList();
		B_Cs  = new ArrayList<Bean_CodeList>();
		map = new HashMap<String,List<Bean_CodeList>>();
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6

		switch (cate){
		case "1":
			setCodeDTO_01_STOCK_DD(startDay,endDay,s);
			break;
		case "2":
			setCodeDTO_02_STATISTICS_DD(startDay,endDay,s);
			break;
		case "3":
			setCodeDTO_03_INDEX_DD(startDay,endDay,s);
			break;
		case "4":
			setCodeDTO_04_ETF_DD(startDay,endDay,s);
			break;
		case "5":
			setCodeDTO_05_SAKIMONO_DD(startDay,endDay,s);
			break;
		case "6":
			setCodeDTO_06_CURRENCY_DD(startDay,endDay,s);
			break;
		default:
			break;
		}


	}

	public void setCodeDTO_DD(S s){
		//一応、実行のたびに変数をリセットする
		B_C = new Bean_CodeList();
		B_Cs  = new ArrayList<Bean_CodeList>();
		map = new HashMap<String,List<Bean_CodeList>>();

		setCodeDTO_01_STOCK_DD(s);

		setCodeDTO_02_STATISTICS_DD(s);

		setCodeDTO_03_INDEX_DD(s);

		setCodeDTO_04_ETF_DD(s);

		setCodeDTO_05_SAKIMONO_DD(s);

		setCodeDTO_06_CURRENCY_DD(s);

	}

	public void setCodeDTO_DD(String cate,S s){
		//一応、実行のたびに変数をリセットする
		B_C = new Bean_CodeList();
		B_Cs  = new ArrayList<Bean_CodeList>();
		map = new HashMap<String,List<Bean_CodeList>>();
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6

		switch (cate){
		case "1":
			setCodeDTO_01_STOCK_DD(s);
			break;
		case "2":
			setCodeDTO_02_STATISTICS_DD(s);
			break;
		case "3":
			setCodeDTO_03_INDEX_DD(s);
			break;
		case "4":
			setCodeDTO_04_ETF_DD(s);
			break;
		case "5":
			setCodeDTO_05_SAKIMONO_DD(s);
			break;
		case "6":
			setCodeDTO_06_CURRENCY_DD(s);
			break;
		default:
			break;
		}


	}


	//個別銘柄・・・1
	private void setCodeDTO_01_STOCK_DD(String startDay,String endDay,S s){

		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '1'";
		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.STOCK_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "' and " + COLUMN.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME	 )		)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_CLOSE)	)	);
					B_C.setDeki   (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_DEKI)		)	);
					B_C.setBaybay (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_BAYBAY)	)	);
					B_C.setCatelfg("1");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);

				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	//統計・・・2
	private void setCodeDTO_02_STATISTICS_DD(String startDay,String endDay,S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '2'";

		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.STATISTICS_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "' and " + COLUMN.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay		  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME)			)	);
					B_C.setDeki		  (s.rs2.getString(commonAP.cutBlank(COLUMN.DEKI)			)	);
					B_C.setBaybay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.BAYBAY)			)	);
					B_C.setStockCount (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_NAME_NUM)	)	);
					B_C.setTakePrice  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_GETPRICE)	)	);
					B_C.setUpPrice	  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_UPSTOCK)	)	);
					B_C.setNoChange   (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_NOCHANGE)	)	);
					B_C.setDownPrice  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_DOWNSTOCK)	)	);
					B_C.setCatelfg("2");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//指数・・・3
	private void setCodeDTO_03_INDEX_DD(String startDay,String endDay,S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '3'";
		String CODENAME;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.INDEX_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "' and " + COLUMN.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				while (s.rs2.next()) {

					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME)	)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.CLOSE)		)	);
					B_C.setCatelfg("1");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//ETF・・・4
	private void setCodeDTO_04_ETF_DD(String startDay,String endDay,S s){

		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '4'";
		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.ETF_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "' and " + COLUMN.DAYTIME + " between '" + startDay + "' and '" + endDay + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME	 )		)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.CLOSE)		)	);
					B_C.setDeki   (s.rs2.getString(commonAP.cutBlank(COLUMN.DEKI)		)	);
					B_C.setBaybay (s.rs2.getString(commonAP.cutBlank(COLUMN.BAYBAY)	)	);
					B_C.setCatelfg("4");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//先物・・・5
	private void setCodeDTO_05_SAKIMONO_DD(String startDay,String endDay,S s){

	}
	//通貨・・・6
	private void setCodeDTO_06_CURRENCY_DD(String startDay,String endDay,S s){

	}


	//個別銘柄・・・1
	private void setCodeDTO_01_STOCK_DD(S s){

		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '1'";
		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.STOCK_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME	 )		)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_CLOSE)	)	);
					B_C.setDeki   (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_DEKI)		)	);
					B_C.setBaybay (s.rs2.getString(commonAP.cutBlank(COLUMN.BEFORE_BAYBAY)	)	);
					B_C.setCatelfg("1");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);

				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	//統計・・・2
	private void setCodeDTO_02_STATISTICS_DD(S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '2'";

		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.STATISTICS_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay		  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME)			)	);
					B_C.setDeki		  (s.rs2.getString(commonAP.cutBlank(COLUMN.DEKI)			)	);
					B_C.setBaybay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.BAYBAY)			)	);
					B_C.setStockCount (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_NAME_NUM)	)	);
					B_C.setTakePrice  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_GETPRICE)	)	);
					B_C.setUpPrice	  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_UPSTOCK)	)	);
					B_C.setNoChange   (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_NOCHANGE)	)	);
					B_C.setDownPrice  (s.rs2.getString(commonAP.cutBlank(COLUMN.STOCK_DOWNSTOCK)	)	);
					B_C.setCatelfg("2");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//指数・・・3
	private void setCodeDTO_03_INDEX_DD(S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '3'";
		String CODENAME;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.INDEX_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				while (s.rs2.next()) {

					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME)	)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.CLOSE)		)	);
					B_C.setCatelfg("1");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//ETF・・・4
	private void setCodeDTO_04_ETF_DD(S s){

		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '4'";
		String CODENAME;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				CODENAME = s.rs.getString(commonAP.cutBlank(COLUMN.CODE));
				List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
				//ここにすべての株の一覧を取得する。
				//取得した銘柄のSQLを株テーブルから持ってくる。

				SQL = "select * from " + TBL_Name.ETF_DD + " where " + (COLUMN.CODE) + " = '" + CODENAME + "'";
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while (s.rs2.next()) {
					Bean_CodeList B_C = new Bean_CodeList();
					B_C.setDay	  (s.rs2.getString(commonAP.cutBlank(COLUMN.DAYTIME	 )		)	);
					B_C.setOpen   (s.rs2.getString(commonAP.cutBlank(COLUMN.OPEN)		)	);
					B_C.setMax    (s.rs2.getString(commonAP.cutBlank(COLUMN.MAX)		)	);
					B_C.setMin    (s.rs2.getString(commonAP.cutBlank(COLUMN.MIN)		)	);
					B_C.setClose  (s.rs2.getString(commonAP.cutBlank(COLUMN.CLOSE)		)	);
					B_C.setDeki   (s.rs2.getString(commonAP.cutBlank(COLUMN.DEKI)		)	);
					B_C.setBaybay (s.rs2.getString(commonAP.cutBlank(COLUMN.BAYBAY)	)	);
					B_C.setCatelfg("4");
					//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
					B_Cs.add(B_C);
				}
				map.put(CODENAME,B_Cs);


			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//先物・・・5
	private void setCodeDTO_05_SAKIMONO_DD(S s){

	}
	//通貨・・・6
	private void setCodeDTO_06_CURRENCY_DD(S s){

	}

	public HashMap<String,List<Bean_CodeList>> getDTO(){
		return map;
	}
}
