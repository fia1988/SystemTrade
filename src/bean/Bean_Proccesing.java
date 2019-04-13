package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.logWriting;

public class Bean_Proccesing {


	public void proceccingParaDTO(Bean_Parameta paraDTO,Bean_Result resultDTO ,String code,S s){



		//年単位とか月単位のデータ(財務諸表データ)を使うかどうか
		if (paraDTO.isMonthYearDateFLG()==false){
			//財務諸表データとか使わない。
//			System.out.println("proceccingParaDTO:::::");
			return;
		}else{
			//財務諸表データとか使う
//			System.out.println("proceccingParaDTO::::aaaaaaaaaaaaaaaaaaaa:");
		}

		List<Bean_FinancialStatement> B_FS_List = new ArrayList<>();
		s.resetConnection();
		String SQL = " select * from " + TBL_Name.FINANCIAL_MM_TBL + " where " + COLUMN_TBL.CODE + " = '" + code + "'" ;

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
		SQL = " select * from " + TBL_Name.FORRIGN_RATIO_TBL + " where " + COLUMN_TBL.CODE + " = '" + code + "'" ;;

		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {
				B_FR_List.add(	setB_FR(s.rs2)	);
			}
		} catch (SQLException e) {
			commonAP.writeInLog("【proceccingParaDTO:なんかえらーだって2】" + SQL ,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);

		}

		if ( paraDTO.isCreditDateUseFlg() ) {
			List<Bean_Credit> B_Cr_List = new ArrayList<>();
			s.resetConnection();
			SQL = " select * from " + TBL_Name.CREDIT_WW_TBL + " where " + COLUMN_TBL.CODE + " = '" + code + "'" ;;

			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				while ( s.rs2.next() ) {
					B_Cr_List.add(	setB_Cr(s.rs2)	);
				}
			} catch (SQLException e) {
				commonAP.writeInLog("【proceccingParaDTO:なんかえらーだって3】" + SQL ,logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInErrLog(e);
			}
			s.resetConnection();
			paraDTO.setB_Cr_List(B_Cr_List);
		}






		paraDTO.setB_FR_List(B_FR_List);
		paraDTO.setB_FS_List(B_FS_List);



	}

	private Bean_Credit setB_Cr(ResultSet RS) throws SQLException{
		Bean_Credit nowB_Cr = new Bean_Credit();
//		TBL_Name.CREDIT_WW_TBL
		nowB_Cr.setNowDay_01(RS.getString(COLUMN_TBL.DAYTIME));
		nowB_Cr.setCODE(RS.getString(COLUMN_TBL.CODE));
		nowB_Cr.setCREDIT_LONG(RS.getDouble(COLUMN_TBL.CREDIT_LONG));
		nowB_Cr.setCREDIT_LONG_CHANGERATE_W(RS.getDouble(COLUMN_TBL.CREDIT_LONG_CHANGERATE_W));
		nowB_Cr.setCREDIT_SHORT(RS.getDouble(COLUMN_TBL.CREDIT_SHORT));
		nowB_Cr.setCREDIT_SHORT_CHANGERATE_W(RS.getDouble(COLUMN_TBL.CREDIT_SHORT_CHANGERATE_W));
		nowB_Cr.setCREDIT_RATIO(RS.getDouble(COLUMN_TBL.CREDIT_RATIO));


		return nowB_Cr;
	}

	private Bean_FinancialStatement setB_FS(ResultSet RS) throws SQLException{
		Bean_FinancialStatement nowB_FS = new Bean_FinancialStatement();
//
//		TBL_Name.FINANCIAL_MM_TBL
		nowB_FS.setNowDay_01(RS.getString(COLUMN_TBL.DAYTIME));
		nowB_FS.setCode_01(RS.getString(COLUMN_TBL.CODE));
		nowB_FS.setKessan_term_yyyy_mm_string(RS.getString(COLUMN_TBL.KESSAN_TERM_YYYY_MM_STRING));
		try{nowB_FS.setYear_kessan_time_yyyymmdd(RS.getString(COLUMN_TBL.YEAR_KESSAN_TIME_YYYYMMDD));} catch (SQLException e) {}
		nowB_FS.setUriage_daka_ppt(RS.getDouble(COLUMN_TBL.URIAGE_DAKA_PPT));
		nowB_FS.setEigyo_prof_ppt(RS.getDouble(COLUMN_TBL.EIGYO_PROF_PPT));
		nowB_FS.setKeijo_prof_ppt(RS.getDouble(COLUMN_TBL.KEIJO_PROF_PPT));
		nowB_FS.setBottom_line_ppt(RS.getDouble(COLUMN_TBL.BOTTOM_LINE_PPT));
		nowB_FS.setTotal_asset_ppt(RS.getDouble(COLUMN_TBL.TOTAL_ASSET_PPT));
		nowB_FS.setSelf_asset_ppt(RS.getDouble(COLUMN_TBL.SELF_ASSET_PPT));
		nowB_FS.setShihonkin_asset_ppt(RS.getDouble(COLUMN_TBL.SHIHONKIN_ASSET_PPT));
		nowB_FS.setLoan_ppt(RS.getDouble(COLUMN_TBL.LOAN_PPT));
		nowB_FS.setSelf_asset_wariai(RS.getDouble(COLUMN_TBL.SELF_ASSET_WARIAI));
		nowB_FS.setRoe(RS.getDouble(COLUMN_TBL.ROE));
		nowB_FS.setRoa(RS.getDouble(COLUMN_TBL.ROA));



//		if(!(RS.getDouble(COLUMN.URIAGE_DAKA_PPT)== 0) && (RS.getString(COLUMN.URIAGE_DAKA_PPT) == null )){nowB_FS.setUriage_daka_ppt(RS.getDouble(COLUMN.URIAGE_DAKA_PPT));}
//		if(!(RS.getDouble(COLUMN.EIGYO_PROF_PPT)== 0) && (RS.getString(COLUMN.EIGYO_PROF_PPT) == null )){nowB_FS.setEigyo_prof_ppt(RS.getDouble(COLUMN.EIGYO_PROF_PPT));}
//		if(!(RS.getDouble(COLUMN.KEIJO_PROF_PPT)== 0) && (RS.getString(COLUMN.KEIJO_PROF_PPT) == null )){nowB_FS.setKeijo_prof_ppt(RS.getDouble(COLUMN.KEIJO_PROF_PPT));}
//		if(!(RS.getDouble(COLUMN.BOTTOM_LINE_PPT)== 0) && (RS.getString(COLUMN.BOTTOM_LINE_PPT) == null )){nowB_FS.setBottom_line_ppt(RS.getDouble(COLUMN.BOTTOM_LINE_PPT));}
//		if(!(RS.getDouble(COLUMN.TOTAL_ASSET_PPT)== 0) && (RS.getString(COLUMN.TOTAL_ASSET_PPT) == null )){nowB_FS.setTotal_asset_ppt(RS.getDouble(COLUMN.TOTAL_ASSET_PPT));}
//		if(!(RS.getDouble(COLUMN.SELF_ASSET_PPT)== 0) && (RS.getString(COLUMN.SELF_ASSET_PPT) == null )){nowB_FS.setSelf_asset_ppt(RS.getDouble(COLUMN.SELF_ASSET_PPT));}
//		if(!(RS.getDouble(COLUMN.SHIHONKIN_ASSET_PPT)== 0) && (RS.getString(COLUMN.SHIHONKIN_ASSET_PPT) == null )){nowB_FS.setShihonkin_asset_ppt(RS.getDouble(COLUMN.SHIHONKIN_ASSET_PPT));}
//		if(!(RS.getDouble(COLUMN.LOAN_PPT)== 0) && (RS.getString(COLUMN.LOAN_PPT) == null )){nowB_FS.setLoan_ppt(RS.getDouble(COLUMN.LOAN_PPT));}
//		if(!(RS.getDouble(COLUMN.SELF_ASSET_WARIAI)== 0) && (RS.getString(COLUMN.SELF_ASSET_WARIAI) == null )){nowB_FS.setSelf_asset_wariai(RS.getDouble(COLUMN.SELF_ASSET_WARIAI));}
//		if(!(RS.getDouble(COLUMN.ROE)== 0) && (RS.getString(COLUMN.ROE) == null )){nowB_FS.setRoe(RS.getDouble(COLUMN.ROE));}
//		if(!(RS.getDouble(COLUMN.ROA)== 0) && (RS.getString(COLUMN.ROA) == null )){nowB_FS.setRoa(RS.getDouble(COLUMN.ROA));}



//		nowB_FS.setKessan_term_yyyy_mm_string_pre(RS.getString(COLUMN.KESSAN_TERM_YYYY_MM_STRING_PRE));
//		nowB_FS.setYear_kessan_time_yyyymmdd_pre(RS.getString(COLUMN.YEAR_KESSAN_TIME_YYYYMMDD_PRE));
//		if(!(RS.getDouble(COLUMN.URIAGE_DAKA_PPT_PRE)== 0) && (RS.getString(COLUMN.URIAGE_DAKA_PPT_PRE) == null )){nowB_FS.setUriage_daka_ppt_pre(RS.getDouble(COLUMN.URIAGE_DAKA_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.EIGYO_PROF_PPT_PRE)== 0) && (RS.getString(COLUMN.EIGYO_PROF_PPT_PRE) == null )){nowB_FS.setEigyo_prof_ppt_pre(RS.getDouble(COLUMN.EIGYO_PROF_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.KEIJO_PROF_PPT_PRE)== 0) && (RS.getString(COLUMN.KEIJO_PROF_PPT_PRE) == null )){nowB_FS.setKeijo_prof_ppt_pre(RS.getDouble(COLUMN.KEIJO_PROF_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.BOTTOM_LINE_PPT_PRE)== 0) && (RS.getString(COLUMN.BOTTOM_LINE_PPT_PRE) == null )){nowB_FS.setBottom_line_ppt_pre(RS.getDouble(COLUMN.BOTTOM_LINE_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.TOTAL_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.TOTAL_ASSET_PPT_PRE) == null )){nowB_FS.setTotal_asset_ppt_pre(RS.getDouble(COLUMN.TOTAL_ASSET_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.SELF_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.SELF_ASSET_PPT_PRE) == null )){nowB_FS.setSelf_asset_ppt_pre(RS.getDouble(COLUMN.SELF_ASSET_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.SHIHONKIN_ASSET_PPT_PRE)== 0) && (RS.getString(COLUMN.SHIHONKIN_ASSET_PPT_PRE) == null )){nowB_FS.setShihonkin_asset_ppt_pre(RS.getDouble(COLUMN.SHIHONKIN_ASSET_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.LOAN_PPT_PRE)== 0) && (RS.getString(COLUMN.LOAN_PPT_PRE) == null )){nowB_FS.setLoan_ppt_pre(RS.getDouble(COLUMN.LOAN_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.SELF_ASSET_WARIAI_PRE)== 0) && (RS.getString(COLUMN.SELF_ASSET_WARIAI_PRE) == null )){nowB_FS.setSelf_asset_wariai_pre(RS.getDouble(COLUMN.SELF_ASSET_WARIAI_PRE));}
//		if(!(RS.getDouble(COLUMN.ROE_PRE)== 0) && (RS.getString(COLUMN.ROE_PRE) == null )){nowB_FS.setRoe_pre(RS.getDouble(COLUMN.ROE_PRE));}
//		if(!(RS.getDouble(COLUMN.ROA_PRE)== 0) && (RS.getString(COLUMN.ROA_PRE) == null )){nowB_FS.setRoa_pre(RS.getDouble(COLUMN.ROA_PRE));}





		return nowB_FS;
	}

	private Bean_Forrign_Ratio setB_FR(ResultSet RS) throws SQLException{
		Bean_Forrign_Ratio nowB_FR = new Bean_Forrign_Ratio();
//		TBL_Name.FORRIGN_RATIO_TBL

		nowB_FR.setNowDay_01(RS.getString(COLUMN_TBL.DAYTIME));
		nowB_FR.setAnother_stock_holder_ratio(RS.getDouble(COLUMN_TBL.ANOTHER_STOCK_HOLDER_RATIO));
		nowB_FR.setMajor_stock_holder_ratio(RS.getDouble(COLUMN_TBL.MAJOR_STOCK_HOLDER_RATIO));
		nowB_FR.setEtf_stock_holder_ratio(RS.getDouble(COLUMN_TBL.ETF_STOCK_HOLDER_RATIO));
		nowB_FR.setForeigner_stock_holder_ratio(RS.getDouble(COLUMN_TBL.FOREIGNER_STOCK_HOLDER_RATIO));
		nowB_FR.setAnother_stock_holder_ratio_pre(RS.getDouble(COLUMN_TBL.ANOTHER_STOCK_HOLDER_RATIO_PRE));
		nowB_FR.setMajor_stock_holder_ratio_pre(RS.getDouble(COLUMN_TBL.MAJOR_STOCK_HOLDER_RATIO_PRE));
		nowB_FR.setEtf_stock_holder_ratio_pre(RS.getDouble(COLUMN_TBL.ETF_STOCK_HOLDER_RATIO_PRE));
		nowB_FR.setForeigner_stock_holder_ratio_pre(RS.getDouble(COLUMN_TBL.FOREIGNER_STOCK_HOLDER_RATIO_PRE));

//		if(!(RS.getDouble(COLUMN.ANOTHER_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.ANOTHER_STOCK_HOLDER_RATIO) == null )){nowB_FR.setAnother_stock_holder_ratio(RS.getDouble(COLUMN.ANOTHER_STOCK_HOLDER_RATIO));}
//		if(!(RS.getDouble(COLUMN.MAJOR_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.MAJOR_STOCK_HOLDER_RATIO) == null )){nowB_FR.setMajor_stock_holder_ratio(RS.getDouble(COLUMN.MAJOR_STOCK_HOLDER_RATIO));}
//		if(!(RS.getDouble(COLUMN.ETF_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.ETF_STOCK_HOLDER_RATIO) == null )){nowB_FR.setEtf_stock_holder_ratio(RS.getDouble(COLUMN.ETF_STOCK_HOLDER_RATIO));}
//		if(!(RS.getDouble(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO)== 0) && (RS.getString(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO) == null )){nowB_FR.setForeigner_stock_holder_ratio(RS.getDouble(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO));}
//		if(!(RS.getDouble(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setAnother_stock_holder_ratio_pre(RS.getDouble(COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE));}
//		if(!(RS.getDouble(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setMajor_stock_holder_ratio_pre(RS.getDouble(COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE));}
//		if(!(RS.getDouble(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setEtf_stock_holder_ratio_pre(RS.getDouble(COLUMN.ETF_STOCK_HOLDER_RATIO_PRE));}
//		if(!(RS.getDouble(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE)== 0) && (RS.getString(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE) == null )){nowB_FR.setForeigner_stock_holder_ratio_pre(RS.getDouble(COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE));}
//

		return nowB_FR;
	}

	private Bean_nowRecord setB_Inv(ResultSet RS) throws SQLException{
		Bean_nowRecord nowB_Inv = new Bean_nowRecord();
//		TBL_Name.INVEST_SIHYO_DD_TBL
		nowB_Inv.setMARKET(RS.getString(COLUMN_TBL.MARKET));
		nowB_Inv.setCATEGORY(RS.getString(COLUMN_TBL.CATEGORY));
		nowB_Inv.setMARKET_CAP_PPT(RS.getDouble(COLUMN_TBL.MARKET_CAP_PPT));
		nowB_Inv.setSTOCK_NUM(RS.getDouble(COLUMN_TBL.STOCK_NUM));
		nowB_Inv.setDIVIDEND_PER(RS.getDouble(COLUMN_TBL.DIVIDEND_PER));
		nowB_Inv.setDIVIDEND(RS.getDouble(COLUMN_TBL.DIVIDEND));
		nowB_Inv.setPER_YOSO(RS.getDouble(COLUMN_TBL.PER_YOSO));
		nowB_Inv.setPBR_REAL(RS.getDouble(COLUMN_TBL.PBR_REAL));
		nowB_Inv.setEPS_YOSO(RS.getDouble(COLUMN_TBL.EPS_YOSO));
		nowB_Inv.setBPS_REAL(RS.getDouble(COLUMN_TBL.BPS_REAL));
		nowB_Inv.setYEAR_MAX_DAY_YYYYMMDD(RS.getString(COLUMN_TBL.YEAR_MAX_DAY_YYYYMMDD));
		nowB_Inv.setYEAR_MAX(RS.getDouble(COLUMN_TBL.YEAR_MAX));
		nowB_Inv.setYEAR_MIN_DAY_YYYYMMDD(RS.getString(COLUMN_TBL.YEAR_MIN_DAY_YYYYMMDD));
		nowB_Inv.setYEAR_MIN(RS.getDouble(COLUMN_TBL.YEAR_MIN));
		nowB_Inv.setMARKET_CAP_PPT_PRE(RS.getDouble(COLUMN_TBL.MARKET_CAP_PPT_PRE));
		nowB_Inv.setSTOCK_NUM_PRE(RS.getDouble(COLUMN_TBL.STOCK_NUM_PRE));
		nowB_Inv.setDIVIDEND_PER_PRE(RS.getDouble(COLUMN_TBL.DIVIDEND_PER_PRE));
		nowB_Inv.setDIVIDEND_PRE(RS.getDouble(COLUMN_TBL.DIVIDEND_PRE));
		nowB_Inv.setPER_YOSO_PRE(RS.getDouble(COLUMN_TBL.PER_YOSO_PRE));
		nowB_Inv.setPBR_REAL_PRE(RS.getDouble(COLUMN_TBL.PBR_REAL_PRE));
		nowB_Inv.setEPS_YOSO_PRE(RS.getDouble(COLUMN_TBL.EPS_YOSO_PRE));
		nowB_Inv.setBPS_REAL_PRE(RS.getDouble(COLUMN_TBL.BPS_REAL_PRE));
		nowB_Inv.setYEAR_MAX_DAY_YYYYMMDD_PRE(RS.getString(COLUMN_TBL.YEAR_MAX_DAY_YYYYMMDD_PRE));
		nowB_Inv.setYEAR_MAX_PRE(RS.getDouble(COLUMN_TBL.YEAR_MAX_PRE));
		nowB_Inv.setYEAR_MIN_DAY_YYYYMMDD_PRE(RS.getString(COLUMN_TBL.YEAR_MIN_DAY_YYYYMMDD_PRE));
		nowB_Inv.setYEAR_MIN_PRE(RS.getDouble(COLUMN_TBL.YEAR_MIN_PRE));

//		nowB_Cr.setMARKET(RS.getString(COLUMN.MARKET));
//		nowB_Cr.setCATEGORY(RS.getString(COLUMN.CATEGORY));
//		if(!(RS.getDouble(COLUMN.MARKET_CAP_PPT)== 0) && (RS.getString(COLUMN.MARKET_CAP_PPT) == null )){nowB_Cr.setMARKET_CAP_PPT(RS.getDouble(COLUMN.MARKET_CAP_PPT));}
//		if(!(RS.getDouble(COLUMN.STOCK_NUM)== 0) && (RS.getString(COLUMN.STOCK_NUM) == null )){nowB_Cr.setSTOCK_NUM(RS.getDouble(COLUMN.STOCK_NUM));}
//		if(!(RS.getDouble(COLUMN.DIVIDEND_PER)== 0) && (RS.getString(COLUMN.DIVIDEND_PER) == null )){nowB_Cr.setDIVIDEND_PER(RS.getDouble(COLUMN.DIVIDEND_PER));}
//		if(!(RS.getDouble(COLUMN.DIVIDEND)== 0) && (RS.getString(COLUMN.DIVIDEND) == null )){nowB_Cr.setDIVIDEND(RS.getDouble(COLUMN.DIVIDEND));}
//		if(!(RS.getDouble(COLUMN.PER_YOSO)== 0) && (RS.getString(COLUMN.PER_YOSO) == null )){nowB_Cr.setPER_YOSO(RS.getDouble(COLUMN.PER_YOSO));}
//		if(!(RS.getDouble(COLUMN.PBR_REAL)== 0) && (RS.getString(COLUMN.PBR_REAL) == null )){nowB_Cr.setPBR_REAL(RS.getDouble(COLUMN.PBR_REAL));}
//		if(!(RS.getDouble(COLUMN.EPS_YOSO)== 0) && (RS.getString(COLUMN.EPS_YOSO) == null )){nowB_Cr.setEPS_YOSO(RS.getDouble(COLUMN.EPS_YOSO));}
//		if(!(RS.getDouble(COLUMN.BPS_REAL)== 0) && (RS.getString(COLUMN.BPS_REAL) == null )){nowB_Cr.setBPS_REAL(RS.getDouble(COLUMN.BPS_REAL));}
//		nowB_Cr.setYEAR_MAX_DAY_YYYYMMDD(RS.getString(COLUMN.YEAR_MAX_DAY_YYYYMMDD));
//		if(!(RS.getDouble(COLUMN.YEAR_MAX)== 0) && (RS.getString(COLUMN.YEAR_MAX) == null )){nowB_Cr.setYEAR_MAX(RS.getDouble(COLUMN.YEAR_MAX));}
//		nowB_Cr.setYEAR_MIN_DAY_YYYYMMDD(RS.getString(COLUMN.YEAR_MIN_DAY_YYYYMMDD));
//		if(!(RS.getDouble(COLUMN.YEAR_MIN)== 0) && (RS.getString(COLUMN.YEAR_MIN) == null )){nowB_Cr.setYEAR_MIN(RS.getDouble(COLUMN.YEAR_MIN));}
//		if(!(RS.getDouble(COLUMN.MARKET_CAP_PPT_PRE)== 0) && (RS.getString(COLUMN.MARKET_CAP_PPT_PRE) == null )){nowB_Cr.setMARKET_CAP_PPT_PRE(RS.getDouble(COLUMN.MARKET_CAP_PPT_PRE));}
//		if(!(RS.getDouble(COLUMN.STOCK_NUM_PRE)== 0) && (RS.getString(COLUMN.STOCK_NUM_PRE) == null )){nowB_Cr.setSTOCK_NUM_PRE(RS.getDouble(COLUMN.STOCK_NUM_PRE));}
//		if(!(RS.getDouble(COLUMN.DIVIDEND_PER_PRE)== 0) && (RS.getString(COLUMN.DIVIDEND_PER_PRE) == null )){nowB_Cr.setDIVIDEND_PER_PRE(RS.getDouble(COLUMN.DIVIDEND_PER_PRE));}
//		if(!(RS.getDouble(COLUMN.DIVIDEND_PRE)== 0) && (RS.getString(COLUMN.DIVIDEND_PRE) == null )){nowB_Cr.setDIVIDEND_PRE(RS.getDouble(COLUMN.DIVIDEND_PRE));}
//		if(!(RS.getDouble(COLUMN.PER_YOSO_PRE)== 0) && (RS.getString(COLUMN.PER_YOSO_PRE) == null )){nowB_Cr.setPER_YOSO_PRE(RS.getDouble(COLUMN.PER_YOSO_PRE));}
//		if(!(RS.getDouble(COLUMN.PBR_REAL_PRE)== 0) && (RS.getString(COLUMN.PBR_REAL_PRE) == null )){nowB_Cr.setPBR_REAL_PRE(RS.getDouble(COLUMN.PBR_REAL_PRE));}
//		if(!(RS.getDouble(COLUMN.EPS_YOSO_PRE)== 0) && (RS.getString(COLUMN.EPS_YOSO_PRE) == null )){nowB_Cr.setEPS_YOSO_PRE(RS.getDouble(COLUMN.EPS_YOSO_PRE));}
//		if(!(RS.getDouble(COLUMN.BPS_REAL_PRE)== 0) && (RS.getString(COLUMN.BPS_REAL_PRE) == null )){nowB_Cr.setBPS_REAL_PRE(RS.getDouble(COLUMN.BPS_REAL_PRE));}
//		nowB_Cr.setYEAR_MAX_DAY_YYYYMMDD_PRE(RS.getString(COLUMN.YEAR_MAX_DAY_YYYYMMDD_PRE));
//		if(!(RS.getDouble(COLUMN.YEAR_MAX_PRE)== 0) && (RS.getString(COLUMN.YEAR_MAX_PRE) == null )){nowB_Cr.setYEAR_MAX_PRE(RS.getDouble(COLUMN.YEAR_MAX_PRE));}
//		nowB_Cr.setYEAR_MIN_DAY_YYYYMMDD_PRE(RS.getString(COLUMN.YEAR_MIN_DAY_YYYYMMDD_PRE));
//		if(!(RS.getDouble(COLUMN.YEAR_MIN_PRE)== 0) && (RS.getString(COLUMN.YEAR_MIN_PRE) == null )){nowB_Cr.setYEAR_MIN_PRE(RS.getDouble(COLUMN.YEAR_MIN_PRE));}
//

		return nowB_Inv;
	}

}
