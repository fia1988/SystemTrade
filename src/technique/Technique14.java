package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique14 {
	public static int CAPM_L_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

//		nowDTO.getCAPM();
//		nowDTO.getCAPM_AVE();
//		nowDTO.getRETURN_FOR_BETA();
//		nowDTO.getRETURN_FOR_BETA_AVE();
//
//		if(nowDTO.getNowCLOSE_01() > 1180 ){
//			return Technique98_CONST.NO_GAME;
//		}
//		//YYYY-MM-DD
//		if(nowDTO.getNowDay_01().equals("") ){
//
//		}
	}


	public static int CAPM_L_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_L_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_S_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_S_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_S_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}




	public static int CAPM_AVE_L_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}


	public static int CAPM_AVE_L_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_L_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_S_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_S_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_S_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}



	public static int CAPM_AVE_Right_L_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}


	public static int CAPM_AVE_Right_L_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_Right_L_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_Right_S_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_Right_S_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_Right_S_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}



	public static int CAPM_AVE_Left_L_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}


	public static int CAPM_AVE_Left_L_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_Left_L_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int CAPM_AVE_Left_S_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_Left_S_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int CAPM_AVE_Left_S_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_aveCheck_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_aveCheck_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_aveCheck_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}







	public static int CAPM_aveCheck_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() * 1 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_aveCheck_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() * 2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_aveCheck_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() * 3 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_1(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_2(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_4(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_5(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_6(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_7(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_8(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_9(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_10(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_11(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_12(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_13(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_14(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() <= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_15(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() >= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() >= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

	public static int CAPM_MULTI_16(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getCAPM() >= nowDTO.getCAPM_AVE() ){
			if(nowDTO.getCAPM_AVE() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
				if(nowDTO.getCAPM() <= nowDTO.getRETURN_FOR_BETA() ){
					if(nowDTO.getRETURN_FOR_BETA() <= nowDTO.getRETURN_FOR_BETA_AVE() ){
						return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
					}
				}
			}
		}
		return Technique98_CONST.NO_GAME;
	}

}
