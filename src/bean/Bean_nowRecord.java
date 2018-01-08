package bean;

import java.sql.ResultSet;

public class Bean_nowRecord {

	//-----ここからINVESTTBL
	//市場
	String MARKET;
	//業種
	String CATEGORY;
	double MARKET_CAP_PPT		; //時価総額（百万円）
	double STOCK_NUM				; //発行済株式数
	double DIVIDEND_PER					; //配当利回り
	double DIVIDEND  						; //1株配当
	double PER_YOSO  						; //PER（予想）
	double PBR_REAL  						; //PBR（実績）
	double EPS_YOSO						; //EPS（予想）
	double BPS_REAL						; //BPS（実績）
	String YEAR_MAX_DAY_YYYYMMDD		; //高値日付
	double YEAR_MAX						; //年初来高値
	String YEAR_MIN_DAY_YYYYMMDD		; //安値日付
	double YEAR_MIN						; //年初来安値
	double MARKET_CAP_PPT_PRE		; //時価総額（百万円）_PRE
	double STOCK_NUM_PRE				; //発行済株式数_PRE
	double DIVIDEND_PER_PRE					; //配当利回り_PRE
	double DIVIDEND_PRE				; //1株配当_PRE
	double PER_YOSO_PRE				; //PER（予想）_PRE
	double PBR_REAL_PRE				; //PBR（実績）_PRE
	double EPS_YOSO_PRE						; //EPS（予想）_PRE
	double BPS_REAL_PRE						; //BPS（実績）_PRE
	String YEAR_MAX_DAY_YYYYMMDD_PRE		; //高値日付_PRE
	double YEAR_MAX_PRE						; //年初来高値_PRE
	String YEAR_MIN_DAY_YYYYMMDD_PRE		; //安値日付_PRE
	double YEAR_MIN_PRE						; //年初来安値_PRE



	public String getMARKET() {
		return MARKET;
	}

	public void setMARKET(String mARKET) {
		MARKET = mARKET;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public double getMARKET_CAP_PPT() {
		return MARKET_CAP_PPT;
	}

	public void setMARKET_CAP_PPT(double mARKET_CAP_PPT) {
		MARKET_CAP_PPT = mARKET_CAP_PPT;
	}

	public double getSTOCK_NUM() {
		return STOCK_NUM;
	}

	public void setSTOCK_NUM(double sTOCK_NUM) {
		STOCK_NUM = sTOCK_NUM;
	}

	public double getDIVIDEND_PER() {
		return DIVIDEND_PER;
	}

	public void setDIVIDEND_PER(double dIVIDEND_PER) {
		DIVIDEND_PER = dIVIDEND_PER;
	}

	public double getDIVIDEND() {
		return DIVIDEND;
	}

	public void setDIVIDEND(double dIVIDEND) {
		DIVIDEND = dIVIDEND;
	}

	public double getPER_YOSO() {
		return PER_YOSO;
	}

	public void setPER_YOSO(double pER_YOSO) {
		PER_YOSO = pER_YOSO;
	}

	public double getPBR_REAL() {
		return PBR_REAL;
	}

	public void setPBR_REAL(double pBR_REAL) {
		PBR_REAL = pBR_REAL;
	}

	public double getEPS_YOSO() {
		return EPS_YOSO;
	}

	public void setEPS_YOSO(double ePS_YOSO) {
		EPS_YOSO = ePS_YOSO;
	}

	public double getBPS_REAL() {
		return BPS_REAL;
	}

	public void setBPS_REAL(double bPS_REAL) {
		BPS_REAL = bPS_REAL;
	}

	public String getYEAR_MAX_DAY_YYYYMMDD() {
		return YEAR_MAX_DAY_YYYYMMDD;
	}

	public void setYEAR_MAX_DAY_YYYYMMDD(String yEAR_MAX_DAY_YYYYMMDD) {
		YEAR_MAX_DAY_YYYYMMDD = yEAR_MAX_DAY_YYYYMMDD;
	}

	public double getYEAR_MAX() {
		return YEAR_MAX;
	}

	public void setYEAR_MAX(double yEAR_MAX) {
		YEAR_MAX = yEAR_MAX;
	}

	public String getYEAR_MIN_DAY_YYYYMMDD() {
		return YEAR_MIN_DAY_YYYYMMDD;
	}

	public void setYEAR_MIN_DAY_YYYYMMDD(String yEAR_MIN_DAY_YYYYMMDD) {
		YEAR_MIN_DAY_YYYYMMDD = yEAR_MIN_DAY_YYYYMMDD;
	}

	public double getYEAR_MIN() {
		return YEAR_MIN;
	}

	public void setYEAR_MIN(double yEAR_MIN) {
		YEAR_MIN = yEAR_MIN;
	}

	public double getMARKET_CAP_PPT_PRE() {
		return MARKET_CAP_PPT_PRE;
	}

	public void setMARKET_CAP_PPT_PRE(double mARKET_CAP_PPT_PRE) {
		MARKET_CAP_PPT_PRE = mARKET_CAP_PPT_PRE;
	}

	public double getSTOCK_NUM_PRE() {
		return STOCK_NUM_PRE;
	}

	public void setSTOCK_NUM_PRE(double sTOCK_NUM_PRE) {
		STOCK_NUM_PRE = sTOCK_NUM_PRE;
	}

	public double getDIVIDEND_PER_PRE() {
		return DIVIDEND_PER_PRE;
	}

	public void setDIVIDEND_PER_PRE(double dIVIDEND_PER_PRE) {
		DIVIDEND_PER_PRE = dIVIDEND_PER_PRE;
	}

	public double getDIVIDEND_PRE() {
		return DIVIDEND_PRE;
	}

	public void setDIVIDEND_PRE(double dIVIDEND_PRE) {
		DIVIDEND_PRE = dIVIDEND_PRE;
	}

	public double getPER_YOSO_PRE() {
		return PER_YOSO_PRE;
	}

	public void setPER_YOSO_PRE(double pER_YOSO_PRE) {
		PER_YOSO_PRE = pER_YOSO_PRE;
	}

	public double getPBR_REAL_PRE() {
		return PBR_REAL_PRE;
	}

	public void setPBR_REAL_PRE(double pBR_REAL_PRE) {
		PBR_REAL_PRE = pBR_REAL_PRE;
	}

	public double getEPS_YOSO_PRE() {
		return EPS_YOSO_PRE;
	}

	public void setEPS_YOSO_PRE(double ePS_YOSO_PRE) {
		EPS_YOSO_PRE = ePS_YOSO_PRE;
	}

	public double getBPS_REAL_PRE() {
		return BPS_REAL_PRE;
	}

	public void setBPS_REAL_PRE(double bPS_REAL_PRE) {
		BPS_REAL_PRE = bPS_REAL_PRE;
	}

	public String getYEAR_MAX_DAY_YYYYMMDD_PRE() {
		return YEAR_MAX_DAY_YYYYMMDD_PRE;
	}

	public void setYEAR_MAX_DAY_YYYYMMDD_PRE(String yEAR_MAX_DAY_YYYYMMDD_PRE) {
		YEAR_MAX_DAY_YYYYMMDD_PRE = yEAR_MAX_DAY_YYYYMMDD_PRE;
	}

	public double getYEAR_MAX_PRE() {
		return YEAR_MAX_PRE;
	}

	public void setYEAR_MAX_PRE(double yEAR_MAX_PRE) {
		YEAR_MAX_PRE = yEAR_MAX_PRE;
	}

	public String getYEAR_MIN_DAY_YYYYMMDD_PRE() {
		return YEAR_MIN_DAY_YYYYMMDD_PRE;
	}

	public void setYEAR_MIN_DAY_YYYYMMDD_PRE(String yEAR_MIN_DAY_YYYYMMDD_PRE) {
		YEAR_MIN_DAY_YYYYMMDD_PRE = yEAR_MIN_DAY_YYYYMMDD_PRE;
	}

	public double getYEAR_MIN_PRE() {
		return YEAR_MIN_PRE;
	}

	public void setYEAR_MIN_PRE(double yEAR_MIN_PRE) {
		YEAR_MIN_PRE = yEAR_MIN_PRE;
	}


	//-----ここまでINVESTTBL




	//決済金額
	private double kessaiKingaku = 0;
	//保有日数
	private int keepDay = 0;
	//決済日
	private String kessaiDay;

	//今のレコードセット
	private ResultSet RS;

	//true:エントリー、01
	//false:exit     、02
	String nowDay_01;
	String nowDay_02;
	String nowDay_03;
	String nowDay_04;

	//マーケット
	String market;

	double nowOpen_01;
	double nowOpen_02;
	double nowOpen_03;
	double nowOpen_04;
	double nowMAX_01;
	double nowMAX_02;
	double nowMAX_03;
	double nowMAX_04;
	double nowMIN_01;
	double nowMIN_02;
	double nowMIN_03;
	double nowMIN_04;
	double nowCLOSE_01;
	double nowCLOSE_02;
	double nowCLOSE_03;
	double nowCLOSE_04;
	double nowDEKI_01;
	double nowDEKI_02;
	double nowDEKI_03;
	double nowDEKI_04;
	double nowBAYBAY_01;
	double nowBAYBAY_02;
	double nowBAYBAY_03;
	double nowBAYBAY_04;

	//前日比
	double nowCHANGE_PRICE_01;
	double nowCHANGE_PRICE_02;
	double nowCHANGE_PRICE_03;
	double nowCHANGE_PRICE_04;
	//前日比率
	double nowCHANGERATE_01;
	double nowCHANGERATE_02;
	double nowCHANGERATE_03;
	double nowCHANGERATE_04;
	//株価短期間移動平均線
	double nowSHORTIDO_01;
	double nowSHORTIDO_02;
	double nowSHORTIDO_03;
	double nowSHORTIDO_04;
	//株価中期間移動平均線
	double nowMIDDLEIDO_01;
	double nowMIDDLEIDO_02;
	double nowMIDDLEIDO_03;
	double nowMIDDLEIDO_04;
	//株価長期間移動平均線
	double nowLONGIDO_01;
	double nowLONGIDO_02;
	double nowLONGIDO_03;
	double nowLONGIDO_04;
	//株価短期間移動平均線前日比
	double nowSHORTIDO_CHANGERATE_01;
	double nowSHORTIDO_CHANGERATE_02;
	double nowSHORTIDO_CHANGERATE_03;
	double nowSHORTIDO_CHANGERATE_04;
	//株価中期間移動平均線前日比
	double nowMIDDLEIDO_CHANGERATE_01;
	double nowMIDDLEIDO_CHANGERATE_02;
	double nowMIDDLEIDO_CHANGERATE_03;
	double nowMIDDLEIDO_CHANGERATE_04;
	//株価長期間移動平均線前日比
	double nowLONGIDO_CHANGERATE_01;
	double nowLONGIDO_CHANGERATE_02;
	double nowLONGIDO_CHANGERATE_03;
	double nowLONGIDO_CHANGERATE_04;
	//株価短期間移動平均線前日比率
	double nowSHORTIDO_RATIO_01;
	double nowSHORTIDO_RATIO_02;
	double nowSHORTIDO_RATIO_03;
	double nowSHORTIDO_RATIO_04;
	//株価中期間移動平均線前日比率
	double nowMIDDLEIDO_RATIO_01;
	double nowMIDDLEIDO_RATIO_02;
	double nowMIDDLEIDO_RATIO_03;
	double nowMIDDLEIDO_RATIO_04;
	//株価長期間移動平均線前日比率
	double nowLONGIDO_RATIO_01;
	double nowLONGIDO_RATIO_02;
	double nowLONGIDO_RATIO_03;
	double nowLONGIDO_RATIO_04;
	//当日の最高値-最安値
	double nowMAXMIN_01;
	double nowMAXMIN_02;
	double nowMAXMIN_03;
	double nowMAXMIN_04;
	//（最高値-最安値)/1
	double nowMAXMINRATIO_01;
	double nowMAXMINRATIO_02;
	double nowMAXMINRATIO_03;
	double nowMAXMINRATIO_04;
	//ローソク足の面積
	double nowCANDLE_AREA_01;
	double nowCANDLE_AREA_02;
	double nowCANDLE_AREA_03;
	double nowCANDLE_AREA_04;
	//ひげの長さと比較したローソク足面積の比率
	double nowCANDLE_AREA_SCALE_01;
	double nowCANDLE_AREA_SCALE_02;
	double nowCANDLE_AREA_SCALE_03;
	double nowCANDLE_AREA_SCALE_04;
	//前日の終値-今日の始値
	double nowWINDOW_01;
	double nowWINDOW_02;
	double nowWINDOW_03;
	double nowWINDOW_04;
	//出来高前日比
	double nowDEKI_CHANGERATE_01;
	double nowDEKI_CHANGERATE_02;
	double nowDEKI_CHANGERATE_03;
	double nowDEKI_CHANGERATE_04;
	//出来高前日比率
	double nowDEKI_RATIO_01;
	double nowDEKI_RATIO_02;
	double nowDEKI_RATIO_03;
	double nowDEKI_RATIO_04;
	//売買代金前日比
	double nowBAYBAY_CHANGERATE_01;
	double nowBAYBAY_CHANGERATE_02;
	double nowBAYBAY_CHANGERATE_03;
	double nowBAYBAY_CHANGERATE_04;
	//売買代金前日比率
	double nowBAYBAY_RATIO_01;
	double nowBAYBAY_RATIO_02;
	double nowBAYBAY_RATIO_03;
	double nowBAYBAY_RATIO_04;
	//出来高短期移動平均線
	double nowSHORTIDO_DEKI_01;
	double nowSHORTIDO_DEKI_02;
	double nowSHORTIDO_DEKI_03;
	double nowSHORTIDO_DEKI_04;
	//出来高中期移動平均線
	double nowMIDDLEIDO_DEKI_01;
	double nowMIDDLEIDO_DEKI_02;
	double nowMIDDLEIDO_DEKI_03;
	double nowMIDDLEIDO_DEKI_04;
	//出来高長期移動平均線
	double nowLONGIDO_DEKI_01;
	double nowLONGIDO_DEKI_02;
	double nowLONGIDO_DEKI_03;
	double nowLONGIDO_DEKI_04;
	//出来高短期間移動平均線前日比
	double nowSHORTIDO_DEKI_CHANGERATE_01;
	double nowSHORTIDO_DEKI_CHANGERATE_02;
	double nowSHORTIDO_DEKI_CHANGERATE_03;
	double nowSHORTIDO_DEKI_CHANGERATE_04;
	//出来高中期移動平均線前日比
	double nowMIDDLEIDO_DEKI_CHANGERATE_01;
	double nowMIDDLEIDO_DEKI_CHANGERATE_02;
	double nowMIDDLEIDO_DEKI_CHANGERATE_03;
	double nowMIDDLEIDO_DEKI_CHANGERATE_04;
	//出来高長期移動平均線前日比_0;
	double nowLONGIDO_DEKI_CHANGERATE_01;
	double nowLONGIDO_DEKI_CHANGERATE_02;
	double nowLONGIDO_DEKI_CHANGERATE_03;
	double nowLONGIDO_DEKI_CHANGERATE_04;
	//出来高短期間移動平均線前日比率
	double nowSHORTIDO_DEKI_RATIO_01;
	double nowSHORTIDO_DEKI_RATIO_02;
	double nowSHORTIDO_DEKI_RATIO_03;
	double nowSHORTIDO_DEKI_RATIO_04;
	//出来高中期移動平均線前日比率
	double nowMIDDLEIDO_DEKI_RATIO_01;
	double nowMIDDLEIDO_DEKI_RATIO_02;
	double nowMIDDLEIDO_DEKI_RATIO_03;
	double nowMIDDLEIDO_DEKI_RATIO_04;
	//出来高長期移動平均線前日比率
	double nowLONGIDO_DEKI_RATIO_01;
	double nowLONGIDO_DEKI_RATIO_02;
	double nowLONGIDO_DEKI_RATIO_03;
	double nowLONGIDO_DEKI_RATIO_04;
	//売買代金短期移動平均線
	double nowSHORTIDO_BAYBAY_01;
	double nowSHORTIDO_BAYBAY_02;
	double nowSHORTIDO_BAYBAY_03;
	double nowSHORTIDO_BAYBAY_04;
	//売買代金中期移動平均線
	double nowMIDDLEIDO_BAYBAY_01;
	double nowMIDDLEIDO_BAYBAY_02;
	double nowMIDDLEIDO_BAYBAY_03;
	double nowMIDDLEIDO_BAYBAY_04;
	//売買代金長期移動平均線
	double nowLONGIDO_BAYBAY_01;
	double nowLONGIDO_BAYBAY_02;
	double nowLONGIDO_BAYBAY_03;
	double nowLONGIDO_BAYBAY_04;
	//売買代金短期間移動平均線前日比
	double nowSHORTIDO_BAYBAY_CHANGERATE_01;
	double nowSHORTIDO_BAYBAY_CHANGERATE_02;
	double nowSHORTIDO_BAYBAY_CHANGERATE_03;
	double nowSHORTIDO_BAYBAY_CHANGERATE_04;
	//売買代金中期間移動平均線前日比
	double nowMIDDLEIDO_BAYBAY_CHANGERATE_01;
	double nowMIDDLEIDO_BAYBAY_CHANGERATE_02;
	double nowMIDDLEIDO_BAYBAY_CHANGERATE_03;
	double nowMIDDLEIDO_BAYBAY_CHANGERATE_04;
	//売買代金長期移動平均線前日比
	double nowLONGIDO_BAYBAY_CHANGERATE_01;
	double nowLONGIDO_BAYBAY_CHANGERATE_02;
	double nowLONGIDO_BAYBAY_CHANGERATE_03;
	double nowLONGIDO_BAYBAY_CHANGERATE_04;
	//売買代金短期間移動平均線前日比率
	double nowSHORTIDO_BAYBAY_RATIO_01;
	double nowSHORTIDO_BAYBAY_RATIO_02;
	double nowSHORTIDO_BAYBAY_RATIO_03;
	double nowSHORTIDO_BAYBAY_RATIO_04;
	//売買代金中期間移動平均線前日比率
	double nowMIDDLEIDO_BAYBAY_RATIO_01;
	double nowMIDDLEIDO_BAYBAY_RATIO_02;
	double nowMIDDLEIDO_BAYBAY_RATIO_03;
	double nowMIDDLEIDO_BAYBAY_RATIO_04;
	//売買代金長期移動平均線前日比率
	double nowLONGIDO_BAYBAY_RATIO_01;
	double nowLONGIDO_BAYBAY_RATIO_02;
	double nowLONGIDO_BAYBAY_RATIO_03;
	double nowLONGIDO_BAYBAY_RATIO_04;
	//信用買い残
	double nowCREDIT_LONG_01;
	double nowCREDIT_LONG_02;
	double nowCREDIT_LONG_03;
	double nowCREDIT_LONG_04;
	//信用売り残
	double nowCREDIT_SHORT_01;
	double nowCREDIT_SHORT_02;
	double nowCREDIT_SHORT_03;
	double nowCREDIT_SHORT_04;
	//信用倍率＝信用買い残÷信用売り残
	double nowCREDIT_RATIO_01;
	double nowCREDIT_RATIO_02;
	double nowCREDIT_RATIO_03;
	double nowCREDIT_RATIO_04;
	//信用買い残前日比
	double nowCREDIT_LONG_CHANGERATE_01;
	double nowCREDIT_LONG_CHANGERATE_02;
	double nowCREDIT_LONG_CHANGERATE_03;
	double nowCREDIT_LONG_CHANGERATE_04;
	//信用売り残前日比
	double nowCREDIT_SHORT_CHANGERATE_01;
	double nowCREDIT_SHORT_CHANGERATE_02;
	double nowCREDIT_SHORT_CHANGERATE_03;
	double nowCREDIT_SHORT_CHANGERATE_04;
	//信用倍率前日比
	double nowCREDIT_RATIO_CHANGERATE_01;
	double nowCREDIT_RATIO_CHANGERATE_02;
	double nowCREDIT_RATIO_CHANGERATE_03;
	double nowCREDIT_RATIO_CHANGERATE_04;
	//短期間の標準偏差（シグマ）
	double nowSHORT_DEV_01;
	double nowSHORT_DEV_02;
	double nowSHORT_DEV_03;
	double nowSHORT_DEV_04;

	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double nowSHORT_NOW_SIGMA_01;
	double nowSHORT_NOW_SIGMA_02;
	double nowSHORT_NOW_SIGMA_03;
	double nowSHORT_NOW_SIGMA_04;
	//短期間でのシグマ１
	double nowSHORT_1_H_SIGMA_01;
	double nowSHORT_1_H_SIGMA_02;
	double nowSHORT_1_H_SIGMA_03;
	double nowSHORT_1_H_SIGMA_04;
	//短期間でのマイナスシグマ１
	double nowSHORT_1_L_SIGMA_01;
	double nowSHORT_1_L_SIGMA_02;
	double nowSHORT_1_L_SIGMA_03;
	double nowSHORT_1_L_SIGMA_04;
	//短期間でのシグマ２
	double nowSHORT_2_H_SIGMA_01;
	double nowSHORT_2_H_SIGMA_02;
	double nowSHORT_2_H_SIGMA_03;
	double nowSHORT_2_H_SIGMA_04;
	//短期間でのマイナスシグマ２
	double nowSHORT_2_L_SIGMA_01;
	double nowSHORT_2_L_SIGMA_02;
	double nowSHORT_2_L_SIGMA_03;
	double nowSHORT_2_L_SIGMA_04;
	//短期間でのシグマ３
	double nowSHORT_3_H_SIGMA_01;
	double nowSHORT_3_H_SIGMA_02;
	double nowSHORT_3_H_SIGMA_03;
	double nowSHORT_3_H_SIGMA_04;
	//短期間でのマイナスシグマ３
	double nowSHORT_3_L_SIGMA_01;
	double nowSHORT_3_L_SIGMA_02;
	double nowSHORT_3_L_SIGMA_03;
	double nowSHORT_3_L_SIGMA_04;
	//中期間の標準偏差（シグマ）
	double nowMIDDLE_DEV_01;
	double nowMIDDLE_DEV_02;
	double nowMIDDLE_DEV_03;
	double nowMIDDLE_DEV_04;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double nowMIDDLE_NOW_SIGMA_01;
	double nowMIDDLE_NOW_SIGMA_02;
	double nowMIDDLE_NOW_SIGMA_03;
	double nowMIDDLE_NOW_SIGMA_04;
	//中期間のシグマ１
	double nowMIDDLE_1_H_SIGMA_01;
	double nowMIDDLE_1_H_SIGMA_02;
	double nowMIDDLE_1_H_SIGMA_03;
	double nowMIDDLE_1_H_SIGMA_04;
	//中期間のマイナスシグマ１
	double nowMIDDLE_1_L_SIGMA_01;
	double nowMIDDLE_1_L_SIGMA_02;
	double nowMIDDLE_1_L_SIGMA_03;
	double nowMIDDLE_1_L_SIGMA_04;
	//中期間のシグマ２
	double nowMIDDLE_2_H_SIGMA_01;
	double nowMIDDLE_2_H_SIGMA_02;
	double nowMIDDLE_2_H_SIGMA_03;
	double nowMIDDLE_2_H_SIGMA_04;
	//中期間のマイナスシグマ２
	double nowMIDDLE_2_L_SIGMA_01;
	double nowMIDDLE_2_L_SIGMA_02;
	double nowMIDDLE_2_L_SIGMA_03;
	double nowMIDDLE_2_L_SIGMA_04;
	//中期間のシグマ３
	double nowMIDDLE_3_H_SIGMA_01;
	double nowMIDDLE_3_H_SIGMA_02;
	double nowMIDDLE_3_H_SIGMA_03;
	double nowMIDDLE_3_H_SIGMA_04;
	//中期間のマイナスシグマ３
	double nowMIDDLE_3_L_SIGMA_01;
	double nowMIDDLE_3_L_SIGMA_02;
	double nowMIDDLE_3_L_SIGMA_03;
	double nowMIDDLE_3_L_SIGMA_04;
	//長期間の標準偏差（シグマ）
	double nowLONG_DEV_01;
	double nowLONG_DEV_02;
	double nowLONG_DEV_03;
	double nowLONG_DEV_04;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double nowLONG_NOW_SIGMA_01;
	double nowLONG_NOW_SIGMA_02;
	double nowLONG_NOW_SIGMA_03;
	double nowLONG_NOW_SIGMA_04;

	//長期間のシグマ１
	double nowLONG_1_H_SIGMA_01;
	double nowLONG_1_H_SIGMA_02;
	double nowLONG_1_H_SIGMA_03;
	double nowLONG_1_H_SIGMA_04;
	//長期間のマイナスシグマ１
	double nowLONG_1_L_SIGMA_01;
	double nowLONG_1_L_SIGMA_02;
	double nowLONG_1_L_SIGMA_03;
	double nowLONG_1_L_SIGMA_04;
	//長期間のシグマ２
	double nowLONG_2_H_SIGMA_01;
	double nowLONG_2_H_SIGMA_02;
	double nowLONG_2_H_SIGMA_03;
	double nowLONG_2_H_SIGMA_04;
	//長期間のマイナスシグマ２
	double nowLONG_2_L_SIGMA_01;
	double nowLONG_2_L_SIGMA_02;
	double nowLONG_2_L_SIGMA_03;
	double nowLONG_2_L_SIGMA_04;
	//長期間のシグマ３
	double nowLONG_3_H_SIGMA_01;
	double nowLONG_3_H_SIGMA_02;
	double nowLONG_3_H_SIGMA_03;
	double nowLONG_3_H_SIGMA_04;
	//長期間のマイナスシグマ３
	double nowLONG_3_L_SIGMA_01;
	double nowLONG_3_L_SIGMA_02;
	double nowLONG_3_L_SIGMA_03;
	double nowLONG_3_L_SIGMA_04;
	//指数平滑移動平均短期
	double nowSHORTIDO_HEKATU_01;
	double nowSHORTIDO_HEKATU_02;
	double nowSHORTIDO_HEKATU_03;
	double nowSHORTIDO_HEKATU_04;
	//指数平滑移動平均中期
	double nowMIDDLEIDO_HEKATU_01;
	double nowMIDDLEIDO_HEKATU_02;
	double nowMIDDLEIDO_HEKATU_03;
	double nowMIDDLEIDO_HEKATU_04;
	//指数平滑移動平均長期
	double nowLONGIDO_HEKATU_01;
	double nowLONGIDO_HEKATU_02;
	double nowLONGIDO_HEKATU_03;
	double nowLONGIDO_HEKATU_04;
	//指数平滑移動平均短期前日比
	double nowSHORTIDO_HEKATU_CHANGERATE_01;
	double nowSHORTIDO_HEKATU_CHANGERATE_02;
	double nowSHORTIDO_HEKATU_CHANGERATE_03;
	double nowSHORTIDO_HEKATU_CHANGERATE_04;
	//指数平滑移動平均中期前日比
	double nowMIDDLEIDO_HEKATU_CHANGERATE_01;
	double nowMIDDLEIDO_HEKATU_CHANGERATE_02;
	double nowMIDDLEIDO_HEKATU_CHANGERATE_03;
	double nowMIDDLEIDO_HEKATU_CHANGERATE_04;
	//指数平滑移動平均長期前日比
	double nowLONGIDO_HEKATU_CHANGERATE_01;
	double nowLONGIDO_HEKATU_CHANGERATE_02;
	double nowLONGIDO_HEKATU_CHANGERATE_03;
	double nowLONGIDO_HEKATU_CHANGERATE_04;
	//指数平滑移動平均短期前日比率
	double nowSHORTIDO_HEKATU_RATIO_01;
	double nowSHORTIDO_HEKATU_RATIO_02;
	double nowSHORTIDO_HEKATU_RATIO_03;
	double nowSHORTIDO_HEKATU_RATIO_04;
	//指数平滑移動平均中期前日比率
	double nowMIDDLEIDO_HEKATU_RATIO_01;
	double nowMIDDLEIDO_HEKATU_RATIO_02;
	double nowMIDDLEIDO_HEKATU_RATIO_03;
	double nowMIDDLEIDO_HEKATU_RATIO_04;
	//指数平滑移動平均長期前日比率
	double nowLONGIDO_HEKATU_RATIO_01;
	double nowLONGIDO_HEKATU_RATIO_02;
	double nowLONGIDO_HEKATU_RATIO_03;
	double nowLONGIDO_HEKATU_RATIO_04;
	//短期MACD
	double nowSHORT_MACD_01;
	double nowSHORT_MACD_02;
	double nowSHORT_MACD_03;
	double nowSHORT_MACD_04;
	//短期MACDシグナル線
	double nowSHORT_MACD_SIGNAL_01;
	double nowSHORT_MACD_SIGNAL_02;
	double nowSHORT_MACD_SIGNAL_03;
	double nowSHORT_MACD_SIGNAL_04;
	//中期MACD
	double nowMIDDLE_MACD_01;
	double nowMIDDLE_MACD_02;
	double nowMIDDLE_MACD_03;
	double nowMIDDLE_MACD_04;
	//中期MACDシグナル線
	double nowMIDDLE_MACD_SIGNAL_01;
	double nowMIDDLE_MACD_SIGNAL_02;
	double nowMIDDLE_MACD_SIGNAL_03;
	double nowMIDDLE_MACD_SIGNAL_04;
	//長期MACD
	double nowLONG_MACD_01;
	double nowLONG_MACD_02;
	double nowLONG_MACD_03;
	double nowLONG_MACD_04;
	//長期MACDシグナル線
	double nowLONG_MACD_SIGNAL_01;
	double nowLONG_MACD_SIGNAL_02;
	double nowLONG_MACD_SIGNAL_03;
	double nowLONG_MACD_SIGNAL_04;
	//全銘柄数
	double nowSTOCK_NAME_NUM_01;
	double nowSTOCK_NAME_NUM_02;
	double nowSTOCK_NAME_NUM_03;
	double nowSTOCK_NAME_NUM_04;
	//比較不可
	double nowSTOCK_NOCOMPARE_01;
	double nowSTOCK_NOCOMPARE_02;
	double nowSTOCK_NOCOMPARE_03;
	double nowSTOCK_NOCOMPARE_04;
	//値下がり
	double nowSTOCK_DOWNSTOCK_01;
	double nowSTOCK_DOWNSTOCK_02;
	double nowSTOCK_DOWNSTOCK_03;
	double nowSTOCK_DOWNSTOCK_04;
	//当日の銘柄数-値付き
	double nowNETUKI_MAXMIN_01;
	double nowNETUKI_MAXMIN_02;
	double nowNETUKI_MAXMIN_03;
	double nowNETUKI_MAXMIN_04;
	//（銘柄数-値付き)/1
	double nowNETUKI_MAXMINRATIO_01;
	double nowNETUKI_MAXMINRATIO_02;
	double nowNETUKI_MAXMINRATIO_03;
	double nowNETUKI_MAXMINRATIO_04;
	//値付き
	double nowSTOCK_GETPRICE_01;
	double nowSTOCK_GETPRICE_02;
	double nowSTOCK_GETPRICE_03;
	double nowSTOCK_GETPRICE_04;
	//値付き前日比
	double nowSTOCK_GETPRICE_CHANGERATE_01;
	double nowSTOCK_GETPRICE_CHANGERATE_02;
	double nowSTOCK_GETPRICE_CHANGERATE_03;
	double nowSTOCK_GETPRICE_CHANGERATE_04;
	//値付き前日比率
	double nowSTOCK_GETPRICE_RATIO_01;
	double nowSTOCK_GETPRICE_RATIO_02;
	double nowSTOCK_GETPRICE_RATIO_03;
	double nowSTOCK_GETPRICE_RATIO_04;
	//値付き短期移動平均線
	double nowSTOCK_GETPRICE_IDO_SHORT_01;
	double nowSTOCK_GETPRICE_IDO_SHORT_02;
	double nowSTOCK_GETPRICE_IDO_SHORT_03;
	double nowSTOCK_GETPRICE_IDO_SHORT_04;
	//値付き中期移動平均線
	double nowSTOCK_GETPRICE_IDO_MIDDLE_01;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_02;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_03;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_04;
	//値付き長期移動平均線
	double nowSTOCK_GETPRICE_IDO_LONG_01;
	double nowSTOCK_GETPRICE_IDO_LONG_02;
	double nowSTOCK_GETPRICE_IDO_LONG_03;
	double nowSTOCK_GETPRICE_IDO_LONG_04;
	//値付き短期間移動平均線前日比
	double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02;
	double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03;
	double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04;
	//値付き中期間移動平均線前日比
	double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04;
	//値付き長期間移動平均線前日比
	double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02;
	double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03;
	double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04;
	//値付き短期間移動平均線前日比率
	double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_01;
	double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_02;
	double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_03;
	double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_04;
	//値付き中期間移動平均線前日比率
	double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03;
	double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04;
	//値付き長期間移動平均線前日比率
	double nowSTOCK_GETPRICE_IDO_LONG_RATIO_01;
	double nowSTOCK_GETPRICE_IDO_LONG_RATIO_02;
	double nowSTOCK_GETPRICE_IDO_LONG_RATIO_03;
	double nowSTOCK_GETPRICE_IDO_LONG_RATIO_04;
	//値上がり
	double nowSTOCK_UPSTOCK_01;
	double nowSTOCK_UPSTOCK_02;
	double nowSTOCK_UPSTOCK_03;
	double nowSTOCK_UPSTOCK_04;
	//値上がり前日比
	double nowSTOCK_UPPRICE_CHANGERATE_01;
	double nowSTOCK_UPPRICE_CHANGERATE_02;
	double nowSTOCK_UPPRICE_CHANGERATE_03;
	double nowSTOCK_UPPRICE_CHANGERATE_04;
	//値上がり前日比率
	double nowSTOCK_UPPRICE_RATIO_01;
	double nowSTOCK_UPPRICE_RATIO_02;
	double nowSTOCK_UPPRICE_RATIO_03;
	double nowSTOCK_UPPRICE_RATIO_04;
	//値上がり短期移動平均線
	double nowSTOCK_UPPRICE_IDO_SHORT_01;
	double nowSTOCK_UPPRICE_IDO_SHORT_02;
	double nowSTOCK_UPPRICE_IDO_SHORT_03;
	double nowSTOCK_UPPRICE_IDO_SHORT_04;
	//値上がり中期移動平均線
	double nowSTOCK_UPPRICE_IDO_MIDDLE_01;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_02;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_03;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_04;
	//値上がり長期移動平均線
	double nowSTOCK_UPPRICE_IDO_LONG_01;
	double nowSTOCK_UPPRICE_IDO_LONG_02;
	double nowSTOCK_UPPRICE_IDO_LONG_03;
	double nowSTOCK_UPPRICE_IDO_LONG_04;
	//値上がり短期間移動平均線前日比
	double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02;
	double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03;
	double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04;
	//値上がり中期間移動平均線前日比
	double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04;
	//値上がり長期間移動平均線前日比
	double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02;
	double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03;
	double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04;
	//値上がり短期間移動平均線前日比率
	double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_01;
	double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_02;
	double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_03;
	double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_04;
	//値上がり中期間移動平均線前日比率
	double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03;
	double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04;
	//値上がり長期間移動平均線前日比率
	double nowSTOCK_UPPRICE_IDO_LONG_RATIO_01;
	double nowSTOCK_UPPRICE_IDO_LONG_RATIO_02;
	double nowSTOCK_UPPRICE_IDO_LONG_RATIO_03;
	double nowSTOCK_UPPRICE_IDO_LONG_RATIO_04;

	//変わらず
	double nowSTOCK_NOCHANGE_01;
	double nowSTOCK_NOCHANGE_02;
	double nowSTOCK_NOCHANGE_03;
	double nowSTOCK_NOCHANGE_04;
	//変わらず前日比
	double nowSTOCK_NOCHANGE_CHANGERATE_01;
	double nowSTOCK_NOCHANGE_CHANGERATE_02;
	double nowSTOCK_NOCHANGE_CHANGERATE_03;
	double nowSTOCK_NOCHANGE_CHANGERATE_04;
	//変わらず前日比率
	double nowSTOCK_NOCHANGE_RATIO_01;
	double nowSTOCK_NOCHANGE_RATIO_02;
	double nowSTOCK_NOCHANGE_RATIO_03;
	double nowSTOCK_NOCHANGE_RATIO_04;
	//変わらず短期移動平均線
	double nowSTOCK_NOCHANGE_IDO_SHORT_01;
	double nowSTOCK_NOCHANGE_IDO_SHORT_02;
	double nowSTOCK_NOCHANGE_IDO_SHORT_03;
	double nowSTOCK_NOCHANGE_IDO_SHORT_04;
	//変わらず中期移動平均線
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_01;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_02;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_03;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_04;
	//変わらず長期移動平均線
	double nowSTOCK_NOCHANGE_IDO_LONG_01;
	double nowSTOCK_NOCHANGE_IDO_LONG_02;
	double nowSTOCK_NOCHANGE_IDO_LONG_03;
	double nowSTOCK_NOCHANGE_IDO_LONG_04;
	//変わらず短期間移動平均線前日比
	double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02;
	double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03;
	double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04;
	//変わらず中期間移動平均線前日比
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04;
	//変わらず長期間移動平均線前日比
	double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02;
	double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03;
	double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04;
	//変わらず短期間移動平均線前日比率
	double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02;
	double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03;
	double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04;
	//変わらず中期間移動平均線前日比率
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03;
	double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04;
	//変わらず長期間移動平均線前日比率
	double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_01;
	double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_02;
	double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_03;
	double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_04;

	//日経平均
	double now_NIKKE_AVEOpen_01;
	double now_NIKKE_AVEMAX_01;
	double now_NIKKE_AVEMIN_01;
	double now_NIKKE_AVECLOSE_01;

	//前日比
	double now_NIKKE_AVECHANGE_PRICE_01;
	//前日比率
	double now_NIKKE_AVECHANGERATE_01;
	//株価短期間移動平均線
	double now_NIKKE_AVESHORTIDO_01;
	//株価中期間移動平均線
	double now_NIKKE_AVEMIDDLEIDO_01;
	//株価長期間移動平均線
	double now_NIKKE_AVELONGIDO_01;
	//株価短期間移動平均線前日比
	double now_NIKKE_AVESHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_NIKKE_AVEMIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_NIKKE_AVELONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_NIKKE_AVESHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_NIKKE_AVEMIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_NIKKE_AVELONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_NIKKE_AVEMAXMIN_01;
	//（最高値-最安値)/1
	double now_NIKKE_AVEMAXMINRATIO_01;
	//ローソク足の面積
	double now_NIKKE_AVECANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_NIKKE_AVECANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_NIKKE_AVEWINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_NIKKE_AVESHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_NIKKE_AVESHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_NIKKE_AVESHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_NIKKE_AVESHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_NIKKE_AVESHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_NIKKE_AVESHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_NIKKE_AVESHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_NIKKE_AVESHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_NIKKE_AVEMIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_NIKKE_AVEMIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_NIKKE_AVEMIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_NIKKE_AVEMIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_NIKKE_AVEMIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_NIKKE_AVEMIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_NIKKE_AVEMIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_NIKKE_AVEMIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_NIKKE_AVELONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_NIKKE_AVELONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_NIKKE_AVELONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_NIKKE_AVELONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_NIKKE_AVELONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_NIKKE_AVELONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_NIKKE_AVELONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_NIKKE_AVELONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_NIKKE_AVESHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_NIKKE_AVEMIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_NIKKE_AVELONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_NIKKE_AVESHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_NIKKE_AVELONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_NIKKE_AVESHORT_MACD_01;
	//短期MACDシグナル線
	double now_NIKKE_AVESHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_NIKKE_AVEMIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_NIKKE_AVEMIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_NIKKE_AVELONG_MACD_01;
	//長期MACDシグナル線
	double now_NIKKE_AVELONG_MACD_SIGNAL_01;

	//TOPIX
	double now_TOPIX_Open_01;
	double now_TOPIX_MAX_01;
	double now_TOPIX_MIN_01;
	double now_TOPIX_CLOSE_01;

	//前日比
	double now_TOPIX_CHANGE_PRICE_01;
	//前日比率
	double now_TOPIX_CHANGERATE_01;
	//株価短期間移動平均線
	double now_TOPIX_SHORTIDO_01;
	//株価中期間移動平均線
	double now_TOPIX_MIDDLEIDO_01;
	//株価長期間移動平均線
	double now_TOPIX_LONGIDO_01;
	//株価短期間移動平均線前日比
	double now_TOPIX_SHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_TOPIX_MIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_TOPIX_LONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_TOPIX_SHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_TOPIX_MIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_TOPIX_LONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_TOPIX_MAXMIN_01;
	//（最高値-最安値)/1
	double now_TOPIX_MAXMINRATIO_01;
	//ローソク足の面積
	double now_TOPIX_CANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_TOPIX_CANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_TOPIX_WINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_TOPIX_SHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_SHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_TOPIX_SHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_TOPIX_SHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_TOPIX_SHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_TOPIX_SHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_TOPIX_SHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_TOPIX_SHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_TOPIX_MIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_MIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_TOPIX_MIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_TOPIX_MIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_TOPIX_MIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_TOPIX_MIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_TOPIX_MIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_TOPIX_MIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_TOPIX_LONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_LONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_TOPIX_LONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_TOPIX_LONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_TOPIX_LONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_TOPIX_LONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_TOPIX_LONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_TOPIX_LONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_TOPIX_SHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_TOPIX_MIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_TOPIX_LONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_TOPIX_LONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_TOPIX_SHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_TOPIX_MIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_TOPIX_LONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_TOPIX_SHORT_MACD_01;
	//短期MACDシグナル線
	double now_TOPIX_SHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_TOPIX_MIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_TOPIX_MIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_TOPIX_LONG_MACD_01;
	//長期MACDシグナル線
	double now_TOPIX_LONG_MACD_SIGNAL_01;

	//core30
	double now_CORE30_Open_01;
	double now_CORE30_MAX_01;
	double now_CORE30_MIN_01;
	double now_CORE30_CLOSE_01;

	//前日比
	double now_CORE30_CHANGE_PRICE_01;
	//前日比率
	double now_CORE30_CHANGERATE_01;
	//株価短期間移動平均線
	double now_CORE30_SHORTIDO_01;
	//株価中期間移動平均線
	double now_CORE30_MIDDLEIDO_01;
	//株価長期間移動平均線
	double now_CORE30_LONGIDO_01;
	//株価短期間移動平均線前日比
	double now_CORE30_SHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_CORE30_MIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_CORE30_LONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_CORE30_SHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_CORE30_MIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_CORE30_LONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_CORE30_MAXMIN_01;
	//（最高値-最安値)/1
	double now_CORE30_MAXMINRATIO_01;
	//ローソク足の面積
	double now_CORE30_CANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_CORE30_CANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_CORE30_WINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_CORE30_SHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_CORE30_SHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_CORE30_SHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_CORE30_SHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_CORE30_SHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_CORE30_SHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_CORE30_SHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_CORE30_SHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_CORE30_MIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_CORE30_MIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_CORE30_MIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_CORE30_MIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_CORE30_MIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_CORE30_MIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_CORE30_MIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_CORE30_MIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_CORE30_LONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_CORE30_LONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_CORE30_LONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_CORE30_LONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_CORE30_LONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_CORE30_LONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_CORE30_LONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_CORE30_LONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_CORE30_SHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_CORE30_MIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_CORE30_LONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_CORE30_SHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_CORE30_LONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_CORE30_SHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_CORE30_MIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_CORE30_LONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_CORE30_SHORT_MACD_01;
	//短期MACDシグナル線
	double now_CORE30_SHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_CORE30_MIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_CORE30_MIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_CORE30_LONG_MACD_01;
	//長期MACDシグナル線
	double now_CORE30_LONG_MACD_SIGNAL_01;

	//TOPIX100
	double now_TOPIX100_Open_01;
	double now_TOPIX100_MAX_01;
	double now_TOPIX100_MIN_01;
	double now_TOPIX100_CLOSE_01;

	//前日比
	double now_TOPIX100_CHANGE_PRICE_01;
	//前日比率
	double now_TOPIX100_CHANGERATE_01;
	//株価短期間移動平均線
	double now_TOPIX100_SHORTIDO_01;
	//株価中期間移動平均線
	double now_TOPIX100_MIDDLEIDO_01;
	//株価長期間移動平均線
	double now_TOPIX100_LONGIDO_01;
	//株価短期間移動平均線前日比
	double now_TOPIX100_SHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_TOPIX100_MIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_TOPIX100_LONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_TOPIX100_SHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_TOPIX100_MIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_TOPIX100_LONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_TOPIX100_MAXMIN_01;
	//（最高値-最安値)/1
	double now_TOPIX100_MAXMINRATIO_01;
	//ローソク足の面積
	double now_TOPIX100_CANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_TOPIX100_CANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_TOPIX100_WINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_TOPIX100_SHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX100_SHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_TOPIX100_SHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_TOPIX100_SHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_TOPIX100_SHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_TOPIX100_SHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_TOPIX100_SHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_TOPIX100_SHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_TOPIX100_MIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX100_MIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_TOPIX100_MIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_TOPIX100_MIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_TOPIX100_MIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_TOPIX100_MIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_TOPIX100_MIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_TOPIX100_MIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_TOPIX100_LONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX100_LONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_TOPIX100_LONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_TOPIX100_LONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_TOPIX100_LONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_TOPIX100_LONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_TOPIX100_LONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_TOPIX100_LONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_TOPIX100_SHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_TOPIX100_MIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_TOPIX100_LONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_TOPIX100_SHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_TOPIX100_LONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_TOPIX100_SHORT_MACD_01;
	//短期MACDシグナル線
	double now_TOPIX100_SHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_TOPIX100_MIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_TOPIX100_MIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_TOPIX100_LONG_MACD_01;
	//長期MACDシグナル線
	double now_TOPIX100_LONG_MACD_SIGNAL_01;

	//TOPIX_SMALL
	double now_TOPIX_SMALL_Open_01;
	double now_TOPIX_SMALL_MAX_01;
	double now_TOPIX_SMALL_MIN_01;
	double now_TOPIX_SMALL_CLOSE_01;

	//前日比
	double now_TOPIX_SMALL_CHANGE_PRICE_01;
	//前日比率
	double now_TOPIX_SMALL_CHANGERATE_01;
	//株価短期間移動平均線
	double now_TOPIX_SMALL_SHORTIDO_01;
	//株価中期間移動平均線
	double now_TOPIX_SMALL_MIDDLEIDO_01;
	//株価長期間移動平均線
	double now_TOPIX_SMALL_LONGIDO_01;
	//株価短期間移動平均線前日比
	double now_TOPIX_SMALL_SHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_TOPIX_SMALL_LONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_TOPIX_SMALL_SHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_TOPIX_SMALL_MIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_TOPIX_SMALL_LONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_TOPIX_SMALL_MAXMIN_01;
	//（最高値-最安値)/1
	double now_TOPIX_SMALL_MAXMINRATIO_01;
	//ローソク足の面積
	double now_TOPIX_SMALL_CANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_TOPIX_SMALL_CANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_TOPIX_SMALL_WINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_TOPIX_SMALL_SHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_SMALL_SHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_TOPIX_SMALL_SHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_TOPIX_SMALL_SHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_TOPIX_SMALL_SHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_TOPIX_SMALL_SHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_TOPIX_SMALL_SHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_TOPIX_SMALL_SHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_TOPIX_SMALL_MIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_TOPIX_SMALL_LONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_TOPIX_SMALL_LONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_TOPIX_SMALL_LONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_TOPIX_SMALL_LONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_TOPIX_SMALL_LONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_TOPIX_SMALL_LONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_TOPIX_SMALL_LONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_TOPIX_SMALL_LONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_TOPIX_SMALL_SHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_TOPIX_SMALL_LONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_TOPIX_SMALL_SHORT_MACD_01;
	//短期MACDシグナル線
	double now_TOPIX_SMALL_SHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_TOPIX_SMALL_MIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_TOPIX_SMALL_LONG_MACD_01;
	//長期MACDシグナル線
	double now_TOPIX_SMALL_LONG_MACD_SIGNAL_01;

	//JASDAC
	double now_JASDAC_Open_01;
	double now_JASDAC_MAX_01;
	double now_JASDAC_MIN_01;
	double now_JASDAC_CLOSE_01;

	//前日比
	double now_JASDAC_CHANGE_PRICE_01;
	//前日比率
	double now_JASDAC_CHANGERATE_01;
	//株価短期間移動平均線
	double now_JASDAC_SHORTIDO_01;
	//株価中期間移動平均線
	double now_JASDAC_MIDDLEIDO_01;
	//株価長期間移動平均線
	double now_JASDAC_LONGIDO_01;
	//株価短期間移動平均線前日比
	double now_JASDAC_SHORTIDO_CHANGERATE_01;
	//株価中期間移動平均線前日比
	double now_JASDAC_MIDDLEIDO_CHANGERATE_01;
	//株価長期間移動平均線前日比
	double now_JASDAC_LONGIDO_CHANGERATE_01;
	//株価短期間移動平均線前日比率
	double now_JASDAC_SHORTIDO_RATIO_01;
	//株価中期間移動平均線前日比率
	double now_JASDAC_MIDDLEIDO_RATIO_01;
	//株価長期間移動平均線前日比率
	double now_JASDAC_LONGIDO_RATIO_01;
	//当日の最高値-最安値
	double now_JASDAC_MAXMIN_01;
	//（最高値-最安値)/1
	double now_JASDAC_MAXMINRATIO_01;
	//ローソク足の面積
	double now_JASDAC_CANDLE_AREA_01;
	//ひげの長さと比較したローソク足面積の比率
	double now_JASDAC_CANDLE_AREA_SCALE_01;
	//前日の終値-今日の始値
	double now_JASDAC_WINDOW_01;
	//短期間の標準偏差（シグマ）
	double now_JASDAC_SHORT_DEV_01;
	//短期間内で今日の終値がシグマと比較して何パーセント上か。
	double now_JASDAC_SHORT_NOW_SIGMA_01;
	//短期間でのシグマ１
	double now_JASDAC_SHORT_1_H_SIGMA_01;
	//短期間でのマイナスシグマ１
	double now_JASDAC_SHORT_1_L_SIGMA_01;
	//短期間でのシグマ２
	double now_JASDAC_SHORT_2_H_SIGMA_01;
	//短期間でのマイナスシグマ２
	double now_JASDAC_SHORT_2_L_SIGMA_01;
	//短期間でのシグマ３
	double now_JASDAC_SHORT_3_H_SIGMA_01;
	//短期間でのマイナスシグマ３
	double now_JASDAC_SHORT_3_L_SIGMA_01;
	//中期間の標準偏差（シグマ）
	double now_JASDAC_MIDDLE_DEV_01;
	//中期間で今日の終値がシグマと比較して何パーセント上か。
	double now_JASDAC_MIDDLE_NOW_SIGMA_01;
	//中期間のシグマ１
	double now_JASDAC_MIDDLE_1_H_SIGMA_01;
	//中期間のマイナスシグマ１
	double now_JASDAC_MIDDLE_1_L_SIGMA_01;
	//中期間のシグマ２
	double now_JASDAC_MIDDLE_2_H_SIGMA_01;
	//中期間のマイナスシグマ２
	double now_JASDAC_MIDDLE_2_L_SIGMA_01;
	//中期間のシグマ３
	double now_JASDAC_MIDDLE_3_H_SIGMA_01;
	//中期間のマイナスシグマ３
	double now_JASDAC_MIDDLE_3_L_SIGMA_01;
	//長期間の標準偏差（シグマ）
	double now_JASDAC_LONG_DEV_01;
	//長期間で今日の終値がシグマと比較して何パーセント上か。
	double now_JASDAC_LONG_NOW_SIGMA_01;
	//長期間のシグマ１
	double now_JASDAC_LONG_1_H_SIGMA_01;
	//長期間のマイナスシグマ１
	double now_JASDAC_LONG_1_L_SIGMA_01;
	//長期間のシグマ２
	double now_JASDAC_LONG_2_H_SIGMA_01;
	//長期間のマイナスシグマ２
	double now_JASDAC_LONG_2_L_SIGMA_01;
	//長期間のシグマ３
	double now_JASDAC_LONG_3_H_SIGMA_01;
	//長期間のマイナスシグマ３
	double now_JASDAC_LONG_3_L_SIGMA_01;
	//指数平滑移動平均短期
	double now_JASDAC_SHORTIDO_HEKATU_01;
	//指数平滑移動平均中期
	double now_JASDAC_MIDDLEIDO_HEKATU_01;
	//指数平滑移動平均長期
	double now_JASDAC_LONGIDO_HEKATU_01;
	//指数平滑移動平均短期前日比
	double now_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均中期前日比
	double now_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均長期前日比
	double now_JASDAC_LONGIDO_HEKATU_CHANGERATE_01;
	//指数平滑移動平均短期前日比率
	double now_JASDAC_SHORTIDO_HEKATU_RATIO_01;
	//指数平滑移動平均中期前日比率
	double now_JASDAC_MIDDLEIDO_HEKATU_RATIO_01;
	//指数平滑移動平均長期前日比率
	double now_JASDAC_LONGIDO_HEKATU_RATIO_01;
	//短期MACD
	double now_JASDAC_SHORT_MACD_01;
	//短期MACDシグナル線
	double now_JASDAC_SHORT_MACD_SIGNAL_01;
	//中期MACD
	double now_JASDAC_MIDDLE_MACD_01;
	//中期MACDシグナル線
	double now_JASDAC_MIDDLE_MACD_SIGNAL_01;
	//長期MACD
	double now_JASDAC_LONG_MACD_01;
	//長期MACDシグナル線
	double now_JASDAC_LONG_MACD_SIGNAL_01;








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
	private String cateflg_01;
	private String cateflg_02;
	private String cateflg_03;
	private String cateflg_04;

	private String code_01;
	private String code_02;
	private String code_03;
	private String code_04;



	double nowSATISTICS_BAYBAY_01;
	double nowSATISTICS_DEKI_01;
	//統計の出来高前日比
	double nowSATISTICS_DEKI_CHANGERATE_01;
	//統計の出来高前日比率
	double nowSATISTICS_DEKI_RATIO_01;
	//統計の売買代金前日比
	double nowSATISTICS_BAYBAY_CHANGERATE_01;
	//統計の売買代金前日比率
	double nowSATISTICS_BAYBAY_RATIO_01;
	//統計の出来高短期移動平均線
	double nowSATISTICS_SHORTIDO_DEKI_01;
	//統計の出来高中期移動平均線
	double nowSATISTICS_MIDDLEIDO_DEKI_01;
	//統計の出来高長期移動平均線
	double nowSATISTICS_LONGIDO_DEKI_01;
	//統計の出来高短期間移動平均線前日比
	double nowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	//統計の出来高中期移動平均線前日比
	double nowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	//統計の出来高長期移動平均線前日比_0;
	double nowSATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	//統計の出来高短期間移動平均線前日比率
	double nowSATISTICS_SHORTIDO_DEKI_RATIO_01;
	//統計の出来高中期移動平均線前日比率
	double nowSATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	//統計の出来高長期移動平均線前日比率
	double nowSATISTICS_LONGIDO_DEKI_RATIO_01;
	//統計の売買代金短期移動平均線
	double nowSATISTICS_SHORTIDO_BAYBAY_01;
	//統計の売買代金中期移動平均線
	double nowSATISTICS_MIDDLEIDO_BAYBAY_01;
	//統計の売買代金長期移動平均線
	double nowSATISTICS_LONGIDO_BAYBAY_01;
	//統計の売買代金短期間移動平均線前日比
	double nowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金中期間移動平均線前日比
	double nowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金長期移動平均線前日比
	double nowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金短期間移動平均線前日比率
	double nowSATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	//統計の売買代金中期間移動平均線前日比率
	double nowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	//統計の売買代金長期移動平均線前日比率
	double nowSATISTICS_LONGIDO_BAYBAY_RATIO_01;

	double nowNIKKE_SATISTICS_BAYBAY_01;
	double nowNIKKE_SATISTICS_DEKI_01;
	//統計の出来高前日比
	double nowNIKKE_SATISTICS_DEKI_CHANGERATE_01;
	//統計の出来高前日比率
	double nowNIKKE_SATISTICS_DEKI_RATIO_01;
	//統計の売買代金前日比
	double nowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01;
	//統計の売買代金前日比率
	double nowNIKKE_SATISTICS_BAYBAY_RATIO_01;
	//統計の出来高短期移動平均線
	double nowNIKKE_SATISTICS_SHORTIDO_DEKI_01;
	//統計の出来高中期移動平均線
	double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01;
	//統計の出来高長期移動平均線
	double nowNIKKE_SATISTICS_LONGIDO_DEKI_01;
	//統計の出来高短期間移動平均線前日比
	double nowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	//統計の出来高中期移動平均線前日比
	double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	//統計の出来高長期移動平均線前日比_0;
	double nowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	//統計の出来高短期間移動平均線前日比率
	double nowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01;
	//統計の出来高中期移動平均線前日比率
	double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	//統計の出来高長期移動平均線前日比率
	double nowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01;
	//統計の売買代金短期移動平均線
	double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01;
	//統計の売買代金中期移動平均線
	double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01;
	//統計の売買代金長期移動平均線
	double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_01;
	//統計の売買代金短期間移動平均線前日比
	double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金中期間移動平均線前日比
	double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金長期移動平均線前日比
	double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	//統計の売買代金短期間移動平均線前日比率
	double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	//統計の売買代金中期間移動平均線前日比率
	double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	//統計の売買代金長期移動平均線前日比率
	double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01;

	//全銘柄数
	double nowNIKKE_SATISTICS_STOCK_NAME_NUM_01;
	//比較不可
	double nowNIKKE_SATISTICS_STOCK_NOCOMPARE_01;
	//値下がり
	double nowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01;
	//当日の銘柄数-値付き
	double nowNIKKE_SATISTICS_NETUKI_MAXMIN_01;
	//（銘柄数-値付き)/1
	double nowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01;
	//値付き
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_01;
	//値付き前日比
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01;
	//値付き前日比率
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01;
	//値付き短期移動平均線
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01;
	//値付き中期移動平均線
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01;
	//値付き長期移動平均線
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01;
	//値付き短期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	//値付き中期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	//値付き長期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	//値付き短期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01;
	//値付き中期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	//値付き長期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01;
	//値上がり
	double nowNIKKE_SATISTICS_STOCK_UPSTOCK_01;
	//値上がり前日比
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01;
	//値上がり前日比率
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01;
	//値上がり短期移動平均線
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01;
	//値上がり中期移動平均線
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01;
	//値上がり長期移動平均線
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01;
	//値上がり短期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	//値上がり中期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	//値上がり長期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	//値上がり短期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01;
	//値上がり中期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	//値上がり長期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01;

	//変わらず
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_01;
	//変わらず前日比
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01;
	//変わらず前日比率
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01;
	//変わらず短期移動平均線
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01;
	//変わらず中期移動平均線
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01;
	//変わらず長期移動平均線
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01;
	//変わらず短期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	//変わらず中期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	//変わらず長期間移動平均線前日比
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	//変わらず短期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	//変わらず中期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	//変わらず長期間移動平均線前日比率
	double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01;


//
//	public ResultSet getNowRS() {
//		return RS;
//	}
//
//	public void setNowRS(ResultSet rS) {
//		RS = rS;
//	}

	public double getNowNIKKE_SATISTICS_BAYBAY_01() {
		return nowNIKKE_SATISTICS_BAYBAY_01;
	}

	public void setNowNIKKE_SATISTICS_BAYBAY_01(double nowNIKKE_SATISTICS_BAYBAY_01) {
		this.nowNIKKE_SATISTICS_BAYBAY_01 = nowNIKKE_SATISTICS_BAYBAY_01;
	}

	public double getNowNIKKE_SATISTICS_DEKI_01() {
		return nowNIKKE_SATISTICS_DEKI_01;
	}

	public void setNowNIKKE_SATISTICS_DEKI_01(double nowNIKKE_SATISTICS_DEKI_01) {
		this.nowNIKKE_SATISTICS_DEKI_01 = nowNIKKE_SATISTICS_DEKI_01;
	}

	public double getNowNIKKE_SATISTICS_DEKI_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_DEKI_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_DEKI_CHANGERATE_01(
			double nowNIKKE_SATISTICS_DEKI_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_DEKI_CHANGERATE_01 = nowNIKKE_SATISTICS_DEKI_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_DEKI_RATIO_01() {
		return nowNIKKE_SATISTICS_DEKI_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_DEKI_RATIO_01(
			double nowNIKKE_SATISTICS_DEKI_RATIO_01) {
		this.nowNIKKE_SATISTICS_DEKI_RATIO_01 = nowNIKKE_SATISTICS_DEKI_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01(
			double nowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01 = nowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_BAYBAY_RATIO_01() {
		return nowNIKKE_SATISTICS_BAYBAY_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_BAYBAY_RATIO_01(
			double nowNIKKE_SATISTICS_BAYBAY_RATIO_01) {
		this.nowNIKKE_SATISTICS_BAYBAY_RATIO_01 = nowNIKKE_SATISTICS_BAYBAY_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_DEKI_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_DEKI_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_DEKI_01(
			double nowNIKKE_SATISTICS_SHORTIDO_DEKI_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_DEKI_01 = nowNIKKE_SATISTICS_SHORTIDO_DEKI_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01 = nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_DEKI_01() {
		return nowNIKKE_SATISTICS_LONGIDO_DEKI_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_DEKI_01(
			double nowNIKKE_SATISTICS_LONGIDO_DEKI_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_DEKI_01 = nowNIKKE_SATISTICS_LONGIDO_DEKI_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01(
			double nowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01 = nowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01 = nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01(
			double nowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01 = nowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01(
			double nowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01 = nowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01 = nowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01() {
		return nowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01(
			double nowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01 = nowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01(
			double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01 = nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01 = nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_BAYBAY_01() {
		return nowNIKKE_SATISTICS_LONGIDO_BAYBAY_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_01(
			double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_BAYBAY_01 = nowNIKKE_SATISTICS_LONGIDO_BAYBAY_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(
			double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01 = nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01 = nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(
			double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01 = nowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01() {
		return nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01(
			double nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01) {
		this.nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01 = nowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01() {
		return nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(
			double nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01) {
		this.nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01 = nowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01() {
		return nowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01(
			double nowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01) {
		this.nowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01 = nowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NAME_NUM_01() {
		return nowNIKKE_SATISTICS_STOCK_NAME_NUM_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NAME_NUM_01(
			double nowNIKKE_SATISTICS_STOCK_NAME_NUM_01) {
		this.nowNIKKE_SATISTICS_STOCK_NAME_NUM_01 = nowNIKKE_SATISTICS_STOCK_NAME_NUM_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCOMPARE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCOMPARE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCOMPARE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCOMPARE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCOMPARE_01 = nowNIKKE_SATISTICS_STOCK_NOCOMPARE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01() {
		return nowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01(
			double nowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01) {
		this.nowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01 = nowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01;
	}

	public double getNowNIKKE_SATISTICS_NETUKI_MAXMIN_01() {
		return nowNIKKE_SATISTICS_NETUKI_MAXMIN_01;
	}

	public void setNowNIKKE_SATISTICS_NETUKI_MAXMIN_01(
			double nowNIKKE_SATISTICS_NETUKI_MAXMIN_01) {
		this.nowNIKKE_SATISTICS_NETUKI_MAXMIN_01 = nowNIKKE_SATISTICS_NETUKI_MAXMIN_01;
	}

	public double getNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01() {
		return nowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01;
	}

	public void setNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01(
			double nowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01) {
		this.nowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01 = nowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01 = nowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPSTOCK_01() {
		return nowNIKKE_SATISTICS_STOCK_UPSTOCK_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPSTOCK_01(
			double nowNIKKE_SATISTICS_STOCK_UPSTOCK_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPSTOCK_01 = nowNIKKE_SATISTICS_STOCK_UPSTOCK_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01 = nowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01() {
		return nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01;
	}

	public void setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01(
			double nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01) {
		this.nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01 = nowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public double getNowSATISTICS_BAYBAY_01() {
		return nowSATISTICS_BAYBAY_01;
	}

	public void setNowSATISTICS_BAYBAY_01(double nowSATISTICS_BAYBAY_01) {
		this.nowSATISTICS_BAYBAY_01 = nowSATISTICS_BAYBAY_01;
	}

	public double getNowSATISTICS_DEKI_01() {
		return nowSATISTICS_DEKI_01;
	}

	public void setNowSATISTICS_DEKI_01(double nowSATISTICS_DEKI_01) {
		this.nowSATISTICS_DEKI_01 = nowSATISTICS_DEKI_01;
	}

	public double getNowSATISTICS_DEKI_CHANGERATE_01() {
		return nowSATISTICS_DEKI_CHANGERATE_01;
	}

	public void setNowSATISTICS_DEKI_CHANGERATE_01(
			double nowSATISTICS_DEKI_CHANGERATE_01) {
		this.nowSATISTICS_DEKI_CHANGERATE_01 = nowSATISTICS_DEKI_CHANGERATE_01;
	}

	public double getNowSATISTICS_DEKI_RATIO_01() {
		return nowSATISTICS_DEKI_RATIO_01;
	}

	public void setNowSATISTICS_DEKI_RATIO_01(double nowSATISTICS_DEKI_RATIO_01) {
		this.nowSATISTICS_DEKI_RATIO_01 = nowSATISTICS_DEKI_RATIO_01;
	}

	public double getNowSATISTICS_BAYBAY_CHANGERATE_01() {
		return nowSATISTICS_BAYBAY_CHANGERATE_01;
	}

	public void setNowSATISTICS_BAYBAY_CHANGERATE_01(
			double nowSATISTICS_BAYBAY_CHANGERATE_01) {
		this.nowSATISTICS_BAYBAY_CHANGERATE_01 = nowSATISTICS_BAYBAY_CHANGERATE_01;
	}

	public double getNowSATISTICS_BAYBAY_RATIO_01() {
		return nowSATISTICS_BAYBAY_RATIO_01;
	}

	public void setNowSATISTICS_BAYBAY_RATIO_01(double nowSATISTICS_BAYBAY_RATIO_01) {
		this.nowSATISTICS_BAYBAY_RATIO_01 = nowSATISTICS_BAYBAY_RATIO_01;
	}

	public double getNowSATISTICS_SHORTIDO_DEKI_01() {
		return nowSATISTICS_SHORTIDO_DEKI_01;
	}

	public void setNowSATISTICS_SHORTIDO_DEKI_01(
			double nowSATISTICS_SHORTIDO_DEKI_01) {
		this.nowSATISTICS_SHORTIDO_DEKI_01 = nowSATISTICS_SHORTIDO_DEKI_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_DEKI_01() {
		return nowSATISTICS_MIDDLEIDO_DEKI_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_DEKI_01(
			double nowSATISTICS_MIDDLEIDO_DEKI_01) {
		this.nowSATISTICS_MIDDLEIDO_DEKI_01 = nowSATISTICS_MIDDLEIDO_DEKI_01;
	}

	public double getNowSATISTICS_LONGIDO_DEKI_01() {
		return nowSATISTICS_LONGIDO_DEKI_01;
	}

	public void setNowSATISTICS_LONGIDO_DEKI_01(double nowSATISTICS_LONGIDO_DEKI_01) {
		this.nowSATISTICS_LONGIDO_DEKI_01 = nowSATISTICS_LONGIDO_DEKI_01;
	}

	public double getNowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01() {
		return nowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	}

	public void setNowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01(
			double nowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01) {
		this.nowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01 = nowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01() {
		return nowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01(
			double nowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01) {
		this.nowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01 = nowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public double getNowSATISTICS_LONGIDO_DEKI_CHANGERATE_01() {
		return nowSATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	}

	public void setNowSATISTICS_LONGIDO_DEKI_CHANGERATE_01(
			double nowSATISTICS_LONGIDO_DEKI_CHANGERATE_01) {
		this.nowSATISTICS_LONGIDO_DEKI_CHANGERATE_01 = nowSATISTICS_LONGIDO_DEKI_CHANGERATE_01;
	}

	public double getNowSATISTICS_SHORTIDO_DEKI_RATIO_01() {
		return nowSATISTICS_SHORTIDO_DEKI_RATIO_01;
	}

	public void setNowSATISTICS_SHORTIDO_DEKI_RATIO_01(
			double nowSATISTICS_SHORTIDO_DEKI_RATIO_01) {
		this.nowSATISTICS_SHORTIDO_DEKI_RATIO_01 = nowSATISTICS_SHORTIDO_DEKI_RATIO_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_DEKI_RATIO_01() {
		return nowSATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_DEKI_RATIO_01(
			double nowSATISTICS_MIDDLEIDO_DEKI_RATIO_01) {
		this.nowSATISTICS_MIDDLEIDO_DEKI_RATIO_01 = nowSATISTICS_MIDDLEIDO_DEKI_RATIO_01;
	}

	public double getNowSATISTICS_LONGIDO_DEKI_RATIO_01() {
		return nowSATISTICS_LONGIDO_DEKI_RATIO_01;
	}

	public void setNowSATISTICS_LONGIDO_DEKI_RATIO_01(
			double nowSATISTICS_LONGIDO_DEKI_RATIO_01) {
		this.nowSATISTICS_LONGIDO_DEKI_RATIO_01 = nowSATISTICS_LONGIDO_DEKI_RATIO_01;
	}

	public double getNowSATISTICS_SHORTIDO_BAYBAY_01() {
		return nowSATISTICS_SHORTIDO_BAYBAY_01;
	}

	public void setNowSATISTICS_SHORTIDO_BAYBAY_01(
			double nowSATISTICS_SHORTIDO_BAYBAY_01) {
		this.nowSATISTICS_SHORTIDO_BAYBAY_01 = nowSATISTICS_SHORTIDO_BAYBAY_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_BAYBAY_01() {
		return nowSATISTICS_MIDDLEIDO_BAYBAY_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_BAYBAY_01(
			double nowSATISTICS_MIDDLEIDO_BAYBAY_01) {
		this.nowSATISTICS_MIDDLEIDO_BAYBAY_01 = nowSATISTICS_MIDDLEIDO_BAYBAY_01;
	}

	public double getNowSATISTICS_LONGIDO_BAYBAY_01() {
		return nowSATISTICS_LONGIDO_BAYBAY_01;
	}

	public void setNowSATISTICS_LONGIDO_BAYBAY_01(
			double nowSATISTICS_LONGIDO_BAYBAY_01) {
		this.nowSATISTICS_LONGIDO_BAYBAY_01 = nowSATISTICS_LONGIDO_BAYBAY_01;
	}

	public double getNowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01() {
		return nowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(
			double nowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01) {
		this.nowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01 = nowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01() {
		return nowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(
			double nowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01) {
		this.nowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01 = nowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01() {
		return nowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(
			double nowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01) {
		this.nowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01 = nowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowSATISTICS_SHORTIDO_BAYBAY_RATIO_01() {
		return nowSATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	}

	public void setNowSATISTICS_SHORTIDO_BAYBAY_RATIO_01(
			double nowSATISTICS_SHORTIDO_BAYBAY_RATIO_01) {
		this.nowSATISTICS_SHORTIDO_BAYBAY_RATIO_01 = nowSATISTICS_SHORTIDO_BAYBAY_RATIO_01;
	}

	public double getNowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01() {
		return nowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	}

	public void setNowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(
			double nowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01) {
		this.nowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01 = nowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01;
	}

	public double getNowSATISTICS_LONGIDO_BAYBAY_RATIO_01() {
		return nowSATISTICS_LONGIDO_BAYBAY_RATIO_01;
	}

	public void setNowSATISTICS_LONGIDO_BAYBAY_RATIO_01(
			double nowSATISTICS_LONGIDO_BAYBAY_RATIO_01) {
		this.nowSATISTICS_LONGIDO_BAYBAY_RATIO_01 = nowSATISTICS_LONGIDO_BAYBAY_RATIO_01;
	}

	public double getKessaiKingaku() {
		return kessaiKingaku;
	}

	public void setKessaiKingaku(double kessaiKingaku) {
		this.kessaiKingaku = kessaiKingaku;
	}

	public int getKeepDay() {
		return keepDay;
	}

	public void setKeepDay(int keepDay) {
		this.keepDay = keepDay;
	}

	public void reSetKeepDay() {
		this.keepDay = 0;
	}

	public String getKessaiDay() {
		return kessaiDay;
	}

	public void setKessaiDay(String kessaiDay) {
		this.kessaiDay = kessaiDay;
	}

	public double getNowCHANGE_PRICE_01() {
		return nowCHANGE_PRICE_01;
	}

	public void setNowCHANGE_PRICE_01(double nowCHANGE_PRICE_01) {
		this.nowCHANGE_PRICE_01 = nowCHANGE_PRICE_01;
	}

	public double getNowCHANGE_PRICE_02() {
		return nowCHANGE_PRICE_02;
	}

	public void setNowCHANGE_PRICE_02(double nowCHANGE_PRICE_02) {
		this.nowCHANGE_PRICE_02 = nowCHANGE_PRICE_02;
	}

	public double getNowCHANGE_PRICE_03() {
		return nowCHANGE_PRICE_03;
	}

	public void setNowCHANGE_PRICE_03(double nowCHANGE_PRICE_03) {
		this.nowCHANGE_PRICE_03 = nowCHANGE_PRICE_03;
	}

	public double getNowCHANGE_PRICE_04() {
		return nowCHANGE_PRICE_04;
	}

	public void setNowCHANGE_PRICE_04(double nowCHANGE_PRICE_04) {
		this.nowCHANGE_PRICE_04 = nowCHANGE_PRICE_04;
	}

	public double getNowCHANGERATE_01() {
		return nowCHANGERATE_01;
	}

	public void setNowCHANGERATE_01(double nowCHANGERATE_01) {
		this.nowCHANGERATE_01 = nowCHANGERATE_01;
	}

	public double getNowCHANGERATE_02() {
		return nowCHANGERATE_02;
	}

	public void setNowCHANGERATE_02(double nowCHANGERATE_02) {
		this.nowCHANGERATE_02 = nowCHANGERATE_02;
	}

	public double getNowCHANGERATE_03() {
		return nowCHANGERATE_03;
	}

	public void setNowCHANGERATE_03(double nowCHANGERATE_03) {
		this.nowCHANGERATE_03 = nowCHANGERATE_03;
	}

	public double getNowCHANGERATE_04() {
		return nowCHANGERATE_04;
	}

	public void setNowCHANGERATE_04(double nowCHANGERATE_04) {
		this.nowCHANGERATE_04 = nowCHANGERATE_04;
	}

	public double getNowSHORTIDO_01() {
		return nowSHORTIDO_01;
	}

	public void setNowSHORTIDO_01(double nowSHORTIDO_01) {
		this.nowSHORTIDO_01 = nowSHORTIDO_01;
	}

	public double getNowSHORTIDO_02() {
		return nowSHORTIDO_02;
	}

	public void setNowSHORTIDO_02(double nowSHORTIDO_02) {
		this.nowSHORTIDO_02 = nowSHORTIDO_02;
	}

	public double getNowSHORTIDO_03() {
		return nowSHORTIDO_03;
	}

	public void setNowSHORTIDO_03(double nowSHORTIDO_03) {
		this.nowSHORTIDO_03 = nowSHORTIDO_03;
	}

	public double getNowSHORTIDO_04() {
		return nowSHORTIDO_04;
	}

	public void setNowSHORTIDO_04(double nowSHORTIDO_04) {
		this.nowSHORTIDO_04 = nowSHORTIDO_04;
	}

	public double getNowMIDDLEIDO_01() {
		return nowMIDDLEIDO_01;
	}

	public void setNowMIDDLEIDO_01(double nowMIDDLEIDO_01) {
		this.nowMIDDLEIDO_01 = nowMIDDLEIDO_01;
	}

	public double getNowMIDDLEIDO_02() {
		return nowMIDDLEIDO_02;
	}

	public void setNowMIDDLEIDO_02(double nowMIDDLEIDO_02) {
		this.nowMIDDLEIDO_02 = nowMIDDLEIDO_02;
	}

	public double getNowMIDDLEIDO_03() {
		return nowMIDDLEIDO_03;
	}

	public void setNowMIDDLEIDO_03(double nowMIDDLEIDO_03) {
		this.nowMIDDLEIDO_03 = nowMIDDLEIDO_03;
	}

	public double getNowMIDDLEIDO_04() {
		return nowMIDDLEIDO_04;
	}

	public void setNowMIDDLEIDO_04(double nowMIDDLEIDO_04) {
		this.nowMIDDLEIDO_04 = nowMIDDLEIDO_04;
	}

	public double getNowLONGIDO_01() {
		return nowLONGIDO_01;
	}

	public void setNowLONGIDO_01(double nowLONGIDO_01) {
		this.nowLONGIDO_01 = nowLONGIDO_01;
	}

	public double getNowLONGIDO_02() {
		return nowLONGIDO_02;
	}

	public void setNowLONGIDO_02(double nowLONGIDO_02) {
		this.nowLONGIDO_02 = nowLONGIDO_02;
	}

	public double getNowLONGIDO_03() {
		return nowLONGIDO_03;
	}

	public void setNowLONGIDO_03(double nowLONGIDO_03) {
		this.nowLONGIDO_03 = nowLONGIDO_03;
	}

	public double getNowLONGIDO_04() {
		return nowLONGIDO_04;
	}

	public void setNowLONGIDO_04(double nowLONGIDO_04) {
		this.nowLONGIDO_04 = nowLONGIDO_04;
	}

	public double getNowSHORTIDO_CHANGERATE_01() {
		return nowSHORTIDO_CHANGERATE_01;
	}

	public void setNowSHORTIDO_CHANGERATE_01(double nowSHORTIDO_CHANGERATE_01) {
		this.nowSHORTIDO_CHANGERATE_01 = nowSHORTIDO_CHANGERATE_01;
	}

	public double getNowSHORTIDO_CHANGERATE_02() {
		return nowSHORTIDO_CHANGERATE_02;
	}

	public void setNowSHORTIDO_CHANGERATE_02(double nowSHORTIDO_CHANGERATE_02) {
		this.nowSHORTIDO_CHANGERATE_02 = nowSHORTIDO_CHANGERATE_02;
	}

	public double getNowSHORTIDO_CHANGERATE_03() {
		return nowSHORTIDO_CHANGERATE_03;
	}

	public void setNowSHORTIDO_CHANGERATE_03(double nowSHORTIDO_CHANGERATE_03) {
		this.nowSHORTIDO_CHANGERATE_03 = nowSHORTIDO_CHANGERATE_03;
	}

	public double getNowSHORTIDO_CHANGERATE_04() {
		return nowSHORTIDO_CHANGERATE_04;
	}

	public void setNowSHORTIDO_CHANGERATE_04(double nowSHORTIDO_CHANGERATE_04) {
		this.nowSHORTIDO_CHANGERATE_04 = nowSHORTIDO_CHANGERATE_04;
	}

	public double getNowMIDDLEIDO_CHANGERATE_01() {
		return nowMIDDLEIDO_CHANGERATE_01;
	}

	public void setNowMIDDLEIDO_CHANGERATE_01(double nowMIDDLEIDO_CHANGERATE_01) {
		this.nowMIDDLEIDO_CHANGERATE_01 = nowMIDDLEIDO_CHANGERATE_01;
	}

	public double getNowMIDDLEIDO_CHANGERATE_02() {
		return nowMIDDLEIDO_CHANGERATE_02;
	}

	public void setNowMIDDLEIDO_CHANGERATE_02(double nowMIDDLEIDO_CHANGERATE_02) {
		this.nowMIDDLEIDO_CHANGERATE_02 = nowMIDDLEIDO_CHANGERATE_02;
	}

	public double getNowMIDDLEIDO_CHANGERATE_03() {
		return nowMIDDLEIDO_CHANGERATE_03;
	}

	public void setNowMIDDLEIDO_CHANGERATE_03(double nowMIDDLEIDO_CHANGERATE_03) {
		this.nowMIDDLEIDO_CHANGERATE_03 = nowMIDDLEIDO_CHANGERATE_03;
	}

	public double getNowMIDDLEIDO_CHANGERATE_04() {
		return nowMIDDLEIDO_CHANGERATE_04;
	}

	public void setNowMIDDLEIDO_CHANGERATE_04(double nowMIDDLEIDO_CHANGERATE_04) {
		this.nowMIDDLEIDO_CHANGERATE_04 = nowMIDDLEIDO_CHANGERATE_04;
	}

	public double getNowLONGIDO_CHANGERATE_01() {
		return nowLONGIDO_CHANGERATE_01;
	}

	public void setNowLONGIDO_CHANGERATE_01(double nowLONGIDO_CHANGERATE_01) {
		this.nowLONGIDO_CHANGERATE_01 = nowLONGIDO_CHANGERATE_01;
	}

	public double getNowLONGIDO_CHANGERATE_02() {
		return nowLONGIDO_CHANGERATE_02;
	}

	public void setNowLONGIDO_CHANGERATE_02(double nowLONGIDO_CHANGERATE_02) {
		this.nowLONGIDO_CHANGERATE_02 = nowLONGIDO_CHANGERATE_02;
	}

	public double getNowLONGIDO_CHANGERATE_03() {
		return nowLONGIDO_CHANGERATE_03;
	}

	public void setNowLONGIDO_CHANGERATE_03(double nowLONGIDO_CHANGERATE_03) {
		this.nowLONGIDO_CHANGERATE_03 = nowLONGIDO_CHANGERATE_03;
	}

	public double getNowLONGIDO_CHANGERATE_04() {
		return nowLONGIDO_CHANGERATE_04;
	}

	public void setNowLONGIDO_CHANGERATE_04(double nowLONGIDO_CHANGERATE_04) {
		this.nowLONGIDO_CHANGERATE_04 = nowLONGIDO_CHANGERATE_04;
	}

	public double getNowSHORTIDO_RATIO_01() {
		return nowSHORTIDO_RATIO_01;
	}

	public void setNowSHORTIDO_RATIO_01(double nowSHORTIDO_RATIO_01) {
		this.nowSHORTIDO_RATIO_01 = nowSHORTIDO_RATIO_01;
	}

	public double getNowSHORTIDO_RATIO_02() {
		return nowSHORTIDO_RATIO_02;
	}

	public void setNowSHORTIDO_RATIO_02(double nowSHORTIDO_RATIO_02) {
		this.nowSHORTIDO_RATIO_02 = nowSHORTIDO_RATIO_02;
	}

	public double getNowSHORTIDO_RATIO_03() {
		return nowSHORTIDO_RATIO_03;
	}

	public void setNowSHORTIDO_RATIO_03(double nowSHORTIDO_RATIO_03) {
		this.nowSHORTIDO_RATIO_03 = nowSHORTIDO_RATIO_03;
	}

	public double getNowSHORTIDO_RATIO_04() {
		return nowSHORTIDO_RATIO_04;
	}

	public void setNowSHORTIDO_RATIO_04(double nowSHORTIDO_RATIO_04) {
		this.nowSHORTIDO_RATIO_04 = nowSHORTIDO_RATIO_04;
	}

	public double getNowMIDDLEIDO_RATIO_01() {
		return nowMIDDLEIDO_RATIO_01;
	}

	public void setNowMIDDLEIDO_RATIO_01(double nowMIDDLEIDO_RATIO_01) {
		this.nowMIDDLEIDO_RATIO_01 = nowMIDDLEIDO_RATIO_01;
	}

	public double getNowMIDDLEIDO_RATIO_02() {
		return nowMIDDLEIDO_RATIO_02;
	}

	public void setNowMIDDLEIDO_RATIO_02(double nowMIDDLEIDO_RATIO_02) {
		this.nowMIDDLEIDO_RATIO_02 = nowMIDDLEIDO_RATIO_02;
	}

	public double getNowMIDDLEIDO_RATIO_03() {
		return nowMIDDLEIDO_RATIO_03;
	}

	public void setNowMIDDLEIDO_RATIO_03(double nowMIDDLEIDO_RATIO_03) {
		this.nowMIDDLEIDO_RATIO_03 = nowMIDDLEIDO_RATIO_03;
	}

	public double getNowMIDDLEIDO_RATIO_04() {
		return nowMIDDLEIDO_RATIO_04;
	}

	public void setNowMIDDLEIDO_RATIO_04(double nowMIDDLEIDO_RATIO_04) {
		this.nowMIDDLEIDO_RATIO_04 = nowMIDDLEIDO_RATIO_04;
	}

	public double getNowLONGIDO_RATIO_01() {
		return nowLONGIDO_RATIO_01;
	}

	public void setNowLONGIDO_RATIO_01(double nowLONGIDO_RATIO_01) {
		this.nowLONGIDO_RATIO_01 = nowLONGIDO_RATIO_01;
	}

	public double getNowLONGIDO_RATIO_02() {
		return nowLONGIDO_RATIO_02;
	}

	public void setNowLONGIDO_RATIO_02(double nowLONGIDO_RATIO_02) {
		this.nowLONGIDO_RATIO_02 = nowLONGIDO_RATIO_02;
	}

	public double getNowLONGIDO_RATIO_03() {
		return nowLONGIDO_RATIO_03;
	}

	public void setNowLONGIDO_RATIO_03(double nowLONGIDO_RATIO_03) {
		this.nowLONGIDO_RATIO_03 = nowLONGIDO_RATIO_03;
	}

	public double getNowLONGIDO_RATIO_04() {
		return nowLONGIDO_RATIO_04;
	}

	public void setNowLONGIDO_RATIO_04(double nowLONGIDO_RATIO_04) {
		this.nowLONGIDO_RATIO_04 = nowLONGIDO_RATIO_04;
	}

	public double getNowMAXMIN_01() {
		return nowMAXMIN_01;
	}

	public void setNowMAXMIN_01(double nowMAXMIN_01) {
		this.nowMAXMIN_01 = nowMAXMIN_01;
	}

	public double getNowMAXMIN_02() {
		return nowMAXMIN_02;
	}

	public void setNowMAXMIN_02(double nowMAXMIN_02) {
		this.nowMAXMIN_02 = nowMAXMIN_02;
	}

	public double getNowMAXMIN_03() {
		return nowMAXMIN_03;
	}

	public void setNowMAXMIN_03(double nowMAXMIN_03) {
		this.nowMAXMIN_03 = nowMAXMIN_03;
	}

	public double getNowMAXMIN_04() {
		return nowMAXMIN_04;
	}

	public void setNowMAXMIN_04(double nowMAXMIN_04) {
		this.nowMAXMIN_04 = nowMAXMIN_04;
	}

	public double getNowMAXMINRATIO_01() {
		return nowMAXMINRATIO_01;
	}

	public void setNowMAXMINRATIO_01(double nowMAXMINRATIO_01) {
		this.nowMAXMINRATIO_01 = nowMAXMINRATIO_01;
	}

	public double getNowMAXMINRATIO_02() {
		return nowMAXMINRATIO_02;
	}

	public void setNowMAXMINRATIO_02(double nowMAXMINRATIO_02) {
		this.nowMAXMINRATIO_02 = nowMAXMINRATIO_02;
	}

	public double getNowMAXMINRATIO_03() {
		return nowMAXMINRATIO_03;
	}

	public void setNowMAXMINRATIO_03(double nowMAXMINRATIO_03) {
		this.nowMAXMINRATIO_03 = nowMAXMINRATIO_03;
	}

	public double getNowMAXMINRATIO_04() {
		return nowMAXMINRATIO_04;
	}

	public void setNowMAXMINRATIO_04(double nowMAXMINRATIO_04) {
		this.nowMAXMINRATIO_04 = nowMAXMINRATIO_04;
	}

	public double getNowCANDLE_AREA_01() {
		return nowCANDLE_AREA_01;
	}

	public void setNowCANDLE_AREA_01(double nowCANDLE_AREA_01) {
		this.nowCANDLE_AREA_01 = nowCANDLE_AREA_01;
	}

	public double getNowCANDLE_AREA_02() {
		return nowCANDLE_AREA_02;
	}

	public void setNowCANDLE_AREA_02(double nowCANDLE_AREA_02) {
		this.nowCANDLE_AREA_02 = nowCANDLE_AREA_02;
	}

	public double getNowCANDLE_AREA_03() {
		return nowCANDLE_AREA_03;
	}

	public void setNowCANDLE_AREA_03(double nowCANDLE_AREA_03) {
		this.nowCANDLE_AREA_03 = nowCANDLE_AREA_03;
	}

	public double getNowCANDLE_AREA_04() {
		return nowCANDLE_AREA_04;
	}

	public void setNowCANDLE_AREA_04(double nowCANDLE_AREA_04) {
		this.nowCANDLE_AREA_04 = nowCANDLE_AREA_04;
	}

	public double getNowCANDLE_AREA_SCALE_01() {
		return nowCANDLE_AREA_SCALE_01;
	}

	public void setNowCANDLE_AREA_SCALE_01(double nowCANDLE_AREA_SCALE_01) {
		this.nowCANDLE_AREA_SCALE_01 = nowCANDLE_AREA_SCALE_01;
	}

	public double getNowCANDLE_AREA_SCALE_02() {
		return nowCANDLE_AREA_SCALE_02;
	}

	public void setNowCANDLE_AREA_SCALE_02(double nowCANDLE_AREA_SCALE_02) {
		this.nowCANDLE_AREA_SCALE_02 = nowCANDLE_AREA_SCALE_02;
	}

	public double getNowCANDLE_AREA_SCALE_03() {
		return nowCANDLE_AREA_SCALE_03;
	}

	public void setNowCANDLE_AREA_SCALE_03(double nowCANDLE_AREA_SCALE_03) {
		this.nowCANDLE_AREA_SCALE_03 = nowCANDLE_AREA_SCALE_03;
	}

	public double getNowCANDLE_AREA_SCALE_04() {
		return nowCANDLE_AREA_SCALE_04;
	}

	public void setNowCANDLE_AREA_SCALE_04(double nowCANDLE_AREA_SCALE_04) {
		this.nowCANDLE_AREA_SCALE_04 = nowCANDLE_AREA_SCALE_04;
	}

	public double getNowWINDOW_01() {
		return nowWINDOW_01;
	}

	public void setNowWINDOW_01(double nowWINDOW_01) {
		this.nowWINDOW_01 = nowWINDOW_01;
	}

	public double getNowWINDOW_02() {
		return nowWINDOW_02;
	}

	public void setNowWINDOW_02(double nowWINDOW_02) {
		this.nowWINDOW_02 = nowWINDOW_02;
	}

	public double getNowWINDOW_03() {
		return nowWINDOW_03;
	}

	public void setNowWINDOW_03(double nowWINDOW_03) {
		this.nowWINDOW_03 = nowWINDOW_03;
	}

	public double getNowWINDOW_04() {
		return nowWINDOW_04;
	}

	public void setNowWINDOW_04(double nowWINDOW_04) {
		this.nowWINDOW_04 = nowWINDOW_04;
	}

	public double getNowDEKI_CHANGERATE_01() {
		return nowDEKI_CHANGERATE_01;
	}

	public void setNowDEKI_CHANGERATE_01(double nowDEKI_CHANGERATE_01) {
		this.nowDEKI_CHANGERATE_01 = nowDEKI_CHANGERATE_01;
	}

	public double getNowDEKI_CHANGERATE_02() {
		return nowDEKI_CHANGERATE_02;
	}

	public void setNowDEKI_CHANGERATE_02(double nowDEKI_CHANGERATE_02) {
		this.nowDEKI_CHANGERATE_02 = nowDEKI_CHANGERATE_02;
	}

	public double getNowDEKI_CHANGERATE_03() {
		return nowDEKI_CHANGERATE_03;
	}

	public void setNowDEKI_CHANGERATE_03(double nowDEKI_CHANGERATE_03) {
		this.nowDEKI_CHANGERATE_03 = nowDEKI_CHANGERATE_03;
	}

	public double getNowDEKI_CHANGERATE_04() {
		return nowDEKI_CHANGERATE_04;
	}

	public void setNowDEKI_CHANGERATE_04(double nowDEKI_CHANGERATE_04) {
		this.nowDEKI_CHANGERATE_04 = nowDEKI_CHANGERATE_04;
	}

	public double getNowDEKI_RATIO_01() {
		return nowDEKI_RATIO_01;
	}

	public void setNowDEKI_RATIO_01(double nowDEKI_RATIO_01) {
		this.nowDEKI_RATIO_01 = nowDEKI_RATIO_01;
	}

	public double getNowDEKI_RATIO_02() {
		return nowDEKI_RATIO_02;
	}

	public void setNowDEKI_RATIO_02(double nowDEKI_RATIO_02) {
		this.nowDEKI_RATIO_02 = nowDEKI_RATIO_02;
	}

	public double getNowDEKI_RATIO_03() {
		return nowDEKI_RATIO_03;
	}

	public void setNowDEKI_RATIO_03(double nowDEKI_RATIO_03) {
		this.nowDEKI_RATIO_03 = nowDEKI_RATIO_03;
	}

	public double getNowDEKI_RATIO_04() {
		return nowDEKI_RATIO_04;
	}

	public void setNowDEKI_RATIO_04(double nowDEKI_RATIO_04) {
		this.nowDEKI_RATIO_04 = nowDEKI_RATIO_04;
	}

	public double getNowBAYBAY_CHANGERATE_01() {
		return nowBAYBAY_CHANGERATE_01;
	}

	public void setNowBAYBAY_CHANGERATE_01(double nowBAYBAY_CHANGERATE_01) {
		this.nowBAYBAY_CHANGERATE_01 = nowBAYBAY_CHANGERATE_01;
	}

	public double getNowBAYBAY_CHANGERATE_02() {
		return nowBAYBAY_CHANGERATE_02;
	}

	public void setNowBAYBAY_CHANGERATE_02(double nowBAYBAY_CHANGERATE_02) {
		this.nowBAYBAY_CHANGERATE_02 = nowBAYBAY_CHANGERATE_02;
	}

	public double getNowBAYBAY_CHANGERATE_03() {
		return nowBAYBAY_CHANGERATE_03;
	}

	public void setNowBAYBAY_CHANGERATE_03(double nowBAYBAY_CHANGERATE_03) {
		this.nowBAYBAY_CHANGERATE_03 = nowBAYBAY_CHANGERATE_03;
	}

	public double getNowBAYBAY_CHANGERATE_04() {
		return nowBAYBAY_CHANGERATE_04;
	}

	public void setNowBAYBAY_CHANGERATE_04(double nowBAYBAY_CHANGERATE_04) {
		this.nowBAYBAY_CHANGERATE_04 = nowBAYBAY_CHANGERATE_04;
	}

	public double getNowBAYBAY_RATIO_01() {
		return nowBAYBAY_RATIO_01;
	}

	public void setNowBAYBAY_RATIO_01(double nowBAYBAY_RATIO_01) {
		this.nowBAYBAY_RATIO_01 = nowBAYBAY_RATIO_01;
	}

	public double getNowBAYBAY_RATIO_02() {
		return nowBAYBAY_RATIO_02;
	}

	public void setNowBAYBAY_RATIO_02(double nowBAYBAY_RATIO_02) {
		this.nowBAYBAY_RATIO_02 = nowBAYBAY_RATIO_02;
	}

	public double getNowBAYBAY_RATIO_03() {
		return nowBAYBAY_RATIO_03;
	}

	public void setNowBAYBAY_RATIO_03(double nowBAYBAY_RATIO_03) {
		this.nowBAYBAY_RATIO_03 = nowBAYBAY_RATIO_03;
	}

	public double getNowBAYBAY_RATIO_04() {
		return nowBAYBAY_RATIO_04;
	}

	public void setNowBAYBAY_RATIO_04(double nowBAYBAY_RATIO_04) {
		this.nowBAYBAY_RATIO_04 = nowBAYBAY_RATIO_04;
	}

	public double getNowSHORTIDO_DEKI_01() {
		return nowSHORTIDO_DEKI_01;
	}

	public void setNowSHORTIDO_DEKI_01(double nowSHORTIDO_DEKI_01) {
		this.nowSHORTIDO_DEKI_01 = nowSHORTIDO_DEKI_01;
	}

	public double getNowSHORTIDO_DEKI_02() {
		return nowSHORTIDO_DEKI_02;
	}

	public void setNowSHORTIDO_DEKI_02(double nowSHORTIDO_DEKI_02) {
		this.nowSHORTIDO_DEKI_02 = nowSHORTIDO_DEKI_02;
	}

	public double getNowSHORTIDO_DEKI_03() {
		return nowSHORTIDO_DEKI_03;
	}

	public void setNowSHORTIDO_DEKI_03(double nowSHORTIDO_DEKI_03) {
		this.nowSHORTIDO_DEKI_03 = nowSHORTIDO_DEKI_03;
	}

	public double getNowSHORTIDO_DEKI_04() {
		return nowSHORTIDO_DEKI_04;
	}

	public void setNowSHORTIDO_DEKI_04(double nowSHORTIDO_DEKI_04) {
		this.nowSHORTIDO_DEKI_04 = nowSHORTIDO_DEKI_04;
	}

	public double getNowMIDDLEIDO_DEKI_01() {
		return nowMIDDLEIDO_DEKI_01;
	}

	public void setNowMIDDLEIDO_DEKI_01(double nowMIDDLEIDO_DEKI_01) {
		this.nowMIDDLEIDO_DEKI_01 = nowMIDDLEIDO_DEKI_01;
	}

	public double getNowMIDDLEIDO_DEKI_02() {
		return nowMIDDLEIDO_DEKI_02;
	}

	public void setNowMIDDLEIDO_DEKI_02(double nowMIDDLEIDO_DEKI_02) {
		this.nowMIDDLEIDO_DEKI_02 = nowMIDDLEIDO_DEKI_02;
	}

	public double getNowMIDDLEIDO_DEKI_03() {
		return nowMIDDLEIDO_DEKI_03;
	}

	public void setNowMIDDLEIDO_DEKI_03(double nowMIDDLEIDO_DEKI_03) {
		this.nowMIDDLEIDO_DEKI_03 = nowMIDDLEIDO_DEKI_03;
	}

	public double getNowMIDDLEIDO_DEKI_04() {
		return nowMIDDLEIDO_DEKI_04;
	}

	public void setNowMIDDLEIDO_DEKI_04(double nowMIDDLEIDO_DEKI_04) {
		this.nowMIDDLEIDO_DEKI_04 = nowMIDDLEIDO_DEKI_04;
	}

	public double getNowLONGIDO_DEKI_01() {
		return nowLONGIDO_DEKI_01;
	}

	public void setNowLONGIDO_DEKI_01(double nowLONGIDO_DEKI_01) {
		this.nowLONGIDO_DEKI_01 = nowLONGIDO_DEKI_01;
	}

	public double getNowLONGIDO_DEKI_02() {
		return nowLONGIDO_DEKI_02;
	}

	public void setNowLONGIDO_DEKI_02(double nowLONGIDO_DEKI_02) {
		this.nowLONGIDO_DEKI_02 = nowLONGIDO_DEKI_02;
	}

	public double getNowLONGIDO_DEKI_03() {
		return nowLONGIDO_DEKI_03;
	}

	public void setNowLONGIDO_DEKI_03(double nowLONGIDO_DEKI_03) {
		this.nowLONGIDO_DEKI_03 = nowLONGIDO_DEKI_03;
	}

	public double getNowLONGIDO_DEKI_04() {
		return nowLONGIDO_DEKI_04;
	}

	public void setNowLONGIDO_DEKI_04(double nowLONGIDO_DEKI_04) {
		this.nowLONGIDO_DEKI_04 = nowLONGIDO_DEKI_04;
	}

	public double getNowSHORTIDO_DEKI_CHANGERATE_01() {
		return nowSHORTIDO_DEKI_CHANGERATE_01;
	}

	public void setNowSHORTIDO_DEKI_CHANGERATE_01(
			double nowSHORTIDO_DEKI_CHANGERATE_01) {
		this.nowSHORTIDO_DEKI_CHANGERATE_01 = nowSHORTIDO_DEKI_CHANGERATE_01;
	}

	public double getNowSHORTIDO_DEKI_CHANGERATE_02() {
		return nowSHORTIDO_DEKI_CHANGERATE_02;
	}

	public void setNowSHORTIDO_DEKI_CHANGERATE_02(
			double nowSHORTIDO_DEKI_CHANGERATE_02) {
		this.nowSHORTIDO_DEKI_CHANGERATE_02 = nowSHORTIDO_DEKI_CHANGERATE_02;
	}

	public double getNowSHORTIDO_DEKI_CHANGERATE_03() {
		return nowSHORTIDO_DEKI_CHANGERATE_03;
	}

	public void setNowSHORTIDO_DEKI_CHANGERATE_03(
			double nowSHORTIDO_DEKI_CHANGERATE_03) {
		this.nowSHORTIDO_DEKI_CHANGERATE_03 = nowSHORTIDO_DEKI_CHANGERATE_03;
	}

	public double getNowSHORTIDO_DEKI_CHANGERATE_04() {
		return nowSHORTIDO_DEKI_CHANGERATE_04;
	}

	public void setNowSHORTIDO_DEKI_CHANGERATE_04(
			double nowSHORTIDO_DEKI_CHANGERATE_04) {
		this.nowSHORTIDO_DEKI_CHANGERATE_04 = nowSHORTIDO_DEKI_CHANGERATE_04;
	}

	public double getNowMIDDLEIDO_DEKI_CHANGERATE_01() {
		return nowMIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public void setNowMIDDLEIDO_DEKI_CHANGERATE_01(
			double nowMIDDLEIDO_DEKI_CHANGERATE_01) {
		this.nowMIDDLEIDO_DEKI_CHANGERATE_01 = nowMIDDLEIDO_DEKI_CHANGERATE_01;
	}

	public double getNowMIDDLEIDO_DEKI_CHANGERATE_02() {
		return nowMIDDLEIDO_DEKI_CHANGERATE_02;
	}

	public void setNowMIDDLEIDO_DEKI_CHANGERATE_02(
			double nowMIDDLEIDO_DEKI_CHANGERATE_02) {
		this.nowMIDDLEIDO_DEKI_CHANGERATE_02 = nowMIDDLEIDO_DEKI_CHANGERATE_02;
	}

	public double getNowMIDDLEIDO_DEKI_CHANGERATE_03() {
		return nowMIDDLEIDO_DEKI_CHANGERATE_03;
	}

	public void setNowMIDDLEIDO_DEKI_CHANGERATE_03(
			double nowMIDDLEIDO_DEKI_CHANGERATE_03) {
		this.nowMIDDLEIDO_DEKI_CHANGERATE_03 = nowMIDDLEIDO_DEKI_CHANGERATE_03;
	}

	public double getNowMIDDLEIDO_DEKI_CHANGERATE_04() {
		return nowMIDDLEIDO_DEKI_CHANGERATE_04;
	}

	public void setNowMIDDLEIDO_DEKI_CHANGERATE_04(
			double nowMIDDLEIDO_DEKI_CHANGERATE_04) {
		this.nowMIDDLEIDO_DEKI_CHANGERATE_04 = nowMIDDLEIDO_DEKI_CHANGERATE_04;
	}

	public double getNowLONGIDO_DEKI_CHANGERATE_01() {
		return nowLONGIDO_DEKI_CHANGERATE_01;
	}

	public void setNowLONGIDO_DEKI_CHANGERATE_01(
			double nowLONGIDO_DEKI_CHANGERATE_01) {
		this.nowLONGIDO_DEKI_CHANGERATE_01 = nowLONGIDO_DEKI_CHANGERATE_01;
	}

	public double getNowLONGIDO_DEKI_CHANGERATE_02() {
		return nowLONGIDO_DEKI_CHANGERATE_02;
	}

	public void setNowLONGIDO_DEKI_CHANGERATE_02(
			double nowLONGIDO_DEKI_CHANGERATE_02) {
		this.nowLONGIDO_DEKI_CHANGERATE_02 = nowLONGIDO_DEKI_CHANGERATE_02;
	}

	public double getNowLONGIDO_DEKI_CHANGERATE_03() {
		return nowLONGIDO_DEKI_CHANGERATE_03;
	}

	public void setNowLONGIDO_DEKI_CHANGERATE_03(
			double nowLONGIDO_DEKI_CHANGERATE_03) {
		this.nowLONGIDO_DEKI_CHANGERATE_03 = nowLONGIDO_DEKI_CHANGERATE_03;
	}

	public double getNowLONGIDO_DEKI_CHANGERATE_04() {
		return nowLONGIDO_DEKI_CHANGERATE_04;
	}

	public void setNowLONGIDO_DEKI_CHANGERATE_04(
			double nowLONGIDO_DEKI_CHANGERATE_04) {
		this.nowLONGIDO_DEKI_CHANGERATE_04 = nowLONGIDO_DEKI_CHANGERATE_04;
	}

	public double getNowSHORTIDO_DEKI_RATIO_01() {
		return nowSHORTIDO_DEKI_RATIO_01;
	}

	public void setNowSHORTIDO_DEKI_RATIO_01(double nowSHORTIDO_DEKI_RATIO_01) {
		this.nowSHORTIDO_DEKI_RATIO_01 = nowSHORTIDO_DEKI_RATIO_01;
	}

	public double getNowSHORTIDO_DEKI_RATIO_02() {
		return nowSHORTIDO_DEKI_RATIO_02;
	}

	public void setNowSHORTIDO_DEKI_RATIO_02(double nowSHORTIDO_DEKI_RATIO_02) {
		this.nowSHORTIDO_DEKI_RATIO_02 = nowSHORTIDO_DEKI_RATIO_02;
	}

	public double getNowSHORTIDO_DEKI_RATIO_03() {
		return nowSHORTIDO_DEKI_RATIO_03;
	}

	public void setNowSHORTIDO_DEKI_RATIO_03(double nowSHORTIDO_DEKI_RATIO_03) {
		this.nowSHORTIDO_DEKI_RATIO_03 = nowSHORTIDO_DEKI_RATIO_03;
	}

	public double getNowSHORTIDO_DEKI_RATIO_04() {
		return nowSHORTIDO_DEKI_RATIO_04;
	}

	public void setNowSHORTIDO_DEKI_RATIO_04(double nowSHORTIDO_DEKI_RATIO_04) {
		this.nowSHORTIDO_DEKI_RATIO_04 = nowSHORTIDO_DEKI_RATIO_04;
	}

	public double getNowMIDDLEIDO_DEKI_RATIO_01() {
		return nowMIDDLEIDO_DEKI_RATIO_01;
	}

	public void setNowMIDDLEIDO_DEKI_RATIO_01(double nowMIDDLEIDO_DEKI_RATIO_01) {
		this.nowMIDDLEIDO_DEKI_RATIO_01 = nowMIDDLEIDO_DEKI_RATIO_01;
	}

	public double getNowMIDDLEIDO_DEKI_RATIO_02() {
		return nowMIDDLEIDO_DEKI_RATIO_02;
	}

	public void setNowMIDDLEIDO_DEKI_RATIO_02(double nowMIDDLEIDO_DEKI_RATIO_02) {
		this.nowMIDDLEIDO_DEKI_RATIO_02 = nowMIDDLEIDO_DEKI_RATIO_02;
	}

	public double getNowMIDDLEIDO_DEKI_RATIO_03() {
		return nowMIDDLEIDO_DEKI_RATIO_03;
	}

	public void setNowMIDDLEIDO_DEKI_RATIO_03(double nowMIDDLEIDO_DEKI_RATIO_03) {
		this.nowMIDDLEIDO_DEKI_RATIO_03 = nowMIDDLEIDO_DEKI_RATIO_03;
	}

	public double getNowMIDDLEIDO_DEKI_RATIO_04() {
		return nowMIDDLEIDO_DEKI_RATIO_04;
	}

	public void setNowMIDDLEIDO_DEKI_RATIO_04(double nowMIDDLEIDO_DEKI_RATIO_04) {
		this.nowMIDDLEIDO_DEKI_RATIO_04 = nowMIDDLEIDO_DEKI_RATIO_04;
	}

	public double getNowLONGIDO_DEKI_RATIO_01() {
		return nowLONGIDO_DEKI_RATIO_01;
	}

	public void setNowLONGIDO_DEKI_RATIO_01(double nowLONGIDO_DEKI_RATIO_01) {
		this.nowLONGIDO_DEKI_RATIO_01 = nowLONGIDO_DEKI_RATIO_01;
	}

	public double getNowLONGIDO_DEKI_RATIO_02() {
		return nowLONGIDO_DEKI_RATIO_02;
	}

	public void setNowLONGIDO_DEKI_RATIO_02(double nowLONGIDO_DEKI_RATIO_02) {
		this.nowLONGIDO_DEKI_RATIO_02 = nowLONGIDO_DEKI_RATIO_02;
	}

	public double getNowLONGIDO_DEKI_RATIO_03() {
		return nowLONGIDO_DEKI_RATIO_03;
	}

	public void setNowLONGIDO_DEKI_RATIO_03(double nowLONGIDO_DEKI_RATIO_03) {
		this.nowLONGIDO_DEKI_RATIO_03 = nowLONGIDO_DEKI_RATIO_03;
	}

	public double getNowLONGIDO_DEKI_RATIO_04() {
		return nowLONGIDO_DEKI_RATIO_04;
	}

	public void setNowLONGIDO_DEKI_RATIO_04(double nowLONGIDO_DEKI_RATIO_04) {
		this.nowLONGIDO_DEKI_RATIO_04 = nowLONGIDO_DEKI_RATIO_04;
	}

	public double getNowSHORTIDO_BAYBAY_01() {
		return nowSHORTIDO_BAYBAY_01;
	}

	public void setNowSHORTIDO_BAYBAY_01(double nowSHORTIDO_BAYBAY_01) {
		this.nowSHORTIDO_BAYBAY_01 = nowSHORTIDO_BAYBAY_01;
	}

	public double getNowSHORTIDO_BAYBAY_02() {
		return nowSHORTIDO_BAYBAY_02;
	}

	public void setNowSHORTIDO_BAYBAY_02(double nowSHORTIDO_BAYBAY_02) {
		this.nowSHORTIDO_BAYBAY_02 = nowSHORTIDO_BAYBAY_02;
	}

	public double getNowSHORTIDO_BAYBAY_03() {
		return nowSHORTIDO_BAYBAY_03;
	}

	public void setNowSHORTIDO_BAYBAY_03(double nowSHORTIDO_BAYBAY_03) {
		this.nowSHORTIDO_BAYBAY_03 = nowSHORTIDO_BAYBAY_03;
	}

	public double getNowSHORTIDO_BAYBAY_04() {
		return nowSHORTIDO_BAYBAY_04;
	}

	public void setNowSHORTIDO_BAYBAY_04(double nowSHORTIDO_BAYBAY_04) {
		this.nowSHORTIDO_BAYBAY_04 = nowSHORTIDO_BAYBAY_04;
	}

	public double getNowMIDDLEIDO_BAYBAY_01() {
		return nowMIDDLEIDO_BAYBAY_01;
	}

	public void setNowMIDDLEIDO_BAYBAY_01(double nowMIDDLEIDO_BAYBAY_01) {
		this.nowMIDDLEIDO_BAYBAY_01 = nowMIDDLEIDO_BAYBAY_01;
	}

	public double getNowMIDDLEIDO_BAYBAY_02() {
		return nowMIDDLEIDO_BAYBAY_02;
	}

	public void setNowMIDDLEIDO_BAYBAY_02(double nowMIDDLEIDO_BAYBAY_02) {
		this.nowMIDDLEIDO_BAYBAY_02 = nowMIDDLEIDO_BAYBAY_02;
	}

	public double getNowMIDDLEIDO_BAYBAY_03() {
		return nowMIDDLEIDO_BAYBAY_03;
	}

	public void setNowMIDDLEIDO_BAYBAY_03(double nowMIDDLEIDO_BAYBAY_03) {
		this.nowMIDDLEIDO_BAYBAY_03 = nowMIDDLEIDO_BAYBAY_03;
	}

	public double getNowMIDDLEIDO_BAYBAY_04() {
		return nowMIDDLEIDO_BAYBAY_04;
	}

	public void setNowMIDDLEIDO_BAYBAY_04(double nowMIDDLEIDO_BAYBAY_04) {
		this.nowMIDDLEIDO_BAYBAY_04 = nowMIDDLEIDO_BAYBAY_04;
	}

	public double getNowLONGIDO_BAYBAY_01() {
		return nowLONGIDO_BAYBAY_01;
	}

	public void setNowLONGIDO_BAYBAY_01(double nowLONGIDO_BAYBAY_01) {
		this.nowLONGIDO_BAYBAY_01 = nowLONGIDO_BAYBAY_01;
	}

	public double getNowLONGIDO_BAYBAY_02() {
		return nowLONGIDO_BAYBAY_02;
	}

	public void setNowLONGIDO_BAYBAY_02(double nowLONGIDO_BAYBAY_02) {
		this.nowLONGIDO_BAYBAY_02 = nowLONGIDO_BAYBAY_02;
	}

	public double getNowLONGIDO_BAYBAY_03() {
		return nowLONGIDO_BAYBAY_03;
	}

	public void setNowLONGIDO_BAYBAY_03(double nowLONGIDO_BAYBAY_03) {
		this.nowLONGIDO_BAYBAY_03 = nowLONGIDO_BAYBAY_03;
	}

	public double getNowLONGIDO_BAYBAY_04() {
		return nowLONGIDO_BAYBAY_04;
	}

	public void setNowLONGIDO_BAYBAY_04(double nowLONGIDO_BAYBAY_04) {
		this.nowLONGIDO_BAYBAY_04 = nowLONGIDO_BAYBAY_04;
	}

	public double getNowSHORTIDO_BAYBAY_CHANGERATE_01() {
		return nowSHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowSHORTIDO_BAYBAY_CHANGERATE_01(
			double nowSHORTIDO_BAYBAY_CHANGERATE_01) {
		this.nowSHORTIDO_BAYBAY_CHANGERATE_01 = nowSHORTIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowSHORTIDO_BAYBAY_CHANGERATE_02() {
		return nowSHORTIDO_BAYBAY_CHANGERATE_02;
	}

	public void setNowSHORTIDO_BAYBAY_CHANGERATE_02(
			double nowSHORTIDO_BAYBAY_CHANGERATE_02) {
		this.nowSHORTIDO_BAYBAY_CHANGERATE_02 = nowSHORTIDO_BAYBAY_CHANGERATE_02;
	}

	public double getNowSHORTIDO_BAYBAY_CHANGERATE_03() {
		return nowSHORTIDO_BAYBAY_CHANGERATE_03;
	}

	public void setNowSHORTIDO_BAYBAY_CHANGERATE_03(
			double nowSHORTIDO_BAYBAY_CHANGERATE_03) {
		this.nowSHORTIDO_BAYBAY_CHANGERATE_03 = nowSHORTIDO_BAYBAY_CHANGERATE_03;
	}

	public double getNowSHORTIDO_BAYBAY_CHANGERATE_04() {
		return nowSHORTIDO_BAYBAY_CHANGERATE_04;
	}

	public void setNowSHORTIDO_BAYBAY_CHANGERATE_04(
			double nowSHORTIDO_BAYBAY_CHANGERATE_04) {
		this.nowSHORTIDO_BAYBAY_CHANGERATE_04 = nowSHORTIDO_BAYBAY_CHANGERATE_04;
	}

	public double getNowMIDDLEIDO_BAYBAY_CHANGERATE_01() {
		return nowMIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowMIDDLEIDO_BAYBAY_CHANGERATE_01(
			double nowMIDDLEIDO_BAYBAY_CHANGERATE_01) {
		this.nowMIDDLEIDO_BAYBAY_CHANGERATE_01 = nowMIDDLEIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowMIDDLEIDO_BAYBAY_CHANGERATE_02() {
		return nowMIDDLEIDO_BAYBAY_CHANGERATE_02;
	}

	public void setNowMIDDLEIDO_BAYBAY_CHANGERATE_02(
			double nowMIDDLEIDO_BAYBAY_CHANGERATE_02) {
		this.nowMIDDLEIDO_BAYBAY_CHANGERATE_02 = nowMIDDLEIDO_BAYBAY_CHANGERATE_02;
	}

	public double getNowMIDDLEIDO_BAYBAY_CHANGERATE_03() {
		return nowMIDDLEIDO_BAYBAY_CHANGERATE_03;
	}

	public void setNowMIDDLEIDO_BAYBAY_CHANGERATE_03(
			double nowMIDDLEIDO_BAYBAY_CHANGERATE_03) {
		this.nowMIDDLEIDO_BAYBAY_CHANGERATE_03 = nowMIDDLEIDO_BAYBAY_CHANGERATE_03;
	}

	public double getNowMIDDLEIDO_BAYBAY_CHANGERATE_04() {
		return nowMIDDLEIDO_BAYBAY_CHANGERATE_04;
	}

	public void setNowMIDDLEIDO_BAYBAY_CHANGERATE_04(
			double nowMIDDLEIDO_BAYBAY_CHANGERATE_04) {
		this.nowMIDDLEIDO_BAYBAY_CHANGERATE_04 = nowMIDDLEIDO_BAYBAY_CHANGERATE_04;
	}

	public double getNowLONGIDO_BAYBAY_CHANGERATE_01() {
		return nowLONGIDO_BAYBAY_CHANGERATE_01;
	}

	public void setNowLONGIDO_BAYBAY_CHANGERATE_01(
			double nowLONGIDO_BAYBAY_CHANGERATE_01) {
		this.nowLONGIDO_BAYBAY_CHANGERATE_01 = nowLONGIDO_BAYBAY_CHANGERATE_01;
	}

	public double getNowLONGIDO_BAYBAY_CHANGERATE_02() {
		return nowLONGIDO_BAYBAY_CHANGERATE_02;
	}

	public void setNowLONGIDO_BAYBAY_CHANGERATE_02(
			double nowLONGIDO_BAYBAY_CHANGERATE_02) {
		this.nowLONGIDO_BAYBAY_CHANGERATE_02 = nowLONGIDO_BAYBAY_CHANGERATE_02;
	}

	public double getNowLONGIDO_BAYBAY_CHANGERATE_03() {
		return nowLONGIDO_BAYBAY_CHANGERATE_03;
	}

	public void setNowLONGIDO_BAYBAY_CHANGERATE_03(
			double nowLONGIDO_BAYBAY_CHANGERATE_03) {
		this.nowLONGIDO_BAYBAY_CHANGERATE_03 = nowLONGIDO_BAYBAY_CHANGERATE_03;
	}

	public double getNowLONGIDO_BAYBAY_CHANGERATE_04() {
		return nowLONGIDO_BAYBAY_CHANGERATE_04;
	}

	public void setNowLONGIDO_BAYBAY_CHANGERATE_04(
			double nowLONGIDO_BAYBAY_CHANGERATE_04) {
		this.nowLONGIDO_BAYBAY_CHANGERATE_04 = nowLONGIDO_BAYBAY_CHANGERATE_04;
	}

	public double getNowSHORTIDO_BAYBAY_RATIO_01() {
		return nowSHORTIDO_BAYBAY_RATIO_01;
	}

	public void setNowSHORTIDO_BAYBAY_RATIO_01(double nowSHORTIDO_BAYBAY_RATIO_01) {
		this.nowSHORTIDO_BAYBAY_RATIO_01 = nowSHORTIDO_BAYBAY_RATIO_01;
	}

	public double getNowSHORTIDO_BAYBAY_RATIO_02() {
		return nowSHORTIDO_BAYBAY_RATIO_02;
	}

	public void setNowSHORTIDO_BAYBAY_RATIO_02(double nowSHORTIDO_BAYBAY_RATIO_02) {
		this.nowSHORTIDO_BAYBAY_RATIO_02 = nowSHORTIDO_BAYBAY_RATIO_02;
	}

	public double getNowSHORTIDO_BAYBAY_RATIO_03() {
		return nowSHORTIDO_BAYBAY_RATIO_03;
	}

	public void setNowSHORTIDO_BAYBAY_RATIO_03(double nowSHORTIDO_BAYBAY_RATIO_03) {
		this.nowSHORTIDO_BAYBAY_RATIO_03 = nowSHORTIDO_BAYBAY_RATIO_03;
	}

	public double getNowSHORTIDO_BAYBAY_RATIO_04() {
		return nowSHORTIDO_BAYBAY_RATIO_04;
	}

	public void setNowSHORTIDO_BAYBAY_RATIO_04(double nowSHORTIDO_BAYBAY_RATIO_04) {
		this.nowSHORTIDO_BAYBAY_RATIO_04 = nowSHORTIDO_BAYBAY_RATIO_04;
	}

	public double getNowMIDDLEIDO_BAYBAY_RATIO_01() {
		return nowMIDDLEIDO_BAYBAY_RATIO_01;
	}

	public void setNowMIDDLEIDO_BAYBAY_RATIO_01(double nowMIDDLEIDO_BAYBAY_RATIO_01) {
		this.nowMIDDLEIDO_BAYBAY_RATIO_01 = nowMIDDLEIDO_BAYBAY_RATIO_01;
	}

	public double getNowMIDDLEIDO_BAYBAY_RATIO_02() {
		return nowMIDDLEIDO_BAYBAY_RATIO_02;
	}

	public void setNowMIDDLEIDO_BAYBAY_RATIO_02(double nowMIDDLEIDO_BAYBAY_RATIO_02) {
		this.nowMIDDLEIDO_BAYBAY_RATIO_02 = nowMIDDLEIDO_BAYBAY_RATIO_02;
	}

	public double getNowMIDDLEIDO_BAYBAY_RATIO_03() {
		return nowMIDDLEIDO_BAYBAY_RATIO_03;
	}

	public void setNowMIDDLEIDO_BAYBAY_RATIO_03(double nowMIDDLEIDO_BAYBAY_RATIO_03) {
		this.nowMIDDLEIDO_BAYBAY_RATIO_03 = nowMIDDLEIDO_BAYBAY_RATIO_03;
	}

	public double getNowMIDDLEIDO_BAYBAY_RATIO_04() {
		return nowMIDDLEIDO_BAYBAY_RATIO_04;
	}

	public void setNowMIDDLEIDO_BAYBAY_RATIO_04(double nowMIDDLEIDO_BAYBAY_RATIO_04) {
		this.nowMIDDLEIDO_BAYBAY_RATIO_04 = nowMIDDLEIDO_BAYBAY_RATIO_04;
	}

	public double getNowLONGIDO_BAYBAY_RATIO_01() {
		return nowLONGIDO_BAYBAY_RATIO_01;
	}

	public void setNowLONGIDO_BAYBAY_RATIO_01(double nowLONGIDO_BAYBAY_RATIO_01) {
		this.nowLONGIDO_BAYBAY_RATIO_01 = nowLONGIDO_BAYBAY_RATIO_01;
	}

	public double getNowLONGIDO_BAYBAY_RATIO_02() {
		return nowLONGIDO_BAYBAY_RATIO_02;
	}

	public void setNowLONGIDO_BAYBAY_RATIO_02(double nowLONGIDO_BAYBAY_RATIO_02) {
		this.nowLONGIDO_BAYBAY_RATIO_02 = nowLONGIDO_BAYBAY_RATIO_02;
	}

	public double getNowLONGIDO_BAYBAY_RATIO_03() {
		return nowLONGIDO_BAYBAY_RATIO_03;
	}

	public void setNowLONGIDO_BAYBAY_RATIO_03(double nowLONGIDO_BAYBAY_RATIO_03) {
		this.nowLONGIDO_BAYBAY_RATIO_03 = nowLONGIDO_BAYBAY_RATIO_03;
	}

	public double getNowLONGIDO_BAYBAY_RATIO_04() {
		return nowLONGIDO_BAYBAY_RATIO_04;
	}

	public void setNowLONGIDO_BAYBAY_RATIO_04(double nowLONGIDO_BAYBAY_RATIO_04) {
		this.nowLONGIDO_BAYBAY_RATIO_04 = nowLONGIDO_BAYBAY_RATIO_04;
	}

	public double getNowCREDIT_LONG_01() {
		return nowCREDIT_LONG_01;
	}

	public void setNowCREDIT_LONG_01(double nowCREDIT_LONG_01) {
		this.nowCREDIT_LONG_01 = nowCREDIT_LONG_01;
	}

	public double getNowCREDIT_LONG_02() {
		return nowCREDIT_LONG_02;
	}

	public void setNowCREDIT_LONG_02(double nowCREDIT_LONG_02) {
		this.nowCREDIT_LONG_02 = nowCREDIT_LONG_02;
	}

	public double getNowCREDIT_LONG_03() {
		return nowCREDIT_LONG_03;
	}

	public void setNowCREDIT_LONG_03(double nowCREDIT_LONG_03) {
		this.nowCREDIT_LONG_03 = nowCREDIT_LONG_03;
	}

	public double getNowCREDIT_LONG_04() {
		return nowCREDIT_LONG_04;
	}

	public void setNowCREDIT_LONG_04(double nowCREDIT_LONG_04) {
		this.nowCREDIT_LONG_04 = nowCREDIT_LONG_04;
	}

	public double getNowCREDIT_SHORT_01() {
		return nowCREDIT_SHORT_01;
	}

	public void setNowCREDIT_SHORT_01(double nowCREDIT_SHORT_01) {
		this.nowCREDIT_SHORT_01 = nowCREDIT_SHORT_01;
	}

	public double getNowCREDIT_SHORT_02() {
		return nowCREDIT_SHORT_02;
	}

	public void setNowCREDIT_SHORT_02(double nowCREDIT_SHORT_02) {
		this.nowCREDIT_SHORT_02 = nowCREDIT_SHORT_02;
	}

	public double getNowCREDIT_SHORT_03() {
		return nowCREDIT_SHORT_03;
	}

	public void setNowCREDIT_SHORT_03(double nowCREDIT_SHORT_03) {
		this.nowCREDIT_SHORT_03 = nowCREDIT_SHORT_03;
	}

	public double getNowCREDIT_SHORT_04() {
		return nowCREDIT_SHORT_04;
	}

	public void setNowCREDIT_SHORT_04(double nowCREDIT_SHORT_04) {
		this.nowCREDIT_SHORT_04 = nowCREDIT_SHORT_04;
	}

	public double getNowCREDIT_RATIO_01() {
		return nowCREDIT_RATIO_01;
	}

	public void setNowCREDIT_RATIO_01(double nowCREDIT_RATIO_01) {
		this.nowCREDIT_RATIO_01 = nowCREDIT_RATIO_01;
	}

	public double getNowCREDIT_RATIO_02() {
		return nowCREDIT_RATIO_02;
	}

	public void setNowCREDIT_RATIO_02(double nowCREDIT_RATIO_02) {
		this.nowCREDIT_RATIO_02 = nowCREDIT_RATIO_02;
	}

	public double getNowCREDIT_RATIO_03() {
		return nowCREDIT_RATIO_03;
	}

	public void setNowCREDIT_RATIO_03(double nowCREDIT_RATIO_03) {
		this.nowCREDIT_RATIO_03 = nowCREDIT_RATIO_03;
	}

	public double getNowCREDIT_RATIO_04() {
		return nowCREDIT_RATIO_04;
	}

	public void setNowCREDIT_RATIO_04(double nowCREDIT_RATIO_04) {
		this.nowCREDIT_RATIO_04 = nowCREDIT_RATIO_04;
	}

	public double getNowCREDIT_LONG_CHANGERATE_01() {
		return nowCREDIT_LONG_CHANGERATE_01;
	}

	public void setNowCREDIT_LONG_CHANGERATE_01(double nowCREDIT_LONG_CHANGERATE_01) {
		this.nowCREDIT_LONG_CHANGERATE_01 = nowCREDIT_LONG_CHANGERATE_01;
	}

	public double getNowCREDIT_LONG_CHANGERATE_02() {
		return nowCREDIT_LONG_CHANGERATE_02;
	}

	public void setNowCREDIT_LONG_CHANGERATE_02(double nowCREDIT_LONG_CHANGERATE_02) {
		this.nowCREDIT_LONG_CHANGERATE_02 = nowCREDIT_LONG_CHANGERATE_02;
	}

	public double getNowCREDIT_LONG_CHANGERATE_03() {
		return nowCREDIT_LONG_CHANGERATE_03;
	}

	public void setNowCREDIT_LONG_CHANGERATE_03(double nowCREDIT_LONG_CHANGERATE_03) {
		this.nowCREDIT_LONG_CHANGERATE_03 = nowCREDIT_LONG_CHANGERATE_03;
	}

	public double getNowCREDIT_LONG_CHANGERATE_04() {
		return nowCREDIT_LONG_CHANGERATE_04;
	}

	public void setNowCREDIT_LONG_CHANGERATE_04(double nowCREDIT_LONG_CHANGERATE_04) {
		this.nowCREDIT_LONG_CHANGERATE_04 = nowCREDIT_LONG_CHANGERATE_04;
	}

	public double getNowCREDIT_SHORT_CHANGERATE_01() {
		return nowCREDIT_SHORT_CHANGERATE_01;
	}

	public void setNowCREDIT_SHORT_CHANGERATE_01(
			double nowCREDIT_SHORT_CHANGERATE_01) {
		this.nowCREDIT_SHORT_CHANGERATE_01 = nowCREDIT_SHORT_CHANGERATE_01;
	}

	public double getNowCREDIT_SHORT_CHANGERATE_02() {
		return nowCREDIT_SHORT_CHANGERATE_02;
	}

	public void setNowCREDIT_SHORT_CHANGERATE_02(
			double nowCREDIT_SHORT_CHANGERATE_02) {
		this.nowCREDIT_SHORT_CHANGERATE_02 = nowCREDIT_SHORT_CHANGERATE_02;
	}

	public double getNowCREDIT_SHORT_CHANGERATE_03() {
		return nowCREDIT_SHORT_CHANGERATE_03;
	}

	public void setNowCREDIT_SHORT_CHANGERATE_03(
			double nowCREDIT_SHORT_CHANGERATE_03) {
		this.nowCREDIT_SHORT_CHANGERATE_03 = nowCREDIT_SHORT_CHANGERATE_03;
	}

	public double getNowCREDIT_SHORT_CHANGERATE_04() {
		return nowCREDIT_SHORT_CHANGERATE_04;
	}

	public void setNowCREDIT_SHORT_CHANGERATE_04(
			double nowCREDIT_SHORT_CHANGERATE_04) {
		this.nowCREDIT_SHORT_CHANGERATE_04 = nowCREDIT_SHORT_CHANGERATE_04;
	}

	public double getNowCREDIT_RATIO_CHANGERATE_01() {
		return nowCREDIT_RATIO_CHANGERATE_01;
	}

	public void setNowCREDIT_RATIO_CHANGERATE_01(
			double nowCREDIT_RATIO_CHANGERATE_01) {
		this.nowCREDIT_RATIO_CHANGERATE_01 = nowCREDIT_RATIO_CHANGERATE_01;
	}

	public double getNowCREDIT_RATIO_CHANGERATE_02() {
		return nowCREDIT_RATIO_CHANGERATE_02;
	}

	public void setNowCREDIT_RATIO_CHANGERATE_02(
			double nowCREDIT_RATIO_CHANGERATE_02) {
		this.nowCREDIT_RATIO_CHANGERATE_02 = nowCREDIT_RATIO_CHANGERATE_02;
	}

	public double getNowCREDIT_RATIO_CHANGERATE_03() {
		return nowCREDIT_RATIO_CHANGERATE_03;
	}

	public void setNowCREDIT_RATIO_CHANGERATE_03(
			double nowCREDIT_RATIO_CHANGERATE_03) {
		this.nowCREDIT_RATIO_CHANGERATE_03 = nowCREDIT_RATIO_CHANGERATE_03;
	}

	public double getNowCREDIT_RATIO_CHANGERATE_04() {
		return nowCREDIT_RATIO_CHANGERATE_04;
	}

	public void setNowCREDIT_RATIO_CHANGERATE_04(
			double nowCREDIT_RATIO_CHANGERATE_04) {
		this.nowCREDIT_RATIO_CHANGERATE_04 = nowCREDIT_RATIO_CHANGERATE_04;
	}

	public double getNowSHORT_DEV_01() {
		return nowSHORT_DEV_01;
	}

	public void setNowSHORT_DEV_01(double nowSHORT_DEV_01) {
		this.nowSHORT_DEV_01 = nowSHORT_DEV_01;
	}

	public double getNowSHORT_DEV_02() {
		return nowSHORT_DEV_02;
	}

	public void setNowSHORT_DEV_02(double nowSHORT_DEV_02) {
		this.nowSHORT_DEV_02 = nowSHORT_DEV_02;
	}

	public double getNowSHORT_DEV_03() {
		return nowSHORT_DEV_03;
	}

	public void setNowSHORT_DEV_03(double nowSHORT_DEV_03) {
		this.nowSHORT_DEV_03 = nowSHORT_DEV_03;
	}

	public double getNowSHORT_DEV_04() {
		return nowSHORT_DEV_04;
	}

	public void setNowSHORT_DEV_04(double nowSHORT_DEV_04) {
		this.nowSHORT_DEV_04 = nowSHORT_DEV_04;
	}

	public double getNowSHORT_NOW_SIGMA_01() {
		return nowSHORT_NOW_SIGMA_01;
	}

	public void setNowSHORT_NOW_SIGMA_01(double nowSHORT_NOW_SIGMA_01) {
		this.nowSHORT_NOW_SIGMA_01 = nowSHORT_NOW_SIGMA_01;
	}

	public double getNowSHORT_NOW_SIGMA_02() {
		return nowSHORT_NOW_SIGMA_02;
	}

	public void setNowSHORT_NOW_SIGMA_02(double nowSHORT_NOW_SIGMA_02) {
		this.nowSHORT_NOW_SIGMA_02 = nowSHORT_NOW_SIGMA_02;
	}

	public double getNowSHORT_NOW_SIGMA_03() {
		return nowSHORT_NOW_SIGMA_03;
	}

	public void setNowSHORT_NOW_SIGMA_03(double nowSHORT_NOW_SIGMA_03) {
		this.nowSHORT_NOW_SIGMA_03 = nowSHORT_NOW_SIGMA_03;
	}

	public double getNowSHORT_NOW_SIGMA_04() {
		return nowSHORT_NOW_SIGMA_04;
	}

	public void setNowSHORT_NOW_SIGMA_04(double nowSHORT_NOW_SIGMA_04) {
		this.nowSHORT_NOW_SIGMA_04 = nowSHORT_NOW_SIGMA_04;
	}

	public double getNowSHORT_1_H_SIGMA_01() {
		return nowSHORT_1_H_SIGMA_01;
	}

	public void setNowSHORT_1_H_SIGMA_01(double nowSHORT_1_H_SIGMA_01) {
		this.nowSHORT_1_H_SIGMA_01 = nowSHORT_1_H_SIGMA_01;
	}

	public double getNowSHORT_1_H_SIGMA_02() {
		return nowSHORT_1_H_SIGMA_02;
	}

	public void setNowSHORT_1_H_SIGMA_02(double nowSHORT_1_H_SIGMA_02) {
		this.nowSHORT_1_H_SIGMA_02 = nowSHORT_1_H_SIGMA_02;
	}

	public double getNowSHORT_1_H_SIGMA_03() {
		return nowSHORT_1_H_SIGMA_03;
	}

	public void setNowSHORT_1_H_SIGMA_03(double nowSHORT_1_H_SIGMA_03) {
		this.nowSHORT_1_H_SIGMA_03 = nowSHORT_1_H_SIGMA_03;
	}

	public double getNowSHORT_1_H_SIGMA_04() {
		return nowSHORT_1_H_SIGMA_04;
	}

	public void setNowSHORT_1_H_SIGMA_04(double nowSHORT_1_H_SIGMA_04) {
		this.nowSHORT_1_H_SIGMA_04 = nowSHORT_1_H_SIGMA_04;
	}

	public double getNowSHORT_1_L_SIGMA_01() {
		return nowSHORT_1_L_SIGMA_01;
	}

	public void setNowSHORT_1_L_SIGMA_01(double nowSHORT_1_L_SIGMA_01) {
		this.nowSHORT_1_L_SIGMA_01 = nowSHORT_1_L_SIGMA_01;
	}

	public double getNowSHORT_1_L_SIGMA_02() {
		return nowSHORT_1_L_SIGMA_02;
	}

	public void setNowSHORT_1_L_SIGMA_02(double nowSHORT_1_L_SIGMA_02) {
		this.nowSHORT_1_L_SIGMA_02 = nowSHORT_1_L_SIGMA_02;
	}

	public double getNowSHORT_1_L_SIGMA_03() {
		return nowSHORT_1_L_SIGMA_03;
	}

	public void setNowSHORT_1_L_SIGMA_03(double nowSHORT_1_L_SIGMA_03) {
		this.nowSHORT_1_L_SIGMA_03 = nowSHORT_1_L_SIGMA_03;
	}

	public double getNowSHORT_1_L_SIGMA_04() {
		return nowSHORT_1_L_SIGMA_04;
	}

	public void setNowSHORT_1_L_SIGMA_04(double nowSHORT_1_L_SIGMA_04) {
		this.nowSHORT_1_L_SIGMA_04 = nowSHORT_1_L_SIGMA_04;
	}

	public double getNowSHORT_2_H_SIGMA_01() {
		return nowSHORT_2_H_SIGMA_01;
	}

	public void setNowSHORT_2_H_SIGMA_01(double nowSHORT_2_H_SIGMA_01) {
		this.nowSHORT_2_H_SIGMA_01 = nowSHORT_2_H_SIGMA_01;
	}

	public double getNowSHORT_2_H_SIGMA_02() {
		return nowSHORT_2_H_SIGMA_02;
	}

	public void setNowSHORT_2_H_SIGMA_02(double nowSHORT_2_H_SIGMA_02) {
		this.nowSHORT_2_H_SIGMA_02 = nowSHORT_2_H_SIGMA_02;
	}

	public double getNowSHORT_2_H_SIGMA_03() {
		return nowSHORT_2_H_SIGMA_03;
	}

	public void setNowSHORT_2_H_SIGMA_03(double nowSHORT_2_H_SIGMA_03) {
		this.nowSHORT_2_H_SIGMA_03 = nowSHORT_2_H_SIGMA_03;
	}

	public double getNowSHORT_2_H_SIGMA_04() {
		return nowSHORT_2_H_SIGMA_04;
	}

	public void setNowSHORT_2_H_SIGMA_04(double nowSHORT_2_H_SIGMA_04) {
		this.nowSHORT_2_H_SIGMA_04 = nowSHORT_2_H_SIGMA_04;
	}

	public double getNowSHORT_2_L_SIGMA_01() {
		return nowSHORT_2_L_SIGMA_01;
	}

	public void setNowSHORT_2_L_SIGMA_01(double nowSHORT_2_L_SIGMA_01) {
		this.nowSHORT_2_L_SIGMA_01 = nowSHORT_2_L_SIGMA_01;
	}

	public double getNowSHORT_2_L_SIGMA_02() {
		return nowSHORT_2_L_SIGMA_02;
	}

	public void setNowSHORT_2_L_SIGMA_02(double nowSHORT_2_L_SIGMA_02) {
		this.nowSHORT_2_L_SIGMA_02 = nowSHORT_2_L_SIGMA_02;
	}

	public double getNowSHORT_2_L_SIGMA_03() {
		return nowSHORT_2_L_SIGMA_03;
	}

	public void setNowSHORT_2_L_SIGMA_03(double nowSHORT_2_L_SIGMA_03) {
		this.nowSHORT_2_L_SIGMA_03 = nowSHORT_2_L_SIGMA_03;
	}

	public double getNowSHORT_2_L_SIGMA_04() {
		return nowSHORT_2_L_SIGMA_04;
	}

	public void setNowSHORT_2_L_SIGMA_04(double nowSHORT_2_L_SIGMA_04) {
		this.nowSHORT_2_L_SIGMA_04 = nowSHORT_2_L_SIGMA_04;
	}

	public double getNowSHORT_3_H_SIGMA_01() {
		return nowSHORT_3_H_SIGMA_01;
	}

	public void setNowSHORT_3_H_SIGMA_01(double nowSHORT_3_H_SIGMA_01) {
		this.nowSHORT_3_H_SIGMA_01 = nowSHORT_3_H_SIGMA_01;
	}

	public double getNowSHORT_3_H_SIGMA_02() {
		return nowSHORT_3_H_SIGMA_02;
	}

	public void setNowSHORT_3_H_SIGMA_02(double nowSHORT_3_H_SIGMA_02) {
		this.nowSHORT_3_H_SIGMA_02 = nowSHORT_3_H_SIGMA_02;
	}

	public double getNowSHORT_3_H_SIGMA_03() {
		return nowSHORT_3_H_SIGMA_03;
	}

	public void setNowSHORT_3_H_SIGMA_03(double nowSHORT_3_H_SIGMA_03) {
		this.nowSHORT_3_H_SIGMA_03 = nowSHORT_3_H_SIGMA_03;
	}

	public double getNowSHORT_3_H_SIGMA_04() {
		return nowSHORT_3_H_SIGMA_04;
	}

	public void setNowSHORT_3_H_SIGMA_04(double nowSHORT_3_H_SIGMA_04) {
		this.nowSHORT_3_H_SIGMA_04 = nowSHORT_3_H_SIGMA_04;
	}

	public double getNowSHORT_3_L_SIGMA_01() {
		return nowSHORT_3_L_SIGMA_01;
	}

	public void setNowSHORT_3_L_SIGMA_01(double nowSHORT_3_L_SIGMA_01) {
		this.nowSHORT_3_L_SIGMA_01 = nowSHORT_3_L_SIGMA_01;
	}

	public double getNowSHORT_3_L_SIGMA_02() {
		return nowSHORT_3_L_SIGMA_02;
	}

	public void setNowSHORT_3_L_SIGMA_02(double nowSHORT_3_L_SIGMA_02) {
		this.nowSHORT_3_L_SIGMA_02 = nowSHORT_3_L_SIGMA_02;
	}

	public double getNowSHORT_3_L_SIGMA_03() {
		return nowSHORT_3_L_SIGMA_03;
	}

	public void setNowSHORT_3_L_SIGMA_03(double nowSHORT_3_L_SIGMA_03) {
		this.nowSHORT_3_L_SIGMA_03 = nowSHORT_3_L_SIGMA_03;
	}

	public double getNowSHORT_3_L_SIGMA_04() {
		return nowSHORT_3_L_SIGMA_04;
	}

	public void setNowSHORT_3_L_SIGMA_04(double nowSHORT_3_L_SIGMA_04) {
		this.nowSHORT_3_L_SIGMA_04 = nowSHORT_3_L_SIGMA_04;
	}

	public double getNowMIDDLE_DEV_01() {
		return nowMIDDLE_DEV_01;
	}

	public void setNowMIDDLE_DEV_01(double nowMIDDLE_DEV_01) {
		this.nowMIDDLE_DEV_01 = nowMIDDLE_DEV_01;
	}

	public double getNowMIDDLE_DEV_02() {
		return nowMIDDLE_DEV_02;
	}

	public void setNowMIDDLE_DEV_02(double nowMIDDLE_DEV_02) {
		this.nowMIDDLE_DEV_02 = nowMIDDLE_DEV_02;
	}

	public double getNowMIDDLE_DEV_03() {
		return nowMIDDLE_DEV_03;
	}

	public void setNowMIDDLE_DEV_03(double nowMIDDLE_DEV_03) {
		this.nowMIDDLE_DEV_03 = nowMIDDLE_DEV_03;
	}

	public double getNowMIDDLE_DEV_04() {
		return nowMIDDLE_DEV_04;
	}

	public void setNowMIDDLE_DEV_04(double nowMIDDLE_DEV_04) {
		this.nowMIDDLE_DEV_04 = nowMIDDLE_DEV_04;
	}

	public double getNowMIDDLE_NOW_SIGMA_01() {
		return nowMIDDLE_NOW_SIGMA_01;
	}

	public void setNowMIDDLE_NOW_SIGMA_01(double nowMIDDLE_NOW_SIGMA_01) {
		this.nowMIDDLE_NOW_SIGMA_01 = nowMIDDLE_NOW_SIGMA_01;
	}

	public double getNowMIDDLE_NOW_SIGMA_02() {
		return nowMIDDLE_NOW_SIGMA_02;
	}

	public void setNowMIDDLE_NOW_SIGMA_02(double nowMIDDLE_NOW_SIGMA_02) {
		this.nowMIDDLE_NOW_SIGMA_02 = nowMIDDLE_NOW_SIGMA_02;
	}

	public double getNowMIDDLE_NOW_SIGMA_03() {
		return nowMIDDLE_NOW_SIGMA_03;
	}

	public void setNowMIDDLE_NOW_SIGMA_03(double nowMIDDLE_NOW_SIGMA_03) {
		this.nowMIDDLE_NOW_SIGMA_03 = nowMIDDLE_NOW_SIGMA_03;
	}

	public double getNowMIDDLE_NOW_SIGMA_04() {
		return nowMIDDLE_NOW_SIGMA_04;
	}

	public void setNowMIDDLE_NOW_SIGMA_04(double nowMIDDLE_NOW_SIGMA_04) {
		this.nowMIDDLE_NOW_SIGMA_04 = nowMIDDLE_NOW_SIGMA_04;
	}

	public double getNowMIDDLE_1_H_SIGMA_01() {
		return nowMIDDLE_1_H_SIGMA_01;
	}

	public void setNowMIDDLE_1_H_SIGMA_01(double nowMIDDLE_1_H_SIGMA_01) {
		this.nowMIDDLE_1_H_SIGMA_01 = nowMIDDLE_1_H_SIGMA_01;
	}

	public double getNowMIDDLE_1_H_SIGMA_02() {
		return nowMIDDLE_1_H_SIGMA_02;
	}

	public void setNowMIDDLE_1_H_SIGMA_02(double nowMIDDLE_1_H_SIGMA_02) {
		this.nowMIDDLE_1_H_SIGMA_02 = nowMIDDLE_1_H_SIGMA_02;
	}

	public double getNowMIDDLE_1_H_SIGMA_03() {
		return nowMIDDLE_1_H_SIGMA_03;
	}

	public void setNowMIDDLE_1_H_SIGMA_03(double nowMIDDLE_1_H_SIGMA_03) {
		this.nowMIDDLE_1_H_SIGMA_03 = nowMIDDLE_1_H_SIGMA_03;
	}

	public double getNowMIDDLE_1_H_SIGMA_04() {
		return nowMIDDLE_1_H_SIGMA_04;
	}

	public void setNowMIDDLE_1_H_SIGMA_04(double nowMIDDLE_1_H_SIGMA_04) {
		this.nowMIDDLE_1_H_SIGMA_04 = nowMIDDLE_1_H_SIGMA_04;
	}

	public double getNowMIDDLE_1_L_SIGMA_01() {
		return nowMIDDLE_1_L_SIGMA_01;
	}

	public void setNowMIDDLE_1_L_SIGMA_01(double nowMIDDLE_1_L_SIGMA_01) {
		this.nowMIDDLE_1_L_SIGMA_01 = nowMIDDLE_1_L_SIGMA_01;
	}

	public double getNowMIDDLE_1_L_SIGMA_02() {
		return nowMIDDLE_1_L_SIGMA_02;
	}

	public void setNowMIDDLE_1_L_SIGMA_02(double nowMIDDLE_1_L_SIGMA_02) {
		this.nowMIDDLE_1_L_SIGMA_02 = nowMIDDLE_1_L_SIGMA_02;
	}

	public double getNowMIDDLE_1_L_SIGMA_03() {
		return nowMIDDLE_1_L_SIGMA_03;
	}

	public void setNowMIDDLE_1_L_SIGMA_03(double nowMIDDLE_1_L_SIGMA_03) {
		this.nowMIDDLE_1_L_SIGMA_03 = nowMIDDLE_1_L_SIGMA_03;
	}

	public double getNowMIDDLE_1_L_SIGMA_04() {
		return nowMIDDLE_1_L_SIGMA_04;
	}

	public void setNowMIDDLE_1_L_SIGMA_04(double nowMIDDLE_1_L_SIGMA_04) {
		this.nowMIDDLE_1_L_SIGMA_04 = nowMIDDLE_1_L_SIGMA_04;
	}

	public double getNowMIDDLE_2_H_SIGMA_01() {
		return nowMIDDLE_2_H_SIGMA_01;
	}

	public void setNowMIDDLE_2_H_SIGMA_01(double nowMIDDLE_2_H_SIGMA_01) {
		this.nowMIDDLE_2_H_SIGMA_01 = nowMIDDLE_2_H_SIGMA_01;
	}

	public double getNowMIDDLE_2_H_SIGMA_02() {
		return nowMIDDLE_2_H_SIGMA_02;
	}

	public void setNowMIDDLE_2_H_SIGMA_02(double nowMIDDLE_2_H_SIGMA_02) {
		this.nowMIDDLE_2_H_SIGMA_02 = nowMIDDLE_2_H_SIGMA_02;
	}

	public double getNowMIDDLE_2_H_SIGMA_03() {
		return nowMIDDLE_2_H_SIGMA_03;
	}

	public void setNowMIDDLE_2_H_SIGMA_03(double nowMIDDLE_2_H_SIGMA_03) {
		this.nowMIDDLE_2_H_SIGMA_03 = nowMIDDLE_2_H_SIGMA_03;
	}

	public double getNowMIDDLE_2_H_SIGMA_04() {
		return nowMIDDLE_2_H_SIGMA_04;
	}

	public void setNowMIDDLE_2_H_SIGMA_04(double nowMIDDLE_2_H_SIGMA_04) {
		this.nowMIDDLE_2_H_SIGMA_04 = nowMIDDLE_2_H_SIGMA_04;
	}

	public double getNowMIDDLE_2_L_SIGMA_01() {
		return nowMIDDLE_2_L_SIGMA_01;
	}

	public void setNowMIDDLE_2_L_SIGMA_01(double nowMIDDLE_2_L_SIGMA_01) {
		this.nowMIDDLE_2_L_SIGMA_01 = nowMIDDLE_2_L_SIGMA_01;
	}

	public double getNowMIDDLE_2_L_SIGMA_02() {
		return nowMIDDLE_2_L_SIGMA_02;
	}

	public void setNowMIDDLE_2_L_SIGMA_02(double nowMIDDLE_2_L_SIGMA_02) {
		this.nowMIDDLE_2_L_SIGMA_02 = nowMIDDLE_2_L_SIGMA_02;
	}

	public double getNowMIDDLE_2_L_SIGMA_03() {
		return nowMIDDLE_2_L_SIGMA_03;
	}

	public void setNowMIDDLE_2_L_SIGMA_03(double nowMIDDLE_2_L_SIGMA_03) {
		this.nowMIDDLE_2_L_SIGMA_03 = nowMIDDLE_2_L_SIGMA_03;
	}

	public double getNowMIDDLE_2_L_SIGMA_04() {
		return nowMIDDLE_2_L_SIGMA_04;
	}

	public void setNowMIDDLE_2_L_SIGMA_04(double nowMIDDLE_2_L_SIGMA_04) {
		this.nowMIDDLE_2_L_SIGMA_04 = nowMIDDLE_2_L_SIGMA_04;
	}

	public double getNowMIDDLE_3_H_SIGMA_01() {
		return nowMIDDLE_3_H_SIGMA_01;
	}

	public void setNowMIDDLE_3_H_SIGMA_01(double nowMIDDLE_3_H_SIGMA_01) {
		this.nowMIDDLE_3_H_SIGMA_01 = nowMIDDLE_3_H_SIGMA_01;
	}

	public double getNowMIDDLE_3_H_SIGMA_02() {
		return nowMIDDLE_3_H_SIGMA_02;
	}

	public void setNowMIDDLE_3_H_SIGMA_02(double nowMIDDLE_3_H_SIGMA_02) {
		this.nowMIDDLE_3_H_SIGMA_02 = nowMIDDLE_3_H_SIGMA_02;
	}

	public double getNowMIDDLE_3_H_SIGMA_03() {
		return nowMIDDLE_3_H_SIGMA_03;
	}

	public void setNowMIDDLE_3_H_SIGMA_03(double nowMIDDLE_3_H_SIGMA_03) {
		this.nowMIDDLE_3_H_SIGMA_03 = nowMIDDLE_3_H_SIGMA_03;
	}

	public double getNowMIDDLE_3_H_SIGMA_04() {
		return nowMIDDLE_3_H_SIGMA_04;
	}

	public void setNowMIDDLE_3_H_SIGMA_04(double nowMIDDLE_3_H_SIGMA_04) {
		this.nowMIDDLE_3_H_SIGMA_04 = nowMIDDLE_3_H_SIGMA_04;
	}

	public double getNowMIDDLE_3_L_SIGMA_01() {
		return nowMIDDLE_3_L_SIGMA_01;
	}

	public void setNowMIDDLE_3_L_SIGMA_01(double nowMIDDLE_3_L_SIGMA_01) {
		this.nowMIDDLE_3_L_SIGMA_01 = nowMIDDLE_3_L_SIGMA_01;
	}

	public double getNowMIDDLE_3_L_SIGMA_02() {
		return nowMIDDLE_3_L_SIGMA_02;
	}

	public void setNowMIDDLE_3_L_SIGMA_02(double nowMIDDLE_3_L_SIGMA_02) {
		this.nowMIDDLE_3_L_SIGMA_02 = nowMIDDLE_3_L_SIGMA_02;
	}

	public double getNowMIDDLE_3_L_SIGMA_03() {
		return nowMIDDLE_3_L_SIGMA_03;
	}

	public void setNowMIDDLE_3_L_SIGMA_03(double nowMIDDLE_3_L_SIGMA_03) {
		this.nowMIDDLE_3_L_SIGMA_03 = nowMIDDLE_3_L_SIGMA_03;
	}

	public double getNowMIDDLE_3_L_SIGMA_04() {
		return nowMIDDLE_3_L_SIGMA_04;
	}

	public void setNowMIDDLE_3_L_SIGMA_04(double nowMIDDLE_3_L_SIGMA_04) {
		this.nowMIDDLE_3_L_SIGMA_04 = nowMIDDLE_3_L_SIGMA_04;
	}

	public double getNowLONG_DEV_01() {
		return nowLONG_DEV_01;
	}

	public void setNowLONG_DEV_01(double nowLONG_DEV_01) {
		this.nowLONG_DEV_01 = nowLONG_DEV_01;
	}

	public double getNowLONG_DEV_02() {
		return nowLONG_DEV_02;
	}

	public void setNowLONG_DEV_02(double nowLONG_DEV_02) {
		this.nowLONG_DEV_02 = nowLONG_DEV_02;
	}

	public double getNowLONG_DEV_03() {
		return nowLONG_DEV_03;
	}

	public void setNowLONG_DEV_03(double nowLONG_DEV_03) {
		this.nowLONG_DEV_03 = nowLONG_DEV_03;
	}

	public double getNowLONG_DEV_04() {
		return nowLONG_DEV_04;
	}

	public void setNowLONG_DEV_04(double nowLONG_DEV_04) {
		this.nowLONG_DEV_04 = nowLONG_DEV_04;
	}

	public double getNowLONG_NOW_SIGMA_01() {
		return nowLONG_NOW_SIGMA_01;
	}

	public void setNowLONG_NOW_SIGMA_01(double nowLONG_NOW_SIGMA_01) {
		this.nowLONG_NOW_SIGMA_01 = nowLONG_NOW_SIGMA_01;
	}

	public double getNowLONG_NOW_SIGMA_02() {
		return nowLONG_NOW_SIGMA_02;
	}

	public void setNowLONG_NOW_SIGMA_02(double nowLONG_NOW_SIGMA_02) {
		this.nowLONG_NOW_SIGMA_02 = nowLONG_NOW_SIGMA_02;
	}

	public double getNowLONG_NOW_SIGMA_03() {
		return nowLONG_NOW_SIGMA_03;
	}

	public void setNowLONG_NOW_SIGMA_03(double nowLONG_NOW_SIGMA_03) {
		this.nowLONG_NOW_SIGMA_03 = nowLONG_NOW_SIGMA_03;
	}

	public double getNowLONG_NOW_SIGMA_04() {
		return nowLONG_NOW_SIGMA_04;
	}

	public void setNowLONG_NOW_SIGMA_04(double nowLONG_NOW_SIGMA_04) {
		this.nowLONG_NOW_SIGMA_04 = nowLONG_NOW_SIGMA_04;
	}

	public double getNowLONG_1_H_SIGMA_01() {
		return nowLONG_1_H_SIGMA_01;
	}

	public void setNowLONG_1_H_SIGMA_01(double nowLONG_1_H_SIGMA_01) {
		this.nowLONG_1_H_SIGMA_01 = nowLONG_1_H_SIGMA_01;
	}

	public double getNowLONG_1_H_SIGMA_02() {
		return nowLONG_1_H_SIGMA_02;
	}

	public void setNowLONG_1_H_SIGMA_02(double nowLONG_1_H_SIGMA_02) {
		this.nowLONG_1_H_SIGMA_02 = nowLONG_1_H_SIGMA_02;
	}

	public double getNowLONG_1_H_SIGMA_03() {
		return nowLONG_1_H_SIGMA_03;
	}

	public void setNowLONG_1_H_SIGMA_03(double nowLONG_1_H_SIGMA_03) {
		this.nowLONG_1_H_SIGMA_03 = nowLONG_1_H_SIGMA_03;
	}

	public double getNowLONG_1_H_SIGMA_04() {
		return nowLONG_1_H_SIGMA_04;
	}

	public void setNowLONG_1_H_SIGMA_04(double nowLONG_1_H_SIGMA_04) {
		this.nowLONG_1_H_SIGMA_04 = nowLONG_1_H_SIGMA_04;
	}

	public double getNowLONG_1_L_SIGMA_01() {
		return nowLONG_1_L_SIGMA_01;
	}

	public void setNowLONG_1_L_SIGMA_01(double nowLONG_1_L_SIGMA_01) {
		this.nowLONG_1_L_SIGMA_01 = nowLONG_1_L_SIGMA_01;
	}

	public double getNowLONG_1_L_SIGMA_02() {
		return nowLONG_1_L_SIGMA_02;
	}

	public void setNowLONG_1_L_SIGMA_02(double nowLONG_1_L_SIGMA_02) {
		this.nowLONG_1_L_SIGMA_02 = nowLONG_1_L_SIGMA_02;
	}

	public double getNowLONG_1_L_SIGMA_03() {
		return nowLONG_1_L_SIGMA_03;
	}

	public void setNowLONG_1_L_SIGMA_03(double nowLONG_1_L_SIGMA_03) {
		this.nowLONG_1_L_SIGMA_03 = nowLONG_1_L_SIGMA_03;
	}

	public double getNowLONG_1_L_SIGMA_04() {
		return nowLONG_1_L_SIGMA_04;
	}

	public void setNowLONG_1_L_SIGMA_04(double nowLONG_1_L_SIGMA_04) {
		this.nowLONG_1_L_SIGMA_04 = nowLONG_1_L_SIGMA_04;
	}

	public double getNowLONG_2_H_SIGMA_01() {
		return nowLONG_2_H_SIGMA_01;
	}

	public void setNowLONG_2_H_SIGMA_01(double nowLONG_2_H_SIGMA_01) {
		this.nowLONG_2_H_SIGMA_01 = nowLONG_2_H_SIGMA_01;
	}

	public double getNowLONG_2_H_SIGMA_02() {
		return nowLONG_2_H_SIGMA_02;
	}

	public void setNowLONG_2_H_SIGMA_02(double nowLONG_2_H_SIGMA_02) {
		this.nowLONG_2_H_SIGMA_02 = nowLONG_2_H_SIGMA_02;
	}

	public double getNowLONG_2_H_SIGMA_03() {
		return nowLONG_2_H_SIGMA_03;
	}

	public void setNowLONG_2_H_SIGMA_03(double nowLONG_2_H_SIGMA_03) {
		this.nowLONG_2_H_SIGMA_03 = nowLONG_2_H_SIGMA_03;
	}

	public double getNowLONG_2_H_SIGMA_04() {
		return nowLONG_2_H_SIGMA_04;
	}

	public void setNowLONG_2_H_SIGMA_04(double nowLONG_2_H_SIGMA_04) {
		this.nowLONG_2_H_SIGMA_04 = nowLONG_2_H_SIGMA_04;
	}

	public double getNowLONG_2_L_SIGMA_01() {
		return nowLONG_2_L_SIGMA_01;
	}

	public void setNowLONG_2_L_SIGMA_01(double nowLONG_2_L_SIGMA_01) {
		this.nowLONG_2_L_SIGMA_01 = nowLONG_2_L_SIGMA_01;
	}

	public double getNowLONG_2_L_SIGMA_02() {
		return nowLONG_2_L_SIGMA_02;
	}

	public void setNowLONG_2_L_SIGMA_02(double nowLONG_2_L_SIGMA_02) {
		this.nowLONG_2_L_SIGMA_02 = nowLONG_2_L_SIGMA_02;
	}

	public double getNowLONG_2_L_SIGMA_03() {
		return nowLONG_2_L_SIGMA_03;
	}

	public void setNowLONG_2_L_SIGMA_03(double nowLONG_2_L_SIGMA_03) {
		this.nowLONG_2_L_SIGMA_03 = nowLONG_2_L_SIGMA_03;
	}

	public double getNowLONG_2_L_SIGMA_04() {
		return nowLONG_2_L_SIGMA_04;
	}

	public void setNowLONG_2_L_SIGMA_04(double nowLONG_2_L_SIGMA_04) {
		this.nowLONG_2_L_SIGMA_04 = nowLONG_2_L_SIGMA_04;
	}

	public double getNowLONG_3_H_SIGMA_01() {
		return nowLONG_3_H_SIGMA_01;
	}

	public void setNowLONG_3_H_SIGMA_01(double nowLONG_3_H_SIGMA_01) {
		this.nowLONG_3_H_SIGMA_01 = nowLONG_3_H_SIGMA_01;
	}

	public double getNowLONG_3_H_SIGMA_02() {
		return nowLONG_3_H_SIGMA_02;
	}

	public void setNowLONG_3_H_SIGMA_02(double nowLONG_3_H_SIGMA_02) {
		this.nowLONG_3_H_SIGMA_02 = nowLONG_3_H_SIGMA_02;
	}

	public double getNowLONG_3_H_SIGMA_03() {
		return nowLONG_3_H_SIGMA_03;
	}

	public void setNowLONG_3_H_SIGMA_03(double nowLONG_3_H_SIGMA_03) {
		this.nowLONG_3_H_SIGMA_03 = nowLONG_3_H_SIGMA_03;
	}

	public double getNowLONG_3_H_SIGMA_04() {
		return nowLONG_3_H_SIGMA_04;
	}

	public void setNowLONG_3_H_SIGMA_04(double nowLONG_3_H_SIGMA_04) {
		this.nowLONG_3_H_SIGMA_04 = nowLONG_3_H_SIGMA_04;
	}

	public double getNowLONG_3_L_SIGMA_01() {
		return nowLONG_3_L_SIGMA_01;
	}

	public void setNowLONG_3_L_SIGMA_01(double nowLONG_3_L_SIGMA_01) {
		this.nowLONG_3_L_SIGMA_01 = nowLONG_3_L_SIGMA_01;
	}

	public double getNowLONG_3_L_SIGMA_02() {
		return nowLONG_3_L_SIGMA_02;
	}

	public void setNowLONG_3_L_SIGMA_02(double nowLONG_3_L_SIGMA_02) {
		this.nowLONG_3_L_SIGMA_02 = nowLONG_3_L_SIGMA_02;
	}

	public double getNowLONG_3_L_SIGMA_03() {
		return nowLONG_3_L_SIGMA_03;
	}

	public void setNowLONG_3_L_SIGMA_03(double nowLONG_3_L_SIGMA_03) {
		this.nowLONG_3_L_SIGMA_03 = nowLONG_3_L_SIGMA_03;
	}

	public double getNowLONG_3_L_SIGMA_04() {
		return nowLONG_3_L_SIGMA_04;
	}

	public void setNowLONG_3_L_SIGMA_04(double nowLONG_3_L_SIGMA_04) {
		this.nowLONG_3_L_SIGMA_04 = nowLONG_3_L_SIGMA_04;
	}

	public double getNowSHORTIDO_HEKATU_01() {
		return nowSHORTIDO_HEKATU_01;
	}

	public void setNowSHORTIDO_HEKATU_01(double nowSHORTIDO_HEKATU_01) {
		this.nowSHORTIDO_HEKATU_01 = nowSHORTIDO_HEKATU_01;
	}

	public double getNowSHORTIDO_HEKATU_02() {
		return nowSHORTIDO_HEKATU_02;
	}

	public void setNowSHORTIDO_HEKATU_02(double nowSHORTIDO_HEKATU_02) {
		this.nowSHORTIDO_HEKATU_02 = nowSHORTIDO_HEKATU_02;
	}

	public double getNowSHORTIDO_HEKATU_03() {
		return nowSHORTIDO_HEKATU_03;
	}

	public void setNowSHORTIDO_HEKATU_03(double nowSHORTIDO_HEKATU_03) {
		this.nowSHORTIDO_HEKATU_03 = nowSHORTIDO_HEKATU_03;
	}

	public double getNowSHORTIDO_HEKATU_04() {
		return nowSHORTIDO_HEKATU_04;
	}

	public void setNowSHORTIDO_HEKATU_04(double nowSHORTIDO_HEKATU_04) {
		this.nowSHORTIDO_HEKATU_04 = nowSHORTIDO_HEKATU_04;
	}

	public double getNowMIDDLEIDO_HEKATU_01() {
		return nowMIDDLEIDO_HEKATU_01;
	}

	public void setNowMIDDLEIDO_HEKATU_01(double nowMIDDLEIDO_HEKATU_01) {
		this.nowMIDDLEIDO_HEKATU_01 = nowMIDDLEIDO_HEKATU_01;
	}

	public double getNowMIDDLEIDO_HEKATU_02() {
		return nowMIDDLEIDO_HEKATU_02;
	}

	public void setNowMIDDLEIDO_HEKATU_02(double nowMIDDLEIDO_HEKATU_02) {
		this.nowMIDDLEIDO_HEKATU_02 = nowMIDDLEIDO_HEKATU_02;
	}

	public double getNowMIDDLEIDO_HEKATU_03() {
		return nowMIDDLEIDO_HEKATU_03;
	}

	public void setNowMIDDLEIDO_HEKATU_03(double nowMIDDLEIDO_HEKATU_03) {
		this.nowMIDDLEIDO_HEKATU_03 = nowMIDDLEIDO_HEKATU_03;
	}

	public double getNowMIDDLEIDO_HEKATU_04() {
		return nowMIDDLEIDO_HEKATU_04;
	}

	public void setNowMIDDLEIDO_HEKATU_04(double nowMIDDLEIDO_HEKATU_04) {
		this.nowMIDDLEIDO_HEKATU_04 = nowMIDDLEIDO_HEKATU_04;
	}

	public double getNowLONGIDO_HEKATU_01() {
		return nowLONGIDO_HEKATU_01;
	}

	public void setNowLONGIDO_HEKATU_01(double nowLONGIDO_HEKATU_01) {
		this.nowLONGIDO_HEKATU_01 = nowLONGIDO_HEKATU_01;
	}

	public double getNowLONGIDO_HEKATU_02() {
		return nowLONGIDO_HEKATU_02;
	}

	public void setNowLONGIDO_HEKATU_02(double nowLONGIDO_HEKATU_02) {
		this.nowLONGIDO_HEKATU_02 = nowLONGIDO_HEKATU_02;
	}

	public double getNowLONGIDO_HEKATU_03() {
		return nowLONGIDO_HEKATU_03;
	}

	public void setNowLONGIDO_HEKATU_03(double nowLONGIDO_HEKATU_03) {
		this.nowLONGIDO_HEKATU_03 = nowLONGIDO_HEKATU_03;
	}

	public double getNowLONGIDO_HEKATU_04() {
		return nowLONGIDO_HEKATU_04;
	}

	public void setNowLONGIDO_HEKATU_04(double nowLONGIDO_HEKATU_04) {
		this.nowLONGIDO_HEKATU_04 = nowLONGIDO_HEKATU_04;
	}

	public double getNowSHORTIDO_HEKATU_CHANGERATE_01() {
		return nowSHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNowSHORTIDO_HEKATU_CHANGERATE_01(
			double nowSHORTIDO_HEKATU_CHANGERATE_01) {
		this.nowSHORTIDO_HEKATU_CHANGERATE_01 = nowSHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNowSHORTIDO_HEKATU_CHANGERATE_02() {
		return nowSHORTIDO_HEKATU_CHANGERATE_02;
	}

	public void setNowSHORTIDO_HEKATU_CHANGERATE_02(
			double nowSHORTIDO_HEKATU_CHANGERATE_02) {
		this.nowSHORTIDO_HEKATU_CHANGERATE_02 = nowSHORTIDO_HEKATU_CHANGERATE_02;
	}

	public double getNowSHORTIDO_HEKATU_CHANGERATE_03() {
		return nowSHORTIDO_HEKATU_CHANGERATE_03;
	}

	public void setNowSHORTIDO_HEKATU_CHANGERATE_03(
			double nowSHORTIDO_HEKATU_CHANGERATE_03) {
		this.nowSHORTIDO_HEKATU_CHANGERATE_03 = nowSHORTIDO_HEKATU_CHANGERATE_03;
	}

	public double getNowSHORTIDO_HEKATU_CHANGERATE_04() {
		return nowSHORTIDO_HEKATU_CHANGERATE_04;
	}

	public void setNowSHORTIDO_HEKATU_CHANGERATE_04(
			double nowSHORTIDO_HEKATU_CHANGERATE_04) {
		this.nowSHORTIDO_HEKATU_CHANGERATE_04 = nowSHORTIDO_HEKATU_CHANGERATE_04;
	}

	public double getNowMIDDLEIDO_HEKATU_CHANGERATE_01() {
		return nowMIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNowMIDDLEIDO_HEKATU_CHANGERATE_01(
			double nowMIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.nowMIDDLEIDO_HEKATU_CHANGERATE_01 = nowMIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNowMIDDLEIDO_HEKATU_CHANGERATE_02() {
		return nowMIDDLEIDO_HEKATU_CHANGERATE_02;
	}

	public void setNowMIDDLEIDO_HEKATU_CHANGERATE_02(
			double nowMIDDLEIDO_HEKATU_CHANGERATE_02) {
		this.nowMIDDLEIDO_HEKATU_CHANGERATE_02 = nowMIDDLEIDO_HEKATU_CHANGERATE_02;
	}

	public double getNowMIDDLEIDO_HEKATU_CHANGERATE_03() {
		return nowMIDDLEIDO_HEKATU_CHANGERATE_03;
	}

	public void setNowMIDDLEIDO_HEKATU_CHANGERATE_03(
			double nowMIDDLEIDO_HEKATU_CHANGERATE_03) {
		this.nowMIDDLEIDO_HEKATU_CHANGERATE_03 = nowMIDDLEIDO_HEKATU_CHANGERATE_03;
	}

	public double getNowMIDDLEIDO_HEKATU_CHANGERATE_04() {
		return nowMIDDLEIDO_HEKATU_CHANGERATE_04;
	}

	public void setNowMIDDLEIDO_HEKATU_CHANGERATE_04(
			double nowMIDDLEIDO_HEKATU_CHANGERATE_04) {
		this.nowMIDDLEIDO_HEKATU_CHANGERATE_04 = nowMIDDLEIDO_HEKATU_CHANGERATE_04;
	}

	public double getNowLONGIDO_HEKATU_CHANGERATE_01() {
		return nowLONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNowLONGIDO_HEKATU_CHANGERATE_01(
			double nowLONGIDO_HEKATU_CHANGERATE_01) {
		this.nowLONGIDO_HEKATU_CHANGERATE_01 = nowLONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNowLONGIDO_HEKATU_CHANGERATE_02() {
		return nowLONGIDO_HEKATU_CHANGERATE_02;
	}

	public void setNowLONGIDO_HEKATU_CHANGERATE_02(
			double nowLONGIDO_HEKATU_CHANGERATE_02) {
		this.nowLONGIDO_HEKATU_CHANGERATE_02 = nowLONGIDO_HEKATU_CHANGERATE_02;
	}

	public double getNowLONGIDO_HEKATU_CHANGERATE_03() {
		return nowLONGIDO_HEKATU_CHANGERATE_03;
	}

	public void setNowLONGIDO_HEKATU_CHANGERATE_03(
			double nowLONGIDO_HEKATU_CHANGERATE_03) {
		this.nowLONGIDO_HEKATU_CHANGERATE_03 = nowLONGIDO_HEKATU_CHANGERATE_03;
	}

	public double getNowLONGIDO_HEKATU_CHANGERATE_04() {
		return nowLONGIDO_HEKATU_CHANGERATE_04;
	}

	public void setNowLONGIDO_HEKATU_CHANGERATE_04(
			double nowLONGIDO_HEKATU_CHANGERATE_04) {
		this.nowLONGIDO_HEKATU_CHANGERATE_04 = nowLONGIDO_HEKATU_CHANGERATE_04;
	}

	public double getNowSHORTIDO_HEKATU_RATIO_01() {
		return nowSHORTIDO_HEKATU_RATIO_01;
	}

	public void setNowSHORTIDO_HEKATU_RATIO_01(double nowSHORTIDO_HEKATU_RATIO_01) {
		this.nowSHORTIDO_HEKATU_RATIO_01 = nowSHORTIDO_HEKATU_RATIO_01;
	}

	public double getNowSHORTIDO_HEKATU_RATIO_02() {
		return nowSHORTIDO_HEKATU_RATIO_02;
	}

	public void setNowSHORTIDO_HEKATU_RATIO_02(double nowSHORTIDO_HEKATU_RATIO_02) {
		this.nowSHORTIDO_HEKATU_RATIO_02 = nowSHORTIDO_HEKATU_RATIO_02;
	}

	public double getNowSHORTIDO_HEKATU_RATIO_03() {
		return nowSHORTIDO_HEKATU_RATIO_03;
	}

	public void setNowSHORTIDO_HEKATU_RATIO_03(double nowSHORTIDO_HEKATU_RATIO_03) {
		this.nowSHORTIDO_HEKATU_RATIO_03 = nowSHORTIDO_HEKATU_RATIO_03;
	}

	public double getNowSHORTIDO_HEKATU_RATIO_04() {
		return nowSHORTIDO_HEKATU_RATIO_04;
	}

	public void setNowSHORTIDO_HEKATU_RATIO_04(double nowSHORTIDO_HEKATU_RATIO_04) {
		this.nowSHORTIDO_HEKATU_RATIO_04 = nowSHORTIDO_HEKATU_RATIO_04;
	}

	public double getNowMIDDLEIDO_HEKATU_RATIO_01() {
		return nowMIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNowMIDDLEIDO_HEKATU_RATIO_01(double nowMIDDLEIDO_HEKATU_RATIO_01) {
		this.nowMIDDLEIDO_HEKATU_RATIO_01 = nowMIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNowMIDDLEIDO_HEKATU_RATIO_02() {
		return nowMIDDLEIDO_HEKATU_RATIO_02;
	}

	public void setNowMIDDLEIDO_HEKATU_RATIO_02(double nowMIDDLEIDO_HEKATU_RATIO_02) {
		this.nowMIDDLEIDO_HEKATU_RATIO_02 = nowMIDDLEIDO_HEKATU_RATIO_02;
	}

	public double getNowMIDDLEIDO_HEKATU_RATIO_03() {
		return nowMIDDLEIDO_HEKATU_RATIO_03;
	}

	public void setNowMIDDLEIDO_HEKATU_RATIO_03(double nowMIDDLEIDO_HEKATU_RATIO_03) {
		this.nowMIDDLEIDO_HEKATU_RATIO_03 = nowMIDDLEIDO_HEKATU_RATIO_03;
	}

	public double getNowMIDDLEIDO_HEKATU_RATIO_04() {
		return nowMIDDLEIDO_HEKATU_RATIO_04;
	}

	public void setNowMIDDLEIDO_HEKATU_RATIO_04(double nowMIDDLEIDO_HEKATU_RATIO_04) {
		this.nowMIDDLEIDO_HEKATU_RATIO_04 = nowMIDDLEIDO_HEKATU_RATIO_04;
	}

	public double getNowLONGIDO_HEKATU_RATIO_01() {
		return nowLONGIDO_HEKATU_RATIO_01;
	}

	public void setNowLONGIDO_HEKATU_RATIO_01(double nowLONGIDO_HEKATU_RATIO_01) {
		this.nowLONGIDO_HEKATU_RATIO_01 = nowLONGIDO_HEKATU_RATIO_01;
	}

	public double getNowLONGIDO_HEKATU_RATIO_02() {
		return nowLONGIDO_HEKATU_RATIO_02;
	}

	public void setNowLONGIDO_HEKATU_RATIO_02(double nowLONGIDO_HEKATU_RATIO_02) {
		this.nowLONGIDO_HEKATU_RATIO_02 = nowLONGIDO_HEKATU_RATIO_02;
	}

	public double getNowLONGIDO_HEKATU_RATIO_03() {
		return nowLONGIDO_HEKATU_RATIO_03;
	}

	public void setNowLONGIDO_HEKATU_RATIO_03(double nowLONGIDO_HEKATU_RATIO_03) {
		this.nowLONGIDO_HEKATU_RATIO_03 = nowLONGIDO_HEKATU_RATIO_03;
	}

	public double getNowLONGIDO_HEKATU_RATIO_04() {
		return nowLONGIDO_HEKATU_RATIO_04;
	}

	public void setNowLONGIDO_HEKATU_RATIO_04(double nowLONGIDO_HEKATU_RATIO_04) {
		this.nowLONGIDO_HEKATU_RATIO_04 = nowLONGIDO_HEKATU_RATIO_04;
	}

	public double getNowSHORT_MACD_01() {
		return nowSHORT_MACD_01;
	}

	public void setNowSHORT_MACD_01(double nowSHORT_MACD_01) {
		this.nowSHORT_MACD_01 = nowSHORT_MACD_01;
	}

	public double getNowSHORT_MACD_02() {
		return nowSHORT_MACD_02;
	}

	public void setNowSHORT_MACD_02(double nowSHORT_MACD_02) {
		this.nowSHORT_MACD_02 = nowSHORT_MACD_02;
	}

	public double getNowSHORT_MACD_03() {
		return nowSHORT_MACD_03;
	}

	public void setNowSHORT_MACD_03(double nowSHORT_MACD_03) {
		this.nowSHORT_MACD_03 = nowSHORT_MACD_03;
	}

	public double getNowSHORT_MACD_04() {
		return nowSHORT_MACD_04;
	}

	public void setNowSHORT_MACD_04(double nowSHORT_MACD_04) {
		this.nowSHORT_MACD_04 = nowSHORT_MACD_04;
	}

	public double getNowSHORT_MACD_SIGNAL_01() {
		return nowSHORT_MACD_SIGNAL_01;
	}

	public void setNowSHORT_MACD_SIGNAL_01(double nowSHORT_MACD_SIGNAL_01) {
		this.nowSHORT_MACD_SIGNAL_01 = nowSHORT_MACD_SIGNAL_01;
	}

	public double getNowSHORT_MACD_SIGNAL_02() {
		return nowSHORT_MACD_SIGNAL_02;
	}

	public void setNowSHORT_MACD_SIGNAL_02(double nowSHORT_MACD_SIGNAL_02) {
		this.nowSHORT_MACD_SIGNAL_02 = nowSHORT_MACD_SIGNAL_02;
	}

	public double getNowSHORT_MACD_SIGNAL_03() {
		return nowSHORT_MACD_SIGNAL_03;
	}

	public void setNowSHORT_MACD_SIGNAL_03(double nowSHORT_MACD_SIGNAL_03) {
		this.nowSHORT_MACD_SIGNAL_03 = nowSHORT_MACD_SIGNAL_03;
	}

	public double getNowSHORT_MACD_SIGNAL_04() {
		return nowSHORT_MACD_SIGNAL_04;
	}

	public void setNowSHORT_MACD_SIGNAL_04(double nowSHORT_MACD_SIGNAL_04) {
		this.nowSHORT_MACD_SIGNAL_04 = nowSHORT_MACD_SIGNAL_04;
	}

	public double getNowMIDDLE_MACD_01() {
		return nowMIDDLE_MACD_01;
	}

	public void setNowMIDDLE_MACD_01(double nowMIDDLE_MACD_01) {
		this.nowMIDDLE_MACD_01 = nowMIDDLE_MACD_01;
	}

	public double getNowMIDDLE_MACD_02() {
		return nowMIDDLE_MACD_02;
	}

	public void setNowMIDDLE_MACD_02(double nowMIDDLE_MACD_02) {
		this.nowMIDDLE_MACD_02 = nowMIDDLE_MACD_02;
	}

	public double getNowMIDDLE_MACD_03() {
		return nowMIDDLE_MACD_03;
	}

	public void setNowMIDDLE_MACD_03(double nowMIDDLE_MACD_03) {
		this.nowMIDDLE_MACD_03 = nowMIDDLE_MACD_03;
	}

	public double getNowMIDDLE_MACD_04() {
		return nowMIDDLE_MACD_04;
	}

	public void setNowMIDDLE_MACD_04(double nowMIDDLE_MACD_04) {
		this.nowMIDDLE_MACD_04 = nowMIDDLE_MACD_04;
	}

	public double getNowMIDDLE_MACD_SIGNAL_01() {
		return nowMIDDLE_MACD_SIGNAL_01;
	}

	public void setNowMIDDLE_MACD_SIGNAL_01(double nowMIDDLE_MACD_SIGNAL_01) {
		this.nowMIDDLE_MACD_SIGNAL_01 = nowMIDDLE_MACD_SIGNAL_01;
	}

	public double getNowMIDDLE_MACD_SIGNAL_02() {
		return nowMIDDLE_MACD_SIGNAL_02;
	}

	public void setNowMIDDLE_MACD_SIGNAL_02(double nowMIDDLE_MACD_SIGNAL_02) {
		this.nowMIDDLE_MACD_SIGNAL_02 = nowMIDDLE_MACD_SIGNAL_02;
	}

	public double getNowMIDDLE_MACD_SIGNAL_03() {
		return nowMIDDLE_MACD_SIGNAL_03;
	}

	public void setNowMIDDLE_MACD_SIGNAL_03(double nowMIDDLE_MACD_SIGNAL_03) {
		this.nowMIDDLE_MACD_SIGNAL_03 = nowMIDDLE_MACD_SIGNAL_03;
	}

	public double getNowMIDDLE_MACD_SIGNAL_04() {
		return nowMIDDLE_MACD_SIGNAL_04;
	}

	public void setNowMIDDLE_MACD_SIGNAL_04(double nowMIDDLE_MACD_SIGNAL_04) {
		this.nowMIDDLE_MACD_SIGNAL_04 = nowMIDDLE_MACD_SIGNAL_04;
	}

	public double getNowLONG_MACD_01() {
		return nowLONG_MACD_01;
	}

	public void setNowLONG_MACD_01(double nowLONG_MACD_01) {
		this.nowLONG_MACD_01 = nowLONG_MACD_01;
	}

	public double getNowLONG_MACD_02() {
		return nowLONG_MACD_02;
	}

	public void setNowLONG_MACD_02(double nowLONG_MACD_02) {
		this.nowLONG_MACD_02 = nowLONG_MACD_02;
	}

	public double getNowLONG_MACD_03() {
		return nowLONG_MACD_03;
	}

	public void setNowLONG_MACD_03(double nowLONG_MACD_03) {
		this.nowLONG_MACD_03 = nowLONG_MACD_03;
	}

	public double getNowLONG_MACD_04() {
		return nowLONG_MACD_04;
	}

	public void setNowLONG_MACD_04(double nowLONG_MACD_04) {
		this.nowLONG_MACD_04 = nowLONG_MACD_04;
	}

	public double getNowLONG_MACD_SIGNAL_01() {
		return nowLONG_MACD_SIGNAL_01;
	}

	public void setNowLONG_MACD_SIGNAL_01(double nowLONG_MACD_SIGNAL_01) {
		this.nowLONG_MACD_SIGNAL_01 = nowLONG_MACD_SIGNAL_01;
	}

	public double getNowLONG_MACD_SIGNAL_02() {
		return nowLONG_MACD_SIGNAL_02;
	}

	public void setNowLONG_MACD_SIGNAL_02(double nowLONG_MACD_SIGNAL_02) {
		this.nowLONG_MACD_SIGNAL_02 = nowLONG_MACD_SIGNAL_02;
	}

	public double getNowLONG_MACD_SIGNAL_03() {
		return nowLONG_MACD_SIGNAL_03;
	}

	public void setNowLONG_MACD_SIGNAL_03(double nowLONG_MACD_SIGNAL_03) {
		this.nowLONG_MACD_SIGNAL_03 = nowLONG_MACD_SIGNAL_03;
	}

	public double getNowLONG_MACD_SIGNAL_04() {
		return nowLONG_MACD_SIGNAL_04;
	}

	public void setNowLONG_MACD_SIGNAL_04(double nowLONG_MACD_SIGNAL_04) {
		this.nowLONG_MACD_SIGNAL_04 = nowLONG_MACD_SIGNAL_04;
	}

	public double getNowSTOCK_NAME_NUM_01() {
		return nowSTOCK_NAME_NUM_01;
	}

	public void setNowSTOCK_NAME_NUM_01(double nowSTOCK_NAME_NUM_01) {
		this.nowSTOCK_NAME_NUM_01 = nowSTOCK_NAME_NUM_01;
	}

	public double getNowSTOCK_NAME_NUM_02() {
		return nowSTOCK_NAME_NUM_02;
	}

	public void setNowSTOCK_NAME_NUM_02(double nowSTOCK_NAME_NUM_02) {
		this.nowSTOCK_NAME_NUM_02 = nowSTOCK_NAME_NUM_02;
	}

	public double getNowSTOCK_NAME_NUM_03() {
		return nowSTOCK_NAME_NUM_03;
	}

	public void setNowSTOCK_NAME_NUM_03(double nowSTOCK_NAME_NUM_03) {
		this.nowSTOCK_NAME_NUM_03 = nowSTOCK_NAME_NUM_03;
	}

	public double getNowSTOCK_NAME_NUM_04() {
		return nowSTOCK_NAME_NUM_04;
	}

	public void setNowSTOCK_NAME_NUM_04(double nowSTOCK_NAME_NUM_04) {
		this.nowSTOCK_NAME_NUM_04 = nowSTOCK_NAME_NUM_04;
	}

	public double getNowSTOCK_NOCOMPARE_01() {
		return nowSTOCK_NOCOMPARE_01;
	}

	public void setNowSTOCK_NOCOMPARE_01(double nowSTOCK_NOCOMPARE_01) {
		this.nowSTOCK_NOCOMPARE_01 = nowSTOCK_NOCOMPARE_01;
	}

	public double getNowSTOCK_NOCOMPARE_02() {
		return nowSTOCK_NOCOMPARE_02;
	}

	public void setNowSTOCK_NOCOMPARE_02(double nowSTOCK_NOCOMPARE_02) {
		this.nowSTOCK_NOCOMPARE_02 = nowSTOCK_NOCOMPARE_02;
	}

	public double getNowSTOCK_NOCOMPARE_03() {
		return nowSTOCK_NOCOMPARE_03;
	}

	public void setNowSTOCK_NOCOMPARE_03(double nowSTOCK_NOCOMPARE_03) {
		this.nowSTOCK_NOCOMPARE_03 = nowSTOCK_NOCOMPARE_03;
	}

	public double getNowSTOCK_NOCOMPARE_04() {
		return nowSTOCK_NOCOMPARE_04;
	}

	public void setNowSTOCK_NOCOMPARE_04(double nowSTOCK_NOCOMPARE_04) {
		this.nowSTOCK_NOCOMPARE_04 = nowSTOCK_NOCOMPARE_04;
	}

	public double getNowSTOCK_DOWNSTOCK_01() {
		return nowSTOCK_DOWNSTOCK_01;
	}

	public void setNowSTOCK_DOWNSTOCK_01(double nowSTOCK_DOWNSTOCK_01) {
		this.nowSTOCK_DOWNSTOCK_01 = nowSTOCK_DOWNSTOCK_01;
	}

	public double getNowSTOCK_DOWNSTOCK_02() {
		return nowSTOCK_DOWNSTOCK_02;
	}

	public void setNowSTOCK_DOWNSTOCK_02(double nowSTOCK_DOWNSTOCK_02) {
		this.nowSTOCK_DOWNSTOCK_02 = nowSTOCK_DOWNSTOCK_02;
	}

	public double getNowSTOCK_DOWNSTOCK_03() {
		return nowSTOCK_DOWNSTOCK_03;
	}

	public void setNowSTOCK_DOWNSTOCK_03(double nowSTOCK_DOWNSTOCK_03) {
		this.nowSTOCK_DOWNSTOCK_03 = nowSTOCK_DOWNSTOCK_03;
	}

	public double getNowSTOCK_DOWNSTOCK_04() {
		return nowSTOCK_DOWNSTOCK_04;
	}

	public void setNowSTOCK_DOWNSTOCK_04(double nowSTOCK_DOWNSTOCK_04) {
		this.nowSTOCK_DOWNSTOCK_04 = nowSTOCK_DOWNSTOCK_04;
	}

	public double getNowNETUKI_MAXMIN_01() {
		return nowNETUKI_MAXMIN_01;
	}

	public void setNowNETUKI_MAXMIN_01(double nowNETUKI_MAXMIN_01) {
		this.nowNETUKI_MAXMIN_01 = nowNETUKI_MAXMIN_01;
	}

	public double getNowNETUKI_MAXMIN_02() {
		return nowNETUKI_MAXMIN_02;
	}

	public void setNowNETUKI_MAXMIN_02(double nowNETUKI_MAXMIN_02) {
		this.nowNETUKI_MAXMIN_02 = nowNETUKI_MAXMIN_02;
	}

	public double getNowNETUKI_MAXMIN_03() {
		return nowNETUKI_MAXMIN_03;
	}

	public void setNowNETUKI_MAXMIN_03(double nowNETUKI_MAXMIN_03) {
		this.nowNETUKI_MAXMIN_03 = nowNETUKI_MAXMIN_03;
	}

	public double getNowNETUKI_MAXMIN_04() {
		return nowNETUKI_MAXMIN_04;
	}

	public void setNowNETUKI_MAXMIN_04(double nowNETUKI_MAXMIN_04) {
		this.nowNETUKI_MAXMIN_04 = nowNETUKI_MAXMIN_04;
	}

	public double getNowNETUKI_MAXMINRATIO_01() {
		return nowNETUKI_MAXMINRATIO_01;
	}

	public void setNowNETUKI_MAXMINRATIO_01(double nowNETUKI_MAXMINRATIO_01) {
		this.nowNETUKI_MAXMINRATIO_01 = nowNETUKI_MAXMINRATIO_01;
	}

	public double getNowNETUKI_MAXMINRATIO_02() {
		return nowNETUKI_MAXMINRATIO_02;
	}

	public void setNowNETUKI_MAXMINRATIO_02(double nowNETUKI_MAXMINRATIO_02) {
		this.nowNETUKI_MAXMINRATIO_02 = nowNETUKI_MAXMINRATIO_02;
	}

	public double getNowNETUKI_MAXMINRATIO_03() {
		return nowNETUKI_MAXMINRATIO_03;
	}

	public void setNowNETUKI_MAXMINRATIO_03(double nowNETUKI_MAXMINRATIO_03) {
		this.nowNETUKI_MAXMINRATIO_03 = nowNETUKI_MAXMINRATIO_03;
	}

	public double getNowNETUKI_MAXMINRATIO_04() {
		return nowNETUKI_MAXMINRATIO_04;
	}

	public void setNowNETUKI_MAXMINRATIO_04(double nowNETUKI_MAXMINRATIO_04) {
		this.nowNETUKI_MAXMINRATIO_04 = nowNETUKI_MAXMINRATIO_04;
	}

	public double getNowSTOCK_GETPRICE_01() {
		return nowSTOCK_GETPRICE_01;
	}

	public void setNowSTOCK_GETPRICE_01(double nowSTOCK_GETPRICE_01) {
		this.nowSTOCK_GETPRICE_01 = nowSTOCK_GETPRICE_01;
	}

	public double getNowSTOCK_GETPRICE_02() {
		return nowSTOCK_GETPRICE_02;
	}

	public void setNowSTOCK_GETPRICE_02(double nowSTOCK_GETPRICE_02) {
		this.nowSTOCK_GETPRICE_02 = nowSTOCK_GETPRICE_02;
	}

	public double getNowSTOCK_GETPRICE_03() {
		return nowSTOCK_GETPRICE_03;
	}

	public void setNowSTOCK_GETPRICE_03(double nowSTOCK_GETPRICE_03) {
		this.nowSTOCK_GETPRICE_03 = nowSTOCK_GETPRICE_03;
	}

	public double getNowSTOCK_GETPRICE_04() {
		return nowSTOCK_GETPRICE_04;
	}

	public void setNowSTOCK_GETPRICE_04(double nowSTOCK_GETPRICE_04) {
		this.nowSTOCK_GETPRICE_04 = nowSTOCK_GETPRICE_04;
	}

	public double getNowSTOCK_GETPRICE_CHANGERATE_01() {
		return nowSTOCK_GETPRICE_CHANGERATE_01;
	}

	public void setNowSTOCK_GETPRICE_CHANGERATE_01(
			double nowSTOCK_GETPRICE_CHANGERATE_01) {
		this.nowSTOCK_GETPRICE_CHANGERATE_01 = nowSTOCK_GETPRICE_CHANGERATE_01;
	}

	public double getNowSTOCK_GETPRICE_CHANGERATE_02() {
		return nowSTOCK_GETPRICE_CHANGERATE_02;
	}

	public void setNowSTOCK_GETPRICE_CHANGERATE_02(
			double nowSTOCK_GETPRICE_CHANGERATE_02) {
		this.nowSTOCK_GETPRICE_CHANGERATE_02 = nowSTOCK_GETPRICE_CHANGERATE_02;
	}

	public double getNowSTOCK_GETPRICE_CHANGERATE_03() {
		return nowSTOCK_GETPRICE_CHANGERATE_03;
	}

	public void setNowSTOCK_GETPRICE_CHANGERATE_03(
			double nowSTOCK_GETPRICE_CHANGERATE_03) {
		this.nowSTOCK_GETPRICE_CHANGERATE_03 = nowSTOCK_GETPRICE_CHANGERATE_03;
	}

	public double getNowSTOCK_GETPRICE_CHANGERATE_04() {
		return nowSTOCK_GETPRICE_CHANGERATE_04;
	}

	public void setNowSTOCK_GETPRICE_CHANGERATE_04(
			double nowSTOCK_GETPRICE_CHANGERATE_04) {
		this.nowSTOCK_GETPRICE_CHANGERATE_04 = nowSTOCK_GETPRICE_CHANGERATE_04;
	}

	public double getNowSTOCK_GETPRICE_RATIO_01() {
		return nowSTOCK_GETPRICE_RATIO_01;
	}

	public void setNowSTOCK_GETPRICE_RATIO_01(double nowSTOCK_GETPRICE_RATIO_01) {
		this.nowSTOCK_GETPRICE_RATIO_01 = nowSTOCK_GETPRICE_RATIO_01;
	}

	public double getNowSTOCK_GETPRICE_RATIO_02() {
		return nowSTOCK_GETPRICE_RATIO_02;
	}

	public void setNowSTOCK_GETPRICE_RATIO_02(double nowSTOCK_GETPRICE_RATIO_02) {
		this.nowSTOCK_GETPRICE_RATIO_02 = nowSTOCK_GETPRICE_RATIO_02;
	}

	public double getNowSTOCK_GETPRICE_RATIO_03() {
		return nowSTOCK_GETPRICE_RATIO_03;
	}

	public void setNowSTOCK_GETPRICE_RATIO_03(double nowSTOCK_GETPRICE_RATIO_03) {
		this.nowSTOCK_GETPRICE_RATIO_03 = nowSTOCK_GETPRICE_RATIO_03;
	}

	public double getNowSTOCK_GETPRICE_RATIO_04() {
		return nowSTOCK_GETPRICE_RATIO_04;
	}

	public void setNowSTOCK_GETPRICE_RATIO_04(double nowSTOCK_GETPRICE_RATIO_04) {
		this.nowSTOCK_GETPRICE_RATIO_04 = nowSTOCK_GETPRICE_RATIO_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_01() {
		return nowSTOCK_GETPRICE_IDO_SHORT_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_01(
			double nowSTOCK_GETPRICE_IDO_SHORT_01) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_01 = nowSTOCK_GETPRICE_IDO_SHORT_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_02() {
		return nowSTOCK_GETPRICE_IDO_SHORT_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_02(
			double nowSTOCK_GETPRICE_IDO_SHORT_02) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_02 = nowSTOCK_GETPRICE_IDO_SHORT_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_03() {
		return nowSTOCK_GETPRICE_IDO_SHORT_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_03(
			double nowSTOCK_GETPRICE_IDO_SHORT_03) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_03 = nowSTOCK_GETPRICE_IDO_SHORT_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_04() {
		return nowSTOCK_GETPRICE_IDO_SHORT_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_04(
			double nowSTOCK_GETPRICE_IDO_SHORT_04) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_04 = nowSTOCK_GETPRICE_IDO_SHORT_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_01() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_01(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_01) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_01 = nowSTOCK_GETPRICE_IDO_MIDDLE_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_02() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_02(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_02) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_02 = nowSTOCK_GETPRICE_IDO_MIDDLE_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_03() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_03(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_03) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_03 = nowSTOCK_GETPRICE_IDO_MIDDLE_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_04() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_04(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_04) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_04 = nowSTOCK_GETPRICE_IDO_MIDDLE_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_01() {
		return nowSTOCK_GETPRICE_IDO_LONG_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_01(
			double nowSTOCK_GETPRICE_IDO_LONG_01) {
		this.nowSTOCK_GETPRICE_IDO_LONG_01 = nowSTOCK_GETPRICE_IDO_LONG_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_02() {
		return nowSTOCK_GETPRICE_IDO_LONG_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_02(
			double nowSTOCK_GETPRICE_IDO_LONG_02) {
		this.nowSTOCK_GETPRICE_IDO_LONG_02 = nowSTOCK_GETPRICE_IDO_LONG_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_03() {
		return nowSTOCK_GETPRICE_IDO_LONG_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_03(
			double nowSTOCK_GETPRICE_IDO_LONG_03) {
		this.nowSTOCK_GETPRICE_IDO_LONG_03 = nowSTOCK_GETPRICE_IDO_LONG_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_04() {
		return nowSTOCK_GETPRICE_IDO_LONG_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_04(
			double nowSTOCK_GETPRICE_IDO_LONG_04) {
		this.nowSTOCK_GETPRICE_IDO_LONG_04 = nowSTOCK_GETPRICE_IDO_LONG_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01() {
		return nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(
			double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01 = nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02() {
		return nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02(
			double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02 = nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03() {
		return nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03(
			double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03 = nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04() {
		return nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04(
			double nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04 = nowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01 = nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02 = nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03 = nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04 = nowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01() {
		return nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01(
			double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01) {
		this.nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01 = nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02() {
		return nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02(
			double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02) {
		this.nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02 = nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03() {
		return nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03(
			double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03) {
		this.nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03 = nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04() {
		return nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04(
			double nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04) {
		this.nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04 = nowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_RATIO_01() {
		return nowSTOCK_GETPRICE_IDO_SHORT_RATIO_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_01(
			double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_01) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_RATIO_01 = nowSTOCK_GETPRICE_IDO_SHORT_RATIO_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_RATIO_02() {
		return nowSTOCK_GETPRICE_IDO_SHORT_RATIO_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_02(
			double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_02) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_RATIO_02 = nowSTOCK_GETPRICE_IDO_SHORT_RATIO_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_RATIO_03() {
		return nowSTOCK_GETPRICE_IDO_SHORT_RATIO_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_03(
			double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_03) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_RATIO_03 = nowSTOCK_GETPRICE_IDO_SHORT_RATIO_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_SHORT_RATIO_04() {
		return nowSTOCK_GETPRICE_IDO_SHORT_RATIO_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_04(
			double nowSTOCK_GETPRICE_IDO_SHORT_RATIO_04) {
		this.nowSTOCK_GETPRICE_IDO_SHORT_RATIO_04 = nowSTOCK_GETPRICE_IDO_SHORT_RATIO_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01 = nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02 = nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03 = nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04() {
		return nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04(
			double nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04) {
		this.nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04 = nowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_04;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_RATIO_01() {
		return nowSTOCK_GETPRICE_IDO_LONG_RATIO_01;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_RATIO_01(
			double nowSTOCK_GETPRICE_IDO_LONG_RATIO_01) {
		this.nowSTOCK_GETPRICE_IDO_LONG_RATIO_01 = nowSTOCK_GETPRICE_IDO_LONG_RATIO_01;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_RATIO_02() {
		return nowSTOCK_GETPRICE_IDO_LONG_RATIO_02;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_RATIO_02(
			double nowSTOCK_GETPRICE_IDO_LONG_RATIO_02) {
		this.nowSTOCK_GETPRICE_IDO_LONG_RATIO_02 = nowSTOCK_GETPRICE_IDO_LONG_RATIO_02;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_RATIO_03() {
		return nowSTOCK_GETPRICE_IDO_LONG_RATIO_03;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_RATIO_03(
			double nowSTOCK_GETPRICE_IDO_LONG_RATIO_03) {
		this.nowSTOCK_GETPRICE_IDO_LONG_RATIO_03 = nowSTOCK_GETPRICE_IDO_LONG_RATIO_03;
	}

	public double getNowSTOCK_GETPRICE_IDO_LONG_RATIO_04() {
		return nowSTOCK_GETPRICE_IDO_LONG_RATIO_04;
	}

	public void setNowSTOCK_GETPRICE_IDO_LONG_RATIO_04(
			double nowSTOCK_GETPRICE_IDO_LONG_RATIO_04) {
		this.nowSTOCK_GETPRICE_IDO_LONG_RATIO_04 = nowSTOCK_GETPRICE_IDO_LONG_RATIO_04;
	}

	public double getNowSTOCK_UPSTOCK_01() {
		return nowSTOCK_UPSTOCK_01;
	}

	public void setNowSTOCK_UPSTOCK_01(double nowSTOCK_UPSTOCK_01) {
		this.nowSTOCK_UPSTOCK_01 = nowSTOCK_UPSTOCK_01;
	}

	public double getNowSTOCK_UPSTOCK_02() {
		return nowSTOCK_UPSTOCK_02;
	}

	public void setNowSTOCK_UPSTOCK_02(double nowSTOCK_UPSTOCK_02) {
		this.nowSTOCK_UPSTOCK_02 = nowSTOCK_UPSTOCK_02;
	}

	public double getNowSTOCK_UPSTOCK_03() {
		return nowSTOCK_UPSTOCK_03;
	}

	public void setNowSTOCK_UPSTOCK_03(double nowSTOCK_UPSTOCK_03) {
		this.nowSTOCK_UPSTOCK_03 = nowSTOCK_UPSTOCK_03;
	}

	public double getNowSTOCK_UPSTOCK_04() {
		return nowSTOCK_UPSTOCK_04;
	}

	public void setNowSTOCK_UPSTOCK_04(double nowSTOCK_UPSTOCK_04) {
		this.nowSTOCK_UPSTOCK_04 = nowSTOCK_UPSTOCK_04;
	}

	public double getNowSTOCK_UPPRICE_CHANGERATE_01() {
		return nowSTOCK_UPPRICE_CHANGERATE_01;
	}

	public void setNowSTOCK_UPPRICE_CHANGERATE_01(
			double nowSTOCK_UPPRICE_CHANGERATE_01) {
		this.nowSTOCK_UPPRICE_CHANGERATE_01 = nowSTOCK_UPPRICE_CHANGERATE_01;
	}

	public double getNowSTOCK_UPPRICE_CHANGERATE_02() {
		return nowSTOCK_UPPRICE_CHANGERATE_02;
	}

	public void setNowSTOCK_UPPRICE_CHANGERATE_02(
			double nowSTOCK_UPPRICE_CHANGERATE_02) {
		this.nowSTOCK_UPPRICE_CHANGERATE_02 = nowSTOCK_UPPRICE_CHANGERATE_02;
	}

	public double getNowSTOCK_UPPRICE_CHANGERATE_03() {
		return nowSTOCK_UPPRICE_CHANGERATE_03;
	}

	public void setNowSTOCK_UPPRICE_CHANGERATE_03(
			double nowSTOCK_UPPRICE_CHANGERATE_03) {
		this.nowSTOCK_UPPRICE_CHANGERATE_03 = nowSTOCK_UPPRICE_CHANGERATE_03;
	}

	public double getNowSTOCK_UPPRICE_CHANGERATE_04() {
		return nowSTOCK_UPPRICE_CHANGERATE_04;
	}

	public void setNowSTOCK_UPPRICE_CHANGERATE_04(
			double nowSTOCK_UPPRICE_CHANGERATE_04) {
		this.nowSTOCK_UPPRICE_CHANGERATE_04 = nowSTOCK_UPPRICE_CHANGERATE_04;
	}

	public double getNowSTOCK_UPPRICE_RATIO_01() {
		return nowSTOCK_UPPRICE_RATIO_01;
	}

	public void setNowSTOCK_UPPRICE_RATIO_01(double nowSTOCK_UPPRICE_RATIO_01) {
		this.nowSTOCK_UPPRICE_RATIO_01 = nowSTOCK_UPPRICE_RATIO_01;
	}

	public double getNowSTOCK_UPPRICE_RATIO_02() {
		return nowSTOCK_UPPRICE_RATIO_02;
	}

	public void setNowSTOCK_UPPRICE_RATIO_02(double nowSTOCK_UPPRICE_RATIO_02) {
		this.nowSTOCK_UPPRICE_RATIO_02 = nowSTOCK_UPPRICE_RATIO_02;
	}

	public double getNowSTOCK_UPPRICE_RATIO_03() {
		return nowSTOCK_UPPRICE_RATIO_03;
	}

	public void setNowSTOCK_UPPRICE_RATIO_03(double nowSTOCK_UPPRICE_RATIO_03) {
		this.nowSTOCK_UPPRICE_RATIO_03 = nowSTOCK_UPPRICE_RATIO_03;
	}

	public double getNowSTOCK_UPPRICE_RATIO_04() {
		return nowSTOCK_UPPRICE_RATIO_04;
	}

	public void setNowSTOCK_UPPRICE_RATIO_04(double nowSTOCK_UPPRICE_RATIO_04) {
		this.nowSTOCK_UPPRICE_RATIO_04 = nowSTOCK_UPPRICE_RATIO_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_01() {
		return nowSTOCK_UPPRICE_IDO_SHORT_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_01(
			double nowSTOCK_UPPRICE_IDO_SHORT_01) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_01 = nowSTOCK_UPPRICE_IDO_SHORT_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_02() {
		return nowSTOCK_UPPRICE_IDO_SHORT_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_02(
			double nowSTOCK_UPPRICE_IDO_SHORT_02) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_02 = nowSTOCK_UPPRICE_IDO_SHORT_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_03() {
		return nowSTOCK_UPPRICE_IDO_SHORT_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_03(
			double nowSTOCK_UPPRICE_IDO_SHORT_03) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_03 = nowSTOCK_UPPRICE_IDO_SHORT_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_04() {
		return nowSTOCK_UPPRICE_IDO_SHORT_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_04(
			double nowSTOCK_UPPRICE_IDO_SHORT_04) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_04 = nowSTOCK_UPPRICE_IDO_SHORT_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_01() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_01(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_01) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_01 = nowSTOCK_UPPRICE_IDO_MIDDLE_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_02() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_02(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_02) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_02 = nowSTOCK_UPPRICE_IDO_MIDDLE_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_03() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_03(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_03) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_03 = nowSTOCK_UPPRICE_IDO_MIDDLE_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_04() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_04(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_04) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_04 = nowSTOCK_UPPRICE_IDO_MIDDLE_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_01() {
		return nowSTOCK_UPPRICE_IDO_LONG_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_01(double nowSTOCK_UPPRICE_IDO_LONG_01) {
		this.nowSTOCK_UPPRICE_IDO_LONG_01 = nowSTOCK_UPPRICE_IDO_LONG_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_02() {
		return nowSTOCK_UPPRICE_IDO_LONG_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_02(double nowSTOCK_UPPRICE_IDO_LONG_02) {
		this.nowSTOCK_UPPRICE_IDO_LONG_02 = nowSTOCK_UPPRICE_IDO_LONG_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_03() {
		return nowSTOCK_UPPRICE_IDO_LONG_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_03(double nowSTOCK_UPPRICE_IDO_LONG_03) {
		this.nowSTOCK_UPPRICE_IDO_LONG_03 = nowSTOCK_UPPRICE_IDO_LONG_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_04() {
		return nowSTOCK_UPPRICE_IDO_LONG_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_04(double nowSTOCK_UPPRICE_IDO_LONG_04) {
		this.nowSTOCK_UPPRICE_IDO_LONG_04 = nowSTOCK_UPPRICE_IDO_LONG_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01() {
		return nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(
			double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01 = nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02() {
		return nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02(
			double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02 = nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03() {
		return nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03(
			double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03 = nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04() {
		return nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04(
			double nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04 = nowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01 = nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02 = nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03 = nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04 = nowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01() {
		return nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01(
			double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01) {
		this.nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01 = nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02() {
		return nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02(
			double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02) {
		this.nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02 = nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03() {
		return nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03(
			double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03) {
		this.nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03 = nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04() {
		return nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04(
			double nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04) {
		this.nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04 = nowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_RATIO_01() {
		return nowSTOCK_UPPRICE_IDO_SHORT_RATIO_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_01(
			double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_01) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_RATIO_01 = nowSTOCK_UPPRICE_IDO_SHORT_RATIO_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_RATIO_02() {
		return nowSTOCK_UPPRICE_IDO_SHORT_RATIO_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_02(
			double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_02) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_RATIO_02 = nowSTOCK_UPPRICE_IDO_SHORT_RATIO_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_RATIO_03() {
		return nowSTOCK_UPPRICE_IDO_SHORT_RATIO_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_03(
			double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_03) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_RATIO_03 = nowSTOCK_UPPRICE_IDO_SHORT_RATIO_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_SHORT_RATIO_04() {
		return nowSTOCK_UPPRICE_IDO_SHORT_RATIO_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_04(
			double nowSTOCK_UPPRICE_IDO_SHORT_RATIO_04) {
		this.nowSTOCK_UPPRICE_IDO_SHORT_RATIO_04 = nowSTOCK_UPPRICE_IDO_SHORT_RATIO_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01 = nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02 = nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03 = nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04() {
		return nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04(
			double nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04) {
		this.nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04 = nowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_04;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_RATIO_01() {
		return nowSTOCK_UPPRICE_IDO_LONG_RATIO_01;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_RATIO_01(
			double nowSTOCK_UPPRICE_IDO_LONG_RATIO_01) {
		this.nowSTOCK_UPPRICE_IDO_LONG_RATIO_01 = nowSTOCK_UPPRICE_IDO_LONG_RATIO_01;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_RATIO_02() {
		return nowSTOCK_UPPRICE_IDO_LONG_RATIO_02;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_RATIO_02(
			double nowSTOCK_UPPRICE_IDO_LONG_RATIO_02) {
		this.nowSTOCK_UPPRICE_IDO_LONG_RATIO_02 = nowSTOCK_UPPRICE_IDO_LONG_RATIO_02;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_RATIO_03() {
		return nowSTOCK_UPPRICE_IDO_LONG_RATIO_03;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_RATIO_03(
			double nowSTOCK_UPPRICE_IDO_LONG_RATIO_03) {
		this.nowSTOCK_UPPRICE_IDO_LONG_RATIO_03 = nowSTOCK_UPPRICE_IDO_LONG_RATIO_03;
	}

	public double getNowSTOCK_UPPRICE_IDO_LONG_RATIO_04() {
		return nowSTOCK_UPPRICE_IDO_LONG_RATIO_04;
	}

	public void setNowSTOCK_UPPRICE_IDO_LONG_RATIO_04(
			double nowSTOCK_UPPRICE_IDO_LONG_RATIO_04) {
		this.nowSTOCK_UPPRICE_IDO_LONG_RATIO_04 = nowSTOCK_UPPRICE_IDO_LONG_RATIO_04;
	}

	public double getNowSTOCK_NOCHANGE_01() {
		return nowSTOCK_NOCHANGE_01;
	}

	public void setNowSTOCK_NOCHANGE_01(double nowSTOCK_NOCHANGE_01) {
		this.nowSTOCK_NOCHANGE_01 = nowSTOCK_NOCHANGE_01;
	}

	public double getNowSTOCK_NOCHANGE_02() {
		return nowSTOCK_NOCHANGE_02;
	}

	public void setNowSTOCK_NOCHANGE_02(double nowSTOCK_NOCHANGE_02) {
		this.nowSTOCK_NOCHANGE_02 = nowSTOCK_NOCHANGE_02;
	}

	public double getNowSTOCK_NOCHANGE_03() {
		return nowSTOCK_NOCHANGE_03;
	}

	public void setNowSTOCK_NOCHANGE_03(double nowSTOCK_NOCHANGE_03) {
		this.nowSTOCK_NOCHANGE_03 = nowSTOCK_NOCHANGE_03;
	}

	public double getNowSTOCK_NOCHANGE_04() {
		return nowSTOCK_NOCHANGE_04;
	}

	public void setNowSTOCK_NOCHANGE_04(double nowSTOCK_NOCHANGE_04) {
		this.nowSTOCK_NOCHANGE_04 = nowSTOCK_NOCHANGE_04;
	}

	public double getNowSTOCK_NOCHANGE_CHANGERATE_01() {
		return nowSTOCK_NOCHANGE_CHANGERATE_01;
	}

	public void setNowSTOCK_NOCHANGE_CHANGERATE_01(
			double nowSTOCK_NOCHANGE_CHANGERATE_01) {
		this.nowSTOCK_NOCHANGE_CHANGERATE_01 = nowSTOCK_NOCHANGE_CHANGERATE_01;
	}

	public double getNowSTOCK_NOCHANGE_CHANGERATE_02() {
		return nowSTOCK_NOCHANGE_CHANGERATE_02;
	}

	public void setNowSTOCK_NOCHANGE_CHANGERATE_02(
			double nowSTOCK_NOCHANGE_CHANGERATE_02) {
		this.nowSTOCK_NOCHANGE_CHANGERATE_02 = nowSTOCK_NOCHANGE_CHANGERATE_02;
	}

	public double getNowSTOCK_NOCHANGE_CHANGERATE_03() {
		return nowSTOCK_NOCHANGE_CHANGERATE_03;
	}

	public void setNowSTOCK_NOCHANGE_CHANGERATE_03(
			double nowSTOCK_NOCHANGE_CHANGERATE_03) {
		this.nowSTOCK_NOCHANGE_CHANGERATE_03 = nowSTOCK_NOCHANGE_CHANGERATE_03;
	}

	public double getNowSTOCK_NOCHANGE_CHANGERATE_04() {
		return nowSTOCK_NOCHANGE_CHANGERATE_04;
	}

	public void setNowSTOCK_NOCHANGE_CHANGERATE_04(
			double nowSTOCK_NOCHANGE_CHANGERATE_04) {
		this.nowSTOCK_NOCHANGE_CHANGERATE_04 = nowSTOCK_NOCHANGE_CHANGERATE_04;
	}

	public double getNowSTOCK_NOCHANGE_RATIO_01() {
		return nowSTOCK_NOCHANGE_RATIO_01;
	}

	public void setNowSTOCK_NOCHANGE_RATIO_01(double nowSTOCK_NOCHANGE_RATIO_01) {
		this.nowSTOCK_NOCHANGE_RATIO_01 = nowSTOCK_NOCHANGE_RATIO_01;
	}

	public double getNowSTOCK_NOCHANGE_RATIO_02() {
		return nowSTOCK_NOCHANGE_RATIO_02;
	}

	public void setNowSTOCK_NOCHANGE_RATIO_02(double nowSTOCK_NOCHANGE_RATIO_02) {
		this.nowSTOCK_NOCHANGE_RATIO_02 = nowSTOCK_NOCHANGE_RATIO_02;
	}

	public double getNowSTOCK_NOCHANGE_RATIO_03() {
		return nowSTOCK_NOCHANGE_RATIO_03;
	}

	public void setNowSTOCK_NOCHANGE_RATIO_03(double nowSTOCK_NOCHANGE_RATIO_03) {
		this.nowSTOCK_NOCHANGE_RATIO_03 = nowSTOCK_NOCHANGE_RATIO_03;
	}

	public double getNowSTOCK_NOCHANGE_RATIO_04() {
		return nowSTOCK_NOCHANGE_RATIO_04;
	}

	public void setNowSTOCK_NOCHANGE_RATIO_04(double nowSTOCK_NOCHANGE_RATIO_04) {
		this.nowSTOCK_NOCHANGE_RATIO_04 = nowSTOCK_NOCHANGE_RATIO_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_01() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_01(
			double nowSTOCK_NOCHANGE_IDO_SHORT_01) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_01 = nowSTOCK_NOCHANGE_IDO_SHORT_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_02() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_02(
			double nowSTOCK_NOCHANGE_IDO_SHORT_02) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_02 = nowSTOCK_NOCHANGE_IDO_SHORT_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_03() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_03(
			double nowSTOCK_NOCHANGE_IDO_SHORT_03) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_03 = nowSTOCK_NOCHANGE_IDO_SHORT_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_04() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_04(
			double nowSTOCK_NOCHANGE_IDO_SHORT_04) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_04 = nowSTOCK_NOCHANGE_IDO_SHORT_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_01() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_01(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_01) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_01 = nowSTOCK_NOCHANGE_IDO_MIDDLE_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_02() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_02(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_02) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_02 = nowSTOCK_NOCHANGE_IDO_MIDDLE_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_03() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_03(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_03) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_03 = nowSTOCK_NOCHANGE_IDO_MIDDLE_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_04() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_04(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_04) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_04 = nowSTOCK_NOCHANGE_IDO_MIDDLE_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_01() {
		return nowSTOCK_NOCHANGE_IDO_LONG_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_01(
			double nowSTOCK_NOCHANGE_IDO_LONG_01) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_01 = nowSTOCK_NOCHANGE_IDO_LONG_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_02() {
		return nowSTOCK_NOCHANGE_IDO_LONG_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_02(
			double nowSTOCK_NOCHANGE_IDO_LONG_02) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_02 = nowSTOCK_NOCHANGE_IDO_LONG_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_03() {
		return nowSTOCK_NOCHANGE_IDO_LONG_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_03(
			double nowSTOCK_NOCHANGE_IDO_LONG_03) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_03 = nowSTOCK_NOCHANGE_IDO_LONG_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_04() {
		return nowSTOCK_NOCHANGE_IDO_LONG_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_04(
			double nowSTOCK_NOCHANGE_IDO_LONG_04) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_04 = nowSTOCK_NOCHANGE_IDO_LONG_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(
			double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01 = nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02(
			double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02 = nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03(
			double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03 = nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04(
			double nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04 = nowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01 = nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02 = nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03 = nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04 = nowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01() {
		return nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(
			double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01 = nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02() {
		return nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02(
			double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02 = nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03() {
		return nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03(
			double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03 = nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04() {
		return nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04(
			double nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04 = nowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01(
			double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01 = nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02(
			double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02 = nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03(
			double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03 = nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04() {
		return nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04(
			double nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04) {
		this.nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04 = nowSTOCK_NOCHANGE_IDO_SHORT_RATIO_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01 = nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02 = nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03 = nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04() {
		return nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04(
			double nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04) {
		this.nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04 = nowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_04;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_RATIO_01() {
		return nowSTOCK_NOCHANGE_IDO_LONG_RATIO_01;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_01(
			double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_01) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_RATIO_01 = nowSTOCK_NOCHANGE_IDO_LONG_RATIO_01;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_RATIO_02() {
		return nowSTOCK_NOCHANGE_IDO_LONG_RATIO_02;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_02(
			double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_02) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_RATIO_02 = nowSTOCK_NOCHANGE_IDO_LONG_RATIO_02;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_RATIO_03() {
		return nowSTOCK_NOCHANGE_IDO_LONG_RATIO_03;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_03(
			double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_03) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_RATIO_03 = nowSTOCK_NOCHANGE_IDO_LONG_RATIO_03;
	}

	public double getNowSTOCK_NOCHANGE_IDO_LONG_RATIO_04() {
		return nowSTOCK_NOCHANGE_IDO_LONG_RATIO_04;
	}

	public void setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_04(
			double nowSTOCK_NOCHANGE_IDO_LONG_RATIO_04) {
		this.nowSTOCK_NOCHANGE_IDO_LONG_RATIO_04 = nowSTOCK_NOCHANGE_IDO_LONG_RATIO_04;
	}

	public double getNowOpen_02() {
		return nowOpen_02;
	}

	public void setNowOpen_02(double nowOpen_02) {
		this.nowOpen_02 = nowOpen_02;
	}

	public double getNowOpen_03() {
		return nowOpen_03;
	}

	public void setNowOpen_03(double nowOpen_03) {
		this.nowOpen_03 = nowOpen_03;
	}

	public double getNowOpen_04() {
		return nowOpen_04;
	}

	public void setNowOpen_04(double nowOpen_04) {
		this.nowOpen_04 = nowOpen_04;
	}

	public double getNowMAX_02() {
		return nowMAX_02;
	}

	public void setNowMAX_02(double nowMAX_02) {
		this.nowMAX_02 = nowMAX_02;
	}

	public double getNowMAX_03() {
		return nowMAX_03;
	}

	public void setNowMAX_03(double nowMAX_03) {
		this.nowMAX_03 = nowMAX_03;
	}

	public double getNowMAX_04() {
		return nowMAX_04;
	}

	public void setNowMAX_04(double nowMAX_04) {
		this.nowMAX_04 = nowMAX_04;
	}

	public double getNowMIN_02() {
		return nowMIN_02;
	}

	public void setNowMIN_02(double nowMIN_02) {
		this.nowMIN_02 = nowMIN_02;
	}

	public double getNowMIN_03() {
		return nowMIN_03;
	}

	public void setNowMIN_03(double nowMIN_03) {
		this.nowMIN_03 = nowMIN_03;
	}

	public double getNowMIN_04() {
		return nowMIN_04;
	}

	public void setNowMIN_04(double nowMIN_04) {
		this.nowMIN_04 = nowMIN_04;
	}

	public double getNowCLOSE_02() {
		return nowCLOSE_02;
	}

	public void setNowCLOSE_02(double nowCLOSE_02) {
		this.nowCLOSE_02 = nowCLOSE_02;
	}

	public double getNowCLOSE_03() {
		return nowCLOSE_03;
	}

	public void setNowCLOSE_03(double nowCLOSE_03) {
		this.nowCLOSE_03 = nowCLOSE_03;
	}

	public double getNowCLOSE_04() {
		return nowCLOSE_04;
	}

	public void setNowCLOSE_04(double nowCLOSE_04) {
		this.nowCLOSE_04 = nowCLOSE_04;
	}

	public double getNowDEKI_02() {
		return nowDEKI_02;
	}

	public void setNowDEKI_02(double nowDEKI_02) {
		this.nowDEKI_02 = nowDEKI_02;
	}

	public double getNowDEKI_03() {
		return nowDEKI_03;
	}

	public void setNowDEKI_03(double nowDEKI_03) {
		this.nowDEKI_03 = nowDEKI_03;
	}

	public double getNowDEKI_04() {
		return nowDEKI_04;
	}

	public void setNowDEKI_04(double nowDEKI_04) {
		this.nowDEKI_04 = nowDEKI_04;
	}

	public double getNowBAYBAY_02() {
		return nowBAYBAY_02;
	}

	public void setNowBAYBAY_02(double nowBAYBAY_02) {
		this.nowBAYBAY_02 = nowBAYBAY_02;
	}

	public double getNowBAYBAY_03() {
		return nowBAYBAY_03;
	}

	public void setNowBAYBAY_03(double nowBAYBAY_03) {
		this.nowBAYBAY_03 = nowBAYBAY_03;
	}

	public double getNowBAYBAY_04() {
		return nowBAYBAY_04;
	}

	public void setNowBAYBAY_04(double nowBAYBAY_04) {
		this.nowBAYBAY_04 = nowBAYBAY_04;
	}

	public String getNowDay_01() {
		return nowDay_01;
	}

	public void setNowDay_01(String nowDay_01) {
		this.nowDay_01 = nowDay_01;
	}

	public String getNowDay_02() {
		return nowDay_02;
	}

	public void setNowDay_02(String nowDay_02) {
		this.nowDay_02 = nowDay_02;
	}

	public String getNowDay_03() {
		return nowDay_03;
	}

	public void setNowDay_03(String nowDay_03) {
		this.nowDay_03 = nowDay_03;
	}

	public String getNowDay_04() {
		return nowDay_04;
	}

	public void setNowDay_04(String nowDay_04) {
		this.nowDay_04 = nowDay_04;
	}

	public double getNowOpen_01() {
		return nowOpen_01;
	}

	public void setNowOpen_01(double nowOpen) {
		this.nowOpen_01 = nowOpen;
	}

	public double getNowMAX_01() {
		return nowMAX_01;
	}

	public void setNowMAX_01(double nowMAX) {
		this.nowMAX_01 = nowMAX;
	}

	public double getNowMIN_01() {
		return nowMIN_01;
	}

	public void setNowMIN_01(double nowMIN) {
		this.nowMIN_01 = nowMIN;
	}

	public double getNowCLOSE_01() {
		return nowCLOSE_01;
	}

	public void setNowCLOSE_01(double nowCLOSE) {
		this.nowCLOSE_01 = nowCLOSE;
	}

	public double getNowDEKI_01() {
		return nowDEKI_01;
	}

	public void setNowDEKI_01(double nowDEKI) {
		this.nowDEKI_01 = nowDEKI;
	}

	public double getNowBAYBAY_01() {
		return nowBAYBAY_01;
	}

	public void setNowBAYBAY_01(double nowBAYBAY) {
		this.nowBAYBAY_01 = nowBAYBAY;
	}

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

	public String getCateflg_01() {
		return cateflg_01;
	}

	public void setCateflg_01(String cateflg) {
		this.cateflg_01 = cateflg;
	}



	public String getCateflg_02() {
		return cateflg_02;
	}

	public void setCateflg_02(String cateflg_02) {
		this.cateflg_02 = cateflg_02;
	}

	public String getCateflg_03() {
		return cateflg_03;
	}

	public void setCateflg_03(String cateflg_03) {
		this.cateflg_03 = cateflg_03;
	}

	public String getCateflg_04() {
		return cateflg_04;
	}

	public void setCateflg_04(String cateflg_04) {
		this.cateflg_04 = cateflg_04;
	}

	public String getCode_01() {
		return code_01;
	}

	public void setCode_01(String code) {
		this.code_01 = code;
	}

	public String getCode_02() {
		return code_02;
	}

	public void setCode_02(String code_02) {
		this.code_02 = code_02;
	}

	public String getCode_03() {
		return code_03;
	}

	public void setCode_03(String code_03) {
		this.code_03 = code_03;
	}

	public String getCode_04() {
		return code_04;
	}

	public void setCode_04(String code_04) {
		this.code_04 = code_04;
	}

	public double getNow_NIKKE_AVEOpen_01() {
		return now_NIKKE_AVEOpen_01;
	}

	public void setNow_NIKKE_AVEOpen_01(double now_NIKKE_AVEOpen_01) {
		this.now_NIKKE_AVEOpen_01 = now_NIKKE_AVEOpen_01;
	}

	public double getNow_NIKKE_AVEMAX_01() {
		return now_NIKKE_AVEMAX_01;
	}

	public void setNow_NIKKE_AVEMAX_01(double now_NIKKE_AVEMAX_01) {
		this.now_NIKKE_AVEMAX_01 = now_NIKKE_AVEMAX_01;
	}

	public double getNow_NIKKE_AVEMIN_01() {
		return now_NIKKE_AVEMIN_01;
	}

	public void setNow_NIKKE_AVEMIN_01(double now_NIKKE_AVEMIN_01) {
		this.now_NIKKE_AVEMIN_01 = now_NIKKE_AVEMIN_01;
	}

	public double getNow_NIKKE_AVECLOSE_01() {
		return now_NIKKE_AVECLOSE_01;
	}

	public void setNow_NIKKE_AVECLOSE_01(double now_NIKKE_AVECLOSE_01) {
		this.now_NIKKE_AVECLOSE_01 = now_NIKKE_AVECLOSE_01;
	}

	public double getNow_NIKKE_AVECHANGE_PRICE_01() {
		return now_NIKKE_AVECHANGE_PRICE_01;
	}

	public void setNow_NIKKE_AVECHANGE_PRICE_01(double now_NIKKE_AVECHANGE_PRICE_01) {
		this.now_NIKKE_AVECHANGE_PRICE_01 = now_NIKKE_AVECHANGE_PRICE_01;
	}

	public double getNow_NIKKE_AVECHANGERATE_01() {
		return now_NIKKE_AVECHANGERATE_01;
	}

	public void setNow_NIKKE_AVECHANGERATE_01(double now_NIKKE_AVECHANGERATE_01) {
		this.now_NIKKE_AVECHANGERATE_01 = now_NIKKE_AVECHANGERATE_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_01() {
		return now_NIKKE_AVESHORTIDO_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_01(double now_NIKKE_AVESHORTIDO_01) {
		this.now_NIKKE_AVESHORTIDO_01 = now_NIKKE_AVESHORTIDO_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_01() {
		return now_NIKKE_AVEMIDDLEIDO_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_01(double now_NIKKE_AVEMIDDLEIDO_01) {
		this.now_NIKKE_AVEMIDDLEIDO_01 = now_NIKKE_AVEMIDDLEIDO_01;
	}

	public double getNow_NIKKE_AVELONGIDO_01() {
		return now_NIKKE_AVELONGIDO_01;
	}

	public void setNow_NIKKE_AVELONGIDO_01(double now_NIKKE_AVELONGIDO_01) {
		this.now_NIKKE_AVELONGIDO_01 = now_NIKKE_AVELONGIDO_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_CHANGERATE_01() {
		return now_NIKKE_AVESHORTIDO_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_CHANGERATE_01(
			double now_NIKKE_AVESHORTIDO_CHANGERATE_01) {
		this.now_NIKKE_AVESHORTIDO_CHANGERATE_01 = now_NIKKE_AVESHORTIDO_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_CHANGERATE_01() {
		return now_NIKKE_AVEMIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_CHANGERATE_01(
			double now_NIKKE_AVEMIDDLEIDO_CHANGERATE_01) {
		this.now_NIKKE_AVEMIDDLEIDO_CHANGERATE_01 = now_NIKKE_AVEMIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVELONGIDO_CHANGERATE_01() {
		return now_NIKKE_AVELONGIDO_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVELONGIDO_CHANGERATE_01(
			double now_NIKKE_AVELONGIDO_CHANGERATE_01) {
		this.now_NIKKE_AVELONGIDO_CHANGERATE_01 = now_NIKKE_AVELONGIDO_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_RATIO_01() {
		return now_NIKKE_AVESHORTIDO_RATIO_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_RATIO_01(
			double now_NIKKE_AVESHORTIDO_RATIO_01) {
		this.now_NIKKE_AVESHORTIDO_RATIO_01 = now_NIKKE_AVESHORTIDO_RATIO_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_RATIO_01() {
		return now_NIKKE_AVEMIDDLEIDO_RATIO_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_RATIO_01(
			double now_NIKKE_AVEMIDDLEIDO_RATIO_01) {
		this.now_NIKKE_AVEMIDDLEIDO_RATIO_01 = now_NIKKE_AVEMIDDLEIDO_RATIO_01;
	}

	public double getNow_NIKKE_AVELONGIDO_RATIO_01() {
		return now_NIKKE_AVELONGIDO_RATIO_01;
	}

	public void setNow_NIKKE_AVELONGIDO_RATIO_01(
			double now_NIKKE_AVELONGIDO_RATIO_01) {
		this.now_NIKKE_AVELONGIDO_RATIO_01 = now_NIKKE_AVELONGIDO_RATIO_01;
	}

	public double getNow_NIKKE_AVEMAXMIN_01() {
		return now_NIKKE_AVEMAXMIN_01;
	}

	public void setNow_NIKKE_AVEMAXMIN_01(double now_NIKKE_AVEMAXMIN_01) {
		this.now_NIKKE_AVEMAXMIN_01 = now_NIKKE_AVEMAXMIN_01;
	}

	public double getNow_NIKKE_AVEMAXMINRATIO_01() {
		return now_NIKKE_AVEMAXMINRATIO_01;
	}

	public void setNow_NIKKE_AVEMAXMINRATIO_01(double now_NIKKE_AVEMAXMINRATIO_01) {
		this.now_NIKKE_AVEMAXMINRATIO_01 = now_NIKKE_AVEMAXMINRATIO_01;
	}

	public double getNow_NIKKE_AVECANDLE_AREA_01() {
		return now_NIKKE_AVECANDLE_AREA_01;
	}

	public void setNow_NIKKE_AVECANDLE_AREA_01(double now_NIKKE_AVECANDLE_AREA_01) {
		this.now_NIKKE_AVECANDLE_AREA_01 = now_NIKKE_AVECANDLE_AREA_01;
	}

	public double getNow_NIKKE_AVECANDLE_AREA_SCALE_01() {
		return now_NIKKE_AVECANDLE_AREA_SCALE_01;
	}

	public void setNow_NIKKE_AVECANDLE_AREA_SCALE_01(
			double now_NIKKE_AVECANDLE_AREA_SCALE_01) {
		this.now_NIKKE_AVECANDLE_AREA_SCALE_01 = now_NIKKE_AVECANDLE_AREA_SCALE_01;
	}

	public double getNow_NIKKE_AVEWINDOW_01() {
		return now_NIKKE_AVEWINDOW_01;
	}

	public void setNow_NIKKE_AVEWINDOW_01(double now_NIKKE_AVEWINDOW_01) {
		this.now_NIKKE_AVEWINDOW_01 = now_NIKKE_AVEWINDOW_01;
	}

	public double getNow_NIKKE_AVESHORT_DEV_01() {
		return now_NIKKE_AVESHORT_DEV_01;
	}

	public void setNow_NIKKE_AVESHORT_DEV_01(double now_NIKKE_AVESHORT_DEV_01) {
		this.now_NIKKE_AVESHORT_DEV_01 = now_NIKKE_AVESHORT_DEV_01;
	}

	public double getNow_NIKKE_AVESHORT_NOW_SIGMA_01() {
		return now_NIKKE_AVESHORT_NOW_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_NOW_SIGMA_01(
			double now_NIKKE_AVESHORT_NOW_SIGMA_01) {
		this.now_NIKKE_AVESHORT_NOW_SIGMA_01 = now_NIKKE_AVESHORT_NOW_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_1_H_SIGMA_01() {
		return now_NIKKE_AVESHORT_1_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_1_H_SIGMA_01(
			double now_NIKKE_AVESHORT_1_H_SIGMA_01) {
		this.now_NIKKE_AVESHORT_1_H_SIGMA_01 = now_NIKKE_AVESHORT_1_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_1_L_SIGMA_01() {
		return now_NIKKE_AVESHORT_1_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_1_L_SIGMA_01(
			double now_NIKKE_AVESHORT_1_L_SIGMA_01) {
		this.now_NIKKE_AVESHORT_1_L_SIGMA_01 = now_NIKKE_AVESHORT_1_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_2_H_SIGMA_01() {
		return now_NIKKE_AVESHORT_2_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_2_H_SIGMA_01(
			double now_NIKKE_AVESHORT_2_H_SIGMA_01) {
		this.now_NIKKE_AVESHORT_2_H_SIGMA_01 = now_NIKKE_AVESHORT_2_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_2_L_SIGMA_01() {
		return now_NIKKE_AVESHORT_2_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_2_L_SIGMA_01(
			double now_NIKKE_AVESHORT_2_L_SIGMA_01) {
		this.now_NIKKE_AVESHORT_2_L_SIGMA_01 = now_NIKKE_AVESHORT_2_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_3_H_SIGMA_01() {
		return now_NIKKE_AVESHORT_3_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_3_H_SIGMA_01(
			double now_NIKKE_AVESHORT_3_H_SIGMA_01) {
		this.now_NIKKE_AVESHORT_3_H_SIGMA_01 = now_NIKKE_AVESHORT_3_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORT_3_L_SIGMA_01() {
		return now_NIKKE_AVESHORT_3_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVESHORT_3_L_SIGMA_01(
			double now_NIKKE_AVESHORT_3_L_SIGMA_01) {
		this.now_NIKKE_AVESHORT_3_L_SIGMA_01 = now_NIKKE_AVESHORT_3_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_DEV_01() {
		return now_NIKKE_AVEMIDDLE_DEV_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_DEV_01(double now_NIKKE_AVEMIDDLE_DEV_01) {
		this.now_NIKKE_AVEMIDDLE_DEV_01 = now_NIKKE_AVEMIDDLE_DEV_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_NOW_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_NOW_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_NOW_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_NOW_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_NOW_SIGMA_01 = now_NIKKE_AVEMIDDLE_NOW_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_1_H_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_1_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_1_H_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_1_H_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_1_H_SIGMA_01 = now_NIKKE_AVEMIDDLE_1_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_1_L_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_1_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_1_L_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_1_L_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_1_L_SIGMA_01 = now_NIKKE_AVEMIDDLE_1_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_2_H_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_2_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_2_H_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_2_H_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_2_H_SIGMA_01 = now_NIKKE_AVEMIDDLE_2_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_2_L_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_2_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_2_L_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_2_L_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_2_L_SIGMA_01 = now_NIKKE_AVEMIDDLE_2_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_3_H_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_3_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_3_H_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_3_H_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_3_H_SIGMA_01 = now_NIKKE_AVEMIDDLE_3_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_3_L_SIGMA_01() {
		return now_NIKKE_AVEMIDDLE_3_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_3_L_SIGMA_01(
			double now_NIKKE_AVEMIDDLE_3_L_SIGMA_01) {
		this.now_NIKKE_AVEMIDDLE_3_L_SIGMA_01 = now_NIKKE_AVEMIDDLE_3_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_DEV_01() {
		return now_NIKKE_AVELONG_DEV_01;
	}

	public void setNow_NIKKE_AVELONG_DEV_01(double now_NIKKE_AVELONG_DEV_01) {
		this.now_NIKKE_AVELONG_DEV_01 = now_NIKKE_AVELONG_DEV_01;
	}

	public double getNow_NIKKE_AVELONG_NOW_SIGMA_01() {
		return now_NIKKE_AVELONG_NOW_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_NOW_SIGMA_01(
			double now_NIKKE_AVELONG_NOW_SIGMA_01) {
		this.now_NIKKE_AVELONG_NOW_SIGMA_01 = now_NIKKE_AVELONG_NOW_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_1_H_SIGMA_01() {
		return now_NIKKE_AVELONG_1_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_1_H_SIGMA_01(
			double now_NIKKE_AVELONG_1_H_SIGMA_01) {
		this.now_NIKKE_AVELONG_1_H_SIGMA_01 = now_NIKKE_AVELONG_1_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_1_L_SIGMA_01() {
		return now_NIKKE_AVELONG_1_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_1_L_SIGMA_01(
			double now_NIKKE_AVELONG_1_L_SIGMA_01) {
		this.now_NIKKE_AVELONG_1_L_SIGMA_01 = now_NIKKE_AVELONG_1_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_2_H_SIGMA_01() {
		return now_NIKKE_AVELONG_2_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_2_H_SIGMA_01(
			double now_NIKKE_AVELONG_2_H_SIGMA_01) {
		this.now_NIKKE_AVELONG_2_H_SIGMA_01 = now_NIKKE_AVELONG_2_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_2_L_SIGMA_01() {
		return now_NIKKE_AVELONG_2_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_2_L_SIGMA_01(
			double now_NIKKE_AVELONG_2_L_SIGMA_01) {
		this.now_NIKKE_AVELONG_2_L_SIGMA_01 = now_NIKKE_AVELONG_2_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_3_H_SIGMA_01() {
		return now_NIKKE_AVELONG_3_H_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_3_H_SIGMA_01(
			double now_NIKKE_AVELONG_3_H_SIGMA_01) {
		this.now_NIKKE_AVELONG_3_H_SIGMA_01 = now_NIKKE_AVELONG_3_H_SIGMA_01;
	}

	public double getNow_NIKKE_AVELONG_3_L_SIGMA_01() {
		return now_NIKKE_AVELONG_3_L_SIGMA_01;
	}

	public void setNow_NIKKE_AVELONG_3_L_SIGMA_01(
			double now_NIKKE_AVELONG_3_L_SIGMA_01) {
		this.now_NIKKE_AVELONG_3_L_SIGMA_01 = now_NIKKE_AVELONG_3_L_SIGMA_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_HEKATU_01() {
		return now_NIKKE_AVESHORTIDO_HEKATU_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_HEKATU_01(
			double now_NIKKE_AVESHORTIDO_HEKATU_01) {
		this.now_NIKKE_AVESHORTIDO_HEKATU_01 = now_NIKKE_AVESHORTIDO_HEKATU_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_HEKATU_01() {
		return now_NIKKE_AVEMIDDLEIDO_HEKATU_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_HEKATU_01(
			double now_NIKKE_AVEMIDDLEIDO_HEKATU_01) {
		this.now_NIKKE_AVEMIDDLEIDO_HEKATU_01 = now_NIKKE_AVEMIDDLEIDO_HEKATU_01;
	}

	public double getNow_NIKKE_AVELONGIDO_HEKATU_01() {
		return now_NIKKE_AVELONGIDO_HEKATU_01;
	}

	public void setNow_NIKKE_AVELONGIDO_HEKATU_01(
			double now_NIKKE_AVELONGIDO_HEKATU_01) {
		this.now_NIKKE_AVELONGIDO_HEKATU_01 = now_NIKKE_AVELONGIDO_HEKATU_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01() {
		return now_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01(
			double now_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01 = now_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01 = now_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01() {
		return now_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01(
			double now_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01) {
		this.now_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01 = now_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_NIKKE_AVESHORTIDO_HEKATU_RATIO_01() {
		return now_NIKKE_AVESHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_NIKKE_AVESHORTIDO_HEKATU_RATIO_01(
			double now_NIKKE_AVESHORTIDO_HEKATU_RATIO_01) {
		this.now_NIKKE_AVESHORTIDO_HEKATU_RATIO_01 = now_NIKKE_AVESHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01() {
		return now_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01(
			double now_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01) {
		this.now_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01 = now_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_NIKKE_AVELONGIDO_HEKATU_RATIO_01() {
		return now_NIKKE_AVELONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_NIKKE_AVELONGIDO_HEKATU_RATIO_01(
			double now_NIKKE_AVELONGIDO_HEKATU_RATIO_01) {
		this.now_NIKKE_AVELONGIDO_HEKATU_RATIO_01 = now_NIKKE_AVELONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_NIKKE_AVESHORT_MACD_01() {
		return now_NIKKE_AVESHORT_MACD_01;
	}

	public void setNow_NIKKE_AVESHORT_MACD_01(double now_NIKKE_AVESHORT_MACD_01) {
		this.now_NIKKE_AVESHORT_MACD_01 = now_NIKKE_AVESHORT_MACD_01;
	}

	public double getNow_NIKKE_AVESHORT_MACD_SIGNAL_01() {
		return now_NIKKE_AVESHORT_MACD_SIGNAL_01;
	}

	public void setNow_NIKKE_AVESHORT_MACD_SIGNAL_01(
			double now_NIKKE_AVESHORT_MACD_SIGNAL_01) {
		this.now_NIKKE_AVESHORT_MACD_SIGNAL_01 = now_NIKKE_AVESHORT_MACD_SIGNAL_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_MACD_01() {
		return now_NIKKE_AVEMIDDLE_MACD_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_MACD_01(double now_NIKKE_AVEMIDDLE_MACD_01) {
		this.now_NIKKE_AVEMIDDLE_MACD_01 = now_NIKKE_AVEMIDDLE_MACD_01;
	}

	public double getNow_NIKKE_AVEMIDDLE_MACD_SIGNAL_01() {
		return now_NIKKE_AVEMIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_NIKKE_AVEMIDDLE_MACD_SIGNAL_01(
			double now_NIKKE_AVEMIDDLE_MACD_SIGNAL_01) {
		this.now_NIKKE_AVEMIDDLE_MACD_SIGNAL_01 = now_NIKKE_AVEMIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_NIKKE_AVELONG_MACD_01() {
		return now_NIKKE_AVELONG_MACD_01;
	}

	public void setNow_NIKKE_AVELONG_MACD_01(double now_NIKKE_AVELONG_MACD_01) {
		this.now_NIKKE_AVELONG_MACD_01 = now_NIKKE_AVELONG_MACD_01;
	}

	public double getNow_NIKKE_AVELONG_MACD_SIGNAL_01() {
		return now_NIKKE_AVELONG_MACD_SIGNAL_01;
	}

	public void setNow_NIKKE_AVELONG_MACD_SIGNAL_01(
			double now_NIKKE_AVELONG_MACD_SIGNAL_01) {
		this.now_NIKKE_AVELONG_MACD_SIGNAL_01 = now_NIKKE_AVELONG_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_Open_01() {
		return now_TOPIX_Open_01;
	}

	public void setNow_TOPIX_Open_01(double now_TOPIX_Open_01) {
		this.now_TOPIX_Open_01 = now_TOPIX_Open_01;
	}

	public double getNow_TOPIX_MAX_01() {
		return now_TOPIX_MAX_01;
	}

	public void setNow_TOPIX_MAX_01(double now_TOPIX_MAX_01) {
		this.now_TOPIX_MAX_01 = now_TOPIX_MAX_01;
	}

	public double getNow_TOPIX_MIN_01() {
		return now_TOPIX_MIN_01;
	}

	public void setNow_TOPIX_MIN_01(double now_TOPIX_MIN_01) {
		this.now_TOPIX_MIN_01 = now_TOPIX_MIN_01;
	}

	public double getNow_TOPIX_CLOSE_01() {
		return now_TOPIX_CLOSE_01;
	}

	public void setNow_TOPIX_CLOSE_01(double now_TOPIX_CLOSE_01) {
		this.now_TOPIX_CLOSE_01 = now_TOPIX_CLOSE_01;
	}

	public double getNow_TOPIX_CHANGE_PRICE_01() {
		return now_TOPIX_CHANGE_PRICE_01;
	}

	public void setNow_TOPIX_CHANGE_PRICE_01(double now_TOPIX_CHANGE_PRICE_01) {
		this.now_TOPIX_CHANGE_PRICE_01 = now_TOPIX_CHANGE_PRICE_01;
	}

	public double getNow_TOPIX_CHANGERATE_01() {
		return now_TOPIX_CHANGERATE_01;
	}

	public void setNow_TOPIX_CHANGERATE_01(double now_TOPIX_CHANGERATE_01) {
		this.now_TOPIX_CHANGERATE_01 = now_TOPIX_CHANGERATE_01;
	}

	public double getNow_TOPIX_SHORTIDO_01() {
		return now_TOPIX_SHORTIDO_01;
	}

	public void setNow_TOPIX_SHORTIDO_01(double now_TOPIX_SHORTIDO_01) {
		this.now_TOPIX_SHORTIDO_01 = now_TOPIX_SHORTIDO_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_01() {
		return now_TOPIX_MIDDLEIDO_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_01(double now_TOPIX_MIDDLEIDO_01) {
		this.now_TOPIX_MIDDLEIDO_01 = now_TOPIX_MIDDLEIDO_01;
	}

	public double getNow_TOPIX_LONGIDO_01() {
		return now_TOPIX_LONGIDO_01;
	}

	public void setNow_TOPIX_LONGIDO_01(double now_TOPIX_LONGIDO_01) {
		this.now_TOPIX_LONGIDO_01 = now_TOPIX_LONGIDO_01;
	}

	public double getNow_TOPIX_SHORTIDO_CHANGERATE_01() {
		return now_TOPIX_SHORTIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_SHORTIDO_CHANGERATE_01(
			double now_TOPIX_SHORTIDO_CHANGERATE_01) {
		this.now_TOPIX_SHORTIDO_CHANGERATE_01 = now_TOPIX_SHORTIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_CHANGERATE_01() {
		return now_TOPIX_MIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_CHANGERATE_01(
			double now_TOPIX_MIDDLEIDO_CHANGERATE_01) {
		this.now_TOPIX_MIDDLEIDO_CHANGERATE_01 = now_TOPIX_MIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_LONGIDO_CHANGERATE_01() {
		return now_TOPIX_LONGIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_LONGIDO_CHANGERATE_01(
			double now_TOPIX_LONGIDO_CHANGERATE_01) {
		this.now_TOPIX_LONGIDO_CHANGERATE_01 = now_TOPIX_LONGIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_SHORTIDO_RATIO_01() {
		return now_TOPIX_SHORTIDO_RATIO_01;
	}

	public void setNow_TOPIX_SHORTIDO_RATIO_01(double now_TOPIX_SHORTIDO_RATIO_01) {
		this.now_TOPIX_SHORTIDO_RATIO_01 = now_TOPIX_SHORTIDO_RATIO_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_RATIO_01() {
		return now_TOPIX_MIDDLEIDO_RATIO_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_RATIO_01(double now_TOPIX_MIDDLEIDO_RATIO_01) {
		this.now_TOPIX_MIDDLEIDO_RATIO_01 = now_TOPIX_MIDDLEIDO_RATIO_01;
	}

	public double getNow_TOPIX_LONGIDO_RATIO_01() {
		return now_TOPIX_LONGIDO_RATIO_01;
	}

	public void setNow_TOPIX_LONGIDO_RATIO_01(double now_TOPIX_LONGIDO_RATIO_01) {
		this.now_TOPIX_LONGIDO_RATIO_01 = now_TOPIX_LONGIDO_RATIO_01;
	}

	public double getNow_TOPIX_MAXMIN_01() {
		return now_TOPIX_MAXMIN_01;
	}

	public void setNow_TOPIX_MAXMIN_01(double now_TOPIX_MAXMIN_01) {
		this.now_TOPIX_MAXMIN_01 = now_TOPIX_MAXMIN_01;
	}

	public double getNow_TOPIX_MAXMINRATIO_01() {
		return now_TOPIX_MAXMINRATIO_01;
	}

	public void setNow_TOPIX_MAXMINRATIO_01(double now_TOPIX_MAXMINRATIO_01) {
		this.now_TOPIX_MAXMINRATIO_01 = now_TOPIX_MAXMINRATIO_01;
	}

	public double getNow_TOPIX_CANDLE_AREA_01() {
		return now_TOPIX_CANDLE_AREA_01;
	}

	public void setNow_TOPIX_CANDLE_AREA_01(double now_TOPIX_CANDLE_AREA_01) {
		this.now_TOPIX_CANDLE_AREA_01 = now_TOPIX_CANDLE_AREA_01;
	}

	public double getNow_TOPIX_CANDLE_AREA_SCALE_01() {
		return now_TOPIX_CANDLE_AREA_SCALE_01;
	}

	public void setNow_TOPIX_CANDLE_AREA_SCALE_01(
			double now_TOPIX_CANDLE_AREA_SCALE_01) {
		this.now_TOPIX_CANDLE_AREA_SCALE_01 = now_TOPIX_CANDLE_AREA_SCALE_01;
	}

	public double getNow_TOPIX_WINDOW_01() {
		return now_TOPIX_WINDOW_01;
	}

	public void setNow_TOPIX_WINDOW_01(double now_TOPIX_WINDOW_01) {
		this.now_TOPIX_WINDOW_01 = now_TOPIX_WINDOW_01;
	}

	public double getNow_TOPIX_SHORT_DEV_01() {
		return now_TOPIX_SHORT_DEV_01;
	}

	public void setNow_TOPIX_SHORT_DEV_01(double now_TOPIX_SHORT_DEV_01) {
		this.now_TOPIX_SHORT_DEV_01 = now_TOPIX_SHORT_DEV_01;
	}

	public double getNow_TOPIX_SHORT_NOW_SIGMA_01() {
		return now_TOPIX_SHORT_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_NOW_SIGMA_01(double now_TOPIX_SHORT_NOW_SIGMA_01) {
		this.now_TOPIX_SHORT_NOW_SIGMA_01 = now_TOPIX_SHORT_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_1_H_SIGMA_01() {
		return now_TOPIX_SHORT_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_1_H_SIGMA_01(double now_TOPIX_SHORT_1_H_SIGMA_01) {
		this.now_TOPIX_SHORT_1_H_SIGMA_01 = now_TOPIX_SHORT_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_1_L_SIGMA_01() {
		return now_TOPIX_SHORT_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_1_L_SIGMA_01(double now_TOPIX_SHORT_1_L_SIGMA_01) {
		this.now_TOPIX_SHORT_1_L_SIGMA_01 = now_TOPIX_SHORT_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_2_H_SIGMA_01() {
		return now_TOPIX_SHORT_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_2_H_SIGMA_01(double now_TOPIX_SHORT_2_H_SIGMA_01) {
		this.now_TOPIX_SHORT_2_H_SIGMA_01 = now_TOPIX_SHORT_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_2_L_SIGMA_01() {
		return now_TOPIX_SHORT_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_2_L_SIGMA_01(double now_TOPIX_SHORT_2_L_SIGMA_01) {
		this.now_TOPIX_SHORT_2_L_SIGMA_01 = now_TOPIX_SHORT_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_3_H_SIGMA_01() {
		return now_TOPIX_SHORT_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_3_H_SIGMA_01(double now_TOPIX_SHORT_3_H_SIGMA_01) {
		this.now_TOPIX_SHORT_3_H_SIGMA_01 = now_TOPIX_SHORT_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_SHORT_3_L_SIGMA_01() {
		return now_TOPIX_SHORT_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_SHORT_3_L_SIGMA_01(double now_TOPIX_SHORT_3_L_SIGMA_01) {
		this.now_TOPIX_SHORT_3_L_SIGMA_01 = now_TOPIX_SHORT_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_DEV_01() {
		return now_TOPIX_MIDDLE_DEV_01;
	}

	public void setNow_TOPIX_MIDDLE_DEV_01(double now_TOPIX_MIDDLE_DEV_01) {
		this.now_TOPIX_MIDDLE_DEV_01 = now_TOPIX_MIDDLE_DEV_01;
	}

	public double getNow_TOPIX_MIDDLE_NOW_SIGMA_01() {
		return now_TOPIX_MIDDLE_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_NOW_SIGMA_01(
			double now_TOPIX_MIDDLE_NOW_SIGMA_01) {
		this.now_TOPIX_MIDDLE_NOW_SIGMA_01 = now_TOPIX_MIDDLE_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_1_H_SIGMA_01() {
		return now_TOPIX_MIDDLE_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_1_H_SIGMA_01(
			double now_TOPIX_MIDDLE_1_H_SIGMA_01) {
		this.now_TOPIX_MIDDLE_1_H_SIGMA_01 = now_TOPIX_MIDDLE_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_1_L_SIGMA_01() {
		return now_TOPIX_MIDDLE_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_1_L_SIGMA_01(
			double now_TOPIX_MIDDLE_1_L_SIGMA_01) {
		this.now_TOPIX_MIDDLE_1_L_SIGMA_01 = now_TOPIX_MIDDLE_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_2_H_SIGMA_01() {
		return now_TOPIX_MIDDLE_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_2_H_SIGMA_01(
			double now_TOPIX_MIDDLE_2_H_SIGMA_01) {
		this.now_TOPIX_MIDDLE_2_H_SIGMA_01 = now_TOPIX_MIDDLE_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_2_L_SIGMA_01() {
		return now_TOPIX_MIDDLE_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_2_L_SIGMA_01(
			double now_TOPIX_MIDDLE_2_L_SIGMA_01) {
		this.now_TOPIX_MIDDLE_2_L_SIGMA_01 = now_TOPIX_MIDDLE_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_3_H_SIGMA_01() {
		return now_TOPIX_MIDDLE_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_3_H_SIGMA_01(
			double now_TOPIX_MIDDLE_3_H_SIGMA_01) {
		this.now_TOPIX_MIDDLE_3_H_SIGMA_01 = now_TOPIX_MIDDLE_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_MIDDLE_3_L_SIGMA_01() {
		return now_TOPIX_MIDDLE_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_MIDDLE_3_L_SIGMA_01(
			double now_TOPIX_MIDDLE_3_L_SIGMA_01) {
		this.now_TOPIX_MIDDLE_3_L_SIGMA_01 = now_TOPIX_MIDDLE_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_DEV_01() {
		return now_TOPIX_LONG_DEV_01;
	}

	public void setNow_TOPIX_LONG_DEV_01(double now_TOPIX_LONG_DEV_01) {
		this.now_TOPIX_LONG_DEV_01 = now_TOPIX_LONG_DEV_01;
	}

	public double getNow_TOPIX_LONG_NOW_SIGMA_01() {
		return now_TOPIX_LONG_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_NOW_SIGMA_01(double now_TOPIX_LONG_NOW_SIGMA_01) {
		this.now_TOPIX_LONG_NOW_SIGMA_01 = now_TOPIX_LONG_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_1_H_SIGMA_01() {
		return now_TOPIX_LONG_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_1_H_SIGMA_01(double now_TOPIX_LONG_1_H_SIGMA_01) {
		this.now_TOPIX_LONG_1_H_SIGMA_01 = now_TOPIX_LONG_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_1_L_SIGMA_01() {
		return now_TOPIX_LONG_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_1_L_SIGMA_01(double now_TOPIX_LONG_1_L_SIGMA_01) {
		this.now_TOPIX_LONG_1_L_SIGMA_01 = now_TOPIX_LONG_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_2_H_SIGMA_01() {
		return now_TOPIX_LONG_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_2_H_SIGMA_01(double now_TOPIX_LONG_2_H_SIGMA_01) {
		this.now_TOPIX_LONG_2_H_SIGMA_01 = now_TOPIX_LONG_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_2_L_SIGMA_01() {
		return now_TOPIX_LONG_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_2_L_SIGMA_01(double now_TOPIX_LONG_2_L_SIGMA_01) {
		this.now_TOPIX_LONG_2_L_SIGMA_01 = now_TOPIX_LONG_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_3_H_SIGMA_01() {
		return now_TOPIX_LONG_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_3_H_SIGMA_01(double now_TOPIX_LONG_3_H_SIGMA_01) {
		this.now_TOPIX_LONG_3_H_SIGMA_01 = now_TOPIX_LONG_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_LONG_3_L_SIGMA_01() {
		return now_TOPIX_LONG_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_LONG_3_L_SIGMA_01(double now_TOPIX_LONG_3_L_SIGMA_01) {
		this.now_TOPIX_LONG_3_L_SIGMA_01 = now_TOPIX_LONG_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_SHORTIDO_HEKATU_01() {
		return now_TOPIX_SHORTIDO_HEKATU_01;
	}

	public void setNow_TOPIX_SHORTIDO_HEKATU_01(double now_TOPIX_SHORTIDO_HEKATU_01) {
		this.now_TOPIX_SHORTIDO_HEKATU_01 = now_TOPIX_SHORTIDO_HEKATU_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_HEKATU_01() {
		return now_TOPIX_MIDDLEIDO_HEKATU_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_HEKATU_01(
			double now_TOPIX_MIDDLEIDO_HEKATU_01) {
		this.now_TOPIX_MIDDLEIDO_HEKATU_01 = now_TOPIX_MIDDLEIDO_HEKATU_01;
	}

	public double getNow_TOPIX_LONGIDO_HEKATU_01() {
		return now_TOPIX_LONGIDO_HEKATU_01;
	}

	public void setNow_TOPIX_LONGIDO_HEKATU_01(double now_TOPIX_LONGIDO_HEKATU_01) {
		this.now_TOPIX_LONGIDO_HEKATU_01 = now_TOPIX_LONGIDO_HEKATU_01;
	}

	public double getNow_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01 = now_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01 = now_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_LONGIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_LONGIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_LONGIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_LONGIDO_HEKATU_CHANGERATE_01 = now_TOPIX_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_SHORTIDO_HEKATU_RATIO_01() {
		return now_TOPIX_SHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_SHORTIDO_HEKATU_RATIO_01(
			double now_TOPIX_SHORTIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_SHORTIDO_HEKATU_RATIO_01 = now_TOPIX_SHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_MIDDLEIDO_HEKATU_RATIO_01() {
		return now_TOPIX_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_MIDDLEIDO_HEKATU_RATIO_01(
			double now_TOPIX_MIDDLEIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_MIDDLEIDO_HEKATU_RATIO_01 = now_TOPIX_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_LONGIDO_HEKATU_RATIO_01() {
		return now_TOPIX_LONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_LONGIDO_HEKATU_RATIO_01(
			double now_TOPIX_LONGIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_LONGIDO_HEKATU_RATIO_01 = now_TOPIX_LONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_SHORT_MACD_01() {
		return now_TOPIX_SHORT_MACD_01;
	}

	public void setNow_TOPIX_SHORT_MACD_01(double now_TOPIX_SHORT_MACD_01) {
		this.now_TOPIX_SHORT_MACD_01 = now_TOPIX_SHORT_MACD_01;
	}

	public double getNow_TOPIX_SHORT_MACD_SIGNAL_01() {
		return now_TOPIX_SHORT_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_SHORT_MACD_SIGNAL_01(
			double now_TOPIX_SHORT_MACD_SIGNAL_01) {
		this.now_TOPIX_SHORT_MACD_SIGNAL_01 = now_TOPIX_SHORT_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_MIDDLE_MACD_01() {
		return now_TOPIX_MIDDLE_MACD_01;
	}

	public void setNow_TOPIX_MIDDLE_MACD_01(double now_TOPIX_MIDDLE_MACD_01) {
		this.now_TOPIX_MIDDLE_MACD_01 = now_TOPIX_MIDDLE_MACD_01;
	}

	public double getNow_TOPIX_MIDDLE_MACD_SIGNAL_01() {
		return now_TOPIX_MIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_MIDDLE_MACD_SIGNAL_01(
			double now_TOPIX_MIDDLE_MACD_SIGNAL_01) {
		this.now_TOPIX_MIDDLE_MACD_SIGNAL_01 = now_TOPIX_MIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_LONG_MACD_01() {
		return now_TOPIX_LONG_MACD_01;
	}

	public void setNow_TOPIX_LONG_MACD_01(double now_TOPIX_LONG_MACD_01) {
		this.now_TOPIX_LONG_MACD_01 = now_TOPIX_LONG_MACD_01;
	}

	public double getNow_TOPIX_LONG_MACD_SIGNAL_01() {
		return now_TOPIX_LONG_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_LONG_MACD_SIGNAL_01(
			double now_TOPIX_LONG_MACD_SIGNAL_01) {
		this.now_TOPIX_LONG_MACD_SIGNAL_01 = now_TOPIX_LONG_MACD_SIGNAL_01;
	}

	public double getNow_CORE30_Open_01() {
		return now_CORE30_Open_01;
	}

	public void setNow_CORE30_Open_01(double now_CORE30_Open_01) {
		this.now_CORE30_Open_01 = now_CORE30_Open_01;
	}

	public double getNow_CORE30_MAX_01() {
		return now_CORE30_MAX_01;
	}

	public void setNow_CORE30_MAX_01(double now_CORE30_MAX_01) {
		this.now_CORE30_MAX_01 = now_CORE30_MAX_01;
	}

	public double getNow_CORE30_MIN_01() {
		return now_CORE30_MIN_01;
	}

	public void setNow_CORE30_MIN_01(double now_CORE30_MIN_01) {
		this.now_CORE30_MIN_01 = now_CORE30_MIN_01;
	}

	public double getNow_CORE30_CLOSE_01() {
		return now_CORE30_CLOSE_01;
	}

	public void setNow_CORE30_CLOSE_01(double now_CORE30_CLOSE_01) {
		this.now_CORE30_CLOSE_01 = now_CORE30_CLOSE_01;
	}

	public double getNow_CORE30_CHANGE_PRICE_01() {
		return now_CORE30_CHANGE_PRICE_01;
	}

	public void setNow_CORE30_CHANGE_PRICE_01(double now_CORE30_CHANGE_PRICE_01) {
		this.now_CORE30_CHANGE_PRICE_01 = now_CORE30_CHANGE_PRICE_01;
	}

	public double getNow_CORE30_CHANGERATE_01() {
		return now_CORE30_CHANGERATE_01;
	}

	public void setNow_CORE30_CHANGERATE_01(double now_CORE30_CHANGERATE_01) {
		this.now_CORE30_CHANGERATE_01 = now_CORE30_CHANGERATE_01;
	}

	public double getNow_CORE30_SHORTIDO_01() {
		return now_CORE30_SHORTIDO_01;
	}

	public void setNow_CORE30_SHORTIDO_01(double now_CORE30_SHORTIDO_01) {
		this.now_CORE30_SHORTIDO_01 = now_CORE30_SHORTIDO_01;
	}

	public double getNow_CORE30_MIDDLEIDO_01() {
		return now_CORE30_MIDDLEIDO_01;
	}

	public void setNow_CORE30_MIDDLEIDO_01(double now_CORE30_MIDDLEIDO_01) {
		this.now_CORE30_MIDDLEIDO_01 = now_CORE30_MIDDLEIDO_01;
	}

	public double getNow_CORE30_LONGIDO_01() {
		return now_CORE30_LONGIDO_01;
	}

	public void setNow_CORE30_LONGIDO_01(double now_CORE30_LONGIDO_01) {
		this.now_CORE30_LONGIDO_01 = now_CORE30_LONGIDO_01;
	}

	public double getNow_CORE30_SHORTIDO_CHANGERATE_01() {
		return now_CORE30_SHORTIDO_CHANGERATE_01;
	}

	public void setNow_CORE30_SHORTIDO_CHANGERATE_01(
			double now_CORE30_SHORTIDO_CHANGERATE_01) {
		this.now_CORE30_SHORTIDO_CHANGERATE_01 = now_CORE30_SHORTIDO_CHANGERATE_01;
	}

	public double getNow_CORE30_MIDDLEIDO_CHANGERATE_01() {
		return now_CORE30_MIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_CORE30_MIDDLEIDO_CHANGERATE_01(
			double now_CORE30_MIDDLEIDO_CHANGERATE_01) {
		this.now_CORE30_MIDDLEIDO_CHANGERATE_01 = now_CORE30_MIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_CORE30_LONGIDO_CHANGERATE_01() {
		return now_CORE30_LONGIDO_CHANGERATE_01;
	}

	public void setNow_CORE30_LONGIDO_CHANGERATE_01(
			double now_CORE30_LONGIDO_CHANGERATE_01) {
		this.now_CORE30_LONGIDO_CHANGERATE_01 = now_CORE30_LONGIDO_CHANGERATE_01;
	}

	public double getNow_CORE30_SHORTIDO_RATIO_01() {
		return now_CORE30_SHORTIDO_RATIO_01;
	}

	public void setNow_CORE30_SHORTIDO_RATIO_01(double now_CORE30_SHORTIDO_RATIO_01) {
		this.now_CORE30_SHORTIDO_RATIO_01 = now_CORE30_SHORTIDO_RATIO_01;
	}

	public double getNow_CORE30_MIDDLEIDO_RATIO_01() {
		return now_CORE30_MIDDLEIDO_RATIO_01;
	}

	public void setNow_CORE30_MIDDLEIDO_RATIO_01(
			double now_CORE30_MIDDLEIDO_RATIO_01) {
		this.now_CORE30_MIDDLEIDO_RATIO_01 = now_CORE30_MIDDLEIDO_RATIO_01;
	}

	public double getNow_CORE30_LONGIDO_RATIO_01() {
		return now_CORE30_LONGIDO_RATIO_01;
	}

	public void setNow_CORE30_LONGIDO_RATIO_01(double now_CORE30_LONGIDO_RATIO_01) {
		this.now_CORE30_LONGIDO_RATIO_01 = now_CORE30_LONGIDO_RATIO_01;
	}

	public double getNow_CORE30_MAXMIN_01() {
		return now_CORE30_MAXMIN_01;
	}

	public void setNow_CORE30_MAXMIN_01(double now_CORE30_MAXMIN_01) {
		this.now_CORE30_MAXMIN_01 = now_CORE30_MAXMIN_01;
	}

	public double getNow_CORE30_MAXMINRATIO_01() {
		return now_CORE30_MAXMINRATIO_01;
	}

	public void setNow_CORE30_MAXMINRATIO_01(double now_CORE30_MAXMINRATIO_01) {
		this.now_CORE30_MAXMINRATIO_01 = now_CORE30_MAXMINRATIO_01;
	}

	public double getNow_CORE30_CANDLE_AREA_01() {
		return now_CORE30_CANDLE_AREA_01;
	}

	public void setNow_CORE30_CANDLE_AREA_01(double now_CORE30_CANDLE_AREA_01) {
		this.now_CORE30_CANDLE_AREA_01 = now_CORE30_CANDLE_AREA_01;
	}

	public double getNow_CORE30_CANDLE_AREA_SCALE_01() {
		return now_CORE30_CANDLE_AREA_SCALE_01;
	}

	public void setNow_CORE30_CANDLE_AREA_SCALE_01(
			double now_CORE30_CANDLE_AREA_SCALE_01) {
		this.now_CORE30_CANDLE_AREA_SCALE_01 = now_CORE30_CANDLE_AREA_SCALE_01;
	}

	public double getNow_CORE30_WINDOW_01() {
		return now_CORE30_WINDOW_01;
	}

	public void setNow_CORE30_WINDOW_01(double now_CORE30_WINDOW_01) {
		this.now_CORE30_WINDOW_01 = now_CORE30_WINDOW_01;
	}

	public double getNow_CORE30_SHORT_DEV_01() {
		return now_CORE30_SHORT_DEV_01;
	}

	public void setNow_CORE30_SHORT_DEV_01(double now_CORE30_SHORT_DEV_01) {
		this.now_CORE30_SHORT_DEV_01 = now_CORE30_SHORT_DEV_01;
	}

	public double getNow_CORE30_SHORT_NOW_SIGMA_01() {
		return now_CORE30_SHORT_NOW_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_NOW_SIGMA_01(
			double now_CORE30_SHORT_NOW_SIGMA_01) {
		this.now_CORE30_SHORT_NOW_SIGMA_01 = now_CORE30_SHORT_NOW_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_1_H_SIGMA_01() {
		return now_CORE30_SHORT_1_H_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_1_H_SIGMA_01(
			double now_CORE30_SHORT_1_H_SIGMA_01) {
		this.now_CORE30_SHORT_1_H_SIGMA_01 = now_CORE30_SHORT_1_H_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_1_L_SIGMA_01() {
		return now_CORE30_SHORT_1_L_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_1_L_SIGMA_01(
			double now_CORE30_SHORT_1_L_SIGMA_01) {
		this.now_CORE30_SHORT_1_L_SIGMA_01 = now_CORE30_SHORT_1_L_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_2_H_SIGMA_01() {
		return now_CORE30_SHORT_2_H_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_2_H_SIGMA_01(
			double now_CORE30_SHORT_2_H_SIGMA_01) {
		this.now_CORE30_SHORT_2_H_SIGMA_01 = now_CORE30_SHORT_2_H_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_2_L_SIGMA_01() {
		return now_CORE30_SHORT_2_L_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_2_L_SIGMA_01(
			double now_CORE30_SHORT_2_L_SIGMA_01) {
		this.now_CORE30_SHORT_2_L_SIGMA_01 = now_CORE30_SHORT_2_L_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_3_H_SIGMA_01() {
		return now_CORE30_SHORT_3_H_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_3_H_SIGMA_01(
			double now_CORE30_SHORT_3_H_SIGMA_01) {
		this.now_CORE30_SHORT_3_H_SIGMA_01 = now_CORE30_SHORT_3_H_SIGMA_01;
	}

	public double getNow_CORE30_SHORT_3_L_SIGMA_01() {
		return now_CORE30_SHORT_3_L_SIGMA_01;
	}

	public void setNow_CORE30_SHORT_3_L_SIGMA_01(
			double now_CORE30_SHORT_3_L_SIGMA_01) {
		this.now_CORE30_SHORT_3_L_SIGMA_01 = now_CORE30_SHORT_3_L_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_DEV_01() {
		return now_CORE30_MIDDLE_DEV_01;
	}

	public void setNow_CORE30_MIDDLE_DEV_01(double now_CORE30_MIDDLE_DEV_01) {
		this.now_CORE30_MIDDLE_DEV_01 = now_CORE30_MIDDLE_DEV_01;
	}

	public double getNow_CORE30_MIDDLE_NOW_SIGMA_01() {
		return now_CORE30_MIDDLE_NOW_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_NOW_SIGMA_01(
			double now_CORE30_MIDDLE_NOW_SIGMA_01) {
		this.now_CORE30_MIDDLE_NOW_SIGMA_01 = now_CORE30_MIDDLE_NOW_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_1_H_SIGMA_01() {
		return now_CORE30_MIDDLE_1_H_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_1_H_SIGMA_01(
			double now_CORE30_MIDDLE_1_H_SIGMA_01) {
		this.now_CORE30_MIDDLE_1_H_SIGMA_01 = now_CORE30_MIDDLE_1_H_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_1_L_SIGMA_01() {
		return now_CORE30_MIDDLE_1_L_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_1_L_SIGMA_01(
			double now_CORE30_MIDDLE_1_L_SIGMA_01) {
		this.now_CORE30_MIDDLE_1_L_SIGMA_01 = now_CORE30_MIDDLE_1_L_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_2_H_SIGMA_01() {
		return now_CORE30_MIDDLE_2_H_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_2_H_SIGMA_01(
			double now_CORE30_MIDDLE_2_H_SIGMA_01) {
		this.now_CORE30_MIDDLE_2_H_SIGMA_01 = now_CORE30_MIDDLE_2_H_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_2_L_SIGMA_01() {
		return now_CORE30_MIDDLE_2_L_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_2_L_SIGMA_01(
			double now_CORE30_MIDDLE_2_L_SIGMA_01) {
		this.now_CORE30_MIDDLE_2_L_SIGMA_01 = now_CORE30_MIDDLE_2_L_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_3_H_SIGMA_01() {
		return now_CORE30_MIDDLE_3_H_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_3_H_SIGMA_01(
			double now_CORE30_MIDDLE_3_H_SIGMA_01) {
		this.now_CORE30_MIDDLE_3_H_SIGMA_01 = now_CORE30_MIDDLE_3_H_SIGMA_01;
	}

	public double getNow_CORE30_MIDDLE_3_L_SIGMA_01() {
		return now_CORE30_MIDDLE_3_L_SIGMA_01;
	}

	public void setNow_CORE30_MIDDLE_3_L_SIGMA_01(
			double now_CORE30_MIDDLE_3_L_SIGMA_01) {
		this.now_CORE30_MIDDLE_3_L_SIGMA_01 = now_CORE30_MIDDLE_3_L_SIGMA_01;
	}

	public double getNow_CORE30_LONG_DEV_01() {
		return now_CORE30_LONG_DEV_01;
	}

	public void setNow_CORE30_LONG_DEV_01(double now_CORE30_LONG_DEV_01) {
		this.now_CORE30_LONG_DEV_01 = now_CORE30_LONG_DEV_01;
	}

	public double getNow_CORE30_LONG_NOW_SIGMA_01() {
		return now_CORE30_LONG_NOW_SIGMA_01;
	}

	public void setNow_CORE30_LONG_NOW_SIGMA_01(double now_CORE30_LONG_NOW_SIGMA_01) {
		this.now_CORE30_LONG_NOW_SIGMA_01 = now_CORE30_LONG_NOW_SIGMA_01;
	}

	public double getNow_CORE30_LONG_1_H_SIGMA_01() {
		return now_CORE30_LONG_1_H_SIGMA_01;
	}

	public void setNow_CORE30_LONG_1_H_SIGMA_01(double now_CORE30_LONG_1_H_SIGMA_01) {
		this.now_CORE30_LONG_1_H_SIGMA_01 = now_CORE30_LONG_1_H_SIGMA_01;
	}

	public double getNow_CORE30_LONG_1_L_SIGMA_01() {
		return now_CORE30_LONG_1_L_SIGMA_01;
	}

	public void setNow_CORE30_LONG_1_L_SIGMA_01(double now_CORE30_LONG_1_L_SIGMA_01) {
		this.now_CORE30_LONG_1_L_SIGMA_01 = now_CORE30_LONG_1_L_SIGMA_01;
	}

	public double getNow_CORE30_LONG_2_H_SIGMA_01() {
		return now_CORE30_LONG_2_H_SIGMA_01;
	}

	public void setNow_CORE30_LONG_2_H_SIGMA_01(double now_CORE30_LONG_2_H_SIGMA_01) {
		this.now_CORE30_LONG_2_H_SIGMA_01 = now_CORE30_LONG_2_H_SIGMA_01;
	}

	public double getNow_CORE30_LONG_2_L_SIGMA_01() {
		return now_CORE30_LONG_2_L_SIGMA_01;
	}

	public void setNow_CORE30_LONG_2_L_SIGMA_01(double now_CORE30_LONG_2_L_SIGMA_01) {
		this.now_CORE30_LONG_2_L_SIGMA_01 = now_CORE30_LONG_2_L_SIGMA_01;
	}

	public double getNow_CORE30_LONG_3_H_SIGMA_01() {
		return now_CORE30_LONG_3_H_SIGMA_01;
	}

	public void setNow_CORE30_LONG_3_H_SIGMA_01(double now_CORE30_LONG_3_H_SIGMA_01) {
		this.now_CORE30_LONG_3_H_SIGMA_01 = now_CORE30_LONG_3_H_SIGMA_01;
	}

	public double getNow_CORE30_LONG_3_L_SIGMA_01() {
		return now_CORE30_LONG_3_L_SIGMA_01;
	}

	public void setNow_CORE30_LONG_3_L_SIGMA_01(double now_CORE30_LONG_3_L_SIGMA_01) {
		this.now_CORE30_LONG_3_L_SIGMA_01 = now_CORE30_LONG_3_L_SIGMA_01;
	}

	public double getNow_CORE30_SHORTIDO_HEKATU_01() {
		return now_CORE30_SHORTIDO_HEKATU_01;
	}

	public void setNow_CORE30_SHORTIDO_HEKATU_01(
			double now_CORE30_SHORTIDO_HEKATU_01) {
		this.now_CORE30_SHORTIDO_HEKATU_01 = now_CORE30_SHORTIDO_HEKATU_01;
	}

	public double getNow_CORE30_MIDDLEIDO_HEKATU_01() {
		return now_CORE30_MIDDLEIDO_HEKATU_01;
	}

	public void setNow_CORE30_MIDDLEIDO_HEKATU_01(
			double now_CORE30_MIDDLEIDO_HEKATU_01) {
		this.now_CORE30_MIDDLEIDO_HEKATU_01 = now_CORE30_MIDDLEIDO_HEKATU_01;
	}

	public double getNow_CORE30_LONGIDO_HEKATU_01() {
		return now_CORE30_LONGIDO_HEKATU_01;
	}

	public void setNow_CORE30_LONGIDO_HEKATU_01(double now_CORE30_LONGIDO_HEKATU_01) {
		this.now_CORE30_LONGIDO_HEKATU_01 = now_CORE30_LONGIDO_HEKATU_01;
	}

	public double getNow_CORE30_SHORTIDO_HEKATU_CHANGERATE_01() {
		return now_CORE30_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_CORE30_SHORTIDO_HEKATU_CHANGERATE_01(
			double now_CORE30_SHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_CORE30_SHORTIDO_HEKATU_CHANGERATE_01 = now_CORE30_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01 = now_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_CORE30_LONGIDO_HEKATU_CHANGERATE_01() {
		return now_CORE30_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_CORE30_LONGIDO_HEKATU_CHANGERATE_01(
			double now_CORE30_LONGIDO_HEKATU_CHANGERATE_01) {
		this.now_CORE30_LONGIDO_HEKATU_CHANGERATE_01 = now_CORE30_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_CORE30_SHORTIDO_HEKATU_RATIO_01() {
		return now_CORE30_SHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_CORE30_SHORTIDO_HEKATU_RATIO_01(
			double now_CORE30_SHORTIDO_HEKATU_RATIO_01) {
		this.now_CORE30_SHORTIDO_HEKATU_RATIO_01 = now_CORE30_SHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_CORE30_MIDDLEIDO_HEKATU_RATIO_01() {
		return now_CORE30_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_CORE30_MIDDLEIDO_HEKATU_RATIO_01(
			double now_CORE30_MIDDLEIDO_HEKATU_RATIO_01) {
		this.now_CORE30_MIDDLEIDO_HEKATU_RATIO_01 = now_CORE30_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_CORE30_LONGIDO_HEKATU_RATIO_01() {
		return now_CORE30_LONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_CORE30_LONGIDO_HEKATU_RATIO_01(
			double now_CORE30_LONGIDO_HEKATU_RATIO_01) {
		this.now_CORE30_LONGIDO_HEKATU_RATIO_01 = now_CORE30_LONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_CORE30_SHORT_MACD_01() {
		return now_CORE30_SHORT_MACD_01;
	}

	public void setNow_CORE30_SHORT_MACD_01(double now_CORE30_SHORT_MACD_01) {
		this.now_CORE30_SHORT_MACD_01 = now_CORE30_SHORT_MACD_01;
	}

	public double getNow_CORE30_SHORT_MACD_SIGNAL_01() {
		return now_CORE30_SHORT_MACD_SIGNAL_01;
	}

	public void setNow_CORE30_SHORT_MACD_SIGNAL_01(
			double now_CORE30_SHORT_MACD_SIGNAL_01) {
		this.now_CORE30_SHORT_MACD_SIGNAL_01 = now_CORE30_SHORT_MACD_SIGNAL_01;
	}

	public double getNow_CORE30_MIDDLE_MACD_01() {
		return now_CORE30_MIDDLE_MACD_01;
	}

	public void setNow_CORE30_MIDDLE_MACD_01(double now_CORE30_MIDDLE_MACD_01) {
		this.now_CORE30_MIDDLE_MACD_01 = now_CORE30_MIDDLE_MACD_01;
	}

	public double getNow_CORE30_MIDDLE_MACD_SIGNAL_01() {
		return now_CORE30_MIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_CORE30_MIDDLE_MACD_SIGNAL_01(
			double now_CORE30_MIDDLE_MACD_SIGNAL_01) {
		this.now_CORE30_MIDDLE_MACD_SIGNAL_01 = now_CORE30_MIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_CORE30_LONG_MACD_01() {
		return now_CORE30_LONG_MACD_01;
	}

	public void setNow_CORE30_LONG_MACD_01(double now_CORE30_LONG_MACD_01) {
		this.now_CORE30_LONG_MACD_01 = now_CORE30_LONG_MACD_01;
	}

	public double getNow_CORE30_LONG_MACD_SIGNAL_01() {
		return now_CORE30_LONG_MACD_SIGNAL_01;
	}

	public void setNow_CORE30_LONG_MACD_SIGNAL_01(
			double now_CORE30_LONG_MACD_SIGNAL_01) {
		this.now_CORE30_LONG_MACD_SIGNAL_01 = now_CORE30_LONG_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX100_Open_01() {
		return now_TOPIX100_Open_01;
	}

	public void setNow_TOPIX100_Open_01(double now_TOPIX100_Open_01) {
		this.now_TOPIX100_Open_01 = now_TOPIX100_Open_01;
	}

	public double getNow_TOPIX100_MAX_01() {
		return now_TOPIX100_MAX_01;
	}

	public void setNow_TOPIX100_MAX_01(double now_TOPIX100_MAX_01) {
		this.now_TOPIX100_MAX_01 = now_TOPIX100_MAX_01;
	}

	public double getNow_TOPIX100_MIN_01() {
		return now_TOPIX100_MIN_01;
	}

	public void setNow_TOPIX100_MIN_01(double now_TOPIX100_MIN_01) {
		this.now_TOPIX100_MIN_01 = now_TOPIX100_MIN_01;
	}

	public double getNow_TOPIX100_CLOSE_01() {
		return now_TOPIX100_CLOSE_01;
	}

	public void setNow_TOPIX100_CLOSE_01(double now_TOPIX100_CLOSE_01) {
		this.now_TOPIX100_CLOSE_01 = now_TOPIX100_CLOSE_01;
	}

	public double getNow_TOPIX100_CHANGE_PRICE_01() {
		return now_TOPIX100_CHANGE_PRICE_01;
	}

	public void setNow_TOPIX100_CHANGE_PRICE_01(double now_TOPIX100_CHANGE_PRICE_01) {
		this.now_TOPIX100_CHANGE_PRICE_01 = now_TOPIX100_CHANGE_PRICE_01;
	}

	public double getNow_TOPIX100_CHANGERATE_01() {
		return now_TOPIX100_CHANGERATE_01;
	}

	public void setNow_TOPIX100_CHANGERATE_01(double now_TOPIX100_CHANGERATE_01) {
		this.now_TOPIX100_CHANGERATE_01 = now_TOPIX100_CHANGERATE_01;
	}

	public double getNow_TOPIX100_SHORTIDO_01() {
		return now_TOPIX100_SHORTIDO_01;
	}

	public void setNow_TOPIX100_SHORTIDO_01(double now_TOPIX100_SHORTIDO_01) {
		this.now_TOPIX100_SHORTIDO_01 = now_TOPIX100_SHORTIDO_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_01() {
		return now_TOPIX100_MIDDLEIDO_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_01(double now_TOPIX100_MIDDLEIDO_01) {
		this.now_TOPIX100_MIDDLEIDO_01 = now_TOPIX100_MIDDLEIDO_01;
	}

	public double getNow_TOPIX100_LONGIDO_01() {
		return now_TOPIX100_LONGIDO_01;
	}

	public void setNow_TOPIX100_LONGIDO_01(double now_TOPIX100_LONGIDO_01) {
		this.now_TOPIX100_LONGIDO_01 = now_TOPIX100_LONGIDO_01;
	}

	public double getNow_TOPIX100_SHORTIDO_CHANGERATE_01() {
		return now_TOPIX100_SHORTIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX100_SHORTIDO_CHANGERATE_01(
			double now_TOPIX100_SHORTIDO_CHANGERATE_01) {
		this.now_TOPIX100_SHORTIDO_CHANGERATE_01 = now_TOPIX100_SHORTIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_CHANGERATE_01() {
		return now_TOPIX100_MIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_CHANGERATE_01(
			double now_TOPIX100_MIDDLEIDO_CHANGERATE_01) {
		this.now_TOPIX100_MIDDLEIDO_CHANGERATE_01 = now_TOPIX100_MIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX100_LONGIDO_CHANGERATE_01() {
		return now_TOPIX100_LONGIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX100_LONGIDO_CHANGERATE_01(
			double now_TOPIX100_LONGIDO_CHANGERATE_01) {
		this.now_TOPIX100_LONGIDO_CHANGERATE_01 = now_TOPIX100_LONGIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX100_SHORTIDO_RATIO_01() {
		return now_TOPIX100_SHORTIDO_RATIO_01;
	}

	public void setNow_TOPIX100_SHORTIDO_RATIO_01(
			double now_TOPIX100_SHORTIDO_RATIO_01) {
		this.now_TOPIX100_SHORTIDO_RATIO_01 = now_TOPIX100_SHORTIDO_RATIO_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_RATIO_01() {
		return now_TOPIX100_MIDDLEIDO_RATIO_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_RATIO_01(
			double now_TOPIX100_MIDDLEIDO_RATIO_01) {
		this.now_TOPIX100_MIDDLEIDO_RATIO_01 = now_TOPIX100_MIDDLEIDO_RATIO_01;
	}

	public double getNow_TOPIX100_LONGIDO_RATIO_01() {
		return now_TOPIX100_LONGIDO_RATIO_01;
	}

	public void setNow_TOPIX100_LONGIDO_RATIO_01(
			double now_TOPIX100_LONGIDO_RATIO_01) {
		this.now_TOPIX100_LONGIDO_RATIO_01 = now_TOPIX100_LONGIDO_RATIO_01;
	}

	public double getNow_TOPIX100_MAXMIN_01() {
		return now_TOPIX100_MAXMIN_01;
	}

	public void setNow_TOPIX100_MAXMIN_01(double now_TOPIX100_MAXMIN_01) {
		this.now_TOPIX100_MAXMIN_01 = now_TOPIX100_MAXMIN_01;
	}

	public double getNow_TOPIX100_MAXMINRATIO_01() {
		return now_TOPIX100_MAXMINRATIO_01;
	}

	public void setNow_TOPIX100_MAXMINRATIO_01(double now_TOPIX100_MAXMINRATIO_01) {
		this.now_TOPIX100_MAXMINRATIO_01 = now_TOPIX100_MAXMINRATIO_01;
	}

	public double getNow_TOPIX100_CANDLE_AREA_01() {
		return now_TOPIX100_CANDLE_AREA_01;
	}

	public void setNow_TOPIX100_CANDLE_AREA_01(double now_TOPIX100_CANDLE_AREA_01) {
		this.now_TOPIX100_CANDLE_AREA_01 = now_TOPIX100_CANDLE_AREA_01;
	}

	public double getNow_TOPIX100_CANDLE_AREA_SCALE_01() {
		return now_TOPIX100_CANDLE_AREA_SCALE_01;
	}

	public void setNow_TOPIX100_CANDLE_AREA_SCALE_01(
			double now_TOPIX100_CANDLE_AREA_SCALE_01) {
		this.now_TOPIX100_CANDLE_AREA_SCALE_01 = now_TOPIX100_CANDLE_AREA_SCALE_01;
	}

	public double getNow_TOPIX100_WINDOW_01() {
		return now_TOPIX100_WINDOW_01;
	}

	public void setNow_TOPIX100_WINDOW_01(double now_TOPIX100_WINDOW_01) {
		this.now_TOPIX100_WINDOW_01 = now_TOPIX100_WINDOW_01;
	}

	public double getNow_TOPIX100_SHORT_DEV_01() {
		return now_TOPIX100_SHORT_DEV_01;
	}

	public void setNow_TOPIX100_SHORT_DEV_01(double now_TOPIX100_SHORT_DEV_01) {
		this.now_TOPIX100_SHORT_DEV_01 = now_TOPIX100_SHORT_DEV_01;
	}

	public double getNow_TOPIX100_SHORT_NOW_SIGMA_01() {
		return now_TOPIX100_SHORT_NOW_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_NOW_SIGMA_01(
			double now_TOPIX100_SHORT_NOW_SIGMA_01) {
		this.now_TOPIX100_SHORT_NOW_SIGMA_01 = now_TOPIX100_SHORT_NOW_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_1_H_SIGMA_01() {
		return now_TOPIX100_SHORT_1_H_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_1_H_SIGMA_01(
			double now_TOPIX100_SHORT_1_H_SIGMA_01) {
		this.now_TOPIX100_SHORT_1_H_SIGMA_01 = now_TOPIX100_SHORT_1_H_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_1_L_SIGMA_01() {
		return now_TOPIX100_SHORT_1_L_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_1_L_SIGMA_01(
			double now_TOPIX100_SHORT_1_L_SIGMA_01) {
		this.now_TOPIX100_SHORT_1_L_SIGMA_01 = now_TOPIX100_SHORT_1_L_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_2_H_SIGMA_01() {
		return now_TOPIX100_SHORT_2_H_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_2_H_SIGMA_01(
			double now_TOPIX100_SHORT_2_H_SIGMA_01) {
		this.now_TOPIX100_SHORT_2_H_SIGMA_01 = now_TOPIX100_SHORT_2_H_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_2_L_SIGMA_01() {
		return now_TOPIX100_SHORT_2_L_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_2_L_SIGMA_01(
			double now_TOPIX100_SHORT_2_L_SIGMA_01) {
		this.now_TOPIX100_SHORT_2_L_SIGMA_01 = now_TOPIX100_SHORT_2_L_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_3_H_SIGMA_01() {
		return now_TOPIX100_SHORT_3_H_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_3_H_SIGMA_01(
			double now_TOPIX100_SHORT_3_H_SIGMA_01) {
		this.now_TOPIX100_SHORT_3_H_SIGMA_01 = now_TOPIX100_SHORT_3_H_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORT_3_L_SIGMA_01() {
		return now_TOPIX100_SHORT_3_L_SIGMA_01;
	}

	public void setNow_TOPIX100_SHORT_3_L_SIGMA_01(
			double now_TOPIX100_SHORT_3_L_SIGMA_01) {
		this.now_TOPIX100_SHORT_3_L_SIGMA_01 = now_TOPIX100_SHORT_3_L_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_DEV_01() {
		return now_TOPIX100_MIDDLE_DEV_01;
	}

	public void setNow_TOPIX100_MIDDLE_DEV_01(double now_TOPIX100_MIDDLE_DEV_01) {
		this.now_TOPIX100_MIDDLE_DEV_01 = now_TOPIX100_MIDDLE_DEV_01;
	}

	public double getNow_TOPIX100_MIDDLE_NOW_SIGMA_01() {
		return now_TOPIX100_MIDDLE_NOW_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_NOW_SIGMA_01(
			double now_TOPIX100_MIDDLE_NOW_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_NOW_SIGMA_01 = now_TOPIX100_MIDDLE_NOW_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_1_H_SIGMA_01() {
		return now_TOPIX100_MIDDLE_1_H_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_1_H_SIGMA_01(
			double now_TOPIX100_MIDDLE_1_H_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_1_H_SIGMA_01 = now_TOPIX100_MIDDLE_1_H_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_1_L_SIGMA_01() {
		return now_TOPIX100_MIDDLE_1_L_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_1_L_SIGMA_01(
			double now_TOPIX100_MIDDLE_1_L_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_1_L_SIGMA_01 = now_TOPIX100_MIDDLE_1_L_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_2_H_SIGMA_01() {
		return now_TOPIX100_MIDDLE_2_H_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_2_H_SIGMA_01(
			double now_TOPIX100_MIDDLE_2_H_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_2_H_SIGMA_01 = now_TOPIX100_MIDDLE_2_H_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_2_L_SIGMA_01() {
		return now_TOPIX100_MIDDLE_2_L_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_2_L_SIGMA_01(
			double now_TOPIX100_MIDDLE_2_L_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_2_L_SIGMA_01 = now_TOPIX100_MIDDLE_2_L_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_3_H_SIGMA_01() {
		return now_TOPIX100_MIDDLE_3_H_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_3_H_SIGMA_01(
			double now_TOPIX100_MIDDLE_3_H_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_3_H_SIGMA_01 = now_TOPIX100_MIDDLE_3_H_SIGMA_01;
	}

	public double getNow_TOPIX100_MIDDLE_3_L_SIGMA_01() {
		return now_TOPIX100_MIDDLE_3_L_SIGMA_01;
	}

	public void setNow_TOPIX100_MIDDLE_3_L_SIGMA_01(
			double now_TOPIX100_MIDDLE_3_L_SIGMA_01) {
		this.now_TOPIX100_MIDDLE_3_L_SIGMA_01 = now_TOPIX100_MIDDLE_3_L_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_DEV_01() {
		return now_TOPIX100_LONG_DEV_01;
	}

	public void setNow_TOPIX100_LONG_DEV_01(double now_TOPIX100_LONG_DEV_01) {
		this.now_TOPIX100_LONG_DEV_01 = now_TOPIX100_LONG_DEV_01;
	}

	public double getNow_TOPIX100_LONG_NOW_SIGMA_01() {
		return now_TOPIX100_LONG_NOW_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_NOW_SIGMA_01(
			double now_TOPIX100_LONG_NOW_SIGMA_01) {
		this.now_TOPIX100_LONG_NOW_SIGMA_01 = now_TOPIX100_LONG_NOW_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_1_H_SIGMA_01() {
		return now_TOPIX100_LONG_1_H_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_1_H_SIGMA_01(
			double now_TOPIX100_LONG_1_H_SIGMA_01) {
		this.now_TOPIX100_LONG_1_H_SIGMA_01 = now_TOPIX100_LONG_1_H_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_1_L_SIGMA_01() {
		return now_TOPIX100_LONG_1_L_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_1_L_SIGMA_01(
			double now_TOPIX100_LONG_1_L_SIGMA_01) {
		this.now_TOPIX100_LONG_1_L_SIGMA_01 = now_TOPIX100_LONG_1_L_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_2_H_SIGMA_01() {
		return now_TOPIX100_LONG_2_H_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_2_H_SIGMA_01(
			double now_TOPIX100_LONG_2_H_SIGMA_01) {
		this.now_TOPIX100_LONG_2_H_SIGMA_01 = now_TOPIX100_LONG_2_H_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_2_L_SIGMA_01() {
		return now_TOPIX100_LONG_2_L_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_2_L_SIGMA_01(
			double now_TOPIX100_LONG_2_L_SIGMA_01) {
		this.now_TOPIX100_LONG_2_L_SIGMA_01 = now_TOPIX100_LONG_2_L_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_3_H_SIGMA_01() {
		return now_TOPIX100_LONG_3_H_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_3_H_SIGMA_01(
			double now_TOPIX100_LONG_3_H_SIGMA_01) {
		this.now_TOPIX100_LONG_3_H_SIGMA_01 = now_TOPIX100_LONG_3_H_SIGMA_01;
	}

	public double getNow_TOPIX100_LONG_3_L_SIGMA_01() {
		return now_TOPIX100_LONG_3_L_SIGMA_01;
	}

	public void setNow_TOPIX100_LONG_3_L_SIGMA_01(
			double now_TOPIX100_LONG_3_L_SIGMA_01) {
		this.now_TOPIX100_LONG_3_L_SIGMA_01 = now_TOPIX100_LONG_3_L_SIGMA_01;
	}

	public double getNow_TOPIX100_SHORTIDO_HEKATU_01() {
		return now_TOPIX100_SHORTIDO_HEKATU_01;
	}

	public void setNow_TOPIX100_SHORTIDO_HEKATU_01(
			double now_TOPIX100_SHORTIDO_HEKATU_01) {
		this.now_TOPIX100_SHORTIDO_HEKATU_01 = now_TOPIX100_SHORTIDO_HEKATU_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_HEKATU_01() {
		return now_TOPIX100_MIDDLEIDO_HEKATU_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_HEKATU_01(
			double now_TOPIX100_MIDDLEIDO_HEKATU_01) {
		this.now_TOPIX100_MIDDLEIDO_HEKATU_01 = now_TOPIX100_MIDDLEIDO_HEKATU_01;
	}

	public double getNow_TOPIX100_LONGIDO_HEKATU_01() {
		return now_TOPIX100_LONGIDO_HEKATU_01;
	}

	public void setNow_TOPIX100_LONGIDO_HEKATU_01(
			double now_TOPIX100_LONGIDO_HEKATU_01) {
		this.now_TOPIX100_LONGIDO_HEKATU_01 = now_TOPIX100_LONGIDO_HEKATU_01;
	}

	public double getNow_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01 = now_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01 = now_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01 = now_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX100_SHORTIDO_HEKATU_RATIO_01() {
		return now_TOPIX100_SHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX100_SHORTIDO_HEKATU_RATIO_01(
			double now_TOPIX100_SHORTIDO_HEKATU_RATIO_01) {
		this.now_TOPIX100_SHORTIDO_HEKATU_RATIO_01 = now_TOPIX100_SHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01() {
		return now_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01(
			double now_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01) {
		this.now_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01 = now_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX100_LONGIDO_HEKATU_RATIO_01() {
		return now_TOPIX100_LONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX100_LONGIDO_HEKATU_RATIO_01(
			double now_TOPIX100_LONGIDO_HEKATU_RATIO_01) {
		this.now_TOPIX100_LONGIDO_HEKATU_RATIO_01 = now_TOPIX100_LONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX100_SHORT_MACD_01() {
		return now_TOPIX100_SHORT_MACD_01;
	}

	public void setNow_TOPIX100_SHORT_MACD_01(double now_TOPIX100_SHORT_MACD_01) {
		this.now_TOPIX100_SHORT_MACD_01 = now_TOPIX100_SHORT_MACD_01;
	}

	public double getNow_TOPIX100_SHORT_MACD_SIGNAL_01() {
		return now_TOPIX100_SHORT_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX100_SHORT_MACD_SIGNAL_01(
			double now_TOPIX100_SHORT_MACD_SIGNAL_01) {
		this.now_TOPIX100_SHORT_MACD_SIGNAL_01 = now_TOPIX100_SHORT_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX100_MIDDLE_MACD_01() {
		return now_TOPIX100_MIDDLE_MACD_01;
	}

	public void setNow_TOPIX100_MIDDLE_MACD_01(double now_TOPIX100_MIDDLE_MACD_01) {
		this.now_TOPIX100_MIDDLE_MACD_01 = now_TOPIX100_MIDDLE_MACD_01;
	}

	public double getNow_TOPIX100_MIDDLE_MACD_SIGNAL_01() {
		return now_TOPIX100_MIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX100_MIDDLE_MACD_SIGNAL_01(
			double now_TOPIX100_MIDDLE_MACD_SIGNAL_01) {
		this.now_TOPIX100_MIDDLE_MACD_SIGNAL_01 = now_TOPIX100_MIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX100_LONG_MACD_01() {
		return now_TOPIX100_LONG_MACD_01;
	}

	public void setNow_TOPIX100_LONG_MACD_01(double now_TOPIX100_LONG_MACD_01) {
		this.now_TOPIX100_LONG_MACD_01 = now_TOPIX100_LONG_MACD_01;
	}

	public double getNow_TOPIX100_LONG_MACD_SIGNAL_01() {
		return now_TOPIX100_LONG_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX100_LONG_MACD_SIGNAL_01(
			double now_TOPIX100_LONG_MACD_SIGNAL_01) {
		this.now_TOPIX100_LONG_MACD_SIGNAL_01 = now_TOPIX100_LONG_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_SMALL_Open_01() {
		return now_TOPIX_SMALL_Open_01;
	}

	public void setNow_TOPIX_SMALL_Open_01(double now_TOPIX_SMALL_Open_01) {
		this.now_TOPIX_SMALL_Open_01 = now_TOPIX_SMALL_Open_01;
	}

	public double getNow_TOPIX_SMALL_MAX_01() {
		return now_TOPIX_SMALL_MAX_01;
	}

	public void setNow_TOPIX_SMALL_MAX_01(double now_TOPIX_SMALL_MAX_01) {
		this.now_TOPIX_SMALL_MAX_01 = now_TOPIX_SMALL_MAX_01;
	}

	public double getNow_TOPIX_SMALL_MIN_01() {
		return now_TOPIX_SMALL_MIN_01;
	}

	public void setNow_TOPIX_SMALL_MIN_01(double now_TOPIX_SMALL_MIN_01) {
		this.now_TOPIX_SMALL_MIN_01 = now_TOPIX_SMALL_MIN_01;
	}

	public double getNow_TOPIX_SMALL_CLOSE_01() {
		return now_TOPIX_SMALL_CLOSE_01;
	}

	public void setNow_TOPIX_SMALL_CLOSE_01(double now_TOPIX_SMALL_CLOSE_01) {
		this.now_TOPIX_SMALL_CLOSE_01 = now_TOPIX_SMALL_CLOSE_01;
	}

	public double getNow_TOPIX_SMALL_CHANGE_PRICE_01() {
		return now_TOPIX_SMALL_CHANGE_PRICE_01;
	}

	public void setNow_TOPIX_SMALL_CHANGE_PRICE_01(
			double now_TOPIX_SMALL_CHANGE_PRICE_01) {
		this.now_TOPIX_SMALL_CHANGE_PRICE_01 = now_TOPIX_SMALL_CHANGE_PRICE_01;
	}

	public double getNow_TOPIX_SMALL_CHANGERATE_01() {
		return now_TOPIX_SMALL_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_CHANGERATE_01(
			double now_TOPIX_SMALL_CHANGERATE_01) {
		this.now_TOPIX_SMALL_CHANGERATE_01 = now_TOPIX_SMALL_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_01() {
		return now_TOPIX_SMALL_SHORTIDO_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_01(double now_TOPIX_SMALL_SHORTIDO_01) {
		this.now_TOPIX_SMALL_SHORTIDO_01 = now_TOPIX_SMALL_SHORTIDO_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_01(double now_TOPIX_SMALL_MIDDLEIDO_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_01 = now_TOPIX_SMALL_MIDDLEIDO_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_01() {
		return now_TOPIX_SMALL_LONGIDO_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_01(double now_TOPIX_SMALL_LONGIDO_01) {
		this.now_TOPIX_SMALL_LONGIDO_01 = now_TOPIX_SMALL_LONGIDO_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_CHANGERATE_01() {
		return now_TOPIX_SMALL_SHORTIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_CHANGERATE_01(
			double now_TOPIX_SMALL_SHORTIDO_CHANGERATE_01) {
		this.now_TOPIX_SMALL_SHORTIDO_CHANGERATE_01 = now_TOPIX_SMALL_SHORTIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01(
			double now_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01 = now_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_CHANGERATE_01() {
		return now_TOPIX_SMALL_LONGIDO_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_CHANGERATE_01(
			double now_TOPIX_SMALL_LONGIDO_CHANGERATE_01) {
		this.now_TOPIX_SMALL_LONGIDO_CHANGERATE_01 = now_TOPIX_SMALL_LONGIDO_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_RATIO_01() {
		return now_TOPIX_SMALL_SHORTIDO_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_RATIO_01(
			double now_TOPIX_SMALL_SHORTIDO_RATIO_01) {
		this.now_TOPIX_SMALL_SHORTIDO_RATIO_01 = now_TOPIX_SMALL_SHORTIDO_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_RATIO_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_RATIO_01(
			double now_TOPIX_SMALL_MIDDLEIDO_RATIO_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_RATIO_01 = now_TOPIX_SMALL_MIDDLEIDO_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_RATIO_01() {
		return now_TOPIX_SMALL_LONGIDO_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_RATIO_01(
			double now_TOPIX_SMALL_LONGIDO_RATIO_01) {
		this.now_TOPIX_SMALL_LONGIDO_RATIO_01 = now_TOPIX_SMALL_LONGIDO_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_MAXMIN_01() {
		return now_TOPIX_SMALL_MAXMIN_01;
	}

	public void setNow_TOPIX_SMALL_MAXMIN_01(double now_TOPIX_SMALL_MAXMIN_01) {
		this.now_TOPIX_SMALL_MAXMIN_01 = now_TOPIX_SMALL_MAXMIN_01;
	}

	public double getNow_TOPIX_SMALL_MAXMINRATIO_01() {
		return now_TOPIX_SMALL_MAXMINRATIO_01;
	}

	public void setNow_TOPIX_SMALL_MAXMINRATIO_01(
			double now_TOPIX_SMALL_MAXMINRATIO_01) {
		this.now_TOPIX_SMALL_MAXMINRATIO_01 = now_TOPIX_SMALL_MAXMINRATIO_01;
	}

	public double getNow_TOPIX_SMALL_CANDLE_AREA_01() {
		return now_TOPIX_SMALL_CANDLE_AREA_01;
	}

	public void setNow_TOPIX_SMALL_CANDLE_AREA_01(
			double now_TOPIX_SMALL_CANDLE_AREA_01) {
		this.now_TOPIX_SMALL_CANDLE_AREA_01 = now_TOPIX_SMALL_CANDLE_AREA_01;
	}

	public double getNow_TOPIX_SMALL_CANDLE_AREA_SCALE_01() {
		return now_TOPIX_SMALL_CANDLE_AREA_SCALE_01;
	}

	public void setNow_TOPIX_SMALL_CANDLE_AREA_SCALE_01(
			double now_TOPIX_SMALL_CANDLE_AREA_SCALE_01) {
		this.now_TOPIX_SMALL_CANDLE_AREA_SCALE_01 = now_TOPIX_SMALL_CANDLE_AREA_SCALE_01;
	}

	public double getNow_TOPIX_SMALL_WINDOW_01() {
		return now_TOPIX_SMALL_WINDOW_01;
	}

	public void setNow_TOPIX_SMALL_WINDOW_01(double now_TOPIX_SMALL_WINDOW_01) {
		this.now_TOPIX_SMALL_WINDOW_01 = now_TOPIX_SMALL_WINDOW_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_DEV_01() {
		return now_TOPIX_SMALL_SHORT_DEV_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_DEV_01(double now_TOPIX_SMALL_SHORT_DEV_01) {
		this.now_TOPIX_SMALL_SHORT_DEV_01 = now_TOPIX_SMALL_SHORT_DEV_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_NOW_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_NOW_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_NOW_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_NOW_SIGMA_01 = now_TOPIX_SMALL_SHORT_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_1_H_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_1_H_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_1_H_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_1_H_SIGMA_01 = now_TOPIX_SMALL_SHORT_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_1_L_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_1_L_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_1_L_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_1_L_SIGMA_01 = now_TOPIX_SMALL_SHORT_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_2_H_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_2_H_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_2_H_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_2_H_SIGMA_01 = now_TOPIX_SMALL_SHORT_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_2_L_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_2_L_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_2_L_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_2_L_SIGMA_01 = now_TOPIX_SMALL_SHORT_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_3_H_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_3_H_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_3_H_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_3_H_SIGMA_01 = now_TOPIX_SMALL_SHORT_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_3_L_SIGMA_01() {
		return now_TOPIX_SMALL_SHORT_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_3_L_SIGMA_01(
			double now_TOPIX_SMALL_SHORT_3_L_SIGMA_01) {
		this.now_TOPIX_SMALL_SHORT_3_L_SIGMA_01 = now_TOPIX_SMALL_SHORT_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_DEV_01() {
		return now_TOPIX_SMALL_MIDDLE_DEV_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_DEV_01(
			double now_TOPIX_SMALL_MIDDLE_DEV_01) {
		this.now_TOPIX_SMALL_MIDDLE_DEV_01 = now_TOPIX_SMALL_MIDDLE_DEV_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01() {
		return now_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01(
			double now_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01) {
		this.now_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01 = now_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_DEV_01() {
		return now_TOPIX_SMALL_LONG_DEV_01;
	}

	public void setNow_TOPIX_SMALL_LONG_DEV_01(double now_TOPIX_SMALL_LONG_DEV_01) {
		this.now_TOPIX_SMALL_LONG_DEV_01 = now_TOPIX_SMALL_LONG_DEV_01;
	}

	public double getNow_TOPIX_SMALL_LONG_NOW_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_NOW_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_NOW_SIGMA_01(
			double now_TOPIX_SMALL_LONG_NOW_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_NOW_SIGMA_01 = now_TOPIX_SMALL_LONG_NOW_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_1_H_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_1_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_1_H_SIGMA_01(
			double now_TOPIX_SMALL_LONG_1_H_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_1_H_SIGMA_01 = now_TOPIX_SMALL_LONG_1_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_1_L_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_1_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_1_L_SIGMA_01(
			double now_TOPIX_SMALL_LONG_1_L_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_1_L_SIGMA_01 = now_TOPIX_SMALL_LONG_1_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_2_H_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_2_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_2_H_SIGMA_01(
			double now_TOPIX_SMALL_LONG_2_H_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_2_H_SIGMA_01 = now_TOPIX_SMALL_LONG_2_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_2_L_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_2_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_2_L_SIGMA_01(
			double now_TOPIX_SMALL_LONG_2_L_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_2_L_SIGMA_01 = now_TOPIX_SMALL_LONG_2_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_3_H_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_3_H_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_3_H_SIGMA_01(
			double now_TOPIX_SMALL_LONG_3_H_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_3_H_SIGMA_01 = now_TOPIX_SMALL_LONG_3_H_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_LONG_3_L_SIGMA_01() {
		return now_TOPIX_SMALL_LONG_3_L_SIGMA_01;
	}

	public void setNow_TOPIX_SMALL_LONG_3_L_SIGMA_01(
			double now_TOPIX_SMALL_LONG_3_L_SIGMA_01) {
		this.now_TOPIX_SMALL_LONG_3_L_SIGMA_01 = now_TOPIX_SMALL_LONG_3_L_SIGMA_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_HEKATU_01() {
		return now_TOPIX_SMALL_SHORTIDO_HEKATU_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_HEKATU_01(
			double now_TOPIX_SMALL_SHORTIDO_HEKATU_01) {
		this.now_TOPIX_SMALL_SHORTIDO_HEKATU_01 = now_TOPIX_SMALL_SHORTIDO_HEKATU_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_HEKATU_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_01(
			double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_HEKATU_01 = now_TOPIX_SMALL_MIDDLEIDO_HEKATU_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_HEKATU_01() {
		return now_TOPIX_SMALL_LONGIDO_HEKATU_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_HEKATU_01(
			double now_TOPIX_SMALL_LONGIDO_HEKATU_01) {
		this.now_TOPIX_SMALL_LONGIDO_HEKATU_01 = now_TOPIX_SMALL_LONGIDO_HEKATU_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01 = now_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01 = now_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01() {
		return now_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01(
			double now_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01) {
		this.now_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01 = now_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01() {
		return now_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01(
			double now_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01 = now_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01() {
		return now_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01(
			double now_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01 = now_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01() {
		return now_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01(
			double now_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01) {
		this.now_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01 = now_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_MACD_01() {
		return now_TOPIX_SMALL_SHORT_MACD_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_MACD_01(
			double now_TOPIX_SMALL_SHORT_MACD_01) {
		this.now_TOPIX_SMALL_SHORT_MACD_01 = now_TOPIX_SMALL_SHORT_MACD_01;
	}

	public double getNow_TOPIX_SMALL_SHORT_MACD_SIGNAL_01() {
		return now_TOPIX_SMALL_SHORT_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_SMALL_SHORT_MACD_SIGNAL_01(
			double now_TOPIX_SMALL_SHORT_MACD_SIGNAL_01) {
		this.now_TOPIX_SMALL_SHORT_MACD_SIGNAL_01 = now_TOPIX_SMALL_SHORT_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_MACD_01() {
		return now_TOPIX_SMALL_MIDDLE_MACD_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_MACD_01(
			double now_TOPIX_SMALL_MIDDLE_MACD_01) {
		this.now_TOPIX_SMALL_MIDDLE_MACD_01 = now_TOPIX_SMALL_MIDDLE_MACD_01;
	}

	public double getNow_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01() {
		return now_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01(
			double now_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01) {
		this.now_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01 = now_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_TOPIX_SMALL_LONG_MACD_01() {
		return now_TOPIX_SMALL_LONG_MACD_01;
	}

	public void setNow_TOPIX_SMALL_LONG_MACD_01(double now_TOPIX_SMALL_LONG_MACD_01) {
		this.now_TOPIX_SMALL_LONG_MACD_01 = now_TOPIX_SMALL_LONG_MACD_01;
	}

	public double getNow_TOPIX_SMALL_LONG_MACD_SIGNAL_01() {
		return now_TOPIX_SMALL_LONG_MACD_SIGNAL_01;
	}

	public void setNow_TOPIX_SMALL_LONG_MACD_SIGNAL_01(
			double now_TOPIX_SMALL_LONG_MACD_SIGNAL_01) {
		this.now_TOPIX_SMALL_LONG_MACD_SIGNAL_01 = now_TOPIX_SMALL_LONG_MACD_SIGNAL_01;
	}

	public double getNow_JASDAC_Open_01() {
		return now_JASDAC_Open_01;
	}

	public void setNow_JASDAC_Open_01(double now_JASDAC_Open_01) {
		this.now_JASDAC_Open_01 = now_JASDAC_Open_01;
	}

	public double getNow_JASDAC_MAX_01() {
		return now_JASDAC_MAX_01;
	}

	public void setNow_JASDAC_MAX_01(double now_JASDAC_MAX_01) {
		this.now_JASDAC_MAX_01 = now_JASDAC_MAX_01;
	}

	public double getNow_JASDAC_MIN_01() {
		return now_JASDAC_MIN_01;
	}

	public void setNow_JASDAC_MIN_01(double now_JASDAC_MIN_01) {
		this.now_JASDAC_MIN_01 = now_JASDAC_MIN_01;
	}

	public double getNow_JASDAC_CLOSE_01() {
		return now_JASDAC_CLOSE_01;
	}

	public void setNow_JASDAC_CLOSE_01(double now_JASDAC_CLOSE_01) {
		this.now_JASDAC_CLOSE_01 = now_JASDAC_CLOSE_01;
	}

	public double getNow_JASDAC_CHANGE_PRICE_01() {
		return now_JASDAC_CHANGE_PRICE_01;
	}

	public void setNow_JASDAC_CHANGE_PRICE_01(double now_JASDAC_CHANGE_PRICE_01) {
		this.now_JASDAC_CHANGE_PRICE_01 = now_JASDAC_CHANGE_PRICE_01;
	}

	public double getNow_JASDAC_CHANGERATE_01() {
		return now_JASDAC_CHANGERATE_01;
	}

	public void setNow_JASDAC_CHANGERATE_01(double now_JASDAC_CHANGERATE_01) {
		this.now_JASDAC_CHANGERATE_01 = now_JASDAC_CHANGERATE_01;
	}

	public double getNow_JASDAC_SHORTIDO_01() {
		return now_JASDAC_SHORTIDO_01;
	}

	public void setNow_JASDAC_SHORTIDO_01(double now_JASDAC_SHORTIDO_01) {
		this.now_JASDAC_SHORTIDO_01 = now_JASDAC_SHORTIDO_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_01() {
		return now_JASDAC_MIDDLEIDO_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_01(double now_JASDAC_MIDDLEIDO_01) {
		this.now_JASDAC_MIDDLEIDO_01 = now_JASDAC_MIDDLEIDO_01;
	}

	public double getNow_JASDAC_LONGIDO_01() {
		return now_JASDAC_LONGIDO_01;
	}

	public void setNow_JASDAC_LONGIDO_01(double now_JASDAC_LONGIDO_01) {
		this.now_JASDAC_LONGIDO_01 = now_JASDAC_LONGIDO_01;
	}

	public double getNow_JASDAC_SHORTIDO_CHANGERATE_01() {
		return now_JASDAC_SHORTIDO_CHANGERATE_01;
	}

	public void setNow_JASDAC_SHORTIDO_CHANGERATE_01(
			double now_JASDAC_SHORTIDO_CHANGERATE_01) {
		this.now_JASDAC_SHORTIDO_CHANGERATE_01 = now_JASDAC_SHORTIDO_CHANGERATE_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_CHANGERATE_01() {
		return now_JASDAC_MIDDLEIDO_CHANGERATE_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_CHANGERATE_01(
			double now_JASDAC_MIDDLEIDO_CHANGERATE_01) {
		this.now_JASDAC_MIDDLEIDO_CHANGERATE_01 = now_JASDAC_MIDDLEIDO_CHANGERATE_01;
	}

	public double getNow_JASDAC_LONGIDO_CHANGERATE_01() {
		return now_JASDAC_LONGIDO_CHANGERATE_01;
	}

	public void setNow_JASDAC_LONGIDO_CHANGERATE_01(
			double now_JASDAC_LONGIDO_CHANGERATE_01) {
		this.now_JASDAC_LONGIDO_CHANGERATE_01 = now_JASDAC_LONGIDO_CHANGERATE_01;
	}

	public double getNow_JASDAC_SHORTIDO_RATIO_01() {
		return now_JASDAC_SHORTIDO_RATIO_01;
	}

	public void setNow_JASDAC_SHORTIDO_RATIO_01(double now_JASDAC_SHORTIDO_RATIO_01) {
		this.now_JASDAC_SHORTIDO_RATIO_01 = now_JASDAC_SHORTIDO_RATIO_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_RATIO_01() {
		return now_JASDAC_MIDDLEIDO_RATIO_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_RATIO_01(
			double now_JASDAC_MIDDLEIDO_RATIO_01) {
		this.now_JASDAC_MIDDLEIDO_RATIO_01 = now_JASDAC_MIDDLEIDO_RATIO_01;
	}

	public double getNow_JASDAC_LONGIDO_RATIO_01() {
		return now_JASDAC_LONGIDO_RATIO_01;
	}

	public void setNow_JASDAC_LONGIDO_RATIO_01(double now_JASDAC_LONGIDO_RATIO_01) {
		this.now_JASDAC_LONGIDO_RATIO_01 = now_JASDAC_LONGIDO_RATIO_01;
	}

	public double getNow_JASDAC_MAXMIN_01() {
		return now_JASDAC_MAXMIN_01;
	}

	public void setNow_JASDAC_MAXMIN_01(double now_JASDAC_MAXMIN_01) {
		this.now_JASDAC_MAXMIN_01 = now_JASDAC_MAXMIN_01;
	}

	public double getNow_JASDAC_MAXMINRATIO_01() {
		return now_JASDAC_MAXMINRATIO_01;
	}

	public void setNow_JASDAC_MAXMINRATIO_01(double now_JASDAC_MAXMINRATIO_01) {
		this.now_JASDAC_MAXMINRATIO_01 = now_JASDAC_MAXMINRATIO_01;
	}

	public double getNow_JASDAC_CANDLE_AREA_01() {
		return now_JASDAC_CANDLE_AREA_01;
	}

	public void setNow_JASDAC_CANDLE_AREA_01(double now_JASDAC_CANDLE_AREA_01) {
		this.now_JASDAC_CANDLE_AREA_01 = now_JASDAC_CANDLE_AREA_01;
	}

	public double getNow_JASDAC_CANDLE_AREA_SCALE_01() {
		return now_JASDAC_CANDLE_AREA_SCALE_01;
	}

	public void setNow_JASDAC_CANDLE_AREA_SCALE_01(
			double now_JASDAC_CANDLE_AREA_SCALE_01) {
		this.now_JASDAC_CANDLE_AREA_SCALE_01 = now_JASDAC_CANDLE_AREA_SCALE_01;
	}

	public double getNow_JASDAC_WINDOW_01() {
		return now_JASDAC_WINDOW_01;
	}

	public void setNow_JASDAC_WINDOW_01(double now_JASDAC_WINDOW_01) {
		this.now_JASDAC_WINDOW_01 = now_JASDAC_WINDOW_01;
	}

	public double getNow_JASDAC_SHORT_DEV_01() {
		return now_JASDAC_SHORT_DEV_01;
	}

	public void setNow_JASDAC_SHORT_DEV_01(double now_JASDAC_SHORT_DEV_01) {
		this.now_JASDAC_SHORT_DEV_01 = now_JASDAC_SHORT_DEV_01;
	}

	public double getNow_JASDAC_SHORT_NOW_SIGMA_01() {
		return now_JASDAC_SHORT_NOW_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_NOW_SIGMA_01(
			double now_JASDAC_SHORT_NOW_SIGMA_01) {
		this.now_JASDAC_SHORT_NOW_SIGMA_01 = now_JASDAC_SHORT_NOW_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_1_H_SIGMA_01() {
		return now_JASDAC_SHORT_1_H_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_1_H_SIGMA_01(
			double now_JASDAC_SHORT_1_H_SIGMA_01) {
		this.now_JASDAC_SHORT_1_H_SIGMA_01 = now_JASDAC_SHORT_1_H_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_1_L_SIGMA_01() {
		return now_JASDAC_SHORT_1_L_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_1_L_SIGMA_01(
			double now_JASDAC_SHORT_1_L_SIGMA_01) {
		this.now_JASDAC_SHORT_1_L_SIGMA_01 = now_JASDAC_SHORT_1_L_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_2_H_SIGMA_01() {
		return now_JASDAC_SHORT_2_H_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_2_H_SIGMA_01(
			double now_JASDAC_SHORT_2_H_SIGMA_01) {
		this.now_JASDAC_SHORT_2_H_SIGMA_01 = now_JASDAC_SHORT_2_H_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_2_L_SIGMA_01() {
		return now_JASDAC_SHORT_2_L_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_2_L_SIGMA_01(
			double now_JASDAC_SHORT_2_L_SIGMA_01) {
		this.now_JASDAC_SHORT_2_L_SIGMA_01 = now_JASDAC_SHORT_2_L_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_3_H_SIGMA_01() {
		return now_JASDAC_SHORT_3_H_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_3_H_SIGMA_01(
			double now_JASDAC_SHORT_3_H_SIGMA_01) {
		this.now_JASDAC_SHORT_3_H_SIGMA_01 = now_JASDAC_SHORT_3_H_SIGMA_01;
	}

	public double getNow_JASDAC_SHORT_3_L_SIGMA_01() {
		return now_JASDAC_SHORT_3_L_SIGMA_01;
	}

	public void setNow_JASDAC_SHORT_3_L_SIGMA_01(
			double now_JASDAC_SHORT_3_L_SIGMA_01) {
		this.now_JASDAC_SHORT_3_L_SIGMA_01 = now_JASDAC_SHORT_3_L_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_DEV_01() {
		return now_JASDAC_MIDDLE_DEV_01;
	}

	public void setNow_JASDAC_MIDDLE_DEV_01(double now_JASDAC_MIDDLE_DEV_01) {
		this.now_JASDAC_MIDDLE_DEV_01 = now_JASDAC_MIDDLE_DEV_01;
	}

	public double getNow_JASDAC_MIDDLE_NOW_SIGMA_01() {
		return now_JASDAC_MIDDLE_NOW_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_NOW_SIGMA_01(
			double now_JASDAC_MIDDLE_NOW_SIGMA_01) {
		this.now_JASDAC_MIDDLE_NOW_SIGMA_01 = now_JASDAC_MIDDLE_NOW_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_1_H_SIGMA_01() {
		return now_JASDAC_MIDDLE_1_H_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_1_H_SIGMA_01(
			double now_JASDAC_MIDDLE_1_H_SIGMA_01) {
		this.now_JASDAC_MIDDLE_1_H_SIGMA_01 = now_JASDAC_MIDDLE_1_H_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_1_L_SIGMA_01() {
		return now_JASDAC_MIDDLE_1_L_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_1_L_SIGMA_01(
			double now_JASDAC_MIDDLE_1_L_SIGMA_01) {
		this.now_JASDAC_MIDDLE_1_L_SIGMA_01 = now_JASDAC_MIDDLE_1_L_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_2_H_SIGMA_01() {
		return now_JASDAC_MIDDLE_2_H_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_2_H_SIGMA_01(
			double now_JASDAC_MIDDLE_2_H_SIGMA_01) {
		this.now_JASDAC_MIDDLE_2_H_SIGMA_01 = now_JASDAC_MIDDLE_2_H_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_2_L_SIGMA_01() {
		return now_JASDAC_MIDDLE_2_L_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_2_L_SIGMA_01(
			double now_JASDAC_MIDDLE_2_L_SIGMA_01) {
		this.now_JASDAC_MIDDLE_2_L_SIGMA_01 = now_JASDAC_MIDDLE_2_L_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_3_H_SIGMA_01() {
		return now_JASDAC_MIDDLE_3_H_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_3_H_SIGMA_01(
			double now_JASDAC_MIDDLE_3_H_SIGMA_01) {
		this.now_JASDAC_MIDDLE_3_H_SIGMA_01 = now_JASDAC_MIDDLE_3_H_SIGMA_01;
	}

	public double getNow_JASDAC_MIDDLE_3_L_SIGMA_01() {
		return now_JASDAC_MIDDLE_3_L_SIGMA_01;
	}

	public void setNow_JASDAC_MIDDLE_3_L_SIGMA_01(
			double now_JASDAC_MIDDLE_3_L_SIGMA_01) {
		this.now_JASDAC_MIDDLE_3_L_SIGMA_01 = now_JASDAC_MIDDLE_3_L_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_DEV_01() {
		return now_JASDAC_LONG_DEV_01;
	}

	public void setNow_JASDAC_LONG_DEV_01(double now_JASDAC_LONG_DEV_01) {
		this.now_JASDAC_LONG_DEV_01 = now_JASDAC_LONG_DEV_01;
	}

	public double getNow_JASDAC_LONG_NOW_SIGMA_01() {
		return now_JASDAC_LONG_NOW_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_NOW_SIGMA_01(double now_JASDAC_LONG_NOW_SIGMA_01) {
		this.now_JASDAC_LONG_NOW_SIGMA_01 = now_JASDAC_LONG_NOW_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_1_H_SIGMA_01() {
		return now_JASDAC_LONG_1_H_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_1_H_SIGMA_01(double now_JASDAC_LONG_1_H_SIGMA_01) {
		this.now_JASDAC_LONG_1_H_SIGMA_01 = now_JASDAC_LONG_1_H_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_1_L_SIGMA_01() {
		return now_JASDAC_LONG_1_L_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_1_L_SIGMA_01(double now_JASDAC_LONG_1_L_SIGMA_01) {
		this.now_JASDAC_LONG_1_L_SIGMA_01 = now_JASDAC_LONG_1_L_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_2_H_SIGMA_01() {
		return now_JASDAC_LONG_2_H_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_2_H_SIGMA_01(double now_JASDAC_LONG_2_H_SIGMA_01) {
		this.now_JASDAC_LONG_2_H_SIGMA_01 = now_JASDAC_LONG_2_H_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_2_L_SIGMA_01() {
		return now_JASDAC_LONG_2_L_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_2_L_SIGMA_01(double now_JASDAC_LONG_2_L_SIGMA_01) {
		this.now_JASDAC_LONG_2_L_SIGMA_01 = now_JASDAC_LONG_2_L_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_3_H_SIGMA_01() {
		return now_JASDAC_LONG_3_H_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_3_H_SIGMA_01(double now_JASDAC_LONG_3_H_SIGMA_01) {
		this.now_JASDAC_LONG_3_H_SIGMA_01 = now_JASDAC_LONG_3_H_SIGMA_01;
	}

	public double getNow_JASDAC_LONG_3_L_SIGMA_01() {
		return now_JASDAC_LONG_3_L_SIGMA_01;
	}

	public void setNow_JASDAC_LONG_3_L_SIGMA_01(double now_JASDAC_LONG_3_L_SIGMA_01) {
		this.now_JASDAC_LONG_3_L_SIGMA_01 = now_JASDAC_LONG_3_L_SIGMA_01;
	}

	public double getNow_JASDAC_SHORTIDO_HEKATU_01() {
		return now_JASDAC_SHORTIDO_HEKATU_01;
	}

	public void setNow_JASDAC_SHORTIDO_HEKATU_01(
			double now_JASDAC_SHORTIDO_HEKATU_01) {
		this.now_JASDAC_SHORTIDO_HEKATU_01 = now_JASDAC_SHORTIDO_HEKATU_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_HEKATU_01() {
		return now_JASDAC_MIDDLEIDO_HEKATU_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_HEKATU_01(
			double now_JASDAC_MIDDLEIDO_HEKATU_01) {
		this.now_JASDAC_MIDDLEIDO_HEKATU_01 = now_JASDAC_MIDDLEIDO_HEKATU_01;
	}

	public double getNow_JASDAC_LONGIDO_HEKATU_01() {
		return now_JASDAC_LONGIDO_HEKATU_01;
	}

	public void setNow_JASDAC_LONGIDO_HEKATU_01(double now_JASDAC_LONGIDO_HEKATU_01) {
		this.now_JASDAC_LONGIDO_HEKATU_01 = now_JASDAC_LONGIDO_HEKATU_01;
	}

	public double getNow_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01() {
		return now_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01(
			double now_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01) {
		this.now_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01 = now_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01() {
		return now_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01(
			double now_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01) {
		this.now_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01 = now_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_JASDAC_LONGIDO_HEKATU_CHANGERATE_01() {
		return now_JASDAC_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public void setNow_JASDAC_LONGIDO_HEKATU_CHANGERATE_01(
			double now_JASDAC_LONGIDO_HEKATU_CHANGERATE_01) {
		this.now_JASDAC_LONGIDO_HEKATU_CHANGERATE_01 = now_JASDAC_LONGIDO_HEKATU_CHANGERATE_01;
	}

	public double getNow_JASDAC_SHORTIDO_HEKATU_RATIO_01() {
		return now_JASDAC_SHORTIDO_HEKATU_RATIO_01;
	}

	public void setNow_JASDAC_SHORTIDO_HEKATU_RATIO_01(
			double now_JASDAC_SHORTIDO_HEKATU_RATIO_01) {
		this.now_JASDAC_SHORTIDO_HEKATU_RATIO_01 = now_JASDAC_SHORTIDO_HEKATU_RATIO_01;
	}

	public double getNow_JASDAC_MIDDLEIDO_HEKATU_RATIO_01() {
		return now_JASDAC_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public void setNow_JASDAC_MIDDLEIDO_HEKATU_RATIO_01(
			double now_JASDAC_MIDDLEIDO_HEKATU_RATIO_01) {
		this.now_JASDAC_MIDDLEIDO_HEKATU_RATIO_01 = now_JASDAC_MIDDLEIDO_HEKATU_RATIO_01;
	}

	public double getNow_JASDAC_LONGIDO_HEKATU_RATIO_01() {
		return now_JASDAC_LONGIDO_HEKATU_RATIO_01;
	}

	public void setNow_JASDAC_LONGIDO_HEKATU_RATIO_01(
			double now_JASDAC_LONGIDO_HEKATU_RATIO_01) {
		this.now_JASDAC_LONGIDO_HEKATU_RATIO_01 = now_JASDAC_LONGIDO_HEKATU_RATIO_01;
	}

	public double getNow_JASDAC_SHORT_MACD_01() {
		return now_JASDAC_SHORT_MACD_01;
	}

	public void setNow_JASDAC_SHORT_MACD_01(double now_JASDAC_SHORT_MACD_01) {
		this.now_JASDAC_SHORT_MACD_01 = now_JASDAC_SHORT_MACD_01;
	}

	public double getNow_JASDAC_SHORT_MACD_SIGNAL_01() {
		return now_JASDAC_SHORT_MACD_SIGNAL_01;
	}

	public void setNow_JASDAC_SHORT_MACD_SIGNAL_01(
			double now_JASDAC_SHORT_MACD_SIGNAL_01) {
		this.now_JASDAC_SHORT_MACD_SIGNAL_01 = now_JASDAC_SHORT_MACD_SIGNAL_01;
	}

	public double getNow_JASDAC_MIDDLE_MACD_01() {
		return now_JASDAC_MIDDLE_MACD_01;
	}

	public void setNow_JASDAC_MIDDLE_MACD_01(double now_JASDAC_MIDDLE_MACD_01) {
		this.now_JASDAC_MIDDLE_MACD_01 = now_JASDAC_MIDDLE_MACD_01;
	}

	public double getNow_JASDAC_MIDDLE_MACD_SIGNAL_01() {
		return now_JASDAC_MIDDLE_MACD_SIGNAL_01;
	}

	public void setNow_JASDAC_MIDDLE_MACD_SIGNAL_01(
			double now_JASDAC_MIDDLE_MACD_SIGNAL_01) {
		this.now_JASDAC_MIDDLE_MACD_SIGNAL_01 = now_JASDAC_MIDDLE_MACD_SIGNAL_01;
	}

	public double getNow_JASDAC_LONG_MACD_01() {
		return now_JASDAC_LONG_MACD_01;
	}

	public void setNow_JASDAC_LONG_MACD_01(double now_JASDAC_LONG_MACD_01) {
		this.now_JASDAC_LONG_MACD_01 = now_JASDAC_LONG_MACD_01;
	}

	public double getNow_JASDAC_LONG_MACD_SIGNAL_01() {
		return now_JASDAC_LONG_MACD_SIGNAL_01;
	}

	public void setNow_JASDAC_LONG_MACD_SIGNAL_01(
			double now_JASDAC_LONG_MACD_SIGNAL_01) {
		this.now_JASDAC_LONG_MACD_SIGNAL_01 = now_JASDAC_LONG_MACD_SIGNAL_01;
	}



	//業種
	String category;
	//発行済株式数
	double stock_num;
	//時価総額（百万円）
	double market_cap_ppt;
	//配当利回り
	double dividend_per;
	//1株配当
	double dividend;
	//per（予想）
	double per_yoso;
	//pbr（実績）
	double pbr_real;
	//eps（予想）
	double eps_yoso;
	//bps（実績）
	double bps_real;
	//高値日付
	String year_max_day_yyyymmdd;
	//年初来高値
	double year_max;
	//安値日付
	String year_min_day_yyyymmdd;
	//年初来安値
	double year_min;

	//発行済株式数_pre
	double stock_num_pre;
	//時価総額（百万円）_pre
	double market_cap_ppt_pre;
	//配当利回り_pre
	double dividend_per_pre;
	//1株配当_pre
	double dividend_pre;
	//per（予想）_pre
	double per_yoso_pre;
	//pbr（実績）_pre
	double pbr_real_pre;
	//eps（予想）_pre
	double eps_yoso_pre;
	//bps（実績）_pre
	double bps_real_pre;
	//高値日付_pre
	String year_max_day_yyyymmdd_pre;
	//年初来高値_pre
	double year_max_pre;
	//安値日付_pre
	String year_min_day_yyyymmdd_pre;
	//年初来安値_pre
	double year_min_pre;



	public double getStock_num_pre() {
		return stock_num_pre;
	}

	public void setStock_num_pre(double stock_num_pre) {
		this.stock_num_pre = stock_num_pre;
	}

	public double getMarket_cap_ppt_pre() {
		return market_cap_ppt_pre;
	}

	public void setMarket_cap_ppt_pre(double market_cap_ppt_pre) {
		this.market_cap_ppt_pre = market_cap_ppt_pre;
	}

	public double getDividend_per_pre() {
		return dividend_per_pre;
	}

	public void setDividend_per_pre(double dividend_per_pre) {
		this.dividend_per_pre = dividend_per_pre;
	}

	public double getDividend_pre() {
		return dividend_pre;
	}

	public void setDividend_pre(double dividend_pre) {
		this.dividend_pre = dividend_pre;
	}

	public double getPer_yoso_pre() {
		return per_yoso_pre;
	}

	public void setPer_yoso_pre(double per_yoso_pre) {
		this.per_yoso_pre = per_yoso_pre;
	}

	public double getPbr_real_pre() {
		return pbr_real_pre;
	}

	public void setPbr_real_pre(double pbr_real_pre) {
		this.pbr_real_pre = pbr_real_pre;
	}

	public double getEps_yoso_pre() {
		return eps_yoso_pre;
	}

	public void setEps_yoso_pre(double eps_yoso_pre) {
		this.eps_yoso_pre = eps_yoso_pre;
	}

	public double getBps_real_pre() {
		return bps_real_pre;
	}

	public void setBps_real_pre(double bps_real_pre) {
		this.bps_real_pre = bps_real_pre;
	}

	public String getYear_max_day_yyyymmdd_pre() {
		return year_max_day_yyyymmdd_pre;
	}

	public void setYear_max_day_yyyymmdd_pre(String year_max_day_yyyymmdd_pre) {
		this.year_max_day_yyyymmdd_pre = year_max_day_yyyymmdd_pre;
	}

	public double getYear_max_pre() {
		return year_max_pre;
	}

	public void setYear_max_pre(double year_max_pre) {
		this.year_max_pre = year_max_pre;
	}

	public String getYear_min_day_yyyymmdd_pre() {
		return year_min_day_yyyymmdd_pre;
	}

	public void setYear_min_day_yyyymmdd_pre(String year_min_day_yyyymmdd_pre) {
		this.year_min_day_yyyymmdd_pre = year_min_day_yyyymmdd_pre;
	}

	public double getYear_min_pre() {
		return year_min_pre;
	}

	public void setYear_min_pre(double year_min_pre) {
		this.year_min_pre = year_min_pre;
	}

	public double getStock_num() {
		return stock_num;
	}

	public void setStock_num(double stock_num) {
		this.stock_num = stock_num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getMarket_cap_ppt() {
		return market_cap_ppt;
	}

	public void setMarket_cap_ppt(double market_cap_ppt) {
		this.market_cap_ppt = market_cap_ppt;
	}

	public double getDividend_per() {
		return dividend_per;
	}

	public void setDividend_per(double dividend_per) {
		this.dividend_per = dividend_per;
	}

	public double getDividend() {
		return dividend;
	}

	public void setDividend(double dividend) {
		this.dividend = dividend;
	}

	public double getPer_yoso() {
		return per_yoso;
	}

	public void setPer_yoso(double per_yoso) {
		this.per_yoso = per_yoso;
	}

	public double getPbr_real() {
		return pbr_real;
	}

	public void setPbr_real(double pbr_real) {
		this.pbr_real = pbr_real;
	}

	public double getEps_yoso() {
		return eps_yoso;
	}

	public void setEps_yoso(double eps_yoso) {
		this.eps_yoso = eps_yoso;
	}

	public double getBps_real() {
		return bps_real;
	}

	public void setBps_real(double bps_real) {
		this.bps_real = bps_real;
	}

	public String getYear_max_day_yyyymmdd() {
		return year_max_day_yyyymmdd;
	}

	public void setYear_max_day_yyyymmdd(String year_max_day_yyyymmdd) {
		this.year_max_day_yyyymmdd = year_max_day_yyyymmdd;
	}

	public double getYear_max() {
		return year_max;
	}

	public void setYear_max(double year_max) {
		this.year_max = year_max;
	}

	public String getYear_min_day_yyyymmdd() {
		return year_min_day_yyyymmdd;
	}

	public void setYear_min_day_yyyymmdd(String year_min_day_yyyymmdd) {
		this.year_min_day_yyyymmdd = year_min_day_yyyymmdd;
	}

	public double getYear_min() {
		return year_min;
	}

	public void setYear_min(double year_min) {
		this.year_min = year_min;
	}


}
