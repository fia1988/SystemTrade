package accesarrySQL;

import java.util.ArrayList;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.AccesarryParameta;
import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;

public class ConAccessaryNew {

	private String SQL_CODE_WHERE;
	private String code;
	private String TODAY;
	private String nowTerm;
	private String beforeTerm;
	private String startLongterm;
	private String startMiddleterm;
	private String startShortterm;

	private ArrayList<String> useListLong = new ArrayList<String>();
	private ArrayList<String> useListMiddle = new ArrayList<String>();
	private ArrayList<String> useListShort = new ArrayList<String>();

	private String cate;
	private String thisTBL;
	private boolean singleFLG = false;
	private String termCol;
	public boolean logFLG = false;
	private final int typeLong = 3;
	private final int typeMiddle = 2;
	private final int typeShort = 1;
	//コンストラクタ、全銘柄
	public ConAccessaryNew(String cate){
		this.cate = cate;
		singleFLG = false;
		logFLG = false;
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
//				  	+ " where "
//				  	+ COLUMN_TBL.CATE_FLG + " = '" + cate + "'"
				  + " ) ";

	}
	public ConAccessaryNew(String cate,String code){
		this.code = code;
		this.cate = cate;
		logFLG = true;
		singleFLG = true;
//		logFLG = false;
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
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_02_SATISTICS:
			thisTBL = TBL_Name.STATISTICS_DD;
			termCol = COLUMN_TBL.DAYTIME;
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_03_INDEX:
			thisTBL = TBL_Name.INDEX_DD;
			termCol = COLUMN_TBL.DAYTIME;
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_04_ETF:
			termCol = COLUMN_TBL.DAYTIME;
			thisTBL = TBL_Name.ETF_DD;
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_05_SAKIMONO:
			thisTBL = TBL_Name.SAKIMONO_DD;
			termCol = COLUMN_TBL.DAYTIME;
			setParameta_sub(calBean,"1");
			break;

		case ReCord.CODE_06_CURRENCY:
			thisTBL = TBL_Name.CURRENCY_DD;
			termCol = COLUMN_TBL.DAYTIME;
			break;

		case CATE_FLG.W_STOCK_F:
			thisTBL = TBL_Name.STOCK_WW_TBL;
			termCol = COLUMN_TBL.WEEK_NOW;
			setParameta_sub(calBean,"2");
			break;

		case CATE_FLG.M_STOCK_F:
			thisTBL = TBL_Name.STOCK_MM_TBL;
			termCol = COLUMN_TBL.MONTH_NOW;
			setParameta_sub(calBean,"3");
			break;

		case CATE_FLG.W_MARKET_F:
			thisTBL = TBL_Name.MARKET_WW_TBL;
			termCol = COLUMN_TBL.WEEK_NOW;
			setParameta_sub(calBean,"2");
			break;

		case CATE_FLG.M_MARKET_F:
			setParameta_sub(calBean,"3");
			termCol = COLUMN_TBL.MONTH_NOW;
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

				useListLong = calBean.getDayLongList();
				useListMiddle = calBean.getDayMiddleList();
				useListShort = calBean.getDayShortList();

				break;
			case "2":
				nowTerm			= calBean.getWEEK_NOW();
				beforeTerm		= calBean.getWEEK_BEFORE();
				startLongterm 	= calBean.getWEEK_LONG_BEFORE();;
				startMiddleterm	= calBean.getWEEK_MIDDLE_BEFORE();;
				startShortterm	= calBean.getWEEK_SHORT_BEFORE();;
				useListLong = calBean.getWeekLongList();
				useListMiddle = calBean.getWeekMiddleList();
				useListShort = calBean.getWeekShortList();
				break;
			case "3":
				nowTerm			= calBean.getMONTH_NOW();
				beforeTerm		= calBean.getMONTH_BEFORE();
				startLongterm 	= calBean.getMONTH_LONG_BEFORE();;
				startMiddleterm	= calBean.getMONTH_MIDDLE_BEFORE();;
				startShortterm	= calBean.getMONTH_SHORT_BEFORE();;
				useListLong = calBean.getMonthLongList();
				useListMiddle = calBean.getMonthMiddleList();
				useListShort = calBean.getMonthShortList();
				break;

			default:
				break;
		}
	}

	public void setConAccessary(Bean_calendarBean calBean,S s){

		TODAY  = calBean.getDAYTIME();
		setParameta(calBean,cate);

		//平滑指数移動平均線とMACDを引く。
		idoheikatuUpdate_Ikkatsu(AccesarryParameta.HEKATUSHORT,AccesarryParameta.HEKATUMIDDLE,AccesarryParameta.HEKATULONG,s);
//		//平滑線の後処理としてnull列を今日のCLOSEと同じ値にする。
		heikatuAfter(s);

		//MACDを作成する。
		MACDupdate(s);

		//売買高、出来高、終値で移動平均線を引く。。ボリバン用の標準偏差の計算をする。
		closeDekiBayIDOheikinUpdate(typeShort, s);
		closeDekiBayIDOheikinUpdate(typeMiddle, s);
		closeDekiBayIDOheikinUpdate(typeLong, s);

		//MACDシグナルひく（必ずMACDの後に引く）
		macdSig(typeShort	, s);
		macdSig(typeMiddle	, s);
		macdSig(typeLong	, s);

		//終値をもとにボリンジャーバンドを引く
		closeBoriban(typeShort, s);
		closeBoriban(typeMiddle, s);
		closeBoriban(typeLong, s);

		//各テーブルの前日比、窓
		zenzituhi(s);
		//一行レコード比較
	}

	private void macdSig(int type,S s){
		String MACD = "";
		String MACD_sig = "";
		//MACDシグナルは9営業日での測定（＝期間短い奴）
		int macdSig = typeShort;
		switch (type) {
			case typeShort:
				MACD = COLUMN_TBL.SHORT_MACD;
				MACD_sig = COLUMN_TBL.SHORT_MACD_SIGNAL;
				break;
			case typeMiddle:
				MACD = COLUMN_TBL.MIDDLE_MACD;
				MACD_sig = COLUMN_TBL.MIDDLE_MACD_SIGNAL;
				break;
			case typeLong:
				MACD = COLUMN_TBL.LONG_MACD;
				MACD_sig = COLUMN_TBL.LONG_MACD_SIGNAL;
				break;
			default:
				break;
		}

		String A = "A";
		String dummyNow = "dummyNow";
		String aveMACD = "F";
		String sansyoTBL = " ( "
						+ " select "
						+ COLUMN_TBL.CODE + " , "
						+ "'" + nowTerm + "'"		+ " as " + dummyNow  +  " , "
						+ " avg(" + MACD	 +  ")" + " as " + aveMACD  +  "  "
						+ " from "
						+ " ( "
						+ createUnionSQL(macdSig, thisTBL)
						+ " ) as V"
						+ " group by V." + COLUMN_TBL.CODE
						+ " ) " + " as " + A;

		String upSQL;

				//ロング
				//ミドル
				//ショート
				upSQL = " update "
						+ thisTBL + " "
						+" left outer join "
						+ sansyoTBL
						+ " on "
						+ thisTBL + "." + COLUMN_TBL.CODE + " = " + A + "." + COLUMN_TBL.CODE	  + " "
						+ " and "
						+ thisTBL + "." + termCol		  + " = " + A + "." + dummyNow
						+ " set "
						+ thisTBL + "." + MACD_sig		 + " = " + A + "." + aveMACD	  + " "
						+ " where "
						+ thisTBL + "." + termCol + " = " + "'" + nowTerm + "'"
						+ " and "
						+ thisTBL + "." + SQL_CODE_WHERE
						;;


		if ( logFLG == false){
			commonAP.writeInLog("【MACDシグナルを計算：】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(upSQL);
	}

	//各テーブルの前日比、窓
	private void zenzituhi(S s){
		String SQL;



		SQL =
		" update "
			+ thisTBL		 + " as A  "
			+ " left outer join "
			+ thisTBL		 + " as B  "
			+ " on "
			+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE

			+ " set "
			+ "A." + COLUMN_TBL.CHANGE_PRICE				 + " = " + " ( " + "A." + COLUMN_TBL.CLOSE				 + " - " + "B." + COLUMN_TBL.CLOSE				 + ")"		 + " , " //前日比
			+ "A." + COLUMN_TBL.CHANGERATE					 + " = " + " ( " + "A." + COLUMN_TBL.CLOSE				 + " / " + "B." + COLUMN_TBL.CLOSE				 + ") - 1 "	 + " , " //前日比率
			+ "A." + COLUMN_TBL.WINDOW						 + " = " + " ( " + "B." + COLUMN_TBL.CLOSE				 + " - " + "A." + COLUMN_TBL.OPEN				 + ")"		 + " , " //窓を埋める。前日の終値と今日の始値の差。終値ー始値
			+ "A." + COLUMN_TBL.SHORTIDO_CHANGERATE			 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO			 + " - " + "B." + COLUMN_TBL.SHORTIDO			 + ")"		 + " , " //株価短期間移動平均線前日比
			+ "A." + COLUMN_TBL.MIDDLEIDO_CHANGERATE		 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO			 + " - " + "B." + COLUMN_TBL.MIDDLEIDO			 + ")"		 + " , " //株価中期間移動平均線前日比
			+ "A." + COLUMN_TBL.LONGIDO_CHANGERATE			 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO			 + " - " + "B." + COLUMN_TBL.LONGIDO			 + ")"		 + " , " //株価長期間移動平均線前日比
			+ "A." + COLUMN_TBL.SHORTIDO_RATIO				 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO			 + " / " + "B." + COLUMN_TBL.SHORTIDO			 + ") - 1 "	 + " , " //株価短期間移動平均線前日比率
			+ "A." + COLUMN_TBL.MIDDLEIDO_RATIO				 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO			 + " / " + "B." + COLUMN_TBL.MIDDLEIDO			 + ") - 1 "	 + " , " //株価中期間移動平均線前日比率
			+ "A." + COLUMN_TBL.LONGIDO_RATIO				 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO			 + " / " + "B." + COLUMN_TBL.LONGIDO			 + ") - 1 "	 + " , "; //株価長期間移動平均線前日比率
//		if (!(cate.equals(ReCord.CODE_04_ETF))){

		SQL	= SQL
//			+ "A." + COLUMN_TBL.DEKI_CHANGERATE				 + " = " + " ( " + "A." + COLUMN_TBL.DEKI				 + " - " + "B." + COLUMN_TBL.DEKI				 + ")"		 + " , " //出来高前日比
			+ "A." + COLUMN_TBL.DEKI_RATIO					 + " = " + " ( " + "A." + COLUMN_TBL.DEKI				 + " / " + "B." + COLUMN_TBL.DEKI				 + ") - 1 "	 + " , " //出来高前日比率
//			+ "A." + COLUMN_TBL.BAYBAY_CHANGERATE			 + " = " + " ( " + "A." + COLUMN_TBL.BAYBAY				 + " - " + "B." + COLUMN_TBL.BAYBAY				 + ")"		 + " , " //売買代金前日比
			+ "A." + COLUMN_TBL.BAYBAY_RATIO				 + " = " + " ( " + "A." + COLUMN_TBL.BAYBAY				 + " / " + "B." + COLUMN_TBL.BAYBAY				 + ") - 1 "	 + " , " //売買代金前日比率
			+ "A." + COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_DEKI		 + " - " + "B." + COLUMN_TBL.SHORTIDO_DEKI		 + ")"		 + " , " //出来高短期間移動平均線前日比
			+ "A." + COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_DEKI		 + " - " + "B." + COLUMN_TBL.MIDDLEIDO_DEKI		 + ")"		 + " , " //出来高中期移動平均線前日比
			+ "A." + COLUMN_TBL.LONGIDO_DEKI_CHANGERATE		 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_DEKI		 + " - " + "B." + COLUMN_TBL.LONGIDO_DEKI		 + ")"		 + " , " //出来高長期移動平均線前日比
			+ "A." + COLUMN_TBL.SHORTIDO_DEKI_RATIO			 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_DEKI		 + " / " + "B." + COLUMN_TBL.SHORTIDO_DEKI		 + ") - 1 "	 + " , " //出来高短期間移動平均線前日比率
			+ "A." + COLUMN_TBL.MIDDLEIDO_DEKI_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_DEKI		 + " / " + "B." + COLUMN_TBL.MIDDLEIDO_DEKI		 + ") - 1 "	 + " , " //出来高中期間移動平均線前日比率
			+ "A." + COLUMN_TBL.LONGIDO_DEKI_RATIO			 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_DEKI		 + " / " + "B." + COLUMN_TBL.LONGIDO_DEKI		 + ") - 1 "	 + " , " //出来高長期間移動平均線前日比率
			+ "A." + COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_BAYBAY	 + " - " + "B." + COLUMN_TBL.SHORTIDO_BAYBAY	 + ")"		 + " , " //売買代金短期間移動平均線前日比
			+ "A." + COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_BAYBAY	 + " - " + "B." + COLUMN_TBL.MIDDLEIDO_BAYBAY	 + ")"		 + " , " //売買代金中期間移動平均線前日比
			+ "A." + COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_BAYBAY		 + " - " + "B." + COLUMN_TBL.LONGIDO_BAYBAY		 + ")"		 + " , " //売買代金長期間移動平均線前日比
			+ "A." + COLUMN_TBL.SHORTIDO_BAYBAY_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_BAYBAY	 + " / " + "B." + COLUMN_TBL.SHORTIDO_BAYBAY	 + ") - 1 "	 + " , " //売買代金短期間移動平均線前日比率
			+ "A." + COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_BAYBAY	 + " / " + "B." + COLUMN_TBL.MIDDLEIDO_BAYBAY	 + ") - 1 "	 + " , " //売買代金中期間移動平均線前日比率
			+ "A." + COLUMN_TBL.LONGIDO_BAYBAY_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_BAYBAY		 + " / " + "B." + COLUMN_TBL.LONGIDO_BAYBAY		 + ") - 1 "	 + " , "; //売買代金長期間移動平均線前日比率
//		}
		SQL = SQL
			+ "A." + COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_HEKATU	 + " - " + "B." + COLUMN_TBL.SHORTIDO_HEKATU	 + ")"		 + " , " //指数平滑移動平均短期前日比
			+ "A." + COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + " - " + "B." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + ")"		 + " , " //指数平滑移動平均中期前日比
			+ "A." + COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE	 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_HEKATU		 + " - " + "B." + COLUMN_TBL.LONGIDO_HEKATU		 + ")"		 + " , " //指数平滑移動平均長期前日比
			+ "A." + COLUMN_TBL.SHORTIDO_HEKATU_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.SHORTIDO_HEKATU	 + " / " + "B." + COLUMN_TBL.SHORTIDO_HEKATU	 + ") - 1 "	 + " , " //指数平滑移動平均短期前日比率
			+ "A." + COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + " / " + "B." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + ") - 1 "	 + " , " //指数平滑移動平均中期前日比率
			+ "A." + COLUMN_TBL.LONGIDO_HEKATU_RATIO		 + " = " + " ( " + "A." + COLUMN_TBL.LONGIDO_HEKATU		 + " / " + "B." + COLUMN_TBL.LONGIDO_HEKATU		 + ") - 1 "	 + "   " //指数平滑移動平均長期前日比率
			+ " where "
			+ "A." + termCol + " = " + "'" + nowTerm + "'"
			+ " and "
			+ "B." + termCol + " = " + "'" + beforeTerm + "'"
			+ " and "
			+ "A." + SQL_CODE_WHERE;

		if ( logFLG == false){
			commonAP.writeInLog("【前日比】" + SQL,logWriting.DATEDATE_LOG_FLG);
		}

		s.freeUpdateQuery(SQL);

		//データ型の関係で売買前日比と出来高前日比は別処理する。
//		zenzituhiDEKIBAYBAY_CHANGERATE(COLUMN_TBL.DEKI_CHANGERATE	, COLUMN_TBL.DEKI	, s);
//		zenzituhiDEKIBAYBAY_CHANGERATE(COLUMN_TBL.BAYBAY_CHANGERATE	, COLUMN_TBL.BAYBAY	, s);
	}

	private void zenzituhiDEKIBAYBAY_CHANGERATE(String changeRateCol,String motoCol,S s){
		//株とマーケットの時だけ処理する。
		if ((cate.equals(ReCord.CODE_04_ETF))){
			return;
		}

		String SQL;

//		SQL =
//		" update "
//			+ thisTBL		 + " as A  "
//			+ " left outer join "
//			+ thisTBL		 + " as B  "
//			+ " on "
//			+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE
//			+ " set "
//			+ "A." + changeRateCol	 + " = " + " ( " + "B." + motoCol + " - " + "A." + motoCol + " ) "
//			+ " where "
//			+ "A." + termCol + " = " + "'" + nowTerm + "'"
//			+ " and "
//			+ "A." + motoCol + " < " + "B." + motoCol
//			+ " and "
//			+ "B." + termCol + " = " + "'" + beforeTerm + "'"
//			+ " and "
//			+ "A." + SQL_CODE_WHERE;
//		commonAP.writeInLog("【前日比出来高売買高１】" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//
//		SQL =
//		" update "
//			+ thisTBL		 + " as A  "
//			+ " set "
//			+ "A." + changeRateCol	 + " = " + " ( A." + changeRateCol + " * (-1)" + " ) "
//			+ " where "
//			+ "A." + termCol + " = " + "'" + nowTerm + "'"
//			+ " and "
//			+ "A." + changeRateCol	 + " is not null "
//			+ " and "
//			+ "A." + SQL_CODE_WHERE;;
//			commonAP.writeInLog("【前日比出来高売買高２】" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//
//
//		SQL =
//		" update "
//			+ thisTBL		 + " as A  "
//			+ " left outer join "
//			+ thisTBL		 + " as B  "
//			+ " on "
//			+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE
//			+ " set "
//			+ "A." + changeRateCol	 + " = " + " ( " + "A." + motoCol + " - " + "B." + motoCol + " ) "
//			+ " where "
//			+ "A." + termCol + " = " + "'" + nowTerm + "'"
//			+ " and "
//			+ "A." + motoCol + " >= " + "B." + motoCol
//			+ " and "
//			+ "B." + termCol + " = " + "'" + beforeTerm + "'"
//			+ " and "
//			+ "A." + SQL_CODE_WHERE;
//		commonAP.writeInLog("【前日比出来高売買高３】" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);

	}

	//平滑事後処理
	private void heikatuAfter(S s){
		String upSQL;
//		COLUMN_TBL.SHORTIDO_HEKATU;
//		COLUMN_TBL.MIDDLEIDO_HEKATU;
//		COLUMN_TBL.LONGIDO_HEKATU;
		upSQL = " update "
			 	+ thisTBL + " as A"
			 	+ " left outer join "
			 	+ thisTBL + " as B"
			 	+ " on "
			 	+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
			 	+ " and "
			 	+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
				+ " set "
				+ "A." + COLUMN_TBL.SHORTIDO_HEKATU	 + " = "
					+ " CASE "
						+ " WHEN " + "A." + COLUMN_TBL.SHORTIDO_HEKATU + " is  null then " + "A." + COLUMN_TBL.CLOSE
						+ " else " + "A." + COLUMN_TBL.SHORTIDO_HEKATU
					+ " END "	+ ","
				+ "A." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + " = "
					+ " CASE "
						+ " WHEN " + "A." + COLUMN_TBL.MIDDLEIDO_HEKATU + " is  null then " + "A." + COLUMN_TBL.CLOSE
						+ " else " + "A." + COLUMN_TBL.MIDDLEIDO_HEKATU
					+ " END "	+ ","
				+ "A." + COLUMN_TBL.LONGIDO_HEKATU	 + " = "
					+ " CASE "
						+ " WHEN " + "A." + COLUMN_TBL.LONGIDO_HEKATU + " is  null then " + "A." + COLUMN_TBL.CLOSE
						+ " else " + "A." + COLUMN_TBL.LONGIDO_HEKATU
					+ " END "	+ " "
				+ " where "
				+ "A." + SQL_CODE_WHERE
//				+ exitCode(thisTBL, singleFLG, cate)
				+ " and "
				+ "A." + termCol + " = " + "'" + nowTerm + "'";
							;

//						upSQL = " update "
//				+ thisTBL + " "
//				+" left outer join "
//				+ selectBeforeTBL
//				+ " on "
//				+ thisTBL + "." + COLUMN_TBL.CODE + " = " + beforeTBL + "." + COLUMN_TBL.CODE	  + " "
//				+ " set "
//				+ thisTBL + "." + heikatuCol	 + " = "
//					+ " CASE "
//						+ " WHEN " + beforeTBL + "." + beforeCol + " is not null then " + " ( " + beforeTBL + "." + beforeCol + " +  ( " + alpha + " * " + " ( " + thisTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + beforeCol + " ) ) )"
//						+ " ELSE " + thisTBL + "." + COLUMN_TBL.CLOSE
//					+ " END "
//				+ " where "
//				+ thisTBL + "." + termCol + " = " + "'" + nowTerm + "'"
//				+ " and "
//				+ thisTBL + "." + SQL_CODE_WHERE
//				;;


		if ( logFLG == false){
			commonAP.writeInLog("【移動平滑線事後処理】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}


		s.freeUpdateQuery(upSQL);

	}

	//平滑指数移動平均線とMACDひく。
	private void idoheikatuMACDupdate(int type,S s){
		//※平滑指数移動平均線をもとにMACDを引く。
		//MACD
//		idoheikatuUpdate(type, s);
		MACDupdate(s);
	}

	//MACD
	private void MACDupdate(S s){
		String SQL;


		//MACDを作る。
		SQL = " update "
		 	+ thisTBL + " as A"
		 	+ " left outer join "
		 	+ thisTBL + " as B"
		 	+ " on "
		 	+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
		 	+ " and "
		 	+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
			+ " set "
			+ "A."+ COLUMN_TBL.SHORT_MACD  + " = "+ "A." + COLUMN_TBL.SHORTIDO_HEKATU  + " - " + "A." + COLUMN_TBL.MIDDLEIDO_HEKATU + ","
			+ "A."+ COLUMN_TBL.MIDDLE_MACD + " = "+ "A." + COLUMN_TBL.MIDDLEIDO_HEKATU + " - " + "A." + COLUMN_TBL.LONGIDO_HEKATU	 + ","
			+ "A."+ COLUMN_TBL.LONG_MACD   + " = "+ "A." + COLUMN_TBL.SHORTIDO_HEKATU  + " - " + "A." + COLUMN_TBL.LONGIDO_HEKATU	 + ""
			+ " where "
			+ "A." + termCol + " = " + "'" + nowTerm + "'"
			+ " and "
			+ "A." + SQL_CODE_WHERE;

		if ( logFLG == false){
			commonAP.writeInLog("【MACD】" + SQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(SQL);
	}
	//※平滑指数移動平均線をもとにMACDを引く。
	private void idoheikatuUpdate(int type,S s){
		int term=0;
		String heikatuCol= "";
		switch (type) {
			case typeShort:
				term =  AccesarryParameta.HEKATUSHORT;
				heikatuCol = COLUMN_TBL.SHORTIDO_HEKATU;
				break;
			case typeMiddle:
				term =  AccesarryParameta.HEKATUMIDDLE;
				heikatuCol = COLUMN_TBL.MIDDLEIDO_HEKATU;
				break;
			case typeLong:
				heikatuCol = COLUMN_TBL.LONGIDO_HEKATU;
				term =  AccesarryParameta.HEKATULONG;
				break;
			default:
				break;
		}


		String upSQL;

		//前日の指数平滑移動平均を参照するため、前日が存在しないとnullになる。
		//前日をチェックする


//		前日の指数平滑移動平均＋α×{当日終値-前日の指数平滑移動平均}
//		※α（平滑定数）＝2÷（ｎ+1）
		//※α（平滑定数）＝2÷（ｎ+1）
		double alpha = ( (term+1) );
		alpha = 2 / alpha;

		String beforeTBL = "beforeTBL";
//		upSQL = " update "
//				+ thisTBL + " "
//				+" left outer join "
//				+ selectBeforeTBL
//				+ " on "
//				+ thisTBL + "." + COLUMN_TBL.CODE + " = " + beforeTBL + "." + COLUMN_TBL.CODE	  + " "
//				+ " set "
//				+ thisTBL + "." + heikatuCol	 + " = "
//					+ " CASE "
//						+ " WHEN " + beforeTBL + "." + beforeCol + " is not null then " + " ( " + beforeTBL + "." + beforeCol + " +  ( " + alpha + " * " + " ( " + thisTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + beforeCol + " ) ) )"
//						+ " ELSE " + thisTBL + "." + COLUMN_TBL.CLOSE
//					+ " END "
//				+ " where "
//				+ thisTBL + "." + termCol + " = " + "'" + nowTerm + "'"
//				+ " and "
//				+ thisTBL + "." + SQL_CODE_WHERE
//				;;

		String upTBL = "upTBL";


		upSQL = " update "
				+ thisTBL + " " + " as " + upTBL
				+ " left outer join "
				+ thisTBL + " " + " as " + beforeTBL
				+ " on "
				+ upTBL + "." + COLUMN_TBL.CODE + " = " + beforeTBL + "." + COLUMN_TBL.CODE	  + " "
				+ " set "
				+ upTBL + "."  + heikatuCol	 + " = ( " + beforeTBL + "." + heikatuCol + " +  ( " + alpha + " * " + " ( " + upTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + heikatuCol + " ) ) )"
				+ " where "
				+ upTBL + "."  + SQL_CODE_WHERE
//				+ exitCode(upTBL,singleFLG,cate)
				+ " and "
				+ upTBL + "."  + termCol + " = " + "'" + nowTerm + "'"
				+ " and "
				+ beforeTBL + "."  + termCol + " = " + "'" + beforeTerm + "'"
				;;

		if ( logFLG == false){
			commonAP.writeInLog("【移動平滑線】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(upSQL);
	}

	//※平滑指数移動平均線をもとにMACDを引く。
	private void idoheikatuUpdate_Ikkatsu(int shortTerm,int middleTerm,int longTerm,S s){

		String upSQL;

//		前日の指数平滑移動平均＋α×{当日終値-前日の指数平滑移動平均}
//		※α（平滑定数）＝2÷（ｎ+1）
		//※α（平滑定数）＝2÷（ｎ+1）
		double shortAlpha = ( (shortTerm+1) );
		shortAlpha = 2 / shortAlpha;
		double middleAlpha = ( (middleTerm+1) );
		middleAlpha = 2 / middleAlpha;
		double longAlpha = ( (longTerm+1) );
		longAlpha = 2 / longAlpha;

		String beforeTBL = "beforeTBL";
		String upTBL = "upTBL";

		upSQL = " update "
				+ thisTBL + " " + " as " + upTBL
				+ " left outer join "
				+ thisTBL + " " + " as " + beforeTBL
				+ " on "
				+ upTBL + "." + COLUMN_TBL.CODE + " = " + beforeTBL + "." + COLUMN_TBL.CODE	  + " "
				+ " set "
				+ upTBL + "."  + COLUMN_TBL.SHORTIDO_HEKATU	 + " = ( " + beforeTBL + "." + COLUMN_TBL.SHORTIDO_HEKATU	 + " +  ( " + shortAlpha	 + " * " + " ( " + upTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + COLUMN_TBL.SHORTIDO_HEKATU + " ) ) ) " + " , "
				+ upTBL + "."  + COLUMN_TBL.MIDDLEIDO_HEKATU + " = ( " + beforeTBL + "." + COLUMN_TBL.MIDDLEIDO_HEKATU	 + " +  ( " + middleAlpha	 + " * " + " ( " + upTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + COLUMN_TBL.MIDDLEIDO_HEKATU + " ) ) ) " + " , "
				+ upTBL + "."  + COLUMN_TBL.LONGIDO_HEKATU	 + " = ( " + beforeTBL + "." + COLUMN_TBL.LONGIDO_HEKATU	 + " +  ( " + longAlpha		 + " * " + " ( " + upTBL + "." + COLUMN_TBL.CLOSE + " - " + beforeTBL + "." + COLUMN_TBL.LONGIDO_HEKATU + " ) ) ) " + "  "
				+ " where "
				+ upTBL + "."  + termCol + " = " + "'" + nowTerm + "'"
				+ " and "
				+ beforeTBL + "."  + termCol + " = " + "'" + beforeTerm + "'"
				+ " and "
				+ upTBL + "."  + SQL_CODE_WHERE
				;;

		if ( logFLG == false){
			commonAP.writeInLog("【移動平滑線】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(upSQL);
	}

	//終値をもとにボリンジャーバンドを引く(終値から作った移動平均線が元ネタ）
	private void closeBoriban(int type,S s){
		int ratio = 1;
		String stvCol = "";
		String tergetStvH_1 = "";
		String tergetStvL_1 = "";
		String tergetStvH_2 = "";
		String tergetStvL_2 = "";
		String tergetStvH_3 = "";
		String tergetStvL_3 = "";
		String idoHeikin = "";
		switch (type) {
			case typeShort:
//				targetBayBay = COLUMN_TBL.SHORTIDO_BAYBAY;
//				targetClose = COLUMN_TBL.SHORTIDO;
//				targetDeki = COLUMN_TBL.SHORTIDO_DEKI;
				stvCol = COLUMN_TBL.SHORT_DEV;
				tergetStvH_1 = COLUMN_TBL.SHORT_1_H_SIGMA;
				tergetStvL_1 = COLUMN_TBL.SHORT_1_L_SIGMA;
				tergetStvH_2 = COLUMN_TBL.SHORT_2_H_SIGMA;
				tergetStvL_2 = COLUMN_TBL.SHORT_2_L_SIGMA;
				tergetStvH_3 = COLUMN_TBL.SHORT_3_H_SIGMA;
				tergetStvL_3 = COLUMN_TBL.SHORT_3_L_SIGMA;
				idoHeikin = COLUMN_TBL.SHORTIDO;
//				startTerm = startShortterm;
				ratio = 1;
				break;
			case typeMiddle:
//				targetBayBay = COLUMN_TBL.MIDDLEIDO_BAYBAY;
//				targetClose = COLUMN_TBL.MIDDLEIDO;
//				targetDeki = COLUMN_TBL.MIDDLEIDO_DEKI;
				stvCol = COLUMN_TBL.MIDDLE_DEV;
				tergetStvH_1 = COLUMN_TBL.MIDDLE_1_H_SIGMA;
				tergetStvL_1 = COLUMN_TBL.MIDDLE_1_L_SIGMA;
				tergetStvH_2 = COLUMN_TBL.MIDDLE_2_H_SIGMA;
				tergetStvL_2 = COLUMN_TBL.MIDDLE_2_L_SIGMA;
				tergetStvH_3 = COLUMN_TBL.MIDDLE_3_H_SIGMA;
				tergetStvL_3 = COLUMN_TBL.MIDDLE_3_L_SIGMA;
				idoHeikin = COLUMN_TBL.MIDDLEIDO;
//				startTerm = startMiddleterm;
				ratio = 2;
				break;
			case typeLong:
//				targetBayBay = COLUMN_TBL.LONGIDO_BAYBAY;
//				targetClose = COLUMN_TBL.LONGIDO;
//				targetDeki = COLUMN_TBL.LONGIDO_DEKI;
				stvCol = COLUMN_TBL.LONG_DEV;
				tergetStvH_1 = COLUMN_TBL.LONG_1_H_SIGMA;
				tergetStvL_1 = COLUMN_TBL.LONG_1_L_SIGMA;
				tergetStvH_2 = COLUMN_TBL.LONG_2_H_SIGMA;
				tergetStvL_2 = COLUMN_TBL.LONG_2_L_SIGMA;
				tergetStvH_3 = COLUMN_TBL.LONG_3_H_SIGMA;
				tergetStvL_3 = COLUMN_TBL.LONG_3_L_SIGMA;
				idoHeikin = COLUMN_TBL.LONGIDO;
//				startTerm = startLongterm;
				ratio = 3;
				break;
		default:
			break;
	}
//		//標準偏差を足したり引いたりしてボリバンを引く
		String upTBL = " select "
					 + COLUMN_TBL.CODE	+ " , "
					 + termCol			+ " , "
					 + 	stvCol			+ " , "
					 + 	tergetStvH_1	+ " , "
					 + 	tergetStvL_1	+ " , "
 					 + 	tergetStvH_2	+ " , "
	 				 + 	tergetStvL_2	+ " , "
		 			 + 	tergetStvH_3	+ " , "
			 		 + 	tergetStvL_3	+ "   "
					 + " from "
					 + thisTBL
					 + " where "
					 + SQL_CODE_WHERE
					 + " and "
					 + termCol + " = " + "'" + nowTerm + "'"
				 ;
		String upSQL  = " update "
				 	+ thisTBL + " as A"
				 	+ " left outer join "
				 	+ thisTBL + " as B"
				 	+ " on "
				 	+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
				 	+ " and "
				 	+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
				 	+ " set "
				 	+ "A." + tergetStvH_1 + " = " + "A." + idoHeikin + " + (" + "A." + stvCol + " * 1 )" + " , "
					+ "A." + tergetStvL_1 + " = " + "A." + idoHeikin + " - (" + "A." + stvCol + " * 1 )" + " , "
					+ "A." + tergetStvH_2 + " = " + "A." + idoHeikin + " + (" + "A." + stvCol + " * 2 )" + " , "
					+ "A." + tergetStvL_2 + " = " + "A." + idoHeikin + " - (" + "A." + stvCol + " * 2 )" + " , "
					+ "A." + tergetStvH_3 + " = " + "A." + idoHeikin + " + (" + "A." + stvCol + " * 3 )" + " , "
					+ "A." + tergetStvL_3 + " = " + "A." + idoHeikin + " - (" + "A." + stvCol + " * 3 )" + "   "
					+ " where "
					+ "A." + termCol + " = " + "'" + nowTerm + "'"
					+ " and "
					+ "A." + SQL_CODE_WHERE
					;;
					;
		if ( logFLG == false){
			commonAP.writeInLog("【ボリバン線引く】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(upSQL);

	}

	//売買高、出来高、終値の移動平均線を引く。ボリバン用の標準偏差の計算をする。
	private void closeDekiBayIDOheikinUpdate(int type,S s){
//		(MACDシグナル:(COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s,EDIT);)
		String upSQL;
		String baybay = COLUMN_TBL.BAYBAY;
		String close = COLUMN_TBL.CLOSE;
		String deki = COLUMN_TBL.DEKI;
		String MACD = "";
		String MACD_sig = "";

		String targetBayBay = "";
		String targetClose = "";
		String targetDeki = "";
		String targetStv = "";
		String startTerm = "";
		String endTerm = nowTerm;
		switch (type) {
			case typeShort:
				targetBayBay = COLUMN_TBL.SHORTIDO_BAYBAY;
				targetClose = COLUMN_TBL.SHORTIDO;
				targetDeki = COLUMN_TBL.SHORTIDO_DEKI;
				targetStv = COLUMN_TBL.SHORT_DEV;
				startTerm = startShortterm;
				MACD = COLUMN_TBL.SHORT_MACD;
				MACD_sig = COLUMN_TBL.SHORT_MACD_SIGNAL;
				break;
			case typeMiddle:
				targetBayBay = COLUMN_TBL.MIDDLEIDO_BAYBAY;
				targetClose = COLUMN_TBL.MIDDLEIDO;
				targetDeki = COLUMN_TBL.MIDDLEIDO_DEKI;
				targetStv = COLUMN_TBL.MIDDLE_DEV;
				startTerm = startMiddleterm;
				MACD = COLUMN_TBL.MIDDLE_MACD;
				MACD_sig = COLUMN_TBL.MIDDLE_MACD_SIGNAL;
				break;
			case typeLong:
				targetBayBay = COLUMN_TBL.LONGIDO_BAYBAY;
				targetClose = COLUMN_TBL.LONGIDO;
				targetDeki = COLUMN_TBL.LONGIDO_DEKI;
				targetStv = COLUMN_TBL.LONG_DEV;
				startTerm = startLongterm;
				MACD = COLUMN_TBL.LONG_MACD;
				MACD_sig = COLUMN_TBL.LONG_MACD_SIGNAL;
				break;
			default:
				break;
		}

		String A = "A";
		String aveBayBay = "B";
		String aveDeki = "C";
		String aveClose = "D";
		String stvClose = "E";
		String aveMACD = "F";
		String dummyNow = "dummyNow";

		String sansyoTBL = " ( "
						 			 + " select "
						 			 + COLUMN_TBL.CODE + " , ";
//		if (!(cate.equals(ReCord.CODE_04_ETF))){
			sansyoTBL	 = sansyoTBL + " avg(" + deki	 +  ")" + " as " + aveDeki   +  " , "
									 + " avg(" + baybay	 +  ")" + " as " + aveBayBay +  " , ";
//		}
//		sansyoTBL		 = sansyoTBL + " avg(" + close	 +  ")" + " as " + aveClose  +  " , "
//									 + "'" + nowTerm + "'"		+ " as " + dummyNow  +  " , "
//									 + " avg(" + MACD	 +  ")" + " as " + aveMACD  +  " , "
//									 + " STDDEV_SAMP(" + close	 +  ")" + " as " + stvClose  +  "   "
//									 + " from "
//									 + thisTBL + " "
//									 + fromWhereTermSQL(thisTBL, startTerm, endTerm, SQL_CODE_WHERE,termCol)
//									 + " group by " + thisTBL + "." + COLUMN_TBL.CODE
//									 + " ) " + " as " + A;

		sansyoTBL		 = sansyoTBL + " avg(" + close	 +  ")" + " as " + aveClose  +  " , "
						 + "'" + nowTerm + "'"		+ " as " + dummyNow  +  " , "
//						 + " avg(" + MACD	 +  ")" + " as " + aveMACD  +  " , "
						 + " STDDEV_SAMP(" + close	 +  ")" + " as " + stvClose  +  "   "
						 + " from "
						 + " ( "
						 + createUnionSQL(type, thisTBL)
						 + " ) as V"
						 + " group by V." + COLUMN_TBL.CODE
						 + " ) " + " as " + A;



		//ロング
		//ミドル
		//ショート
		upSQL = " update "
				+ thisTBL + " "
				+" left outer join "
				+ sansyoTBL
				+ " on "
				+ thisTBL + "." + COLUMN_TBL.CODE + " = " + A + "." + COLUMN_TBL.CODE	  + " "
				+ " and "
				+ thisTBL + "." + termCol		  + " = " + A + "." + dummyNow
				+ " set ";
//		if (!(cate.equals(ReCord.CODE_04_ETF))){
			upSQL = upSQL
				+ thisTBL + "." + targetBayBay	 + " = " + A + "." + aveBayBay	  + ","
				+ thisTBL + "." + targetDeki	 + " = " + A + "." + aveDeki	  + ",";
//		}

		upSQL = upSQL
				+ thisTBL + "." + targetClose	 + " = " + A + "." + aveClose	  + ","
//				+ thisTBL + "." + MACD_sig		 + " = " + A + "." + aveMACD	  + ","
				+ thisTBL + "." + targetStv		 + " = " + A + "." + stvClose	  + " "
				+ " where "
				+ thisTBL + "." + termCol + " = " + "'" + nowTerm + "'"
				+ " and "
				+ thisTBL + "." + SQL_CODE_WHERE
				;;

		if ( logFLG == false){
			commonAP.writeInLog("【売買高、出来高、終値の移動平均線を引く。ボリバン用の標準偏差の計算をする。：】" + upSQL,logWriting.DATEDATE_LOG_FLG);
		}
		s.freeUpdateQuery(upSQL);
	}

	//termUnitColはTBLに存在する期間列を参照する
	private String fromWhereTermSQL(String TBL,String startTerm,String endTerm,String codeWhere,String termUnitCol){
		String SQL	 = "  "
					 + " where "
					 + "'" + startTerm + "'" + " <= " + termUnitCol
					 + " and "
					 + termUnitCol + " <= " + "'" + endTerm + "' "
					 + " and "
					 + TBL + "." + codeWhere
					 ;

		return SQL;
	}

	//1:日足
	//2:週足
	//3:月足
	//select * from TBL where code and term = 個別日付 union select * from TBL where code and term = 個別日付をつくる
	private String createUnionSQL(int type,String TBL){
		ArrayList<String> thisList = new ArrayList<String>();


		String unionSQL = "";
		switch (type) {
			case typeShort:

				thisList = useListShort;
				break;
			case typeMiddle:

				thisList = useListMiddle;
				break;
			case typeLong:
				thisList = useListLong;
				break;
			default:
				break;
		}

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

	//checkFLGがtrueのとき個別銘柄
	//falseのとき複数銘柄
//	private String exitCode(String upTBL,boolean checkFLG,String cate){
//
//		switch (cate) {
//			case CATE_FLG.W_STOCK_F:
//				cate = ReCord.CODE_01_STOCK;
//				break;
//			case CATE_FLG.M_STOCK_F:
//				cate = ReCord.CODE_01_STOCK;
//				break;
//			default:
//				break;
//		}
//
//		String returnCode;
//		String EXISTSBBB = "EXISTSBBB";
//		String EXISTSTBL = "EXISTSTBL";
//		if (checkFLG){
//			//この中は個別銘柄
//			returnCode = upTBL + "." + COLUMN_TBL.CODE  + " = '" + code + "'"
//					  ;
//		}else{
//			//この中は全銘柄
////			EXISTS(SELECT B BB WHERE AA.id = BB.id);
//			returnCode = " EXISTS("
//							+ "SELECT "+ COLUMN_TBL.CODE + " as " + EXISTSBBB
//						  	+ " from "
//						  	+ TBL_Name.CODELISTTBL + " as " + EXISTSTBL
//						  	+ " where "
//						  	+ EXISTSTBL + "." + COLUMN_TBL.CODE + " = "+ upTBL + "." + COLUMN_TBL.CODE
//						  	+ " and "
//						  	+ EXISTSTBL + "." + COLUMN_TBL.CATE_FLG + " = '" + cate + "') ";
//		}
//
//		return returnCode;
//	}

}
