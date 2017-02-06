package constant;

import bean.Bean_CodeList;

public class CATE_FLG {


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6

	public static String STOCK_FLG		= "1";
	public static String STATISTICS_FLG	= "2";
	public static String IDNEX_FLG		= "3";
	public static String ETF_FLG		= "4";
	public static String SAKIMONO_FLG	= "5";
	public static String CURRENCY_FLG	= "6";

	public final static String replaceLetter = "―";

	public void testsub(Bean_CodeList B){
		B.setOpen("100");
	}

}
