package technique;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.COLUMN;

public class Technique00_Common {
	//checkPrice_S設定部分
	//勝ち条件
//		paraDTO.setWinWariai(1.05);
	//負け条件
//		paraDTO.setLoseWariai(0.95);
//売値だけで見る
	//true:エントリー
	//false:exit
	public static int checkPrice_S(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,boolean judge){

			//trueならレコードが存在する。

		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}

		//nowDTO.getNowCLOSE_02();は売値が入っている。今日の売価
		Double nowPrice_Exit_KOHO = nowDTO.getNowCLOSE_01();


		//負けたとき
		if ( nowPrice_Exit_KOHO <= nowDTO.getNowCLOSE_01() * paraDTO.getLoseWariai()){
			nowDTO.setKessaiDay(nowDTO.getNowDay_01());
			nowDTO.setKessaiKingaku(nowDTO.getNowCLOSE_01());
			return Technique98_CONST.TRADE_FLG;
		}


		//勝っているとき
		if ( nowPrice_Exit_KOHO >= nowDTO.getNowCLOSE_01() * paraDTO.getWinWariai()){
			nowDTO.setKessaiDay(nowDTO.getNowDay_01());
			nowDTO.setKessaiKingaku(nowDTO.getNowCLOSE_01());
			return Technique98_CONST.TRADE_FLG;
		}



		return Technique98_CONST.NO_GAME;
	}

	//当日売るやつ
	public static int checkPrice_TODAY_S(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,boolean judge){

		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}
		S this_s = new S ();
		ResultSet this_rs=null;

		double exitMAX=0.0;
		double exitMIN=0.0;
		double exitOpen=0.0;
		double exitEnd=0.0;
		String kessaiDay="";




			String checkWord;
			String checkDaisyo;


		String SQL = " select "
					+ COLUMN.DAYTIME	+ ","
					+ COLUMN.OPEN		+ ","
					+ COLUMN.MAX		+ ","
					+ COLUMN.MIN		+ ","
					+ COLUMN.CLOSE		+ " "
					+ " from "
					+ SQLChecker.getTBL(nowDTO.getCateflg_01())
					+ " where "
					+ COLUMN.DAYTIME + " <= '" + nowDTO.getNowDay_01() + "'"
					+ " and "
					+ COLUMN.CODE + " = '" + nowDTO.getCode_01() + "'"
					+ " order by "
					+ COLUMN.DAYTIME + " desc ";

		try {
				this_rs = this_s.sqlGetter().executeQuery(SQL);
				this_rs.next();
				this_rs.next();
				exitMAX = this_rs.getDouble(COLUMN.MAX);
				exitMIN = this_rs.getDouble(COLUMN.MIN);
				exitOpen = this_rs.getDouble(COLUMN.OPEN);
				exitEnd = this_rs.getDouble(COLUMN.CLOSE);
				kessaiDay = this_rs.getString(COLUMN.DAYTIME);
				
		} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		}


//		//当日の場合
			



		nowDTO.getKessaiDay();
		nowDTO.getKessaiKingaku();

		//下がりすぎ用のストッパー
		//先にここをチェックする。
		if ( nowDTO.getKessaiKingaku() * paraDTO.getLoseWariai() >= exitMIN ){
			nowDTO.setKessaiKingaku(nowDTO.getKessaiKingaku() * paraDTO.getLoseWariai() );
			nowDTO.setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}



		//勝っているとき
		if ( exitMAX >= nowDTO.getKessaiKingaku() * paraDTO.getWinWariai() ){
			nowDTO.setKessaiKingaku( nowDTO.getKessaiKingaku() * paraDTO.getWinWariai() );
			nowDTO.setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}


		//予定よりも上がらなかったとき、その日に売る。
		if ( nowDTO.getKessaiKingaku() <= exitEnd ){
			nowDTO.setKessaiKingaku( exitEnd );
			nowDTO.setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}else{
			nowDTO.setKessaiKingaku( exitEnd );
			nowDTO.setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}


	}
}
