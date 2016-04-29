package sql;

import java.sql.SQLException;

import proparty.S;

public class createDB {
	public static void CreateDB(S s){
		//DBあるなしチェックをやったほうがいい
		try {
			s.sqlGetter().executeUpdate("drop DATABASE kabudata");

		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}finally{
			try {

				s.sqlGetter().executeUpdate("CREATE DATABASE kabudata");

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println(e.getErrorCode());
			}

		}
	}
}
