package GamenDTO;

import proparty.PROPARTY;

public class TAB_MainDTO {
	//MYSQLID
	private String mysqlID;
	//MYSQLPASS
	private String mysqlPass;
	//タイマー起動中かどうか判定
	private boolean judgeTimer;
	//logFilePath。ログファイル出力先
	private String logFilePath;
	//日々の売買ファイル出力先
	private String entryFolderPath;
	//合併分割ファイルのファイルパス
	private String sepaCombineFilePath;
	//バックアップ出力フォルダパス
	private String outBackUpFolderPath;
	//バックアップ入力ファイルパス
	private String inBackUpFilePath;






	public String getEntryFolderPath() {
		return entryFolderPath;
	}
	public void setEntryFolderPath(String entryFolderPath) {
		this.entryFolderPath = entryFolderPath;
	}
	public String getSepaCombineFilePath() {
		return sepaCombineFilePath;
	}
	public void setSepaCombineFilePath(String sepaCombineFilePath) {
		this.sepaCombineFilePath = sepaCombineFilePath;
	}
	public String getOutBackUpFolderPath() {
		return outBackUpFolderPath;
	}
	public void setOutBackUpFolderPath(String outBackUpFolderPath) {
		this.outBackUpFolderPath = outBackUpFolderPath;
	}
	public String getInBackUpFilePath() {
		return inBackUpFilePath;
	}
	public void setInBackUpFilePath(String inBackUpFilePath) {
		this.inBackUpFilePath = inBackUpFilePath;
	}
	public void setJudgeTimer(boolean judgeTimer) {
		this.judgeTimer = judgeTimer;
	}
	public boolean isJudgeTimer() {
		return judgeTimer;
	}
	public void setJudgeTimer(String judgeTimer) {
		boolean resultJudgeTimer = Boolean.valueOf( judgeTimer );
		this.judgeTimer = resultJudgeTimer;
	}
	public String getMysqlID() {
		return mysqlID;
	}
	public void setMysqlID(String mysqlID) {
		PROPARTY.DBUSER = mysqlID;
		this.mysqlID = mysqlID;
	}
	public String getMysqlPass() {
		return mysqlPass;
	}
	public void setMysqlPass(String mysqlPass) {
		PROPARTY.DBPASS = mysqlPass;
		this.mysqlPass = mysqlPass;
	}
	public String getLogFilePath() {
		return logFilePath;
	}
	public void setLogFilePath(String logFilePath) {
		PROPARTY.LOG_FILE_OUT = logFilePath;
		this.logFilePath = logFilePath;
	}





}