package technique;

import java.util.List;

import bean.Bean_Parameta;
import bean.Bean_Result;
import bean.Bean_nowRecord;
import constant.ReCord;

public class Technique05 {
	//ボリンジャーバンド
	public static int checkBori_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		
		Bean_nowRecord nowDTO = nowDTOList.get(nowDTOadress);
		if (nowDTO.getCateflg_01().equals(ReCord.CODE_02_SATISTICS)){return Technique98_CONST.NO_GAME;}
		if(paraDTO.getCheckBori_checkBORI()==0){return Technique98_CONST.NO_GAME;}

		
//;
//		Double checkLimitBreak		=	nowDTO.getNowLONG_3_H_SIGMA_01();
//		Double close				=	nowDTO.getNowCLOSE_01();
//		String checkLimit			=	COLUMN.LONG_1_H_SIGMA;
//		Double kessaiKin;
//		Double kessaiDay;
//		//今日がL3を超えているかチェック
//		if (close <= checkLimitBreak){
//			return Technique98_CONST.NO_GAME;
//		}
//
//
//		S this_s = new S ();
//		ResultSet this_rs=null;
//
//
//		String SQL = " select "
//				+ COLUMN.DAYTIME		+ ","
//				+ COLUMN.CLOSE			+ ","
//				+ checkLimit		+ ""
//				+ " from "
//				+ SQLChecker.getTBL(nowDTO.getCateflg_01())
//				+ " where "
//				+ COLUMN.DAYTIME + " <= '" + nowDTO.getNowDay_01() + "'"
//				+ " and "
//				+ COLUMN.CODE + " = '" + nowDTO.getCode_01() + "'"
//				+ " order by "
//				+ COLUMN.DAYTIME + " desc ";
//
//		try {
//
//
//			this_rs = this_s.sqlGetter().executeQuery(SQL);
//
//
//			this_rs.next();
//			this_rs.next();
//			for ( int i = 0 ; i < paraDTO.getCheckBori_checkBORI() + 1 ; i++ ){
//				//チェックする期間がL1を以下であることをチェック
//				if( this_rs.getDouble(COLUMN.CLOSE) >= this_rs.getDouble(checkLimit)){
//					this_rs.close();
//					return Technique98_CONST.NO_GAME;
//				}
//				this_rs.next();
//			}
//
//
//			this_rs.close();
//			nowDTO.setKessaiDay(nowDTO.getNowDay_01());
//			nowDTO.setKessaiKingaku( nowDTO.getNowCLOSE_01() );
//			return Technique98_CONST.TRADE_FLG;
//		} catch (SQLException e) {
//			//paraDTO.getCheckBori_checkBORIで指定した日数より遡れない場合、チェックしない
//			try {
//				this_rs.close();
//			} catch (SQLException e1) {
//				// TODO 自動生成された catch ブロック
//				e1.printStackTrace();
//			}
//			return Technique98_CONST.NO_GAME;
//		}
//
		return Technique98_CONST.NO_GAME;

	}


	public static int baseBori_L(Bean_Parameta paraDTO,List<Bean_nowRecord> nowDTOList,int nowDTOadress,Bean_Result resultDTO,boolean judge){
		return Technique98_CONST.NO_GAME;
	}
}
