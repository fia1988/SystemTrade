package makeWeekMonthTBL;

import proparty.S;
import proparty.TBL_Name;
import accesarrySQL.ConAccessaryNew;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;





public class makeWeekMonthCon {



	private String SQL_CODE_WHERE;
	private String fromTBL = TBL_Name.STOCK_DD;
	private String stkDD = TBL_Name.STOCK_DD;
	private String checkCol = "";
	private boolean resultCheck = false;
	private String yesterDay = "";
	private String TBL = "";

	private String TODAY = "";
	private String nowTerm = "";
	private String nowTerm_before = "";
	private String nowTerm_col = "";
	private String nowTerm_before_col = "";
	private String w_mLetter = "";
	private String code="";
	private boolean sepaConFLG = false;

	//コンストラクタ、全銘柄
	public makeWeekMonthCon(){
		sepaConFLG = false;
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " in "
				  + " ( "
				  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
				  	+ " from "
				  	+ TBL_Name.CODELISTTBL
				  	+ " where "
				  	+ COLUMN_TBL.CATE_FLG + " = '" + ReCord.CODE_01_STOCK + "'"
				  + " ) ";

	}

	//コンストラクタ、個別銘柄
	public makeWeekMonthCon(String code){
		sepaConFLG = true;
		SQL_CODE_WHERE = COLUMN_TBL.CODE
				  + " = '" + code + "'"
				  ;
		this.code = code;
	}

	public void zikken(){
		System.out.println("sepaConFLG:" + sepaConFLG);
		System.out.println("SQL_CODE_WHERE:" + SQL_CODE_WHERE);
	}

	private void setParameta(String cate,Bean_calendarBean calBean){
		yesterDay = "'" + calBean.getDAYTIME_BEFORE() + "'";
		TODAY = "'" + calBean.getDAYTIME() + "'";
		switch (cate) {
			case CATE_FLG.M_STOCK_F:
				w_mLetter = "月";
				resultCheck = calBean.getMONTH_CHANGE_FLG();
				TBL = TBL_Name.STOCK_MM_REAL_TIME;
				nowTerm = "'" + calBean.getMONTH_NOW() + "'";
				nowTerm_col = COLUMN_TBL.MONTH_NOW;
				nowTerm_before_col = COLUMN_TBL.MONTH_BEFORE;
				if ( calBean.getMONTH_BEFORE() != null){
					nowTerm_before =  "'" + calBean.getMONTH_BEFORE() + "'";
				}
				break;
			case CATE_FLG.W_STOCK_F:
				resultCheck = calBean.getWEEK_CHANGE_FLG();
				w_mLetter = "週";
				TBL = TBL_Name.STOCK_WW_REAL_TIME;
				nowTerm = "'" + calBean.getWEEK_NOW() + "'";
				nowTerm_col = COLUMN_TBL.WEEK_NOW;
				nowTerm_before_col = COLUMN_TBL.WEEK_BEFORE;
				if (calBean.getWEEK_BEFORE() != null){
					nowTerm_before = "'" + calBean.getWEEK_BEFORE() + "'";
				}

				break;
			case CATE_FLG.M_MARKET_F:
				w_mLetter = "月";
				resultCheck = calBean.getMONTH_CHANGE_FLG();
				TBL = TBL_Name.MARKET_MM_REAL_TIME_TBL;
				nowTerm = "'" + calBean.getMONTH_NOW() + "'";
				nowTerm_col = COLUMN_TBL.MONTH_NOW;
				nowTerm_before_col = COLUMN_TBL.MONTH_BEFORE;
				if ( calBean.getMONTH_BEFORE() != null){
					nowTerm_before =  "'" + calBean.getMONTH_BEFORE() + "'";
				}
				break;
			case CATE_FLG.W_MARKET_F:
				resultCheck = calBean.getWEEK_CHANGE_FLG();
				w_mLetter = "週";
				TBL = TBL_Name.MARKET_WW_REAL_TIME_TBL;
				nowTerm = "'" + calBean.getWEEK_NOW() + "'";
				nowTerm_col = COLUMN_TBL.WEEK_NOW;
				nowTerm_before_col = COLUMN_TBL.WEEK_BEFORE;
				if (calBean.getWEEK_BEFORE() != null){
					nowTerm_before = "'" + calBean.getWEEK_BEFORE() + "'";
				}

				break;
			default:
				break;
		}
	}

	public void createWeekMonth(String TODAY,S s) {

		boolean testcord = false;
		//まだ動かしたくないからダミーをセットして動きをとめる
		if (testcord == false){
			return;
		}

		Bean_calendarBean calBean = new Bean_calendarBean();
		calBean.setCalendarBean(TODAY, s);

		//個別銘柄の時は処理しない
		if (sepaConFLG==false){
			//前営業日が月/週の最終営業日でなければピックアップフラグをfalseにする。
			checkEndTerm(CATE_FLG.W_STOCK_F,calBean,s);
			checkEndTerm(CATE_FLG.M_STOCK_F,calBean,s);
			//日足から月/週足に銘柄名、日付、始値(仮)、高値、安値、終値、売買高、出来高、ナウ、BEFOREをつくる。
			checkBaseW_M(CATE_FLG.W_STOCK_F,calBean,s);
			checkBaseW_M(CATE_FLG.M_STOCK_F,calBean,s);
		}



		//月/週足の銘柄名、日付、始値(仮)、高値、安値、終値、売買高、出来高正しく加工するつくる。
		updateCol(CATE_FLG.W_STOCK_F,calBean,s);
		updateCol(CATE_FLG.M_STOCK_F,calBean,s);

//		//始値をつくる
		updateStart(CATE_FLG.W_STOCK_F,calBean,s);
		updateStart(CATE_FLG.M_STOCK_F,calBean,s);


		//アクセサリを作る
		ConAccessaryNew ac = new ConAccessaryNew(CATE_FLG.M_STOCK_F);
		ac.setConAccessary(calBean,s);
		ac = new ConAccessaryNew(CATE_FLG.W_STOCK_F);
		ac.setConAccessary(calBean,s);

		//全銘柄のアクセサリ、マーケットテーブルを作る、日付と現在株価の相関係数をもとめる、capmを作る。。
		if (sepaConFLG==false){
			commonAP.writeInLog("ここからマーケットの月足週足を作る",logWriting.DATEDATE_LOG_FLG);
			//マーケットテーブル：1306
			String nowSQL = SQL_CODE_WHERE;
			String nowTBL = fromTBL;
			String nowstkDD = stkDD;

			stkDD = TBL_Name.MARKET_DD_TBL;
			fromTBL = TBL_Name.MARKET_DD_TBL;
			SQL_CODE_WHERE = COLUMN_TBL.CODE  + " = '" + ReCord.MARKET_CODE_1306 + "'";

			//前営業日が月/週の最終営業日でなければピックアップフラグをfalseにする。
			checkEndTerm(CATE_FLG.W_MARKET_F,calBean,s);
			checkEndTerm(CATE_FLG.M_MARKET_F,calBean,s);
			//日足から月/週足に銘柄名、日付、始値(仮)、高値、安値、終値、売買高、出来高、ナウ、BEFOREをつくる。
			checkBaseW_M(CATE_FLG.W_MARKET_F,calBean,s);
			checkBaseW_M(CATE_FLG.M_MARKET_F,calBean,s);
			//マーケットの始値以外とか作る
			//月/週足の銘柄名、日付、始値(仮)、高値、安値、終値、売買高、出来高正しく加工するつくる。
			updateCol(CATE_FLG.W_MARKET_F,calBean,s);
			updateCol(CATE_FLG.M_MARKET_F,calBean,s);
			//マーケットの始値
			updateStart(CATE_FLG.W_MARKET_F,calBean,s);
			updateStart(CATE_FLG.M_MARKET_F,calBean,s);

			//マーケットのアクセサリ
			ac = new ConAccessaryNew(CATE_FLG.M_MARKET_F,ReCord.MARKET_CODE_1306);
			ac.setConAccessary(calBean,s);
			ac = new ConAccessaryNew(CATE_FLG.W_MARKET_F,ReCord.MARKET_CODE_1306);
			ac.setConAccessary(calBean,s);

			//CAPM


			//元に戻す
			SQL_CODE_WHERE = nowSQL;
			fromTBL = nowTBL;
			stkDD = nowstkDD;
			commonAP.writeInLog("ここまでマーケットの月足週足。無事終了",logWriting.DATEDATE_LOG_FLG);
		}else{
			//個別銘柄のアクセサリ

		}

	}



	//始値をつくる
	private void updateStart(String cate,Bean_calendarBean calBean,S s){
		setParameta(cate, calBean);

		//resultCheckがtrueの時は月/週のスタートなので処理しない。
		//true=週/月の始まりなので前営業日が週/月の最終日になるので編集しなくてもよい。
		if ( resultCheck ){
			return;
		}

		String SQL;

		SQL = " update "
				+ TBL		 + " as A  "
				+ " left outer join "
				+ TBL		 + " as B  "
				+ " on "
				+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE
				+ " set "
				+ "A." + COLUMN_TBL.OPEN + " = " + "B." + COLUMN_TBL.OPEN
				+ " where "
				+ "A." + COLUMN_TBL.DAYTIME + " = " + TODAY
				+ " and "
				+ "B." + COLUMN_TBL.DAYTIME + " = " + yesterDay
				+ " and "
				+ "A." + SQL_CODE_WHERE;

			commonAP.writeInLog("updateStart:" + w_mLetter + "足の各列の始値作成：" + SQL,logWriting.DATEDATE_LOG_FLG);

			s.freeUpdateQuery(SQL);
	}
	//始値以外の列を作る(高値、安値、出来高、売買高、ピックアップフラグ(=true))
	private void updateCol(String cate,Bean_calendarBean calBean,S s){


		setParameta(cate, calBean);


//		始値以外の列を作る(高値、安値、出来高、売買高
		String SQL;

//		String STOCK_DD = TBL_Name.STOCK_DD;
		String maxTBL	 = "A";
		String minTBL	 = "B";
		String dekTBL	 = "C";
		String bayTBL = "D";

		String maxCol	 = "maxCol";
		String minCol	 = "minCol";
		String dekCol	 = "dekiCol";
		String bayCol = "baybayCol";
		String codeCol = "codeCol";

		String selectColCode = 			stkDD + "." + COLUMN_TBL.CODE +  " as " + codeCol;
		String selectColMax = "max(" + 	stkDD + "." + COLUMN_TBL.MAX	  + ") as " + maxCol;
		String selectColMin = "min(" + 	stkDD + "." + COLUMN_TBL.MIN	  + ") as " + minCol;
		String selectColDek = "sum(" + 	stkDD + "." + COLUMN_TBL.DEKI  + ") as " + dekCol;
		String selectColBay = "sum(" + 	stkDD + "." + COLUMN_TBL.BAYBAY + ") as " + bayCol;

		String leftJoin  = " left outer join " + TBL + " on "
							+ stkDD + "." + COLUMN_TBL.CODE + " = " + TBL  + "." + COLUMN_TBL.CODE
							+ " and "
							+ stkDD + "." + COLUMN_TBL.DAYTIME + " = " + TBL  + "." + COLUMN_TBL.DAYTIME;;
		String groupBy   = " group by " + stkDD + "." + COLUMN_TBL.CODE;

		String fromTBL  = " from " + stkDD  + leftJoin + " where " + stkDD + "." + COLUMN_TBL.DAYTIME + " <= " + TODAY + " and " + nowTerm_col + " = " + nowTerm + " and " + stkDD + "." +  SQL_CODE_WHERE + groupBy + "  ";

		String dummyT = "dummyT";
		String dummyTBL = " ( "
						+ " select "
						+ selectColCode + "," + selectColMax + "," + selectColMin + "," + selectColDek + "," + selectColBay
						+ fromTBL
						+ " ) as " + dummyT;
//		System.out.println("a:" + dummyTBL);

		SQL = " update "
			+ TBL		 + " , "
			+ dummyTBL	 + "   "
			+ " set "
			+ TBL + "." + COLUMN_TBL.MAX		 + " = " + dummyT	 + "."  + maxCol	 +  " , "
			+ TBL + "." + COLUMN_TBL.MIN		 + " = " + dummyT	 + "."  + minCol	 +  " , "
			+ TBL + "." + COLUMN_TBL.DEKI		 + " = " + dummyT	 + "."  + dekCol	 +  " , "
			+ TBL + "." + COLUMN_TBL.BAYBAY		 + " = " + dummyT + "."  + bayCol	 +  "   "
			+ " where "
			+ TBL + "." + COLUMN_TBL.DAYTIME + " = " + TODAY
			+ " and "
			+ TBL + "." + SQL_CODE_WHERE
			+ " and "
			+ TBL + "." + COLUMN_TBL.CODE + " = " + dummyT + "." + codeCol;

		commonAP.writeInLog("updateCol:" + w_mLetter + "足の各列のリアルタイム基本情報作成：" + SQL,logWriting.DATEDATE_LOG_FLG);

		s.freeUpdateQuery(SQL);
	}


	//日足から月/週足に銘柄名、日付、始値(仮)、高値、安値、終値、売買高、出来高、ナウ、BEFOREをつくる。
	private void checkBaseW_M(String cate,Bean_calendarBean calBean,S s){

		setParameta(cate, calBean);


		String col =  COLUMN_TBL.CODE	 + " , "
					+ COLUMN_TBL.DAYTIME + " , "
					+ COLUMN_TBL.OPEN	 + " , "
					+ COLUMN_TBL.MAX	 + " , "
					+ COLUMN_TBL.MIN	 + " , "
					+ COLUMN_TBL.DEKI	 + " , "
					+ COLUMN_TBL.BAYBAY	 + " , "
					+ COLUMN_TBL.CLOSE;
		String selectSQL;
		selectSQL = " select "
				  + col
				  + " from " + fromTBL
				  + " where "
				  + COLUMN_TBL.DAYTIME + " = " + TODAY
				  + " and "
				  + SQL_CODE_WHERE;

		String insSQL;
		insSQL = "insert into "
				+ TBL
				+ " ( "
				+ col
				+ ")"
				+ selectSQL;

		commonAP.writeInLog("checkBaseW_M:" + w_mLetter + "足の銘柄名、本日日付、終値作成：" + insSQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(insSQL);

		String updateSQL;
		updateSQL = " update " + TBL
					+ " set "
					+ nowTerm_col		 + " = " + nowTerm +  " , "
					+ nowTerm_before_col + " = " + nowTerm_before +  "   "
					+ " where "
					+ COLUMN_TBL.DAYTIME + " = " + TODAY
					+ " and "
					  + SQL_CODE_WHERE;
		commonAP.writeInLog("checkBaseW_M:" + w_mLetter + "足のナウとBEFORE設定：" + updateSQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(updateSQL);
	}

	//前営業日が月/週の最終営業日でなければピックアップフラグをfalseにする。
	private boolean checkEndTerm(String cate,Bean_calendarBean calBean,S s){
		boolean thisResult = true;


		setParameta(cate, calBean);

		//true処理終了
		//true=週/月の始まりなので前営業日が週/月の最終日になるので編集しなくてもよい。
		//ピックアップフラグは基本trueで作成されて前営業日をひたすらfalseに変えていく。
		if (resultCheck == true){
			return thisResult;
		}

		if(yesterDay.equals("null")){
			thisResult = false;
			return thisResult;
		}

		String SQL;
		SQL = " update "
			+ TBL
			+ " set "
			+ COLUMN_TBL.PICK_UP_FLG + " = false"
			+ " where "
			+ COLUMN_TBL.DAYTIME + " = " + yesterDay
			+ " and "
			  + SQL_CODE_WHERE;
		commonAP.writeInLog("checkEndTerm:" + w_mLetter + "足のピックアップチェック："+SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		return thisResult;
	}


}
