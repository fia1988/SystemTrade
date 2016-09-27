package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import constant.AccesarryParameta;
import constant.COLUMN;
import constant.ReCord;

public class Sigma{
	public static void setIDOHeikinSigma(String code,String cate,String dayTime,S s){

		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setSigma_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setSigma_2_Statics(code,TBL_Name.STATISTICS_DD,dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setSigma_3_Index(code,TBL_Name.INDEX_DD,dayTime,s);
			break;
		case ReCord.CODE_04_ETF:
			setSigma_4_ETF(code,TBL_Name.ETF_DD,dayTime,s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setSigma_5_Sakimono(code,TBL_Name.SAKIMONO_DD,dayTime,s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setSigma_6_Curency(code,TBL_Name.CURRENCY_DD,dayTime,s);
			break;
		default:
			System.out.println("setIDOHeikinSigmaなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}
	//個別銘柄・・・1
	private static void setSigma_1_Stock(String code,String TBL,String dayTime,S s){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s);

		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s);

		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s);
	}

	//統計・・・2
	private static void setSigma_2_Statics(String code,String TBL,String dayTime,S s){

	}

	//指数・・・3
	private static void setSigma_3_Index(String code,String TBL,String dayTime,S s){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s);
		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s);
		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s);
	}

	//ETF・・・4
	private static void setSigma_4_ETF(String code,String TBL,String dayTime,S s){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s);
		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s);
		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s);
	}

	//先物・・・5
	private static void setSigma_5_Sakimono(String code,String TBL,String dayTime,S s){

	}


	//通貨・・・6
	private static void setSigma_6_Curency(String code,String TBL,String dayTime,S s){

	}


	//kindSigmaは短中長を判断する。ための数値
	private static void setIDOHeikinSigma_base(String code,String TBL,String dayTime,int term,String targetColomn,int kindSigma,S s){
		String SQL;

		//平均
		double ave = 0;
		//標準偏差、1シグマの値
		double stv = 0;
		//今日の価格
//		double now = 0;

		SQL = "select "  + COLUMN.DAYTIME
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

				String start = s.rs.getString((COLUMN.DAYTIME)) ;



				//標準偏差
				SQL = "select "
						+ " STDDEV_SAMP(" + targetColomn +  ") " + " , "
						+ " avg(" + targetColomn +  ") "
						+ "from "
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
					stv = s.rs.getDouble("STDDEV_SAMP(" + targetColomn +  ")") ;
					ave = s.rs.getDouble("avg(" + targetColomn +  ")") ;
				}

//				//平均
//				SQL = "select "
//						+ " avg(" + targetColomn +  ") from "
//						+ TBL
//						+ " where "
//						+ COLUMN.CODE
//						+ " ='" + code + "'"
//						+ " and "
//						+ COLUMN.DAYTIME
//						+ " between "
//						+ "'" + start + "'"
//						+ " and "
//						+ "'" + dayTime + "'";
//
//
//				s.rs = s.sqlGetter().executeQuery(SQL);
//
//				if(s.rs.next()==true){
//					ave = s.rs.getDouble("avg(" + targetColomn +  ")") ;
//				}

//				//今日の価格
//				SQL = "select "
//						+ " (" + targetColomn +  ") from "
//						+ TBL
//						+ " where "
//						+ COLUMN.CODE
//						+ " ='" + code + "'"
//						+ " and "
//						+ COLUMN.DAYTIME
//						+ " ='" + dayTime + "'";
//
//				s.rs = s.sqlGetter().executeQuery(SQL);
//
//				if(s.rs.next()==true){
//					now = s.rs.getDouble(targetColomn) ;
//					System.out.println(stv);
//					System.out.println(ave);
//					System.out.println(now);
//					now = ( ( ( (now-ave) / stv) * 10 ) + 50 );
//					now = ( ( (ave+stv+stv-ave) / stv) * 10 ) + 50;
//
//					System.out.println("今日の偏差値：" + now);
//
//				}

				//今日のレコード


				//ここから更新
				switch(kindSigma){
				//短期
				case 1:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.SHORT_DEV + 	   " = " + stv + ","
							//							+ COLUMN.SHORT_NOW_SIGMA + " = " + now + ","
							+ COLUMN.SHORT_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.SHORT_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.SHORT_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.SHORT_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.SHORT_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.SHORT_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";
					s.sqlGetter().executeUpdate(SQL);

//					long	art = System.currentTimeMillis();
//				s.sqlGetter().executeUpdate(SQL);
//					long	stop = System.currentTimeMillis();
//					System.out.println(SQL);
//					System.out.println((stop - art) + " 秒です。");

					break;


					//中期
				case 2:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.MIDDLE_DEV + 	   " = " + stv + ","
							//							+ COLUMN.MIDDLE_NOW_SIGMA + " = " + now + ","
							+ COLUMN.MIDDLE_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.MIDDLE_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.MIDDLE_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.MIDDLE_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.MIDDLE_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.MIDDLE_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";

					s.sqlGetter().executeUpdate(SQL);
					break;

					//長期
				case 3:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.LONG_DEV + 	   " = " + stv + ","
							//							+ COLUMN.LONG_NOW_SIGMA + " = " + now + ","
							+ COLUMN.LONG_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.LONG_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.LONG_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.LONG_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.LONG_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.LONG_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";

					s.sqlGetter().executeUpdate(SQL);

					break;


				default:
					System.out.println("setIDOHeikinSigmaなんかよくわからないの来た：" + code + ":" + dayTime);
					break;

				}

			}
		}catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			//				if(ea.getErrorCode()==1054){
			//
			//				}else{
			ea.printStackTrace();
			System.out.println(code + ":" + dayTime + ":" + stv + ":" + SQL);

			//				}
		}

	}



























	public static void setIDOHeikinSigma(String code,String cate,String dayTime,S s,ResultSet EDIT){

		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case "1":
			setSigma_1_Stock(code,TBL_Name.STOCK_DD,dayTime,s,EDIT);
			break;
		case "2":
			setSigma_2_Statics(code,TBL_Name.STATISTICS_DD,dayTime,s,EDIT);
			break;
		case "3":
			setSigma_3_Index(code,TBL_Name.INDEX_DD,dayTime,s,EDIT);
			break;
		case "4":
			setSigma_4_ETF(code,TBL_Name.ETF_DD,dayTime,s,EDIT);
			break;
		case "5":
			setSigma_5_Sakimono(code,TBL_Name.SAKIMONO_DD,dayTime,s,EDIT);
			break;
		case "6":
			setSigma_6_Curency(code,TBL_Name.CURRENCY_DD,dayTime,s,EDIT);
			break;
		default:
			System.out.println("setIDOHeikinSigmaなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}
	//個別銘柄・・・1
	private static void setSigma_1_Stock(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s,EDIT);

		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s,EDIT);

		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s,EDIT);
	}

	//統計・・・2
	private static void setSigma_2_Statics(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}

	//指数・・・3
	private static void setSigma_3_Index(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s,EDIT);
		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s,EDIT);
		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s,EDIT);
	}

	//ETF・・・4
	private static void setSigma_4_ETF(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//短
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_SHORT, (COLUMN.CLOSE),AccesarryParameta.SIGMA_SHORT ,s,EDIT);
		//中
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_MIDDLE, (COLUMN.CLOSE),AccesarryParameta.SIGMA_MIDDLE ,s,EDIT);
		//長
		setIDOHeikinSigma_base(code,TBL,dayTime, AccesarryParameta.SIGMA_TERM_LONG, (COLUMN.CLOSE),AccesarryParameta.SIGMA_LONG ,s,EDIT);
	}

	//先物・・・5
	private static void setSigma_5_Sakimono(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	//通貨・・・6
	private static void setSigma_6_Curency(String code,String TBL,String dayTime,S s,ResultSet EDIT){

	}


	//kindSigmaは短中長を判断する。ための数値
	private static void setIDOHeikinSigma_base(String code,String TBL,String dayTime,int term,String targetColomn,int kindSigma,S s,ResultSet EDIT){
		String SQL;

		//平均
		double ave = 0;
		//標準偏差、1シグマの値
		double stv = 0;
		//今日の価格
//		double now = 0;

		SQL = "select "  + COLUMN.DAYTIME
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " and "
				+ COLUMN.DAYTIME + " <= '" + dayTime + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit " + ( term - 1 ) + "," + 1;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){

				String start = s.rs.getString((COLUMN.DAYTIME)) ;



				//標準偏差
				SQL = "select "
						+ " STDDEV_SAMP(" + targetColomn +  ") " + " , "
						+ " avg(" + targetColomn +  ") "
						+ "from "
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
					stv = s.rs.getDouble("STDDEV_SAMP(" + targetColomn +  ")") ;
					ave = s.rs.getDouble("avg(" + targetColomn +  ")") ;
				}

//				//平均
//				SQL = "select "
//						+ " avg(" + targetColomn +  ") from "
//						+ TBL
//						+ " where "
//						+ COLUMN.CODE
//						+ " ='" + code + "'"
//						+ " and "
//						+ COLUMN.DAYTIME
//						+ " between "
//						+ "'" + start + "'"
//						+ " and "
//						+ "'" + dayTime + "'";
//
//
//				s.rs = s.sqlGetter().executeQuery(SQL);
//
//				if(s.rs.next()==true){
//					ave = s.rs.getDouble("avg(" + targetColomn +  ")") ;
//				}

//				//今日の価格
//				SQL = "select "
//						+ " (" + targetColomn +  ") from "
//						+ TBL
//						+ " where "
//						+ COLUMN.CODE
//						+ " ='" + code + "'"
//						+ " and "
//						+ COLUMN.DAYTIME
//						+ " ='" + dayTime + "'";
//
//				s.rs = s.sqlGetter().executeQuery(SQL);
//
//				if(s.rs.next()==true){
//					now = s.rs.getDouble(targetColomn) ;
//					System.out.println(stv);
//					System.out.println(ave);
//					System.out.println(now);
//					now = ( ( ( (now-ave) / stv) * 10 ) + 50 );
//					now = ( ( (ave+stv+stv-ave) / stv) * 10 ) + 50;
//
//					System.out.println("今日の偏差値：" + now);
//
//				}

				//今日のレコード


				//ここから更新
				switch(kindSigma){
				//短期
				case 1:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.SHORT_DEV + 	   " = " + stv + ","
							//							+ COLUMN.SHORT_NOW_SIGMA + " = " + now + ","
							+ COLUMN.SHORT_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.SHORT_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.SHORT_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.SHORT_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.SHORT_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.SHORT_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";
//					s.sqlGetter().executeUpdate(SQL);
//					System.out.println(COLUMN.SHORT_DEV + "," + stv);
					EDIT.updateDouble(COLUMN.SHORT_DEV,stv);
					EDIT.updateDouble(COLUMN.SHORT_1_H_SIGMA,(ave + stv));
					EDIT.updateDouble(COLUMN.SHORT_1_L_SIGMA,(ave - stv));
					EDIT.updateDouble(COLUMN.SHORT_2_H_SIGMA,(ave + stv + stv));
					EDIT.updateDouble(COLUMN.SHORT_2_L_SIGMA,(ave - stv - stv));
					EDIT.updateDouble(COLUMN.SHORT_3_H_SIGMA,(ave + stv + stv + stv));
					EDIT.updateDouble(COLUMN.SHORT_3_L_SIGMA,(ave - stv - stv - stv));


//					long	art = System.currentTimeMillis();
//				s.sqlGetter().executeUpdate(SQL);
//					long	stop = System.currentTimeMillis();
//					System.out.println(SQL);
//					System.out.println((stop - art) + " 秒です。");

					break;


					//中期
				case 2:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.MIDDLE_DEV + 	   " = " + stv + ","
							//							+ COLUMN.MIDDLE_NOW_SIGMA + " = " + now + ","
							+ COLUMN.MIDDLE_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.MIDDLE_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.MIDDLE_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.MIDDLE_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.MIDDLE_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.MIDDLE_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";

//					s.sqlGetter().executeUpdate(SQL);
					EDIT.updateDouble(COLUMN.MIDDLE_DEV,stv);
					EDIT.updateDouble(COLUMN.MIDDLE_1_H_SIGMA,(ave + stv));
					EDIT.updateDouble(COLUMN.MIDDLE_1_L_SIGMA,(ave - stv));
					EDIT.updateDouble(COLUMN.MIDDLE_2_H_SIGMA,(ave + stv + stv));
					EDIT.updateDouble(COLUMN.MIDDLE_2_L_SIGMA,(ave - stv - stv));
					EDIT.updateDouble(COLUMN.MIDDLE_3_H_SIGMA,(ave + stv + stv + stv));
					EDIT.updateDouble(COLUMN.MIDDLE_3_L_SIGMA,(ave - stv - stv - stv));
					break;

					//長期
				case 3:
					SQL = " update "
							+ TBL
							+ " set "
							+ COLUMN.LONG_DEV + 	   " = " + stv + ","
							//							+ COLUMN.LONG_NOW_SIGMA + " = " + now + ","
							+ COLUMN.LONG_1_H_SIGMA + " = " + (ave + stv) + ","
							+ COLUMN.LONG_1_L_SIGMA + " = " + (ave - stv) + ","
							+ COLUMN.LONG_2_H_SIGMA + " = " + (ave + stv + stv) + ","
							+ COLUMN.LONG_2_L_SIGMA + " = " + (ave - stv - stv) + ","
							+ COLUMN.LONG_3_H_SIGMA + " = " + (ave + stv + stv + stv) + ","
							+ COLUMN.LONG_3_L_SIGMA + " = " + (ave - stv - stv - stv)
							+ " where "
							+ COLUMN.DAYTIME
							+ " = '" + dayTime + "'"
							+ " and "
							+ COLUMN.CODE
							+ " ='" + code + "'";

//					s.sqlGetter().executeUpdate(SQL);
					EDIT.updateDouble(COLUMN.LONG_DEV,stv);
					EDIT.updateDouble(COLUMN.LONG_1_H_SIGMA,(ave + stv));
					EDIT.updateDouble(COLUMN.LONG_1_L_SIGMA,(ave - stv));
					EDIT.updateDouble(COLUMN.LONG_2_H_SIGMA,(ave + stv + stv));
					EDIT.updateDouble(COLUMN.LONG_2_L_SIGMA,(ave - stv - stv));
					EDIT.updateDouble(COLUMN.LONG_3_H_SIGMA,(ave + stv + stv + stv));
					EDIT.updateDouble(COLUMN.LONG_3_L_SIGMA,(ave - stv - stv - stv));

					break;


				default:
					System.out.println("setIDOHeikinSigmaなんかよくわからないの来た：" + code + ":" + dayTime);
					break;

				}

			}
		}catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			//				if(ea.getErrorCode()==1054){
			//
			//				}else{
			ea.printStackTrace();
			System.out.println(code + ":" + dayTime + ":" + stv + ":" + SQL);

			//				}
		}

	}
}
