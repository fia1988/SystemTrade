package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique10 {


	public static int BORIBAN_JUN_1_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		try{

			//１日前
			Bean_nowRecord before_1_nowDTO = nowDTOList.get(nowDTOadress - 1);
			//二日前
			Bean_nowRecord before_2_nowDTO = nowDTOList.get(nowDTOadress - 2);
			Bean_nowRecord before_8_nowDTO = nowDTOList.get(nowDTOadress - 8);
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		//何営業日前か
		int beforeDAY = 8;
		//幅なん％
		double haba = 0.15;

		for (int n = beforeDAY ; n > 0 ; n--){
			Bean_nowRecord checkNowDTO = nowDTOList.get(nowDTOadress - n );

			if (checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() == 0){
				return Technique98_CONST.NO_GAME;
			}
//			System.out.println("forのなか：" + checkNowDTO.getNowDay_01() + ":" + n);
			if ( ( ( checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}

			if ( ( ( checkNowDTO.getNowMIDDLE_3_H_SIGMA_01() - checkNowDTO.getNowMIDDLE_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}
		}


		nowDTO = nowDTOList.get(nowDTOadress);
		if ( nowDTO.getNowMIDDLE_3_H_SIGMA_01() < nowDTO.getNowCLOSE_01()  * 1.2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}
		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_JUN_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		try{

			//１日前
			Bean_nowRecord before_1_nowDTO = nowDTOList.get(nowDTOadress - 1);
			//二日前
			Bean_nowRecord before_2_nowDTO = nowDTOList.get(nowDTOadress - 2);
			Bean_nowRecord before_8_nowDTO = nowDTOList.get(nowDTOadress - 8);
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		//何営業日前か
		int beforeDAY = 8;
		//幅なん％
		double haba = 0.15;

		for (int n = beforeDAY ; n > 0 ; n--){
			Bean_nowRecord checkNowDTO = nowDTOList.get(nowDTOadress - n );

			if (checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() == 0){
				return Technique98_CONST.NO_GAME;
			}

			if ( ( ( checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}

			if ( ( ( checkNowDTO.getNowMIDDLE_3_H_SIGMA_01() - checkNowDTO.getNowMIDDLE_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}
		}


		nowDTO = nowDTOList.get(nowDTOadress);
		if ( nowDTO.getNowSHORT_3_H_SIGMA_01() < nowDTO.getNowCLOSE_01()  * 1.2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}
		return Technique98_CONST.NO_GAME;
	}


	public static int BORIBAN_JUN_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		try{

			//１日前
			Bean_nowRecord before_1_nowDTO = nowDTOList.get(nowDTOadress - 1);
			//二日前
			Bean_nowRecord before_2_nowDTO = nowDTOList.get(nowDTOadress - 2);
			Bean_nowRecord before_8_nowDTO = nowDTOList.get(nowDTOadress - 8);
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		//何営業日前か
		int beforeDAY = 8;
		//幅なん％
		double haba = 0.15;

		for (int n = beforeDAY ; n > 0 ; n--){
			Bean_nowRecord checkNowDTO = nowDTOList.get(nowDTOadress - n );


			if (checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() == 0){
				return Technique98_CONST.NO_GAME;
			}

			if ( ( ( checkNowDTO.getNowLONG_3_H_SIGMA_01() - checkNowDTO.getNowLONG_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}

			if ( ( ( checkNowDTO.getNowMIDDLE_3_H_SIGMA_01() - checkNowDTO.getNowMIDDLE_3_L_SIGMA_01() ) / checkNowDTO.getNowCLOSE_01() )  > haba ) {
				return Technique98_CONST.NO_GAME;
			}
		}


		nowDTO = nowDTOList.get(nowDTOadress);
		if ( nowDTO.getNowLONG_3_H_SIGMA_01() < nowDTO.getNowCLOSE_01() * 1.2 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}
		return Technique98_CONST.NO_GAME;
	}



	public static int BORIBAN_JUN_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_1_H_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_JUN_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_2_H_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_JUN_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}


	public static int BORIBAN_JUN_4_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_1_L_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_JUN_5_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_2_L_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int BORIBAN_JUN_6_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( nowDTO.getNowSHORT_3_L_SIGMA_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}


		return Technique98_CONST.NO_GAME;
	}


	public static int MACD_M_L_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( Technique04.MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

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
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

}
