package analysis;

import java.util.List;

import GamenDTO.TAB_MainDTO;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import botton.cloringDate;

public class Testsupport {

	private static void setparameta(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO,false);
		//				paraDTO.setCheckInvest(true);
		paraDTO.setTesuRYO(0.015);
		paraDTO.setMaxEntryTimes(30);
		paraDTO.setCheckParaDTOOption(true);
		paraDTO.setCheckParaDTOOption(false);
		resultDTO.setTotalGames(6);
		resultDTO.setTotalGames(10);
		paraDTO.setKeepVisualFlg(false);
		paraDTO.setOnEliteFLG();
		paraDTO.setOffEliteFLG();
	}

	public static void renzokuAnalysis(List<String[]> methodListL,List<String[]> methodListS,List<String[]> dayLists){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		String tec = "technique";
		String startDD;
		String endDD;

		for (String[] a: dayLists){
			startDD		=	a[0];
			endDD		=	a[1];
			for (int b = 0 ;b < methodListL.size() ; b++){
				String L_CLASS = methodListL.get(b)[0];
				String L_METHOD = methodListL.get(b)[1];
				for (int c = 0 ;c < methodListS.size() ; c++){
					String S_CLASS = methodListS.get(c)[0];
					String S_METHOD = methodListS.get(c)[1];
					//				System.out.println("");

					paraDTO = new Bean_Parameta();
					resultDTO = new Bean_Result();
					nowDTO = new Bean_nowRecord();
					setparameta(paraDTO, nowDTO, resultDTO);

					if (!(L_METHOD.equals(S_METHOD))){
						//					System.out.println(L_METHOD + ":" + S_METHOD );
						Analysis00_Common.Analysis_COMMON(tec,L_CLASS,L_METHOD,tec,S_CLASS,S_METHOD,paraDTO,nowDTO,resultDTO,startDD,endDD);
						longTermTestSupporter();
					}
				}

			}
		}

	}

	public static void longTermTestSupporter(){

//		cloringDate CD = new cloringDate();
//
//
//		Calendar now = Calendar.getInstance(); //インスタンス化
//
//		int h = now.get(now.HOUR_OF_DAY);//時を取得
//		int m = now.get(now.MINUTE);     //分を取得
//		int second = now.get(now.SECOND);      //秒を取得
//		String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日",
//                "木曜日", "金曜日", "土曜日"};
//		int baseHour = 17;
//		int baseMinitu = 20;
//		int sleepTime = 10;
//		int week = now.get(Calendar.DAY_OF_WEEK) - 1;
//
//
//		switch (week_name[week]) {
//			case "日曜日":
//				System.out.println(h + ":" + m + ":" + second + ",今日は" + week_name[week]);
//				return;
//			case "土曜日":
//				System.out.println(h + ":" + m + ":" + second + ",今日は" + week_name[week]);
//				return;
//
//			default:
//				break;
//		}
//
//
//		if ( h > baseHour ){
////			System.out.println("ちょいと止まります。");
////			sleepTime = 1000 * 60 * 60 *  ( baseHour - h );
////			System.out.println(sleepTime + "ﾐﾘ秒と止まります。");
////			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
////			if ( h == baseHour ){
////				if ( m < baseMinitu ){
////					sleepTime = 1000 * 60 * ( baseMinitu - m );
////
////					try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
////
////				}
////			}
//			System.out.println(h + ":" + m + ":" + second + ",処理します。");
//			longTermTestSupporter_main();
//		}else if(h == baseHour){
//			if ( m >= baseMinitu ){
//				System.out.println(h + ":" + m + ":" + second + ",処理します。");
//				longTermTestSupporter_main();
//			}
//		}else{
//			System.out.println(h + ":" + m + ":" + second + ",スキップします。");
//		}
		longTermTestSupporter_main();

	}

	private static void longTermTestSupporter_main(){
		TAB_MainDTO mainDTO = new TAB_MainDTO();

		//バックテストである場合のみそれを判断するフラグをここにセットする
		mainDTO.setBackTestFLG(true);

		//即座にばらまく
		mainDTO.setCloringSokuzaCheck(true);
		cloringDate C_D = new cloringDate();
		C_D.getDayDate(mainDTO);
		C_D = new cloringDate();

		//最後にバックテストフラグを終了する
		mainDTO.setBackTestFLG(false);
	}
}
