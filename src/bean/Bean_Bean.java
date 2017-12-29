package bean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.commonAP;

import constant.ReCord;
import constant.logWriting;

public class Bean_Bean {


	private List<Bean_CodeList> B_Cs = new ArrayList<Bean_CodeList>();
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();

	private List<Bean_FinancialStatement> B_F = null;
	private List<Bean_Oneline> B_O = null;
	private List<Bean_TBLRecord> B_T = null;

	private List<String> netFile = new ArrayList<String>();
	private List<List<String>> netFileS = new ArrayList<List <String>>();
	private List<List<List<String>>> netFileSS = new ArrayList<List<List <String>>>();


//	public void setList_CsvStoDTOS_STATISTICA(List<List<String>> CsvS,int skipLine,S s){
//		for(int i=0;i<CsvS.size();i++){
//
//			B_Cs = new ArrayList<Bean_CodeList>();
//
//			setList_CSVtoDTO_STATISTICA(CsvS.get(i),skipLine);
//
//			B_Css.add(getList_CSVtoDTO_STATISTICA());
//
//		}
//
//	}

//	public void setList_CsvStoDTOS_STATISTICA(List<List<String>> CsvS,int skipLine,S s,boolean judge){
//		int p = CsvS.size()-1;
//		InsertDay i_d = new InsertDay();
//		for(int i = p ; i >= 0 ; i--){
//
//
//			B_Cs = new ArrayList<Bean_CodeList>();
//			setList_CSVtoDTO_STATISTICA(CsvS.get(i),skipLine);
//
//			//DTOを入れてインサート開始
//			i_d.InsertDD_STATISTICS(getList_CSVtoDTO_STATISTICA(), s);
//
//			//使用後のDTOは削除する。メモリ節約
//			CsvS.remove(i);
////			B_Css.add(getList_CSVtoDTO_STATISTICA());
//
//		}
//	}

	public List<List<Bean_CodeList>> getList_CsvStoDTOS_STATISTICA(){
		return B_Css;
	}





	public List<List<Bean_CodeList>> getList_CsvStoDTOS_STOCK_INDEX(){
		return B_Css;
	}

	public List<Bean_CodeList> getList_CSVtoDTO(){
		return B_Cs;
	}

	//株の日々データと株一覧以外は仮ファイルを作ってそれをインサートする
	public void setList_CSVtoDTO(List<String> listCSV,String DAY,String cate,String kariFilePath){
		//2015年12月04日 一行目にこんな感じで日付が入っている。
//		String DAY = listCSV.get(0);
		B_Cs = new ArrayList<Bean_CodeList>();



		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				hesoGomaStockList	(listCSV, DAY, 1, cate);
				return;
			case ReCord.CODE_HESO_01_STOCK:
				hesoGomaStock		(listCSV, DAY, 3, cate);
				return;
			case ReCord.CODE_HESO_02_INVEST:
				makingKariFile		(listCSV, DAY, 3, cate,kariFilePath);
				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				makingKariFile		(listCSV, DAY, 1, cate,kariFilePath);
				break;
			case  ReCord.CODE_HESO_04_RATIO:
				makingKariFile		(listCSV, DAY, 1, cate,kariFilePath);
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				makingKariFile		(listCSV, DAY, 1, cate,kariFilePath);
				break;
			default:
				break;
		}


	}

	private void makingKariFile(List<String> listCSV,String DAY,int skipLine,String cate,String kariFilePath){


		File file = new File(kariFilePath);

		if (file.isFile()==true){
			//ファイルが存在する場合は上書き
			//リストの時は黙ってスキップ
			commonAP.writeInLog("makingKariFile：これもう存在します。上書きします。→:" + kariFilePath,logWriting.DATEDATE_LOG_FLG);
	        if(file.delete()){
	        	//成功
	        	commonAP.writeInLog("makingKariFile：これ削除成功。新しく作ります。→:" + kariFilePath,logWriting.DATEDATE_LOG_FLG);
	        }

		}

		try {
			file.createNewFile();
			FileWriter filewriter = new FileWriter(file,true);


			for(int i = skipLine;i<listCSV.size();i++){
				filewriter.write( DAY + "," + listCSV.get(i)  + "\r\n");
			}
			filewriter.close();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			commonAP.writeInErrLog(e1);
			try {
				FileWriter filewriter = new FileWriter(file,true);
			} catch (IOException e) {}
			commonAP.writeInLog("makingKariFile：下記ファイルの作成が失敗しました。",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(kariFilePath,logWriting.DATEDATE_LOG_FLG);
			return;
		}




	}

	private void hesoGomaFinance(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");
		}
		B_C = new Bean_CodeList();
	}

	private void hesoGomaInvest(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");
		}
		B_C = new Bean_CodeList();
	}

	private void hesoGomaStockList(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");


//			System.out.println(listCSV.get(i));

			B_C.setCode			(listCSV_SPRIT[0]);
			B_C.setCodeName		(listCSV_SPRIT[1]);
			B_C.setMarket		(listCSV_SPRIT[2]);
			B_C.setCategory		(listCSV_SPRIT[3]);
			B_C.setOpen			(listCSV_SPRIT[9]);
			B_C.setMax			(listCSV_SPRIT[10]);
			B_C.setMin			(listCSV_SPRIT[11]);
			B_C.setClose		(listCSV_SPRIT[5]);
			B_C.setDeki			(listCSV_SPRIT[12]);
			B_C.setBaybay		(listCSV_SPRIT[13]);
			//へそごまのcateを入れたいがこれしかないのです。
			B_C.setCatelfg(ReCord.CODE_01_STOCK);
			B_Cs.add(B_C);

		}
		B_C = new Bean_CodeList();
	}

	private void hesoGomaRatio(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");
		}
		B_C = new Bean_CodeList();
	}

	private void hesoGomaCredit(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");
		}
		B_C = new Bean_CodeList();
	}

	private void hesoGomaStock(List<String> listCSV,String DAY,int skipLine,String cate){
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");

			B_C.setDay					(DAY);
			B_C.setCode			(listCSV_SPRIT[0]);
			B_C.setCodeName		(listCSV_SPRIT[1]);
			B_C.setMarket		(listCSV_SPRIT[2]);
			B_C.setCategory		(listCSV_SPRIT[3]);
			B_C.setOpen			(listCSV_SPRIT[9]);
			B_C.setMax			(listCSV_SPRIT[10]);
			B_C.setMin			(listCSV_SPRIT[11]);
			B_C.setClose		(listCSV_SPRIT[5]);
			B_C.setDeki			(listCSV_SPRIT[12]);
			B_C.setBaybay		(listCSV_SPRIT[13] + "000");

			switch(listCSV_SPRIT[0]){
			case "0001":
//				日経225（日経平均株価）
				B_C.setCatelfg(ReCord.CODE_04_ETF);
				break;
			case "0002":
//				TOPIX（東証株価指数）
				B_C.setCatelfg(ReCord.CODE_04_ETF);
				break;
			default:
				//へそごまのcateを入れたいがこれしかないのです。
				B_C.setCatelfg(ReCord.CODE_01_STOCK);
				break;
			}


			B_Cs.add(B_C);


		}
		B_C = new Bean_CodeList();
	}

	public void setList_CSVtoDTO_STATISTICA(List<String> listCSV,String DAY,int skipLine){
		//2015年12月04日 一行目にこんな感じで日付が入っている。
//		String DAY = listCSV.get(0);

		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");

//			System.out.println(listCSV.get(i));

			B_C.setDay					(DAY);
			B_C.setCode					(listCSV_SPRIT[0].replace("東証1部_", ""));
			B_C.setCodeName				(listCSV_SPRIT[0]);
			B_C.setDeki					(listCSV_SPRIT[1]);
			B_C.setBaybay				(listCSV_SPRIT[2]);
			B_C.setStockCount			(listCSV_SPRIT[3]);
			B_C.setTakePrice			(listCSV_SPRIT[4]);
			B_C.setUpPrice				(listCSV_SPRIT[5]);
			B_C.setNoChange				(listCSV_SPRIT[6]);
			B_C.setDownPrice			(listCSV_SPRIT[7]);
			B_C.setNoCompare			(listCSV_SPRIT[8]);
			B_C.setCatelfg(ReCord.CODE_02_SATISTICS);
			B_Cs.add(B_C);


		}
		B_C = new Bean_CodeList();
	}

	public List<Bean_CodeList> getList_CSVtoDTO_STATISTICA(){
		return B_Cs;
	}



	public void setList_CSVtoDTO_STOCK_ETF(List<String> listCSV,String DAY,int skipLine){
		//一行目に2015-12-04,全銘柄日足,http://k-db.com/ ←こんな感じではいっているので分割する。
		String[] DAY_SPRIT = listCSV.get(0).split(",");
//		String DAY = DAY_SPRIT[0];
		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();

			String[] listCSV_SPRIT = listCSV.get(i).split(",");
			B_C.setDay			(DAY);

			B_C.setCode			(listCSV_SPRIT[0]);
			B_C.setCodeName		(listCSV_SPRIT[1]);
			B_C.setMarket		(listCSV_SPRIT[2]);
			B_C.setOpen			(listCSV_SPRIT[4]);
			B_C.setMax			(listCSV_SPRIT[5]);
			B_C.setMin			(listCSV_SPRIT[6]);
			B_C.setClose		(listCSV_SPRIT[7]);
			B_C.setDeki			(listCSV_SPRIT[8]);
			B_C.setBaybay		(listCSV_SPRIT[9]);
//			B_C.setMAXMIN		(Double.toString(   Double.parseDouble(B_C.getMax()) - Double.parseDouble(B_C.getMin()))            );
//			B_C.setMAXMINRatio	(Double.toString( ( (Double.parseDouble(B_C.getMax()) - Double.parseDouble(B_C.getMin())) / 100 ) ) );


			switch(listCSV_SPRIT[3]){


			case "指数":
				B_C.setCatelfg(ReCord.CODE_03_INDEX);
				B_C.setCategory(listCSV_SPRIT[3]);

				break;

			case "その他":
				B_C.setCatelfg(ReCord.CODE_04_ETF);
				B_C.setCategory("ETF");
				break;

			case "先物":
				B_C.setCatelfg(ReCord.CODE_05_SAKIMONO);
				B_C.setCategory(listCSV_SPRIT[3]);
				break;

			case "統計":
				B_C.setCatelfg(ReCord.CODE_02_SATISTICS);
				B_C.setCategory(listCSV_SPRIT[3]);
				break;

			default:
				B_C.setCategory(listCSV_SPRIT[3]);
				B_C.setCatelfg(ReCord.CODE_01_STOCK);
			}


			B_Cs.add(B_C);

		}
		B_C = new Bean_CodeList();
	}

	public List<Bean_CodeList> getList_CSVtoDTO_STOCK_ETF(){
		return B_Cs;
	}

	public void setList_CSVtoDTO_INDEX(List<String> listCSV,String DAY,int skipLine){

		Bean_CodeList B_C = new Bean_CodeList();
		for(int i = skipLine;i<listCSV.size();i++){
			B_C = new Bean_CodeList();

			String[] listCSV_SPRIT = listCSV.get(i).split(",");
			B_C.setDay			(DAY);

			B_C.setCode			(listCSV_SPRIT[0]);
			B_C.setCodeName		(listCSV_SPRIT[1]);
			B_C.setCategory		(listCSV_SPRIT[2]);
			B_C.setMarket		("東証");
			B_C.setOpen			(listCSV_SPRIT[4]);
			B_C.setMax			(listCSV_SPRIT[5]);
			B_C.setMin			(listCSV_SPRIT[6]);
			B_C.setClose		(listCSV_SPRIT[7]);
//			B_C.setDeki			(listCSV_SPRIT[8]);
//			B_C.setBaybay		(listCSV_SPRIT[9]);
			B_C.setCatelfg(ReCord.CODE_03_INDEX);
//			B_C.setMAXMIN		(Double.toString(   Double.parseDouble(B_C.getMax()) - Double.parseDouble(B_C.getMin()))            );
//			B_C.setMAXMINRatio	(Double.toString( ( (Double.parseDouble(B_C.getMax()) - Double.parseDouble(B_C.getMin())) / 100 ) ) );


			B_Cs.add(B_C);

		}
		B_C = new Bean_CodeList();
	}

	public List<Bean_CodeList> getList_CSVtoDTO_INDEX(){
		return B_Cs;
	}



	public void setB_C(List<Bean_CodeList> x){
		B_Cs = x;
	}

	public List<Bean_CodeList> getB_C(){
		return B_Cs;
	}

	public void setB_F(List<Bean_FinancialStatement> x){
		B_F = x;
	}

	public List<Bean_FinancialStatement> getB_F(){
		return B_F;
	}

	public void setB_O(List<Bean_Oneline> x){
		B_O = x;
	}

	public List<Bean_Oneline> getB_O(){
		return B_O;
	}

	public void setB_T(List<Bean_TBLRecord> x){
		B_T = x;
	}

	public List<Bean_TBLRecord> getB_T(){
		return B_T;
	}
}
