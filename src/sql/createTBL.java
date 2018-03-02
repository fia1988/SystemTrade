package sql;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import constant.COLUMN;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class createTBL {


	public String createStartTBL(S s){

		createSTOCK_1_DD(s);

		createStatistical_2_DD(s);

		createINDEX_3_DD(s);

		createETF_4_DD(s);
		createSAKIMONO_5_DD(s);
		createCurrency_6_DD(s);

		createKOSHINList(s);
		createSEPARETE_DD(s);

		createCodeList(s);

		createKeepListTable(s);
		createResulthistory(s);
		createEleteTBL(s);
		createIntervalTime(s);
		createOutPutTable(s);

		createPROPARTYTBL(s);
		createPROPARTYLIST(s);
		createFORCE_S_TBL(s);
		createPayMemberList_TBL(s);
		createKICK_FILE_USER_LIST_TBL(s);
		createFINANCIAL_MM_TBL(s);
		createINVEST_SIHYO_TBL(s);
//		createVolumeUnitListTBL(s);
		createFORRIGN_RATIO_TBL(s);
		createMARKET_DD_TBL(s);
		createCREDIT_WW_TBL(s);
		return createLastOrderTable(s);
	}


	private void createMARKET_DD_TBL(S s){
		//SQL全文
				String SQL;
				//列名の取得
				String colum;

				//SQL文の取得
				String create = "create table ";

				colum = "("
//						+ "id MEDIUMINT AUTO_INCREMENT," //ID
						+ COLUMN.CODE_KATA									 + " , " //銘柄名
						+ COLUMN.DAYTIME_KATA								 + " , " //日付
						+ COLUMN.OPEN_KATA									 + " , " //始値
						+ COLUMN.MAX_KATA									 + " , " //最高値
						+ COLUMN.MIN_KATA									 + " , " //最安値
						+ COLUMN.CLOSE_KATA									 + " , " //終値
						+ COLUMN.DEKI_KATA									 + " , " //出来高
						+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
						//+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済み株式数
						//+ COLUMN.MARKET_CAP_KATA							 + " , " //時価総額
						//+ COLUMN.M_AND_A_FLG_KATA							 + " , " //合併フラグ
//						+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//						+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//						+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//						+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
						+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
						+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率(0.05表示＝（5％）)
						+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
						+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
						+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
						+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
						+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
						+ COLUMN.SHORTIDO_RATIO_KATA						 + " , " //株価短期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_RATIO_KATA						 + " , " //株価中期間移動平均線前日比率
						+ COLUMN.LONGIDO_RATIO_KATA							 + " , " //株価長期間移動平均線前日比率
						+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
						+ COLUMN.MAXMINRATIO_KATA							 + " , " //（1-最安値)/最高値
						+ COLUMN.CANDLE_AREA_KATA							 + " , " //ローソク足の面積
						+ COLUMN.CANDLE_AREA_SCALE_KATA						 + " , " //ひげの長さと比較したローソク足面積の比率
						+ COLUMN.WINDOW_KATA								 + " , " //前日の終値-今日の始値
						+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
						+ COLUMN.DEKI_RATIO_KATA							 + " , " //出来高前日比率
						+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
						+ COLUMN.BAYBAY_RATIO_KATA							 + " , " //売買代金前日比率
						+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
						+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
						+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
						+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期移動平均線前日比
						+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
						+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
						+ COLUMN.SHORTIDO_DEKI_RATIO_KATA					 + " , " //出来高短期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_DEKI_RATIO_KATA					 + " , " //出来高中期移動平均線前日比率
						+ COLUMN.LONGIDO_DEKI_RATIO_KATA					 + " , " //出来高長期移動平均線前日比率
						+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
						+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
						+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
						+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
						+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
						+ COLUMN.SHORTIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金短期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_BAYBAY_RATIO_KATA				 + " , " //売買代金中期間移動平均線前日比率
						+ COLUMN.LONGIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金長期移動平均線前日比率
						+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買い残
						+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売り残
						+ COLUMN.CREDIT_RATIO_KATA							 + " , " //信用倍率＝信用買い残÷信用売り残
						+ COLUMN.CREDIT_LONG_CHANGERATE_KATA				 + " , " //信用買い残前日比
						+ COLUMN.CREDIT_SHORT_CHANGERATE_KATA				 + " , " //信用売り残前日比
						+ COLUMN.CREDIT_RATIO_CHANGERATE_KATA				 + " , " //信用倍率前日比
						+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
						+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値がシグマと比較して何パーセント上か。
						+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
						+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
						+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
						+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
						+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
						+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
						+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
						+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値がシグマと比較して何パーセント上か。
						+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
						+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
						+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
						+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
						+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
						+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
						+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
						+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値がシグマと比較して何パーセント上か。
						+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
						+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
						+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
						+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
						+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
						+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
						+ COLUMN.SHORTIDO_HEKATU_KATA						 + " , " //指数平滑移動平均短期
						+ COLUMN.MIDDLEIDO_HEKATU_KATA						 + " , " //指数平滑移動平均中期
						+ COLUMN.LONGIDO_HEKATU_KATA				 	 	 + " , " //指数平滑移動平均長期
						+ COLUMN.SHORTIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均短期前日比
						+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均中期前日比
						+ COLUMN.LONGIDO_HEKATU_CHANGERATE_KATA		 	 	 + " , " //指数平滑移動平均長期前日比
						+ COLUMN.SHORTIDO_HEKATU_RATIO_KATA					 + " , " //指数平滑移動平均短期前日比率
						+ COLUMN.MIDDLEIDO_HEKATU_RATIO_KATA				 + " , " //指数平滑移動平均中期前日比率
						+ COLUMN.LONGIDO_HEKATU_RATIO_KATA		 	 		 + " , " //指数平滑移動平均長期前日比率
						+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
						+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
						+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
						+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
						+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
						+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線


						+ COLUMN.MARKET_RETURN_FOR_BETA_KATA				 + " , " //過去データの基づく理論上リターン
						+ COLUMN.MARKET_RETURN_FOR_BETA_AVE_KATA			 + " , " //過去データの基づく理論上リターンの平均
						+ COLUMN.MARKET_RISK_FOR_BETA_KATA					 + " , " //標準偏差
						+ COLUMN.MARKET_RISK_FOR_BETA_AVE_KATA				 + " , " //標準偏差平均
						+ COLUMN.MARKET_RISK_Squaring_FOR_BETA_KATA			 + " , " //分散
						+ COLUMN.RISK_FREE_RATE_KATA						 + " , " //リスクフリーレート
						+ COLUMN.MARKET_RISK_PREMIUM_KATA					 + " , " //マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）
						+ COLUMN.MARKET_RISK_PREMIUM_AVE_KATA				 + " , " //マーケットリスクプレミアム（トピックスリターン-リスクフリーレート）_平均

						+ "primary key ("
						+ COLUMN.CODE  + " , " +  COLUMN.DAYTIME + ")) ";
//						+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
//						+ "unique (" + COLUMN.CODE + COLUMN.DAYTIME + "),primary key(id)) ";

				//残り、インデックス
				//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
				//週足、月足、週足、５分足、財務諸表

				SQL = create + TBL_Name.MARKET_DD_TBL + colum;

				s.createTBL(SQL);
	}

	//全上場企業 決算・財務・業績データ
	//財務諸表データ
	//japan-all-stock-financial-results_20170107.csv
	private void createFINANCIAL_MM_TBL(S s){
		String TBL = TBL_Name.FINANCIAL_MM_TBL;
//													ROE	ROA	発行済株式数
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.CODENAME_KATA								 + " , " //名称
				+ COLUMN.KESSAN_TERM_YYYY_MM_STRING_KATA			 + " , " //決算期
				+ COLUMN.YEAR_KESSAN_TIME_YYYYMMDD_KATA				 + " , " //決算発表日（本決算）
				+ COLUMN.URIAGE_DAKA_PPT_KATA						 + " , " //売上高（百万円）
				+ COLUMN.EIGYO_PROF_PPT_KATA						 + " , " //営業利益（百万円）
				+ COLUMN.KEIJO_PROF_PPT_KATA						 + " , " //経常利益（百万円）
				+ COLUMN.BOTTOM_LINE_PPT_KATA						 + " , " //当期利益（百万円）
				+ COLUMN.TOTAL_ASSET_PPT_KATA						 + " , " //総資産（百万円）
				+ COLUMN.SELF_ASSET_PPT_KATA						 + " , " //自己資本（百万円）
				+ COLUMN.SHIHONKIN_ASSET_PPT_KATA					 + " , " //資本金（百万円）
				+ COLUMN.LOAN_PPT_KATA								 + " , " //有利子負債（百万円）
				+ COLUMN.SELF_ASSET_WARIAI_KATA						 + " , " //自己資本比率
				+ COLUMN.ROE_KATA									 + " , " //ROE
				+ COLUMN.ROA_KATA									 + " , " //ROA
				+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済株式数
				+ "primary key ( "
//				+ COLUMN.DAYTIME + " , " + COLUMN.CODE +  " ) )";
				+ COLUMN.YEAR_KESSAN_TIME_YYYYMMDD + " , " + COLUMN.CODE +  " ) )";

		SQL = create + TBL + colum;

		s.createTBL(SQL);
	}

	//日本株全銘柄 投資指標データ
	//配当比率とか
	//japan-all-stock-data.csv
	private void createINVEST_SIHYO_TBL(S s){
		String TBL = TBL_Name.INVEST_SIHYO_DD_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.CODENAME_KATA								 + " , " //名称
				+ COLUMN.MARKET_KATA								 + " , " //市場
				+ COLUMN.CATEGORY_KATA								 + " , " //業種
				+ COLUMN.MARKET_CAP_PPT_KATA						 + " , " //時価総額（百万円）
				+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済株式数
				+ COLUMN.DIVIDEND_PER_KATA 							 + " , " //配当利回り
				+ COLUMN.DIVIDEND_KATA  							 + " , " //1株配当
				+ COLUMN.PER_YOSO_KATA  							 + " , " //PER（予想）
				+ COLUMN.PBR_REAL_KATA  							 + " , " //PBR（実績）
				+ COLUMN.EPS_YOSO_KATA 								 + " , " //EPS（予想）
				+ COLUMN.BPS_REAL_KATA 								 + " , " //BPS（実績）
				+ COLUMN.MIN_BUY_PRICE_KATA  						 + " , " //最低購入額
				+ COLUMN.VOLUME_UNIT_KATA 							 + " , " //単元株
				+ COLUMN.YEAR_MAX_DAY_YYYYMMDD_KATA 				 + " , " //高値日付
				+ COLUMN.YEAR_MAX_KATA 								 + " , " //年初来高値
				+ COLUMN.YEAR_MIN_DAY_YYYYMMDD_KATA 				 + " , " //安値日付
				+ COLUMN.YEAR_MIN_KATA 								 + " , " //年初来安値
				+ COLUMN.MARKET_CAP_PPT_PRE_KATA						 + " , " //時価総額（百万円）_PRE
				+ COLUMN.STOCK_NUM_PRE_KATA								 + " , " //発行済株式数_PRE
				+ COLUMN.DIVIDEND_PER_PRE_KATA 							 + " , " //配当利回り_PRE
				+ COLUMN.DIVIDEND_PRE_KATA  							 + " , " //1株配当_PRE
				+ COLUMN.PER_YOSO_PRE_KATA  							 + " , " //PER（予想）_PRE
				+ COLUMN.PBR_REAL_PRE_KATA  							 + " , " //PBR（実績）_PRE
				+ COLUMN.EPS_YOSO_PRE_KATA 								 + " , " //EPS（予想）_PRE
				+ COLUMN.BPS_REAL_PRE_KATA 								 + " , " //BPS（実績）_PRE
				+ COLUMN.YEAR_MAX_DAY_YYYYMMDD_PRE_KATA 				 + " , " //高値日付_PRE
				+ COLUMN.YEAR_MAX_PRE_KATA 								 + " , " //年初来高値_PRE
				+ COLUMN.YEAR_MIN_DAY_YYYYMMDD_PRE_KATA 				 + " , " //安値日付_PRE
				+ COLUMN.YEAR_MIN_PRE_KATA 								 + " , " //年初来安値_PRE
				+ "primary key ( "
				+ COLUMN.DAYTIME + " , " + COLUMN.CODE +  " ) )";

		SQL = create + TBL + colum;

		s.createTBL(SQL);
	}


	//日本株全銘柄 基本データ
	//外人保有比率
	//japan-all-stock-information/
	private void createFORRIGN_RATIO_TBL(S s){
		String TBL = TBL_Name.FORRIGN_RATIO_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.ANOTHER_STOCK_HOLDER_RATIO_KATA			 + " , " //浮動株数比率
				+ COLUMN.MAJOR_STOCK_HOLDER_RATIO_KATA				 + " , " //少数特定者持株数比率
				+ COLUMN.ETF_STOCK_HOLDER_RATIO_KATA				 + " , " //投資信託持株数比率
				+ COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_KATA			 + " , " //外国人持株数比率
				+ COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE_KATA			 + " , " //浮動株数比率_PRE
				+ COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE_KATA				 + " , " //少数特定者持株数比率_PRE
				+ COLUMN.ETF_STOCK_HOLDER_RATIO_PRE_KATA				 + " , " //投資信託持株数比率_PRE
				+ COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE_KATA			 + " , " //外国人持株数比率_PRE
				+ "primary key ( "
				+ COLUMN.DAYTIME + " , " + COLUMN.CODE +  " ) )";

		SQL = create + TBL + colum;

		s.createTBL(SQL);
	}


	//信用取引残高
	//	japan-all-stock-margin-transactions.csv
	private void createCREDIT_WW_TBL(S s){
		String TBL = TBL_Name.CREDIT_WW_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";
//

		colum = " ( "
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買残高
				+ COLUMN.CREDIT_LONG_CHANGERATE_W_KATA				 + " , " //信用買残高前週比
				+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売残高
				+ COLUMN.CREDIT_SHORT_CHANGERATE_W_KATA				 + " , " //信用売残高前週比
				+ COLUMN.CREDIT_RATIO_KATA							 + " , " //貸借倍率
				+ COLUMN.CREDIT_LONG_PRE_KATA							 + " , " //信用買残高_PRE
				+ COLUMN.CREDIT_LONG_CHANGERATE_W_PRE_KATA				 + " , " //信用買残高前週比_PRE
				+ COLUMN.CREDIT_SHORT_PRE_KATA							 + " , " //信用売残高_PRE
				+ COLUMN.CREDIT_SHORT_CHANGERATE_W_PRE_KATA				 + " , " //信用売残高前週比_PRE
				+ COLUMN.CREDIT_RATIO_PRE_KATA							 + " , " //貸借倍率_PRE
				+ "primary key ( "
				+ COLUMN.DAYTIME + " , " + COLUMN.CODE +  " ) )";

		SQL = create + TBL + colum;

		s.createTBL(SQL);


	}

	private void createPayMemberList_TBL(S s){
		String TBL = TBL_Name.KICK_FILE_PAYING_USER_LIST_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.KICK_FILE_USER_FOLDER_KATA							 + " ,  " //キックファイル配布フォルダ名
				+ COLUMN.KOSIN_DAYTIME_KATA										 + " ,  "
				+ COLUMN.LIMIT_DAYTIME_KATA										 + "   "//最終配布日
				+ " , "
				+ "primary key ("
				+ COLUMN.KICK_FILE_USER_FOLDER +  ") )";;

		SQL = create + TBL + colum;

		s.createTBL(SQL);


	}

	private void createFORCE_S_TBL(S s){
		String TBL = TBL_Name.FORCE_S_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.ALL_CHECK_FLG_KATA								 + "   " //オールチェックフラグ true全部株、false特定手法のみ
				+  " )";;

		SQL = create + TBL + colum;

		s.createTBL(SQL);

	}

	private void createKICK_FILE_USER_LIST_TBL(S s){

		String TBL = TBL_Name.KICK_FILE_USER_LIST_TBL;

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = " ( "
				+ COLUMN.KICK_FILE_USER_FOLDER_KATA							 + "   " //キックファイル配布フォルダ名
				+ " , "
				+ "primary key ("
				+ COLUMN.KICK_FILE_USER_FOLDER +  ") )";;

		SQL = create + TBL + colum;

		s.createTBL(SQL);
	}

	private void createPROPARTYLIST(S s){

		//SQL全文
		String SQL;

		//初期値の設定
		SQL = "insert into "
				+ TBL_Name.PROPARTY_TBL
				+ " ( " + COLUMN.ITEMNAME
				+ " , "
				+ COLUMN.ITEMNAME_DESC
				+ ") values ('" + PROPARTY.FBS_KEY + "' , '"+ PROPARTY.FIRST_SET + "' )  " ;

		s.createTBL(SQL);

	}

	private void createPROPARTYTBL(S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.ITEMNAME_KATA							 + " ,  " //項目
				+ COLUMN.ITEMNAME_DESC_KATA								 + " ,  " //項目内容
				+ "primary key ("
				+ COLUMN.ITEMNAME +  ")) ";

		SQL = create + TBL_Name.PROPARTY_TBL + colum;

		s.createTBL(SQL);
	}

	private void createIntervalTime(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;



		String create = "create table ";

		colum = "( "
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.NOW_INTERVAL_KATA								 + " , " //
				+ COLUMN.MAX_INTERVAL_KATA								 + " , " //
				+ "primary key ("
				+ COLUMN.CODE + " , " + COLUMN.ENTRYMETHOD + "," + COLUMN.EXITMETHOD + "," + COLUMN.TYPE + ")) ";

		SQL = create + TBL_Name.INTERVAL_TIME_TBL + colum;

		int intResult = s.createTBL(SQL);

	}



	private void createEleteTBL(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;



		String create = "create table ";

		colum = "( "
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.MAX_ENTRY_TIME_KATA							 + " , " //
				+ COLUMN.MAX_KEEP_TIME_KATA								 + " , " //
				+ COLUMN.MAX_INTERVAL_KATA									 + " , " //
				+ COLUMN.MAX_LOSS_KATA								+ " , " //
				+ "primary key ("
				+ COLUMN.CODE + " , " + COLUMN.ENTRYMETHOD + "," + COLUMN.EXITMETHOD + "," + COLUMN.TYPE + ")) ";

		SQL = create + TBL_Name.ELETE_LIST_TBL + colum;

		int intResult = s.createTBL(SQL);

		SQL = create + TBL_Name.ELETE_LIST_TEST_TBL + colum;

		intResult = s.createTBL(SQL);
	}

	private void createOutPutTable(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.DAYTIME_KATA									 + " , " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.CATE_FLG_KATA									 + " , " //
				+ COLUMN.SIGN_FLG_KATA								 	 + " , " //売買サインフラグ。true買い、false売り
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.CLOSE_KATA										 + " , " //今日の終値
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.VOLUME_UNIT_KATA								 + " ,  " //売買単位
				+ COLUMN.MINI_CHECK_FLG_KATA							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
				+ COLUMN.REAL_ENTRY_VOLUME_KATA							 + " ,  " //現実的購入枚数
				+ COLUMN.ENTRY_MONEY_KATA								 + " ,  " //一回辺り投資金額
				+ "primary key ("
				+ COLUMN.CODE + " , "+ COLUMN.CATE_FLG + " , "+  COLUMN.DAYTIME + " , "+ COLUMN.SIGN_FLG + " , "+ COLUMN.ENTRYMETHOD + "," + COLUMN.EXITMETHOD + "," + COLUMN.TYPE + "," + COLUMN.MINI_CHECK_FLG +  ")) ";

		SQL = create + TBL_Name.OUT_PUT_LASTORDER + colum;

		s.createTBL(SQL);
	}


	private void createVolumeUnitListTBL(S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.VOLUME_UNIT_KATA								 + " ,  " //売買単位
				+ "primary key ("
				+ COLUMN.CODE +  ")) ";

		SQL = create + TBL_Name.VOLUME_UNIT_LIST_TBL + colum;

		s.createTBL(SQL);


	}


	private String createLastOrderTable(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.DAYTIME_KATA									 + " , " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.CATE_FLG_KATA									 + " , " //
				+ COLUMN.SIGN_FLG_KATA								 	 + " , " //売買サインフラグ。true買い、false売り
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.CLOSE_KATA										 + " ,  " //今日の終値
				+ COLUMN.VOLUME_UNIT_KATA								 + " ,  " //売買単位
				+ COLUMN.MINI_CHECK_FLG_KATA							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
				+ COLUMN.IDEA_VOLUME_KATA								 + " ,  " //理想的購入枚数
				+ COLUMN.REAL_ENTRY_VOLUME_KATA								 + " ,  " //現実的購入枚数
				+ "primary key ("
				+ COLUMN.CODE + " , "+ COLUMN.CATE_FLG + " , "+  COLUMN.DAYTIME + " , "+ COLUMN.SIGN_FLG + " , "+ COLUMN.ENTRYMETHOD + "," + COLUMN.EXITMETHOD + "," + COLUMN.TYPE + "," + COLUMN.MINI_CHECK_FLG +  ")) ";

		SQL = create + TBL_Name.LASTORDER + colum;

		int intResult = s.createTBL(SQL);

		switch (s.createTBL(SQL)) {
			case ReturnCodeConst.SQL_ERR_0:
				return nyuryokuCheckResultConst.SUCCESS;
			case ReturnCodeConst.SQL_ERR_1050:
				return nyuryokuCheckResultConst.SUCCESS;
			default:

				return nyuryokuCheckResultConst.NO_DB;
		}

	}

	//保有銘柄一覧テーブル
	private void createKeepListTable(S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.ENTRYDAY_KATA									 + " , " //
				+ COLUMN.LASTENTRYDAY_KATA								 + " , " //
				+ COLUMN.ENTRYTIMES_KATA								 + " , " //
				+ COLUMN.AVERAGEPRICE_KATA								 + " , " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.MINI_CHECK_FLG_KATA							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
				+ COLUMN.IDEA_VOLUME_KATA								 + " ,  "  //理想的保持数
				+ COLUMN.IDEA_AVERAGEPRICE_KATA							 + " ,  "  //理想的平均取得価格
				+ COLUMN.IDEA_TOTAL_ENTRY_MONEY_KATA					 + " ,  "  //理想的合計投資金額
				+ COLUMN.REAL_ENTRY_VOLUME_KATA							 + " ,  "  //現実保有数
				+ COLUMN.REAL_AVERAGEPRICE_KATA							 + " ,  "  //現実平均取得価格
				+ COLUMN.REAL_TOTAL_ENTRY_MONEY_KATA					 + " ,  " 	//現実的合計投資金額
				+ "primary key ("
				+ COLUMN.CODE + " , " +  COLUMN.ENTRYMETHOD + "," + COLUMN.EXITMETHOD + "," + COLUMN.TYPE + "," + COLUMN.MINI_CHECK_FLG + ")) ";

		SQL = create + TBL_Name.KEEPLISTTBL + colum;

		s.createTBL(SQL);

	}

	//
	private void createResulthistory(S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "( "
				+ COLUMN.CODE_KATA										 + " , " //
				+ COLUMN.ENTRYDAY_KATA									 + " , " //
				+ COLUMN.EXITDAY_KATA									 + " , " //
				+ COLUMN.AVERAGEPRICE_KATA								 + " , " //
				+ COLUMN.EXITPRICE_KATA									 + " , " //
				+ COLUMN.TYPE_KATA									 	 + " , " //
				+ COLUMN.ENTRYTIMES_KATA								 + " , " //
				+ COLUMN.RESULTRETURN_KATA								 + " , " //
				+ COLUMN.TOTAL_RETURN_KATA								 + " , " //
				+ COLUMN.KEEPTIME_KATA									 + " , " //
				+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
				+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
				+ COLUMN.MINI_CHECK_FLG_KATA							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
				+ COLUMN.IDEA_VOLUME_KATA								 + " ,  "  //理想的保持数
				+ COLUMN.IDEA_AVERAGEPRICE_KATA							 + " ,  "  //理想的平均取得価格
				+ COLUMN.IDEA_RETURN_KATA								 + " ,  " //理想的トータルリターン
				+ COLUMN.REAL_ENTRY_VOLUME_KATA							 + " ,  "  //現実保有数
				+ COLUMN.REAL_AVERAGEPRICE_KATA							 + " ,  "  //現実平均取得価格
				+ COLUMN.REAL_RETURN_KATA								 + " ,  "//現実的的トータルリターン



				+ "primary key ("
				+ COLUMN.CODE + " , " +  COLUMN.ENTRYDAY + " , " + COLUMN.ENTRYMETHOD + " , " + COLUMN.EXITMETHOD + "," + COLUMN.MINI_CHECK_FLG +  ")) ";

		SQL = create + TBL_Name.RESULTHISTROYTBL + colum;

		s.createTBL(SQL);

	}

	private void createSEPARETE_DD(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";
//		・併合でfalse、分割でtrue
//		  併合の場合は比率で乗算
//		  分割の場合は比率で除算
		colum = "( "
				+ COLUMN.EFFECT_STARTDAY_KATA						+ " , " //効力発生日
				+ COLUMN.CODE_KATA									 + " , " //銘柄コード
//				+ COLUMN.CODENAME_KATA								+ " , " //銘柄名
				+ COLUMN.AJUSTRATE_KATA								 + " , " //調整レート。仕様はまだ決まっていないが、
				+ COLUMN.DAYTIME_KENRI_LAST_KATA					+ " , " //権利付最終売買日。効力は権利付最終日の翌営業日から発生する
				+ COLUMN.CHECKSEPA_COMBINE_KATA						 + " , " //分割/併合の判断。分割の場合はtrue、併合の場合はfalse
				+ COLUMN.SEPA_FLG_KATA								 + " , " //分割、併合処理をおえたらここに1を埋める
				+ COLUMN.BIKOU_KATA									 + " , " //備考欄
				+ "primary key ("
				+ COLUMN.CODE + " , " +  COLUMN.DAYTIME_KENRI_LAST + " , " + COLUMN.CHECKSEPA_COMBINE + ")) ";

		SQL = create + TBL_Name.SEPARATE_DD + colum;

		s.createTBL(SQL);
	}

	//個別銘柄・・・1
	private void createSTOCK_1_DD(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "("
//				+ "id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.DAYTIME_KATA								 + " , " //日付

				+ COLUMN.BEFORE_OPEN_KATA							 + " , " //調整前始値
				+ COLUMN.BEFORE_MAX_KATA								 + " , " //調整前最高値
				+ COLUMN.BEFORE_MIN_KATA								 + " , " //調整前最安値
				+ COLUMN.BEFORE_CLOSE_KATA							 + " , " //調整前終値
				+ COLUMN.BEFORE_DEKI_KATA							 + " , " //調整前出来高
				+ COLUMN.BEFORE_BAYBAY_KATA							 + " , " //調整前売買代金

				+ COLUMN.OPEN_KATA									 + " , " //始値
				+ COLUMN.MAX_KATA									 + " , " //最高値
				+ COLUMN.MIN_KATA									 + " , " //最安値
				+ COLUMN.CLOSE_KATA									 + " , " //終値
				+ COLUMN.DEKI_KATA									 + " , " //出来高
				+ COLUMN.BAYBAY_KATA								 + " , " //売買代金

				+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済み株式数
				+ COLUMN.MARKET_CAP_KATA							 + " , " //時価総額
//				+ COLUMN.M_AND_A_FLG_KATA							 + " , " //合併フラグ
//				+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
				+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率(0.05表示＝（5％）)
				+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.SHORTIDO_RATIO_KATA						 + " , " //株価短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_RATIO_KATA						 + " , " //株価中期間移動平均線前日比率
				+ COLUMN.LONGIDO_RATIO_KATA							 + " , " //株価長期間移動平均線前日比率
				+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO_KATA							 + " , " //（最高値-最安値)/1
				+ COLUMN.CANDLE_AREA_KATA							 + " , " //ローソク足の面積
				+ COLUMN.CANDLE_AREA_SCALE_KATA						 + " , " //ひげの長さと比較したローソク足面積の比率
				+ COLUMN.WINDOW_KATA								 + " , " //前日の終値-今日の始値
				+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
				+ COLUMN.DEKI_RATIO_KATA							 + " , " //出来高前日比率
				+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
				+ COLUMN.BAYBAY_RATIO_KATA							 + " , " //売買代金前日比率
				+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
				+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
				+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
				+ COLUMN.SHORTIDO_DEKI_RATIO_KATA					 + " , " //出来高短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_DEKI_RATIO_KATA					 + " , " //出来高中期移動平均線前日比率
				+ COLUMN.LONGIDO_DEKI_RATIO_KATA					 + " , " //出来高長期移動平均線前日比率
				+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
				+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
				+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_BAYBAY_RATIO_KATA				 + " , " //売買代金中期間移動平均線前日比率
				+ COLUMN.LONGIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金長期移動平均線前日比率
				+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買い残
				+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売り残
				+ COLUMN.CREDIT_RATIO_KATA							 + " , " //信用倍率＝信用買い残÷信用売り残
				+ COLUMN.CREDIT_LONG_CHANGERATE_KATA				 + " , " //信用買い残前日比
				+ COLUMN.CREDIT_SHORT_CHANGERATE_KATA				 + " , " //信用売り残前日比
				+ COLUMN.CREDIT_RATIO_CHANGERATE_KATA				 + " , " //信用倍率前日比
				+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORTIDO_HEKATU_KATA						 + " , " //指数平滑移動平均短期
				+ COLUMN.MIDDLEIDO_HEKATU_KATA						 + " , " //指数平滑移動平均中期
				+ COLUMN.LONGIDO_HEKATU_KATA				 	 	 + " , " //指数平滑移動平均長期
				+ COLUMN.SHORTIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均短期前日比
				+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均中期前日比
				+ COLUMN.LONGIDO_HEKATU_CHANGERATE_KATA		 	 	 + " , " //指数平滑移動平均長期前日比
				+ COLUMN.SHORTIDO_HEKATU_RATIO_KATA					 + " , " //指数平滑移動平均短期前日比率
				+ COLUMN.MIDDLEIDO_HEKATU_RATIO_KATA				 + " , " //指数平滑移動平均中期前日比率
				+ COLUMN.LONGIDO_HEKATU_RATIO_KATA		 	 		 + " , " //指数平滑移動平均長期前日比率
				+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
				+ COLUMN.DIVIDEND_PER_KATA							 + " , " //配当利回り

				+ COLUMN.BETA_KATA									 + " , " //(個別銘柄リターンとTOPIXリターンの共分散)/(TOPIXの分散)
				+ COLUMN.Certainty_FOR_BETA_KATA					 + " , " //ベータの確実度=相関係数=(個別銘柄リターンとTOPIXリターンの共分散)/(個別銘柄標準偏差*TOPIX標準偏差)
				+ COLUMN.Certainty_FOR_BETA_AVE_KATA				 + " , " //ベータの確実度=相関係数=(個別銘柄リターンとTOPIXリターンの共分散)/(個別銘柄標準偏差*TOPIX標準偏差)_平均
				+ COLUMN.RETURN_FOR_BETA_KATA						 + " , " //過去データの基づく理論上リターン
				+ COLUMN.RETURN_FOR_BETA_AVE_KATA					 + " , " //過去データの基づく理論上リターンの平均
				+ COLUMN.RISK_FOR_BETA_KATA							 + " , " //標準偏差
				+ COLUMN.RISK_FOR_BETA_AVE_KATA						 + " , " //標準偏差の平均
				+ COLUMN.RISK_Squaring_FOR_BETA_KATA				 + " , " //分散
				+ COLUMN.CAPM_KATA							 + " , " //CAPM				//CAPM株主資本コスト（リスクフリーレート+ベータ*マーケットリスクプレミアム）
				+ COLUMN.WACC_KATA							 + " , " //WACC
				+ COLUMN.CAPM_AVE_KATA							 + " , " //CAPM_AVE
				+ COLUMN.WACC_AVE_KATA							 + " , " //WACC_AVE
//				+ "index Idx_day(id)"								 + ","
				+ "primary key ("
				+ COLUMN.CODE + " , " +  COLUMN.DAYTIME + ")) ";
//				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
//				+ "unique (" + COLUMN.CODE + COLUMN.DAYTIME + "),primary key(id)) ";

		//残り、インデックス
		//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
		//週足、月足、週足、５分足、財務諸表

		SQL = create + TBL_Name.STOCK_DD + colum;
//		System.out.println(SQL);
		s.createTBL(SQL);
	}

	//統計・・・2
	private void createStatistical_2_DD(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "("
//				+ "id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.DAYTIME_KATA								 + " , " //日付

				+ COLUMN.STOCK_NAME_NUM_KATA						 + " , " //全銘柄数
				+ COLUMN.STOCK_NOCOMPARE_KATA						 + " , " //比較不可
				+ COLUMN.STOCK_DOWNSTOCK_KATA						 + " , " //値下がり

				+ COLUMN.NETUKI_MAXMIN_KATA							 + " , " //当日の銘柄数-値付き
				+ COLUMN.NETUKI_MAXMINRATIO_KATA					 + " , " //値上がり銘柄数 ÷ 値下がり銘柄数


				+ COLUMN.STOCK_GETPRICE_KATA						 + " , " //値付き
				+ COLUMN.STOCK_GETPRICE_CHANGERATE_KATA				 + " , " //値付き前日比
				+ COLUMN.STOCK_GETPRICE_RATIO_KATA					 + " , " //値付き前日比率
				+ COLUMN.STOCK_GETPRICE_IDO_SHORT_KATA				 + " , " //値付き短期移動平均線
				+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE_KATA				 + " , " //値付き中期移動平均線
				+ COLUMN.STOCK_GETPRICE_IDO_LONG_KATA				 + " , " //値付き長期移動平均線
				+ COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE_KATA	 + " , " //値付き短期間移動平均線前日比
				+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_KATA	 + " , " //値付き中期間移動平均線前日比
				+ COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE_KATA	 + " , " //値付き長期間移動平均線前日比
				+ COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO_KATA		 + " , " //値付き短期間移動平均線前日比率
				+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO_KATA		 + " , " //値付き中期間移動平均線前日比率
				+ COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO_KATA			 + " , " //値付き長期間移動平均線前日比率

				+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
				+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
				+ COLUMN.BAYBAY_RATIO_KATA							 + " , " //売買代金前日比率
				+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
				+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
				+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_BAYBAY_RATIO_KATA				 + " , " //売買代金中期間移動平均線前日比率
				+ COLUMN.LONGIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金長期移動平均線前日比率

				+ COLUMN.DEKI_KATA									 + " , " //出来高
				+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
				+ COLUMN.DEKI_RATIO_KATA							 + " , " //出来高前日比率
				+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
				+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
				+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
				+ COLUMN.SHORTIDO_DEKI_RATIO_KATA					 + " , " //出来高短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_DEKI_RATIO_KATA					 + " , " //出来高中期移動平均線前日比率
				+ COLUMN.LONGIDO_DEKI_RATIO_KATA					 + " , " //出来高長期移動平均線前日比率

				+ COLUMN.STOCK_UPSTOCK_KATA							 + " , " //値上がり
				+ COLUMN.STOCK_UPPRICE_CHANGERATE_KATA				 + " , " //値上がり前日比
				+ COLUMN.STOCK_UPPRICE_RATIO_KATA					 + " , " //値上がり前日比率
				+ COLUMN.STOCK_UPPRICE_IDO_SHORT_KATA				 + " , " //値上がり短期移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_KATA				 + " , " //値上がり中期移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_LONG_KATA				 + " , " //値上がり長期移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE_KATA	 + " , " //値上がり短期間移動平均線前日比　※値付き移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_KATA	 + " , " //値上がり中期間移動平均線前日比　※値付き移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE_KATA		 + " , " //値上がり長期間移動平均線前日比　※値付き移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO_KATA			 + " , " //値上がり短期間移動平均線前日比率
				+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO_KATA		 + " , " //値上がり中期間移動平均線前日比率
				+ COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO_KATA			 + " , " //値上がり長期間移動平均線前日比率


				+ COLUMN.STOCK_NOCHANGE_KATA						 + " , " //変わらず
				+ COLUMN.STOCK_NOCHANGE_CHANGERATE_KATA				 + " , " //変わらず前日比
				+ COLUMN.STOCK_NOCHANGE_RATIO_KATA					 + " , " //変わらず前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_KATA				 + " , " //変わらず短期移動平均線
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_KATA				 + " , " //変わらず中期移動平均線
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_KATA				 + " , " //変わらず長期移動平均線
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_KATA	 + " , " //変わらず短期間移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_KATA	 + " , " //変わらず中期間移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE_KATA	 + " , " //変わらず長期間移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO_KATA		 + " , " //変わらず短期間移動平均線前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO_KATA		 + " , " //変わらず中期間移動平均線前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO_KATA			 + " , " //変わらず長期間移動平均線前日比率




//				+ "index Idx_day(id)"								 + ","
				+ "primary key ("
				+ COLUMN.CODE  + " , " +  COLUMN.DAYTIME + ")) ";
//				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
//				+ "unique (" + COLUMN.CODE + COLUMN.DAYTIME + "),primary key(id)) ";


		SQL = create + TBL_Name.STATISTICS_DD + colum;

		s.createTBL(SQL);
	}

	//指数・・・3
	private void createINDEX_3_DD(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "("
//				+ "id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.OPEN_KATA									 + " , " //始値
				+ COLUMN.MAX_KATA									 + " , " //最高値
				+ COLUMN.MIN_KATA									 + " , " //最安値
				+ COLUMN.CLOSE_KATA									 + " , " //終値
//				+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
				+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
				+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.SHORTIDO_RATIO_KATA						 + " , " //株価短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_RATIO_KATA						 + " , " //株価中期間移動平均線前日比率
				+ COLUMN.LONGIDO_RATIO_KATA							 + " , " //株価長期間移動平均線前日比率
				+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO_KATA							 + " , " //（最高値-最安値)/1
				+ COLUMN.CANDLE_AREA_KATA							 + " , " //ローソク足の面積
				+ COLUMN.CANDLE_AREA_SCALE_KATA						 + " , " //ひげの長さと比較したローソク足面積の比率
				+ COLUMN.WINDOW_KATA								 + " , " //前日の終値-今日の始値
				+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORTIDO_HEKATU_KATA						 + " , " //指数平滑移動平均短期
				+ COLUMN.MIDDLEIDO_HEKATU_KATA						 + " , " //指数平滑移動平均中期
				+ COLUMN.LONGIDO_HEKATU_KATA				 	 	 + " , " //指数平滑移動平均長期
				+ COLUMN.SHORTIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均短期前日比
				+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均中期前日比
				+ COLUMN.LONGIDO_HEKATU_CHANGERATE_KATA		 	 	 + " , " //指数平滑移動平均長期前日比
				+ COLUMN.SHORTIDO_HEKATU_RATIO_KATA					 + " , " //指数平滑移動平均短期前日比率
				+ COLUMN.MIDDLEIDO_HEKATU_RATIO_KATA				 + " , " //指数平滑移動平均中期前日比率
				+ COLUMN.LONGIDO_HEKATU_RATIO_KATA		 	 		 + " , " //指数平滑移動平均長期前日比率
				+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
//				+ "index Idx_day(id)"								 + ","
				+ "primary key ("
				+ COLUMN.CODE  + " , " +  COLUMN.DAYTIME + ")) ";
//				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
//				+ "unique (" + COLUMN.CODE + COLUMN.DAYTIME + "),primary key(id)) ";


		SQL = create + TBL_Name.INDEX_DD + colum;

		s.createTBL(SQL);
	}

	//ETF・・・4
	private void createETF_4_DD(S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;

		//SQL文の取得
		String create = "create table ";

		colum = "("
//				+ "id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.CODE_KATA									 + " , " //銘柄名
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.OPEN_KATA									 + " , " //始値
				+ COLUMN.MAX_KATA									 + " , " //最高値
				+ COLUMN.MIN_KATA									 + " , " //最安値
				+ COLUMN.CLOSE_KATA									 + " , " //終値
				+ COLUMN.DEKI_KATA									 + " , " //出来高
				+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
				//+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済み株式数
				//+ COLUMN.MARKET_CAP_KATA							 + " , " //時価総額
				//+ COLUMN.M_AND_A_FLG_KATA							 + " , " //合併フラグ
//				+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
				+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
				+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.SHORTIDO_RATIO_KATA						 + " , " //株価短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_RATIO_KATA						 + " , " //株価中期間移動平均線前日比率
				+ COLUMN.LONGIDO_RATIO_KATA							 + " , " //株価長期間移動平均線前日比率
				+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO_KATA							 + " , " //（1-最安値)/最高値
				+ COLUMN.CANDLE_AREA_KATA							 + " , " //ローソク足の面積
				+ COLUMN.CANDLE_AREA_SCALE_KATA						 + " , " //ひげの長さと比較したローソク足面積の比率
				+ COLUMN.WINDOW_KATA								 + " , " //前日の終値-今日の始値
				+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
				+ COLUMN.DEKI_RATIO_KATA							 + " , " //出来高前日比率
				+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
				+ COLUMN.BAYBAY_RATIO_KATA							 + " , " //売買代金前日比率
				+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
				+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
				+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
				+ COLUMN.SHORTIDO_DEKI_RATIO_KATA					 + " , " //出来高短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_DEKI_RATIO_KATA					 + " , " //出来高中期移動平均線前日比率
				+ COLUMN.LONGIDO_DEKI_RATIO_KATA					 + " , " //出来高長期移動平均線前日比率
				+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
				+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
				+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金短期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_BAYBAY_RATIO_KATA				 + " , " //売買代金中期間移動平均線前日比率
				+ COLUMN.LONGIDO_BAYBAY_RATIO_KATA					 + " , " //売買代金長期移動平均線前日比率
				+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買い残
				+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売り残
				+ COLUMN.CREDIT_RATIO_KATA							 + " , " //信用倍率＝信用買い残÷信用売り残
				+ COLUMN.CREDIT_LONG_CHANGERATE_KATA				 + " , " //信用買い残前日比
				+ COLUMN.CREDIT_SHORT_CHANGERATE_KATA				 + " , " //信用売り残前日比
				+ COLUMN.CREDIT_RATIO_CHANGERATE_KATA				 + " , " //信用倍率前日比
				+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値がシグマと比較して何パーセント上か。
				+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORTIDO_HEKATU_KATA						 + " , " //指数平滑移動平均短期
				+ COLUMN.MIDDLEIDO_HEKATU_KATA						 + " , " //指数平滑移動平均中期
				+ COLUMN.LONGIDO_HEKATU_KATA				 	 	 + " , " //指数平滑移動平均長期
				+ COLUMN.SHORTIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均短期前日比
				+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE_KATA			 + " , " //指数平滑移動平均中期前日比
				+ COLUMN.LONGIDO_HEKATU_CHANGERATE_KATA		 	 	 + " , " //指数平滑移動平均長期前日比
				+ COLUMN.SHORTIDO_HEKATU_RATIO_KATA					 + " , " //指数平滑移動平均短期前日比率
				+ COLUMN.MIDDLEIDO_HEKATU_RATIO_KATA				 + " , " //指数平滑移動平均中期前日比率
				+ COLUMN.LONGIDO_HEKATU_RATIO_KATA		 	 		 + " , " //指数平滑移動平均長期前日比率
				+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
//				+ "index Idx_day(id)"								 + ","
				+ "primary key ("
				+ COLUMN.CODE  + " , " +  COLUMN.DAYTIME + ")) ";
//				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
//				+ "unique (" + COLUMN.CODE + COLUMN.DAYTIME + "),primary key(id)) ";

		//残り、インデックス
		//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
		//週足、月足、週足、５分足、財務諸表

		SQL = create + TBL_Name.ETF_DD + colum;

		s.createTBL(SQL);
	}

	//先物・・・5
	private void createSAKIMONO_5_DD(S s){

	}

	//通貨・・・6
	private void createCurrency_6_DD(S s){
//		S s = new S();
//		s.getCon();
//
//		//SQL全文
//		String SQL;
//		//列名の取得
//		String colum;
//
//
//		//SQL文の取得
//		String create = "create table ";
//		colum = " ( " + COLUMN.KOSIN_KATA	  + " , "
//					  + COLUMN.KOSIN_DAY_KATA + " , "
//					  + COLUMN.STAMP_KATA	  + "   "//タイムスタンプ
//					  + " PRIMARY KEY ( " + COLUMN.KOSIN_KATA + ")); ";
//
//		SQL = create + TBL_Name.UPDATE_MANAGE + colum;
//
//		s.createTBL(SQL);
//
//		s.closeConection();
	}

	//更新日管理
	private void createKOSHINList(S s){


		//SQL全文
		String SQL;
		//列名の取得
		String colum;


		//SQL文の取得
		String create = "create table ";
		colum = " ( " + COLUMN.KOSIN_KATA	  + " , "
					  + COLUMN.KOSIN_DAY_KATA + " , "
					  + COLUMN.STAMP_KATA	  + " , "//タイムスタンプ
					  + " PRIMARY KEY ( " + COLUMN.KOSIN + ")); ";

		SQL = create + TBL_Name.UPDATE_MANAGE + colum;

		s.createTBL(SQL);

		//初期値の設定
		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_STOCK_ETF + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_INDEX + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_STATISTICS + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_CURRENCY + "' , '"+ ReCord.CURRENCY_KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_SEPA_CHECK + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_COMBINE_CHECK + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_BACK_UP + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);


		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_INVEST + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_CREDIT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_FORRIGN_RATIO + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_FINANCIAL + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
//				+ ") values ('" + ReCord.KOSHINBI_STOCK_LIST + "' , '"+ ReCord.LIST_KOSHINBI_SHOKI + "' )  " ;
				+ ") values ('" + ReCord.KOSHINBI_STOCK_LIST + "' , '"+ controllDay.getYesterDay() + "' )  " ;

		s.createTBL(SQL);










		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_INVEST_CHECK_POINT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);



		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_CREDIT_CHECK_POINT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_FORRIGN_RATIO_CHECK_POINT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_FINANCIAL_CHECK_POINT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);



		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_TOSHO_REIT + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);


		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_TOSHO_ETF + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);

		SQL = "insert into "
				+ TBL_Name.UPDATE_MANAGE
				+ " ( " + COLUMN.KOSIN
				+ " , "
				+ COLUMN.KOSIN_DAY
				+ ") values ('" + ReCord.KOSHINBI_MARKET_TBL + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

		s.createTBL(SQL);



	}


	//証券コード一覧を作成する.
	//列は、コード、業種、更新時刻
	private void createCodeList(S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;
		//作成するテーブルの名前

		//SQL文の取得
		String create = "create table ";


		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		colum = " ( " + COLUMN.CODE_KATA		 + " , "//証券コード
				+ COLUMN.CODENAME_KATA			 + " , "//銘柄名
				+ COLUMN.MARKET_KATA			 + " , "//取引市場
				+ COLUMN.CATEGORY_KATA			 + " , "//業種
				+ COLUMN.CATE_FLG_KATA			 + " , "//個別銘柄か統計か指数かとか
				+ COLUMN.STAMP_KATA				 + " , "//タイムスタンプ
				+ " PRIMARY KEY ( " + COLUMN.CODE + ")); ";
		//
		//証券市場
		//財閥フラグ、業界トップフラグ、業界トップフラグ

		SQL = create + TBL_Name.CODELISTTBL + colum;

		s.createTBL(SQL);
//		SQL = "insert into "
//				+ TBL_Name.CODELISTTBL
//				+ " ( " + COLUMN.CODE
//				+ " , "
//				+ COLUMN.CODENAME
//				+ ") values ('" + ReCord.KOSHINBI_STOCK_INDEX + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;
//
//		s.createTBL(SQL);
//
//		SQL = "insert into "
//				+ TBL_Name.CODELISTTBL
//				+ " ( " + COLUMN.CODE
//				+ " , "
//				+ COLUMN.CODENAME
//				+ ") values ('" + ReCord.KOSHINBI_STATISTICS + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;
//
//		s.createTBL(SQL);


	}


	//証券コードを引数にすると日足テーブルを作る
	//証券コードの末尾に_DDが付与される。例：9999_DD
	public void dayTable_Stock(String TBLNAME,S s){

		//SQL全文
		String SQL;
		//列名の取得
		String colum;
		//作成するテーブルの名前

		TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
		//SQL文の取得
		String create = "create table ";

		colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.OPEN_KATA									 + " , " //始値
				+ COLUMN.MAX_KATA									 + " , " //最高値
				+ COLUMN.MIN_KATA									 + " , " //最安値
				+ COLUMN.CLOSE_KATA									 + " , " //終値
				+ COLUMN.DEKI_KATA									 + " , " //出来高
				+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
				+ COLUMN.BEFORE_OPEN_KATA							 + " , " //調整後始値
				+ COLUMN.BEFORE_MAX_KATA								 + " , " //調整後最高値
				+ COLUMN.BEFORE_MIN_KATA								 + " , " //調整後最安値
				+ COLUMN.BEFORE_CLOSE_KATA							 + " , " //調整後終値
				+ COLUMN.BEFORE_DEKI_KATA							 + " , " //調整後出来高
				+ COLUMN.BEFORE_BAYBAY_KATA							 + " , " //調整後売買代金
				+ COLUMN.AJUSTRATE_KATA								 + " , " //調整レート。仕様はまだ決まっていないが、この値に株価を掛けることで調整したい。
				+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済み株式数
				+ COLUMN.MARKET_CAP_KATA							 + " , " //時価総額
//				+ COLUMN.M_AND_A_FLG_KATA							 + " , " //合併フラグ
//				+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
				+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
				+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO_KATA							 + " , " //（1-最安値)/最高値
				+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
				+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
				+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
				+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
				+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
				+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
				+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
				+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買い残
				+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売り残
				+ COLUMN.CREDIT_RATIO_KATA							 + " , " //信用倍率＝信用買い残÷信用売り残
				+ COLUMN.CREDIT_LONG_CHANGERATE_KATA				 + " , " //信用買い残前日比
				+ COLUMN.CREDIT_SHORT_CHANGERATE_KATA				 + " , " //信用売り残前日比
				+ COLUMN.CREDIT_RATIO_CHANGERATE_KATA				 + " , " //信用倍率前日比
				+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
				+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";






		//残り、インデックス
		//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
		//週足、月足、週足、５分足、財務諸表

		SQL = create + TBLNAME + colum;

		s.createTBL(SQL);

	}


	public void dayTable_INDEX(String TBLNAME,S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;
		//作成するテーブルの名前

		TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
		//SQL文の取得
		String create = "create table ";

		colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.OPEN_KATA									 + " , " //始値
				+ COLUMN.MAX_KATA									 + " , " //最高値
				+ COLUMN.MIN_KATA									 + " , " //最安値
				+ COLUMN.CLOSE_KATA									 + " , " //終値
//				+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
//				+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
//				+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
//				+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
				+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
				+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
				+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
				+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
				+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
				+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
				+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
				+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
				+ COLUMN.MAXMINRATIO_KATA							 + " , " //（1-最安値)/最高値
				+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
				+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
				+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
				+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
				+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
				+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
				+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
				+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
				+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
				+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
				+ COLUMN.MIDDLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
				+ COLUMN.MIDDLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
				+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
				+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
				+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
				+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値が何シグマにいるか。（少ないほうが上）
				+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
				+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
				+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
				+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
				+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
				+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
				+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
				+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
				+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
				+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
				+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
				+ COLUMN.LONG_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
				+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";

		SQL = create + TBLNAME + colum;

		s.createTBL(SQL);
	}


	public void dayTable_Statistical(String TBLNAME,S s){
		//SQL全文
		String SQL;
		//列名の取得
		String colum;
		//作成するテーブルの名前

		TBLNAME = TBLNAME + TBL_Name.TAIL_DAY ;
		//SQL文の取得
		String create = "create table ";

		colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
				+ COLUMN.DAYTIME_KATA								 + " , " //日付
				+ COLUMN.DEKI_KATA									 + " , " //出来高
				+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
				+ COLUMN.STOCK_NAME_NUM_KATA						 + " , " //全銘柄数
				+ COLUMN.STOCK_GETPRICE_KATA						 + " , " //寝付き
				+ COLUMN.STOCK_UPSTOCK_KATA							 + " , " //値上がり
				+ COLUMN.STOCK_NOCHANGE_KATA						 + " , " //変わらず
				+ COLUMN.STOCK_DOWNSTOCK_KATA						 + " , " //値下がり
				+ COLUMN.STOCK_NOCOMPARE_KATA						 + " , " //比較不可

				+ COLUMN.STOCK_UPPRICE_IDO_SHORT_KATA				 + " , " //値上がり短期移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_KATA				 + " , " //値上がり中期移動平均線
				+ COLUMN.STOCK_UPPRICE_IDO_LONG_KATA				 + " , " //値上がり長期移動平均線

				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_KATA				 + " , " //変わらず短期移動平均線
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_KATA			 + " , " //変わらず中期移動平均線
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_KATA				 + " , " //変わらず長期移動平均線
				+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
				+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";

		SQL = create + TBLNAME + colum;

		s.createTBL(SQL);
	}



}
