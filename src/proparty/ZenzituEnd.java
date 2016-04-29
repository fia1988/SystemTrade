package proparty;

import java.sql.SQLException;

import constant.COLUMN;

public class ZenzituEnd {

	public static String getZenzituClose_Stock(String Code,S s){
		String price = "0";
		String SQL;

		SQL = "select "
			+ COLUMN.BEFORE_CLOSE
			+ " from " + TBL_Name.STOCK_DD
			+ " where "		   + COLUMN.CODE + " = '" + Code + "'"
			+ " order by "	   + COLUMN.DAYTIME
			+ " desc "
			+ " limit 1";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			s.rs.next();
			price = (s.rs.getString((COLUMN.BEFORE_CLOSE)));

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

		}


		return price;
	}

}
