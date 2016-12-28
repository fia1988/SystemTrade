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

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		
		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique06.idoHeikinTest_S":
				switch( nowDTO.getCode_01() ){
				case "3687―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "2429―T":
					break;
				case "3179―T":
					break;
				case "4293―T":
					break;
				case "6055―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			default:
				return Technique98_CONST.NO_GAME;

			}
		}


		if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int IDO_HEKIN_2_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowLONGIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;


	}

	public static int IDO_HEKIN_3_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		
		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "2429―T":
					break;
				case "3179―T":
					break;
				case "4293―T":
					break;
				case "9419―T":
					break;
				case "9438―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}

				break;
			default:
				return Technique98_CONST.NO_GAME;

			}
		}



		if (nowDTO.getNowMIDDLEIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int IDO_HEKIN_4_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowMIDDLEIDO_01() < nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}


		return Technique98_CONST.NO_GAME;

	}


	public static int IDO_HEKIN_1_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		
		//買いの時だけエリート処理
		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique04.MACD_M_S_OVER0":
				switch( nowDTO.getCode_01() ){
				case "1674―T":
					break;
				case "1824―T":
					break;
				case "1835―T":
					break;
				case "1899―T":
					break;
				case "1925―T":
					break;
				case "1982―T":
					break;
				case "2371―T":
					break;
				case "2432―T":
					break;
				case "2651―T":
					break;
				case "2801―T":
					break;
				case "3064―T":
					break;
				case "3092―T":
					break;
				case "3098―T":
					break;
				case "3156―T":
					break;
				case "3360―T":
					break;
				case "3632―T":
					break;
				case "3744―T":
					break;
				case "3769―T":
					break;
				case "3778―T":
					break;
				case "3843―T":
					break;
				case "3865―T":
					break;
				case "4350―T":
					break;
				case "4543―T":
					break;
				case "4694―T":
					break;
				case "4927―T":
					break;
				case "5105―T":
					break;
				case "5282―T":
					break;
				case "5423―T":
					break;
				case "5440―T":
					break;
				case "5481―T":
					break;
				case "5949―T":
					break;
				case "6013―T":
					break;
				case "6255―T":
					break;
				case "6268―T":
					break;
				case "6508―T":
					break;
				case "6586―T":
					break;
				case "6641―T":
					break;
				case "6644―T":
					break;
				case "6807―T":
					break;
				case "6849―T":
					break;
				case "6952―T":
					break;
				case "6988―T":
					break;
				case "7239―T":
					break;
				case "7915―T":
					break;
				case "7966―T":
					break;
				case "8396―T":
					break;
				case "8715―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "8897―T":
					break;
				case "9627―T":
					break;
				case "9787―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}

				break;

			case "technique.Technique06.IDO_HEKIN_2_L":
				switch( nowDTO.getCode_01() ){
				case "2175―T":
					break;
				case "2352―T":
					break;
				case "2432―T":
					break;
				case "4613―T":
					break;
				case "4927―T":
					break;
				case "5108―T":
					break;
				case "5471―T":
					break;
				case "6050―T":
					break;
				case "6656―T":
					break;
				case "6674―T":
					break;
				case "6807―T":
					break;
				case "6856―T":
					break;
				case "9627―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}
				break;
			default:
				return Technique98_CONST.NO_GAME;

			}
		}






		if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_2_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowLONGIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_3_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		
		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique04.MACD_M_S_OVER0":
				switch( nowDTO.getCode_01() ){
				case "1801―T":
					break;
				case "1884―T":
					break;
				case "2120―T":
					break;
				case "2127―T":
					break;
				case "2175―T":
					break;
				case "2181―T":
					break;
				case "2229―T":
					break;
				case "2326―T":
					break;
				case "2371―T":
					break;
				case "2398―T":
					break;
				case "3034―T":
					break;
				case "3092―T":
					break;
				case "3098―T":
					break;
				case "3110―T":
					break;
				case "3608―T":
					break;
				case "3624―T":
					break;
				case "3632―T":
					break;
				case "3647―T":
					break;
				case "3654―T":
					break;
				case "3823―T":
					break;
				case "3843―T":
					break;
				case "4564―T":
					break;
				case "5105―T":
					break;
				case "5192―T":
					break;
				case "5440―T":
					break;
				case "5445―T":
					break;
				case "5481―T":
					break;
				case "6050―T":
					break;
				case "6055―T":
					break;
				case "6058―T":
					break;
				case "6498―T":
					break;
				case "6504―T":
					break;
				case "6627―T":
					break;
				case "6641―T":
					break;
				case "6728―T":
					break;
				case "6755―T":
					break;
				case "6770―T":
					break;
				case "6869―T":
					break;
				case "6920―T":
					break;
				case "7148―T":
					break;
				case "7239―T":
					break;
				case "7259―T":
					break;
				case "8174―T":
					break;
				case "8584―T":
					break;
				case "8591―T":
					break;
				case "8600―T":
					break;
				case "8715―T":
					break;
				case "8841―T":
					break;
				case "8876―T":
					break;
				case "8897―T":
					break;
				case "9375―T":
					break;
				case "9627―T":
					break;
				case "I146":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "1417―T":
					break;
				case "1675―T":
					break;
				case "1801―T":
					break;
				case "1827―T":
					break;
				case "1835―T":
					break;
				case "1884―T":
					break;
				case "1945―T":
					break;
				case "1950―T":
					break;
				case "1972―T":
					break;
				case "2120―T":
					break;
				case "2127―T":
					break;
				case "2175―T":
					break;
				case "2181―T":
					break;
				case "2229―T":
					break;
				case "2326―T":
					break;
				case "2371―T":
					break;
				case "2398―T":
					break;
				case "2432―T":
					break;
				case "2440―T":
					break;
				case "2489―T":
					break;
				case "2492―T":
					break;
				case "3034―T":
					break;
				case "3064―T":
					break;
				case "3092―T":
					break;
				case "3098―T":
					break;
				case "3110―T":
					break;
				case "3359―F":
					break;
				case "3360―T":
					break;
				case "3391―T":
					break;
				case "3431―T":
					break;
				case "3608―T":
					break;
				case "3624―T":
					break;
				case "3632―T":
					break;
				case "3647―T":
					break;
				case "3654―T":
					break;
				case "3769―T":
					break;
				case "3815―T":
					break;
				case "3823―T":
					break;
				case "3843―T":
					break;
				case "3941―T":
					break;
				case "4061―T":
					break;
				case "4095―T":
					break;
				case "4182―T":
					break;
				case "4320―T":
					break;
				case "4565―T":
					break;
				case "4581―T":
					break;
				case "4612―T":
					break;
				case "4694―T":
					break;
				case "4848―T":
					break;
				case "4927―T":
					break;
				case "5105―T":
					break;
				case "5192―T":
					break;
				case "5232―T":
					break;
				case "5282―T":
					break;
				case "5440―T":
					break;
				case "5445―T":
					break;
				case "5949―T":
					break;
				case "5975―T":
					break;
				case "6055―T":
					break;
				case "6058―T":
					break;
				case "6247―T":
					break;
				case "6315―T":
					break;
				case "6395―T":
					break;
				case "6498―T":
					break;
				case "6504―T":
					break;
				case "6641―T":
					break;
				case "6755―T":
					break;
				case "6770―T":
					break;
				case "6841―T":
					break;
				case "6845―T":
					break;
				case "6849―T":
					break;
				case "6861―T":
					break;
				case "6869―T":
					break;
				case "6954―T":
					break;
				case "7148―T":
					break;
				case "7239―T":
					break;
				case "7240―T":
					break;
				case "7248―T":
					break;
				case "7259―T":
					break;
				case "7272―T":
					break;
				case "7276―T":
					break;
				case "7606―T":
					break;
				case "7613―T":
					break;
				case "7733―T":
					break;
				case "7747―T":
					break;
				case "7951―T":
					break;
				case "8085―T":
					break;
				case "8174―T":
					break;
				case "8584―T":
					break;
				case "8591―T":
					break;
				case "8593―T":
					break;
				case "8600―T":
					break;
				case "8713―T":
					break;
				case "8715―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "8876―T":
					break;
				case "9130―T":
					break;
				case "9375―T":
					break;
				case "9511―T":
					break;
				case "9627―T":
					break;
				case "9830―T":
					break;
				case "9984―T":
					break;
				case "I146":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			case "technique.Technique06.IDO_HEKIN_2_L":
				switch( nowDTO.getCode_01() ){
				case "3043―T":
					break;
				case "5703―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			default:
				return Technique98_CONST.NO_GAME;

			}
		}



		if (nowDTO.getNowMIDDLEIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int IDO_HEKIN_4_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowMIDDLEIDO_01() > nowDTO.getNowSHORTIDO_01()){
			if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}
		}


		return Technique98_CONST.NO_GAME;
	}



	public static int idoHeikinTest_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		//
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "2154―T":
					break;
				case "2303―T":
					break;
				case "2323―T":
					break;
				case "2326―T":
					break;
				case "2371―T":
					break;
				case "2427―T":
					break;
				case "2428―T":
					break;
				case "2429―T":
					break;
				case "2492―T":
					break;
				case "2782―T":
					break;
				case "3092―T":
					break;
				case "3176―T":
					break;
				case "3179―T":
					break;
				case "3624―T":
					break;
				case "3649―T":
					break;
				case "3655―T":
					break;
				case "3662―T":
					break;
				case "3665―T":
					break;
				case "4290―T":
					break;
				case "4293―T":
					break;
				case "4771―T":
					break;
				case "4847―T":
					break;
				case "6050―T":
					break;
				case "6055―T":
					break;
				case "6862―T":
					break;
				case "7519―T":
					break;
				case "7771―T":
					break;
				case "8462―T":
					break;
				case "8732―T":
					break;
				case "8885―T":
					break;
				case "8938―T":
					break;
				case "9419―T":
					break;
				case "9438―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}

				break;

			case "technique.Technique06.IDO_HEKIN_2_L":
				switch( nowDTO.getCode_01() ){
				case "6030―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;
			default:
				return Technique98_CONST.NO_GAME;

			}
		}



		if (nowDTO.getNowSHORTIDO_01() > nowDTO.getNowCLOSE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}


	public static int idoHeikinTest_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}
		
		if (nowDTO.getNowSHORTIDO_01() < nowDTO.getNowCLOSE_01() ){
			//			nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
			//			nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;
	}
}
