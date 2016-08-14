package bean;

import java.util.ArrayList;
import java.util.List;

import common.commonAP;

public class Bean_Result {

	String DAY;
	String code;

	long resultPlusClass00 = 0;
	long resultPlusClass01 = 0;
	long resultPlusClass02 = 0;
	long resultPlusClass03 = 0;
	long resultPlusClass04 = 0;
	long resultPlusClass05 = 0;
	long resultPlusClass06 = 0;
	long resultPlusClass07 = 0;
	long resultPlusClass08 = 0;
	long resultPlusClass09 = 0;
	long resultPlusClass10 = 0;
	long resultPlusClass11 = 0;
	long resultPlusClass12 = 0;
	long resultPlusClass13 = 0;
	long resultPlusClass14 = 0;
	long resultPlusClass15 = 0;
	long resultPlusClass16 = 0;
	long resultPlusClass17 = 0;
	long resultPlusClassOver = 0;

	long resultMinusClass01 = 0;
	long resultMinusClass02 = 0;
	long resultMinusClass03 = 0;
	long resultMinusClass04 = 0;
	long resultMinusClass05 = 0;
	long resultMinusClass06 = 0;
	long resultMinusClass07 = 0;
	long resultMinusClass08 = 0;
	long resultMinusClass09 = 0;
	long resultMinusClass10 = 0;
	long resultMinusClass11 = 0;
	long resultMinusClass12 = 0;
	long resultMinusClass13 = 0;
	long resultMinusClass14 = 0;
	long resultMinusClass15 = 0;
	long resultMinusClass16 = 0;
	long resultMinusClass17 = 0;
	long resultMinusClass18 = 0;
	long resultMinusClassOver = 0;


	//日付の標準偏差
	List<Long> keepDayList = new ArrayList();
	//日付の合計
	long totalDays = 0;

	//リターンの標準偏差
	List<Double> returnList = new ArrayList();


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

	public void resetList(){
		entryPriceList = new ArrayList<Double>();
		entryDayList = new ArrayList<String>();
		totalDays = 0;
		resultPlusClass00 = 0;
		resultPlusClass01 = 0;
		resultPlusClass02 = 0;
		resultPlusClass03 = 0;
		resultPlusClass04 = 0;
		resultPlusClass05 = 0;
		resultPlusClass06 = 0;
		resultPlusClass07 = 0;
		resultPlusClass08 = 0;
		resultPlusClass09 = 0;
		resultPlusClass10 = 0;
		resultPlusClass11 = 0;
		resultPlusClass12 = 0;
		resultPlusClass13 = 0;
		resultPlusClass14 = 0;
		resultPlusClass15 = 0;
		resultPlusClass16 = 0;
		resultPlusClass17 = 0;
		resultPlusClassOver = 0;



		resultMinusClass01 = 0;
		resultMinusClass02 = 0;
		resultMinusClass03 = 0;
		resultMinusClass04 = 0;
		resultMinusClass05 = 0;
		resultMinusClass06 = 0;
		resultMinusClass07 = 0;
		resultMinusClass08 = 0;
		resultMinusClass09 = 0;
		resultMinusClass10 = 0;
		resultMinusClass11 = 0;
		resultMinusClass12 = 0;
		resultMinusClass13 = 0;
		resultMinusClass14 = 0;
		resultMinusClass15 = 0;
		resultMinusClass16 = 0;
		resultMinusClass17 = 0;
		resultMinusClass18 = 0;
		resultMinusClassOver = 0;

	}

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

	//買った日と売る日が同日ではないことを確認する。
	//同日の場合は買った日のエントリーを取り消す。
	public boolean checkSameDay(){


		if (entryDayList.get(entryDayList.size() -1 ).equals(exitDay) ){
			if ( entryPriceList.size() > 0 ){
				entryPriceList.remove(entryPriceList.size() - 1);
			}

			if (entryDayList.size() > 0 ){
				entryDayList.remove(entryDayList.size() - 1);
			}
			
			if (entryDayList.size() ==0 ){
				return false;
			}
		}
		
		return true;

	}

	public void getResultDayResult(String code){

		String result = "";


		//買った日と売る日が同日ではないことを確認する。
		//同日の場合は買った日のエントリーを取り消す。
		//これでentryDayListのレコードが0になるとメソッドの処理を中断する。
		if ( checkSameDay() == false ){
			return;
		};

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

		double checkClass = Math.floor(averageParcent * 100);
		//階級を作る
		switch((int)checkClass){
		case 0:
			resultPlusClass01++;
			break;
		case 1:
			resultPlusClass02++;
			break;
		case 2:
			resultPlusClass03++;
			break;
		case 3:
			resultPlusClass04++;
			break;
		case 4:
			resultPlusClass05++;
			break;
		case 5:
			resultPlusClass06++;
			break;
		case 6:
			resultPlusClass07++;
			break;
		case 7:
			resultPlusClass08++;
			break;
		case 8:
			resultPlusClass09++;
			break;
		case 9:
			resultPlusClass10++;
			break;
		case 10:
			resultPlusClass11++;
			break;
		case 11:
			resultPlusClass12++;
			break;
		case 12:
			resultPlusClass13++;
			break;
		case 13:
			resultPlusClass14++;
			break;
		case 14:
			resultPlusClass15++;
			break;
		case 15:
			resultPlusClass16++;
			break;
		case 16:
			resultPlusClass17++;
			break;
		case -1:
			resultMinusClass01++;
			break;
		case -2:
			resultMinusClass02++;
			break;
		case -3:
			resultMinusClass03++;
			break;
		case -4:
			resultMinusClass04++;
			break;
		case -5:
			resultMinusClass05++;
			break;
		case -6:
			resultMinusClass06++;
			break;
		case -7:
			resultMinusClass07++;
			break;
		case -8:
			resultMinusClass08++;
			break;
		case -9:
			resultMinusClass09++;
			break;
		case -11:
			resultMinusClass10++;
			break;
		case -12:
			resultMinusClass11++;
			break;
		case -13:
			resultMinusClass12++;
			break;
		case -14:
			resultMinusClass13++;
			break;
		case -15:
			resultMinusClass14++;
			break;
		case -16:
			resultMinusClass15++;
			break;
		case -17:
			resultMinusClass16++;
			break;
		case -18:
			resultMinusClass17++;
			break;
		default:
			if (checkClass > 0){
				resultPlusClassOver++;
			}else{

				resultMinusClassOver++;
			}
			break;
		}

		//標準偏差を計算する。
		setKeepDayList(getKeepCount());
		setReturnList((averageParcent));


		if( getResultDay() ){
			System.out.println(code + ":" + result + "【entry】" + getEntryList() + "【exit】" + exitDay + "/" + exitPrice + "【" + getKeepCount() + "】" + (exitPrice - average) + "/" + averageParcent);
		}

		if (averageParcent < -0.35 ){
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
			System.out.println("見込みリターン：" + ( getTotalWinParcent() + getTotalLoseParcent() ) / ( getTOTAL_WIN() + getTOTAL_LOSE()));
			System.out.println("見込みリスク：" + commonAP.getDev(getReturnList(),  true));
			System.out.println("平均保有期間：" + getTotalDays() / getTradeCount());
			System.out.println("保有期間標準偏差：" + commonAP.getDev(getKeepDayList(), true,""));

			System.out.println(" 17%以上 ："	+	resultPlusClassOver);
			System.out.println("16%～ 17%："	+	resultPlusClass17);
			System.out.println("15%～ 16%："	+	resultPlusClass16);
			System.out.println("14%～ 15%："	+	resultPlusClass15);
			System.out.println("13%～ 14%："	+	resultPlusClass14);
			System.out.println("12%～ 13%："	+	resultPlusClass13);
			System.out.println("11%～ 12%："	+	resultPlusClass12);
			System.out.println("10%～ 11%："	+	resultPlusClass11);
			System.out.println("  9～ 10%："	+	resultPlusClass10);
			System.out.println("  8～  9%："	+	resultPlusClass09);
			System.out.println("  7～  8%："	+	resultPlusClass08);
			System.out.println("  6～  7%："	+	resultPlusClass07);
			System.out.println("  5～  6%："	+	resultPlusClass06);
			System.out.println("  4～  5%："	+	resultPlusClass05);
			System.out.println("  3～  4%："	+	resultPlusClass04);
			System.out.println("  2～  3%："	+	resultPlusClass03);
			System.out.println("  1～  2%："	+	resultPlusClass02);
			System.out.println("  0～  1%："	+	resultPlusClass01);
			System.out.println("-1 ～  0%："	+	resultMinusClass01);
			System.out.println("-2 ～ -1%："	+	resultMinusClass02);
			System.out.println("-3 ～ -2%："	+	resultMinusClass03);
			System.out.println("-4 ～ -3%："	+	resultMinusClass04);
			System.out.println("-5 ～ -4%："	+	resultMinusClass05);
			System.out.println("-6 ～ -5%："	+	resultMinusClass06);
			System.out.println("-7 ～ -6%："	+	resultMinusClass07);
			System.out.println("-8 ～ -7%："	+	resultMinusClass08);
			System.out.println("-9 ～ -8%："	+	resultMinusClass09);
			System.out.println("-10～ -9%："	+	resultMinusClass10);
			System.out.println("-11～-10%："	+	resultMinusClass11);
			System.out.println("-12～-11%："	+	resultMinusClass12);
			System.out.println("-13～-12%："	+	resultMinusClass13);
			System.out.println("-14～-13%："	+	resultMinusClass14);
			System.out.println("-15～-14%："	+	resultMinusClass15);
			System.out.println("-16～-15%："	+	resultMinusClass16);
			System.out.println("-17～-16%："	+	resultMinusClass17);
			System.out.println("-17%以下 ："	+	resultMinusClassOver);


			System.out.println("Lメソッド：" + L_packageName + "." + L_className + "." + L_methodName );
			System.out.println("Sメソッド：" + S_packageName + "." + S_className + "." + S_methodName );

		}

		resetList();
		reSetKeepCount();
	}








	public long getTotalDays() {
		return totalDays;
	}


	public List<Long> getKeepDayList() {
		return keepDayList;
	}

	public void setKeepDayList(long keepDayCount) {
		totalDays = totalDays + keepDayCount;
		keepDayList.add(keepDayCount);
	}

	public List<Double> getReturnList() {
		return returnList;
	}

	public void setReturnList(double reTurn) {
		returnList.add(reTurn);
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
