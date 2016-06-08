package controller;

import insertPackage.InsertDay;
import insertPackage.InsertList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import netConnect.NC_Controller;
import netConnect.NetBean;
import proparty.Net_Adress;
import proparty.PROPARTY;
import proparty.S;
import bean.Bean_Bean;
import bean.Bean_CodeList;

import common.commonAP;

import constant.ReCord;
import createTBL.GetCodeTBL;

public class CONTOLLBOTTON {

	public void everyDayBottonContoroll_STOCK_ETF(String MAXDAY ,String TODAY,S s){


		//更新日が昨日と同じ場合、今日の分だけ更新する。月曜日の場合はあきらめる。
		if(commonAP.getTODAY(-1).equals(MAXDAY)){


//			everyDayBotton_STOCK_ETF(commonAP.getTODAY(-1),s);
			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_01_STOCK,s);
			System.out.println("こことおる");

		}else if(commonAP.getTODAY().equals(MAXDAY)){
			System.out.println("株更新梨");
		}else{
			hisabisaDayBotton(MAXDAY, TODAY, ReCord.CODE_01_STOCK, s);
//			hisabisaDayBottonContoroll_STOCK_ETF(MAXDAY,TODAY,s);

		}

		s.resetConnection();

	}

	public void everyDayBottonContoroll_STATISTICS(String MAXDAY ,String TODAY,S s){

		if(commonAP.getTODAY(-1).equals(MAXDAY)){


//			everyDayBotton_STATISTICS(commonAP.getTODAY(-1),s);
			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_02_SATISTICS,s);
			System.out.println("こことおる");

		}else if(commonAP.getTODAY().equals(MAXDAY)){
			//更新日とボタン実行日が同じならここ
			System.out.println("統計更新なし");
		}else{

//			hisabisaDayBottonContoroll_STATISTICS(MAXDAY,TODAY,s);

			hisabisaDayBotton(MAXDAY,TODAY,ReCord.CODE_02_SATISTICS,s);
		}
		s.resetConnection();
	}

	public void everyDayBottonContoroll_INDEX(String MAXDAY ,String TODAY,S s){


		//更新日が昨日と同じ場合、今日の分だけ更新する。月曜日の場合はあきらめる。
		if(commonAP.getTODAY(-1).equals(MAXDAY)){


//			everyDayBotton_INDEX(commonAP.getTODAY(-1),s);
			everyDayBotton(commonAP.getTODAY(),ReCord.CODE_03_INDEX,s);
			System.out.println("こことおる");

		}else if(commonAP.getTODAY().equals(MAXDAY)){
			System.out.println("指数更新梨");
		}else{
			hisabisaDayBotton(MAXDAY, TODAY, ReCord.CODE_03_INDEX, s);
//			hisabisaDayBottonContoroll_INDEX(MAXDAY,TODAY,s);

		}

		s.resetConnection();

	}

	private void everyDayBotton(String TODAY,String cate,S s){

	    DateFormat format = new SimpleDateFormat("HH:mm:ss");
	    Date nowDate = new Date();
	    String nowTime = format.format(nowDate);
	    System.out.println(nowTime);
	    System.out.println(PROPARTY.UPDATETIME);
	    System.out.println(nowTime.compareTo(PROPARTY.UPDATETIME));

	    if (nowTime.compareTo(PROPARTY.UPDATETIME) <= 0) {
//		    System.out.println("14:30:00".compareTo("15:30:00")); //		    -1
//		    System.out.println("15:30:00".compareTo("15:30:00")); //		    0
//		    System.out.println("16:30:00".compareTo("15:30:00")); //		    1
	    	System.out.println(PROPARTY.UPDATETIME + "がまだ来ていません。今は" + nowTime);
	    	return;
	    }

		NetBean NB = new NetBean();

		Bean_Bean bbb = new Bean_Bean();

		String URL = "";
		switch(cate){
		case ReCord.CODE_01_STOCK:
			if(NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0) == false){
				System.out.println("株のリスト作るの失敗");
				return;
			}
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),TODAY, s);

			break;
		case ReCord.CODE_02_SATISTICS:
			URL = Net_Adress.STATISTICS_LIST;
			if(NB.setUrlCsv(URL , 1) == false){
				System.out.println("統計のリスト作るの失敗");
				return;
			}
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
			//取得したDTOをリストTBLに挿入する。
			//取得したDTOをもとに日々テーブルを作る
			//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
			InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(bbb.getList_CSVtoDTO_STATISTICA(),TODAY, s);
			break;
		case ReCord.CODE_03_INDEX:
			if( NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0) == false ){
				System.out.println("INDEXのリスト作るの失敗");
				return;
			}
			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(bbb.getList_CSVtoDTO_INDEX(),TODAY, s);
			break;
		case ReCord.CODE_04_ETF:
			if(NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0) == false){
				System.out.println("株のリスト作るの失敗");
				return;
			}
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
			InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),TODAY, s);


			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			System.out.println("なんかよくわからないの来た：");
			break;
		}


	}

	private void hisabisaDayBotton(String MAXDAY,String TODAY,String cate,S s){

		NetBean NB = new NetBean();
		Bean_Bean bbb = new Bean_Bean();

		//リスト作る。
//		everyDayBotton(TODAY,cate,s);

		switch(cate){
		case ReCord.CODE_01_STOCK:
			if(insertDD_STOCK_ETF(MAXDAY,TODAY,s)==false){
				System.out.println("こりゃだめだ：株ETF");
			}
			break;
		case ReCord.CODE_02_SATISTICS:
			if(insertDD_STATISTICS(MAXDAY,TODAY,s)==false){
				System.out.println("こりゃだめだ：統計");
			}
			break;
		case ReCord.CODE_03_INDEX:
			if(insertDD_INDEX(MAXDAY,TODAY,s)==false){
				System.out.println("こりゃだめだ：INDEX");
			}
			break;
		case ReCord.CODE_04_ETF:
			if(insertDD_STOCK_ETF(MAXDAY,TODAY,s)==false){
				System.out.println("こりゃだめだ：株ETF");
			}

			break;
		case ReCord.CODE_05_SAKIMONO:

			break;
		case ReCord.CODE_06_CURRENCY:

			break;
		default:
			System.out.println("なんかよくわからないの来た：");
			break;
		}


	}

	private void everyDayBotton_STATISTICS(String TODAY,S s){
		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STATISTICS_LIST , 1);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}


		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}


		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
		InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(bbb.getList_CSVtoDTO_STATISTICA(),TODAY, s);


	}


//	リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
	private void hisabisaDayBottonContoroll_STATISTICS(String MAXDAY , String TODAY , S s){
		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();

//		CSVを取得
		try{

			NB.setUrlCsv(Net_Adress.STATISTICS_LIST,1);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}


		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),TODAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}

		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STATISTICA(), s);

		insertDD_STATISTICS(MAXDAY,TODAY,s);

	}

	private boolean insertDD_STATISTICS(String MAXDAY,String TODAY,S s){
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
			}else{

				check++;
				if ( check > 30 ) {
					return false;
				}
			}

			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());
		}

		return true;

	}



	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
	private void hisabisaDayBottonContoroll_STOCK_ETF(String MAXDAY , String TODAY , S s){

		NetBean NB = new NetBean();

		//株と指数
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),TODAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}


		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STOCK_ETF(), s);


		//MAXDAYから今日までのデータをインサート開始。ストック、インデックス、統計も全部

		if(insertDD_STOCK_ETF(MAXDAY,TODAY,s)){

		}else{
			System.out.println("こりゃだめだ：株ETF");
		}
	}

	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日であるときのみ実行する。
	private void everyDayBotton_STOCK_ETF(String DAY,S s){

		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STOCK_LIST + Net_Adress.DOWN_ITEM_9, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_ETF(NB.getUrlCsv(),DAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}

		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
		InsertList_CreateTBL_DD_InsertDD_TODAY_STOCK_ETF(bbb.getList_CSVtoDTO_STOCK_ETF(),DAY, s);


	}

	private boolean insertDD_STOCK_ETF(String MAXDAY,String TODAY,S s){
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
		System.out.println("今から株ETFの更新：insertDD_STOCK_ETF");

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
			}else{
				check++;
				if ( check > 30 ) {
					return false;
				}
			}


			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());
		}


		return true;

	}




	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日であるときのみ実行する。
	private void everyDayBotton_INDEX(String DAY,S s){

		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();


		//			CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),DAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}

		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
		InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(bbb.getList_CSVtoDTO_INDEX(),DAY, s);

	}

	private void hisabisaDayBottonContoroll_INDEX(String MAXDAY , String TODAY , S s){

		NetBean NB = new NetBean();

		//株と指数
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.INDEX_LIST + Net_Adress.DOWN_ITEM_9, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_INDEX(NB.getUrlCsv(),TODAY,0);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}


		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_INDEX(), s);


		//MAXDAYから今日までのデータをインサート開始。ストック、インデックス、統計も全部

		if(insertDD_INDEX(MAXDAY,TODAY,s)){

		}else{
			System.out.println("こりゃだめだ：指数");
		}
	}

	private boolean insertDD_INDEX(String MAXDAY,String TODAY,S s){
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
		System.out.println("今からINDEXの更新：insertDD_INDEX");

		int check = 0;
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
			}else{
				check++;
				if ( check > 30 ) {
					return false;
				}
			}


			calendar.add(Calendar.DAY_OF_MONTH, +1);
			MAXDAY = sdf1.format(calendar.getTime());
		}


		return true;

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

		//取得したDTOをもとに時系列テーブルにデータを挿入
		ID.InsertDD_STOCK_ETF(DTO,DAY, s);

	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY_INDEX(List<Bean_CodeList> DTO ,String DAY,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入
		ID.InsertDD_INDEX(DTO, DAY, s);

	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY_STATISTICS(List<Bean_CodeList> DTO,String TODAY ,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入
		ID.InsertDD_STATISTICS(DTO,TODAY, s);


	}

	private void InsertList_CreateTBL_DD_hisabisa(List<Bean_CodeList> DTO ,S s){
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入

	}

}
