package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique12 {

	public static int diviteCheck_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getDIVIDEND() > 2.2){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		System.out.println("■diviteCheck_1_L-");
//		System.out.println("nowDTO.getCode_01():" + nowDTO.getCode_01());
//		System.out.println("nowDTO.getDIVIDEND():" + nowDTO.getDIVIDEND());
////		System.out.println("nowDTO.getPbr_real():" + nowDTO.getPbr_real());
////		System.out.println("nowDTO.getPer_yoso():" + nowDTO.getPer_yoso());
//		System.out.println("nowDTO.getPER_YOSO():" + nowDTO.getPER_YOSO());
//		System.out.println("nowDTO.getBPS_REAL():" + nowDTO.getBPS_REAL());
//		System.out.println("nowDTO.getPBR_REAL():" + nowDTO.getPBR_REAL());
////		System.out.println("nowDTO.getBps_real():" + nowDTO.getBps_real());
//		System.out.println("■diviteCheck_1_L-");

//

		return Technique98_CONST.NO_GAME;
	}

	public static int diviteCheck_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getDIVIDEND() <= 2.2){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int PBRCheck_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getPBR_REAL() <= 3){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRCheck_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getPBR_REAL() > 3){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRandDiviteCheck_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getPBR_REAL() <= 3 && nowDTO.getDIVIDEND() > 2.2){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRandDiviteCheck_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getPBR_REAL() > 3 && nowDTO.getDIVIDEND() > 2.2){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRandDiviteCheck_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getPBR_REAL() > 5){
			if (nowDTO.getDIVIDEND() > 2){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 5 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 4.5 ){
			if (nowDTO.getDIVIDEND() > 2){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 4.5 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 4.0 ){
			if (nowDTO.getDIVIDEND() > 2){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 4.0 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 3.5 ){
			if (nowDTO.getDIVIDEND() > 2.1){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 3.5 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 3.0 ){
			if (nowDTO.getDIVIDEND() > 2.2){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 3.0 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 2.5 ){
			if (nowDTO.getDIVIDEND() > 2.5){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 2.5 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 2.0 ){
			if (nowDTO.getDIVIDEND() > 2.8){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 2.0 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 1.5 ){
			if (nowDTO.getDIVIDEND() > 3.1){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 1.5 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 1.0 ){
			if (nowDTO.getDIVIDEND() > 3.4){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 1.0 >= nowDTO.getPBR_REAL() && nowDTO.getPBR_REAL() > 0.5 ){
			if (nowDTO.getDIVIDEND() > 3.7){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		} else if ( 0.5 >= nowDTO.getPBR_REAL() ){
			if (nowDTO.getDIVIDEND() > 4){return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);}
		}


//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRandDiviteCheck_4_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getPBR_REAL() > 3 && nowDTO.getDIVIDEND() > 2.2){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int averageCheck_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		//今日の終値
		double nowPrice= 0 ;
		if ( paraDTO.getRealTimeMode() ){
			//本番
			nowPrice = nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
		}else{
			//バックテスト
			try{
				nowPrice = nowDTOList.get(nowDTOadress + 1).getNowCLOSE_01() ;
			}catch(Exception e){
				return Technique98_CONST.NO_GAME;
			}
		}
		//昨日までの平均取得価格
		double nowAvePrice;
		if ( paraDTO.getRealTimeMode()==false ){
			//この中はバックテストモード
			nowAvePrice = resultDTO.getDollStockAveragePrice();
		}else{
			nowAvePrice = resultDTO.getNowAveragePrice(paraDTO, nowDTO);
//			System.out.println(nowAvePrice);
		}
		double nowResult = ( nowPrice - nowAvePrice ) / nowAvePrice;

		if (nowResult >= 1.1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int averageCheck_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		//今日の終値
		double nowPrice= 0 ;
		if ( paraDTO.getRealTimeMode() ){
			//本番
			nowPrice = nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
		}else{
			//バックテスト
			try{
				nowPrice = nowDTOList.get(nowDTOadress + 1).getNowCLOSE_01() ;
			}catch(Exception e){
				return Technique98_CONST.NO_GAME;
			}
		}
		//昨日までの平均取得価格
		double nowAvePrice;
		if ( paraDTO.getRealTimeMode()==false ){
			//この中はバックテストモード
			nowAvePrice = resultDTO.getDollStockAveragePrice();
		}else{
			nowAvePrice = resultDTO.getNowAveragePrice(paraDTO, nowDTO);
		}

		double nowResult = ( nowPrice - nowAvePrice ) / nowAvePrice;

		if (nowResult >= 1.2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int averageCheck_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		//今日の終値
		double nowPrice= 0 ;
		if ( paraDTO.getRealTimeMode() ){
			//本番
			nowPrice = nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
		}else{
			//バックテスト
			try{
				nowPrice = nowDTOList.get(nowDTOadress + 1).getNowCLOSE_01() ;
			}catch(Exception e){
				return Technique98_CONST.NO_GAME;
			}
		}
		//昨日までの平均取得価格
		double nowAvePrice;
		if ( paraDTO.getRealTimeMode()==false ){
			//この中はバックテストモード
			nowAvePrice = resultDTO.getDollStockAveragePrice();
		}else{
			nowAvePrice = resultDTO.getNowAveragePrice(paraDTO, nowDTO);
		}
		double nowResult = ( nowPrice - nowAvePrice ) / nowAvePrice;

		if (nowResult >= 1.3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int diviteCheck_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}





	public static int PBRCheck_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}

	public static int PBRandDiviteCheck_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		if (paraDTO.isCheckInvest()==false){
			return Technique98_CONST.NO_GAME;
		}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		return Technique98_CONST.NO_GAME;
	}







}
