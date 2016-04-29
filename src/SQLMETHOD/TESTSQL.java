package SQLMETHOD;
import java.sql.SQLException;

import proparty.S;
import GAMEN.TAB_test;

public class TESTSQL {


//	static Connection con = null;
//	static ResultSet rs = null;
//	static Statement stmt = null;
	public void testSQL(String SQL){



		try {



			// ３．SQL ステートメント・オブジェクトの作成

			// ４．SQL ステートメントの発行
			//ここにSQL文を書いている。

			S.rs = S.sqlGetter().executeQuery("select * from 9999_dd");

			// ５．結果の出力

			while (S.rs.next()) {

				TAB_test.textArea_SQLresult.append(S.rs.getString("owari")  +  "_"+ S.rs.getString("deki") + "\n");
//				TAB_test.textArea_SQLresult.append(rs.getString("yomi"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getString("yomi"));


			}
			// ６．データベースのクローズ
			S.closeConection();

		} catch (SQLException e1) {
			System.out.println(
					"SQLException: " + e1.getMessage());
			System.out.println(
					"    SQLState: " + e1.getSQLState());
			System.out.println(
					" VendorError: " + e1.getErrorCode());
		}catch (Exception e2) {
			System.out.println(
					"Exception: " + e2.getMessage());
		}

	}
}