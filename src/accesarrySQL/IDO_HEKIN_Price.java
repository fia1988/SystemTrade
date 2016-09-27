package accesarrySQL;

import java.sql.ResultSet;

import proparty.S;
import proparty.TBL_Name;
import constant.AccesarryParameta;
import constant.COLUMN;
import constant.ReCord;

public class IDO_HEKIN_Price extends Super_IDO_HEKIN{

	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6
	public static void setIDO_Heikin(String code,String cate,String dayTime,S s){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setStockIDO_Heikin(code, TBL_Name.STOCK_DD, dayTime,s);
			break;
		case ReCord.CODE_02_SATISTICS:
			setStaticsIDO_Heikin(code, TBL_Name.STATISTICS_DD, dayTime,s);
			break;
		case ReCord.CODE_03_INDEX:
			setIndexIDO_Heikin(code, TBL_Name.INDEX_DD, dayTime,s);
			break;
		case ReCord.CODE_04_ETF:
			setETFIDO_Heikin(code, TBL_Name.ETF_DD, dayTime,s);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setSakimonoDO_Heikin(code, TBL_Name.SAKIMONO_DD, dayTime,s);
			break;
		case ReCord.CODE_06_CURRENCY:
			setCurrencyIDO_Heikin(code, TBL_Name.CURRENCY_DD, dayTime,s);
			break;
		default:
			System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	//個別銘柄・・・1
	private static void setStockIDO_Heikin(String code,String TBL,String dayTime,S s){
		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s);


		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s);


		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s);
	}

	//統計・・・2
	private static void setStaticsIDO_Heikin(String code,String TBL,String dayTime,S s){
//		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s);

		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s);

		//値上がり
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_UPPRICE_IDO_SHORT),(COLUMN.STOCK_UPSTOCK), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_UPPRICE_IDO_MIDDLE),(COLUMN.STOCK_UPSTOCK), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_UPPRICE_IDO_LONG),(COLUMN.STOCK_UPSTOCK), s);

		//変わらず
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_NOCHANGE_IDO_SHORT),(COLUMN.STOCK_NOCHANGE), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_NOCHANGE_IDO_MIDDLE),(COLUMN.STOCK_NOCHANGE), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_NOCHANGE_IDO_LONG),(COLUMN.STOCK_NOCHANGE), s);

	}

	//指数・・・3
	private static void setIndexIDO_Heikin(String code,String TBL,String dayTime,S s){
		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s);
	}

	//ETF・・・4
	private static void setETFIDO_Heikin(String code,String TBL,String dayTime,S s){
		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s);


		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s);


		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s);
	}

	//先物・・・5
	private static void setSakimonoDO_Heikin(String code,String TBL,String dayTime,S s){
//		setIDOHeikinPrice_base(code,TBL,,dayTime,0,"","",s);
	}

	//通貨・・・6
	private static void setCurrencyIDO_Heikin(String code,String TBL,String dayTime,S s){
//		setIDOHeikinPrice_base(code,TBL,,dayTime,0,"","",s);
	}














	public static void setIDO_Heikin(String code,String cate,String dayTime,S s,ResultSet EDIT){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		switch(cate){
		case ReCord.CODE_01_STOCK:
			setStockIDO_Heikin(code, TBL_Name.STOCK_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_02_SATISTICS:
			setStaticsIDO_Heikin(code, TBL_Name.STATISTICS_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_03_INDEX:
			setIndexIDO_Heikin(code, TBL_Name.INDEX_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_04_ETF:
			setETFIDO_Heikin(code, TBL_Name.ETF_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_05_SAKIMONO:
			setSakimonoDO_Heikin(code, TBL_Name.SAKIMONO_DD, dayTime,s,EDIT);
			break;
		case ReCord.CODE_06_CURRENCY:
			setCurrencyIDO_Heikin(code, TBL_Name.CURRENCY_DD, dayTime,s,EDIT);
			break;
		default:
			System.out.println("setIDO_Heikinなんかよくわからないの来た：" + code + ":" + cate);
			break;
		}
	}

	//個別銘柄・・・1
	private static void setStockIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);


		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s,EDIT);


		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s,EDIT);
	}

	//統計・・・2
	private static void setStaticsIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s,EDIT);

		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);

		//値上がり
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_UPPRICE_IDO_SHORT),(COLUMN.STOCK_UPSTOCK), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_UPPRICE_IDO_MIDDLE),(COLUMN.STOCK_UPSTOCK), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_UPPRICE_IDO_LONG),(COLUMN.STOCK_UPSTOCK), s,EDIT);

		//変わらず
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_NOCHANGE_IDO_SHORT),(COLUMN.STOCK_NOCHANGE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_NOCHANGE_IDO_MIDDLE),(COLUMN.STOCK_NOCHANGE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_NOCHANGE_IDO_LONG),(COLUMN.STOCK_NOCHANGE), s,EDIT);

		//寝付き
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_GETPRICE_IDO_SHORT),(COLUMN.STOCK_GETPRICE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_GETPRICE_IDO_MIDDLE),(COLUMN.STOCK_GETPRICE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_GETPRICE_IDO_LONG),(COLUMN.STOCK_GETPRICE), s,EDIT);

		//騰落レシオ
		//列の再利用として、shortIDO_stock_upprice_changeRateを使う
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.STOCK_UPPRICE_IDO_SHORT_CHANGERATE),(COLUMN.NETUKI_MAXMINRATIO), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.STOCK_UPPRICE_IDO_MIDDLE_CHANGERATE),(COLUMN.NETUKI_MAXMINRATIO), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.STOCK_UPPRICE_IDO_LONG_CHANGERATE),(COLUMN.NETUKI_MAXMINRATIO), s,EDIT);
	}

	//指数・・・3
	private static void setIndexIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s,EDIT);
	}

	//ETF・・・4
	private static void setETFIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
		//売買高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_BAYBAY),(COLUMN.BAYBAY), s,EDIT);


		//出来高
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO_DEKI),(COLUMN.DEKI), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO_DEKI),(COLUMN.DEKI), s,EDIT);


		//終値の移動平均線
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOSHORT, (COLUMN.SHORTIDO),(COLUMN.CLOSE), s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOMIDDLE, (COLUMN.MIDDLEIDO), (COLUMN.CLOSE),s,EDIT);
		setIDOHeikin_base(code,TBL, dayTime, AccesarryParameta.IDOLONG, (COLUMN.LONGIDO), (COLUMN.CLOSE),s,EDIT);
	}

	//先物・・・5
	private static void setSakimonoDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		setIDOHeikinPrice_base(code,TBL,,dayTime,0,"","",s,EDIT);
	}

	//通貨・・・6
	private static void setCurrencyIDO_Heikin(String code,String TBL,String dayTime,S s,ResultSet EDIT){
//		setIDOHeikinPrice_base(code,TBL,,dayTime,0,"","",s,EDIT);
	}

}
