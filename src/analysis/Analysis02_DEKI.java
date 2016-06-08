package analysis;

import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import technique.Technique98_CONST;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;

public class Analysis02_DEKI {

	public static void Analysis_DEKI(){
		S s = new S();
		s.getCon();
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		
		//前提条件
		paraDTO.setTerm01(60);
		paraDTO.setTerm02(10);
		paraDTO.setWinWariai(1.05);
		paraDTO.setLoseWariai(0.95);

		long start = System.currentTimeMillis();


		String SQL;


		SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {
			
			commonAP.setCodeList(s);
			//銘柄ごとにループする
			for (int i=0;i<commonAP.getCodeList().size();i++){
				String cate = commonAP.getCodeList().get(i)[1];
				String code = commonAP.getCodeList().get(i)[0];
				
				SQL = " select * "
						+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

				boolean loopCheck = false;

				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);

					//指定した銘柄の各日付でループする
					while ( s.rs2.next() ) {
						//買った日
						paraDTO.setDayTime01(s.rs2.getString(COLUMN.DAYTIME));
						paraDTO.setCode(code);
						paraDTO.setCateflg(cate);
						String buyDay=paraDTO.getDayTime01();

						double MAX		=s.rs2.getDouble(	COLUMN.MAX		);
						double MIN		=s.rs2.getDouble(	COLUMN.MIN		);
						double OPEN		=s.rs2.getDouble(	COLUMN.OPEN		);
						//購入時の価格
						paraDTO.setBuyPrice(s.rs2.getDouble( COLUMN.CLOSE ));
						double CLOSE	=s.rs2.getDouble(	COLUMN.CLOSE	);


						
//						if(Technique01.checkDeki_L(paraDTO,resultDTO)==Technique98_CONST.TRADE_FLG){
						if( Analysis00_Common.Analysis_intMethod("technique","Technique01","checkDeki_L",paraDTO,nowDTO,resultDTO) ==Technique98_CONST.TRADE_FLG){
							//取引の発生した回数
							resultDTO.setTradeCount();


							while(loopCheck==false && s.rs2.next()){

								//指定銘柄を何日保有していたか
								resultDTO.setKeepCount();
								//売る日、売りフラグでなければ次の日へ
								Double nowCLOSE = s.rs2.getDouble(COLUMN.CLOSE);
								String nowDay=s.rs2.getString(COLUMN.DAYTIME);
								paraDTO.setDayTime01(nowDay);

//								switch(Technique00_Common.checkPrice_S(code, cate, nowDay, CLOSE, 1.05, 0.95, s)){
								

//								switch(Technique00_Common.checkPrice_S(paraDTO,resultDTO)){
								switch( Analysis00_Common.Analysis_intMethod("technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO) ){


									//勝った場合
									case Technique98_CONST.WIN_FLG:

										resultDTO.setWinCount();
										resultDTO.setTOTAL_WIN();
										loopCheck=true;

										System.out.println("(勝)" + paraDTO.getDayTime01() + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + resultDTO.getKeepCount() + "】" );
										resultDTO.reSetKeepCount();
										break;

									//負けた場合
									case Technique98_CONST.LOSE_FLG:
										loopCheck=true;
										resultDTO.setLoseCount();
										resultDTO.setTOTAL_LOSE();
										System.out.println("(負)" + paraDTO.getDayTime01() + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + resultDTO.getKeepCount() + "】");
										resultDTO.reSetKeepCount();
										break;

									//なにもない場合
									case Technique98_CONST.NO_GAME:
										break;
								}
							}
						}

					}
					s.rs2.close();
					s.reCon();
					//銘柄の結果を出す
					if ( ( resultDTO.getWinCount() + resultDTO.getLoseCount() ) > 0){
						System.out.print("・" + code +  "：勝【" + resultDTO.getWinCount() + "】");
						System.out.println("／" + code +  "：負【" + resultDTO.getLoseCount() + "】");

						resultDTO.reSetWinCount();
						resultDTO.reSetLoseCount();
					}

				} catch (SQLException e) {
//					e.printStackTrace();
				}

			}
			System.out.println("トータル勝：" + resultDTO.getTOTAL_WIN());
			System.out.println("トータル負：" + resultDTO.getTOTAL_LOSE());
			System.out.println("トータル  ：" + resultDTO.getTradeCount());

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
			try {
				s.rs2.close();
				s.reCon();
				System.out.println("こことおった");
//				System.out.println("トータル勝：" + TOTAL_WIN);
//				System.out.println("トータル負：" + TOTAL_LOSE);
			} catch (SQLException e) {

			}

		}

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


		s.closeConection();

	}

}
