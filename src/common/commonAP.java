package common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import proparty.PROPARTY;
import proparty.S;
import proparty.TBL_Name;
import accesarrySQL.SQLChecker;
import constant.COLUMN;
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
		String SQL = " select " + COLUMN.DAYTIME + " from " + TBL_Name.INDEX_DD
				+" where "
				+ COLUMN.CODE + " = 'I101'"
				+ " and "
				+ COLUMN.DAYTIME + " <= '" + end + "'"
				+ " order by " + COLUMN.DAYTIME + " desc limit " + count;
		String startDay = "";
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				startDay=s.rs.getString(COLUMN.DAYTIME);

			}

		} catch (SQLException e) {
			System.out.println("getStartDayでエラー。スタックトレース:" + SQL);
			e.getStackTrace();
		}
		return startDay;
	}


	public static int countDay(String start,String end,S s){

		String SQL = " select count(" + COLUMN.DAYTIME + ")"
					+" from " + TBL_Name.INDEX_DD
					+" where "
					+ COLUMN.CODE + " = 'I101'"
					+ " and "
					+ COLUMN.DAYTIME + " <= '" + end + "'"
					+ " and "
					+ COLUMN.DAYTIME + " >= '" + start + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			s.rs.next();

			return s.rs.getInt(	"count(" + COLUMN.DAYTIME + ")"	);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return 0;

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


		String fileName = "sys.log";
		switch (writeType) {
			case logWriting.DATEDATE_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			case logWriting.STOCK_RESULT_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			case logWriting.BACKTEST_LOG_FLG:
				fileName = "backtestLog.log";
				break;
			case logWriting.ANOTHER_RROR_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			default:
			break;
		}


		String logFileFolderPath = PROPARTY.LOG_FILE_OUT;
		File file = new File(logFileFolderPath + File.separator + fileName);
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

			FileWriter filewriter = new FileWriter(file,true);
			filewriter.write(nowTime + " " + writing + ":" + writeType  + "\r\n");
			filewriter.close();
		}catch(IOException e){
			System.out.println(e);
		}

		System.out.println(nowTime + writeType + ":" + writing);
	}

	public static void writeLog(String writing,int writeType){


		String fileName = "sys.log";
		switch (writeType) {
			case logWriting.DATEDATE_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			case logWriting.STOCK_RESULT_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			case logWriting.BACKTEST_LOG_FLG:
				fileName = "backtestLog.log";
				break;
			case logWriting.ANOTHER_RROR_LOG_FLG:
				fileName = "sys_" + logWriting.DATEDATE_LOG_FLG + ".log";
				break;
			default:
			break;
		}


		String logFileFolderPath = PROPARTY.LOG_FILE_OUT;
		File file = new File(logFileFolderPath + File.separator + fileName);
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

			FileWriter filewriter = new FileWriter(file,true);
			filewriter.write("：" + writing + ":" + writeType  + "");
			filewriter.close();
		}catch(IOException e){
			System.out.println(e);
		}

		System.out.print(writeType + ":" + writing);
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

	//judgeがtrueのとき、不偏分散
	//       falseのとき、分散
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
		String SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[2];
				codeSingle[0]=s.rs.getString(COLUMN.CODE);
				codeSingle[1]=s.rs.getString(COLUMN.CATE_FLG);

				codeListwithiCate.add(codeSingle);

			}

		} catch (SQLException e) {

		}

	}

	public static void setKeepCodeList(S s){
		codeListwithiCate = new ArrayList<String[]>();
		String SQL = " select " + COLUMN.CODE + " from " + TBL_Name.KEEPLISTTBL;


		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[2];
				String code = s.rs.getString(COLUMN.CODE);
//				String cate = SQLChecker.getCate(code, s);
				codeSingle[0]=code;
//				codeSingle[1]=cate;
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

	public static void setCodeList(String cate, S s){
//		codeList = new ArrayList<String>();
//		codeCateList = new ArrayList<ArrayList<String>>();
		codeListwithiCate = new ArrayList<String[]>();
//		codeSingle=null;

		String SQL;

		if(cate.equals(ReCord.CODE_99_ALLTYPE)){
			SQL = " select " + COLUMN.CODE + "," + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL;
		}else{
			SQL = " select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '" + cate + "'";
		}




		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSingle = new String[2];
				codeSingle[0]=s.rs.getString(COLUMN.CODE);
				codeSingle[1]=cate;
				codeListwithiCate.add(codeSingle);
			}

		} catch (SQLException e) {

		}
	}

	public static ArrayList<String[]> getCodeList(){
		return codeListwithiCate;
	}


}
