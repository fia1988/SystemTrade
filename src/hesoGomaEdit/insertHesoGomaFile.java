package hesoGomaEdit;

import insertPackage.InsertDay;
import insertPackage.InsertList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;
import accesarrySQL.SEPARATE_CHECK;
import bean.Bean_Bean;
import bean.Bean_CodeList;
import botton.CreateSepaComFile;

import common.commonAP;

import constant.ReCord;
import constant.logWriting;

public class insertHesoGomaFile {

	static int checkCount = 0;

	//true:成功
	//falseなし
	public boolean insertHesoGomaFileController(TAB_MainDTO mainDTO,String filePath,String TODAY,String cate,String TBL,String updateColumn,S s){


		File file =  new File(filePath);
		if (file.isFile()==false){
			//ファイルが存在しない場合は更新しない
			commonAP.writeInLog("下記URLのファイルが存在しません。",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(filePath,logWriting.DATEDATE_LOG_FLG);
			return false;
		}
		List<String> csvStringList = new ArrayList<String>();
		csvStringList = csvToStringList(filePath);

		if (csvStringList.size() == 0 ){
			commonAP.writeInLog("下記URLのファイルのレコード数が0件です。",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(filePath,logWriting.DATEDATE_LOG_FLG);
			return false;
		}

		Bean_Bean B_B = new Bean_Bean();
//		B_B.getList_CSVtoDTO_STOCK_ETF();
//		B_B.setList_CSVtoDTO_INDEX(listCSV, TODAY, skipLine);


		List<String> csvProcessedStringList = new ArrayList<String>();
		for (String record: csvStringList){
			csvProcessedStringList.add(editReplaceHesogomaFile(record,cate));
		}
		B_B.setList_CSVtoDTO(csvProcessedStringList,TODAY,cate);



		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				insertCodeList	(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case ReCord.CODE_HESO_01_STOCK:
				insertStock		(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case ReCord.CODE_HESO_02_INVEST:
				insertInvest	(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				insertFinance	(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case  ReCord.CODE_HESO_04_RATIO:
				insertRatio		(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				insertCredit	(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			default:
				commonAP.writeInLog("insertHesoGomaFileControllerのcateがおかしい:" + cate,logWriting.DATEDATE_LOG_FLG);
				return false;
		}

		commonAP.writeInLog(updateColumn + ":" + TODAY,logWriting.DATEDATE_LOG_FLG);
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
		return true;
	}



	private List<String> csvToStringList(String filePath){
		List<String> csvStringList = new ArrayList<String>();
		File file = new File(filePath);


		String str;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			str = br.readLine();
			while(str != null){
				csvStringList.add(str);
				str = br.readLine();
			}

			br.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			commonAP.writeInErrLog(e);
			commonAP.writeInLog("下記URLのファイルで異常発生！",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(filePath,logWriting.DATEDATE_LOG_FLG);
			csvStringList = new ArrayList<String>();
		}


		return csvStringList;
	}

	private String editReplaceHesogomaFile(String record,String cate){

		String replaceRecord = record;

		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				break;
			case ReCord.CODE_HESO_01_STOCK:
				//変換前が左、変換後が→
				//DTOにするときに-は0になって0の時は前日比が入る
				replaceRecord = replaceRecord.replaceAll("\"-\"","");
				break;
			case ReCord.CODE_HESO_02_INVEST:

				break;
			case  ReCord.CODE_HESO_03_FINANCE:

				break;
			case  ReCord.CODE_HESO_04_RATIO:
				replaceRecord = replaceRecord.replaceAll("\"-\"","");
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				break;
			default:
				break;
		}

		//「"」を削除する処理は共通と思われる
		replaceRecord = replaceRecord.replaceAll("\"","");


		return replaceRecord;
	}

	private void checkCounter(S s){

		if( checkCount%400 == 0){
			checkCount=0;
			s.resetConnection();
		}
	}

	private List<String> getHesoGomaCSV(TAB_MainDTO mainDTO,String filePath){

		List<String> hesogomaFile = new ArrayList<String>();


		return hesogomaFile;
	}

	private void insertCodeList(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){
		InsertList BBB = new InsertList();
		BBB.hesoGomaInsertList_Day(DTO, s);
	}

	private void insertStock(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){
		InsertDay i_d = new InsertDay();
//		i_d.InsertDD_STOCK_ETF(B_B.getList_CSVtoDTO_STOCK_ETF(),MAXDAY, s);
//		i_d.InsertDD_STOCK_ETF(DTO,TODAY, s);

		i_d.hesoGomaInsertDD(DTO, s);

		//分割ファイルの作成/取込を行う。
		CreateSepaComFile sepaComCheck = new CreateSepaComFile();
		sepaComCheck.checkSepaComFile(mainDTO,TODAY);

		//分割チェック。
		s.resetConnection();
		SEPARATE_CHECK.checkSEPARATE_controll(s);
	}

	private void insertInvest(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertFinance(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertRatio(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertCredit(List<Bean_CodeList> DTO,TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}
}
