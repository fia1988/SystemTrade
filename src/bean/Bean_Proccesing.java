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
//		if(paraDTO.getRealTimeMode()){
////			paraDTO.setCheckInvest(true);
//			//財務諸表データとか使う
//			paraDTO.setMonthYearDateFLG(true);
//		}
		//年単位とか月単位のデータ(財務諸表データ)を使うかどうか
		if (paraDTO.isMonthYearDateFLG()==false){
			//財務諸表データとか使わない。
			return;
		}else{
			//財務諸表データとか使う
		}

		Bean_FinancialStatement B_FS = new Bean_FinancialStatement();
		Bean_Forrign_Ratio B_FR = new Bean_Forrign_Ratio();
		Bean_Credit B_Cr = new Bean_Credit();

		s.resetConnection();
		String SQL = " select * from " + TBL_Name.FINANCIAL_MM_TBL + " where " + COLUMN.CODE + " = '" + code + "'" ;

		try {
			List<Bean_FinancialStatement> B_FS_List = new ArrayList<>();
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {
				B_FS_List.add(	setB_FS(s.rs2)	);
			}
		} catch (SQLException e) {
			commonAP.writeInLog("【なんかえらーだって】" ,logWriting.DATEDATE_LOG_FLG);
			e.printStackTrace();}




		s.resetConnection();
		SQL = " select * from " + TBL_Name.FORRIGN_RATIO_TBL;

		s.resetConnection();
		SQL = " select * from " + TBL_Name.INVEST_SIHYO_DD_TBL;
	}



	private Bean_FinancialStatement setB_FS(ResultSet RS){
		Bean_FinancialStatement nowB_FS = new Bean_FinancialStatement();
//		nowB_FS.setNowDay_01		(	RS.getString( ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME		)	);
		try {
			nowB_FS.setBottom_line_ppt(RS.getDouble(COLUMN.BOTTOM_LINE_PPT));
			nowB_FS.setBottom_line_ppt_pre(RS.getDouble(COLUMN.BOTTOM_LINE_PPT_PRE));
		} catch (SQLException e) {
		}
		return nowB_FS;
	}
}
