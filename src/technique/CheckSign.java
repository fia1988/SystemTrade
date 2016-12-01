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

		s.closeConection();


		//今保有している銘柄はココ
		Technique98_CONST.setNowSTOCK();

		commonAP.writeInLog("--------------買いフラグチェックここから------------------",logWriting.STOCK_RESULT_LOG_FLG);
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		List<Bean_nowRecord> nowDTOList = new ArrayList<>();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		checkToday_L_Sign(1,"technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
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
		checkToday_S_Sign(1,"technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
//		checkMACD_S(STOCKList,SATISTICSList,INDEXList,ETFNameList);
		commonAP.writeInLog("--------------売りフラグチェックここまで------------------",logWriting.STOCK_RESULT_LOG_FLG);


	}


	private static void checkToday_L_Sign(
			int size,
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

		ArrayList<String> resultCodeList = new ArrayList<String>();
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,STOCKList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,SATISTICSList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,INDEXList);
		checkTodaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,ETFNameList);


		setEntryTBL(resultCodeList, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,"DD");
	}


	private static void checkToday_S_Sign(
			int size,
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

		ArrayList<String> resultCodeList = new ArrayList<String>();
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,STOCKList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,SATISTICSList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,INDEXList);
		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,ETFNameList);


		setResultTBL(resultCodeList, L_packageName, L_className, L_methodName, S_packageName, S_className, S_methodName,"DD");
	}

	public static void setResultTBL(List<String> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type){
		S s = new S();
		s.getCon();
		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;


		for (int i = 0; i < codeList.size();i++){
			String cate = SQLChecker.getCate(codeList.get(i), s);
			String TBL = SQLChecker.getTBL(cate);
			String code = codeList.get(i);
			String TODAY = SQLChecker.getCateToday(cate,s);
			String SQL = " select "
						+ COLUMN.DAYTIME + "," + COLUMN.CLOSE
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.DAYTIME + " = '" + TODAY
						+ "' and "
						+ COLUMN.CODE + " = '" + code + "'";


			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);

				double nowClose = 0.0;

				while(s.rs2.next()){
					nowClose =s.rs2.getDouble(	COLUMN.CLOSE	);
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

						String entryDay = s.rs2.getString(COLUMN.ENTRYDAY);
						int entryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double averagePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double RETURN = ( nowClose - averagePrice ) / averagePrice;
						int keepTime = commonAP.countDay(entryDay,TODAY, s);

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
								+ "'" + TODAY			+ "'"	 + ","
								+ averagePrice						 + ","
								+ nowClose							 + ","
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

						//売りサインの出た持ってる銘柄だけ表示する。ログ
						commonAP.writeInLog("売:" + Smethod + ":" + code,logWriting.STOCK_RESULT_LOG_FLG);

					}else{
						//falseのとき存在しない

					}


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}

		s.closeConection();
	}

	public static void setEntryTBL(List<String> codeList,String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type){


		S s = new S();
		s.getCon();
		String Lmethod = L_packageName + "_" + L_className + "_" + L_methodName;
		String Smethod = S_packageName + "_" + S_className + "_" + S_methodName;


//		String TODAY = controllDay.getMAX_DD_INDEX(s);
		for (int i = 0; i < codeList.size();i++){
			String cate = SQLChecker.getCate(codeList.get(i), s);
			String TODAY = SQLChecker.getCateToday(cate,s);

			String code = codeList.get(i);
			String TBL = SQLChecker.getTBL(cate);


			String SQL = " select "
						+ COLUMN.DAYTIME + "," + COLUMN.CLOSE
						+ " from "
						+ TBL
						+ " where "
						+ COLUMN.DAYTIME + " = '" + TODAY
						+ "' and "
						+ COLUMN.CODE + " = '" + code + "'";

			try {
				s.rs2 = s.sqlGetter().executeQuery(SQL);
				double nowClose = 0.0;

				boolean existCheck = false;
				while(s.rs2.next()){
					nowClose =s.rs2.getDouble(	COLUMN.CLOSE	);
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
						double nowAveragePrice = ( ( beforeAveragePrice * beforeEntryTime ) + nowClose ) / ( beforeEntryTime + 1);

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
							//買いサインログ
							commonAP.writeInLog("買:" + Lmethod + ":" + code,logWriting.STOCK_RESULT_LOG_FLG);
						}

					}

				}else{
					//falseのとき存在しない
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
						+ nowClose							 + ","
						+ "'" + type			+ "'"	 + ","
						+ "'" + Lmethod			+ "'"	 + ","
						+ "'" + Smethod			+ "'"	 + " "
						+ ")";

					s.freeUpdateQuery(SQL);
					//買いサインログ
					commonAP.writeInLog("買:" + Lmethod + ":" + code,logWriting.STOCK_RESULT_LOG_FLG);
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
			Technique98_CONST.setNowSTOCK();
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
