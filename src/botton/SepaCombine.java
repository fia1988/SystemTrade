package botton;

import java.io.File;

import proparty.S;
import GamenDTO.TAB_MainDTO;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class SepaCombine {

	public String nyuryokuChecker(TAB_MainDTO mainDTO){

		//タイマーチェック
		//TRUEのときはタイマー起動中なのでオフを返す。
		if(mainDTO.isJudgeTimer()==true){
			return nyuryokuCheckResultConst.ON_TIMER_ERR;
		}

		//MYSQLのアカウントチェック
		S s = new S();
		if ( s.getCon() != ReturnCodeConst.SQL_ERR_0){
			return nyuryokuCheckResultConst.MYSQL_ERR;
		};
		s.closeConection();

		//分割ファイルの有無チェック
		File file =  new File(mainDTO.getSepaCombineFilePath());
		if (file.isFile()==false){
		    return nyuryokuCheckResultConst.NO_FILE_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}

	public int loadSepaCombineFile(TAB_MainDTO mainDTO){

//		System.out.println(File.separator);
//		System.out.println(mainDTO.getSepaCombineFilePath());
//		String filePath = mainDTO.getSepaCombineFilePath().replaceAll(File.separator,ReturnCodeConst.SQL_SEPA);
//		String filePath = mainDTO.getSepaCombineFilePath();
//		String SQL = "LOAD DATA INFILE \"" + filePath + "\" ignore INTO TABLE " + TBL_Name.SEPARATE_DD + " FIELDS TERMINATED BY ','";
//
		S s = new S();
		s.getCon();
//		System.out.println(SQL);
//
//		try {
//			s.sqlGetter().executeUpdate(SQL);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			s.closeConection();
//			return e.getErrorCode();
//		}


		s.closeConection();

		return ReturnCodeConst.SQL_ERR_0;
	}
}
