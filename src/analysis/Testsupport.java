package analysis;

import java.util.Calendar;

import GamenDTO.TAB_MainDTO;
import botton.cloringDate;

public class Testsupport {
	public static void longTermTestSupporter(){


		Calendar now = Calendar.getInstance(); //インスタンス化

		int h = now.get(now.HOUR_OF_DAY);//時を取得
		int m = now.get(now.MINUTE);     //分を取得
		int second = now.get(now.SECOND);      //秒を取得
		String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日",
                "木曜日", "金曜日", "土曜日"};
		int baseHour = 17;
		int baseMinitu = 20;
		int sleepTime = 10;
		int week = now.get(Calendar.DAY_OF_WEEK) - 1;


		switch (week_name[week]) {
			case "日曜日":
				System.out.println(h + ":" + m + ":" + second + ",今日は" + week_name[week]);
				return;
			case "土曜日":
				System.out.println(h + ":" + m + ":" + second + ",今日は" + week_name[week]);
				return;

			default:
				break;
		}


		if ( h > baseHour ){
//			System.out.println("ちょいと止まります。");
//			sleepTime = 1000 * 60 * 60 *  ( baseHour - h );
//			System.out.println(sleepTime + "ﾐﾘ秒と止まります。");
//			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
//			if ( h == baseHour ){
//				if ( m < baseMinitu ){
//					sleepTime = 1000 * 60 * ( baseMinitu - m );
//
//					try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
//
//				}
//			}
			System.out.println(h + ":" + m + ":" + second + ",処理します。");
			longTermTestSupporter_main();
		}else{
			System.out.println(h + ":" + m + ":" + second + ",スキップします。");
		}


	}

	private static void longTermTestSupporter_main(){
		TAB_MainDTO mainDTO = new TAB_MainDTO();

		cloringDate C_D = new cloringDate();
		C_D.getDayDate(mainDTO);
		C_D = new cloringDate();
	}
}
