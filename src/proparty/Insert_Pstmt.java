package proparty;

public class Insert_Pstmt {


	public static String sqlRecord = "";
	public static String sqlQuestion = "";


	//INSERT INTO tbl_name (col_name1, col_name2, ...) VALUES (value1, value2, ...), (value1, value2, ...), (value1, value2, ...);
	//これのvalues以降の文章を作成する。Pstmt向けを想定
	//questionNum：?の数
	//recordNum：追加するレコードの数
	//どちらも正の整数を入力するものとする。
	//レコード数が増えた時の処理をもっと軽やかにしたい。
	public static String insertFooder(int questionNum,int recordNum){
		try{
		switch(recordNum){
			case 1:
				sqlRecord = getQuestion(questionNum);
				break;
			default:
				sqlRecord = getQuestion(questionNum);
				for (int i =1;i<recordNum;i++){
					sqlRecord = sqlRecord + "," + getQuestion(questionNum);
				}
		}
		}catch(Exception e){
			System.out.println("パンク");
		}
		return " " + sqlRecord + " ";
	}

	public static String getQuestion(int questionNum){

		switch (questionNum){
			case 1:
				sqlQuestion = "(?)";
				break;
			default:
				sqlQuestion = "?";
				for (int i =1;i<questionNum;i++){
					sqlQuestion = sqlQuestion + ",?";
				}
				sqlQuestion = "(" + sqlQuestion + ")";
		}
		return sqlQuestion;
	}

	public static void serStmt(){
		
	}
}
