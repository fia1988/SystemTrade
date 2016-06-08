package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
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
import constant.ReCord;

public class Analysis00_Common {

	public static void sagyoSpace(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		//checkDeki_L設定部分
		paraDTO.setTerm01(60);
		paraDTO.setTerm02(10);
		//変化していないの定義。TERM01と02の合計期間の出来高前日比率のSTDDEV_SAMP。すなわち「どのぐらい変化していないか」。0でまったく変化していない。初期値1.5
		paraDTO.setBOXCHECK(1.5);
		//スコア。変化率でスコアを設定している。その点数。初期値0.7
		paraDTO.setHIGHT_DEKI_RATIO(1.5);
		//checkPrice_S設定部分
		paraDTO.setWinWariai(1.1);
		paraDTO.setLoseWariai(0.95);

		Analysis_COMMON("technique","Technique01","checkDeki_L","technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO);


		Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO);
	}

	//買いメソッド、売りメソッドを入れると計算してくれる
	//引数1:買いメソッドのパッケージ名
	//引数2:買いメソッドのクラス名
	//引数3:買いメソッドのメソッド名
	//引数4:売りメソッドのパッケージ名
	//引数5:売りメソッドのクラス名
	//引数6:売りメソッドのメソッド名
	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){
		S s = new S();
		s.getCon();


		long start = System.currentTimeMillis();

		String SQL;


		SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {

			//全銘柄をリストに入れる
			commonAP.setCodeList(s);
			//全銘柄でループする
			for (int i=0;i<commonAP.getCodeList().size();i++){
				String cate = commonAP.getCodeList().get(i)[1];
				String code = commonAP.getCodeList().get(i)[0];

				//今の銘柄のコード名、カテゴリを取得する
				SQL = " select * "
						+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

				boolean loopCheck = false;

				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);

					//指定した銘柄の全日付でループする
					while ( s.rs2.next() ) {

						//今の銘柄
						nowDTO.setCode(code);

						//今の銘柄のカテゴリ
						nowDTO.setCateflg(cate);
						//nowDTOにいろいろセットする。
						setNowRecord01(code,cate,nowDTO,s.rs2);

						//ifの中に入ったら買いフラグがたつ
						if( Analysis00_Common.Analysis_intMethod(L_packageName,L_className,L_methodName,paraDTO,nowDTO,resultDTO) ==Technique98_CONST.TRADE_FLG){
							//取引の発生した回数
							resultDTO.setTradeCount();

							//買った状態でその銘柄が売れるかチェックする
							while(loopCheck==false && s.rs2.next()){

								//指定銘柄を何日保有していたか
								resultDTO.setKeepCount();
								//売る日、売りフラグでなければ次の日へ
								nowDTO.setNowDay_02		(	s.rs2.getString(	COLUMN.DAYTIME	)	);
								nowDTO.setNowCLOSE_02	(	s.rs2.getDouble(	COLUMN.CLOSE	)	);
//								Double nowCLOSE = s.rs2.getDouble(COLUMN.CLOSE);
//								String nowDay=s.rs2.getString(COLUMN.DAYTIME);
//								paraDTO.setDayTime01(nowDay);

								switch( Analysis00_Common.Analysis_intMethod(S_packageName,S_className,S_methodName,paraDTO,nowDTO,resultDTO) ){


									//勝った場合
									case Technique98_CONST.WIN_FLG:

										resultDTO.setWinCount();
										resultDTO.setTOTAL_WIN();
										loopCheck=true;

										System.out.println("(勝)" + nowDTO.getNowDay_01() + ":" + nowDTO.getNowCLOSE_01() + "／" + nowDTO.getNowCLOSE_02() + ":" + nowDTO.getNowDay_02() + "／【" + resultDTO.getKeepCount() + "】" );
										resultDTO.reSetKeepCount();
										break;

									//負けた場合
									case Technique98_CONST.LOSE_FLG:
										loopCheck=true;
										resultDTO.setLoseCount();
										resultDTO.setTOTAL_LOSE();
										System.out.println("(負)" + nowDTO.getNowDay_01() + ":" + nowDTO.getNowCLOSE_01() + "／" + nowDTO.getNowDay_02() + ":" + nowDTO.getNowCLOSE_02() + "／【" + resultDTO.getKeepCount() + "】");
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

	public static int Analysis_intMethod(String packageName,String className,String methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName( packageName + "." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_Parameta.class,Bean_nowRecord.class, Bean_Result.class };
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m = cl.getMethod(methodName,para);


				// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
				Object[] ob = new Object[] { paraDTO,nowDTO, resultDTO };
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
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return Technique98_CONST.NO_RESULT;

	}

	public static void setNowRecord01(String code,String cate,Bean_nowRecord nowDTO,ResultSet RS){
		//買った日の最高値、最安、とかいろいろ
		try {
			switch(cate){
			case ReCord.CODE_01_STOCK:
				//買った日
				nowDTO.setNowDay_01		(	RS.getString(COLUMN.DAYTIME		)	);
				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_01		(	RS.getDouble(	COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	COLUMN.CLOSE	)	);				
				break;
			case ReCord.CODE_02_SATISTICS:
				
				break;
			case ReCord.CODE_03_INDEX:
				
				break;
			case ReCord.CODE_04_ETF:
				
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
