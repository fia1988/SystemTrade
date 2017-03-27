package insertPackage;

import java.sql.SQLException;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;

public class InsertCodeList extends InsertSuper  {
//	頭文字がCならまとめてインポート、Sなら単発
	String SQL;
	S s = new S();

	public void c_Controller(String methodName,List<Bean_CodeList> beanList ,S s){
		superCODEList("InsertCodeList",methodName,beanList,s);
	}

	public void c_InsertStockList(List<Bean_CodeList> B_C_List,S s){
//		int Num = B_C_List.size();
//		if (Num == 0){
//			return;
//		}
//
//		SQL = "insert into " + TBL_Name.CODELISTTBL + " (code,codeName,market,category,company_flg,etf_flg,statistical_flg,index_flg,future_flg,currency_flg) values " + Insert_Pstmt.insertFooder(10,Num);
//
//		s.setPstmt(SQL);
//		for (int i = 0;i<Num;i++){
//
//			try {
//				System.out.println(B_C_List.get(i).getCode().replaceAll("-","_"));
//				s.getPstmt().setString( i*6+  1, (B_C_List.get(i).getCode()).replaceAll("-","_")    );
//				s.getPstmt().setString( i*6+  2,  B_C_List.get(i).getCodeName()                      );
//				s.getPstmt().setString( i*6+  3,  B_C_List.get(i).getMarket()                        );
//				s.getPstmt().setString( i*6+  4,  B_C_List.get(i).getCategory()                      );
//				s.getPstmt().setString( i*6+  5,  B_C_List.get(i).getCompany_flg()                   );
//				s.getPstmt().setString( i*6+  6,  B_C_List.get(i).getEtf_flg()                       );
//				s.getPstmt().setString( i*6+  7,  B_C_List.get(i).getStatistical_flg()               );
//				s.getPstmt().setString( i*6+  8,  B_C_List.get(i).getIndex_flg()                     );
//				s.getPstmt().setString( i*6+  9,  B_C_List.get(i).getFuture_flg()                    );
//				s.getPstmt().setString( i*6+ 10,  B_C_List.get(i).getCurrency_flg()                  );
//
//
//
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
////				System.out.println("いっぱい");
////				e.printStackTrace();
//			}
//		}
//
//		try {
//			s.getPstmt().executeUpdate();
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
////						c_Controller("s_InsertClassList",B_C_List,s);
//
////			e.printStackTrace();
//		}finally{
//
//		}
		c_Controller("s_InsertClassList",B_C_List,s);
	}

	public void s_InsertClassList(Bean_CodeList B_C,S s){

		SQL = "insert into " + TBL_Name.CODELISTTBL + " (code,codeName,market,category,company_flg,etf_flg,statistical_flg,index_flg,future_flg,currency_flg) values (?,?,?,?,?,?,?,?,?,?)";

		s.setPstmt(SQL);

				try {
//					s.getPstmt().setString(  1, (B_C.getCode()).replaceAll("-","_")   );
//					s.getPstmt().setString(  2,  B_C.getCodeName()                     );
//					s.getPstmt().setString(  3,  B_C.getMarket()                       );
//					s.getPstmt().setString(  4,  B_C.getCategory()                     );
//					s.getPstmt().setString(  5,  B_C.getCompany_flg()                  );
//					s.getPstmt().setString(  6,  B_C.getEtf_flg()                      );
//					s.getPstmt().setString(  7,  B_C.getStatistical_flg()              );
//					s.getPstmt().setString(  8,  B_C.getIndex_flg()                    );
//					s.getPstmt().setString(  9,  B_C.getFuture_flg()                   );
//					s.getPstmt().setString( 10,  B_C.getCurrency_flg()                 );

					s.getPstmt().executeUpdate();
				} catch (SQLException e) {
					// TODO ミスった時の処理

//					テーブル重複時の処理
					if(e.getErrorCode()!=1062){
						e.printStackTrace();
						System.out.println("ミスったのは：" + B_C.getCode() + ":" + B_C.getCodeName());
					}


				}
	}
}
