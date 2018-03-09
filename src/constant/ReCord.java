package constant;

import proparty.TBL_Name;

public class ReCord {
	//コードリストテーブルを作成した際にcode列に入れられる作成列
	public static String KOSHINBI_MARKET_TBL							= "マーケットテーブル更新日";
	public static String KOSHINBI_STOCK_ETF								= "株とETF更新日";
	public static String KOSHINBI_STOCK_ETF_CHECK_POINT					= "株とETF更新日のチェックポイント更新日";
	public static String KOSHINBI_INDEX									= "指数更新日";
	public static String KOSHINBI_STATISTICS							= "統計更新日";
	public static String KOSHINBI_CURRENCY								= "通貨更新日";
	public static String KOSHINBI_FINANCIAL								= "財務データ更新日";
	public static String KOSHINBI_INVEST								= "投資データ更新日";
	public static String KOSHINBI_FORRIGN_RATIO							= "株主比率更新日";
	public static String KOSHINBI_CREDIT								= "信用売買残更新日";
	public static String KOSHINBI_TOSHO_REIT							= "東証REIT更新日";
	public static String KOSHINBI_TOSHO_ETF								= "東証ETF更新日";

	public static String KOSHINBI_FINANCIAL_CHECK_POINT					= "財務データ更新日のチェックポイント更新日";
	public static String KOSHINBI_INVEST_CHECK_POINT					= "投資データ更新日のチェックポイント更新日";
	public static String KOSHINBI_FORRIGN_RATIO_CHECK_POINT				= "株主比率更新日のチェックポイント更新日";
	public static String KOSHINBI_CREDIT_CHECK_POINT					= "信用売買残更新日のチェックポイント更新日";
	public static String KOSHINBI_SEPA_CHECK							= "分割ファイル更新日";
	public static String KOSHINBI_COMBINE_CHECK							= "併合ファイル更新日";
	public static String KOSHINBI_BACK_UP								= "バックアップ作成日";
	public static String KOSHINBI_STOCK_LIST							= "銘柄一覧作成日";


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	//財務情報・・・21
	//信用売買残・・・22
	//投資情報・・・23
	//外国人保有比率・・・24
	public static final String CODE_01_STOCK = "1";
	public static final String CODE_02_SATISTICS = "2";
	public static final String CODE_03_INDEX = "3";
	public static final String CODE_04_ETF = "4";
	public static final String CODE_21_FINANCIAL = "21";
	public static final String CODE_22_CREDIT = "22";
	public static final String CODE_23_INVEST = "23";
	public static final String CODE_24_FORRIGN_RATIO = "24";
	public static final String CODE_05_SAKIMONO = "5";
	public static final String CODE_06_CURRENCY = "6";
	public static final String CODE_99_ALLTYPE = "99";

	//へそのごまのファイルのアレ
	//株
	public static final String CODE_HESO_01_STOCK = "1111";
	//投資情報
	public static final String CODE_HESO_02_INVEST = "2222";
	//財務情報
	public static final String CODE_HESO_03_FINANCE = "3333";
	//保有比率
	public static final String CODE_HESO_04_RATIO = "4444";
	//信用残高
	public static final String CODE_HESO_05_CREDIT = "5555";
	//リスト
	public static final String CODE_HESO_00_CODE_LIST = "555512";
	//東証REIT
	public static final String CODE_HESO_06_REIT = "66666";
	//東証ETF
	public static final String CODE_HESO_07_ETF = "77777";

	 //01_stock_dd a
	 //00_codelisttbl b
	 //02_statistics_dd c
	public static final String STOCK_TBK_DD_A = "a";
	public static final String STOCK_TBK_DD_AA = "aa";
	public static final String CODELIST_B = "b";
	public static final String STATISTICS_DD_C = "c";
	public static final String STATISTICS_NIKKE01_DD_CC = "cc";
	public static final String INDEX_DD_D = "d";
	public static final String ETF_DD_E = "e";
	public static final String INVESTTBL_F = "ffffffff";
	public static final String INDEX_TBK_DD_NIKKE_AVE		= "i";
	public static final String INDEX_TBK_DD_TOPIX			= "ii";
	public static final String INDEX_TBK_DD_JPX400			= "iii";
	public static final String INDEX_TBK_DD_CORE30			= "iiii";
	public static final String INDEX_TBK_DD_TOPIX100		= "iiiii";
	public static final String INDEX_TBK_DD_TOPIX_SMALL		= "iiiiii";
	public static final String INDEX_TBK_DD_ASIA			= "iiiiiii";
	public static final String INDEX_TBK_DD_JASDAC			= "iiiiiiii";
	public static final String MARKET_LETTER			= "mmmmmmmmmmm";

	//銘柄名など
//	I101 日経平均
	public static final String indexName_I101 = "I101";
//	I102　TOPIX
	public static final String indexName_I102 = "I102";
//	I103　JPXINDEX400
	public static final String indexName_I103 = "I103";
//	I111 コア30
	public static final String indexName_I111 = "I111";
//	I113　TOPIX100
	public static final String indexName_I113 = "I113";
//	I116　TOPIXSMALL
	public static final String indexName_I116 = "I116";
//	I131　アジア関連株指数
	public static final String indexName_I131 = "I131";
//	I306、ジャスダック
	public static final String indexName_I306 = "I306";

	//東証一部
	public static final String TOSYO_01 = "東証1部";

	//基準となる銘柄（日経平均など）→NTTを基準とする
	public static String BASIC_CODE_01 = "9432";
	//基準となる銘柄（日経平均など）→トヨタを基準とする
	public static String BASIC_CODE_02 = "7203";
	//基準となる銘柄（日経平均など）→JTを基準とする
	public static String BASIC_CODE_03 = "2914";
	//基準となる銘柄（日経平均など）→日立を基準とする
	public static String BASIC_CODE_04 = "6501";
	//基準となる銘柄（日経平均など）→信越化学工業を基準とする
	public static String BASIC_CODE_05 = "4063";
	//基準となる銘柄（日経平均など）→三菱商事を基準とする
	public static String BASIC_CODE_06 = "8058";
	//基準となる銘柄が存在するテーブル
	public static final String BASIC_TBL = TBL_Name.STOCK_DD;

	//マーケットコード
	public static final String MARKET_CODE_1306 = "1306";
	//日経平均に等しい銘柄：ETFの
	public static final String NIKKEI225_CODE_1321 = "1321";

	//初期値
	public static final String KOSHINBI_SHOKI									= "2007-01-03";
	//リストテーブルの更新日初期値
	public static final String LIST_KOSHINBI_SHOKI								= "2017-12-03";
	//通貨初期値
	public static String CURRENCY_KOSHINBI_SHOKI						= "2007-01-03";

}
