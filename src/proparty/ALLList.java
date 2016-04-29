package proparty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Bean_CodeList;

import common.commonAP;

import constant.COLUMN;

public class ALLList {
	static String SQL;
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();
	private List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
	private static List<String> ALLCODE = new ArrayList<String>();

	//コードを入れるとそのコードのカテゴリを返す
	static public String getCateFlg(String code,S s){


		SQL = "select " + COLUMN.CATE_FLG + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " = '" + code + "'"				;

		String cateflg= "0";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {

				cateflg = (s.rs.getString(commonAP.cutBlank(COLUMN.CATE_FLG)));

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return cateflg;
	}

	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	static public void setListCode(S s){
		ALLCODE = new ArrayList<String>();
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL;


		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {

				ALLCODE.add(s.rs.getString(commonAP.cutBlank(COLUMN.CODE)));

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}


	static public void setListCode(String cate,S s){


		ALLCODE = new ArrayList<String>();
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '" + cate + "'";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {

				ALLCODE.add(s.rs.getString(commonAP.cutBlank(COLUMN.CODE)));

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


	static public List<String> getListCode(S s){
		return ALLCODE;
	}
}
