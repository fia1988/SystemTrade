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
import constant.COLUMN;
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
			String SQL = Analysis00_Common.makekabuSQL(code, this_s);
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

			// select *  from 01_STOCK_DD where dayTime <= '2016-06-06' and code='9994―T' order by daytime desc limit 1
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
	//例）Techinique_COMMON_METHOD.codeMethodMove("technique","Technique04","MACD_L",paraDTO,nowDTOList,8,resultDTO,"9994―T","2016-06-06",5,true);
	//nowDTOadressの値はなんでもよい
	public static int codeMethodMove(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,String code,String dayTime,int size,boolean entryCheck){
		S this_s = new S ();
		ResultSet this_rs=null;

		if( size <= 0 ){return Technique98_CONST.NO_GAME;}


//		Bean_Parameta paraDTO = new Bean_Parameta();
//		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord this_nowDTO = new Bean_nowRecord();



		try {

			List<Bean_nowRecord> thisNowDTOList = new ArrayList<>();
			String cate = SQLChecker.getCate(code, this_s);

//			String SQL = " select *  from " + SQLChecker.getTBL(cate) + " where " + COLUMN.DAYTIME + " <= '" + dayTime +  "' and " + COLUMN.CODE  + "='" + code +  "' order by daytime desc limit " + size;

			String SQL = Analysis00_Common.makekabuSQL(code, this_s);
			switch(cate){
				case ReCord.CODE_01_STOCK:
					SQL = SQL + " order by " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME +  " desc limit " + size;
					break;
				case ReCord.CODE_02_SATISTICS:
					SQL = SQL + " order by " +  COLUMN.DAYTIME +  " desc limit " + size;
					break;
				case ReCord.CODE_03_INDEX:
					SQL = SQL + " order by " +  COLUMN.DAYTIME +  " desc limit " + size;
					break;
				case ReCord.CODE_04_ETF:
					SQL = SQL + " order by " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME +  " desc limit " + size;
					break;
				case ReCord.CODE_05_SAKIMONO:
					SQL = SQL + " order by " +  COLUMN.DAYTIME +  " desc limit " + size;
					break;
				case ReCord.CODE_06_CURRENCY:
					SQL = SQL + " order by " +  COLUMN.DAYTIME +  " desc limit " + size;
					break;
				default:
					break;
			}


			// select *  from 01_STOCK_DD where dayTime <= '2016-06-06' and code='9994―T' order by daytime desc limit 1
//			System.out.println(SQL);

			this_s.rs2 = this_s.sqlGetter().executeQuery(SQL);

			//指定した日からサイズまでの昇順で持ってきたい
			//例：6/1,6/2,6/3,6/4,6/5
			this_s.rs2.last();
			this_s.rs2.next();
			while ( this_s.rs2.previous() ) {
//				System.out.println(this_s.rs2.getString(COLUMN.DAYTIME));
//				System.out.println(this_s.rs2.getString( ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME		));
				thisNowDTOList.add(	Analysis00_Common.setNowRecord(code,cate,this_s.rs2,paraDTO )	);
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
