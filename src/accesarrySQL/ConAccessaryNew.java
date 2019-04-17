package accesarrySQL;

import proparty.S;
import proparty.TBL_Name;
import proparty.VIEW_Name;
import bean.Bean_calendarBean;
import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;

public class ConAccessaryNew {

	private String SQL_CODE_WHERE;
	private String code;

	private String nowTerm;
	private String beforeTerm;
	private String startLongterm;
	private String startMiddleterm;
	private String startShortterm;

	private String cate;
	private String thisTBL;
	//コンストラクタ、全銘柄
	public ConAccessaryNew(String cate){
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " in "
				  + " ( "
				  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
				  	+ " from "
				  	+ TBL_Name.CODELISTTBL
				  	+ " where "
				  	+ COLUMN_TBL.CATE_FLG + " = '" + cate + "'"
				  + " ) ";
		this.cate = cate;
	}
	public ConAccessaryNew(String cate,String code){
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " = '" + code + "'"
				  ;
		this.code = code;
		this.cate = cate;

	}

	private void setParameta(Bean_calendarBean calBean,String cate){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		//週足個別銘柄・・・7
		//月足個別銘柄・・・8
		switch(cate){
		case ReCord.CODE_01_STOCK:
			thisTBL = TBL_Name.STOCK_DD;
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			
			break;

		case ReCord.CODE_02_SATISTICS:
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			break;

		case ReCord.CODE_03_INDEX:
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			break;

		case ReCord.CODE_04_ETF:
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			break;

		case ReCord.CODE_05_SAKIMONO:
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			break;

		case ReCord.CODE_06_CURRENCY:
			nowTerm			= calBean.getDAYTIME();
			beforeTerm		= calBean.getDAYTIME_BEFORE();
			startLongterm 	= calBean.getDAYTIME_LONG_BEFORE();;
			startMiddleterm	= calBean.getDAYTIME_MIDDLE_BEFORE();;
			startShortterm	= calBean.getDAYTIME_SHORT_BEFORE();;
			break;
		case CATE_FLG.W_STOCK_F:
			thisTBL = VIEW_Name.STOCK_WW_REAL_TIME;
			nowTerm			= calBean.getWEEK_NOW();
			beforeTerm		= calBean.getWEEK_BEFORE();
			startLongterm 	= calBean.getWEEK_LONG_BEFORE();;
			startMiddleterm	= calBean.getWEEK_MIDDLE_BEFORE();;
			startShortterm	= calBean.getWEEK_SHORT_BEFORE();;
			break;
		case CATE_FLG.M_STOCK_F:
			thisTBL = VIEW_Name.STOCK_MM_REAL_TIME;
			nowTerm			= calBean.getMONTH_NOW();
			beforeTerm		= calBean.getMONTH_BEFORE();
			startLongterm 	= calBean.getMONTH_LONG_BEFORE();;
			startMiddleterm	= calBean.getMONTH_MIDDLE_BEFORE();;
			startShortterm	= calBean.getMONTH_SHORT_BEFORE();;
			break;
		default:
			System.out.println("ConAccessaryNewなんかよくわからないの来た：" + cate + ":" + cate);
			break;
		}
	}


	public void setConAccessary(String TODAY){
		S s = new S();
		s.getCon();
		Bean_calendarBean calBean = new Bean_calendarBean();
		calBean.setCalendarBean(TODAY, s);
		String yesterday = calBean.getDAYTIME_BEFORE();
		setParameta(calBean,cate);
		
		
		
		//売買高、出来高、終値で移動平均線を引く。
		//ロング
		//ミドル
		//ショート

		//終値をもとにボリンジャーバンドを引く
		
		
		//平滑指数移動平均線を引く。
		
		//※平滑指数移動平均線をもとにMACDを引く。

		//MACDシグナル（必ずMACDのあとに引く）
		
		
		//各テーブルの前日比、窓
		s.closeConection();

	}
	
	private String fromWhereTermSQL(String TBL,String startTerm,String endTerm,String codeWhere,String termUnitCol){
		String SQL	 = " from " + TBL
					 + " where " ;
		
		return SQL;
	}
}
