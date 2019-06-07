package accesarrySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import makeWeekMonthTBL.makeWeekMonthCon;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import bean.Bean_calendarBean;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;

public class SEPARATE_CHECK {
	static String codeSeparate[] = new String[4];
	static ArrayList<String[]> codeSeparateList = new ArrayList<String[]>();


	public static void checkSEPARATE_controll(S s){


//		S s = new S();
//		s.getCon();



		String SQL = "";

		//権利付き最終売買日が今日以前のもので分割併合更新がまだのものを探す。
		String SQL_defo = " select "
				+ COLUMN_TBL.CODE + " , "
				+ COLUMN_TBL.DAYTIME_KENRI_LAST + " , "		//権利付最終売買日。効力は権利付最終日の翌営業日
				+ COLUMN_TBL.AJUSTRATE			+ " , "		//調整レート
				+ COLUMN_TBL.CHECKSEPA_COMBINE	+ "   "		//分割/併合の判断。分割の場合はtrue、併合の場合はfalse
//				+ COLUMN.SEPA_FLG						//分割、併合処理をおえたらここに1を埋める
				+ " from "
				+ TBL_Name.SEPARATE_DD
				+ " where "
//				+ COLUMN.DAYTIME_KENRI_LAST + " <= '" + commonAP.getTODAY() + "' and "
				+ COLUMN_TBL.DAYTIME_KENRI_LAST + " <= '" + controllDay.getMAX_DD_STOCK_ETF(s) + "' and "
				+ COLUMN_TBL.SEPA_FLG + " is false"
				+ " order by "
				+ COLUMN_TBL.DAYTIME_KENRI_LAST;

		commonAP.writeInLog("checkSEPARATE_controll:本日の分割併合対象検索:" + SQL_defo ,logWriting.DATEDATE_LOG_FLG);


		try {
			s.rs = s.sqlGetter().executeQuery(SQL_defo);

			while ( s.rs.next() ) {

				boolean check = false;

				String enXan_1="";
				String enXan_2="";
				//分割の場合はtrue、併合の場合はfalse
				if (s.rs.getBoolean(COLUMN_TBL.CHECKSEPA_COMBINE)){
					//分割。過去の株価を安くする。
					enXan_1=" / ";
					//出来高
					enXan_2=" * ";
				}else{
					//併合。過去の株価を高くする
					enXan_1=" * ";
					//出来高
					enXan_2=" / ";
				}
				double RATE=s.rs.getDouble(COLUMN_TBL.AJUSTRATE);


				//				System.out.println(s.rs.getString(COLUMN.DAYTIME_KENRI_LAST)  + ":" + s.rs.getString(COLUMN.CODE));
				//証券コード
				String code_4 = s.rs.getString(COLUMN_TBL.CODE);
				String day_kenri_last = s.rs.getString(COLUMN_TBL.DAYTIME_KENRI_LAST);

				SQL	= " select "
						+ COLUMN_TBL.CODE + ""
						+ " from "
						+ TBL_Name.CODELISTTBL
						+ " where "
//						+ "left(" + COLUMN.CODE + ",4) = '" + s.rs.getString(COLUMN.CODE) + "'";
						+ COLUMN_TBL.CODE + " = '" + s.rs.getString(COLUMN_TBL.CODE) + "'";

				s.rs = s.sqlGetter().executeQuery(SQL);
				//リストの中から一致するコードを探す。

				ArrayList<String> codeList = new ArrayList<String>();
				while ( s.rs.next() ) {
					//証券コード+市場
					codeList.add(	s.rs.getString(COLUMN_TBL.CODE)	);
				}

				for( int i = 0; i < codeList.size(); i++) {
					//権利付最終売買日以前の株価などを更新する。効力は権利付最終日の翌営業日から発生するため。
					SQL = " update " + TBL_Name.STOCK_DD
							+ " set "
							+ getColumnSEPA(COLUMN_TBL.OPEN		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.MAX		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.MIN		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.CLOSE	,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.DEKI		,	RATE,	enXan_2) + "  "
							+ " where "
							+ COLUMN_TBL.DAYTIME + " <= '" + day_kenri_last + "'"
							+ " and "
							+ COLUMN_TBL.CODE + " = '" + codeList.get(i) + "'";
					commonAP.writeInLog("checkSEPARATE_controll:株テーブル更新開始:" + SQL ,logWriting.DATEDATE_LOG_FLG);
					s.freeUpdateQuery(SQL);

					//キープテーブルの更新をする。
					SQL = " update " + TBL_Name.KEEPLISTTBL
							+ " set "
							+ getColumnSEPA(COLUMN_TBL.AVERAGEPRICE			,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.IDEA_AVERAGEPRICE	,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN_TBL.REAL_AVERAGEPRICE	,	RATE,	enXan_1) + "  "
							+ " where "
							+ COLUMN_TBL.CODE + " = '" + codeList.get(i) + "'";
					commonAP.writeInLog("checkSEPARATE_controll:キープテーブル更新開始:" + SQL ,logWriting.DATEDATE_LOG_FLG);
					s.freeUpdateQuery(SQL);

					//2010-01-01以前、権利付最終売買日以後4営業日は取引期間後4営業日を営業停止期間としている。これのレコードを削除する。
					if("2010-01-01".compareTo(day_kenri_last) > 0){
						SQL	= " select "
								+ " * "
								+ " from "
								+ TBL_Name.STOCK_DD
								+ " where "
								+ COLUMN_TBL.CODE + " = '" + codeList.get(i) + "'"
								+ " and "
								+ COLUMN_TBL.DAYTIME + " > '" + day_kenri_last + "'"
								+ " limit 0,4 ";


						int checkDelete = 0;
						ArrayList<String> dayList = new ArrayList<String>();

						s.rs = s.sqlGetter().executeQuery(SQL);
						while ( s.rs.next() ) {

							  if (s.rs.getString(COLUMN_TBL.BEFORE_OPEN).equals(s.rs.getString(COLUMN_TBL.BEFORE_MAX))){
								  if (s.rs.getString(COLUMN_TBL.BEFORE_MIN).equals(s.rs.getString(COLUMN_TBL.BEFORE_CLOSE))){
									  if (s.rs.getString(COLUMN_TBL.BEFORE_MIN).equals(s.rs.getString(COLUMN_TBL.BEFORE_MAX))){
										  if (s.rs.getString(COLUMN_TBL.BEFORE_DEKI).equals(s.rs.getString(COLUMN_TBL.BEFORE_BAYBAY))){
											  if (s.rs.getString(COLUMN_TBL.BEFORE_DEKI).equals(("0"))){
												  dayList.add(s.rs.getString(COLUMN_TBL.DAYTIME));
												  checkDelete++;
											  }
										  }
									  }
								  }
							  }

						}

						if ( checkDelete == 4 ){


							SQL = " delete from "
								+ TBL_Name.STOCK_DD
								+ " where "
								+ COLUMN_TBL.CODE + " = '" + codeList.get(i) + "'"
								+ " and "
								+ COLUMN_TBL.DAYTIME + " >= '" + dayList.get(0) + "'"
								+ " and "
								+ COLUMN_TBL.DAYTIME + " <= '" + dayList.get(3) + "'";
							commonAP.writeInLog(SQL ,logWriting.DATEDATE_LOG_FLG);
							s.freeUpdateQuery(SQL);
						}
					}







					//調整後の株価で移動平均線とかを引き直す。
					updateAccesary(	codeList.get(i)	,s	);
					System.out.println("");
				}


				//フラグをtrueにする。
				updateSEPAFLG(code_4,day_kenri_last,s);
				System.out.println(code_4 + "の" + day_kenri_last);
				s.rs = s.sqlGetter().executeQuery(SQL_defo);

			}
		} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		}


//		s.closeConection();

		commonAP.writeInLog("checkSEPARATE_controll:本日の分割併合対象検索終了",logWriting.DATEDATE_LOG_FLG);
	}

	public static void updateSEPAFLG(String code,String DAY,S s){
		String SQL	= " update " + TBL_Name.SEPARATE_DD
					+ " set "
					+ COLUMN_TBL.SEPA_FLG + " = true "
					+ " where "
					+ COLUMN_TBL.DAYTIME_KENRI_LAST + " = '" + DAY + "'"
					+ " and "
					+ COLUMN_TBL.CODE + " = '" + code + "'"
					+ " and "
					+ COLUMN_TBL.SEPA_FLG + " is false";
		commonAP.writeInLog("updateSEPAFLG:" + code + ":" + SQL ,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
	}
	static int checkCount=0;

	private static void resetWeekConTBL(String code,S s){
		resetWeekConTBL(TBL_Name.STOCK_MM_REAL_TIME,code,s);
		resetWeekConTBL(TBL_Name.STOCK_WW_REAL_TIME,code,s);
		resetWeekConTBL(TBL_Name.STOCK_MM_TBL,code,s);
		resetWeekConTBL(TBL_Name.STOCK_WW_TBL,code,s);
	}

	private static void resetWeekConTBL(String TBL,String code,S s){
		String A = "A";
		String B = "B";
		String SQL = " delete " + A + " from "
				+ TBL + " as " + A
				+ " left outer join "
				+ TBL + " as " + B
				+ " on "
				+ " " + A + "." + COLUMN_TBL.CODE + " = " + B + "." + COLUMN_TBL.CODE
				+ " and "
				+ " " + A + "." + COLUMN_TBL.DAYTIME + " = " + B + "." + COLUMN_TBL.DAYTIME
				+ " where "
				+ " " + A + "." + COLUMN_TBL.CODE + " = " + "'" + code + "'";
		commonAP.writeInLog("resetWeekConTBL:" + code + ":"+TBL+"月足週足のテーブルリセット" ,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
	}

	public static void updateAccesary(String code,S s){

		//月足週足の関係テーブルすべて削除する。
		resetWeekConTBL(code,s);

		setSepaDayList(code,s);
		ConAccessaryNew ac = new ConAccessaryNew(ReCord.CODE_01_STOCK , code);
		makeWeekMonthCon n = new makeWeekMonthCon( code);
		n.bunkatuheigoParametaReset(code, s);
		commonAP.writeInLog("updateAccesary:" + code + ":過去の更新開始" ,logWriting.DATEDATE_LOG_FLG);
		//0:code
		//1:日付
		for( int i = 0; i < getSepaDayList().size(); i++) {
			//新しい月足週足

			//ニューアクセサリ
			Bean_calendarBean calBean = new Bean_calendarBean();
			calBean.setCalendarBean(getSepaDayList().get(i)[1], s);
			ac.setConAccessary(calBean,s);
			//ニューアクセサリここまで

			//月週足の加工
			n.createWeekMonth(getSepaDayList().get(i)[1],s,false);

//			ConAccessary.setConAccessary(getSepaDayList().get(i)[0],ReCord.CODE_01_STOCK,getSepaDayList().get(i)[1],s);

			checkCount++;
			if( checkCount%400 == 0){
				checkCount=0;
				s.resetConnection();
			}
		}


		commonAP.writeInLog("updateAccesary:" + code + ":過去の更新終了" ,logWriting.DATEDATE_LOG_FLG);

	}


	public static String getColumnSEPA(String columnName,double WARIAI,String enXan ){
		String RESULT = columnName + " = ( " + columnName + " ) " + enXan + " ( " + WARIAI + " ) ";

		return RESULT;
	}

	public static void setSepaDayList(String code,S s){
		codeSeparateList = new ArrayList<String[]>();



		String SQL	= " select "
				+ COLUMN_TBL.CODE + ","
				+ COLUMN_TBL.DAYTIME
				+ " from "
				+ TBL_Name.STOCK_DD
				+ " where "
				+ COLUMN_TBL.CODE + " = '" + code + "'"
				+ " order by "
				+ COLUMN_TBL.DAYTIME;
		try {

			s.rs = s.sqlGetter().executeQuery(SQL);

			while ( s.rs.next() ) {

				codeSeparate = new String[4];
				//コード
				codeSeparate[0]		=	s.rs.getString(COLUMN_TBL.CODE);

				//日付
				codeSeparate[1]		=	s.rs.getString(COLUMN_TBL.DAYTIME);

//				System.out.println("code:" + codeSeparate[0]);
//				System.out.println("day:" + codeSeparate[1]);
	//			System.out.println("rate:" + codeSeparate[2]);
//				System.out.println("judge:" + codeSeparate[3]);

				codeSeparateList.add(codeSeparate);
			}

		} catch (SQLException e) {

		}
	}

	public static ArrayList<String[]> getSepaDayList(){
		return codeSeparateList;
	}
}
