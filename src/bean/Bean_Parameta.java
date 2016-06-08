package bean;

import proparty.controllDay;
import constant.ReCord;

public class Bean_Parameta {
	//出来高の調査する場合の、推移していないことを示す値
	double BOXCHECK;
	//出来高の調査する場合の、出来高の上がっている期間を示す
	double HIGHT_DEKI_RATIO;

	//ボーナス月日。MM-DDで入力
	String bonus_01;
	String bonus_02;
	String bonus_03;
	//給料日。MMで入力
	String saraly_01;
	String saraly_02;
	String saraly_03;

	String targetColumn_S_01;
	String targetColumn_S_02;
	String targetColumn_S_03;
	String targetColumn_S_04;

	String targetColumn_L_01;
	String targetColumn_L_02;
	String targetColumn_L_03;
	String targetColumn_L_04;

	Double targetColumn01_value;
	Double targetColumn02_value;
	Double targetColumn03_value;
	Double targetColumn04_value;

	//持ち株会のチェックとか
	String checkDay_01;
	String checkDay_02;
	String checkDay_03;
	String checkDay_04;



	public String getBonus_01() {
		return bonus_01;
	}

	public void setBonus_01(String bonus_01) {
		this.bonus_01 = bonus_01;
	}

	public String getBonus_02() {
		return bonus_02;
	}

	public void setBonus_02(String bonus_02) {
		this.bonus_02 = bonus_02;
	}

	public String getBonus_03() {
		return bonus_03;
	}

	public void setBonus_03(String bonus_03) {
		this.bonus_03 = bonus_03;
	}

	public String getSaraly_01() {
		return saraly_01;
	}

	public void setSaraly_01(String saraly_01) {
		this.saraly_01 = saraly_01;
	}

	public String getSaraly_02() {
		return saraly_02;
	}

	public void setSaraly_02(String saraly_02) {
		this.saraly_02 = saraly_02;
	}

	public String getSaraly_03() {
		return saraly_03;
	}

	public void setSaraly_03(String saraly_03) {
		this.saraly_03 = saraly_03;
	}

	public String getCheckDay_01() {
		return checkDay_01;
	}

	public void setCheckDay_01(String checkDay_01) {
		this.checkDay_01 = checkDay_01;
	}

	public String getCheckDay_02() {
		return checkDay_02;
	}

	public void setCheckDay_02(String checkDay_02) {
		this.checkDay_02 = checkDay_02;
	}

	public String getCheckDay_03() {
		return checkDay_03;
	}

	public void setCheckDay_03(String checkDay_03) {
		this.checkDay_03 = checkDay_03;
	}

	public String getCheckDay_04() {
		return checkDay_04;
	}

	public void setCheckDay_04(String checkDay_04) {
		this.checkDay_04 = checkDay_04;
	}

	public double getBOXCHECK() {
		return BOXCHECK;
	}

	public void setBOXCHECK(double bOXCHECK) {
		BOXCHECK = bOXCHECK;
	}

	public double getHIGHT_DEKI_RATIO() {
		return HIGHT_DEKI_RATIO;
	}

	public void setHIGHT_DEKI_RATIO(double hIGHT_DEKI_RATIO) {
		HIGHT_DEKI_RATIO = hIGHT_DEKI_RATIO;
	}


	public String getTargetColumn_S_01() {
		return targetColumn_S_01;
	}

	public void setTargetColumn_S_01(String targetColumn_S_01) {
		this.targetColumn_S_01 = targetColumn_S_01;
	}

	public String getTargetColumn_S_02() {
		return targetColumn_S_02;
	}

	public void setTargetColumn_S_02(String targetColumn_S_02) {
		this.targetColumn_S_02 = targetColumn_S_02;
	}

	public String getTargetColumn_S_03() {
		return targetColumn_S_03;
	}

	public void setTargetColumn_S_03(String targetColumn_S_03) {
		this.targetColumn_S_03 = targetColumn_S_03;
	}

	public String getTargetColumn_S_04() {
		return targetColumn_S_04;
	}

	public void setTargetColumn_S_04(String targetColumn_S_04) {
		this.targetColumn_S_04 = targetColumn_S_04;
	}

	public String getTargetColumn_L_01() {
		return targetColumn_L_01;
	}

	public void setTargetColumn_L_01(String targetColumn_L_01) {
		this.targetColumn_L_01 = targetColumn_L_01;
	}

	public String getTargetColumn_L_02() {
		return targetColumn_L_02;
	}

	public void setTargetColumn_L_02(String targetColumn_L_02) {
		this.targetColumn_L_02 = targetColumn_L_02;
	}

	public String getTargetColumn_L_03() {
		return targetColumn_L_03;
	}

	public void setTargetColumn_L_03(String targetColumn_L_03) {
		this.targetColumn_L_03 = targetColumn_L_03;
	}

	public String getTargetColumn_L_04() {
		return targetColumn_L_04;
	}

	public void setTargetColumn_L_04(String targetColumn_L_04) {
		this.targetColumn_L_04 = targetColumn_L_04;
	}
	//勝った場合の値段の比率。
	private Double winWariai	=	0.0;
	private Double loseWariai	=	0.0;

	//勝った時のお値段
	private double buyPrice		=	0;

	private int winCount		=	0;


	private int loseCount		=	0;
	private int totalTrade		=	0;
	private	int	keepCount		=	0;
	//条件出来高

	//なんでもいいから数える
	int intCount01				=	0;
	int intCount02				=	0;
	int intCount03				=	0;
	int intCount04				=	0;
	int intCount05				=	0;
	double doublePara01			=	0;
	double doublePara02			=	0;
	double doublePara03			=	0;
	double doublePara04			=	0;
	double doublePara05			=	0;

	//期間
	private String startDay		=	ReCord.KOSHINBI_SHOKI ;
	private String endDay		=	controllDay.getTODAY();
	private String dayTime01;
	private String dayTime02;
	//Term		:注目する期間1
	//beforeTerm:注目する期間2
	private int term01;
	private int term02;

	//flg
	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	private boolean flg01_stock	=	false;
	private boolean flg02_statics	=	false;
	private boolean flg03_index	=	false;
	private boolean flg04_etf	=	false;
	private boolean flg05_sakimono	=	false;
	private boolean flg06_currency	=	false;
	private String cateflg;

	private String code;





	public int getIntCount01() {
		return intCount01;
	}

	public void setIntCount01(int intCount01) {
		this.intCount01 = intCount01;
	}

	public int getIntCount02() {
		return intCount02;
	}

	public void setIntCount02(int intCount02) {
		this.intCount02 = intCount02;
	}

	public int getIntCount03() {
		return intCount03;
	}

	public void setIntCount03(int intCount03) {
		this.intCount03 = intCount03;
	}

	public int getIntCount04() {
		return intCount04;
	}

	public void setIntCount04(int intCount04) {
		this.intCount04 = intCount04;
	}

	public int getIntCount05() {
		return intCount05;
	}

	public void setIntCount05(int intCount05) {
		this.intCount05 = intCount05;
	}

	public double getDoublePara01() {
		return doublePara01;
	}

	public void setDoublePara01(double doublePara01) {
		this.doublePara01 = doublePara01;
	}

	public double getDoublePara02() {
		return doublePara02;
	}

	public void setDoublePara02(double doublePara02) {
		this.doublePara02 = doublePara02;
	}

	public double getDoublePara03() {
		return doublePara03;
	}

	public void setDoublePara03(double doublePara03) {
		this.doublePara03 = doublePara03;
	}

	public double getDoublePara04() {
		return doublePara04;
	}

	public void setDoublePara04(double doublePara04) {
		this.doublePara04 = doublePara04;
	}

	public double getDoublePara05() {
		return doublePara05;
	}

	public void setDoublePara05(double doublePara05) {
		this.doublePara05 = doublePara05;
	}



	public Double getWinWariai() {
		return winWariai;
	}

	public void setWinWariai(Double winWariai) {
		this.winWariai = winWariai;
	}

	public Double getLoseWariai() {
		return loseWariai;
	}

	public void setLoseWariai(Double loseWariai) {
		this.loseWariai = loseWariai;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getLoseCount() {
		return loseCount;
	}

	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}

	public int getTotalTrade() {
		return totalTrade;
	}

	public void setTotalTrade(int totalTrade) {
		this.totalTrade = totalTrade;
	}

	public int getKeepCount() {
		return keepCount;
	}

	public void setKeepCount(int keepCount) {
		this.keepCount = keepCount;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getDayTime01() {
		return dayTime01;
	}

	public void setDayTime01(String dayTime) {
		this.dayTime01 = dayTime;
	}

	public String getDayTime02() {
		return dayTime02;
	}

	public void setDayTime02(String dayTime02) {
		this.dayTime02 = dayTime02;
	}

	public int getTerm01() {
		return term01;
	}

	public void setTerm01(int term01) {
		this.term01 = term01;
	}

	public int getTerm02() {
		return term02;
	}

	public void setTerm02(int term02) {
		this.term02 = term02;
	}

	public boolean isFlg01_stock() {
		return flg01_stock;
	}

	public void setFlg01_stock(boolean flg01_stock) {
		this.flg01_stock = flg01_stock;
	}

	public boolean isFlg02_statics() {
		return flg02_statics;
	}

	public void setFlg02_statics(boolean flg02_statics) {
		this.flg02_statics = flg02_statics;
	}

	public boolean isFlg03_index() {
		return flg03_index;
	}

	public void setFlg03_index(boolean flg03_index) {
		this.flg03_index = flg03_index;
	}

	public boolean isFlg04_etf() {
		return flg04_etf;
	}

	public void setFlg04_etf(boolean flg04_etf) {
		this.flg04_etf = flg04_etf;
	}

	public boolean isFlg05_sakimono() {
		return flg05_sakimono;
	}

	public void setFlg05_sakimono(boolean flg05_sakimono) {
		this.flg05_sakimono = flg05_sakimono;
	}

	public boolean isFlg06_currency() {
		return flg06_currency;
	}

	public void setFlg06_currency(boolean flg06_currency) {
		this.flg06_currency = flg06_currency;
	}

	public String getCateflg() {
		return cateflg;
	}

	public void setCateflg(String cateflg) {
		this.cateflg = cateflg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getTargetColumn01_value() {
		return targetColumn01_value;
	}
	public void setTargetColumn01_value(Double targetColumn01_value) {
		this.targetColumn01_value = targetColumn01_value;
	}
	public Double getTargetColumn02_value() {
		return targetColumn02_value;
	}
	public void setTargetColumn02_value(Double targetColumn02_value) {
		this.targetColumn02_value = targetColumn02_value;
	}
	public Double getTargetColumn03_value() {
		return targetColumn03_value;
	}
	public void setTargetColumn03_value(Double targetColumn03_value) {
		this.targetColumn03_value = targetColumn03_value;
	}
	public Double getTargetColumn04_value() {
		return targetColumn04_value;
	}
	public void setTargetColumn04_value(Double targetColumn04_value) {
		this.targetColumn04_value = targetColumn04_value;
	}


}
