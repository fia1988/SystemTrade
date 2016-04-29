package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN;
import constant.ReCord;

public class MACD {


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	public static void setMACD(String code,String cate,String dayTime,S s){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setMACD_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setMACD_2_Statistics(code,TBL_Name.STATISTICS_DD, dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setMACD_3_Index(code,TBL_Name.INDEX_DD,dayTime,s);
			break;
		case ReCord.CODE_04_ETF:
			setMACD_4_ETF(code,TBL_Name.ETF_DD,dayTime,s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setMACD_5_SAKIMONO(code,TBL_Name.SAKIMONO_DD,dayTime,s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setMACD_6_Currency(code,TBL_Name.CURRENCY_DD,dayTime,s);
			break;
		default:
			System.out.println("setIDOHeikinMACDなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	private static void setMACD_1_Stock(String code,String TBL,String dayTime,S s){
		setMACD_base(code,TBL,dayTime,s);
	}


	private static void setMACD_2_Statistics(String code,String TBL,String dayTime,S s){

	}


	private static void setMACD_3_Index(String code,String TBL,String dayTime,S s){
		setMACD_base(code,TBL,dayTime,s);
	}


	private static void setMACD_4_ETF(String code,String TBL,String dayTime,S s){
		setMACD_base(code,TBL,dayTime,s);
	}

	private static void setMACD_5_SAKIMONO(String code,String TBL,String dayTime,S s){

	}


	private static void setMACD_6_Currency(String code,String TBL,String dayTime,S s){

	}



	private static void setMACD_base(String code,String TBL,String dayTime,S s){
		String SQL;


		//MACDシグナルを作る。
		SQL = " update "
			+ TBL
			+ " set "
			+ COLUMN.SHORT_MACD  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.MIDDLEIDO_HEKATU + ","
			+ COLUMN.MIDDLE_MACD + " = " + COLUMN.MIDDLEIDO_HEKATU + " - " + COLUMN.LONGIDO_HEKATU	 + ","
			+ COLUMN.LONG_MACD   + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.LONGIDO_HEKATU	 + ""
			+ " where "
			+ COLUMN.DAYTIME
			+ " = '" + dayTime + "'"
			+ " and "
			+ COLUMN.CODE
			+ " ='" + code + "'";

		try {

			s.sqlGetter().executeUpdate(SQL);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}
















	public static void setMACD(String code,String cate,String dayTime,S s,ResultSet EDIT){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setMACD_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_02_SATISTICS:
			setMACD_2_Statistics(code,TBL_Name.STATISTICS_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_03_INDEX:
			setMACD_3_Index(code,TBL_Name.INDEX_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_04_ETF:
			setMACD_4_ETF(code,TBL_Name.ETF_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setMACD_5_SAKIMONO(code,TBL_Name.SAKIMONO_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_06_CURRENCY:
			setMACD_6_Currency(code,TBL_Name.CURRENCY_DD,dayTime,s,EDIT);
			break;
		default:
			System.out.println("setIDOHeikinMACDなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	private static void setMACD_1_Stock(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		setMACD_base(code,TBL,dayTime,s,EDIT);
	}


	private static void setMACD_2_Statistics(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	private static void setMACD_3_Index(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		setMACD_base(code,TBL,dayTime,s,EDIT);
	}


	private static void setMACD_4_ETF(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		setMACD_base(code,TBL,dayTime,s,EDIT);
	}

	private static void setMACD_5_SAKIMONO(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	private static void setMACD_6_Currency(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}



	private static void setMACD_base(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		String SQL;
		double resultDouble;

		//MACDシグナルを作る。
		SQL = " update "
			+ TBL
			+ " set "
			+ COLUMN.SHORT_MACD  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.MIDDLEIDO_HEKATU + ","
			+ COLUMN.MIDDLE_MACD + " = " + COLUMN.MIDDLEIDO_HEKATU + " - " + COLUMN.LONGIDO_HEKATU	 + ","
			+ COLUMN.LONG_MACD   + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.LONGIDO_HEKATU	 + ""
			+ " where "
			+ COLUMN.DAYTIME
			+ " = '" + dayTime + "'"
			+ " and "
			+ COLUMN.CODE
			+ " ='" + code + "'";

		try {

//			s.sqlGetter().executeUpdate(SQL);
			if (EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU)!=0){
				resultDouble = EDIT.getDouble(COLUMN.SHORTIDO_HEKATU)  - EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU);
				EDIT.updateDouble(COLUMN.SHORT_MACD		,resultDouble);

			}

			if(EDIT.getDouble(COLUMN.LONGIDO_HEKATU)!=0){
				resultDouble = EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) - EDIT.getDouble(COLUMN.LONGIDO_HEKATU);
				EDIT.updateDouble(COLUMN.MIDDLE_MACD	,resultDouble);

					resultDouble = EDIT.getDouble(COLUMN.SHORTIDO_HEKATU)  - EDIT.getDouble(COLUMN.LONGIDO_HEKATU);
					EDIT.updateDouble(COLUMN.LONG_MACD		,resultDouble);

			}






		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}
}
