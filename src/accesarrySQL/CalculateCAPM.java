package accesarrySQL;

import java.util.ArrayList;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.AccesarryParameta;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;

public class CalculateCAPM {

	String SQL_CODE_WHERE = COLUMN_TBL.CODE
			  + " in "
			  + " ( "
			  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
			  	+ " from "
			  	+ TBL_Name.CODELISTTBL
			  + " ) ";

	private String createUnionSQL(ArrayList<String> thisList,String TBL){
		String unionSQL = "";

		String cate = ReCord.CODE_01_STOCK;

		String thisSQL_CODE_WHERE = COLUMN_TBL.CODE
		  + " in "
		  + " ( "
		  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
		  	+ " from "
		  	+ TBL_Name.CODELISTTBL
		  	+ " where "
		  	+ COLUMN_TBL.CATE_FLG + " = '" + cate + "'"
		  + " ) ";

		if (thisList.size()==1){
			unionSQL = " select * from " + TBL +" where " + TBL + "." + thisSQL_CODE_WHERE + " and " + COLUMN_TBL.DAYTIME + " = '" + thisList.get(0) + "'";
		}else{

			for (String term:thisList){
				unionSQL = unionSQL + " select * from " + TBL + " where " + TBL + "." + thisSQL_CODE_WHERE + " and "  + COLUMN_TBL.DAYTIME + " = '" + term + "'" + " UNION ALL ";
			}
//			+第一引数：刈り取り対象文字列（テキスト）
//			+第二引数：刈り取る文字
			unionSQL = commonAP.stripEnd(unionSQL," UNION ALL ");
		}
		return unionSQL;
	}

	public void calculateCAPM_MARLET_TBL(String TODAY,String beforeDay, int term,String TBL){
//		String TBL = TBL_Name.MARKET_DD_TBL;
		S s = new S();
		s.getCon();

		String SQL="";


		//NT倍率の計算
		SQL = " update "
				+ TBL_Name.ETF_DD				 + " as A ,"
				+ TBL							 + " as B "
			+ " set "
				+ " B." + COLUMN_TBL.NT_RATIO
				+ " = "
				+ " A." + COLUMN_TBL.CLOSE + " / " + " B." + COLUMN_TBL.CLOSE
			+ " where "
					+ " B." + COLUMN_TBL.CODE + " = " + "'" + ReCord.MARKET_CODE_1306 + "'"
				+ " and "
					+ " A." + COLUMN_TBL.CODE + " = " + "'" + ReCord.NIKKEI225_CODE_1321 + "'"
				+ " and "
					+ " B." + COLUMN_TBL.DAYTIME
					+ " = "
					+ " A." + COLUMN_TBL.DAYTIME
				+ " and "
					+ " A." + COLUMN_TBL.DAYTIME + " = " + "'" + TODAY + "'";
		commonAP.writeInLog(TBL + "NT倍率の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//標準偏差の計算、リターンの計算
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",true);
//		commonAP.writeInLog(TBL + "リターンの計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",true);
//		commonAP.writeInLog(TBL + "の標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
		SQL = calculateSQL_2(TBL,TODAY,beforeDay,COLUMN_TBL.MARKET_RETURN_FOR_BETA,COLUMN_TBL.CHANGERATE,"avg",COLUMN_TBL.MARKET_RISK_FOR_BETA,COLUMN_TBL.CHANGERATE,"STDDEV_SAMP",true,"");
		commonAP.writeInLog(TBL + "のリターン、標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN_TBL.MARKET_RETURN_FOR_BETA,TODAY,s);
		persentUpdate(TBL,COLUMN_TBL.MARKET_RISK_FOR_BETA,TODAY,s);


//		+ COLUMN.MARKET_RISK_PREMIUM_KATA					 + " , "
//		//分散、リスクフリーレート計算
		//リスクフリーレートは0.8/245%とする。
		SQL = " update " + TBL
			+ " set "
			+ COLUMN_TBL.MARKET_RISK_Squaring_FOR_BETA + " = " + COLUMN_TBL.MARKET_RISK_FOR_BETA + " * " + COLUMN_TBL.MARKET_RISK_FOR_BETA + " , "
			+ COLUMN_TBL.RISK_FREE_RATE + " = " + AccesarryParameta.RISK_FREE_RATE
			+ " where "
			+ COLUMN_TBL.DAYTIME + " = "+ "'" +  TODAY + "'"
			+ " and "
			+ COLUMN_TBL.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog(TBL + "の分散、リスクフリーレート計算(" + AccesarryParameta.RISK_FREE_RATE + ")：" + SQL,logWriting.DATEDATE_LOG_FLG);

		s.freeUpdateQuery(SQL);
		//マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）
		SQL = " update " + TBL
				+ " set "
				+ COLUMN_TBL.MARKET_RISK_PREMIUM + " = " + COLUMN_TBL.MARKET_RETURN_FOR_BETA + " - " + COLUMN_TBL.RISK_FREE_RATE + "  "
				+ " where "
				+ COLUMN_TBL.DAYTIME + " = "+ "'" +  TODAY + "'"
				+ " and "
				+ COLUMN_TBL.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog(TBL + "マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		//標準偏差平均、リターンの平均、マーケットリスクプレミアムの平均
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA_AVE,COLUMN.MARKET_RETURN_FOR_BETA,"avg",true);
//		commonAP.writeInLog(TBL + "リターンの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_FOR_BETA_AVE,COLUMN.MARKET_RISK_FOR_BETA,"avg",true);
//		commonAP.writeInLog(TBL + "標準偏差平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_PREMIUM_AVE,COLUMN.MARKET_RISK_PREMIUM,"avg",true);
//		commonAP.writeInLog(TBL + "マーケットリスクプレミアムの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.NT_RATIO_AVE,COLUMN.NT_RATIO,"avg",true);
//		commonAP.writeInLog(TBL + "NT倍率の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
		SQL = calculateSQL_4(TBL,TODAY,beforeDay,
				COLUMN_TBL.MARKET_RETURN_FOR_BETA_AVE,COLUMN_TBL.MARKET_RETURN_FOR_BETA,"avg",
				COLUMN_TBL.MARKET_RISK_FOR_BETA_AVE,COLUMN_TBL.MARKET_RISK_FOR_BETA,"avg",
				COLUMN_TBL.MARKET_RISK_PREMIUM_AVE,COLUMN_TBL.MARKET_RISK_PREMIUM,"avg",
				COLUMN_TBL.NT_RATIO_AVE,COLUMN_TBL.NT_RATIO,"avg",
				true,"");
		commonAP.writeInLog(TBL + "リターンの平均、標準偏差平均、マーケットリスクプレミアムの更新、NT倍率の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		s.closeConection();
	}




	public void calculateCAPM_STOCK_TBL(String TODAY,String beforeDay, int term,String TBL){
//		String TBL = TBL_Name.STOCK_DD;
		String dummyCOLUMN_A = "dummyCOLUMN_A";
		String dummyCOLUMN_B = "dummyCOLUMN_B";
		String dummyCOLUMN_C = "dummyCOLUMN_C";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		S s = new S();
		s.getCon();

		//ユニオンのためのセレクトを作る
		Bean_calendarBean calBean = new Bean_calendarBean();
		calBean.setDayList(TODAY,term, s);
		String unionSQL = createUnionSQL(calBean.getDayList(),TBL);

		String SQL="";

		int rate =  AccesarryParameta.MARKET_OBSERVATION_TERM;

		//以下２つはまだ
//		+ COLUMN.WACC_KATA							 + " , " //WACC
//		+ COLUMN.WACC_AVE_KATA							 + " , " //WACC_AVE




		//配当のセット。単位はパーセント。
		SQL = " update "
				+ TBL_Name.INVEST_SIHYO_DD_TBL	 + " as A ,"
				+ TBL							 + " as B "
			+ " set "
				+ " B." + COLUMN_TBL.DIVIDEND_PER
				+ " = "
				+ " (A." + COLUMN_TBL.DIVIDEND_PER + "/" + rate + ") "
			+ " where "
					+ " B." + COLUMN_TBL.CODE
					+ " = "
					+ " A." + COLUMN_TBL.CODE
				+ " and "
					+ " B." + COLUMN_TBL.DAYTIME
					+ " = "
					+ " A." + COLUMN_TBL.DAYTIME
				+ " and "
					+ " A." + COLUMN_TBL.DAYTIME
					+ " = " + "'" + TODAY + "'";
		commonAP.writeInLog(TBL + "配当のセット。ただしこれは日単位にアジャストする（245で割る）：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		//標準偏差の計算、リターンの計算
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",false);
//		commonAP.writeInLog(TBL + "リターンの計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);

//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",false);
//		commonAP.writeInLog(TBL + "の標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);

		SQL = calculateSQL_2(TBL,TODAY,beforeDay,COLUMN_TBL.RETURN_FOR_BETA,COLUMN_TBL.CHANGERATE,"avg",COLUMN_TBL.RISK_FOR_BETA,COLUMN_TBL.CHANGERATE,"STDDEV_SAMP",false,unionSQL);
		commonAP.writeInLog(TBL + "リターン、標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN_TBL.RETURN_FOR_BETA,TODAY,s);
		persentUpdate(TBL,COLUMN_TBL.RISK_FOR_BETA,TODAY,s);

		//分散の計算
		SQL = " update "
			+ TBL + " as A "
			+ " left outer join "
			+ TBL + " as B "
			+ " on "
		 	+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
		 	+ " and "
		 	+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
			+ " set "
			+ "A."+ COLUMN_TBL.RISK_Squaring_FOR_BETA + " = "+ "A." + COLUMN_TBL.RISK_FOR_BETA + " * "+ "A." + COLUMN_TBL.RISK_FOR_BETA + "  "
			+ " where "
			+ "A." + SQL_CODE_WHERE
			+ " and "
			+ "A."+ COLUMN_TBL.DAYTIME + " = "+ "'" +  TODAY + "'";
		commonAP.writeInLog(TBL + "の分散：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//個別銘柄リターンとTOPIXリターンの共分散相関係数、ベータ、CAPM、ベータの確実性を求める
		calculateCAPM_STOCK_TBL_createTMP_TBL(TODAY,beforeDay,s);

//		//標準偏差平均、過去データの基づく理論上リターンの平均、CAPMの平均、ベータの平均
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.RETURN_FOR_BETA_AVE,COLUMN.RETURN_FOR_BETA,"avg",false);
//		commonAP.writeInLog(TBL + "リターンの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.RISK_FOR_BETA_AVE,COLUMN.RISK_FOR_BETA,"avg",false);
//		commonAP.writeInLog(TBL + "標準偏差平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.CAPM_AVE,COLUMN.CAPM,"avg",false);
//		commonAP.writeInLog(TBL + "CAPMの平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.Certainty_FOR_BETA_AVE,COLUMN.Certainty_FOR_BETA,"avg",false);
//		commonAP.writeInLog(TBL + "確実性の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);

		SQL = calculateSQL_4(TBL,TODAY,beforeDay,
				COLUMN_TBL.RETURN_FOR_BETA_AVE,COLUMN_TBL.RETURN_FOR_BETA,"avg",
				COLUMN_TBL.RISK_FOR_BETA_AVE,COLUMN_TBL.RISK_FOR_BETA,"avg",
				COLUMN_TBL.CAPM_AVE,COLUMN_TBL.CAPM,"avg",
				COLUMN_TBL.Certainty_FOR_BETA_AVE,COLUMN_TBL.Certainty_FOR_BETA,"avg",
				false,
				unionSQL);
		commonAP.writeInLog(TBL + "リターン、標準偏差、CAPM、確実性の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		s.closeConection();
	}




	//個別銘柄リターンとTOPIXリターンの共分散相関係数、ベータ、CAPM、ベータの確実性を求める
	private void calculateCAPM_STOCK_TBL_createTMP_TBL(String TODAY,String beforeDay,S s){
		//共分散の計算
		String stockTBL = TBL_Name.STOCK_DD;
		String marketTBL = TBL_Name.MARKET_DD_TBL;
		String unionTBL = "unionTBL";
//		update 01_stock_dd a , 07_marketTBL_DD b ,  ( select 01_stock_dd.code, ( avg(01_stock_dd.RETURN_FOR_BETA * 07_marketTBL_DD.MARKET_RETURN_FOR_BETA) - avg(01_stock_dd.RETURN_FOR_BETA) * avg(07_marketTBL_DD.MARKET_RETURN_FOR_BETA) )  as dummycolumn  from  07_marketTBL_DD left outer join  01_stock_dd on  07_marketTBL_DD.daytime = 01_stock_dd.daytime where  07_marketTBL_DD.daytime <= '2007-12-28' and 07_marketTBL_DD.daytime >= '2007-01-04' group by 01_stock_dd.code ) c set a.COVAR_with_TOPIX =  c.dummycolumn where a.daytime = '2007-12-28' and a.code = c.code ;
//       where a.daytime = '2007-12-28' and a.code = c.code ;
		String SQL = " ";
		SQL = " update " + stockTBL + " a , " + marketTBL + " b , "
				+ " ( "
					+ " select " + stockTBL + "." + COLUMN_TBL.CODE + " , "
						+ " ( "
							+ " avg(" + stockTBL + "." + COLUMN_TBL.RETURN_FOR_BETA + " * " + marketTBL + "." + COLUMN_TBL.MARKET_RETURN_FOR_BETA + ")"
								+ " - "
							+ " avg(" + stockTBL + "." + COLUMN_TBL.RETURN_FOR_BETA + ") * avg(" + marketTBL + "." + COLUMN_TBL.MARKET_RETURN_FOR_BETA + ")"
						+ " )  as dummycolumn "
					+ " from " + marketTBL + " left outer join " + stockTBL + " on " + stockTBL + "." + COLUMN_TBL.DAYTIME + " = " + marketTBL + "." + COLUMN_TBL.DAYTIME
					+ " where "
						+ stockTBL + "." + SQL_CODE_WHERE
						+ " and "
						+ marketTBL + "." + COLUMN_TBL.DAYTIME + " <= '" + TODAY + "'"
						+ " and "
						+ marketTBL + "." + COLUMN_TBL.DAYTIME + " >= '" + beforeDay + "'"
					+ " group by " + stockTBL + "." + COLUMN_TBL.CODE
				+ " ) c "
			+ " set "
				+ " a." + COLUMN_TBL.COVAR_with_TOPIX + " = "
				+ " c.dummycolumn "
			+ " where "
				+ " a." + COLUMN_TBL.CODE + " = "+ " c." + COLUMN_TBL.CODE
				+ " and "
				+ " a." + COLUMN_TBL.DAYTIME + " = '" + TODAY + "'";


//		//改善案
//		SQL = " update " + stockTBL + " a , " + marketTBL + " b , "
//				+ " ( "
//					+ " select " + stockTBL + "." + COLUMN_TBL.CODE + " , "
//						+ " ( "
//							+ " avg(" + stockTBL + "." + COLUMN_TBL.RETURN_FOR_BETA + " * " + marketTBL + "." + COLUMN_TBL.MARKET_RETURN_FOR_BETA + ")"
//								+ " - "
//							+ " avg(" + stockTBL + "." + COLUMN_TBL.RETURN_FOR_BETA + ") * avg(" + marketTBL + "." + COLUMN_TBL.MARKET_RETURN_FOR_BETA + ")"
//						+ " )  as dummycolumn "
//					+ " from "
//						+ marketTBL + " left outer join " + stockTBL + " on " + stockTBL + "." + COLUMN_TBL.DAYTIME + " = " + marketTBL + "." + COLUMN_TBL.DAYTIME
//						+ " ( "
//						+ unionSQL
//						+ " ) as " + unionTBL
//						+ " group by " + unionTBL + "." + COLUMN_TBL.CODE
//				+ " ) c "
//			+ " set "
//				+ " a." + COLUMN_TBL.COVAR_with_TOPIX + " = "
//				+ " c.dummycolumn "
//			+ " where "
//				+ " a." + COLUMN_TBL.CODE + " = "+ " c." + COLUMN_TBL.CODE
//				+ " and "
//				+ " a." + COLUMN_TBL.DAYTIME + " = '" + TODAY + "'";

		commonAP.writeInLog("共分散の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		//ベータ、ベータの確実度
		SQL = " update "
				+ stockTBL	 + " as A ,"
				+ marketTBL	 + " as B "
			+ " set "
				+ " A." + COLUMN_TBL.BETA
				+ " = "
				+ " (A." + COLUMN_TBL.COVAR_with_TOPIX + " / " + " B." + COLUMN_TBL.MARKET_RISK_Squaring_FOR_BETA + " ) , "
				+ " A." + COLUMN_TBL.Certainty_FOR_BETA
				+ " = "
				+ " (A." + COLUMN_TBL.COVAR_with_TOPIX + " / ( " + " B." + COLUMN_TBL.MARKET_RISK_FOR_BETA + " * A." + COLUMN_TBL.RISK_FOR_BETA + " ) )  "
			+ " where "
					+ "A." + SQL_CODE_WHERE
				+ " and "
					+ " B." + COLUMN_TBL.DAYTIME
					+ " = "
					+ " A." + COLUMN_TBL.DAYTIME
				+ " and "
					+ " A." + COLUMN_TBL.DAYTIME
					+ " = " + "'" + TODAY + "'";
		commonAP.writeInLog(stockTBL + "のベータとベータの確実度セット：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//CAPM
		SQL = " update "
				+ stockTBL	 + " as A ,"
				+ marketTBL	 + " as B "
			+ " set "
				+ " A." + COLUMN_TBL.CAPM
				+ " = "
				+ " (B." + COLUMN_TBL.RISK_FREE_RATE + " + ( A." + COLUMN_TBL.BETA + " * B." + COLUMN_TBL.MARKET_RISK_PREMIUM + "  ) ) "
			+ " where "
					+ "A." + SQL_CODE_WHERE
				+ " and "
					+ " B." + COLUMN_TBL.DAYTIME
					+ " = "
					+ " A." + COLUMN_TBL.DAYTIME
				+ " and "
					+ " A." + COLUMN_TBL.DAYTIME
					+ " = " + "'" + TODAY + "'";
		commonAP.writeInLog(stockTBL + "CAPMセット：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
//		+ COLUMN.BETA_KATA									 + " , " //(個別銘柄リターンとTOPIXリターンの共分散)/(TOPIXの分散)
		//		+ COLUMN.CAPM_KATA							 + " , " //CAPM				//CAPM株主資本コスト（リスクフリーレート+ベータ*マーケットリスクプレミアム）
//		+ COLUMN.Certainty_FOR_BETA_KATA					 + " , " //ベータの確実度=相関係数=(個別銘柄リターンとTOPIXリターンの共分散)/(個別銘柄標準偏差*TOPIX標準偏差)



	}



	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL_1(String TBL,String TODAY,String beforeDay,String updateColumn,String calculateColumn,String calculateLetter,boolean marketFLG){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN = "dummyCOLUMN";

		SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
				+ " ( "
				+ " select "
				+ COLUMN_TBL.CODE + " , "
				+ " " + calculateLetter +  "(" + calculateColumn + ") as " + dummyCOLUMN + "  "
				+ " from " + TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME + " <= " + "'" + TODAY + "'"
				+ " and "
				+ COLUMN_TBL.DAYTIME + " >= " + "'" + beforeDay + "'"
				+ " group by "+ COLUMN_TBL.CODE
				+ " )  " + selectLetter
		+ " set "
				+ updateLetter + "." + updateColumn	 + " = " + selectLetter + "." + dummyCOLUMN + "   "
		+ " where "
				+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE
				+ " and "
				+ updateLetter + "." + COLUMN_TBL.DAYTIME + " = " + "'" +  TODAY + "'";

		if (marketFLG){
//			SQL = SQL+ " and "
//					+ updateLetter + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		}
		return SQL;
	}


	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL_2(String TBL,String TODAY,String beforeDay
			,String updateColumn1,String calculateColumn1,String calculateLetter1
			,String updateColumn2,String calculateColumn2,String calculateLetter2,boolean marketFLG,String unionSQL){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN_1 = "dummyCOLUMNA";
		String dummyCOLUMN_2 = "dummyCOLUMNB";

		String thisTBL = TBL;

		 
		String unionTBL = "unionTBL";
		if(marketFLG==false){
			//このなかSTOCK
			SQL = " UPDATE " + TBL + " " + updateLetter 
					+  " left outer join "
					+ " ( "
						+ " select "
						+ COLUMN_TBL.CODE + " , "
						+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
						+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + "   "
						+ " from "
						
//					 	+ TBL
//						+ " where "
//						+ SQL_CODE_WHERE
//						+ " and "
//						+ COLUMN_TBL.DAYTIME + " <= " + "'" + TODAY + "'"
//						+ " and "
//						+ COLUMN_TBL.DAYTIME + " >= " + "'" + beforeDay + "'"
//						+ " group by "+ COLUMN_TBL.CODE
//						+ " )  " + selectLetter
//					+ " on "
//					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE

						+ " ( "
						+ unionSQL
						+ " ) as " + unionTBL
						+ " group by " + unionTBL + "." + COLUMN_TBL.CODE
					+ " )  " + selectLetter
					+ " on "
					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE

					+ " set "
					+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
					+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + "    "
					+ " where "
					+ updateLetter + "." + SQL_CODE_WHERE
					+ " and "
					+ updateLetter + "." + COLUMN_TBL.DAYTIME + " = " + "'" +  TODAY + "'";
		}else{
			SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
					+ " ( "
					+ " select "
					+ COLUMN_TBL.CODE + " , "
					+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
					+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + "   "
					+ " from " + thisTBL
					+ " where "
					+ COLUMN_TBL.DAYTIME + " <= " + "'" + TODAY + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " >= " + "'" + beforeDay + "'"
					+ " group by "+ COLUMN_TBL.CODE
					+ " )  " + selectLetter
					+ " set "
					+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
					+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + "    "
					+ " where "
					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE
					+ " and "
					+ updateLetter + "." + COLUMN_TBL.DAYTIME + " = " + "'" +  TODAY + "'";
		}


		return SQL;
	}


	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL_4(String TBL,String TODAY,String beforeDay
			,String updateColumn1,String calculateColumn1,String calculateLetter1
			,String updateColumn2,String calculateColumn2,String calculateLetter2
			,String updateColumn3,String calculateColumn3,String calculateLetter3
			,String updateColumn4,String calculateColumn4,String calculateLetter4,boolean marketFLG,String unionSQL){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN_1 = "dummyCOLUMNA";
		String dummyCOLUMN_2 = "dummyCOLUMNB";
		String dummyCOLUMN_3 = "dummyCOLUMNC";
		String dummyCOLUMN_4 = "dummyCOLUMND";
		String thisTBL = TBL;

		String unionTBL = "unionTBL";
		if(marketFLG==false){
			//このなかSTOCK
			//処理速度向上案

			SQL = " UPDATE " + TBL + " " + updateLetter
					+ " left outer join  "
					+ " ( "
						+ " select "
						+ COLUMN_TBL.CODE + " , "
						+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
						+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + " , "
						+ " " + calculateLetter3 +  "(" + calculateColumn3 + ") as " + dummyCOLUMN_3 + " , "
						+ " " + calculateLetter4 +  "(" + calculateColumn4 + ") as " + dummyCOLUMN_4 + "  "
						+ " from "
						
//					 	+ TBL
//						+ " where "
//						+ SQL_CODE_WHERE
//						+ " and "
//						+ COLUMN_TBL.DAYTIME + " <= " + "'" + TODAY + "'"
//						+ " and "
//						+ COLUMN_TBL.DAYTIME + " >= " + "'" + beforeDay + "'"
//						+ " group by "+ COLUMN_TBL.CODE
//					+ " )  " + selectLetter
//					+ " on "
//					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE
					
						+ " ( "
						+ unionSQL
						+ " ) as " + unionTBL
						+ " group by " + unionTBL + "." + COLUMN_TBL.CODE
					+ " )  " + selectLetter
					+ " on "
					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE
					
			+ " set "
					+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
					+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + " ,  "
					+ updateLetter + "." + updateColumn3	 + " = " + selectLetter + "." + dummyCOLUMN_3 + " ,  "
					+ updateLetter + "." + updateColumn4	 + " = " + selectLetter + "." + dummyCOLUMN_4 + "   "
			+ " where "
					+ updateLetter + "." + SQL_CODE_WHERE
					+ " and "
					+ updateLetter + "." + COLUMN_TBL.DAYTIME + " = " + "'" +  TODAY + "'";
		}else{

			SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
					+ " ( "
					+ " select "
					+ COLUMN_TBL.CODE + " , "
					+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
					+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + " , "
					+ " " + calculateLetter3 +  "(" + calculateColumn3 + ") as " + dummyCOLUMN_3 + " , "
					+ " " + calculateLetter4 +  "(" + calculateColumn4 + ") as " + dummyCOLUMN_4 + "  "
					+ " from " + thisTBL
					+ " where "
					+ COLUMN_TBL.DAYTIME + " <= " + "'" + TODAY + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " >= " + "'" + beforeDay + "'"
					+ " group by "+ COLUMN_TBL.CODE
					+ " )  " + selectLetter
			+ " set "
					+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
					+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + " ,  "
					+ updateLetter + "." + updateColumn3	 + " = " + selectLetter + "." + dummyCOLUMN_3 + " ,  "
					+ updateLetter + "." + updateColumn4	 + " = " + selectLetter + "." + dummyCOLUMN_4 + "   "
			+ " where "
					+ updateLetter + "." + COLUMN_TBL.CODE + " = "+ selectLetter + "." + COLUMN_TBL.CODE
					+ " and "
					+ updateLetter + "." + COLUMN_TBL.DAYTIME + " = " + "'" +  TODAY + "'";
		}

		return SQL;
	}

	//0.008⇒0.8％にする。
	//100倍にする。
	private void persentUpdate(String TBL,String column,String dayTime, S s){
		String SQL;

		SQL = " update "
				+ TBL + " as A "
				+ " left outer join "
				+ TBL + " as B "
				+ " on "
			 	+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
			 	+ " and "
			 	+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
				+ " set "
				+ "A." + column + " = " + "A." + column + " * 100 "
				+ " where "
				+ "A." + SQL_CODE_WHERE
				+ " and "
				+ "A." + COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";
		commonAP.writeInLog("persentUpdate:％にする:" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
	}

}
