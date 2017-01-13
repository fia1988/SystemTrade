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

public class CheckSign {


	public static void checkTodaySign(){

		//		commonAP.writeInLog("サイン点灯をチェックします。",logWriting.STOCK_RESULT_LOG_FLG);
		S s = new S();
		s.getCon();
		String TODAY = SQLChecker.getCateToday(ReCord.CODE_01_STOCK,s);

		//前日の注文を実行する。
		dealLastOrder(TODAY);

		ArrayList<String[]> STOCKList = new ArrayList<String[]>();
		ArrayList<String[]> SATISTICSList = new ArrayList<String[]>();
		ArrayList<String[]> INDEXList = new ArrayList<String[]>();
		ArrayList<String[]> ETFNameList = new ArrayList<String[]>();

		ArrayList<String[]> keepStockList = new ArrayList<String[]>();



		//全銘柄をリストに入れる
		commonAP.setCodeList(ReCord.CODE_01_STOCK,s);
		STOCKList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_02_SATISTICS,s);
		SATISTICSList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_03_INDEX,s);
		INDEXList = commonAP.getCodeList();

		commonAP.setCodeList(ReCord.CODE_04_ETF,s);
		ETFNameList = commonAP.getCodeList();

		//キープテーブルのリストを取得
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();



		//別メソッドを動かす前にメモリ解放
		s.closeConection();


		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		//		CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList);


		////		paraDTO = new Bean_Parameta();
		////		resultDTO = new Bean_Result();
		////		nowDTO = new Bean_nowRecord();
		////		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		////		paraDTO.setOnEliteFLG();
		////		CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
		//
		//
		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		//		CHECKTODAY(1,"DD","technique","Technique06","idoHeikinTest_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
		//
		//
		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		//		CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_OVER0",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
		//
		//
		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		//		CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
		//
		//
		////		paraDTO = new Bean_Parameta();
		////		resultDTO = new Bean_Result();
		////		nowDTO = new Bean_nowRecord();
		////		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		////		paraDTO.setOnEliteFLG();
		////		CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_1_S","technique","Technique04","MACD_M_S_OVER0",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);
		//
		//
		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		//		CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_1_S","technique","Technique06","IDO_HEKIN_2_L",paraDTO, nowDTOList, resultDTO,STOCKList,SATISTICSList,INDEXList,ETFNameList);


		//		paraDTO = new Bean_Parameta();
		//		resultDTO = new Bean_Result();
		//		nowDTO = new Bean_nowRecord();
		//		nowDTOList = new ArrayList<>();
		//		SagyoSpace.shokisettei(paraDTO, nowDTO, resultDTO);
		//		paraDTO.setOnEliteFLG();
		CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);





		//メモリの解放
		STOCKList = new ArrayList<String[]>();
		SATISTICSList = new ArrayList<String[]>();
		INDEXList = new ArrayList<String[]>();
		ETFNameList = new ArrayList<String[]>();
		keepStockList = new ArrayList<String[]>();

	}

	public static void dealLastOrder(String checkDay){

		List<String[]> methodList = new ArrayList<String[]>();
		String SQL = " SELECT DISTINCT "
				   + COLUMN.ENTRYMETHOD +	","
				   + COLUMN.EXITMETHOD +	","
				   + COLUMN.TYPE +			" "
				   + " from "
				   + TBL_Name.LASTORDER;
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
			setEntryTBL_L(lastOrderCodeList_L, a[0],a[1],a[2],checkDay);
			lastOrderCodeList_L = new ArrayList<String[]>();

			//前日の分を売る
			List<String[]> lastOrderCodeList_S = new ArrayList<String[]>();
			getLastOrderCodeList(lastOrderCodeList_S,a[0],a[1],a[2],false,checkDay);
			setResultTBL_S(lastOrderCodeList_S,a[0],a[1],a[2],checkDay);
			lastOrderCodeList_S = new ArrayList<String[]>();

		}







	}


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
			String checkDay){




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
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,STOCKList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,SATISTICSList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,INDEXList);
		//		checkTodaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,ETFNameList);
		checkdaySignControll(resultCodeList,S_packageName,S_className,S_methodName,paraDTO,nowDTOList,0,resultDTO,size,false,keepCodeList,checkDay);

		//今日のサインをオーダーに入れる
		makeLastOrderTBL(resultCodeList,L_packageName,L_className,L_methodName,S_packageName,S_className,S_methodName,type,false,checkDay);



		//メモリの解放
		resultCodeList = new ArrayList<String>();

	}



	private static void setResultTBL_S(List<String[]> codeList,String Lmethod,String Smethod,String type,String checkDay){
		S s = new S();
		s.getCon();
//		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
//		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

		String TODAY = checkDay;
		for (int i = 0; i < codeList.size();i++){
			String signDay = codeList.get(i)[5];
			String cate = codeList.get(i)[2];
			String code = codeList.get(i)[0];
			String TBL = SQLChecker.getTBL(cate);

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
							+ COLUMN.EXITMETHOD + " = '" + Smethod + "'";

					s.rs2 = s.sqlGetter().executeQuery(SQL);


					if ( s.rs2.next() ) {
						//trueのとき、存在する。

						String entryDay = s.rs2.getString(COLUMN.ENTRYDAY);
						int entryTime = s.rs2.getInt(COLUMN.ENTRYTIMES);
						double averagePrice = s.rs2.getDouble(COLUMN.AVERAGEPRICE);
						double RETURN = ( nowOpen - averagePrice ) / averagePrice;
//						int keepTime = commonAP.countDay(entryDay,signDay, s) ;
						int keepTime = commonAP.countDay(entryDay,TODAY, s) -1;

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
		checkdaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,STOCKList,checkDay);
		checkdaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,SATISTICSList,checkDay);
		checkdaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,INDEXList,checkDay);
		checkdaySignControll(resultCodeList,L_packageName,L_className,L_methodName,paraDTO,nowDTOList,0,resultDTO,size,true,ETFNameList,checkDay);

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

		//		//まずはラストオーダーを前日の分を削除する。
		//		SQL = " delete from " + TBL_Name.LASTORDER
		//			+ " where "
		//			+ COLUMN.SIGN_FLG + " is " + signFlg
		//			+ " and "
		//			+ COLUMN.TYPE + " = '" + type + "'"
		//			+ " and "
		//			+ COLUMN.ENTRYMETHOD + " = '" + Lmethod + "'"
		//			+ " and "
		//			+ COLUMN.EXITMETHOD + " = '" + Smethod + "'"
		//			;
		//		s.freeUpdateQuery(SQL);
		//		System.out.println("setLastOrderTBL:" + SQL);

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



	private static void setEntryTBL_L(List<String[]> codeList,String Lmethod,String Smethod,String type,String checkDay){


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
								+ COLUMN.ENTRYTIMES									 + " , " //
								+ COLUMN.AVERAGEPRICE								 + " , " //
								+ COLUMN.TYPE									 	 + " , " //
								+ COLUMN.ENTRYMETHOD								 + " , " //
								+ COLUMN.EXITMETHOD									 + "   " //
								+ " ) value ( "
								+ "'" + code + "'"	 + ","
								+ "'" + TODAY+ "'"	 + ","
								+ "'" + TODAY+ "'"	 + ","
								+ "1"				 + ","
								+ nowOpen			 + ","
								+ "'" + type	+ "'"+ ","
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
	private static int getKeepDayEntryTimes(boolean check,
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
		int resultInt = 0;
		String Lmethod = L_packageName + "." + L_className + "." + L_methodName;
		String Smethod = S_packageName + "." + S_className + "." + S_methodName;

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

//				System.out.println(SQL);
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


	private static void checkdaySignControll(ArrayList<String> resultCodeList,String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,int size,boolean judge,ArrayList<String[]> codeList,String checkDay){
		String check="";
		paraDTO.setRealTimeMode(true);
		if ( judge ){
			//trueは買いフラグ
			check = "(買)";
		}else{
			check = "(売)";
		}

		if (codeList.size()==0){
			return;
		}

//		S s = new S();
//		s.getCon();
		//01_stock_dd a
		//00_codelisttbl b
		//02_statistics_dd c
		String cate = codeList.get(0)[1];
		String day = checkDay;

		//全銘柄でループする
		for (int i=0;i< codeList.size();i++){
			String code = codeList.get(i)[0];
			boolean checkMotiResult = false;
			cate = codeList.get(i)[1];

			if ( Techinique_COMMON_METHOD.codeMethodMove(packageName,className,methodName,paraDTO,nowDTOList,nowDTOadress,resultDTO,code,cate,day,size,judge) == Technique98_CONST.TRADE_FLG ){
				resultCodeList.add(code);
			};

		}

	}



}