package controller;

import insertPackage.InsertDay;
import insertPackage.InsertList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import netConnect.NC_Controller;
import netConnect.NetBean;
import proparty.Net_Adress;
import proparty.S;
import GamenDTO.TAB_MainDTO;
import accesarrySQL.SEPARATE_CHECK;
import bean.Bean_Bean;
import bean.Bean_CodeList;
import botton.CreateSepaComFile;

import common.commonAP;

import constant.ReCord;
import constant.ReturnCodeConst;
import constant.logWriting;
import createTBL.GetCodeTBL;

public class CONTOLLBOTTON {

	public int everyDayBottonContoroll(TAB_MainDTO mainDTO,String MAXDAY ,String TODAY,String cate,S s){



		//日々テーブルの更新
		int hibiResult;
		hibiResult = hisabisaDayBotton(mainDTO,MAXDAY, TODAY, cate, s);

		switch (hibiResult){
			case ReturnCodeConst.EVERY_UPDATE_SUCSESS:
				//成功時は抜ける
				break;
			case ReturnCodeConst.EVERY_UPDATE_NOTHING:
				s.resetConnection();
				return hibiResult;
			case ReturnCodeConst.EVERY_UPDATE_ERR:
				commonAP.writeInLog("こりゃだめだcate：" + cate,logWriting.DATEDATE_LOG_FLG);
				s.resetConnection();
				return hibiResult;
			default:
				commonAP.writeInLog("なんかよくわからないの来た：" + cate,logWriting.DATEDATE_LOG_FLG);
				s.resetConnection();
				return hibiResult;
		}



		//リストを作る
		if ( everyDayBotton(commonAP.getTODAY(),cate,s) == ReturnCodeConst.EVERY_UPDATE_ERR){
			commonAP.writeInLog("リスト作り失敗：" + cate,logWriting.DATEDATE_LOG_FLG);
			s.resetConnection();
			return ReturnCodeConst.EVERY_UPDATE_ERR;
		};

		s.resetConnection();
		return hibiResult;
	}

//	public void everyDayBottonContoroll_STOCK_ETF(String MAXDAY ,String TODAY,S s){
//
//
//		//更新日が昨日と同じ場合、今日の分だけ更新する。月曜日の場合はあきらめる。
//		if(commonAP.getTODAY(-1).equals(MAXDAY)){
//
//			//リストを作る
////			everyDayBotton_STOCK_ETF(commonAP.getTODAY(-1),s);
//			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_01_STOCK,s);
//			commonAP.writeInLog("こことおる",logWriting.DATEDATE_LOG_FLG);
//
//		}else if(commonAP.getTODAY().equals(MAXDAY)){
//			commonAP.writeInLog("株更新梨",logWriting.DATEDATE_LOG_FLG);
//		}else{
//
////			hisabisaDayBottonContoroll_STOCK_ETF(MAXDAY,TODAY,s);
//
//		}
//		hisabisaDayBotton(MAXDAY, TODAY, ReCord.CODE_01_STOCK, s);
//		s.resetConnection();
//
//	}

//	public void everyDayBottonContoroll_STATISTICS(String MAXDAY ,String TODAY,S s){
//
//		if(commonAP.getTODAY(-1).equals(MAXDAY)){
//
//			//リストを作る
////			everyDayBotton_STATISTICS(commonAP.getTODAY(-1),s);
//			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_02_SATISTICS,s);
//			commonAP.writeInLog("こことおる",logWriting.DATEDATE_LOG_FLG);
//
//		}else if(commonAP.getTODAY().equals(MAXDAY)){
//			//更新日とボタン実行日が同じならここ
//			commonAP.writeInLog("統計更新なし",logWriting.DATEDATE_LOG_FLG);
//		}else{
//
////			hisabisaDayBottonContoroll_STATISTICS(MAXDAY,TODAY,s);
//
//
//		}
//		hisabisaDayBotton(MAXDAY,TODAY,ReCord.CODE_02_SATISTICS,s);
//		s.resetConnection();
//	}

//	public void everyDayBottonContoroll_INDEX(String MAXDAY ,String TODAY,S s){
//
//
//		//更新日が昨日と同じ場合、今日の分だけ更新する。月曜日の場合はあきらめる。
//		if(commonAP.getTODAY(-1).equals(MAXDAY)){
//
//
////			everyDayBotton_INDEX(commonAP.getTODAY(-1),s);
//			//リストを作る
//			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_03_INDEX,s);
//			commonAP.writeInLog("こことおる",logWriting.DATEDATE_LOG_FLG);
//
//		}else if(commonAP.getTODAY().equals(MAXDAY)){
//			commonAP.writeInLog("指数更新梨",logWriting.DATEDATE_LOG_FLG);
//		}else{
//
////			hisabisaDayBottonContoroll_INDEX(MAXDAY,TODAY,s);
//
//		}
//		hisabisaDayBotton(MAXDAY, TODAY, ReCord.CODE_03_INDEX, s);
//		s.resetConnection();
//
//	}

	private int everyDayBotton(String TODAY,String cate,S s){

//	    DateFormat format = new SimpleDateFormat("HH:mm:ss");
//	    Date nowDate = new Date();
//	    String nowTime = format.format(nowDate);
//	    System.out.println(nowTime);
//	    System.out.println(PROPARTY.UPDATETIME);
//	    System.out.println(nowTime.compareTo(PROPARTY.UPDATETIME));
//
//	    if (nowTime.compareTo(PROPARTY.UPDATETIME) <= 0) {
////		    System.out.println("14:30:00".compareTo("15:30:00")); //		    -1
////		    System.out.println("15:30:00".compareTo("15:30:00")); //		    0
////		    System.out.println("16:30:00".compareTo("15:30:00")); //		    1
//	    	System.out.println(PROPARTY.UPDATETIME + "がまだ来ていません。今は" + nowTime);
//	    	return;
//	    }

		NetBean NB = new NetBean();

		Bean_Bean bbb = new Bean_Bean();

		String URL = "";
		switch(cate){
		case ReCord.CODE_01_STOCK:
			if(NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0) == false){
				commonAP.writeInLog("株のリスト作るの失敗",logWriting.DATEDATE_LOG_FLG);
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),TODAY, s);

			break;
		case ReCord.CODE_02_SATISTICS:
			URL = Net_Adress.STATISTICS_LIST;
			if(NB.setUrlCsv(URL , 1) == false){

				commonAP.writeInLog("統計のリスト作るの失敗",logWriting.DATEDATE_LOG_FLG);
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
//			//取得したDTOをリストTBLに挿入する。
//			//取得したDTOをもとに日々テーブルを作る
//			//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
			InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(bbb.getList_CSVtoDTO_STATISTICA(),TODAY, s);
			break;
		case ReCord.CODE_03_INDEX:
			if( NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0) == false ){
				commonAP.writeInLog("INDEXのリスト作るの失敗",logWriting.DATEDATE_LOG_FLG);
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}
			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(bbb.getList_CSVtoDTO_INDEX(),TODAY, s);
			break;
		case ReCord.CODE_04_ETF:
			if(NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0) == false){
				commonAP.writeInLog("株のリスト作るの失敗",logWriting.DATEDATE_LOG_FLG);
				return ReturnCodeConst.EVERY_UPDATE_ERR;
			}
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),TODAY, s);
//

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			System.out.println("なんかよくわからないの来た：");
			break;
		}

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;
	}

	private int hisabisaDayBotton(TAB_MainDTO mainDTO,String MAXDAY,String TODAY,String cate,S s){

		NetBean NB = new NetBean();
		Bean_Bean bbb = new Bean_Bean();
		int resultInsert = 0;
		//リスト作る。
//		everyDayBotton(TODAY,cate,s);


		switch(cate){
		case ReCord.CODE_01_STOCK:
			resultInsert=insertDD_STOCK_ETF(mainDTO,MAXDAY,TODAY,s);

			break;
		case ReCord.CODE_02_SATISTICS:
			resultInsert=insertDD_STATISTICS(MAXDAY,TODAY,s);
			break;
		case ReCord.CODE_03_INDEX:
			resultInsert=insertDD_INDEX(MAXDAY,TODAY,s);
			break;
		case ReCord.CODE_04_ETF:
			resultInsert=(insertDD_STOCK_ETF(mainDTO,MAXDAY,TODAY,s));

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			System.out.println("なんかよくわからないの来た：");
			break;
		}


//		switch (resultInsert){
//			case ReturnCodeConst.EVERY_UPDATE_SUCSESS:
//				return resultInsert;
//			case ReturnCodeConst.EVERY_UPDATE_NOTHING:
//				return resultInsert;
//			case ReturnCodeConst.EVERY_UPDATE_ERR:
//				System.out.println("なんかエラー1");
//				return resultInsert;
//			default:
//				System.out.println("なんかエラー2");
//				return resultInsert;
//		}

		return resultInsert;

	}

//	private void everyDayBotton_STATISTICS(String TODAY,S s){
//		NetBean NB = new NetBean();
//
//		//統計指標
//		Bean_Bean bbb = new Bean_Bean();
//
//
////		CSVを取得
//		try{
//			NB.setUrlCsv(Net_Adress.STATISTICS_LIST , 1);
//		}catch(Exception o){
//
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
//		}catch(NullPointerException nu){
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//
//			return;
//		}catch(Exception e){
//
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
//		InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(bbb.getList_CSVtoDTO_STATISTICA(),TODAY, s);
//
//
//	}


////	リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
//	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
//	private void hisabisaDayBottonContoroll_STATISTICS(String MAXDAY , String TODAY , S s){
//		NetBean NB = new NetBean();
//
//		//統計指標
//		Bean_Bean bbb = new Bean_Bean();
//
////		CSVを取得
//		try{
//
//			NB.setUrlCsv(Net_Adress.STATISTICS_LIST,1);
//		}catch(Exception o){
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
//		}catch(NullPointerException nu){
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//			return;
//		}catch(Exception e){
//
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STATISTICA(), s);
//
//		insertDD_STATISTICS(MAXDAY,TODAY,s);
//
//	}

	private int insertDD_STATISTICS(String MAXDAY,String TODAY,S s){
		NC_Controller NC = new NC_Controller();

		commonAP cAP = new commonAP();
//		InsertDay ID = new InsertDay();

		//String"yyyy-mm-dd"できた日付を分割
		String[] MAXDAY_SPRIT = MAXDAY.split("-");

		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(MAXDAY_SPRIT[0]), Integer.parseInt(MAXDAY_SPRIT[1]) - 1, Integer.parseInt(MAXDAY_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


		calendar.add(Calendar.DAY_OF_MONTH, +1);
		MAXDAY = sdf1.format(calendar.getTime());

		int check = 0;
		boolean noSetUrlCsv = false;
		while(cAP.checkDay(TODAY, MAXDAY)){

			//CSVゲット
			NetBean NB = new NetBean();
			Bean_Bean B_B = new Bean_Bean();
			//CSVの中身がnullではない場合、続行CSVをDTOにしてインサート

			if(NB.setUrlCsv(Net_Adress.STATISTICS_LIST_DD + MAXDAY + Net_Adress.DOWN_CSV,1)){

				//CSV→DTO
				B_B.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),MAXDAY,0);
				//インサート
				InsertDay i_d = new InsertDay();
				i_d.InsertDD_STATISTICS(B_B.getList_CSVtoDTO_STATISTICA(),MAXDAY, s);
				check = 0;

				//一回でも通ればtrueにする。
				noSetUrlCsv = true;
			}else{

				check++;
				if ( check > 30 ) {
					return ReturnCodeConst.EVERY_UPDATE_ERR;
				}
			}

			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());
		}

		if (noSetUrlCsv == false){
			//一回も更新処理をしていない場合はfalseなので更新なしを返す
			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
		}

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;

	}



//	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
//	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
//	private void hisabisaDayBottonContoroll_STOCK_ETF(String MAXDAY , String TODAY , S s){
//
//		NetBean NB = new NetBean();
//
//		//株と指数
//		Bean_Bean bbb = new Bean_Bean();
//
//
////		CSVを取得
//		try{
//			NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0);
//		}catch(Exception o){
//
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
//		}catch(NullPointerException nu){
//
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//			return;
//		}catch(Exception e){
//
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STOCK_ETF(), s);
//
//
//		//MAXDAYから今日までのデータをインサート開始。ストック、インデックス、統計も全部
//
//		if(insertDD_STOCK_ETF(MAXDAY,TODAY,s)){
//
//		}else{
//
//			commonAP.writeInLog("こりゃだめだ：株ETF",logWriting.DATEDATE_LOG_FLG);
//		}
//	}

//	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
//	//ただし、リストテーブルの更新日が昨日であるときのみ実行する。
//	private void everyDayBotton_STOCK_ETF(String DAY,S s){
//
//		NetBean NB = new NetBean();
//
//		//統計指標
//		Bean_Bean bbb = new Bean_Bean();
//
//
////		CSVを取得
//		try{
//			NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0);
//		}catch(Exception o){
//
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),DAY,0);
//		}catch(NullPointerException nu){
//
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//			return;
//		}catch(Exception e){
//
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
//		InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),DAY, s);
//
//
//	}

	private int insertDD_STOCK_ETF(TAB_MainDTO mainDTO,String MAXDAY,String TODAY,S s){
		NC_Controller NC = new NC_Controller();

		commonAP cAP = new commonAP();
//		InsertDay ID = new InsertDay();

		//String"yyyy-mm-dd"できた日付を分割
		String[] MAXDAY_SPRIT = MAXDAY.split("-");

		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(MAXDAY_SPRIT[0]), Integer.parseInt(MAXDAY_SPRIT[1]) - 1, Integer.parseInt(MAXDAY_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


		calendar.add(Calendar.DAY_OF_MONTH, +1);
		MAXDAY = sdf1.format(calendar.getTime());
		commonAP.writeInLog("今から株ETFの更新：insertDD_STOCK_ETF",logWriting.DATEDATE_LOG_FLG);

		boolean noSetUrlCsv = false;

		int check = 0;
		while(cAP.checkDay(TODAY, MAXDAY)){

			//CSVゲット
			NetBean NB = new NetBean();
			Bean_Bean B_B = new Bean_Bean();
			//CSVの中身がnullではない場合、続行CSVをDTOにしてインサート
			if(NB.setUrlCsv(Net_Adress.STOCK_LIST_DD + MAXDAY + Net_Adress.DOWN_CSV + Net_Adress.DOWN_ITEM_9,0)){
				//CSV→DTO
				B_B.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),MAXDAY,0);
				//インサート
				InsertDay i_d = new InsertDay();
				i_d.InsertDD_STOCK_ETF(B_B.getList_CSVtoDTO_STOCK_ETF(),MAXDAY, s);
				check = 0;

				//分割ファイルの作成/取込を行う。
				CreateSepaComFile sepaComCheck = new CreateSepaComFile();
				sepaComCheck.checkSepaComFile(mainDTO,TODAY);

				//分割チェック。
				SEPARATE_CHECK.checkSEPARATE_controll(s);

				//一回でも通ればtrueにする。
				noSetUrlCsv = true;
			}else{

				check++;
				if ( check > 30 ) {
					return ReturnCodeConst.EVERY_UPDATE_ERR;
				}
			}

			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());

		}

		if (noSetUrlCsv == false){
			//一回も更新処理をしていない場合はfalseなので更新なしを返す
			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
		}

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;

	}




//	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
//	//ただし、リストテーブルの更新日が昨日であるときのみ実行する。
//	private void everyDayBotton_INDEX(String DAY,S s){
//
//		NetBean NB = new NetBean();
//
//		//統計指標
//		Bean_Bean bbb = new Bean_Bean();
//
//
//		//			CSVを取得
//		try{
//			NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0);
//		}catch(Exception o){
//
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),DAY,0);
//		}catch(NullPointerException nu){
//
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//			return;
//		}catch(Exception e){
//
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
//		InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(bbb.getList_CSVtoDTO_INDEX(),DAY, s);
//
//	}

//	private void hisabisaDayBottonContoroll_INDEX(String MAXDAY , String TODAY , S s){
//
//		NetBean NB = new NetBean();
//
//		//株と指数
//		Bean_Bean bbb = new Bean_Bean();
//
//
////		CSVを取得
//		try{
//			NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0);
//		}catch(Exception o){
//
//			commonAP.writeInLog("たぶん何かのえらー",logWriting.DATEDATE_LOG_FLG);
//			o.printStackTrace();
//			return;
//		}
//
//		try{
//			//CSVをDTOにする
//			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),TODAY,0);
//		}catch(NullPointerException nu){
//			commonAP.writeInLog("なんかヌルポ",logWriting.DATEDATE_LOG_FLG);
//			return;
//		}catch(Exception e){
//			commonAP.writeInLog("原因不明",logWriting.DATEDATE_LOG_FLG);
//			e.printStackTrace();
//			return;
//		}
//
//
//		//取得したDTOをリストTBLに挿入する。
//		//取得したDTOをもとに日々テーブルを作る
//		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_INDEX(), s);
//
//
//		//MAXDAYから今日までのデータをインサート開始。ストック、インデックス、統計も全部
//
//		if(insertDD_INDEX(MAXDAY,TODAY,s)){
//
//		}else{
//			commonAP.writeInLog("こりゃだめだ：指数",logWriting.DATEDATE_LOG_FLG);
//
//		}
//	}

	private int insertDD_INDEX(String MAXDAY,String TODAY,S s){
		NC_Controller NC = new NC_Controller();

		commonAP cAP = new commonAP();
//		InsertDay ID = new InsertDay();

		//String"yyyy-mm-dd"できた日付を分割
		String[] MAXDAY_SPRIT = MAXDAY.split("-");

		//今日の日付をカレンダーにいれまーす。
		//月だけ0 ＝ 1月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(MAXDAY_SPRIT[0]), Integer.parseInt(MAXDAY_SPRIT[1]) - 1, Integer.parseInt(MAXDAY_SPRIT[2]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


		calendar.add(Calendar.DAY_OF_MONTH, +1);
		MAXDAY = sdf1.format(calendar.getTime());

		commonAP.writeInLog("今からINDEXの更新：insertDD_INDEX",logWriting.DATEDATE_LOG_FLG);
		int check = 0;
		boolean noSetUrlCsv = false;
		while(cAP.checkDay(TODAY, MAXDAY)){

			//CSVゲット
			NetBean NB = new NetBean();
			Bean_Bean B_B = new Bean_Bean();
			//CSVの中身がnullではない場合、続行CSVをDTOにしてインサート
			if(NB.setUrlCsv(Net_Adress.INDEX_LIST_DD + MAXDAY + Net_Adress.DOWN_CSV + Net_Adress.DOWN_ITEM_9,0)){

				//CSV→DTO
				B_B.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),MAXDAY,0);
				//インサート
				InsertDay i_d = new InsertDay();
				i_d.InsertDD_INDEX(B_B.getList_CSVtoDTO_INDEX(),MAXDAY, s);

				check = 0;

				//一回でも通ればtrueにする。
				noSetUrlCsv = true;
			}else{
				check++;
				if ( check > 30 ) {
					return ReturnCodeConst.EVERY_UPDATE_ERR;
				}
			}


			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());
		}


		if (noSetUrlCsv == false){
			//一回も更新処理をしていない場合はfalseなので更新なしを返す
			return ReturnCodeConst.EVERY_UPDATE_NOTHING;
		}

		return ReturnCodeConst.EVERY_UPDATE_SUCSESS;

	}


	private void InsertList_CreateTBL_DD(List<Bean_CodeList> DTO ,S s){
		InsertList BBB = new InsertList();
		GetCodeTBL GCL = new GetCodeTBL();

		//取得したDTOをリストTBLに挿入する。
		BBB.InsertList_Day(DTO, s);

		//取得したDTOをもとに日々テーブルを作る
//		GCL.controll_CreateTBL_DD(DTO, s);
	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(List<Bean_CodeList> DTO ,String DAY,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入。よく考えたらイランので没
//		ID.InsertDD_STOCK_ETF(DTO,DAY, s);

	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(List<Bean_CodeList> DTO ,String DAY,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入。よく考えたらイランので没
//		ID.InsertDD_INDEX(DTO, DAY, s);

	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(List<Bean_CodeList> DTO,String TODAY ,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入。よく考えたらイランので没
//		ID.InsertDD_STATISTICS(DTO,TODAY, s);


	}

	private void InsertList_CreateTBL_DD_hisabisa(List<Bean_CodeList> DTO ,S s){
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入

	}

}
