package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import technique.CheckSign;
import technique.Technique98_CONST;
import bean.Bean_FinancialStatement;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;
import constant.TechCon;
import constant.logWriting;

public class SagyoSpace {


//	mysql> update 23_invest_sihyo_tbl_dd b left join 23_invest_sihyo_tbl_dd a on a.code = b.code set b.m
//			arket_cap_ppt_pre = a.market_cap_ppt where b.daytime = '2017-01-02' and a.daytime = '2017-01-01' ;

	public static void shokisettei(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO,boolean realcheckFLG){

		if (realcheckFLG){
			//このなか本番
			paraDTO.setRealTimeMode(true);

			//インヴェストテーブル使う(配当とかそういうこと)
			paraDTO.setCheckInvest(true);


			//財務諸表データとか使う
			paraDTO.setMonthYearDateFLG(true);
			paraDTO.setCheckParaDTOOption(true);
			//ここをfalseにすると財務諸表データ使わなくなる
			paraDTO.setCheckParaDTOOption(false);

		}else{
			//この中試験用
			paraDTO.setRealTimeMode(false);

			//インヴェストテーブル使う(配当とかそういうこと)
//			paraDTO.setCheckInvest(true);
			//財務諸表データとかBeanにいれるかどうかをきめる
			paraDTO.setMonthYearDateFLG(true);
			//財務諸表データとかBeanにいれるか使うかどうかを決める
			paraDTO.setCheckParaDTOOption(true);
			//ここをfalseにすると財務諸表データ使わなくなる
			paraDTO.setCheckParaDTOOption(false);

			//保有できず銘柄を表示するか否か。falseなら表示しない
			paraDTO.setKeepVisualFlg(true);
			paraDTO.setKeepVisualFlg(false);
		}

		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。
		paraDTO.setCheckRenzokuSign(true);
//		paraDTO.setCheckRenzokuSign(false);
		//結論の出力方法
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
//		resultDTO.setOnResultDay();
		resultDTO.setOnResultCode();
		resultDTO.setOnResultTotal();
		int i = 1000;
		paraDTO.setMinDeki(i);
		resultDTO.setShoritu(0.65);
//		resultDTO.setShoritu(0.05);
		resultDTO.setTotalGames(8);
//		resultDTO.setTotalGames(1);
		resultDTO.setTotalRatio(0.7);
//		resultDTO.setTotalRatio(0.05);
		//手数料
		paraDTO.setTesuRYO(0.015);
//		paraDTO.setTesuRYO(0.011);
//		paraDTO.setTesuRYO(0.03);
//		paraDTO.setTesuRYO(0);
		//統計データを使わない場合
		paraDTO.setStaticsFLG(false);
		//一回当たりエントリー金額（単位：万円）
		paraDTO.setEntryMoney(1.100);
		//エリートフラグ
		paraDTO.setOffEliteFLG();
		paraDTO.setOnEliteFLG();
//		paraDTO.setCheckCate(ReCord.CODE_01_STOCK);
		paraDTO.setMaxEntryTimes(30);
//		paraDTO.setMaxKeepDays(5);
//		System.out.println("【出来高"+ i + "】");
		//ドルコスト法
		paraDTO.setDollCostFLG(true);
		paraDTO.setRealEntryVolumeFLG(true);

		paraDTO.setMaxEntryClose(15000);
		paraDTO.setMaxEntryClose(15000000);
		//株のみ取り引きする
		paraDTO.setJustSTOCK(true);



	}

	public static void shokisettei_false(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){


		//買いサインが連続して出た時、連続して買うかどうかを判断。true:連続、false連続しない。

		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setCheckRenzokuSign(false);

	}




	public static void testCase89(){



		String replaceRecord = "132+456";
		System.out.println(replaceRecord);
		replaceRecord = replaceRecord.replaceAll("\"-\"","");
		replaceRecord = replaceRecord.replaceAll("\\+","");
		String testLetter = ",\"-\",";

//		replaceRecord = replaceRecord.replaceAll("\"-\"","\\\\N");
		System.out.println("\\N");
		System.out.println("\"-\"");
		System.out.println(testLetter);
//		testLetter = testLetter.replaceAll("\"-\"","");
		testLetter = testLetter.replaceAll("\"-\"","\\\\N");
		System.out.println(testLetter);
		System.out.println(replaceRecord);
	}


	public static void testCase80(){
		S s = new S();
		s.getCon();
		Bean_FinancialStatement nowDTO = new Bean_FinancialStatement ();
		String SQL = " select * from " + TBL_Name.FINANCIAL_MM_TBL
				+ " where  "
				+ " ( "
				+ COLUMN.CODENAME								 + " is not null and " //名称
				+ COLUMN.KESSAN_TERM_YYYY_MM_STRING			 + " is not null and " //決算期
				+ COLUMN.YEAR_KESSAN_TIME_YYYYMMDD				 + " is not null and " //決算発表日（本決算）
				+ COLUMN.URIAGE_DAKA_PPT						 + " is not null and " //売上高（百万円）
				+ COLUMN.EIGYO_PROF_PPT						 + " is not null and " //営業利益（百万円）
				+ COLUMN.KEIJO_PROF_PPT						 + " is not null and " //経常利益（百万円）
				+ COLUMN.BOTTOM_LINE_PPT						 + " is not null and " //当期利益（百万円）
				+ COLUMN.TOTAL_ASSET_PPT						 + " is not null and " //総資産（百万円）
				+ COLUMN.SELF_ASSET_PPT						 + " is not null and " //自己資本（百万円）
				+ COLUMN.SHIHONKIN_ASSET_PPT					 + " is not null and " //資本金（百万円）
				+ COLUMN.LOAN_PPT								 + " is not null and " //有利子負債（百万円）
				+ COLUMN.SELF_ASSET_WARIAI						 + " is not null and " //自己資本比率
				+ COLUMN.ROE									 + " is not null and " //ROE
				+ COLUMN.ROA									 + " is not null and " //ROA
				+ COLUMN.STOCK_NUM
				+ " ) "
				;
		SQL = " select * from " + TBL_Name.FINANCIAL_MM_TBL + " where code = '1773'";
//		SQL = " select * from 21_financialTBL_MM where code = '8685' ";
		System.out.println(SQL);

		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {

				try{System.out.println(s.rs2.getString(COLUMN.YEAR_KESSAN_TIME_YYYYMMDD));} catch (SQLException e) {System.out.println("aaaaaaa");}


////				nowDTO.setCode_01(s.rs2.getString(	  COLUMN.TOTAL_ASSET_PPT		));
//				System.out.println(nowDTO.getCode_01());
//
//				nowDTO.setTotal_asset_ppt(s.rs2.getInt(	  COLUMN.TOTAL_ASSET_PPT		));
//
//				if (! (s.rs2.getInt(COLUMN.TOTAL_ASSET_PPT)== 0) && (s.rs2.getString(COLUMN.TOTAL_ASSET_PPT) == null )){
//					nowDTO.setTotal_asset_ppt(s.rs2.getInt(	  COLUMN.TOTAL_ASSET_PPT		));
//				}
//
//				System.out.println(nowDTO.getTotal_asset_ppt());
//
//				if (nowDTO.getTotal_asset_ppt()==0){
//					System.out.println("aaaaaaaaaaaaaaaaa");
//				}
//				nowDTOList.add(	setNowRecord(code,cate,s.rs2,paraDTO)	);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

//		 select * from 21_financialTBL_MM
//		 null
//		 0.0
//		 aaaaaaaaaaaaaaaaa
		//→==0ならnullチェックするとかでいいかも
//		 実行にかかった時間は 35 ミリ秒です。

		s.closeConection();
	}


	public static void testCase9997(){
		Testsupport TS = new Testsupport();

		//v6.0で作ったCAPMを考慮したやつ
		//連続取引するエリートの全メソッドの一覧を作る
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);

		String startDD	=	"2008-01-03";
		String endDD		=	"2009-12-31";
		startDD	=	"2010-01-04";
		endDD		=	"2018-04-30";

		List<String[]> dayLists = new ArrayList<String[]>();
		List<String[]> methodListL = new ArrayList<String[]>();
		List<String[]> methodListS = new ArrayList<String[]>();
		String dayList[] = new String[2];
		String methodName[] = new String[2];
		String tec = "technique";

		dayList[0] =	"2010-01-04";
		dayList[1] =	"2018-04-30";
		dayLists.add(dayList.clone());

//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_S_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_S_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_S_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_L_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_L_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_L_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_L_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_L_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_L_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_S_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_S_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_S_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_L_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_L_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_L_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_S_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_S_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Right_S_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_L_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_L_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_L_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_S_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_S_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_AVE_Left_S_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_1_S";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_2_S";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_3_S";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_1_L";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_2_L";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_aveCheck_3_L";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_1";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_2";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_3";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_4";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_5";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_6";
//		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_7";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_8";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_9";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_10";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_11";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_12";
		methodListL.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_13";
		methodListL.add(methodName.clone());

//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_14";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_15";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique14";
//		methodName[1] = "CAPM_MULTI_16";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_L_OVER0";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "idoHeikinTest_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique08";
//		methodName[1] = "MACD_IDOHEIKIN_L";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique08";
//		methodName[1] = "MACD_OR_IDOHEIKIN_S";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique08";
//		methodName[1] = "MACD_0_OR_IDOHEIKIN_S";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_S_OVER0";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique04";
//		methodName[1] = "MACD_M_S";
//		methodListL.add(methodName.clone());
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_1_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_2_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_3_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_4_L";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_1_S";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_2_S";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_3_S";
//		methodListL.add(methodName.clone());
//
//
//		methodName[0] = "Technique06";
//		methodName[1] = "IDO_HEKIN_4_S";
//		methodListL.add(methodName.clone());
//
//


		methodName[0] = "Technique14";
		methodName[1] = "CAPM_S_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_S_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_S_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_L_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_L_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_L_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_L_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_L_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_L_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_S_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_S_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_S_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_L_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_L_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_L_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_S_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_S_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Right_S_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_L_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_L_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_L_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_S_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_S_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_AVE_Left_S_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_1_S";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_2_S";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_3_S";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_1_L";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_2_L";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_aveCheck_3_L";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_1";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_2";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_3";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_4";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_5";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_6";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_7";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_8";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_9";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_10";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_11";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_12";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_13";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_14";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_15";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique14";
		methodName[1] = "CAPM_MULTI_16";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_L_OVER0";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "idoHeikinTest_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique08";
		methodName[1] = "MACD_IDOHEIKIN_L";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique08";
		methodName[1] = "MACD_OR_IDOHEIKIN_S";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique08";
		methodName[1] = "MACD_0_OR_IDOHEIKIN_S";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_S_OVER0";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_S";
		methodListS.add(methodName.clone());

		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_1_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_2_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_3_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_4_L";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_1_S";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_2_S";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_3_S";
		methodListS.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_4_S";
		methodListS.add(methodName.clone());

		for (String[] a: dayLists){
			startDD		=	a[0];
			endDD		=	a[1];
			for (int b = 0 ;b < methodListL.size() ; b++){
				String L_CLASS = methodListL.get(b)[0];
				String L_METHOD = methodListL.get(b)[1];
				for (int c = 0 ;c < methodListS.size() ; c++){
					String S_CLASS = methodListS.get(c)[0];
					String S_METHOD = methodListS.get(c)[1];
					//				System.out.println("");

					paraDTO = new Bean_Parameta();
					resultDTO = new Bean_Result();
					nowDTO = new Bean_nowRecord();
					shokisettei(paraDTO, nowDTO, resultDTO,false);
					//				paraDTO.setCheckInvest(true);
					paraDTO.setTesuRYO(0.015);
					paraDTO.setMaxEntryTimes(30);
					paraDTO.setCheckParaDTOOption(true);
					paraDTO.setCheckParaDTOOption(false);
					resultDTO.setTotalGames(6);
					resultDTO.setTotalGames(10);
					paraDTO.setKeepVisualFlg(false);
					paraDTO.setOnEliteFLG();
					paraDTO.setOffEliteFLG();
					if (!(L_METHOD.equals(S_METHOD))){
						//					System.out.println(L_METHOD + ":" + S_METHOD );
						Analysis00_Common.Analysis_COMMON(tec,L_CLASS,L_METHOD,tec,S_CLASS,S_METHOD,paraDTO,nowDTO,resultDTO,startDD,endDD);
						TS.longTermTestSupporter();
					}
				}

			}
		}
//		TS.renzokuAnalysis(methodListL, methodListS, dayLists);
//		longTermTestSupporter();
	}

	public static void testCase9998(){
		//v5.0で作った割安株とか配当とかを考慮したやつ
		//連続取引するエリートの全メソッドの一覧を作る
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2015-01-03";
		String endDD		=	"2017-12-31";
		startDD	=	"2018-03-26";
		endDD		=	"2018-05-30";
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setCheckInvest(true);
		String tec = "technique";
//		Analysis00_Common.Analysis_COMMON(tec,"Technique12","diviteCheck_1_L",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

		List<String[]> methodList_L = new ArrayList<String[]>();
		String methodName[] = new String[2];
		methodName[0] = "Technique12";
		methodName[1] = "diviteCheck_1_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "diviteCheck_2_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "PBRCheck_1_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "PBRCheck_2_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "PBRandDiviteCheck_1_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "PBRandDiviteCheck_2_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique12";
		methodName[1] = "PBRandDiviteCheck_3_L";
		methodList_L.add(methodName.clone());


		List<String[]> methodList_S = new ArrayList<String[]>();
		String methodNameS[] = new String[2];
		methodNameS[0] = "Technique12";
		methodNameS[1] = "averageCheck_1_S";
		methodList_S.add(methodNameS.clone());

		methodNameS[0] = "Technique12";
		methodNameS[1] = "averageCheck_2_S";
		methodList_S.add(methodNameS.clone());

		methodNameS[0] = "Technique12";
		methodNameS[1] = "averageCheck_3_S";
		methodList_S.add(methodNameS.clone());



		for (int b = 0 ;b < methodList_L.size() ; b++){
			String L_CLASS = methodList_L.get(b)[0];
			String L_METHOD = methodList_L.get(b)[1];
			for (int c = 0 ;c < methodList_S.size() ; c++){
				String S_CLASS = methodList_S.get(c)[0];
				String S_METHOD = methodList_S.get(c)[1];
				System.out.println("");

				paraDTO = new Bean_Parameta();
				resultDTO = new Bean_Result();
				nowDTO = new Bean_nowRecord();
				shokisettei(paraDTO, nowDTO, resultDTO,false);
				paraDTO.setCheckInvest(true);
				paraDTO.setTesuRYO(0.0);
				paraDTO.setMaxEntryTimes(30);
				paraDTO.setCheckParaDTOOption(true);
				paraDTO.setCheckParaDTOOption(false);
				paraDTO.setKeepVisualFlg(true);
				resultDTO.setTotalGames(1);
				paraDTO.setOnEliteFLG();
//				paraDTO.setOffEliteFLG();
				if (!(L_METHOD.equals(S_METHOD))){
					Analysis00_Common.Analysis_COMMON(tec,L_CLASS,L_METHOD,tec,S_CLASS,S_METHOD,paraDTO,nowDTO,resultDTO,startDD,endDD);
				}
			}
		}

	}



	public static void testCase9999(){
		//基本８手法
		//連続取引するエリートの全メソッドの一覧を作る
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2007-01-03";
		String endDD		=	"2008-12-31";
		startDD	=	"2018-03-26";
		endDD		=	"2018-05-31";
//		startDD	=	"2017-12-04";
//		endDD		=	"2016-12-31";
		//一部はここからスタート
//		startDD	=	"2017-07-18";

		List<String[]> dayLists = new ArrayList<String[]>();
		String dayList[] = new String[2];
//		dayList[0] =	"2016-10-01";
//		dayList[1] =	"2016-12-31";
//		dayLists.add(dayList.clone());
//		dayList[0] =	startDD;
//		dayList[1] =	endDD;
//		dayLists.add(dayList.clone());

		dayList[0] = "2018-03-26";
		dayList[1] =	"2018-05-31";
		dayLists.add(dayList.clone());


//		dayList[0] = "2007-01-01";
//		dayList[1] = "2007-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2008-01-01";
//		dayList[1] = "2008-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2009-01-01";
//		dayList[1] = "2009-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2010-01-01";
//		dayList[1] = "2010-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2011-01-01";
//		dayList[1] = "2011-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2012-01-01";
//		dayList[1] = "2012-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2013-01-01";
//		dayList[1] = "2013-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2014-01-01";
//		dayList[1] = "2014-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2015-01-01";
//		dayList[1] = "2015-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2016-01-01";
//		dayList[1] = "2016-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2017-01-01";
//		dayList[1] = "2017-12-30";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2018-01-01";
//		dayList[1] = "2018-04-30";
//		dayLists.add(dayList.clone());




		String tec = "technique";


		for (String[] a: dayLists){
			startDD		=	a[0];
			endDD		=	a[1];

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();
			commonAP.writeInLog("-----" + a[0] + "_" + a[1]+ "-----",logWriting.CODE_DOLLCOTST_RESULT_LIST_LOG_FLG);
			commonAP.writeInLog("-----" + a[0] + "_" + a[1]+ "-----",logWriting.CODE_RESULT_LIST_LOG_FLG);

//////			paraDTO.setMaxLoss(3);
//////			resultDTO.setMaxInterValTime(	30	);
//////			resultDTO.setOnResultDay();
			Analysis00_Common.Analysis_COMMON(tec,"Technique04","MACD_M_L_OVER0",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(32);
//			paraDTO.setMaxKeepDays(21);
			Analysis00_Common.Analysis_COMMON(tec,"Technique04","MACD_M_L",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(35);
//			paraDTO.setMaxKeepDays(17);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_1_S",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(30);
//			paraDTO.setMaxKeepDays(19);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_1_S",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(28);
//			paraDTO.setMaxKeepDays(22);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_3_S",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(28);
//			paraDTO.setMaxKeepDays(16);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_3_S",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(33);
//			paraDTO.setMaxKeepDays(32);
			Analysis00_Common.Analysis_COMMON(tec,"Technique08","MACD_IDOHEIKIN_L",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(20);
//			paraDTO.setMaxKeepDays(19);
			Analysis00_Common.Analysis_COMMON(tec,"Technique08","MACD_IDOHEIKIN_L",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


		}

	}


	public static void testCase10000(){
		//基本８手法
		//連続取引するエリートの全メソッドの一覧を作る
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2018-04-02";
		String endDD		=	"2018-04-27";
		startDD = "2018-03-22";
		endDD = "2018-05-11";
//		startDD	=	"2008-01-01";
//		endDD		=	"2009-12-31";
//		startDD	=	"2010-01-01";
//		endDD		=	"2015-12-31";

		//一部はここからスタート
//		startDD	=	"2017-07-18";

		List<String[]> dayLists = new ArrayList<String[]>();
		String dayList[] = new String[2];
//		dayList[0] =	"2016-10-01";
//		dayList[1] =	"2016-12-31";
//		dayLists.add(dayList.clone());
		dayList[0] =	startDD;
		dayList[1] =	endDD;
		dayLists.add(dayList.clone());


		String tec = "technique";


		for (String[] a: dayLists){
			startDD		=	a[0];
			endDD		=	a[1];

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
			paraDTO.setOffEliteFLG();
			paraDTO.setOnEliteFLG();
			paraDTO.setTesuRYO(0.00);
			paraDTO.setCheckParaDTOOption(true);
			commonAP.writeInLog("-----" + a[0] + "_" + a[1]+ "-----",logWriting.CODE_DOLLCOTST_RESULT_LIST_LOG_FLG);
			commonAP.writeInLog("-----" + a[0] + "_" + a[1]+ "-----",logWriting.CODE_RESULT_LIST_LOG_FLG);
//			resultDTO.setTotalRatio(0.05);
//			resultDTO.setTotalGames(1);
//			resultDTO.setShoritu(0.05);
//////			paraDTO.setMaxLoss(3);
//////			resultDTO.setMaxInterValTime(	30	);
//////			resultDTO.setOnResultDay();
			Analysis00_Common.Analysis_COMMON(tec,"Technique04","MACD_M_S_OVER0_testbefore",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);
//			Analysis00_Common.Analysis_COMMON(tec,"Technique14","CAPM_L_2",tec,"Technique14","CAPM_S_2",paraDTO,nowDTO,resultDTO,startDD,endDD);

		}

	}

	public static void testCase96(){
		//連続取引するエリートの全メソッドの一覧を作る
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2012-01-03";
		String endDD		=	"2016-12-31";

		startDD	=	"2017-04-25";
		endDD		=	"2017-05-31";

		List<String[]> dayLists = new ArrayList<String[]>();
		String dayList[] = new String[2];
//		dayList[0] =	"2017-04-25";
//		dayList[1] =	"2017-05-31";
//		dayLists.add(dayList.clone());
		dayList[0] =	"2017-08-01";
		dayList[1] =	"2017-09-29";
		dayLists.add(dayList.clone());
//		dayList[0] = "2007-01-01";
//		dayList[1] = "2007-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2008-01-01";
//		dayList[1] = "2008-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2009-01-01";
//		dayList[1] = "2009-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2010-01-01";
//		dayList[1] = "2010-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2011-01-01";
//		dayList[1] = "2011-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2012-01-01";
//		dayList[1] = "2012-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2013-01-01";
//		dayList[1] = "2013-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2014-01-01";
//		dayList[1] = "2014-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2015-01-01";
//		dayList[1] = "2015-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2016-01-01";
//		dayList[1] = "2016-12-31";
//		dayLists.add(dayList.clone());
//
//		dayList[0] = "2017-01-01";
//		dayList[1] = "2017-03-31";
//		dayLists.add(dayList.clone());

		String tec = "technique";


		for (String[] a: dayLists){
			startDD		=	a[0];
			endDD		=	a[1];

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();


////			paraDTO.setMaxLoss(3);
////			resultDTO.setMaxInterValTime(	30	);
////			resultDTO.setOnResultDay();
			Analysis00_Common.Analysis_COMMON(tec,"Technique04","MACD_M_L_OVER0",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(32);
//			paraDTO.setMaxKeepDays(21);
			Analysis00_Common.Analysis_COMMON(tec,"Technique04","MACD_M_L",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(35);
//			paraDTO.setMaxKeepDays(17);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_1_S",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(30);
//			paraDTO.setMaxKeepDays(19);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_1_S",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(28);
//			paraDTO.setMaxKeepDays(22);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_3_S",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(28);
//			paraDTO.setMaxKeepDays(16);
			Analysis00_Common.Analysis_COMMON(tec,"Technique06","IDO_HEKIN_3_S",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(33);
//			paraDTO.setMaxKeepDays(32);
			Analysis00_Common.Analysis_COMMON(tec,"Technique08","MACD_IDOHEIKIN_L",tec,"Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

			paraDTO = new Bean_Parameta();
			resultDTO = new Bean_Result();
			nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);
//			paraDTO.setOnEliteFLG();

//			paraDTO.setMaxEntryTimes(20);
//			paraDTO.setMaxKeepDays(19);
			Analysis00_Common.Analysis_COMMON(tec,"Technique08","MACD_IDOHEIKIN_L",tec,"Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


		}

		//
//		List<String[]> methodList_L = new ArrayList<String[]>();
//		String methodName[] = new String[2];
//		methodName[0] = "Technique11";
//		methodName[1] = "DEKI_1_L";
//		methodList_L.add(methodName.clone());
//
//		List<String[]> methodList_S = new ArrayList<String[]>();
//		String methodNameS[] = new String[2];
//		methodNameS[0] = "Technique11";
//
//		methodNameS[1] = "DEKI_1_L";
//		methodList_S.add(methodNameS.clone());
//
//
//
//		for (int b = 0 ;b < methodList_L.size() ; b++){
//			String L_CLASS = methodList_L.get(b)[0];
//			String L_METHOD = methodList_L.get(b)[1];
//			for (int c = 0 ;c < methodList_S.size() ; c++){
//				String S_CLASS = methodList_L.get(c)[0];
//				String S_METHOD = methodList_L.get(c)[1];
//				System.out.println("");
//
//				paraDTO = new Bean_Parameta();
//				resultDTO = new Bean_Result();
//				nowDTO = new Bean_nowRecord();
//				shokisettei(paraDTO, nowDTO, resultDTO,false);
//				paraDTO.setEtfFLG(false);
//				paraDTO.setCheckRenzokuSign(true);
//				paraDTO.setTesuRYO(0.022);
//				//					paraDTO.setMaxEntryTimes(15);
//				//					paraDTO.setMaxKeepDays(15);
//				resultDTO.setOnResultCode();
//				resultDTO.setShoritu(0.85);
//				resultDTO.setTotalGames(20);
////				resultDTO.setTotalRatio(0.65);
//				if (!(L_METHOD.equals(S_METHOD))){
//					Analysis00_Common.Analysis_COMMON(tec,L_CLASS,L_METHOD,tec,S_CLASS,S_METHOD,paraDTO,nowDTO,resultDTO,startDD,endDD);
//				}
//			}
//		}



	}

	public static void testCase97(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2016-10-03";
		String endDD		=	"2016-10-30";



//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		resultDTO.setShoritu(0.05);
//		resultDTO.setTotalGames(1);
//		paraDTO.setTesuRYO(0.0);
//		System.out.println("");
//		Analysis00_Common.Analysis_COMMON("technique","Techinique00_TEST","MACD_M_L_OVER0","technique","Techinique00_TEST","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);



		startDD	=	"2007-10-03";
		endDD		=	"2016-12-30";
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		resultDTO.setShoritu(0.00);
		resultDTO.setTotalGames(0);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
		System.out.println("");
//		resultDTO.setTotalRatio(0.75);
//		paraDTO.setCheckRenzokuSign(false);
//		paraDTO.setMaxKeepDays(3);
		paraDTO.setMaxEntryTimes(1);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		resultDTO.setShoritu(0.00);
		resultDTO.setTotalGames(0);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		resultDTO.setOffResultDay();
		resultDTO.setOffResultCode();
		System.out.println("");
//		resultDTO.setTotalRatio(0.75);
		paraDTO.setCheckRenzokuSign(false);
//		paraDTO.setMaxKeepDays(3);
//		paraDTO.setMaxEntryTimes(1);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();

	}

	public static void testCase999(){
		List<String> dayList = new ArrayList<String>();
		dayList.add("2016-10-03");
		dayList.add("2016-10-04");
		dayList.add("2016-10-05");
		dayList.add("2016-10-06");
		dayList.add("2016-10-07");
		dayList.add("2016-10-11");
		dayList.add("2016-10-12");
		dayList.add("2016-10-13");
		dayList.add("2016-10-14");
		dayList.add("2016-10-17");
		dayList.add("2016-10-18");
		dayList.add("2016-10-19");
		dayList.add("2016-10-20");
		dayList.add("2016-10-21");
		dayList.add("2016-10-24");
		dayList.add("2016-10-25");
		dayList.add("2016-10-26");
		dayList.add("2016-10-27");


//		1
//		1
//		1
//		2
//		1
//		0
//		-1
//		-2
		System.out.println("2016-10-27".compareTo("2015-10-28"));
		System.out.println("2016-10-27".compareTo("2015-10-27"));
		System.out.println("2016-10-27".compareTo("2016-09-25"));
		System.out.println("2016-10-27".compareTo("2016-10-25"));
		System.out.println("2016-10-27".compareTo("2016-10-26"));
		System.out.println("2016-10-27".compareTo("2016-10-27"));
		System.out.println("2016-10-27".compareTo("2016-10-28"));
		System.out.println("2016-10-27".compareTo("2016-10-29"));

		int i = 0;
		int setAdress = i;
		String nowDay = "2016-10-11";
		while (nowDay.compareTo(dayList.get(i)) >= 0) {
			System.out.println(dayList.get(i));
			setAdress = i;
			i++;
		}
		System.out.println("a:"+dayList.get(setAdress));
	}

	public static void testCase98(){

		List<String> dayList = new ArrayList<String>();
//		dayList.add("2016-10-03");
//		dayList.add("2016-10-04");
//		dayList.add("2016-10-05");
//		dayList.add("2016-10-06");
//		dayList.add("2016-10-07");
//		dayList.add("2016-10-11");
//		dayList.add("2016-10-12");
//		dayList.add("2016-10-13");
//		dayList.add("2016-10-14");
//		dayList.add("2016-10-17");
//		dayList.add("2016-10-18");
//		dayList.add("2016-10-19");
//		dayList.add("2016-10-20");
//		dayList.add("2016-10-21");
//		dayList.add("2016-10-24");
//		dayList.add("2016-10-25");
//		dayList.add("2016-10-26");
//		dayList.add("2016-10-27");
//		dayList.add("2016-10-28");
//		dayList.add("2016-10-31");
//		dayList.add("2016-11-01");
//		dayList.add("2016-11-02");
//		dayList.add("2016-11-04");
//		dayList.add("2016-11-07");
//		dayList.add("2016-11-08");
//		dayList.add("2016-11-09");
//		dayList.add("2016-11-10");
//		dayList.add("2016-11-11");
//		dayList.add("2016-11-14");
//		dayList.add("2016-11-15");
//		dayList.add("2016-11-16");
//		dayList.add("2016-11-17");
//		dayList.add("2016-11-18");
//		dayList.add("2016-11-21");
//		dayList.add("2016-11-22");
//		dayList.add("2016-11-24");
//		dayList.add("2016-11-25");
//		dayList.add("2016-11-28");
//		dayList.add("2016-11-29");
//		dayList.add("2016-11-30");
//		dayList.add("2016-12-01");
//		dayList.add("2016-12-02");
//		dayList.add("2016-12-05");
//		dayList.add("2016-12-06");
//		dayList.add("2016-12-07");
//		dayList.add("2016-12-08");
//		dayList.add("2016-12-09");
//		dayList.add("2016-12-12");
//		dayList.add("2016-12-13");
//		dayList.add("2016-12-14");
//		dayList.add("2016-12-15");
//		dayList.add("2016-12-16");
//		dayList.add("2016-12-19");
//		dayList.add("2016-12-20");
//		dayList.add("2016-12-21");
//		dayList.add("2016-12-22");
//		dayList.add("2016-12-26");
//		dayList.add("2016-12-27");
//		dayList.add("2016-12-28");
//		dayList.add("2016-12-29");
//		dayList.add("2016-12-30");


//		dayList.add("2017-07-03");
//		dayList.add("2017-07-04");
//		dayList.add("2017-07-05");
//		dayList.add("2017-07-06");
//		dayList.add("2017-07-07");
//		dayList.add("2017-07-10");
//		dayList.add("2017-07-11");
//		dayList.add("2017-07-12");
//		dayList.add("2017-07-13");
//		dayList.add("2017-07-14");
//		dayList.add("2017-07-18");
//		dayList.add("2017-07-19");
//		dayList.add("2017-07-20");
//		dayList.add("2017-07-21");
//		dayList.add("2017-07-24");
//		dayList.add("2017-07-25");
//		dayList.add("2017-07-26");
//		dayList.add("2017-07-27");
//		dayList.add("2017-07-28");
//		dayList.add("2017-07-31");
//		dayList.add("2017-08-01");
//		dayList.add("2017-08-02");
//		dayList.add("2017-08-03");
//		dayList.add("2017-08-04");
//		dayList.add("2017-08-07");
//		dayList.add("2017-08-08");
//		dayList.add("2017-08-09");
//		dayList.add("2017-08-10");
//		dayList.add("2017-08-14");
//		dayList.add("2017-08-15");
//		dayList.add("2017-08-16");
//		dayList.add("2017-08-17");
//		dayList.add("2017-08-18");
//		dayList.add("2017-08-21");
//		dayList.add("2017-08-22");
//		dayList.add("2017-08-23");
//		dayList.add("2017-08-24");
//		dayList.add("2017-08-25");
//		dayList.add("2017-08-28");
//		dayList.add("2017-08-29");
//		dayList.add("2017-08-30");
//		dayList.add("2017-08-31");
		dayList.add("2017-09-01");
		dayList.add("2017-09-04");
		dayList.add("2017-09-05");
		dayList.add("2017-09-06");
		dayList.add("2017-09-07");
		dayList.add("2017-09-08");
		dayList.add("2017-09-11");
		dayList.add("2017-09-12");
		dayList.add("2017-09-13");
		dayList.add("2017-09-14");
		dayList.add("2017-09-15");
		dayList.add("2017-09-19");
		dayList.add("2017-09-20");
		dayList.add("2017-09-21");
		dayList.add("2017-09-22");


		for (String TODAY:dayList){
			Bean_Parameta paraDTO = new Bean_Parameta();
			Bean_Result resultDTO = new Bean_Result();
			Bean_nowRecord nowDTO = new Bean_nowRecord();
			shokisettei(paraDTO, nowDTO, resultDTO,false);

			CheckSign.dealLastOrder(TODAY,paraDTO);

			System.out.println(TODAY);
			S s = new S();
			s.getCon();

			ArrayList<String[]> STOCKList = new ArrayList<String[]>();
			ArrayList<String[]> SATISTICSList = new ArrayList<String[]>();
			ArrayList<String[]> INDEXList = new ArrayList<String[]>();
			ArrayList<String[]> ETFNameList = new ArrayList<String[]>();

			ArrayList<String[]> keepStockList = new ArrayList<String[]>();
			//全銘柄をリストに入れる

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


//			CheckSign.CHECKTODAY(1,"DD","technique","Techinique00_TEST","MACD_M_L_OVER0","technique","Techinique00_TEST","MACD_M_S_OVER0",STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			int sleepTime = 7000;

			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC04, TechCon.METH_MACD_M_L_OVER0,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC04, TechCon.METH_MACD_M_L,			TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_1_S,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_1_S,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC08, TechCon.METH_MACD_IDOHEIKIN_L,	TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,	STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
			CheckSign.CHECKTODAY(1,"DD", TechCon.PAC01 ,TechCon.TEC08, TechCon.METH_MACD_IDOHEIKIN_L,	TechCon.PAC01,TechCon.TEC06,TechCon.METH_IDO_HEKIN_2_L,		STOCKList,SATISTICSList,INDEXList,ETFNameList,keepStockList,TODAY);
			try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}

			s.resetConnection();
			CheckSign.afterCheck(TODAY,s);
			STOCKList = new ArrayList<String[]>();
			SATISTICSList = new ArrayList<String[]>();
			INDEXList = new ArrayList<String[]>();
			ETFNameList = new ArrayList<String[]>();
			keepStockList = new ArrayList<String[]>();
		}

//		testCase97();
	}



	public static void testCase30(){

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();

		String startDD	=	"2007-01-23";
		String endDD		=	"2017-01-27";
//		String startDD	=	"2007-06-30";
//		String endDD		=	"2009-07-01";

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(27);
//		paraDTO.setMaxKeepDays(59);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(65);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(45);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(24);
		paraDTO.setMaxKeepDays(42);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(58);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);


//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique06","IDO_HEKIN_4_L",paraDTO,nowDTO,resultDTO,startDD,endDD);


//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setOnEliteFLG();
//		paraDTO.setMaxEntryTimes(5);
//		paraDTO.setMaxKeepDays(10);
//		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(27);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(65);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(30);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(24);
		paraDTO.setMaxKeepDays(40);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_1_S","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(25);
		paraDTO.setMaxKeepDays(54);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(28);
		paraDTO.setMaxKeepDays(60);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,startDD,endDD);

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setOnEliteFLG();
		paraDTO.setMaxEntryTimes(30);
		paraDTO.setMaxKeepDays(16);
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique06","IDO_HEKIN_2_L",paraDTO,nowDTO,resultDTO,startDD,endDD);

	}

	public static void testCase33(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		String startDD	=	"2015-01-01";
		String endDD		=	"2017-12-31";

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setTesuRYO(0.012);
//		paraDTO.setOnEliteFLG();
//		resultDTO.setOnResultDay();
//		resultDTO.setOnResultCode();
//		resultDTO.setOnResultTotal();
//		resultDTO.setShoritu(0.71);
//		resultDTO.setTotalGames(10);
		System.out.println("");
		Analysis00_Common.Analysis_COMMON(TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,paraDTO,nowDTO,resultDTO,startDD,endDD);

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setTesuRYO(0.012);
//		paraDTO.setOnEliteFLG();
//		resultDTO.setOnResultDay();
//		resultDTO.setOnResultCode();
//		resultDTO.setOnResultTotal();
//		resultDTO.setShoritu(0.01);
//		resultDTO.setTotalGames(1);
//		System.out.println("");
//		Analysis00_Common.Analysis_COMMON(TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,paraDTO,nowDTO,resultDTO,startDD,endDD);


	}

	public static void testCase29(){


		long start = System.currentTimeMillis();

		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		String startDD	=	"2017-01-27";
		String endDD		=	"2017-01-30";
//		startDD	=	"2017-01-16";
//		endDD		=	"2017-01-20";
		String L_CLASS = "";
		String L_METHOD = "";
//		startDD	=	"2016-10-26";
//		endDD		=	"2016-12-28";
		List<String[]> methodList_L = new ArrayList<String[]>();


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		System.out.println("");
		resultDTO.setOnResultDay();
		Analysis00_Common.Analysis_COMMON( TechCon.PAC01 ,TechCon.TEC04, TechCon.METH_MACD_M_L_OVER0,TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,paraDTO,nowDTO,resultDTO,startDD,endDD);

		startDD	=	"2017-01-23";
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setTesuRYO(0.0);
		paraDTO.setOnEliteFLG();
		System.out.println("");
		resultDTO.setOnResultDay();

		Analysis00_Common.Analysis_COMMON(TechCon.PAC01 ,TechCon.TEC06, TechCon.METH_IDO_HEKIN_3_S,TechCon.PAC01,TechCon.TEC04,TechCon.METH_MACD_M_S_OVER0,paraDTO,nowDTO,resultDTO,startDD,endDD);
//		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_3_S","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,startDD,endDD);


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
					shokisettei(paraDTO, nowDTO, resultDTO,false);
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

		shokisettei(paraDTO, nowDTO, resultDTO,false);
		resultDTO.setOnResultDay();
		S s = new S();
		s.getCon();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","IDO_HEKIN_4_S","technique","Technique06","IDO_HEKIN_1_L",paraDTO,nowDTO,resultDTO,"1345_T","2016-01-01","2016-10-31",s);

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
		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_L_OVER0";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "idoHeikinTest_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique08";
		methodName[1] = "MACD_IDOHEIKIN_L";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique08";
		methodName[1] = "MACD_OR_IDOHEIKIN_S";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique08";
		methodName[1] = "MACD_0_OR_IDOHEIKIN_S";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_S_OVER0";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique04";
		methodName[1] = "MACD_M_S";
		methodList_L.add(methodName.clone());

		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_1_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_2_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_3_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_4_L";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_1_S";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_2_S";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_3_S";
		methodList_L.add(methodName.clone());


		methodName[0] = "Technique06";
		methodName[1] = "IDO_HEKIN_4_S";
		methodList_L.add(methodName.clone());



		List<String[]> methodList_S = new ArrayList<String[]>();
		String methodNameS[] = new String[2];
		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_L_OVER0";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique06";
		methodNameS[1] = "idoHeikinTest_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_L";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_IDOHEIKIN_L";
		methodList_S.add(methodNameS.clone());

		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_OR_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique08";
		methodNameS[1] = "MACD_0_OR_IDOHEIKIN_S";
		methodList_S.add(methodNameS.clone());


		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_S_OVER0";
		methodList_S.add(methodNameS.clone());

		methodNameS[0] = "Technique04";
		methodNameS[1] = "MACD_M_S";
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



		for (int b = 0 ;b < methodList_L.size() ; b++){
			L_CLASS = methodList_L.get(b)[0];
			L_METHOD = methodList_L.get(b)[1];



			for (int c = 0 ;c < methodList_S.size() ; c++){
				for (int a = 0 ;a < checkDAYS.size() ; a++){
					System.out.println("");
					System.out.println("--------" + checkDAYS.get(a)[2] + "--------");
					startDD	=	checkDAYS.get(a)[0];
					endDD		=	checkDAYS.get(a)[1];

					System.out.println("");

					paraDTO = new Bean_Parameta();
					resultDTO = new Bean_Result();
					nowDTO = new Bean_nowRecord();
					shokisettei(paraDTO, nowDTO, resultDTO,false);
					paraDTO.setEtfFLG(false);
					paraDTO.setCheckRenzokuSign(false);
//					resultDTO.setTotalGames(20);
					paraDTO.setTesuRYO(0.022);
					//					paraDTO.setMaxEntryTimes(15);
					//					paraDTO.setMaxKeepDays(15);
					resultDTO.setOnResultCode();
					resultDTO.setShoritu(0.85);
					resultDTO.setTotalGames(20);
//					resultDTO.setTotalRatio(0.65);

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
						shokisettei(paraDTO, nowDTO, resultDTO,false);
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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		S s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(5);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		paraDTO.setIntCount01(10);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(15);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-01-01","2016-10-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2016-01-01","2016-10-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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

		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","testL","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//
//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
//		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"5721_T","2009-07-01","2013-08-01",s);

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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		S s = new S();
		s.getCon();
//		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");



		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(20);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(5);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique06","idoHeikinTest_L","technique","Technique06","idoHeikinTest_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(10);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		paraDTO.setIntCount01(0);
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(0);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		paraDTO.setIntCount01(5);
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L_ENTRY","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		S s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-01-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","testL","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");



		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2016-05-01","2016-08-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);

		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		System.out.println("【2007-06-30、2009-07-01】");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");




		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		s = new S();
		s.getCon();
		paraDTO.setObTerm(commonAP.countDay("2007-06-30","2009-07-01", s));
		s.closeConection();
		Analysis00_Common.Analysis_COMMON("technique","Technique08","MACD_IDOHEIKIN_L","technique","Technique08","MACD_IDOHEIKIN_S",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");




		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);


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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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

		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_ENTRY","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_BORIBAN","technique","Technique04","MACD_M_S_OVER0_BORIBAN",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		System.out.println("");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setIntCount01(20);
		shokisettei(paraDTO, nowDTO, resultDTO,false);

		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_ENTRY","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setCheckRenzokuSign(false);
//		S s = new S();
//		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"1587_T","2016-05-01","2016-08-01",s);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");
//		s.closeConection();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		paraDTO.setIntCount01(20);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_ENTRY","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
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

		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_BORIBAN","technique","Technique04","MACD_M_S_OVER0_BORIBAN",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
//		System.out.println("");
		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);

		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");

//		shokisettei(paraDTO, nowDTO, resultDTO,false);
//		paraDTO.setCheckRenzokuSign(false);
//		S s = new S();
//		s.getCon();
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"1587_T","2016-05-01","2016-08-01",s);
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0","technique","Technique04","MACD_M_S_OVER0",paraDTO,nowDTO,resultDTO,"2016-05-01","2016-08-01");
//		s.closeConection();

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
		long stop = System.currentTimeMillis();
	    System.out.println("実行にかかった時間は " + (stop - start) + "ﾐﾘ秒です。");

	}


	public static void testCase14(){
		Bean_Parameta paraDTO = new Bean_Parameta();
		Bean_Result resultDTO = new Bean_Result();
		Bean_nowRecord nowDTO = new Bean_nowRecord();


		long start = System.currentTimeMillis();

		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.07);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.08);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.09);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.10);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.11);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.12);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");
		System.out.println("");

		paraDTO = new Bean_Parameta();
		resultDTO = new Bean_Result();
		nowDTO = new Bean_nowRecord();
		paraDTO.setDoubleCount(-0.13);
		shokisettei(paraDTO, nowDTO, resultDTO,false);
		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_OVER0_KYURAKU","technique","Technique04","MACD_M_S_OVER0_KYURAKU",paraDTO,nowDTO,resultDTO,"2007-06-30","2009-07-01");

//		paraDTO = new Bean_Parameta();
//		resultDTO = new Bean_Result();
//		nowDTO = new Bean_nowRecord();
//		shokisettei(paraDTO, nowDTO, resultDTO,false);
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
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1629_T",s);
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

//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1629_T",s);

//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L_beforeDay","technique","Technique04","MACD_M_S_14_beforeDay",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-01-01","2016-08-01");


		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"2007-08-01","2009-07-31");
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_M_L","technique","Technique04","MACD_M_S_14",paraDTO,nowDTO,resultDTO,"1310_T",s);




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
//		Analysis00_Common.Analysis_COMMON("technique","Technique04","MACD_L","technique","Technique04","MACD_S",paraDTO,nowDTO,resultDTO,"9994_T",s);

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

//		Analysis00_Common.Analysis_COMMON("technique","Technique02","checkMotiKabu_L","technique","Technique00_Common","checkPrice_TODAY_S",paraDTO,nowDTO,resultDTO,"2229_T",s);

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
