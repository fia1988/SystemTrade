package accesarrySQL;

import java.sql.SQLException;

import proparty.S;
import proparty.controllDay;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;


public class OneRecord_Update {

	//前日など参照せず、一行のレコードのみで比較できるもの
	public static void OneRecord(S s){

		if(commonAP.getTODAY().equals(controllDay.getMAX_DD_STOCK_ETF(s) )){
			return;
		}
		windowScale(ReCord.CODE_01_STOCK,s);
		windowScale(ReCord.CODE_03_INDEX,s);
		windowScale(ReCord.CODE_04_ETF,s);

	}


	private static void windowScale(String cate,S s){

//		+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
//		+ COLUMN.MAXMINRATIO_KATA							 + " , " //（1-最安値)/最高値
//		+ COLUMN.CANDLE_AREA_KATA							 + " , " //ローソク足の面積
//		+ COLUMN.CANDLE_AREA_SCALE_KATA						 + " , " //ひげの長さと比較したローソク足面積の比率



		String SQL ="";
		try {
			//個別銘柄・・・1
			//統計・・・2
			//指数・・・3
			//ETF・・・4
			//先物・・・5
			//通貨・・・6
			String targetCOMUMN = COLUMN.MAXMIN				+ " = " + COLUMN.MAX + " - " + COLUMN.MIN							+ " , "
								+ COLUMN.MAXMINRATIO		+ " = " + " ( 1 -  (" + COLUMN.MIN + "/" + COLUMN.MAX + "  ) )"		+ " , "
								+ COLUMN.CANDLE_AREA		+ " = " + COLUMN.CLOSE + " - " + COLUMN.OPEN						+ " , "
								+ COLUMN.CANDLE_AREA_SCALE	+ " = " + "( (" +  COLUMN.CLOSE + " - " + COLUMN.OPEN + ") / (" + COLUMN.MAX + " - " + COLUMN.MIN + ") )";
			switch(cate){
			case ReCord.CODE_01_STOCK:

				break;
			case ReCord.CODE_02_SATISTICS:

				return;
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

			String omake = "";
			omake =  " and "	 + COLUMN.DAYTIME + " > '2016-06-30'";

			SQL = " update " + SQLChecker.getTBL(cate)
			+ " set "
			+ targetCOMUMN
			+ " where "
			+ COLUMN.MAXMIN + " is null " + omake;

//			SQL = " update " + SQLChecker.getTBL(cate)
//					+ " set "
//					+ targetCOMUMN
//					+ " where "
//+ COLUMN.DAYTIME + " > '2016-06-30'";

			s.sqlGetter().executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
