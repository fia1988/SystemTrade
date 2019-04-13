package accesarrySQL;

import java.sql.ResultSet;

import proparty.S;
import proparty.TBL_Name;
import constant.AccesarryParameta;
import constant.COLUMN_TBL;
import constant.ReCord;

//MACD
public class MACD_SIGNAL extends Super_IDO_HEKIN {
	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	public static void setIDOHeikinMACD_signal(String code,String cate,String dayTime,S s){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setMACD_signal_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setMACD_signal_2_Statistics(code,TBL_Name.STATISTICS_DD, dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setMACD_signal_3_Index(code,TBL_Name.INDEX_DD,dayTime,s);
			break;
		case ReCord.CODE_04_ETF:
			setMACD_signal_4_ETF(code,TBL_Name.ETF_DD,dayTime,s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setMACD_signal_5_SAKIMONO(code,TBL_Name.SAKIMONO_DD,dayTime,s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setMACD_signal_6_Currency(code,TBL_Name.CURRENCY_DD,dayTime,s);
			break;
		default:
			System.out.println("setIDOHeikinMACDなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}



	private static void setMACD_signal_1_Stock(String code,String TBL,String dayTime,S s){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s);
	}


	private static void setMACD_signal_2_Statistics(String code,String TBL,String dayTime,S s){

	}


	private static void setMACD_signal_3_Index(String code,String TBL,String dayTime,S s){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s);
	}


	private static void setMACD_signal_4_ETF(String code,String TBL,String dayTime,S s){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s);
	}

	private static void setMACD_signal_5_SAKIMONO(String code,String TBL,String dayTime,S s){

	}


	private static void setMACD_signal_6_Currency(String code,String TBL,String dayTime,S s){

	}


























	public static void setIDOHeikinMACD_signal(String code,String cate,String dayTime,S s,ResultSet EDIT){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setMACD_signal_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_02_SATISTICS:
			setMACD_signal_2_Statistics(code,TBL_Name.STATISTICS_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_03_INDEX:
			setMACD_signal_3_Index(code,TBL_Name.INDEX_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_04_ETF:
			setMACD_signal_4_ETF(code,TBL_Name.ETF_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setMACD_signal_5_SAKIMONO(code,TBL_Name.SAKIMONO_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_06_CURRENCY:
			setMACD_signal_6_Currency(code,TBL_Name.CURRENCY_DD,dayTime,s,EDIT);
			break;
		default:
			System.out.println("setIDOHeikinMACDなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}



	private static void setMACD_signal_1_Stock(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s,EDIT);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s,EDIT);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s,EDIT);
	}


	private static void setMACD_signal_2_Statistics(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	private static void setMACD_signal_3_Index(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s,EDIT);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s,EDIT);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s,EDIT);
	}


	private static void setMACD_signal_4_ETF(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//MACDshort
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.SHORT_MACD_SIGNAL),(COLUMN_TBL.SHORT_MACD), s,EDIT);
		//MACDmiddle
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.MIDDLE_MACD_SIGNAL),(COLUMN_TBL.MIDDLE_MACD), s,EDIT);
		//MACDlong
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.MACD_SIGNAL, (COLUMN_TBL.LONG_MACD_SIGNAL),(COLUMN_TBL.LONG_MACD), s,EDIT);
	}

	private static void setMACD_signal_5_SAKIMONO(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	private static void setMACD_signal_6_Currency(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}

}
