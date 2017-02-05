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

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

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


		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


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

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;

	}

	public static int testL(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}


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
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;
	}

	public static int testS(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		if ( MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_L_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowSHORT_3_H_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_M_L_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

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
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int MACD_M_S_OVER0_BORIBAN(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}

		if ( judge ) {

			if (Technique00_Common.common_Stopper_L(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.NO_GAME){return Technique98_CONST.NO_GAME;}
		}else{
			if (Technique00_Common.common_Stopper_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) ==  Technique98_CONST.TRADE_FLG){return Technique98_CONST.TRADE_FLG;}
		}

		if (nowDTO.getNowSHORT_3_L_SIGMA_01() > nowDTO.getNowCLOSE_01() * 1.1 ) {
			return Technique98_CONST.NO_GAME;
		}

		if ( MACD_M_S_OVER0(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

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

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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

//		nowDTO.setKeepDay(resultDTO.getKeepCount());

//		if (nowDTO.getKeepDay() > 30){
//
//		}


		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){
			case "technique.Technique04.MACD_M_S_OVER0":
				switch( nowDTO.getCode_01() ){
				case "1824―T":
					break;
				case "1884―T":
					break;
				case "1979―T":
					break;
				case "1982―T":
					break;
				case "2181―T":
					break;
				case "2413―T":
					break;
				case "2432―T":
					break;
				case "2492―T":
					break;
				case "2670―T":
					break;
				case "3110―T":
					break;
				case "3391―T":
					break;
				case "3865―T":
					break;
				case "4619―T":
					break;
				case "4704―T":
					break;
				case "4967―T":
					break;
				case "4989―T":
					break;
				case "5105―T":
					break;
				case "5192―T":
					break;
				case "5423―T":
					break;
				case "5707―T":
					break;
				case "5714―T":
					break;
				case "5949―T":
					break;
				case "6273―T":
					break;
				case "6373―T":
					break;
				case "6504―T":
					break;
				case "6586―T":
					break;
				case "6718―T":
					break;
				case "6724―T":
					break;
				case "6856―T":
					break;
				case "6869―T":
					break;
				case "6954―T":
					break;
				case "6988―T":
					break;
				case "7259―T":
					break;
				case "7463―T":
					break;
				case "7550―T":
					break;
				case "7733―T":
					break;
				case "7844―T":
					break;
				case "7966―T":
					break;
				case "8111―T":
					break;
				case "8114―T":
					break;
				case "8584―T":
					break;
				case "8729―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "9787―T":
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
				case "1801―T":
					break;
				case "1802―T":
					break;
				case "1824―T":
					break;
				case "1950―T":
					break;
				case "1979―T":
					break;
				case "2109―T":
					break;
				case "2181―T":
					break;
				case "2359―T":
					break;
				case "2371―T":
					break;
				case "2432―T":
					break;
				case "2659―T":
					break;
				case "2871―T":
					break;
				case "3110―T":
					break;
				case "3151―T":
					break;
				case "3360―T":
					break;
				case "3391―T":
					break;
				case "3569―T":
					break;
				case "3580―T":
					break;
				case "3734―T":
					break;
				case "3865―T":
					break;
				case "4095―T":
					break;
				case "4452―T":
					break;
				case "4619―T":
					break;
				case "4704―T":
					break;
				case "4751―T":
					break;
				case "4775―T":
					break;
				case "4825―T":
					break;
				case "4924―T":
					break;
				case "4967―T":
					break;
				case "4989―T":
					break;
				case "5105―T":
					break;
				case "5195―T":
					break;
				case "5352―T":
					break;
				case "5393―T":
					break;
				case "5423―T":
					break;
				case "5440―T":
					break;
				case "5491―T":
					break;
				case "5541―T":
					break;
				case "5707―T":
					break;
				case "5911―T":
					break;
				case "5949―T":
					break;
				case "6272―T":
					break;
				case "6273―T":
					break;
				case "6282―T":
					break;
				case "6315―T":
					break;
				case "6326―T":
					break;
				case "6355―T":
					break;
				case "6586―T":
					break;
				case "6718―T":
					break;
				case "6724―T":
					break;
				case "6849―T":
					break;
				case "6856―T":
					break;
				case "6869―T":
					break;
				case "6954―T":
					break;
				case "6985―T":
					break;
				case "7202―T":
					break;
				case "7259―T":
					break;
				case "7276―T":
					break;
				case "7451―T":
					break;
				case "7463―T":
					break;
				case "7649―T":
					break;
				case "7733―T":
					break;
				case "7769―T":
					break;
				case "7905―T":
					break;
				case "7915―T":
					break;
				case "7937―T":
					break;
				case "7955―T":
					break;
				case "7966―T":
					break;
				case "7988―T":
					break;
				case "8015―T":
					break;
				case "8031―T":
					break;
				case "8085―T":
					break;
				case "8114―T":
					break;
				case "8174―T":
					break;
				case "8278―T":
					break;
				case "8289―T":
					break;
				case "8338―T":
					break;
				case "8397―T":
					break;
				case "8424―T":
					break;
				case "8425―T":
					break;
				case "8584―T":
					break;
				case "8729―T":
					break;
				case "8841―T":
					break;
				case "8871―T":
					break;
				case "9533―T":
					break;
				case "9602―T":
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
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);

		}

		return Technique98_CONST.NO_GAME;
	}

	private static int P_MACD_M_L_OVER0(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if ( nowDTO.getNowMIDDLE_MACD_01() > 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() > 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() < nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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

//		if (resultDTO.getKeepCount() >= 5){
//			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//			return Technique98_CONST.TRADE_FLG;
//		}

		if ( nowDTO.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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


		if ( paraDTO.getEliteFLG(judge) ){
			switch(paraDTO.getSMETHOD()){

			case "technique.Technique04.MACD_M_S_OVER0":
				switch( nowDTO.getCode_01() ){
				case "2326―T":
					break;

				case "2371―T":
					break;

				case "2427―T":
					break;

				case "3179―T":
					break;

				case "3359―F":
					break;

				case "3654―T":
					break;

				case "3844―T":
					break;

				case "4293―T":
					break;

				case "6055―T":
					break;

				case "6058―T":
					break;
				default:
					return Technique98_CONST.NO_GAME;
				}

				break;
			case "technique.Technique08.MACD_IDOHEIKIN_S":
				switch( nowDTO.getCode_01() ){
				case "2326―T":
					break;
				case "2371―T":
					break;
				case "2427―T":
					break;
				case "3092―T":
					break;
				case "3179―T":
					break;
				case "3359―F":
					break;
				case "3647―T":
					break;
				case "3654―T":
					break;
				case "3844―T":
					break;
				case "4290―T":
					break;
				case "6050―T":
					break;
				case "6055―T":
					break;
				case "6058―T":
					break;
				case "7240―T":
					break;
				case "8085―T":
					break;
				case "8876―T":
					break;
				case "8920―T":
					break;

				default:
					return Technique98_CONST.NO_GAME;
				}

				break;
			default:
				return Technique98_CONST.NO_GAME;

			}
		}

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


			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}





		return Technique98_CONST.NO_GAME;
	}

	public static int MACD_M_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

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

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
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

			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}


		return Technique98_CONST.NO_GAME;

	}



}
