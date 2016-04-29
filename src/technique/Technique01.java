package technique;

import java.sql.ResultSet;
import java.sql.SQLException;

import proparty.S;
import accesarrySQL.SQLChecker;
import bean.Bean_Parameta;
import bean.Bean_Result;
import constant.AccesarryParameta;
import constant.COLUMN;
import constant.ReCord;

public class Technique01 {

//Lメソッドは戻り値int（勝ち）約定（負け）、false買わず
//WINFLG_買う、LOSEフラグ、買わない。
	public static int checkDeki_L(Bean_Parameta paraDTO,Bean_Result resultDTO){
		S this_s = new S ();
		ResultSet this_rs=null;

		switch(paraDTO.getCateflg()){
		case ReCord.CODE_01_STOCK:
			break;
		case ReCord.CODE_04_ETF:
			break;
		default:
			return Technique98_CONST.NO_GAME;
		}

		String SQL = SQLChecker.getTermCheckSQL(paraDTO.getCode(),paraDTO.getCateflg(),paraDTO.getDayTime(),paraDTO.getTerm01() + paraDTO.getTerm02());


		try {

			this_rs = this_s.sqlGetter().executeQuery(SQL);
			if(this_rs.next()==true){
				//もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。

				String devStart = this_rs.getString((COLUMN.DAYTIME)) ;

				SQL = SQLChecker.getTermCheckSQL(paraDTO.getCode(),paraDTO.getCateflg(),paraDTO.getDayTime(),paraDTO.getTerm02());

				this_rs.close();

				this_rs = this_s.sqlGetter().executeQuery(SQL);
				if(this_rs.next()==true){
					String checkStart = this_rs.getString((COLUMN.DAYTIME)) ;

					String DEKI="";
					if(paraDTO.getCateflg().equals(ReCord.CODE_01_STOCK)){
						DEKI=COLUMN.BEFORE_DEKI;
					}else{
						DEKI=COLUMN.DEKI;
					}

					String checkColumn1 = "STDDEV_SAMP(" + DEKI +  ")";
					String checkColumn2 = "avg(" + DEKI +  ")";
					String checkColumn3 = "STDDEV_SAMP(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn4 = "avg(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn5 = "STDDEV_SAMP(" + COLUMN.DEKI_RATIO +  ")";
					String checkColumn6 = "avg(" + COLUMN.DEKI_RATIO +  ")";

					SQL = "select "
							+ checkColumn5
							+ " from "
							+ SQLChecker.getTBL(paraDTO.getCateflg())
							+ " where "
							+ COLUMN.CODE
							+ " ='" + paraDTO.getCode() + "'"
							+ " and "
							+ "'" + devStart + "' <= "
							+ COLUMN.DAYTIME
							+ " and "
							+ COLUMN.DAYTIME
							+ " < "
							+ "'" + checkStart + "'";

					this_rs.close();
					this_rs = this_s.sqlGetter().executeQuery(SQL);
					if(this_rs.next()==true){
						//出来高が変化していない期間を調査する。
//						double dekiDEV = s.rs.getDouble(checkColumn1) ;
//						double dekiAVG = s.rs.getDouble(checkColumn2) ;
						double CHECK = this_rs.getDouble(checkColumn5) ;

						//過去の出来高の変異が少ない期間であるかをチェックする

						if(CHECK < AccesarryParameta.BOXCHECK){
							SQL = "select "
									+ DEKI + ","
									+ COLUMN.DEKI_CHANGERATE + ","
									+ COLUMN.DEKI_RATIO +  ""
									+ " from "
									+ SQLChecker.getTBL(paraDTO.getCateflg())
									+ " where "
									+ COLUMN.CODE
									+ " ='" + paraDTO.getCode() + "'"
									+ " and "
									+ "'" + checkStart + "' <= "
									+ COLUMN.DAYTIME
									+ " and "
									+ COLUMN.DAYTIME
									+ " <= "
									+ "'" + paraDTO.getDayTime() + "'";

							this_rs.close();
							this_rs = this_s.sqlGetter().executeQuery(SQL);
							//有効なカウントを数える
							double checkCount	 = 0;
//							double MAXDEKI		 = 0;
							while ( this_rs.next() ) {
								Double DEKI_ChANGERATE=this_rs.getDouble(COLUMN.DEKI_CHANGERATE);
								if( DEKI_ChANGERATE > 0.1 ){
									checkCount++;
									if( DEKI_ChANGERATE > 0.2 ){
										checkCount++;
										if( DEKI_ChANGERATE > 0.3 ){
											checkCount++;
										}
									}
								}



								Double DEKI_RATIO = this_rs.getDouble(COLUMN.DEKI_RATIO);
								if( DEKI_RATIO < -0.1 ){
									checkCount--;
									if( DEKI_RATIO < -0.2 ){
										checkCount--;
										if( DEKI_RATIO < -0.3 ){
											checkCount--;
										}
									}
								}
							}

							checkCount = checkCount / paraDTO.getTerm02();

							if ( checkCount >= AccesarryParameta.HIGHT_DEKI_RATIO ){
								this_rs.close();

								return Technique98_CONST.TRADE_FLG;
							}
						}else if(Double.isNaN(CHECK)){
							System.out.println(CHECK);
						}

					}
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return Technique98_CONST.NO_GAME;
	}
//	static int count=0;
	//Term		:変動が少ない出来高の期間
	//beforeTerm:出来高が上がってきた期間
	public static boolean checkDeki_L(String code,String cate,String dayTime,int Term,int beforeTerm,S this_s){
		//String SQL = SQLChecker.getSQL(code, cate, dayTime, s);

//		ResultSet this_rs;
//		this_s.reCon();
		String SQL = SQLChecker.getTermCheckSQL(code,cate,dayTime,Term + beforeTerm);
//		System.out.println(code + ":" + dayTime + ":" + count);
//		count++;
//		System.out.println(count);

		try {
			this_s.rs = this_s.sqlGetter().executeQuery(SQL);
			//trueならterm期間中分のレコードが存在する
			if(this_s.rs.next()==true){
				//もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。

				String devStart = this_s.rs.getString((COLUMN.DAYTIME)) ;

				SQL = SQLChecker.getTermCheckSQL(code,cate,dayTime,beforeTerm);


				this_s.rs.close();

				this_s.rs = this_s.sqlGetter().executeQuery(SQL);
				if(this_s.rs.next()==true){
					String checkStart = this_s.rs.getString((COLUMN.DAYTIME)) ;

					String DEKI="";
					if(cate.equals("1")){
						DEKI=COLUMN.BEFORE_DEKI;
					}else{
						DEKI=COLUMN.DEKI;
					}


					String checkColumn1 = "STDDEV_SAMP(" + DEKI +  ")";
					String checkColumn2 = "avg(" + DEKI +  ")";
					String checkColumn3 = "STDDEV_SAMP(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn4 = "avg(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn5 = "STDDEV_SAMP(" + COLUMN.DEKI_RATIO +  ")";
					String checkColumn6 = "avg(" + COLUMN.DEKI_RATIO +  ")";

					SQL = "select "
							+ checkColumn5
							+ " from "
							+ SQLChecker.getTBL(cate)
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ "'" + devStart + "' <= "
							+ COLUMN.DAYTIME
							+ " and "
							+ COLUMN.DAYTIME
							+ " < "
							+ "'" + checkStart + "'";

					this_s.rs.close();
					this_s.rs = this_s.sqlGetter().executeQuery(SQL);

					if(this_s.rs.next()==true){

						//出来高が変化していない期間を調査する。
//						double dekiDEV = s.rs.getDouble(checkColumn1) ;
//						double dekiAVG = s.rs.getDouble(checkColumn2) ;
						double CHECK = this_s.rs.getDouble(checkColumn5) ;

						//過去の出来高の変異が少ない期間であるかをチェックする

						if(CHECK < AccesarryParameta.BOXCHECK){
							SQL = "select "
									+ DEKI + ","
									+ COLUMN.DEKI_CHANGERATE + ","
									+ COLUMN.DEKI_RATIO +  ""
									+ " from "
									+ SQLChecker.getTBL(cate)
									+ " where "
									+ COLUMN.CODE
									+ " ='" + code + "'"
									+ " and "
									+ "'" + checkStart + "' <= "
									+ COLUMN.DAYTIME
									+ " and "
									+ COLUMN.DAYTIME
									+ " <= "
									+ "'" + dayTime + "'";

							this_s.rs.close();
							this_s.rs = this_s.sqlGetter().executeQuery(SQL);

							//有効なカウントを数える
							double checkCount	 = 0;
//							double MAXDEKI		 = 0;
							while ( this_s.rs.next() ) {
								Double DEKI_ChANGERATE=this_s.rs.getDouble(COLUMN.DEKI_CHANGERATE);
								if( DEKI_ChANGERATE > 0.1 ){
									checkCount++;
									if( DEKI_ChANGERATE > 0.2 ){
										checkCount++;
										if( DEKI_ChANGERATE > 0.3 ){
											checkCount++;
										}
									}
								}



								Double DEKI_RATIO = this_s.rs.getDouble(COLUMN.DEKI_RATIO);
								if( DEKI_RATIO < -0.1 ){
									checkCount--;
									if( DEKI_RATIO < -0.2 ){
										checkCount--;
										if( DEKI_RATIO < -0.3 ){
											checkCount--;
										}
									}
								}
							}

							checkCount = checkCount / beforeTerm;

							if ( checkCount >= AccesarryParameta.HIGHT_DEKI_RATIO ){
								this_s.rs.close();
								return true;
							}

						}else if(Double.isNaN(CHECK)){
							System.out.println(CHECK);
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			this_s.rs.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

		}
		return false;
	}

	public static boolean checkDeki_L(String code,String cate,String dayTime,int Term,int beforeTerm){
		//String SQL = SQLChecker.getSQL(code, cate, dayTime, s);
		S this_s = new S ();
		ResultSet this_rs=null;
//		this_s.reCon();
		String SQL = SQLChecker.getTermCheckSQL(code,cate,dayTime,Term + beforeTerm);
//		System.out.println(code + ":" + dayTime + ":" + count);
//		count++;
//		System.out.println(count);
		switch(cate){
		case ReCord.CODE_01_STOCK:
			break;
		case ReCord.CODE_04_ETF:
			break;
		default:
			return false;
		}

		try {
			this_rs = this_s.sqlGetter().executeQuery(SQL);
			//trueならterm期間中分のレコードが存在する
			if(this_rs.next()==true){
				//もしも指定したテーブルの中のレコード数が、termよりも少ない場合は処理をしない。

				String devStart = this_rs.getString((COLUMN.DAYTIME)) ;

				SQL = SQLChecker.getTermCheckSQL(code,cate,dayTime,beforeTerm);


				this_rs.close();

				this_rs = this_s.sqlGetter().executeQuery(SQL);
				if(this_rs.next()==true){
					String checkStart = this_rs.getString((COLUMN.DAYTIME)) ;

					String DEKI="";
					if(cate.equals("1")){
						DEKI=COLUMN.BEFORE_DEKI;
					}else{
						DEKI=COLUMN.DEKI;
					}


					String checkColumn1 = "STDDEV_SAMP(" + DEKI +  ")";
					String checkColumn2 = "avg(" + DEKI +  ")";
					String checkColumn3 = "STDDEV_SAMP(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn4 = "avg(" + COLUMN.DEKI_CHANGERATE +  ")";
					String checkColumn5 = "STDDEV_SAMP(" + COLUMN.DEKI_RATIO +  ")";
					String checkColumn6 = "avg(" + COLUMN.DEKI_RATIO +  ")";

					SQL = "select "
							+ checkColumn5
							+ " from "
							+ SQLChecker.getTBL(cate)
							+ " where "
							+ COLUMN.CODE
							+ " ='" + code + "'"
							+ " and "
							+ "'" + devStart + "' <= "
							+ COLUMN.DAYTIME
							+ " and "
							+ COLUMN.DAYTIME
							+ " < "
							+ "'" + checkStart + "'";

					this_rs.close();
					this_rs = this_s.sqlGetter().executeQuery(SQL);

					if(this_rs.next()==true){

						//出来高が変化していない期間を調査する。
//						double dekiDEV = s.rs.getDouble(checkColumn1) ;
//						double dekiAVG = s.rs.getDouble(checkColumn2) ;
						double CHECK = this_rs.getDouble(checkColumn5) ;

						//過去の出来高の変異が少ない期間であるかをチェックする

						if(CHECK < AccesarryParameta.BOXCHECK){
							SQL = "select "
									+ DEKI + ","
									+ COLUMN.DEKI_CHANGERATE + ","
									+ COLUMN.DEKI_RATIO +  ""
									+ " from "
									+ SQLChecker.getTBL(cate)
									+ " where "
									+ COLUMN.CODE
									+ " ='" + code + "'"
									+ " and "
									+ "'" + checkStart + "' <= "
									+ COLUMN.DAYTIME
									+ " and "
									+ COLUMN.DAYTIME
									+ " <= "
									+ "'" + dayTime + "'";

							this_rs.close();
							this_rs = this_s.sqlGetter().executeQuery(SQL);

							//有効なカウントを数える
							double checkCount	 = 0;
//							double MAXDEKI		 = 0;
							while ( this_rs.next() ) {
								Double DEKI_ChANGERATE=this_rs.getDouble(COLUMN.DEKI_CHANGERATE);
								if( DEKI_ChANGERATE > 0.1 ){
									checkCount++;
									if( DEKI_ChANGERATE > 0.2 ){
										checkCount++;
										if( DEKI_ChANGERATE > 0.3 ){
											checkCount++;
										}
									}
								}



								Double DEKI_RATIO = this_rs.getDouble(COLUMN.DEKI_RATIO);
								if( DEKI_RATIO < -0.1 ){
									checkCount--;
									if( DEKI_RATIO < -0.2 ){
										checkCount--;
										if( DEKI_RATIO < -0.3 ){
											checkCount--;
										}
									}
								}
							}

							checkCount = checkCount / beforeTerm;

							if ( checkCount >= AccesarryParameta.HIGHT_DEKI_RATIO ){
								this_rs.close();

								return true;
							}

						}else if(Double.isNaN(CHECK)){
							System.out.println(CHECK);
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			this_rs.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return false;
	}
}
