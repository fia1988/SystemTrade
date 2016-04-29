package bean;


	//時刻を入力する際、文字が入力されていた場合、以下のように置き換える（先物に用いる）
	//午前：12:00:00
	//日中：12:00:00
	//午後：15:00:00
	//夜間：18:00:00

	//個別株の日足データのBean
	//値がない場合は0

	public class Bean_TBLRecord {

//		日付
		private String day = null;
//		業種
		private String category = null;
//		市場
		private String market = null;
//		時刻
		private String nowTime = null;
//		始値
		private String open = "0";
//		高値
		private String max = "0";
//		安値
		private String min = "0";
//		終値
		private String close = "0";
//		出来高
		private String deki = "0";
//		売買高
		private String baybay = "0";
//		銘柄数
		private String stockCount = "0";
//		値付
		private String takePrice = "0";
//		値上げ
		private String upPrice ="0";
//		値下げ
		private String downPrice ="0";
//		変わらず
		private String noChange = "0";
//		比較不可
		private String noCompare = "0";


		public void setDay(String x){
			day = x;
		}

		public String getDay(){
			return day;
		}

		public void setMarket(String x){
			market = x;
		}

		public String getMarket(){
			return market;
		}

		public void setCategory(String x){
			category = x;
		}

		public String getCategory(String x){
			return category;
		}

		public void setNowTime(String x){

			x = x.equals("午前") ? "12:00:00":x;
			x = x.equals("日中") ? "12:00:00":x;
			x = x.equals("午後") ? "15:00:00":x;
			x = x.equals("夜間") ? "18:00:00":x;
			nowTime = x;
		}

		public String getNowTime(){
			return nowTime;
		}

		public void setOpen(String x){
			x = (x.equals("-")) ? "0" : x;
			open = x;
		}

		public String getOpen(){
			return open;
		}

		public void setMax(String x){
			x = (x.equals("-")) ? "0" : x;
			max = x;
		}

		public String getMax(){
			return max;
		}

		public void setMin(String x){
			x = (x.equals("-")) ? "0" : x;
			min = x;
		}

		public String getMin(){
			return min;
		}

		public void setClose(String x){
			x = (x.equals("-")) ? "0" : x;
			close = x;
		}

		public String getClose(){
			return close;
		}

		public void setDeki(String x){
			x = (x.equals("-")) ? "0" : x;
			deki = x;
		}

		public String getDeki(){
			return deki;
		}

		public void setBaybay(String x){
			x = (x.equals("-")) ? "0" : x;
			baybay = x;
		}

		public String getBayBay(){
			return baybay;
		}

		public void setStockCount(String x){
			x = (x.equals("-")) ? "0" : x;
			stockCount = x;
		}

		public String getStockCount(){
			return stockCount;
		}

		public void setTakePrice(String x){
			x = (x.equals("-")) ? "0" : x;
			takePrice = x;
		}

		public String getTakePrice(){
			return takePrice;
		}


		public void setUpPrice(String x){
			x = (x.equals("-")) ? "0" : x;
			upPrice = x;
		}

		public String getUpPrice(){
			return upPrice;
		}

		public void setDownPrice(String x){
			x = (x.equals("-")) ? "0" : x;
			downPrice = x;
		}

		public String getDownPrice(){
			return downPrice;
		}

		public void setNoChange(String x){
			x = (x.equals("-")) ? "0" : x;
			noChange = x;
		}

		public String getNoChange(){
			return noChange;
		}

		public void setNoCompare(String x){
			x = (x.equals("-")) ? "0" : x;
			noCompare = x;
		}

		public String getNoCompare(){
			return noCompare;
		}
}
