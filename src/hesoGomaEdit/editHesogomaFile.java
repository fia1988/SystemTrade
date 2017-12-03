package hesoGomaEdit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import netConnect.DownloadController;
import proparty.S;
import proparty.TBL_Name;
import GamenDTO.TAB_MainDTO;

import common.commonAP;

import constant.ReCord;
import constant.ReturnCodeConst;

public class editHesogomaFile {
	//投資情報ファイル
	//2017-06-20_investFile.csv
	private final String INVEST_FILE = "_investFile.csv";
	//財務情報ファイル
	private final String FINANCIAL_FILE = "_financialFile.csv";
	//株の時系列ファイル
	private final String STOCK_DATA_FILE = "_stock_DataFile.csv";
	//信用残高ファイル
	private final String CREDIT_FILE = "_creditFile.csv";
	//保有比率ファイル
	private final String RATIO_FILE = "_ratioFile.csv";
	public int editHesoGomaString(TAB_MainDTO mainDTO,String cate,String lastUpdateDay,String TODAY,S s){

		String URL_parts = "";
		String hesogomaFileName = cate;
		String TBL = TBL_Name.CODELISTTBL;
//		PROPARTY.hesoGomaID;
//		PROPARTY.hesoGomePASS;
		switch (cate){
		case ReCord.CODE_HESO_01_STOCK:
			hesogomaFileName = hesogomaFileName + STOCK_DATA_FILE;
			TBL = TBL_Name.STOCK_DD;
//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices.csv";
			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices";
			break;
		case ReCord.CODE_HESO_02_INVEST:
			hesogomaFileName = hesogomaFileName + INVEST_FILE;
			TBL = TBL_Name.INVEST_SIHYO_DD_TBL;
//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data.csv";
			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data";
			break;
		case  ReCord.CODE_HESO_03_FINANCE:
			hesogomaFileName = hesogomaFileName + FINANCIAL_FILE;
			TBL = TBL_Name.FINANCIAL_MM_TBL;
//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results.csv";
			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results";
			break;
		case  ReCord.CODE_HESO_04_RATIO:
			TBL = TBL_Name.FORRIGN_RATIO_TBL;
			hesogomaFileName = hesogomaFileName + RATIO_FILE;
//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio.csv";
			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio";
			break;
		case  ReCord.CODE_HESO_05_CREDIT:
			TBL = TBL_Name.CREDIT_WW_TBL;
			hesogomaFileName = hesogomaFileName + CREDIT_FILE;
//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-margin-transactions/weekly/japan-all-stock-margin-transactions.csv";
			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-margin-transactions/weekly/japan-all-stock-margin-transactions";
			break;
		default:
			break;
		}

		String hesogomaFilePath = mainDTO.getEveryDayHesoGomaCsvFolderPath() + File.separator + hesogomaFileName;

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;
	}
	//財務データとかを落とす
	//URLで指定したCSVファイルを指定したフォルダに指定した名前でダウンロードする。
	//パスワードが求められるページではない場合、パスワードをスキップする。（オーバーロードでもいいかも）
	//"-"をnullに変える
	//行の先頭に日付を入れる
	private void financialCredit(TAB_MainDTO mainDTO,String TBL,String TODAY,String lastUpDateDay,String URL,String urlID,String urlPASS,String folderPath,String fileName,String cate,S s){
		commonAP cAP = new commonAP();
		DownloadController dCon = new DownloadController();

		insertHesoGomaFile insHego = new insertHesoGomaFile();
		//String"yyyy-mm-dd"できた日付を分割
		String[] lastUpDateDay_SPRIT = lastUpDateDay.split("-");
		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(lastUpDateDay_SPRIT[0]), Integer.parseInt(lastUpDateDay_SPRIT[1]) - 1, Integer.parseInt(lastUpDateDay_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.add(Calendar.DAY_OF_MONTH, +1);
		lastUpDateDay = sdf1.format(calendar.getTime());
		while(cAP.checkDay(TODAY, lastUpDateDay)){
			calendar.add(Calendar.DAY_OF_MONTH, +1);
			String filePath = folderPath + File.separator + lastUpDateDay + fileName + ".csv";
			if ( mainDTO.isHesoGomaOnlineCheck() == false ){
				//ファイルをへそのゴマからダウンロード
				URL = URL + lastUpDateDay + ".csv";
//				try {
//					dCon.getData(URL, urlID, urlPASS);
//				} catch (UnknownHostException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (MalformedURLException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (WebAccessException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
			}
			//ここからインサート
			insHego.insertHesoGomaFileController(mainDTO, filePath, lastUpDateDay, cate);
			lastUpDateDay = sdf1.format(calendar.getTime());

		}
	}



	private String editReplaceHesogomaFile(String record,String cate){

		String replaceRecord = "";

		switch (cate){
		case ReCord.CODE_HESO_01_STOCK:
			//成功時は抜ける
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




}
