package accesarrySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import constant.COLUMN;

public class Super_IDO_HEKIN {


	public static void setIDOHeikin_base(String code,String TBL,String dayTime,int term,String updateColomn,String targetColomn,S s){
		String SQL;

		//ここでテーブル指定
		SQL = "select " + COLUMN.DAYTIME
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit " + ( term - 1 ) + "," + 1;

		try {

			s.rs = s.sqlGetter().executeQuery(SQL);

			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
				String start = s.rs.getString((COLUMN.DAYTIME)) ;

				SQL = "select "
						+ " avg(" + targetColomn +  ") from "
						+ TBL
						+ " where "
						+ COLUMN.CODE
						+ " ='" + code + "'"
						+ " and "
						+ COLUMN.DAYTIME
						+ " between "
						+ "'" + start + "'"
						+ " and "
						+ "'" + dayTime + "'";

				s.rs = s.sqlGetter().executeQuery(SQL);

				if(s.rs.next()==true){
//					double num = s.rs.getDouble("avg(" + targetColomn +  ")") ;

					//ここから更新

					SQL = " update "
						+ TBL
						+ " set "
						+ updateColomn + " = " + s.rs.getDouble("avg(" + targetColomn +  ")")
						+ " where "
						+ COLUMN.DAYTIME
						+ " = '" + dayTime + "'"
						+ " and "
						+ COLUMN.CODE
						+ " ='" + code + "'";

//						long	art = System.currentTimeMillis();
					s.sqlGetter().executeUpdate(SQL);
//						long	stop = System.currentTimeMillis();
//						System.out.println(SQL);
//						System.out.println((stop - art) + " 秒です。");

				}

			}


		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
//			if(ea.getErrorCode()==1054){
//
//			}else{
				ea.printStackTrace();
				System.out.println(code + ":" + dayTime);
//			}
		}

	}



	public static void setIDOHeikin_base(String code,String TBL,String dayTime,int term,String updateColomn,String targetColomn,S s,ResultSet EDIT){
		String SQL;

		//ここでテーブル指定
		SQL = "select " + COLUMN.DAYTIME
				+ " from "
				+ TBL
				+ " where "
				+ COLUMN.CODE
				+ " ='" + code + "'"
				+ " and "
				+ COLUMN.DAYTIME + " <= '" + dayTime + "'"
				+ " order by "	   + COLUMN.DAYTIME
				+ " desc "
				+ " limit " + ( term - 1 ) + "," + 1;

		try {

			s.rs = s.sqlGetter().executeQuery(SQL);

			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//				もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。
				String start = s.rs.getString((COLUMN.DAYTIME)) ;

				SQL = "select "
						+ " avg(" + targetColomn +  ") from "
						+ TBL
						+ " where "
						+ COLUMN.CODE
						+ " ='" + code + "'"
						+ " and "
						+ COLUMN.DAYTIME
						+ " between "
						+ "'" + start + "'"
						+ " and "
						+ "'" + dayTime + "'";

				s.rs = s.sqlGetter().executeQuery(SQL);

				if(s.rs.next()==true){
//					double num = s.rs.getDouble("avg(" + targetColomn +  ")") ;

					//ここから更新

//					SQL = " update "
//						+ TBL
//						+ " set "
//						+ updateColomn + " = " + s.rs.getDouble("avg(" + targetColomn +  ")")
//						+ " where "
//						+ COLUMN.DAYTIME
//						+ " = '" + dayTime + "'"
//						+ " and "
//						+ COLUMN.CODE
//						+ " ='" + code + "'";

					EDIT.updateDouble(updateColomn,s.rs.getDouble("avg(" + targetColomn +  ")"));
//						long	art = System.currentTimeMillis();
//					s.sqlGetter().executeUpdate(SQL);
//						long	stop = System.currentTimeMillis();
//						System.out.println(SQL);
//						System.out.println((stop - art) + " 秒です。");

				}

			}


		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
//			if(ea.getErrorCode()==1054){
//
//			}else{
				ea.printStackTrace();
				System.out.println(code + ":" + dayTime);
//			}
		}

	}
}
