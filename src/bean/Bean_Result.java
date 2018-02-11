package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.commonAP;

import constant.logWriting;

public class Bean_Result {

	String DAY;
	String code;

	String realStartDay = "0";

	int maxInterValTime=0;
	int nowInterValTime=0;
	boolean nowInterValFLG=false;

	boolean maxLossFLG = false;

	private double doubleDaytime = 0.0;

	private String lastEntryDay = "";
	private String lastExitDay = "";

	//全銘柄の評価損益合計
	double codeKeepStockResult = 0;

	//個別銘柄毎の評価損益合計
	double totalKeepStockResult = 0;

	int keepCodeCout = 0;

	double newDivide = 0;
	double newClose = 0;




	public double getNewClose() {
		return newClose;
	}

	public void setNewClose(double newClose) {
		this.newClose = newClose;
	}

	public double getNewDivide() {
		return newDivide;
	}

	public void setNewDivide(double newDivide) {
		this.newDivide = newDivide;
	}

	public int getKeepCodeCout() {
		return keepCodeCout;
	}

	public void setKeepCodeCout() {
		this.keepCodeCout++;
	}

	public double getCodeKeepStockResult() {
		return codeKeepStockResult;
	}

	public void reSetCodeKeepStockResult() {
		this.codeKeepStockResult = 0;
	}

	public void setCodeKeepStockResult(double codeKeepStockResult) {
		this.codeKeepStockResult = this.codeKeepStockResult + codeKeepStockResult;
	}

	public double getTotalKeepStockResult() {
		return totalKeepStockResult;
	}

	public void resetTotalKeepStockResult() {
		totalKeepStockResult = 0;
	}

	public void setTotalKeepStockResult(double totalKeepStockResult) {
		this.totalKeepStockResult = this.totalKeepStockResult + totalKeepStockResult;
	}

	public String getLastEntryDay() {
		return lastEntryDay;
	}

	public void setLastEntryDay(String lastEntryDay) {
		this.lastEntryDay = lastEntryDay;
	}

	public String getLastExitDay() {
		return lastExitDay;
	}

	public void setLastExitDay(String lastExitDay) {
		this.lastExitDay = lastExitDay;
	}

	public void resetGetDoubleDaytime() {
		doubleDaytime = 0.0;
	}

	public double getDoubleDaytime() {
		return doubleDaytime;
	}

	public void setDoubleDaytime(double doubleDaytime) {
		this.doubleDaytime = doubleDaytime;
	}


	//ドルコスト平均法の勝率
	private int dollCostCodeWinCount = 0;
	private int dollCostCodeLoseCount = 0;
	private int dollCostTotalWinCount = 0;
	private int dollCostTotalLoseCount = 0;

	//ドルコスト平均法の儲け管理（％）
//	private List<Double> dollerCodeWinResult = new ArrayList<Double>();
//	private List<Double> dollerCodeLoseResult = new ArrayList<Double>();

	//ドルコスト平均法の儲け管理（％（ただし、一回辺り投資金額と比較した儲け））
	private List<Double> dollerCodeWinTotalResult = new ArrayList<Double>();
	private List<Double> dollerCodeLoseTotalResult = new ArrayList<Double>();
	private List<Double> dollerTotalWinTotalResult = new ArrayList<Double>();
	private List<Double> dollerTotalLoseTotalResult = new ArrayList<Double>();

	//codeのをリセットする。
	public void resetDollCostCodeResult(){
		dollCostCodeLoseCount=0;
		dollCostCodeWinCount=0;
		dollerCodeWinTotalResult = new ArrayList<Double>();
		dollerCodeLoseTotalResult = new ArrayList<Double>();

	}

	public int getDollCostCodeWinCount() {
		return dollCostCodeWinCount;
	}

	public void setDollCostCodeWinCount() {
		this.dollCostCodeWinCount = this.dollCostCodeWinCount + 1;
	}

	public int getDollCostCodeLoseCount() {
		return dollCostCodeLoseCount;
	}

	public void setDollCostCodeLoseCount() {
		this.dollCostCodeLoseCount = this.dollCostCodeLoseCount + 1;
	}

	public int getDollCostTotalWinCount() {
		return dollCostTotalWinCount;
	}

	public void setDollCostTotalWinCount() {
		this.dollCostTotalWinCount = this.dollCostTotalWinCount+1;
	}

	public int getDollCostTotalLoseCount() {
		return dollCostTotalLoseCount;
	}

	public void setDollCostTotalLoseCount() {
		this.dollCostTotalLoseCount = this.dollCostTotalLoseCount+1;
	}


	//多分、CODEの結果を求めるのに使う

	public Double getDollerCodeWinTotalResult() {
		double getResult = 0;
		for(double result : dollerCodeWinTotalResult){
			getResult = getResult + result;
		}
		return getResult;
//		return dollerCodeWinTotalResult;
	}

	public void setDollerCodeWinTotalResult(Double dollerCodeWinTotalResult) {
		this.dollerCodeWinTotalResult.add(dollerCodeWinTotalResult);
	}

	public Double getDollerCodeLoseTotalResult() {
		double getResult = 0;
		for(double result : dollerCodeLoseTotalResult){
			getResult = getResult + result;
		}
		return getResult;
//		return dollerCodeLoseTotalResult;
	}

	public void setDollerCodeLoseTotalResult(Double dollerCodeLoseTotalResult) {
		this.dollerCodeLoseTotalResult.add(dollerCodeLoseTotalResult);
	}


	public double getDollerTotalLoseTotalResult() {
		double getResult = 0;
		for(double result : dollerTotalLoseTotalResult){
			getResult = getResult + result;
		}
		return getResult;
//		return dollerTotalLoseTotalResult;
	}
	//指定した割合だけ下をカットして返す
	public double getDollerTotalLoseTotalResult(double half) {
		double getResult = 0;

		List<Double> doubleListCopy = new ArrayList<Double>();
		List<Long> doubleList = new ArrayList<Long>();

		//昇順に並び替え
		doubleListCopy = dollerTotalLoseTotalResult;
		Collections.sort(doubleListCopy);
		Collections.reverse(doubleListCopy);
//		for (int i = 0 + (int)Math.round(cutMIN * doubleListCopy.size() ) ; i < doubleListCopy.size() - (int)Math.round(cutMAX * doubleListCopy.size()) ; i++) {

		for(int i = 0; i < (int)Math.round( doubleListCopy.size() * (1-half) ); i++){
			getResult = getResult + doubleListCopy.get(i);
	    }
		return getResult;
	}



	public void setDollerTotalLoseTotalResult(Double dollerTotalLoseTotalResult) {
		this.dollerTotalLoseTotalResult.add(dollerTotalLoseTotalResult);
	}


	public double getDollerTotalWinTotalResult() {
		double getResult = 0;
		for(double result : dollerTotalWinTotalResult){
			getResult = getResult + result;
		}
		return getResult;
//		return dollerTotalWinTotalResult;
	}

	//指定した割合だけ上をカットして返す
	public double getDollerTotalWinTotalResult(double half) {
		double getResult = 0;

		List<Double> doubleListCopy = new ArrayList<Double>();
		List<Long> doubleList = new ArrayList<Long>();

		//昇順に並び替え
		doubleListCopy = dollerTotalWinTotalResult;
		Collections.sort(doubleListCopy);

//		for (int i = 0 + (int)Math.round(cutMIN * doubleListCopy.size() ) ; i < doubleListCopy.size() - (int)Math.round(cutMAX * doubleListCopy.size()) ; i++) {

		for(int i = 0; i < (int)Math.round( doubleListCopy.size() * (1-half) ); i++){
			getResult = getResult + doubleListCopy.get(i);
        }
		return getResult;
//		return dollerTotalWinTotalResult;
	}

	public void setDollerTotalWinTotalResult(Double dollerTotalWinTotalResult) {
		this.dollerTotalWinTotalResult.add(dollerTotalWinTotalResult);
	}


	//dayのドルコスト平均法の取得株数、取得額を計算する。
	private List<double[]> dollerStockVolume = new ArrayList<double[]>();


	//ドルコストにおける平均取得価格
	public double getDollStockAveragePrice(){
		double getResult = getDollStockTotalPrice() / getDollTotalStockVolume();
		return getResult;
	}

	//ドルコストにおける合計取得株数
	public double getDollTotalStockVolume(){
		double getResult = 0;



		//0：株数、1：株価
		int listAdress = 0;

		for(double[] dollerList : getDollerStockVolume()){
			getResult = getResult + dollerList[listAdress] ;
		}
		return getResult;
	}

	//ドルコストにおける合計投資金額
	public double getDollStockTotalPrice(){
		double getResult = 0;

		//0：株数、1：株価
		int listAdress = 1;

		for(double[] dollerList : getDollerStockVolume()){
			getResult = getResult + ( dollerList[1] * dollerList[0]);
		}

		return getResult;
	}

	public void resetDollerVolumes(){
		dollerStockVolume = new ArrayList<double[]>();
	}

	//買った値段リスト
	public String getDollerStockVolumePriceList(){
		String getResult = ",";

		//0：株数、1：株価
		int listAdress = 1;
		for(double[] dollerList : getDollerStockVolume()){
			getResult = getResult + dollerList[listAdress] + ",";
		}
		return getResult;
	}

	//買った株数リスト
	public String getDollerStockVolumeStockList(){
		String getResult = ",";
		//0：株数、1：株価
		int listAdress = 0;


		for(double[] dollerList : getDollerStockVolume()){
			getResult = getResult + dollerList[listAdress] + ",";
		}

		return getResult;
	}

	public List<double[]> getDollerStockVolume() {

		//最終日の売り日と
		//最終日の買い日が一致するとき最終日を消す。
//		if( dollerStockVolume.get(dollerStockVolume.size()-1)[2] == getDoubleDaytime()) {
//			System.out.println("------------------------------------------------------------");
//			System.out.println(dollerStockVolume.get(dollerStockVolume.size()-1)[2]);
//			System.out.println("------------------------------------------------------------");
//			dollerStockVolume.remove(dollerStockVolume.size()-1);
//		};

		if (getLastEntryDay().equals(getLastExitDay())){
			dollerStockVolume.remove(dollerStockVolume.size()-1);
		}
		//一度LastExitDayを参照すると、後には使用しないためここで塗りつぶす。
		setLastExitDay("");
		return dollerStockVolume;
	}

	//dayTimeは2017-01-01→20170101.0
	public void setDollerStockVolume(double dollerStockVolume,double dollerStockPrice,double dayTime) {
		double[] dollerStockPair = {dollerStockVolume,dollerStockPrice,dayTime};
		this.dollerStockVolume.add(dollerStockPair.clone());
	}

	public boolean isMaxLossFLG() {
		return maxLossFLG;
	}

	public void setMaxLossFLG(boolean maxLossFLG) {
		this.maxLossFLG = maxLossFLG;
	}

	public boolean isNowInterValFLG() {
		return nowInterValFLG;
	}

	public void setNowInterValFLG(boolean nowInterValFLG) {
		this.nowInterValFLG = nowInterValFLG;
	}

	public int getNowInterValTime() {
		return nowInterValTime;
	}

	public void reSetNowInterValTime(){
		this.nowInterValTime = 0;
	}

	public void setNowInterValTime() {
		this.nowInterValTime++;
	}

	public int getMaxInterValTime() {
		return maxInterValTime;
	}

	public void setMaxInterValTime(int maxInterValTime) {
		this.maxInterValTime = maxInterValTime;
	}

	public String getRealStartDay() {
		return realStartDay;
	}

	public void setRealStartDay(String realStartDay) {
		this.realStartDay = realStartDay;
	}

	//トータルレシオ
	double totalRatio = 0;
	boolean checkTotalRatio = false;
	public double getTotalRatio() {
		return totalRatio;
	}

	public void setTotalRatio(double totalRatio) {
		checkTotalRatio = true;
		this.totalRatio = totalRatio;
	}

	//勝率
	double shoritu = 0;
	int totalGames = 0;
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
	//保有期間
	int keepCount=0;

//	Double entryPrice;
//	String entryDay;
	ArrayList<Double> entryPriceList = new ArrayList<Double>();
	ArrayList<String> entryDayList = new ArrayList<String>();

	//銘柄ごとのエントリー数、保有期間、リターンの結果を格納する。
	ArrayList<Double> returnListCode = new ArrayList<Double>();
	ArrayList<Double> loseReturnListCode = new ArrayList<Double>();
	ArrayList<Double> winReturnListCode = new ArrayList<Double>();
	ArrayList<Long> entryTimeListCode = new ArrayList<Long>();
	ArrayList<Long> loseEntryTimeListCode = new ArrayList<Long>();
	ArrayList<Long> winEntryTimeListCode = new ArrayList<Long>();
	ArrayList<Long> keepTimeListCode = new ArrayList<Long>();
	ArrayList<Long> loseKeepTimeListCode = new ArrayList<Long>();
	ArrayList<Long> winKeepTimeListCode = new ArrayList<Long>();



	public ArrayList<Double> getReturnListCode() {
		return returnListCode;
	}

	public void setReturnListCode(double returnListCode) {
		this.returnListCode.add(returnListCode);
	}

	public ArrayList<Double> getLoseReturnListCode() {
		return loseReturnListCode;
	}

	public void setLoseReturnListCode(double loseReturnListCode) {
		this.loseReturnListCode.add(loseReturnListCode);
	}

	public ArrayList<Double> getWinReturnListCode() {
		return winReturnListCode;
	}

	public void setWinReturnListCode(double winReturnListCode) {
		this.winReturnListCode.add(winReturnListCode);
	}

	public ArrayList<Long> getEntryTimeListCode() {
		return entryTimeListCode;
	}

	public void setEntryTimeListCode(long entryTimeListCode) {
		this.entryTimeListCode.add(entryTimeListCode);
	}

	public ArrayList<Long> getLoseEntryTimeListCode() {
		return loseEntryTimeListCode;
	}

	public void setLoseEntryTimeListCode(long loseEntryTimeListCode) {
		this.loseEntryTimeListCode.add(loseEntryTimeListCode);
	}

	public ArrayList<Long> getWinEntryTimeListCode() {
		return winEntryTimeListCode;
	}

	public void setWinEntryTimeListCode(long winEntryTimeListCode) {
		this.winEntryTimeListCode.add(winEntryTimeListCode);
	}

	public ArrayList<Long> getKeepTimeListCode() {
		return keepTimeListCode;
	}

	public void setKeepTimeListCode(long keepTimeListCode) {
		this.keepTimeListCode.add(keepTimeListCode);
	}

	public ArrayList<Long> getLoseKeepTimeListCode() {
		return loseKeepTimeListCode;
	}

	public void setLoseKeepTimeListCode(long loseKeepTimeListCode) {
		this.loseKeepTimeListCode.add(loseKeepTimeListCode);
	}

	public ArrayList<Long> getWinKeepTimeListCode() {
		return winKeepTimeListCode;
	}

	public void setWinKeepTimeListCode(long winKeepTimeListCode) {
		this.winKeepTimeListCode.add(winKeepTimeListCode);
	}

	ArrayList<Long> entryTimeList = new ArrayList<Long>();
	long entryTime = 0;
	List<Long> arrayEntryTime = new ArrayList();

	//勝った場合、負けた場合のエントリー回数リスト
	ArrayList<Long> loseEntryTimeList = new ArrayList<Long>();
	ArrayList<Long> winEntryTimeList = new ArrayList<Long>();

	//勝った場合、負けた場合の保有期間リスト
	ArrayList<Long> loseKeepTimeList = new ArrayList<Long>();
	ArrayList<Long> winKeepTimeList = new ArrayList<Long>();

	public double getWinKeepTimeAverage(){
		double total=0.0;
		for (int i = 0 ; i < winKeepTimeList.size() ; i++){
			total = total + winKeepTimeList.get(i);
		}
		return (total/winKeepTimeList.size());
	}

	public double getLoseKeepTimeAverage(){
		double total=0.0;
		for (int i = 0 ; i < loseKeepTimeList.size() ; i++){
			total = total + loseKeepTimeList.get(i);
		}
		return (total/loseKeepTimeList.size());
	}

	public double getWinEntryTimeAverage(){
		double total=0.0;
		for (int i = 0 ; i < winEntryTimeList.size() ; i++){
			total = total + winEntryTimeList.get(i);
		}
		return (total/winEntryTimeList.size());
	}

	public double getLoseEntryTimeAverage(){
		double total=0.0;
		for (int i = 0 ; i < loseEntryTimeList.size() ; i++){
			total = total + loseEntryTimeList.get(i);
		}
		return (total/loseEntryTimeList.size());
	}

	public double getEntryTimeAverage(){
		double total=0.0;
		for (int i = 0 ; i < entryTimeList.size() ; i++){
			total = total + entryTimeList.get(i);
		}
		return (total/entryTimeList.size());
	}

	public ArrayList<Long> getEntryTimeList() {
		return entryTimeList;
	}


	public ArrayList<Long> getLoseKeepTimeList() {
		return loseKeepTimeList;
	}

	public void setLoseKeepTimeList(long loseKeepTimeList) {
		this.loseKeepTimeList.add(loseKeepTimeList);
	}

	public ArrayList<Long> getWinKeepTimeList() {
		return winKeepTimeList;
	}

	public void setWinKeepTimeList(long winKeepTimeList) {
		this.winKeepTimeList.add(winKeepTimeList);
	}

	public ArrayList<Long> getLoseEntryTimeList() {
		return loseEntryTimeList;
	}

	public void setLoseEntryTimeList(long loseEntryTimeList) {
		this.loseEntryTimeList.add(loseEntryTimeList);
	}

	public ArrayList<Long> getWinEntryTimeList() {
		return winEntryTimeList;
	}

	public void setWinEntryTimeList(Long winEntryTimeList) {
		this.winEntryTimeList.add(winEntryTimeList);
	}

	public void setEntryTimeList(Long entryTimeList) {
		this.entryTimeList.add(entryTimeList);
	}

	public long getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(int a) {
		this.entryTime=a;
	}

	public void setEntryTime() {
		this.entryTime++;
	}

	public void setEntryTimeMinus() {
		this.entryTime--;
	}

	public void reSetEntryTime() {
		this.entryTime=0;

	}

	public void reSetRealAverage(){
		this.realAveregePrice = 0;
	}

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

	//トータルのリセットを書く
	public void resetList(){
		loseEntryTimeList = new ArrayList<Long>();
		winEntryTimeList = new ArrayList<Long>();
		entryTimeList = new ArrayList<Long>();
		entryPriceList = new ArrayList<Double>();
		entryDayList = new ArrayList<String>();
		loseKeepTimeList = new ArrayList<Long>();
		winKeepTimeList = new ArrayList<Long>();
		dollerTotalWinTotalResult = new ArrayList<Double>();
		dollerTotalLoseTotalResult = new ArrayList<Double>();
//		returnList = new ArrayList();

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

	public void getResultCodeResult(String resultCode,Bean_Parameta paraDTO){

		//売れずに保有していた場合にこれを出力する。
		if (getCodeKeepStockResult()!=0){
			String keepWord;
			keepWord = paraDTO.getLMETHOD() + ","
					+ paraDTO.getSMETHOD() + ","
					+ paraDTO.getTermType() + ","
					+ resultCode + "," //code
					+ paraDTO.getMaxEntryTimes() + "," //MAXエントリー
					+ paraDTO.getMaxKeepDays() + "," //MAXキープデイ
					+ getMaxInterValTime() + ","  //インターバルタイム
					+ paraDTO.getMaxLoss() + ","  //損切ライン
					+ getDollStockTotalPrice()  + "," //合計投資金額（単位：円）
					+ getDollStockAveragePrice() + "," //平均取得価格（単位：円）
					+ getNewClose() + "," //現在価格（単位：円）
					+ getDollTotalStockVolume()  + "," //合計購入株数
					+ getKeepCount() +  ","  //保有期間
					+ getNewDivide() + "," //1株あたり配当(最新履歴)
					+ ( ( getDollTotalStockVolume() * (getNewClose() - getDollStockAveragePrice() ) ) / ( paraDTO.getEntryMoney() * 10000) ) * 100  + " %" //*100するかも
//					+ getCodeKeepStockResult() + " %"
					+ "\r\n";
			commonAP.writeLog(keepWord, logWriting.KEEP_CODE_RESULT_LOG);

		}


		if( getResultCode() ){


			if ( ( getWinCount() + getLoseCount() ) > 0){

				//勝率が90％のものだけ出力

				double totalCodeGame = (getWinCount() + getLoseCount() );
				double shouritu = getWinCount() / totalCodeGame;
				double totalWin = commonAP.getAverageTotalCountDouble(getWinReturnListCode(),commonAP.TOTAL_FLG) * 100;
				double totalLose = commonAP.getAverageTotalCountDouble(getLoseReturnListCode(),commonAP.TOTAL_FLG) * 100;
				double aveWinEntry = commonAP.getAverageTotalCountLong(getWinEntryTimeListCode(),commonAP.AVERAGE_FLG);
				double aveLoseEntry = commonAP.getAverageTotalCountLong(getLoseEntryTimeListCode(),commonAP.AVERAGE_FLG);
				String winList		= commonAP.getStringList(getWinEntryTimeListCode()	, true);
				String loseList		= commonAP.getStringList(getLoseEntryTimeListCode()	, true);
				double aveWinKeep = commonAP.getAverageTotalCountLong(getWinKeepTimeListCode(),commonAP.AVERAGE_FLG);
				double aveLoseKeep = commonAP.getAverageTotalCountLong(getLoseKeepTimeListCode(),commonAP.AVERAGE_FLG);
				double totalWARIAI = 0;
				try {
					if(totalWin==0){
						totalWin = 0.01;
					}
					totalWARIAI = (totalWin+totalLose)/(totalWin);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("BeanResult:なんかあった。ノーマル");
				}

				//設定した勝率（shoritu）以上の場合、結果を表示する
				if ( shouritu > shoritu){
					if( totalCodeGame > totalGames){
						String elete = paraDTO.getObStartDay() + "_" + paraDTO.getObEndDay() + "," + paraDTO.getLMETHOD() + "," + paraDTO.getSMETHOD() + "," + paraDTO.getTermType() + "," + resultCode + "," + paraDTO.getMaxEntryTimes() + "," + paraDTO.getMaxKeepDays() + "," + getMaxInterValTime() + "," + paraDTO.getMaxLoss() + "\r\n";

						if (checkTotalRatio){

							if (totalWARIAI > getTotalRatio()){
								//トータル勝ち％
								//トータル負け％
								//勝ちエントリー平均
								//勝ち保有期間平均
								//勝ち最大エントリー数
								//勝ち最大保有期間
								//負けエントリー平均
								//負け保有期間平均
								//負け最大エントリー数
								//負け最大保有期間
								//トータル勝ち％ / トータル負け％

								commonAP.writeLog("・" + resultCode +  "：勝【" + getWinCount() + "】",logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("／" +  "：負【" + getLoseCount() + "】",logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("トータル勝％：" + totalWin,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("トータル負％：" + totalLose,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("勝保有期間平均：" + aveWinKeep,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("勝エントリー平均回数：" + aveWinEntry,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("負保有期間平均：" + aveLoseKeep,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("負エントリー平均回数：" + aveLoseEntry,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("勝エントリー回数一覧：" + "・" + resultCode +"," + winList,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("負エントリー回数一覧：" + "・" + resultCode +"," + loseList,logWriting.BACKTEST_LOG_FLG);
								commonAP.writeInLog("保有できずの評価：" + resultCode +"," + getCodeKeepStockResult() + " %",logWriting.BACKTEST_LOG_FLG);
								commonAP.writeLog( elete ,logWriting.CODE_RESULT_LOG_FLG);
								commonAP.writeInLog("トータル％ ／ トータル勝ち％：" + (totalWARIAI),logWriting.BACKTEST_LOG_FLG);
								System.out.println("ここは通っている。レイシオ");
							}
						}else{
							System.out.println("ここ通っている。ノーレイシオ");
							commonAP.writeLog("・" + resultCode +  "：勝【" + getWinCount() + "】",logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("／" +  "：負【" + getLoseCount() + "】",logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("トータル勝％：" + totalWin,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("トータル負％：" + totalLose,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("勝保有期間平均：" + aveWinKeep,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("勝エントリー平均回数：" + aveWinEntry,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("負保有期間平均：" + aveLoseKeep,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("負エントリー平均回数：" + aveLoseEntry,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("勝エントリー回数一覧：" + "・" + resultCode +"," + winList,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("負エントリー回数一覧：" + "・" + resultCode +"," + loseList,logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("保有できずの評価：" + resultCode +"," + getCodeKeepStockResult(),logWriting.BACKTEST_LOG_FLG);
							commonAP.writeInLog("トータル％ ／ トータル勝ち％：" + (totalWARIAI),logWriting.BACKTEST_LOG_FLG);
							//時刻,メソッド名,code
							commonAP.writeLog( elete ,logWriting.CODE_RESULT_LOG_FLG);
						}


					}
				}
//				System.out.print("・" + resultCode +  "：勝【" + getWinCount() + "】");
//				System.out.println("／" +  "：負【" + getLoseCount() + "】");
			}




			if (paraDTO.isDollCostFLG()){
//				・1721_T：勝【29】2017/04/05 19:18:15,／：負【6】
//				2017/04/05 19:18:15,トータル勝％：1698.3196139066436
//				2017/04/05 19:18:15,トータル負％：-652.7782675007876
//				2017/04/05 19:18:15,トータル％ ／ トータル勝ち％：0.6156328513458065
				if ( ( getWinCount() + getLoseCount() ) > 0){
					int totalWinCount = getDollCostCodeWinCount();
					int totalLoseCount = getDollCostCodeLoseCount();
					double totalCodeGame = totalWinCount + totalLoseCount;
					double shouritu = 0;
					shouritu = totalWinCount/totalCodeGame;



					//結果を％表記する。0.5を50％に表記
					double totalCodeWinResult = getDollerCodeWinTotalResult() * 100;
					double totalCodeLoseResult = getDollerCodeLoseTotalResult() * 100;
					String elete = paraDTO.getObStartDay() + "_" + paraDTO.getObEndDay() + "," + paraDTO.getLMETHOD() + "," + paraDTO.getSMETHOD() + "," + paraDTO.getTermType() + "," + resultCode + "," + paraDTO.getMaxEntryTimes() + "," + paraDTO.getMaxKeepDays() + "," + getMaxInterValTime() + "," + paraDTO.getMaxLoss() + "\r\n";
					double totalWin = totalCodeWinResult;
					double totalLose = totalCodeLoseResult;
					double totalWARIAI = 0;
					try {
						if(totalWin==0){
							totalWin = 0.01;
						}
						totalWARIAI = (totalWin+totalLose)/(totalWin);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("BeanResult:なんかあった。ドルコスト");
					}

					if ( shouritu > shoritu){
						if( totalCodeGame > totalGames){

							if (checkTotalRatio){
								if (totalWARIAI > getTotalRatio()){
									commonAP.writeLog("ドルコスト法・" + resultCode +  "：勝【" + totalWinCount + "】",logWriting.DOLLCOST_BACKTEST_LOG_FLG);
									commonAP.writeInLog("／" +  "：負【" + totalLoseCount + "】",logWriting.DOLLCOST_BACKTEST_LOG_FLG);
									commonAP.writeInLog("ドルコスト法,トータル勝％：" + totalCodeWinResult,logWriting.DOLLCOST_BACKTEST_LOG_FLG);
									commonAP.writeInLog("ドルコスト法,トータル負％：" + totalCodeLoseResult,logWriting.DOLLCOST_BACKTEST_LOG_FLG);
									commonAP.writeLog( elete ,logWriting.CODE_DOLLCOST_RESULT_LOG_FLG);
								}
							}
						}
					}

				}

			}
		}

		reSetCodeSatutus(paraDTO);
	}


	public void resetInterval(){
		maxInterValTime=0;
		nowInterValTime=0;
		nowInterValFLG=false;
	}

	//codeのリセットを書く
	private void reSetCodeSatutus(Bean_Parameta paraDTO){
		reSetWinCount();
		reSetLoseCount();
		resetInterval();
		reSetCodeKeepStockResult();
		setMaxLossFLG(false);

		if ( paraDTO.isDollCostFLG() ){
			resetDollCostCodeResult();
		}

		if ( paraDTO.getEliteFLG(true) ){
			//エリートフラグがonのとき、セットする。paraとかをリセットする
//			resultDTO.setEntryDay(entryDay);E
			paraDTO.setMaxEntryTimes	(	2000	);
			paraDTO.setMaxKeepDays		(	2000	);
			paraDTO.setMaxLoss			(	2000	);
			setMaxInterValTime			(	0		);
		}

		returnListCode = new ArrayList<Double>();
		loseReturnListCode = new ArrayList<Double>();
		winReturnListCode = new ArrayList<Double>();
		entryTimeListCode = new ArrayList<Long>();
		loseEntryTimeListCode = new ArrayList<Long>();
		winEntryTimeListCode = new ArrayList<Long>();
		keepTimeListCode = new ArrayList<Long>();
		loseKeepTimeListCode = new ArrayList<Long>();
		winKeepTimeListCode = new ArrayList<Long>();
	}

	//買った日と売る日が同日ではないことを確認する。
	//同日の場合は買った日のエントリーを取り消す。
	public boolean checkSameDay(){



		try {

			if (entryDayList.get(entryDayList.size() -1 ).equals(exitDay) ){
				if ( entryPriceList.size() > 0 ){

					entryPriceList.remove(entryPriceList.size() - 1);
				}

				if (entryDayList.size() > 0 ){
					entryDayList.remove(entryDayList.size() - 1);
				}

				if (entryDayList.size() ==0 ){
					reSetKeepCount();
					return false;
				}
				setEntryTimeMinus();
			}
		} catch (IndexOutOfBoundsException e) {
//			System.out.println("exitDay:" + exitDay);
//			System.out.print("(entryDayList.size()  ):" + (entryDayList.size()  ));
			return false;
		}

		return true;

	}

	public void getResultDayResult(String code,Bean_Parameta paraDTO){

		String result = "";


		//買った日と売る日が同日ではないことを確認する。
		//同日の場合は買った日のエントリーを取り消す。
		//これでentryDayListのレコードが0になるとメソッドの処理を中断する。
		if ( checkSameDay() == false ){
			return;
		};

		//checkSameDayの結果exitDayがnullの場合は終了する。
		if (exitDay==null){
			return;
		}


		double average = getEntryAveragePrice();
		//averageParcentは*100していない
		//例）60％→0.6
		//0.6の形で入っている。
		double averageParcent = (exitPrice - average) / average;

		//手数料を差し引く
		averageParcent = averageParcent - paraDTO.getTesuRYO();


		if ( averageParcent > 0){
			//勝った場合
			setWinCount();
			setTOTAL_WIN();
//			setTotalWinParcent(averageParcent);
			setTotalWinParcent(averageParcent*getEntryTime());
			setWinEntryTimeList ( getEntryTime() );
			setWinKeepTimeList( getKeepCount() );

			//コードごとの成果を入れる
			setWinReturnListCode	( averageParcent*getEntryTime() );
			setWinKeepTimeListCode	( getKeepCount() );
			setWinEntryTimeListCode( getEntryTime() );
			result = "(win)";

		}else{
			//負けた場合
			setLoseCount();
			setTOTAL_LOSE();
//			setTotalLoseParcent(averageParcent);
			setTotalLoseParcent(averageParcent*getEntryTime());
			setLoseEntryTimeList ( getEntryTime() );
			setLoseKeepTimeList( getKeepCount() );
			//コードごとの成果を入れる
			setLoseReturnListCode	( averageParcent*getEntryTime() );
			setLoseKeepTimeListCode	( getKeepCount() );
			setLoseEntryTimeListCode( getEntryTime() );
			result = "(lose)";
		}

//		returnListCode = new ArrayList<Double>();
//		keepTimeListCode = new ArrayList<Long>();
//		entryTimeListCode = new ArrayList<Long>();
//		loseKeepTimeListCode = new ArrayList<Long>();
//		loseReturnListCode = new ArrayList<Double>();
//		loseEntryTimeListCode = new ArrayList<Long>();
//		winEntryTimeListCode = new ArrayList<Long>();
//		winReturnListCode = new ArrayList<Double>();
//		winKeepTimeListCode = new ArrayList<Long>();

		//averageParcentは投資金額に対していくら儲かったか
		//例：一回辺り投資金額1.2万円を5回エントリー、63000円で売れば0.05
		//averageParcentだけではエントリー回数を考慮していないからいくら儲かったかわからないため意味がない
		//→負けまくっている銘柄に投資を繰り返している可能性がある。


		//一回辺り投資金額と比較していくら稼げたか
		//例：一回辺り投資金額1.2万円を5回エントリー、63000円で売れば3000/12000
		double averageParcentEntryTime = averageParcent*getEntryTime();

		//標準偏差を計算する。
		setKeepDayList		( getKeepCount() );
		setReturnList		( averageParcentEntryTime );
		setEntryTimeList	( getEntryTime() );

		//コードごとの成果を入れる
		setReturnListCode	( averageParcentEntryTime );
		setKeepTimeListCode	( getKeepCount() );
		setEntryTimeListCode( getEntryTime() );

//		if(getEntryTime() != 1){
//			System.out.println(code);
//		}

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


		if( getResultDay() ){
//			if (averageParcent>1 || -0.4 > averageParcent){
//				commonAP.writeInLog(code + "," + result + ",【entry】" + getEntryList() + "【exit】" + exitDay + "/" + exitPrice + "【保有期間】," + getKeepCount() + "," + "【リターン絶対値】," + (exitPrice - average) + ",【リターン％】," + averageParcent + ",【エントリー回数】," + getEntryTime(),logWriting.BACKTEST_LOG_FLG);
				//code,勝ち負け,儲かった金絶対値,保有期間,儲かったリターン,エントリー回数,購入日,購入価格
			//code,勝ち負け,平均取得価格,売値,手数料,儲かったリターン,儲かったリターンとエントリー回数結果,保有期間,エントリー回数,購入日,購入価格

				commonAP.writeLog(code + "," + result + ","  + average + "," + exitPrice + "," + paraDTO.getTesuRYO() + ","  + averageParcent + "," + (averageParcent*getEntryTime()) + "," + getKeepCount() + "," + getEntryTime() + "," + getEntryList() + "\r\n",logWriting.BACKTEST_LOG_FLG);
//			}

		}

		if (paraDTO.isDollCostFLG()){
			double dayDollCostGetAverage = getDollStockAveragePrice();



			//結果を％表記する。50％を0.5をに表記
			double dollCostResultParcent = ( (exitPrice - dayDollCostGetAverage) / dayDollCostGetAverage ) - paraDTO.getTesuRYO();
			//一回あたり投資資金と比べていくら増えたか（単位：50％を0.5をに表記）
			double dollReturn = ( dollCostResultParcent * ( getDollStockAveragePrice() * getDollTotalStockVolume() ) ) / (paraDTO.getEntryMoney() * 10000);

//			dollCostResultParcent = dollCostResultParcent;
			//かった株の数合計
//			double volumeStock = getDollTotalStockVolume();

			String resultLetter = "";
			//ドルコストにおける合計投資金額

			if ( dollCostResultParcent > 0){
				//勝ちの時
				setDollCostCodeWinCount();
				setDollCostTotalWinCount();
				setDollerCodeWinTotalResult(dollReturn);
				setDollerTotalWinTotalResult(dollReturn);
				resultLetter = "(win)";
			}else{
				//負けの時
				setDollCostCodeLoseCount();
				setDollCostTotalLoseCount();
				setDollerCodeLoseTotalResult(dollReturn);
				setDollerTotalLoseTotalResult(dollReturn);
				resultLetter = "(lose)";
			}

			if( getResultDay() ){
				//code,勝ち負け,平均取得価格,売値,合計取得株数,手数料(%),儲かったリターン

//				logWriting.CODE_DOLLCOST_RESULT_LOG_FLG
				commonAP.writeLog("ドルコスト法：" + code + "," + resultLetter + "," + dayDollCostGetAverage + "," + exitPrice + "," + getDollTotalStockVolume() + "," + paraDTO.getTesuRYO() + ","  + dollCostResultParcent + "," + ( dollReturn ) + "\r\n",logWriting.DOLLCOST_BACKTEST_LOG_FLG);
				commonAP.writeLog(code + getDollerStockVolumeStockList() + "\r\n",logWriting.CODE_DOLLCOST_STOCKLOST_RESULT_LOG_FLG);
				commonAP.writeLog(code + getDollerStockVolumePriceList() + "\r\n",logWriting.CODE_DOLLCOST_L_PRICE_LISTRESULT_LOG_FLG);
			}
		}

//		if (averageParcent < -0.35 ){
//			System.out.println(code + ":" + result + "【entry】" + getEntryList() + "【exit】" + exitDay + "/" + exitPrice + "【" + getKeepCount() + "】" + (exitPrice - average) + "/" + averageParcent);
//		}

//		resetEntryList();
		resetCount();
	}

	//dayのリセットを書く
	public void resetCount(){
		reSetKeepCount();
		reSetEntryTime();
		reSetRealAverage();
		resetDollerVolumes();
		resetGetDoubleDaytime();
		realStartDay = "0";
	}

	public void getResultTotalResult(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO){
		double half = paraDTO.getCutWariai()/2;
		if( getResultTotal() ){
			try {


				//上下カット平均保有日数
				double aveCutKeepDays = commonAP.getAverageCut(getKeepDayList(), true,commonAP.AVERAGE_FLG,	half,"");
				//上下カット年間勝ち数
				double getCutWinCount=commonAP.getAverageCut(getReturnList(),true,	commonAP.COUNT_FLG,	half);
				double getCutLoseCount=commonAP.getAverageCut(getReturnList(),false,	commonAP.COUNT_FLG,	half);
				//上下1%カット見込みリターン
				//※上のhalfだけカットする。
				double getCutAveReturn=( commonAP.getAverageCut(getReturnList(),true,	commonAP.TOTAL_FLG,	half) + commonAP.getAverageCut(getReturnList(),false,	commonAP.TOTAL_FLG,	half) ) / ( getReturnList().size() * (1-paraDTO.getCutWariai()) ) ;
				//上下カット平均エントリー回数
				//※上のhalfだけカットする。
				double getCutAveEntryTimes	=	commonAP.getAverageCut(getEntryTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");
				double getCutWinAveEntryTimes	=	commonAP.getAverageCut(getWinEntryTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");
				double getCutLoseAveEntryTimes	=	commonAP.getAverageCut(getLoseEntryTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");
//				double getCutAveEntryTimes	=	commonAP.getDev(getEntryTimeList(),true,"",	half,half);
				//上下カットリスク
				double getCutAveRisk = commonAP.getDev(getReturnList(),		true,	half,half);

				commonAP.writeInLog("" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("エリートの有無：" + paraDTO.getEliteFLG(true) ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("配当とかの情報(investFLG)：" + paraDTO.isCheckInvest() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("財務情報データの利用有無(truetrueなら使ってる)：" + paraDTO.isMonthYearDateFLG() + "," + paraDTO.isCheckParaDTOOption() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("Lメソッド：" + paraDTO.getLMETHOD() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("Sメソッド：" + paraDTO.getSMETHOD() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル勝：" + getTOTAL_WIN(),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル負：" + getTOTAL_LOSE(),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("売却できず1：" + ( getTradeCount() - getTOTAL_WIN() - getTOTAL_LOSE() ) ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("売却できず2：" + getKeepCodeCout() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル計：" + getTradeCount(),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル勝％：" + getTotalWinParcent() * 100 +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル負％：" + getTotalLoseParcent() * 100 +  " %" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("売却できずの評価：" +  getTotalKeepStockResult() + " %",logWriting.BACKTEST_LOG_FLG);
				double totalReturn = getTotalWinParcent() + getTotalLoseParcent();
				commonAP.writeInLog("トータルリターン：" + ( ( totalReturn ) * 100 ) +  " %" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("リターンレイシオ：" + ( ( 100 * totalReturn ) / ( ( getTotalWinParcent() ) ) ) +  " %" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("一回辺りリターン：" + (( ( getTotalWinParcent() + getTotalLoseParcent() ) * 100 )/ ( (getTOTAL_WIN()+getTOTAL_LOSE()) * getEntryTimeAverage()) ) +  " %" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル平均勝％：" + (getTotalWinParcent()  * 100) / ( getTOTAL_WIN()  ) +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("トータル平均負％：" + (getTotalLoseParcent() * 100) / ( getTOTAL_LOSE() ) +  " %",logWriting.BACKTEST_LOG_FLG);
//				commonAP.writeInLog("見込みリターン：" + ( totalReturn ) / ( getTOTAL_WIN() + getTOTAL_LOSE())  * 100 +  " %",logWriting.BACKTEST_LOG_FLG);
//				commonAP.writeInLog("見込みリスク：" + commonAP.getDev(getReturnList(),  true)  * 100 +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("平均保有期間(売却できずを除く)：" + getTotalDays() / ( getTOTAL_WIN() + getTOTAL_LOSE() ) ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("平均保有勝ち期間(売却できずを除く)：" + getWinKeepTimeAverage() ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("平均保有負け期間(売却できずを除く)：" + getLoseKeepTimeAverage() ,logWriting.BACKTEST_LOG_FLG);

				commonAP.writeInLog("保有期間標準偏差：" + commonAP.getDev(getKeepDayList(), true,""),logWriting.BACKTEST_LOG_FLG);

				commonAP.writeInLog("平均エントリー回数：" + getEntryTimeAverage(),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("平均勝ちエントリー回数：" + getWinEntryTimeAverage(),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("平均負けエントリー回数：" + getLoseEntryTimeAverage(),logWriting.BACKTEST_LOG_FLG);



				commonAP.writeInLog("エントリー回数標準偏差：" + commonAP.getDev(getEntryTimeList(), true,""),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("勝ちエントリー回数標準偏差：" + commonAP.getDev(getWinEntryTimeList(), true,""),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("負けエントリー回数標準偏差：" + commonAP.getDev(getLoseEntryTimeList(), true,""),logWriting.BACKTEST_LOG_FLG);


				commonAP.writeInLog("上" + half * 100 +  "%カットトータル勝："			+	getCutWinCount		,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("下" + half * 100 +  "%カットトータル負："				+ getCutLoseCount	,logWriting.BACKTEST_LOG_FLG);

				double getCutTotalWIN = commonAP.getAverageCut(getReturnList(),true,	commonAP.TOTAL_FLG,	half) * 100;
				double getCutTotalLose = commonAP.getAverageCut(getReturnList(),false,	commonAP.TOTAL_FLG,	half) * 100;


//				double getCutTotalReturn = (( ( getCutTotalLose + getCutTotalWIN ) / ( getCutWinCount + getCutLoseCount )*aveCutKeepDays ) );
				double getCutTotalReturn = getCutTotalLose + getCutTotalWIN;
				commonAP.writeInLog("上" + half * 100 +  "%カットトータル勝％："			+ getCutTotalWIN +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("下" + half * 100 +  "%カットトータル負％："			+ getCutTotalLose +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下" + half * 100 +  "%カットトータルリターン："		+ (getCutTotalReturn) +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下" + half * 100 +  "一回辺りリターン%：" + (getCutTotalReturn)/((getCutWinCount+getCutLoseCount)) +  " %" ,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上" + half * 100 +  "%カットトータル平均勝％："		+ (getCutTotalWIN*100)/(getCutWinCount) +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("下" + half * 100 +  "%カットトータル平均負％："		+ (getCutTotalLose*100)/(getCutLoseCount) +  " %",logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("出来高中期移動平均線：" + paraDTO.getMinDeki(),logWriting.BACKTEST_LOG_FLG);

//				commonAP.writeInLog("上下0.5%カット見込みリターン："		+ getCutAveReturn * 100 +  " %",logWriting.BACKTEST_LOG_FLG);
//				commonAP.writeInLog("上下1%カット見込みリターン："		+ ( commonAP.getAverageCut(getReturnList(),true,	commonAP.TOTAL_FLG,	half) + commonAP.getAverageCut(getReturnList(),false,	commonAP.TOTAL_FLG,	half) ) / ( getReturnList().size() * (paraDTO.getCutWariai()) ),logWriting.BACKTEST_LOG_FLG);


//				commonAP.writeInLog("上下1%カットリスク："				+ ( getCutAveRisk * 100 ) +  " %",logWriting.BACKTEST_LOG_FLG);







				double getCutWinAveKeepTimes	=	commonAP.getAverageCut(getWinKeepTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");
				double getCutLoseAveKeepTimes	=	commonAP.getAverageCut(getLoseKeepTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");

				commonAP.writeInLog("上" + half * 100 +  "%カット平均保有期間："			+ aveCutKeepDays,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上" + half * 100 +  "%カット平均勝ち平均保有期間："			+ getCutWinAveKeepTimes,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("下" + half * 100 +  "%カット平均負け平均保有期間："			+ getCutLoseAveKeepTimes,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カット保有期間標準偏差："		+ commonAP.getDev(getKeepDayList(),		true,"",half,half),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カット勝ち平均保有期間標準偏差："	+ commonAP.getDev(getWinKeepTimeList(),	true,"",half,half),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カット負け平均保有期間標準偏差："	+ commonAP.getDev(getLoseKeepTimeList(),	true,"",half,half),logWriting.BACKTEST_LOG_FLG);



				commonAP.writeInLog("上" + half * 100 +  "%カット平均エントリー回数："			+ getCutAveEntryTimes,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上" + half * 100 +  "%カット平均勝ちエントリー回数："			+ getCutWinAveEntryTimes,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上" + half * 100 +  "%カット平均負けエントリー回数："			+ getCutLoseAveEntryTimes,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カットエントリー回数標準偏差："	+ commonAP.getDev(getEntryTimeList(),	true,"",half,half),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カット勝ちエントリー回数標準偏差："	+ commonAP.getDev(getWinEntryTimeList(),	true,"",half,half),logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("上下1%カット負けエントリー回数標準偏差："	+ commonAP.getDev(getLoseEntryTimeList(),	true,"",half,half),logWriting.BACKTEST_LOG_FLG);
//				double getCutAveEntryTimes	=	commonAP.getAverageCut(getEntryTimeList(),true,	commonAP.AVERAGE_FLG,	paraDTO.getCutWariai(),"");

				commonAP.writeInLog("手数料：" + paraDTO.getTesuRYO()*100 + "%",logWriting.BACKTEST_LOG_FLG);

				//期間のエンドとスタートがはっきりしている場合はここ
				if ( paraDTO.getTermFLG() ){


					//年間営業日は245で想定
					int yearDay	=	245;
					//一日辺りのサイン点灯数
					double dayRightUpTimes	=	(	getCutAveEntryTimes	*	getTradeCount()		)	/(paraDTO.getObTerm());
//					double dayRightUpTimes	=	(	getCutAveEntryTimes	*	getTradeCount()	);


					//必要資金
					double needMoney	=	dayRightUpTimes
										*	paraDTO.getEntryMoney()
										*	aveCutKeepDays;
					commonAP.writeInLog("一日辺りサイン点灯数：" + dayRightUpTimes ,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("必要投資資金："	+	needMoney + " 万円"	,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("一回辺りエントリー金額："	+	paraDTO.getEntryMoney() + " 万円"	,logWriting.BACKTEST_LOG_FLG);
					//回転サイクル
					double kaitenCyecle=yearDay/(aveCutKeepDays*dayRightUpTimes);
					//トータルで稼いだお金
					double totalGetMoney = ( ( getCutTotalWIN + getCutTotalLose ) / 100 ) * paraDTO.getEntryMoney();
					//一年間で稼ぐお金
					double yearEarnMoney = ((totalGetMoney*yearDay)/(paraDTO.getObTerm()));

//					commonAP.writeInLog("想定金利："	+	( (100 * paraDTO.getEntryMoney() * getCutAveReturn * dayRightUpTimes * yearDay) /needMoney )	 + "%"	,logWriting.BACKTEST_LOG_FLG);
//					commonAP.writeInLog("想定金利："	+	( (100 *  getCutAveReturn * yearDay) /aveCutKeepDays )	 + "%"	,logWriting.BACKTEST_LOG_FLG);

					commonAP.writeInLog("想定金利："	+	( (100) * (yearEarnMoney/needMoney) )	 + "%"	,logWriting.BACKTEST_LOG_FLG);
//					commonAP.writeInLog("想定リスク："	+	( (100 *  getCutAveRisk * yearDay) /aveCutKeepDays )	 + "%"	,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("開始時期：" + paraDTO.getObStartDay() ,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("終了時期：" + paraDTO.getObEndDay() ,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("調査期間：" + paraDTO.getObTerm() + " 営業日",logWriting.BACKTEST_LOG_FLG);



					String resultLetter =paraDTO.getObStartDay() + "_" + paraDTO.getObEndDay() + "_" + paraDTO.getLMETHOD() + "_" + paraDTO.getSMETHOD() + ","
										+ getTOTAL_WIN() + ","
										+ getTOTAL_LOSE() + ","
										+ ( getTradeCount() - getTOTAL_WIN() - getTOTAL_LOSE() ) + ","
										+ ( getTotalWinParcent() * 100 ) + ","
										+ ( getTotalLoseParcent() * 100 ) + ","
										+ (totalReturn*100) + ","
										+ getTotalKeepStockResult() + ","
										+ ( ( ( 100 * totalReturn ) / ( ( getTotalWinParcent() ) ) ) ) + ","
										+ ((( ( getTotalWinParcent() + getTotalLoseParcent() ) * 100 )/ ( (getTOTAL_WIN()+getTOTAL_LOSE()) * getEntryTimeAverage()) ) ) + ","
										+ (getTotalDays() / ( getTOTAL_WIN() + getTOTAL_LOSE() ) ) + ","
										+ ( getWinKeepTimeAverage() ) + ","
										+ getLoseKeepTimeAverage() + ","
										+ getEntryTimeAverage() + ","
										+ getWinEntryTimeAverage() + ","
										+ getLoseEntryTimeAverage() + ","
										+  (paraDTO.getTesuRYO()*100) + "%" + ","
										+ dayRightUpTimes + ","
										+ paraDTO.getMinDeki() + ","
										+ needMoney + " 万円" + ","
										+ ( (100) * (yearEarnMoney/needMoney) ) + "%";
					//時刻,メソッド名,勝,負,売却できず,勝％,負％,トータルリターン,売却できずの評価,レイシオ,一回辺りリターン,保有期間,勝ち保有期間,負け保有期間,平均E数,勝ちE数,負けE数,手数料,一日辺りサイン点灯数,出来高中期移動平均線,必要資金,金利
					commonAP.writeInLog(resultLetter,logWriting.CODE_RESULT_LIST_LOG_FLG);

				}


				commonAP.writeInLog("	 17%以上 ："	+	resultPlusClassOver,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	16%～ 17%："	+	resultPlusClass17,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	15%～ 16%："	+	resultPlusClass16,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	14%～ 15%："	+	resultPlusClass15,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	13%～ 14%："	+	resultPlusClass14,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	12%～ 13%："	+	resultPlusClass13,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	11%～ 12%："	+	resultPlusClass12,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	10%～ 11%："	+	resultPlusClass11,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  9～ 10%："	+	resultPlusClass10,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  8～  9%："	+	resultPlusClass09,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  7～  8%："	+	resultPlusClass08,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  6～  7%："	+	resultPlusClass07,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  5～  6%："	+	resultPlusClass06,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  4～  5%："	+	resultPlusClass05,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  3～  4%："	+	resultPlusClass04,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  2～  3%："	+	resultPlusClass03,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  1～  2%："	+	resultPlusClass02,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	  0～  1%："	+	resultPlusClass01,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-1 ～  0%："	+	resultMinusClass01,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-2 ～ -1%："	+	resultMinusClass02,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-3 ～ -2%："	+	resultMinusClass03,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-4 ～ -3%："	+	resultMinusClass04,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-5 ～ -4%："	+	resultMinusClass05,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-6 ～ -5%："	+	resultMinusClass06,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-7 ～ -6%："	+	resultMinusClass07,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-8 ～ -7%："	+	resultMinusClass08,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-9 ～ -8%："	+	resultMinusClass09,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-10～ -9%："	+	resultMinusClass10,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-11～-10%："	+	resultMinusClass11,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-12～-11%："	+	resultMinusClass12,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-13～-12%："	+	resultMinusClass13,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-14～-13%："	+	resultMinusClass14,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-15～-14%："	+	resultMinusClass15,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-16～-15%："	+	resultMinusClass16,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-17～-16%："	+	resultMinusClass17,logWriting.BACKTEST_LOG_FLG);
				commonAP.writeInLog("	-17%以下 ："	+	resultMinusClassOver,logWriting.BACKTEST_LOG_FLG);



				if(paraDTO.isDollCostFLG()){
					double totalWinPer = getDollerTotalWinTotalResult() * 100;
					double totalLosePer = getDollerTotalLoseTotalResult() * 100;
					double totalResult = totalWinPer + totalLosePer;

					//年間営業日は245で想定
					int yearDay	=	245;
					//一日辺りのサイン点灯数
					double dayRightUpTimes	=	(	getCutAveEntryTimes	*	getTradeCount()		)	/(paraDTO.getObTerm());
					//必要資金
					double needMoney	=	dayRightUpTimes
										*	paraDTO.getEntryMoney()
										*	aveCutKeepDays;

					//トータルで稼ぐお金
					double earnMoneyDoll = (totalResult / 100) * paraDTO.getEntryMoney() ;
					//一年間で稼ぐお金
					double yearEarnMoney = (earnMoneyDoll  * yearDay) / paraDTO.getObTerm();
					//単位：万円
//					double cycleYear = ( ( totalResult * yearDay ) / paraDTO.getObTerm() );

					double kinriPer = ( ( ( yearEarnMoney ) ) / needMoney ) * 100;

					//この辺カット版の計算
					double cutWinPer = getDollerTotalWinTotalResult(half) * 100;
					double cutLosePer = getDollerTotalLoseTotalResult(half) * 100;
					double cutEarnMoneyDoll = ( ( cutWinPer + cutLosePer ) / 100) * paraDTO.getEntryMoney() ;
					double cutYearEarnMoney = (cutEarnMoneyDoll  * yearDay) / paraDTO.getObTerm();
//					double cutCycleYear = ( ( ( cutWinPer+cutLosePer ) * yearDay ) / paraDTO.getObTerm() );
					double cutKinriPer = ( ( ( cutYearEarnMoney ) ) / needMoney ) * 100;


					commonAP.writeInLog("----------------ここからドルコスト法--------------------"  ,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("勝ち数　　　："  + getDollCostTotalWinCount()				,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("負け数　　　："  + getDollCostTotalLoseCount()				,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("勝ち％　　　："  + totalWinPer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("負け％　　　："  + totalLosePer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("トータル％　："  + totalResult + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("金利％　　　："  + kinriPer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("上" + half * 100 + "カット" + "トータル勝ち数　　　："  + getDollCostTotalWinCount()  * (1-half)			,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("下" + half * 100 + "カット" + "トータル負け数　　　："  + getDollCostTotalLoseCount()  * (1-half)			,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("上" + half * 100 + "カット" + "勝ち％　　　："  + cutWinPer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("下" + half * 100 + "カット" + "負け％　　　："  + cutLosePer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("カットトータル％　："  + (cutLosePer+cutWinPer) + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("カット金利％　　　："  + cutKinriPer + " %"						,logWriting.BACKTEST_LOG_FLG);
					commonAP.writeInLog("----------------ここまでドルコスト法--------------------"  ,logWriting.BACKTEST_LOG_FLG);

					String resultDOLLCOSTLetter =paraDTO.getObStartDay() + "_" + paraDTO.getObEndDay() + "_" + paraDTO.getLMETHOD() + "_" + paraDTO.getSMETHOD() + ","
							+ getDollCostTotalWinCount() + ","
							+ getDollCostTotalLoseCount()  + ","
							+ ( getTradeCount() - getTOTAL_WIN() - getTOTAL_LOSE() )  + ","
							+ ( totalWinPer  ) + ","
							+ ( totalLosePer ) + ","
							+ (totalResult) + ","
							+ getTotalKeepStockResult() + ","
							+ ( ( ( totalResult ) / ( ( totalWinPer ) ) ) ) + ","
							+  (paraDTO.getTesuRYO()*100) + "%"  + ","
							+ dayRightUpTimes + ","
							+ paraDTO.getMinDeki() + ","
							+ needMoney + " 万円" + ","
							+ kinriPer + "%" + ","
							+ (cutKinriPer ) + "%";
					//時刻,メソッド名,勝,負,売却できず,勝％,負％,トータルリターン,売却できずの評価,レイシオ,手数料,一日辺りサイン点灯数,出来高中期移動平均線,必要資金,金利,カット金利
					commonAP.writeInLog(resultDOLLCOSTLetter,logWriting.CODE_DOLLCOTST_RESULT_LIST_LOG_FLG);

					commonAP.writeLog("-------" + paraDTO.getLMETHOD() +  "_" + paraDTO.getSMETHOD() + "-------" + "\r\n",logWriting.DOLLCOST_BACKTEST_LOG_FLG);
					commonAP.writeLog("-------" + paraDTO.getLMETHOD() +  "_" + paraDTO.getSMETHOD() + "-------" + "\r\n",logWriting.CODE_DOLLCOST_STOCKLOST_RESULT_LOG_FLG);
					commonAP.writeLog("-------" + paraDTO.getLMETHOD() +  "_" + paraDTO.getSMETHOD() + "-------" + "\r\n",logWriting.CODE_DOLLCOST_L_PRICE_LISTRESULT_LOG_FLG);
				}

			} catch (Exception e) {
				commonAP.writeInLog("	ここでエラー発生。次の処理へゆきます。",logWriting.BACKTEST_LOG_FLG);
				String errLetter =paraDTO.getObStartDay() + "_" + paraDTO.getObEndDay() + "_" + paraDTO.getLMETHOD() + "_" + paraDTO.getSMETHOD() + "," + "0" + "," + "0" + ",0,0,0,0,0,0,0,0,0,0,0,0%,0,0 万円,0%";
				//時刻,メソッド名,勝,負,勝％,負％,トータルリターン,レイシオ,一回辺りリターン,保有期間,勝ち保有期間,負け保有期間,平均E数,勝ちE数,負けE数,手数料,必要資金,一日辺りサイン点灯数,金利
				commonAP.writeInLog(errLetter,logWriting.CODE_RESULT_LIST_LOG_FLG);
			}




		}
		resetTotalKeepStockResult();
		resetList();
		reSetKeepCount();
		reSetEntryTime();
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
				entryList = entryList + "," + entryPriceList.get(i);
			}
		}

		for (int i = 0 ; i < entryDayList.size() ; i++){
			if(i==0){
				dayList = entryDayList.get(i) + "";
			}else{
				dayList = dayList + "/" + entryDayList.get(i);
			}
		}

		return dayList + "," +  entryList;
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

	double realAveregePrice;
	public void setRealAveragePrice(double price){
		this.realAveregePrice = price;
	}

	public double getRealAveragePrice(){
		return realAveregePrice;
	}

//	//一応nowDTOも入れているが必要なさそう
	public double getNowAveragePrice(Bean_Parameta paraDTO,Bean_nowRecord nowDTO){

		double nowAvePrice;

		if ( paraDTO.getRealTimeMode() ){
			//本番
			nowAvePrice = getRealAveragePrice();
		}else{
			//バックテスト
			nowAvePrice = getEntryAveragePrice();

		}
		return nowAvePrice;
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

	public void setKeepCount(int a) {
		this.keepCount=a;
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

	public double getShoritu() {
		return shoritu;
	}

	public void setShoritu(double shoritu) {
		this.shoritu = shoritu;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}




}
