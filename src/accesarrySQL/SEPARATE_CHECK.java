package accesarrySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;

import common.commonAP;

import constant.COLUMN;
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
				+ COLUMN.CODE + " , "
				+ COLUMN.DAYTIME_KENRI_LAST + " , "		//権利付最終売買日。効力は権利付最終日の翌営業日
				+ COLUMN.AJUSTRATE			+ " , "		//調整レート
				+ COLUMN.CHECKSEPA_COMBINE	+ "   "		//分割/併合の判断。分割の場合はtrue、併合の場合はfalse
//				+ COLUMN.SEPA_FLG						//分割、併合処理をおえたらここに1を埋める
				+ " from "
				+ TBL_Name.SEPARATE_DD
				+ " where "
//				+ COLUMN.DAYTIME_KENRI_LAST + " <= '" + commonAP.getTODAY() + "' and "
				+ COLUMN.DAYTIME_KENRI_LAST + " <= '" + controllDay.getMAX_DD_STOCK_ETF(s) + "' and "
				+ COLUMN.SEPA_FLG + " is false"
				+ " order by "
				+ COLUMN.DAYTIME_KENRI_LAST;




		try {
			s.rs = s.sqlGetter().executeQuery(SQL_defo);

			while ( s.rs.next() ) {

				boolean check = false;

				String enXan_1="";
				String enXan_2="";
				//分割の場合はtrue、併合の場合はfalse
				if (s.rs.getBoolean(COLUMN.CHECKSEPA_COMBINE)){
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
				double RATE=s.rs.getDouble(COLUMN.AJUSTRATE);


				//				System.out.println(s.rs.getString(COLUMN.DAYTIME_KENRI_LAST)  + ":" + s.rs.getString(COLUMN.CODE));
				//証券コード
				String code_4 = s.rs.getString(COLUMN.CODE);
				String day_kenri_last = s.rs.getString(COLUMN.DAYTIME_KENRI_LAST);

				SQL	= " select "
						+ COLUMN.CODE + ""
						+ " from "
						+ TBL_Name.CODELISTTBL
						+ " where "
						+ "left(" + COLUMN.CODE + ",4) = '" + s.rs.getString(COLUMN.CODE) + "'";

				s.rs = s.sqlGetter().executeQuery(SQL);
				//リストの中から一致するコードを探す。

				ArrayList<String> codeList = new ArrayList<String>();
				while ( s.rs.next() ) {
					//証券コード+市場
					codeList.add(	s.rs.getString(COLUMN.CODE)	);
				}

				for( int i = 0; i < codeList.size(); i++) {
					//権利付最終売買日以前の株価などを更新する。効力は権利付最終日の翌営業日から発生するため。
					SQL = " update " + TBL_Name.STOCK_DD
							+ " set "
							+ getColumnSEPA(COLUMN.OPEN		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN.MAX		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN.MIN		,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN.CLOSE	,	RATE,	enXan_1) + " , "
							+ getColumnSEPA(COLUMN.DEKI		,	RATE,	enXan_2) + "  "
							+ " where "
							+ COLUMN.DAYTIME + " <= '" + day_kenri_last + "'"
							+ " and "
							+ COLUMN.CODE + " = '" + codeList.get(i) + "'";

					s.freeUpdateQuery(SQL);

					//キープテーブルの更新をする。
					SQL = " update " + TBL_Name.KEEPLISTTBL
							+ " set "
							+ getColumnSEPA(COLUMN.AVERAGEPRICE	, COLUMN.IDEA_AVERAGEPRICE	,COLUMN.REAL_AVERAGEPRICE ,	RATE,	enXan_1) + "  "
							+ " where "
							+ COLUMN.CODE + " = '" + codeList.get(i) + "'";
					commonAP.writeInLog(SQL ,logWriting.DATEDATE_LOG_FLG);
					s.freeUpdateQuery(SQL);

					//2010-01-01以前、権利付最終売買日以後4営業日は取引期間後4営業日を営業停止期間としている。これのレコードを削除する。
					if("2010-01-01".compareTo(day_kenri_last) > 0){
						SQL	= " select "
								+ " * "
								+ " from "
								+ TBL_Name.STOCK_DD
								+ " where "
								+ COLUMN.CODE + " = '" + codeList.get(i) + "'"
								+ " and "
								+ COLUMN.DAYTIME + " > '" + day_kenri_last + "'"
								+ " limit 0,4 ";


						int checkDelete = 0;
						ArrayList<String> dayList = new ArrayList<String>();

						s.rs = s.sqlGetter().executeQuery(SQL);
						while ( s.rs.next() ) {

							  if (s.rs.getString(COLUMN.BEFORE_OPEN).equals(s.rs.getString(COLUMN.BEFORE_MAX))){
								  if (s.rs.getString(COLUMN.BEFORE_MIN).equals(s.rs.getString(COLUMN.BEFORE_CLOSE))){
									  if (s.rs.getString(COLUMN.BEFORE_MIN).equals(s.rs.getString(COLUMN.BEFORE_MAX))){
										  if (s.rs.getString(COLUMN.BEFORE_DEKI).equals(s.rs.getString(COLUMN.BEFORE_BAYBAY))){
											  if (s.rs.getString(COLUMN.BEFORE_DEKI).equals(("0"))){
												  dayList.add(s.rs.getString(COLUMN.DAYTIME));
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
								+ COLUMN.CODE + " = '" + codeList.get(i) + "'"
								+ " and "
								+ COLUMN.DAYTIME + " >= '" + dayList.get(0) + "'"
								+ " and "
								+ COLUMN.DAYTIME + " <= '" + dayList.get(3) + "'";
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


	}

	public static void updateSEPAFLG(String code,String DAY,S s){
		String SQL	= " update " + TBL_Name.SEPARATE_DD
					+ " set "
					+ COLUMN.SEPA_FLG + " = true "
					+ " where "
					+ COLUMN.DAYTIME_KENRI_LAST + " = '" + DAY + "'"
					+ " and "
					+ COLUMN.CODE + " = '" + code + "'"
					+ " and "
					+ COLUMN.SEPA_FLG + " is false";
		commonAP.writeInLog(SQL ,logWriting.DATEDATE_LOG_FLG);
		s.freeUpdateQuery(SQL);
	}

	public static void updateAccesary(String code,S s){


		setSepaDayList(code,s);


		//0:code
		//1:日付
		for( int i = 0; i < getSepaDayList().size(); i++) {

			ConAccessary.setConAccessary(getSepaDayList().get(i)[0],ReCord.CODE_01_STOCK,getSepaDayList().get(i)[1],s);
		}




	}

	public static String getColumnSEPA(String columnName1,String columnName2,String columnName3,double WARIAI,String enXan ){
		String RESULT = columnName1 + " = ( " + columnName1 + " ) " + enXan + " ( " + WARIAI + " ) , ";

		RESULT = RESULT + columnName2 + " = ( " + columnName2 + " ) " + enXan + " ( " + WARIAI + " ) , ";
		
		RESULT = RESULT + columnName3 + " = ( " + columnName3 + " ) " + enXan + " ( " + WARIAI + " ) ";
		
		return RESULT;
	}
	
	public static String getColumnSEPA(String columnName,double WARIAI,String enXan ){
		String RESULT = columnName + " = ( " + columnName + " ) " + enXan + " ( " + WARIAI + " ) ";

		return RESULT;
	}

	public static void setSepaDayList(String code,S s){
		codeSeparateList = new ArrayList<String[]>();



		String SQL	= " select "
				+ COLUMN.CODE + ","
				+ COLUMN.DAYTIME
				+ " from "
				+ TBL_Name.STOCK_DD
				+ " where "
				+ COLUMN.CODE + " = '" + code + "'"
				+ " order by "
				+ COLUMN.DAYTIME;
		try {

			s.rs = s.sqlGetter().executeQuery(SQL);

			while ( s.rs.next() ) {

				codeSeparate = new String[4];
				//コード
				codeSeparate[0]		=	s.rs.getString(COLUMN.CODE);

				//日付
				codeSeparate[1]		=	s.rs.getString(COLUMN.DAYTIME);

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
