package GAMEN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import proparty.PROPARTY;
import GamenDTO.TAB_MainDTO;
import GamenNyuryokuCheck.nyuryokuCheck;
import botton.ResetShori;
import botton.SepaCombine;
import botton.TimeClornigDate;
import botton.setUp;
import constant.ReturnCodeConst;
import constant.nyuryokuCheckResultConst;

public class TAB_main extends JPanel {


	TimeClornigDate a = new TimeClornigDate();

	private JTextField mysqlID;
	private JTextField mysqlPass;
	private JTextField entryFolderPath;
	private JTextField sepaComFolderPath;
	private JTextField logFolderPath;
	private JTextField outBackUplogFolderPath;
	private JTextField inBackUplogFilePath;

	JLabel timerCheck = new JLabel("false");
	JLabel sepaComResult = new JLabel("成／否");
	JLabel deleteS_Cresult = new JLabel("成／否");
	JLabel deleteKeepResult = new JLabel("成／否");
	JLabel deleteRecordResult = new JLabel("成／否");
	JLabel createTBLresult = new JLabel("成／否");
	JLabel deleteDBresult = new JLabel("成／否");
	JLabel inBackupResult = new JLabel("成／否");
	JLabel outBackupResult = new JLabel("成／否");


	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	/**
	 * Create the panel.
	 */
	public TAB_main() {
		setLayout(null);

		logFolderPath = new JTextField();
		logFolderPath.setBounds(42, 362, 330, 25);
		add(logFolderPath);
		logFolderPath.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 528, 183, 110);
		add(textPane);

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

		mysqlPass = new JTextField();
		mysqlPass.setColumns(10);
		mysqlPass.setBounds(95, 244, 136, 25);
		add(mysqlPass);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(42, 213, 52, 19);
		add(lblId);

		JLabel lblPass = new JLabel("pass:");
		lblPass.setBounds(42, 247, 52, 19);
		add(lblPass);

		JLabel timerResult = new JLabel("ボタンを押してね");
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
		btnNewButton_1.setBounds(201, 671, 119, 27);
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
		inBackUplogFilePath.setBounds(434, 381, 330, 25);
		add(inBackUplogFilePath);

		JButton button_1 = new JButton("test");
		button_1.setBounds(434, 270, 165, 27);
		add(button_1);

		JButton button_2 = new JButton("test");
		button_2.setBounds(434, 415, 165, 27);
		add(button_2);

		JLabel label_7 = new JLabel("結果：");
		label_7.setBounds(434, 312, 60, 19);
		add(label_7);

		JLabel label_8 = new JLabel("結果：");
		label_8.setBounds(434, 457, 60, 19);
		add(label_8);

		outBackupResult.setBounds(488, 312, 139, 19);
		add(outBackupResult);

		inBackupResult.setBounds(488, 457, 139, 19);
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
		label_12.setBounds(831, 402, 60, 19);
		add(label_12);

		JLabel label_13 = new JLabel("結果：");
		label_13.setBounds(831, 196, 60, 19);
		add(label_13);

		deleteDBresult.setBounds(885, 402, 139, 19);
		add(deleteDBresult);

		createTBLresult.setBounds(885, 197, 139, 19);
		add(createTBLresult);

		JLabel label_16 = new JLabel("リセット処理 ※操作注意");
		label_16.setBounds(811, 306, 165, 19);
		add(label_16);

		JButton btnsql = new JButton("下のSQLを手打ちしてね");
		btnsql.setAction(action_4);
		btnsql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnsql.setBounds(831, 361, 193, 27);
		add(btnsql);

		JButton button_6 = new JButton("test");
		button_6.setAction(action_5);
		button_6.setBounds(831, 434, 193, 27);
		add(button_6);

		JButton button_7 = new JButton("test");
		button_7.setAction(action_6);
		button_7.setBounds(831, 503, 193, 27);
		add(button_7);

		JButton button_8 = new JButton("test");
		button_8.setAction(action_7);
		button_8.setBounds(831, 570, 193, 27);
		add(button_8);

		JLabel label_18 = new JLabel("結果：");
		label_18.setBounds(831, 469, 60, 19);
		add(label_18);

		JLabel label_19 = new JLabel("結果：");
		label_19.setBounds(831, 536, 60, 19);
		add(label_19);

		JLabel label_20 = new JLabel("結果：");
		label_20.setBounds(831, 607, 60, 19);
		add(label_20);

		JLabel lblCreateDatabaseKabudata = new JLabel("CREATE DATABASE kabudata");
		lblCreateDatabaseKabudata.setBounds(831, 113, 266, 19);
		add(lblCreateDatabaseKabudata);


		deleteRecordResult.setBounds(885, 469, 139, 19);
		add(deleteRecordResult);

		deleteS_Cresult.setBounds(885, 536, 139, 19);
		add(deleteS_Cresult);

		deleteKeepResult.setBounds(885, 607, 139, 19);
		add(deleteKeepResult);

		JLabel label_17 = new JLabel("バックアップ出力先フォルダパス");
		label_17.setBounds(434, 223, 239, 19);
		add(label_17);

		JLabel label_21 = new JLabel("バックアップ入力ファイルパス");
		label_21.setBounds(434, 346, 239, 19);
		add(label_21);



	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "タイマーオン");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {


			TAB_MainDTO mainDTO = new TAB_MainDTO();
			nyuryokuCheck check = new nyuryokuCheck();

			//タイマーの状態のチェック
			mainDTO.setJudgeTimer((  timerCheck.getText() ));
			mainDTO.setMysqlID(mysqlID.getText());
			mainDTO.setMysqlPass(mysqlPass.getText());
			mainDTO.setLogFilePath(logFolderPath.getText());
			mainDTO.setEntryFolderPath(entryFolderPath.getText());
			mainDTO.setSepaCombineFilePath(sepaComFolderPath.getText());
			mainDTO.setOutBackUpFolderPath(outBackUplogFolderPath.getText());
			mainDTO.setInBackUpFilePath(inBackUplogFilePath.getText());



			if ( mainDTO.isJudgeTimer() ==true ){
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				return;
			}



			timerCheck.setText("true") ;

			System.out.println(PROPARTY.LOG_FILE_OUT);
//			PROPARTY.LOG_FILE_OUT = "aabbbba";
			System.out.println(PROPARTY.LOG_FILE_OUT);



			System.out.println( Boolean.valueOf(  timerCheck.getText() ) );
//			a.getEveryDay(mainDTO);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "タイマーオフ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			timerCheck.setText("false") ;
			a.cancelEveryDay();

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
			mainDTO.setJudgeTimer((  timerCheck.getText() ));
			mainDTO.setMysqlID(mysqlID.getText());
			mainDTO.setMysqlPass(mysqlPass.getText());
			mainDTO.setLogFilePath(logFolderPath.getText());
			mainDTO.setEntryFolderPath(entryFolderPath.getText());
			mainDTO.setSepaCombineFilePath(sepaComFolderPath.getText());
			mainDTO.setOutBackUpFolderPath(outBackUplogFolderPath.getText());
			mainDTO.setInBackUpFilePath(inBackUplogFilePath.getText());
			SepaCombine SC = new SepaCombine();

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


			int resultSC = SC.loadSepaCombineFile(mainDTO) ;
			if( resultSC == ReturnCodeConst.SQL_ERR_0 ){
				//インポート成功
				System.out.println(resultSC);
			}else{
				//インポート失敗
				System.out.println(resultSC);
			}

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
			ResetShori a = new ResetShori();
			a.resetDB();
			a = new ResetShori();
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "TBLレコード削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResetShori a = new ResetShori();
			a.resetRecord();
			a = new ResetShori();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "分割リセット");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResetShori a = new ResetShori();
			a.resetSepaCombine();
			a = new ResetShori();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "キープテーブル削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResetShori a = new ResetShori();
			a.resetKeepResult();
			a = new ResetShori();
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "各種TBL作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setUp a = new setUp();
			a.createTBL();
			a = new setUp();
		}
	}
}
