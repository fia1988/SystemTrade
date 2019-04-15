package constant;

import bean.Bean_CodeList;

public class CATE_FLG {


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6

	//株週足・・・7
	//株月足・・・8

	public final static String STOCK_FLG		= "1";
	public final static String STATISTICS_FLG	= "2";
	public final static String IDNEX_FLG		= "3";
	public final static String ETF_FLG		= "4";
	public final static String SAKIMONO_FLG	= "5";
	public final static String CURRENCY_FLG	= "6";
	public final static String W_STOCK_F	= "7";
	public final static String M_STOCK_F	= "8";
	public final static String replaceLetter = "_";

	public void testsub(Bean_CodeList B){
		B.setOpen("100");
	}

}
