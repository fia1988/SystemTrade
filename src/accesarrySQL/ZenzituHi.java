package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN;
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
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
						+ COLUMN.CHANGE_PRICE				  + " = " + COLUMN.CLOSE + " - " + s.rs.getDouble((COLUMN.CLOSE)) + ","
						//前日比率
						+ COLUMN.CHANGERATE					  + " = " + COLUMN.CLOSE + " / " + s.rs.getDouble((COLUMN.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN.SHORTIDO_CHANGERATE		  + " = " + COLUMN.SHORTIDO + " - " + s.rs.getDouble((COLUMN.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN.MIDDLEIDO + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN.LONGIDO_CHANGERATE			  + " = " + COLUMN.LONGIDO  + " - " + s.rs.getDouble((COLUMN.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_RATIO				  + " = " + COLUMN.SHORTIDO  + " / " + s.rs.getDouble((COLUMN.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_RATIO			  + " = " + COLUMN.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN.LONGIDO_RATIO				  + " = " + COLUMN.LONGIDO  + " / " + s.rs.getDouble((COLUMN.LONGIDO)) + " - 1 " + ","
						//出来高前日比
						+ COLUMN.DEKI_CHANGERATE			  + " = " + COLUMN.DEKI + " - " + s.rs.getDouble((COLUMN.DEKI)) + ","
						//出来高前日比率
						+ COLUMN.DEKI_RATIO					  + " = " + COLUMN.DEKI + " / " + s.rs.getDouble((COLUMN.DEKI)) + " -  1 " + ","
						//売買代金前日比
						+ COLUMN.BAYBAY_CHANGERATE			  + " = " + COLUMN.BAYBAY + " - " + s.rs.getDouble((COLUMN.BAYBAY)) + ","
						//売買代金前日比率
						+ COLUMN.BAYBAY_RATIO				  + " = " + COLUMN.BAYBAY + " / " + s.rs.getDouble((COLUMN.BAYBAY)) + " -  1 " + ","
						//出来高短期間移動平均線前日比
						+ COLUMN.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + ","
						//出来高中期移動平均線前日比
						+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + ","
						//出来高長期移動平均線前日比
						+ COLUMN.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + ","
						//出来高短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + " -  1 " + ","
						//出来高中期移動平均線前日比率
						+ COLUMN.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + " -  1 " + ","
						//出来高長期移動平均線前日比率
						+ COLUMN.LONGIDO_DEKI_RATIO			  + " = " + COLUMN.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + " -  1 " + ","
						//売買代金短期間移動平均線前日比
						+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + ","
						//売買代金中期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + ","
						//売買代金長期移動平均線前日比
						+ COLUMN.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + ","
						//売買代金短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + " -  1 " + ","
						//売買代金中期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
						//売買代金長期移動平均線前日比率
						+ COLUMN.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + " -  1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN.CODE
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
				+ COLUMN.STOCK_GETPRICE + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_SHORT + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_LONG + " , "
				+ COLUMN.STOCK_NOCHANGE + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
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
						+ COLUMN.STOCK_GETPRICE_CHANGERATE			  + " = " + COLUMN.STOCK_GETPRICE + " - " + s.rs.getInt((COLUMN.STOCK_GETPRICE)) + ","
						//値付き前日比率
						+ COLUMN.STOCK_GETPRICE_RATIO				  + " = " + COLUMN.STOCK_GETPRICE + " / " + s.rs.getDouble((COLUMN.STOCK_GETPRICE)) + " -  1 " + ","
						//値付き短期間移動平均線前日比
						+ COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE  + " = " + COLUMN.STOCK_GETPRICE_IDO_SHORT  + " - " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT)) + ","
						//値付き中期移動平均線前日比
						+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE + " = " + COLUMN.STOCK_GETPRICE_IDO_MIDDLE  + " - " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE)) + ","
						//値付き長期移動平均線前日比
						+ COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE	  + " = " + COLUMN.STOCK_GETPRICE_IDO_LONG  + " - " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG)) + ","
						//値付き短期間移動平均線前日比率
						+ COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		  + " = " + COLUMN.STOCK_GETPRICE_IDO_SHORT  + " / " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT)) + " -  1 " + ","
						//値付き中期移動平均線前日比率
						+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO	  + " = " + COLUMN.STOCK_GETPRICE_IDO_MIDDLE  + " / " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE)) + " -  1 " + ","
						//値付き長期移動平均線前日比率
						+ COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		  + " = " + COLUMN.STOCK_GETPRICE_IDO_LONG  + " / " + s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG)) + " -  1 " + ","

				//変わらず前日比
				+ COLUMN.STOCK_NOCHANGE_CHANGERATE			  + " = " + COLUMN.STOCK_NOCHANGE + " - " + s.rs.getInt((COLUMN.STOCK_NOCHANGE)) + ","
				//変わらず前日比率
				+ COLUMN.STOCK_NOCHANGE_RATIO				  + " = " + COLUMN.STOCK_NOCHANGE + " / " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE)) + " -  1 " + ","
				//変わらず短期間移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE  + " = " + COLUMN.STOCK_NOCHANGE_IDO_SHORT  + " - " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT)) + ","
				//変わらず中期移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE + " = " + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE  + " - " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE)) + ","
				//変わらず長期移動平均線前日比
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE	  + " = " + COLUMN.STOCK_NOCHANGE_IDO_LONG  + " - " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG)) + ","
				//変わらず短期間移動平均線前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		  + " = " + COLUMN.STOCK_NOCHANGE_IDO_SHORT  + " / " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT)) + " -  1 " + ","
				//変わらず中期移動平均線前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO	  + " = " + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE  + " / " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE)) + " -  1 " + ","
				//変わらず長期移動平均線前日比率
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		  + " = " + COLUMN.STOCK_NOCHANGE_IDO_LONG  + " / " + s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG)) + " -  1 " + ","

				//出来高前日比
				+ COLUMN.DEKI_CHANGERATE			  + " = " + COLUMN.DEKI + " - " + s.rs.getDouble((COLUMN.DEKI)) + ","
				//出来高前日比率
				+ COLUMN.DEKI_RATIO					  + " = " + COLUMN.DEKI + " / " + s.rs.getDouble((COLUMN.DEKI)) + " -  1 " + ","
				//出来高短期間移動平均線前日比
				+ COLUMN.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + ","
				//出来高中期移動平均線前日比
				+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + ","
				//出来高長期移動平均線前日比
				+ COLUMN.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + ","
				//出来高短期間移動平均線前日比率
				+ COLUMN.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + " -  1 " + ","
				//出来高中期移動平均線前日比率
				+ COLUMN.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + " -  1 " + ","
				//出来高長期移動平均線前日比率
				+ COLUMN.LONGIDO_DEKI_RATIO			  + " = " + COLUMN.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + " -  1 " + ","

				//売買代金前日比
				+ COLUMN.BAYBAY_CHANGERATE			  + " = " + COLUMN.BAYBAY + " - " + s.rs.getDouble((COLUMN.BAYBAY)) + ","
				//売買代金前日比率
				+ COLUMN.BAYBAY_RATIO				  + " = " + COLUMN.BAYBAY + " / " + s.rs.getDouble((COLUMN.BAYBAY)) + " -  1 " + ","
				//売買代金短期間移動平均線前日比
				+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + ","
				//売買代金中期間移動平均線前日比
				+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + ","
				//売買代金長期移動平均線前日比
				+ COLUMN.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + ","
				//売買代金短期間移動平均線前日比率
				+ COLUMN.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + " -  1 " + ","
				//売買代金中期間移動平均線前日比率
				+ COLUMN.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
				//売買代金長期移動平均線前日比率
				+ COLUMN.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + " -  1 " + ""

				+ " where "
				+ COLUMN.DAYTIME
				+ " = '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
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
						+ COLUMN.CHANGE_PRICE				  + " = " + COLUMN.CLOSE + " - " + s.rs.getDouble((COLUMN.CLOSE)) + ","
						//前日比率
						+ COLUMN.CHANGERATE					  + " = " + COLUMN.CLOSE + " / " + s.rs.getDouble((COLUMN.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN.SHORTIDO_CHANGERATE		  + " = " + COLUMN.SHORTIDO  + " - " + s.rs.getDouble((COLUMN.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN.MIDDLEIDO  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN.LONGIDO_CHANGERATE			  + " = " + COLUMN.LONGIDO  + " - " + s.rs.getDouble((COLUMN.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_RATIO				  + " = " + COLUMN.SHORTIDO  + " / " + s.rs.getDouble((COLUMN.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_RATIO			  + " = " + COLUMN.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN.LONGIDO_RATIO				  + " = " + COLUMN.LONGIDO  + " / " + s.rs.getDouble((COLUMN.LONGIDO)) + " - 1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN.CODE
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
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
						+ COLUMN.CHANGE_PRICE				  + " = " + COLUMN.CLOSE + " - " + s.rs.getDouble((COLUMN.CLOSE)) + ","
						//前日比率
						+ COLUMN.CHANGERATE					  + " = " + COLUMN.CLOSE + " / " + s.rs.getDouble((COLUMN.CLOSE)) + " -  1 " + ","
						//株価短期間移動平均線前日比
						+ COLUMN.SHORTIDO_CHANGERATE		  + " = " + COLUMN.SHORTIDO  + " - " + s.rs.getDouble((COLUMN.SHORTIDO)) + ","
						//株価中期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_CHANGERATE		  + " = " + COLUMN.MIDDLEIDO  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + ","
						//株価長期間移動平均線前日比
						+ COLUMN.LONGIDO_CHANGERATE			  + " = " + COLUMN.LONGIDO  + " - " + s.rs.getDouble((COLUMN.LONGIDO)) + ","
						//株価短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_RATIO				  + " = " + COLUMN.SHORTIDO  + " / " + s.rs.getDouble((COLUMN.SHORTIDO)) + " -  1 " + ","
						//株価中期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_RATIO			  + " = " + COLUMN.MIDDLEIDO  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO)) + " - 1 " + ","
						//株価長期間移動平均線前日比率
						+ COLUMN.LONGIDO_RATIO				  + " = " + COLUMN.LONGIDO  + " / " + s.rs.getDouble((COLUMN.LONGIDO)) + " - 1 " + ","
						//出来高前日比
						+ COLUMN.DEKI_CHANGERATE			  + " = " + COLUMN.DEKI + " - " + s.rs.getDouble((COLUMN.DEKI)) + ","
						//出来高前日比率
						+ COLUMN.DEKI_RATIO					  + " = " + COLUMN.DEKI + " / " + s.rs.getDouble((COLUMN.DEKI)) + " -  1 " + ","
						//売買代金前日比
						+ COLUMN.BAYBAY_CHANGERATE			  + " = " + COLUMN.BAYBAY + " - " + s.rs.getDouble((COLUMN.BAYBAY)) + ","
						//売買代金前日比率
						+ COLUMN.BAYBAY_RATIO				  + " = " + COLUMN.BAYBAY + " / " + s.rs.getDouble((COLUMN.BAYBAY)) + " -  1 " + ","
						//出来高短期間移動平均線前日比
						+ COLUMN.SHORTIDO_DEKI_CHANGERATE	  + " = " + COLUMN.SHORTIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + ","
						//出来高中期移動平均線前日比
						+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE	  + " = " + COLUMN.MIDDLEIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + ","
						//出来高長期移動平均線前日比
						+ COLUMN.LONGIDO_DEKI_CHANGERATE	  + " = " + COLUMN.LONGIDO_DEKI  + " - " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + ","
						//出来高短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_DEKI_RATIO		  + " = " + COLUMN.SHORTIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) + " -  1 " + ","
						//出来高中期移動平均線前日比率
						+ COLUMN.MIDDLEIDO_DEKI_RATIO		  + " = " + COLUMN.MIDDLEIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) + " -  1 " + ","
						//出来高長期移動平均線前日比率
						+ COLUMN.LONGIDO_DEKI_RATIO			  + " = " + COLUMN.LONGIDO_DEKI  + " / " + s.rs.getDouble((COLUMN.LONGIDO_DEKI)) + " -  1 " + ","
						//売買代金短期間移動平均線前日比
						+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.SHORTIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + ","
						//売買代金中期間移動平均線前日比
						+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + ","
						//売買代金長期移動平均線前日比
						+ COLUMN.LONGIDO_BAYBAY_CHANGERATE	  + " = " + COLUMN.LONGIDO_BAYBAY  + " - " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + ","
						//売買代金短期間移動平均線前日比率
						+ COLUMN.SHORTIDO_BAYBAY_RATIO		  + " = " + COLUMN.SHORTIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) + " -  1 " + ","
						//売買代金中期間移動平均線前日比率
						+ COLUMN.MIDDLEIDO_BAYBAY_RATIO		  + " = " + COLUMN.MIDDLEIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) + " -  1 " + ","
						//売買代金長期移動平均線前日比率
						+ COLUMN.LONGIDO_BAYBAY_RATIO		  + " = " + COLUMN.LONGIDO_BAYBAY  + " / " + s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) + " -  1 " + ","
						//指数平滑移動平均短期前日比
						+ COLUMN.SHORTIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.SHORTIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + ","
						//指数平滑移動平均中期前日比
						+ COLUMN.MIDDLEIDO_HEKATU_CHANGERATE  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + ","
						//指数平滑移動平均長期前日比
						+ COLUMN.LONGIDO_HEKATU_CHANGERATE	  + " = " + COLUMN.LONGIDO_HEKATU  + " - " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + ","
						//指数平滑移動平均短期前日比率
						+ COLUMN.SHORTIDO_HEKATU_RATIO		  + " = " + COLUMN.SHORTIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均中期前日比率
						+ COLUMN.MIDDLEIDO_HEKATU_RATIO		  + " = " + COLUMN.MIDDLEIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) + " -  1 " + ","
						//指数平滑移動平均長期前日比率
						+ COLUMN.LONGIDO_HEKATU_RATIO		  + " = " + COLUMN.LONGIDO_HEKATU  + " / " + s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) + " -  1 " + ""
						+ " where "
						+ COLUMN.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN.CODE
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。
				if(s.rs.getDouble((COLUMN.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) - s.rs.getDouble((COLUMN.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) / s.rs.getDouble((COLUMN.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN.CLOSE)) - EDIT.getDouble(COLUMN.OPEN) ) ;
					EDIT.updateDouble(COLUMN.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) - s.rs.getDouble((COLUMN.SHORTIDO)) );

				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) - s.rs.getDouble((COLUMN.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) - s.rs.getDouble((COLUMN.LONGIDO)) );
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) / s.rs.getDouble((COLUMN.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) / s.rs.getDouble((COLUMN.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) / s.rs.getDouble((COLUMN.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_RATIO,resultDouble);
				}


				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) - s.rs.getDouble((COLUMN.DEKI)) );
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_CHANGERATE,resultDouble);
				}


				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) / s.rs.getDouble((COLUMN.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_RATIO,resultDouble);
				}


				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) - s.rs.getDouble((COLUMN.BAYBAY)) );
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) / s.rs.getDouble((COLUMN.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_RATIO,resultDouble);
				}


				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) - s.rs.getDouble((COLUMN.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) / s.rs.getDouble((COLUMN.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_RATIO,resultDouble);
				}


				//売買代金短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_BAYBAY) - s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_RATIO,resultDouble);
				}


				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_RATIO,resultDouble);
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
				+ COLUMN.STOCK_GETPRICE + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_SHORT + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_MIDDLE + " , "
				+ COLUMN.STOCK_GETPRICE_IDO_LONG + " , "
				+ COLUMN.STOCK_NOCHANGE + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_SHORT + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_MIDDLE + " , "
				+ COLUMN.STOCK_NOCHANGE_IDO_LONG + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//値付き前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE) - s.rs.getDouble((COLUMN.STOCK_GETPRICE)) );
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_CHANGERATE,resultDouble);
				}

				//値付き前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE) / s.rs.getDouble((COLUMN.STOCK_GETPRICE)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_RATIO,resultDouble);
				}

				//値付き短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_SHORT) - s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT)) );
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE,resultDouble);
				}

				//値付き中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_MIDDLE) - s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE)) );
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE,resultDouble);
				}

				//値付き長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_LONG) - s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG)) );
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE,resultDouble);
				}

				//値付き短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_SHORT) / s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO,resultDouble);
				}

				//値付き中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_MIDDLE) / s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO,resultDouble);
				}

				//値付き長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_GETPRICE_IDO_LONG) / s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_GETPRICE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO,resultDouble);
				}

				//変わらず前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE) - s.rs.getDouble((COLUMN.STOCK_NOCHANGE)) );
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_CHANGERATE,resultDouble);
				}

				//変わらず前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE) / s.rs.getDouble((COLUMN.STOCK_NOCHANGE)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_RATIO,resultDouble);
				}


				//変わらず短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_SHORT) - s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT)) );
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE,resultDouble);
				}

				//変わらず中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_MIDDLE) - s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE)) );
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE,resultDouble);
				}

				//変わらず長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_LONG) - s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG)) );
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE,resultDouble);
				}


				//変わらず短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_SHORT) / s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_SHORT))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO,resultDouble);
				}

				//変わらず中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_MIDDLE) / s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_MIDDLE))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO,resultDouble);
				}

				//変わらず長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.STOCK_NOCHANGE_IDO_LONG) / s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG)) ) - 1;
				if(s.rs.getDouble((COLUMN.STOCK_NOCHANGE_IDO_LONG))!=0){
					EDIT.updateDouble(COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO,resultDouble);
				}

				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) - s.rs.getDouble((COLUMN.DEKI)) );
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_CHANGERATE,resultDouble);
				}

				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) / s.rs.getDouble((COLUMN.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_RATIO,resultDouble);
				}

				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) - s.rs.getDouble((COLUMN.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) / s.rs.getDouble((COLUMN.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_RATIO,resultDouble);
				}

				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) - s.rs.getDouble((COLUMN.BAYBAY)) );
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) / s.rs.getDouble((COLUMN.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_RATIO,resultDouble);
				}

				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_RATIO,resultDouble);
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。

				if(s.rs.getDouble((COLUMN.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) - s.rs.getDouble((COLUMN.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) / s.rs.getDouble((COLUMN.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN.CLOSE)) - EDIT.getDouble(COLUMN.OPEN) ) ;
					EDIT.updateDouble(COLUMN.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) - s.rs.getDouble((COLUMN.SHORTIDO)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) - s.rs.getDouble((COLUMN.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) - s.rs.getDouble((COLUMN.LONGIDO)) );
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) / s.rs.getDouble((COLUMN.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) / s.rs.getDouble((COLUMN.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) / s.rs.getDouble((COLUMN.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_RATIO,resultDouble);
				}

				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_RATIO,resultDouble);
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
				+ COLUMN.CLOSE + " , "
				+ COLUMN.SHORTIDO + " , "
				+ COLUMN.MIDDLEIDO + " , "
				+ COLUMN.LONGIDO + " , "
				+ COLUMN.DEKI + " , "
				+ COLUMN.BAYBAY + " , "
				+ COLUMN.SHORTIDO_DEKI + " , "
				+ COLUMN.MIDDLEIDO_DEKI + " , "
				+ COLUMN.LONGIDO_DEKI + " , "
				+ COLUMN.SHORTIDO_BAYBAY + " , "
				+ COLUMN.MIDDLEIDO_BAYBAY + " , "
				+ COLUMN.LONGIDO_BAYBAY + " , "
				+ COLUMN.SHORTIDO_HEKATU + " , "
				+ COLUMN.MIDDLEIDO_HEKATU + " , "
				+ COLUMN.LONGIDO_HEKATU + "  "
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.DAYTIME
				+ " < '" + dayTime + "'"
				+ " and "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){


				//今日の日付の前日比を更新する。

				if(s.rs.getDouble((COLUMN.CLOSE))!=0){
					//前日比
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) - s.rs.getDouble((COLUMN.CLOSE)) ) ;
					EDIT.updateDouble(COLUMN.CHANGE_PRICE,resultDouble);

					//前日比率
					resultDouble=(EDIT.getDouble(COLUMN.CLOSE) / s.rs.getDouble((COLUMN.CLOSE)) ) - 1;
					EDIT.updateDouble(COLUMN.CHANGERATE,resultDouble);

					//窓を埋める。前日の終値と今日の始値の差。終値ー始値
					resultDouble=( s.rs.getDouble((COLUMN.CLOSE)) - EDIT.getDouble(COLUMN.OPEN) ) ;
					EDIT.updateDouble(COLUMN.WINDOW,resultDouble);
				}

				//株価短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) - s.rs.getDouble((COLUMN.SHORTIDO)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_CHANGERATE,resultDouble);
				}


				//株価中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) - s.rs.getDouble((COLUMN.MIDDLEIDO)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_CHANGERATE,resultDouble);
				}


				//株価長期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) - s.rs.getDouble((COLUMN.LONGIDO)) );
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_CHANGERATE,resultDouble);
				}


				//株価短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO) / s.rs.getDouble((COLUMN.SHORTIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_RATIO,resultDouble);
				}


				//株価中期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO) / s.rs.getDouble((COLUMN.MIDDLEIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_RATIO,resultDouble);
				}


				//株価長期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO) / s.rs.getDouble((COLUMN.LONGIDO)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_RATIO,resultDouble);
				}
				//出来高前日比
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) - s.rs.getDouble((COLUMN.DEKI)) );
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_CHANGERATE,resultDouble);
				}


				//出来高前日比率
				resultDouble=(EDIT.getDouble(COLUMN.DEKI) / s.rs.getDouble((COLUMN.DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.DEKI))!=0){
					EDIT.updateDouble(COLUMN.DEKI_RATIO,resultDouble);
				}


				//売買代金前日比
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) - s.rs.getDouble((COLUMN.BAYBAY)) );
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金前日比率
				resultDouble=(EDIT.getDouble(COLUMN.BAYBAY) / s.rs.getDouble((COLUMN.BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.BAYBAY_RATIO,resultDouble);
				}


				//出来高短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) - s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高中期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) - s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) - s.rs.getDouble((COLUMN.LONGIDO_DEKI)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_CHANGERATE,resultDouble);
				}


				//出来高短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_DEKI) / s.rs.getDouble((COLUMN.SHORTIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_DEKI_RATIO,resultDouble);
				}


				//出来高中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_DEKI) / s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_DEKI_RATIO,resultDouble);
				}


				//出来高長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_DEKI) / s.rs.getDouble((COLUMN.LONGIDO_DEKI)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_DEKI))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_DEKI_RATIO,resultDouble);
				}


				//売買代金短期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_BAYBAY) - s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金中期間移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) - s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金長期移動平均線前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) - s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_CHANGERATE,resultDouble);
				}


				//売買代金短期間移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_BAYBAY) / s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金中期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_BAYBAY) / s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_BAYBAY_RATIO,resultDouble);
				}


				//売買代金長期移動平均線前日比率
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_BAYBAY) / s.rs.getDouble((COLUMN.LONGIDO_BAYBAY)) ) - 1;
				if(s.rs.getDouble((COLUMN.LONGIDO_BAYBAY))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_BAYBAY_RATIO,resultDouble);
				}


				//指数平滑移動平均短期前日比
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) - s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均中期前日比
				resultDouble=(EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) - s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)));
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均長期前日比
				resultDouble=(EDIT.getDouble(COLUMN.LONGIDO_HEKATU) - s.rs.getDouble((COLUMN.LONGIDO_HEKATU)) );
				if(s.rs.getDouble((COLUMN.LONGIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_CHANGERATE,resultDouble);
				}


				//指数平滑移動平均短期前日比率
				resultDouble=(EDIT.getDouble(COLUMN.SHORTIDO_HEKATU) / s.rs.getDouble((COLUMN.SHORTIDO_HEKATU)) ) -  1;
				if(s.rs.getDouble((COLUMN.SHORTIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.SHORTIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均中期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.MIDDLEIDO_HEKATU) / s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU)) ) - 1;
				if(s.rs.getDouble((COLUMN.MIDDLEIDO_HEKATU))!=0){
					EDIT.updateDouble(COLUMN.MIDDLEIDO_HEKATU_RATIO,resultDouble);
				}


				//指数平滑移動平均長期前日比率
				resultDouble=( EDIT.getDouble(COLUMN.LONGIDO_HEKATU) / s.rs.getDouble(COLUMN.LONGIDO_HEKATU) ) - 1;
				if(s.rs.getDouble(COLUMN.LONGIDO_HEKATU)!=0){
					EDIT.updateDouble(COLUMN.LONGIDO_HEKATU_RATIO,resultDouble);
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
