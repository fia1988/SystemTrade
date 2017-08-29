package netConnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import proparty.Net_Adress;
import proparty.PROPARTY;
import bean.Bean_CodeList;
import bean.Bean_TBLRecord;

import common.commonAP;

import constant.logWriting;



public class NetBean extends NetSuper{

	private List<String> codeList_Stock = new ArrayList<String>();
	private List<String[]> codeList_Stock2 = new ArrayList<String[]>();
	private String[] codeList_Stock_Arary;
	private String[] codeList_Stock_Sprit;
	private Bean_CodeList DTO_B_C;
	private Bean_TBLRecord DTO_B_T;
	private List<Bean_CodeList> DTO_B_C_LIST_STOCK = new ArrayList<Bean_CodeList>();
	private List<Bean_CodeList> DTO_B_C_LIST_IDX = new ArrayList<Bean_CodeList>();
	private List<Bean_CodeList> DTO_B_C_LIST_Statistical = new ArrayList<Bean_CodeList>();
	private List<Bean_CodeList> DTO_B_C_LIST_Future = new ArrayList<Bean_CodeList>();
	private List<Bean_CodeList> DTO_B_C_LIST_Currency = new ArrayList<Bean_CodeList>();
	private List<Bean_TBLRecord> DTO_B_T_LIST = new ArrayList<Bean_TBLRecord>();
	private int x =0;
	int year;
	private String[][] codeList_Stock_Array2;

	private List<String> netFile = new ArrayList<String>();
	private List<List<String>> netFileS = new ArrayList<List <String>>();


	//リバースは何をいれても逆から入れる。
	public void setUrlCsv(String URL,int skipLine,int intervalTime,boolean reverse){
		netFile = new ArrayList<String>();
		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;

		try{

			//ちょっと間をおいてから動かす。連続実行するときは多少はね。
			Thread.sleep(intervalTime);

			//概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);



			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}


			String lineRecord = baf.readLine();
			System.out.println("一行目：" + lineRecord);

			//アクセス拒否された場合の動き
			if(lineRecord==null){
				commonAP.writeInLog(("NetBean：アクセス拒否中。" + PROPARTY.SLEEPTIME + "秒待ちます。") ,logWriting.DATEDATE_LOG_FLG);

				//ちょっとだけ時間に間を置く。連続アクセスするとリジェクトされる。
				try {
					Thread.sleep(PROPARTY.SLEEPTIME);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				setUrlCsv(URL,skipLine,intervalTime);
				return;
			}else if(lineRecord.equals(PROPARTY.NAZO)){
				commonAP.writeInLog("NetBean：503かも。" + ( PROPARTY.SLEEPTIME-145000 ) + "秒待まってもう一回。" ,logWriting.DATEDATE_LOG_FLG);
				try {
					Thread.sleep(PROPARTY.SLEEPTIME-145000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				setUrlCsv(URL,skipLine,intervalTime);
				return;
			}


			netFile.add(lineRecord);
//			System.out.println(lineRecord);
			while ((lineRecord = baf.readLine()) != null) {
//				System.out.println(lineRecord);
				netFile.add(lineRecord);
			}



		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
//			e.printStackTrace();
			commonAP.writeInLog("ページがないよ：" + URL ,logWriting.DATEDATE_LOG_FLG);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
				commonAP.writeInLog("NetBean109でIOEXception",logWriting.DATEDATE_LOG_FLG);
				e.printStackTrace();
			}
		}
	}

	public void setUrlCsv(String URL,int skipLine,int intervalTime){
		netFile = new ArrayList<String>();
		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;

		try{

			//ちょっと間をおいてから動かす。連続実行するときは多少はね。
			Thread.sleep(intervalTime);

			//概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);



			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}


			String lineRecord = baf.readLine();
			System.out.println("一行目：" + lineRecord);

			//アクセス拒否された場合の動き
			if(lineRecord==null){
				System.out.println("NetBean：アクセス拒否中。"+PROPARTY.SLEEPTIME+"ﾐﾘ秒待ちます。");
				//ちょっとだけ時間に間を置く。連続アクセスするとリジェクトされる。
				try {
					Thread.sleep(PROPARTY.SLEEPTIME);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				setUrlCsv(URL,skipLine,intervalTime);
				return;
			}else if(lineRecord.equals(PROPARTY.NAZO)){
				System.out.println("NetBean：503かも。"+(PROPARTY.SLEEPTIME-145000)+"ﾐﾘ秒待まってもう一回。");
				try {
					Thread.sleep(PROPARTY.SLEEPTIME-145000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				setUrlCsv(URL,skipLine,intervalTime);
				return;
			}


			netFile.add(lineRecord);
//			System.out.println(lineRecord);
			while ((lineRecord = baf.readLine()) != null) {
//				System.out.println(lineRecord);
				netFile.add(lineRecord);
			}



		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
//			e.printStackTrace();

			System.out.println("ページがないよ：" + URL);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
				System.out.println("NetBean109でIOEXception");
				e.printStackTrace();
			}
		}
	}

	public boolean setUrlCsv(String URL,int skipLine){
		netFile = new ArrayList<String>();
//		System.out.println("ここきた" + URL);
		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;

		try{

			Thread.sleep(PROPARTY.INTERVALTIME);

			//概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);


			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}


			String lineRecord = baf.readLine();
//			System.out.print("一行目：" + lineRecord);

			//アクセス拒否された場合の動き
			if(lineRecord==null){
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
				return false;
			}else if(lineRecord.equals(PROPARTY.NAZO)){
				commonAP.writeInLog("NetBean：503かも。" + PROPARTY.INTERVALTIME + "ﾐﾘ秒待まってもう一回。" ,logWriting.DATEDATE_LOG_FLG);
				try {
					Thread.sleep(PROPARTY.INTERVALTIME);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				return setUrlCsv(URL,skipLine);

//				if ( setUrlCsv(URL,skipLine) ){
//					return true;
//				}else {
//					System.out.println("ふぁるす：" + URL);
//					return false;
//				}


			}else if(lineRecord.equals(PROPARTY.NAZO2)){
				commonAP.writeInLog("NetBean：503かも。" + PROPARTY.INTERVALTIME + "ﾐﾘ秒待まってもう一回。" ,logWriting.DATEDATE_LOG_FLG);
				try {
					Thread.sleep(PROPARTY.INTERVALTIME);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				return setUrlCsv(URL,skipLine);

			}


			netFile.add(lineRecord);
//			System.out.println(lineRecord);

			while ((lineRecord = baf.readLine()) != null) {
//				System.out.println(lineRecord + ":" + URL);
				netFile.add(lineRecord);
			}
//			System.out.println("ひょっとして・・・？");
		}catch(IOException e1) {
			//403エラーのときの動き
			commonAP.writeInLog("NetBean：403かも。" + PROPARTY.INTERVALTIME + "ﾐﾘ秒待まってもう一回。"+ URL ,logWriting.DATEDATE_LOG_FLG);
			return setUrlCsv(URL,skipLine);

		}catch(Exception e2){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
			e2.printStackTrace();
			commonAP.writeInLog("【なぞのエラー】" + URL ,logWriting.DATEDATE_LOG_FLG);

			return setUrlCsv(URL,skipLine);

		}finally{
			try {
				//				URL切断

				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e3) {
				System.out.println("NetBean109でIOEXception");
				e3.printStackTrace();
			} catch (NullPointerException e5) {
//				baf.close();でミスったとき

//				System.out.println("NetBean109でnurupo");
//				System.out.println(URL);
			} catch (Exception e4) {
				System.out.println("NetBean109でEXception");
				System.out.println(URL);
				e4.printStackTrace();
			}
		}

		if ( netFile.size() < 20 ){
			commonAP.writeInLog("レコードが少なすぎるエラー",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("アクセスURLは以下",logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog(URL,logWriting.DATEDATE_LOG_FLG);
			commonAP.writeInLog("レコード内容は以下",logWriting.DATEDATE_LOG_FLG);
		    for (String naka: netFile){
		    	commonAP.writeInLog(naka,logWriting.DATEDATE_LOG_FLG);
		    }
			return false;
		}else{
			return true;
		}

		
	}


//	public void setUrlCsv(String URL,int skipLine){
//		netFile = new ArrayList<String>();
//		HttpURLConnection connect = null;
//		URL url = null;
//		InputStream in = null;
//		InputStreamReader isr = null;
//		BufferedReader baf = null;
//
//		try{
//
//			Thread.sleep(PROPARTY.INTERVALTIME);
//
//			//概ねの操作で例外処理が必要です。
//			//URLを作成する
//			String adress= URL;
//			url=new URL(adress);//URLを設定
//			// URL接続
//			connect = (HttpURLConnection)url.openConnection();//サイトに接続
//			connect.setRequestMethod("GET");//プロトコルの設定
//			in=connect.getInputStream();//ファイルを開く
//			isr = new InputStreamReader( in,"SJIS");
//			baf = new BufferedReader(isr);
//
//
//			for (int i = 0;i<skipLine;i++){
//				baf.readLine();
//			}
//
//
//			String lineRecord = baf.readLine();
//			System.out.println("一行目：" + lineRecord);
//
//			//アクセス拒否された場合の動き
//			if(lineRecord==null){
//				System.out.println("NetBean：アクセス拒否中。" + PROPARTY.SLEEPTIME + "ﾐﾘ秒待ちます。");
//				//ちょっとだけ時間に間を置く。連続アクセスするとリジェクトされる。
//				try {
//					Thread.sleep(PROPARTY.SLEEPTIME);
//				} catch (InterruptedException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//				setUrlCsv(URL,skipLine);
//				return;
//			}else if(lineRecord.equals(PROPARTY.NAZO)){
//				System.out.println("NetBean：503かも。" + PROPARTY.INTERVALTIME + "ﾐﾘ秒待まってもう一回。");
//				try {
//					Thread.sleep(PROPARTY.INTERVALTIME);
//				} catch (InterruptedException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//				setUrlCsv(URL,skipLine);
//				return;
//			}
//
//
//			netFile.add(lineRecord);
////			System.out.println(lineRecord);
//			while ((lineRecord = baf.readLine()) != null) {
////				System.out.println(lineRecord);
//				netFile.add(lineRecord);
//			}
//
//
//
//		}catch(Exception e){
//			//例外処理が発生したら、表示する
//			//			System.out.println("Err =" + e);
////			e.printStackTrace();
//
//			System.out.println("ページがないよ：" + URL);
//		}finally{
//			try {
//				//				URL切断
//				baf.close();
//				isr.close();
//				in.close();//InputStreamを閉じる
//				connect.disconnect();//サイトの接続を切断
//			} catch (IOException e) {
//				System.out.println("NetBean109でIOEXception");
//				e.printStackTrace();
//			}
//		}
//	}

	public List<String> getUrlCsv(){
		return netFile;

	}

	public void setUrlCsvS(List<String> FILE){
//		System.out.println(FILE.get(0));
		netFileS.add(FILE);
	}

	public List<List<String>> getUrlCsvS(){
		return netFileS;
	}



	public void takeCSV(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.set(2006, 0, 14);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		System.out.println(sdf1.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf1.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		System.out.println(sdf1.format(calendar.getTime()));

	}




	public void setINDEXDD(List<Bean_TBLRecord> DTO,String indexName,String MAX_DAY_HAIHUN){

	}

	//sleepTime:連続アクセスするとリジェクトされるのでsleepTimeミリ秒の間隔を置いてデータ取得。
	public void setCodeDD(List<Bean_TBLRecord> DTO,String stockName,String MAX_DAY_HAIHUN){



		//重複データを入れないような工夫をしている
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);
		setNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear),2,MAX_DAY_HAIHUN);

//		System.out.println("NETBEAN1" + Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear));


//		int j = 1;
//
//		while(getFlg()==false){
//			setPlusNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - j),2);
//			j++;
//			System.out.println(j);
//			System.out.println("whie:" + getFlg());
//		}
//		System.out.println("外:" + getFlg());
			int count = 1;

//			System.out.println("SetCodeDD1:" + getEndFlg() + ":" + getFlg());
		while(getEndFlg() && getFlg()){

//			System.out.println("NETBeam2" + Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - count));
			setPlusNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - count),2,MAX_DAY_HAIHUN);
			count++;

		}
		System.out.println("SetCodeDD2:" + getEndFlg() + ":" + getFlg());
//		WHILEがだめなら以下のfor分を動かす
//		for (int k = 1;k<PROPARTY.COLLECTYEAR;k++){
//
//			if (getEndFlg()==false){
//				break;
//			}
//			setPlusNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - k),2,MAX_DAY_HAIHUN);
//			if (getFlg()==false){
//				break;
//			}
//			count++;
//		}
//		System.out.println("カウント" + count);

		codeList_Stock = getNetCSV();

		//MAX_Dの取得
		Collections.sort(codeList_Stock);
		System.out.println(stockName + "の追加レコード数：" + codeList_Stock.size());

		for(int i = 0;i<codeList_Stock.size();i++){

			codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;
			DTO_B_T = new Bean_TBLRecord();
			DTO_B_T.setDay    (codeList_Stock_Sprit[0]);
			DTO_B_T.setOpen   (codeList_Stock_Sprit[1]);
			DTO_B_T.setMax    (codeList_Stock_Sprit[2]);
			DTO_B_T.setMin    (codeList_Stock_Sprit[3]);
			DTO_B_T.setClose  (codeList_Stock_Sprit[4]);
			DTO_B_T.setDeki   (codeList_Stock_Sprit[5]);
			DTO_B_T.setBaybay (codeList_Stock_Sprit[6]);
			DTO.add(DTO_B_T);
		}

		DTO_B_T_LIST = DTO;
	}

	public List<Bean_TBLRecord> getCodeDD(){
		return DTO_B_T_LIST;
	}


	//通貨リストをセットする。
	//未完成


	//通貨リストをゲットする。


	//先物リストセットする
	//未完成
	public void setCodeList_FUTURE(List<Bean_CodeList> DTO){

		setNetCSV(Net_Adress.FUTURES,2);
		codeList_Stock = getNetCSV();
		Collections.sort(codeList_Stock);


		 for(int i=0;i<codeList_Stock.size();i++){
			 DTO_B_C = new Bean_CodeList();
			 //","でなく" "を使っているのは先物の区切りがおかしいから。
			 //URL見るとわかる
			 codeList_Stock_Sprit = codeList_Stock.get(i).split(" ") ;

//			 DTO_B_C.setFuture_flg();

			 //ここらへんを変える
			 DTO_B_C.setCodeName        (codeList_Stock_Sprit[0]);
			 DTO.add(DTO_B_C);

		 }

		 DTO_B_C_LIST_Future = DTO;


	}

	//先物リストをゲットする。
	public List<Bean_CodeList> getCodeList_FUTURE(){
		return DTO_B_C_LIST_Future;
	}

	//市場統計リストをセットする
	//未完成
	public void setCodeList_Statistical(List<Bean_CodeList> DTO){
		setNetCSV(Net_Adress.STATISTICS,2);
		codeList_Stock = getNetCSV();
		Collections.sort(codeList_Stock);


		 for(int i=0;i<codeList_Stock.size();i++){
			 DTO_B_C = new Bean_CodeList();

			 codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;

//			 DTO_B_C.setStatistical_flg();


			 //ここらへんを変える
			 DTO_B_C.setCodeName        (codeList_Stock_Sprit[0]);
			 DTO.add(DTO_B_C);

		 }

		 DTO_B_C_LIST_Statistical = DTO;
	}

//	統計リストを取得
	public List<Bean_CodeList> getCodeList_Statistical(){
		return DTO_B_C_LIST_Statistical;
	}

	//インデックス、指標リストを取得する
	//未完成
	public void setCodeList_Index(List<Bean_CodeList> DTO){
		setNetCSV(Net_Adress.INDEX,2);
		codeList_Stock = getNetCSV();
		Collections.sort(codeList_Stock);

		 for(int i=0;i<codeList_Stock.size();i++){
			 DTO_B_C = new Bean_CodeList();

			 codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;

//			 DTO_B_C.setIndex_flg();


			 //ここらへんを変える
			 DTO_B_C.setCodeName       (codeList_Stock_Sprit[0]);
			 DTO.add(DTO_B_C);

		 }

		 DTO_B_C_LIST_IDX = DTO;
	}

	//指標リストが取得できる。
	public List<Bean_CodeList> getCodeList_Index(){
		return DTO_B_C_LIST_IDX;
	}


	public void setCodeList_Stock(List<Bean_CodeList> DTO){
		setNetCSV(Net_Adress.CODELIST_STOCK,2);
		codeList_Stock = getNetCSV();
//		codeList_Stockを配列に変換
//		codeList_Stock_Arary =  (String[])codeList_Stock.toArray(new String[0]);
		//ソートする
//		Arrays.sort(codeList_Stock_Arary);
		Collections.sort(codeList_Stock);
		//スプリットする
//		codeList_Stock_Array2 = new String[codeList_Stock_Arary.length][];
		 for(int i=0;i<codeList_Stock.size();i++){
			 DTO_B_C = new Bean_CodeList();

			 codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;

//			 DTO_B_C.setCompany_flg ();
			 DTO_B_C.setCode        (codeList_Stock_Sprit[0]);
			 DTO_B_C.setMarket      (codeList_Stock_Sprit[1]);
			 DTO_B_C.setCodeName    (codeList_Stock_Sprit[2]);
			 DTO_B_C.setCategory    (codeList_Stock_Sprit[3]);
			 DTO.add(DTO_B_C);

		 }

		 DTO_B_C_LIST_STOCK = DTO;
	}

	//二次元配列で証券コードリストが取得できる。
	public List<Bean_CodeList> getCodeList_Stock(){
		return DTO_B_C_LIST_STOCK;
	}


}
