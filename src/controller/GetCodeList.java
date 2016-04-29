package controller;
import insertPackage.InsertCodeList;

import java.util.ArrayList;
import java.util.List;

import netConnect.NetBean;
import proparty.S;
import bean.Bean_Bean;
import bean.Bean_CodeList;

public class GetCodeList {

	//
//	//指標、株式、統計の一覧ををCODELISTTBLにぶっこむ。
//	public void controllCreateDB_GetList(){
//		S s = new S();
//
//		s.getCon();
//
//		controllGetList(s);
//
//		s.closeConection();
//	}
//
//
//	private void controllGetList(S s){
//		NetBean NB = new NetBean();
//		InsertList BBB = new InsertList();
//
//
//		//統計指標
//		Bean_Bean bbb = new Bean_Bean();
//		NB.setUrlCsv(Net_Adress.STATISTICS_LIST, 0);
//		bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),2);
//		BBB.InsertList_Day(bbb.getList_CSVtoDTO_STATISTICA(), s);
//		//株と指数
//		bbb = new Bean_Bean();
//		bbb.setList_CSVtoDTO_STOCK_INDEX(NB.getUrlCsv(),2);
//		NB.setUrlCsv(Net_Adress.STOCK_INDEX_LIST, 0);
//		BBB.InsertList_Day(bbb.getList_CSVtoDTO_STOCK_INDEX(), s);
//
//	}




	//個別銘柄の証券コード一覧とETF一覧を取得する。
	public void controllGetStockList(){

		 long start = System.currentTimeMillis();

		 S s = new S();

		 NetBean NB = new  NetBean();

		 //CSVファイルをキャプチャ
		 NB.setUrlCsv("http://k-db.com/?p=all&download=csv", 2);
		 Bean_Bean B_B = new Bean_Bean();
		 //CSVをDTOに変換
		 B_B.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),"a",0);



		//インポート開始！
		 B_B.getList_CSVtoDTO_STOCK_ETF();
		 InsertCodeList ICL = new InsertCodeList();

		 List<Bean_CodeList> DTO_B_C_List = new ArrayList();
		 s.getCon();
		 //CSVをキャプチャ
		 NB.setCodeList_Stock(DTO_B_C_List);
		 //インポート開始！
		 ICL.c_InsertStockList(NB.getCodeList_Stock(),s);
		 s.closeConection();

		 long stop = System.currentTimeMillis();
		 System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");


	}

	//先物のリストを取得する
//	未完成、未検討
	public void controllGetFutureList(){
		 long start = System.currentTimeMillis();

		 NetBean NB = new  NetBean();
		 InsertCodeList ICL = new InsertCodeList();
		 S s = new S();
		 List<Bean_CodeList> DTO_B_C_List = new ArrayList();
		 s.getCon();
		 //CSVをキャプチャ
		 NB.setCodeList_FUTURE(DTO_B_C_List);
		 //インポート開始！
		 ICL.c_InsertStockList(NB.getCodeList_FUTURE(),s);
		 s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");


	}

//	インデックスを取得する
	public void controllGetIndexList(){
		 long start = System.currentTimeMillis();

		 NetBean NB = new  NetBean();
		 InsertCodeList ICL = new InsertCodeList();
		 S s = new S();
		 List<Bean_CodeList> DTO_B_C_List = new ArrayList();
		 s.getCon();
		 //CSVをキャプチャ
		 NB.setCodeList_Index(DTO_B_C_List);
		 //インポート開始！
		 ICL.c_InsertStockList(NB.getCodeList_Index(),s);
		 s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");


	}

//	統計指標のリストを取得する。
	public void controllGetStatisticalList(){
		 long start = System.currentTimeMillis();

		 NetBean NB = new  NetBean();
		 InsertCodeList ICL = new InsertCodeList();
		 S s = new S();
		 List<Bean_CodeList> DTO_B_C_List = new ArrayList();
		 s.getCon();
		 //CSVをキャプチャ
		 NB.setCodeList_Statistical(DTO_B_C_List);
		 //インポート開始！
		 ICL.c_InsertStockList(NB.getCodeList_Statistical(),s);
		 s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");

	}

}


