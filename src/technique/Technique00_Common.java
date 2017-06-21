package technique;

import java.sql.SQLException;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.COLUMN;
import constant.ReCord;

public class Technique00_Common {

	//MAXLOSS用
	public static int setKessaiClose(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		resultDTO.setKeepCount();
		//今何日保有しているかをnowDTOにいれる。
		nowDTO.setKeepDay(resultDTO.getKeepCount());

		if (judge){
			//買い
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );
				return Technique98_CONST.TRADE_FLG;
			}catch(ArrayIndexOutOfBoundsException e){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}catch(IndexOutOfBoundsException a){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}
		}else{
			//売り
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );
				return Technique98_CONST.TRADE_FLG;
			}catch(ArrayIndexOutOfBoundsException e){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}catch(IndexOutOfBoundsException a){
//				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}
		}

//		nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//		nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );

		return Technique98_CONST.NO_GAME;
	}



	public static int setKessaiClose(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);







		if (judge){
			//買い
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );

				return Technique98_CONST.TRADE_FLG;
			}catch(ArrayIndexOutOfBoundsException e){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}catch(IndexOutOfBoundsException a){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}
		}else{
			//売り
			try{
				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress + 1).getNowDay_01());
				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress + 1).getNowOpen_01() );


				return Technique98_CONST.TRADE_FLG;
			}catch(ArrayIndexOutOfBoundsException e){
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}catch(IndexOutOfBoundsException a){
//				nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//				nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );
				if ( paraDTO.getRealTimeMode() ){
					nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
					nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowOpen_01() );
					return Technique98_CONST.TRADE_FLG;
				}
			}
		}

//		nowDTO.setKessaiDay(nowDTOList.get(nowDTOadress).getNowDay_01());
//		nowDTO.setKessaiKingaku( nowDTOList.get(nowDTOadress).getNowCLOSE_01() );

		return Technique98_CONST.NO_GAME;
	}




	//買いメソッドの場合だけ動作する。
	//NOGAMEの時、処理しない
	//トレードフラグの時、処理続行
	public static int common_Stopper_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		//売りの場合は動かさない
		//買いメソッドの場合の処理
		if ( judge==false ) {return Technique98_CONST.NO_GAME;	}


		//インターバルタイムかどうかをチェックする
		//なお、リアルタイムモードのときはそもそもインターバルテーブルのレコードで制御するため記述しない
		if ( paraDTO.getRealTimeMode()==false ){
			if (resultDTO.isNowInterValFLG()==true){
				//今のインターバルタイムが設定したマックスよりも大きければ買う
				if( resultDTO.getNowInterValTime() < resultDTO.getMaxInterValTime()){
					resultDTO.setNowInterValTime();
					return Technique98_CONST.NO_GAME;
				}else{
					resultDTO.reSetNowInterValTime();
					resultDTO.setNowInterValFLG(false);
				}
			}
		}


		//今日の終値
		double nowPrice=nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
		//昨日までの平均取得価格
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		double nowAvePrice=resultDTO.getNowAveragePrice(paraDTO, nowDTO);

		double nowResult = ( nowPrice - nowAvePrice ) / nowAvePrice;
		nowResult = nowResult * resultDTO.getEntryTime();
		double lossLine = -1 * paraDTO.getMaxLoss();

		if (nowResult <= lossLine ){
			return Technique98_CONST.NO_GAME;
		}



//		//RUMフラグがtrueだったら一定確率でノーゲームを返す。
//		if ( paraDTO.getRumFLG() ) {
//			//Randomクラスのインスタンス化
//	        Random rnd = new Random();
//	        int ran = rnd.nextInt(paraDTO.getRumNumber());
//	        if ( ran != paraDTO.getRumNumber() + 1){
//	        	return Technique98_CONST.NO_GAME;
//	        }
//		}


		if ( paraDTO.getRealTimeMode() ){
			//本番

//			Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
//			int entryTime = getKeepDayEntryTimes(true,nowDTO.getCode_01(),"DD",paraDTO.getLMETHOD(),paraDTO.getSMETHOD());
//			//エントリータイムが多すぎるとノーゲーム
//			if (entryTime >= paraDTO.getMaxKeepDays()){
//				Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//				return Technique98_CONST.TRADE_FLG;
//			}

		}else{
			//バックテスト

		}

		//エントリータイムが多すぎるとノーゲーム
		if (resultDTO.getEntryTime() >= paraDTO.getMaxEntryTimes()){
			return Technique98_CONST.NO_GAME;
		}



		//取引量の少ない銘柄は計算しない
		if (nowDTOList.get(nowDTOadress).getNowMIDDLEIDO_DEKI_01() < paraDTO.getMinDeki()	){

			//株かどうかを確認する。INDEXの場合、出来高がないからスルー
			if(nowDTOList.get(nowDTOadress).getCateflg_01().equals(ReCord.CODE_03_INDEX)){

			}else{
				return Technique98_CONST.NO_GAME;
			}
			//				System.out.println(nowDTOList.get(nowDTOadress).getNowDEKI_01());

		}



		//損切的なのを計算
		if ( Double.isNaN(resultDTO.getNowAveragePrice(paraDTO, nowDTO)) || resultDTO.getNowAveragePrice(paraDTO, nowDTO) == 0 ) {
			// 0とかNaNのときはここ＝まだ初購入の時はここ
		}else{
			//初購入ではないときはここ
//			System.out.println(nowDTO.getCode_01() + ":" + resultDTO.getEntryTime() + ":" + resultDTO.getNowAveragePrice(paraDTO, nowDTO));



//			if ( paraDTO.getRealTimeMode() ){
//				//本番
//				nowPrice=nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
//			}else{
//				//バックテスト
//				nowPrice=nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
//			}
			//これ以上買わないサイン
//			resultDTO.getEntryTime();
//			return Technique98_CONST.NO_GAME;




			double wari = 0.05;
			double nowAvePriceH = nowAvePrice * ( 1 + wari);
			double nowAvePriceL = nowAvePrice * ( 1 - wari);


//			if ( nowAvePriceL <= nowPrice && nowPrice <= nowAvePriceH ){

			//paraDTO.getEntryMoney();の単位は万円
			double resultReturn = ( (nowAvePrice - nowPrice ) / nowPrice ) * resultDTO.getEntryTime();

			//マイナスが著しければ止める
			//-1.0 = -100%
			double minusMIN = -3.0;
			double plusMIN = 1.0;
//			if (resultReturn <= minusMIN){
//			if (resultReturn >= plusMIN){
//				return Technique98_CONST.NO_GAME;
//			}


//
//			if (nowAvePriceL < nowPrice){
//				return Technique98_CONST.TRADE_FLG;
//			}else{
//				return Technique98_CONST.NO_GAME;
//			}

		}


		return Technique98_CONST.TRADE_FLG;

	}

	//売メソッドの場合だけ動作する。
	//NOGAMEの時、処理しない
	//トレードフラグの時、処理決済する。
	public static int common_Stopper_S(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){

		//買いメソッドの場合の処理
		if ( judge ) {return Technique98_CONST.NO_GAME;	}
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);



//		if (checkKeepDay_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
//			return setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//		}
//
//		if (checkPrice_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
//			return setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
//		}




		//保有期間が長くなると売る
		if (resultDTO.getKeepCount() >= paraDTO.getMaxKeepDays()){
			Technique00_Common.setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			resultDTO.setNowInterValFLG(true);
			return Technique98_CONST.TRADE_FLG;
		}
		//損切のインターバルが必要かどうかのチェック
		//インターバルタイムかどうかをチェックする。
		//損切した場合、インターバルフラグをtrue

		//今日の終値
		double nowPrice= 0 ;
		if ( paraDTO.getRealTimeMode() ){
			//本番
			nowPrice = nowDTOList.get(nowDTOadress).getNowCLOSE_01() ;
		}else{
			//バックテスト

			try{
				nowPrice = nowDTOList.get(nowDTOadress + 1).getNowCLOSE_01() ;
//			}catch(ArrayIndexOutOfBoundsException e){
			}catch(Exception e){
				return Technique98_CONST.NO_GAME;
			}
		}
		//昨日までの平均取得価格
		double nowAvePrice=resultDTO.getNowAveragePrice(paraDTO, nowDTO);

		double nowResult = ( nowPrice - nowAvePrice ) / nowAvePrice;
		nowResult = nowResult * resultDTO.getEntryTime();
		double lossLine = -1 * paraDTO.getMaxLoss();

		if (nowResult <= lossLine ){
			if (nowResult <= lossLine * 1.5){
				return Technique98_CONST.NO_GAME;
			}

			resultDTO.setNowInterValFLG(true);

			if ( paraDTO.getRealTimeMode() ){
				//本番
				return setKessaiClose(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge);
			}else{
				//バックテスト

				resultDTO.setMaxLossFLG(true);
				return setKessaiClose(paraDTO,nowDTO, nowDTOList, nowDTOadress + 1 , resultDTO, judge);

			}

		}





//		if (checkPlunge_STOCK_S(paraDTO, nowDTOList, nowDTOadress, resultDTO, judge) == Technique98_CONST.TRADE_FLG){
//			return Technique98_CONST.TRADE_FLG;
//		}

		return Technique98_CONST.NO_GAME;

	}

	//true:保有期間
	//false:エントリー回数
	private static int getKeepDayEntryTimes(boolean check,
			String code,
			String type,
			String Lmethod,
			String Smethod){
		String SQL = "";
		S s = new S();
		s.getCon();
		int resultInt = 0;
//		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
//		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//true:保有期間
		//false:エントリー回数
		String column = COLUMN.ENTRYDAY;

		if ( check = false ) {
			column = COLUMN.ENTRYTIMES;
		}

		SQL = "select " + column + " from " + TBL_Name.KEEPLISTTBL
				+ " where "
				+ COLUMN.CODE + " = '" + code + "'"
				+ " and "
				+ COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;

				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);
					//				if(s.rs2.next()){
					//
					//				};
					while(s.rs2.next()){
						//					String codeStatus[] = new String[6];
						resultInt = s.rs2.getInt(	column	);
					};
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}


				s.closeConection();
				return resultInt;
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
