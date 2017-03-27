package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique11 {


	public static int DEKI_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() > nowDTO.getNowSHORTIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		nowDTO.getNowSHORTIDO_DEKI_01();
		nowDTO.getNowSHORTIDO_BAYBAY_01();
		nowDTO.getNowDEKI_01();
		nowDTO.getNowBAYBAY_01();

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int DEKI_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() < nowDTO.getNowMIDDLEIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}


	public static int DEKI_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() > nowDTO.getNowMIDDLEIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int DEKI_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() < nowDTO.getNowLONGIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}

	public static int DEKI_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() > nowDTO.getNowLONGIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int DEKI_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowDEKI_01() < nowDTO.getNowSHORTIDO_DEKI_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}
	
	
	public static int BAYBAY_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() > nowDTO.getNowSHORTIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		nowDTO.getNowSHORTIDO_BAYBAY_01();
		nowDTO.getNowSHORTIDO_BAYBAY_01();
		nowDTO.getNowBAYBAY_01();
		nowDTO.getNowBAYBAY_01();

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int BAYBAY_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() < nowDTO.getNowMIDDLEIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}


	public static int BAYBAY_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() > nowDTO.getNowMIDDLEIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int BAYBAY_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() < nowDTO.getNowLONGIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}

	public static int BAYBAY_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() > nowDTO.getNowLONGIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

//		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		return Technique98_CONST.NO_GAME;
	}

	public static int BAYBAY_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if(nowDTO.getNowBAYBAY_01() < nowDTO.getNowSHORTIDO_BAYBAY_01()){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;

	}
}
