package GamenNyuryokuCheck;

import java.io.File;

import proparty.S;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class nyuryokuCheck {



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

		//日々売買ファイルの出力先有無チェック
		file =  new File(mainDTO.getEntryFolderPath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_ENTRY_FOLDER_ERR;
		}

		//分割併合ファイルの出力先チェック
		file =  new File(mainDTO.getSepaFolderPath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR;
		}

		//自動バックアップを取る場合はバックアップフォルダのフォルダパスをチェックする
		if (mainDTO.isAutoBackUp()){
			//バックアップファイルの出力先有無チェック
			file =  new File(mainDTO.getOutBackUpFolderPath());
			if (file.isDirectory()==false){
			    return nyuryokuCheckResultConst.NO_BACKUP_FOLDER_ERR;
			}
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}
}
