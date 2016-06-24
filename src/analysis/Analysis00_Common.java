package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import technique.Technique98_CONST;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;

public class Analysis00_Common {

	public static void sagyoSpace(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();

//		**
//		checkDeki_L設定部分
//		paraDTO.setTerm01(60);
//		paraDTO.setTerm02(10);
//		//変化していないの定義。TERM01と02の合計期間の出来高前日比率のSTDDEV_SAMP。すなわち「どのぐらい変化していないか」。0でまったく変化していない。初期値1.5
//		paraDTO.setBOXCHECK(1.5);
//		//スコア。変化率でスコアを設定している。その点数。初期値0.7
//		paraDTO.setHIGHT_DEKI_RATIO(1.5);
////		checkPrice_S設定部分
//		paraDTO.setWinWariai(1.1);
//		paraDTO.setLoseWariai(0.95);
//		Analysis_COMMON("technique","Technique01","checkDeki_L","technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO);
		//


		//checkMotiKabu_L設定部分
		//あるいは持ち株会の買付日を見つける
		//基準日1、多くは給料日
		paraDTO.setSaraly_01("20");
		//基準日2、多くはボーナス夏
		paraDTO.setBonus_01("06-25");
		//基準日3、多くはボーナス冬
		paraDTO.setBonus_02("12-10");
		//基準日の何営業日あとかのチェック
		paraDTO.setIntCount01(2);
		//勝敗条件
		paraDTO.setWinWariai(1.01);
		paraDTO.setLoseWariai(0.99);
		//持ち株、ボーナス夏、ボーナス冬の設定
		paraDTO.setMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setWinterBonus();
		//前日終値、当日始値
			//当日の始値で買えていそう、当日の終値で売れていそう
		paraDTO.setTOZITU_START();

//		paraDTO.setZENZITU_END();





//		System.out.println("【当日／給料日】");
//		paraDTO.setIntCount01(0);
//		paraDTO.setMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);
//
//		System.out.println("【２日後／給料日】");
//		paraDTO.setIntCount01(2);
//		paraDTO.setMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);
//
//		System.out.println("【当日／夏ボーナス】");
//		paraDTO.setIntCount01(0);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);
//
//		System.out.println("【２日後／冬ボーナス】");
//		paraDTO.setIntCount01(2);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);
//
//		System.out.println("【当日／夏ボーナス】");
//		paraDTO.setIntCount01(0);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);
//
//		System.out.println("【２日後／冬ボーナス】");
//		paraDTO.setIntCount01(2);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setWinterBonus();
//		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO_entry,nowDTO_exit,resultDTO);

		S s = new S();
		s.getCon();

		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO,"2229―T",s);

		//
		s.closeConection();



		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}

	//買いメソッド、売りメソッドを入れると計算してくれる
	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	//引数7:paraDTO
	//引数8:nowDTO
	//引数9:resultDTO
	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){
		S s = new S();
		s.getCon();


		String SQL;
		//全銘柄をリストに入れる
		commonAP.setCodeList(s);
		//forの中のAnalysis_COMMONのなかでS作るため。切断
//		s.closeConection();

		//全銘柄でループする
		for (int i=0;i<commonAP.getCodeList().size();i++){
			String code = commonAP.getCodeList().get(i)[0];
			//メソッド名が不適切な場合、終了します。
			if(Analysis00_Common.Analysis_COMMON(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code,s) == Technique98_CONST.NO_METHOD){
				return;
			};

		}

		System.out.println("トータル勝：" + resultDTO.getTOTAL_WIN());
		System.out.println("トータル負：" + resultDTO.getTOTAL_LOSE());
		System.out.println("トータル  ：" + resultDTO.getTradeCount());

		s.closeConection();

	}

	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	//引数7:paraDTO
	//引数8:nowDTO
	//引数9:resultDTO
	//引数10:開始日
	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String startDay){
		S s = new S();
		s.getCon();



		//全銘柄をリストに入れる
		commonAP.setCodeList(s);
		//forの中のAnalysis_COMMONのなかでS作るため。切断
//		s.closeConection();

		//全銘柄でループする
		for (int i=0;i<commonAP.getCodeList().size();i++){
			String code = commonAP.getCodeList().get(i)[0];
			String SQL = makekabuSQL(code,startDay,s);
			Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, SQL, s);

		}

		System.out.println("トータル勝：" + resultDTO.getTOTAL_WIN());
		System.out.println("トータル負：" + resultDTO.getTOTAL_LOSE());
		System.out.println("トータル  ：" + resultDTO.getTradeCount());

		s.closeConection();

	}



	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	//引数7:paraDTO
	//引数8:nowDTO
	//引数9:resultDTO
	//引数10:コード
	//引数11:s
	public static int Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String code,S s){
		return Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, makekabuSQL(code,s), s);
	}

	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	//引数7:paraDTO
	//引数8:nowDTO
	//引数9:resultDTO
	//引数10:コード
	//引数11:開始日
	//引数12:s
	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String code,String startDay,S s){
		Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, makekabuSQL(code,startDay,s), s);
	}

	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	//引数7:paraDTO
	//引数8:nowDTO
	//引数9:resultDTO
	//引数10:コード
	//引数11:SQL文;指定したcodeの指定した期間、あるいは全期間文のSQL
	//引数12:s
	public static int Analysis_COMMON_main(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String code,String SQL,S s){

		String cate = SQLChecker.getCate(code,s);
		int check_L_method_result;
		int check_S_method_result;
		double kessaiKin01;
		double kessaiKin02;
		String kessaiDay01;
		String kessaiDay02;
		int keepTime;
		try {


			//今の銘柄のコード名、カテゴリを取得する
//			SQL = " select * "
//					+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

			boolean loopCheck = false;

			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				//指定した銘柄の全日付でループする
				while ( s.rs2.next() ) {
					loopCheck = false;
					//今の銘柄
					nowDTO.setCode_01(code);

					//今の銘柄のカテゴリ
					nowDTO.setCateflg_01(cate);
					//nowDTOにいろいろセットする。
					setNowRecord01(code,cate,nowDTO,s.rs2);

					//true:エントリー
					//false:exit
					switch( Analysis00_Common.Analysis_intMethod(L_packageName,L_className,L_methodName,paraDTO,nowDTO,resultDTO,true) ){
						case Technique98_CONST.TRADE_FLG:

						//								System.out.println(code + " :1: " + nowDTO.getNowDay_01());
						//決済が発生した日、決済金額を入れる。
						kessaiKin01 = nowDTO.getKessaiKingaku();
						kessaiDay01 = nowDTO.getKessaiDay();


						//取引の発生した回数
						resultDTO.setTradeCount();

							//買った状態でその銘柄が売れるかチェックする
							while(loopCheck==false && s.rs2.next()){

								//指定銘柄を何日保有していたか
								resultDTO.setKeepCount();
								//今何日保有しているかをnowDTOにいれる。
								nowDTO.setKeepDay(resultDTO.getKeepCount());
								//売る日、売りフラグでなければ次の日へ
								nowDTO.setNowDay_01		(	s.rs2.getString(	COLUMN.DAYTIME	)	);
								nowDTO.setNowCLOSE_01	(	s.rs2.getDouble(	COLUMN.CLOSE	)	);
								setNowRecord01(code,cate,nowDTO,s.rs2);


								switch( Analysis00_Common.Analysis_intMethod(S_packageName,S_className,S_methodName,paraDTO,nowDTO,resultDTO,false) ){



									//勝った場合
									case Technique98_CONST.TRADE_FLG:
										//決済が発生した日、決済金額を入れる。
										kessaiKin02 = nowDTO.getKessaiKingaku();
										kessaiDay02 = nowDTO.getKessaiDay();
										//ループが終わった証を立てる
										loopCheck=true;
										if ( kessaiKin02 - kessaiKin01 > 0){
											//勝った場合
											resultDTO.setWinCount();
											resultDTO.setTOTAL_WIN();
											System.out.println("(勝)" + kessaiDay01 + "／" + kessaiKin01 + "／" + kessaiDay02 + "／" + kessaiKin02 + "／【" + resultDTO.getKeepCount() + "】" + (kessaiKin02 - kessaiKin01) );
										}else{
											//負けた場合
											resultDTO.setLoseCount();
											resultDTO.setTOTAL_LOSE();
											System.out.println("(負)" + kessaiDay01 + "／" + kessaiKin01 + "／" + kessaiDay02 + "／" + kessaiKin02 + "／【" + resultDTO.getKeepCount() + "】"  + (kessaiKin02 - kessaiKin01) );
										}
										resultDTO.reSetKeepCount();
										break;

									//売りメソッドがどこにもない場合
									case Technique98_CONST.NO_METHOD:
										return Technique98_CONST.NO_METHOD;

								}
							}

						break;
						//売りメソッドがどこにもない場合
						case Technique98_CONST.NO_METHOD:
							return Technique98_CONST.NO_METHOD;
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
				return Technique98_CONST.METHOD_RESULT;

			} catch (SQLException e) {
				//						e.printStackTrace();
			}

			//				System.out.println("トータル勝：" + resultDTO.getTOTAL_WIN());
			//				System.out.println("トータル負：" + resultDTO.getTOTAL_LOSE());
			//				System.out.println("トータル  ：" + resultDTO.getTradeCount());

		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
			try {
				s.rs2.close();
				s.reCon();
				System.out.println("こことおった");
				//					System.out.println("トータル勝：" + TOTAL_WIN);
				//					System.out.println("トータル負：" + TOTAL_LOSE);
			} catch (SQLException e) {

			}

		}
		return Technique98_CONST.METHOD_RESULT;
	}



	//引数1:コード名。リストテーブルより取得
	//引数2:指定期間;開始(yyyy-mm-dd)
	//引数3:指定期間;終了(yyyy-mm-dd)
	//引数4:s
	public static String makekabuSQL(String code,S s){
		String cate = SQLChecker.getCate(code,s);
		return " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";
	}

	public static String makekabuSQL(String code,String startDay,S s){
		String cate = SQLChecker.getCate(code,s);
		return " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'"
				+ " and "
				+ COLUMN.DAYTIME + " >= '" + startDay + "'";
	}

	public static String makekabuSQL(String code,String startDay,String endDay,S s){
		String cate = SQLChecker.getCate(code,s);
		return " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'"
		+ " and "
		+ endDay + " >= '" + COLUMN.DAYTIME + "'"
		+ " and "
		+ COLUMN.DAYTIME + " >= '" + startDay + "'";
	}


	//true:エントリー
	//false:exit
	public static int Analysis_intMethod(String packageName,String className,String methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,boolean entryCheck){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName( packageName + "." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_Parameta.class,Bean_nowRecord.class,Bean_Result.class,boolean.class };
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m = cl.getMethod(methodName,para);


				// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
				Object[] ob = new Object[] { paraDTO,nowDTO, resultDTO,entryCheck };
				// 引数をいれて実行
				try {
					Object result = m.invoke(cl.newInstance(), ob);
					int intResult = ( int )result;
					return intResult;

				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException
						| InstantiationException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				System.out.println("Analysis_intMethod:メソッド名：" + methodName + "はありません");
				return Technique98_CONST.NO_METHOD;
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return Technique98_CONST.NO_RESULT;

	}

	private static void setNowRecord01(String code,String cate,Bean_nowRecord nowDTO,ResultSet RS){

		try {
			//買った日の最高値、最安、とかいろいろ
			nowDTO.setCode_01(code);
			//買った日

			nowDTO.setNowDay_01		(	RS.getString(COLUMN.DAYTIME		)	);

			switch(cate){
			case ReCord.CODE_01_STOCK:


				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_01		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_01	(	RS.getDouble(	COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_01	(	RS.getDouble(	COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_01	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_01	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_01	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_01	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_01	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_01	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_01	(	RS.getDouble(	COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_01	(	RS.getDouble(	COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_01	(	RS.getDouble(	COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));
//				nowDTO.setNowCREDIT_LONG_01(RS.getDouble(	COLUMN.CREDIT_LONG		));
//				nowDTO.setNowCREDIT_SHORT_01(RS.getDouble(	COLUMN.CREDIT_SHORT		));
//				nowDTO.setNowCREDIT_RATIO_01(RS.getDouble(	COLUMN.CREDIT_RATIO		));
//				nowDTO.setNowCREDIT_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
//				nowDTO.setNowCREDIT_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
//				nowDTO.setNowCREDIT_RATIO_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_01(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_01(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_01(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_01(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_01(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_01(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_01(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_01(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_01(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_01(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_01(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_02_SATISTICS:


				nowDTO.setNowSTOCK_NAME_NUM_01(RS.getDouble(	COLUMN.STOCK_NAME_NUM		));
				nowDTO.setNowSTOCK_NOCOMPARE_01(RS.getDouble(	COLUMN.STOCK_NOCOMPARE		));
				nowDTO.setNowSTOCK_DOWNSTOCK_01(RS.getDouble(	COLUMN.STOCK_DOWNSTOCK		));

				nowDTO.setNowNETUKI_MAXMIN_01(RS.getDouble(	COLUMN.NETUKI_MAXMIN		));
				nowDTO.setNowNETUKI_MAXMINRATIO_01(RS.getDouble(	COLUMN.NETUKI_MAXMINRATIO		));


				nowDTO.setNowSTOCK_GETPRICE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE		));
				nowDTO.setNowSTOCK_GETPRICE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_RATIO_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_RATIO_01(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

				nowDTO.setNowBAYBAY_01(RS.getDouble(	COLUMN.BAYBAY		));
				nowDTO.setNowBAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.BAYBAY_CHANGERATE		));
				nowDTO.setNowBAYBAY_RATIO_01(RS.getDouble(	COLUMN.BAYBAY_RATIO		));
				nowDTO.setNowSHORTIDO_BAYBAY_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY		));
				nowDTO.setNowLONGIDO_BAYBAY_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY		));
				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));

				nowDTO.setNowDEKI_01(RS.getDouble(	COLUMN.DEKI		));
				nowDTO.setNowDEKI_CHANGERATE_01(RS.getDouble(	COLUMN.DEKI_CHANGERATE		));
				nowDTO.setNowDEKI_RATIO_01(RS.getDouble(	COLUMN.DEKI_RATIO		));
				nowDTO.setNowSHORTIDO_DEKI_01(RS.getDouble(	COLUMN.SHORTIDO_DEKI		));
				nowDTO.setNowMIDDLEIDO_DEKI_01(RS.getDouble(	COLUMN.MIDDLEIDO_DEKI		));
				nowDTO.setNowLONGIDO_DEKI_01(RS.getDouble(	COLUMN.LONGIDO_DEKI		));
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);




				nowDTO.setNowSTOCK_UPSTOCK_01(RS.getDouble(	COLUMN.STOCK_UPSTOCK		));
				nowDTO.setNowSTOCK_UPPRICE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_RATIO_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_RATIO_01(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


				nowDTO.setNowSTOCK_NOCHANGE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE		));
				nowDTO.setNowSTOCK_NOCHANGE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_RATIO_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_01(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));

				break;
			case ReCord.CODE_03_INDEX:


				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_01		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	COLUMN.CLOSE	)	);

				nowDTO.setNowCHANGE_PRICE_01	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_01	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_01	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_01	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_01	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_01	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_01	(	RS.getDouble(	COLUMN.WINDOW	)	);

//				nowDTO.setNowCREDIT_LONG_01(RS.getDouble(	COLUMN.CREDIT_LONG		));
//				nowDTO.setNowCREDIT_SHORT_01(RS.getDouble(	COLUMN.CREDIT_SHORT		));
//				nowDTO.setNowCREDIT_RATIO_01(RS.getDouble(	COLUMN.CREDIT_RATIO		));
//				nowDTO.setNowCREDIT_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
//				nowDTO.setNowCREDIT_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
//				nowDTO.setNowCREDIT_RATIO_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_01(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_01(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_01(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_01(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_01(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_01(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_01(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_01(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_01(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_01(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_01(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_04_ETF:

				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_01		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_01	(	RS.getDouble(	COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_01	(	RS.getDouble(	COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_01	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_01	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_01	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_01	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_01	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_01	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_01	(	RS.getDouble(	COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_01	(	RS.getDouble(	COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_01	(	RS.getDouble(	COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_01	(	RS.getDouble(	COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));
//				nowDTO.setNowCREDIT_LONG_01(RS.getDouble(	COLUMN.CREDIT_LONG		));
//				nowDTO.setNowCREDIT_SHORT_01(RS.getDouble(	COLUMN.CREDIT_SHORT		));
//				nowDTO.setNowCREDIT_RATIO_01(RS.getDouble(	COLUMN.CREDIT_RATIO		));
//				nowDTO.setNowCREDIT_LONG_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
//				nowDTO.setNowCREDIT_SHORT_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
//				nowDTO.setNowCREDIT_RATIO_CHANGERATE_01(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_01(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_01(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_01(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_01(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_01(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_01(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_01(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_01(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_01(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_01(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_01(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_01(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_01(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_01(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_05_SAKIMONO:

				break;
			case ReCord.CODE_06_CURRENCY:

				break;
			default:
				System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
				break;
			}


		} catch (SQLException e) {
			//
			System.out.println("setNowRecord01でなんかミスった"+code);
			e.printStackTrace();
		}

	}


	public static void setNowRecord02(String code,String cate,Bean_nowRecord nowDTO,ResultSet RS){

		try {
			//買った日の最高値、最安、とかいろいろ
			nowDTO.setCode_02(code);
			//買った日

			nowDTO.setNowDay_02		(	RS.getString(COLUMN.DAYTIME		)	);
			switch(cate){
			case ReCord.CODE_01_STOCK:


				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_02		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_02		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_02	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_02	(	RS.getDouble(	COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_02	(	RS.getDouble(	COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_02	(	RS.getDouble(	COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_02	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_02	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_02	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_02	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_02	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_02	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_02	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_02	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_02	(	RS.getDouble(	COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_02	(	RS.getDouble(	COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_02	(	RS.getDouble(	COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));
				nowDTO.setNowCREDIT_LONG_02(RS.getDouble(	COLUMN.CREDIT_LONG		));
				nowDTO.setNowCREDIT_SHORT_02(RS.getDouble(	COLUMN.CREDIT_SHORT		));
				nowDTO.setNowCREDIT_RATIO_02(RS.getDouble(	COLUMN.CREDIT_RATIO		));
				nowDTO.setNowCREDIT_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
				nowDTO.setNowCREDIT_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
				nowDTO.setNowCREDIT_RATIO_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_02(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_02(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_02(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_02(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_02(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_02(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_02(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_02(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_02(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_02(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_02(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_02_SATISTICS:


				nowDTO.setNowSTOCK_NAME_NUM_02(RS.getDouble(	COLUMN.STOCK_NAME_NUM		));
				nowDTO.setNowSTOCK_NOCOMPARE_02(RS.getDouble(	COLUMN.STOCK_NOCOMPARE		));
				nowDTO.setNowSTOCK_DOWNSTOCK_02(RS.getDouble(	COLUMN.STOCK_DOWNSTOCK		));

				nowDTO.setNowNETUKI_MAXMIN_02(RS.getDouble(	COLUMN.NETUKI_MAXMIN		));
				nowDTO.setNowNETUKI_MAXMINRATIO_02(RS.getDouble(	COLUMN.NETUKI_MAXMINRATIO		));


				nowDTO.setNowSTOCK_GETPRICE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE		));
				nowDTO.setNowSTOCK_GETPRICE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_RATIO_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_RATIO_02(RS.getDouble(	COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

				nowDTO.setNowBAYBAY_02(RS.getDouble(	COLUMN.BAYBAY		));
				nowDTO.setNowBAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.BAYBAY_CHANGERATE		));
				nowDTO.setNowBAYBAY_RATIO_02(RS.getDouble(	COLUMN.BAYBAY_RATIO		));
				nowDTO.setNowSHORTIDO_BAYBAY_02(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_02(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY		));
				nowDTO.setNowLONGIDO_BAYBAY_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY		));
				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));

				nowDTO.setNowDEKI_02(RS.getDouble(	COLUMN.DEKI		));
				nowDTO.setNowDEKI_CHANGERATE_02(RS.getDouble(	COLUMN.DEKI_CHANGERATE		));
				nowDTO.setNowDEKI_RATIO_02(RS.getDouble(	COLUMN.DEKI_RATIO		));
				nowDTO.setNowSHORTIDO_DEKI_02(RS.getDouble(	COLUMN.SHORTIDO_DEKI		));
				nowDTO.setNowMIDDLEIDO_DEKI_02(RS.getDouble(	COLUMN.MIDDLEIDO_DEKI		));
				nowDTO.setNowLONGIDO_DEKI_02(RS.getDouble(	COLUMN.LONGIDO_DEKI		));
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);




				nowDTO.setNowSTOCK_UPSTOCK_02(RS.getDouble(	COLUMN.STOCK_UPSTOCK		));
				nowDTO.setNowSTOCK_UPPRICE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_RATIO_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_RATIO_02(RS.getDouble(	COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


				nowDTO.setNowSTOCK_NOCHANGE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE		));
				nowDTO.setNowSTOCK_NOCHANGE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_RATIO_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
				nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_02(RS.getDouble(	COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));

				break;
			case ReCord.CODE_03_INDEX:


				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_02		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_02		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_02	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_02	(	RS.getDouble(	COLUMN.CLOSE	)	);

				nowDTO.setNowCHANGE_PRICE_02	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_02	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_02	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_02	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_02	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_02	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_02	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_02	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_02	(	RS.getDouble(	COLUMN.WINDOW	)	);

				nowDTO.setNowCREDIT_LONG_02(RS.getDouble(	COLUMN.CREDIT_LONG		));
				nowDTO.setNowCREDIT_SHORT_02(RS.getDouble(	COLUMN.CREDIT_SHORT		));
				nowDTO.setNowCREDIT_RATIO_02(RS.getDouble(	COLUMN.CREDIT_RATIO		));
				nowDTO.setNowCREDIT_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
				nowDTO.setNowCREDIT_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
				nowDTO.setNowCREDIT_RATIO_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_02(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_02(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_02(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_02(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_02(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_02(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_02(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_02(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_02(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_02(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_02(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_04_ETF:

				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_02		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_02		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_02	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_02	(	RS.getDouble(	COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_02	(	RS.getDouble(	COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_02	(	RS.getDouble(	COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_02	(	RS.getDouble(	COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_02	(	RS.getDouble(	COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_02	(	RS.getDouble(	COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_02	(	RS.getDouble(	COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_02	(	RS.getDouble(	COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_02	(	RS.getDouble(	COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_02	(	RS.getDouble(	COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_02	(	RS.getDouble(	COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_02	(	RS.getDouble(	COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_02	(	RS.getDouble(	COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_02	(	RS.getDouble(	COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_02	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_02	(	RS.getDouble(	COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_02	(	RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));
				nowDTO.setNowCREDIT_LONG_02(RS.getDouble(	COLUMN.CREDIT_LONG		));
				nowDTO.setNowCREDIT_SHORT_02(RS.getDouble(	COLUMN.CREDIT_SHORT		));
				nowDTO.setNowCREDIT_RATIO_02(RS.getDouble(	COLUMN.CREDIT_RATIO		));
				nowDTO.setNowCREDIT_LONG_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_LONG_CHANGERATE		));
				nowDTO.setNowCREDIT_SHORT_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_SHORT_CHANGERATE		));
				nowDTO.setNowCREDIT_RATIO_CHANGERATE_02(RS.getDouble(	COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_02(RS.getDouble(	COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_02(RS.getDouble(	COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_02(RS.getDouble(	COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_02(RS.getDouble(	COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_02(RS.getDouble(	COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_02(RS.getDouble(	COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_02(RS.getDouble(	COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_02(RS.getDouble(	COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_02(RS.getDouble(	COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_02(RS.getDouble(	COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_02(RS.getDouble(	COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_02(RS.getDouble(	COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_02(RS.getDouble(	COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_02(RS.getDouble(	COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_02(RS.getDouble(	COLUMN.LONG_MACD_SIGNAL		));


				break;
			case ReCord.CODE_05_SAKIMONO:

				break;
			case ReCord.CODE_06_CURRENCY:

				break;
			default:
				System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
				break;
			}


		} catch (SQLException e) {
			//
			System.out.println("setNowRecord01でなんかミスった");
			e.printStackTrace();
		}

	}
}
