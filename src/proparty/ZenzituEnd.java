package proparty;

import java.sql.SQLException;

import accesarrySQL.SQLChecker;
import constant.COLUMN;
import constant.ReCord;

public class ZenzituEnd {

	public static String getZenzituClose(String Code,String cate,S s){
		String price = "0";
		String SQL;

		String column = COLUMN.CLOSE;
		if (cate.equals(ReCord.CODE_01_STOCK)){
			column = COLUMN.BEFORE_CLOSE;
		}

		SQL = "select "
			+ column
			+ " from " + SQLChecker.getTBL(cate)
			+ " where "		   + COLUMN.CODE + " = '" + Code + "'"
			+ " order by "	   + COLUMN.DAYTIME
			+ " desc "
			+ " limit 1";
		
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			s.rs.next();
			price = (s.rs.getString((column)));

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

		}


		return price;
	}

}
