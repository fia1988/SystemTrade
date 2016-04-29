package accesarrySQL;

import proparty.S;
import constant.ReCord;


public class OneRecord_Update {

	//前日など参照せず、一行のレコードのみで比較できるもの
	public static void OneRecord(S s){

		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		String TBL="";
		switch(TBL){
		case ReCord.CODE_01_STOCK:

			break;
		case ReCord.CODE_02_SATISTICS:

			break;
		case ReCord.CODE_03_INDEX:

			break;
		case ReCord.CODE_04_ETF:

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:

			break;
		}
//		int num=0;
//
//		String SQL;
//
//		//MACDシグナルを作る。
//		SQL = " update "
//			+ TBL
//			+ " set "
//			+ COLUMN.SHORT_MACD  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.MIDDLEIDO_HEKATU + ","
//			+ COLUMN.MIDDLE_MACD + " = " + COLUMN.MIDDLEIDO_HEKATU + " - " + COLUMN.LONGIDO_HEKATU	 + ","
//			+ COLUMN.LONG_MACD   + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + COLUMN.LONGIDO_HEKATU	 + ""
//			+ " where "
//			+ COLUMN.DAYTIME
//			+ " = '" + dayTime + "'"
//			+ " and "
//			+ COLUMN.CODE
//			+ " ='" + code + "'";
//
//		try {
//			s.sqlGetter().executeUpdate(SQL);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
	}

}
