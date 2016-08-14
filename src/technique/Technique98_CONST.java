package technique;

import java.util.ArrayList;

public class Technique98_CONST {
	public static  final  int NO_RESULT			=	99999;
	public static  final  int NO_METHOD			=	99998;
	public static  final  int METHOD_RESULT 	=	99997;
	public static  final  int CONTENUE_PROCESS	=	99996;

	public static  final  int NO_GAME		=	10000;

	//勝つ思われる、値上がり
//	public static  final  int ENTRY_FLG		=	10001;
	//負けると思われる、値下がり
//	public static  final  int LOSE_FLG		=	10002;
	//取引フラグ
	public static  final  int TRADE_FLG		=	10003;


	//ここからmethod名
	//S売り、L買い
	//M順張り、R逆張り
	public static final String MACD_M_L = "MACD_M_L";
	public static final String MACD_R_L = "MACD_R_L";
	public static final String MACD_M_S = "MACD_M_S";
	public static final String MACD_R_S = "MACD_R_S";
	public static final String MACD_M_S_14 = "MACD_M_S_14";


	//ここからパッケージ名
	public static final String PACKAGE_01 = "technique";
	//ここからクラス名
	public static final String CLASS_04 = "Technique04";

	//今保持している銘柄
	static ArrayList<String> nowSTOCK = new ArrayList<String>();
	public static void setNowSTOCK() {
		nowSTOCK = new ArrayList<String>();
		nowSTOCK.add("9031―T");
	}
	public static ArrayList<String> getNowSTOCK() {
		return nowSTOCK;
	}

}
