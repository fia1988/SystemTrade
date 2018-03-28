package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

public class Technique14 {
	public static int CAPM_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		nowDTO.getCAPM();
		nowDTO.getCAPM_AVE();
		nowDTO.getRETURN_FOR_BETA();
		nowDTO.getRETURN_FOR_BETA_AVE();

		if(nowDTO.getNowCLOSE_01() > 1180 ){
			return Technique98_CONST.NO_GAME;
		}

		return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
	}
}
