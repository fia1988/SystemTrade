package accesarrySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import proparty.S;
import proparty.TBL_Name;

import common.commonAP;

import constant.COLUMN;

public class SEPARATE_CHECK {
	static String codeSeparate[] = new String[3];
	static ArrayList<String[]> codeSeparateList = new ArrayList<String[]>();
	public static void checkSEPARATE(S s){

	}

	public static void setSeparateList(S s){
		codeSeparateList = new ArrayList<String[]>();

		String SQL = " select " + COLUMN.CODE
					+ " from "
					+ TBL_Name.SEPARATE_DD
					+ " where "
					+ COLUMN.DAYTIME + " <= '" + commonAP.getTODAY() + "'"
					+ COLUMN.SEPA_FLG + " is not null";
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while ( s.rs.next() ) {
				codeSeparate = new String[2];
				codeSeparate[0]=s.rs.getString(COLUMN.CODE);
//				codeSeparate[1]=cate;
				codeSeparateList.add(codeSeparate);
			}

		} catch (SQLException e) {

		}

	}

	public static ArrayList<String[]> getSeparateList(){
		return codeSeparateList;
	}
}
