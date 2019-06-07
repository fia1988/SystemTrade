package makeCalendar;

import java.sql.SQLException;
import java.util.Calendar;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.AccesarryParameta;
import constant.COLUMN_TBL;
import constant.logWriting;

public class makeCalendarCon {

	public void createCallendar(String TODAY) {
		commonAP.writeInLog("createCallendar:カレンダーテーブルを" + TODAY + "更新します。",logWriting.DATEDATE_LOG_FLG);
		S s = new S();
		s.getCon();

		insertTODAYRecord(TODAY, s);

		updateTODAYRecord(TODAY, s);

		s.closeConection();
		commonAP.writeInLog("createCallendar:カレンダーテーブルを" + TODAY + "更新しました。",logWriting.DATEDATE_LOG_FLG);
	}

	private void updateTODAYRecord(String TODAY,S s){
		String SQL;

		//前日
		String maeDay		 = updateData(TODAY,1,2,s);
		//前週
		String maeWeek		 = updateData(TODAY,2,2,s);
		//前月
		String maeMonth		 = updateData(TODAY,3,2,s);

		//短期前日
		String shortDay		 = updateData(TODAY,1,AccesarryParameta.IDOSHORT,s);
		//短期前週
		String shortWeek	 = updateData(TODAY,2,AccesarryParameta.IDOSHORT,s);
		//短期前月
		String shortMonth	 = updateData(TODAY,3,AccesarryParameta.IDOSHORT,s);

		//中期前日
		String middleDay	 = updateData(TODAY,1,AccesarryParameta.IDOMIDDLE,s);
		//中期前週
		String middleWeek	 = updateData(TODAY,2,AccesarryParameta.IDOMIDDLE,s);
		//中期前月
		String middleMonth	 = updateData(TODAY,3,AccesarryParameta.IDOMIDDLE,s);

		//長期前日
		String longDay		 = updateData(TODAY,1,AccesarryParameta.IDOLONG,s);
		//長期前週
		String longWeek		 = updateData(TODAY,2,AccesarryParameta.IDOLONG,s);
		//長期前月
		String longMonth	 = updateData(TODAY,3,AccesarryParameta.IDOLONG,s);

		//入手した値をアップデート

//		System.out.println( getCalString(cal));
		SQL = " update "
				+ TBL_Name.CALENDAR_TBL
				+ " set "
				+ COLUMN_TBL.DAYTIME_BEFORE			+ " = " + maeDay		 + " , "
				+ COLUMN_TBL.WEEK_BEFORE			+ " = " + maeWeek		 + " ,  "
				+ COLUMN_TBL.MONTH_BEFORE			+ " = " + maeMonth		 + " , "

				+ COLUMN_TBL.DAYTIME_SHORT_BEFORE	+ " = " + shortDay		 + " , "
				+ COLUMN_TBL.WEEK_SHORT_BEFORE		+ " = " + shortWeek		 + " ,  "
				+ COLUMN_TBL.MONTH_SHORT_BEFORE		+ " = " + shortMonth	 + " , "

				+ COLUMN_TBL.DAYTIME_MIDDLE_BEFORE	+ " = " + middleDay		 + " , "
				+ COLUMN_TBL.WEEK_MIDDLE_BEFORE		+ " = " + middleWeek	 + " ,  "
				+ COLUMN_TBL.MONTH_MIDDLE_BEFORE	+ " = " + middleMonth	 + " , "

				+ COLUMN_TBL.DAYTIME_LONG_BEFORE	+ " = " + longDay		 + " , "
				+ COLUMN_TBL.WEEK_LONG_BEFORE		+ " = " + longWeek		 + " ,  "
				+ COLUMN_TBL.MONTH_LONG_BEFORE		+ " = " + longMonth		 + "   "
				+ " where "
				+ COLUMN_TBL.DAYTIME + " = '" + TODAY + "'";
				;
		s.freeUpdateQuery(SQL);

		//週、月チェンジチェック
		//直前の月情報、週情報
		String checkWeek = checkChangeWeekMontn(TODAY,2,s);
		String checkMonth = checkChangeWeekMontn(TODAY,3,s);



		SQL = " update "
				+ TBL_Name.CALENDAR_TBL
				+ " set "
				+ COLUMN_TBL.MONTH_CHANGE_FLG	+ " = false "
				+ " where "
				+ COLUMN_TBL.DAYTIME + " = '" + TODAY + "'"
				+ " and "
				+ COLUMN_TBL.MONTH_NOW + " = " + checkMonth;
		s.freeUpdateQuery(SQL);


		SQL = " update "
				+ TBL_Name.CALENDAR_TBL
				+ " set "
				+ COLUMN_TBL.WEEK_CHANGE_FLG	+ " = false "
				+ " where "
				+ COLUMN_TBL.DAYTIME + " = '" + TODAY + "'"
				+ " and "
				+ COLUMN_TBL.WEEK_NOW + " = " + checkWeek;
		s.freeUpdateQuery(SQL);


	}

	//cateは以下
	//2:週足
	//3:月足
	private String checkChangeWeekMontn(String TODAY,int cate,S s){
		int term = 2;
		String SQL = "";
		String col = "";
		String data = "null";
		switch (cate) {
			case 1:
				col = COLUMN_TBL.DAYTIME;
				break;
			case 2:
				col = COLUMN_TBL.WEEK_NOW;
				break;
			case 3:
				col = COLUMN_TBL.MONTH_NOW;
				break;
			default:
				break;
		}


		SQL = " select  " + col + " from " + TBL_Name.CALENDAR_TBL
				+ " where " + COLUMN_TBL.DAYTIME + " <= '" + TODAY + "'"
				+ " order by " + col + " desc"
				+ " limit " + (term - 1) + " , 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
				data="'" +  s.rs.getString((col))  + "'" ;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return data;
	}


	//cateは以下
	//1:日足
	//2:週足
	//3:月足
	private String updateData(String TODAY,int cate,int term,S s){

		String SQL = "";
		String col = "";
		String data = "null";
		switch (cate) {
			case 1:
				col = COLUMN_TBL.DAYTIME;
				break;
			case 2:
				col = COLUMN_TBL.WEEK_NOW;
				break;
			case 3:
				col = COLUMN_TBL.MONTH_NOW;
				break;
			default:
				break;
		}
		SQL = " select distinct " + col + " from " + TBL_Name.CALENDAR_TBL
				+ " where " + COLUMN_TBL.DAYTIME + " <= '" + TODAY + "'"
				+ " order by " + col + " desc"
				+ " limit " + (term - 1) + " , 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
				data="'" +  s.rs.getString((col))  + "'" ;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



		return data;
	}


	//TODAY:YYYY-MM-DD
	private void insertTODAYRecord(String TODAY,S s){
		String YYYYMMDD = ( TODAY.replaceAll("-",""));
		String YYYY = YYYYMMDD.substring(0, 4);
		String MM = YYYYMMDD.substring(4, 6);
		String DD = YYYYMMDD.substring(6, 8);
		int yyyy = Integer.parseInt(YYYY);
		int mm = Integer.parseInt(MM);
		int dd = Integer.parseInt(DD);
		Calendar cal = Calendar.getInstance();

		//月だけ0＝1月なので1を引く
		cal.set(yyyy, mm-1, dd);

		int week_now_int = cal.get(Calendar.WEEK_OF_YEAR);
		String week_now = Integer.toString(week_now_int);

		if (week_now.length() == 1){
			if(mm==12){
				//なぜか12月のweeknowが１のときがあるので修正
				cal.set(yyyy, mm-1, dd-7);
				week_now_int = cal.get(Calendar.WEEK_OF_YEAR);
				week_now = Integer.toString(week_now_int+1);
			}else{
				week_now = "0" + week_now;	
			}
		}


		String month_now = YYYYMMDD;
		month_now = month_now.substring(0, 6);
		week_now = YYYY + week_now;

		String SQL;
//		System.out.println( getCalString(cal));
		SQL = "insert into "
				+ TBL_Name.CALENDAR_TBL
				+ " ( "
				+ COLUMN_TBL.DAYTIME			 + " , "
				+ COLUMN_TBL.MONTH_NOW			 + " , "
				+ COLUMN_TBL.WEEK_NOW			 + " ,  "
				+ COLUMN_TBL.MONTH_CHANGE_FLG	 + " ,  "
				+ COLUMN_TBL.WEEK_CHANGE_FLG	 + "    "
				+ ")"
				+ " values "
				+ "("
				+ "'" + TODAY		 + "' , "
				+ "'" + month_now	 + "' , "
				+ "'" + week_now	 + "' ,  "
				+ " true ,  "
				+ " true    "
				+ " )  "
				;
		s.freeUpdateQuery(SQL);

	}
}
