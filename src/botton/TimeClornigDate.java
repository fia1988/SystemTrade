package botton;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Timer;
import java.util.TimerTask;

import GamenDTO.TAB_MainDTO;

import common.commonAP;

import constant.logWriting;

public class TimeClornigDate {
	Timer timer = new Timer();
//	ScheduledExecutorService timer = new ScheduledExecutorService();




	TAB_MainDTO MainDTO = null;

	public void getEveryDay(TAB_MainDTO mainDTO){

		try {
			timer = new Timer();
			this.MainDTO = mainDTO;
//			timer.scheduleAtFixedRate(task,0, 1800000);
			timer.schedule(task,0, 1200000);
//			timer.schedule(task,0, 18);
//			timer.scheduleWithFixedDelay(task,0,0);
		} catch (Exception e) {
			e.printStackTrace();
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

			try {
				C_D.getDayDate(MainDTO);
			} catch (Exception e) {
				commonAP.writeInLog("何か致命的にエラーが発生している。以下にエラーメッセージ",logWriting.DATEDATE_LOG_FLG);
				e.printStackTrace();
	            StringWriter sw = null;
	            PrintWriter  pw = null;

	            sw = new StringWriter();
	            pw = new PrintWriter(sw);
	            e.printStackTrace(pw);
	            String trace = sw.toString();
	            commonAP.writeInLog(trace,logWriting.DATEDATE_LOG_FLG);

	            try {
	                if ( sw != null ) {
	                    sw.flush();
	                    sw.close();
	                }
	                if ( pw != null ) {
	                    pw.flush();
	                    pw.close();
	                }
	            } catch (IOException ignore){}


			}

			//メモリの解放
			C_D = new cloringDate();
		}
	};
}
