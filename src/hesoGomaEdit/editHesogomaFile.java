package hesoGomaEdit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import netConnect.DownloadController;
import netConnect.WebAccessException;
import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;

import common.commonAP;

import constant.ReCord;
import constant.ReturnCodeConst;
import constant.logWriting;

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
	public int editHesoGomaString(TAB_MainDTO mainDTO,String cate,String lastUpDateDay,String TODAY,S s){

		String URL_parts = "";
		String hesogomaFileName = "";
		String TBL = TBL_Name.CODELISTTBL;
		String updateColumn = "";
		switch (cate){
			case ReCord.CODE_HESO_00_CODE_LIST:
				hesogomaFileName = hesogomaFileName + STOCK_DATA_FILE;
				TBL = TBL_Name.CODELISTTBL;
				updateColumn = ReCord.KOSHINBI_STOCK_LIST;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices_";
				break;
			case ReCord.CODE_HESO_01_STOCK:
				hesogomaFileName = hesogomaFileName + STOCK_DATA_FILE;
				TBL = TBL_Name.STOCK_DD;
				updateColumn = ReCord.KOSHINBI_STOCK_ETF;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-prices/daily/japan-all-stock-prices_";
				break;
			case ReCord.CODE_HESO_02_INVEST:
				hesogomaFileName = hesogomaFileName + INVEST_FILE;
				TBL = TBL_Name.INVEST_SIHYO_DD_TBL;
				updateColumn = ReCord.KOSHINBI_INVEST;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-data/daily/japan-all-stock-data_";


				break;
			case  ReCord.CODE_HESO_03_FINANCE:
				hesogomaFileName = hesogomaFileName + FINANCIAL_FILE;
				TBL = TBL_Name.FINANCIAL_MM_TBL;
				updateColumn = ReCord.KOSHINBI_FINANCIAL;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-financial-results/monthly/japan-all-stock-financial-results_";
				break;
			case  ReCord.CODE_HESO_04_RATIO:
				TBL = TBL_Name.FORRIGN_RATIO_TBL;
				hesogomaFileName = hesogomaFileName + RATIO_FILE;
				updateColumn = ReCord.KOSHINBI_FORRIGN_RATIO;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-information/monthly/shareholding-ratio_";
				break;
			case  ReCord.CODE_HESO_05_CREDIT:
				TBL = TBL_Name.CREDIT_WW_TBL;
				hesogomaFileName = hesogomaFileName + CREDIT_FILE;
				updateColumn = ReCord.KOSHINBI_CREDIT;
	//			URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-margin-transactions/weekly/japan-all-stock-margin-transactions.csv";
				URL_parts = "https://hesonogoma.com/stocks/download/csv/japan-all-stock-margin-transactions/weekly/japan-all-stock-margin-transactions_";
				break;
			default:
				break;
		}

//		String hesogomaFilePath = mainDTO.getEveryDayHesoGomaCsvFolderPath() + File.separator + hesogomaFileName;



		return hesoGomaFileInsertFIAS(mainDTO, TBL, TODAY, lastUpDateDay, URL_parts, PROPARTY.hesoGomaID, PROPARTY.hesoGomePASS, mainDTO.getEveryDayHesoGomaCsvFolderPath(), hesogomaFileName, cate,updateColumn, s);
	}
	//財務データとかを落とす
	//URLで指定したCSVファイルを指定したフォルダに指定した名前でダウンロードする。
	//パスワードが求められるページではない場合、パスワードをスキップする。（オーバーロードでもいいかも）
	//"-"をnullに変える
	//行の先頭に日付を入れる
	private int hesoGomaFileInsertFIAS(TAB_MainDTO mainDTO,String TBL,String TODAY,String lastUpDateDay,String URL_parts,String urlID,String urlPASS,String folderPath,String fileName,String cate,String updateColumn,S s){
		commonAP cAP = new commonAP();
		DownloadController dCon = new DownloadController();

		boolean resultInsertExit = false;

		//String"yyyy-mm-dd"できた日付を分割
		String[] lastUpDateDay_SPRIT = lastUpDateDay.split("-");
		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(lastUpDateDay_SPRIT[0]), Integer.parseInt(lastUpDateDay_SPRIT[1]) - 1, Integer.parseInt(lastUpDateDay_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		boolean insertChecker = false;
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		lastUpDateDay = sdf1.format(calendar.getTime());
		int upCounter = 0;
		String downURL;
		while(cAP.checkDay(TODAY, lastUpDateDay)){

			insertChecker = false;

			String filePath = folderPath + File.separator + lastUpDateDay + fileName ;
			File file =  new File(filePath);

			if ( mainDTO.isHesoGomaOnlineCheck() == false ){

				if (file.isFile()==false){
					//ファイルが存在する場合はネットからダウンロードしない
					//ファイルが存在しない場合はこの中を通る。ダウンロード開始
					//ファイルをへそのゴマからダウンロード
					String downDay = lastUpDateDay.replaceAll("-", "");
					downURL = URL_parts + downDay + ".csv";

					try {
						List<String> csvStringList = new ArrayList<String>();
						csvStringList = dCon.getData(downURL, urlID, urlPASS);
						insertChecker = true;
						writtingString(csvStringList,filePath,cate);
					} catch (UnknownHostException e) {
						// TODO 自動生成された catch ブロック
						commonAP.writeInLog("以下のURLは存在しません",logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInLog(downURL,logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInErrLog(e);
						return ReturnCodeConst.EVERY_UPDATE_ERR;

					} catch (MalformedURLException e) {
						// TODO 自動生成された catch ブロック
						commonAP.writeInLog("以下のURLは正規のURLがありません。いい加減な文字を打つな",logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInLog(downURL,logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInErrLog(e);
						return ReturnCodeConst.EVERY_UPDATE_ERR;
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						commonAP.writeInLog("以下のURLで文字列のエラー発生！もしくは接続失敗。",logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInLog(downURL,logWriting.DATEDATE_LOG_FLG);
						commonAP.writeInErrLog(e);
						return ReturnCodeConst.EVERY_UPDATE_ERR;

					} catch (WebAccessException e) {
						// TODO 自動生成された catch ブロック

						if ( e.getCode() != 404) {
							commonAP.writeInLog("以下のURLで「" + e.getCode() + "」発生！",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInLog(downURL,logWriting.DATEDATE_LOG_FLG);
						}

						switch (e.getCode()) {
						case 401:
							commonAP.writeInLog("認証失敗。ID：" + urlID + "とパスワード：" + urlPASS + "が違います。",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						case 403:
							//禁止されてるパターン
							//へそのごまでは出てこない。
							commonAP.writeInLog("403が出ています。上記のURLへのアクセスが拒否されています。",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						case 404:
							//ファイルがないパターン
							break;
						case 502:
							commonAP.writeInLog("上記のURLのプロキシとかゲートウェイ辺りに問題あり。",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						case 503:
							commonAP.writeInLog("上記のURLのサーバーが死んでいます。しばらくたってからアクセスしてください。",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						case 504:
							commonAP.writeInLog("タイムアウトしました。処理を止めます。",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						default:
							commonAP.writeInLog("理由がさっぱりわからんエラー",logWriting.DATEDATE_LOG_FLG);
							commonAP.writeInErrLog(e);
							return ReturnCodeConst.EVERY_UPDATE_ERR;
						}
					}
				}

			}else{
				insertChecker = true;
			}

			if (insertChecker == true){
				//ここからインサート
				insertHesoGomaFile insHego = new insertHesoGomaFile();
				insHego.insertHesoGomaFileController(mainDTO, filePath, lastUpDateDay, cate,TBL,updateColumn,s);
				s.resetConnection();
				resultInsertExit = true;
			}

			upCounter++;
			calendar.add(Calendar.DAY_OF_MONTH, +1);
			lastUpDateDay = sdf1.format(calendar.getTime());

		}


		if (resultInsertExit){
			return ReturnCodeConst.EVERY_UPDATE_SUCSESS;
		}else{

			if (upCounter>6){
				commonAP.writeInLog(updateColumn + ":" + TODAY,logWriting.DATEDATE_LOG_FLG);
				String updateDay = controllDay.getTODAYnoYesterDay(TODAY);
				commonAP.writeInLog(updateColumn + ":" + updateDay,logWriting.DATEDATE_LOG_FLG);
				controllDay.update_KOSHINBI(updateDay,updateColumn, s);
			}
			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
		}


	}


	private void writtingString(List<String> csvStringList , String filePath,String cate){
		commonAP.writeInLog("下記ファイルを作成します。",logWriting.DATEDATE_LOG_FLG);
		commonAP.writeInLog("作成場所:" + filePath,logWriting.DATEDATE_LOG_FLG);


		File file = new File(filePath);

		if (file.isFile()==true){
			//ファイルが存在する場合は何もしない。
			//リストの時は黙ってスキップ
			switch (cate) {
				case ReCord.CODE_HESO_00_CODE_LIST:
					break;
				default:
					commonAP.writeInLog("これもう存在します。スキップします。→:" + filePath,logWriting.DATEDATE_LOG_FLG);
					break;
			}
			return;
		}

		try {
			file.createNewFile();
			FileWriter filewriter = new FileWriter(file,true);
			for (String writing: csvStringList){
//				  System.out.println(writing);
				  filewriter.write( writing  + "\r\n");
			}

			filewriter.close();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			commonAP.writeInErrLog(e1);
			try {
				FileWriter filewriter = new FileWriter(file,true);
			} catch (IOException e) {}
			commonAP.writeInLog("上記ファイルの作成が失敗しました。",logWriting.DATEDATE_LOG_FLG);
			return;
		}

		commonAP.writeInLog("上記ファイルの作成が成功しました。",logWriting.DATEDATE_LOG_FLG);
	}






}
