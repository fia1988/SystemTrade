package makeWeekMonthTBL;

import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import proparty.VIEW_Name;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.AccesarryParameta;
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

	private String termCol;
	private String idoHeikinCol = COLUMN_TBL.SHORTIDO;
	private String COVAR_Col = COLUMN_TBL.COVAR_with_TIME;
	private final int typeLong = 3;
	private final int typeMiddle = 2;
	private final int typeShort = 1;

	public makeSokanWithTimeCon(String cate){
		this.cate = cate;

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

		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " = '" + code + "'"
				  ;
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
			thisTBL = VIEW_Name.STOCK_WW_VIEW;
			termCol = COLUMN_TBL.WEEK_NOW;
			logLetter = "株週足";
			setParameta_sub(calBean,"2");
			break;

		case CATE_FLG.M_STOCK_F:
			thisTBL = VIEW_Name.STOCK_MM_VIEW;
			termCol = COLUMN_TBL.MONTH_NOW;
			logLetter = "株月足";
			setParameta_sub(calBean,"3");
			break;

		case CATE_FLG.W_MARKET_F:
			thisTBL = VIEW_Name.MARKET_WW_VIEW;
			termCol = COLUMN_TBL.WEEK_NOW;
			setParameta_sub(calBean,"2");
			logLetter = "マーケット週足";
			break;

		case CATE_FLG.M_MARKET_F:
			setParameta_sub(calBean,"3");
			termCol = COLUMN_TBL.MONTH_NOW;
			logLetter = "マーケット月足";
			thisTBL = VIEW_Name.MARKET_MM_VIEW;
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
	public void makeSokanWithTime(Bean_calendarBean calBean,S s){
		setParameta(calBean,cate);

		upDateCoverWithTime(AccesarryParameta.IDOSHORT,s);
	}


	private void upDateCoverWithTime(int term, S s){
		commonAP.writeInLog(logLetter+"と日付との共分散計算開始。ただしterm:" + term,logWriting.DATEDATE_LOG_FLG);

		//分散の計算、ついでに平均も求める
		List<Double> list = new ArrayList<Double>();
		for (int counter = 1; counter <= term; counter++) {
			list.add((double)counter);
		}
		double timeBunsan = commonAP.getDev(list, true);
		double timeAve =  ( term+1 ) / 2 ;



		String idoHeikinSQL_A	= " select "
								+ COLUMN_TBL.CODE + " , "
								+ idoHeikinCol
								+ " from "
								+ thisTBL
								+ " where "
								+ SQL_CODE_WHERE
								+ " and "
								+ termCol + " = " + "'" + nowTerm + "'"
								+ " as A";

		String updateSQL_B		= " select "
								+ COLUMN_TBL.CODE + " , "
								+ COLUMN_TBL.CLOSE
								+ " from "
								+ thisTBL
								+ " where "
								+ "'" + startShortterm + "'" + " <= "+ termCol
								+ " and "
								+ termCol + " <= " + "'" + nowTerm + "'"
								+ " and "
								+ SQL_CODE_WHERE
								+ "as B";

		String SQL_B_leftOn_C	= " select "
								+ "A." +  COLUMN_TBL.CODE + " , "
								+ "B." + COLUMN_TBL.CLOSE + " , "
								+ "A." + idoHeikinCol
								+ " from "
								+ updateSQL_B
								+ " left outer join "
								+ idoHeikinSQL_A
								+ " on "
								+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE
								+ " where "
								+ "A." + SQL_CODE_WHERE;;

		System.out.println("＜SQL＞"+ SQL_B_leftOn_C);
	}
}
