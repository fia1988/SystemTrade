package proparty;

public class PROPARTY {

	//------------------------------------ここはアップロードする前に消してやること
		//propartyTBLの項目名
		//暗号化キー
		public static String FBS_KEY = "";
		//各項目の初期値
		public static String FIRST_SET = "";


		//へそのごまのID
		public static final String hesoGomaID = "";
		//へそのごまのパスワード
		public static final String hesoGomePASS = "";
	//------------------------------------ここはアップロードする前に消してやること

	//everyフォルダの固定値
	public static final String COMMON_A = "00000.commonBoard_typeA";
	public static final String COMMON_B = "10000.commonBoard_typeB";
	public static final String COMMON_OLD = "old";

	//手法ごとの今日までの結果をまとめたファイル
	public static final String METHOD_RESULE_F = "methodResultFile.csv";

//  集計する年数
	public static int COLLECTYEAR = 100;
	//サイトに株価更新時間
	public static String UPDATETIME = "15:30:00";
	//有料のお客様へのファイルを配る時間
	public final static String DIVITETIME = "18:30:00";

	//一回辺り投資資金（単位：万円）
	public static double ONE_SHOT_MONEY = 1.2;
	//SBIにおけるミニ株の手数料が最小になる金額。単位：円
	public static final int SBI_MINI_LOT = 10000;

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

	//株データを監視するスパン単位(変動値)：ﾐﾘ秒
	public static int CLOALING_TIME			=	900000;
	//株データを監視するスパン単位(固定値)：ﾐﾘ秒
	public final static int CLOALING_TIME_CONST			=	900000;

	//文字コード
	public final static String MOJI_TYPE			=	"utf-8";

	//0:毎日
	//1:月水金
	//2:月木、火金
	//3:月金
	//4:週一回
	//7:月、翌週火、翌週水・・・
	//8:月、翌週水、翌週金
	//バックアップを何日間隔でやるか
	public static int BACK_UP_KANkAKU			=	0;
	//分割併合ファイルを何日間隔でとるか
	public static int SEPA_COM_KANKAKU			=	0;
	//バックアップファイルの世代、いくつdumpファイルを残すか（1つはoldなので6＝5ファイル）
	public static int MAX_DUMP_FILES			=	6;

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
