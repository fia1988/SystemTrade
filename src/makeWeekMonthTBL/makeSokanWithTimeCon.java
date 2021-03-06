package makeWeekMonthTBL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;

public class makeSokanWithTimeCon {
	private String SQL_CODE_WHERE;
	private String code;
	private String TODAY;
	private String nowTerm;
	private String beforeTerm;
	private String startLongterm;
	private String startMiddleterm;
	private String startShortterm;
	private String logLetter;
	private String cate;
	private String thisTBL;
	private boolean logFlg = false;
	private String termCol;
	private String idoHeikinCol = COLUMN_TBL.SHORTIDO;
	private String COVAR_Col = COLUMN_TBL.COVAR_with_TIME;
	private final int typeLong = 3;
	private final int typeMiddle = 2;
	private final int typeShort = 1;

	public makeSokanWithTimeCon(String cate){
		this.cate = cate;
		logFlg = true;
		switch (cate) {
			case CATE_FLG.W_STOCK_F:
				cate = ReCord.CODE_01_STOCK;
				break;
			case CATE_FLG.M_STOCK_F:
				cate = ReCord.CODE_01_STOCK;
				break;
			default:
				break;
		}
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " in "
				  + " ( "
				  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
				  	+ " from "
				  	+ TBL_Name.CODELISTTBL
				  	+ " where "
				  	+ COLUMN_TBL.CATE_FLG + " = '" + cate + "'"
				  + " ) ";
	}

	public makeSokanWithTimeCon(String cate,String code){
		this.code = code;
		this.cate = cate;
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " = '" + code + "'"
				  ;
		logFlg = false;
	}


	private void setParameta(Bean_calendarBean calBean,String cate){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		//週足個別銘柄・・・8
		//月足個別銘柄・・・9

		switch(cate){
		case ReCord.CODE_01_STOCK:
			thisTBL = TBL_Name.STOCK_DD;
			termCol = COLUMN_TBL.DAYTIME;
			logLetter = "株日足";
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_02_SATISTICS:
			thisTBL = TBL_Name.STATISTICS_DD;
			termCol = COLUMN_TBL.DAYTIME;
			logLetter = "統計系データ日足";
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_03_INDEX:
			thisTBL = TBL_Name.INDEX_DD;
			termCol = COLUMN_TBL.DAYTIME;
			setParameta_sub(calBean,"1");
			logLetter = "INDEX日足";
			break;

		case ReCord.CODE_04_ETF:
			termCol = COLUMN_TBL.DAYTIME;
			thisTBL = TBL_Name.ETF_DD;
			setParameta_sub(calBean,"1");
			logLetter = "ETF日足";
			break;

		case ReCord.CODE_05_SAKIMONO:
			thisTBL = TBL_Name.SAKIMONO_DD;
			termCol = COLUMN_TBL.DAYTIME;
			setParameta_sub(calBean,"1");
			logLetter = "先物日足";
			break;

		case ReCord.CODE_06_CURRENCY:
			thisTBL = TBL_Name.CURRENCY_DD;
			termCol = COLUMN_TBL.DAYTIME;
			logLetter = "通貨日足";
			break;

		case CATE_FLG.W_STOCK_F:
			thisTBL = TBL_Name.STOCK_WW_TBL;
			termCol = COLUMN_TBL.WEEK_NOW;
			logLetter = "株週足";
			setParameta_sub(calBean,"2");
			break;

		case CATE_FLG.M_STOCK_F:
			thisTBL = TBL_Name.STOCK_MM_TBL;
			termCol = COLUMN_TBL.MONTH_NOW;
			logLetter = "株月足";
			setParameta_sub(calBean,"3");
			break;

		case CATE_FLG.W_MARKET_F:
			thisTBL = TBL_Name.MARKET_WW_TBL;
			termCol = COLUMN_TBL.WEEK_NOW;
			setParameta_sub(calBean,"2");
			logLetter = "マーケット週足";
			break;

		case CATE_FLG.M_MARKET_F:
			setParameta_sub(calBean,"3");
			termCol = COLUMN_TBL.MONTH_NOW;
			logLetter = "マーケット月足";
			thisTBL = TBL_Name.MARKET_MM_TBL;
			break;


		default:
			System.out.println("ConAccessaryNewなんかよくわからないの来た：" + cate + ":" + cate);
			break;
		}
	}
	//1:日足
	//2:週足
	//3:月足
	private void setParameta_sub(Bean_calendarBean calBean,String monthWeekDayCheak){
		switch (monthWeekDayCheak) {
			case "1":
				nowTerm			= calBean.getDAYTIME();
				beforeTerm		= calBean.getDAYTIME_BEFORE();
				startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
				startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
				startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
				break;
			case "2":
				nowTerm			= calBean.getWEEK_NOW();
				beforeTerm		= calBean.getWEEK_BEFORE();
				startLongterm 	= calBean.getWEEK_LONG_BEFORE();;
				startMiddleterm	= calBean.getWEEK_MIDDLE_BEFORE();;
				startShortterm	= calBean.getWEEK_SHORT_BEFORE();;
				break;
			case "3":
				nowTerm			= calBean.getMONTH_NOW();
				beforeTerm		= calBean.getMONTH_BEFORE();
				startLongterm 	= calBean.getMONTH_LONG_BEFORE();;
				startMiddleterm	= calBean.getMONTH_MIDDLE_BEFORE();;
				startShortterm	= calBean.getMONTH_SHORT_BEFORE();;
				break;

			default:
				break;
		}

	}

	//cateは月足週足だけ入る
	public void makeKyoBunsanWithTime(int term,Bean_calendarBean calBean,S s){
		setParameta(calBean,cate);

		upDateCoverWithTime(term,s);

	}


	private void upDateCoverWithTime(int term, S s){
		if(logFlg){
			commonAP.writeInLog(logLetter+"と日付との共分散計算開始。ただしterm:" + term,logWriting.DATEDATE_LOG_FLG);
		}


		//分散の計算、ついでに平均も求める
		List<Double> list = new ArrayList<Double>();
		for (int counter = 1; counter <= term; counter++) {
			list.add((double)counter);
		}
		double timeHensa = commonAP.getDev(list, true);
//		double timeHensa =  Math.sqrt(timeBunsan);
		double timeAve =  ( term+1 ) / 2 ;


		String idoHeikinSQL_A	= " ( "
								+ " select "
								+ COLUMN_TBL.CODE + " , "
								+ idoHeikinCol
								+ " from "
								+ thisTBL
								+ " where "
								+ SQL_CODE_WHERE
								+ " and "
								+ termCol + " = " + "'" + nowTerm + "'"
								+ " ) "
								+ " as A";

//		String updateSQL_B		= " ( "
//								+ " select "
//								+ COLUMN_TBL.CODE + " , "
//								+ termCol + " , "
//								+ COLUMN_TBL.CLOSE
//								+ " from "
//								+ thisTBL
//								+ " where "
//								+ "'" + startShortterm + "'" + " <= "+ termCol
//								+ " and "
//								+ termCol + " <= " + "'" + nowTerm + "'"
//								+ " and "
//								+ SQL_CODE_WHERE
//								+ " ) "
//								+ "as B";

		String updateSQL_B		= " ( "
								+ " select "
								+ COLUMN_TBL.CODE + " , "
								+ termCol + " , "
								+ COLUMN_TBL.CLOSE
								+ " from "
								+ " ( "
								+ createUnionSQL(thisTBL, startShortterm, nowTerm, s)
								+ " ) as Vaaaa"
								+ " group by Vaaaa." + COLUMN_TBL.CODE + ", Vaaaa."+termCol
								+ " ) "
								+ "as B";


		String calendarCol = "aa";
		String calendarCol_use = "bbbb";
		String idCol = "cal_id";
		String selectSQL_C		= " ( "
										+ " select "
										+ calendarCol
										+ " as " + " bbbb " + " , "
										+ "(@num := @num +1) " + " as " + idCol
										+ " from "
										+ " ( "
											+ " select distinct(" + termCol + ") as " + calendarCol + " from " + TBL_Name.CALENDAR_TBL
											+ " where "
											+ "'" + startShortterm + "'" + " <= "+ termCol
											+ " and "
											+ termCol + " <= " + "'" + nowTerm + "'"
										+ " ) " + " as " + "XX" + ","
										+ "(select @num :=0) "  + " as " + " dmy "
										+ "order by " + calendarCol
								+ " ) "
								+ "as C";

		String targetCol = "targetCol";
		String dmyA		 = "dmyA";
		String dmyB		 = "dmyB";

		String asCombine = "asCombine";
		String SQL_B_leftOn_A_leftOn_C
								= " ( "
								+ " select "
								+ "avg("
									+ " ( " + "C." +  idCol + " - " + timeAve + " ) "
									+ " * "
									+ " (" + "B." + COLUMN_TBL.CLOSE + " - " + "A." + idoHeikinCol + " ) "
								+ ")" + " as " + targetCol	 + " , "
//								+ "C." +  idCol				 + " , "
								+ "A." +  COLUMN_TBL.CODE	 + "  "
//								+ "B." + termCol			 + " , "
//								+ "B." + COLUMN_TBL.CLOSE	 + " , "
//								+ "A." + idoHeikinCol		 + " "
								+ " from "
								+ updateSQL_B
								+ " left outer join "
								+ idoHeikinSQL_A
								+ " on "
								+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE
								+ " left outer join "
								+ selectSQL_C
								+ " on "
								+ "B." + termCol + " = " + "C." + calendarCol_use
								+ " where "	//group byにかわるかも
								+ "A." + SQL_CODE_WHERE
								+ " group by "
								+ "A." +  COLUMN_TBL.CODE
								+ " ) as " + asCombine;
		String upSQL =
		   " update " + thisTBL + "," + SQL_B_leftOn_A_leftOn_C
		 + " set "
		 + thisTBL + "." + COLUMN_TBL.COVAR_with_TIME	+ " = " + asCombine	 + "."  + targetCol
		 + " where "
		 + thisTBL + "."+ termCol + " = " + "'" + nowTerm + "'"
		 + " and "
		 + thisTBL + "."+ COLUMN_TBL.CODE + " = " + asCombine + "."+ COLUMN_TBL.CODE
		 ;

		if(logFlg){
			commonAP.writeInLog("upDateCoverWithTime" + logLetter+"の共分散:" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}

		s.freeUpdateQuery(upSQL);


	}


	//calBeanは使わない
	public void makeSokanWithTime(int term,S s,Bean_calendarBean calBean){
		setParameta(calBean,cate);

		//分散の計算、ついでに平均も求める
		List<Double> list = new ArrayList<Double>();
		for (int counter = 1; counter <= term; counter++) {
			list.add((double)counter);
		}
		double timeHensa = commonAP.getDev(list, true);
		String upSQL;
		String A = "A";
		String B = "B";
		upSQL = " update "
				  + thisTBL + " as " + A
				  + " left outer join "
				  + thisTBL + " as " + B
				  + " on "
				  + A + "." + COLUMN_TBL.CODE + " = " + B + "." + COLUMN_TBL.CODE
				  + " and "
				  + A + "." + termCol + " = " + B + "." + termCol
				  + " set "
				  + A + "." + COLUMN_TBL.SOKANKEISU_with_TIME
				  	+ " = "
				  + " ( " + A + "." +  COLUMN_TBL.COVAR_with_TIME + " /" + " ( " + A + "." + COLUMN_TBL.SHORT_DEV + " * " + timeHensa + " ) " + ")"
				  + " where "
				  + A + "." + SQL_CODE_WHERE
				  + " and "
				  + A + "." + termCol + " = " + "'" + nowTerm + "'";
			if(logFlg){
				commonAP.writeInLog("makeSokanWithTime" + logLetter+"の相関係数（時間）:" + upSQL,logWriting.DATEDATE_LOG_FLG);
			}

			s.freeUpdateQuery(upSQL);
	}

	private String createUnionSQL(String TBL,String start,String end,S s){
		ArrayList<String> thisList = new ArrayList<String>();

		//入れる範囲を入れる
		String startCheck	=  " and "
				 			+ "'" + start + "'" + " <= " + termCol;
		if( start==null ){
			startCheck =  "  ";
		}
		String SQL = " select distinct(" + termCol + ") from " + TBL_Name.CALENDAR_TBL
				+" where "
				+ termCol + " <= '" + end + "'"
				+ startCheck;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				thisList.add(s.rs.getString(termCol));
			}

		} catch (SQLException e) {
			commonAP.writeInLog("createUnionSQL:エラー検知。スタックトレース:" + SQL,logWriting.DATEDATE_LOG_FLG);
			e.getStackTrace();
		}

		String unionSQL = "";


		if (thisList.size()==1){
			unionSQL = " select * from " + TBL +" where " + TBL + "." + SQL_CODE_WHERE + " and " + termCol + " = '" + thisList.get(0) + "'";
		}else{

			for (String term:thisList){
				unionSQL = unionSQL + " select * from " + TBL + " where " + TBL + "." + SQL_CODE_WHERE + " and "  + termCol + " = '" + term + "'" + " UNION ALL ";
			}

//			+第一引数：刈り取り対象文字列（テキスト）
//			+第二引数：刈り取る文字
			unionSQL = commonAP.stripEnd(unionSQL," UNION ALL ");

		}


		return unionSQL;
	}
}
