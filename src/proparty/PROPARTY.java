package proparty;

public class PROPARTY {


//  集計する年数
	public static int COLLECTYEAR = 100;
	//サイトに株価更新時間
	public static String UPDATETIME = "15:30:00";


	//連続アクセスを防ぐﾐﾘ秒数
	public static int SLEEPTIME = 3600000;
	//ちょっと間をおいてアクセスする。その間の時間。
	public static int INTERVALTIME = 4000;
	//最終更新日が1年前なら分割する。150で23075秒。180で28207一晩ぐらい？
	//400:55252
	//1000:
	public static int HISABISADAY_STOCK_INDEX	=	5200;
	public static int HISABISADAY_STATISTICS	=	5210;
	public static int HISABISADAY_INDEX			=	5210;


	//0:毎日
	//1:月水金
	//2:月木、火金
	//3:月金
	//4:週一回
	//7:月、翌週火、翌週水・・・
	//8:月、翌週水、翌週金
	//バックアップを何日間隔でやるか
	public static int BACK_UP_KANkAKU			=	4;
	//分割併合ファイルを何日間隔でとるか
	public static int SEPA_COM_KANKAKU			=	2;
	//バックアップファイルの世代、いくつdumpファイルを作るか
	public static int MAX_DUMP_FILES			=	5;

	//503エラー？たまに出るへんなやつ
	public static String NAZO = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\"http://www.w3.org/TR/html4/strict.dtd\">";
	public static String NAZO2 = "<HTML><HEAD><TITLE>Service Unavailable</TITLE>";

	//ここら辺は画面で設定する箇所
	public static String LOG_FILE_OUT = "";
//	DBのID
	public static String DBUSER = "";
//	DBのパス。
	public static String DBPASS = "";


}
