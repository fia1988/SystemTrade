package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import proparty.controllDay;
import accesarrySQL.SQLChecker;
import constant.COLUMN_TBL;
import constant.ReCord;
import constant.logWriting;

public class commonAP {

//	static ArrayList<String> codeList = new ArrayList<String>();
//	static ArrayList<ArrayList<String>> codeCateList = new ArrayList<ArrayList<String>>();


	public static final   int TOTAL_FLG	= 1;
	public static final  int AVERAGE_FLG	= 2;
	public static final  int COUNT_FLG	= 3;



	static String codeSingle[] = new String[2];
	static ArrayList<String[]> codeListwithiCate = new ArrayList<String[]>();
//	static List<String[]> codeListwithiCate = new ArrayList<String>();

	//終了日を入れて、count文遡った場合の開始日を取得
	//例：2017/01/11,2→2017/01/10
	//例：2017/01/11,1→2017/01/11
	public static String getStartDay(String end,int count,S s){
		String SQL = " select " + COLUMN_TBL.DAYTIME + " from " + ReCord.BASIC_TBL
				+" where "
				+ COLUMN_TBL.CODE + " = '" + ReCord.BASIC_CODE_01 + "'"
				+ " and "
				+ COLUMN_TBL.DAYTIME + " <= '" + end + "'"
				+ " order by " + COLUMN_TBL.DAYTIME + " desc limit " + count;
		String startDay = "";
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				startDay=s.rs.getString(COLUMN_TBL.DAYTIME);

			}

		} catch (SQLException e) {
			System.out.println("getStartDayでエラー。スタックトレース:" + SQL);
			e.getStackTrace();
		}
		return startDay;
	}

	//引数で指定したコードのTODAYが存在すればtrue、存在しなければfalse
	public static boolean checkStandardCode(String code,String TBL){
		boolean resultBoolean = false;

		S s = new S();
		s.getCon();

		String checkDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);

		String SQL = " select " + COLUMN_TBL.CODE + " from " + TBL
					+ " where "
					+ COLUMN_TBL.CODE + " = '" + code + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " = '" + checkDay + "'";

		try {
			s.rs2 = s.sqlGetter().executeQuery(SQL);
			if ( s.rs2.next() ) {
				//trueのとき、存在する。
				resultBoolean = true;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



		s.closeConection();
		return resultBoolean;
	}

	//startが0の場合、1を返す。
	public static int countDay(String start,String end,S s){

		if (start.equals("0")){
			return 0;
		}

		String SQL = " select count(" + COLUMN_TBL.DAYTIME + ")"
					+" from " + ReCord.BASIC_TBL
					+" where "
					+ COLUMN_TBL.CODE + " = '" + ReCord.BASIC_CODE_01 + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " <= '" + end + "'"
					+ " and "
					+ COLUMN_TBL.DAYTIME + " >= '" + start + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			s.rs.next();

			return s.rs.getInt(	"count(" + COLUMN_TBL.DAYTIME + ")"	);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return 0;

	}



	public static void writeInErrLog(Exception e) {

        StringWriter sw = null;
        PrintWriter  pw = null;

        sw = new StringWriter();
        pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String trace = sw.toString();
        commonAP.writeInLog(trace,logWriting.DATEDATE_LOG_FLG);
        commonAP.writeInLog(trace,logWriting.CODE_SEPACON_ERR_LOG_FLG);
        try {
            if ( sw != null ) {
                sw.flush();
                sw.close();
            }
            if ( pw != null ) {
                pw.flush();
                pw.close();
            }
        } catch (IOException ignore){}

	}

	public static void writeText(String folderPath,String fileName,String writing){
		File file = new File(folderPath + File.separator + fileName);
//			File folder = new File(file_name);
//			folder.mkdirs();

		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try{
		//				File file = new File(newFile);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(folderPath + File.separator + fileName, true),PROPARTY.MOJI_TYPE)));
			pw.write(writing);
			pw.close();
//			FileWriter filewriter = new FileWriter(file,true);
//			filewriter.write(writing );
//			filewriter.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public static void writeInLog(String writing,int writeType){
		Calendar now = Calendar.getInstance(); //インスタンス化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//		int h = now.get(now.HOUR_OF_DAY);//時を取得
//		int m = now.get(now.MINUTE);     //分を取得
//		int s = now.get(now.SECOND);      //秒を取得
//
//		int y = now.get(Calendar.YEAR);  //年を取得
//		int mo = now.get(Calendar.MONTH);//月を取得
//		int d = now.get(Calendar.DATE); //現在の日を取得
//		String nowTime = y+"/"+mo + "/" + d + "　" +h + ":"+m+":"+s+":";
		String nowTime = sdf.format(now.getTime());
//		System.out.println(sdf.format(now.getTime()));
//		System.out.println(y+"/"+mo + "/" + d + "_" +h + ":"+m+":"+s+":");


		writeLog(nowTime + "," + writing,writeType);
		writeLog("\r\n",writeType);

	}

	public static void writeLog(String writing,int writeType){


		String fileName = "sys" + logWriting.logKakutyousi;
		switch (writeType) {
			case logWriting.DATEDATE_LOG_FLG:
				fileName = "sys_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.STOCK_RESULT_LOG_FLG:
				fileName = "sys_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.BACKTEST_LOG_FLG:
				fileName = "backtestLog" + logWriting.logKakutyousi;
				break;
			case logWriting.ANOTHER_RROR_LOG_FLG:
				fileName = "sys_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_RESULT_LOG_FLG:
				fileName = "CODE_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_RESULT_LIST_LOG_FLG:
				fileName = "samaryResult_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_SEPACON_ERR_LOG_FLG:
				fileName = controllDay.getTODAY() + "sepaComERR_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_DOLLCOST_RESULT_LOG_FLG:
				fileName = "CODE_DOLLCOST_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_DOLLCOST_STOCKLOST_RESULT_LOG_FLG:
				fileName = "CODE_DOLLCOST_STOCK_RIST" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_DOLLCOST_L_PRICE_LISTRESULT_LOG_FLG:
				fileName = "CODE_DOLLCOST_L_PRICE_LIST" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.CODE_DOLLCOTST_RESULT_LIST_LOG_FLG:
				fileName = "samaryResult_DOLLCOST_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.DOLLCOST_BACKTEST_LOG_FLG:
				fileName = "CODE_DOLLCOST_backtestLog" + logWriting.logKakutyousi;
				break;
			case logWriting.KEEP_CODE_RESULT_LOG:
				fileName = "KEEP_CODE_RESULT_LOG_" + writeType + logWriting.logKakutyousi;
				break;
			case logWriting.MOVING_LOG_FLG:
				fileName = "MOVING_CHECK_LOG_" + writeType + logWriting.logKakutyousi;
				break;
			default:
			break;
		}


		String logFileFolderPath = PROPARTY.LOG_FILE_OUT;

		writeText(logFileFolderPath,fileName,writing);

		System.out.print(writing);
	}


	public static double getAverageTotalCountDouble(List<Double> list,int checkCountTotal){
		int totalCount	=	0;
		double sum	=	0 ;

		for (double a: list){
			totalCount++;
			sum = sum + a;
		}

		switch(checkCountTotal){
		case TOTAL_FLG:
			return sum;
		case COUNT_FLG:
			return totalCount;
		case AVERAGE_FLG:
			return sum/totalCount;
		default:
			return 0;
		}

	}

	public static String getStringList(ArrayList<Long> resultList,boolean judge){
		String resultLetter = "";

		List<Long> doubleListCopy = new ArrayList<Long>();
		doubleListCopy = resultList;

		Collections.sort(doubleListCopy);
		Collections.reverse(doubleListCopy);
		if(judge){
			//勝ちリスト

		}else{

			//負けリスト
			//昇順でソートしたものを逆順にする
//			Collections.sort(doubleListCopy);
//
		}


	    for (Long a:doubleListCopy){
	        resultLetter = resultLetter + a + ",";
	    }

		return resultLetter;
	}

	public static double getAverageTotalCountLong(List<Long> list,int checkCountTotal){
		int totalCount	=	0;
		double sum	=	0 ;

		for (long a: list){
			totalCount++;
			sum = sum + a;
		}

		switch(checkCountTotal){
		case TOTAL_FLG:
			return sum;
		case COUNT_FLG:
			return totalCount;
		case AVERAGE_FLG:
			return sum/totalCount;
		default:
			return 0;
		}
	}


	public static double getAverageCut(List<Long> list,boolean checkJudge,int checkCountTotal,double cut,String a){
		List<Long> doubleListCopy = new ArrayList<Long>();
//		List<Double> doubleList = new ArrayList<Double>();

		int totalCount	=	0;
		double sum	=	0 ;


		doubleListCopy = list;
		//昇順に並び替え
		Collections.sort(doubleListCopy);


		if (checkJudge){
			for (int i = 0  ; i < doubleListCopy.size() - (int)Math.round(cut * doubleListCopy.size()) ; i++) {
				if(doubleListCopy.get(i) >= 0){
					totalCount++;
					sum = sum + doubleListCopy.get(i);

				}
	        }
		}else{
			for (int i = 0 + (int)Math.round(cut * doubleListCopy.size() )   ; i < doubleListCopy.size() ; i++) {
				if(doubleListCopy.get(i) < 0){
					totalCount++;
					sum = sum + doubleListCopy.get(i);

				}
	        }
		}


		switch(checkCountTotal){
			case TOTAL_FLG:
				return sum;
			case COUNT_FLG:
				return totalCount;
			case AVERAGE_FLG:
				return sum/totalCount;
			default:
				return 0;
		}
	}

	//checkJudgeがtrueの場合は正の数、falseは負の数
	public static double getAverageCut(List<Double> list,boolean checkJudge,int checkCountTotal,double cut){
		List<Double> doubleListCopy = new ArrayList<Double>();
//		List<Double> doubleList = new ArrayList<Double>();

		int totalCount	=	0;
		double sum	=	0 ;

		doubleListCopy = list;
		//昇順に並び替え
		Collections.sort(doubleListCopy);

		int cutsize = (int)Math.round(cut * doubleListCopy.size());
		if ( cutsize == 0){
			if ( doubleListCopy.size() > 2){
				cutsize = 1;
			}
		}

		if (checkJudge){
			for (int i = 0  ; i < doubleListCopy.size() - cutsize ; i++) {
				if(doubleListCopy.get(i) >= 0){
					totalCount++;
					sum = sum + doubleListCopy.get(i);

				}
	        }
		}else{
			for (int i = 0 + cutsize   ; i < doubleListCopy.size() ; i++) {
				if(doubleListCopy.get(i) < 0){
					totalCount++;
					sum = sum + doubleListCopy.get(i);

				}
	        }
		}



		switch(checkCountTotal){
			case TOTAL_FLG:
				return sum;
			case COUNT_FLG:
				return totalCount;
			case AVERAGE_FLG:
				return sum/totalCount;
			default:
				return 0;
		}
	}

//	//checkJudgeがtrueの場合は正の数、falseは負の数
//	public static double getAverageCut(ArrayList<Long> list,boolean checkJudge,int checkCountTotal,double cut){
//		List<Long> doubleListCopy = new ArrayList<Long>();
//		//			List<Double> doubleList = new ArrayList<Double>();
//
//		int totalCount	=	0;
//		double sum	=	0 ;
//
//		doubleListCopy = list;
//		//昇順に並び替え
//		Collections.sort(doubleListCopy);
//
//
//		if (checkJudge){
//			for (int i = 0  ; i < doubleListCopy.size() - (int)Math.round(cut * doubleListCopy.size()) ; i++) {
//				if(doubleListCopy.get(i) >= 0){
//					totalCount++;
//					sum = sum + doubleListCopy.get(i);
//					//						System.out.println(doubleListCopy.get(i));
//				}
//			}
//		}else{
//			for (int i = 0 + (int)Math.round(cut * doubleListCopy.size() )   ; i < doubleListCopy.size() ; i++) {
//				if(doubleListCopy.get(i) < 0){
//					totalCount++;
//					sum = sum + doubleListCopy.get(i);
//					//						System.out.println(doubleListCopy.get(i));
//				}
//			}
//		}
//
//
//
//		switch(checkCountTotal){
//		case TOTAL_FLG:
//			return sum;
//		case COUNT_FLG:
//			return totalCount;
//		case AVERAGE_FLG:
//			return sum/totalCount;
//		default:
//			return 0;
//		}
//	}

//	//checkJudgeがtrueの場合は正の数、falseは負の数
//	public static double getAverageCutCount(List<Long> list,boolean judge,boolean checkJudge,double cut){
//		List<Long> doubleListCopy = new ArrayList<Long>();
//		List<Long> doubleList = new ArrayList<Long>();
//	}
//
//	//checkJudgeがtrueの場合は正の数、falseは負の数
//	public static double getAverageCut(List<Double> list,boolean judge,boolean checkJudge,double cutMAX,double cutMIN){
//		List<Long> doubleListCopy = new ArrayList<Long>();
//		List<Long> doubleList = new ArrayList<Long>();
//	}
//
//
//	//checkJudgeがtrueの場合は正の数、falseは負の数
//	public static double getAverageCutCount(List<Double> list,boolean judge,boolean checkJudge,double cut){
//		List<Long> doubleListCopy = new ArrayList<Long>();
//		List<Long> doubleList = new ArrayList<Long>();
//	}

	//第三引数に意味はない
	public static double getDev(List<Long> list,boolean judge,String a,double cutMAX,double cutMIN){
		long allSumple=list.size();
		if ( allSumple < 10 ){
			return getDev(list,judge,a);
		}


		List<Long> doubleListCopy = new ArrayList<Long>();
		List<Long> doubleList = new ArrayList<Long>();

		//昇順に並び替え
		doubleListCopy = list;
		Collections.sort(doubleListCopy);

//		for (int i=0; i< list.size(); i++) {
		for (int i = 0 + (int)Math.round(cutMIN * doubleListCopy.size() ) ; i < doubleListCopy.size() - (int)Math.round(cutMAX * doubleListCopy.size()) ; i++) {
			doubleList.add( doubleListCopy.get(i) );

        }

		return getDev(doubleList,judge,a);

	}
	//judgeがtrueのとき、不偏分散
	//       falseのとき、分散
	//cutMAXに入力した割合だけ上からカットして値を返す。
	//cutMINに入力した割合だけ上からカットして値を返す。
	public static double getDev(List<Double> list,boolean judge,double cutMAX,double cutMIN){
		long allSumple=list.size();
		if ( allSumple < 10 ){
			return getDev(list,judge);
		}

		List<Double> doubleListCopy = new ArrayList<Double>();
		List<Double> doubleList = new ArrayList<Double>();

		//昇順に並び替え
		doubleListCopy = list;
		Collections.sort(doubleListCopy);

//		for (int i=0; i< list.size(); i++) {

		for (int i = 0 + (int)Math.round(cutMIN * doubleListCopy.size() ) ; i < doubleListCopy.size() - (int)Math.round(cutMAX * doubleListCopy.size()) ; i++) {
			doubleList.add( doubleListCopy.get(i) );

        }

//		for (int i=0; i< doubleList.size(); i++) {
//
//			System.out.println(doubleList.get(i));
//        }
		return getDev(doubleList,judge);
	}

	//judgeがtrueのとき、不偏分散をもとに標準偏差
	//       falseのとき、分散をもとに標準偏差
	public static double getDev(List<Double> list,boolean judge){
        double vars = 0;
        double sum = 0;

        for(int i=0; i<list.size(); i++ ) {

        	sum += list.get(i);
//        	System.out.println(list.get(i));
        }

        if(list.size()==0){
        	return 0;
        }

        double ave = ( (double)sum )/list.size();
        for (int i=0; i<list.size(); i++) {
            vars += ((list.get(i) - ave)*(list.get(i) - ave));
        }

        int bunbo=0;
        if(judge){
        	bunbo=list.size() - 1;
        }else{
        	bunbo=list.size();
        }
//        System.out.println("abbbbbbbbbbbbbbaaa" + sum);
        double std = Math.sqrt(vars/bunbo);
        return std;
	}

	//第三引数に意味はない
	public static double getDev(List<Long> list,boolean judge,String a){
        double vars = 0;
        double sum = 0;
        for(int i=0; i<list.size(); i++ ) {
            sum += list.get(i);
        }

        if(list.size()==0){
        	return 0;
        }

        double ave = ( (double)sum )/list.size();
        for (int i=0; i<list.size(); i++) {

            vars += ((list.get(i) - ave)*(list.get(i) - ave));
        }

        int bunbo=0;
        if(judge){
        	bunbo=list.size() - 1;
        }else{
        	bunbo=list.size();
        }

        double std = Math.sqrt(vars/bunbo);
        return std;
	}

	//ArrayList<ArrayList<型名>> list=new ArrayList<ArrayList <型名>>();//二次元配列の生成
	public boolean checkMAX(S s){
		return true;
	}

	//TODAYとMAXDAYを比較して、TODAYがMAX以後ならTRUE、以前ならfalse
	//同日はtrueっぽい
	public boolean checkDay(String TODAY,String MAXDAY){
		//TODAY:0105,MAXDAY:0106→false
		//TODAY:0105,MAXDAY:0105→true
		//TODAY:0105,MAXDAY:0104→true
		if(TODAY.compareTo(MAXDAY)<0){
			return false;
		}

		return true;
	}

	public static String cutBlank(String letter){
		letter = letter.replaceAll(" ", "");
		return letter;
	}

	//yyyy-mm-ddで返す
	public static String getTODAY(){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

//		calendar.set(2006, 0, 14);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return sdf1.format(calendar.getTime());


	}

	//yyyy-mm-ddで返す
	//引数で入力した分だけ過去をかえす。
	//(例)-1；一日前、-2：二日前、1：一日後、2：二日後
	public static String getTODAY(int agoDay){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

//		calendar.set(2006, 0, 14);
		calendar.add(Calendar.DAY_OF_MONTH, agoDay);
		return sdf1.format(calendar.getTime());

	}



	public static void setCodeList(S s){
//		codeList = new ArrayList<String>();
//		codeCateList = new ArrayList<ArrayList<String>>();

//		codeList[] = new String[2];
		codeListwithiCate = new ArrayList<String[]>();
//		codeSingle=null;
		String SQL = " select " + COLUMN_TBL.CODE + "," + COLUMN_TBL.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[2];
				codeSingle[0]=s.rs.getString(COLUMN_TBL.CODE);
				codeSingle[1]=s.rs.getString(COLUMN_TBL.CATE_FLG);

				codeListwithiCate.add(codeSingle);

			}

		} catch (SQLException e) {

		}

	}

	public static void setKeepCodeList(String type,S s){
		codeListwithiCate = new ArrayList<String[]>();
		String SQL = " select " + COLUMN_TBL.CODE + " from " + TBL_Name.KEEPLISTTBL;
		String TBL = TBL_Name.ELETE_LIST_TBL;

		SQL = " select * from " +  TBL +" AAA "
				+ " left outer join " + TBL_Name.KEEPLISTTBL + " BBB "
				+ " on " + "AAA." + COLUMN_TBL.CODE + " = " + "BBB." + COLUMN_TBL.CODE
				+ " where "
				+ "BBB." + COLUMN_TBL.TYPE			+ " = '" + type + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[8];
				String code = s.rs.getString("BBB." + COLUMN_TBL.CODE);
//				String cate = SQLChecker.getCate(code, s);
				//setCodeList（本番）に合わせる
				codeSingle[0]=code;
//				codeSingle[1]=cate;

				codeSingle[2]=s.rs.getString("AAA." + COLUMN_TBL.ENTRYMETHOD);
				codeSingle[3]=s.rs.getString("AAA." + COLUMN_TBL.EXITMETHOD);
				codeSingle[4]=s.rs.getString("AAA." + COLUMN_TBL.MAX_ENTRY_TIME);
				codeSingle[5]=s.rs.getString("AAA." + COLUMN_TBL.MAX_KEEP_TIME);
				codeSingle[6]=s.rs.getString("AAA." + COLUMN_TBL.MAX_INTERVAL);
				codeSingle[7]=s.rs.getString("AAA." + COLUMN_TBL.MAX_LOSS);
				codeListwithiCate.add(codeSingle);
			}

			for ( int i = 0; i < codeListwithiCate.size() ; i++){
//				System.out.println(codeListwithiCate.get(i)[0]);

				codeListwithiCate.get(i)[1]=SQLChecker.getCate(codeListwithiCate.get(i)[0], s);

			}
//			System.out.println("setKeepCodeList:" + codeListwithiCate.size());
		} catch (SQLException e) {

		}

	}

	//true:本番
	//false:test
	public static void setCodeList(String type,String cate,boolean judge,S s){
		codeListwithiCate = new ArrayList<String[]>();
//		codeSingle=null;

		String SQL;
		String TBL;
		if (judge){
			//本番
			TBL = TBL_Name.ELETE_LIST_TBL;
			SQL = " select * from " +  TBL +" AAA "
					+ " left outer join " + TBL_Name.CODELISTTBL + " BBB "
					+ " on "
					+ "AAA." + COLUMN_TBL.CODE + " = " + "BBB." + COLUMN_TBL.CODE
					+ " left outer join " + TBL_Name.INTERVAL_TIME_TBL + " CCC "
					+ " on "
					+ "AAA." + COLUMN_TBL.CODE + " = " + "CCC." + COLUMN_TBL.CODE
					+ " and "
					+ "AAA." + COLUMN_TBL.ENTRYMETHOD + " = " + "CCC." + COLUMN_TBL.ENTRYMETHOD
					+ " and "
					+ "AAA." + COLUMN_TBL.EXITMETHOD + " = " + "CCC." + COLUMN_TBL.EXITMETHOD
					+ " and "
					+ "AAA." + COLUMN_TBL.CODE + " = " + "CCC." + COLUMN_TBL.CODE
					+ " where "
					+ "BBB." + COLUMN_TBL.CATE_FLG	+ " = '" + cate + "'"
					+ " and "
					+ "AAA." + COLUMN_TBL.TYPE			+ " = '" + type + "'"	 	 + "  "
					+ " and "
					+ "CCC." + COLUMN_TBL.MAX_INTERVAL + " is null";
		}else{
			//試験環境
			TBL = TBL_Name.ELETE_LIST_TEST_TBL;
			SQL = " select * from " +  TBL +" AAA "
					+ " left outer join " + TBL_Name.CODELISTTBL + " BBB "
					+ " on " + "AAA." + COLUMN_TBL.CODE + " = " + "BBB." + COLUMN_TBL.CODE
					+ " where "
					+ "BBB." + COLUMN_TBL.CATE_FLG	+ " = '" + cate + "'"	 + " and " //
					+ "AAA." + COLUMN_TBL.TYPE			+ " = '" + type + "'"	 	 + "  " ;

		}



		try {
			System.out.println("setCodeList(String:" + SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				//keepCodeListと揃える
				codeSingle = new String[8];
				codeSingle[0]=s.rs.getString("AAA." + COLUMN_TBL.CODE);
				codeSingle[1]=cate;
				codeSingle[2]=s.rs.getString("AAA." + COLUMN_TBL.ENTRYMETHOD);
				codeSingle[3]=s.rs.getString("AAA." + COLUMN_TBL.EXITMETHOD);
				codeSingle[4]=s.rs.getString("AAA." + COLUMN_TBL.MAX_ENTRY_TIME);
				codeSingle[5]=s.rs.getString("AAA." + COLUMN_TBL.MAX_KEEP_TIME);
				codeSingle[6]=s.rs.getString("AAA." + COLUMN_TBL.MAX_INTERVAL);
				codeSingle[7]=s.rs.getString("AAA." + COLUMN_TBL.MAX_LOSS);
				codeListwithiCate.add(codeSingle);
			}

		} catch (SQLException e) {

		}
	}

	//true:本番
	//false:test
	public static void setCodeList(String L_packageName,String L_className,String L_methodName,String S_packageName,String S_className,String S_methodName,String type,boolean judge,S s){
		String LMETHOD = (L_packageName + "." + L_className + "." + L_methodName);
		String SMETHOD = (S_packageName + "." + S_className + "." + S_methodName);
		codeListwithiCate = new ArrayList<String[]>();
		String TBL;
		if (judge){
			TBL = TBL_Name.ELETE_LIST_TBL;
		}else{
			TBL = TBL_Name.ELETE_LIST_TEST_TBL;
		}

		String SQL;
		SQL = " select * from " +  TBL +" AAA "
				+ " left outer join " + TBL_Name.CODELISTTBL + " BBB "
				+ " on " + "AAA." + COLUMN_TBL.CODE + " = " + "BBB." + COLUMN_TBL.CODE
				+ " where "
				+ "AAA." + COLUMN_TBL.ENTRYMETHOD	+ " = '" + LMETHOD + "'"	 + " and " //
				+ "AAA." + COLUMN_TBL.EXITMETHOD	+ " = '" + SMETHOD + "'"	 + " and  " //
				+ "AAA." + COLUMN_TBL.TYPE			+ " = '" + type + "'"	 	 + "  " ;

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[6];
				codeSingle[0]=s.rs.getString("AAA." + COLUMN_TBL.CODE);
				codeSingle[1]=s.rs.getString("BBB." + COLUMN_TBL.CATE_FLG);
				codeSingle[2]=s.rs.getString("AAA." + COLUMN_TBL.MAX_ENTRY_TIME);
				codeSingle[3]=s.rs.getString("AAA." + COLUMN_TBL.MAX_KEEP_TIME);
				codeSingle[4]=s.rs.getString("AAA." + COLUMN_TBL.MAX_INTERVAL);
				codeSingle[5]=s.rs.getString("AAA." + COLUMN_TBL.MAX_LOSS);
				codeListwithiCate.add(codeSingle);
			}

		} catch (SQLException e) {

		}
	}


	public static void setCodeList(String cate, S s){
//		codeList = new ArrayList<String>();
//		codeCateList = new ArrayList<ArrayList<String>>();
		codeListwithiCate = new ArrayList<String[]>();
//		codeSingle=null;

		String SQL;

		if(cate.equals(ReCord.CODE_99_ALLTYPE)){
			SQL = " select " + COLUMN_TBL.CODE + "," + COLUMN_TBL.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		}else{
			SQL = " select " + COLUMN_TBL.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN_TBL.CATE_FLG + " = '" + cate + "'";
		}




		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[2];
				codeSingle[0]=s.rs.getString(COLUMN_TBL.CODE);
				codeSingle[1]=cate;
				codeListwithiCate.add(codeSingle);
			}

		} catch (SQLException e) {

		}
	}

	public static ArrayList<String[]> getCodeList(){
		return codeListwithiCate;
	}

	//after - before > checksabunのときtrue
	public static boolean checkSabunDay(String TODAY,String lastUpdateDay,int checkSabun){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateTODAY = null;
	    Date dateCheckDay = null;

	    try {
	        dateTODAY = sdf.parse(TODAY);
	        dateCheckDay = sdf.parse(lastUpdateDay);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // 日付をlong値に変換します。
	    long dateTimeTODAY = dateTODAY.getTime();
	    long dateTimeCheckDay = dateCheckDay.getTime();

	    // 差分の日数を算出します。
	    long dayDiff = ( dateTimeTODAY - dateTimeCheckDay  ) / (1000 * 60 * 60 * 24 );



	    if(checkSabun < dayDiff){
	    	return false;
	    }else{
	    	return true;
	    }
	}

	//特定のテーブルから特定の列名に等しい特定の列の値を持ってくる
	public static String getParametaChoseTBL(String TBL,String kensakuRetu,String getColumn,String kensakuWord,S s){
		String returnResult = "";

		String SQL;

		//-を_に変える。DBには_で入っている
		SQL = "select " + getColumn + " from " + TBL + " where " + kensakuRetu + " ='" + kensakuWord + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				returnResult = s.p_rs.getString(getColumn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}




		return returnResult;
	}
//	+第一引数：刈り取り対象文字列（テキスト）
//	+第二引数：刈り取る文字
	public static String stripEnd(String str, String stripChars) {
	    int end;
	    if (str == null || (end = str.length()) == 0) {
	      return str;
	    }
	    if (stripChars == null) {
	      while ((end != 0) && Character.isWhitespace(str.charAt(end - 1))) {
	        end--;
	      }
	    } else if (stripChars.length() == 0) {
	      return str;
	    } else {
	      while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
	        end--;
	      }
	    }
	    return str.substring(0, end);
	  }
}
