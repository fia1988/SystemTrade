package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import technique.CheckSign;
import technique.Technique98_CONST;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.ReCord;

public class SagyoSpace {


	public static void shokisettei(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		resultDTO.setShoritu(0.85);
		resultDTO.setTotalGames(25);
		//手数料
		paraDTO.setTesuRYO(0.022);
		//統計データを使わない場合
		paraDTO.setStaticsFLG(false);
		//一回当たりエントリー金額（単位：万円）
//		paraDTO.setEntryMoney(0.83);

//		paraDTO.setCheckCate(ReCord.CODE_01_STOCK);
		System.out.println("【出来高"+ i + "】");
	}

	public static void shokisettei_false(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。

		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setCheckRenzokuSign(false);

	}



	public static void testCase99(){



		S s = new S();
		s.getCon();

		ArrayList<String[]> STOCKList = new ArrayList<String[]>();
		ArrayList<String[]> SATISTICSList = new ArrayList<String[]>();
		ArrayList<String[]> INDEXList = new ArrayList<String[]>();
		ArrayList<String[]> ETFNameList = new ArrayList<String[]>();

		ArrayList<String[]> keepStockList = new ArrayList<String[]>();

		String TODAY = "";

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
		TODAY = "2017-01-04";
		System.out.println(keepStockList.size());
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);


		TODAY = "2017-01-05";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		System.out.println(keepStockList.size());
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

		TODAY = "2017-01-06";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		System.out.println(keepStockList.size());
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);


		TODAY = "2017-01-10";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		System.out.println(keepStockList.size());
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);


		TODAY = "2017-01-11";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		System.out.println(keepStockList.size());
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);


		TODAY = "2017-01-12";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		
		TODAY = "2017-01-13";
		CheckSign.dealLastOrder(TODAY);
		s.getCon();
		commonAP.setKeepCodeList(s);
		keepStockList = commonAP.getCodeList();
		s.closeConection();
		CheckSign.CHECKTODAY(1,"DD","technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
		CheckSign.CHECKTODAY(1,"DD","technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);

	}

	public static void testCase30(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2007-01-04";
		String endDD		=	"2016-08-01";
//		String startDD	=	"2007-06-30";
//		String endDD		=	"2009-07-01";

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(27);
//		paraDTO.setMaxKeepDays(59);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(65);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(45);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(24);
		paraDTO.setMaxKeepDays(42);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(58);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);


//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique06","IDO_HEKIN_4_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(65);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(30);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(24);
		paraDTO.setMaxKeepDays(40);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_S","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(25);
		paraDTO.setMaxKeepDays(54);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(30);
		paraDTO.setMaxKeepDays(16);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

	}


	public static void testCase29(){


		long start = System.currentTimeMillis();

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		String startDD	=	"2017-01-04";
		String endDD		=	"2017-01-13";
//		startDD	=	"2016-09-26";
//		endDD		=	"2017-01-13";
		String L_CLASS = "";
		String L_METHOD = "";
//		startDD	=	"2016-10-26";
//		endDD		=	"2016-12-28";
		List<String[]> methodList_L = new ArrayList<String[]>();


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		System.out.println("");
		resultDTO.setOnResultDay();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		System.out.println("");
		resultDTO.setOnResultDay();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


	}
	public static void testCase28(){


		long start = System.currentTimeMillis();

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		String startDD	=	"";
		String endDD		=	"";
		String L_CLASS = "";
		String L_METHOD = "";


//		List<Double> returnList = new ArrayList();
		List<String[]> methodList_L = new ArrayList<String[]>();
		String methodName[] = new String[2];
		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_L_OVER0";
		methodList_L.add(methodName.clone());

//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_L_OVER0";
//		methodList_L.add(methodName.clone());

		List<String[]> methodList_S = new ArrayList<String[]>();
		String methodNameS[] = new String[2];
		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());

		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_S_OVER0";
		methodList_S.add(methodNameS.clone());


		List<String[]> checkDAYS = new ArrayList<String[]>();
		String checkDAY[] = new String[3];
//		checkDAY[0] = "2016-01-01";
//		checkDAY[1] = "2016-10-31";
//		checkDAY[2] = "直近";
//		checkDAYS.add(checkDAY.clone());
//
		checkDAY[0] = "2007-01-01";
		checkDAY[1] = "2016-08-01";
		checkDAY[2] = "歴史";
		checkDAYS.add(checkDAY.clone());

//		checkDAY[0] = "2007-06-30";
//		checkDAY[1] = "2009-07-01";
//		checkDAY[2] = "リーマンショック";
//		checkDAYS.add(checkDAY.clone());
//
//
//		checkDAY[0] = "2007-01-01";
//		checkDAY[1] = "2007-12-31";
//		checkDAY[2] = "2007";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2008-01-01";
//		checkDAY[1] = "2008-12-31";
//		checkDAY[2] = "2008";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2009-01-01";
//		checkDAY[1] = "2009-12-31";
//		checkDAY[2] = "2009";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2010-01-01";
//		checkDAY[1] = "2010-12-31";
//		checkDAY[2] = "2010";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2011-01-01";
//		checkDAY[1] = "2011-12-31";
//		checkDAY[2] = "2011";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2012-01-01";
//		checkDAY[1] = "2012-12-31";
//		checkDAY[2] = "2012";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2013-01-01";
//		checkDAY[1] = "2013-12-31";
//		checkDAY[2] = "2013";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2014-01-01";
//		checkDAY[1] = "2014-12-31";
//		checkDAY[2] = "2014";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2015-01-01";
//		checkDAY[1] = "2015-12-31";
//		checkDAY[2] = "2015";
//		checkDAYS.add(checkDAY.clone());
//
//		checkDAY[0] = "2016-01-01";
//		checkDAY[1] = "2016-11-30";
//		checkDAY[2] = "2016";
//		checkDAYS.add(checkDAY.clone());

//		checkDAY[0] = "2007-06-30";
//		checkDAY[1] = "2009-07-01";
//		checkDAY[2] = "リーマンショック";
//		checkDAYS.add(checkDAY.clone());


		for (int a = 0 ;a < checkDAYS.size() ; a++){
			System.out.println("");
			System.out.println("--------" + checkDAYS.get(a)[2] + "--------");
			startDD	=	checkDAYS.get(a)[0];
			endDD		=	checkDAYS.get(a)[1];

			for (int b = 0 ;b < methodList_L.size() ; b++){
				L_CLASS = methodList_L.get(b)[0];
				L_METHOD = methodList_L.get(b)[1];



				for (int c = 0 ;c < methodList_S.size() ; c++){
					paraDTO = new Bean_Parameta();
					resultDTO = new Bean_Result();
					nowDTO = new Bean_nowRecord();
					shokisettei(paraDTO, nowDTO, resultDTO);
//					paraDTO.setRumNumber(50);
					paraDTO.setTesuRYO(0.0);
//					paraDTO.setOnEliteFLG();
					System.out.println("");
					Analysis00_Common.Analysis_COMMON("technique",L_CLASS,L_METHOD,"technique",methodList_S.get(c)[0],methodList_S.get(c)[1],paraDTO,nowDTO,resultDTO,startDD,endDD);

				}
			}
		}

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}


	public static void testCase27(){
		long start = System.currentTimeMillis();

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();

		shokisettei(paraDTO, nowDTO, resultDTO);
		resultDTO.setOnResultDay();
		S s = new S();
		s.getCon();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_4_S","technique","Technique06","IDO_HEKIN_1_L",paraDTO,nowDTO,resultDTO,"1345―T","2016-01-01","2016-10-31",s);

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}


	public static void testCase26(){
		long start = System.currentTimeMillis();

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		String startDD	=	"";
		String endDD		=	"";
		String L_CLASS = "";
		String L_METHOD = "";


//		List<Double> returnList = new ArrayList();
		List<String[]> methodList_L = new ArrayList<String[]>();
		String methodName[] = new String[2];
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_L_OVER0";
//		methodList_L.add(methodName.clone());


//		methodName[0] = "Technique06";
//		methodName[1] = "idoHeikinTest_L";
//		methodList_L.add(methodName.clone());
//
//
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_L";
//		methodList_L.add(methodName.clone());


//		methodName[0] = "Technique08";
//		methodName[1] = "MACD_IDOHEIKIN_L";
//		methodList_L.add(methodName.clone());


//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_1_L";
//		methodList_L.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_2_L";
//		methodList_L.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_3_L";
//		methodList_L.add(methodName.clone());


//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_4_L";
//		methodList_L.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_1_S";
//		methodList_L.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_2_S";
//		methodList_L.add(methodName.clone());


//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_3_S";
//		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_4_S";
		methodList_L.add(methodName.clone());



		List<String[]> methodList_S = new ArrayList<String[]>();
		String methodNameS[] = new String[2];
		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_OR_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_0_OR_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "idoHeikinTest_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_S_OVER0";
		methodList_S.add(methodNameS.clone());


//		methodNameS[0] = "Technique04";
//		methodNameS[1] = "MACD_M_S_14";
//		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_1_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_2_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_3_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_4_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_1_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_2_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_3_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "IDO_HEKIN_4_S";
		methodList_S.add(methodNameS.clone());



		List<String[]> checkDAYS = new ArrayList<String[]>();
		String checkDAY[] = new String[3];
//		checkDAY[0] = "2016-01-01";
//		checkDAY[1] = "2016-10-31";
//		checkDAY[2] = "直近";
//		checkDAYS.add(checkDAY.clone());

		checkDAY[0] = "2007-01-01";
		checkDAY[1] = "2016-08-01";
		checkDAY[2] = "歴史";
		checkDAYS.add(checkDAY.clone());

//		checkDAY[0] = "2007-06-30";
//		checkDAY[1] = "2009-07-01";
//		checkDAY[2] = "リーマンショック";
//		checkDAYS.add(checkDAY.clone());


		for (int a = 0 ;a < checkDAYS.size() ; a++){
			System.out.println("");
			System.out.println("--------" + checkDAYS.get(a)[2] + "--------");
			startDD	=	checkDAYS.get(a)[0];
			endDD		=	checkDAYS.get(a)[1];

			for (int b = 0 ;b < methodList_L.size() ; b++){
				L_CLASS = methodList_L.get(b)[0];
				L_METHOD = methodList_L.get(b)[1];



				for (int c = 0 ;c < methodList_S.size() ; c++){

					System.out.println("");

					paraDTO = new Bean_Parameta();
					resultDTO = new Bean_Result();
					nowDTO = new Bean_nowRecord();
					shokisettei(paraDTO, nowDTO, resultDTO);
//					paraDTO.setTesuRYO(0.0);


					if (!(L_METHOD.equals(methodList_S.get(c)[1]))){
						Analysis00_Common.Analysis_COMMON("technique",L_CLASS,L_METHOD,"technique",methodList_S.get(c)[0],methodList_S.get(c)[1],paraDTO,nowDTO,resultDTO,startDD,endDD);
					}



				}
			}
		}

		//ここから繰り返し
		ArrayList<String[]> methodList_ROOP_L = new ArrayList<String[]>();
		String methodRoopName[] = new String[2];
		methodRoopName[0] = "Technique04";
		methodRoopName[1] = "MACD_M_L_ENTRY";
		methodList_ROOP_L.add(methodRoopName.clone());

		methodRoopName[0] = "Technique04";
		methodRoopName[1] = "MACD_M_L_OVER0_ENTRY";
		methodList_ROOP_L.add(methodRoopName.clone());



		for (int a = 0 ;a < checkDAYS.size() ; a++){
			System.out.println("");
			System.out.println("--------" + checkDAYS.get(a)[2] + "--------");
			startDD	=	checkDAYS.get(a)[0];
			endDD		=	checkDAYS.get(a)[1];

			for (int b = 0 ;b < methodList_ROOP_L.size() ; b++){
				L_CLASS = methodList_ROOP_L.get(b)[0];
				L_METHOD = methodList_ROOP_L.get(b)[1];

				for (int c = 0 ;c < methodList_S.size() ; c++){

					for (int i = 0 ;i < 20 ; i=i+5){

						paraDTO = new Bean_Parameta();
						resultDTO = new Bean_Result();
						nowDTO = new Bean_nowRecord();
						shokisettei(paraDTO, nowDTO, resultDTO);
						paraDTO.setIntCount01(i);

						System.out.println("");
						System.out.println("繰り返し設定：" + i);
//						Analysis00_Common.Analysis_COMMON("technique",L_CLASS,L_METHOD,"technique",methodList_S.get(c)[0],methodList_S.get(c)[1],paraDTO,nowDTO,resultDTO,startDD,endDD);

					}

				}
			}
		}




		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


	}

	public static void testCase25(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		long start = System.currentTimeMillis();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		S s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(5);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		paraDTO.setIntCount01(10);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(15);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");


		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


	}
	public static void testCase24(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		long start = System.currentTimeMillis();

		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}
	public static void testCase23(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		long start = System.currentTimeMillis();

		testCase21();
		System.out.println("");
		System.out.println("ここからてｓｔ20");
		System.out.println("");
		testCase20();
		System.out.println("");
		System.out.println("ここからてｓｔ20");
		System.out.println("");
		testCase25();
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","testL","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//
//		shokisettei(paraDTO, nowDTO, resultDTO);
//
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		List<Double> doubleListCopy = new ArrayList<Double>();
//
//		doubleListCopy.add(0.1);
//		doubleListCopy.add(0.2);
//		doubleListCopy.add(0.3);
//		doubleListCopy.add(0.4);
//		doubleListCopy.add(0.5);
//		doubleListCopy.add(0.6);
//		doubleListCopy.add(0.7);
//		doubleListCopy.add(0.8);
//		doubleListCopy.add(0.9);
//		doubleListCopy.add(1.0);
//		doubleListCopy.add(-0.1);
//		doubleListCopy.add(-0.2);
//		doubleListCopy.add(-0.3);
//		doubleListCopy.add(-0.4);
//		doubleListCopy.add(-0.5);
//		doubleListCopy.add(-0.6);
//		doubleListCopy.add(-0.7);
//		doubleListCopy.add(-0.8);
//		doubleListCopy.add(-0.9);
//		doubleListCopy.add(-1.0);
//
//		System.out.println(commonAP.getDev(doubleListCopy,true,	0.4,	0.1));
//		S s = new S();
//		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"5721―T","2009-07-01","2013-08-01",s);

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}
	public static void testCase22(){
		long start = System.currentTimeMillis();


		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");


		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}



	public static void testCase21(){

		long start = System.currentTimeMillis();

		System.out.println("【2007-01-01,2016-08-01】");


		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		S s = new S();
		s.getCon();
//		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");



		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(20);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(5);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(10);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");




		System.out.println("【2007-06-30、2009-07-01】");
		System.out.println("");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(10);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		paraDTO.setIntCount01(0);
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		paraDTO.setIntCount01(5);
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(10);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}

	public static void testCase20(){

		long start = System.currentTimeMillis();

		System.out.println("【2007-01-01,2016-08-01】");
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		S s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","testL","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");



		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-05-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);

		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		System.out.println("【2007-06-30、2009-07-01】");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");




		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");




		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);


		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}

	public static void testCase19(){

		System.out.println("ここから18");
		testCase18();
		System.out.println("ここから17");
		testCase17();
	}

	public static void testCase18(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(20);
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_ENTRY","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2015-07-01","2016-06-30");

	}

	public static void testCase17(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();

		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_ENTRY","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_BORIBAN","technique","Technique04","MACD_M_S_OVER0_BORIBAN",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		System.out.println("");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setIntCount01(20);
		shokisettei(paraDTO, nowDTO, resultDTO);

		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_ENTRY","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setCheckRenzokuSign(false);
//		S s = new S();
//		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"1587―T","2016-05-01","2016-08-01",s);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");
//		s.closeConection();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");



		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}

	public static void testCase16(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		long start = System.currentTimeMillis();

		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
		resultDTO.setOnResultDay();
//		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		resultDTO.setShoritu(0);
		resultDTO.setTotalGames(0);
		//手数料
		paraDTO.setTesuRYO(0.01);
		System.out.println("【出来高"+ i + "】");

		Analysis00_Common.Analysis_COMMON("technique","Technique04","testL","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2014-07-01","2015-06-30");
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}

	public static void testCase15(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();

		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_BORIBAN","technique","Technique04","MACD_M_S_OVER0_BORIBAN",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		System.out.println("");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);

		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		shokisettei(paraDTO, nowDTO, resultDTO);
//		paraDTO.setCheckRenzokuSign(false);
//		S s = new S();
//		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"1587―T","2016-05-01","2016-08-01",s);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");
//		s.closeConection();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}


	public static void testCase14(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();

		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique09","BORIBAN_L","technique","Technique09","BORIBAN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}
	public static void testCase13(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();




		S s = new S();
		s.getCon();
//
//		shokisettei(paraDTO, nowDTO, resultDTO);
//
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_TORAKU_L","technique","Technique08","MACD_TORAKU_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//
//



//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.06);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.07);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.08);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.09);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.10);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.11);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.12);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.13);
		shokisettei(paraDTO, nowDTO, resultDTO);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}

	public static void testCase12(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		resultDTO.setShoritu(0.8);
		resultDTO.setTotalGames(20);
		System.out.println("【出来高"+ i + "】");

		S s = new S();
		s.getCon();

		//手数料
		paraDTO.setTesuRYO(0.01);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		Analysis00_Common.Analysis_COMMON("technique","Technique07","torakuRatio_L","technique","Technique07","torakuRatio_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-31","2016-06-30");
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}



	public static void testCase11(){


		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		resultDTO.setShoritu(0.8);
		resultDTO.setTotalGames(20);
		System.out.println("【出来高"+ i + "】");

		S s = new S();
		s.getCon();

		//手数料
		paraDTO.setTesuRYO(0.05);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-31","2016-06-30");
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}



	public static void testCase10(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		System.out.println("【出来高"+ i + "】");

		S s = new S();
		s.getCon();

		//手数料
		paraDTO.setTesuRYO(0.05);
		resultDTO.setShoritu(0.8);
		resultDTO.setTotalGames(20);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-31","2016-06-30");



		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}
	public static void testCase09(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1;
		paraDTO.setMinDeki(i);
		System.out.println("【出来高"+ i + "】");

		S s = new S();
		s.getCon();

		//手数料
				paraDTO.setTesuRYO(0.01);
//
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
//		resultDTO.setOnResultTotal();
//		//勝敗条件
//				paraDTO.setWinWariai(111.01);
//				paraDTO.setLoseWariai(0.05);
//				paraDTO.setCheckKeepDay(100000);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2015-06-30");
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
//		resultDTO.setOnResultTotal();
		//勝敗条件
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2014-06-30","2015-07-01");
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		resultDTO.setOffResultDay();
//		resultDTO.setOffResultCode();
//		resultDTO.setOnResultTotal();
//		//勝敗条件
//				paraDTO.setWinWariai(111.01);
//				paraDTO.setLoseWariai(0.75);
//				paraDTO.setCheckKeepDay(100000);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1629―T",s);
		paraDTO.setCheckKeepDay(930);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_beforeDay","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}
	public static void testCase08(){


		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 0;
		paraDTO.setMinDeki(i);
		System.out.println("【出来高"+ i + "】");

		S s = new S();
		s.getCon();

//		手数料
//		paraDTO.setTesuRYO(0.01);

//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1629―T",s);

//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_beforeDay","technique","Technique04","MACD_M_S_14_beforeDay",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-08-01","2009-07-31");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1310―T",s);




//		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO);
//		resultDTO.getResultTotalResult("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO);
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}


	public static void testCase07(){





		ArrayList<String[]> methodList = new ArrayList<String[]>();
		String methodName[] = new String[3];
		methodName[0] = "technique";
		methodName[1] = "Technique04";
		methodName[2] = "MACD_M_L";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_01";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_02";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_03";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_04";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_05";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_06";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_07";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_08";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_09";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_10";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_11";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_12";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_13";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_14";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_15";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_L_16";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_01";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_02";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_03";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_04";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_05";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_06";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_07";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_08";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_09";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_10";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_11";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_12";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_13";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_14";
		methodList.add(methodName);

		methodName = new String[3];
		methodName[2] = "MACD_M_S_15";
		methodList.add(methodName);







		long start = System.currentTimeMillis();

		for (int i = 0 ;i < methodList.size() ; i++){
			for (int p = 0 ;p < methodList.size() ; p++){

				if (methodList.get(i)[2].equals(methodList.get(p)[2])){

				}else{
					Bean_Parameta paraDTO = new Bean_Parameta();
					Bean_Result resultDTO = new Bean_Result();
					Bean_nowRecord nowDTO = new Bean_nowRecord();

					//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
					paraDTO.setCheckRenzokuSign(true);
//					paraDTO.setCheckRenzokuSign(false);
					//結論の出力方法
					resultDTO.setOffResultDay();
					resultDTO.setOffResultCode();
//					resultDTO.setOnResultDay();
//					resultDTO.setOnResultCode();
					resultDTO.setOnResultTotal();


					//勝敗条件
					paraDTO.setWinWariai(111.01);
					paraDTO.setLoseWariai(0.0099);
					paraDTO.setCheckKeepDay(100000);


					Analysis00_Common.Analysis_COMMON("technique","Technique04",methodList.get(i)[2],"technique","Technique04",methodList.get(p)[2],paraDTO,nowDTO,resultDTO);
				}
				System.out.println();
			}
		}

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}
	public static void testCase06(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOnResultDay();
			resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();


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

		//持ち株、ボーナス夏、ボーナス冬の設定
		paraDTO.setMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setWinterBonus();
		//前日終値、当日始値
			//当日の始値で買えていそう、当日の終値で売れていそう
		paraDTO.setTOZITU_START();

//		paraDTO.setZENZITU_END();

		paraDTO.setMotikabuDay();
		paraDTO.setOffSummerBonus();
		paraDTO.setOffWinterBonus();

		//勝敗条件
//		paraDTO.setWinWariai(1.01);
//		paraDTO.setLoseWariai(0.099);
		paraDTO.setCheckKeepDay(100000);

		long start = System.currentTimeMillis();
		S s = new S();
		s.getCon();

		Analysis00_Common.Analysis_COMMON("technique","Technique04","testMACD_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO);
		s.closeConection();

		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");


	}

	public static void testCase05(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		long start = System.currentTimeMillis();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO);
	}

	public static void testCase04(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
//		paraDTO.setCheckRenzokuSign(true);
		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//損切ライン
		paraDTO.setWinWariai(2.1);
		paraDTO.setLoseWariai(0.47);

		long start = System.currentTimeMillis();

		//手数料
		paraDTO.setTesuRYO(0.01);


//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_L","technique","Technique04","MACD_S",paraDTO,nowDTO,resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_S","technique","Technique04","MACD_L",paraDTO,nowDTO,resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_L","technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_S","technique","Technique04","MACD_L",paraDTO,nowDTO,resultDTO);
		S s = new S();
		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_S","technique","Technique04","MACD_L",paraDTO,nowDTO,resultDTO,"I306",s);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_L","technique","Technique04","MACD_S",paraDTO,nowDTO,resultDTO,"9994―T",s);

		Analysis00_Common.Analysis_COMMON("technique","Technique03","checkIDOHeikin_SandL_S","technique","Technique03","checkIDOHeikin_SandL_L",paraDTO,nowDTO,resultDTO);
//		resultDTO.getResultTotalResult("technique","Technique04","MACD_S","technique","Technique04","MACD_L",paraDTO);
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}

	public static void testCase03(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//何をみるか
		paraDTO.setCheckBori_checkBORI(10);
		//勝敗条件
		paraDTO.setWinWariai(1.1);
		paraDTO.setLoseWariai(0.9);

		long start = System.currentTimeMillis();
		Analysis00_Common.Analysis_COMMON("technique","Technique05","checkBori_L","technique","Technique00_Common","checkPrice_S",paraDTO,nowDTO,resultDTO);
		S s = new S();
		s.getCon();


//		Analysis00_Common.Analysis_COMMON("technique","Technique03","checkIDOHeikin_SandL_S","technique","Technique03","checkIDOHeikin_SandL_L",paraDTO,nowDTO,resultDTO,"I139",s);
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}


	public static void testCase02(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		//結論の出力方法
		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		//何をみるか
//		paraDTO.setCheckCate(ReCord.CODE_02_SATISTICS);

		long start = System.currentTimeMillis();
		Analysis00_Common.Analysis_COMMON("technique","Technique03","checkIDOHeikin_MandL_S","technique","Technique00_Common","checkIDOHeikin_MandL_L",paraDTO,nowDTO,resultDTO);
		S s = new S();
		s.getCon();


//		Analysis00_Common.Analysis_COMMON("technique","Technique03","checkIDOHeikin_SandL_S","technique","Technique03","checkIDOHeikin_SandL_L",paraDTO,nowDTO,resultDTO,"I139",s);
		s.closeConection();
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}

	public static void testCase01(){

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

		//結論の出力方法
//		resultDTO.setOnResultCode();
		resultDTO.setOnResultDay();
		resultDTO.setOnResultTotal();


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
		paraDTO.setWinWariai(1.5);
		paraDTO.setLoseWariai(0.40);
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
//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);

		System.out.println("【２日後／給料日】");
		paraDTO.setIntCount01(2);
		paraDTO.setMotikabuDay();
		paraDTO.setOffSummerBonus();
		paraDTO.setOffWinterBonus();
		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);

//		System.out.println("【当日／夏ボーナス】");
//		paraDTO.setIntCount01(0);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);
//
//		System.out.println("【２日後／冬ボーナス】");
//		paraDTO.setIntCount01(2);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setWinterBonus();
//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);
//
//		System.out.println("【当日／夏ボーナス】");
//		paraDTO.setIntCount01(0);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setSummerBonus();
//		paraDTO.setOffWinterBonus();
//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);
//
//		System.out.println("【２日後／冬ボーナス】");
//		paraDTO.setIntCount01(2);
//		paraDTO.setOffMotikabuDay();
//		paraDTO.setOffSummerBonus();
//		paraDTO.setWinterBonus();
//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO);

		S s = new S();
		s.getCon();

//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO,"2229―T",s);

		//
		s.closeConection();



		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");
	}


	//true:エントリー
		//false:exit
	public static int sagyoSpaceDoing(String methodName){
			try {
				//クラス名を指定。パッケージ名のクラス名
				Class cl = Class.forName( "analysis.SagyoSpace");

				try {
					// メソッドに引き渡すクラスの順番を定義

					// 引数ありのメソッドを取得する。methodNameがメソッド名
					Method m = cl.getMethod(methodName);

					// 引数をいれて実行
					try {
						Object result = m.invoke(cl.newInstance());

					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException
							| InstantiationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					System.out.println(methodName + "はありません");
					return Technique98_CONST.NO_METHOD;
				}
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			return Technique98_CONST.NO_RESULT;

		}


}
