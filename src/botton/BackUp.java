package botton;

import java.io.File;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;

import common.commonAP;

import constant.ReCord;
import constant.ReturnCodeConst;
import constant.logWriting;
import constant.nyuryokuCheckResultConst;

public class BackUp {
	public String nyuryokuCheckerIn(TAB_MainDTO mainDTO){


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

		//バックアップファイルの有無チェック
		File file =  new File(mainDTO.getInBackUpFilePath());
		if (file.isFile()==false){
		    return nyuryokuCheckResultConst.NO_FILE_ERR;
		}

		//ログファイルの出力先有無チェック
		file =  new File(mainDTO.getLogFilePath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}


	public String nyuryokuCheckerOut(TAB_MainDTO mainDTO){


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

		//バックアップファイルの出力先有無チェック
		File file =  new File(mainDTO.getOutBackUpFolderPath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_FOLDER_ERR;
		}

		//ログファイルの出力先有無チェック
		file =  new File(mainDTO.getLogFilePath());
		if (file.isDirectory()==false){
			return nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR;
		}

//		s = new S();
//		s.getCon();
//		String TODAY = controllDay.getMAX_DD_STOCK_ETF(s);
		String TODAY = controllDay.getTODAY();
//		s.closeConection();
		//バックアップファイルの出力先にバックアップファイルが存在するかどうかのチェック
		mainDTO.setOutBackUpFilePath(mainDTO.getOutBackUpFolderPath() + File.separator + TODAY + ".dump");
		file =  new File(mainDTO.getOutBackUpFilePath());
		if (file.isFile()==true){
		    return nyuryokuCheckResultConst.EXACT_BACK_UP_FILE_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}



	public String optimizeDB(TAB_MainDTO mainDTO){

		String executeCmd = "cmd /c mysqlcheck -o -u " + mainDTO.getMysqlID() + " -p" + mainDTO.getMysqlPass() + " " + TBL_Name.KABU_DB ;
		commonAP.writeInLog("最適化開始",logWriting.DATEDATE_LOG_FLG);
		Process runtimeProcess;
		try {
		    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		    int processComplete = runtimeProcess.waitFor();
		    if (processComplete == 0) {
		    	commonAP.writeInLog("最適化成功",logWriting.DATEDATE_LOG_FLG);
		    	return nyuryokuCheckResultConst.SUCCESS;
		    } else {
		    	commonAP.writeInLog("最適化失敗：エラータイプ：" + processComplete,logWriting.DATEDATE_LOG_FLG);
		    	return nyuryokuCheckResultConst.FAILED + ":" + processComplete;
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    commonAP.writeInLog("最適化失敗：原因不明",logWriting.DATEDATE_LOG_FLG);
		    return nyuryokuCheckResultConst.FAILED + ":" + "原因不明のエラー";
		}

	}

	//バックアップ出力
	public String backUpOut(TAB_MainDTO mainDTO){



		String executeCmd = "cmd /c mysqldump --single-transaction -u " + mainDTO.getMysqlID() + " -p" + mainDTO.getMysqlPass() + " " + TBL_Name.KABU_DB + "  >  " + mainDTO.getOutBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		executeCmd = executeCmd.replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		mysqldump --single-transaction -u root -p kabudata > D:/orderList/a.dump
//
		Process runtimeProcess;

		commonAP.writeInLog("バックアップ開始：" + mainDTO.getOutBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA),logWriting.DATEDATE_LOG_FLG);

		try {
		    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		    int processComplete = runtimeProcess.waitFor();
		    if (processComplete == 0) {
		    	commonAP.writeInLog("バックアップ成功",logWriting.DATEDATE_LOG_FLG);
		    	updateBackUpDay();
		    	return nyuryokuCheckResultConst.SUCCESS;
		    } else {
		    	commonAP.writeInLog("バックアップ失敗:エラータイプ：" + processComplete,logWriting.DATEDATE_LOG_FLG);
		    	return nyuryokuCheckResultConst.FAILED + ":" + processComplete;
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    commonAP.writeInLog("バックアップ失敗:エラータイプ：不明",logWriting.DATEDATE_LOG_FLG);
		    return nyuryokuCheckResultConst.FAILED + ":" + "原因不明のエラー";
		}


	}

	private void updateBackUpDay(){
		String toDay = controllDay.getTODAY();


		S s = new S();
		s.getCon();

		controllDay.update_KOSHINBI(toDay, ReCord.KOSHINBI_BACK_UP, s);

		s.closeConection();

	}

	//バックアップ入力
	public String backUpIn(TAB_MainDTO mainDTO){


		String executeCmd = "cmd /c mysql -u " + mainDTO.getMysqlID() + " -p" + mainDTO.getMysqlPass() + " " + TBL_Name.KABU_DB + "  <  " + mainDTO.getInBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		executeCmd = executeCmd.replace(File.separator,ReturnCodeConst.SQL_SEPA);
		commonAP.writeInLog("リストア開始:" + mainDTO.getInBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA),logWriting.DATEDATE_LOG_FLG);
		Process runtimeProcess;
		try {
		    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		    int processComplete = runtimeProcess.waitFor();
		    if (processComplete == 0) {
		    	commonAP.writeInLog("リストア成功",logWriting.DATEDATE_LOG_FLG);
		    	return nyuryokuCheckResultConst.SUCCESS;
		    } else {
		    	commonAP.writeInLog("リストア失敗:エラータイプ：" + processComplete,logWriting.DATEDATE_LOG_FLG);
		    	return nyuryokuCheckResultConst.FAILED + ":" + processComplete;
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    commonAP.writeInLog("リストア失敗:エラータイプ：不明",logWriting.DATEDATE_LOG_FLG);
		    return nyuryokuCheckResultConst.FAILED + ":" + "原因不明のエラー";
		}

	}


	public String checkDumpFileNumbers(TAB_MainDTO mainDTO){
		if(checkAllFileNumbers(mainDTO)==false){
			if ( deleteMostOldDumpFile(mainDTO)==false ) {
				return nyuryokuCheckResultConst.FAILED;
			};
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}

	//フォルダ内のファイルの数を数える。
	//指定の数より多い場合はfalseを返す。
	//falseの場合、一番古いファイルを削除する。
	private boolean checkAllFileNumbers(TAB_MainDTO mainDTO){

        File file = new File(mainDTO.getOutBackUpFilePath());
        File files[] = file.listFiles();

        if (files.length > PROPARTY.MAX_DUMP_FILES){
        	commonAP.writeInLog( PROPARTY.MAX_DUMP_FILES + "ファイルよりも多くファイルが存在するため最も古いdumpを削除します。",logWriting.DATEDATE_LOG_FLG);
        	return false;
        }
		return true;
	}

	private boolean deleteMostOldDumpFile(TAB_MainDTO mainDTO){
        File file = new File(mainDTO.getOutBackUpFilePath());
        File files[] = file.listFiles();

        //以下のような順でならんでいるので一番新しい古いファイルを消す
        //[0]:2017-01-01
        //[1]:2017-01-02
        //[2]:2017-01-03
        if(files[0].delete()){
        	//成功
        	commonAP.writeInLog(files[0] + "の削除に成功しました。",logWriting.DATEDATE_LOG_FLG);
        }else{
        	//失敗
        	commonAP.writeInLog(files[0] + "の削除に失敗しました。",logWriting.DATEDATE_LOG_FLG);
        }

		return true;
	}
}
