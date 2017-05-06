package botton;

import java.io.File;

import proparty.S;
import proparty.controllDay;
import sepacomfilecreate.ParseHtmlStockSplit;
import GamenDTO.TAB_MainDTO;
import constant.ReCord;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class CreateSepaComFile {



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


		//ログファイルの出力先有無チェック
		File file =  new File(mainDTO.getLogFilePath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR;
		}


		//分割併合ファイルの出力先チェック
		file =  new File(mainDTO.getSepaFolderPath());
		if (file.isDirectory()==false){
		    return nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR;
		}

		return nyuryokuCheckResultConst.SUCCESS;
	}



	public String checkSepaComFile(TAB_MainDTO mainDTO){

		S s = new S();
		s.getCon();
		String lastSepaDay = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_SEPA_CHECK, s);
		String lastComDay =  controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_COMBINE_CHECK, s);


//		//-3
//		System.out.println("2016-02-15".compareTo("2016-02-18"));
//		//-2
//		System.out.println("2016-02-15".compareTo("2016-02-17"));
//		System.out.println("2016-02-15".compareTo("2016-02-16"));
//		System.out.println("2016-02-15".compareTo("2016-02-15"));
//		System.out.println("2016-02-15".compareTo("2016-02-14"));
//		System.out.println("2016-02-15".compareTo("2016-02-12"));

//		controllDay.update_KOSHINBI(updateDay, ReCord.KOSHINBI_COMBINE_CHECK, s);
//		controllDay.update_KOSHINBI(updateDay, ReCord.KOSHINBI_SEPA_CHECK, s);
		System.out.println(lastSepaDay);
		System.out.println(lastComDay);
		
		ParseHtmlStockSplit phs = new ParseHtmlStockSplit();
		
		System.out.println("分割：" + phs.makeSplitCsv(mainDTO.getSepaFolderPath(), lastSepaDay	));
		System.out.println("併合：" + phs.makeMergeCsv(mainDTO.getSepaFolderPath(), lastComDay	));
		
//		commonAP.writeInLog("日々売買ファイルの出力でなんかエラー。",logWriting.DATEDATE_LOG_FLG);
		s.closeConection();



//		String filePath = mainDTO.getSepaFolderPath().replace(File.separator,ReturnCodeConst.SQL_SEPA);
//
//		String SQL = "LOAD DATA INFILE \"" + filePath + "\" ignore INTO TABLE " + TBL_Name.SEPARATE_DD + " FIELDS TERMINATED BY ','";
//
//		S s = new S();
//		s.getCon();
//
//		try {
//			s.sqlGetter().executeUpdate(SQL);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			s.closeConection();
//			return e.getErrorCode();
//		}
//
//
//		s.closeConection();
//		return ReturnCodeConst.SQL_ERR_0;

		return nyuryokuCheckResultConst.SUCCESS;
	}

}
