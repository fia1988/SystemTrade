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
			case "1312_T":

				break;
			case "1323_T":

				break;

			case "1333_T":

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


	public static int MACD_M_S_OVER0_testbefore(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		Bean_nowRecord nowDTO_1;
		Bean_nowRecord nowDTO_2;
		try {
			nowDTO_1 = nowDTOList.get(nowDTOadress-1);
			nowDTO_2 = nowDTOList.get(nowDTOadress-2);
		}catch(Exception e){
			return Technique98_CONST.NO_GAME;
		}
//		System.out.println("今日　:"+nowDTO.getNowDay_01());
//		System.out.println("前日　:"+nowDTO_1.getNowDay_01());
//		System.out.println("前々日:"+nowDTO_2.getNowDay_01());

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



		if ( nowDTO_1.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO_1.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}



		if ( nowDTO_2.getNowMIDDLE_MACD_01() < 0 ){return Technique98_CONST.NO_GAME;}
		if ( nowDTO_2.getNowMIDDLE_MACD_SIGNAL_01() < 0 ){return Technique98_CONST.NO_GAME;}

		if (nowDTO_2.getNowMIDDLE_MACD_01() > nowDTO_2.getNowMIDDLE_MACD_SIGNAL_01() ){
			if (nowDTO_1.getNowMIDDLE_MACD_01() > nowDTO_1.getNowMIDDLE_MACD_SIGNAL_01() ){
				if (nowDTO.getNowMIDDLE_MACD_01() > nowDTO.getNowMIDDLE_MACD_SIGNAL_01() ){
					return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
				}
			}
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
