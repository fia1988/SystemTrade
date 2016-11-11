package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique06 {


	public static int IDO_HEKIN_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int IDO_HEKIN_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;


}

	public static int IDO_HEKIN_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLEIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int IDO_HEKIN_4_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

//		nowDTO.getNowMIDDLEIDO_01();
//		nowDTO.getNowLONGIDO_01();
//		nowDTO.getNowSHORTIDO_01();
//		nowDTO.getNowCLOSE_01() ;

		if (nowDTO.getNowMIDDLEIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}


	public static int IDO_HEKIN_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLEIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_4_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

//		nowDTO.getNowMIDDLEIDO_01();
//		nowDTO.getNowLONGIDO_01();
//		nowDTO.getNowSHORTIDO_01();
//		nowDTO.getNowCLOSE_01() ;

		if (nowDTO.getNowMIDDLEIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				return Technique98_CONST.TRADE_FLG;
			}
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;
	}



	public static int idoHeikinTest_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){

			nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
			nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;

	}


	public static int idoHeikinTest_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
			nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
			nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}
}
