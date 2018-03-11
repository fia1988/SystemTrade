package accesarrySQL;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.AccesarryParameta;
import constant.COLUMN;
import constant.ReCord;
import constant.logWriting;

public class CalculateCAPM {



	public void calculateCAPM_MARLET_TBL(String TODAY,String beforeDay, int term){
		String TBL = TBL_Name.MARKET_DD_TBL;
		S s = new S();
		s.getCon();

		String SQL="";


		//NT倍率の計算
		SQL = " update "
				+ TBL_Name.ETF_DD				 + " as A ,"
				+ TBL							 + " as B "
			+ " set "
				+ " B." + COLUMN.NT_RATIO
				+ " = "
				+ " A." + COLUMN.CLOSE + " / " + " B." + COLUMN.CLOSE
			+ " where "
					+ " B." + COLUMN.CODE + " = " + "'" + ReCord.MARKET_CODE_1306 + "'"
				+ " and "
					+ " A." + COLUMN.CODE + " = " + "'" + ReCord.NIKKEI225_CODE_1321 + "'"
				+ " and "
					+ " B." + COLUMN.DAYTIME
					+ " = "
					+ " A." + COLUMN.DAYTIME
				+ " and "
					+ " A." + COLUMN.DAYTIME + " = " + "'" + TODAY + "'";
		commonAP.writeInLog(TBL + "NT倍率の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//標準偏差の計算、リターンの計算
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",true);
//		commonAP.writeInLog(TBL + "リターンの計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
//		SQL = calculateSQL_1(TBL,TODAY,beforeDay,COLUMN.MARKET_RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",true);
//		commonAP.writeInLog(TBL + "の標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
//		s.freeUpdateQuery(SQL);
		SQL = calculateSQL_2(TBL,TODAY,beforeDay,COLUMN.MARKET_RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",COLUMN.MARKET_RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",true);
		commonAP.writeInLog(TBL + "のリターン、標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
		persentUpdate(TBL,COLUMN.MARKET_RETURN_FOR_BETA,TODAY,s);
		persentUpdate(TBL,COLUMN.MARKET_RISK_FOR_BETA,TODAY,s);


//		+ COLUMN.MARKET_RISK_PREMIUM_KATA					 + " , "
//		//分散、リスクフリーレート計算
		//リスクフリーレートは0.8%とする。
		SQL = " update " + TBL
			+ " set "
			+ COLUMN.MARKET_RISK_Squaring_FOR_BETA + " = " + COLUMN.MARKET_RISK_FOR_BETA + " * " + COLUMN.MARKET_RISK_FOR_BETA + " , "
			+ COLUMN.RISK_FREE_RATE + " = " + AccesarryParameta.RISK_FREE_RATE
			+ " where "
			+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'"
			+ " and "
			+ COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		commonAP.writeInLog(TBL + "の分散、リスクフリーレート計算(" + AccesarryParameta.RISK_FREE_RATE + ")：" + SQL,logWriting.DATEDATE_LOG_FLG);

		s.freeUpdateQuery(SQL);
		//マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）
		SQL = " update " + TBL
				+ " set "
				+ COLUMN.MARKET_RISK_PREMIUM + " = " + COLUMN.MARKET_RETURN_FOR_BETA + " - " + COLUMN.RISK_FREE_RATE + "  "
				+ " where "
				+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'"
				+ " and "
				+ COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
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
				COLUMN.MARKET_RETURN_FOR_BETA_AVE,COLUMN.MARKET_RETURN_FOR_BETA,"avg",
				COLUMN.MARKET_RISK_FOR_BETA_AVE,COLUMN.MARKET_RISK_FOR_BETA,"avg",
				COLUMN.MARKET_RISK_PREMIUM_AVE,COLUMN.MARKET_RISK_PREMIUM,"avg",
				COLUMN.NT_RATIO_AVE,COLUMN.NT_RATIO,"avg",
				true);
		commonAP.writeInLog(TBL + "リターンの平均、標準偏差平均、マーケットリスクプレミアムの更新、NT倍率の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		s.closeConection();
	}




	public void calculateCAPM_STOCK_TBL(String TODAY,String beforeDay, int term){
		String TBL = TBL_Name.STOCK_DD;
		String dummyCOLUMN_A = "dummyCOLUMN_A";
		String dummyCOLUMN_B = "dummyCOLUMN_B";
		String dummyCOLUMN_C = "dummyCOLUMN_C";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		S s = new S();
		s.getCon();
		String SQL="";


		//以下２つはまだ
//		+ COLUMN.WACC_KATA							 + " , " //WACC
//		+ COLUMN.WACC_AVE_KATA							 + " , " //WACC_AVE




		//配当のセット。単位はパーセント。
		SQL = " update "
				+ TBL_Name.INVEST_SIHYO_DD_TBL	 + " as A ,"
				+ TBL							 + " as B "
			+ " set "
				+ " B." + COLUMN.DIVIDEND_PER
				+ " = "
				+ " (A." + COLUMN.DIVIDEND_PER + "/245) "
			+ " where "
					+ " B." + COLUMN.CODE
					+ " = "
					+ " A." + COLUMN.CODE
				+ " and "
					+ " B." + COLUMN.DAYTIME
					+ " = "
					+ " A." + COLUMN.DAYTIME
				+ " and "
					+ " A." + COLUMN.DAYTIME
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

		calculateSQL_2(TBL,TODAY,beforeDay,COLUMN.RETURN_FOR_BETA,COLUMN.CHANGERATE,"avg",COLUMN.RISK_FOR_BETA,COLUMN.CHANGERATE,"STDDEV_SAMP",false);
		commonAP.writeInLog(TBL + "リターン、標準偏差の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		persentUpdate(TBL,COLUMN.RETURN_FOR_BETA,TODAY,s);
		persentUpdate(TBL,COLUMN.RISK_FOR_BETA,TODAY,s);

		//分散の計算
		SQL = " update " + TBL
			+ " set "
			+ COLUMN.RISK_Squaring_FOR_BETA + " = " + COLUMN.RISK_FOR_BETA + " * " + COLUMN.RISK_FOR_BETA + "  "
			+ " where "
			+ COLUMN.DAYTIME + " = "+ "'" +  TODAY + "'";
		commonAP.writeInLog(TBL + "の分散：" + SQL,logWriting.DATEDATE_LOG_FLG);

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
				COLUMN.RETURN_FOR_BETA_AVE,COLUMN.RETURN_FOR_BETA,"avg",
				COLUMN.RISK_FOR_BETA_AVE,COLUMN.RISK_FOR_BETA,"avg",
				COLUMN.CAPM_AVE,COLUMN.CAPM,"avg",
				COLUMN.Certainty_FOR_BETA_AVE,COLUMN.Certainty_FOR_BETA,"avg",
				true);
		commonAP.writeInLog(TBL + "リターン、標準偏差、CAPM、確実性の平均：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		s.closeConection();
	}




	//個別銘柄リターンとTOPIXリターンの共分散相関係数、ベータ、CAPM、ベータの確実性を求める
	private void calculateCAPM_STOCK_TBL_createTMP_TBL(String TODAY,String beforeDay,S s){
		//共分散の計算
		String stockTBL = TBL_Name.STOCK_DD;
		String marketTBL = TBL_Name.MARKET_DD_TBL;

//		update 01_stock_dd a , 07_marketTBL_DD b ,  ( select 01_stock_dd.code, ( avg(01_stock_dd.RETURN_FOR_BETA * 07_marketTBL_DD.MARKET_RETURN_FOR_BETA) - avg(01_stock_dd.RETURN_FOR_BETA) * avg(07_marketTBL_DD.MARKET_RETURN_FOR_BETA) )  as dummycolumn  from  07_marketTBL_DD left outer join  01_stock_dd on  07_marketTBL_DD.daytime = 01_stock_dd.daytime where  07_marketTBL_DD.daytime <= '2007-12-28' and 07_marketTBL_DD.daytime >= '2007-01-04' group by 01_stock_dd.code ) c set a.COVAR_with_TOPIX =  c.dummycolumn where a.daytime = '2007-12-28' and a.code = c.code ;
//       where a.daytime = '2007-12-28' and a.code = c.code ;
		String SQL = " ";
		SQL = " update " + stockTBL + " a , " + marketTBL + " b , "
				+ " ( "
					+ " select " + stockTBL + "." + COLUMN.CODE + " , "
						+ " ( "
							+ " avg(" + stockTBL + "." + COLUMN.RETURN_FOR_BETA + " * " + marketTBL + "." + COLUMN.MARKET_RETURN_FOR_BETA + ")"
								+ " - "
							+ " avg(" + stockTBL + "." + COLUMN.RETURN_FOR_BETA + ") * avg(" + marketTBL + "." + COLUMN.MARKET_RETURN_FOR_BETA + ")"
						+ " )  as dummycolumn "
					+ " from " + marketTBL + " left outer join " + stockTBL + " on " + stockTBL + "." + COLUMN.DAYTIME + " = " + marketTBL + "." + COLUMN.DAYTIME
					+ " where "
						+ marketTBL + "." + COLUMN.DAYTIME + " <= '" + TODAY + "'"
						+ " and "
						+ marketTBL + "." + COLUMN.DAYTIME + " >= '" + beforeDay + "'"
					+ " group by " + stockTBL + "." + COLUMN.CODE
				+ " ) c "
			+ " set "
				+ " a." + COLUMN.COVAR_with_TOPIX + " = "
				+ " c.dummycolumn "
			+ " where "
				+ " a." + COLUMN.CODE + " = "+ " c." + COLUMN.CODE
				+ " and "
				+ " a." + COLUMN.DAYTIME + " = '" + TODAY + "'";

		commonAP.writeInLog("共分散の計算：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);


		//ベータ、ベータの確実度
		SQL = " update "
				+ stockTBL	 + " as A ,"
				+ marketTBL	 + " as B "
			+ " set "
				+ " A." + COLUMN.BETA
				+ " = "
				+ " (A." + COLUMN.COVAR_with_TOPIX + " / " + " B." + COLUMN.MARKET_RISK_Squaring_FOR_BETA + " ) , "
				+ " A." + COLUMN.Certainty_FOR_BETA
				+ " = "
				+ " (A." + COLUMN.COVAR_with_TOPIX + " / ( " + " B." + COLUMN.MARKET_RISK_FOR_BETA + " * A." + COLUMN.RISK_FOR_BETA + " ) ) , "
			+ " where "
					+ " B." + COLUMN.DAYTIME
					+ " = "
					+ " A." + COLUMN.DAYTIME
				+ " and "
					+ " A." + COLUMN.DAYTIME
					+ " = " + "'" + TODAY + "'";
		commonAP.writeInLog(stockTBL + "のベータとベータの確実度セット：" + SQL,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);

		//CAPM
		SQL = " update "
				+ stockTBL	 + " as A ,"
				+ marketTBL	 + " as B "
			+ " set "
				+ " A." + COLUMN.CAPM
				+ " = "
				+ " (B." + COLUMN.RISK_FREE_RATE + " + ( A." + COLUMN.BETA + " * B." + COLUMN.MARKET_RISK_PREMIUM + "  ) ) "
			+ " where "
					+ " B." + COLUMN.DAYTIME
					+ " = "
					+ " A." + COLUMN.DAYTIME
				+ " and "
					+ " A." + COLUMN.DAYTIME
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
				+ COLUMN.CODE + " , "
				+ " " + calculateLetter +  "(" + calculateColumn + ") as " + dummyCOLUMN + "  "
				+ " from " + TBL
				+ " where "
				+ COLUMN.DAYTIME + " <= " + "'" + TODAY + "'"
				+ " and "
				+ COLUMN.DAYTIME + " >= " + "'" + beforeDay + "'"
				+ " group by "+ COLUMN.CODE
				+ " )  " + selectLetter
		+ " set "
				+ updateLetter + "." + updateColumn	 + " = " + selectLetter + "." + dummyCOLUMN + "   "
		+ " where "
				+ updateLetter + "." + COLUMN.CODE + " = "+ selectLetter + "." + COLUMN.CODE
				+ " and "
				+ updateLetter + "." + COLUMN.DAYTIME + " = " + "'" +  TODAY + "'";

		if (marketFLG){
//			SQL = SQL+ " and "
//					+ updateLetter + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		}
		return SQL;
	}


	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL_2(String TBL,String TODAY,String beforeDay
			,String updateColumn1,String calculateColumn1,String calculateLetter1
			,String updateColumn2,String calculateColumn2,String calculateLetter2,boolean marketFLG){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN_1 = "dummyCOLUMNA";
		String dummyCOLUMN_2 = "dummyCOLUMNB";

		SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
				+ " ( "
				+ " select "
				+ COLUMN.CODE + " , "
				+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
				+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + "   "
				+ " from " + TBL
				+ " where "
				+ COLUMN.DAYTIME + " <= " + "'" + TODAY + "'"
				+ " and "
				+ COLUMN.DAYTIME + " >= " + "'" + beforeDay + "'"
				+ " group by "+ COLUMN.CODE
				+ " )  " + selectLetter
				+ " set "
				+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
				+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + "    "
				+ " where "
				+ updateLetter + "." + COLUMN.CODE + " = "+ selectLetter + "." + COLUMN.CODE
				+ " and "
				+ updateLetter + "." + COLUMN.DAYTIME + " = " + "'" +  TODAY + "'";

		if (marketFLG){
			//				SQL = SQL+ " and "
			//						+ updateLetter + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		}
		return SQL;
	}


	//マーケットフラグ：true(マーケットテーブル)
	private String calculateSQL_4(String TBL,String TODAY,String beforeDay
			,String updateColumn1,String calculateColumn1,String calculateLetter1
			,String updateColumn2,String calculateColumn2,String calculateLetter2
			,String updateColumn3,String calculateColumn3,String calculateLetter3
			,String updateColumn4,String calculateColumn4,String calculateLetter4,boolean marketFLG){
		String SQL = "";
		String selectLetter = "selectLetter";
		String updateLetter = "updateLetter";
		String dummyCOLUMN_1 = "dummyCOLUMNA";
		String dummyCOLUMN_2 = "dummyCOLUMNB";
		String dummyCOLUMN_3 = "dummyCOLUMNC";
		String dummyCOLUMN_4 = "dummyCOLUMND";

		SQL = " UPDATE " + TBL + " " + updateLetter + " ,  "
				+ " ( "
				+ " select "
				+ COLUMN.CODE + " , "
				+ " " + calculateLetter1 +  "(" + calculateColumn1 + ") as " + dummyCOLUMN_1 + " , "
				+ " " + calculateLetter2 +  "(" + calculateColumn2 + ") as " + dummyCOLUMN_2 + " , "
				+ " " + calculateLetter3 +  "(" + calculateColumn3 + ") as " + dummyCOLUMN_3 + " , "
				+ " " + calculateLetter4 +  "(" + calculateColumn4 + ") as " + dummyCOLUMN_4 + "  "
				+ " from " + TBL
				+ " where "
				+ COLUMN.DAYTIME + " <= " + "'" + TODAY + "'"
				+ " and "
				+ COLUMN.DAYTIME + " >= " + "'" + beforeDay + "'"
				+ " group by "+ COLUMN.CODE
				+ " )  " + selectLetter
		+ " set "
				+ updateLetter + "." + updateColumn1	 + " = " + selectLetter + "." + dummyCOLUMN_1 + " ,  "
				+ updateLetter + "." + updateColumn2	 + " = " + selectLetter + "." + dummyCOLUMN_2 + " ,  "
				+ updateLetter + "." + updateColumn3	 + " = " + selectLetter + "." + dummyCOLUMN_3 + " ,  "
				+ updateLetter + "." + updateColumn4	 + " = " + selectLetter + "." + dummyCOLUMN_4 + "   "
		+ " where "
				+ updateLetter + "." + COLUMN.CODE + " = "+ selectLetter + "." + COLUMN.CODE
				+ " and "
				+ updateLetter + "." + COLUMN.DAYTIME + " = " + "'" +  TODAY + "'";

		if (marketFLG){
//			SQL = SQL+ " and "
//					+ updateLetter + "." + COLUMN.CODE + " = " + "'" +  ReCord.MARKET_CODE_1306 + "'";
		}
		return SQL;
	}

	//0.008⇒0.8％にする。
	//100倍にする。
	private void persentUpdate(String TBL,String column,String dayTime, S s){
		String SQL="";

		SQL = " update " + TBL
				+ " set "
				+ column + " = " + column + " * 100 "
				+ " where "
				+ COLUMN.DAYTIME + " = '" + dayTime + "'";

		s.freeUpdateQuery(SQL);
	}



}
