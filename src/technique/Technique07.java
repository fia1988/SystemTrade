package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique07 {

	public static int torakuRatio_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		switch(nowDTO.getCateflg_01()){
		case ReCord.CODE_01_STOCK:

			break;
		case ReCord.CODE_02_SATISTICS:
			return Technique98_CONST.NO_GAME;

		case ReCord.CODE_03_INDEX:
			return Technique98_CONST.NO_GAME;

		case ReCord.CODE_04_ETF:

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			break;
		}
//		nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01
//		+ COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE_KATA	 + " , " //値上がり短期間移動平均線前日比　※値付き移動平均線
//		+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_KATA	 + " , " //値上がり中期間移動平均線前日比　※値付き移動平均線
//		+ COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE_KATA		 + " , " //値上がり長期間移動平均線前日比　※値付き移動平均線



//		if ( nowDTO.getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01() > 1.5 ){
		if ( nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01() > nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01() ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}


	public static int torakuRatio_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);

		switch(nowDTO.getCateflg_01()){
		case ReCord.CODE_01_STOCK:

			break;
		case ReCord.CODE_02_SATISTICS:
			return Technique98_CONST.NO_GAME;

		case ReCord.CODE_03_INDEX:
			return Technique98_CONST.NO_GAME;

		case ReCord.CODE_04_ETF:

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			break;
		}
//		nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01
//		+ COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE_KATA	 + " , " //値上がり短期間移動平均線前日比　※値付き移動平均線
//		+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_KATA	 + " , " //値上がり中期間移動平均線前日比　※値付き移動平均線
//		+ COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE_KATA		 + " , " //値上がり長期間移動平均線前日比　※値付き移動平均線
//		System.out.println(nowDTO.getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01());


//		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE),(COLUMN.NETUKI_MAXMINRATIO), s,EDIT);
//		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE),(COLUMN.NETUKI_MAXMINRATIO), s,EDIT);
//		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE

//		System.out.println(nowDTO.getNowDay_01()+":" + nowDTO.getCode_01()+ ":"+ nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01());
//		if ( nowDTO.getNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01() < 0.5 ){
		if ( nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01() < nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01() ){
//		if ( nowDTO.getNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01() < 0.5 ){
			return Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
		}

		return Technique98_CONST.NO_GAME;
	}
}
