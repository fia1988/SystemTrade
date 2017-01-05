package proparty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constant.ReturnCodeConst;

public class S {
	public static Connection con = null;
	public static ResultSet rs = null;
	public static ResultSet rs2 = null;
	public static ResultSet rs3 = null;
	public static ResultSet rs_EDIT = null;
	public static ResultSet rs_IDOHEIKIN_2 = null;
	public static ResultSet rs_MACD = null;
	public static ResultSet rs_MACD_SIGNAL = null;
	public static ResultSet p_rs = null;
	public static Statement stmt = null;
	public static Statement cstmt = null;
	public static PreparedStatement pstmt = null;


//	public S(){
//		try {
//			con = DriverManager.getConnection(
//				    "jdbc:mysql://localhost/kabudata", PROPARTY.DBUSER, PROPARTY.DBPASS);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//	}

	//conだけを再接続する。大量にSQLを発行するときに、たまに使う。
	public void reCon(){
		try {
			con.close();
			getCon();
		} catch (Exception e) {
		}

	}
	//conを再接続する。大量にSQLを発行するときに、たまに使う。
	public void resetConnection(){
		closeConection();
		getCon();
	}

	public int getCon(){
		try {
			con = DriverManager.getConnection(
				    "jdbc:mysql://localhost/"  + TBL_Name.KABU_DB, PROPARTY.DBUSER, PROPARTY.DBPASS);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			if (e.getErrorCode()==ReturnCodeConst.SQL_ERR_1045){
				return e.getErrorCode();
			}else{
				e.printStackTrace();
				return e.getErrorCode();
			}

		}

		return ReturnCodeConst.SQL_ERR_0;
	}


	//pstmtを作る。
	//使用後はP_createClose()
	public void setPstmt(String SQL){
		try {
			pstmt = con.prepareStatement(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public PreparedStatement getPstmt(){
		return pstmt;

	}

	//sql文を入力するとSQLを実行できる。使い方は以下
	//		ResultSet S.p_rs = S.freeQuery("select * from 9999_dd");
	//			while (S.p_rs.next()) {
	//		}
	//使い回し可能。
	//ただし適当なタイミングでS.P_freeQueryClose()すべし。
	public static ResultSet freeQuery(String sql){
		try {

			pstmt = con.prepareStatement(sql);

			p_rs = pstmt.executeQuery();

			return p_rs;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
		}
		return p_rs;
	}

	//sql文を入力するとSQLを実行できる。
	//使い回し可能。
	//ただし適当なタイミングでS.P_createclose()すべし。
	public static int freeUpdateQuery(String sql){
		try {

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック


//			System.out.println("S:普通のテーブル重複");
			//同じテーブルが存在した以外のエラーの場合以下を処理する。
			//1062エラーも一応出す
			switch (e.getErrorCode()) {
				case ReturnCodeConst.SQL_ERR_1062:
					return e.getErrorCode();

				case ReturnCodeConst.SQL_ERR_1050:
					return e.getErrorCode();

				default:
					System.out.println(sql);
					System.out.println(e.getErrorCode());
					return e.getErrorCode();
			}





		}

		return ReturnCodeConst.SQL_ERR_0;
	}

	//ファイルをエクスポートするときに使う。
	//使用例：s.exportFile(SQL)
	public int exportFile(String SQL){
		try {
			stmt = con.createStatement();

			stmt.executeQuery(SQL);


		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック


			switch (e.getErrorCode()) {
			case ReturnCodeConst.SQL_ERR_1086:
				//ファイルが既に存在する
				return e.getErrorCode();
			case ReturnCodeConst.SQL_ERR_1:
				//ディレクトリが存在しない
				return e.getErrorCode();

			default:
				//そのほかのエラー
				e.printStackTrace();
				return e.getErrorCode();
			}


		}



		return ReturnCodeConst.SQL_ERR_0;
	}

	//使うときはこんな感じ
//	S.sqlGetter().executeUpdate("CREATE DATABASE db_User");
//	S.rs = S.sqlGetter().executeQuery("select * from 9999_dd");
//	while (S.rs.next()) {
//	}
//	S.DBClose();
	public static Statement sqlGetter(){

		try {

			// ３．SQL ステートメント・オブジェクトの作成
			stmt = con.createStatement();

			return stmt;

			} catch (SQLException e1) {
				System.out.println(
					"SQLException: " + e1.getMessage());
				System.out.println(
					"    SQLState: " + e1.getSQLState());
				System.out.println(
					" VendorError: " + e1.getErrorCode());

			} catch (Exception e2) {
				System.out.println(
					"Exception: " + e2.getMessage());
			}
		return stmt;
	}


	//使うときはこんな感じ
//	S.sqlEditer().executeUpdate("CREATE DATABASE db_User");
//	S.rs = S.sqlEditer().executeQuery("select * from 9999_dd");
//	while (S.rs.next()) {
	//	s.rs.updateDouble("列名",100 );
	//
	//	s.rs.updateRow();
//	}
//	S.DBClose();
	public static Statement sqlEditer(){

		try {

			// ３．SQL ステートメント・オブジェクトの作成
			cstmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);

			return cstmt;

			} catch (SQLException e1) {
				System.out.println(
					"SQLException: " + e1.getMessage());
				System.out.println(
					"    SQLState: " + e1.getSQLState());
				System.out.println(
					" VendorError: " + e1.getErrorCode());
			} catch (Exception e2) {
				System.out.println(
					"Exception: " + e2.getMessage());
			}
		return cstmt;
	}


	public static void closeConection(){
		try {
			rs.close();
		} catch (Exception e) {
		}

		try {
			rs2.close();
		} catch (Exception e) {
		}

		try {
			rs3.close();
		} catch (Exception e) {
		}

		try {
			pstmt.close();
		} catch (Exception e) {
		}

		try {
			cstmt.close();
		} catch (Exception e) {
		}

		try {
			con.close();
		} catch (Exception e) {
		}

		try {
			stmt.close();
		} catch (Exception e) {
		}

		try {
			p_rs.close();
		} catch (Exception e) {
		}

		try {
			rs_EDIT.close();
		} catch (Exception e) {
		}

//		try {
//			rs_IDOHEIKIN_1.close();
//		} catch (SQLException e) {
//		}
//
//		try {
//			rs_IDOHEIKIN_2.close();
//		} catch (SQLException e) {
//		}
//
//		try {
//			rs_MACD.close();
//		} catch (SQLException e) {
//		}
//
//		try {
//			rs_MACD_SIGNAL.close();
//		} catch (SQLException e) {
//		}

	}










}
