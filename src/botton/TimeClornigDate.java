package botton;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import proparty.S;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class TimeClornigDate {
	Timer timer = new Timer();



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

		return nyuryokuCheckResultConst.SUCCESS;
	}


	public void getEveryDay(TAB_MainDTO mainDTO){

		try {
			timer = new Timer();
//			timer.scheduleAtFixedRate(task, 1000, 5000);
//			timer.scheduleWithFixedDelay(task,0,0);
		} catch (Exception e) {
			System.out.println("kokoko");
			// TODO: handle exception
		}


//
	}

	public void cancelEveryDay(){
		timer.cancel();
	}

	private TimerTask task = new TimerTask(){
		public void run(){
			cloringDate C_D = new cloringDate();
//			C_D.getDayDate();
			//メモリの解放
			C_D = new cloringDate();
			System.out.println("aaaaaaaaaa");
		}
	};
}
