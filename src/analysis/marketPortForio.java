package analysis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.COLUMN_TBL;
import constant.logWriting;



public class marketPortForio {

	String kugiri = "_";
	String kugiSepa = "-";

	public void checkA(){



		String strDay = "2017-01-04";
		String endDay = "2019-12-30";
		String budget = "100000";
		String filePath = "D:\\01.kabu_backup\\00.dropbox\\Dropbox\\01.kabu\\01.log";
		//select count(*) from kabudata.aa_calendartbl where daytime between '2017-01-04' and '2019-12-30'
		reserchMarketportForio(0,999999999, strDay, endDay, budget,filePath,730);
		
//		System.out.println("size:" + testList.size());

	}


	private void reserchMarketportForio(int start,int maxL,String strDay,String endDay,String budget,String filePath,int term){



		List<String> returnList = new ArrayList<>();
		List<String> codeListPattern = new ArrayList<>();


		String codes;
		String[] codeSplit;

		codeListPattern = getTargetCode(strDay,endDay,term);
		
//		コンビネーション
		codeListPattern = combi2(codeListPattern);

		
		
		S s = new S();
		s.getCon();
		
		for(int i = start; i < codeListPattern.size(); i++){
			codes = codeListPattern.get(i);
			codeSplit = codes.split(kugiSepa, 0);
			con_AB_MarketPortForio(i,codes,codeSplit,strDay,endDay,budget,filePath,s);

			if (i==maxL){
				s.closeConection();
				return;
			}
		}

		commonAP.writeText(filePath,"test.txt","koko3" + "\r\n");
		s.closeConection();

	}

	//単位は％
	private void con_AB_MarketPortForio(long marketAdress,String codes,String[] codeSplit,String strDay,String endDay,String budget,String filePath,S s){


		//ABテーブルを削除する。
		deleteTBL("false",s);
		
		//ABテーブルを作成する。
		upDate_AB_MarketPortForio(5,codes,codeSplit,strDay,endDay,budget,s);

		//最終日の平均、標準偏差を計算する
		calculateAB_TBL(endDay,s);


		if ((marketAdress+1) % 1000 ==0 ){
			s.reCon();
			//ANテーブルを出力する
			outABfile(filePath,s);
			//ABテーブルを全削除する
			deleteTBL("true",s);
		}




	}


	private void outABfile(String filePath,S s){

		String SQL;
		SQL = " select "
			+ COLUMN_TBL.MARKET_ADRESS	 + ","
			+ COLUMN_TBL.CODES			 + ","
			+ COLUMN_TBL.START_DAY		 + ","
			+ COLUMN_TBL.DAYTIME		 + ","
			+ COLUMN_TBL.RETURN_FOR_BETA + ","
			+ COLUMN_TBL.RISK_FOR_BETA	 + " "
			+ " from "
			+ TBL_Name.AB_MarketPortForio
			+ " where "
			+ COLUMN_TBL.ACTIVE_FLG + " is true ";

		String R0;
		String R1;
		String R2;
		String R3;
		String R4;
		String R5;
		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			while ( s.rs2.next() ) {
				R0 = s.rs2.getString(	 COLUMN_TBL.MARKET_ADRESS	);
				R1 = s.rs2.getString(	 COLUMN_TBL.CODES			);
				R2 = s.rs2.getString(	 COLUMN_TBL.START_DAY		);
				R3 = s.rs2.getString(	 COLUMN_TBL.DAYTIME			);
				R4 = s.rs2.getString(	 COLUMN_TBL.RETURN_FOR_BETA	);
				R5 = s.rs2.getString(	 COLUMN_TBL.RISK_FOR_BETA	);
				//\銘柄名,開始日,終了日,リターン、リスク
				commonAP.writeText(filePath,PROPARTY.RESERCHMARKET_PORT,R0 + "," + R1 + "," + R2 + "," + R3 + "," + R4 + "%," + R5 + "%");
				commonAP.writeText(filePath,PROPARTY.RESERCHMARKET_PORT,"\r\n");

			}
		} catch (SQLException e) {

		}




	}


	private void calculateAB_TBL(String endDay,S s){
		String upDateSQL;
//		System.out.println(getAVG_STV_SQL("AVG",COLUMN_TBL.RETURN_FOR_BETA,endDay));
//		System.out.println(getAVG_STV_SQL("STDDEV",COLUMN_TBL.RISK_FOR_BETA,endDay));

		upDateSQL = " update "
				+ TBL_Name.AB_MarketPortForio + " as A ,"
				+ " ( " + getAVG_STV_SQL() + " )  as B"
				+ " set "
				+ "A." + COLUMN_TBL.ACTIVE_FLG
				+ " = true  , "
				+ "A." + COLUMN_TBL.RETURN_FOR_BETA
				+ " = "
				+ "B." + COLUMN_TBL.RETURN_FOR_BETA + ","
				+ "A." + COLUMN_TBL.RISK_FOR_BETA
				+ " = "
				+ "B." + COLUMN_TBL.RISK_FOR_BETA
				+ " where "
				+ "A." +  COLUMN_TBL.ACTIVE_FLG + " is false "
				+ " and "
				+ "A." +  COLUMN_TBL.DAYTIME + " = " + "'" + endDay + "'";
		s.freeUpdateQuery(upDateSQL);



	}

	private String getAVG_STV_SQL(){
		String SQL = " select "
				   + "AVG(((t1." + COLUMN_TBL.CLOSE + " / " + "t2." + COLUMN_TBL.CLOSE + " ) - 1 ) * 100 ) as " + COLUMN_TBL.RETURN_FOR_BETA + ","
				   + "STDDEV_pop(((t1." + COLUMN_TBL.CLOSE + " / " + "t2." + COLUMN_TBL.CLOSE + " ) - 1 ) * 100 ) as " + COLUMN_TBL.RISK_FOR_BETA
				   + " from "
				   + "kabudata."+TBL_Name.AB_MarketPortForio + " as t1 "
				   + " inner join "
				   + "kabudata."+TBL_Name.AB_MarketPortForio + " as t2 "
				   + " on "
				   + "t1." + COLUMN_TBL.DAYTIME_BEFORE
				   + " = "
				   + "t2." + COLUMN_TBL.DAYTIME
				   + " where "
				   + "t1." + COLUMN_TBL.ACTIVE_FLG + " is false ";


//		select
//		 AVG((t1.close / t2.close ) - 1)  as RETURN_for_beta,
//		 STDDEV((t1.close / t2.close ) - 1)  as risk_for_beta
//		from
//		 kabudata.ab_marketportforio as t1
//		 inner join kabudata.ab_marketportforio as t2 on t1.dayTime_BEFORE = t2.dayTime
//		 where t1.ACTIVE_FLG is false


		return SQL;
	}

	//codesには「1234_4,1235_1,1236_4,1276_1」というような形で入っている
	//マーケットポートフォリオテーブルをインサートする
	private void upDate_AB_MarketPortForio(long marketAdress,String codes,String[] codeSplit,String strDay,String endDay,String budget,S s){

		String SQL = getSQL(marketAdress,codes,codeSplit,strDay,endDay,budget,codeSplit.length);

		SQL = " insert into " + TBL_Name.AB_MarketPortForio
			+ "("
			+ COLUMN_TBL.MARKET_ADRESS					 + " ,  "
			+ COLUMN_TBL.CODES					 + " ,  "
			+ COLUMN_TBL.START_DAY					 + " ,  "
			+ COLUMN_TBL.DAYTIME					 + " ,  "
			+ COLUMN_TBL.DAYTIME_BEFORE			 + " , "
			+ COLUMN_TBL.CLOSE					 + "   "
			+ ")"
			+ SQL;


//		インサート
		try {
			int addRecord = s.sqlGetter().executeUpdate(SQL);
		} catch (SQLException e) {
			commonAP.writeInLog("insertMarketTBL：" + SQL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInErrLog(e);
		}

	}


	private String getSQL(long marketAdress,String codes,String[] codeSplit,String strDay,String endDay,String budget,int size){
		String fromTBL;
		String whereTBL;
		String selectTBL;
		String asTBL = "t";
		String asCal = "calT";
		selectTBL = " select "
					+ "'" + marketAdress + "'" + " as " + COLUMN_TBL.MARKET_ADRESS + ","
					+ "'" + codes + "'" + " as " + COLUMN_TBL.CODES + ","
					+ "'" + strDay + "'" + " as " + COLUMN_TBL.START_DAY + ","
					+ asTBL + "1" + "." + COLUMN_TBL.DAYTIME + " as " + COLUMN_TBL.DAYTIME + ","
					+ asCal + "." + COLUMN_TBL.DAYTIME_BEFORE + " as " + COLUMN_TBL.DAYTIME_BEFORE + ","
					+ asTBL + "1" + "." + COLUMN_TBL.CLOSE + " * (" + getCreateCol(getCode(codeSplit[0]),strDay,getCate(codeSplit[0]),budget) + ")";

		fromTBL = " from " + getTBL(getCate(codeSplit[0])) + " as " + asTBL + "1";
		whereTBL = " where " + asTBL + "1" + "." + COLUMN_TBL.CODE + " = " + "'" + (getCode(codeSplit[0])) + "'";

		for (int count = 2; count <= size; count++){

			selectTBL = selectTBL + " + "
					  + asTBL + (count) + "." + COLUMN_TBL.CLOSE + " * (" + getCreateCol(getCode(codeSplit[count-1]),strDay,getCate(codeSplit[count-1]),budget) + ")" ;
					;

			fromTBL = fromTBL
					+ " inner join " + getTBL(getCate(codeSplit[count - 1])) + " as " + asTBL + (count)
					+ " on "
					+ (asTBL + (count-1)) + "." + COLUMN_TBL.DAYTIME
					+ " = "
					+ (asTBL + (count)) + "." + COLUMN_TBL.DAYTIME;

			whereTBL = whereTBL + " and " + (asTBL + count) + "." + COLUMN_TBL.CODE + " = " + "'" + (getCode(codeSplit[count-1])) + "'";
		}

		selectTBL = selectTBL + " as " + COLUMN_TBL.CLOSE + " ";

		fromTBL = fromTBL
				+ " inner join " + TBL_Name.CALENDAR_TBL + " as " + asCal
				+ " on "
				+ asCal + "." + COLUMN_TBL.DAYTIME
				+ " = "
				+ (asTBL + 1) + "." + COLUMN_TBL.DAYTIME
				+ " and "
				+ "'" + strDay+ "'" + " <= "+  asCal + "." + COLUMN_TBL.DAYTIME
				+ " and "
				+ asCal + "." + COLUMN_TBL.DAYTIME + " <= " + "'" + endDay + "'";
		fromTBL = selectTBL + fromTBL + whereTBL;

		return fromTBL;
	}

	private String getCreateCol(String code,String strDay,String cate,String budget){

		String TBL = getTBL(cate);

		String SQL = "select " + budget + " / " + COLUMN_TBL.CLOSE + " from " + TBL + " where " + COLUMN_TBL.CODE + " ='" + code + "' and " + COLUMN_TBL.DAYTIME + " ='" + strDay + "'" ;

		return SQL;
	}

	//全銘柄を取得する
	//株の場合はcode_1
	//ETFの場合はcode_4
	private List<String> getTargetCode(String strDay,String endDay,int term){
		List<String> returnList = new ArrayList<>();

		String SQL_1;
		String SQL_4;
		String SQL;
		String dataCount = "dataCount";
		String cate = "cate";
		S s = new S();
		s.getCon();
//		select '2020-12-12' as starta , count(code) as dataCount,code from kabudata.01_stock_dd where daytime between '2019-08-27' and '2020-08-27' group by code having count(code) >= 1
//				 union
//				select '2020-12-12' as starta , count(code) as dataCount,code from kabudata.04_etf_dd where daytime between '2019-08-27' and '2020-08-27' group by code having count(code) >= 1;
		//株
		SQL_1 = " select " + "'1' as " + cate + ", count(" + COLUMN_TBL.CODE + ") as " + dataCount + "," + COLUMN_TBL.CODE
				  +	" from "
				  + TBL_Name.STOCK_DD
				  + " where "
				  + COLUMN_TBL.DAYTIME + " between '" + strDay + "' and '" + endDay + "'"
				  + "group by "
				  + COLUMN_TBL.CODE + " having count(" + COLUMN_TBL.CODE + ") >= " + term;

		//ETF
		SQL_4 = " select " + "'4' as " + cate + ",  count(" + COLUMN_TBL.CODE + ") as " + dataCount + "," + COLUMN_TBL.CODE
				  +	" from "
				  + TBL_Name.ETF_DD
				  + " where "
				  + COLUMN_TBL.DAYTIME + " between '" + strDay + "' and '" + endDay + "'"
				  + "group by "
				  + COLUMN_TBL.CODE + " having count(" + COLUMN_TBL.CODE + ") >= " + term;

		SQL = SQL_1 + " union " + SQL_4;


		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				returnList.add(s.p_rs.getString(COLUMN_TBL.CODE) + kugiri + s.p_rs.getString(cate));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}


		s.closeConection();
		return returnList;
	}



	//「,」区切りで全パターンをリストの中の組み合わせを羅列する
	private List<String> combi2(List<String> codeList){
		List<String> returnList = new ArrayList<>();
		int count = codeList.size();
        int num = 0;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count - 0; j++) {

                    num++;
                    returnList.add((codeList.get(i) + kugiSepa + codeList.get(j)));

            }
        }

		return returnList;
	}

	private List<String> combi3(List<String> codeList){
		List<String> returnList = new ArrayList<>();
		int count = codeList.size();
        int num = 0;
        for (int i = 0; i < count - 2; i++) {
            for (int j = i + 1; j < count - 1; j++) {
                for (int k = j + 1; k < count; k++) {
                    num++;
                    returnList.add((codeList.get(i) + kugiSepa + codeList.get(j) + kugiSepa + codeList.get(k)));
                }
            }
        }

		return returnList;
	}

	private List<String> combi4(List<String> codeList){
		List<String> returnList = new ArrayList<>();
		int count = codeList.size();
        int num = 0;
        for (int i = 0; i < count - 3; i++) {
            for (int j = i + 1; j < count - 2; j++) {
                for (int k = j + 1; k < count - 1; k++) {
                	for (int l = k + 1; l < count - 0; l++) {
                		num++;
                        returnList.add((codeList.get(i) + kugiSepa + codeList.get(j) + kugiSepa + codeList.get(k) + kugiSepa + codeList.get(l)));
                	}

                }
            }
        }

		return returnList;
	}

	private void deleteTBL(String BOOLEAN,S s){
		String SQL = " delete from " + TBL_Name.AB_MarketPortForio + " where " + COLUMN_TBL.ACTIVE_FLG + " is " + BOOLEAN;
		s.freeUpdateQuery(SQL);
	}


	private String getTBL(String cate){
		String returnTBL="";

		switch (cate) {
			case "1":
				returnTBL = TBL_Name.STOCK_DD;
				break;
			case "4":
				returnTBL = TBL_Name.ETF_DD;
				break;

			default:
				break;
		}

		return  returnTBL;
	}

	//1234_4で1234を返す
	private String getCode(String codeSprit){
		return codeSprit.substring(0, 4);
	}

	//1234_4で4を返す
	private String getCate(String codeSprit){
		return codeSprit.substring(codeSprit.length() - 1);
	}
}
