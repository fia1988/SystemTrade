package constant;

public class AccesarryParameta {

	//ベータ計算するのに使うような平均観測期間
	public final static int MARKET_OBSERVATION_TERM = 245;

	//リスクフリーレート。とりあえずン年間1.0%で設定
	//日々で割って1.0/245（245営業日は一年間：1.0/245≒0.0041％）
	public final static double RISK_FREE_RATE = 0.0041;

	//移動平均線長中短
	public static final int IDOSHORT = 9;
	public static final int IDOMIDDLE = 13;
	public static final int IDOLONG = 26;

	//移動平滑線
	public static int HEKATUSHORT = 9;
	public static int HEKATUMIDDLE = 13;
	public static int HEKATULONG = 26;

	//MACDシグナル
	public static int MACD_SIGNAL = 9;

	//ボリンジャーバンドを計算する際に利用する値
	//期間
	public static int SIGMA_TERM_SHORT = 9;
	public static int SIGMA_TERM_MIDDLE = 13;
	public static int SIGMA_TERM_LONG = 26;
	//判断するためのコード値
	public static int SIGMA_SHORT = 1;
	public static int SIGMA_MIDDLE = 2;
	public static int SIGMA_LONG = 3;

	//出来高の調査する場合の、推移していないことを示す値
	public static double BOXCHECK = 1.5;
	//出来高の調査する場合の、出来高の上がっている期間を示す
	public static double HIGHT_DEKI_RATIO = 0.7;
}
