package proparty;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.ReCord;

public class controllDay {

	static String SQL;
	static String MAXDAY;
	static String COMDAY;
	static String TBLName;

	public static String getAJUSTMAXDAY_STATISTICS(S s){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//String"yyyy-mm-dd"できた日付を分割
		MAXDAY =  getMAX_DD_STATISTICS(s);

		String[] TODAYMAX_SPRIT = MAXDAY.split("-");
//		String[] TODAY_SPRIT = getTODAY().split("-");

//		int MAX_int = Integer.parseInt(TODAYMAX_SPRIT[0]);
//		int TODAY_int = Integer.parseInt(TODAY_SPRIT[0]);

		calendar.set(Integer.parseInt(TODAYMAX_SPRIT[0]), Integer.parseInt(TODAYMAX_SPRIT[1]) - 1, Integer.parseInt(TODAYMAX_SPRIT[2]));
		//三年以上更新していない場合、MAX+730日を今日とする。
		calendar.add(Calendar.DAY_OF_MONTH, PROPARTY.HISABISADAY_STATISTICS);
		COMDAY = sdf1.format(calendar.getTime());

		//COMDAYとTODAYを比較して過去の方をリターンする。
		if(COMDAY.compareTo(getTODAY())<=0){

			return COMDAY;
		}else{

			return getTODAY();
		}

	}


	public static String getAJUSTMAXDAY_INDEX(S s){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//String"yyyy-mm-dd"できた日付を分割
		MAXDAY =  getMAX_DD_INDEX(s);

		String[] TODAYMAX_SPRIT = MAXDAY.split("-");
//		String[] TODAY_SPRIT = getTODAY().split("-");

//		int MAX_int = Integer.parseInt(TODAYMAX_SPRIT[0]);
//		int TODAY_int = Integer.parseInt(TODAY_SPRIT[0]);

		calendar.set(Integer.parseInt(TODAYMAX_SPRIT[0]), Integer.parseInt(TODAYMAX_SPRIT[1]) - 1, Integer.parseInt(TODAYMAX_SPRIT[2]));
		//三年以上更新していない場合、MAX+730日を今日とする。
		calendar.add(Calendar.DAY_OF_MONTH, PROPARTY.HISABISADAY_INDEX);
		COMDAY = sdf1.format(calendar.getTime());


		//COMDAYとTODAYを比較して過去の方をリターンする。
		if(COMDAY.compareTo(getTODAY())<=0){

			return COMDAY;
		}else{

			return getTODAY();
		}

	}


	public static String getAJUSTMAXDAY_STOCK_ETF(S s){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//String"yyyy-mm-dd"できた日付を分割
		MAXDAY =  getMAX_DD_STOCK_ETF(s);

		String[] TODAYMAX_SPRIT = MAXDAY.split("-");
//		String[] TODAY_SPRIT = getTODAY().split("-");

//		int MAX_int = Integer.parseInt(TODAYMAX_SPRIT[0]);
//		int TODAY_int = Integer.parseInt(TODAY_SPRIT[0]);

		calendar.set(Integer.parseInt(TODAYMAX_SPRIT[0]), Integer.parseInt(TODAYMAX_SPRIT[1]) - 1, Integer.parseInt(TODAYMAX_SPRIT[2]));
		//三年以上更新していない場合、MAX+730日を今日とする。
		calendar.add(Calendar.DAY_OF_MONTH, PROPARTY.HISABISADAY_STOCK_INDEX);
		COMDAY = sdf1.format(calendar.getTime());


		//COMDAYとTODAYを比較して過去の方をリターンする。
		if(COMDAY.compareTo(getTODAY())<=0){

			return COMDAY;
		}else{

			return getTODAY();
		}

	}



	public static void update_KOSHINBI(String updateDay,String UpdateCulumn,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN_TBL.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN_TBL.KOSIN + " = '" + UpdateCulumn + "'";
		s.freeUpdateQuery(SQL);
	}


	public static void update_STOCK_ETF(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN_TBL.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN_TBL.KOSIN + " = '" + ReCord.KOSHINBI_STOCK_ETF + "'";
		s.freeUpdateQuery(SQL);

	}

	public static void update_INDEX(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN_TBL.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN_TBL.KOSIN + " = '" + ReCord.KOSHINBI_INDEX + "'";
		s.freeUpdateQuery(SQL);

	}

	public static void update_STATISTICS(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN_TBL.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN_TBL.KOSIN + " = '" + ReCord.KOSHINBI_STATISTICS + "'";
		s.freeUpdateQuery(SQL);
	}

	//今日の日付をyyyy-mm-ddでとる
	public static String getTODAY(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return sdf1.format(calendar.getTime());
	}


	public static String getTODAYnoYesterDay(String TODAY){
		Calendar calendar = Calendar.getInstance();
		String[] TODAY_SPRIT = TODAY.split("-");
		calendar.set(Integer.parseInt(TODAY_SPRIT[0]), Integer.parseInt(TODAY_SPRIT[1]) - 1, Integer.parseInt(TODAY_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return sdf1.format(calendar.getTime());
	}

	//今日の日付をyyyy-mm-ddでとる
	public static String getYesterDay(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return sdf1.format(calendar.getTime());
	}

	//UPDATEMANAGEテーブルから引数で指定した値の日付を取得する。
	public static String getDAY_DD_FROM_UPDATE_MAMAGE(String updateColumn,S s){


//		SQL = "select " + COLUMN.CODENAME + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " ='" + ReCord.KOSHINBI_STOCK_INDEX + "'";
		SQL = "select " + COLUMN_TBL.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN_TBL.KOSIN + " ='" + updateColumn + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN_TBL.KOSIN_DAY));

			}
//			System.out.println(TBLName + "のMAX(setMAX_DD_HAIHUN)：" + MAX_HAIHUN);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}


	//YYYY-MM-DDでとってくる
	public static String getMAX_DD_STOCK_ETF(S s){

		//-を_に変える。DBには_で入っている

//		SQL = "select " + COLUMN.CODENAME + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " ='" + ReCord.KOSHINBI_STOCK_INDEX + "'";
		SQL = "select " + COLUMN_TBL.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN_TBL.KOSIN + " ='" + ReCord.KOSHINBI_STOCK_ETF + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN_TBL.KOSIN_DAY));

			}
//			System.out.println(TBLName + "のMAX(setMAX_DD_HAIHUN)：" + MAX_HAIHUN);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}

	public static String getMAX_DD_STATISTICS(S s){

		//-を_に変える。DBには_で入っている
		SQL = "select " + COLUMN_TBL.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN_TBL.KOSIN + " ='" + ReCord.KOSHINBI_STATISTICS + "'";
		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN_TBL.KOSIN_DAY));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}


	public static String getMAX_DD_INDEX(S s){

		//-を_に変える。DBには_で入っている
		SQL = "select " + COLUMN_TBL.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN_TBL.KOSIN + " ='" + ReCord.KOSHINBI_INDEX + "'";
		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN_TBL.KOSIN_DAY));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}

}
