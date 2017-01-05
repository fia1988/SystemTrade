package botton;

import java.io.File;

import proparty.S;
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

		return nyuryokuCheckResultConst.SUCCESS;
	}
}
