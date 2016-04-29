package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.AccesarryParameta;
import constant.COLUMN;
import constant.ReCord;

public class IDO_HEKIN_HEKATU {

	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	public static void setIDO_Heikkatu(String code,String cate,String dayTime,S s){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setStockIDO_HEKATU(code, TBL_Name.STOCK_DD, dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setStaticsIDO_Heikin(code, TBL_Name.STATISTICS_DD, dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setIndexIDO_Heikin(code, TBL_Name.INDEX_DD, dayTime,s);
			break;
		case ReCord.CODE_04_ETF:
			setETFIDO_Heikin(code, TBL_Name.ETF_DD, dayTime,s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setSakimonoDO_Heikin(code, TBL_Name.SAKIMONO_DD, dayTime,s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setCurrencyIDO_Heikin(code, TBL_Name.CURRENCY_DD, dayTime,s);
			break;
		default:
			System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	//個別銘柄・・・1
	private static void setStockIDO_HEKATU(String code,String TBL,String dayTime,S s){
		//終値による移動平滑線
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s);

	}

	//統計・・・2
	private static void setStaticsIDO_Heikin(String code,String TBL,String dayTime,S s){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.STATISTICS_DD,dayTime,0,"","",s);
	}

	//指数・・・3
	private static void setIndexIDO_Heikin(String code,String TBL,String dayTime,S s){
		//終値による移動平滑線
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s);
	}

	//ETF・・・4
	private static void setETFIDO_Heikin(String code,String TBL,String dayTime,S s){
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s);
	}

	//先物・・・5
	private static void setSakimonoDO_Heikin(String code,String TBL,String dayTime,S s){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.SAKIMONO_DD,dayTime,0,"","",s);
	}

	//通貨・・・6
	private static void setCurrencyIDO_Heikin(String code,String TBL,String dayTime,S s){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.CURRENCY_DD,dayTime,0,"","",s);
	}




	private static void setIDOHeikin_HEKATU_base(String code,String TBL,String dayTime,int term,String updateColomn,String targetColomn,S s){
		String SQL;

		String start = "";

		//前日の移動平均平滑線
		double zenHekatu = 0;
		//※α（平滑定数）＝2÷（ｎ+1）
//		double alpha = ( 2 / (term+1) );
		double alpha = ( (term+1) );
		alpha = 2 / alpha;
		//更新用の一時列名
		String KARI = "KARI";
		//
		double num = 0;

		//ここでテーブル指定
		SQL = "select " + COLUMN.DAYTIME
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit " + ( term - 1 ) + "," + 1;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。

				start = s.rs.getString((COLUMN.DAYTIME)) ;
				//前日のレコード
				SQL = "select "
						+ updateColomn
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.CODE
						+ " ='" + code + "'"
						+ " and "
						+ COLUMN.DAYTIME + " < " + "'" + dayTime + "'"
						+ " order by "	   + COLUMN.DAYTIME
						+ " desc "
						+ " limit 1";

				s.rs = s.sqlGetter().executeQuery(SQL);
				if(s.rs.next()==true){
//					num = s.rs.getDouble("avg(" + targetColomn +  ")") ;
					zenHekatu = s.rs.getDouble(updateColomn) ;
				}

				if (zenHekatu==0){
					//前日の移動平滑指数が0の場合＝NULL
					SQL = "select "
							+ " avg(" + targetColomn +  ")" + " as " + KARI
							+ " from "
							+ TBL
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ COLUMN.DAYTIME
							+ " between "
							+ "'" + start + "'"
							+ " and "
							+ "'" + dayTime + "'";
					s.rs = s.sqlGetter().executeQuery(SQL);
					if(s.rs.next()==true){
						num = s.rs.getDouble(KARI) ;
					}

				}else{
					//前日の移動平滑指数がNULLではない場合
//					2日目以降＝前日の指数平滑移動平均＋α×{当日終値-前日の指数平滑移動平均}
//					※α（平滑定数）＝2÷（ｎ+1）

					//当日終値の取得
					SQL = "select "
							+ targetColomn
							+ " from "
							+ TBL
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ COLUMN.DAYTIME
							+ " = " + "'" + dayTime + "'";
					s.rs = s.sqlGetter().executeQuery(SQL);
					if(s.rs.next()==true){
//						num = s.rs.getDouble(KARI) ;
//						num = num + ( ( 2 / (term+1) ) ) * ( num - zenHekatu );
						num = zenHekatu + ( alpha ) * ( s.rs.getDouble(targetColomn) - zenHekatu );
					}
				}

				//ここから更新
				SQL = " update "
					+ TBL
					+ " set "
					+ updateColomn + " = " + num
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
//			if(ea.getErrorCode()==1054){
//
//			}else{
				ea.printStackTrace();
				System.out.println(code + ":" + dayTime);
//			}
		}

	}



























	public static void setIDO_Heikkatu(String code,String cate,String dayTime,S s,ResultSet EDIT){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setStockIDO_HEKATU(code, TBL_Name.STOCK_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_02_SATISTICS:
			setStaticsIDO_Heikin(code, TBL_Name.STATISTICS_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_03_INDEX:
			setIndexIDO_Heikin(code, TBL_Name.INDEX_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_04_ETF:
			setETFIDO_Heikin(code, TBL_Name.ETF_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setSakimonoDO_Heikin(code, TBL_Name.SAKIMONO_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_06_CURRENCY:
			setCurrencyIDO_Heikin(code, TBL_Name.CURRENCY_DD, dayTime,s,EDIT);
			break;
		default:
			System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	//個別銘柄・・・1
	private static void setStockIDO_HEKATU(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//終値による移動平滑線
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);

	}

	//統計・・・2
	private static void setStaticsIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.STATISTICS_DD,dayTime,0,"","",s);
	}

	//指数・・・3
	private static void setIndexIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//終値による移動平滑線
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
	}

	//ETF・・・4
	private static void setETFIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUSHORT, (COLUMN.SHORTIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATUMIDDLE, (COLUMN.MIDDLEIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_HEKATU_base(code,TBL, dayTime, AccesarryParameta.HEKATULONG, (COLUMN.LONGIDO_HEKATU),(COLUMN.CLOSE), s,EDIT);
	}

	//先物・・・5
	private static void setSakimonoDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.SAKIMONO_DD,dayTime,0,"","",s,EDIT);
	}

	//通貨・・・6
	private static void setCurrencyIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		setIDOHeikin_HEKATU_base(code,TBL_Name.CURRENCY_DD,dayTime,0,"","",s,EDIT);
	}




	private static void setIDOHeikin_HEKATU_base(String code,String TBL,String dayTime,int term,String updateColomn,String targetColomn,S s,ResultSet EDIT){
		String SQL;

		String start = "";

		//前日の移動平均平滑線
		double zenHekatu = 0;
		//※α（平滑定数）＝2÷（ｎ+1）
//		double alpha = ( 2 / (term+1) );
		double alpha = ( (term+1) );
		alpha = 2 / alpha;
		//更新用の一時列名
		String KARI = "KARI";
		//
		double num = 0;

		//ここでテーブル指定
		SQL = "select " + COLUMN.DAYTIME
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit " + ( term - 1 ) + "," + 1;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。

				start = s.rs.getString((COLUMN.DAYTIME)) ;
				//前日のレコード
				SQL = "select "
						+ updateColomn
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.CODE
						+ " ='" + code + "'"
						+ " and "
						+ COLUMN.DAYTIME + " < " + "'" + dayTime + "'"
						+ " order by "	   + COLUMN.DAYTIME
						+ " desc "
						+ " limit 1";

				s.rs = s.sqlGetter().executeQuery(SQL);
				if(s.rs.next()==true){
//					num = s.rs.getDouble("avg(" + targetColomn +  ")") ;
					zenHekatu = s.rs.getDouble(updateColomn) ;
				}

				if (zenHekatu==0){
					//前日の移動平滑指数が0の場合＝NULL
					SQL = "select "
							+ " avg(" + targetColomn +  ")" + " as " + KARI
							+ " from "
							+ TBL
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ COLUMN.DAYTIME
							+ " between "
							+ "'" + start + "'"
							+ " and "
							+ "'" + dayTime + "'";
					s.rs = s.sqlGetter().executeQuery(SQL);
					if(s.rs.next()==true){
						num = s.rs.getDouble(KARI) ;
					}

				}else{
					//前日の移動平滑指数がNULLではない場合
//					2日目以降＝前日の指数平滑移動平均＋α×{当日終値-前日の指数平滑移動平均}
//					※α（平滑定数）＝2÷（ｎ+1）

					//当日終値の取得
					SQL = "select "
							+ targetColomn
							+ " from "
							+ TBL
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ COLUMN.DAYTIME
							+ " = " + "'" + dayTime + "'";
					s.rs = s.sqlGetter().executeQuery(SQL);
					if(s.rs.next()==true){
//						num = s.rs.getDouble(KARI) ;
//						num = num + ( ( 2 / (term+1) ) ) * ( num - zenHekatu );
						num = zenHekatu + ( alpha ) * ( s.rs.getDouble(targetColomn) - zenHekatu );
					}
				}

				//ここから更新
				SQL = " update "
					+ TBL
					+ " set "
					+ updateColomn + " = " + num
					+ " where "
					+ COLUMN.DAYTIME
					+ " = '" + dayTime + "'"
					+ " and "
					+ COLUMN.CODE
					+ " ='" + code + "'";

//				s.sqlGetter().executeUpdate(SQL);
				EDIT.updateDouble(updateColomn,num);
			}


		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
//			if(ea.getErrorCode()==1054){
//
//			}else{
				ea.printStackTrace();
				System.out.println(code + ":" + dayTime);
//			}
		}

	}


}
