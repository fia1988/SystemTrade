package bean;

public class Bean_FinancialStatement {

	private String code_01;
	private String nowDay_01;
	//マーケット
	private String market;
	//決算期
	private String kessan_term_yyyy_mm_string;
	//決算発表日（本決算）
	private String year_kessan_time_yyyymmdd;
	//売上高（百万円）
	private double uriage_daka_ppt;
	//営業利益（百万円）
	private double eigyo_prof_ppt;
	//経常利益（百万円）
	private double keijo_prof_ppt;
	//当期利益（百万円）
	private double bottom_line_ppt;
	//総資産（百万円）
	private double total_asset_ppt;
	//自己資本（百万円）
	private double self_asset_ppt;
	//資本金（百万円）
	private double shihonkin_asset_ppt;
	//有利子負債（百万円）
	private double loan_ppt;
	//自己資本比率
	private double self_asset_wariai;
	//roe
	private double roe;
	//roa
	private double roa;




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
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getKessan_term_yyyy_mm_string() {
		return kessan_term_yyyy_mm_string;
	}
	public void setKessan_term_yyyy_mm_string(String kessan_term_yyyy_mm_string) {
		this.kessan_term_yyyy_mm_string = kessan_term_yyyy_mm_string;
	}
	public String getYear_kessan_time_yyyymmdd() {
		return year_kessan_time_yyyymmdd;
	}
	public void setYear_kessan_time_yyyymmdd(String year_kessan_time_yyyymmdd) {
		this.year_kessan_time_yyyymmdd = year_kessan_time_yyyymmdd;
	}
	public double getUriage_daka_ppt() {
		return uriage_daka_ppt;
	}
	public void setUriage_daka_ppt(double uriage_daka_ppt) {
		this.uriage_daka_ppt = uriage_daka_ppt;
	}
	public double getEigyo_prof_ppt() {
		return eigyo_prof_ppt;
	}
	public void setEigyo_prof_ppt(double eigyo_prof_ppt) {
		this.eigyo_prof_ppt = eigyo_prof_ppt;
	}
	public double getKeijo_prof_ppt() {
		return keijo_prof_ppt;
	}
	public void setKeijo_prof_ppt(double keijo_prof_ppt) {
		this.keijo_prof_ppt = keijo_prof_ppt;
	}
	public double getBottom_line_ppt() {
		return bottom_line_ppt;
	}
	public void setBottom_line_ppt(double bottom_line_ppt) {
		this.bottom_line_ppt = bottom_line_ppt;
	}
	public double getTotal_asset_ppt() {
		return total_asset_ppt;
	}
	public void setTotal_asset_ppt(double total_asset_ppt) {
		this.total_asset_ppt = total_asset_ppt;
	}
	public double getSelf_asset_ppt() {
		return self_asset_ppt;
	}
	public void setSelf_asset_ppt(double self_asset_ppt) {
		this.self_asset_ppt = self_asset_ppt;
	}
	public double getShihonkin_asset_ppt() {
		return shihonkin_asset_ppt;
	}
	public void setShihonkin_asset_ppt(double shihonkin_asset_ppt) {
		this.shihonkin_asset_ppt = shihonkin_asset_ppt;
	}
	public double getLoan_ppt() {
		return loan_ppt;
	}
	public void setLoan_ppt(double loan_ppt) {
		this.loan_ppt = loan_ppt;
	}
	public double getSelf_asset_wariai() {
		return self_asset_wariai;
	}
	public void setSelf_asset_wariai(double self_asset_wariai) {
		this.self_asset_wariai = self_asset_wariai;
	}
	public double getRoe() {
		return roe;
	}
	public void setRoe(double roe) {
		this.roe = roe;
	}
	public double getRoa() {
		return roa;
	}
	public void setRoa(double roa) {
		this.roa = roa;
	}



}
