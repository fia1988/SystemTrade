package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

public class Technique13 {

	public static int code9468_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (!nowDTO.getCode_01().equals("9468")){
			return Technique98_CONST.NO_GAME;
		}

		if(nowDTO.getNowCLOSE_01() > 1180 ){
			return Technique98_CONST.NO_GAME;
		}

		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
	}

	public static int code9468_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (!nowDTO.getCode_01().equals("9468")){
			return Technique98_CONST.NO_GAME;
		}

		if(nowDTO.getNowCLOSE_01() < 1400 ){
			return Technique98_CONST.NO_GAME;
		}

		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
	}

}
