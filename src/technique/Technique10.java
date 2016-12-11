package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique10 {


	public static int BORIBAN_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){



		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		try{

			Bean_nowRecord before_1_nowDTO = nowDTOList.get(nowDTOadress - 1);
			System.out.println("-----");
			System.out.println("nowDTO:" + nowDTO.getNowDay_01());
			System.out.println("beforeDTO:" + before_1_nowDTO.getNowDay_01());
			System.out.println("-----");
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		if ( ( ( nowDTO.getNowSHORT_3_H_SIGMA_01() - nowDTO.getNowSHORT_3_L_SIGMA_01() ) / nowDTO.getNowCLOSE_01() )  < 0.1 ) {
			return Technique98_CONST.NO_GAME;
		}
//		nowDTO.getNowLONG_DEV_01();


		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_L_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( Technique04.MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_S_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowSHORT_3_L_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( Technique04.MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

}
