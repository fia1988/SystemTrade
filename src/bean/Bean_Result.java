package bean;

public class Bean_Result {

	String DAY;
	String code;



	int loseCount=0;
	int winCount=0;
	int keepCount=0;

	double entryPrice;
	String entryDay;
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
		if ( exitPrice - entryPrice > 0){
			//勝った場合
			setWinCount();
			setTOTAL_WIN();
			result = "(勝)";
		}else{
			//負けた場合
			setLoseCount();
			setTOTAL_LOSE();
			result = "(負)";
		}

		if( getResultDay() ){
			System.out.println(code + ":" + result + entryDay + "／" + entryPrice + "／" + exitDay + "／" + exitPrice + "／【" + getKeepCount() + "】" + (exitPrice - entryPrice) );
		}


		reSetKeepCount();
	}

	public void getResultTotalResult(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName){
		if( getResultTotal() ){
			System.out.println("トータル勝：" + getTOTAL_WIN());
			System.out.println("トータル負：" + getTOTAL_LOSE());
			System.out.println("売却できず：" + ( getTradeCount() - getTOTAL_WIN() - getTOTAL_LOSE() ) );
			System.out.println("トータル計：" + getTradeCount());

			System.out.println("Lメソッド：" + ":" + L_packageName + ":" + L_className + ":" + L_methodName );
			System.out.println("Sメソッド：" + ":" + S_packageName + ":" + S_className + ":" + S_methodName );
		}
	}

	public double getEntryPrice() {
		return entryPrice;
	}
	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}
	public String getEntryDay() {
		return entryDay;
	}
	public void setEntryDay(String entryDay) {
		this.entryDay = entryDay;
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

}
