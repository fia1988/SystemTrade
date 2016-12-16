package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique09 {

	//ボリンジャーバンド
	public static int BORIBAN_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

//		nowDTO.getNowLONG_1_L_SIGMA_01();
//		nowDTO.getNowLONG_3_H_SIGMA_01();
//		nowDTO.getNowSHORT_1_H_SIGMA_01();
//		nowDTO.getNowMIDDLE_1_H_SIGMA_01();


		if (nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}
		return Technique98_CONST.NO_GAME;
	}



	public static int BORIBAN_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

//		nowDTO.getNowLONG_1_L_SIGMA_01();
//		nowDTO.getNowLONG_3_H_SIGMA_01();
//		nowDTO.getNowSHORT_1_H_SIGMA_01();
//		nowDTO.getNowMIDDLE_1_H_SIGMA_01();

//		double kessaiKin =  resultDTO.getEntryAveragePrice();
		if (nowDTO.getNowSHORT_3_L_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}
		return Technique98_CONST.NO_GAME;
	}


}
