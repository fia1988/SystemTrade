package proparty;


public class Net_Adress {
	private static String URL;
	/**
	 * 株価データのコードリスト一覧
	 */
	public static String CODELIST_STOCK = "http://k-db.com/stocks/2015-02-03a?download=csv";
	public static String INDEX = "http://k-db.com/indices/2015-05-08a?download=csv";
	public static String STATISTICS = "http://k-db.com/statistics/2015-05-08a?download=csv";
	public static String FUTURES = "http://k-db.com/futures/2015-05-08a?download=csv";
	public static String INDEX_STOCK = "http://k-db.com/?p=all&download=csv&";

//	public static String STOCK_LIST = "http://k-db.com/stocks/";
//	public static String INDEX_LIST = "http://k-db.com/indices/";
//	public static String STATISTICS_LIST = "http://k-db.com/statistics/";
//	public static String FUTURE_LIST = "http://k-db.com/futures/";

	public static String STOCK_LIST = "http://k-db.com/stocks/?download=csv";
	public static String INDEX_LIST = "http://k-db.com/indices/?download=csv";
//	public static String STATISTICS_LIST = "http://k-db.com/statistics/2015-99-01?download=csv";
	public static String STATISTICS_LIST = "http://k-db.com/statistics/?download=csv";

	public static String STOCK_LIST_DD = "http://k-db.com/stocks/";
	public static String INDEX_LIST_DD = "http://k-db.com/indices/";
	public static String STATISTICS_LIST_DD = "http://k-db.com/statistics/";

	//&csvheaderstring=コード,銘柄名,市場,業種,始値,高値,安値,終値,出来高,売買代金
	public static String DOWN_ITEM_9 = "&csvbodyformat={0},{1},{2},{3},{4},{5},{6},{7},{8},{9}";
	public static String DOWN_CSV = "?download=csv";
	public static String STOCK_LIST_DATE = "http://k-db.com/?p=all&download=csv&date=";



	/**
	 * 株価データの個別リストの日足取得
	 * @param stockName
	 * @param year
	 * @return
	 */
	public static String getTimeSeriesCSV_URL_DD(String stockName,int year){
		URL = "http://k-db.com/stocks/" + stockName + "?year=" + year + "&download=csv";
		return URL;
	}

	/**
	 * 株価データの個別リストの時間足取得
	 * @param stockName
	 * @param year
	 * @return
	 * @TODO どっから取得しようか
	 */
	public static String getTimeSeriesCSV_URL_HH(String stockName,int year){
		URL = "http://k-db.com/stocks/" + stockName + "?year=" + year + "&download=csv";
		return URL;
	}

}
