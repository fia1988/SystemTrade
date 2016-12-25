package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

public class Technique08 {



	public static int MACD_TORAKU_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if ( Technique04.MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		};

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_TORAKU_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( Technique07.torakuRatio_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		if ( Technique04.MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		};

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_IDOHEIKIN_L_ENTRY(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		try{
			//			for (int n = 0 ; n < paraDTO.getIntCount01() ; n++){
			for (int n = paraDTO.getIntCount01() ; n > 0 ; n--){
				if ( MACD_IDOHEIKIN_L(paraDTO, nowDTOList, nowDTOadress - n , resultDTO, judge) == Technique98_CONST.NO_GAME){
					return Technique98_CONST.NO_GAME;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_IDOHEIKIN_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;


	}

	public static int MACD_IDOHEIKIN_S_ENTRY(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		try{
			//			for (int n = 0 ; n < paraDTO.getIntCount01() ; n++){
			for (int n = paraDTO.getIntCount01() ; n > 0 ; n--){
				if ( MACD_IDOHEIKIN_S(paraDTO, nowDTOList, nowDTOadress - n , resultDTO, judge) == Technique98_CONST.NO_GAME){
					return Technique98_CONST.NO_GAME;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_IDOHEIKIN_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;


	}

	public static int MACD_IDOHEIKIN_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique04.MACD_M_S_OVER0":
				switch( nowDTO.getCode_01() ){
				case "1810―T":
					break;
				case "1813―T":
					break;
				case "1824―T":
					break;
				case "1870―T":
					break;
				case "1878―T":
					break;
				case "1881―T":
					break;
				case "1925―T":
					break;
				case "1950―T":
					break;
				case "1979―T":
					break;
				case "1982―T":
					break;
				case "1983―T":
					break;
				case "2206―T":
					break;
				case "2371―T":
					break;
				case "2413―T":
					break;
				case "2432―T":
					break;
				case "2492―T":
					break;
				case "2651―T":
					break;
				case "2670―T":
					break;
				case "2801―T":
					break;
				case "3110―T":
					break;
				case "3360―T":
					break;
				case "3391―T":
					break;
				case "3580―T":
					break;
				case "3825―T":
					break;
				case "3843―T":
					break;
				case "3865―T":
					break;
				case "4027―T":
					break;
				case "4046―T":
					break;
				case "4095―T":
					break;
				case "4097―T":
					break;
				case "4185―T":
					break;
				case "4204―T":
					break;
				case "4208―T":
					break;
				case "4344―T":
					break;
				case "4516―T":
					break;
				case "4534―T":
					break;
				case "4543―T":
					break;
				case "4555―T":
					break;
				case "4568―T":
					break;
				case "4619―T":
					break;
				case "4704―T":
					break;
				case "4751―T":
					break;
				case "4924―T":
					break;
				case "4967―T":
					break;
				case "4989―T":
					break;
				case "5105―T":
					break;
				case "5110―T":
					break;
				case "5192―T":
					break;
				case "5352―T":
					break;
				case "5423―T":
					break;
				case "5440―T":
					break;
				case "5486―T":
					break;
				case "5541―T":
					break;
				case "5609―T":
					break;
				case "5803―T":
					break;
				case "5947―T":
					break;
				case "5949―T":
					break;
				case "6268―T":
					break;
				case "6273―T":
					break;
				case "6282―T":
					break;
				case "6358―T":
					break;
				case "6373―T":
					break;
				case "6501―T":
					break;
				case "6504―T":
					break;
				case "6586―T":
					break;
				case "6622―T":
					break;
				case "6718―T":
					break;
				case "6849―T":
					break;
				case "6869―T":
					break;
				case "6954―T":
					break;
				case "6988―T":
					break;
				case "7239―T":
					break;
				case "7259―T":
					break;
				case "7282―T":
					break;
				case "7313―T":
					break;
				case "7463―T":
					break;
				case "7550―T":
					break;
				case "7769―T":
					break;
				case "7844―T":
					break;
				case "7937―T":
					break;
				case "7955―T":
					break;
				case "7966―T":
					break;
				case "7981―T":
					break;
				case "7988―T":
					break;
				case "8015―T":
					break;
				case "8031―T":
					break;
				case "8053―T":
					break;
				case "8081―T":
					break;
				case "8114―T":
					break;
				case "8174―T":
					break;
				case "8253―T":
					break;
				case "8424―T":
					break;
				case "8729―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "9070―T":
					break;
				case "9072―T":
					break;
				case "9115―T":
					break;
				case "9533―T":
					break;
				case "9719―T":
					break;
				case "9755―T":
					break;
				case "9787―T":
					break;
				case "9948―T":
					break;
				case "9974―T":
					break;
				case "9984―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}

				break;

			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "1721―T":
					break;
				case "1802―T":
					break;
				case "1810―T":
					break;
				case "1813―T":
					break;
				case "1824―T":
					break;
				case "1881―T":
					break;
				case "1950―T":
					break;
				case "1951―T":
					break;
				case "1959―T":
					break;
				case "1979―T":
					break;
				case "1982―T":
					break;
				case "2109―T":
					break;
				case "2267―T":
					break;
				case "2359―T":
					break;
				case "2371―T":
					break;
				case "2432―T":
					break;
				case "2659―T":
					break;
				case "2801―T":
					break;
				case "2914―T":
					break;
				case "2918―T":
					break;
				case "3110―T":
					break;
				case "3151―T":
					break;
				case "3201―T":
					break;
				case "3360―T":
					break;
				case "3391―T":
					break;
				case "3580―T":
					break;
				case "3734―T":
					break;
				case "3843―T":
					break;
				case "3865―T":
					break;
				case "4027―T":
					break;
				case "4046―T":
					break;
				case "4088―T":
					break;
				case "4095―T":
					break;
				case "4097―T":
					break;
				case "4185―T":
					break;
				case "4206―T":
					break;
				case "4208―T":
					break;
				case "4212―T":
					break;
				case "4512―T":
					break;
				case "4534―T":
					break;
				case "4536―T":
					break;
				case "4543―T":
					break;
				case "4613―T":
					break;
				case "4617―T":
					break;
				case "4619―T":
					break;
				case "4704―T":
					break;
				case "4708―T":
					break;
				case "4848―T":
					break;
				case "4924―T":
					break;
				case "4967―T":
					break;
				case "4989―T":
					break;
				case "5101―T":
					break;
				case "5105―T":
					break;
				case "5108―T":
					break;
				case "5110―T":
					break;
				case "5192―T":
					break;
				case "5232―T":
					break;
				case "5352―T":
					break;
				case "5423―T":
					break;
				case "5486―T":
					break;
				case "5491―T":
					break;
				case "5541―T":
					break;
				case "5803―T":
					break;
				case "5911―T":
					break;
				case "5946―T":
					break;
				case "5947―T":
					break;
				case "6151―T":
					break;
				case "6273―T":
					break;
				case "6282―T":
					break;
				case "6287―T":
					break;
				case "6340―T":
					break;
				case "6355―T":
					break;
				case "6455―T":
					break;
				case "6501―T":
					break;
				case "6586―T":
					break;
				case "6622―T":
					break;
				case "6674―T":
					break;
				case "6718―T":
					break;
				case "6724―T":
					break;
				case "6841―T":
					break;
				case "6849―T":
					break;
				case "6869―T":
					break;
				case "6954―T":
					break;
				case "6985―T":
					break;
				case "7239―T":
					break;
				case "7259―T":
					break;
				case "7309―T":
					break;
				case "7451―T":
					break;
				case "7463―T":
					break;
				case "7532―T":
					break;
				case "7550―T":
					break;
				case "7649―T":
					break;
				case "7723―T":
					break;
				case "7769―T":
					break;
				case "7840―T":
					break;
				case "7937―T":
					break;
				case "7947―T":
					break;
				case "7955―T":
					break;
				case "7966―T":
					break;
				case "7981―T":
					break;
				case "7988―T":
					break;
				case "8015―T":
					break;
				case "8031―T":
					break;
				case "8032―T":
					break;
				case "8053―T":
					break;
				case "8057―T":
					break;
				case "8078―T":
					break;
				case "8081―T":
					break;
				case "8114―T":
					break;
				case "8174―T":
					break;
				case "8252―T":
					break;
				case "8278―T":
					break;
				case "8289―T":
					break;
				case "8338―T":
					break;
				case "8343―T":
					break;
				case "8344―T":
					break;
				case "8355―T":
					break;
				case "8388―T":
					break;
				case "8392―T":
					break;
				case "8397―T":
					break;
				case "8424―T":
					break;
				case "8584―T":
					break;
				case "8729―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "9059―T":
					break;
				case "9068―T":
					break;
				case "9072―T":
					break;
				case "9310―T":
					break;
				case "9533―T":
					break;
				case "9602―T":
					break;
				case "9719―T":
					break;
				case "9787―T":
					break;
				case "9797―T":
					break;
				case "9896―T":
					break;
				case "9902―T":
					break;
				case "9948―T":
					break;
				case "9974―T":
					break;
				case "9989―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}
				break;

			case "technique.Technique06.IDO_HEKIN_2_L":
				switch( nowDTO.getCode_01() ){
				case "4613―T":
					break;
				case "4751―T":
					break;
				case "6273―T":
					break;
				case "6345―T":
					break;
				case "6856―T":
					break;
				case "7220―T":
					break;
				case "7976―T":
					break;
				case "7988―T":
					break;
				case "8572―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;
			case "technique.Technique06.IDO_HEKIN_4_L":
				switch( nowDTO.getCode_01() ){
				case "2413―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}
				break;
			default:
				return Technique98_CONST.NO_GAME;

			}
		}



		if ( Technique04.MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){

			if ( Technique06.idoHeikinTest_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

			}

		};

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_IDOHEIKIN_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if ( Technique04.MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){

			if ( Technique06.idoHeikinTest_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
				return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}

		};

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_0_OR_IDOHEIKIN_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



		if ( Technique04.MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		};

		if ( Technique06.idoHeikinTest_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_OR_IDOHEIKIN_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



		if ( Technique04.MACD_M_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		};

		if ( Technique06.idoHeikinTest_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;
	}
}
