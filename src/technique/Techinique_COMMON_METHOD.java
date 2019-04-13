package technique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import accesarrySQL.SQLChecker;
import analysis.Analysis00_Common;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.ReCord;


public class Techinique_COMMON_METHOD {


	public static int checkEveryDayMethodMove(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,String code,String dayTime,int size,boolean entryCheck){
		S this_s = new S ();
		ResultSet this_rs=null;

		if( size <= 0 ){return Technique98_CONST.NO_GAME;}
		Bean_nowRecord this_nowDTO = new Bean_nowRecord();

//
//		String SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";



		try {

			List<Bean_nowRecord> thisNowDTOList = new ArrayList<>();
			String cate = SQLChecker.getCate(code, this_s);
//			String SQL = " select *  from " + SQLChecker.getTBL(cate) + " where " + COLUMN.DAYTIME + " <= '" + dayTime +  "' and " + COLUMN.CODE  + "='" + code +  "' order by daytime desc limit " + size;
			String SQL = Analysis00_Common.makekabuSQL(code, this_s,paraDTO,resultDTO);
//			switch(cate){
//				case ReCord.CODE_01_STOCK:
//					break;
//				case ReCord.CODE_02_SATISTICS:
//
//					break;
//				case ReCord.CODE_03_INDEX:
//
//					break;
//				case ReCord.CODE_04_ETF:
//
//					break;
//				case ReCord.CODE_05_SAKIMONO:
//					break;
//				case ReCord.CODE_06_CURRENCY:
//					break;
//				default:
//					break;
//			}

			// select *  from 01_STOCK_DD where dayTime <= '2016-06-06' and code='9994_T' order by daytime desc limit 1
//			System.out.println(SQL);

			this_s.rs2 = this_s.sqlGetter().executeQuery(SQL);

			//指定した日からサイズまでの昇順で持ってきたい
			//例：6/1,6/2,6/3,6/4,6/5
			this_s.rs2.last();
			this_s.rs2.next();
			while ( this_s.rs2.previous() ) {
//				System.out.println(this_s.rs2.getString(COLUMN.DAYTIME));
				thisNowDTOList.add(	Analysis00_Common.setNowRecord(code,cate,this_s.rs2, paraDTO)	);
			}
			this_s.rs2.close();
//			this_s.reCon();
//			this_rs.close();
//			System.out.println(size);
//			System.out.println(thisNowDTOList.get(size - 1).getNowDay_01());
//			System.out.println(Analysis00_Common.Analysis_intMethod(packageName,className,methodName,paraDTO,thisNowDTOList,size - 1,resultDTO,entryCheck));

			if (thisNowDTOList.size() == 0){
				return Technique98_CONST.NO_GAME;
			}else{
				return Analysis00_Common.Analysis_intMethod(packageName,className,methodName,paraDTO,thisNowDTOList,size - 1,resultDTO,entryCheck);
			}



		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NullPointerException n){

		} catch (ArrayIndexOutOfBoundsException c){

		}



		return Technique98_CONST.NO_GAME;
	}

	//コード名、日付、メソッドを入れると実行する。今日の日付のメソッドを確認する。
	//パッケージ名とDTOとコードとtrue,falseをいれる
	//例）Techinique_COMMON_METHOD.codeMethodMove("technique","Technique04","MACD_L",paraDTO,nowDTOList,8,resultDTO,"9994_T","2016-06-06",5,true);
	//nowDTOadressの値はなんでもよい
	public static int codeMethodMove(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,String code,String cate,String dayTime,int size,boolean entryCheck,S s){
//	public static int codeMethodMove(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,String code,String cate,int size,boolean entryCheck){

		if( size <= 0 ){return Technique98_CONST.NO_GAME;}

		int sleepTime = 7;

		if ( sleepTime < 0 ){return Technique98_CONST.NO_GAME;}
		//連続稼働させないように休息する。
		try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}

//		S s = new S();
//		s.getCon();
		String startDay = commonAP.getStartDay(dayTime,size, s);
//		s.closeConection();

		String endDay = dayTime;
//		S s = new S ();
//		ResultSet this_rs=null;
//		s.getCon();


		List<Bean_nowRecord> thisNowDTOList = new ArrayList<>();
		//			String cate = SQLChecker.getCate(code, this_s);

		//			String SQL = " select *  from " + SQLChecker.getTBL(cate) + " where " + COLUMN.DAYTIME + " <= '" + dayTime +  "' and " + COLUMN.CODE  + "='" + code +  "' order by daytime desc limit " + size;

		//			String SQL = Analysis00_Common.makekabuDaySQL(code,startDay,endDay, this_s);
		String SQL = Analysis00_Common.makekabuSQL(code, s,paraDTO,resultDTO);
		String headLetter = "";
		switch(cate){
			case ReCord.CODE_01_STOCK:
				headLetter = ReCord.STOCK_TBK_DD_A +  ".";
				SQL = SQL
						+	"and '"	+	startDay + "' <= " + headLetter + COLUMN_TBL.DAYTIME + " and "
						+	headLetter + COLUMN_TBL.DAYTIME + " <= '" + endDay + "'"
						+ " order by " + headLetter + COLUMN_TBL.DAYTIME +  " desc limit " + size;


				break;
			case ReCord.CODE_02_SATISTICS:
				SQL = SQL
				+	"and '"	+	startDay + "' <= " + headLetter + COLUMN_TBL.DAYTIME + " and "
				+	headLetter + COLUMN_TBL.DAYTIME + " <= '" + endDay + "'"
				+ " order by " +  COLUMN_TBL.DAYTIME +  " desc limit " + size;
				break;
			case ReCord.CODE_03_INDEX:
				SQL = SQL
				+	"and '"	+	startDay + "' <= " + headLetter + COLUMN_TBL.DAYTIME + " and "
				+	headLetter + COLUMN_TBL.DAYTIME + " <= '" + endDay + "'"
				+ " order by " +  COLUMN_TBL.DAYTIME +  " desc limit " + size;
				break;
			case ReCord.CODE_04_ETF:
				headLetter = ReCord.ETF_DD_E +  ".";
				SQL = SQL
						+	" and '"	+	startDay + "' <= " + headLetter + COLUMN_TBL.DAYTIME + " and "
						+	headLetter + COLUMN_TBL.DAYTIME + " <= '" + endDay + "'"
						+ " order by " + headLetter + COLUMN_TBL.DAYTIME +  " desc limit " + size;
				break;
			case ReCord.CODE_05_SAKIMONO:
				SQL = SQL + " order by " +  COLUMN_TBL.DAYTIME +  " desc limit " + size;
				break;
			case ReCord.CODE_06_CURRENCY:
				SQL = SQL + " order by " +  COLUMN_TBL.DAYTIME +  " desc limit " + size;
				break;
			default:
				break;
		}


		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			//指定した日からサイズまでの昇順で持ってきたい
			//例：6/1,6/2,6/3,6/4,6/5
			s.rs2.last();
			s.rs2.next();
			while ( s.rs2.previous() ) {
				String nowDay = s.rs2.getString(headLetter + COLUMN_TBL.DAYTIME);
//				System.out.println(startDay);
//				System.out.println(endDay);
				//startDay =< nowDay =< endDayであればよい
				if ( nowDay.compareTo(startDay) >= 0 && endDay.compareTo(nowDay) >=0 ){
//					String moji01 = "2017-01-01";
//					String moji02 = "2017-01-02";
//					String moji03 = "2017-01-03";
//					String moji04 = "2017-01-04";
//					System.out.println(moji01.compareTo(moji02)); //moji01 - moji02 = -1
//					System.out.println(moji04.compareTo(moji02)); //moji04 - moji02 = 2
//					System.out.println(moji04.compareTo(moji01)); //moji04 - moji02 = 3
//					System.out.println(moji02.compareTo(moji04)); //moji04 - moji02 = -2
					thisNowDTOList.add(	Analysis00_Common.setNowRecord(code,cate,s.rs2,paraDTO )	);
				}else{
					System.out.println("code:   "  + code);
					System.out.println("startDay:" + startDay);
					System.out.println("nowDay  :" + nowDay);
					System.out.println("endDay  :" + endDay);
					System.out.println("SQL     :" + SQL);
//					this_s.rs2.close();
					s.closeConection();
					return Technique98_CONST.NO_GAME;
				}
			}

//			this_s.rs2.close();
//			this_s.reCon();
//			this_rs.close();
//			System.out.println(size);
//			System.out.println(thisNowDTOList.get(size - 1).getNowDay_01());
//			System.out.println(Analysis00_Common.Analysis_intMethod(packageName,className,methodName,paraDTO,thisNowDTOList,size - 1,resultDTO,entryCheck));

			s.closeConection();
			if (thisNowDTOList.size() == 0){
				return Technique98_CONST.NO_GAME;
			}else{
				return Analysis00_Common.Analysis_intMethod(packageName,className,methodName,paraDTO,thisNowDTOList,size - 1,resultDTO,entryCheck);
			}



		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NullPointerException n){
			System.out.println("koko");
		} catch (ArrayIndexOutOfBoundsException c){
			System.out.println("kokokoko");
		}


//		s.closeConection();
		return Technique98_CONST.NO_GAME;
	}


	//
	//	public static Bean_nowRecord checkStartNowDTO(Bean_nowRecord nowDTO_entry,Bean_nowRecord nowDTO_exit,boolean judge){
	//		//買いメソッドでのみの運用を検討している。
	//		//true:エントリー
	//		//false:exit
	//
	//		if ( judge ) {
	//			return nowDTO_entry;
	//		}else{
	//			return nowDTO_exit;
	//		}
	//	}
	//
	//	public static void finishNowDTO(Bean_nowRecord nowDTO_entry,Bean_nowRecord nowDTO_exit,boolean judge){
	//		if ( judge ) {
	////			return nowDTO_entry;
	//		}else{
	////			return nowDTO_exit;
	//		}
	//	}

	public static int checkCateGory(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,boolean judge){

		switch(paraDTO.getCheckCate()){
			case ReCord.CODE_99_ALLTYPE:
				return Technique98_CONST.CONTENUE_PROCESS;

			default:


				if (paraDTO.getCheckCate().equals(nowDTO.getCateflg_01())){
					//等しければ問題なく続ける

					return Technique98_CONST.CONTENUE_PROCESS;
				}else{

					return Technique98_CONST.NO_GAME;
				}
		}

	}



}
