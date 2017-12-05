package hesoGomaEdit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;
import bean.Bean_Bean;

import common.commonAP;

import constant.ReCord;
import constant.logWriting;

public class insertHesoGomaFile {

	static int checkCount = 0;


	public void insertHesoGomaFileController(TAB_MainDTO mainDTO,String filePath,String TODAY,String cate,String TBL,S s){

		String updateColumn = "";

		File file =  new File(filePath);
		if (file.isFile()==false){
			//ファイルが存在しない場合は更新しない
			return;
		}
		List<String> csvStringList = new ArrayList<String>();
		csvStringList = csvToStringList(filePath);

		if (csvStringList.size() == 0 ){
			commonAP.writeInLog("下記URLのファイルが存在しません。",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(filePath,logWriting.DATEDATE_LOG_FLG);
			return;
		}

		Bean_Bean B_B = new Bean_Bean();
		B_B.getList_CSVtoDTO_STOCK_ETF();
//		B_B.setList_CSVtoDTO_INDEX(listCSV, TODAY, skipLine);
		for (String record: csvStringList){

		}
		switch (cate){
		case ReCord.CODE_HESO_01_STOCK:
			updateColumn = ReCord.KOSHINBI_STOCK_ETF;
			insertStock(mainDTO,filePath,TODAY,updateColumn,TBL,s);
			break;
		case ReCord.CODE_HESO_02_INVEST:
			updateColumn = ReCord.KOSHINBI_INVEST;
			insertInvest(mainDTO,filePath,TODAY,updateColumn,TBL,s);
			break;
		case  ReCord.CODE_HESO_03_FINANCE:
			updateColumn = ReCord.KOSHINBI_FINANCIAL;
			insertFinance(mainDTO,filePath,TODAY,updateColumn,TBL,s);
			break;
		case  ReCord.CODE_HESO_04_RATIO:
			updateColumn = ReCord.KOSHINBI_FORRIGN_RATIO;
			insertRatio(mainDTO,filePath,TODAY,updateColumn,TBL,s);
			break;
		case  ReCord.CODE_HESO_05_CREDIT:
			updateColumn = ReCord.KOSHINBI_CREDIT;
			insertCredit(mainDTO,filePath,TODAY,updateColumn,TBL,s);
			break;
		default:
			break;
		}

		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}


	private void testCase00(){
		List<String> csvStringList = new ArrayList<String>();
		csvStringList = csvToStringList("C:\\Users\\NOBORU1988\\Dropbox\\01.kabu\\03.sepaFile\\00_00_sepaComKakodata.csv");
		for (String record: csvStringList){
			System.out.println(record);
		}
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
		case ReCord.CODE_HESO_01_STOCK:
			break;
		case ReCord.CODE_HESO_02_INVEST:
			break;
		case  ReCord.CODE_HESO_03_FINANCE:
			break;
		case  ReCord.CODE_HESO_04_RATIO:
			break;
		case  ReCord.CODE_HESO_05_CREDIT:
			break;
		default:
			break;
		}


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

	private void insertStock(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertInvest(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertFinance(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertRatio(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}

	private void insertCredit(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,S s){

	}
}
