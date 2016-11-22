package technique;

import java.sql.SQLException;

import proparty.S;

public class ResultMemory {

	public void entryLogic(){
		String SQL="";

		S s = new S();
		s.getCon();
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				//レコードが存在する場合はここ
				s.sqlGetter().executeUpdate(SQL);
			}else{
				//レコードが存在しない場合はここ
			}

		} catch (SQLException ea) {
			// TODO 自動生成された catch ブロック
			ea.printStackTrace();
		}
		
		s.closeConection();

	}


	public void resultHistoryLogic(){

	}

}
