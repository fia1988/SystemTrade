package insertPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import netConnect.NetBean;
import bean.Bean_Bean;

import common.commonAP;

public class InsertDay_Controller {
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	commonAP cAP = new commonAP();
	NetBean NB = new NetBean();
	Bean_Bean B_B = new Bean_Bean();
	InsertDay I_D = new InsertDay();

//	public void insertDDs_STOCK_INDEX(String URL,String TODAY,String MAXDAY,int SkipLine1,int SkipLine2,S s){
//
//		//String"yyyy-mm-dd"できた日付を分割
//		String[] TODAY_SPRIT = TODAY.split("-");
//
//		//今日の日付をカレンダーにいれまーす。
//		//月だけ0 ＝ 1月
//		calendar.set(Integer.parseInt(TODAY_SPRIT[0]), Integer.parseInt(TODAY_SPRIT[1]) - 1, Integer.parseInt(TODAY_SPRIT[2]));
//
//
//
//			while(cAP.checkDay(TODAY, MAXDAY)){
//
//				NB.setUrlCsv(URL + TODAY,SkipLine1);
//
//				if(NB.getUrlCsv().get(0).equals("")){
//
//				}else{
//					B_B = new Bean_Bean();
//					B_B.setList_CSVtoDTO_STOCK_INDEX(NB.getUrlCsv(), SkipLine2);
//					I_D.InsertDD(B_B.getList_CSVtoDTO_STOCK_ETF(), s);
//				}
//
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				TODAY = sdf1.format(calendar.getTime());
//			}
//
//
//	}




//	public void insertDDs_STATISTICS(String TODAY,String MAXDAY,int SkipLine1,int SkipLine2,S s){
//
//		//String"yyyy-mm-dd"できた日付を分割
//		String[] TODAY_SPRIT = TODAY.split("-");
//
//		//今日の日付をカレンダーにいれまーす。
//		//月だけ0 ＝ 1月
//		calendar.set(Integer.parseInt(TODAY_SPRIT[0]), Integer.parseInt(TODAY_SPRIT[1]) - 1, Integer.parseInt(TODAY_SPRIT[2]));
//
//		if(cAP.checkDay(TODAY, MAXDAY)){
//
//			NB.setUrlCsv(Net_Adress.STATISTICS_LIST_DD + TODAY + Net_Adress.DOWN_CSV,SkipLine1);
//			String firstDAY = NB.getUrlCsv().get(0);
//
//			firstDAY = firstDAY.replaceFirst("年", "-");
//			firstDAY = firstDAY.replaceFirst("月", "-");
//			firstDAY = firstDAY.replaceFirst("日", "");
//
//
////			NB.setUrlCsvS(NB.getUrlCsv());
////			calendar.add(Calendar.DAY_OF_MONTH, -1);
////			TODAY = sdf1.format(calendar.getTime());
//			if(TODAY.equals(firstDAY)){
//
//				B_B = new Bean_Bean();
//				B_B.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(), SkipLine2);
//				I_D.InsertDD(B_B.getList_CSVtoDTO_STATISTICA(), s);
//
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				TODAY = sdf1.format(calendar.getTime());
//			}else if(cAP.checkDay(firstDAY, MAXDAY)){
//				B_B = new Bean_Bean();
//				B_B.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(), SkipLine2);
//				I_D.InsertDD(B_B.getList_CSVtoDTO_STATISTICA(), s);
//
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				System.out.println("試験的に通ったNC_CON：TODAY" + TODAY + ",firstDAY:" + firstDAY + ",MAXDAY:" + MAXDAY);
//				TODAY = sdf1.format(calendar.getTime());
//
//			}
//
//
//			String DAY;
//
//			while(cAP.checkDay(TODAY, MAXDAY)){
//
//				NB.setUrlCsv(Net_Adress.STATISTICS_LIST_DD + TODAY + Net_Adress.DOWN_CSV,SkipLine1);
//				DAY = NB.getUrlCsv().get(0);
//				DAY = DAY.replaceFirst("年", "-");
//				DAY = DAY.replaceFirst("月", "-");
//				DAY = DAY.replaceFirst("日", "");
//
//				if(DAY.equals(firstDAY)){
//
//				}else if(NB.getUrlCsv().get(0).equals("")){
//
//				}else if(firstDAY.compareTo(DAY)<0){
////					System.out.println("firstDAY:" + firstDAY + " DAY：" + DAY);
//				}else{
//
//					B_B = new Bean_Bean();
//					B_B.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(), SkipLine2);
//					I_D.InsertDD(B_B.getList_CSVtoDTO_STATISTICA(), s);
//				}
//
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				TODAY = sdf1.format(calendar.getTime());
//			}
//
//		}
//
//
//
//	}
}
