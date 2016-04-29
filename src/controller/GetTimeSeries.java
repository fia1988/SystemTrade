package controller;

import insertPackage.InsertDay;
import insertPackage.InsertStock;

import java.util.List;

import netConnect.NC_Controller;
import netConnect.NetBean;
import proparty.S;
import bean.Bean_Bean;
import bean.Bean_TBLRecord;

public class GetTimeSeries {
	InsertDay I_D = new InsertDay();

	//codelisttblをもとに時系列データを各テーブルに挿入する。
	public void updateTodayDD_STOCK_INDEX(String URL,String TODAY,String MAXDAY,int skipLine,S s){
		NC_Controller NC_Con = new NC_Controller();
		Bean_Bean B_B = new Bean_Bean();

		//CSVファイルを一定期間文、取得する。
		NC_Con.setNC_ConUrlCsvS_STOCK_INDEX(URL, TODAY, MAXDAY, skipLine);

		//取得したCSVファイルをループさせる。。
		for (int i =0;0<NC_Con.getNC_ConUrlCsvS_STOCK_INDEX().size();i++){
			//取得したCSVファイル１つをDTOに変換する。＝一行ごとにDTOに格納する。
			B_B.setList_CSVtoDTO_STOCK_ETF(NC_Con.getNC_ConUrlCsvS_STOCK_INDEX().get(i),"", skipLine);
			//インサートする
			I_D.InsertDD(B_B.getList_CSVtoDTO_STOCK_ETF(), s);

			//テスト用の行,、日付を取得する。
			System.out.println(B_B.getList_CSVtoDTO_STOCK_ETF().get(i).getDay());

		}
	}

	//codelisttblをもとに時系列データを各テーブルに挿入する。
	public void getTimeSeries_DD(){
		long start = System.currentTimeMillis();
		List<Bean_TBLRecord> DTO_B_T_List;
		NetBean NB = new  NetBean();

		S s = new S();
		InsertStock IS = new InsertStock();
		s.getCon();
	}

//	//codelisttblをもとに時系列データを各テーブルに挿入する。
//	public void getTimeSeries_DD(){
//		long start = System.currentTimeMillis();
//		List<Bean_TBLRecord> DTO_B_T_List;
//		NetBean NB = new  NetBean();
//
//		S s = new S();
//		InsertStock IS = new InsertStock();
//		s.getCon();
//		TBL_Name.setAllCodeList(s);
//
//
//		//証券とETFのリストをコードリストTBLから拾う
//		TBL_Name.setCodeList_HauhunReplace(s);
//		int TBL_DD_num = TBL_Name.getCodeList_HauhunReplace().size();
//		MaxDay md = new MaxDay();
//
//		md.getMAX_DD_SLUSH();
//		for (int i = 0;i<TBL_DD_num;i++){
//
//			md.setMAX_DD_HAIHUN(TBL_Name.getCodeList_HauhunReplace().get(i),s);
//			DTO_B_T_List = new ArrayList<Bean_TBLRecord>();
//			//-を―に置き換えて挿入している。
//			NB.setCodeDD( DTO_B_T_List ,
//					TBL_Name.getCodeList_HauhunReplace().get(i),md.getMAX_DD_HAIHUN());
//			//-を―に置き換えて挿入している。
//			IS.c_InsertStock_DD(NB.getCodeDD(),
//					(TBL_Name.getCodeList_HauhunReplace().get(i)).replace("-","―"),s);
//		}
//		s.closeConection();
//
//		long stop = System.currentTimeMillis();
//		System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
//
//	}
}
