package common;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN;
import constant.ReCord;

public class commonAP {

//	static ArrayList<String> codeList = new ArrayList<String>();
//	static ArrayList<ArrayList<String>> codeCateList = new ArrayList<ArrayList<String>>();

	static String codeSingle[] = new String[2];
	static ArrayList<String[]> codeListwithiCate = new ArrayList<String[]>();
//	static List<String[]> codeListwithiCate = new ArrayList<String>();

	//ArrayList<ArrayList<型名>> list=new ArrayList<ArrayList <型名>>();//二次元配列の生成
	public boolean checkMAX(S s){
		return true;
	}

	//TODAYとMAXDAYを比較して、TODAYがMAX以後ならTRUE、以前ならfalse
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
