package technique;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.COLUMN;

public class Technique00_Common {
	//checkPrice_S設定部分
	//勝ち条件
//		paraDTO.setWinWariai(1.05);
	//負け条件
//		paraDTO.setLoseWariai(0.95);
	//judgeがtrueなら勝ちの場合、falseなら負けの場合
	public static int checkPrice_S(Bean_Parameta paraDTO,Bean_nowRecord nowDTO,Bean_Result resultDTO){
		String checkColumn	=	COLUMN.CLOSE;
		S this_s = new S ();
		ResultSet this_rs=null;



		String SQL	=	" select "
				+	checkColumn
				+	" from  "
				+	SQLChecker.getTBL(nowDTO.getCateflg())
				+	" where "
				+	COLUMN.CODE
				+	" = '"	+	nowDTO.getCode()	+	"' "
				+	" and "
				+	COLUMN.DAYTIME
				+	" = '"	+	nowDTO.getNowDay_02()	+	"' ";

		try {
			this_rs = this_s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(this_rs.next()==true){
				Double nowPrice = this_rs.getDouble(checkColumn) ;

				//勝っているとき
				if ( nowPrice >= nowDTO.getNowCLOSE_01() * paraDTO.getWinWariai()){
					this_rs.close();
					return Technique98_CONST.WIN_FLG;
				}

				//負けたとき
				if ( nowPrice <= nowDTO.getNowCLOSE_01() * paraDTO.getLoseWariai()){
					this_rs.close();
					return Technique98_CONST.LOSE_FLG;
				}

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return Technique98_CONST.NO_GAME;
	}
	//judgeがtrueなら勝ちの場合、falseなら負けの場合
	public static int checkPrice_S(String code,String cate,String dayTime,double buyPrice,double winWariai,double loseWariai, S s){
		String checkColumn	=	COLUMN.CLOSE;


		String SQL	=	" select "
					+	checkColumn
					+	" from  "
					+	SQLChecker.getTBL(cate)
					+	" where "
					+	COLUMN.CODE
					+	" = '"	+	code	+	"' "
					+	" and "
					+	COLUMN.DAYTIME
					+	" = '"	+	dayTime	+	"' ";

		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			//trueならレコードが存在する。
			if(s.rs.next()==true){
				Double nowPrice = s.rs.getDouble(checkColumn) ;

				//勝っているとき
				if ( nowPrice >= buyPrice * winWariai){
					s.rs.close();
					return Technique98_CONST.WIN_FLG;
				}

				//負けたとき
				if ( nowPrice <= buyPrice * loseWariai){
					s.rs.close();
					return Technique98_CONST.LOSE_FLG;
				}

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return Technique98_CONST.NO_GAME;
	}
}
