package botton;

import java.io.File;
import java.sql.SQLException;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import sepacomfilecreate.ParseHtmlStockSplit;
import GamenDTO.TAB_MainDTO;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.logWriting;
import constant.nyuryokuCheckResultConst;

public class CreateSepaComFile {



	public String nyuryokuChecker(TAB_MainDTO mainDTO){


		//タイマーチェック
		//TRUEのときはタイマー起動中なのでオフを返す。
		if(mainDTO.isJudgeTimer()==true){
			return nyuryokuCheckResultConst.ON_TIMER_ERR;
		}

		//MYSQLのアカウントチェック
		S s = new S();
		if ( s.getCon() != ReturnCodeConst.SQL_ERR_0){
			return nyuryokuCheckResultConst.MYSQL_ERR;
		};
		s.closeConection();


		//ログファイルの出力先有無チェック
		File file =  new File(mainDTO.getLogFilePath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR;
		}


		//分割併合ファイルの出力先チェック
		file =  new File(mainDTO.getSepaFolderPath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}


	public String checkSepaComFile(TAB_MainDTO mainDTO,String LS_TODAY){

		commonAP.writeInLog(LS_TODAY + "の分割併合チェック開始",logWriting.DATEDATE_LOG_FLG);
		//分割ファイルを取り込む前に今現在、falseのものを消す！


		String letterSepaCOM = "分割";
		int resultInt = createSepaComFileAndLoad(mainDTO,true,LS_TODAY);
		switch (resultInt) {
			case ParseHtmlStockSplit.NO_UPDATE:
				commonAP.writeInLog(letterSepaCOM + "ファイル更新なし",logWriting.DATEDATE_LOG_FLG);
				break;
			case ParseHtmlStockSplit.NORMAL_END:
				commonAP.writeInLog(letterSepaCOM + "ファイル更新処理成功",logWriting.DATEDATE_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_DATAINCOLLECT:
				commonAP.writeInLog(letterSepaCOM + "ファイルのレイアウトがおかしい",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "ファイルのレイアウトがおかしい",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_IOERROR:
				commonAP.writeInLog(letterSepaCOM + "ファイルをフォルダに書き込めない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "ファイルをフォルダに書き込めない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_NOFOLDEREXIST:
				commonAP.writeInLog(letterSepaCOM + "指定フォルダが存在しない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "指定フォルダが存在しない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_SAMEFILENAME:
				commonAP.writeInLog(letterSepaCOM + "同名ファイルがある",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "同名ファイルがある",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_WEBCONNECT:
				commonAP.writeInLog(letterSepaCOM + "WEBがつながらない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "WEBがつながらない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_OTHER:
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
			default:
				//SQLエラー
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー。たぶんSQL",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー。たぶんSQL",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				break;
		}

		letterSepaCOM = "併合";
		resultInt = createSepaComFileAndLoad(mainDTO,false,LS_TODAY);
		switch (resultInt) {
			case ParseHtmlStockSplit.NO_UPDATE:
				commonAP.writeInLog(letterSepaCOM + "ファイル更新なし",logWriting.DATEDATE_LOG_FLG);
				break;
			case ParseHtmlStockSplit.NORMAL_END:
				commonAP.writeInLog(letterSepaCOM + "ファイル更新処理成功",logWriting.DATEDATE_LOG_FLG);
				break;
			case ParseHtmlStockSplit.ERROR_DATAINCOLLECT:
				commonAP.writeInLog(letterSepaCOM + "ファイルのレイアウトがおかしい",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "ファイルのレイアウトがおかしい",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			case ParseHtmlStockSplit.ERROR_IOERROR:
				commonAP.writeInLog(letterSepaCOM + "ファイルをフォルダに書き込めない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "ファイルをフォルダに書き込めない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			case ParseHtmlStockSplit.ERROR_NOFOLDEREXIST:
				commonAP.writeInLog(letterSepaCOM + "指定フォルダが存在しない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "指定フォルダが存在しない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			case ParseHtmlStockSplit.ERROR_SAMEFILENAME:
				commonAP.writeInLog(letterSepaCOM + "同名ファイルがある",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "同名ファイルがある",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			case ParseHtmlStockSplit.ERROR_WEBCONNECT:
				commonAP.writeInLog(letterSepaCOM + "WEBがつながらない",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "WEBがつながらない",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			case ParseHtmlStockSplit.ERROR_OTHER:
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
			default:
				//SQLエラー
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー。たぶんSQL",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letterSepaCOM + "原因不明エラー。たぶんSQL",logWriting.CODE_SEPACON_ERR_LOG_FLG);
				return nyuryokuCheckResultConst.FAILED;
		}

//		return nyuryokuCheckResultConst.FAILED;
		return nyuryokuCheckResultConst.SUCCESS;
	}

	//true:分割
	//false:併合
	private int deleteOldFalse(boolean judge , S s ){

		String letter;
		String judgeStr;
		if (judge){
			letter = "分割";
			judgeStr = "true";
		}else{
			letter = "併合";
			judgeStr = "false";
		}



		String SQL = "delete from " + TBL_Name.SEPARATE_DD
					+ " where "
					+ COLUMN_TBL.SEPA_FLG + " is false "
					+ " and "
					+ COLUMN_TBL.CHECKSEPA_COMBINE + " is " + judgeStr;

		int deleteRecord = 0;
		try {
			commonAP.writeInLog(letter + "のsepa_flg is falseを削除します。",logWriting.DATEDATE_LOG_FLG);
			deleteRecord = s.sqlGetter().executeUpdate(SQL);
			commonAP.writeInLog(letter + "を" + deleteRecord + "件削除しました。",logWriting.DATEDATE_LOG_FLG);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			//エラー
			return 0;
		}finally{

		}

		return deleteRecord;
//		return 0;
	}



	//true:分割
	//false:併合
	private int createSepaComFileAndLoad(TAB_MainDTO mainDTO,boolean checkFLG,String LS_TODAY){
		String checkDay;
		String toDay = controllDay.getTODAY();
		String letter = "";

		S s = new S();
		s.getCon();

		if ( checkFLG ){
			checkDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_SEPA_CHECK, s);
			letter = "分割";
		}else{
			checkDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_COMBINE_CHECK, s);
			letter = "併合";
		}

//		//-3
//		System.out.println("2016-02-15".compareTo("2016-02-18"));
//		//-2
//		System.out.println("2016-02-15".compareTo("2016-02-17"));
		//直近一週間で更新がない場合は処理終わり

		//trueのときは処理終了
		if (commonAP.checkSabunDay(toDay,checkDay,PROPARTY.SEPA_COM_KANKAKU)){
			s.closeConection();
			return ParseHtmlStockSplit.NO_UPDATE;
		}

		String fileName;
		int checkResult;
		ParseHtmlStockSplit phs = new ParseHtmlStockSplit();

		if ( checkFLG ){
			fileName = "01_separate_" + LS_TODAY + ".csv";
			checkResult = ( phs.makeSplitCsv(mainDTO.getSepaFolderPath(), fileName	));
		}else{
			fileName = "02_combine_" + LS_TODAY + ".csv";
			checkResult = ( phs.makeMergeCsv(mainDTO.getSepaFolderPath(), fileName	));
		}

		if ( checkResult == ParseHtmlStockSplit.NORMAL_END ){
			if ( checkFLG ){
				controllDay.update_KOSHINBI(LS_TODAY, ReCord.KOSHINBI_SEPA_CHECK, s);
			}else{
				controllDay.update_KOSHINBI(LS_TODAY, ReCord.KOSHINBI_COMBINE_CHECK, s);
			}
		}else{
			phs = new ParseHtmlStockSplit();
			s.closeConection();
			return checkResult;
		}

		String filePath = mainDTO.getSepaFolderPath().replace(File.separator,ReturnCodeConst.SQL_SEPA) + ReturnCodeConst.SQL_SEPA + fileName;
		String SQL1 = "LOAD DATA INFILE \"" + filePath + "\" ignore INTO TABLE " + TBL_Name.SEPARATE_DD + " FIELDS TERMINATED BY ','";

		//2007-01-04以降しかDBには入っていないため、それ以前のものはsepa_flg is falseをtrueにする
		String SQL2 = "update " + TBL_Name.SEPARATE_DD
					+ " set "
					+ COLUMN_TBL.SEPA_FLG + " = true "
					+ " where "
					+ COLUMN_TBL.SEPA_FLG + " is false "
					+ " and "
					+ COLUMN_TBL.EFFECT_STARTDAY + " < '2007-01-01'";
//		System.out.println("createSepaComFileAndLoad:" + checkFLG + ":" + LS_TODAY);
		//取り込む前に削除する
		deleteOldFalse(checkFLG,s);

		commonAP.writeInLog("createSepaComFileAndLoad:"+SQL1,logWriting.DATEDATE_LOG_FLG);

		//自動取込がONの場合、取り込みを行う。
		if(mainDTO.isSepaComFileAutoCaptureFLG()){
			commonAP.writeInLog(letter + "取込開始",logWriting.DATEDATE_LOG_FLG);
			try {
				int addRecord = s.sqlGetter().executeUpdate(SQL1);
				commonAP.writeInLog(letter+"を"+addRecord + "件追加しました。",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(letter + "ファイル取込成功",logWriting.DATEDATE_LOG_FLG);
				s.freeUpdateQuery(SQL2);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				s.closeConection();
				commonAP.writeInLog("createSepaComFileAndLoadの「" + letter + "」でエラー",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("利用したSQLは以下",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("■SQL1：" + SQL1,logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("■SQL2：" + SQL2,logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("--------createSepaComFileAndLoadの「" + letter + "」でエラーメッセージここから--------",logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInErrLog(e);
				commonAP.writeInLog("--------createSepaComFileAndLoadの「" + letter + "」でエラーメッセージここまで--------",logWriting.DATEDATE_LOG_FLG);
				return e.getErrorCode();
			}
		}


		phs = new ParseHtmlStockSplit();
		s.closeConection();
		return ParseHtmlStockSplit.NORMAL_END;
	}
}
