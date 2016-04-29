package analysis;

import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;
import technique.Technique00_Common;
import technique.Technique01;
import technique.Technique98_CONST;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;

import common.commonAP;

import constant.COLUMN;

public class Analysis02_DEKI {

	public static void Analysis_DEKI(String A){
		S s = new S();
		s.getCon();
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		long start = System.currentTimeMillis();


		String SQL;
		String column ="";


		int TOTAL_WIN=0;
		int TOTAL_LOSE=0;
		int winMoney=0;
		int loseMoney=0;
		int totalWinMoney=0;
		int totalLoseMoney=0;
		int keepAve=0;
		double winParcent=0.0;
		double loseParcent=0.0;
		int tradeCount=0;
		SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {
//			s.rs3 = s.sqlGetter().executeQuery(SQL);
			commonAP.setCodeList(s);
			/*
			 * 銘柄ごとにループする
			 */
//			while ( s.rs3.next() ) {
			for (int i=0;i<commonAP.getCodeList().size();i++){
//				String cate = s.rs3.getString(COLUMN.CATE_FLG);
//				String code = s.rs3.getString(COLUMN.CODE);
				String cate = commonAP.getCodeList().get(i)[1];
				String code = commonAP.getCodeList().get(i)[0];

				paraDTO.setTargetColumn_L_01(COLUMN.MAX);
				paraDTO.setTargetColumn_L_02(COLUMN.MIN);
				paraDTO.setTargetColumn_L_03(COLUMN.OPEN);
				paraDTO.setTargetColumn_L_04(COLUMN.CLOSE);

				column= ((COLUMN.DAYTIME)) + ","
						+ paraDTO.getTargetColumn_L_01() + ","
						+ paraDTO.getTargetColumn_L_02() + ","
						+ paraDTO.getTargetColumn_L_03() + ","
						+ paraDTO.getTargetColumn_L_04();

				SQL = " select "
						+ column
						+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

				String DAY="";
				Double MAX=0.0;
				Double MIN=0.0;
				Double OPEN=0.0;
				Double CLOSE=0.0;

				int loseCount=0;
				int winCount=0;
				int keepCount=0;
				boolean loopCheck = false;

//				s.rs2.close();

				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);

					//指定した銘柄の各日付でループする
					while ( s.rs2.next() ) {
						paraDTO.setDayTime(s.rs2.getString(COLUMN.DAYTIME));

						MAX		=s.rs2.getDouble(paraDTO.getTargetColumn_L_01());
						MIN		=s.rs2.getDouble(paraDTO.getTargetColumn_L_02());
						OPEN	=s.rs2.getDouble(paraDTO.getTargetColumn_L_03());
						CLOSE	=s.rs2.getDouble(paraDTO.getTargetColumn_L_04());


//						if(Technique_01.checkDeki_L(code, cate, DAY, 60, 10,s)){
//						if(Technique01.checkDeki_L(code, cate, DAY, 60, 10)){
						if(Technique01.checkDeki_L(paraDTO,resultDTO)==Technique98_CONST.TRADE_FLG){

							tradeCount++;

							while(loopCheck==false && s.rs2.next()){
//								s.rs2.next();
								keepCount++;
								Double nowCLOSE = s.rs2.getDouble( paraDTO.getTargetColumn_L_04() );
								String nowDay=s.rs2.getString((COLUMN.DAYTIME));
//								switch(Technique00_Common.checkPrice_S(code, cate, nowDay, CLOSE, 1.05, 0.95, s)){
								switch(Technique00_Common.checkPrice_S(paraDTO,resultDTO)){
									case Technique98_CONST.WIN_FLG:
										winCount++;
										loopCheck=true;
										System.out.println("(勝)" + DAY + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + keepCount + "】" );
										keepCount=0;
										break;
									case Technique98_CONST.LOSE_FLG:
										loopCheck=true;
										loseCount++;
										System.out.println("(負)" + DAY + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + keepCount + "】");
										keepCount=0;
										break;
									case Technique98_CONST.NO_GAME:
										break;
								}
							}
						}

					}
					s.rs2.close();
					s.reCon();
					//銘柄の結果を出す
					if ( (winCount+loseCount) > 0 ){
						System.out.print("・" + code +  "：勝【" + winCount + "】");
						System.out.println("／" + code +  "：負【" + loseCount + "】");
					}

					TOTAL_WIN=TOTAL_WIN+winCount;
					TOTAL_LOSE=TOTAL_LOSE+loseCount;
				} catch (SQLException e) {
//					e.printStackTrace();

				}

			}
			System.out.println("トータル勝：" + TOTAL_WIN);
			System.out.println("トータル負：" + TOTAL_LOSE);
			System.out.println("トータル  ：" + tradeCount);

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
			try {
				s.rs2.close();
				s.reCon();
				System.out.println("こことおった");
				System.out.println("トータル勝：" + TOTAL_WIN);
				System.out.println("トータル負：" + TOTAL_LOSE);
			} catch (SQLException e) {

			}

		}

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


		s.closeConection();

	}



	public static void Analysis_DEKI(){
		S s = new S();
		s.getCon();
		long start = System.currentTimeMillis();

		String SQL;
		String column ="";
		String MAX_S =COLUMN.MAX;
		String MIN_S =COLUMN.MIN;
		String OPEN_S =COLUMN.OPEN;
		String CLOSE_S =COLUMN.CLOSE;
		int TOTAL_WIN=0;
		int TOTAL_LOSE=0;
		int winMoney=0;
		int loseMoney=0;
		int totalWinMoney=0;
		int totalLoseMoney=0;
		int keepAve=0;
		double winParcent=0.0;
		double loseParcent=0.0;
		int tradeCount=0;
		SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {
//			s.rs3 = s.sqlGetter().executeQuery(SQL);
			commonAP.setCodeList(s);
			/*
			 * 銘柄ごとにループする
			 */
//			while ( s.rs3.next() ) {
			for (int i=0;i<commonAP.getCodeList().size();i++){
//				String cate = s.rs3.getString(COLUMN.CATE_FLG);
//				String code = s.rs3.getString(COLUMN.CODE);
				String cate = commonAP.getCodeList().get(i)[1];
				String code = commonAP.getCodeList().get(i)[0];
//				System.out.println(i + ":" + code);
				if (cate.equals("1")){

					MAX_S =COLUMN.BEFORE_MAX;
					MIN_S =COLUMN.BEFORE_MIN;
					OPEN_S =COLUMN.BEFORE_OPEN;
					CLOSE_S =COLUMN.BEFORE_CLOSE;
					column= ((COLUMN.DAYTIME)) + ","
							+ MAX_S + ","
							+ MIN_S + ","
							+ OPEN_S + ","
							+ CLOSE_S;
				}else{
					MAX_S =COLUMN.MAX;
					MIN_S =COLUMN.MIN;
					OPEN_S =COLUMN.OPEN;
					CLOSE_S =COLUMN.CLOSE;
					column= ((COLUMN.DAYTIME)) + ","
							+ MAX_S + ","
							+ MIN_S + ","
							+ OPEN_S + ","
							+ CLOSE_S;
				}
				SQL = " select "
						+ column
						+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

				String DAY="";
				Double MAX=0.0;
				Double MIN=0.0;
				Double OPEN=0.0;
				Double CLOSE=0.0;

				int loseCount=0;
				int winCount=0;
				int keepCount=0;
				boolean loopCheck = false;

//				s.rs2.close();

				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);

					//指定した銘柄の各日付でループする
					while ( s.rs2.next() ) {
						DAY		=s.rs2.getString((COLUMN.DAYTIME));
						MAX		=s.rs2.getDouble((MAX_S));
						MIN		=s.rs2.getDouble((MIN_S));
						CLOSE	=s.rs2.getDouble((CLOSE_S));
						OPEN	=s.rs2.getDouble((OPEN_S));

//						if(Technique_01.checkDeki_L(code, cate, DAY, 60, 10,s)){
						if(Technique01.checkDeki_L(code, cate, DAY, 60, 10)){
							tradeCount++;

							while(loopCheck==false && s.rs2.next()){
//								s.rs2.next();
								keepCount++;
								Double nowCLOSE = s.rs2.getDouble(CLOSE_S);
								String nowDay=s.rs2.getString((COLUMN.DAYTIME));
								switch(Technique00_Common.checkPrice_S(code, cate, nowDay, CLOSE, 1.05, 0.95, s)){
									case Technique98_CONST.WIN_FLG:
										winCount++;
										loopCheck=true;
										System.out.println("(勝)" + DAY + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + keepCount + "】" );
										keepCount=0;
										break;
									case Technique98_CONST.LOSE_FLG:
										loopCheck=true;
										loseCount++;
										System.out.println("(負)" + DAY + ":" + CLOSE + "／" + nowCLOSE + ":" + nowDay + "／【" + keepCount + "】");
										keepCount=0;
										break;
									case Technique98_CONST.NO_GAME:
										break;
								}
							}
						}

					}
					s.rs2.close();
					s.reCon();
					//銘柄の結果を出す
					if ( (winCount+loseCount) > 0 ){
						System.out.print("・" + code +  "：勝【" + winCount + "】");
						System.out.println("／" + code +  "：負【" + loseCount + "】");
					}

					TOTAL_WIN=TOTAL_WIN+winCount;
					TOTAL_LOSE=TOTAL_LOSE+loseCount;
				} catch (SQLException e) {
//					e.printStackTrace();

				}

			}
			System.out.println("トータル勝：" + TOTAL_WIN);
			System.out.println("トータル負：" + TOTAL_LOSE);
			System.out.println("トータル  ：" + tradeCount);

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
			try {
				s.rs2.close();
				s.reCon();
				System.out.println("こことおった");
				System.out.println("トータル勝：" + TOTAL_WIN);
				System.out.println("トータル負：" + TOTAL_LOSE);
			} catch (SQLException e) {

			}

		}

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


		s.closeConection();
	}
}
