package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique00_Common {




	public static void setKessaiClose(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		if (judge){
			//買い
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );
			}catch(ArrayIndexOutOfBoundsException e){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			}catch(IndexOutOfBoundsException a){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			}
		}else{
			//売り
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );
			}catch(ArrayIndexOutOfBoundsException e){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			}catch(IndexOutOfBoundsException a){
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
			}
		}

//		nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//		nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );


	}




	//買いメソッドの場合だけ動作する。
	//NOGAMEの時、処理しない
	//トレードフラグの時、処理続行
	public static int common_Stopper_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		//売りの場合は動かさない
		//買いメソッドの場合の処理
		if ( judge==false ) {return Technique98_CONST.NO_GAME;	}

		//日経が急落してたり今の銘柄が急落してたら買いフラグをたてないようにする。
		//NOGAMEで返す


//		//RUMフラグがtrueだったら一定確率でノーゲームを返す。
//		if ( paraDTO.getRumFLG() ) {
//			//Randomクラスのインスタンス化
//	        Random rnd = new Random();
//	        int ran = rnd.nextInt(paraDTO.getRumNumber());
//	        if ( ran != paraDTO.getRumNumber() + 1){
//	        	return Technique98_CONST.NO_GAME;
//	        }
//		}


//		//エントリータイムが多すぎるとノーゲーム
//		if (resultDTO.getEntryTime() > 6){
//			return Technique98_CONST.NO_GAME;
//		}


		//取引量の少ない銘柄は計算しない
		if (nowDTOList.get(nowDTOadress).getNowDEKI_01() < paraDTO.getMinDeki()	){

			//株かどうかを確認する。INDEXの場合、出来高がないからスルー
			if(nowDTOList.get(nowDTOadress).getCateflg_01().equals(ReCord.CODE_03_INDEX)){
				return Technique98_CONST.TRADE_FLG;
			}
			//				System.out.println(nowDTOList.get(nowDTOadress).getNowDEKI_01());
			return Technique98_CONST.NO_GAME;
		}


		return Technique98_CONST.TRADE_FLG;


//			return Technique98_CONST.NO_GAME;
//			return Technique98_CONST.TRADE_FLG;





	}

	//売メソッドの場合だけ動作する。
	//NOGAMEの時、処理しない
	//トレードフラグの時、処理決済する。
	public static int common_Stopper_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		//買いメソッドの場合の処理
		if ( judge ) {return Technique98_CONST.NO_GAME;	}



		if (checkKeepDay_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique98_CONST.TRADE_FLG;
		}

		if (checkPrice_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
			return Technique98_CONST.TRADE_FLG;
		}


		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);



//		//保有期間が長くなると売る
//		if (resultDTO.getKeepCount() > 14){
//			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//			return Technique98_CONST.TRADE_FLG;
//		}


//		if (checkPlunge_STOCK_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
//			return Technique98_CONST.TRADE_FLG;
//		}

		return Technique98_CONST.NO_GAME;

	}

	//急落したら売り出す
	public static int checkPlunge_STOCK_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}

		//trueの時は急落なので売る。tradeflg//falseの時は急落ではない。売らない。NOGAME
		boolean checkResult = true;
		//株テーブルではないときは処理を終了する。
//		switch(nowDTOList.get(nowDTOadress).getCateflg_01()){
//			case ReCord.CODE_01_STOCK:
//				break;
//			case ReCord.CODE_02_SATISTICS:
//				break;
//			case ReCord.CODE_03_INDEX:
//				break;
//			case ReCord.CODE_04_ETF:
//				break;
//			case ReCord.CODE_05_SAKIMONO:
//				break;
//			case ReCord.CODE_06_CURRENCY:
//				break;
//			default:
//				break;
//		}

		if (nowDTOList.get(nowDTOadress).getCateflg_01().equals(ReCord.CODE_99_ALLTYPE)){
			//急落要素を書く


//			setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//			return Technique98_CONST.TRADE_FLG;
			return Technique98_CONST.NO_GAME;
		}else{
			return Technique98_CONST.NO_GAME;
		}

	}


	public static int checkKeepDay_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		//売りメソッドでのみの運用を検討している。
		if ( judge ) { return Technique98_CONST.NO_GAME;}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);



		if ( resultDTO.getKeepCount() >= paraDTO.getCheckKeepDay() ){
			setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			return Technique98_CONST.TRADE_FLG;
		}

		return Technique98_CONST.NO_GAME;
	}



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



			double kessaiKin =  resultDTO.getEntryAveragePrice();

			double nowMAX = nowDTO.getNowMAX_01();
			double nowMIN = nowDTO.getNowMIN_01();
			double nowOpen = nowDTO.getNowOpen_01();
			double nowEnd = nowDTO.getNowCLOSE_01();
			double winPrice = kessaiKin * paraDTO.getWinWariai();
			double losePrice = kessaiKin * paraDTO.getLoseWariai();

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