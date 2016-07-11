package bean;

import java.util.ArrayList;

public class Bean_Result {

	String DAY;
	String code;



	int loseCount=0;
	int winCount=0;
	int keepCount=0;

//	Double entryPrice;
//	String entryDay;
	ArrayList<Double> entryPriceList = new ArrayList<Double>();
	ArrayList<String> entryDayList = new ArrayList<String>();

	double totalWinParcent;
	double averageWinParcent;
	double totalLoseParcent;
	double averageLoseParcent;

	double averagePrice;
	double exitPrice;
	String exitDay;

	int TOTAL_WIN=0;
	int TOTAL_LOSE=0;
	int winMoney=0;
	int loseMoney=0;
	int totalWinMoney=0;
	int totalLoseMoney=0;
	int keepAve;
	double winParcent;
	double loseParcent;
	int tradeCount;

	//結果のフラグ、trueの場合、出力する。falseの場合しない。
	boolean resultDay = false;
	boolean resultCode = false;
	boolean resultTotal = false;

	public void getResultCodeResult(String resultCode){

		if( getResultCode() ){
			if ( ( getWinCount() + getLoseCount() ) > 0){
				System.out.print("・" + resultCode +  "：勝【" + getWinCount() + "】");
				System.out.println("／" +  "：負【" + getLoseCount() + "】");
			}
		}
		reSetWinCount();
		reSetLoseCount();
	}

	public void getResultDayResult(String code){

		String result = "";
		double average = getEntryAveragePrice();
		double averageParcent = (exitPrice - average) / average;
		if ( exitPrice - average > 0){
			//勝った場合
			setWinCount();
			setTOTAL_WIN();
			setTotalWinParcent(averageParcent);
			result = "(勝)";

		}else{
			//負けた場合
			setLoseCount();
			setTOTAL_LOSE();
			setTotalLoseParcent(averageParcent);
			result = "(負)";
		}



		if( getResultDay() ){
			System.out.println(code + ":" + result + "【entry】" + getEntryList() + "【exit】" + exitDay + "/" + exitPrice + "【" + getKeepCount() + "】" + (exitPrice - average) + "/" + averageParcent);
		}

//		resetEntryList();
		reSetKeepCount();
	}

	public void getResultTotalResult(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName){
		if( getResultTotal() ){
			System.out.println("トータル勝：" + getTOTAL_WIN());
			System.out.println("トータル負：" + getTOTAL_LOSE());
			System.out.println("売却できず：" + ( getTradeCount() - getTOTAL_WIN() - getTOTAL_LOSE() ) );
			System.out.println("トータル計：" + getTradeCount());
			System.out.println("トータル勝％：" + getTotalWinParcent());
			System.out.println("トータル負％：" + getTotalLoseParcent() );
			System.out.println("トータル平均勝％：" + getAverageWinParcent());
			System.out.println("トータル平均負％：" + getAverageLoseParcent());
			System.out.println("Lメソッド：" + L_packageName + "." + L_className + "." + L_methodName );
			System.out.println("Sメソッド：" + S_packageName + "." + S_className + "." + S_methodName );
			
		}
	}

	public void resetEntryList(){
		this.entryPriceList = new ArrayList<Double>();
		this.entryDayList = new ArrayList<String>();
	}


	public String getEntryList(){
		String dayList="";
		String entryList="";

		for (int i = 0 ; i < entryPriceList.size() ; i++){
			if(i==0){
				entryList = entryPriceList.get(i) + "";
			}else{
				entryList = entryList + "/" + entryPriceList.get(i);
			}
		}

		for (int i = 0 ; i < entryDayList.size() ; i++){
			if(i==0){
				dayList = entryDayList.get(i) + "";
			}else{
				dayList = dayList + "/" + entryDayList.get(i);
			}
		}

		return "購入日：" + dayList + "／購入額：" +  entryList;
	}

	public ArrayList<Double> getEntryPrice() {
		return entryPriceList;
	}

	public double getEntryAveragePrice(){
		double total=0.0;
		for (int i = 0 ; i < entryPriceList.size() ; i++){
			total = total + entryPriceList.get(i);
		}
		return (total/entryPriceList.size());
	}

	public void setEntryPrice(double entryPrice) {
//		this.entryPrice = entryPrice;
		this.entryPriceList.add(entryPrice);
	}
	public ArrayList<String> getEntryDay() {
		return entryDayList;
//		return entryDay;
	}
	public void setEntryDay(String entryDay) {
		this.entryDayList.add(entryDay);
//		this.entryDay = entryDay;
	}
	public double getExitPrice() {
		return exitPrice;
	}
	public void setExitPrice(double exitPrice) {
		this.exitPrice = exitPrice;
	}
	public String getExitDay() {
		return exitDay;
	}
	public void setExitDay(String exitDay) {
		this.exitDay = exitDay;
	}
	public String getDAY() {
		return DAY;
	}
	public void setDAY(String dAY) {
		DAY = dAY;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public int getLoseCount() {
		return loseCount;
	}

	public void setLoseCount() {
		this.loseCount++;
	}

	public void reSetLoseCount() {
		this.loseCount=0;
	}

	public int getWinCount() {
		return winCount;
	}
	public void setWinCount() {
		this.winCount++;
	}

	public void reSetWinCount() {
		this.winCount=0;
	}

	public int getKeepCount() {
		return keepCount;
	}
	public void setKeepCount() {
		this.keepCount++;
	}
	public void reSetKeepCount() {
		this.keepCount=0;
	}
	public int getTOTAL_WIN() {
		return TOTAL_WIN;
	}
	public void setTOTAL_WIN() {
		TOTAL_WIN++;
	}

	public void reSetTOTAL_WIN() {
		TOTAL_WIN=0;
	}
	public int getTOTAL_LOSE() {
		return TOTAL_LOSE;
	}
	public void setTOTAL_LOSE() {
		TOTAL_LOSE++;
	}
	public void reSetTOTAL_LOSE() {
		TOTAL_LOSE=0;
	}
	public int getWinMoney() {
		return winMoney;
	}
	public void setWinMoney(int winMoney) {
		this.winMoney = winMoney;
	}
	public int getLoseMoney() {
		return loseMoney;
	}
	public void setLoseMoney(int loseMoney) {
		this.loseMoney = loseMoney;
	}
	public int getTotalWinMoney() {
		return totalWinMoney;
	}
	public void setTotalWinMoney(int totalWinMoney) {
		this.totalWinMoney = totalWinMoney;
	}
	public int getTotalLoseMoney() {
		return totalLoseMoney;
	}
	public void setTotalLoseMoney(int totalLoseMoney) {
		this.totalLoseMoney = totalLoseMoney;
	}
	public int getKeepAve() {
		return keepAve;
	}
	public void setKeepAve(int keepAve) {
		this.keepAve = keepAve;
	}
	public double getWinParcent() {
		return winParcent;
	}
	public void setWinParcent(double winParcent) {
		this.winParcent = winParcent;
	}
	public double getLoseParcent() {
		return loseParcent;
	}
	public void setLoseParcent(double loseParcent) {
		this.loseParcent = loseParcent;
	}
	public int getTradeCount() {
		return tradeCount;
	}
	public void setTradeCount() {
		this.tradeCount++;
	}



	public boolean getResultDay() {
		return resultDay;
	}

	public boolean getResultCode() {
		return resultCode;
	}

	public boolean getResultTotal() {
		return resultTotal;
	}


	public void setOnResultDay() {
		this.resultDay = true;
	}

	public void setOnResultCode() {
		this.resultCode = true;
	}

	public void setOnResultTotal() {
		this.resultTotal = true;
	}

	public void setOffResultDay() {
		this.resultDay = false;
	}

	public void setOffResultCode() {
		this.resultCode = false;
	}

	public void setOffResultTotal() {
		this.resultTotal = false;
	}

	public double getTotalWinParcent() {
		return totalWinParcent;
	}

	public void setTotalWinParcent(double totalWinParcent) {
		this.totalWinParcent = totalWinParcent + this.totalWinParcent;
	}

	public double getTotalLoseParcent() {
		return totalLoseParcent;
	}

	public void setTotalLoseParcent(double totalLoseParcent) {
		this.totalLoseParcent = totalLoseParcent + this.totalLoseParcent;
	}

	public double getAverageWinParcent() {
		return getTotalWinParcent() / getTOTAL_WIN();
	}


	public double getAverageLoseParcent() {
		return ( getTotalLoseParcent() / getTOTAL_LOSE()) ;
	}




}
