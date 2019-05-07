package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.logWriting;

public class Bean_calendarBean {


	ArrayList<String> dayLongList = new ArrayList<String>();
	ArrayList<String> dayMiddleList = new ArrayList<String>();
	ArrayList<String> dayShortList = new ArrayList<String>();
	ArrayList<String> weekLongList = new ArrayList<String>();
	ArrayList<String> weekMiddleList = new ArrayList<String>();
	ArrayList<String> weekShortList = new ArrayList<String>();
	ArrayList<String> monthLongList = new ArrayList<String>();
	ArrayList<String> monthMiddleList = new ArrayList<String>();
	ArrayList<String> monthShortList = new ArrayList<String>();
	ArrayList<String> dayList = new ArrayList<String>();



	private String DAYTIME;
	private String WEEK_NOW;
	private String MONTH_NOW;
	private String DAYTIME_BEFORE;
	private String WEEK_BEFORE;
	private String MONTH_BEFORE;
	private String DAYTIME_SHORT_BEFORE;
	private String WEEK_SHORT_BEFORE;
	private String MONTH_SHORT_BEFORE;
	private String DAYTIME_MIDDLE_BEFORE;
	private String WEEK_MIDDLE_BEFORE;
	private String MONTH_MIDDLE_BEFORE;
	private String DAYTIME_LONG_BEFORE;
	private String WEEK_LONG_BEFORE;
	private String MONTH_LONG_BEFORE;
	private boolean WEEK_CHANGE_FLG ;
	private boolean MONTH_CHANGE_FLG ;

	//getterの結果がnullの時はnullなのでgetterのnullは考慮すること
	//例：if(getter==null){}
	public void setCalendarBean(String TODAY,S s){
		//変数初期化
		dayLongList = new ArrayList<String>();
		dayMiddleList = new ArrayList<String>();
		dayShortList = new ArrayList<String>();
		weekLongList = new ArrayList<String>();
		weekMiddleList = new ArrayList<String>();
		weekShortList = new ArrayList<String>();
		monthLongList = new ArrayList<String>();
		monthMiddleList = new ArrayList<String>();
		monthShortList = new ArrayList<String>();
		String SQL = " select * from " + TBL_Name.CALENDAR_TBL + " where " + COLUMN_TBL.DAYTIME + " = '" + TODAY + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				DAYTIME = s.rs.getString(COLUMN_TBL.DAYTIME);
				WEEK_NOW = s.rs.getString(COLUMN_TBL.WEEK_NOW);
				MONTH_NOW = s.rs.getString(COLUMN_TBL.MONTH_NOW);
				DAYTIME_BEFORE = s.rs.getString(COLUMN_TBL.DAYTIME_BEFORE);
				WEEK_BEFORE = s.rs.getString(COLUMN_TBL.WEEK_BEFORE);
				MONTH_BEFORE = s.rs.getString(COLUMN_TBL.MONTH_BEFORE);
				DAYTIME_SHORT_BEFORE = s.rs.getString(COLUMN_TBL.DAYTIME_SHORT_BEFORE);
				WEEK_SHORT_BEFORE = s.rs.getString(COLUMN_TBL.WEEK_SHORT_BEFORE);
				MONTH_SHORT_BEFORE = s.rs.getString(COLUMN_TBL.MONTH_SHORT_BEFORE);
				DAYTIME_MIDDLE_BEFORE = s.rs.getString(COLUMN_TBL.DAYTIME_MIDDLE_BEFORE);
				WEEK_MIDDLE_BEFORE = s.rs.getString(COLUMN_TBL.WEEK_MIDDLE_BEFORE);
				MONTH_MIDDLE_BEFORE = s.rs.getString(COLUMN_TBL.MONTH_MIDDLE_BEFORE);
				DAYTIME_LONG_BEFORE = s.rs.getString(COLUMN_TBL.DAYTIME_LONG_BEFORE);
				WEEK_LONG_BEFORE = s.rs.getString(COLUMN_TBL.WEEK_LONG_BEFORE);
				MONTH_LONG_BEFORE = s.rs.getString(COLUMN_TBL.MONTH_LONG_BEFORE);
				WEEK_CHANGE_FLG = s.rs.getBoolean(COLUMN_TBL.WEEK_CHANGE_FLG);
				MONTH_CHANGE_FLG = s.rs.getBoolean(COLUMN_TBL.MONTH_CHANGE_FLG);

				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
//				data="'" +  s.rs.getString((col))  + "'" ;
			}else{
				//falseならレコードがないので処理を終える
				return;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		//dayを入れる
		String chkCol = COLUMN_TBL.DAYTIME;
		String checkNow = DAYTIME;
		//短期
		String chkTerm = DAYTIME_SHORT_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				dayShortList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//中期
		chkTerm = DAYTIME_MIDDLE_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				dayMiddleList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//長期
		chkTerm = DAYTIME_LONG_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				dayLongList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//weekをいれる
		chkCol = COLUMN_TBL.WEEK_NOW;
		checkNow = WEEK_NOW;
		//短期
		chkTerm = WEEK_SHORT_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				weekShortList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//中期
		chkTerm = WEEK_MIDDLE_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				weekMiddleList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//長期
		chkTerm = WEEK_LONG_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				weekLongList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}


		chkCol = COLUMN_TBL.MONTH_NOW;
		checkNow = MONTH_NOW;
		//monthをいれる
		//短期
		chkTerm = MONTH_SHORT_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				monthShortList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//中期
		chkTerm = MONTH_MIDDLE_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				monthMiddleList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

		//長期
		chkTerm = MONTH_LONG_BEFORE;
		if (chkTerm==null){
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " <= " + "'" + checkNow + "'" + " order by " + chkCol;
		}else{
			SQL = " select distinct(" + chkCol + ") from " + TBL_Name.CALENDAR_TBL + " where " + chkCol + " between " +  "'" + chkTerm + "'" + " and " +  "'" + checkNow + "'" + " order by " + chkCol;
		}
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				monthLongList.add(s.rs.getString(chkCol));
			}
		} catch (SQLException e) {
			commonAP.writeInLog("setCalendarBean：" + TODAY + "：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

	}

	public String getDAYTIME() {
		return DAYTIME;
	}

	public String getWEEK_NOW() {
		return WEEK_NOW;
	}

	public String getMONTH_NOW() {
		return MONTH_NOW;
	}

	public String getDAYTIME_BEFORE() {
		return DAYTIME_BEFORE;
	}

	public String getWEEK_BEFORE() {
		return WEEK_BEFORE;
	}

	public String getMONTH_BEFORE() {
		return MONTH_BEFORE;
	}

	public String getDAYTIME_SHORT_BEFORE() {
		return DAYTIME_SHORT_BEFORE;
	}

	public String getWEEK_SHORT_BEFORE() {
		return WEEK_SHORT_BEFORE;
	}

	public String getMONTH_SHORT_BEFORE() {
		return MONTH_SHORT_BEFORE;
	}

	public String getDAYTIME_MIDDLE_BEFORE() {
		return DAYTIME_MIDDLE_BEFORE;
	}

	public String getWEEK_MIDDLE_BEFORE() {
		return WEEK_MIDDLE_BEFORE;
	}

	public String getMONTH_MIDDLE_BEFORE() {
		return MONTH_MIDDLE_BEFORE;
	}

	public String getDAYTIME_LONG_BEFORE() {
		return DAYTIME_LONG_BEFORE;
	}

	public String getWEEK_LONG_BEFORE() {
		return WEEK_LONG_BEFORE;
	}

	public String getMONTH_LONG_BEFORE() {
		return MONTH_LONG_BEFORE;
	}

	public boolean getWEEK_CHANGE_FLG() {
		return WEEK_CHANGE_FLG;
	}

	public boolean getMONTH_CHANGE_FLG() {
		return MONTH_CHANGE_FLG;
	}

	public ArrayList<String> getDayLongList() {
		return dayLongList;
	}

	public ArrayList<String> getDayMiddleList() {
		return dayMiddleList;
	}

	public ArrayList<String> getDayShortList() {
		return dayShortList;
	}

	public ArrayList<String> getWeekLongList() {
		return weekLongList;
	}

	public ArrayList<String> getWeekMiddleList() {
		return weekMiddleList;
	}

	public ArrayList<String> getWeekShortList() {
		return weekShortList;
	}

	public ArrayList<String> getMonthLongList() {
		return monthLongList;
	}

	public ArrayList<String> getMonthMiddleList() {
		return monthMiddleList;
	}

	public ArrayList<String> getMonthShortList() {
		return monthShortList;
	}

	public ArrayList<String> getDayList() {
		return dayList;
	}

	public void setDayList(String end,int count,S s) {

		ArrayList<String> thisDayList = new ArrayList<String>();
		dayList = new ArrayList<String>();

		String SQL = " select " + COLUMN_TBL.DAYTIME + " from " + TBL_Name.CALENDAR_TBL
				+" where "
				+ COLUMN_TBL.DAYTIME + " <= '" + end + "'"
				+ " order by " + COLUMN_TBL.DAYTIME + " desc limit " + count;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				thisDayList.add(s.rs.getString(COLUMN_TBL.DAYTIME));
			}

		} catch (SQLException e) {
			System.out.println("getStartDayでエラー。スタックトレース:" + SQL);
			e.getStackTrace();
		}

		this.dayList = thisDayList;
	}




}
