package bean;

public class Bean_FinancialStatement {

	private String code_01;
	String nowDay_01;
	//マーケット
	String market;
	//決算期
	String kessan_term_yyyy_mm_string;
	//決算発表日（本決算）
	String year_kessan_time_yyyymmdd;
	//売上高（百万円）
	double uriage_daka_ppt;
	//営業利益（百万円）
	double eigyo_prof_ppt;
	//経常利益（百万円）
	double keijo_prof_ppt;
	//当期利益（百万円）
	double bottom_line_ppt;
	//総資産（百万円）
	double total_asset_ppt;
	//自己資本（百万円）
	double self_asset_ppt;
	//資本金（百万円）
	double shihonkin_asset_ppt;
	//有利子負債（百万円）
	double loan_ppt;
	//自己資本比率
	double self_asset_wariai;
	//roe
	double roe;
	//roa
	double roa;
}
