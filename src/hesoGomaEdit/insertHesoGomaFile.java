package hesoGomaEdit;

import insertPackage.InsertDay;
import insertPackage.InsertList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
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

import constant.COLUMN;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.logWriting;

public class insertHesoGomaFile {

	static int checkCount = 0;

	//true:成功
	//falseなし
	public boolean insertHesoGomaFileController(TAB_MainDTO mainDTO,String filePath,String TODAY,String lastUpDateDay,String cate,String TBL,String updateColumn,String updateCheckPointColumn,S s){


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

		String kariFilePath = filePath + "_kari_" + TODAY + ".csv";

		B_B.setList_CSVtoDTO(csvProcessedStringList,TODAY,cate,kariFilePath);



		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				insertCodeList	(B_B.getList_CSVtoDTO(),mainDTO,filePath,TODAY,updateColumn,TBL,s);
				break;
			case ReCord.CODE_HESO_01_STOCK:
//				insertKariFileToTBLandKariFileDelete	(mainDTO,filePath,TODAY,updateColumn,TBL,kariFilePath,cate,s);
				insertStock(B_B.getList_CSVtoDTO(), mainDTO, kariFilePath, TODAY, updateColumn, TBL, s);
				break;
			case ReCord.CODE_HESO_02_INVEST:
				insertKariFileToTBLandKariFileDelete	(mainDTO,filePath,TODAY,updateColumn,TBL,kariFilePath,cate,s);
				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				insertKariFileToTBLandKariFileDelete	(mainDTO,filePath,TODAY,updateColumn,TBL,kariFilePath,cate,s);
				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			case  ReCord.CODE_HESO_04_RATIO:
				insertKariFileToTBLandKariFileDelete	(mainDTO,filePath,TODAY,updateColumn,TBL,kariFilePath,cate,s);
				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				insertKariFileToTBLandKariFileDelete	(mainDTO,filePath,TODAY,updateColumn,TBL,kariFilePath,cate,s);
				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			case  ReCord.CODE_HESO_06_REIT:
//				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			case  ReCord.CODE_HESO_07_ETF:
//				updateZenzituhi(TBL,cate,TODAY,lastUpDateDay,s);
				break;
			default:
				commonAP.writeInLog("insertHesoGomaFileControllerのcateがおかしい:" + cate,logWriting.DATEDATE_LOG_FLG);
				return false;
		}

		commonAP.writeInLog(updateColumn + ":" + TODAY,logWriting.DATEDATE_LOG_FLG);
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
//		commonAP.writeInLog(updateCheckPointColumn + ":" + TODAY,logWriting.DATEDATE_LOG_FLG);
		controllDay.update_KOSHINBI(TODAY,updateCheckPointColumn, s);
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
				//DTOにするときに"-"は"0"になって"0"の時は前日比が入る
				replaceRecord = replaceRecord.replaceAll("\"-\"","");
				break;
			case ReCord.CODE_HESO_02_INVEST:
				//"-"を"\N"にする
				replaceRecord = replaceRecord.replaceAll("\"-\"","\\\\N");
				replaceRecord = replaceRecord.replaceAll("/","-");
				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				replaceRecord = replaceRecord.replaceAll("\"-\"","\\\\N");
				replaceRecord = replaceRecord.replaceAll("/","-");
				break;
			case  ReCord.CODE_HESO_04_RATIO:
				replaceRecord = replaceRecord.replaceAll("\"-\"","\\\\N");
				replaceRecord = replaceRecord.replaceAll("%","");
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				replaceRecord = replaceRecord.replaceAll("\"-\"","\\\\N");
				replaceRecord = replaceRecord.replaceAll("\\+","");
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

	private void insertKariFileToTBLandKariFileDelete(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,String TBL,String kariFilePath,String cate,S s){

		String SQL = "LOAD DATA INFILE \"" + kariFilePath + "\" ignore INTO TABLE " + TBL + " FIELDS TERMINATED BY ','";

		SQL = SQL.replace(File.separator,ReturnCodeConst.SQL_SEPA);

		try {
			s.sqlGetter().executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			commonAP.writeInLog("insertKariFileToTBLandKariFileDelete",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("SQL：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
			s.resetConnection();
		}



//		//仮ファイルを削除
        File file = new File(kariFilePath);
        if(file.delete()){
        	//成功

        }else{
        	//失敗
        }

	}

	private void updateZenzituhi(String TBL,String cate,String TODAY,String lastUpdateDay,S s){


		String updateColumn = "";

		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				//これはやらん
				return;
			case ReCord.CODE_HESO_01_STOCK:
				//これはやらん
				return;
			case ReCord.CODE_HESO_02_INVEST:
				updateColumn = " "
					+ "b." + COLUMN.MARKET_CAP_PPT_PRE				 + " = "+ "a." + COLUMN.MARKET_CAP_PPT			 + " , "
					+ "b." + COLUMN.STOCK_NUM_PRE					 + " = "+ "a." + COLUMN.STOCK_NUM				 + " , "
					+ "b." + COLUMN.DIVIDEND_PER_PRE 				 + " = "+ "a." + COLUMN.DIVIDEND_PER 			 + " , "
					+ "b." + COLUMN.DIVIDEND_PRE  					 + " = "+ "a." + COLUMN.DIVIDEND  				 + " , "
					+ "b." + COLUMN.PER_YOSO_PRE  					 + " = "+ "a." + COLUMN.PER_YOSO  				 + " , "
					+ "b." + COLUMN.PBR_REAL_PRE  					 + " = "+ "a." + COLUMN.PBR_REAL  				 + " , "
					+ "b." + COLUMN.EPS_YOSO_PRE 					 + " = "+ "a." + COLUMN.EPS_YOSO 				 + " , "
					+ "b." + COLUMN.BPS_REAL_PRE 					 + " = "+ "a." + COLUMN.BPS_REAL 				 + " , "
					+ "b." + COLUMN.YEAR_MAX_DAY_YYYYMMDD_PRE 		 + " = "+ "a." + COLUMN.YEAR_MAX_DAY_YYYYMMDD 	 + " , "
					+ "b." + COLUMN.YEAR_MAX_PRE 					 + " = "+ "a." + COLUMN.YEAR_MAX 				 + " , "
					+ "b." + COLUMN.YEAR_MIN_DAY_YYYYMMDD_PRE 		 + " = "+ "a." + COLUMN.YEAR_MIN_DAY_YYYYMMDD 	 + " , "
					+ "b." + COLUMN.YEAR_MIN_PRE 					 + " = "+ "a." + COLUMN.YEAR_MIN 				 + "   ";
				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				//これはやらん
				return;
			case  ReCord.CODE_HESO_04_RATIO:
				updateColumn = " "
					+ "b." + COLUMN.ANOTHER_STOCK_HOLDER_RATIO_PRE		 + " = "+ "a." + COLUMN.ANOTHER_STOCK_HOLDER_RATIO		 + " , "
					+ "b." + COLUMN.MAJOR_STOCK_HOLDER_RATIO_PRE		 + " = "+ "a." + COLUMN.MAJOR_STOCK_HOLDER_RATIO		 + " , "
					+ "b." + COLUMN.ETF_STOCK_HOLDER_RATIO_PRE			 + " = "+ "a." + COLUMN.ETF_STOCK_HOLDER_RATIO			 + " , "
					+ "b." + COLUMN.FOREIGNER_STOCK_HOLDER_RATIO_PRE	 + " = "+ "a." + COLUMN.FOREIGNER_STOCK_HOLDER_RATIO	 + "   " ;
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				updateColumn = " "
					+ "b." + COLUMN.CREDIT_LONG_PRE					 + " = " + "a." + COLUMN.CREDIT_LONG				 + " , "
					+ "b." + COLUMN.CREDIT_LONG_CHANGERATE_W_PRE	 + " = " + "a." + COLUMN.CREDIT_LONG_CHANGERATE_W	 + " , "
					+ "b." + COLUMN.CREDIT_SHORT_PRE				 + " = " + "a." + COLUMN.CREDIT_SHORT				 + " , "
					+ "b." + COLUMN.CREDIT_SHORT_CHANGERATE_W_PRE	 + " = " + "a." + COLUMN.CREDIT_SHORT_CHANGERATE_W	 + " , "
					+ "b." + COLUMN.CREDIT_RATIO_PRE				 + " = " + "a." + COLUMN.CREDIT_RATIO				 + "  " ;

				break;
			default:
				commonAP.writeInLog("updateZenzituhiのcateがおかしい:" + cate,logWriting.DATEDATE_LOG_FLG);
			return ;
		}


//		update 23_invest_sihyo_tbl_dd b
//		left join 23_invest_sihyo_tbl_dd a
//		on
//		a.code = b.code
//		set b.market_cap_ppt_pre = a.market_cap_ppt
//		where b.daytime = '2017-01-02'
//		and
//		a.daytime = '2017-01-01' ;

		String SQL = " update " + TBL + " b "
					+ " left join " + TBL + " a "
					+ " on "
					+ " a." + COLUMN.CODE + " = " + " b." + COLUMN.CODE
					+ " set "
					+ updateColumn
					+ " where "
					+ "b." + COLUMN.DAYTIME + " = '" + TODAY + "' "
					+ " and "
					+ "a." + COLUMN.DAYTIME + " = '" + lastUpdateDay + "' ";


		try {
			s.sqlGetter().executeUpdate(SQL);
			commonAP.writeInLog("updateZenzituhiのSQLで成功",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("SQL：" + SQL,logWriting.DATEDATE_LOG_FLG);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			commonAP.writeInLog("updateZenzituhiのSQLで【失敗】",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("SQL：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
			s.resetConnection();
		}

	}

}
