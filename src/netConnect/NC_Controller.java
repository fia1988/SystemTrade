package netConnect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import proparty.Net_Adress;

import common.commonAP;

public class NC_Controller {

	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	commonAP cAP = new commonAP();
	List<List<String>> netFileS_STOCK_INDEX = new ArrayList<List <String>>();
	List<List<String>> netFileS_STATISTICS = new ArrayList<List <String>>();
	NetBean NB = new NetBean();


	public void setNC_ConUrlCsvS_STOCK_INDEX(String URL,String TODAY,String MAXDAY,int SkipLine){

		//String"yyyy-mm-dd"できた日付を分割
		String[] TODAY_SPRIT = TODAY.split("-");

		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		calendar.set(Integer.parseInt(TODAY_SPRIT[0]), Integer.parseInt(TODAY_SPRIT[1]) - 1, Integer.parseInt(TODAY_SPRIT[2]));



			while(cAP.checkDay(TODAY, MAXDAY)){

				NB.setUrlCsv(URL + TODAY,SkipLine);

				if(NB.getUrlCsv().get(0).equals("")){

				}else{
					NB.setUrlCsvS(NB.getUrlCsv());
				}

				calendar.add(Calendar.DAY_OF_MONTH, -1);
				TODAY = sdf1.format(calendar.getTime());
			}

		netFileS_STOCK_INDEX = NB.getUrlCsvS();

	}

	public List<List<String>> getNC_ConUrlCsvS_STOCK_INDEX(){
		return netFileS_STOCK_INDEX;
	}



	public void setNC_ConUrlCsvS_STATISTICS(String TODAY,String MAXDAY,int SkipLine){

		//String"yyyy-mm-dd"できた日付を分割
		String[] TODAY_SPRIT = TODAY.split("-");
		
		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		calendar.set(Integer.parseInt(TODAY_SPRIT[0]), Integer.parseInt(TODAY_SPRIT[1]) - 1, Integer.parseInt(TODAY_SPRIT[2]));
		String DAY;
		if(cAP.checkDay(TODAY, MAXDAY)){


			System.out.println("setNC:" + Net_Adress.STATISTICS_LIST_DD + TODAY + Net_Adress.DOWN_CSV);


			NB.setUrlCsv(Net_Adress.STATISTICS_LIST_DD + TODAY + Net_Adress.DOWN_CSV,SkipLine);
			String firstDAY = TODAY;
			System.out.println(TODAY);
//			firstDAY = firstDAY.replaceFirst("年", "-");
//			firstDAY = firstDAY.replaceFirst("月", "-");
//			firstDAY = firstDAY.replaceFirst("日", "");


//			NB.setUrlCsvS(NB.getUrlCsv());
//			calendar.add(Calendar.DAY_OF_MONTH, -1);
//			TODAY = sdf1.format(calendar.getTime());
			if(TODAY.equals(firstDAY)){
				NB.setUrlCsvS(NB.getUrlCsv());
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				TODAY = sdf1.format(calendar.getTime());
			}else if(cAP.checkDay(firstDAY, MAXDAY)){

				DAY = NB.getUrlCsv().get(0);
				DAY = DAY.replaceFirst("年", "-");
				DAY = DAY.replaceFirst("月", "-");
				DAY = DAY.replaceFirst("日", "");
				if(cAP.checkDay(TODAY,DAY )){
					NB.setUrlCsvS(NB.getUrlCsv());
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					System.out.println("試験的に通ったNC_CON：TODAY" + TODAY + ",firstDAY:" + firstDAY + ",MAXDAY:" + MAXDAY + ",DAY:" + DAY);
					TODAY = sdf1.format(calendar.getTime());
				}
			}




			while(cAP.checkDay(TODAY, MAXDAY)){

				NB.setUrlCsv(Net_Adress.STATISTICS_LIST_DD + TODAY + Net_Adress.DOWN_CSV,SkipLine);
				DAY = NB.getUrlCsv().get(0);
				DAY = DAY.replaceFirst("年", "-");
				DAY = DAY.replaceFirst("月", "-");
				DAY = DAY.replaceFirst("日", "");

				if(DAY.equals(firstDAY)){

				}else if(NB.getUrlCsv().get(0).equals("")){

				}else if(firstDAY.compareTo(DAY)<0){
//					System.out.println("firstDAY:" + firstDAY + " DAY：" + DAY);
				}else{

					NB.setUrlCsvS(NB.getUrlCsv());
				}

				calendar.add(Calendar.DAY_OF_MONTH, -1);
				TODAY = sdf1.format(calendar.getTime());
			}

		}

		netFileS_STATISTICS = NB.getUrlCsvS();

	}


	public List<List<String>> getNC_ConUrlCsvS_STATISTICS(){
		return netFileS_STATISTICS;
	}

	public void reset(){


	}

}
