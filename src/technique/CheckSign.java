package technique;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import accesarrySQL.SQLChecker;
import analysis.SagyoSpace;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.TechCon;

public class CheckSign {


	public static void checkTodaySign(){

		//		commonAP.writeInLog("サイン点灯をチェックします。",logWriting.STOCK_RESULT_LOG_FLG);
		S s = new S();
		s.getCon();
		String TODAY = SQLChecker.getCateToday(ReCord.CODE_01_STOCK,s);
		s.closeConection();
		//前日の注文を実行する。
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		dealLastOrder(TODAY,paraDTO);

		s = new S();
		s.getCon();
		ArrayList<String[]> STOCKList = new ArrayList<String[]>();
		ArrayList<String[]> SATISTICSList = new ArrayList<String[]>();
		ArrayList<String[]> INDEXList = new ArrayList<String[]>();
		ArrayList<String[]> ETFNameList = new ArrayList<String[]>();
		ArrayList<String[]> keepStockList = new ArrayList<String[]>();


		//全銘柄をリストに入れる

//		commonAP.setCodeList(ReCord.CODE_01_STOCK,s);
		commonAP.setCodeList("DD",ReCord.CODE_01_STOCK,true,s);
		STOCKList = commonAP.getCodeList();

		commonAP.setCodeList("DD",ReCord.CODE_02_SATISTICS,true,s);
		SATISTICSList = commonAP.getCodeList();

		commonAP.setCodeList("DD",ReCord.CODE_03_INDEX,true,s);
		INDEXList = commonAP.getCodeList();

		commonAP.setCodeList("DD",ReCord.CODE_04_ETF,true,s);
		ETFNameList = commonAP.getCodeList();

		//キープテーブルのリストを取得
		commonAP.setKeepCodeList("DD",s);
		keepStockList = commonAP.getCodeList();

		//別メソッドを動かす前にメモリ解放
		s.closeConection();


		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC04, TechCon.METH_MACD_M_L_OVER0,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC04, TechCon.METH_MACD_M_L,			TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_1_S,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		//採用
		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_1_S,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC08, TechCon.METH_MACD_IDOHEIKIN_L,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		//採用
		CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC08, TechCon.METH_MACD_IDOHEIKIN_L,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);


		s.resetConnection();
		TODAY = controllDay.getMAX_DD_STOCK_ETF(s);
		afterCheck(TODAY,s);



		//別メソッドを動かす前にメモリ解放
		s.closeConection();

		//メモリの解放
		STOCKList = new ArrayList<String[]>();
		SATISTICSList = new ArrayList<String[]>();
		INDEXList = new ArrayList<String[]>();
		ETFNameList = new ArrayList<String[]>();
		keepStockList = new ArrayList<String[]>();

	}

	public static void checkVolume(double entryMoney,String TODAY,S s){

		//まずはクローズを一致させる。株の
		String TBLName = TBL_Name.STOCK_DD;
		String SQL  = " update "+ TBL_Name.LASTORDER + " , " + TBLName
				+ " set "
				+ TBL_Name.LASTORDER + "." + COLUMN.CLOSE + " = " + TBLName + "." + COLUMN.CLOSE
				+ " where "
				+ TBL_Name.LASTORDER + "." + COLUMN.CODE + " = " + TBLName + "." + COLUMN.CODE
				+ " and "
				+ TBLName + "." + COLUMN.DAYTIME + " = " + "'" + TODAY + "'";
		s.freeUpdateQuery(SQL);

		//次はインデックス
		TBLName = TBL_Name.INDEX_DD;
		SQL  = " update "+ TBL_Name.LASTORDER + " , " + TBLName
				+ " set "
				+ TBL_Name.LASTORDER + "." + COLUMN.CLOSE + " = " + TBLName + "." + COLUMN.CLOSE
				+ " where "
				+ TBL_Name.LASTORDER + "." + COLUMN.CODE + " = " + TBLName + "." + COLUMN.CODE
				+ " and "
				+ TBLName + "." + COLUMN.DAYTIME + " = " + "'" + TODAY + "'";
		s.freeUpdateQuery(SQL);

		//次はETF
		TBLName = TBL_Name.ETF_DD;
		SQL  = " update "+ TBL_Name.LASTORDER + " , " + TBLName
				+ " set "
				+ TBL_Name.LASTORDER + "." + COLUMN.CLOSE + " = " + TBLName + "." + COLUMN.CLOSE
				+ " where "
				+ TBL_Name.LASTORDER + "." + COLUMN.CODE + " = " + TBLName + "." + COLUMN.CODE
				+ " and "
				+ TBLName + "." + COLUMN.DAYTIME + " = " + "'" + TODAY + "'";
		s.freeUpdateQuery(SQL);

		//以下true:買い
		//理想的株数を計算する
		SQL  = " update "+ TBL_Name.LASTORDER
				+ " set "
				+ COLUMN.IDEA_VOLUME + " = " + "( " + (entryMoney*10000) + " / " + COLUMN.CLOSE + " ) "
				+ " where "
				+ COLUMN.SIGN_FLG + " is true";
		s.freeUpdateQuery(SQL);

		//現実的株数を計算する
		SQL  = " update "+ TBL_Name.LASTORDER
				+ " set "
				+ COLUMN.REAL_ENTRY_VOLUME + " = " + COLUMN.IDEA_VOLUME
				+ " where "
				+ COLUMN.SIGN_FLG + " is true";
		s.freeUpdateQuery(SQL);

		//切り上げ処理
		SQL  = " update "+ TBL_Name.LASTORDER
				+ " set "
				+ COLUMN.REAL_ENTRY_VOLUME + " = " + COLUMN.REAL_ENTRY_VOLUME + " + 1 "
				+ " where "
				+ COLUMN.REAL_ENTRY_VOLUME + " < " + COLUMN.IDEA_VOLUME
				+ " and "
				+ COLUMN.SIGN_FLG + " is true";
		s.freeUpdateQuery(SQL);

		//以下false売り
		//現実的
		SQL  = " update "+ TBL_Name.LASTORDER + " , " + TBL_Name.KEEPLISTTBL
				+ " set "
				+ TBL_Name.LASTORDER + "." + COLUMN.REAL_ENTRY_VOLUME + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.REAL_ENTRY_VOLUME
				+ " where "
				+ TBL_Name.LASTORDER + "." + COLUMN.CODE + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.CODE
				+ " and "
				+ TBL_Name.LASTORDER + "." + COLUMN.EXITMETHOD + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.EXITMETHOD
				+ " and "
				+ TBL_Name.LASTORDER + "." + COLUMN.ENTRYMETHOD + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.ENTRYMETHOD
				+ " and "
				+ TBL_Name.LASTORDER + "."+ COLUMN.SIGN_FLG + " is false "
				+ " and "
				+ TBL_Name.LASTORDER + "."+ COLUMN.MINI_CHECK_FLG + " = " + TBL_Name.KEEPLISTTBL + "."+ COLUMN.MINI_CHECK_FLG;
		s.freeUpdateQuery(SQL);

		//理想的
		SQL  = " update "+ TBL_Name.LASTORDER + " , " + TBL_Name.KEEPLISTTBL
				+ " set "
				+ TBL_Name.LASTORDER + "." + COLUMN.IDEA_VOLUME + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.IDEA_VOLUME
				+ " where "
				+ TBL_Name.LASTORDER + "." + COLUMN.CODE + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.CODE
				+ " and "
				+ TBL_Name.LASTORDER + "." + COLUMN.EXITMETHOD + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.EXITMETHOD
				+ " and "
				+ TBL_Name.LASTORDER + "." + COLUMN.ENTRYMETHOD + " = " + TBL_Name.KEEPLISTTBL + "." + COLUMN.ENTRYMETHOD
				+ " and "
				+ TBL_Name.LASTORDER + "."+ COLUMN.SIGN_FLG + " is false "
				+ " and "
				+ TBL_Name.LASTORDER + "."+ COLUMN.MINI_CHECK_FLG + " = " + TBL_Name.KEEPLISTTBL + "."+ COLUMN.MINI_CHECK_FLG;
		s.freeUpdateQuery(SQL);

	}


	//true:本番
	//false:試験
	public static void dealLastOrder(String checkDay,Bean_Parameta paraDTO){

		List<String[]> methodList = new ArrayList<String[]>();
		String SQL = " SELECT DISTINCT "
				   + COLUMN.ENTRYMETHOD +	","
				   + COLUMN.EXITMETHOD +	","
				   + COLUMN.TYPE +			" "
				   + " from "
				   + TBL_Name.LASTORDER
				   + " where "
				   + COLUMN.DAYTIME + " < '" + checkDay + "'";
		S s = new S();
		s.getCon();
		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while(s.rs2.next()){
				String codeStatus[] = new String[3];
				codeStatus[0] = s.rs2.getString(	COLUMN.ENTRYMETHOD	);
				codeStatus[1] = s.rs2.getString(	COLUMN.EXITMETHOD	);
				codeStatus[2] = s.rs2.getString(	COLUMN.TYPE			);
				methodList.add(codeStatus.clone());
			};
		} catch (SQLException e) {e.printStackTrace();	}

		s.closeConection();

		for ( String a[] : methodList){
//			System.out.println(checkDay + ":" + a);
			//前日の分を買う。
			List<String[]> lastOrderCodeList_L = new ArrayList<String[]>();
			getLastOrderCodeList(lastOrderCodeList_L,a[0],a[1],a[2],true,checkDay);
			setEntryTBL_L(lastOrderCodeList_L, a[0],a[1],a[2],checkDay,paraDTO);
			lastOrderCodeList_L = new ArrayList<String[]>();
			//前日の分を売る
			List<String[]> lastOrderCodeList_S = new ArrayList<String[]>();
			getLastOrderCodeList(lastOrderCodeList_S,a[0],a[1],a[2],false,checkDay);
			setResultTBL_S(lastOrderCodeList_S,a[0],a[1],a[2],checkDay,paraDTO);
			lastOrderCodeList_S = new ArrayList<String[]>();
		}



		//keepTBLのREALVOLUMEをいい感じにする



	}


	//true:本番
	//false:試験
	public static void CHECKTODAY(
			int size,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName,
			ArrayList<String[]> STOCKList,
			ArrayList<String[]> SATISTICSList,
			ArrayList<String[]> INDEXList,
			ArrayList<String[]> ETFNameList,
			ArrayList<String[]> keepCodeList,
			String checkDay
			){




		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		nowDTOList = new ArrayList<>();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setLMETHOD(L_packageName + "." + L_className + "." + L_methodName);
		paraDTO.setSMETHOD(S_packageName + "." + S_className + "." + S_methodName);
		CHECKTODAY_L(size,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList,checkDay);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		nowDTOList = new ArrayList<>();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setLMETHOD(L_packageName + "." + L_className + "." + L_methodName);
		paraDTO.setSMETHOD(S_packageName + "." + S_className + "." + S_methodName);


		CHECKTODAY_S(size,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList,keepCodeList,checkDay);


		//同日に売りと買いが同時に出ていないかチェック。存在する場合、買いログに出力する。
		checkWsign(type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName);

		//メモリの解放
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		nowDTOList = new ArrayList<>();

	}

	private static void CHECKTODAY_S(
			int size,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName,
			Bean_Parameta paraDTO,
			List<Bean_nowRecord> nowDTOList,
			Bean_Result resultDTO,
			ArrayList<String[]> STOCKList,
			ArrayList<String[]> SATISTICSList,
			ArrayList<String[]> INDEXList,
			ArrayList<String[]> ETFNameList,
			ArrayList<String[]> keepCodeList,
			String checkDay){



		//今日のサインを調べる
		ArrayList<String> resultCodeList = new ArrayList<String>();
//		ArrayList<String[]> resultCodeList = new ArrayList<String[]>();
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,STOCKList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,SATISTICSList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,INDEXList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,ETFNameList);
		checkdaySignControll(resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,keepCodeList,checkDay);

		//今日のサインをオーダーに入れる
		makeLastOrderTBL(resultCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,false,checkDay);



		//メモリの解放
		resultCodeList = new ArrayList<String>();

	}



	private static void setResultTBL_S(List<String[]> codeList,String Lmethod,String Smethod,String type,String checkDay,Bean_Parameta paraDTO){
		S s = new S();
		s.getCon();
//		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
//		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//単位万円→円
		double oneTimeEntryMoney = paraDTO.getEntryMoney()*10000;

		String TODAY = checkDay;
		for (int i = 0; i < codeList.size();i++){
			String signDay = codeList.get(i)[5];
			String cate = codeList.get(i)[2];
			String code = codeList.get(i)[0];
			String TBL = SQLChecker.getTBL(cate);
			String checkMINI = codeList.get(i)[6];

			boolean exitCheck = false;

			//最新日が売りサイン実行日
			String SQL = " select "
					+ COLUMN.DAYTIME + "," + COLUMN.OPEN
					+ " from "
					+ TBL
					+ " where "
					+ COLUMN.DAYTIME + " = '" + TODAY
					+ "' and "
					+ COLUMN.CODE + " = '" + code + "'"
					+ " order by " + COLUMN.DAYTIME + " desc";



			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				double nowOpen = 0.0;

				if(s.rs2.next()){
					nowOpen =s.rs2.getDouble(	COLUMN.OPEN	);
					exitCheck = true;
					//					System.out.println("setResultTBL:" + SQL);
				};

				if (exitCheck){
					SQL = "select * from " + TBL_Name.KEEPLISTTBL
							+ " where "
							+ COLUMN.CODE + " = '" + code + "'"
							+ " and "
							+ COLUMN.TYPE + " = '" + type + "'"
							+ " and "
							+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
							+ " and "
							+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
							+ " and "
							+ COLUMN.MINI_CHECK_FLG + " is "	+ checkMINI;

					s.rs2 = s.sqlGetter().executeQuery(SQL);


					if ( s.rs2.next() ) {
						//trueのとき、存在する。

						String entryDay = s.rs2.getString(COLUMN.ENTRYDAY);
						int entryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double realVolume = s.rs2.getDouble(COLUMN.REAL_ENTRY_VOLUME);;
						double ideaVolume = s.rs2.getDouble(COLUMN.IDEA_VOLUME);;

						double averagePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double realAveragePrice = s.rs2.getDouble(COLUMN.REAL_AVERAGEPRICE);
						double ideaAveragePrice = s.rs2.getDouble(COLUMN.IDEA_AVERAGEPRICE);

						double RETURN = ( nowOpen - averagePrice ) / averagePrice;
//						double realRETURN = realVolume * ( ( nowOpen - realAveragePrice ) / realAveragePrice );
						double realRETURN = ( realVolume * ( ( nowOpen - realAveragePrice ) ) ) / oneTimeEntryMoney;
//						double ideaRETURN = ideaVolume * ( ( nowOpen - ideaAveragePrice ) / ideaAveragePrice );
						double ideaRETURN = ( ideaVolume * ( ( nowOpen - ideaAveragePrice ) ) ) / oneTimeEntryMoney;

//						int keepTime = commonAP.countDay(entryDay,signDay, s) ;
						int keepTime = commonAP.countDay(entryDay,TODAY, s) -1;

						SQL ="insert into " + TBL_Name.RESULTHISTROYTBL
								+ " ( "
								+ COLUMN.CODE										 + " , " //
								+ COLUMN.ENTRYDAY									 + " , " //
								+ COLUMN.EXITDAY									 + " , " //
								+ COLUMN.AVERAGEPRICE								 + " , " //
								+ COLUMN.EXITPRICE									 + " , " //
								+ COLUMN.IDEA_AVERAGEPRICE 						 	 + " , " //理想的平均取得価格
								+ COLUMN.IDEA_VOLUME 						  		 + " , " //理想的保有株数
								+ COLUMN.IDEA_RETURN								 + " ,  " //理想的トータルリターン
								+ COLUMN.REAL_AVERAGEPRICE 						 	 + " , " //現実的平均取得価格
								+ COLUMN.REAL_ENTRY_VOLUME 						 	 + " , " //現実的保有株数
								+ COLUMN.REAL_RETURN								 + " ,  " //現実的トータルリターン
								+ COLUMN.MINI_CHECK_FLG									 	 + " , " //
								+ COLUMN.TYPE									 	 + " , " //
								+ COLUMN.ENTRYTIMES								 + " , " //
								+ COLUMN.RESULTRETURN									 + " , " //
								+ COLUMN.TOTAL_RETURN									 + " , " //
								+ COLUMN.KEEPTIME									 + " , " //
								+ COLUMN.ENTRYMETHOD								 + " , " //
								+ COLUMN.EXITMETHOD								 + "   " //
								+ " ) value ( "
								+ "'" + code + "'"	 + ","
								+ "'" + entryDay			+ "'"	 + ","
								+ "'" + TODAY			+ "'"	 + ","
								+ averagePrice						 + ","
								+ nowOpen							 + ","
								+ ideaAveragePrice							 + ","//理想的平均取得価格
								+ ideaVolume							 + ","//理想的保有株数
								+ ideaRETURN							 + ","//理想的トータルリターン
								+ realAveragePrice							 + ","//現実的平均取得価格
								+ realVolume							 + ","//現実的保有株数
								+ realRETURN							 + ","//現実的トータルリターン
								+ checkMINI + ","
								+ "'" + type			+ "'"	 + ","
								+ entryTime							 + ","
								+ RETURN							 + ","
								+ (RETURN*entryTime)					 + ","
								+ keepTime							 + ","
								+ "'" + Lmethod			+ "'"	 + ","
								+ "'" + Smethod			+ "'"	 + " "
								+ ")";
//						+ COLUMN.MINI_CHECK_FLG_KATA							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
//						+ COLUMN.IDEA_VOLUME_KATA								 + " ,  "  //理想的保持数
//						+ COLUMN.IDEA_AVERAGEPRICE_KATA							 + " ,  "  //理想的平均取得価格
//						+ COLUMN.IDEA_RETURN_KATA								 + " ,  " //理想的トータルリターン
//						+ COLUMN.REAL_ENTRY_VOLUME_KATA							 + " ,  "  //現実保有数
//						+ COLUMN.REAL_AVERAGEPRICE_KATA							 + " ,  "  //現実平均取得価格
//						+ COLUMN.REAL_RETURN_KATA								 + " ,  "//現実的的トータルリターン

						s.freeUpdateQuery(SQL);

						//ここからはキープテーブルの削除
						SQL = " delete from " + TBL_Name.KEEPLISTTBL
								+ " where "
								+ COLUMN.CODE + " = '" + code + "'"
								+ " and "
								+ COLUMN.TYPE + " = '" + type + "'"
								+ " and "
								+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
								+ " and "
								+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";
						s.freeUpdateQuery(SQL);

					}else{
						//falseのとき存在しない

					}
				}

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		s.closeConection();
	}


	private static void CHECKTODAY_L(
			int size,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName,
			Bean_Parameta paraDTO,
			List<Bean_nowRecord> nowDTOList,
			Bean_Result resultDTO,
			ArrayList<String[]> STOCKList,
			ArrayList<String[]> SATISTICSList,
			ArrayList<String[]> INDEXList,
			ArrayList<String[]> ETFNameList,
			String checkDay){



		//今日のサインを調べる
		ArrayList<String> resultCodeList = new ArrayList<String>();
//		ArrayList<String[]> resultCodeList = new ArrayList<String[]>();
		checkdaySignControll(resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,STOCKList,checkDay);
		checkdaySignControll(resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,SATISTICSList,checkDay);
		checkdaySignControll(resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,INDEXList,checkDay);
		checkdaySignControll(resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,ETFNameList,checkDay);

		//今日のサインをオーダーに入れる
		makeLastOrderTBL(resultCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,true,checkDay);



		//メモリの解放
		resultCodeList = new ArrayList<String>();
	}

	//売買サインフラグ。true買い、false売り
	private static void makeLastOrderTBL(List<String> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type,boolean signFlg,String checkDay){
		S s = new S();
		s.getCon();

		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		String SQL = "";

		List<String> thisResultCodeList = new ArrayList<String>();

		String check="";


		if ( signFlg ){
			//trueは買いフラグ
			check = "(買)";
			thisResultCodeList = codeList;
		}else{
			//falseは売りフラグ
			//キープテーブルの中から探す。
			check = "(売)";
			for (int i = 0; i < codeList.size();i++){
				try {
					String code = codeList.get(i);
					//売りフラグの内、キープテーブルに存在するレコードのみをthisresultCodeListにaddする
					String SQL2 = " select " + COLUMN.CODE + " from "  + TBL_Name.KEEPLISTTBL
							+ " where "
							+ COLUMN.CODE + " = '" +  code + "'"
							+ " and "
							+ COLUMN.TYPE + " = '" + type + "'"
							+ " and "
							+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
							+ " and "
							+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;
							s.rs2 = s.sqlGetter().executeQuery(SQL2);

							if(s.rs2.next()){
								thisResultCodeList.add(s.rs2.getString(	COLUMN.CODE	));
							};
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

		String TODAY = checkDay;
		//ラストオーダーを挿入する。
		for (int i = 0; i < thisResultCodeList.size();i++){

			String code = thisResultCodeList.get(i);
			String cate = SQLChecker.getCate(thisResultCodeList.get(i), s);
			String TBL = SQLChecker.getTBL(cate);


			SQL ="insert into " + TBL_Name.LASTORDER
					+ " ( "
					+ COLUMN.CODE										 + " , " //
					+ COLUMN.DAYTIME									 + " , " //
					+ COLUMN.TYPE									 	 + " , " //
					+ COLUMN.CATE_FLG									 + " , " //
					+ COLUMN.SIGN_FLG								 	 + " , " //売買サインフラグ。true買い、false売り
					+ COLUMN.MINI_CHECK_FLG							 + " ,  " //ミニ株本株チェック trueミニ株、false普通株
					+ COLUMN.ENTRYMETHOD								 + " , " //
					+ COLUMN.EXITMETHOD								 + "  " //
					+ " ) value ( "
					+ "'" + code + "'"	 + ","
					+ "'" + TODAY			+ "'"	 + ","
					+ "'" + type			+ "'"	 + ","
					+ cate							 + ","
					+ signFlg						 + ","
					+ " true "						 + ","
					+ "'" + Lmethod			+ "'"	 + ","
					+ "'" + Smethod			+ "'"	 + " "
					+ ")";

			s.freeUpdateQuery(SQL);
			//サインの出た持ってる銘柄だけ表示する。ログ
			//			if (signFlg){
			//				commonAP.writeInLog(check + "," + TODAY + "," +  code + "," + Lmethod + "," + Smethod,logWriting.STOCK_RESULT_LOG_FLG_L);
			//			}else{
			//				commonAP.writeInLog(check + "," + TODAY + "," +  code + "," + Lmethod + "," + Smethod,logWriting.STOCK_RESULT_LOG_FLG_S);
			//			}

		}




		//		メモリの解放
		thisResultCodeList = new ArrayList<String>();
		s.closeConection();
	}



	private static void setEntryTBL_L(List<String[]> codeList,String Lmethod,String Smethod,String type,String checkDay,Bean_Parameta paraDTO){


		S s = new S();
		s.getCon();
//		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
//		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		if (codeList.size()==0){
			s.closeConection();
			return;
		}
//		System.out.println("setEntryTBL_L:" + codeList.size());
		//        for(String a[] : codeList){
		//
		//        }
		String TODAY = checkDay;
		for (int i = 0; i < codeList.size();i++){
			String cate = codeList.get(i)[2];
//			String signDay = codeList.get(i)[5];
			String code = codeList.get(i)[0];
			String TBL = SQLChecker.getTBL(cate);

			//ミニ株チェック true：ミニ、false：普通株
			String checkMINI = codeList.get(i)[6];
			double ideaVolume = Double.valueOf(codeList.get(i)[7]);
			double realVolume = Double.valueOf(codeList.get(i)[8]);

//			codeStatus[6] = s.rs2.getString(	COLUMN.MINI_CHECK_FLG	);
//			codeStatus[7] = s.rs2.getString(	COLUMN.IDEA_VOLUME		);
//			codeStatus[8] = s.rs2.getString(	COLUMN.REAL_ENTRY_VOLUME);

			//最新日が買いサイン実行日
//			String SQL = " select "
//					+ COLUMN.DAYTIME + "," + COLUMN.OPEN
//					+ " from "
//					+ TBL
//					+ " where "
//					+ COLUMN.DAYTIME + " > '" + signDay
//					+ "' and "
//					+ COLUMN.CODE + " = '" + code + "'"
//					+ " order by " + COLUMN.DAYTIME + " desc";


			String	SQL = " select "
					+ COLUMN.DAYTIME + "," + COLUMN.OPEN
					+ " from "
					+ TBL
					+ " where "
					+ COLUMN.DAYTIME + " = '" + TODAY
					+ "' and "
					+ COLUMN.CODE + " = '" + code + "'"
					+ " order by " + COLUMN.DAYTIME + " desc";

			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				double nowOpen = 0.0;

				boolean existCheck = false;
				if (s.rs2.next()){
					nowOpen =s.rs2.getDouble(	COLUMN.OPEN	);
					existCheck = true;
				};


				SQL = "select * from " + TBL_Name.KEEPLISTTBL
						+ " where "
						+ COLUMN.CODE + " = '" + code + "'"
						+ " and "
						+ COLUMN.TYPE + " = '" + type + "'"
						+ " and "
						+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
						+ " and "
						+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
						+ " and "
						+ COLUMN.MINI_CHECK_FLG + " is "	+ checkMINI;

				s.rs2 = s.sqlGetter().executeQuery(SQL);


				if ( s.rs2.next() ) {
					//trueのとき、存在する。

					if( !s.rs2.getString(COLUMN.LASTENTRYDAY).equals(TODAY)){
						//一緒じゃない場合だけ動く

						int beforeEntryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double beforeRealVolume = s.rs2.getDouble(COLUMN.REAL_ENTRY_VOLUME);;
						double beforeIdeaVolume = s.rs2.getDouble(COLUMN.IDEA_VOLUME);;
						int beforeRealTotalEntryMoney =s.rs2.getInt(COLUMN.REAL_TOTAL_ENTRY_MONEY);
						double beforeIdeaTotalEntryMoney =s.rs2.getDouble(COLUMN.IDEA_TOTAL_ENTRY_MONEY);
						double beforeAveragePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double nowAveragePrice = ( ( beforeAveragePrice * beforeEntryTime ) + nowOpen ) / ( beforeEntryTime + 1);
						int intRealVolume = (int)realVolume;
						int intNowOpen = (int)nowOpen;
						int nowRealTotalEntryMoney = beforeRealTotalEntryMoney + (intRealVolume * intNowOpen);
						double nowIdeaTotalMoney = beforeIdeaTotalEntryMoney + (ideaVolume * intNowOpen);
						double nowRealVolume = beforeRealVolume + realVolume;
						double nowIdeaVolume = beforeIdeaVolume + ideaVolume;
						double realNowAveragePrice = ( ( nowRealTotalEntryMoney ) / ( nowRealVolume ));;
						double ideaNowAveragePrice = ( nowIdeaTotalMoney ) / ( nowIdeaVolume );;


						//						s.rs2.updateDouble(COLUMN.AVERAGEPRICE,nowAveragePrice);
						//						s.rs2.updateInt(COLUMN.ENTRYTIMES,beforeEntryTime + 1);
						//						s.rs2.updateString(COLUMN.LASTENTRYDAY,TODAY);


						if(existCheck){
							//
							SQL = " update "+ TBL_Name.KEEPLISTTBL + " "
									+ " set "
									+ COLUMN.ENTRYTIMES + 			" = " + ( beforeEntryTime + 1 ) + " , "
									+ COLUMN.AVERAGEPRICE + 		" = " + nowAveragePrice + " , "
									+ COLUMN.LASTENTRYDAY +			" = '" + TODAY + "' , "
									+ COLUMN.IDEA_TOTAL_ENTRY_MONEY +	" = " + nowIdeaTotalMoney + " , "
									+ COLUMN.REAL_TOTAL_ENTRY_MONEY +	" = " + nowRealTotalEntryMoney + " , "
									+ COLUMN.IDEA_AVERAGEPRICE + 	" = " + ( ideaNowAveragePrice ) + " , "//理想的平均取得価格
									+ COLUMN.IDEA_VOLUME + 			" = " + ( nowIdeaVolume ) + " , "//理想的保有株数
									+ COLUMN.REAL_AVERAGEPRICE + 	" = " + ( realNowAveragePrice ) + " , "//現実的平均取得価格
									+ COLUMN.REAL_ENTRY_VOLUME + 	" = " + ( nowRealVolume ) + "  "//現実的保有株数
									+ " where "
									+ COLUMN.CODE + " = '" + code + "'"
									+ " and "
									+ COLUMN.TYPE + " = '" + type + "'"
									+ " and "
									+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
									+ " and "
									+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
									+ " and "
									+ COLUMN.MINI_CHECK_FLG + " is "	+ checkMINI;;
									s.freeUpdateQuery(SQL);

						}

					}

				}else{
					//falseのとき存在しない
					if(existCheck){

						double totalRealEntryMoney = (realVolume * nowOpen);
						double totalIdeaEntryMoney = (ideaVolume * nowOpen);


						SQL ="insert into " + TBL_Name.KEEPLISTTBL
								+ " ( "
								+ COLUMN.CODE										 + " , " //
								+ COLUMN.ENTRYDAY									 + " , " //
								+ COLUMN.LASTENTRYDAY								 + " , " //
								+ COLUMN.AVERAGEPRICE								 + " , " //
								+ COLUMN.ENTRYTIMES									 + " , " //
								+ COLUMN.IDEA_AVERAGEPRICE 						 	 + " , " //理想的平均取得価格
								+ COLUMN.IDEA_VOLUME 						  		 + " , " //理想的保有株数
								+ COLUMN.REAL_AVERAGEPRICE 						 	 + " , " //現実的平均取得価格
								+ COLUMN.REAL_ENTRY_VOLUME 						 	 + " , " //現実的保有株数
								+ COLUMN.TYPE									 	 + " , " //
								+ COLUMN.MINI_CHECK_FLG							 	 + " , " //
								+ COLUMN.IDEA_TOTAL_ENTRY_MONEY						 	 + " , " //
								+ COLUMN.REAL_TOTAL_ENTRY_MONEY						 	 + " , " //
								+ COLUMN.ENTRYMETHOD								 + " , " //
								+ COLUMN.EXITMETHOD									 + "   " //
								+ " ) value ( "
								+ "'" + code + "'"	 + ","
								+ "'" + TODAY+ "'"	 + ","
								+ "'" + TODAY+ "'"	 + ","
								+ nowOpen			 + ","
								+ "1"				 + ","
								+ nowOpen			 + ","
								+ ideaVolume		 + ","
								+ nowOpen			 + ","
								+ realVolume		 + ","
								+ "'" + type	+ "'"+ ","
								+ checkMINI			 + ","
								+ totalIdeaEntryMoney	 + ","
								+ totalRealEntryMoney	 + ","
								+ "'" + Lmethod	+ "'"+ ","
								+ "'" + Smethod	+ "'"+ " "
								+ ")";

						s.freeUpdateQuery(SQL);

					}

				}


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}



			s.resetConnection();
		}
		s.closeConection();
	}

	private static void getLastOrderCodeList(List<String[]> lastOrderCodeList,String Lmethod,String Smethod,String type,boolean signFlg,String checkDay){
//	private static void getLastOrderCodeList(List<String[]> lastOrderCodeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type,boolean signFlg,String checkDay){
		S s = new S();
		s.getCon();

//		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
//		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		String sqlWhere = COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
				+ " and "
				+ COLUMN.DAYTIME + " < '" + checkDay + "'"
				+ " and "
				+ COLUMN.SIGN_FLG	+ " is " + signFlg;


		String SQL = " select * from " + TBL_Name.LASTORDER
				+ " where "
				+ sqlWhere;


		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);

			while(s.rs2.next()){
				String codeStatus[] = new String[9];
				codeStatus[0] = s.rs2.getString(	COLUMN.CODE				);
				codeStatus[1] = s.rs2.getString(	COLUMN.DAYTIME			);
				codeStatus[2] = s.rs2.getString(	COLUMN.CATE_FLG			);
				codeStatus[3] = s.rs2.getString(	COLUMN.ENTRYMETHOD		);
				codeStatus[4] = s.rs2.getString(	COLUMN.EXITMETHOD		);
				codeStatus[5] = s.rs2.getString(	COLUMN.DAYTIME			);

				if ( s.rs2.getString(	COLUMN.MINI_CHECK_FLG	).equals("1") ){
					codeStatus[6] = "true";
				}else{
					codeStatus[6] = "false";
				}

//				double ideaVolume = Double.valueOf(codeList.get(i)[7]);
//				double realVolume = Double.valueOf(codeList.get(i)[8]);
				codeStatus[7] = s.rs2.getString(	COLUMN.IDEA_VOLUME		);
				codeStatus[8] = s.rs2.getString(	COLUMN.REAL_ENTRY_VOLUME);

				lastOrderCodeList.add(codeStatus.clone());

			};

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		System.out.println("getLastOrderCodeList:" + lastOrderCodeList.size());
		//入れ終わったら古いのを削除する。
		//まずはラストオーダーを前日の分を削除する。
		SQL = " delete from " + TBL_Name.LASTORDER
				+ " where "
				+ sqlWhere;

		s.freeUpdateQuery(SQL);

		s.closeConection();

	}



	//true:保有期間
	//false:エントリー回数
	public static String getKeepDay(
			String code,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName,S s){
		String SQL = "";

		String resultStr = "0";
		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//true:保有期間
		//false:エントリー回数
		String column = COLUMN.ENTRYDAY;

		SQL = "select " + column + " from " + TBL_Name.KEEPLISTTBL
				+ " where "
				+ COLUMN.CODE + " = '" + code + "'"
				+ " and "
				+ COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;
//				System.out.println(SQL);
				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);
					//				if(s.rs2.next()){
					//
					//				};
					while(s.rs2.next()){
						//					String codeStatus[] = new String[6];
						resultStr = s.rs2.getString(	column	);
					};
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}


				return resultStr;
	}

	//true:保有期間
	//false:エントリー回数
	public static String getKeepDay(
			String code,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName){
		String SQL = "";
		S s = new S();
		s.getCon();
		String resultStr = "0";
		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//true:保有期間
		//false:エントリー回数
		String column = COLUMN.ENTRYDAY;

		SQL = "select " + column + " from " + TBL_Name.KEEPLISTTBL
				+ " where "
				+ COLUMN.CODE + " = '" + code + "'"
				+ " and "
				+ COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;
//				System.out.println(SQL);
				try {
					s.rs2 = s.sqlGetter().executeQuery(SQL);
					//				if(s.rs2.next()){
					//
					//				};
					while(s.rs2.next()){
						//					String codeStatus[] = new String[6];
						resultStr = s.rs2.getString(	column	);
					};
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}


				s.closeConection();
				return resultStr;
	}

	public static void setEntryTimesEntryDayAveragePrice(String code,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName,
			Bean_Result resultDTO,
			S s){

		String SQL = "";
		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		String column = COLUMN.ENTRYTIMES + "," + COLUMN.ENTRYDAY + "," + COLUMN.AVERAGEPRICE;

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
			while(s.rs2.next()){

				resultDTO.setEntryTime(s.rs2.getInt(COLUMN.ENTRYTIMES));
//				resultDTO.setKeepCount(s.rs2.getString(COLUMN.ENTRYDAY));
				resultDTO.setRealStartDay(s.rs2.getString(COLUMN.ENTRYDAY));
				resultDTO.setRealAveragePrice(s.rs2.getDouble(COLUMN.AVERAGEPRICE));
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getEntryTimes(
			String code,
			String type,
			String L_packageName,
			String L_className,
			String L_methodName,
			String S_packageName,
			String S_className,
			String S_methodName
			,S s){
		String SQL = "";
//		S s = new S();
//		s.getCon();
		int resultInt = 0;
		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//true:保有期間
		//false:エントリー回数
		String column = COLUMN.ENTRYTIMES;

		SQL = "select " + column + " from " + TBL_Name.KEEPLISTTBL
				+ " where "
				+ COLUMN.CODE + " = '" + code + "'"
				+ " and "
				+ COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;
//				System.out.println(SQL);
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


//				s.closeConection();
				return resultInt;
	}


	private static void checkWsign(String type,String L_packageName,String L_className,	String L_methodName,String S_packageName,String S_className,String S_methodName){

		S s = new S();
		s.getCon();

		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		//複数行あるレコードのみ抽出
		//		select code from 95_lastordertbl where entrymethod = 'technique.Technique04.MACD_M_L_OVER0' group by code having count(code) > 1
		String SQL = " select " + COLUMN.CODE + " from " + TBL_Name.LASTORDER
				+ " where "
				+ COLUMN.TYPE + " = '" + type + "'"
				+ " and "
				+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
				+ " and "
				+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
				+ " group by " + COLUMN.CODE
				+ " having count(" + COLUMN.CODE + ") > 1";


		try {

			s.rs2 = s.sqlGetter().executeQuery(SQL);


			if (s.rs2.next()){
				//存在する場合はここを通る。
				SQL = " delete from " + TBL_Name.LASTORDER
						+ " where "
						+ COLUMN.SIGN_FLG + " is true"
						+ " and "
						+ COLUMN.CODE
						+ " in "
						+ " ( "
						+ " select * from "
						+ " ( "
						+ SQL
						+ " ) "
						+ " as sub "
						+ " ) ";

				System.out.println(SQL);
				s.freeUpdateQuery(SQL);
//				commonAP.writeInLog("【重要！】,が買いと売りで重複。購入しないまたは注文取消ししてください。",logWriting.DATEDATE_LOG_FLG);
			};

			//			while(s.rs2.next()){
			//				//売り買い同時に存在する場合、ラストオーダーから買いを消す。
			//				String code = s.rs2.getString(	COLUMN.CODE	);
			//				String SQL2 = " delete from " + TBL_Name.LASTORDER
			//							+ " where "
			//							+ COLUMN.CODE + " = '" + code + "'"
			//							+ " and "
			//							+ COLUMN.TYPE + " = '" + type + "'"
			//							+ " and "
			//							+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
			//							+ " and "
			//							+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
			//							+ " and "
			//							+ COLUMN.SIGN_FLG + " is true";
			////				s.freeUpdateQuery(SQL2);
			//				System.out.println("【重要！】：" + SQL2);
			//
			//				//買いログに出す
			//				commonAP.writeInLog("【重要！】," + code + "が買いと売りで重複。購入しないまたは注文取消ししてください。",logWriting.STOCK_RESULT_LOG_FLG_L);
			//			};

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}







		s.closeConection();
	}


	private static void checkdaySignControll(ArrayList<String> resultCodeList,String type,String L_packageName,String L_className,	String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,int size,boolean judge,ArrayList<String[]> codeList,String checkDay){
		paraDTO.setRealTimeMode(true);

		String packageName = L_packageName;
		String className = L_className;
		String methodName = L_methodName;

		if ( judge ){
			//trueは買いフラグ
		}else{
			packageName = S_packageName;
			className = S_className;
			methodName = S_methodName;
		}

		if (codeList.size()==0){
			return;
		}


		String LMETHOD = (L_packageName + "." + L_className + "." + L_methodName);
		String SMETHOD = (S_packageName + "." + S_className + "." + S_methodName);
//		S s = new S();
//		s.getCon();
		//01_stock_dd a
		//00_codelisttbl b
		//02_statistics_dd c
		String cate = codeList.get(0)[1];


		//全銘柄でループする
		for (int i=0;i< codeList.size();i++){
			String code = codeList.get(i)[0];
			boolean checkMotiResult = false;
			cate = codeList.get(i)[1];

			if ( judge ){
				//trueは買いフラグ
				if(LMETHOD.equals(codeList.get(i)[2]) && SMETHOD.equals(codeList.get(i)[3])){
					setParameta(paraDTO,resultDTO,codeList.get(i));
					checkdaySignControll_sub(code,cate,resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,checkDay);
				}
			}else{
				setParameta(paraDTO,resultDTO,codeList.get(i));
//				paraDTO.setMaxEntryTimes	(	Integer.parseInt(codeList.get(i)[4])	);
//				paraDTO.setMaxKeepDays		(	Integer.parseInt(codeList.get(i)[5])	);
//				resultDTO.setMaxInterValTime(	Integer.parseInt(codeList.get(i)[6])	);
//				paraDTO.setMaxLoss			(	Double.parseDouble(codeList.get(i)[7])	);
				checkdaySignControll_sub(code,cate,resultCodeList,type,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,checkDay);
			}
		}

	}

	private static void setParameta(Bean_Parameta paraDTO,Bean_Result resultDTO,String[] codeList){
		paraDTO.setMaxEntryTimes	(	Integer.parseInt(codeList[4])	);
		paraDTO.setMaxKeepDays		(	Integer.parseInt(codeList[5])	);
		resultDTO.setMaxInterValTime(	Integer.parseInt(codeList[6])	);
		paraDTO.setMaxLoss			(	Double.parseDouble(codeList[7])	);


	}

	private static void checkdaySignControll_sub(String code,String cate,ArrayList<String> resultCodeList,String type,String L_packageName,String L_className,	String L_methodName,String S_packageName,String S_className,String S_methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,int size,boolean judge,String checkDay){
		String day = checkDay;

		String packageName = L_packageName;
		String className = L_className;
		String methodName = L_methodName;

		String LMETHOD = L_packageName + "." + L_className + "." + L_methodName;
		String SMETHOD = S_packageName + "." + S_className + "." + S_methodName;

//		System.out.println("");
//		System.out.println("checkdaySignControll_sub");
//		System.out.println(code);
//		System.out.println(LMETHOD);
//		System.out.println(SMETHOD);
//		System.out.println(paraDTO.getMaxEntryTimes());
//		System.out.println(paraDTO.getMaxKeepDays());
//		System.out.println(resultDTO.getMaxInterValTime());
//		System.out.println(paraDTO.getMaxLoss());

		if ( judge ){
			//trueは買いフラグ

		}else{

			packageName = S_packageName;
			className = S_className;
			methodName = S_methodName;
		}

		S s = new S();
		s.getCon();

		//以下を設定する
		//resultDTO.setEntryTime
		//resultDTO.setRealStartDay
		//resultDTO.setRealAveragePrice
		setEntryTimesEntryDayAveragePrice(code, type, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName, resultDTO, s);


		//買うときにはエントリー回数を参照するので買う時だけ見る
		//売うときにはキープデイズを参照するので売る時だけ見る
		if ( judge ){
			//trueは買いフラグ
//			resultDTO.setEntryTime( getEntryTimes(code, type, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,s) );
		}else{

//			String startDay = getKeepDay(code, type, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,s);
			String startDay = resultDTO.getRealStartDay();
			String endDay = day;
			int keepCount=0;

			if(startDay.equals(endDay)){
				keepCount = 1;
			}else{
				keepCount = commonAP.countDay(startDay,endDay, s) ;
			}

			resultDTO.setKeepCount( keepCount );

		}

		s.closeConection();
		//ｓのコネクションを連続稼働するとエラーがでるのでちょっと止める
		int sleepTime = 7;
		try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}

//		System.out.println(code + ":" + resultDTO.getKeepCount());
//		System.out.println(code + ":" + resultDTO.getEntryTime());

		if ( Techinique_COMMON_METHOD.codeMethodMove(packageName,className,methodName,paraDTO,nowDTOList,nowDTOadress,resultDTO,code,cate,day,size,judge) == Technique98_CONST.TRADE_FLG ){
			resultCodeList.add(code);
			//売りフラグの時、インターバルタイムがtrueかどうかをチェックする
			if ( judge==false ){
				if ( resultDTO.isNowInterValFLG() ){

					//次の処理のためにfalseにする。
					s = new S();
					s.getCon();
					setIntervalTBL(LMETHOD,SMETHOD,type,code,resultDTO.getMaxInterValTime(),s);
					resultDTO.setNowInterValFLG(false);
					//ｓのコネクションを連続稼働するとエラーがでるのでちょっと止める
					try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
					s.closeConection();
				}
			};
		};
		resultDTO.resetCount();
	}

	private static void setIntervalTBL(String Lmethod,String Smethod,String type,String code,int maxInterval,S s){
		String SQL ="insert into " + TBL_Name.INTERVAL_TIME_TBL
				+ " ( "
				+ COLUMN.ENTRYMETHOD								 + " , " //
				+ COLUMN.EXITMETHOD								 	 + " ,  " //
				+ COLUMN.TYPE									 	 + " , " //
				+ COLUMN.CODE										 + " , " //
				+ COLUMN.NOW_INTERVAL								 + " , " //
				+ COLUMN.MAX_INTERVAL								 + "   " //
				+ " ) value ( "
				+ "'" + Lmethod + "'"	 + ","
				+ "'" + Smethod + "'"	 + ","
				+ "'" + type    + "'"	 + ","
				+ "'" + code    + "'"	 + ","
				+ "1"					 + ","
				+ maxInterval			 + " "
				+ ")";
		s.freeUpdateQuery(SQL);
	}

	//true:本番
	//false:試験
	public static void afterCheck(String TODAY,S s){
		deleteIntervalTBL(s);
		increMentIntervalTBL(s);

		String SQL;
		//volumeUnit列を更新する。
		String TBL = TBL_Name.LASTORDER;

		SQL  = " update "+ TBL
				+ " set "
				+ COLUMN.VOLUME_UNIT + " = 100";
		s.freeUpdateQuery(SQL);


		//今日の購入株数を計算する
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//一回当たりエントリー金額（単位：万円）
//		paraDTO.setEntryMoney(0.83);
		checkVolume(paraDTO.getEntryMoney(),TODAY,s);


		//ラストオーダーテーブルをミニ株単元株を分けるならここ


	}



	private static void deleteIntervalTBL(S s){
		String SQL;
		SQL = "delete from " + TBL_Name.INTERVAL_TIME_TBL
			+ " where "
			+ COLUMN.NOW_INTERVAL + " > " + COLUMN.MAX_INTERVAL	;
		s.freeUpdateQuery(SQL);

//		+ COLUMN.ENTRYMETHOD_KATA								 + " , " //
//		+ COLUMN.EXITMETHOD_KATA								 + " ,  " //
//		+ COLUMN.TYPE_KATA									 	 + " , " //
//		+ COLUMN.CODE_KATA										 + " , " //
//		+ COLUMN.NOW_INTERVAL_KATA								 + " , " //
//		+ COLUMN.MAX_INTERVAL_KATA								 + " , " //
	}

	private static void increMentIntervalTBL(S s){
		String SQL;
		String TBL = TBL_Name.INTERVAL_TIME_TBL;
		SQL = " update "
				+ TBL
				+ " set "
				+ COLUMN.NOW_INTERVAL + " = " + COLUMN.NOW_INTERVAL + " + 1";
		try {
			s.sqlGetter().executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}