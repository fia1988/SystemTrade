package bean;

import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN;

public class Bean_calendarBean {

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
	
	public void setCalendarBean(String TODAY,S s){
		String SQL = " select * from " + TBL_Name.CALENDAR_TBL + " where " + COLUMN.DAYTIME + " = '" + TODAY + "'";
		
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				DAYTIME = s.rs.getString(COLUMN.DAYTIME);
				WEEK_NOW = s.rs.getString(COLUMN.WEEK_NOW);
				MONTH_NOW = s.rs.getString(COLUMN.MONTH_NOW);
				DAYTIME_BEFORE = s.rs.getString(COLUMN.DAYTIME_BEFORE);
				WEEK_BEFORE = s.rs.getString(COLUMN.WEEK_BEFORE);
				MONTH_BEFORE = s.rs.getString(COLUMN.MONTH_BEFORE);
				DAYTIME_SHORT_BEFORE = s.rs.getString(COLUMN.DAYTIME_SHORT_BEFORE);
				WEEK_SHORT_BEFORE = s.rs.getString(COLUMN.WEEK_SHORT_BEFORE);
				MONTH_SHORT_BEFORE = s.rs.getString(COLUMN.MONTH_SHORT_BEFORE);
				DAYTIME_MIDDLE_BEFORE = s.rs.getString(COLUMN.DAYTIME_MIDDLE_BEFORE);
				WEEK_MIDDLE_BEFORE = s.rs.getString(COLUMN.WEEK_MIDDLE_BEFORE);
				MONTH_MIDDLE_BEFORE = s.rs.getString(COLUMN.MONTH_MIDDLE_BEFORE);
				DAYTIME_LONG_BEFORE = s.rs.getString(COLUMN.DAYTIME_LONG_BEFORE);
				WEEK_LONG_BEFORE = s.rs.getString(COLUMN.WEEK_LONG_BEFORE);
				MONTH_LONG_BEFORE = s.rs.getString(COLUMN.MONTH_LONG_BEFORE);
				WEEK_CHANGE_FLG = s.rs.getBoolean(COLUMN.WEEK_CHANGE_FLG);
				MONTH_CHANGE_FLG = s.rs.getBoolean(COLUMN.MONTH_CHANGE_FLG);

				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
//				data="'" +  s.rs.getString((col))  + "'" ;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		+ COLUMN.DAYTIME_KATA					 + " ,  "
//		+ COLUMN.WEEK_NOW_KATA					 + " ,  "
//		+ COLUMN.MONTH_NOW_KATA					 + " ,  "
//		+ COLUMN.DAYTIME_BEFORE_KATA			 + " ,  "
//		+ COLUMN.WEEK_BEFORE_KATA				 + " ,  "
//		+ COLUMN.MONTH_BEFORE_KATA				 + " ,  "
//		+ COLUMN.DAYTIME_SHORT_BEFORE_KATA		 + " ,  "
//		+ COLUMN.WEEK_SHORT_BEFORE_KATA			 + " ,  "
//		+ COLUMN.MONTH_SHORT_BEFORE_KATA		 + " ,  "
//		+ COLUMN.DAYTIME_MIDDLE_BEFORE_KATA		 + " ,  "
//		+ COLUMN.WEEK_MIDDLE_BEFORE_KATA		 + " ,  "
//		+ COLUMN.MONTH_MIDDLE_BEFORE_KATA		 + " ,  "
//		+ COLUMN.DAYTIME_LONG_BEFORE_KATA		 + " ,  "
//		+ COLUMN.WEEK_LONG_BEFORE_KATA			 + " ,  "
//		+ COLUMN.MONTH_LONG_BEFORE_KATA			 + " ,  "
//		+ COLUMN.WEEK_CHANGE_FLG_KATA 			 + " ,  "
//		+ COLUMN.MONTH_CHANGE_FLG_KATA 			 + " ,  "
		
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
	
	
	
	
}
