package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.COLUMN;
import constant.logWriting;

public class Bean_Proccesing {


	public void proceccingParaDTO(Bean_Parameta paraDTO,Bean_Result resultDTO ,String code,S s){


		//本番環境だけここを通る
		if(paraDTO.getRealTimeMode()){
			//財務諸表データとか使う
			paraDTO.setMonthYearDateFLG(true);
		}
		//年単位とか月単位のデータ(財務諸表データ)を使うかどうか
		if (paraDTO.isMonthYearDateFLG()==false){
			//財務諸表データとか使わない。
			return;
		}else{
			//財務諸表データとか使う
		}

		List<Bean_FinancialStatement> B_FS_List = new ArrayList<>();
		s.resetConnection();
		String SQL = " select * from " + TBL_Name.FINANCIAL_MM_TBL + " where " + COLUMN.CODE + " = '" + code + "'" ;

		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {
				B_FS_List.add(	setB_FS(s.rs2)	);
			}
		} catch (SQLException e) {
			commonAP.writeInLog("【proceccingParaDTO:なんかえらーだって1】" + SQL ,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}




		List<Bean_Forrign_Ratio> B_FR_List = new ArrayList<>();
		s.resetConnection();
		SQL = " select * from " + TBL_Name.FORRIGN_RATIO_TBL + " where " + COLUMN.CODE + " = '" + code + "'" ;;

		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {
				B_FR_List.add(	setB_FR(s.rs2)	);
			}
		} catch (SQLException e) {
			commonAP.writeInLog("【proceccingParaDTO:なんかえらーだって2】" + SQL ,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);

		}


//		List<Bean_Credit> B_Cr_List = new ArrayList<>();
//		s.resetConnection();
//		SQL = " select * from " + TBL_Name.INVEST_SIHYO_DD_TBL + " where " + COLUMN.CODE + " = '" + code + "'" ;;
//
//		try {
//			s.rs2 = s.sqlGetter().executeQuery(SQL);
//			while ( s.rs2.next() ) {
//				B_Cr_List.add(	setB_Cr(s.rs2)	);
//			}
//		} catch (SQLException e) {
//			commonAP.writeInLog("【proceccingParaDTO:なんかえらーだって3】" + SQL ,logWriting.DATEDATE_LOG_FLG);
//			commonAP.writeInErrLog(e);
//		}
		s.resetConnection();



		paraDTO.setB_FR_List(B_FR_List);
		paraDTO.setB_FS_List(B_FS_List);

		if(code.equals("3484")){
			for (Bean_FinancialStatement a:paraDTO.getB_FS_List()){
				System.out.println("proceccingParaDTO3484:"+a.getRoe());
			}
		}
		if(code.equals("1400")){
			for (Bean_FinancialStatement a:paraDTO.getB_FS_List()){
				System.out.println("proceccingParaDTO1400:"+a.getRoe());
			}
		}


	}



	private Bean_FinancialStatement setB_FS(ResultSet RS) throws SQLException{
		Bean_FinancialStatement nowB_FS = new Bean_FinancialStatement();
//
//		TBL_Name.FINANCIAL_MM_TBL

		nowB_FS.setKessan_term_yyyy_mm_string(RS.getString(COLUMN.KESSAN_TERM_YYYY_MM_STRING));
		try{nowB_FS.setYear_kessan_time_yyyymmdd(RS.getString(COLUMN.YEAR_KESSAN_TIME_YYYYMMDD));} catch (SQLException e) {}
		if(!(RS.getInt(COLUMN.URIAGE_DAKA_PPT)== 0) && (RS.getString(COLUMN.URIAGE_DAKA_PPT) == null )){nowB_FS.setUriage_daka_ppt(RS.getInt(COLUMN.URIAGE_DAKA_PPT));}
		if(!(RS.getInt(COLUMN.EIGYO_PROF_PPT)== 0) && (RS.getString(COLUMN.EIGYO_PROF_PPT) == null )){nowB_FS.setEigyo_prof_ppt(RS.getInt(COLUMN.EIGYO_PROF_PPT));}
		if(!(RS.getInt(COLUMN.KEIJO_PROF_PPT)== 0) && (RS.getString(COLUMN.KEIJO_PROF_PPT) == null )){nowB_FS.setKeijo_prof_ppt(RS.getInt(COLUMN.KEIJO_PROF_PPT));}
		if(!(RS.getInt(COLUMN.BOTTOM_LINE_PPT)== 0) && (RS.getString(COLUMN.BOTTOM_LINE_PPT) == null )){nowB_FS.setBottom_line_ppt(RS.getInt(COLUMN.BOTTOM_LINE_PPT));}
		if(!(RS.getInt(COLUMN.TOTAL_ASSET_PPT)== 0) && (RS.getString(COLUMN.TOTAL_ASSET_PPT) == null )){nowB_FS.setTotal_asset_ppt(RS.getInt(COLUMN.TOTAL_ASSET_PPT));}
		if(!(RS.getInt(COLUMN.SELF_ASSET_PPT)== 0) && (RS.getString(COLUMN.SELF_ASSET_PPT) == null )){nowB_FS.setSelf_asset_ppt(RS.getInt(COLUMN.SELF_ASSET_PPT));}
		if(!(RS.getInt(COLUMN.SHIHONKIN_ASSET_PPT)== 0) && (RS.getString(COLUMN.SHIHONKIN_ASSET_PPT) == null )){nowB_FS.setShihonkin_asset_ppt(RS.getInt(COLUMN.SHIHONKIN_ASSET_PPT));}
		if(!(RS.getInt(COLUMN.LOAN_PPT)== 0) && (RS.getString(COLUMN.LOAN_PPT) == null )){nowB_FS.setLoan_ppt(RS.getInt(COLUMN.LOAN_PPT));}
		if(!(RS.getInt(COLUMN.SELF_ASSET_WARIAI)== 0) && (RS.getString(COLUMN.SELF_ASSET_WARIAI) == null )){nowB_FS.setSelf_asset_wariai(RS.getInt(COLUMN.SELF_ASSET_WARIAI));}
		if(!(RS.getInt(COLUMN.ROE)== 0) && (RS.getString(COLUMN.ROE) == null )){nowB_FS.setRoe(RS.getInt(COLUMN.ROE));}
		if(!(RS.getInt(COLUMN.ROA)== 0) && (RS.getString(COLUMN.ROA) == null )){nowB_FS.setRoa(RS.getInt(COLUMN.ROA));}
//		nowB_FS.setKessan_term_yyyy_mm_string_pre(RS.getString(COLUMN.KESSAN_TERM_YYYY_MM_STRING_PRE));
//		nowB_FS.setYear_kessan_time_yyyymmdd_pre(RS.getString(COLUMN.YEAR_KESSAN_TIME_YYYYMMDD_PRE));
//		if(!(RS.getInt(COLUMN.URIAGE_DAKA_PPT_PRE)== 0) && (RS.getString(COLUMN.URIAGE_DAKA_PPT_PRE) == null )){nowB_FS.setUriage_daka_ppt_pre(RS.getInt(COLUMN.URIAGE_DAKA_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.EIGYO_PROF_PPT_PRE)== 0) && (RS.getString(COLUMN.EIGYO_PROF_PPT_PRE) == null )){nowB_FS.setEigyo_prof_ppt_pre(RS.getInt(COLUMN.EIGYO_PROF_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.KEIJO_PROF_PPT_PRE)== 0) && (RS.getString(COLUMN.KEIJO_PROF_PPT_PRE) == null )){nowB_FS.setKeijo_prof_ppt_pre(RS.getInt(COLUMN.KEIJO_PROF_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.BOTTOM_LINE_PPT_PRE)== 0) && (RS.getString(COLUMN.BOTTOM_LINE_PPT_PRE) == null )){nowB_FS.setBottom_line_ppt_pre(RS.getInt(COLUMN.BOTTOM_LINE_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.TOTAL_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.TOTAL_ASSET_PPT_PRE) == null )){nowB_FS.setTotal_asset_ppt_pre(RS.getInt(COLUMN.TOTAL_ASSET_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.SELF_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.SELF_ASSET_PPT_PRE) == null )){nowB_FS.setSelf_asset_ppt_pre(RS.getInt(COLUMN.SELF_ASSET_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.SHIHONKIN_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.SHIHONKIN_ASSET_PPT_PRE) == null )){nowB_FS.setShihonkin_asset_ppt_pre(RS.getInt(COLUMN.SHIHONKIN_ASSET_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.LOAN_PPT_PRE)== 0) && (RS.getString(COLUMN.LOAN_PPT_PRE) == null )){nowB_FS.setLoan_ppt_pre(RS.getInt(COLUMN.LOAN_PPT_PRE));}
//		if(!(RS.getInt(COLUMN.SELF_ASSET_WARIAI_PRE)== 0) && (RS.getString(COLUMN.SELF_ASSET_WARIAI_PRE) == null )){nowB_FS.setSelf_asset_wariai_pre(RS.getInt(COLUMN.SELF_ASSET_WARIAI_PRE));}
//		if(!(RS.getInt(COLUMN.ROE_PRE)== 0) && (RS.getString(COLUMN.ROE_PRE) == null )){nowB_FS.setRoe_pre(RS.getInt(COLUMN.ROE_PRE));}
//		if(!(RS.getInt(COLUMN.ROA_PRE)== 0) && (RS.getString(COLUMN.ROA_PRE) == null )){nowB_FS.setRoa_pre(RS.getInt(COLUMN.ROA_PRE));}





		return nowB_FS;
	}

	private Bean_Forrign_Ratio setB_FR(ResultSet RS) throws SQLException{
		Bean_Forrign_Ratio nowB_FR = new Bean_Forrign_Ratio();
//		TBL_Name.FORRIGN_RATIO_TBL

		nowB_FR.setNowDay_01(RS.getString(COLUMN.DAYTIME));
		if(!(RS.getInt(COLUMN.ANOTHER_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.ANOTHER_STOCK_HOLDER_RATIO) == null )){nowB_FR.setAnother_stock_holder_ratio(RS.getInt(COLUMN.ANOTHER_STOCK_HOLDER_RATIO));}
		if(!(RS.getInt(COLUMN.MAJOR_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.MAJOR_STOCK_HOLDER_RATIO) == null )){nowB_FR.setMajor_stock_holder_ratio(RS.getInt(COLUMN.MAJOR_STOCK_HOLDER_RATIO));}
		if(!(RS.getInt(COLUMN.ETF_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.ETF_STOCK_HOLDER_RATIO) == null )){nowB_FR.setEtf_stock_holder_ratio(RS.getInt(COLUMN.ETF_STOCK_HOLDER_RATIO));}
		if(!(RS.getInt(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO) == null )){nowB_FR.setForeigner_stock_holder_ratio(RS.getInt(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO));}
		if(!(RS.getInt(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setAnother_stock_holder_ratio_pre(RS.getInt(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE));}
		if(!(RS.getInt(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setMajor_stock_holder_ratio_pre(RS.getInt(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE));}
		if(!(RS.getInt(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setEtf_stock_holder_ratio_pre(RS.getInt(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE));}
		if(!(RS.getInt(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setForeigner_stock_holder_ratio_pre(RS.getInt(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE));}


		return nowB_FR;
	}

	private Bean_nowRecord setB_Cr(ResultSet RS) throws SQLException{
		Bean_nowRecord nowB_Cr = new Bean_nowRecord();
//		TBL_Name.INVEST_SIHYO_DD_TBL
		nowB_Cr.setMARKET(RS.getString(COLUMN.MARKET));
		nowB_Cr.setCATEGORY(RS.getString(COLUMN.CATEGORY));
		if(!(RS.getInt(COLUMN.MARKET_CAP_PPT)== 0) && (RS.getString(COLUMN.MARKET_CAP_PPT) == null )){nowB_Cr.setMARKET_CAP_PPT(RS.getInt(COLUMN.MARKET_CAP_PPT));}
		if(!(RS.getInt(COLUMN.STOCK_NUM)== 0) && (RS.getString(COLUMN.STOCK_NUM) == null )){nowB_Cr.setSTOCK_NUM(RS.getInt(COLUMN.STOCK_NUM));}
		if(!(RS.getInt(COLUMN.DIVIDEND_PER)== 0) && (RS.getString(COLUMN.DIVIDEND_PER) == null )){nowB_Cr.setDIVIDEND_PER(RS.getInt(COLUMN.DIVIDEND_PER));}
		if(!(RS.getInt(COLUMN.DIVIDEND)== 0) && (RS.getString(COLUMN.DIVIDEND) == null )){nowB_Cr.setDIVIDEND(RS.getInt(COLUMN.DIVIDEND));}
		if(!(RS.getInt(COLUMN.PER_YOSO)== 0) && (RS.getString(COLUMN.PER_YOSO) == null )){nowB_Cr.setPER_YOSO(RS.getInt(COLUMN.PER_YOSO));}
		if(!(RS.getInt(COLUMN.PBR_REAL)== 0) && (RS.getString(COLUMN.PBR_REAL) == null )){nowB_Cr.setPBR_REAL(RS.getInt(COLUMN.PBR_REAL));}
		if(!(RS.getInt(COLUMN.EPS_YOSO)== 0) && (RS.getString(COLUMN.EPS_YOSO) == null )){nowB_Cr.setEPS_YOSO(RS.getInt(COLUMN.EPS_YOSO));}
		if(!(RS.getInt(COLUMN.BPS_REAL)== 0) && (RS.getString(COLUMN.BPS_REAL) == null )){nowB_Cr.setBPS_REAL(RS.getInt(COLUMN.BPS_REAL));}
		nowB_Cr.setYEAR_MAX_DAY_YYYYMMDD(RS.getString(COLUMN.YEAR_MAX_DAY_YYYYMMDD));
		if(!(RS.getInt(COLUMN.YEAR_MAX)== 0) && (RS.getString(COLUMN.YEAR_MAX) == null )){nowB_Cr.setYEAR_MAX(RS.getInt(COLUMN.YEAR_MAX));}
		nowB_Cr.setYEAR_MIN_DAY_YYYYMMDD(RS.getString(COLUMN.YEAR_MIN_DAY_YYYYMMDD));
		if(!(RS.getInt(COLUMN.YEAR_MIN)== 0) && (RS.getString(COLUMN.YEAR_MIN) == null )){nowB_Cr.setYEAR_MIN(RS.getInt(COLUMN.YEAR_MIN));}
		if(!(RS.getInt(COLUMN.MARKET_CAP_PPT_PRE)== 0) && (RS.getString(COLUMN.MARKET_CAP_PPT_PRE) == null )){nowB_Cr.setMARKET_CAP_PPT_PRE(RS.getInt(COLUMN.MARKET_CAP_PPT_PRE));}
		if(!(RS.getInt(COLUMN.STOCK_NUM_PRE)== 0) && (RS.getString(COLUMN.STOCK_NUM_PRE) == null )){nowB_Cr.setSTOCK_NUM_PRE(RS.getInt(COLUMN.STOCK_NUM_PRE));}
		if(!(RS.getInt(COLUMN.DIVIDEND_PER_PRE)== 0) && (RS.getString(COLUMN.DIVIDEND_PER_PRE) == null )){nowB_Cr.setDIVIDEND_PER_PRE(RS.getInt(COLUMN.DIVIDEND_PER_PRE));}
		if(!(RS.getInt(COLUMN.DIVIDEND_PRE)== 0) && (RS.getString(COLUMN.DIVIDEND_PRE) == null )){nowB_Cr.setDIVIDEND_PRE(RS.getInt(COLUMN.DIVIDEND_PRE));}
		if(!(RS.getInt(COLUMN.PER_YOSO_PRE)== 0) && (RS.getString(COLUMN.PER_YOSO_PRE) == null )){nowB_Cr.setPER_YOSO_PRE(RS.getInt(COLUMN.PER_YOSO_PRE));}
		if(!(RS.getInt(COLUMN.PBR_REAL_PRE)== 0) && (RS.getString(COLUMN.PBR_REAL_PRE) == null )){nowB_Cr.setPBR_REAL_PRE(RS.getInt(COLUMN.PBR_REAL_PRE));}
		if(!(RS.getInt(COLUMN.EPS_YOSO_PRE)== 0) && (RS.getString(COLUMN.EPS_YOSO_PRE) == null )){nowB_Cr.setEPS_YOSO_PRE(RS.getInt(COLUMN.EPS_YOSO_PRE));}
		if(!(RS.getInt(COLUMN.BPS_REAL_PRE)== 0) && (RS.getString(COLUMN.BPS_REAL_PRE) == null )){nowB_Cr.setBPS_REAL_PRE(RS.getInt(COLUMN.BPS_REAL_PRE));}
		nowB_Cr.setYEAR_MAX_DAY_YYYYMMDD_PRE(RS.getString(COLUMN.YEAR_MAX_DAY_YYYYMMDD_PRE));
		if(!(RS.getInt(COLUMN.YEAR_MAX_PRE)== 0) && (RS.getString(COLUMN.YEAR_MAX_PRE) == null )){nowB_Cr.setYEAR_MAX_PRE(RS.getInt(COLUMN.YEAR_MAX_PRE));}
		nowB_Cr.setYEAR_MIN_DAY_YYYYMMDD_PRE(RS.getString(COLUMN.YEAR_MIN_DAY_YYYYMMDD_PRE));
		if(!(RS.getInt(COLUMN.YEAR_MIN_PRE)== 0) && (RS.getString(COLUMN.YEAR_MIN_PRE) == null )){nowB_Cr.setYEAR_MIN_PRE(RS.getInt(COLUMN.YEAR_MIN_PRE));}


		return nowB_Cr;
	}

}
