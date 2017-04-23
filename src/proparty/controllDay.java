package proparty;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import common.commonAP;

import constant.COLUMN;
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

	
	
	public static void update_KOSHINBI_SEPA_COMBINE_CHECK(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.KOSIN + " = '" + ReCord.KOSHINBI_SEPA_COMBINE_CHECK + "'";
		s.freeUpdateQuery(SQL);
	}


	public static void update_STOCK_ETF(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.KOSIN + " = '" + ReCord.KOSHINBI_STOCK_ETF + "'";
		s.freeUpdateQuery(SQL);

	}

	public static void update_INDEX(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.KOSIN + " = '" + ReCord.KOSHINBI_INDEX + "'";
		s.freeUpdateQuery(SQL);

	}

	public static void update_STATISTICS(String updateDay,S s){
		SQL = "update " + TBL_Name.UPDATE_MANAGE
				+ " set "
				+ COLUMN.KOSIN_DAY + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.KOSIN + " = '" + ReCord.KOSHINBI_STATISTICS + "'";
		s.freeUpdateQuery(SQL);
	}

	//今日の日付をyyyy-mm-ddでとる
	public static String getTODAY(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return sdf1.format(calendar.getTime());

	}

	//YYYY-MM-DDでとってくる
	public static String getMAX_DD_STOCK_ETF(S s){

		//-を_に変える。DBには_で入っている

//		SQL = "select " + COLUMN.CODENAME + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " ='" + ReCord.KOSHINBI_STOCK_INDEX + "'";
		SQL = "select " + COLUMN.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN.KOSIN + " ='" + ReCord.KOSHINBI_STOCK_ETF + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.KOSIN_DAY));

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
		SQL = "select " + COLUMN.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN.KOSIN + " ='" + ReCord.KOSHINBI_STATISTICS + "'";
		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.KOSIN_DAY));

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
		SQL = "select " + COLUMN.KOSIN_DAY + " from " + TBL_Name.UPDATE_MANAGE + " where " + COLUMN.KOSIN + " ='" + ReCord.KOSHINBI_INDEX + "'";
		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.KOSIN_DAY));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}

}
