package constant;

public class ReturnCodeConst {

	//SQL文用のセパレータ
	final public static String SQL_SEPA = "/";
	//SQL用のエラー文

	//成功
	final public static int SQL_ERR_0 = 0;
	//ディレクトリが存在しない
	final public static int SQL_ERR_1 = 1;
	//レコード重複
	final public static int SQL_ERR_1062 = 1062;
	//ファイルが既に存在する
	final public static int SQL_ERR_1086 = 1086;

	//時系列更新があった。
	final public static int EVERY_UPDATE_SUCSESS	=10000;
	//時系列更新がなかった
	final public static int EVERY_UPDATE_NOTHING	=20000;
	//時系列更新に異常があった
	final public static int EVERY_UPDATE_ERR		=30000;
}
