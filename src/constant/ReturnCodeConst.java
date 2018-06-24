package constant;

public class ReturnCodeConst {

	//SQL文用のセパレータ
	final public static String SQL_SEPA = "/";
	//SQL用のエラー文

	//成功
	final public static int SQL_ERR_0 = 0;
	//ディレクトリが存在しない
	final public static int SQL_ERR_1 = 1;
	//LOAD失敗。ファイルが存在しないとか？
	final public static int SQL_ERR_29 = 29;
	//ユーザー名、パスワードエラー
	final public static int SQL_ERR_1045 = 1045;
	//テーブル重複
	final public static int SQL_ERR_1050 = 1050;
	//列がない
	final public static int SQL_ERR_1054 = 1054;
	//レコード重複
	final public static int SQL_ERR_1062 = 1062;
	//ファイルが既に存在する
	final public static int SQL_ERR_1086 = 1086;

	//時系列更新ありそう。チェック開始
	final public static int CHECK_START	=10002;
	//時系列更新があった。
	final public static int EVERY_UPDATE_SUCSESS	=10000;
	//一部分だけ更新があった。
	final public static int EVERY_UPDATE_ODD_SUCSESS	=10001;
	//時系列更新がなかった
	final public static int EVERY_UPDATE_NOTHING	=20000;
	//時系列更新に異常があった
	final public static int EVERY_UPDATE_ERR		=30000;
	//時系列更新にふさわしくない時間に起動した
	final public static int NO_UPDATE_TIME	=40000;
	//意図しないよくわからんエラー
	final public static int NAZO_ERR		=99999;
}
