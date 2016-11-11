package technique;

import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.controllDay;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

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
		checkMACD_L_SMALL(STOCKList,SATISTICSList,INDEXList,ETFNameList);
//		checkMACD_L(STOCKList,SATISTICSList,INDEXList,ETFNameList);
		commonAP.writeInLog("--------------買いフラグチェックここまで------------------",logWriting.STOCK_RESULT_LOG_FLG);
		commonAP.writeInLog("",logWriting.STOCK_RESULT_LOG_FLG);
		commonAP.writeInLog("--------------売りフラグチェックここから------------------",logWriting.STOCK_RESULT_LOG_FLG);
//		checkMACD_S(STOCKList,SATISTICSList,INDEXList,ETFNameList);
		commonAP.writeInLog("--------------売りフラグチェックここまで------------------",logWriting.STOCK_RESULT_LOG_FLG);


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

		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,STOCKList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,SATISTICSList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,INDEXList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,methodName,paraDTO,nowDTOList,0,resultDTO,1,true,ETFNameList);
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

		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,STOCKList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,SATISTICSList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,INDEXList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_L,paraDTO,nowDTOList,0,resultDTO,1,true,ETFNameList);
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

		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,STOCKList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,SATISTICSList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,INDEXList);
		checkTodaySignControll(Technique98_CONST.PACKAGE_01,Technique98_CONST.CLASS_04,Technique98_CONST.MACD_M_S_14,paraDTO,nowDTOList,0,resultDTO,1,false,ETFNameList);


	}

	//nowDTOadressはなんでもいい
	private static void checkTodaySignControll(String packageName,String className,String methodName,Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,int size,boolean judge,ArrayList<String[]> codeList){
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
		String day = "";
		String cate = codeList.get(0)[1];
		switch(cate){
		case ReCord.CODE_01_STOCK:
			day = controllDay.getMAX_DD_STOCK_ETF(s);
			break;
		case ReCord.CODE_02_SATISTICS:
			day = controllDay.getMAX_DD_STATISTICS(s);
			break;
		case ReCord.CODE_03_INDEX:
			day = controllDay.getMAX_DD_INDEX(s);
			break;
		case ReCord.CODE_04_ETF:
			day = controllDay.getMAX_DD_STOCK_ETF(s);
			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			break;
		}

		//全銘柄でループする
		for (int i=0;i< codeList.size();i++){
			String code = codeList.get(i)[0];
			boolean checkMotiResult = false;
			cate = codeList.get(i)[1];

			if ( Techinique_COMMON_METHOD.codeMethodMove(packageName,className,methodName,paraDTO,nowDTOList,nowDTOadress,resultDTO,code,day,size,judge) == Technique98_CONST.TRADE_FLG ){

				if (judge == false){

					//持っている銘柄の場合は出力する。
					for ( int n = 0; n < Technique98_CONST.getNowSTOCK().size() ; n++){
						if (Technique98_CONST.getNowSTOCK().get(n).equals(code)){

							commonAP.writeLog("【持ってる銘柄】",logWriting.STOCK_RESULT_LOG_FLG);
							checkMotiResult = true;
						}
					}

				}

				if (judge ==true ){

					boolean checkMoti = false;

					for ( int n = 0; n < Technique98_CONST.getNowSTOCK().size() ; n++){
						if (Technique98_CONST.getNowSTOCK().get(n).equals(code)){
							checkMoti=true;
							commonAP.writeLog("【持ってる銘柄】",logWriting.STOCK_RESULT_LOG_FLG);
						}
					}

					if (checkMoti){
						//持ってない銘柄が買いフラグ来た場合は追加する。
						//持ってる場合はスキップ
						Technique98_CONST.nowSTOCK.add(code);
						checkMoti = false;
					}

//					System.out.println(Technique98_CONST.getNowSTOCK().size());
				}

				if(judge){
					//買いサイン表示
					commonAP.writeInLog(check + ":" + packageName + "," + className + "," + methodName + ":" + code,logWriting.STOCK_RESULT_LOG_FLG);
//					System.out.println(check + ":" + packageName + "," + className + "," + methodName + ":" + code);
				}else{
					//売りサイン表示
					if (checkMotiResult){
						//売りサインの出た持ってる銘柄だけ表示する。
						commonAP.writeInLog(check + ":" + packageName + "," + className + "," + methodName + ":" + code,logWriting.STOCK_RESULT_LOG_FLG);
//						System.out.println(check + ":" + packageName + "," + className + "," + methodName + ":" + code);
					}
//					System.out.println(check + ":" + packageName + "," + className + "," + methodName + ":" + code);
				}




			};

		}

	}
}
