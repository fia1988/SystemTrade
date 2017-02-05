package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Techinique00_TEST {
	public static int MACD_M_L_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		//エントリータイムが多すぎるとノーゲーム
//		if (resultDTO.getEntryTime() >= paraDTO.getMaxEntryTimes()){
		if (resultDTO.getEntryTime() >= 5){
			return Technique98_CONST.NO_GAME;
		}

		if ( nowDTO.getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;

	}

	public static int MACD_M_S_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		//保有期間が長くなると売る
		if (resultDTO.getKeepCount() >= 10){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;

	}
}
