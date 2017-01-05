package sql;

import java.sql.SQLException;

import proparty.S;
import proparty.TBL_Name;

public class createDB {
	public static void CreateDB(S s){
		//DBあるなしチェックをやったほうがいい
		try {
			s.sqlGetter().executeUpdate("drop DATABASE " + TBL_Name.KABU_DB);

		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}finally{
			try {

				s.sqlGetter().executeUpdate("CREATE DATABASE " + TBL_Name.KABU_DB);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println(e.getErrorCode());
			}

		}
	}
}
