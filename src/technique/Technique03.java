package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique03 {


	//移動平均線SがLを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_SandL_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
//		if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01() ){


			if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}





	}

	//移動平均線LがSを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_SandL_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}



		//ここから移動平均線を見る


			if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowSHORTIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}

	}



	//移動平均線MがLを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_MandL_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}



			if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowMIDDLEIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}




	}

	//移動平均線LがMを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_MandL_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		//ここから移動平均線を見る


			if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowMIDDLEIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}


	}



	//移動平均線SがMを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_SandM_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


			if (nowDTO.getNowMIDDLEIDO_01() < nowDTO.getNowSHORTIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}




	}

	//移動平均線MがSを上回ったとき、トレードフラグ
	public static int checkIDOHeikin_SandM_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

//		if(Techinique_COMMON_METHOD.checkCateGory(paraDTO, nowDTO, resultDTO, judge)==Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		//ここから移動平均線を見る


			if (nowDTO.getNowMIDDLEIDO_01() > nowDTO.getNowSHORTIDO_01() ){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				return Technique98_CONST.TRADE_FLG;
			}else{
				return Technique98_CONST.NO_GAME;
			}

	}
}
