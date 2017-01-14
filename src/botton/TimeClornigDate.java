package botton;

import java.util.Timer;
import java.util.TimerTask;

import GamenDTO.TAB_MainDTO;

public class TimeClornigDate {
	Timer timer = new Timer();
//	ScheduledExecutorService timer = new ScheduledExecutorService();




	TAB_MainDTO MainDTO = null;

	public void getEveryDay(TAB_MainDTO mainDTO){

		try {
			timer = new Timer();
			this.MainDTO = mainDTO;
//			timer.scheduleAtFixedRate(task,0, 1800000);
			timer.schedule(task,0, 1800000);
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

			}

			//メモリの解放
			C_D = new cloringDate();
		}
	};
}
