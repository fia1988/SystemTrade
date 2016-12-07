package technique;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import accesarrySQL.SQLChecker;
import analysis.SagyoSpace;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.logWriting;

public class CheckSign {


	public static void checkTodaySign(){

		commonAP.writeInLog("サイン点灯をチェックします。",logWriting.STOCK_RESULT_LOG_FLG);
		S s = new S();
		s.getCon();

		ArrayList<String[]> STOCKList = new ArrayList<String[]>();
		ArrayList<String[]> SATISTICSList = new ArrayList<String[]>();
		ArrayList<String[]> INDEXList = new ArrayList<String[]>();
		ArrayList<String[]> ETFNameList = new ArrayList<String[]>();


		//全銘柄をリストに入れる
		commonAP.setCodeList(ReCord.CODE_01_STOCK,s);
		STOCKList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_02_SATISTICS,s);
		SATISTICSList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_03_INDEX,s);
		INDEXList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_04_ETF,s);
		ETFNameList = commonAP.getCodeList();

		//別メソッドを動かす前にメモリ解放
		s.closeConection();



		commonAP.writeInLog("--------------買いフラグチェックここから------------------",logWriting.STOCK_RESULT_LOG_FLG);
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		checkToday_L_Sign(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
//		checkMACD_L_SMALL(STOCKList,SATISTICSList,INDEXList,ETFNameList);
//		checkMACD_L(STOCKList,SATISTICSList,INDEXList,ETFNameList);
		commonAP.writeInLog("--------------買いフラグチェックここまで------------------",logWriting.STOCK_RESULT_LOG_FLG);


		commonAP.writeInLog("",logWriting.STOCK_RESULT_LOG_FLG);


		commonAP.writeInLog("--------------売りフラグチェックここから------------------",logWriting.STOCK_RESULT_LOG_FLG);
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		nowDTOList = new ArrayList<>();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		checkToday_S_Sign(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
//		checkMACD_S(STOCKList,SATISTICSList,INDEXList,ETFNameList);
		commonAP.writeInLog("--------------売りフラグチェックここまで------------------",logWriting.STOCK_RESULT_LOG_FLG);

		//メモリの解放
		STOCKList = new ArrayList<String[]>();
		SATISTICSList = new ArrayList<String[]>();
		INDEXList = new ArrayList<String[]>();
		ETFNameList = new ArrayList<String[]>();
		s.closeConection();
	}


	private static void checkToday_L_Sign(
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
			ArrayList<String[]> ETFNameList){


		//前日の分を買う

		List<String[]> lastOrderCodeList = new ArrayList<String[]>();
		makeLastOrderCodeList(lastOrderCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,true);
		setEntryTBL(lastOrderCodeList, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,type);


		//今日のサインを調べる
		ArrayList<String> resultCodeList = new ArrayList<String>();
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,STOCKList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,SATISTICSList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,INDEXList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,ETFNameList);

		//今日のサインをオーダーに入れる
		setLastOrderTBL(resultCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,true);



		//メモリの解放
		resultCodeList = new ArrayList<String>();
		lastOrderCodeList = new ArrayList<String[]>();
	}



	private static void checkToday_S_Sign(
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
			ArrayList<String[]> ETFNameList){


		//前日の分を売る
		List<String[]> lastOrderCodeList = new ArrayList<String[]>();
		makeLastOrderCodeList(lastOrderCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,false);
		setResultTBL(lastOrderCodeList, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,type);

		//今日のサインを調べる
		ArrayList<String> resultCodeList = new ArrayList<String>();
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,STOCKList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,SATISTICSList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,INDEXList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,ETFNameList);

		//今日のサインをオーダーに入れる
		setLastOrderTBL(resultCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,false);



		//メモリの解放
		resultCodeList = new ArrayList<String>();
		lastOrderCodeList = new ArrayList<String[]>();
	}



	private static void makeLastOrderCodeList(List<String[]> lastOrderCodeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type,boolean signFlg){
		S s = new S();
		s.getCon();

		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;



		String SQL = " select * from " + TBL_Name.LASTORDER
					+ " where "
					+ COLUMN.TYPE + " = '" + type + "'"
					+ " and "
					+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
					+ " and "
					+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
					+ " and "
					+ COLUMN.SIGN_FLG
					+ " is "
					+ signFlg;


		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);

			while(s.rs2.next()){
				String codeStatus[] = new String[6];
				codeStatus[0] = s.rs2.getString(	COLUMN.CODE	);
				codeStatus[1] = s.rs2.getString(	COLUMN.DAYTIME	);
				codeStatus[2] = s.rs2.getString(	COLUMN.CATE_FLG	);
				codeStatus[3] = s.rs2.getString(	COLUMN.ENTRYMETHOD	);
				codeStatus[4] = s.rs2.getString(	COLUMN.EXITMETHOD	);
				codeStatus[5] = s.rs2.getString(	COLUMN.DAYTIME	);
				lastOrderCodeList.add(codeStatus.clone());

			};

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}




		s.closeConection();

	}

	//売買サインフラグ。true買い、false売り
	private static void setLastOrderTBL(List<String> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type,boolean signFlg){
		S s = new S();
		s.getCon();

		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;

		String SQL = "";

		//まずはラストオーダーを前日の分を削除する。
		SQL = " delete from " + TBL_Name.LASTORDER
			+ " where "
			+ COLUMN.SIGN_FLG + " is " + signFlg;
		s.freeUpdateQuery(SQL);


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


		//ラストオーダーを挿入する。
		for (int i = 0; i < thisResultCodeList.size();i++){

			String code = thisResultCodeList.get(i);
			String cate = SQLChecker.getCate(thisResultCodeList.get(i), s);
			String TBL = SQLChecker.getTBL(cate);
			String TODAY = SQLChecker.getCateToday(cate,s);

			SQL ="insert into " + TBL_Name.LASTORDER
					+ " ( "
					+ COLUMN.CODE										 + " , " //
					+ COLUMN.DAYTIME									 + " , " //
					+ COLUMN.TYPE									 	 + " , " //
					+ COLUMN.CATE_FLG									 + " , " //
					+ COLUMN.SIGN_FLG								 	 + " , " //売買サインフラグ。true買い、false売り
					+ COLUMN.ENTRYMETHOD								 + " , " //
					+ COLUMN.EXITMETHOD								 + "  " //
					+ " ) value ( "
					+ "'" + code + "'"	 + ","
					+ "'" + TODAY			+ "'"	 + ","
					+ "'" + type			+ "'"	 + ","
					+ cate							 + ","
					+ signFlg						 + ","
					+ "'" + Lmethod			+ "'"	 + ","
					+ "'" + Smethod			+ "'"	 + " "
					+ ")";

			s.freeUpdateQuery(SQL);
			//サインの出た持ってる銘柄だけ表示する。ログ
			commonAP.writeInLog(check + ":" + TODAY + ":" +  code + ":" + Lmethod + ":" + Smethod,logWriting.STOCK_RESULT_LOG_FLG);
		}




//		メモリの解放
		thisResultCodeList = new ArrayList<String>();
		s.closeConection();
	}

	public static void setResultTBL(List<String[]> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type){
		S s = new S();
		s.getCon();
		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;


		for (int i = 0; i < codeList.size();i++){
			String signDay = codeList.get(i)[5];
			String cate = codeList.get(i)[2];
			String code = codeList.get(i)[0];
			String TBL = SQLChecker.getTBL(cate);
			boolean exitCheck = false;

			//最新日が売りサイン
			String SQL = " select "
						+ COLUMN.DAYTIME + "," + COLUMN.OPEN
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.DAYTIME + " > '" + signDay
						+ "' and "
						+ COLUMN.CODE + " = '" + code + "'"
						+ " order by " + COLUMN.DAYTIME + " desc";


			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				double nowOpen = 0.0;

				if(s.rs2.next()){
					nowOpen =s.rs2.getDouble(	COLUMN.OPEN	);
					exitCheck = true;
					System.out.println("setResultTBL:" + SQL);
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
							+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";

					s.rs2 = s.sqlGetter().executeQuery(SQL);


					if ( s.rs2.next() ) {
						//trueのとき、存在する。

						String entryDay = s.rs2.getString(COLUMN.ENTRYDAY);
						int entryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double averagePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double RETURN = ( nowOpen - averagePrice ) / averagePrice;
						int keepTime = commonAP.countDay(entryDay,signDay, s) - 1;

						SQL ="insert into " + TBL_Name.RESULTHISTROYTBL
								+ " ( "
								+ COLUMN.CODE										 + " , " //
								+ COLUMN.ENTRYDAY									 + " , " //
								+ COLUMN.EXITDAY									 + " , " //
								+ COLUMN.AVERAGEPRICE								 + " , " //
								+ COLUMN.EXITPRICE									 + " , " //
								+ COLUMN.TYPE									 	 + " , " //
								+ COLUMN.ENTRYTIMES								 + " , " //
								+ COLUMN.RESULTRETURN									 + " , " //
								+ COLUMN.KEEPTIME									 + " , " //
								+ COLUMN.ENTRYMETHOD								 + " , " //
								+ COLUMN.EXITMETHOD								 + "   " //
								+ " ) value ( "
								+ "'" + code + "'"	 + ","
								+ "'" + entryDay			+ "'"	 + ","
								+ "'" + signDay			+ "'"	 + ","
								+ averagePrice						 + ","
								+ nowOpen							 + ","
								+ "'" + type			+ "'"	 + ","
								+ entryTime							 + ","
								+ RETURN							 + ","
								+ keepTime							 + ","
								+ "'" + Lmethod			+ "'"	 + ","
								+ "'" + Smethod			+ "'"	 + " "
								+ ")";

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
						//commonAP.writeInLog("売:" + Lmethod + ":" + Smethod + ":" + signDay + ":" +  code,logWriting.STOCK_RESULT_LOG_FLG);
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

	public static void setEntryTBL(List<String[]> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type){


		S s = new S();
		s.getCon();
		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;


//		String TODAY = controllDay.getMAX_DD_INDEX(s);
		for (int i = 0; i < codeList.size();i++){
			String cate = codeList.get(i)[2];
			String signDay = codeList.get(i)[5];
			String TODAY = SQLChecker.getCateToday(cate,s);


			String code = codeList.get(i)[0];
			String TBL = SQLChecker.getTBL(cate);


			//最新日が買いサイン
			String SQL = " select "
						+ COLUMN.DAYTIME + "," + COLUMN.OPEN
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.DAYTIME + " > '" + signDay
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
					+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";

				s.rs2 = s.sqlGetter().executeQuery(SQL);


				if ( s.rs2.next() ) {
					//trueのとき、存在する。

					if( !s.rs2.getString(COLUMN.LASTENTRYDAY).equals(TODAY)){
						//一緒じゃない場合だけ動く

						int beforeEntryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double beforeAveragePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double nowAveragePrice = ( ( beforeAveragePrice * beforeEntryTime ) + nowOpen ) / ( beforeEntryTime + 1);

//						s.rs2.updateDouble(COLUMN.AVERAGEPRICE,nowAveragePrice);
//						s.rs2.updateInt(COLUMN.ENTRYTIMES,beforeEntryTime + 1);
//						s.rs2.updateString(COLUMN.LASTENTRYDAY,TODAY);


						if(existCheck){
							//
							SQL = " update "+ TBL_Name.KEEPLISTTBL + " "
								+ " set "
								+ COLUMN.ENTRYTIMES + 	   " = " + ( beforeEntryTime + 1 ) + " , "
								+ COLUMN.AVERAGEPRICE + 	   " = " + nowAveragePrice + " , "
								+ COLUMN.LASTENTRYDAY + " = '" + TODAY + "' "
								+ " where "
								+ COLUMN.CODE + " = '" + code + "'"
								+ " and "
								+ COLUMN.TYPE + " = '" + type + "'"
								+ " and "
								+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
								+ " and "
								+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";;
							s.freeUpdateQuery(SQL);

						}

					}

				}else{
					//falseのとき存在しない
					if(existCheck){
						SQL ="insert into " + TBL_Name.KEEPLISTTBL
								+ " ( "
								+ COLUMN.CODE										 + " , " //
								+ COLUMN.ENTRYDAY									 + " , " //
								+ COLUMN.LASTENTRYDAY								 + " , " //
								+ COLUMN.ENTRYTIMES								 + " , " //
								+ COLUMN.AVERAGEPRICE								 + " , " //
								+ COLUMN.TYPE									 	 + " , " //
								+ COLUMN.ENTRYMETHOD								 + " , " //
								+ COLUMN.EXITMETHOD								 + "   " //
								+ " ) value ( "
								+ "'" + code + "'"	 + ","
								+ "'" + TODAY			+ "'"	 + ","
								+ "'" + TODAY			+ "'"	 + ","
								+ "1"							 + ","
								+ nowOpen							 + ","
								+ "'" + type			+ "'"	 + ","
								+ "'" + Lmethod			+ "'"	 + ","
								+ "'" + Smethod			+ "'"	 + " "
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



	private static void checkMACD_L_SMALL(ArrayList<String[]> STOCKList,ArrayList<String[]> SATISTICSList,ArrayList<String[]> INDEXList,ArrayList<String[]> ETFNameList){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();
		String methodName = Technique98_CONST.MACD_M_L_SMALL;
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//損切ライン
		paraDTO.setWinWariai(2.1);
		paraDTO.setLoseWariai(0.17);

//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,STOCKList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,SATISTICSList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,INDEXList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,ETFNameList);
	}


	//今日のサインチェック
	//sizeはメソッドごとに何日前までみるかを見る
	private static void checkMACD_L(ArrayList<String[]> STOCKList,ArrayList<String[]> SATISTICSList,ArrayList<String[]> INDEXList,ArrayList<String[]> ETFNameList){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//損切ライン
		paraDTO.setWinWariai(2.1);
		paraDTO.setLoseWariai(0.47);
//
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,STOCKList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,SATISTICSList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,INDEXList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,ETFNameList);
	}

	private static void checkMACD_S(ArrayList<String[]> STOCKList,ArrayList<String[]> SATISTICSList,ArrayList<String[]> INDEXList,ArrayList<String[]> ETFNameList){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//損切ライン
		paraDTO.setWinWariai(2.1);
		paraDTO.setLoseWariai(0.47);

//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,STOCKList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,SATISTICSList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,INDEXList);
//		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,ETFNameList);


	}

	//nowDTOadressはなんでもいい
	private static void checkTodaySignControll(ArrayList<String> resultCodeList,String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,int size,boolean judge,ArrayList<String[]> codeList){
		String check="";
		if ( judge ){
			//trueは買いフラグ
			check = "(買)";
		}else{
			check = "(売)";
		}
		S s = new S();
		s.getCon();
		 //01_stock_dd a
		 //00_codelisttbl b
		 //02_statistics_dd c
		String cate = codeList.get(0)[1];
		String day = SQLChecker.getCateToday(cate,s);

		//全銘柄でループする
		for (int i=0;i< codeList.size();i++){
			String code = codeList.get(i)[0];
			boolean checkMotiResult = false;
			cate = codeList.get(i)[1];

			if ( Techinique_COMMON_METHOD.codeMethodMove(packageName,className,methodName,paraDTO,nowDTOList,nowDTOadress,resultDTO,code,day,size,judge) == Technique98_CONST.TRADE_FLG ){

//				if (judge == false){
//
//					//持っている銘柄の場合は出力する。
//					for ( int n = 0; n < Technique98_CONST.getNowSTOCK().size() ; n++){
//						if (Technique98_CONST.getNowSTOCK().get(n).equals(code)){
//
//							commonAP.writeLog("【持ってる銘柄】",logWriting.STOCK_RESULT_LOG_FLG);
//							checkMotiResult = true;
//						}
//					}
//
//				}
//
//				if (judge ==true ){
//
//					boolean checkMoti = false;
//
//					for ( int n = 0; n < Technique98_CONST.getNowSTOCK().size() ; n++){
//						if (Technique98_CONST.getNowSTOCK().get(n).equals(code)){
//							checkMoti=true;
//							commonAP.writeLog("【持ってる銘柄】",logWriting.STOCK_RESULT_LOG_FLG);
//						}
//					}
//
//					if (checkMoti){
//						//持ってない銘柄が買いフラグ来た場合は追加する。
//						//持ってる場合はスキップ
//						Technique98_CONST.nowSTOCK.add(code);
//						checkMoti = false;
//					}
//				}

				if(judge){

					resultCodeList.add(code);

				}else{
					//売りサイン表示
//					if (checkMotiResult){

						resultCodeList.add(code);
//					}
//					System.out.println(check + ":" + packageName + "," + className + "," + methodName + ":" + code);
				}




			};

		}

	}
}
