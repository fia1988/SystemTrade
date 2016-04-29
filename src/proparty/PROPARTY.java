package proparty;

public class PROPARTY {

//	DBのID
	public static String DBUSER = "root";
//	DBのパス。
	public static String DBPASS = "8Jecikj";
//  集計する年数
	public static int COLLECTYEAR = 100;
	//連続アクセスを防ぐﾐﾘ秒数
	public static int SLEEPTIME = 3600000;
	//ちょっと間をおいてアクセスする。その間の時間。
	public static int INTERVALTIME = 5000;
	//最終更新日が1年前なら分割する。150で23075秒。180で28207一晩ぐらい？
	//400:55252
	//1000:
	public static int HISABISADAY_STOCK_INDEX	=	200;
	public static int HISABISADAY_STATISTICS	=	210;
	public static int HISABISADAY_INDEX			=	210;


	//503エラー？たまに出るへんなやつ
	public static String NAZO = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\"http://www.w3.org/TR/html4/strict.dtd\">";
	public static String NAZO2 = "<HTML><HEAD><TITLE>Service Unavailable</TITLE>";


}
