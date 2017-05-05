package botton;

import java.io.File;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
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

		s = new S();
		s.getCon();
		String TODAY = controllDay.getMAX_DD_STOCK_ETF(s);
		s.closeConection();
		//バックアップファイルの出力先にバックアップファイルが存在するかどうかのチェック
		mainDTO.setOutBackUpFilePath(mainDTO.getOutBackUpFolderPath() + File.separator + TODAY + ".dump");
		file =  new File(mainDTO.getOutBackUpFilePath());
		if (file.isFile()==true){
		    return nyuryokuCheckResultConst.EXACT_BACK_UP_FILE_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}




	//バックアップ出力
	public String backUpOut(TAB_MainDTO mainDTO){


		String executeCmd = "mysqldump --single-transaction -u " + mainDTO.getMysqlID() + " -p " + mainDTO.getMysqlPass() + " " + TBL_Name.KABU_DB + "  >  " + mainDTO.getOutBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		executeCmd = executeCmd.replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		mysqldump --single-transaction -u root -p kabudata > D:/orderList/a.dump
//
		Process runtimeProcess;
		try {
			System.out.println("out:" + executeCmd);
		    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		    System.out.println("aaa");
		    int processComplete = runtimeProcess.waitFor();
		    System.out.println("bbbbbbb");
		    if (processComplete == 0) {
		    	return nyuryokuCheckResultConst.SUCCESS;
		    } else {
		    	return nyuryokuCheckResultConst.FAILED + ":" + processComplete;
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    return nyuryokuCheckResultConst.FAILED + ":" + "原因不明のエラー";
		}


	}

	//バックアップ入力
	public String backUpIn(TAB_MainDTO mainDTO){


		String executeCmd = "mysql -u " + mainDTO.getMysqlID() + " -p" + mainDTO.getMysqlPass() + " " + TBL_Name.KABU_DB + "  <  " + mainDTO.getInBackUpFilePath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//		executeCmd = executeCmd.replace(File.separator,ReturnCodeConst.SQL_SEPA);

		Process runtimeProcess;
		try {
			System.out.println("in:" + executeCmd);

		    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		    int processComplete = runtimeProcess.waitFor();
		    if (processComplete == 0) {
		    	return nyuryokuCheckResultConst.SUCCESS;
		    } else {
		    	return nyuryokuCheckResultConst.FAILED + ":" + processComplete;
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    return nyuryokuCheckResultConst.FAILED + ":" + "原因不明のエラー";
		}

	}
}
