package hesoGomaEdit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;
import constant.ReCord;

public class insertHesoGomaFile {


	public void insertHesoGomaFileController(TAB_MainDTO mainDTO,String filePath,String TODAY,String cate){
		S s = new S();
		s.getCon();
		String updateColumn = "";

		File file =  new File(filePath);
		if (file.isFile()==false){
			//ファイルが存在しない場合は更新しない
			return;
		}

		switch (cate){
		case ReCord.CODE_HESO_01_STOCK:
			updateColumn = ReCord.KOSHINBI_STOCK_ETF;
			insertStock(mainDTO,filePath,TODAY,updateColumn,s);
			break;
		case ReCord.CODE_HESO_02_INVEST:
			updateColumn = ReCord.KOSHINBI_INVEST;
			insertInvest(mainDTO,filePath,TODAY,updateColumn,s);
			break;
		case  ReCord.CODE_HESO_03_FINANCE:
			updateColumn = ReCord.KOSHINBI_FINANCIAL;
			insertFinance(mainDTO,filePath,TODAY,updateColumn,s);
			break;
		case  ReCord.CODE_HESO_04_RATIO:
			updateColumn = ReCord.KOSHINBI_FORRIGN_RATIO;
			insertRatio(mainDTO,filePath,TODAY,updateColumn,s);
			break;
		case  ReCord.CODE_HESO_05_CREDIT:
			updateColumn = ReCord.KOSHINBI_CREDIT;
			insertCredit(mainDTO,filePath,TODAY,updateColumn,s);
			break;
		default:
			break;
		}

		s.closeConection();
	}


	private List<String> getHesoGomaCSV(TAB_MainDTO mainDTO,String filePath){

		List<String> hesogomaFile = new ArrayList<String>();


		return hesogomaFile;
	}

	private void insertStock(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,S s){
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}

	private void insertInvest(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,S s){
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}

	private void insertFinance(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,S s){
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}

	private void insertRatio(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,S s){
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}

	private void insertCredit(TAB_MainDTO mainDTO,String filePath,String TODAY,String updateColumn,S s){
		controllDay.update_KOSHINBI(TODAY,updateColumn, s);
	}
}
