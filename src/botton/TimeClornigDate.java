package botton;

import java.util.Timer;
import java.util.TimerTask;

import GamenDTO.TAB_MainDTO;

public class TimeClornigDate {
	Timer timer = new Timer();

	public void getEveryDay(TAB_MainDTO mainDTO){

		try {
			timer = new Timer();
			timer.scheduleAtFixedRate(task, 1000, 5000);
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
