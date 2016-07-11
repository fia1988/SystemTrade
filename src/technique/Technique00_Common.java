package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

public class Technique00_Common {
	//checkPrice_S設定部分
	//勝ち条件
//		paraDTO.setWinWariai(1.05);
	//負け条件
//		paraDTO.setLoseWariai(0.95);
//売値だけで見る
	//true:エントリー
	//false:exit
	public static int checkPrice_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

			//trueならレコードが存在する。

		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		//nowDTO.getNowCLOSE_02();は売値が入っている。今日の売価


			double kessaiKin = nowDTO.getKessaiKingaku();

			double nowMAX = nowDTO.getNowMAX_01();
			double nowMIN = nowDTO.getNowMIN_01();
			double nowOpen = nowDTO.getNowOpen_01();
			double nowEnd = nowDTO.getNowCLOSE_01();
			double winPrice = kessaiKin * paraDTO.getWinWariai();
			double losePrice = kessaiKin * paraDTO.getLoseWariai();

			if( winPrice == losePrice){
				System.out.println("checkPrice_S：setWinWariaiとsetLoseWariaiの設定がない。");
				return Technique98_CONST.NO_RESULT;
			};

			//負けたとき
			if ( nowMIN <= losePrice ){
				nowDTO.setKessaiDay(nowDTO.getNowDay_01());
				nowDTO.setKessaiKingaku( losePrice );
				return Technique98_CONST.TRADE_FLG;
			}


			//勝っているとき
			if ( nowMAX >= winPrice ){
				nowDTO.setKessaiDay(nowDTO.getNowDay_01());
				nowDTO.setKessaiKingaku( winPrice );
				return Technique98_CONST.TRADE_FLG;
			}

			return Technique98_CONST.NO_GAME;


	}

	//当日売るやつ
	public static int checkPrice_TODAY_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress - 1);


		double exitMAX=0.0;
		double exitMIN=0.0;
		double exitOpen=0.0;
		double exitEnd=0.0;
		String kessaiDay="";



			String checkWord;
			String checkDaisyo;

			exitMAX = nowDTO.getNowMAX_01();
			exitMIN = nowDTO.getNowMIN_01();
			exitOpen = nowDTO.getNowOpen_01();
			exitEnd = nowDTO.getNowCLOSE_01();
			kessaiDay = nowDTO.getNowDay_01();




//		//当日の場合




		nowDTO.getKessaiDay();
		nowDTO.getKessaiKingaku();
		
		//下がりすぎ用のストッパー
		//先にここをチェックする。
		if ( nowDTO.getKessaiKingaku() * paraDTO.getLoseWariai() >= exitMIN ){
			nowDTOList.get(nowDTOadress).setKessaiKingaku(nowDTO.getKessaiKingaku() * paraDTO.getLoseWariai() );
			nowDTOList.get(nowDTOadress).setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}



		//勝っているとき
		if ( exitMAX >= nowDTO.getKessaiKingaku() * paraDTO.getWinWariai() ){
			nowDTOList.get(nowDTOadress).setKessaiKingaku( nowDTO.getKessaiKingaku() * paraDTO.getWinWariai() );
			nowDTOList.get(nowDTOadress).setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}


		//予定よりも上がらなかったとき、その日に売る。
		if ( nowDTO.getKessaiKingaku() <= exitEnd ){
			nowDTOList.get(nowDTOadress).setKessaiKingaku( exitEnd );
			nowDTOList.get(nowDTOadress).setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}else{
			nowDTOList.get(nowDTOadress).setKessaiKingaku( exitEnd );
			nowDTOList.get(nowDTOadress).setKessaiDay(kessaiDay);
			return Technique98_CONST.TRADE_FLG;
		}


	}
}
