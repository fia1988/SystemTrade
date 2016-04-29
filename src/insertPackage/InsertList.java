package insertPackage;

import java.sql.SQLException;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;
import constant.COLUMN;
import constant.ReCord;

public class InsertList {
	String SQL;


	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	//リストをインサートする。
	public void InsertList_Day(List<Bean_CodeList> DTO , S s){
		for(int i = 0;i<DTO.size();i++){
			switch(DTO.get(i).getCateflg()){
			case ReCord.CODE_01_STOCK:
				InsertList_case1(DTO.get(i),s);
				break;
			case ReCord.CODE_02_SATISTICS:
				InsertList_case2(DTO.get(i),s);
				break;
			case ReCord.CODE_03_INDEX:
				InsertList_case3(DTO.get(i),s);
				break;
			case ReCord.CODE_04_ETF:

				InsertList_case4(DTO.get(i),s);
				break;
			case ReCord.CODE_05_SAKIMONO:
				InsertList_case5(DTO.get(i),s);
				break;
			case ReCord.CODE_06_CURRENCY:
				InsertList_case6(DTO.get(i),s);
				break;
			default:
				System.out.println("なんかよくわからないの来た：" + DTO.get(i).getCode() + ":" + DTO.get(i).getCodeName());
				break;
			}

		}
	}


	//個別銘柄・・・1
	private void InsertList_case1(Bean_CodeList DTO , S s){
		SQL = "insert into "
				+ TBL_Name.CODELISTTBL
				+ " ("
				+ COLUMN.CODE + " , "
				+ COLUMN.CODENAME + " , "
				+ COLUMN.MARKET + " , "
				+ COLUMN.CATEGORY + " , "
				+ COLUMN.CATE_FLG
				+ " ) "
				+ "values (?,?,?,?,?)";

		s.setPstmt(SQL);

		SQL = "insert into "
				+ TBL_Name.CODELISTTBL
				+ " ("
				+ COLUMN.CODE + " , "
				+ COLUMN.CODENAME + " , "
				+ COLUMN.MARKET + " , "
				+ COLUMN.CATEGORY + " , "
				+ COLUMN.CATE_FLG
				+ " ) "
				+ "values (?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			s.getPstmt().setString(  1,  DTO.getCode()			);
			s.getPstmt().setString(  2,  DTO.getCodeName()		);
			s.getPstmt().setString(  3,  DTO.getMarket()		);
			s.getPstmt().setString(  4,  DTO.getCategory()		);
			s.getPstmt().setString(  5,  DTO.getCateflg()		);
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理

			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
				//								e.printStackTrace();
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName());
			}
		}
	}

	//統計・・・2
	private void InsertList_case2(Bean_CodeList DTO , S s){

		SQL = "insert into "
				+ TBL_Name.CODELISTTBL
				+ " ("
				+ COLUMN.CODE + " , "
				+ COLUMN.CODENAME + " , "
				+ COLUMN.CATE_FLG
				+ " ) "
				+ "values (?,?,?)";

		s.setPstmt(SQL);

		try {
			s.getPstmt().setString(  1,  DTO.getCode()					      );
			s.getPstmt().setString(  2,  DTO.getCodeName()                    );
			s.getPstmt().setString(  3,  DTO.getCateflg()                     );
			s.getPstmt().executeUpdate();
		} catch (SQLException e) {
			// TODO ミスった時の処理
			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
												e.printStackTrace();
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName() + ":" + DTO.getCateflg());
			}
		}

	}

	//指数・・・3
	private void InsertList_case3(Bean_CodeList DTO , S s){
		SQL = "insert into "
				+ TBL_Name.CODELISTTBL
				+ " ("
				+ COLUMN.CODE + " , "
				+ COLUMN.CODENAME + " , "
				+ COLUMN.MARKET + " , "
				+ COLUMN.CATEGORY + " , "
				+ COLUMN.CATE_FLG
				+ " ) "
				+ "values (?,?,?,?,?)";

		s.setPstmt(SQL);


		try {

			//もしも指数ならテーブル名とコード(ﾃｨｯｶｰｼﾝﾎﾞﾙ)を同じにする。

			s.getPstmt().setString(  1,  DTO.getCode()					  );
			s.getPstmt().setString(  2,  DTO.getCodeName()                     );
			s.getPstmt().setString(  3,  DTO.getMarket()                       );
			s.getPstmt().setString(  4,  DTO.getCategory()                     );
			s.getPstmt().setString(  5,  DTO.getCateflg()                      );

			s.getPstmt().executeUpdate();
		} catch (SQLException e) {
			// TODO ミスった時の処理

			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
				//								e.printStackTrace();
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName());
			}
		}


	}

	//ETF・・・4
	private void InsertList_case4(Bean_CodeList DTO , S s){

		SQL = "insert into "
				+ TBL_Name.CODELISTTBL
				+ " ("
				+ COLUMN.CODE + " , "
				+ COLUMN.CODENAME + " , "
				+ COLUMN.MARKET + " , "
				+ COLUMN.CATEGORY + " , "
				+ COLUMN.CATE_FLG
				+ " ) "
				+ "values (?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			s.getPstmt().setString(  1,  DTO.getCode()					      );
			s.getPstmt().setString(  2,  DTO.getCodeName()                     );
			s.getPstmt().setString(  3,  DTO.getMarket()                       );
			s.getPstmt().setString(  4,  DTO.getCategory()                     );
			s.getPstmt().setString(  5,  DTO.getCateflg()                      );
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理

			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
				//								e.printStackTrace();
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName());
			}
		}

	}

	//先物・・・5
	private void InsertList_case5(Bean_CodeList DTO , S s){

	}

	//通貨・・・6
	private void InsertList_case6(Bean_CodeList DTO , S s){

	}

}
