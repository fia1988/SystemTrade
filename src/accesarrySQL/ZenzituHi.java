package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN_TBL;
import constant.ReCord;

public class ZenzituHi {

	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	public static void setZenzituhi(String code,String cate,String dayTime,S s){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setZenzituhi_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setZenzituhi_2_Statistics(code,TBL_Name.STATISTICS_DD,dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setZenzituhi_3_Index(code,TBL_Name.INDEX_DD, dayTime, s);
			break;
		case ReCord.CODE_04_ETF:
			setZenzituhi_4_ETF(code, TBL_Name.ETF_DD,dayTime, s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setZenzituhi_5_SAKIMONO(code, TBL_Name.SAKIMONO_DD,dayTime, s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setZenzituhi_6_Currency(code, TBL_Name.CURRENCY_DD,dayTime, s);
			break;
		default:
			System.out.println("setZenzituhiMAXMINなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}


	//個別銘柄・・・1
	private static void setZenzituhi_1_Stock(String code,String TBL,String dayTime,S s){
		String SQL;


		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				SQL = " update "
						+ TBL
						+ " set "
						//前日比
						+ COLUMN_TBL.CHANGE_PRICE				  + " = " + COLUMN_TBL.CLOSE + " - " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + ","
						//前日比率
						+ COLUMN_TBL.CHANGERATE					  + " = " + COLUMN_TBL.CLOSE + " / " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_CHANGERATE		  + " = " + COLUMN_TBL.SHORTIDO + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN_TBL.MIDDLEIDO + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN_TBL.LONGIDO_CHANGERATE			  + " = " + COLUMN_TBL.LONGIDO  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_RATIO				  + " = " + COLUMN_TBL.SHORTIDO  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_RATIO			  + " = " + COLUMN_TBL.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_RATIO				  + " = " + COLUMN_TBL.LONGIDO  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + " - 1 " + ","
						//出来高前日比
						+ COLUMN_TBL.DEKI_CHANGERATE			  + " = " + COLUMN_TBL.DEKI + " - " + s.rs.getDouble((COLUMN_TBL.DEKI)) + ","
						//出来高前日比率
						+ COLUMN_TBL.DEKI_RATIO					  + " = " + COLUMN_TBL.DEKI + " / " + s.rs.getDouble((COLUMN_TBL.DEKI)) + " -  1 " + ","
						//売買代金前日比
						+ COLUMN_TBL.BAYBAY_CHANGERATE			  + " = " + COLUMN_TBL.BAYBAY + " - " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + ","
						//売買代金前日比率
						+ COLUMN_TBL.BAYBAY_RATIO				  + " = " + COLUMN_TBL.BAYBAY + " / " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + " -  1 " + ","
						//出来高短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + ","
						//出来高中期移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + ","
						//出来高長期移動平均線前日比
						+ COLUMN_TBL.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + ","
						//出来高短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + " -  1 " + ","
						//出来高中期移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + " -  1 " + ","
						//出来高長期移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_DEKI_RATIO			  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + " -  1 " + ","
						//売買代金短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + ","
						//売買代金中期間移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + ","
						//売買代金長期移動平均線前日比
						+ COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + ","
						//売買代金短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + " -  1 " + ","
						//売買代金中期間移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
						//売買代金長期移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + " -  1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN_TBL.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN_TBL.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN_TBL.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN_TBL.CODE
						+ " ='" + code + "'";

				s.sqlGetter().executeUpdate(SQL);
			}
		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			System.out.println(code + ":" + dayTime + ":" + SQL);
			ea.printStackTrace();
		}

	}



	//統計・・・2
	private static void setZenzituhi_2_Statistics(String code,String TBL,String dayTime,S s){
		String SQL;

		SQL = "select "
				+ COLUMN_TBL.STOCK_GETPRICE + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_LONG + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				SQL = " update "
						+ TBL
						+ " set "

						//値付き前日比
						+ COLUMN_TBL.STOCK_GETPRICE_CHANGERATE			  + " = " + COLUMN_TBL.STOCK_GETPRICE + " - " + s.rs.getInt((COLUMN_TBL.STOCK_GETPRICE)) + ","
						//値付き前日比率
						+ COLUMN_TBL.STOCK_GETPRICE_RATIO				  + " = " + COLUMN_TBL.STOCK_GETPRICE + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE)) + " -  1 " + ","
						//値付き短期間移動平均線前日比
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT_CHANGERATE  + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT)) + ","
						//値付き中期移動平均線前日比
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE)) + ","
						//値付き長期移動平均線前日比
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_LONG_CHANGERATE	  + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_LONG  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG)) + ","
						//値付き短期間移動平均線前日比率
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT_RATIO		  + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT)) + " -  1 " + ","
						//値付き中期移動平均線前日比率
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE_RATIO	  + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE)) + " -  1 " + ","
						//値付き長期移動平均線前日比率
						+ COLUMN_TBL.STOCK_GETPRICE_IDO_LONG_RATIO		  + " = " + COLUMN_TBL.STOCK_GETPRICE_IDO_LONG  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG)) + " -  1 " + ","

				//変わらず前日比
				+ COLUMN_TBL.STOCK_NOCHANGE_CHANGERATE			  + " = " + COLUMN_TBL.STOCK_NOCHANGE + " - " + s.rs.getInt((COLUMN_TBL.STOCK_NOCHANGE)) + ","
				//変わらず前日比率
				+ COLUMN_TBL.STOCK_NOCHANGE_RATIO				  + " = " + COLUMN_TBL.STOCK_NOCHANGE + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE)) + " -  1 " + ","
				//変わらず短期間移動平均線前日比
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE  + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT)) + ","
				//変わらず中期移動平均線前日比
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE)) + ","
				//変わらず長期移動平均線前日比
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG_CHANGERATE	  + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG  + " - " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG)) + ","
				//変わらず短期間移動平均線前日比率
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT_RATIO		  + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT)) + " -  1 " + ","
				//変わらず中期移動平均線前日比率
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE_RATIO	  + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE)) + " -  1 " + ","
				//変わらず長期移動平均線前日比率
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG_RATIO		  + " = " + COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG  + " / " + s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG)) + " -  1 " + ","

				//出来高前日比
				+ COLUMN_TBL.DEKI_CHANGERATE			  + " = " + COLUMN_TBL.DEKI + " - " + s.rs.getDouble((COLUMN_TBL.DEKI)) + ","
				//出来高前日比率
				+ COLUMN_TBL.DEKI_RATIO					  + " = " + COLUMN_TBL.DEKI + " / " + s.rs.getDouble((COLUMN_TBL.DEKI)) + " -  1 " + ","
				//出来高短期間移動平均線前日比
				+ COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + ","
				//出来高中期移動平均線前日比
				+ COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + ","
				//出来高長期移動平均線前日比
				+ COLUMN_TBL.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + ","
				//出来高短期間移動平均線前日比率
				+ COLUMN_TBL.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + " -  1 " + ","
				//出来高中期移動平均線前日比率
				+ COLUMN_TBL.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + " -  1 " + ","
				//出来高長期移動平均線前日比率
				+ COLUMN_TBL.LONGIDO_DEKI_RATIO			  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + " -  1 " + ","

				//売買代金前日比
				+ COLUMN_TBL.BAYBAY_CHANGERATE			  + " = " + COLUMN_TBL.BAYBAY + " - " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + ","
				//売買代金前日比率
				+ COLUMN_TBL.BAYBAY_RATIO				  + " = " + COLUMN_TBL.BAYBAY + " / " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + " -  1 " + ","
				//売買代金短期間移動平均線前日比
				+ COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + ","
				//売買代金中期間移動平均線前日比
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + ","
				//売買代金長期移動平均線前日比
				+ COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + ","
				//売買代金短期間移動平均線前日比率
				+ COLUMN_TBL.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + " -  1 " + ","
				//売買代金中期間移動平均線前日比率
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
				//売買代金長期移動平均線前日比率
				+ COLUMN_TBL.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + " -  1 " + ""

				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " = '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'";

				s.sqlGetter().executeUpdate(SQL);
			}
		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			System.out.println(code + ":" + dayTime + ":" + SQL);
			ea.printStackTrace();
		}
	}
	//指数・・・3
	private static void setZenzituhi_3_Index(String code,String TBL,String dayTime,S s){
		String SQL;



		//ここでテーブル指定
		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				SQL = " update "
						+ TBL
						+ " set "
						//前日比
						+ COLUMN_TBL.CHANGE_PRICE				  + " = " + COLUMN_TBL.CLOSE + " - " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + ","
						//前日比率
						+ COLUMN_TBL.CHANGERATE					  + " = " + COLUMN_TBL.CLOSE + " / " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_CHANGERATE		  + " = " + COLUMN_TBL.SHORTIDO  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN_TBL.MIDDLEIDO  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN_TBL.LONGIDO_CHANGERATE			  + " = " + COLUMN_TBL.LONGIDO  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_RATIO				  + " = " + COLUMN_TBL.SHORTIDO  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_RATIO			  + " = " + COLUMN_TBL.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_RATIO				  + " = " + COLUMN_TBL.LONGIDO  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + " - 1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN_TBL.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN_TBL.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN_TBL.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN_TBL.CODE
						+ " ='" + code + "'";

				s.sqlGetter().executeUpdate(SQL);

			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}


	}
	//ETF・・・4
	private static void setZenzituhi_4_ETF(String code,String TBL,String dayTime,S s){
		String SQL;

		//ここでテーブル指定
		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				SQL = " update "
						+ TBL
						+ " set "
						//前日比
						+ COLUMN_TBL.CHANGE_PRICE				  + " = " + COLUMN_TBL.CLOSE + " - " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + ","
						//前日比率
						+ COLUMN_TBL.CHANGERATE					  + " = " + COLUMN_TBL.CLOSE + " / " + s.rs.getDouble((COLUMN_TBL.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_CHANGERATE		  + " = " + COLUMN_TBL.SHORTIDO  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN_TBL.MIDDLEIDO  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN_TBL.LONGIDO_CHANGERATE			  + " = " + COLUMN_TBL.LONGIDO  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_RATIO				  + " = " + COLUMN_TBL.SHORTIDO  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_RATIO			  + " = " + COLUMN_TBL.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_RATIO				  + " = " + COLUMN_TBL.LONGIDO  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO)) + " - 1 " + ","
						//出来高前日比
						+ COLUMN_TBL.DEKI_CHANGERATE			  + " = " + COLUMN_TBL.DEKI + " - " + s.rs.getDouble((COLUMN_TBL.DEKI)) + ","
						//出来高前日比率
						+ COLUMN_TBL.DEKI_RATIO					  + " = " + COLUMN_TBL.DEKI + " / " + s.rs.getDouble((COLUMN_TBL.DEKI)) + " -  1 " + ","
						//売買代金前日比
						+ COLUMN_TBL.BAYBAY_CHANGERATE			  + " = " + COLUMN_TBL.BAYBAY + " - " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + ","
						//売買代金前日比率
						+ COLUMN_TBL.BAYBAY_RATIO				  + " = " + COLUMN_TBL.BAYBAY + " / " + s.rs.getDouble((COLUMN_TBL.BAYBAY)) + " -  1 " + ","
						//出来高短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + ","
						//出来高中期移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + ","
						//出来高長期移動平均線前日比
						+ COLUMN_TBL.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + ","
						//出来高短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) + " -  1 " + ","
						//出来高中期移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) + " -  1 " + ","
						//出来高長期移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_DEKI_RATIO			  + " = " + COLUMN_TBL.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) + " -  1 " + ","
						//売買代金短期間移動平均線前日比
						+ COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + ","
						//売買代金中期間移動平均線前日比
						+ COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + ","
						//売買代金長期移動平均線前日比
						+ COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + ","
						//売買代金短期間移動平均線前日比率
						+ COLUMN_TBL.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) + " -  1 " + ","
						//売買代金中期間移動平均線前日比率
						+ COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
						//売買代金長期移動平均線前日比率
						+ COLUMN_TBL.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN_TBL.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) + " -  1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN_TBL.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN_TBL.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN_TBL.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN_TBL.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN_TBL.CODE
						+ " ='" + code + "'";

				s.sqlGetter().executeUpdate(SQL);
			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}


	}

	//先物・・・5
	private static void setZenzituhi_5_SAKIMONO(String code,String TBL,String dayTime,S s){

	}
	//通貨・・・6
	private static void setZenzituhi_6_Currency(String code,String TBL,String dayTime,S s){

	}










































	public static void setZenzituhi(String code,String cate,String dayTime,S s,ResultSet EDIT){
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setZenzituhi_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_02_SATISTICS:
			setZenzituhi_2_Statistics(code,TBL_Name.STATISTICS_DD,dayTime,s,EDIT);
			break;
		case ReCord.CODE_03_INDEX:
			setZenzituhi_3_Index(code,TBL_Name.INDEX_DD, dayTime, s,EDIT);
			break;
		case ReCord.CODE_04_ETF:
			setZenzituhi_4_ETF(code, TBL_Name.ETF_DD,dayTime, s,EDIT);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setZenzituhi_5_SAKIMONO(code, TBL_Name.SAKIMONO_DD,dayTime, s,EDIT);
			break;
		case ReCord.CODE_06_CURRENCY:
			setZenzituhi_6_Currency(code, TBL_Name.CURRENCY_DD,dayTime, s,EDIT);
			break;
		default:
			System.out.println("setZenzituhiMAXMINなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}


	//個別銘柄・・・1
	private static void setZenzituhi_1_Stock(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		String SQL;
		//計算結果を入れる
		double resultDouble;


		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				if(s.rs.getDouble((COLUMN_TBL.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) - s.rs.getDouble((COLUMN_TBL.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN_TBL.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) / s.rs.getDouble((COLUMN_TBL.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN_TBL.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN_TBL.CLOSE)) - EDIT.getDouble(COLUMN_TBL.OPEN) ) ;
					EDIT.updateDouble(COLUMN_TBL.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) - s.rs.getDouble((COLUMN_TBL.SHORTIDO)) );

				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) - s.rs.getDouble((COLUMN_TBL.LONGIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) / s.rs.getDouble((COLUMN_TBL.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) / s.rs.getDouble((COLUMN_TBL.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_RATIO,resultDouble);
				}


				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) - s.rs.getDouble((COLUMN_TBL.DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_CHANGERATE,resultDouble);
				}


				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) / s.rs.getDouble((COLUMN_TBL.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_RATIO,resultDouble);
				}


				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) - s.rs.getDouble((COLUMN_TBL.BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) / s.rs.getDouble((COLUMN_TBL.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_RATIO,resultDouble);
				}


				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_RATIO,resultDouble);
				}


				//売買代金短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_RATIO,resultDouble);
				}


				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_RATIO,resultDouble);
				}

			}
		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			System.out.println(code + ":" + dayTime + ":" + SQL);
			ea.printStackTrace();
		}

	}



	//統計・・・2
	private static void setZenzituhi_2_Statistics(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		String SQL;
		//計算結果を入れる
		double resultDouble;

		SQL = "select "
				+ COLUMN_TBL.STOCK_GETPRICE + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE + " , "
				+ COLUMN_TBL.STOCK_GETPRICE_IDO_LONG + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE + " , "
				+ COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//値付き前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE) - s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_CHANGERATE,resultDouble);
				}

				//値付き前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE) / s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_RATIO,resultDouble);
				}

				//値付き短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT) - s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT_CHANGERATE,resultDouble);
				}

				//値付き中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE) - s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE,resultDouble);
				}

				//値付き長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_LONG) - s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_LONG_CHANGERATE,resultDouble);
				}

				//値付き短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT) / s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_SHORT_RATIO,resultDouble);
				}

				//値付き中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE) / s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_MIDDLE_RATIO,resultDouble);
				}

				//値付き長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_LONG) / s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_GETPRICE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_GETPRICE_IDO_LONG_RATIO,resultDouble);
				}

				//変わらず前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE) - s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_CHANGERATE,resultDouble);
				}

				//変わらず前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE) / s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_RATIO,resultDouble);
				}


				//変わらず短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT) - s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE,resultDouble);
				}

				//変わらず中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE) - s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE,resultDouble);
				}

				//変わらず長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG) - s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG)) );
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG_CHANGERATE,resultDouble);
				}


				//変わらず短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT) / s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_SHORT_RATIO,resultDouble);
				}

				//変わらず中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE) / s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_MIDDLE_RATIO,resultDouble);
				}

				//変わらず長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG) / s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN_TBL.STOCK_NOCHANGE_IDO_LONG_RATIO,resultDouble);
				}

				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) - s.rs.getDouble((COLUMN_TBL.DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_CHANGERATE,resultDouble);
				}

				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) / s.rs.getDouble((COLUMN_TBL.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_RATIO,resultDouble);
				}

				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_RATIO,resultDouble);
				}

				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) - s.rs.getDouble((COLUMN_TBL.BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) / s.rs.getDouble((COLUMN_TBL.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_RATIO,resultDouble);
				}

				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_RATIO,resultDouble);
				}
			}
		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			System.out.println(code + ":" + dayTime + ":" + SQL);
			ea.printStackTrace();
		}
	}
	//指数・・・3
	private static void setZenzituhi_3_Index(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		String SQL;
		//計算結果を入れる
		double resultDouble;



		//ここでテーブル指定
		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。

				if(s.rs.getDouble((COLUMN_TBL.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) - s.rs.getDouble((COLUMN_TBL.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN_TBL.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) / s.rs.getDouble((COLUMN_TBL.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN_TBL.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN_TBL.CLOSE)) - EDIT.getDouble(COLUMN_TBL.OPEN) ) ;
					EDIT.updateDouble(COLUMN_TBL.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) - s.rs.getDouble((COLUMN_TBL.SHORTIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) - s.rs.getDouble((COLUMN_TBL.LONGIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) / s.rs.getDouble((COLUMN_TBL.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) / s.rs.getDouble((COLUMN_TBL.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_RATIO,resultDouble);
				}

				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_RATIO,resultDouble);
				}



			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}


	}
	//ETF・・・4
	private static void setZenzituhi_4_ETF(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		String SQL;
		//計算結果を入れる
		double resultDouble;

		//ここでテーブル指定
		SQL = "select "
				+ COLUMN_TBL.CLOSE + " , "
				+ COLUMN_TBL.SHORTIDO + " , "
				+ COLUMN_TBL.MIDDLEIDO + " , "
				+ COLUMN_TBL.LONGIDO + " , "
				+ COLUMN_TBL.DEKI + " , "
				+ COLUMN_TBL.BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_DEKI + " , "
				+ COLUMN_TBL.MIDDLEIDO_DEKI + " , "
				+ COLUMN_TBL.LONGIDO_DEKI + " , "
				+ COLUMN_TBL.SHORTIDO_BAYBAY + " , "
				+ COLUMN_TBL.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN_TBL.LONGIDO_BAYBAY + " , "
				+ COLUMN_TBL.SHORTIDO_HEKATU + " , "
				+ COLUMN_TBL.MIDDLEIDO_HEKATU + " , "
				+ COLUMN_TBL.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN_TBL.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。

				if(s.rs.getDouble((COLUMN_TBL.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) - s.rs.getDouble((COLUMN_TBL.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN_TBL.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN_TBL.CLOSE) / s.rs.getDouble((COLUMN_TBL.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN_TBL.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN_TBL.CLOSE)) - EDIT.getDouble(COLUMN_TBL.OPEN) ) ;
					EDIT.updateDouble(COLUMN_TBL.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) - s.rs.getDouble((COLUMN_TBL.SHORTIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) - s.rs.getDouble((COLUMN_TBL.LONGIDO)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO) / s.rs.getDouble((COLUMN_TBL.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO) / s.rs.getDouble((COLUMN_TBL.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_RATIO,resultDouble);
				}
				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) - s.rs.getDouble((COLUMN_TBL.DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_CHANGERATE,resultDouble);
				}


				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.DEKI) / s.rs.getDouble((COLUMN_TBL.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.DEKI_RATIO,resultDouble);
				}


				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) - s.rs.getDouble((COLUMN_TBL.BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.BAYBAY) / s.rs.getDouble((COLUMN_TBL.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.BAYBAY_RATIO,resultDouble);
				}


				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) - s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_DEKI) / s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_DEKI_RATIO,resultDouble);
				}


				//売買代金短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_BAYBAY_RATIO,resultDouble);
				}


				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN_TBL.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN_TBL.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN_TBL.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN_TBL.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN_TBL.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN_TBL.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN_TBL.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN_TBL.LONGIDO_HEKATU_RATIO,resultDouble);
				}


			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}


	}

	//先物・・・5
	private static void setZenzituhi_5_SAKIMONO(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}
	//通貨・・・6
	private static void setZenzituhi_6_Currency(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}

}
