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
