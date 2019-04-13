package accesarrySQL;

import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import constant.COLUMN_TBL;
import constant.ReCord;

public class SQLChecker {

	//dayTimeからTerm期間前の日付を取得するSQLをゲット
	public static String getTermCheckSQL(String code,String cate,String dayTime,int Term){
		String SQL = "";

		//ここでテーブル指定
		SQL = "select " + COLUMN_TBL.DAYTIME
			+ " from "
			+ getTBL(cate)
			+ " where "
			+ COLUMN_TBL.CODE
			+ " ='" + code + "'"
			+ " and "
			+ COLUMN_TBL.DAYTIME
			+ " <= '" + dayTime + "'"
			+ " order by "	   + COLUMN_TBL.DAYTIME
			+ " desc "
			+ " limit " + ( Term - 1 ) + "," + 1;

		return SQL;
	}

	public static String getCateToday(String cate,S s){
		String TODAY = "";
		switch(cate){
		case ReCord.CODE_01_STOCK:
			TODAY = controllDay.getMAX_DD_STOCK_ETF(s);
			break;

		case ReCord.CODE_02_SATISTICS:
			TODAY = controllDay.getMAX_DD_STATISTICS(s);
			break;

		case ReCord.CODE_03_INDEX:
			TODAY = controllDay.getMAX_DD_INDEX(s);
			break;

		case ReCord.CODE_04_ETF:
			TODAY = controllDay.getMAX_DD_STOCK_ETF(s);
			break;

		default:
			System.out.println("SQLChecker.getCateTodayなんかよくわからないの来た：" + cate);
			break;
		}

		return TODAY;
	}

	public static String getCate(String code,S s){

		String SQL = " select "
					+ COLUMN_TBL.CATE_FLG
					+ " from "
					+ TBL_Name.CODELISTTBL
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'";


		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			if (s.rs.next()){
				return s.rs.getString(	COLUMN_TBL.CATE_FLG	);
			}else{
				//コードリストにない場合の処理。とりあえず1を返す
				return ReCord.CODE_01_STOCK;
			}
//			s.rs.next();
//			return s.rs.getString(	COLUMN.CATE_FLG	);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "";
	}

	public static String getTBL(String cate){
		String TBL = "";
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			TBL = TBL_Name.STOCK_DD;
			break;

		case ReCord.CODE_02_SATISTICS:
			TBL = TBL_Name.STATISTICS_DD;
			break;

		case ReCord.CODE_03_INDEX:
			TBL = TBL_Name.INDEX_DD;
			break;

		case ReCord.CODE_04_ETF:
			TBL = TBL_Name.ETF_DD;
			break;

		case ReCord.CODE_05_SAKIMONO:
			TBL = TBL_Name.SAKIMONO_DD;
			break;

		case ReCord.CODE_06_CURRENCY:
			TBL = TBL_Name.CURRENCY_DD;
			break;

		default:
			System.out.println("SQLCheckerなんかよくわからないの来た：" + cate);
			break;
		}


		return TBL;
	}

	public static String getSQL(String code,String cate,String dayTime,S s){
		String SQL = null;

		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			SQL = " select * from "
				+ TBL_Name.STOCK_DD
				+ " where "
				+ COLUMN_TBL.CODE + " = '"+ code + "'"
				+ " and "
				+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";

			break;

		case ReCord.CODE_02_SATISTICS:
			SQL = " select * from "
					+ TBL_Name.STATISTICS_DD
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";
			break;

		case ReCord.CODE_03_INDEX:
			SQL = " select * from "
					+ TBL_Name.INDEX_DD
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";

			break;

		case ReCord.CODE_04_ETF:
			SQL = " select * from "
					+ TBL_Name.ETF_DD
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";
			break;

		case ReCord.CODE_05_SAKIMONO:
			SQL = " select * from "
					+ TBL_Name.SAKIMONO_DD
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";
			break;

		case ReCord.CODE_06_CURRENCY:
			SQL = " select * from "
					+ TBL_Name.CURRENCY_DD
					+ " where "
					+ COLUMN_TBL.CODE + " = '"+ code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + dayTime + "'";
			break;

		default:
			System.out.println("SQLCheckerなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}


		return SQL;
	}
}
