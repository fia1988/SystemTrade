package constant;

public class COLUMN {

	//count(*)
	public static String COUNT											= "count(*)";


	//エリートテーブルで設定する最大保有期間、エントリー回数、インターバルタイム、損切ライン
	public static String MAX_ENTRY_TIME									= "MAX_ENTRY_TIME";
	public static String MAX_ENTRY_TIME_KATA								= MAX_ENTRY_TIME + "  smallint  unsigned ";
	public static String MAX_KEEP_TIME									= "MAX_KEEP_TIME";
	public static String MAX_KEEP_TIME_KATA								= MAX_KEEP_TIME + "  smallint  unsigned ";
	//ただし1.0＝-100％
	public static String MAX_LOSS										= "MAX_LOSS";
	public static String MAX_LOSS_KATA								= MAX_LOSS + "  double   unsigned ";


	//今のインターバルタイム
	public static String NOW_INTERVAL									= "now_interval";
	public static String NOW_INTERVAL_KATA								= NOW_INTERVAL + "  smallint  unsigned ";
	//インターバルタイムの最大値
	public static String MAX_INTERVAL									= "MAX_interval";
	public static String MAX_INTERVAL_KATA								= MAX_INTERVAL + "  smallint  unsigned  ";


	//コードリストテーブルの列名
	//証券コード
	public static String CODE											= "code";
	public static String CODE_KATA										= CODE + " varchar(30) ";
	//銘柄名
	public static String CODENAME										= "codeName";
	public static String CODENAME_KATA									= CODENAME + " varchar(100) ";
	//取引市場
	public static String MARKET											= "market";
	public static String MARKET_KATA									= MARKET + " varchar(30) ";

	//業種
	public static String CATEGORY										= "category";
	public static String CATEGORY_KATA									= CATEGORY + " varchar(30) ";

	//銘柄かどうかを判断するフラグ。種類は以下
	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//通貨・・・5
	public static String CATE_FLG										= "cate_flg";
	public static String CATE_FLG_KATA									= CATE_FLG + " tinyint ";

	//タイムスタンプ
	public static String STAMP											= "STAMP";
	public static String STAMP_KATA										= STAMP + " TIMESTAMP ";


	//効力発生日
	public static String EFFECT_STARTDAY									= "effect_startDay";
	public static String EFFECT_STARTDAY_KATA								= EFFECT_STARTDAY + " DATE not null ";

	//権利付最終売買日
	public static String DAYTIME_KENRI_LAST									= "dayTime_kenri_last";
	public static String DAYTIME_KENRI_LAST_KATA							= DAYTIME_KENRI_LAST + " DATE not null ";
	//権利落ち日
	public static String DAYTIME_KENRI_OTI									= "dayTime_kenri_oti";
	public static String DAYTIME_KENRI_OTI_KATA								= DAYTIME_KENRI_OTI + " DATE not null ";

	//各種銘柄のテーブルの列名

	//日付
	public static String DAYTIME											= "dayTime";
	public static String DAYTIME_KATA										= DAYTIME + " DATE not null ";
	//始値
	public static String OPEN												= "open";
	public static String OPEN_KATA											= OPEN + " double unsigned  ";
	//最高値
	public static String MAX												= "max";
	public static String MAX_KATA											= MAX + " double unsigned  ";
	//最安値
	public static String MIN												= "min";
	public static String MIN_KATA											= MIN + " double unsigned  ";
	//終値
	public static String CLOSE												= "close";
	public static String CLOSE_KATA											= CLOSE + " double unsigned  ";
	//出来高
	public static String DEKI												= "DEKI";
	public static String DEKI_KATA											= DEKI + " BIGINT unsigned  ";
	//売買代金
	public static String BAYBAY												= "BAYBAY";
	public static String BAYBAY_KATA										= BAYBAY + " BIGINT unsigned  ";
	//調整後始値
	public static String BEFORE_OPEN											= "before_open";
	public static String BEFORE_OPEN_KATA									= BEFORE_OPEN + " double unsigned  ";
	//調整後最高値
	public static String BEFORE_MAX											= "before_max";
	public static String BEFORE_MAX_KATA										= BEFORE_MAX + " double unsigned  ";
	//調整後最安値
	public static String BEFORE_MIN											= "before_min";
	public static String BEFORE_MIN_KATA										= BEFORE_MIN + " double unsigned  ";
	//調整後終値
	public static String BEFORE_CLOSE										= "before_close";
	public static String BEFORE_CLOSE_KATA									= BEFORE_CLOSE + " double unsigned  ";
	//調整後出来高
	public static String BEFORE_DEKI											= "before_DEKI";
	public static String BEFORE_DEKI_KATA									= BEFORE_DEKI + " BIGINT unsigned  ";
	//調整後売買代金
	public static String BEFORE_BAYBAY										= "before_BAYBAY";
	public static String BEFORE_BAYBAY_KATA									= BEFORE_BAYBAY + " BIGINT unsigned  ";
	//調整レート。仕様はまだ決まっていないが、この値に株価を掛けることで調整したい。
	public static String AJUSTRATE											= "ajustRate";
	public static String AJUSTRATE_KATA										= AJUSTRATE + " double unsigned  ";
	//発行済み株式数
	public static String STOCK_NUM 											= "STOCK_NUM";
	public static String STOCK_NUM_KATA										= STOCK_NUM + " BIGINT unsigned  ";
	//時価総額
	public static String MARKET_CAP											= "Market_Cap";
	public static String MARKET_CAP_KATA									= MARKET_CAP + " BIGINT unsigned  ";
	//合併フラグ
	public static String M_AND_A_FLG										= "m_and_a_flg";
	public static String M_AND_A_FLG_KATA									= M_AND_A_FLG + " tinyint(1) ";
	//買いフラグ
	public static String LONG_FLG											= "Long_flg";
	public static String LONG_FLG_KATA										= LONG_FLG + " tinyint(1) ";
	//売りフラグ
	public static String SHORT_FLG											= "Short_flg";
	public static String SHORT_FLG_KATA 									= SHORT_FLG + " tinyint(1) ";
	//買いフラグ合計
	public static String L_TOTAL_FLG 										= "L_Total_flg";
	public static String L_TOTAL_FLG_KATA 									= L_TOTAL_FLG + " tinyint(2) ";
	//売りフラグ合計
	public static String S_TOTAL_A_FLG										= "S_Total_a_flg";
	public static String S_TOTAL_A_FLG_KATA									= S_TOTAL_A_FLG + " tinyint(2) ";
	//前日比
	public static String CHANGE_PRICE										= "change_Price";
	public static String CHANGE_PRICE_KATA 									= CHANGE_PRICE + " double ";
	//前日比率
	public static String CHANGERATE 										= "changeRate";
	public static String CHANGERATE_KATA 									= CHANGERATE + " double ";
	//株価短期間移動平均線
	public static String SHORTIDO 											= "shortIDO";
	public static String SHORTIDO_KATA 										= SHORTIDO + " double unsigned  ";
	//株価中期間移動平均線
	public static String MIDDLEIDO 											= "middleIDO";
	public static String MIDDLEIDO_KATA 									= MIDDLEIDO + " double unsigned  ";
	//株価長期間移動平均線
	public static String LONGIDO 											= "longIDO";
	public static String LONGIDO_KATA 										= LONGIDO + " double unsigned  ";
	//株価短期間移動平均線前日比
	public static String SHORTIDO_CHANGERATE 								= "shortIDO_ChangeRate";
	public static String SHORTIDO_CHANGERATE_KATA 							= SHORTIDO_CHANGERATE + " double ";
	//株価中期間移動平均線前日比
	public static String MIDDLEIDO_CHANGERATE 								= "middleIDO_ChangeRate";
	public static String MIDDLEIDO_CHANGERATE_KATA 							= MIDDLEIDO_CHANGERATE + " double ";
	//株価長期間移動平均線前日比
	public static String LONGIDO_CHANGERATE 										= "longIDO_ChangeRate";
	public static String LONGIDO_CHANGERATE_KATA									= LONGIDO_CHANGERATE + " double ";

	//株価短期間移動平均線前日比率
	public static String SHORTIDO_RATIO 								= "shortIDO_Ratio";
	public static String SHORTIDO_RATIO_KATA 							= SHORTIDO_RATIO + " double ";
	//株価中期間移動平均線前日比率
	public static String MIDDLEIDO_RATIO 								= "middleIDO_Ratio";
	public static String MIDDLEIDO_RATIO_KATA 							= MIDDLEIDO_RATIO + " double ";
	//株価長期間移動平均線前日比率
	public static String LONGIDO_RATIO 										= "longIDO_Ratio";
	public static String LONGIDO_RATIO_KATA									= LONGIDO_RATIO + " double ";

	//指数平滑移動平均短期
	public static String SHORTIDO_HEKATU 											= "shortIDO_HEKATU";
	public static String SHORTIDO_HEKATU_KATA 										= SHORTIDO_HEKATU + " double ";
	//指数平滑移動平均中期
	public static String MIDDLEIDO_HEKATU 											= "middleIDO_HEKATU";
	public static String MIDDLEIDO_HEKATU_KATA 										= MIDDLEIDO_HEKATU + " double ";
	//指数平滑移動平均長期
	public static String LONGIDO_HEKATU 											= "longIDO_HEKATU";
	public static String LONGIDO_HEKATU_KATA 										= LONGIDO_HEKATU + " double ";
	//指数平滑移動平均短期前日比
	public static String SHORTIDO_HEKATU_CHANGERATE									= "shortIDO_HEKATU_ChangeRate";
	public static String SHORTIDO_HEKATU_CHANGERATE_KATA 							= SHORTIDO_HEKATU_CHANGERATE + " double ";
	//指数平滑移動平均中期前日比
	public static String MIDDLEIDO_HEKATU_CHANGERATE								= "middleIDO_HEKATU_ChangeRate";
	public static String MIDDLEIDO_HEKATU_CHANGERATE_KATA 							= MIDDLEIDO_HEKATU_CHANGERATE + " double ";
	//指数平滑移動平均長期前日比
	public static String LONGIDO_HEKATU_CHANGERATE									= "longIDO_HEKATU_ChangeRate";
	public static String LONGIDO_HEKATU_CHANGERATE_KATA 							= LONGIDO_HEKATU_CHANGERATE + " double ";

	//指数平滑移動平均短期前日比率
	public static String SHORTIDO_HEKATU_RATIO									= "shortIDO_HEKATU_RATIO";
	public static String SHORTIDO_HEKATU_RATIO_KATA 							= SHORTIDO_HEKATU_RATIO + " double ";
	//指数平滑移動平均中期前日比率
	public static String MIDDLEIDO_HEKATU_RATIO								= "middleIDO_HEKATU_RATIO";
	public static String MIDDLEIDO_HEKATU_RATIO_KATA 							= MIDDLEIDO_HEKATU_RATIO + " double ";
	//指数平滑移動平均長期前日比率
	public static String LONGIDO_HEKATU_RATIO									= "longIDO_HEKATU_RATIO";
	public static String LONGIDO_HEKATU_RATIO_KATA 							= LONGIDO_HEKATU_RATIO + " double ";

	//当日の最高値-最安値
	public static String MAXMIN													= "maxmin";
	public static String MAXMIN_KATA											= MAXMIN + " double unsigned ";
	//（最高値-最安値)/1、ひげの長さ、MAX-MINが0のとき注意
	public static String MAXMINRATIO											= "maxminRatio";
	public static String MAXMINRATIO_KATA										= MAXMINRATIO + " double unsigned ";
	//ろうそく足の面積。（終値-始値）
	public static String CANDLE_AREA											= "candle_area";
	public static String CANDLE_AREA_KATA										= CANDLE_AREA + " double ";
	//ひげの長さと比較して、ろうそく足の面積はどの程度か
	public static String CANDLE_AREA_SCALE										= "candle_area_scale";
	public static String CANDLE_AREA_SCALE_KATA									= CANDLE_AREA_SCALE + " double ";
	//窓。前日の終値と今日の始値の差。終値ー始値
	public static String WINDOW													="window";
	public static String WINDOW_KATA											= WINDOW + " double ";
	//出来高前日比
	public static String DEKI_CHANGERATE = "DEKI_ChangeRate";
	public static String DEKI_CHANGERATE_KATA = DEKI_CHANGERATE + " double ";
	//出来高前日比率
	public static String DEKI_RATIO = "DEKI_RATIO";
	public static String DEKI_RATIO_KATA = DEKI_RATIO + " double ";
	//売買代金前日比
	public static String BAYBAY_CHANGERATE = "BAYBAY_ChangeRate";
	public static String BAYBAY_CHANGERATE_KATA = BAYBAY_CHANGERATE + " double ";
	//売買代金前日比率
	public static String BAYBAY_RATIO = "BAYBAY_RATIO";
	public static String BAYBAY_RATIO_KATA = BAYBAY_RATIO + " double ";
	//出来高短期移動平均線
	public static String SHORTIDO_DEKI = "shortIDO_DEKI";
	public static String SHORTIDO_DEKI_KATA = SHORTIDO_DEKI + " double ";
	//出来高中期移動平均線
	public static String MIDDLEIDO_DEKI = "middleIDO_DEKI";
	public static String MIDDLEIDO_DEKI_KATA = MIDDLEIDO_DEKI + " double ";
	//出来高長期移動平均線
	public static String LONGIDO_DEKI = "longIDO_DEKI";
	public static String LONGIDO_DEKI_KATA = LONGIDO_DEKI + " double ";


	//出来高短期間移動平均線前日比
	public static String SHORTIDO_DEKI_CHANGERATE = "shortIDO_DEKI_changeRate";
	public static String SHORTIDO_DEKI_CHANGERATE_KATA = SHORTIDO_DEKI_CHANGERATE + " double  ";
	//出来高中期移動平均線前日比
	public static String MIDDLEIDO_DEKI_CHANGERATE = "middleIDO_DEKI_changeRate";
	public static String MIDDLEIDO_DEKI_CHANGERATE_KATA = MIDDLEIDO_DEKI_CHANGERATE + " double  ";
	//出来高長期移動平均線前日比
	public static String LONGIDO_DEKI_CHANGERATE = "longIDO_DEKI_changeRate";
	public static String LONGIDO_DEKI_CHANGERATE_KATA = LONGIDO_DEKI_CHANGERATE + " double  ";

	//出来高短期間移動平均線前日比率
	public static String SHORTIDO_DEKI_RATIO = "shortIDO_DEKI_RATIO";
	public static String SHORTIDO_DEKI_RATIO_KATA = SHORTIDO_DEKI_RATIO + " double  ";
	//出来高中期移動平均線前日比率
	public static String MIDDLEIDO_DEKI_RATIO = "middleIDO_DEKI_RATIO";
	public static String MIDDLEIDO_DEKI_RATIO_KATA = MIDDLEIDO_DEKI_RATIO + " double  ";
	//出来高長期移動平均線前日比率
	public static String LONGIDO_DEKI_RATIO = "longIDO_DEKI_RATIO";
	public static String LONGIDO_DEKI_RATIO_KATA = LONGIDO_DEKI_RATIO + " double  ";

	//売買代金短期移動平均線
	public static String SHORTIDO_BAYBAY = "shortIDO_BAYBAY";
	public static String SHORTIDO_BAYBAY_KATA = SHORTIDO_BAYBAY + " double unsigned  ";
	//売買代金中期移動平均線
	public static String MIDDLEIDO_BAYBAY = "middleIDO_BAYBAY";
	public static String MIDDLEIDO_BAYBAY_KATA = MIDDLEIDO_BAYBAY + " double unsigned  ";
	//売買代金長期移動平均線
	public static String LONGIDO_BAYBAY = "longIDO_BAYBAY";
	public static String LONGIDO_BAYBAY_KATA = LONGIDO_BAYBAY + " double unsigned  ";
	//売買代金短期間移動平均線前日比
	public static String SHORTIDO_BAYBAY_CHANGERATE = "shortIDO_BAYBAY_changeRate";
	public static String SHORTIDO_BAYBAY_CHANGERATE_KATA = SHORTIDO_BAYBAY_CHANGERATE + " double  ";
	//売買代金中期間移動平均線前日比
	public static String MIDDLEIDO_BAYBAY_CHANGERATE = "middleIDO_BAYBAY_changeRate";
	public static String MIDDLEIDO_BAYBAY_CHANGERATE_KATA = MIDDLEIDO_BAYBAY_CHANGERATE + " double  ";
	//売買代金長期移動平均線前日比
	public static String LONGIDO_BAYBAY_CHANGERATE = "longIDO_BAYBAY_changeRate";
	public static String LONGIDO_BAYBAY_CHANGERATE_KATA = LONGIDO_BAYBAY_CHANGERATE + " double  ";

	//売買代金短期間移動平均線前日比率
	public static String SHORTIDO_BAYBAY_RATIO = "shortIDO_BAYBAY_RATIO";
	public static String SHORTIDO_BAYBAY_RATIO_KATA = SHORTIDO_BAYBAY_RATIO + " double  ";
	//売買代金中期間移動平均線前日比率
	public static String MIDDLEIDO_BAYBAY_RATIO = "middleIDO_BAYBAY_RATIO";
	public static String MIDDLEIDO_BAYBAY_RATIO_KATA = MIDDLEIDO_BAYBAY_RATIO + " double  ";
	//売買代金長期移動平均線前日比率
	public static String LONGIDO_BAYBAY_RATIO = "longIDO_BAYBAY_RATIO";
	public static String LONGIDO_BAYBAY_RATIO_KATA = LONGIDO_BAYBAY_RATIO + " double  ";

	//信用買い残
	public static String CREDIT_LONG = "Credit_Long";
	public static String CREDIT_LONG_KATA = CREDIT_LONG + " double ";
	//信用売り残
	public static String CREDIT_SHORT = "Credit_Short";
	public static String CREDIT_SHORT_KATA = CREDIT_SHORT + " double ";
	//信用倍率＝信用買い残÷信用売り残
	public static String CREDIT_RATIO = "Credit_Ratio";
	public static String CREDIT_RATIO_KATA = CREDIT_RATIO + " double ";
	//信用買い残前日比
	public static String CREDIT_LONG_CHANGERATE = "Credit_Long_ChangeRate";
	public static String CREDIT_LONG_CHANGERATE_KATA = CREDIT_LONG_CHANGERATE + " double ";
	//信用売り残前日比
	public static String CREDIT_SHORT_CHANGERATE = "Credit_Short_ChangeRate";
	public static String CREDIT_SHORT_CHANGERATE_KATA = CREDIT_SHORT_CHANGERATE + " double ";

	//信用買い残前週比
	public static String CREDIT_LONG_CHANGERATE_W = "Credit_Long_ChangeRate";
	public static String CREDIT_LONG_CHANGERATE_W_KATA = CREDIT_LONG_CHANGERATE_W + " double ";
	//信用売り残前週比
	public static String CREDIT_SHORT_CHANGERATE_W = "Credit_Short_ChangeRate";
	public static String CREDIT_SHORT_CHANGERATE_W_KATA = CREDIT_SHORT_CHANGERATE_W + " double ";

	//信用倍率前日比
	public static String CREDIT_RATIO_CHANGERATE = "Credit_Ratio_ChangeRate";
	public static String CREDIT_RATIO_CHANGERATE_KATA = CREDIT_RATIO_CHANGERATE + " double ";
	//短期間の標準偏差（シグマ）
	public static String SHORT_DEV = "short_dev";
	public static String SHORT_DEV_KATA = SHORT_DEV + " double ";
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	public static String SHORT_NOW_SIGMA = "short_now_sigma";
	public static String SHORT_NOW_SIGMA_KATA = SHORT_NOW_SIGMA + " double ";
	//短期間でのシグマ１
	public static String SHORT_1_H_SIGMA = "short_1_sigma_h";
	public static String SHORT_1_H_SIGMA_KATA = SHORT_1_H_SIGMA + " double ";
	//短期間でのマイナスシグマ１
	public static String SHORT_1_L_SIGMA = "short_1_sigma_l";
	public static String SHORT_1_L_SIGMA_KATA = SHORT_1_L_SIGMA + " double ";
	//短期間でのシグマ２
	public static String SHORT_2_H_SIGMA = "short_2_sigma_h";
	public static String SHORT_2_H_SIGMA_KATA = SHORT_2_H_SIGMA + " double ";
	//短期間でのマイナスシグマ２
	public static String SHORT_2_L_SIGMA = "short_2_sigma_l";
	public static String SHORT_2_L_SIGMA_KATA = SHORT_2_L_SIGMA + " double ";
	//短期間でのシグマ３
	public static String SHORT_3_H_SIGMA = "short_3_sigma_h";
	public static String SHORT_3_H_SIGMA_KATA = SHORT_3_H_SIGMA + " double ";
	//短期間でのマイナスシグマ３
	public static String SHORT_3_L_SIGMA = "short_3_sigma_l";
	public static String SHORT_3_L_SIGMA_KATA = SHORT_3_L_SIGMA + " double ";
	//中期間の標準偏差（シグマ）
	public static String MIDDLE_DEV = "middle_dev";
	public static String MIDDLE_DEV_KATA = MIDDLE_DEV + " double ";
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	public static String MIDDLE_NOW_SIGMA = "middle_now_sigma";
	public static String MIDDLE_NOW_SIGMA_KATA = MIDDLE_NOW_SIGMA + " double ";
	//中期間のシグマ１
	public static String MIDDLE_1_H_SIGMA = "middle_1_sigma_h";
	public static String MIDDLE_1_H_SIGMA_KATA = MIDDLE_1_H_SIGMA + " double ";
	//中期間のマイナスシグマ１
	public static String MIDDLE_1_L_SIGMA = "middle_1_sigma_l";
	public static String MIDDLE_1_L_SIGMA_KATA = MIDDLE_1_L_SIGMA + " double ";
	//中期間のシグマ２
	public static String MIDDLE_2_H_SIGMA = "midlle_2_sigma_h";
	public static String MIDDLE_2_H_SIGMA_KATA = MIDDLE_2_H_SIGMA + " double ";
	//中期間のマイナスシグマ２
	public static String MIDDLE_2_L_SIGMA = "midlle_2_sigma_l";
	public static String MIDDLE_2_L_SIGMA_KATA = MIDDLE_2_L_SIGMA + " double ";
	//中期間のシグマ３
	public static String MIDDLE_3_H_SIGMA = "middle_3_sigma_h";
	public static String MIDDLE_3_H_SIGMA_KATA = MIDDLE_3_H_SIGMA + " double ";
	//中期間のマイナスシグマ３
	public static String MIDDLE_3_L_SIGMA = "middle_3_sigma_l";
	public static String MIDDLE_3_L_SIGMA_KATA = MIDDLE_3_L_SIGMA + " double ";
	//長期間の標準偏差（シグマ）
	public static String LONG_DEV = "long_dev";
	public static String LONG_DEV_KATA = LONG_DEV + " double ";
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	public static String LONG_NOW_SIGMA = "long_now_sigma";
	public static String LONG_NOW_SIGMA_KATA = LONG_NOW_SIGMA + " double ";
	//長期間のシグマ１
	public static String LONG_1_H_SIGMA = "long_1_sigma_h";
	public static String LONG_1_H_SIGMA_KATA = LONG_1_H_SIGMA + " double ";
	//長期間のマイナスシグマ１
	public static String LONG_1_L_SIGMA = "long_1_sigma_l";
	public static String LONG_1_L_SIGMA_KATA = LONG_1_L_SIGMA + " double ";
	//長期間のシグマ２
	public static String LONG_2_H_SIGMA = "long_2_sigma_h";
	public static String LONG_2_H_SIGMA_KATA = LONG_2_H_SIGMA + " double ";
	//長期間のマイナスシグマ２
	public static String LONG_2_L_SIGMA = "long_2_sigma_l";
	public static String LONG_2_L_SIGMA_KATA = LONG_2_L_SIGMA + " double ";
	//長期間のシグマ３
	public static String LONG_3_H_SIGMA = "long_3_sigma_h";
	public static String LONG_3_H_SIGMA_KATA = LONG_3_H_SIGMA + " double ";
	//長期間のマイナスシグマ３
	public static String LONG_3_L_SIGMA = "long_3_sigma_l";
	public static String LONG_3_L_SIGMA_KATA = LONG_3_L_SIGMA + " double ";
	//短期MACD
	public static String SHORT_MACD = "short_MACD";
	public static String SHORT_MACD_KATA = SHORT_MACD + " double ";
	//短期MACDシグナル線
	public static String SHORT_MACD_SIGNAL = "short_MACD_signal";
	public static String SHORT_MACD_SIGNAL_KATA = SHORT_MACD_SIGNAL + " double ";
	//中期MACD
	public static String MIDDLE_MACD = "middle_MACD";
	public static String MIDDLE_MACD_KATA = MIDDLE_MACD + " double ";
	//中期MACDシグナル線
	public static String MIDDLE_MACD_SIGNAL = "middle_MACD_signal";
	public static String MIDDLE_MACD_SIGNAL_KATA = MIDDLE_MACD_SIGNAL + " double ";
	//長期MACD
	public static String LONG_MACD = "long_MACD";
	public static String LONG_MACD_KATA = LONG_MACD + " double ";
	//長期MACDシグナル線
	public static String LONG_MACD_SIGNAL = "longt_MACD_signal";
	public static String LONG_MACD_SIGNAL_KATA = LONG_MACD_SIGNAL + " double ";


	//銘柄数
	public static String STOCK_NAME_NUM										= "stock_name_num";
	public static String STOCK_NAME_NUM_KATA								= STOCK_NAME_NUM + " smallint unsigned ";
	//値付き
	public static String STOCK_GETPRICE 									= "stock_getprice";
	public static String STOCK_GETPRICE_KATA 								= STOCK_GETPRICE  + " smallint ";
	//値上がり
	public static String STOCK_UPSTOCK										= "stock_upstock";
	public static String STOCK_UPSTOCK_KATA 								= STOCK_UPSTOCK + " smallint ";
	//変わらず
	public static String STOCK_NOCHANGE										= "stock_nochange";
	public static String STOCK_NOCHANGE_KATA 								= STOCK_NOCHANGE + " smallint ";
	//値下がり
	public static String STOCK_DOWNSTOCK									= "stock_downstock";
	public static String STOCK_DOWNSTOCK_KATA 								= STOCK_DOWNSTOCK + " smallint ";
	//比較不可
	public static String STOCK_NOCOMPARE									= "stock_nocompare";
	public static String STOCK_NOCOMPARE_KATA 								= STOCK_NOCOMPARE + " smallint ";

	//当日の銘柄数-値付き
	public static String NETUKI_MAXMIN = "NETUKI_maxmin";
	public static String NETUKI_MAXMIN_KATA = NETUKI_MAXMIN + "  smallint unsigned  ";
	//値上がり銘柄数 ÷ 値下がり銘柄数 ×100
	public static String NETUKI_MAXMINRATIO = "NETUKI_maxminRatio";
	public static String NETUKI_MAXMINRATIO_KATA = NETUKI_MAXMINRATIO + " double ";



	//値付き前日比
	public static String STOCK_GETPRICE_CHANGERATE = "STOCK_GETPRICE_ChangeRate";
	public static String STOCK_GETPRICE_CHANGERATE_KATA = STOCK_GETPRICE_CHANGERATE + " smallint ";
	//値付き前日比率
	public static String STOCK_GETPRICE_RATIO = "STOCK_GETPRICE_RATIO";
	public static String STOCK_GETPRICE_RATIO_KATA = STOCK_GETPRICE_RATIO + " double ";

	//値付き短期移動平均線
	public static String STOCK_GETPRICE_IDO_SHORT							= "STOCK_GETPRICE_ido_short";
	public static String STOCK_GETPRICE_IDO_SHORT_KATA 						= STOCK_GETPRICE_IDO_SHORT + " double ";
	//値付き中期移動平均線
	public static String STOCK_GETPRICE_IDO_MIDDLE							= "STOCK_GETPRICE_ido_middle";
	public static String STOCK_GETPRICE_IDO_MIDDLE_KATA 						= STOCK_GETPRICE_IDO_MIDDLE + " double ";
	//値付き長期移動平均線
	public static String STOCK_GETPRICE_IDO_LONG								= "STOCK_GETPRICE_ido_long";
	public static String STOCK_GETPRICE_IDO_LONG_KATA 						= STOCK_GETPRICE_IDO_LONG + " double ";

	//値付き短期間移動平均線前日比
	public static String STOCK_GETPRICE_IDO_SHORT_CHANGERATE = "shortIDO_STOCK_GETPRICE_changeRate";
	public static String STOCK_GETPRICE_IDO_SHORT_CHANGERATE_KATA = STOCK_GETPRICE_IDO_SHORT_CHANGERATE + " double  ";
	//値付き中期間移動平均線前日比
	public static String STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE = "middleIDO_STOCK_GETPRICE_changeRate";
	public static String STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_KATA = STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE + " double  ";
	//値付き長期間移動平均線前日比
	public static String STOCK_GETPRICE_IDO_LONG_CHANGERATE = "longIDO_STOCK_GETPRICE_changeRate";
	public static String STOCK_GETPRICE_IDO_LONG_CHANGERATE_KATA = STOCK_GETPRICE_IDO_LONG_CHANGERATE + " double  ";

	//値付き短期間移動平均線前日比率
	public static String STOCK_GETPRICE_IDO_SHORT_RATIO = "shortIDO_STOCK_GETPRICE_RATIO";
	public static String STOCK_GETPRICE_IDO_SHORT_RATIO_KATA = STOCK_GETPRICE_IDO_SHORT_RATIO + " double  ";
	//値付き中期間移動平均線前日比率
	public static String STOCK_GETPRICE_IDO_MIDDLE_RATIO = "middleIDO_STOCK_GETPRICE_RATIO";
	public static String STOCK_GETPRICE_IDO_MIDDLE_RATIO_KATA = STOCK_GETPRICE_IDO_MIDDLE_RATIO + " double  ";
	//値付き長期間移動平均線前日比率
	public static String STOCK_GETPRICE_IDO_LONG_RATIO = "longIDO_STOCK_GETPRICE_RATIO";
	public static String STOCK_GETPRICE_IDO_LONG_RATIO_KATA = STOCK_GETPRICE_IDO_LONG_RATIO + " double  ";






	//値上がり前日比
	public static String STOCK_UPPRICE_CHANGERATE = "stock_upprice_ChangeRate";
	public static String STOCK_UPPRICE_CHANGERATE_KATA = STOCK_UPPRICE_CHANGERATE + " smallint ";
	//値上がり前日比率
	public static String STOCK_UPPRICE_RATIO = "stock_upprice_RATIO";
	public static String STOCK_UPPRICE_RATIO_KATA = STOCK_UPPRICE_RATIO + " double ";

	//値上がり短期移動平均線
	public static String STOCK_UPPRICE_IDO_SHORT							= "stock_upprice_ido_short";
	public static String STOCK_UPPRICE_IDO_SHORT_KATA 						= STOCK_UPPRICE_IDO_SHORT + " double ";
	//値上がり中期移動平均線
	public static String STOCK_UPPRICE_IDO_MIDDLE							= "stock_upprice_ido_middle";
	public static String STOCK_UPPRICE_IDO_MIDDLE_KATA 						= STOCK_UPPRICE_IDO_MIDDLE + " double ";
	//値上がり長期移動平均線
	public static String STOCK_UPPRICE_IDO_LONG								= "stock_upprice_ido_long";
	public static String STOCK_UPPRICE_IDO_LONG_KATA 						= STOCK_UPPRICE_IDO_LONG + " double ";

	//値上がり短期間移動平均線前日比
	public static String STOCK_UPPRICE_IDO_SHORT_CHANGERATE = "shortIDO_stock_upprice_changeRate";
	public static String STOCK_UPPRICE_IDO_SHORT_CHANGERATE_KATA = STOCK_UPPRICE_IDO_SHORT_CHANGERATE + " double  ";
	//値上がり中期間移動平均線前日比
	public static String STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE = "middleIDO_stock_upprice_changeRate";
	public static String STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_KATA = STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE + " double  ";
	//値上がり長期間移動平均線前日比
	public static String STOCK_UPPRICE_IDO_LONG_CHANGERATE = "longIDO_stock_upprice_changeRate";
	public static String STOCK_UPPRICE_IDO_LONG_CHANGERATE_KATA = STOCK_UPPRICE_IDO_LONG_CHANGERATE + " double  ";

	//値上がり短期間移動平均線前日比率
	public static String STOCK_UPPRICE_IDO_SHORT_RATIO = "shortIDO_stock_upprice_RATIO";
	public static String STOCK_UPPRICE_IDO_SHORT_RATIO_KATA = STOCK_UPPRICE_IDO_SHORT_RATIO + " double  ";
	//値上がり中期間移動平均線前日比率
	public static String STOCK_UPPRICE_IDO_MIDDLE_RATIO = "middleIDO_stock_upprice_RATIO";
	public static String STOCK_UPPRICE_IDO_MIDDLE_RATIO_KATA = STOCK_UPPRICE_IDO_MIDDLE_RATIO + " double  ";
	//値上がり長期間移動平均線前日比率
	public static String STOCK_UPPRICE_IDO_LONG_RATIO = "longIDO_stock_upprice_RATIO";
	public static String STOCK_UPPRICE_IDO_LONG_RATIO_KATA = STOCK_UPPRICE_IDO_LONG_RATIO + " double  ";

	//変わらず前日比
	public static String STOCK_NOCHANGE_CHANGERATE = "stock_nochange_ChangeRate";
	public static String STOCK_NOCHANGE_CHANGERATE_KATA = STOCK_NOCHANGE_CHANGERATE + " smallint ";
	//変わらず前日比率
	public static String STOCK_NOCHANGE_RATIO = "stock_nochange_RATIO";
	public static String STOCK_NOCHANGE_RATIO_KATA = STOCK_NOCHANGE_RATIO + " double ";

	//変わらず短期移動平均線
	public static String STOCK_NOCHANGE_IDO_SHORT								= "stock_nochange_ido_short";
	public static String STOCK_NOCHANGE_IDO_SHORT_KATA 						= STOCK_NOCHANGE_IDO_SHORT + " double ";
	//変わらず短期移動平均線
	public static String STOCK_NOCHANGE_IDO_MIDDLE								= "stock_nochange_ido_middle";
	public static String STOCK_NOCHANGE_IDO_MIDDLE_KATA 						= STOCK_NOCHANGE_IDO_MIDDLE + " double ";
	//変わらず短期移動平均線
	public static String STOCK_NOCHANGE_IDO_LONG								= "stock_nochange_ido_long";
	public static String STOCK_NOCHANGE_IDO_LONG_KATA		 					= STOCK_NOCHANGE_IDO_LONG + " double ";

	//変わらず短期間移動平均線前日比
	public static String STOCK_NOCHANGE_IDO_SHORT_CHANGERATE = "shortIDO_stock_nochange_changeRate";
	public static String STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_KATA = STOCK_NOCHANGE_IDO_SHORT_CHANGERATE + " double  ";
	//変わらず中期間移動平均線前日比
	public static String STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE = "middleIDO_stock_nochange_changeRate";
	public static String STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_KATA = STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE + " double  ";
	//変わらず長期間移動平均線前日比
	public static String STOCK_NOCHANGE_IDO_LONG_CHANGERATE = "longIDO_stock_nochange_changeRate";
	public static String STOCK_NOCHANGE_IDO_LONG_CHANGERATE_KATA = STOCK_NOCHANGE_IDO_LONG_CHANGERATE + " double  ";

	//変わらず短期間移動平均線前日比率
	public static String STOCK_NOCHANGE_IDO_SHORT_RATIO = "shortIDO_stock_nochange_RATIO";
	public static String STOCK_NOCHANGE_IDO_SHORT_RATIO_KATA = STOCK_NOCHANGE_IDO_SHORT_RATIO + " double  ";
	//変わらず中期間移動平均線前日比率
	public static String STOCK_NOCHANGE_IDO_MIDDLE_RATIO = "middleIDO_stock_nochange_RATIO";
	public static String STOCK_NOCHANGE_IDO_MIDDLE_RATIO_KATA = STOCK_NOCHANGE_IDO_MIDDLE_RATIO + " double  ";
	//変わらず長期間移動平均線前日比率
	public static String STOCK_NOCHANGE_IDO_LONG_RATIO = "longIDO_stock_nochange_RATIO";
	public static String STOCK_NOCHANGE_IDO_LONG_RATIO_KATA = STOCK_NOCHANGE_IDO_LONG_RATIO + " double  ";

	//値下がり短期移動平均線
	public static String STOCK_DOWNSTOCK_IDO_SHORT								= "stock_downstock_ido_short";
	public static String STOCK_DOWNSTOCK_IDO_SHORT_KATA 						= STOCK_DOWNSTOCK_IDO_SHORT + " double ";
	//値下がり中期移動平均線
	public static String STOCK_DOWNSTOCK_IDO_MIDDLE								= "stock_downstock_ido_middle";
	public static String STOCK_DOWNSTOCK_IDO_MIDDLE_KATA 						= STOCK_DOWNSTOCK_IDO_MIDDLE + " double ";
	//値下がり長期移動平均線
	public static String STOCK_DOWNSTOCK_IDO_LONG								= "stock_downstock_ido_long";
	public static String STOCK_DOWNSTOCK_IDO_LONG_KATA 							= STOCK_DOWNSTOCK_IDO_LONG + " double ";

	//値下がり短期間移動平均線前日比
	//値下がり中期間移動平均線前日比
	//値下がり長期間移動平均線前日比

	//値下がり短期間移動平均線前日比率
	//値下がり中期間移動平均線前日比率
	//値下がり長期間移動平均線前日比率


//新テーブル
	//購入日
	public static String ENTRYDAY												= "entryDay";
	public static String ENTRYDAY_KATA											= ENTRYDAY  + " DATE not null ";

	//前回購入日
	public static String LASTENTRYDAY												= "lastEntryDay";
	public static String LASTENTRYDAY_KATA											= LASTENTRYDAY  + " DATE not null ";

	//購入回数
	public static String ENTRYTIMES = "entryTimes";
	public static String ENTRYTIMES_KATA = ENTRYTIMES + " smallint  unsigned ";

	//平均取得価格
	public static String AVERAGEPRICE = "averagePrice";
	public static String AVERAGEPRICE_KATA = AVERAGEPRICE + " double unsigned  ";

	//現実的平均取得価格
	public static String REAL_AVERAGEPRICE = "REALaveragePrice";
	public static String REAL_AVERAGEPRICE_KATA = REAL_AVERAGEPRICE + " double unsigned  ";

	//理想的平均取得価格
	public static String IDEA_AVERAGEPRICE = "IDEAaveragePrice";
	public static String IDEA_AVERAGEPRICE_KATA = IDEA_AVERAGEPRICE + " double unsigned  ";

	//現実的合計投資金額
	public static String REAL_TOTAL_ENTRY_MONEY = "REAL_TOTAL_ENTRY_MONEY";
	public static String REAL_TOTAL_ENTRY_MONEY_KATA = REAL_TOTAL_ENTRY_MONEY + " int unsigned  ";

	//理想的合計投資金額
	public static String IDEA_TOTAL_ENTRY_MONEY = "IDEA_TOTAL_ENTRY_MONEY";
	public static String IDEA_TOTAL_ENTRY_MONEY_KATA = IDEA_TOTAL_ENTRY_MONEY + " double unsigned  ";

	//タイプ。分足とか日足とかを区別
	public static String TYPE = "type";
	public static String TYPE_KATA = TYPE + " varchar(2)" ;

	//エントリーmethod
	public static String ENTRYMETHOD = "entryMethod";
	public static String ENTRYMETHOD_KATA = ENTRYMETHOD + " varchar(100)" ;

	//出口メソッド
	public static String EXITMETHOD = "exitMethod";
	public static String EXITMETHOD_KATA = EXITMETHOD + " varchar(100)" ;

	//販売日、出口
	public static String EXITDAY												= "exitDay";
	public static String EXITDAY_KATA											= EXITDAY  + " DATE not null ";

	//販売価格
	public static String EXITPRICE = "exitPrice";
	public static String EXITPRICE_KATA = EXITPRICE + " double unsigned  ";

	//リターン
	public static String RESULTRETURN								= "resultReturn";
	public static String RESULTRETURN_KATA		 					= RESULTRETURN + " double ";

	//トータルリターン
	public static String TOTAL_RETURN								= "totalReturn";
	public static String TOTAL_RETURN_KATA							= TOTAL_RETURN + " double ";

	//現実的リターン
	public static String REAL_RETURN								= "RealReturn";
	public static String REAL_RETURN_KATA							= REAL_RETURN + " double ";

	//理想的リターン
	public static String IDEA_RETURN								= "IDEAReturn";
	public static String IDEA_RETURN_KATA							= IDEA_RETURN + " double ";

	//保有期間
	public static String KEEPTIME = "keepTime";
	public static String KEEPTIME_KATA = KEEPTIME + " smallint unsigned   ";

	//売買サインフラグ。true買い、false売り
	public static String SIGN_FLG											= "sign_flg";
	public static String SIGN_FLG_KATA 									= SIGN_FLG + " tinyint(1) ";

	//売買単位、単元株
	public static String VOLUME_UNIT = "volumeUnit";
	public static String VOLUME_UNIT_KATA = VOLUME_UNIT + " int unsigned  ";

	//ミニ株本株チェック trueミニ株、false普通株
	public static String MINI_CHECK_FLG											= "MINI_CHECK_flg";
	public static String MINI_CHECK_FLG_KATA 									= MINI_CHECK_FLG + " tinyint(1) ";

	//理想的購入枚数
	public static String IDEA_VOLUME = "ideallyVolume";
	public static String IDEA_VOLUME_KATA = IDEA_VOLUME + " double unsigned  ";

	//現実的購入枚数
	public static String REAL_ENTRY_VOLUME = "realEntryVolume";
	public static String REAL_ENTRY_VOLUME_KATA = REAL_ENTRY_VOLUME + " int unsigned  ";

	//エントリー金額
	public static String ENTRY_MONEY = "entry_money";
	public static String ENTRY_MONEY_KATA = ENTRY_MONEY + " int unsigned  ";

	//更新内容
	public static String KOSIN													= "KOSIN";
	public static String KOSIN_KATA	 											= KOSIN + " varchar(30) ";
	//更新内容
	public static String KOSIN_DAY												= "KOSIN_DAY";
	public static String KOSIN_DAY_KATA	 										= KOSIN_DAY + " varchar(30) ";
	//株式の分割処理の終了フラグ
	public static String SEPA_FLG												= "SEPA_FLG";
	public static String SEPA_FLG_KATA											= SEPA_FLG + " tinyint(1) ";
	//分割/併合の判断。分割の場合はtrue、併合の場合はfalse
	public static String CHECKSEPA_COMBINE										= "checksepa_combine";
	public static String CHECKSEPA_COMBINE_KATA									= CHECKSEPA_COMBINE + " tinyint(1) ";

	//備考
	public static String BIKOU													= "bikou";
	public static String BIKOU_KATA	 											= BIKOU + " varchar(30) ";

	//プロパティテーブルの列
	//項目
	public static String ITEMNAME										= "itemName";
	public static String ITEMNAME_KATA									= ITEMNAME + " varchar(100) ";

	//項目内容
	public static String ITEMNAME_DESC										= "itemNameDesc";
	public static String ITEMNAME_DESC_KATA									= ITEMNAME_DESC + " varchar(100) ";

	//キックファイルを配るフォルダ名
	public static String KICK_FILE_USER_FOLDER								= "kick_file_user";
	public static String KICK_FILE_USER_FOLDER_KATA								= KICK_FILE_USER_FOLDER + " varchar(100) ";

	//オールチェックフラグ true全部株、false特定手法のみ
	public static String ALL_CHECK_FLG											= "ALL_CHECK_flg";
	public static String ALL_CHECK_FLG_KATA 									= ALL_CHECK_FLG + " tinyint(1) ";

	//有料会員リストの列名
	//期限日付
	public static String LIMIT_DAYTIME											= "limit_dayTime";
	public static String LIMIT_DAYTIME_KATA										= LIMIT_DAYTIME + " DATE not null ";

	//今日の更新日
	public static String KOSIN_DAYTIME											= "kosin_dayTime";
	public static String KOSIN_DAYTIME_KATA										= KOSIN_DAYTIME + " DATE not null ";


	//この辺はjapan-all-stock-financial-resul
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results.csv
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results_20171007.csv
	//決算期
	public static String KESSAN_TERM_YYYY_MM_STRING						= "KESSAN_TERM_YYYY_MM_STRING";
	public static String KESSAN_TERM_YYYY_MM_STRING_KATA				= KESSAN_TERM_YYYY_MM_STRING + " varchar(10)";

	//決算発表日
	public static String YEAR_KESSAN_TIME_YYYYMMDD						= "YEAR_KESSAN_TIME_YYYYMMDD";
	public static String YEAR_KESSAN_TIME_YYYYMMDD_KATA					= YEAR_KESSAN_TIME_YYYYMMDD + " DATE ";

	//売上高_単位：百万円
	public static String URIAGE_DAKA_PPT 								= "URIAGE_DAKA_PPT";
	public static String URIAGE_DAKA_PPT_KATA							= URIAGE_DAKA_PPT + " BIGINT ";

	//営業利益_単位：百万円
	public static String EIGYO_PROF_PPT 								= "EIGYO_PROF_PPT";
	public static String EIGYO_PROF_PPT_KATA							= EIGYO_PROF_PPT + " BIGINT  ";

	//経常利益_単位：百万円
	public static String KEIJO_PROF_PPT 								= "KEIJO_PROF_PPT";
	public static String KEIJO_PROF_PPT_KATA							= KEIJO_PROF_PPT + " BIGINT  ";

	//当期純利益_単位：百万円
	public static String BOTTOM_LINE_PPT 								= "BOTTOM_LINE_PPT";
	public static String BOTTOM_LINE_PPT_KATA							= BOTTOM_LINE_PPT + " BIGINT ";

	//総資産_単位：百万円
	public static String TOTAL_ASSET_PPT 								= "TOTAL_ASSET_PPT";
	public static String TOTAL_ASSET_PPT_KATA							= TOTAL_ASSET_PPT + " BIGINT ";

	//自己資本_単位：百万円
	public static String SELF_ASSET_PPT 								= "SELF_ASSET_PPT";
	public static String SELF_ASSET_PPT_KATA							= SELF_ASSET_PPT + " BIGINT ";

	//資本金_単位：百万円
	public static String SHIHONKIN_ASSET_PPT 							= "SHIHONKIN_ASSET_PPT";
	public static String SHIHONKIN_ASSET_PPT_KATA						= SHIHONKIN_ASSET_PPT + " BIGINT ";

	//有利子負債_単位：百万円
	public static String LOAN_PPT 										= "LOAN_PPT";
	public static String LOAN_PPT_KATA									= LOAN_PPT + " BIGINT ";

	//自己資本比率
	public static String SELF_ASSET_WARIAI 								= "SELF_ASSET_WARIAI";
	public static String SELF_ASSET_WARIAI_KATA 						= SELF_ASSET_WARIAI + " double ";

	//ROE
	public static String ROE 											= "ROE";
	public static String ROE_KATA 										= ROE + " double ";

	//ROA
	public static String ROA 											= "ROA";
	public static String ROA_KATA 										= ROA + " double ";


	//この辺はjapan-all-stock-data_20171031.csv
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data_20171031.csv
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data.csv
	//時価総額_単位：百万円
	public static String MARKET_CAP_PPT									= "Market_Cap_PPT";
	public static String MARKET_CAP_PPT_KATA							= MARKET_CAP_PPT + " BIGINT unsigned  ";

//	配当利回り
	public static String DIVIDEND_PER 									= "DIVIDEND_PER";
	public static String DIVIDEND_PER_KATA 								= DIVIDEND_PER + " double ";
//	1株配当
	public static String DIVIDEND 										= "DIVIDEND";
	public static String DIVIDEND_KATA 									= DIVIDEND + " double ";
//	PER（予想）
	public static String PER_YOSO 										= "PER_YOSO";
	public static String PER_YOSO_KATA 									= PER_YOSO + " double ";
//	PBR（実績）
	public static String PBR_REAL 										= "PBR_REAL";
	public static String PBR_REAL_KATA 									= PBR_REAL + " double ";
//	EPS（予想）
	public static String EPS_YOSO 										= "EPS_YOSO";
	public static String EPS_YOSO_KATA 									= EPS_YOSO + " double ";
//	BPS（実績）
	public static String BPS_REAL 										= "BPS_REAL";
	public static String BPS_REAL_KATA 									= BPS_REAL + " double ";
//	最低購入額
	public static String MIN_BUY_PRICE 									= "MIN_BUY_PRICE";
	public static String MIN_BUY_PRICE_KATA 							= MIN_BUY_PRICE + " double ";

//	高値日付
	public static String YEAR_MAX_DAY_YYYYMMDD							= "YEAR_MAX_DAY_YYYYMMDD_YYYYMMDD";
	public static String YEAR_MAX_DAY_YYYYMMDD_KATA						= YEAR_MAX_DAY_YYYYMMDD + " DATE ";
//	年初来高値
	public static String YEAR_MAX										= "YEAR_MAX";
	public static String YEAR_MAX_KATA									= YEAR_MAX + " double unsigned  ";
//	安値日付
	public static String YEAR_MIN_DAY_YYYYMMDD							= "YEAR_MIN_DAY_YYYYMMDD_YYYYMMDD";
	public static String YEAR_MIN_DAY_YYYYMMDD_KATA						= YEAR_MIN_DAY_YYYYMMDD + " DATE ";
//	年初来安値
	public static String YEAR_MIN										= "YEAR_min";
	public static String YEAR_MIN_KATA									= YEAR_MIN + " double unsigned  ";

	//この辺はshareholding-ratio.csv
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio.csv
	//https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio_20171008.csv
	//浮動株数比率
	public static String ANOTHER_STOCK_HOLDER_RATIO						= "ANOTHER_STOCK_HOLDER_RATIO";
	public static String ANOTHER_STOCK_HOLDER_RATIO_KATA				= ANOTHER_STOCK_HOLDER_RATIO + " double unsigned  ";
	//少数特定者持株数比率
	public static String MAJOR_STOCK_HOLDER_RATIO						= "MAJOR_STOCK_HOLDER_RATIO";
	public static String MAJOR_STOCK_HOLDER_RATIO_KATA					= MAJOR_STOCK_HOLDER_RATIO + " double unsigned  ";
	//投資信託持株数比率
	public static String ETF_STOCK_HOLDER_RATIO							= "ETF_STOCK_HOLDER_RATIO";
	public static String ETF_STOCK_HOLDER_RATIO_KATA					= ETF_STOCK_HOLDER_RATIO + " double unsigned  ";
	//外国人持株数比率
	public static String FOREIGNER_STOCK_HOLDER_RATIO					= "FOREIGNER_STOCK_HOLDER_RATIO";
	public static String FOREIGNER_STOCK_HOLDER_RATIO_KATA				= FOREIGNER_STOCK_HOLDER_RATIO + " double unsigned  ";

	//_単位：百万円



}
