package accesarrySQL;

import java.sql.SQLException;

import proparty.S;

import common.commonAP;

import constant.logWriting;

public class ConAccessary {
//アクセサリを制御する。
	static int checkCount=0;



	//移動平均線を制御する。
	public static void setConAccessary(String code,String cate,String dayTime,S s){
////
		try {
			s.rs_EDIT = s.sqlEditer().executeQuery(SQLChecker.getSQL(code, cate, dayTime, s));
			s.rs_EDIT.next();


			//騰落レシオとか、一日でいけるやつを引く。
			OneRecord_Update.OneRecord(code, cate, dayTime, s, s.rs_EDIT);
			s.rs_EDIT.updateRow();

			//売買高、出来高、終値で移動平均線を引く。
			IDO_HEKIN_Price.setIDO_Heikin(code, cate, dayTime,s,s.rs_EDIT);

			//終値をもとにボリンジャーバンドを引く
			Sigma.setIDOHeikinSigma(code, cate, dayTime,s,s.rs_EDIT);

			//平滑指数移動平均線を引く。
			IDO_HEKIN_HEKATU.setIDO_Heikkatu(code, cate, dayTime, s,s.rs_EDIT);
			s.rs_EDIT.updateRow();


			//※平滑指数移動平均線をもとにMACDを引く。
			//MACD
			MACD.setMACD(code, cate, dayTime, s,s.rs_EDIT);
			s.rs_EDIT.updateRow();

			//MACDシグナル（必ずMACDのあとに引く）
			MACD_SIGNAL.setIDOHeikinMACD_signal(code, cate, dayTime, s,s.rs_EDIT);

			s.rs_EDIT.updateRow();

			//各テーブルの前日比、窓
			ZenzituHi.setZenzituhi(code,cate, dayTime, s,s.rs_EDIT);

			s.rs_EDIT.updateRow();


//			s.rs_EDIT.updateRow();

			checkCount++;
			if( checkCount%400 == 0){
				checkCount=0;
				s.resetConnection();
				commonAP.writeLog(code + ":" + dayTime + ":",logWriting.DATEDATE_LOG_FLG);
//				System.out.print(code + ":" + dayTime + ":");
			}


		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			if(e.getErrorCode()!=1146){
				commonAP.writeInLog("SQLException: " + e.getMessage(),logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("SQLState: " + e.getSQLState(),logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog(" VendorError: " + e.getErrorCode(),logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("Exception: " + e.getMessage(),logWriting.DATEDATE_LOG_FLG);
				commonAP.writeInLog("【" + code + ":" + cate + ":" + dayTime + "】",logWriting.DATEDATE_LOG_FLG);
				e.printStackTrace();

			}

		}




	}


}
