package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique02 {

	//checkMotiKabu_L設定部分
	//前日の終値を買う。
	//あるいは持ち株会の買付日を見つける
	//基準日1、多くは給料日
	//paraDTO.kyuryoDayDD_01("DD");
	//基準日2、多くはボーナス夏
	//paraDTO.bonusDay__01("MM-DD");
	//基準日3、多くはボーナス冬
	//paraDTO.bonusDay_02("MM-DD");
	//基準日の何営業日あとかのチェック
	//paraDTO.setIntCount01(2);

	//前日の終値か当日の始値かで動作が変わる、前日の場合：true、当日の場合：false
//	getCheckTOZITU_ZENZITU()
//	setTOZITU_START()
//	setZENZITU_END()
	//持ち株、ボーナス夏、ボーナス冬の設定
//	paraDTO.setMotikabuDay();
//	paraDTO.setSummerBonus();
//	paraDTO.setWinterBonus();

//Lメソッドは戻り値int（勝ち）約定（負け）、false買わず
//WINFLG_買う、LOSEフラグ、買わない。
	public static int checkMotiKabu_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		//買いメソッドでのみの運用を検討している。
		//true:エントリー
		//false:exit
		//		Bean_nowRecord nowDTO = Techinique_COMMON_METHOD.checkStartNowDTO(nowDTO_entry, nowDTO_exit, judge);

		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);


		
		//給料日、ボーナス夏、ボーナス冬のどれでもない場合
		if (paraDTO.checkMotikabu()==false){
			System.out.println("checkMotiKabu_L:給料日、ボーナス夏、ボーナス冬のどれでもない場合");
			return Technique98_CONST.NO_GAME;
		}

		switch(nowDTO.getCateflg_01()){
		case ReCord.CODE_01_STOCK:
			break;
		default:
			return Technique98_CONST.NO_GAME;
		}



		String checkWord;
		String checkDaisyo;


		//			String SQL = " select "
		//						+ COLUMN.DAYTIME + ","
		//						+ COLUMN.OPEN + ","
		//						+ COLUMN.CLOSE + " "
		//						+ " from "
		//						+ SQLChecker.getTBL(nowDTO.getCateflg_01())
		//						+ " where "
		//						+ COLUMN.DAYTIME + " <= '" + nowDTO.getNowDay_01() + "'"
		//						+ " and "
		//						+ COLUMN.CODE + " = '" + nowDTO.getCode_01() + "'"
		//						+ " order by "
		//						+ COLUMN.DAYTIME + " desc ";
		//
		//			this_rs = this_s.sqlGetter().executeQuery(SQL);

		//			if (this_rs.next()){

		double openPrice = nowDTO.getNowOpen_01();
		double closePrise = 0.0;
		String nowDay = nowDTO.getNowDay_01();

		//ここのエラー科アック
		try{
			if(paraDTO.getCheckTOZITU_ZENZITU()==true){
				closePrise = nowDTOList.get(nowDTOadress - 1).getNowCLOSE_01();;
				nowDay = nowDTOList.get(nowDTOadress - 1).getNowDay_01();
			}



			//				String checkDay = "";

			//基準日より何日あとかをチェックする

			//				checkDay =  nowDTOList.get(nowDTOadress - paraDTO.getIntCount01() ).getNowDay_01();

			//				if (paraDTO.getIntCount01() < 0 ){
			//
			//				}else{
			//					//前日の終値か当日の始値かで動作が変わる、前日の場合：true、当日の場合：false
			//					//ZENZITU_CLOSE
			//					//					getCheckTOZITU_ZENZITU()
			//					//初期値は前日終値を指す-1
			//
			//					for (int i=0 ; i < paraDTO.getIntCount01() ; i++ ){
			//
			//
			//						if (this_rs.previous()==false){
			//
			//							return Technique98_CONST.NO_GAME;
			//						}
			//
			//						if (i==0){
			//
			//						}
			//
			//					}
			//					checkDay = this_rs.getString(COLUMN.DAYTIME);
			//					if (paraDTO.getIntCount01() ==0 ){
			//						this_rs.previous();
			//						if(paraDTO.getCheckTOZITU_ZENZITU()==true){
			//							closePrise = this_rs.getDouble(COLUMN.CLOSE);
			//							nowDay = this_rs.getString(COLUMN.DAYTIME);
			//						}
			//					}

			//				}



			//					//給料日チェック
			//					SQL = " select "
			//						+ COLUMN.DAYTIME
			//						+ " from "
			//						+ SQLChecker.getTBL(nowDTO.getCateflg_01())
			//						+ " where "
			//						+ COLUMN.DAYTIME + " >= '" + checkDay + "'"
			//						+ " and "
			//						+ COLUMN.CODE + " = '" + nowDTO.getCode_01() + "'"
			//						+ " order by "
			//						+ COLUMN.DAYTIME;
			//
			//					this_rs = this_s.sqlGetter().executeQuery(SQL);

			//給料日あるいはボーナス日チェックの次の営業日を調べる。
			//				if( this_rs2.next() == false ){return Technique98_CONST.NO_GAME;};
			//給料日と思われる日
			int kyuryoDayKohoDD		=	Integer.parseInt(	nowDTOList.get(nowDTOadress - paraDTO.getIntCount01() ).getNowDay_01().substring(8,10)	);
			//ボーナス日と思われる日
			int bonusKohoDayMMDD		=	Integer.parseInt(	nowDTOList.get(nowDTOadress - paraDTO.getIntCount01() ).getNowDay_01().substring(5,10).replace("-", "")	);

			//				if( this_rs.next() == false ){return Technique98_CONST.NO_GAME;};
			//これが給料日の次の営業日と思われる日
			int kyuryoNextDayKohoDD		=	Integer.parseInt(	nowDTOList.get(nowDTOadress - paraDTO.getIntCount01()  + 1).getNowDay_01().substring(8,10)	);
			//ボーナス日の翌営業日と思われる日
			int bonusKohoNextDayMMDD	=	Integer.parseInt(	nowDTOList.get(nowDTOadress - paraDTO.getIntCount01()  + 1).getNowDay_01().substring(5,10).replace("-", "")	);


			//給料日
			int kyuryoDayDD				=	Integer.parseInt(	paraDTO.getSaraly_01()				);
			//ボーナス夏
			int bonusDay_01				=	Integer.parseInt(	paraDTO.getBonus_01().replace("-", "")	);
			//ボーナス冬
			int bonusDay_02				=	Integer.parseInt(	paraDTO.getBonus_02().replace("-", "")	);

			//給料日かどうかの判定
			//給料日の次の日候補が給料日よりも後で、かつ、給料日候補が給料日以前である場合、処理をする。
			if(paraDTO.getMotikabuDay()){
				if (kyuryoNextDayKohoDD > kyuryoDayDD && kyuryoDayKohoDD <= kyuryoDayDD){
					finishCheckMotiKabu_L(paraDTO, nowDTO, resultDTO, openPrice, closePrise,nowDay, judge);
					return Technique98_CONST.TRADE_FLG;
				}

			}

			//夏のボーナス日かどうかの判定
			if(paraDTO.getSummerBonus()){
				if (bonusKohoNextDayMMDD > bonusDay_01 && bonusKohoDayMMDD <= bonusDay_01){
					finishCheckMotiKabu_L(paraDTO, nowDTO, resultDTO, openPrice, closePrise,nowDay, judge);
					return Technique98_CONST.TRADE_FLG;
				}
			}

			//冬のボーナス日かどうかの判定
			if(paraDTO.getWinterBonus()){
				if (bonusKohoNextDayMMDD > bonusDay_02 && bonusKohoDayMMDD <= bonusDay_02){
					finishCheckMotiKabu_L(paraDTO, nowDTO, resultDTO, openPrice, closePrise,nowDay, judge);
					return Technique98_CONST.TRADE_FLG;
				}
			}

		}catch(ArrayIndexOutOfBoundsException e){

		}catch(IndexOutOfBoundsException a){

		}




		//				return checkResultDay(paraDTO,nowDTO,resultDTO,kyuryoDayKohoDD,bonusKohoDayMMDD,kyuryoNextDayKohoDD,bonusKohoNextDayMMDD);
		return Technique98_CONST.NO_GAME;
	}



	private static void finishCheckMotiKabu_L(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,double openPrice,double closePrise,String nowDay,boolean judge){

		nowDTO.setKessaiDay(nowDay);
		if ( judge ) {


			//前日の終値か当日の始値かで動作が変わる、前日の場合：true、当日の場合：false
			if(paraDTO.getCheckTOZITU_ZENZITU()==false){
				//当日始値
				nowDTO.setKessaiKingaku(openPrice);
			}else{
				//前日終値
				nowDTO.setKessaiKingaku(closePrise);
			}
		}else{

			if(paraDTO.getCheckTOZITU_ZENZITU()==false){
				//当日始値
				nowDTO.setKessaiKingaku(openPrice);
			}else{
				//前日終値
				nowDTO.setKessaiKingaku(closePrise);
			}
		}

	}

	private static int checkResultDay(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,int checkSarary,int checkBonus,int checkNextSarary,int checkNextBonus){

		//給料日
		int kyuryoDayDD				=	Integer.parseInt(	paraDTO.getSaraly_01()				);
		//ボーナス夏
		int bonusDay_01				=	Integer.parseInt(	paraDTO.getBonus_01().replace("-", "")	);
		//ボーナス冬
		int bonusDay_02				=	Integer.parseInt(	paraDTO.getBonus_02().replace("-", "")	);

		//給料日と思われる日
		int kyuryoDayKohoDD		=	checkSarary;
		//ボーナス日と思われる日
		int bonusKohoDayMMDD		=	checkBonus;

		//これが給料日の次の営業日と思われる日
		int kyuryoNextDayKohoDD		=	checkNextSarary;
		//ボーナス日の翌営業日と思われる日
		int bonusKohoNextDayMMDD	=	checkNextBonus;


		//給料日かどうかの判定
		//給料日の次の日候補が給料日よりも後で、かつ、給料日候補が給料日以前である場合、処理をする。
		if(paraDTO.getMotikabuDay()){
			if (kyuryoNextDayKohoDD > kyuryoDayDD && kyuryoDayKohoDD <= kyuryoDayDD){

				return Technique98_CONST.TRADE_FLG;
			}

		}

		//夏のボーナス日かどうかの判定
		if(paraDTO.getSummerBonus()){
			if (bonusKohoNextDayMMDD > bonusDay_01 && bonusKohoDayMMDD <= bonusDay_01){return Technique98_CONST.TRADE_FLG;}
		}

		//冬のボーナス日かどうかの判定
		if(paraDTO.getWinterBonus()){
			if (bonusKohoNextDayMMDD > bonusDay_02 && bonusKohoDayMMDD <= bonusDay_02){return Technique98_CONST.TRADE_FLG;}
		}

		return Technique98_CONST.NO_GAME;
	}




}
