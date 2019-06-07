package analysis;

import java.io.File;
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

		longTermTestSupporter_main();

	}

	private static void longTermTestSupporter_main(){
		TAB_MainDTO mainDTO = new TAB_MainDTO();

		//バックテストである場合のみそれを判断するフラグをここにセットする
		mainDTO.setBackTestFLG(true);
		//IDとパス
		mainDTO.setMysqlID("root");
		mainDTO.setMysqlPass("8Jecikj");
		//へそごま
		mainDTO.setHesogomaFile(true);
		//セパフラグ
		mainDTO.setSepaComFileAutoCaptureFLG(true);
		//バックアップとる
		mainDTO.setAutoBackUp(true);
		//ログ
		mainDTO.setLogFilePath						("C:\\Users\\NOBORU1988\\Dropbox\\01.kabu\\01.log");
		mainDTO.setLogFilePath						("D:\\01.kabu_backup");
		
		//LSファイル
		mainDTO.setEntryFolderPath					("C:\\Users\\NOBORU1988\\Dropbox\\01.kabu\\02.everyDayFile");
		//セパファイル
		mainDTO.setSepaFolderPath					("D:\\01.kabu_backup\\03.sepaFile");
		//へそごま
		mainDTO.setEveryDayHesoGomaCsvFolderPath	("D:\\01.kabu_backup\\04.hesoGoma");
		//backup
		mainDTO.setOutBackUpFolderPath				("D:" + File.separator + "01.kabu_backup" + File.separator + "99.dumpbakup");

		//即座にばらまく
		mainDTO.setCloringSokuzaCheck(true);
		cloringDate C_D = new cloringDate();
		C_D.getDayDate(mainDTO);
		C_D = new cloringDate();
		mainDTO.setCloringSokuzaCheck(false);
		//最後にバックテストフラグを終了する
		mainDTO.setBackTestFLG(false);
	}
}
