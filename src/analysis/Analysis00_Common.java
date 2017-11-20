package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import technique.Technique98_CONST;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Proccesing;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;

public class Analysis00_Common {



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

		paraDTO.setObTerm(commonAP.countDay(ReCord.KOSHINBI_SHOKI,controllDay.getMAX_DD_INDEX(s), s));
		//期間の最初と最後を指定してテストすることを確認するフラグ
		paraDTO.setTermFLG();
		paraDTO.setObStartDay(ReCord.KOSHINBI_SHOKI);
		paraDTO.setObEndDay(controllDay.getMAX_DD_INDEX(s));
		s.closeConection();

		s = new S();
		s.getCon();

		String SQL;
		//全銘柄をリストに入れる
		commonAP.setCodeList(paraDTO.getCheckCate(),s);
//		commonAP.setCodeList(s);
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

		resultDTO.getResultTotalResult(L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO);

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
		paraDTO.setObTerm(commonAP.countDay(startDay,controllDay.getMAX_DD_INDEX(s), s));

		//期間の最初と最後を指定してテストすることを確認するフラグ
		paraDTO.setTermFLG();
		paraDTO.setObStartDay(startDay);
		paraDTO.setObEndDay(controllDay.getMAX_DD_INDEX(s));
		s.closeConection();
		s.getCon();
		s = new S();
		//全銘柄をリストに入れる
		commonAP.setCodeList(paraDTO.getCheckCate(),s);

		//全銘柄でループする
		for (int i=0;i<commonAP.getCodeList().size();i++){
			String code = commonAP.getCodeList().get(i)[0];
			String SQL = makekabuSQL(code,startDay,s,paraDTO,resultDTO);
			Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, SQL, s);

		}

		resultDTO.getResultTotalResult(L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO);
		s.closeConection();

	}

	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String startDay,String endDay){
		S s = new S();
		s.getCon();

		paraDTO.setObTerm(commonAP.countDay(startDay,endDay, s));
		//期間の最初と最後を指定してテストすることを確認するフラグ
		paraDTO.setTermFLG();
		paraDTO.setObStartDay(startDay);
		paraDTO.setObEndDay(endDay);
		s.closeConection();
		s = new S();
		s.getCon();



		//全銘柄をリストに入れる



		ArrayList<String[]> codeListwithiCate = new ArrayList<String[]>();


		if ( paraDTO.getEliteFLG(true) ){
			//エリートフラグオン
			commonAP.setCodeList(L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,"DD",false,s);
//				commonAP.setCodeList(paraDTO.getCheckCate(),s);
		}else{
			//エリートフラグオフ
			commonAP.setCodeList(paraDTO.getCheckCate(),s);
		}

		codeListwithiCate = commonAP.getCodeList();

		//全銘柄でループする
		for (int i=0;i<codeListwithiCate.size();i++){
			String code = codeListwithiCate.get(i)[0];

			if ( paraDTO.getEliteFLG(true) ){
				//エリートフラグがonのとき、セットする。paraとかを
//				resultDTO.setEntryDay(entryDay);E
				paraDTO.setMaxEntryTimes	(	Integer.parseInt(codeListwithiCate.get(i)[2])	);
				paraDTO.setMaxKeepDays		(	Integer.parseInt(codeListwithiCate.get(i)[3])	);
				resultDTO.setMaxInterValTime(	Integer.parseInt(codeListwithiCate.get(i)[4])	);
				paraDTO.setMaxLoss			(	Double.parseDouble(codeListwithiCate.get(i)[5])	);
			}
			String SQL = makekabuSQL(code,startDay,endDay,s,paraDTO,resultDTO);
			Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, SQL, s);

		}

		resultDTO.getResultTotalResult(L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO);
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
		return Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, makekabuSQL(code,s,paraDTO,resultDTO), s);
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
		Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, makekabuSQL(code,startDay,s,paraDTO,resultDTO), s);
	}

	public static void Analysis_COMMON(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,String code,String startDay,String endDay,S s){
		Analysis_COMMON_main(L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, paraDTO, nowDTO, resultDTO, code, makekabuSQL(code,startDay,endDay,s,paraDTO,resultDTO), s);
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

		//リストのクリア
		//paraDTOにセットするテーブル用のメソッドを取得する。

		//ここでファイナンスとか入れる
		Bean_Proccesing B_PRO = new Bean_Proccesing();
		B_PRO.proceccingParaDTO(paraDTO,resultDTO,s);

		int check_L_method_result;
		int check_S_method_result;
		double kessaiKin01;
		double kessaiKin02;
		String kessaiDay01;
		String kessaiDay02;
		int keepTime;

		paraDTO.setLMETHOD(L_packageName + "." + L_className + "." + L_methodName);
		paraDTO.setSMETHOD(S_packageName + "." + S_className + "." + S_methodName);

		try {


			//今の銘柄のコード名、カテゴリを取得する
//			SQL = " select * "
//					+   " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

			boolean loopCheck = false;

			//売買フラグチェックを外す。
			paraDTO.setCheckFLG(false);

			try {
//				System.out.println(SQL);
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				List<Bean_nowRecord> nowDTOList = new ArrayList<>();
				while ( s.rs2.next() ) {
					nowDTOList.add(	setNowRecord(code,cate,s.rs2,paraDTO)	);
				}
				s.rs2.close();
				s.reCon();

				resultDTO.resetCount();
				for (int i = 0 ; i < nowDTOList.size() ; i++){



					loopCheck = false;

					resultDTO.resetEntryList();
					//true:エントリー
					//false:exit

					switch( Analysis00_Common.Analysis_intMethod(L_packageName,L_className,L_methodName,paraDTO,nowDTOList,i,resultDTO,true) ){
						case Technique98_CONST.TRADE_FLG:

						//決済が発生した日、決済金額を入れる。
						resultDTO.setEntryDay(nowDTOList.get(i).getKessaiDay());
						resultDTO.setEntryPrice(nowDTOList.get(i).getKessaiKingaku());
						resultDTO.setLastEntryDay(nowDTOList.get(i).getKessaiDay() + nowDTOList.get(i).getCode_01());
						//取引の発生した回数
						resultDTO.setTradeCount();
						resultDTO.setEntryTime();

						//ドルコスト平均法でも買う
						if (paraDTO.isDollCostFLG()){
							//取得株数。注文するときは今日の終値をもとに数を計算する。ただしこれは理論値
							double getStockVolume = ( paraDTO.getEntryMoney() * 10000 ) / nowDTOList.get(i).getNowCLOSE_01();
							if ( paraDTO.isRealEntryVolumeFLG() ){
								//購入数現実的。切り上げ
								getStockVolume = Math.ceil(getStockVolume);
							}
							String nowDay = nowDTOList.get(i + 1).getNowDay_01();
							nowDay = nowDay.replaceAll("-", "");
							double douNowDay = Double.parseDouble(nowDay);
							//購買金額。明日の始値で買うのだ
							resultDTO.setDollerStockVolume(getStockVolume, nowDTOList.get(i + 1).getNowOpen_01(),douNowDay);

						}

						//次の日に
						i++;
//						System.out.println("b" + nowDTOList.get(i).getNowDay_01());

						//買った状態でその銘柄が売れるかチェックする
						while(loopCheck==false && i < nowDTOList.size()){
							//指定銘柄を何日保有していたか
							resultDTO.setKeepCount();
							//今何日保有しているかをnowDTOにいれる。
							nowDTO.setKeepDay(resultDTO.getKeepCount());

//							boolean checkSameDay = false;

							//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
							if (paraDTO.getCheckRenzokuSign()){
								switch( Analysis00_Common.Analysis_intMethod(L_packageName,L_className,L_methodName,paraDTO,nowDTOList,i,resultDTO,true) ){
									case Technique98_CONST.TRADE_FLG:
										//決済が発生した日、決済金額を入れる。
										resultDTO.setEntryDay(nowDTOList.get(i).getKessaiDay());
										resultDTO.setEntryPrice(nowDTOList.get(i).getKessaiKingaku());
										resultDTO.setEntryTime();
										resultDTO.setLastEntryDay(nowDTOList.get(i).getKessaiDay() + nowDTOList.get(i).getCode_01());
										//ドルコスト平均法でも買う
										if (paraDTO.isDollCostFLG()){
											//取得株数。注文するときは今日の終値をもとに数を計算する。ただしこれは理論値
											double getStockVolume = ( paraDTO.getEntryMoney() * 10000 ) / nowDTOList.get(i).getNowCLOSE_01();
											if ( paraDTO.isRealEntryVolumeFLG() ){
												//購入数現実的。切り上げ
												getStockVolume = Math.ceil(getStockVolume);
											}
											String nowDay = nowDTOList.get(i + 1).getNowDay_01();
											nowDay = nowDay.replaceAll("-", "");
											double douNowDay = Double.parseDouble(nowDay);
											//購買金額。明日の始値で買うのだ
											resultDTO.setDollerStockVolume(getStockVolume, nowDTOList.get(i + 1).getNowOpen_01(),douNowDay);
										}

//										checkSameDay = true;
										//取引の発生した回数
//										resultDTO.setTradeCount();
										break;
									case Technique98_CONST.NO_METHOD:
										return Technique98_CONST.NO_METHOD;
									case Technique98_CONST.NO_RESULT:
										return Technique98_CONST.NO_RESULT;
									//売りメソッドがどこにもない場合
								}
							}

							//売りと買いが同じ日に出ているかをチェックする。同じ日に出ていたらエントリータイムを一つ減らす。
//							if (checkSameDay==true){
//								resultDTO.setEntryTimeMinus();
//							}

							switch( Analysis00_Common.Analysis_intMethod(S_packageName,S_className,S_methodName,paraDTO,nowDTOList,i,resultDTO,false) ){


								case Technique98_CONST.TRADE_FLG:
									//決済が発生した日、決済金額を入れる。
									resultDTO.setExitDay(nowDTOList.get(i).getKessaiDay());
									resultDTO.setExitPrice(nowDTOList.get(i).getKessaiKingaku());
									resultDTO.setLastExitDay(nowDTOList.get(i).getKessaiDay() + nowDTOList.get(i).getCode_01());
									//ドルコスト平均法での売り
									if (paraDTO.isDollCostFLG()){
										String nowDay = nowDTOList.get(i).getNowDay_01();
										nowDay = nowDay.replaceAll("-", "");
										double douNowDay = Double.parseDouble(nowDay);

										//売った日を保有します。
										resultDTO.setDoubleDaytime(douNowDay);

									}


									//ループが終わった証を立てる
									loopCheck=true;
									//その日の結論を出す。
									resultDTO.getResultDayResult(code,paraDTO);
									//下で一日増やすので減らしておく
									if ( resultDTO.isMaxLossFLG() == false){
										i--;
									}else{
										resultDTO.setMaxLossFLG(false);
									}


									//売買フラグチェックを外す。
									paraDTO.setCheckFLG(false);

									break;

								case Technique98_CONST.NO_RESULT:
									return Technique98_CONST.NO_RESULT;
							//売りメソッドがどこにもない場合
								case Technique98_CONST.NO_METHOD:
									return Technique98_CONST.NO_METHOD;
							}

							//次の日に
							i++;
						}

						break;

						case Technique98_CONST.NO_RESULT:
							return Technique98_CONST.NO_RESULT;

						//売りメソッドがどこにもない場合
						case Technique98_CONST.NO_METHOD:
							return Technique98_CONST.NO_METHOD;
					}

				}


				//銘柄の結果を出す
				resultDTO.getResultCodeResult(code,paraDTO);

				return Technique98_CONST.METHOD_RESULT;


				//------------------------------------------------------------------------------------------------------------------------------------------
			} catch (SQLException e) {
				//						e.printStackTrace();
			}
//			resultDTO.getResultTotalResult(L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName);


		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
			try {
				s.rs2.close();
				s.reCon();
				System.out.println("Analysis_COMMON_main:こことおった");
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
	//01_stock_dd a
	//00_codelisttbl b
	//02_statistics_dd c
	//株：日経平均、JASDAC平均、なんちゃら400
	//指数：自己結合；日経平均、JASDAC平均、なんちゃら400
	public static String makekabuSQL(String code,S s,Bean_Parameta paraDTO,Bean_Result resultDTO){

		String cate = SQLChecker.getCate(code,s);

		String SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

		//ここをなおす
//		 select * from 01_STOCK_DD b left outer join 21_financialTBL_MM a  on  a.daytime = b.daytime  where left(b.code,4) = '1518' and  ( a.codeName is not null and a.KESSAN_TERM_YYYY_MM_STRING is not null and a.YEAR_KESSAN_TIME_YYYYMMDD is not null and a.URIAGE_DAKA_PPT is not null and a.EIGYO_PROF_PPT is not null and a.KEIJO_PROF_PPT is not null and a.BOTTOM_LINE_PPT is not null and a.TOTAL_ASSET_PPT is not null and a.SELF_ASSET_PPT is not null and a.SHIHONKIN_ASSET_PPT is not null and a.LOAN_PPT is not null and a.SELF_ASSET_WARIAI is not null and a.ROE is not null and a.ROA is not null and a.STOCK_NUM )

		//株の時だけ挙動が違う
		switch(cate){
			case ReCord.CODE_01_STOCK:


				SQL = " select * from "
						+	SQLChecker.getTBL(cate) + " " + ReCord.STOCK_TBK_DD_A + " "

						+	" left outer join " + TBL_Name.CODELISTTBL + " " + ReCord.CODELIST_B + " "
						+	" on " +  ReCord.STOCK_TBK_DD_A + "." + COLUMN.CODE + " = " + ReCord.CODELIST_B + "." + COLUMN.CODE

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_02_SATISTICS) + " " + ReCord.STATISTICS_DD_C + " "
						+	" on " + ReCord.CODELIST_B +  "." + COLUMN.CATEGORY  + "= " + ReCord.STATISTICS_DD_C + "." +  COLUMN.CODE + " and  " + ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME + " = " + ReCord.STATISTICS_DD_C +"." + COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_NIKKE_AVE + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_NIKKE_AVE + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX + "." +  COLUMN.DAYTIME

//						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_JPX400 + " "
//						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_JPX400 + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_CORE30 + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_CORE30 + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX100 + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX100 + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX_SMALL + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." +  COLUMN.DAYTIME

//						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_ASIA + " "
//						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_ASIA + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_JASDAC + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_JASDAC + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_02_SATISTICS) + " " + ReCord.STATISTICS_NIKKE01_DD_CC + " "
						+	" on " + ReCord.STOCK_TBK_DD_A +  "." + COLUMN.DAYTIME  + "= " + ReCord.STATISTICS_NIKKE01_DD_CC + "." +  COLUMN.DAYTIME


						+	" where "
						+	ReCord.STOCK_TBK_DD_A + "." + COLUMN.CODE + " = '" + code + "' and "
						+	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CODE + " = '" + ReCord.indexName_I101 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CODE + " = '" + ReCord.indexName_I102 + "' and "
//						+	ReCord.INDEX_TBK_DD_JPX400 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I103 + "' and "
						+	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I111 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I113 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CODE + " = '" + ReCord.indexName_I116 + "' and "
//						+	ReCord.INDEX_TBK_DD_ASIA + "." + COLUMN.CODE + " = '" + ReCord.indexName_I131 + "' and "
						+	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CODE + " = '" + ReCord.indexName_I306 + "' and "
						+	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.CODE + " = '" + ReCord.TOSYO_01 + "'"
						;


				break;
			case ReCord.CODE_02_SATISTICS:

				break;
			case ReCord.CODE_03_INDEX:

				break;
			case ReCord.CODE_04_ETF:
				SQL = " select * from "
						+	SQLChecker.getTBL(cate) + " " + ReCord.ETF_DD_E + " "
						+	" left outer join " + TBL_Name.CODELISTTBL + " " + ReCord.CODELIST_B + " "
						+	" on " +  ReCord.ETF_DD_E + "." + COLUMN.CODE + " = " + ReCord.CODELIST_B + "." + COLUMN.CODE
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_02_SATISTICS) + " " + ReCord.STATISTICS_DD_C + " "
						+	" on " + ReCord.CODELIST_B +  "." + COLUMN.CATEGORY  + "= " + ReCord.STATISTICS_DD_C + "." +  COLUMN.CODE + " and  " + ReCord.ETF_DD_E + "." + COLUMN.DAYTIME + " = " + ReCord.STATISTICS_DD_C +"." + COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_NIKKE_AVE + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_NIKKE_AVE + "." +  COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX + "." +  COLUMN.DAYTIME
//						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_JPX400 + " "
//						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_JPX400 + "." +  COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_CORE30 + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_CORE30 + "." +  COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX100 + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX100 + "." +  COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_TOPIX_SMALL + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." +  COLUMN.DAYTIME
//						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_ASIA + " "
//						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_ASIA + "." +  COLUMN.DAYTIME
						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_03_INDEX) + " " + ReCord.INDEX_TBK_DD_JASDAC + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.INDEX_TBK_DD_JASDAC + "." +  COLUMN.DAYTIME

						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_02_SATISTICS) + " " + ReCord.STATISTICS_NIKKE01_DD_CC + " "
						+	" on " + ReCord.ETF_DD_E +  "." + COLUMN.DAYTIME  + "= " + ReCord.STATISTICS_NIKKE01_DD_CC + "." +  COLUMN.DAYTIME

						+	" where "
						+	ReCord.ETF_DD_E + "." + COLUMN.CODE + " = '" + code + "' and "
						+	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CODE + " = '" + ReCord.indexName_I101 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CODE + " = '" + ReCord.indexName_I102 + "' and "
//						+	ReCord.INDEX_TBK_DD_JPX400 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I103 + "' and "	//2014
						+	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I111 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CODE + " = '" + ReCord.indexName_I113 + "' and "
						+	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CODE + " = '" + ReCord.indexName_I116 + "' and "
//						+	ReCord.INDEX_TBK_DD_ASIA + "." + COLUMN.CODE + " = '" + ReCord.indexName_I131 + "' and "	//2011
						+	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CODE + " = '" + ReCord.indexName_I306 + "' and "
						+	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.CODE + " = '" + ReCord.TOSYO_01 + "'"
						;
//				System.out.println(SQL);
//				SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

				break;
			case ReCord.CODE_05_SAKIMONO:
				break;
			case ReCord.CODE_06_CURRENCY:
				break;
			default:
				break;
		}
//		SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'";

		return SQL;
	}




	public static String makekabuSQL(String code,String startDay,S s,Bean_Parameta paraDTO,Bean_Result resultDTO){
		String cate = SQLChecker.getCate(code,s);


//		String SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'"
//				+ " and "
//				+ COLUMN.DAYTIME + " >= '" + startDay + "'";

		String SQL = makekabuSQL(code,s,paraDTO,resultDTO) + " and "+ COLUMN.DAYTIME + " >= '" + startDay + "'";


		switch(cate){
			case ReCord.CODE_01_STOCK:
//				SQL = " select * from "
//						+	SQLChecker.getTBL(cate) + " " + ReCord.STOCK_TBK_DD_A + " "
//						+	" left outer join " + TBL_Name.CODELISTTBL + " " + ReCord.CODELIST_B + " "
//						+	" on " +  ReCord.STOCK_TBK_DD_A + "." + COLUMN.CODE + " = " + ReCord.CODELIST_B + "." + COLUMN.CODE
//						+	" left outer join " + SQLChecker.getTBL(ReCord.CODE_02_SATISTICS) + " " + ReCord.STATISTICS_DD_C + " "
//						+	" on " + ReCord.CODELIST_B +  "." + COLUMN.CATEGORY  + "= " + ReCord.STATISTICS_DD_C + "." +  COLUMN.CODE + " and  " + ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME + " = " + ReCord.STATISTICS_DD_C +"." + COLUMN.DAYTIME
//						+	" where " + ReCord.STOCK_TBK_DD_A + "." + COLUMN.CODE + " = '" + code + "' and " +ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME + " >= '" + startDay + "'";

				SQL = makekabuSQL(code,s,paraDTO,resultDTO) + " and " +	ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME + " >= '" + startDay + "'";
//				SQL = makekabuSQL(code,s) + " and "+ COLUMN.DAYTIME + " >= '" + startDay + "'";
				break;
			case ReCord.CODE_02_SATISTICS:

				break;
			case ReCord.CODE_03_INDEX:

				break;
			case ReCord.CODE_04_ETF:

				SQL = makekabuSQL(code,s,paraDTO,resultDTO) + " and " +	ReCord.ETF_DD_E + "." + COLUMN.DAYTIME + " >= '" + startDay + "'";
//				SQL = " select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'"
//						+ " and "
//						+ COLUMN.DAYTIME + " >= '" + startDay + "'";
				break;
			case ReCord.CODE_05_SAKIMONO:
				break;
			case ReCord.CODE_06_CURRENCY:
				break;
			default:
				break;
		}
//		SQL = makekabuSQL(code,s) + " and "+ COLUMN.DAYTIME + " >= '" + startDay + "'";
//		System.out.println(SQL);
		return  SQL;
	}

	public static String makekabuSQL(String code,String startDay,String endDay,S s,Bean_Parameta paraDTO,Bean_Result resultDTO){
		String cate = SQLChecker.getCate(code,s);

		String SQL=" select * " + " from " + SQLChecker.getTBL(cate) + " where " + COLUMN.CODE + "='" + code +  "'"
				+ " and "
				+ "'" +  endDay + "' >= " + COLUMN.DAYTIME + ""
				+ " and "
				+ COLUMN.DAYTIME + " >= '" + startDay + "'";

		SQL = makekabuSQL(code,startDay,s,paraDTO,resultDTO) + " and "+ "'" +  endDay + "' >= " + COLUMN.DAYTIME + "";


		switch(cate){
			case ReCord.CODE_01_STOCK:
				SQL = makekabuSQL(code,startDay,s,paraDTO,resultDTO) + " and "	+ "'" +  endDay + "' >= " + ReCord.STOCK_TBK_DD_A +"." + COLUMN.DAYTIME + "";
				break;
			case ReCord.CODE_02_SATISTICS:

				break;
			case ReCord.CODE_03_INDEX:

				break;
			case ReCord.CODE_04_ETF:
				SQL = makekabuSQL(code,startDay,s,paraDTO,resultDTO) + " and "	+ "'" +  endDay + "' >= " + ReCord.ETF_DD_E +"." + COLUMN.DAYTIME + "";
				break;
			case ReCord.CODE_05_SAKIMONO:
				break;
			case ReCord.CODE_06_CURRENCY:
				break;
			default:
				break;
		}


		return SQL;
	}


	//true:エントリー
	//false:exit
	public static int Analysis_intMethod(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean entryCheck){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName( packageName + "." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_Parameta.class , List.class , int.class , Bean_Result.class , boolean.class };
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m = cl.getMethod(methodName,para);


				// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
				Object[] ob = new Object[] { paraDTO,nowDTOList,nowDTOadress,resultDTO,entryCheck };
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

	public static Bean_nowRecord setNowRecord(String code,String cate,ResultSet RS,Bean_Parameta paraDTO){
//	public static void setNowRecord(String code,String cate,Bean_nowRecord nowDTO ,ResultSet RS){
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		try {
			//買った日の最高値、最安、とかいろいろ
			nowDTO.setCode_01(code);
			nowDTO.setCateflg_01(cate);


			switch(cate){
			case ReCord.CODE_01_STOCK:



				nowDTO.setNowDay_01		(	RS.getString( ReCord.STOCK_TBK_DD_A + "." + COLUMN.DAYTIME		)	);

				 //01_stock_dd a
				 //00_codelisttbl b
				 //02_statistics_dd c

				//買った日の最高値、最安、とかいろいろ

				nowDTO.setNowMAX_01		(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_BAYBAY_RATIO		));
//				nowDTO.setNowCREDIT_LONG_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_LONG		));
//				nowDTO.setNowCREDIT_SHORT_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_SHORT		));
//				nowDTO.setNowCREDIT_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_RATIO		));
//				nowDTO.setNowCREDIT_LONG_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//				nowDTO.setNowCREDIT_SHORT_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//				nowDTO.setNowCREDIT_RATIO_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_01(RS.getDouble(	 ReCord.STOCK_TBK_DD_A + "." + COLUMN.LONG_MACD_SIGNAL		));


				//統計データを取得するかどうか
				if (paraDTO.isFlg02_statics()==true){
					//codelist部分
					nowDTO.setMarket(RS.getString(	 ReCord.CODELIST_B + "." + COLUMN.MARKET		));

					//統計データ部分
					nowDTO.setNowSTOCK_NAME_NUM_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NAME_NUM		));
					nowDTO.setNowSTOCK_NOCOMPARE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCOMPARE		));
					nowDTO.setNowSTOCK_DOWNSTOCK_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_DOWNSTOCK		));

					nowDTO.setNowNETUKI_MAXMIN_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.NETUKI_MAXMIN		));
					nowDTO.setNowNETUKI_MAXMINRATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.NETUKI_MAXMINRATIO		));


					nowDTO.setNowSTOCK_GETPRICE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE		));
					nowDTO.setNowSTOCK_GETPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

					nowDTO.setNowSATISTICS_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY		));
					nowDTO.setNowSATISTICS_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI		));
					nowDTO.setNowSATISTICS_DEKI_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI_CHANGERATE		));
					nowDTO.setNowSATISTICS_DEKI_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI_RATIO		));
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI		));
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI		));
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI_RATIO	)	);
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI_RATIO	)	);


					nowDTO.setNowSTOCK_UPSTOCK_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPSTOCK		));
					nowDTO.setNowSTOCK_UPPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


					nowDTO.setNowSTOCK_NOCHANGE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE		));
					nowDTO.setNowSTOCK_NOCHANGE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));

					//東証一部、統計部分
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NAME_NUM_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NAME_NUM		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCOMPARE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCOMPARE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_DOWNSTOCK		));

					nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMIN_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.NETUKI_MAXMIN		));
					nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.NETUKI_MAXMINRATIO		));


					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI_RATIO	)	);
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI_RATIO	)	);


					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPSTOCK_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPSTOCK		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));


					//日経平均
					nowDTO.setNow_NIKKE_AVEMAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAX		)	);
					nowDTO.setNow_NIKKE_AVEMIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIN		)	);
					nowDTO.setNow_NIKKE_AVEOpen_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_NIKKE_AVECLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_NIKKE_AVECHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_NIKKE_AVECHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_NIKKE_AVESHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_NIKKE_AVELONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_NIKKE_AVESHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVELONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVEMAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_NIKKE_AVEMAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_NIKKE_AVECANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_NIKKE_AVECANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_NIKKE_AVEWINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_NIKKE_AVECREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_NIKKE_AVECREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_NIKKE_AVECREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_NIKKE_AVECREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_NIKKE_AVECREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_NIKKE_AVECREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_NIKKE_AVESHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_NIKKE_AVESHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_NIKKE_AVELONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVESHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_NIKKE_AVESHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_NIKKE_AVELONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_NIKKE_AVELONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX
					nowDTO.setNow_TOPIX_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_MACD_SIGNAL		));

					//core30
					nowDTO.setNow_CORE30_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAX		)	);
					nowDTO.setNow_CORE30_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIN		)	);
					nowDTO.setNow_CORE30_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_CORE30_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_CORE30_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_CORE30_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_CORE30_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_CORE30_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_CORE30_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_CORE30_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_CORE30_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_CORE30_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_CORE30_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_CORE30_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_CORE30_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_CORE30_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_CORE30_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_CORE30_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_CORE30_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_CORE30_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_CORE30_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_CORE30_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_CORE30_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_CORE30_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_CORE30_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_CORE30_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_CORE30_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_CORE30_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_CORE30_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_CORE30_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX_SMALL
					nowDTO.setNow_TOPIX_SMALL_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX_SMALL_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX_SMALL_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX_SMALL_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX_SMALL_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX_SMALL_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX_SMALL_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX_SMALL_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX_SMALL_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX_SMALL_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX_SMALL_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX_SMALL_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX_SMALL_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_SMALL_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX_SMALL_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX100
					nowDTO.setNow_TOPIX100_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX100_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX100_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX100_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX100_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX100_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX100_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX100_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX100_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX100_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX100_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX100_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX100_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX100_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX100_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX100_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX100_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX100_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX100_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX100_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX100_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX100_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX100_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX100_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX100_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX100_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX100_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX100_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX100_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_MACD_SIGNAL		));

					//JASDAC
					nowDTO.setNow_JASDAC_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAX		)	);
					nowDTO.setNow_JASDAC_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIN		)	);
					nowDTO.setNow_JASDAC_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_JASDAC_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_JASDAC_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_JASDAC_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_JASDAC_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_JASDAC_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_JASDAC_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_JASDAC_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_JASDAC_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_JASDAC_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_JASDAC_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_JASDAC_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_JASDAC_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_JASDAC_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_JASDAC_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_JASDAC_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_JASDAC_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_JASDAC_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_JASDAC_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_JASDAC_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_JASDAC_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_JASDAC_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_JASDAC_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_JASDAC_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_JASDAC_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_JASDAC_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_JASDAC_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_MACD_SIGNAL		));


				}

				break;
			case ReCord.CODE_02_SATISTICS:

				nowDTO.setNowDay_01		(	RS.getString(COLUMN.DAYTIME		)	);

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

				nowDTO.setNowSATISTICS_BAYBAY_01(RS.getDouble(	COLUMN.BAYBAY		));
				nowDTO.setNowSATISTICS_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.BAYBAY_CHANGERATE		));
				nowDTO.setNowSATISTICS_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.BAYBAY_RATIO		));
				nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY		));
				nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY		));
				nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY		));
				nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
				nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_RATIO_01(RS.getDouble(	COLUMN.LONGIDO_BAYBAY_RATIO		));

				nowDTO.setNowSATISTICS_DEKI_01(RS.getDouble(	COLUMN.DEKI		));
				nowDTO.setNowSATISTICS_DEKI_CHANGERATE_01(RS.getDouble(	COLUMN.DEKI_CHANGERATE		));
				nowDTO.setNowSATISTICS_DEKI_RATIO_01(RS.getDouble(	COLUMN.DEKI_RATIO		));
				nowDTO.setNowSATISTICS_SHORTIDO_DEKI_01(RS.getDouble(	COLUMN.SHORTIDO_DEKI		));
				nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_01(RS.getDouble(	COLUMN.MIDDLEIDO_DEKI		));
				nowDTO.setNowSATISTICS_LONGIDO_DEKI_01(RS.getDouble(	COLUMN.LONGIDO_DEKI		));
				nowDTO.setNowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSATISTICS_LONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSATISTICS_SHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowSATISTICS_LONGIDO_DEKI_RATIO_01	(	RS.getDouble(	COLUMN.LONGIDO_DEKI_RATIO	)	);




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

				nowDTO.setNowDay_01		(	RS.getString(COLUMN.DAYTIME		)	);
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



				nowDTO.setNowDay_01		(	RS.getString(ReCord.ETF_DD_E + "." +  COLUMN.DAYTIME		)	);

				//買った日の最高値、最安、とかいろいろ
				nowDTO.setNowMAX_01		(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MAX		)	);
				nowDTO.setNowMIN_01		(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIN		)	);
				nowDTO.setNowOpen_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.OPEN		)	);
				nowDTO.setNowCLOSE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CLOSE	)	);
				nowDTO.setNowDEKI_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.DEKI		)	);
				nowDTO.setNowBAYBAY_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.BAYBAY	)	);

				nowDTO.setNowCHANGE_PRICE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CHANGE_PRICE	)	);
				nowDTO.setNowCHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CHANGERATE	)	);

				nowDTO.setNowSHORTIDO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO	)	);
				nowDTO.setNowMIDDLEIDO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO	)	);
				nowDTO.setNowLONGIDO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO	)	);

				nowDTO.setNowSHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_CHANGERATE	)	);
				nowDTO.setNowMAXMIN_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MAXMIN	)	);
				nowDTO.setNowMAXMINRATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MAXMINRATIO	)	);

				nowDTO.setNowCANDLE_AREA_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CANDLE_AREA	)	);
				nowDTO.setNowCANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CANDLE_AREA_SCALE	)	);
				nowDTO.setNowWINDOW_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.WINDOW	)	);
				nowDTO.setNowDEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.DEKI_CHANGERATE	)	);
				nowDTO.setNowDEKI_RATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.DEKI_RATIO	)	);
				nowDTO.setNowBAYBAY_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.BAYBAY_CHANGERATE	)	);
				nowDTO.setNowBAYBAY_RATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.BAYBAY_RATIO	)	);
				nowDTO.setNowSHORTIDO_DEKI_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_DEKI	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_DEKI	)	);
				nowDTO.setNowLONGIDO_DEKI_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_DEKI	)	);
				nowDTO.setNowSHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
				nowDTO.setNowSHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_DEKI_RATIO	)	);
				nowDTO.setNowMIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
				nowDTO.setNowLONGIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_DEKI_RATIO	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_BAYBAY	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_BAYBAY	)	);
				nowDTO.setNowLONGIDO_BAYBAY_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_BAYBAY	)	);

				nowDTO.setNowSHORTIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowMIDDLEIDO_BAYBAY_CHANGERATE_01	(	RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE	)	);
				nowDTO.setNowLONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_BAYBAY_CHANGERATE		));

				nowDTO.setNowSHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_BAYBAY_RATIO		));
				nowDTO.setNowMIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
				nowDTO.setNowLONGIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_BAYBAY_RATIO		));
//				nowDTO.setNowCREDIT_LONG_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_LONG		));
//				nowDTO.setNowCREDIT_SHORT_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_SHORT		));
//				nowDTO.setNowCREDIT_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_RATIO		));
//				nowDTO.setNowCREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_LONG_CHANGERATE		));
//				nowDTO.setNowCREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_SHORT_CHANGERATE		));
//				nowDTO.setNowCREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.CREDIT_RATIO_CHANGERATE		));

				nowDTO.setNowSHORT_DEV_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_DEV		));
				nowDTO.setNowSHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_NOW_SIGMA		));
				nowDTO.setNowSHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_1_H_SIGMA		));
				nowDTO.setNowSHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_1_L_SIGMA		));
				nowDTO.setNowSHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_2_H_SIGMA		));
				nowDTO.setNowSHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_2_L_SIGMA		));
				nowDTO.setNowSHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_3_H_SIGMA		));
				nowDTO.setNowSHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_3_L_SIGMA		));
				nowDTO.setNowMIDDLE_DEV_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_DEV		));
				nowDTO.setNowMIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_NOW_SIGMA		));
				nowDTO.setNowMIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_1_H_SIGMA		));
				nowDTO.setNowMIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_1_L_SIGMA		));
				nowDTO.setNowMIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_2_H_SIGMA		));
				nowDTO.setNowMIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_2_L_SIGMA		));
				nowDTO.setNowMIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_3_H_SIGMA		));
				nowDTO.setNowMIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_3_L_SIGMA		));
				nowDTO.setNowLONG_DEV_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_DEV		));
				nowDTO.setNowLONG_NOW_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_NOW_SIGMA		));
				nowDTO.setNowLONG_1_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_1_H_SIGMA		));
				nowDTO.setNowLONG_1_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_1_L_SIGMA		));
				nowDTO.setNowLONG_2_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_2_H_SIGMA		));
				nowDTO.setNowLONG_2_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_2_L_SIGMA		));
				nowDTO.setNowLONG_3_H_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_3_H_SIGMA		));
				nowDTO.setNowLONG_3_L_SIGMA_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_3_L_SIGMA		));
				nowDTO.setNowSHORTIDO_HEKATU_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_HEKATU		));
				nowDTO.setNowMIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_HEKATU		));
				nowDTO.setNowLONGIDO_HEKATU_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_HEKATU		));
				nowDTO.setNowSHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowLONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_HEKATU_CHANGERATE		));
				nowDTO.setNowSHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORTIDO_HEKATU_RATIO		));
				nowDTO.setNowMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLEIDO_HEKATU_RATIO		));
				nowDTO.setNowLONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONGIDO_HEKATU_RATIO		));
				nowDTO.setNowSHORT_MACD_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_MACD		));
				nowDTO.setNowSHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.SHORT_MACD_SIGNAL		));
				nowDTO.setNowMIDDLE_MACD_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_MACD		));
				nowDTO.setNowMIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.MIDDLE_MACD_SIGNAL		));
				nowDTO.setNowLONG_MACD_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_MACD		));
				nowDTO.setNowLONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.ETF_DD_E + "." +  COLUMN.LONG_MACD_SIGNAL		));

				//統計データを取得するかどうか
				if (paraDTO.isFlg02_statics()==true){
					//codelist部分
					nowDTO.setMarket(RS.getString(	 ReCord.CODELIST_B + "." + COLUMN.MARKET		));

					//統計データ部分
					nowDTO.setNowSTOCK_NAME_NUM_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NAME_NUM		));
					nowDTO.setNowSTOCK_NOCOMPARE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCOMPARE		));
					nowDTO.setNowSTOCK_DOWNSTOCK_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_DOWNSTOCK		));

					nowDTO.setNowNETUKI_MAXMIN_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.NETUKI_MAXMIN		));
					nowDTO.setNowNETUKI_MAXMINRATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.NETUKI_MAXMINRATIO		));


					nowDTO.setNowSTOCK_GETPRICE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE		));
					nowDTO.setNowSTOCK_GETPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_GETPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

					nowDTO.setNowSATISTICS_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY		));
					nowDTO.setNowSATISTICS_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowSATISTICS_SHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_LONGIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_BAYBAY_RATIO		));
					nowDTO.setNowSATISTICS_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI		));
					nowDTO.setNowSATISTICS_DEKI_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI_CHANGERATE		));
					nowDTO.setNowSATISTICS_DEKI_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.DEKI_RATIO		));
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI		));
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI		));
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI		));
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowSATISTICS_SHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.SHORTIDO_DEKI_RATIO	)	);
					nowDTO.setNowSATISTICS_MIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
					nowDTO.setNowSATISTICS_LONGIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.LONGIDO_DEKI_RATIO	)	);


					nowDTO.setNowSTOCK_UPSTOCK_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPSTOCK		));
					nowDTO.setNowSTOCK_UPPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_UPPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


					nowDTO.setNowSTOCK_NOCHANGE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE		));
					nowDTO.setNowSTOCK_NOCHANGE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowSTOCK_NOCHANGE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_DD_C + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));

					//東証一部、統計部分
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NAME_NUM_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NAME_NUM		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCOMPARE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCOMPARE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_DOWNSTOCK_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_DOWNSTOCK		));

					nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMIN_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.NETUKI_MAXMIN		));
					nowDTO.setNowNIKKE_SATISTICS_NETUKI_MAXMINRATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.NETUKI_MAXMINRATIO		));


					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_GETPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_GETPRICE_IDO_LONG_RATIO		));

					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_BAYBAY_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_BAYBAY_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_DEKI_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.DEKI_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI		));
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_CHANGERATE_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI_CHANGERATE	)	);
					nowDTO.setNowNIKKE_SATISTICS_SHORTIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.SHORTIDO_DEKI_RATIO	)	);
					nowDTO.setNowNIKKE_SATISTICS_MIDDLEIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.MIDDLEIDO_DEKI_RATIO	)	);
					nowDTO.setNowNIKKE_SATISTICS_LONGIDO_DEKI_RATIO_01	(	RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.LONGIDO_DEKI_RATIO	)	);


					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPSTOCK_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPSTOCK		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_UPPRICE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_UPPRICE_IDO_LONG_RATIO		));


					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_CHANGERATE_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_CHANGERATE		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_SHORT_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_SHORT_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_MIDDLE_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_MIDDLE_RATIO		));
					nowDTO.setNowNIKKE_SATISTICS_STOCK_NOCHANGE_IDO_LONG_RATIO_01(RS.getDouble(	ReCord.STATISTICS_NIKKE01_DD_CC + "." + COLUMN.STOCK_NOCHANGE_IDO_LONG_RATIO		));


					//日経平均
					nowDTO.setNow_NIKKE_AVEMAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAX		)	);
					nowDTO.setNow_NIKKE_AVEMIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIN		)	);
					nowDTO.setNow_NIKKE_AVEOpen_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_NIKKE_AVECLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_NIKKE_AVECHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_NIKKE_AVECHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_NIKKE_AVESHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_NIKKE_AVELONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_NIKKE_AVESHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVELONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_NIKKE_AVEMAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_NIKKE_AVEMAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_NIKKE_AVECANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_NIKKE_AVECANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_NIKKE_AVEWINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_NIKKE_AVECREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_NIKKE_AVECREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_NIKKE_AVECREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_NIKKE_AVECREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_NIKKE_AVECREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_NIKKE_AVECREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_NIKKE_AVESHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_NIKKE_AVESHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_NIKKE_AVELONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_NIKKE_AVELONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_NIKKE_AVESHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVEMIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVELONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_NIKKE_AVESHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_NIKKE_AVESHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_NIKKE_AVEMIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_NIKKE_AVELONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_NIKKE_AVELONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_NIKKE_AVE + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX
					nowDTO.setNow_TOPIX_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX + "." + COLUMN.LONG_MACD_SIGNAL		));

					//core30
					nowDTO.setNow_CORE30_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAX		)	);
					nowDTO.setNow_CORE30_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIN		)	);
					nowDTO.setNow_CORE30_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_CORE30_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_CORE30_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_CORE30_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_CORE30_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_CORE30_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_CORE30_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_CORE30_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_CORE30_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_CORE30_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_CORE30_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_CORE30_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_CORE30_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_CORE30_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_CORE30_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_CORE30_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_CORE30_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_CORE30_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_CORE30_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_CORE30_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_CORE30_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_CORE30_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_CORE30_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_CORE30_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_CORE30_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_CORE30_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_CORE30_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_CORE30_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_CORE30_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_CORE30_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_CORE30_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_CORE30_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_CORE30_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_CORE30_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_CORE30_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_CORE30 + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX_SMALL
					nowDTO.setNow_TOPIX_SMALL_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX_SMALL_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX_SMALL_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX_SMALL_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX_SMALL_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX_SMALL_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX_SMALL_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX_SMALL_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX_SMALL_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX_SMALL_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX_SMALL_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX_SMALL_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX_SMALL_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX_SMALL_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX_SMALL_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX_SMALL_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX_SMALL_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX_SMALL_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX_SMALL_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX_SMALL_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX_SMALL + "." + COLUMN.LONG_MACD_SIGNAL		));

					//TOPIX100
					nowDTO.setNow_TOPIX100_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAX		)	);
					nowDTO.setNow_TOPIX100_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIN		)	);
					nowDTO.setNow_TOPIX100_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_TOPIX100_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_TOPIX100_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_TOPIX100_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_TOPIX100_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_TOPIX100_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_TOPIX100_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_TOPIX100_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_TOPIX100_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_TOPIX100_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_TOPIX100_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_TOPIX100_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_TOPIX100_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_TOPIX100_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_TOPIX100_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_TOPIX100_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_TOPIX100_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_TOPIX100_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_TOPIX100_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_TOPIX100_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_TOPIX100_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_TOPIX100_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_TOPIX100_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_TOPIX100_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_TOPIX100_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_TOPIX100_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_TOPIX100_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX100_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_TOPIX100_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_TOPIX100_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_TOPIX100_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_TOPIX100 + "." + COLUMN.LONG_MACD_SIGNAL		));

					//JASDAC
					nowDTO.setNow_JASDAC_MAX_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAX		)	);
					nowDTO.setNow_JASDAC_MIN_01		(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIN		)	);
					nowDTO.setNow_JASDAC_Open_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.OPEN		)	);
					nowDTO.setNow_JASDAC_CLOSE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CLOSE	)	);

					nowDTO.setNow_JASDAC_CHANGE_PRICE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CHANGE_PRICE	)	);
					nowDTO.setNow_JASDAC_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CHANGERATE	)	);

					nowDTO.setNow_JASDAC_SHORTIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO	)	);
					nowDTO.setNow_JASDAC_MIDDLEIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO	)	);
					nowDTO.setNow_JASDAC_LONGIDO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO	)	);

					nowDTO.setNow_JASDAC_SHORTIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_MIDDLEIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_LONGIDO_CHANGERATE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_CHANGERATE	)	);
					nowDTO.setNow_JASDAC_MAXMIN_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAXMIN	)	);
					nowDTO.setNow_JASDAC_MAXMINRATIO_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MAXMINRATIO	)	);

					nowDTO.setNow_JASDAC_CANDLE_AREA_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CANDLE_AREA	)	);
					nowDTO.setNow_JASDAC_CANDLE_AREA_SCALE_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CANDLE_AREA_SCALE	)	);
					nowDTO.setNow_JASDAC_WINDOW_01	(	RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.WINDOW	)	);

//					nowDTO.setNow_JASDAC_CREDIT_LONG_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_LONG		));
//					nowDTO.setNow_JASDAC_CREDIT_SHORT_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_SHORT		));
//					nowDTO.setNow_JASDAC_CREDIT_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_RATIO		));
//					nowDTO.setNow_JASDAC_CREDIT_LONG_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_LONG_CHANGERATE		));
//					nowDTO.setNow_JASDAC_CREDIT_SHORT_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_SHORT_CHANGERATE		));
//					nowDTO.setNow_JASDAC_CREDIT_RATIO_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.CREDIT_RATIO_CHANGERATE		));

					nowDTO.setNow_JASDAC_SHORT_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_DEV		));
					nowDTO.setNow_JASDAC_SHORT_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_SHORT_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_DEV		));
					nowDTO.setNow_JASDAC_MIDDLE_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_MIDDLE_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_DEV_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_DEV		));
					nowDTO.setNow_JASDAC_LONG_NOW_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_NOW_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_1_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_1_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_1_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_1_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_2_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_2_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_2_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_2_L_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_3_H_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_3_H_SIGMA		));
					nowDTO.setNow_JASDAC_LONG_3_L_SIGMA_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_3_L_SIGMA		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_CHANGERATE_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU_CHANGERATE		));
					nowDTO.setNow_JASDAC_SHORTIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORTIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_MIDDLEIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLEIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_LONGIDO_HEKATU_RATIO_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONGIDO_HEKATU_RATIO		));
					nowDTO.setNow_JASDAC_SHORT_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_MACD		));
					nowDTO.setNow_JASDAC_SHORT_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.SHORT_MACD_SIGNAL		));
					nowDTO.setNow_JASDAC_MIDDLE_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_MACD		));
					nowDTO.setNow_JASDAC_MIDDLE_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.MIDDLE_MACD_SIGNAL		));
					nowDTO.setNow_JASDAC_LONG_MACD_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_MACD		));
					nowDTO.setNow_JASDAC_LONG_MACD_SIGNAL_01(RS.getDouble(	ReCord.INDEX_TBK_DD_JASDAC + "." + COLUMN.LONG_MACD_SIGNAL		));

				}

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
		return nowDTO;
	}




}
