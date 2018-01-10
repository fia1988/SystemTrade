package bean;

public class Bean_Forrign_Ratio {
	private String code_01;
	String nowDay_01;
	//浮動株数比率
	double another_stock_holder_ratio;
	//少数特定者持株数比率
	double major_stock_holder_ratio;
	//投資信託持株数比率
	double etf_stock_holder_ratio;
	//外国人持株数比率
	double foreigner_stock_holder_ratio;
//	//信用買残高
//	double credit_long;
//	//信用買残高前週比
//	double credit_long_changerate_w;
//	//信用売残高
//	double credit_short;
//	//信用売残高前週比
//	double credit_short_changerate_w;
//	//貸借倍率
//	double credit_ratio;


	//------PREここから
	//浮動株数比率
	double another_stock_holder_ratio_pre;
	public String getCode_01() {
		return code_01;
	}
	public void setCode_01(String code_01) {
		this.code_01 = code_01;
	}
	public String getNowDay_01() {
		return nowDay_01;
	}
	public void setNowDay_01(String nowDay_01) {
		this.nowDay_01 = nowDay_01;
	}
	//少数特定者持株数比率
	double major_stock_holder_ratio_pre;
	//投資信託持株数比率
	double etf_stock_holder_ratio_pre;
	//外国人持株数比率
	double foreigner_stock_holder_ratio_pre;
	//------PREここまで
	public double getAnother_stock_holder_ratio() {
		return another_stock_holder_ratio;
	}
	public void setAnother_stock_holder_ratio(double another_stock_holder_ratio) {
		this.another_stock_holder_ratio = another_stock_holder_ratio;
	}
	public double getMajor_stock_holder_ratio() {
		return major_stock_holder_ratio;
	}
	public void setMajor_stock_holder_ratio(double major_stock_holder_ratio) {
		this.major_stock_holder_ratio = major_stock_holder_ratio;
	}
	public double getEtf_stock_holder_ratio() {
		return etf_stock_holder_ratio;
	}
	public void setEtf_stock_holder_ratio(double etf_stock_holder_ratio) {
		this.etf_stock_holder_ratio = etf_stock_holder_ratio;
	}
	public double getForeigner_stock_holder_ratio() {
		return foreigner_stock_holder_ratio;
	}
	public void setForeigner_stock_holder_ratio(double foreigner_stock_holder_ratio) {
		this.foreigner_stock_holder_ratio = foreigner_stock_holder_ratio;
	}
	public double getAnother_stock_holder_ratio_pre() {
		return another_stock_holder_ratio_pre;
	}
	public void setAnother_stock_holder_ratio_pre(
			double another_stock_holder_ratio_pre) {
		this.another_stock_holder_ratio_pre = another_stock_holder_ratio_pre;
	}
	public double getMajor_stock_holder_ratio_pre() {
		return major_stock_holder_ratio_pre;
	}
	public void setMajor_stock_holder_ratio_pre(double major_stock_holder_ratio_pre) {
		this.major_stock_holder_ratio_pre = major_stock_holder_ratio_pre;
	}
	public double getEtf_stock_holder_ratio_pre() {
		return etf_stock_holder_ratio_pre;
	}
	public void setEtf_stock_holder_ratio_pre(double etf_stock_holder_ratio_pre) {
		this.etf_stock_holder_ratio_pre = etf_stock_holder_ratio_pre;
	}
	public double getForeigner_stock_holder_ratio_pre() {
		return foreigner_stock_holder_ratio_pre;
	}
	public void setForeigner_stock_holder_ratio_pre(
			double foreigner_stock_holder_ratio_pre) {
		this.foreigner_stock_holder_ratio_pre = foreigner_stock_holder_ratio_pre;
	}
	
	
	
	
}
