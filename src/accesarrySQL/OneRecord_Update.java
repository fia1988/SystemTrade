package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.CATE_FLG;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;


public class OneRecord_Update {

	//前日など参照せず、一行のレコードのみで比較できるもの
	//ただし、今のところ統計の騰落レシオだけ20160821
	public static void OneRecord(String code,String cate,String dayTime,S s,ResultSet EDIT){
		//個別銘柄・・・1
				//統計・・・2
				//指数・・・3
				//ETF・・・4
				//先物・・・5
				//通貨・・・6
				switch(cate){
				case ReCord.CODE_01_STOCK:

					break;
				case ReCord.CODE_02_SATISTICS:
					OneRecord_02_STATISTICS(code, ReCord.CODE_02_SATISTICS, dayTime,s,EDIT);
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
					System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
					break;
				}
	}

	public static void OneRecord_02_STATISTICS(String code,String cate,String dayTime,S s,ResultSet EDIT){
		String SQL;
		//計算結果を入れる
		double resultDouble;



		//ここでテーブル指定
		SQL = "select "
				+ COLUMN_TBL.STOCK_DOWNSTOCK + " , "
				+ COLUMN_TBL.STOCK_UPSTOCK + " , "
				+ COLUMN_TBL.NETUKI_MAXMINRATIO + "  "
				+ " from "
				+ SQLChecker.getTBL(cate)
				+ " where "
				+ COLUMN_TBL.DAYTIME
				+ " = '" + dayTime + "'"
				+ " and "
				+ COLUMN_TBL.CODE
				+ " ='" + code + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){

				//騰落レシオ
				//値上がり銘柄数 ÷ 値下がり銘柄数

				double stock_downStock = s.rs.getDouble(COLUMN_TBL.STOCK_DOWNSTOCK);
				if ( stock_downStock == 0 ){
					stock_downStock = 1;
				}

				resultDouble=( s.rs.getDouble(COLUMN_TBL.STOCK_UPSTOCK) / stock_downStock );

				EDIT.updateDouble(COLUMN_TBL.NETUKI_MAXMINRATIO,resultDouble);

			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}
	}



	//前日など参照せず、一行のレコードのみで比較できるもの日足：株、ETF
	//true:通常、false:分割併合
	public static void OneRecord_stock_ETF_DD(String TODAY,S s,boolean checkFLG){

//		if(commonAP.getTODAY().equals(controllDay.getMAX_DD_STOCK_ETF(s) )){
//			return;
//		}

		commonAP.writeInLog("日足：ETF、株の1行レコードのみで比較できるものの更新開始",logWriting.DATEDATE_LOG_FLG);
		windowScale(ReCord.CODE_01_STOCK,s,TODAY, checkFLG);
//		windowScale(ReCord.CODE_03_INDEX,s); //今はもうない
		windowScale(ReCord.CODE_04_ETF,s,TODAY, checkFLG);
//		windowScale(CATE_FLG.M_MARKET_F,s);
//		windowScale(CATE_FLG.W_MARKET_F,s);
//		windowScale(CATE_FLG.W_STOCK_F,s);
//		windowScale(CATE_FLG.M_STOCK_F,s);
		commonAP.writeInLog("日足：ETF、株の1行レコードのみで比較できるものの更新終了",logWriting.DATEDATE_LOG_FLG);
	}

	//前日など参照せず、一行のレコードのみで比較できるもの月足週足
	//true:通常、false:分割併合
	public static void OneRecord_stock_MARKET_DD(String TODAY,S s,boolean checkFLG){

//		if(commonAP.getTODAY().equals(controllDay.getMAX_DD_STOCK_ETF(s) )){
//			return;
//		}

		commonAP.writeInLog("月足週足：マーケット、株の1行レコードのみで比較できるものの更新開始",logWriting.DATEDATE_LOG_FLG);
		windowScale(CATE_FLG.M_MARKET_F,s,TODAY, checkFLG);
		windowScale(CATE_FLG.W_MARKET_F,s,TODAY, checkFLG);
		windowScale(CATE_FLG.W_STOCK_F,s,TODAY, checkFLG);
		windowScale(CATE_FLG.M_STOCK_F,s,TODAY, checkFLG);
		commonAP.writeInLog("月足週足：マーケット、株の1行レコードのみで比較できるものの更新終了",logWriting.DATEDATE_LOG_FLG);
	}

	private static void windowScale(String cate,S s,String TODAY,boolean checkFLG){

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
			String targetCOMUMN = "A." + COLUMN_TBL.MAXMIN				+ " = " + "A." + COLUMN_TBL.MAX + " - " + "A." + COLUMN_TBL.MIN							+ " , "
								+ "A." + COLUMN_TBL.MAXMINRATIO		+ " = " + " ( 1 -  (" + "A." + COLUMN_TBL.MIN + "/" + "A." + COLUMN_TBL.MAX + "  ) )"		+ " , "
								+ "A." + COLUMN_TBL.CANDLE_AREA		+ " = " + "A." + COLUMN_TBL.CLOSE + " - " + "A." + COLUMN_TBL.OPEN						+ " , "
								+ "A." + COLUMN_TBL.CANDLE_AREA_SCALE	+ " = " + "( (" +  "A." + COLUMN_TBL.CLOSE + " - " + "A." + COLUMN_TBL.OPEN + ") / (" + "A." + COLUMN_TBL.MAX + " - " + "A." + COLUMN_TBL.MIN + ") )";
			
			String listCate = cate;
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
			case CATE_FLG.M_MARKET_F:
				listCate = ReCord.CODE_04_ETF;
				break;
				
			case CATE_FLG.W_MARKET_F:
				listCate = ReCord.CODE_04_ETF;
				break;
				
			case CATE_FLG.M_STOCK_F:
				listCate = ReCord.CODE_01_STOCK;
				break;
				
			case CATE_FLG.W_STOCK_F:
				listCate = ReCord.CODE_01_STOCK;
				break;

			default:
				break;
			}

			String SQL_CODE_WHERE = COLUMN_TBL.CODE
					  + " in "
					  + " ( "
					  	+ " select " + TBL_Name.CODELISTTBL + "." + COLUMN_TBL.CODE
					  	+ " from "
					  	+ TBL_Name.CODELISTTBL
					  	+ " where "
					  	+ COLUMN_TBL.CATE_FLG + " = '" + listCate + "'"
					  + " ) ";
			
			String omake = "";
			
			if (checkFLG){
				omake =  "  "	 + "A." + COLUMN_TBL.DAYTIME + " = '" + TODAY + "'";	
			}else{
				omake =  "  "	 + "A." + COLUMN_TBL.DAYTIME + " > '2007-01-01'";	
			}
			
			String TBL = SQLChecker.getTBL(cate);
			SQL = " update " + TBL + " as A "
			+ " left outer join "
			+ TBL + " as B "
			+ " on "
			+ "A." + COLUMN_TBL.CODE + " = " + "B." + COLUMN_TBL.CODE	  + " "
			+ " and "
			+ "A." + COLUMN_TBL.DAYTIME + " = " + "B." + COLUMN_TBL.DAYTIME	  + " "
			+ " set "
			+ targetCOMUMN
			+ " where "
			+ omake
			+ " and "
			+ "A." + SQL_CODE_WHERE;

//			SQL = " update " + SQLChecker.getTBL(cate)
//					+ " set "
//					+ targetCOMUMN
//					+ " where "
//+ COLUMN.DAYTIME + " > '2016-06-30'";
//			System.out.println(SQL);
			commonAP.writeInLog("windowScale:"+SQL,logWriting.DATEDATE_LOG_FLG);
			s.sqlGetter().executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
