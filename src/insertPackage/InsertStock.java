package insertPackage;

import java.sql.SQLException;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_TBLRecord;
//主に株券をインサートする
//頭文字がCならまとめてインポート、Sなら単発
//日足、月足、５分足、時間足、週足
public class InsertStock extends InsertSuper {
	String SQL;
	S s = new S();

	//引数：method名、beanList,TBL名を入れる
	//beanList内のデータをmethodで全てstockTBLにインサートする。
	//ただし、先頭語は必ずc_Iであること
	//使用後はP_createClose()
	public void c_Controller(String methodName,List<Bean_TBLRecord> beanList ,String stock,S s){

		superTBLRecord("InsertStock",methodName,beanList,stock,s);
	}

	public void c_InsertStock_DD(List<Bean_TBLRecord> B_T_List,String stock,S s){
		int Num = B_T_List.size();
		if(Num == 0){
//			System.out.println(stock + "は今日はゼロ！");
			return;
		}
//		SQL = "insert into " + stock + TBL_Name.TAIL_DAY + " (dayTime,open,max,min,close,ajust_open,ajust_max,ajust_min,ajust_close,DEKI,BAYBAY,ajust_DEKI) values " + Insert_Pstmt.insertFooder(12,Num);
//		s.setPstmt(SQL);
//		System.out.println("追加レコード:" + B_T_List.get(0).getDay());
//		for (int i = 0;i<Num;i++){
//			try {
//				s.getPstmt().setString(i*11 + 1, B_T_List.get(i).getDay()    );
//				s.getPstmt().setString(i*11 + 2, B_T_List.get(i).getOpen()   );
//				s.getPstmt().setString(i*11 + 3, B_T_List.get(i).getMax()    );
//				s.getPstmt().setString(i*11 + 4, B_T_List.get(i).getMin()    );
//				s.getPstmt().setString(i*11 + 5, B_T_List.get(i).getClose()  );
//				s.getPstmt().setString(i*11 + 6, B_T_List.get(i).getOpen()   );
//				s.getPstmt().setString(i*11 + 7, B_T_List.get(i).getMax()    );
//				s.getPstmt().setString(i*11 + 8, B_T_List.get(i).getMin()    );
//				s.getPstmt().setString(i*11 + 9, B_T_List.get(i).getClose()  );
//				s.getPstmt().setString(i*11 +10, B_T_List.get(i).getDeki()   );
//				s.getPstmt().setString(i*11 +11, B_T_List.get(i).getBayBay() );
//				s.getPstmt().setString(i*11 +12, B_T_List.get(i).getDeki()   );
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//				System.out.println(stock + "でなんかエラー化も");
//			}
//		}
//
//
//		try {
//			s.getPstmt().executeUpdate();
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			c_Controller("s_InsertStock_DD",B_T_List,stock,s);
//
//		}finally{
//
//		}
		c_Controller("s_InsertStock_DD",B_T_List,stock,s);

	}


//	使用後はP_createClose()
	public void s_InsertStock_DD(Bean_TBLRecord DTO,String stock,S s){

		SQL = "insert into " + stock + TBL_Name.TAIL_DAY + " (dayTime,open,max,min,close,ajust_open,ajust_max,ajust_min,ajust_close,DEKI,BAYBAY,ajust_DEKI) value (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			s.setPstmt(SQL);
			s.getPstmt().setString( 1, DTO.getDay());
			s.getPstmt().setString( 2, DTO.getOpen());
			s.getPstmt().setString( 3, DTO.getMax());
			s.getPstmt().setString( 4, DTO.getMin());
			s.getPstmt().setString( 5, DTO.getClose());
			s.getPstmt().setString( 6, DTO.getOpen());
			s.getPstmt().setString( 7, DTO.getMax());
			s.getPstmt().setString( 8, DTO.getMin());
			s.getPstmt().setString( 9, DTO.getClose());
			s.getPstmt().setString(10, DTO.getDeki());
			s.getPstmt().setString(11, DTO.getBayBay());
			s.getPstmt().setString(12, DTO.getDeki());

			s.getPstmt().executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			
		      //Duplicate entry 以外のエラーが出たとき
		      if(e.getErrorCode()!=1062){
		    	  e.printStackTrace();
		    	  System.out.println(SQL);
		      }
			System.out.println("重複");
		}
	}

	public void c_InsertStock_WW(){

	}

	public void s_InsertStock_WW(){

	}

	public void c_InsertStock_Month(){

	}

	public void s_InsertStock_Month(){

	}

	public void c_InsertStock_Minute(){

	}

	public void s_InsertStock_Minute(){

	}

	public void c_InsertStock_HH(){

	}

	public void s_InsertStock_HH(){

	}
}
