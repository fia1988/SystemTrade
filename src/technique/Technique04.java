package technique;

import java.util.List;
import java.util.Random;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique04 {


	public static int MACD_M_L_OVER0_ENTRY(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		boolean judgeSign = false;
		try{
//			for (int n = 0 ; n < paraDTO.getIntCount01() ; n++){
			for (int n = paraDTO.getIntCount01() ; n > 0 ; n--){

				if ( nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
				if ( nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}
				if (nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_01() >= nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_SIGNAL_01() ){
					return Technique98_CONST.NO_GAME;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_L_ENTRY(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		try{
//			for (int n = 0 ; n < paraDTO.getIntCount01() ; n++){
			for (int n = paraDTO.getIntCount01() ; n > 0 ; n--){

				if ( nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
				if ( nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

				if (nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_01() >= nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_SIGNAL_01() ){
					return Technique98_CONST.NO_GAME;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}



		if ( MACD_M_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int testL(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		switch(nowDTO.getCode_01()){
			case "1312―T":

				break;
			case "1323―T":

				break;

			case "1333―T":

				break;
			default:
				return Technique98_CONST.NO_GAME;
		}

		if ( MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int testS(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		if ( MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_L_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_L_OVER0_BORIBAN_IDOHEIKIN_CASE3_ENTRY(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		return Technique98_CONST.NO_GAME;
	}

	private static int MACD_M_L_OVER0_BORIBAN_IDOHEIKIN_CASE3(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		//ボリバン_ちょっと考える
		if (nowDTO.getNowSHORT_3_L_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		//移動平均線_ちょっと考える
		if (nowDTO.getNowSHORTIDO_01() <= nowDTO.getNowCLOSE_01() ){
			return Technique98_CONST.NO_GAME;
		}



		//MACD
		if ( P_MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG ){
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

		if ( MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	//MACD
	public static int MACD_M_L_OVER0_KYURAKU(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}



//		nowDTO.setNowDEKI_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.DEKI		)	);
//		nowDTO.setNowBAYBAY_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.BAYBAY	)	);
//
//		nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CHANGERATE	)	);
//
//		nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MAXMINRATIO	)	);
//		nowDTO.setNowWINDOW_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.WINDOW	)	);
//		nowDTO.getNowCANDLE_AREA_SCALE_01();
		//何営業日前まで遡るか。
		int loopCount = 20;
		//いくつあればノーとするか
		int pointResult = 10;
		int countPoint = 0;
		//過去の営業日を調べて急落しているときはトレードをしない


			try{
				for (int n = 0 ; n < loopCount ; n++){
					if (nowDTOList.get(nowDTOadress - n ).getNowCHANGERATE_01() <= paraDTO.getDoubleCount() ){
						countPoint++;
					}
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return Technique98_CONST.NO_GAME;
			}catch(IndexOutOfBoundsException a){
				return Technique98_CONST.NO_GAME;
			}

		if (countPoint >= pointResult){
			return Technique98_CONST.NO_GAME;
		}

		if ( nowDTO.getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_S_OVER0_KYURAKU(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}


	public static int MACD_M_L_beforeDay(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {
//
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		for (int n = 0 ; n < 10 ; n++){
//			Bean_nowRecord checkDTO = nowDTOList.get(nowDTOadress - n );


			try{
				if (nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_01() >= nowDTOList.get(nowDTOadress - n ).getNowMIDDLE_MACD_SIGNAL_01() ){
//				if (checkDTO.getNowMIDDLE_MACD_01() >= checkDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

//					System.out.println(nowDTO.getCode_01() +":" + nowDTO.getNowDay_01() + ":" + nowDTOList.get(nowDTOadress - 0 ).getNowDay_01() + ":" + nowDTOList.get(nowDTOadress - 1 ).getNowDay_01() + ":" + nowDTOList.get(nowDTOadress - 2 ).getNowDay_01() + ":" + nowDTOList.get(nowDTOadress - 3 ).getNowDay_01());
					return Technique98_CONST.NO_GAME;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return Technique98_CONST.NO_GAME;
			}catch(IndexOutOfBoundsException a){
				return Technique98_CONST.NO_GAME;
			}

		}


		try{

			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}catch(ArrayIndexOutOfBoundsException e){
			return Technique98_CONST.NO_GAME;
		}catch(IndexOutOfBoundsException a){
			return Technique98_CONST.NO_GAME;
		}


		return Technique98_CONST.TRADE_FLG;

//		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
//
//			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//
//			return Technique98_CONST.TRADE_FLG;
//		}
//
//
//
//
//
//		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_S_14_beforeDay(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{

			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



//
//		if ( 0 > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
//			return Technique98_CONST.NO_GAME;
//		}

		if ( 0 > nowDTO.getNowMIDDLE_MACD_01() ){
			return Technique98_CONST.NO_GAME;
		}


//		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}

	public static int MACD_M_L_SMALL(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		//値段が高そうな奴は弾く
		if (nowDTO.getNowCLOSE_01() > 1500){
			return Technique98_CONST.NO_GAME;
		}
		return MACD_M_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
	}


	public static int MACD_M_L_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


		//選ばれた銘柄のみ売買判断をする。
		
		if ( paraDTO.getEliteFLG()){
			switch (nowDTO.getCode_01()) {
			case "1352―T":
				break;
			case "1377―T":
				break;
			case "1605―T":
				break;
			case "1712―T":
				break;
			case "1720―T":
				break;
			case "1762―T":
				break;
			case "1802―T":
				break;
			case "1824―T":
				break;
			case "1827―T":
				break;
			case "1866―T":
				break;
			case "1881―T":
				break;
			case "1883―T":
				break;
			case "1898―T":
				break;
			case "1911―T":
				break;
			case "1914―T":
				break;
			case "1924―T":
				break;
			case "1925―T":
				break;
			case "1930―T":
				break;
			case "1934―T":
				break;
			case "1938―T":
				break;
			case "1944―T":
				break;
			case "1950―T":
				break;
			case "1956―T":
				break;
			case "1964―T":
				break;
			case "1972―T":
				break;
			case "1973―T":
				break;
			case "1975―T":
				break;
			case "1979―T":
				break;
			case "1982―T":
				break;
			case "1983―T":
				break;
			case "2001―T":
				break;
			case "2003―T":
				break;
			case "2004―T":
				break;
			case "2009―T":
				break;
			case "2053―T":
				break;
			case "2058―F":
				break;
			case "2107―T":
				break;
			case "2114―T":
				break;
			case "2151―T":
				break;
			case "2168―T":
				break;
			case "2201―T":
				break;
			case "2204―T":
				break;
			case "2206―T":
				break;
			case "2207―T":
				break;
			case "2208―T":
				break;
			case "2209―T":
				break;
			case "2264―T":
				break;
			case "2288―T":
				break;
			case "2305―T":
				break;
			case "2345―T":
				break;
			case "2371―T":
				break;
			case "2379―T":
				break;
			case "2393―T":
				break;
			case "2395―T":
				break;
			case "2413―T":
				break;
			case "2438―T":
				break;
			case "2579―T":
				break;
			case "2594―T":
				break;
			case "2607―T":
				break;
			case "2608―T":
				break;
			case "2652―T":
				break;
			case "2670―T":
				break;
			case "2676―T":
				break;
			case "2681―T":
				break;
			case "2692―T":
				break;
			case "2695―T":
				break;
			case "2780―T":
				break;
			case "2798―T":
				break;
			case "2802―T":
				break;
			case "2805―T":
				break;
			case "2806―T":
				break;
			case "2809―T":
				break;
			case "2818―T":
				break;
			case "2871―T":
				break;
			case "2892―T":
				break;
			case "2897―T":
				break;
			case "2907―T":
				break;
			case "2908―T":
				break;
			case "2918―T":
				break;
			case "2922―T":
				break;
			case "2923―T":
				break;
			case "3001―T":
				break;
			case "3021―T":
				break;
			case "3028―T":
				break;
			case "3047―F":
				break;
			case "3064―T":
				break;
			case "3087―T":
				break;
			case "3088―T":
				break;
			case "3107―T":
				break;
			case "3116―T":
				break;
			case "3201―T":
				break;
			case "3226―T":
				break;
			case "3231―T":
				break;
			case "3302―T":
				break;
			case "3333―T":
				break;
			case "3347―T":
				break;
			case "3349―T":
				break;
			case "3360―T":
				break;
			case "3382―T":
				break;
			case "3397―T":
				break;
			case "3551―T":
				break;
			case "3580―T":
				break;
			case "3591―T":
				break;
			case "3708―T":
				break;
			case "3734―T":
				break;
			case "3738―T":
				break;
			case "3770―T":
				break;
			case "3810―T":
				break;
			case "3817―T":
				break;
			case "3823―T":
				break;
			case "3843―T":
				break;
			case "3861―T":
				break;
			case "3865―T":
				break;
			case "3880―T":
				break;
			case "3946―T":
				break;
			case "3947―T":
				break;
			case "3950―T":
				break;
			case "4023―T":
				break;
			case "4027―T":
				break;
			case "4041―T":
				break;
			case "4045―T":
				break;
			case "4046―T":
				break;
			case "4064―T":
				break;
			case "4186―T":
				break;
			case "4204―T":
				break;
			case "4206―T":
				break;
			case "4208―T":
				break;
			case "4282―T":
				break;
			case "4337―T":
				break;
			case "4401―T":
				break;
			case "4409―T":
				break;
			case "4512―T":
				break;
			case "4514―T":
				break;
			case "4516―T":
				break;
			case "4521―T":
				break;
			case "4523―T":
				break;
			case "4526―T":
				break;
			case "4527―T":
				break;
			case "4531―T":
				break;
			case "4534―T":
				break;
			case "4540―T":
				break;
			case "4544―T":
				break;
			case "4547―T":
				break;
			case "4549―T":
				break;
			case "4553―T":
				break;
			case "4559―T":
				break;
			case "4569―T":
				break;
			case "4612―T":
				break;
			case "4633―T":
				break;
			case "4651―T":
				break;
			case "4653―T":
				break;
			case "4665―T":
				break;
			case "4666―T":
				break;
			case "4668―T":
				break;
			case "4674―T":
				break;
			case "4687―T":
				break;
			case "4689―T":
				break;
			case "4694―T":
				break;
			case "4704―T":
				break;
			case "4708―T":
				break;
			case "4716―T":
				break;
			case "4719―T":
				break;
			case "4722―T":
				break;
			case "4726―T":
				break;
			case "4743―T":
				break;
			case "4767―T":
				break;
			case "4781―T":
				break;
			case "4812―T":
				break;
			case "4824―T":
				break;
			case "4825―T":
				break;
			case "4826―T":
				break;
			case "4834―S":
				break;
			case "4911―T":
				break;
			case "4914―T":
				break;
			case "4917―T":
				break;
			case "4924―T":
				break;
			case "4967―T":
				break;
			case "4968―T":
				break;
			case "4985―T":
				break;
			case "4989―T":
				break;
			case "4990―T":
				break;
			case "4997―T":
				break;
			case "5196―T":
				break;
			case "5352―T":
				break;
			case "5363―T":
				break;
			case "5410―T":
				break;
			case "5423―T":
				break;
			case "5440―T":
				break;
			case "5449―T":
				break;
			case "5451―T":
				break;
			case "5471―T":
				break;
			case "5541―T":
				break;
			case "5713―T":
				break;
			case "5805―T":
				break;
			case "5809―T":
				break;
			case "5902―T":
				break;
			case "5933―T":
				break;
			case "5942―T":
				break;
			case "5947―T":
				break;
			case "5949―T":
				break;
			case "5951―T":
				break;
			case "5959―T":
				break;
			case "5974―T":
				break;
			case "5981―T":
				break;
			case "5988―T":
				break;
			case "6273―T":
				break;
			case "6316―T":
				break;
			case "6326―T":
				break;
			case "6340―T":
				break;
			case "6355―T":
				break;
			case "6356―T":
				break;
			case "6360―T":
				break;
			case "6369―T":
				break;
			case "6370―T":
				break;
			case "6373―T":
				break;
			case "6378―T":
				break;
			case "6412―T":
				break;
			case "6418―T":
				break;
			case "6455―T":
				break;
			case "6457―T":
				break;
			case "6479―T":
				break;
			case "6594―T":
				break;
			case "6651―T":
				break;
			case "6676―T":
				break;
			case "6702―T":
				break;
			case "6718―T":
				break;
			case "6741―T":
				break;
			case "6745―T":
				break;
			case "6762―T":
				break;
			case "6770―T":
				break;
			case "6771―T":
				break;
			case "6776―T":
				break;
			case "6809―T":
				break;
			case "6823―T":
				break;
			case "6848―T":
				break;
			case "6849―T":
				break;
			case "6853―T":
				break;
			case "6857―T":
				break;
			case "6861―T":
				break;
			case "6866―T":
				break;
			case "6869―T":
				break;
			case "6875―T":
				break;
			case "6901―T":
				break;
			case "6929―T":
				break;
			case "6935―T":
				break;
			case "6973―T":
				break;
			case "6989―T":
				break;
			case "7213―T":
				break;
			case "7222―T":
				break;
			case "7238―T":
				break;
			case "7274―T":
				break;
			case "7282―T":
				break;
			case "7441―F":
				break;
			case "7451―T":
				break;
			case "7453―T":
				break;
			case "7455―T":
				break;
			case "7459―T":
				break;
			case "7476―T":
				break;
			case "7504―T":
				break;
			case "7518―T":
				break;
			case "7522―T":
				break;
			case "7532―T":
				break;
			case "7545―T":
				break;
			case "7550―T":
				break;
			case "7552―T":
				break;
			case "7554―T":
				break;
			case "7561―T":
				break;
			case "7601―T":
				break;
			case "7616―T":
				break;
			case "7649―T":
				break;
			case "7723―T":
				break;
			case "7862―T":
				break;
			case "7864―T":
				break;
			case "7893―T":
				break;
			case "7912―T":
				break;
			case "7915―T":
				break;
			case "7916―T":
				break;
			case "7920―T":
				break;
			case "7937―T":
				break;
			case "7947―T":
				break;
			case "7955―T":
				break;
			case "7956―T":
				break;
			case "7962―T":
				break;
			case "7976―T":
				break;
			case "8001―T":
				break;
			case "8005―T":
				break;
			case "8008―T":
				break;
			case "8022―T":
				break;
			case "8058―T":
				break;
			case "8059―T":
				break;
			case "8060―T":
				break;
			case "8081―T":
				break;
			case "8089―T":
				break;
			case "8105―T":
				break;
			case "8113―T":
				break;
			case "8114―T":
				break;
			case "8131―T":
				break;
			case "8132―T":
				break;
			case "8140―T":
				break;
			case "8142―T":
				break;
			case "8153―T":
				break;
			case "8160―T":
				break;
			case "8168―T":
				break;
			case "8173―T":
				break;
			case "8174―T":
				break;
			case "8182―T":
				break;
			case "8185―T":
				break;
			case "8194―T":
				break;
			case "8200―T":
				break;
			case "8203―T":
				break;
			case "8207―T":
				break;
			case "8237―T":
				break;
			case "8248―T":
				break;
			case "8274―T":
				break;
			case "8278―T":
				break;
			case "8279―T":
				break;
			case "8289―T":
				break;
			case "8324―T":
				break;
			case "8341―T":
				break;
			case "8342―T":
				break;
			case "8344―T":
				break;
			case "8345―T":
				break;
			case "8346―T":
				break;
			case "8350―T":
				break;
			case "8355―T":
				break;
			case "8361―T":
				break;
			case "8362―T":
				break;
			case "8364―T":
				break;
			case "8367―T":
				break;
			case "8368―T":
				break;
			case "8369―T":
				break;
			case "8382―T":
				break;
			case "8383―T":
				break;
			case "8385―T":
				break;
			case "8386―T":
				break;
			case "8388―T":
				break;
			case "8396―T":
				break;
			case "8397―T":
				break;
			case "8399―T":
				break;
			case "8418―T":
				break;
			case "8424―T":
				break;
			case "8425―T":
				break;
			case "8519―T":
				break;
			case "8522―T":
				break;
			case "8529―T":
				break;
			case "8530―T":
				break;
			case "8540―F":
				break;
			case "8554―F":
				break;
			case "8559―F":
				break;
			case "8566―T":
				break;
			case "8572―T":
				break;
			case "8601―T":
				break;
			case "8609―T":
				break;
			case "8622―T":
				break;
			case "8628―T":
				break;
			case "8707―T":
				break;
			case "8729―T":
				break;
			case "8806―T":
				break;
			case "8842―T":
				break;
			case "8952―T":
				break;
			case "8955―T":
				break;
			case "8957―T":
				break;
			case "8958―T":
				break;
			case "8964―T":
				break;
			case "8967―T":
				break;
			case "8975―T":
				break;
			case "8987―T":
				break;
			case "9001―T":
				break;
			case "9003―T":
				break;
			case "9006―T":
				break;
			case "9007―T":
				break;
			case "9009―T":
				break;
			case "9010―T":
				break;
			case "9014―T":
				break;
			case "9017―T":
				break;
			case "9021―T":
				break;
			case "9022―T":
				break;
			case "9031―T":
				break;
			case "9037―T":
				break;
			case "9041―T":
				break;
			case "9045―T":
				break;
			case "9059―T":
				break;
			case "9065―T":
				break;
			case "9070―T":
				break;
			case "9081―T":
				break;
			case "9086―T":
				break;
			case "9110―T":
				break;
			case "9115―T":
				break;
			case "9193―T":
				break;
			case "9302―T":
				break;
			case "9304―T":
				break;
			case "9310―T":
				break;
			case "9311―T":
				break;
			case "9324―T":
				break;
			case "9360―T":
				break;
			case "9361―T":
				break;
			case "9404―T":
				break;
			case "9449―T":
				break;
			case "9504―T":
				break;
			case "9505―T":
				break;
			case "9506―T":
				break;
			case "9507―T":
				break;
			case "9509―T":
				break;
			case "9533―T":
				break;
			case "9536―T":
				break;
			case "9602―T":
				break;
			case "9612―T":
				break;
			case "9621―T":
				break;
			case "9628―T":
				break;
			case "9629―T":
				break;
			case "9632―T":
				break;
			case "9633―T":
				break;
			case "9681―T":
				break;
			case "9697―T":
				break;
			case "9717―T":
				break;
			case "9719―T":
				break;
			case "9735―T":
				break;
			case "9740―T":
				break;
			case "9742―T":
				break;
			case "9755―T":
				break;
			case "9759―T":
				break;
			case "9783―T":
				break;
			case "9788―T":
				break;
			case "9843―T":
				break;
			case "9887―T":
				break;
			case "9889―T":
				break;
			case "9896―T":
				break;
			case "9900―T":
				break;
			case "9902―T":
				break;
			case "9919―T":
				break;
			case "9948―T":
				break;
			case "9957―T":
				break;
			case "9959―T":
				break;
			case "9966―T":
				break;
			case "9979―T":
				break;
			case "9982―T":
				break;
			case "9983―T":
				break;
			case "9984―T":
				break;
			case "9989―T":
				break;
			case "9991―T":
				break;
			case "9993―T":
				break;
			case "I202":
				break;
			case "I206":
				break;
			case "I219":
				break;
			case "I226":
				break;

			default:
				return Technique98_CONST.NO_GAME;
			}
		}



		if ( P_MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG ){

			//RUMフラグがtrueだったら一定確率でノーゲームを返す。
			if ( paraDTO.getRumFLG() ) {
				//Randomクラスのインスタンス化
		        Random rnd = new Random();
		        int ran = rnd.nextInt(paraDTO.getRumNumber()) + 1;
		        if ( ran != paraDTO.getRumNumber()){
		        	return Technique98_CONST.NO_GAME;
		        }
			}

			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}

	private static int P_MACD_M_L_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if ( nowDTO.getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}

	public static int MACD_M_S_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}



	public static int MACD_M_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if ( judge ) {
//
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}


//		if (Technique00_Common.checkKeepDay_Prise_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}

		//出来高があんまりにも少ないのは減らす
//		if (nowDTO.getNowDEKI_01() > 20000){
//			return Technique98_CONST.NO_GAME;
//		}
//
//		if (nowDTO.getNowDEKI_01() < 1000){
//			return Technique98_CONST.NO_GAME;
//		}
//
//		if (nowDTO.getNowCLOSE_01() > 1000){
//			return Technique98_CONST.NO_GAME;
//		}



//// TODO ＜MACDの買いシグナル＞
//		MACDがプラスマイナス０を下から上にぬく（順張り）
//		マイナス圏でMACDがMACDシグナルを下から上にぬく（逆張り）
//		＜MACDの売りシグナル＞
//		MACDがプラスマイナス０を上から下にぬく（順張り）
//		プラス圏でMACDがMACDシグナルを上から下にぬく（逆張り）
//MACDがプラスマイナス０の数値をぬく場合は、そのトレンドがさらに継続する

//		if ( nowDTO.getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
//		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

			return Technique98_CONST.TRADE_FLG;
		}





		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}




//
//		if ( 0 > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
//			return Technique98_CONST.NO_GAME;
//		}
//
//		if ( 0 > nowDTO.getNowMIDDLE_MACD_01() ){
//			return Technique98_CONST.NO_GAME;
//		}


		//
//		if (Technique00_Common.checkKeepDay_Prise_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}

//		//損切
//		if (paraDTO.getLoseWariai() * resultDTO.getEntryAveragePrice() > nowDTO.getNowMIN_01() ){
//			nowDTO.setKessaiDay(nowDTO.getNowDay_01());
//			nowDTO.setKessaiKingaku(paraDTO.getLoseWariai() * resultDTO.getEntryAveragePrice());
//			return Technique98_CONST.TRADE_FLG;
//		}
//
//		//キープデイ
//		if ( Technique00_Common.checkKeepDay_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
//			return Technique98_CONST.TRADE_FLG;
//		}

//		損切とか
//		if ( Technique00_Common.checkPrice_S(paraDTO, nowDTO, resultDTO, judge) == Technique98_CONST.TRADE_FLG ){
//			return Technique98_CONST.TRADE_FLG;
//		};

//		return Technique00_Common.checkPrice_S(paraDTO, nowDTO, resultDTO, judge);

//		if ( nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
//		nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//		nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
//			return Technique98_CONST.TRADE_FLG;
//		}

//		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
//		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}


	public static int MACD_M_S_14(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {
			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{

			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}



//
//		if ( 0 > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
//			return Technique98_CONST.NO_GAME;
//		}

		if ( 0 > nowDTO.getNowMIDDLE_MACD_01() ){
			return Technique98_CONST.NO_GAME;
		}


//		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}


		return Technique98_CONST.NO_GAME;

	}



}
