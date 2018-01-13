package GAMEN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proparty.TBL_Name;
import proparty.controllDay;
import GamenDTO.TAB_MainDTO;
import GamenNyuryokuCheck.nyuryokuCheck;
import botton.BackUp;
import botton.CreateSepaComFile;
import botton.ResetShori;
import botton.SepaCombine;
import botton.TimeClornigDate;
import botton.cloringDate;
import botton.setUp;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class TAB_main extends JPanel {




	private JTextField mysqlID;
	private JPasswordField mysqlPassMask;
	private JTextField logFolderPath;
	private JTextField entryFolderPath;
	private JTextField sepaComFolderPath;
	private JTextField outBackUplogFolderPath;
	private JTextField inBackUplogFilePath;

	JCheckBox checkBox = new JCheckBox("分割併合ファイル自動取込チェック");
	JCheckBox checkBox_1 = new JCheckBox("最適化チェックフラグ");
	JCheckBox checkBox_2 = new JCheckBox("自動バックアップ制御");
	JCheckBox checkBox_3 = new JCheckBox("へそごまローカルフラグ");
	JCheckBox checkBox_4 = new JCheckBox("へそごま利用チェック");
	JCheckBox checkBox_5 = new JCheckBox("即座に日々ファイル取込");
//	JCheckBox checkBox_5 = new JCheckBox("即座に日々ファイル取込");

	JLabel timerCheck = new JLabel("false");
	JLabel sepaComResult = new JLabel("成／否");
	JLabel deleteS_Cresult = new JLabel("成／否");
	JLabel deleteKeepResult = new JLabel("成／否");
	JLabel deleteRecordResult = new JLabel("成／否");
	JLabel deleteDBresult = new JLabel("成／否");
	JLabel createTBLresult = new JLabel("成／否");
	JLabel inBackupResult = new JLabel("成／否");
	JLabel outBackupResult = new JLabel("成／否");
	JLabel oneShotResult = new JLabel("成／否");
	JLabel kickResult = new JLabel("成／否");
	JLabel timerResult = new JLabel("ボタンを押してね");
	JLabel oneShotSepaComResult = new JLabel("成／否");

	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private final Action action_9 = new SwingAction_9();
	private final Action action_10 = new SwingAction_10();

	/**
	 * Create the panel.
	 */
	public TAB_main() {
		setLayout(null);

		logFolderPath = new JTextField();
		logFolderPath.setBounds(42, 362, 330, 25);
		add(logFolderPath);
		logFolderPath.setColumns(10);

		JButton btnNewButton = new JButton("timerOn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(65, 79, 119, 27);
		add(btnNewButton);

		JButton btnTest = new JButton("test");
		btnTest.setAction(action_1);
		btnTest.setBounds(201, 79, 119, 27);
		add(btnTest);

		JLabel label = new JLabel("タイマー：");
		label.setBounds(42, 45, 73, 19);
		add(label);

//		JLabel timerCheck = new JLabel("false");
		timerCheck.setBounds(124, 45, 73, 19);
		add(timerCheck);

		mysqlID = new JTextField();
		mysqlID.setColumns(10);
		mysqlID.setBounds(95, 210, 136, 25);
		add(mysqlID);

		JLabel lblMysql = new JLabel("MYSQL情報");
		lblMysql.setBounds(42, 176, 142, 19);
		add(lblMysql);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(42, 213, 52, 19);
		add(lblId);

		JLabel lblPass = new JLabel("pass:");
		lblPass.setBounds(42, 247, 52, 19);
		add(lblPass);


		timerResult.setBounds(42, 121, 375, 19);
		add(timerResult);

		entryFolderPath = new JTextField();
		entryFolderPath.setColumns(10);
		entryFolderPath.setBounds(42, 434, 330, 25);
		add(entryFolderPath);

		JLabel label_1 = new JLabel("ログファイル出力先フォルダパス");
		label_1.setBounds(42, 333, 375, 19);
		add(label_1);

		JLabel label_2 = new JLabel("日々売買ファイル出力先フォルダパス");
		label_2.setBounds(42, 402, 330, 19);
		add(label_2);

		JLabel label_3 = new JLabel("合併／分割取込ファイルパス セパレータ「/」");
		label_3.setBounds(397, 45, 289, 19);
		add(label_3);

		sepaComFolderPath = new JTextField();
		sepaComFolderPath.setColumns(10);
		sepaComFolderPath.setBounds(434, 80, 330, 25);
		add(sepaComFolderPath);

		JLabel label_4 = new JLabel("結果：");
		label_4.setBounds(434, 155, 60, 19);
		add(label_4);

		sepaComResult.setBounds(488, 155, 316, 19);
		add(sepaComResult);

		JButton button = new JButton("test");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setAction(action_3);
		button.setBounds(434, 113, 119, 27);
		add(button);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action_2);
		btnNewButton_1.setBounds(201, 710, 119, 71);
		add(btnNewButton_1);

		JLabel label_6 = new JLabel("バックアップ");
		label_6.setBounds(399, 189, 165, 19);
		add(label_6);

		outBackUplogFolderPath = new JTextField();
		outBackUplogFolderPath.setColumns(10);
		outBackUplogFolderPath.setBounds(434, 244, 330, 25);
		add(outBackUplogFolderPath);

		inBackUplogFilePath = new JTextField();
		inBackUplogFilePath.setColumns(10);
		inBackUplogFilePath.setBounds(434, 421, 330, 25);
		add(inBackUplogFilePath);

		JButton button_1 = new JButton("test");
		button_1.setAction(action_9);
		button_1.setBounds(434, 270, 165, 27);
		add(button_1);

		JButton button_2 = new JButton("test");
		button_2.setAction(action_10);
		button_2.setBounds(434, 455, 165, 27);
		add(button_2);

		JLabel label_7 = new JLabel("結果：");
		label_7.setBounds(434, 333, 60, 19);
		add(label_7);

		JLabel label_8 = new JLabel("結果：");
		label_8.setBounds(434, 497, 60, 19);
		add(label_8);

		outBackupResult.setBounds(488, 333, 307, 19);
		add(outBackupResult);

		inBackupResult.setBounds(488, 497, 307, 19);
		add(inBackupResult);

		JLabel label_11 = new JLabel("初期設定");
		label_11.setBounds(811, 45, 165, 19);
		add(label_11);

		JButton btnsql_1 = new JButton("下のSQLを手打ちしてね");
		btnsql_1.setBounds(821, 79, 193, 27);
		add(btnsql_1);

		JButton button_4 = new JButton("test");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setAction(action_8);
		button_4.setBounds(821, 155, 193, 27);
		add(button_4);

		JLabel label_12 = new JLabel("結果：");
		label_12.setBounds(832, 505, 60, 19);
		add(label_12);

		JLabel label_13 = new JLabel("結果：");
		label_13.setBounds(831, 196, 60, 19);
		add(label_13);

		deleteDBresult.setBounds(886, 505, 278, 19);
		add(deleteDBresult);

		createTBLresult.setBounds(885, 197, 278, 19);
		add(createTBLresult);

		JLabel label_16 = new JLabel("リセット処理 ※操作注意");
		label_16.setBounds(812, 409, 165, 19);
		add(label_16);

		JButton btnsql = new JButton("下のSQLを手打ちしてね");
		btnsql.setAction(action_4);
		btnsql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnsql.setBounds(832, 464, 193, 27);
		add(btnsql);

		JButton button_6 = new JButton("test");
		button_6.setAction(action_5);
		button_6.setBounds(832, 537, 193, 27);
		add(button_6);

		JButton button_7 = new JButton("test");
		button_7.setAction(action_6);
		button_7.setBounds(832, 606, 193, 27);
		add(button_7);

		JButton button_8 = new JButton("test");
		button_8.setAction(action_7);
		button_8.setBounds(832, 673, 193, 27);
		add(button_8);

		JLabel label_18 = new JLabel("結果：");
		label_18.setBounds(832, 572, 60, 19);
		add(label_18);

		JLabel label_19 = new JLabel("結果：");
		label_19.setBounds(832, 639, 60, 19);
		add(label_19);

		JLabel label_20 = new JLabel("結果：");
		label_20.setBounds(832, 710, 60, 19);
		add(label_20);

		JLabel lblCreateDatabaseKabudata = new JLabel("CREATE DATABASE " + TBL_Name.KABU_DB );
		lblCreateDatabaseKabudata.setBounds(831, 113, 266, 19);
		add(lblCreateDatabaseKabudata);


		deleteRecordResult.setBounds(886, 572, 278, 19);
		add(deleteRecordResult);

		deleteS_Cresult.setBounds(886, 639, 278, 19);
		add(deleteS_Cresult);

		deleteKeepResult.setBounds(886, 710, 278, 19);
		add(deleteKeepResult);

		JLabel label_17 = new JLabel("バックアップ出力先フォルダパス");
		label_17.setBounds(434, 223, 239, 19);
		add(label_17);

		JLabel label_21 = new JLabel("バックアップ入力ファイルパス");
		label_21.setBounds(434, 386, 239, 19);
		add(label_21);

		mysqlPassMask = new JPasswordField();
		mysqlPassMask.setBounds(95, 250, 136, 25);
		add(mysqlPassMask);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setAction(action_11);
		btnNewButton_2.setBounds(821, 230, 193, 27);
		add(btnNewButton_2);

		JLabel label_5 = new JLabel("結果：");
		label_5.setBounds(831, 270, 60, 19);
		add(label_5);


		oneShotResult.setBounds(885, 270, 278, 19);
		add(oneShotResult);

		sepaFolderPath = new JTextField();
		sepaFolderPath.setColumns(10);
		sepaFolderPath.setBounds(42, 502, 330, 25);
		add(sepaFolderPath);

		JLabel label_9 = new JLabel("分割併合ファイル出力先");
		label_9.setBounds(42, 474, 330, 19);
		add(label_9);

		JLabel label_10 = new JLabel("結果：");
		label_10.setBounds(832, 346, 60, 19);
		add(label_10);


		oneShotSepaComResult.setBounds(885, 346, 278, 19);
		add(oneShotSepaComResult);

		JButton button_3 = new JButton("分割併合ファイル取込");
		button_3.setAction(action_12);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(821, 302, 193, 27);
		add(button_3);
		checkBox.setSelected(true);


		checkBox.setBounds(42, 536, 333, 29);
		add(checkBox);

		JLabel label_14 = new JLabel("sepaComKakodataは後に取り込むこと。");
		label_14.setBounds(831, 368, 278, 19);
		add(label_14);


		checkBox_1.setBounds(434, 301, 212, 29);
		add(checkBox_1);
		checkBox_2.setSelected(true);


		checkBox_2.setBounds(42, 281, 239, 29);
		add(checkBox_2);

		JButton btnNewButton_3 = new JButton("キックファイル作成ボタン");
		btnNewButton_3.setAction(action_13);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(434, 581, 212, 27);
		add(btnNewButton_3);

		JLabel label_15 = new JLabel("結果：");
		label_15.setBounds(435, 615, 60, 19);
		add(label_15);


		kickResult.setBounds(488, 615, 316, 19);
		add(kickResult);


		checkBox_3.setBounds(42, 666, 278, 29);
		add(checkBox_3);
		checkBox_4.setSelected(true);
		checkBox_4.setEnabled(false);


		checkBox_4.setBounds(42, 631, 224, 29);
		add(checkBox_4);

		hesoGomaFolderPath = new JTextField();
		hesoGomaFolderPath.setBounds(42, 603, 330, 25);
		add(hesoGomaFolderPath);
		hesoGomaFolderPath.setColumns(10);

		JLabel label_22 = new JLabel("へそごまファイル格納場所");
		label_22.setBounds(42, 572, 330, 19);
		add(label_22);

		
		checkBox_5.setBounds(430, 672, 334, 29);
		add(checkBox_5);



	}


	TimeClornigDate TCD = null;
	private final Action action_11 = new SwingAction_11();
	private JTextField sepaFolderPath;
	private final Action action_12 = new SwingAction_12();
	private final Action action_13 = new SwingAction_13();
	private JTextField hesoGomaFolderPath;


	private void gamenNyuryoku(TAB_MainDTO mainDTO){
		//タイマーの状態のチェック
		mainDTO.setJudgeTimer((  timerCheck.getText() ));
		mainDTO.setMysqlID(mysqlID.getText());
//		mainDTO.setMysqlPass(mysqlPass.getText());
		mainDTO.setMysqlPass(mysqlPassMask.getText());
		mainDTO.setLogFilePath(logFolderPath.getText());
		mainDTO.setEntryFolderPath(entryFolderPath.getText());
		mainDTO.setSepaCombineFilePath(sepaComFolderPath.getText());
		mainDTO.setOutBackUpFolderPath(outBackUplogFolderPath.getText());
		mainDTO.setInBackUpFilePath(inBackUplogFilePath.getText());
		mainDTO.setSepaFolderPath(sepaFolderPath.getText());
		mainDTO.setSepaComFileAutoCaptureFLG(checkBox.isSelected());
		mainDTO.setOptimazeFLG(checkBox_1.isSelected());
		mainDTO.setAutoBackUp(checkBox_2.isSelected());
		mainDTO.setCloringSokuzaCheck(checkBox_5.isSelected());
		
		//へそのごまのファイルを毎日CSVに利用するかを判断するフラグ
		//false:しない、true:する
		mainDTO.setHesogomaFile(checkBox_4.isSelected());
		//false:オンライン、true:ローカル
		mainDTO.setHesoGomaOnlineCheck(checkBox_3.isSelected());
		mainDTO.setEveryDayHesoGomaCsvFolderPath(hesoGomaFolderPath.getText());

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "タイマーオン");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {


			TAB_MainDTO mainDTO = new TAB_MainDTO();
			nyuryokuCheck check = new nyuryokuCheck();

			gamenNyuryoku(mainDTO);

			String checkResult = check.nyuryokuChecker(mainDTO);

			switch (checkResult) {
			case nyuryokuCheckResultConst.SUCCESS:
				timerCheck.setText("true") ;
				timerResult.setText("ツール実行中。。。");
				break;
			case nyuryokuCheckResultConst.ON_TIMER_ERR:
				timerResult.setText(checkResult);
				return;
			case nyuryokuCheckResultConst.MYSQL_ERR:
				timerResult.setText(checkResult);
				return;
			case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
				timerResult.setText(checkResult);
				return;
			case nyuryokuCheckResultConst.NO_ENTRY_FOLDER_ERR:
				timerResult.setText(checkResult);
				return;
			case nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR:
				timerResult.setText(checkResult);
			return;
			case nyuryokuCheckResultConst.NO_BACKUP_FOLDER_ERR:
				timerResult.setText(checkResult);
			return;
			case nyuryokuCheckResultConst.HESO_GOMA_FOLDER_ERR:
				timerResult.setText(checkResult);
			return;
			default:
				timerResult.setText("そのほかエラー");
				return;
			}



//			Calendar now = Calendar.getInstance(); //インスタンス化
//
//			int h = now.get(now.HOUR_OF_DAY);//時を取得
//			int m = now.get(now.MINUTE);     //分を取得
//			int s = now.get(now.SECOND);      //秒を取得
//
//			int y = now.get(Calendar.YEAR);  //年を取得
//			int mo = now.get(Calendar.MONTH);//月を取得
//			int d = now.get(Calendar.DATE); //現在の日を取得
//			System.out.println(h+"時"+m+"分"+s+"秒");



//			System.out.println( Boolean.valueOf(  timerCheck.getText() ) );

			TCD = new TimeClornigDate();
			TCD.getEveryDay(mainDTO);
		}
	}


	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "タイマーオフ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {




			timerCheck.setText("false") ;
			timerResult.setText("ツール停止。。。");
			TCD.cancelEveryDay();

//			a = new TimeClornigDate();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "終了");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			TAB_PROPATY.textField.setText("aaaa");

			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//タイマーの状態のチェック
			mainDTO.setJudgeTimer((  timerCheck.getText() ));
			if ( mainDTO.isJudgeTimer() ){
				return;
			}

			System.exit(0);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "分割取込");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);

			SepaCombine SC = new SepaCombine();
			sepaComResult.setText(nyuryokuCheckResultConst.NOW_SHORI);
			String checkNyuryoku = SC.nyuryokuChecker(mainDTO);
			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					sepaComResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					sepaComResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_FILE_ERR:
					sepaComResult.setText(checkNyuryoku);
					return;
				default:
					return;
			}


			int beforeRecord = SC.getSepaTBLCount();
			int afterRecord = 0;

			int resultSC = SC.loadSepaCombineFile(mainDTO) ;
			if( resultSC == ReturnCodeConst.SQL_ERR_0 ){
				//インポート成功
				afterRecord = SC.getSepaTBLCount();
				afterRecord = afterRecord - beforeRecord;

				sepaComResult.setText(checkNyuryoku + ":" + afterRecord + "件追加");
			}else{
				//インポート失敗
				sepaComResult.setText("インポート失敗");
			}
			//29:ファイルが存在しない
			mainDTO = new TAB_MainDTO();
			SC = new SepaCombine();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "DB削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);


			ResetShori RS = new ResetShori();
			deleteDBresult.setText(nyuryokuCheckResultConst.NOW_SHORI);
			String checkNyuryoku = RS.nyuryokuChecker(mainDTO);

			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					deleteDBresult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					deleteDBresult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_FILE_ERR:
					deleteDBresult.setText(checkNyuryoku);
					return;
				default:
					return;
			}

			if ( RS.resetDB() != ReturnCodeConst.SQL_ERR_0){
				deleteDBresult.setText("失敗。DBが存在しないのかも。");
			};

			deleteDBresult.setText(checkNyuryoku);
			RS = new ResetShori();
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "TBLレコード削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);


			ResetShori RS = new ResetShori();
			deleteRecordResult.setText(nyuryokuCheckResultConst.NOW_SHORI);

			String checkNyuryoku = RS.nyuryokuChecker(mainDTO);

			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					deleteRecordResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					deleteRecordResult.setText(checkNyuryoku);
					return;
				default:
					return;
			}

			deleteRecordResult.setText(checkNyuryoku);
			RS.resetRecord();
			RS = new ResetShori();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "分割リセット");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);



			deleteS_Cresult.setText(nyuryokuCheckResultConst.NOW_SHORI);

			ResetShori RS = new ResetShori();
			String checkNyuryoku = RS.nyuryokuChecker(mainDTO);
			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					deleteS_Cresult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					deleteS_Cresult.setText(checkNyuryoku);
					return;
				default:
					return;
			}


			deleteS_Cresult.setText(checkNyuryoku);
			RS.resetSepaCombine();
			RS = new ResetShori();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "キープテーブル削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);


			deleteKeepResult.setText(nyuryokuCheckResultConst.NOW_SHORI);

			ResetShori RS = new ResetShori();
			String checkNyuryoku = RS.nyuryokuChecker(mainDTO);
			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					deleteKeepResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					deleteKeepResult.setText(checkNyuryoku);
					return;
				default:
					return;
			}
			deleteKeepResult.setText(checkNyuryoku);

			RS.resetKeepResult();
			RS = new ResetShori();
			mainDTO = new TAB_MainDTO();
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "各種TBL作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);


			createTBLresult.setText(nyuryokuCheckResultConst.NOW_SHORI);


			setUp SU = new setUp();

			String checkNyuryoku = SU.nyuryokuChecker(mainDTO);
			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					createTBLresult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					createTBLresult.setText(checkNyuryoku);
					return;
				default:
					return;
			}

			createTBLresult.setText(checkNyuryoku);

			createTBLresult.setText(SU.createTBL());
			SU = new setUp();
			mainDTO = new TAB_MainDTO();
		}
	}
	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "バックアップ開始");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			BackUp BU = new BackUp();

			TAB_MainDTO mainDTO = new TAB_MainDTO();


			//入力チェック
			gamenNyuryoku(mainDTO);

			outBackupResult.setText(nyuryokuCheckResultConst.NOW_SHORI);



			String checkNyuryoku = BU.nyuryokuCheckerOut(mainDTO);

			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					outBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					outBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_FOLDER_ERR:
					outBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.EXACT_BACK_UP_FILE_ERR:
					outBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
					outBackupResult.setText(checkNyuryoku);
					return;
				default:
					return;
			}


			if (mainDTO.isOptimazeFLG()){
				String opResult = BU.optimizeDB(mainDTO);
				if (!opResult.equals(nyuryokuCheckResultConst.SUCCESS)){
					outBackupResult.setText(opResult + ":最適化失敗");
					BU = new BackUp();
					mainDTO = new TAB_MainDTO();
					return;
				}
			}

			String resultBackUpOut = BU.backUpOut(mainDTO,controllDay.getTODAY());
			switch (resultBackUpOut) {
				case nyuryokuCheckResultConst.SUCCESS:
					outBackupResult.setText(resultBackUpOut);
					break;
				default:
					outBackupResult.setText(resultBackUpOut);
				break;
			}


			BU = new BackUp();
			mainDTO = new TAB_MainDTO();
		}
	}
	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "バックアップ取込");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			BackUp BU = new BackUp();
			TAB_MainDTO mainDTO = new TAB_MainDTO();

			//入力チェック
			gamenNyuryoku(mainDTO);


			String checkNyuryoku = BU.nyuryokuCheckerIn(mainDTO);

			inBackupResult.setText(nyuryokuCheckResultConst.NOW_SHORI);

			switch (checkNyuryoku) {
				case nyuryokuCheckResultConst.SUCCESS:
					break;
				case nyuryokuCheckResultConst.ON_TIMER_ERR:
					inBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.MYSQL_ERR:
					inBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_FILE_ERR:
					inBackupResult.setText(checkNyuryoku);
					return;
				case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
					inBackupResult.setText(checkNyuryoku);
					return;
				default:
					return;
			}




			String resultBackUpIn = BU.backUpIn(mainDTO);

			switch (resultBackUpIn) {
				case nyuryokuCheckResultConst.SUCCESS:
					inBackupResult.setText(resultBackUpIn);
					return;
				default:
					inBackupResult.setText(resultBackUpIn);
				break;
			}

			BU = new BackUp();
			mainDTO = new TAB_MainDTO();
		}
	}
	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "ワンショット");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TAB_MainDTO mainDTO = new TAB_MainDTO();
			nyuryokuCheck oneShotCheck = new nyuryokuCheck();

			//入力チェック
			gamenNyuryoku(mainDTO);

			String checkShotResult = oneShotCheck.nyuryokuChecker(mainDTO);

			switch (checkShotResult) {
			case nyuryokuCheckResultConst.SUCCESS:
				break;
			case nyuryokuCheckResultConst.ON_TIMER_ERR:
				oneShotResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.MYSQL_ERR:
				oneShotResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
				oneShotResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.NO_ENTRY_FOLDER_ERR:
				oneShotResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR:
				oneShotResult.setText(checkShotResult);
				return;
			default:
				oneShotResult.setText("そのほかエラー");
				return;
			}


			//一回分のセパ取込
			CreateSepaComFile sepaComCheck = new CreateSepaComFile();
			checkShotResult = sepaComCheck.checkSepaComFile(mainDTO,controllDay.getTODAY());
			oneShotResult.setText(checkShotResult);

			//メモリの解放
			sepaComCheck = new CreateSepaComFile();

			//成功以外は中止
			if (!checkShotResult.equals(nyuryokuCheckResultConst.SUCCESS)){	return;	}


			//ワンショット分の日々ファイルの取込
			cloringDate C_D = new cloringDate();
			String mainDTO_result = C_D.getDayDate(mainDTO);
			oneShotResult.setText(mainDTO_result);
			//メモリの解放
			C_D = new cloringDate();


		}
	}
	private class SwingAction_12 extends AbstractAction {
		public SwingAction_12() {
			putValue(NAME, "分割併合ファイル取込");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			TAB_MainDTO mainDTO = new TAB_MainDTO();
			CreateSepaComFile sepaComCheck = new CreateSepaComFile();

			//入力チェック
			gamenNyuryoku(mainDTO);

			String checkShotResult = sepaComCheck.nyuryokuChecker(mainDTO);



			switch (checkShotResult) {
			case nyuryokuCheckResultConst.SUCCESS:
				oneShotSepaComResult.setText(checkShotResult);
				break;
			case nyuryokuCheckResultConst.ON_TIMER_ERR:
				oneShotSepaComResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.MYSQL_ERR:
				oneShotSepaComResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
				oneShotSepaComResult.setText(checkShotResult);
				return;
			case nyuryokuCheckResultConst.NO_SEPA_FOLDER_ERR:
				oneShotSepaComResult.setText(checkShotResult);
				return;
			default:
				oneShotSepaComResult.setText("そのほかエラー");
				return;
			}


			checkShotResult = sepaComCheck.checkSepaComFile(mainDTO,controllDay.getTODAY());
			oneShotSepaComResult.setText(checkShotResult);

			//メモリの解放
			sepaComCheck = new CreateSepaComFile();
		}
	}
	private class SwingAction_13 extends AbstractAction {
		public SwingAction_13() {
			putValue(NAME, "キックファイル作成ボタン");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			TAB_MainDTO mainDTO = new TAB_MainDTO();
			gamenNyuryoku(mainDTO);

			nyuryokuCheck kickFileCheck = new nyuryokuCheck();

			//入力チェック
			String kickFileResult = kickFileCheck.kickNyuryokuChecker(mainDTO);

			switch (kickFileResult) {
			case nyuryokuCheckResultConst.SUCCESS:
				kickResult.setText(kickFileResult);
				break;
			case nyuryokuCheckResultConst.ON_TIMER_ERR:
				kickResult.setText(kickFileResult);
				return;
			case nyuryokuCheckResultConst.MYSQL_ERR:
				kickResult.setText(kickFileResult);
				return;
			case nyuryokuCheckResultConst.NO_LOG_FOLDER_ERR:
				kickResult.setText(kickFileResult);
				return;
			case nyuryokuCheckResultConst.NO_ENTRY_FOLDER_ERR:
				kickResult.setText(kickFileResult);
				return;
			default:
				kickResult.setText("そのほかエラー");
				return;
			}

			cloringDate CD = new cloringDate();
//			S s = new S();
//			s.getCon();
//			String TODAY = controllDay.getDAY_DD_FROM_UPDATE_MAMAGE(ReCord.KOSHINBI_STOCK_ETF, s);
//			s.closeConection();

			String TODAY = controllDay.getTODAY();

			//FBS_KICK_2017-07-31.fbs
	        String fileName = TODAY + "_FBS_KICK" + ".fbs";
			CD.createSecureFile(TODAY,mainDTO.getEntryFolderPath(),fileName);

		}
	}
}
