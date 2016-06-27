package GAMEN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import proparty.S;
import proparty.TBL_Name;
import timeSeriesDTO.DayTimeSeries;
import timeSeriesDTO.DayTimeSeries2;
import analysis.SagyoSpace;
import bean.Bean_CodeList;
import botton.cloringDate;
import botton.setUp;
import constant.CATE_FLG;
import constant.COLUMN;

//いろいろテストする。

//とりあえずSQLをテストする

public class TAB_test extends JPanel {
	public static JTextField textField;
	private final Action action = new SwingAction();
	private JButton button;
	private final Action action_1 = new SwingAction_1();
	private JScrollPane scrollPane;
	public static  JTextArea textArea_SQLresult;
	private JButton button_1;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private final Action action_9 = new SwingAction_9();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public TAB_test() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(52, 111, 136, 25);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("押す！");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(52, 37, 119, 27);
		add(btnNewButton);

		button = new JButton("消す");
		button.setAction(action_1);
		button.setBounds(198, 37, 119, 27);
		add(button);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 180, 536, 277);
		add(scrollPane);

		textArea_SQLresult = new JTextArea();
		scrollPane.setViewportView(textArea_SQLresult);

		button_1 = new JButton("終了");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setAction(action_2);
		button_1.setBounds(198, 80, 119, 27);
		add(button_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(205, 122, 146, 14);
		add(progressBar);

		btnNewButton_1 = new JButton("一覧作成");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action_3);
		btnNewButton_1.setBounds(360, 37, 168, 27);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("リスト挿入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setAction(action_4);
		btnNewButton_2.setBounds(360, 80, 168, 27);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("テーブル作成");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setAction(action_5);
		btnNewButton_3.setBounds(545, 37, 155, 27);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setAction(action_6);
		btnNewButton_4.setBounds(545, 80, 155, 27);
		add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setAction(action_7);
		btnNewButton_5.setBounds(372, 138, 156, 27);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setAction(action_8);
		btnNewButton_6.setBounds(545, 122, 155, 27);
		add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setAction(action_9);
		btnNewButton_7.setBounds(581, 177, 155, 27);
		add(btnNewButton_7);



	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "押す！");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			double a = 0.0;
			double b = 0.0;
			b=a/b;
//			if (Double.isNaN(b)){
//				System.out.println("aaa");
//			}
//			String TODAY = "1--3";
//			String[] TODAY_SPRIT = TODAY.split("-");
//			System.out.println(TODAY_SPRIT[0]);
//			System.out.println(TODAY_SPRIT[1]);
//			System.out.println(TODAY_SPRIT[2]);

			SagyoSpace.testCase03();
			//checkMotiKabu_L設定部分
			//あるいは持ち株会の買付日を見つける
			//基準日1、多くは給料日
			//paraDTO.sarary_01("DD");
			//基準日2、多くはボーナス夏
			//paraDTO.bonus_01("MM-DD");
			//基準日3、多くはボーナス冬
			//paraDTO.bonus_02("MM-DD");
			//基準日の何営業日あとかのチェック
			//paraDTO.intCount01(2);
//			Bean_Parameta paraDTO = new Bean_Parameta();
//			Bean_Result resultDTO = new Bean_Result();
//			Bean_nowRecord nowDTO = new Bean_nowRecord();
//			paraDTO.setIntCount01(2);
//			nowDTO.setCode("1301―T");
//			nowDTO.setCateflg("1");
//			nowDTO.setNowDay_01("2008-05-05");
//			Technique02.checkMotiKabu_L(paraDTO, nowDTO, resultDTO);

			textArea_SQLresult.append(textField.getText() + "5\n");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "消す");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			textArea_SQLresult.setText(null);

		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "終了");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "一覧TBL&DB作成_毎日");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			cloringDate C_D = new cloringDate();
			S s = new S();
			s.getCon();
			C_D.getDayDate();

		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "セットアップ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setUp S_U = new setUp();
			S_U.firstSetUp();
		}
	}

	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "テーブル作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("a");
		}
	}

	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "DTO実験");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			Bean_CodeList b_b = new Bean_CodeList ();
			CATE_FLG cf = new CATE_FLG();
			S s = new S();
			s.getCon();
			b_b.setOpen("200");
			cf.testsub(b_b);

			System.out.println(b_b.getOpen());




		}
	}

	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "レコード削除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			S s = new S();
			s.getCon();

			String SQL;

			SQL = "delete from " + TBL_Name.CODELISTTBL;
			s.freeUpdateQuery(SQL);

			SQL = "delete from " + TBL_Name.STOCK_DD;
			s.freeUpdateQuery(SQL);

			SQL = "delete from " + TBL_Name.STATISTICS_DD;
			s.freeUpdateQuery(SQL);

			SQL = "delete from " + TBL_Name.INDEX_DD;
			s.freeUpdateQuery(SQL);

			SQL = "delete from " + TBL_Name.ETF_DD;
			s.freeUpdateQuery(SQL);

			SQL = "delete from " + TBL_Name.UPDATE_MANAGE;
			s.freeUpdateQuery(SQL);

			//分割情報のみをリセット
			SQL = " update " + TBL_Name.STOCK_DD	+ " set "
							 + COLUMN.OPEN			+ " = " + COLUMN.BEFORE_OPEN	+ " , "
							 + COLUMN.MAX			+ " = " + COLUMN.BEFORE_MAX		+ " , "
							 + COLUMN.MIN			+ " = " + COLUMN.BEFORE_MIN		+ " , "
							 + COLUMN.CLOSE			+ " = " + COLUMN.BEFORE_CLOSE	+ " , "
							 + COLUMN.DEKI			+ " = " + COLUMN.BEFORE_DEKI	+ "   ";
			s.freeUpdateQuery(SQL);

			SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = false ";
			s.freeUpdateQuery(SQL);

			SQL = " update " + TBL_Name.SEPARATE_DD +  " set " + COLUMN.SEPA_FLG + " = true  where dayTime_kenri_last <= '2006-12-31'";
			s.freeUpdateQuery(SQL);


			s.closeConection();
		}
	}

	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "実験1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			S s = new S();
			s.getCon();
			long start = System.currentTimeMillis();

			DayTimeSeries DT = new DayTimeSeries();
			//個別銘柄・・・1
			//統計・・・2
			//指数・・・3
			//ETF・・・4
			//先物・・・5
			//通貨・・・6
			DT.setCodeDTO_DD("1301―T","2007-01-01","2007-01-09", s);


			for(int i =0;i<DT.getCodeDTO_DD().size();i++){
				System.out.println(DT.getCodeDTO_DD().get(i).getDay() + " " + DT.getCodeDTO_DD().get(i).getOpen() + " " + DT.getCodeDTO_DD().get(i).getMax() + " " + DT.getCodeDTO_DD().get(i).getMin() + " " + DT.getCodeDTO_DD().get(i).getClose() + " " + DT.getCodeDTO_DD().get(i).getBayBay() + " " + DT.getCodeDTO_DD().get(i).getDeki() +" フラグ；" +  DT.getCodeDTO_DD().get(i).getCateflg());
			}


			s.closeConection();


			long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
		}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "実験2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			long start = System.currentTimeMillis();
			S s = new S();
			s.getCon();
			//個別銘柄・・・1
			//統計・・・2
			//指数・・・3
			//ETF・・・4
			//先物・・・5
			//通貨・・・6

			DayTimeSeries2 D_T = new DayTimeSeries2();
			HashMap<String,List<Bean_CodeList>> map = new HashMap<String,List<Bean_CodeList>>();
			List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
			List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();

//			D_T.setCodeDTO_DD("1",s);
			D_T.setCodeDTO_DD("2","2008-01-01","2012-01-01",s);
			D_T.setCodeDTO_DD("2",s);
//			D_T.setCodeDTO_DD("3",s);
//			D_T.setCodeDTO_DD("4",s);
			String CODE = "東証1部";
			for(int i = 0;i<D_T.getDTO().get(CODE).size();i++){
				System.out.println(CODE + ":" + D_T.getDTO().get(CODE).get(i).getDay());

			}

//			map = D_T.getDTO();
//			B_Cs = D_T.getDTO().get(CODE);
//			B_Css.add(D_T.getDTO().get(CODE));

//			CODE = "I142";
//			for(int i = 0;i<D_T.getDTO().get(CODE).size();i++){
//				System.out.println(CODE + ":" + D_T.getDTO().get(CODE).get(i).getDay());
//
//			}
//
//			CODE = "1305";
//			for(int i = 0;i<D_T.getDTO().get(CODE).size();i++){
//				System.out.println(CODE + ":" + D_T.getDTO().get(CODE).get(i).getDay());
//			}



//			System.out.println(D_T.getDTO().get("JQグロース").size());
//			System.out.println(D_T.getDTO().get("東証1部").size());
			s.closeConection();


			long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
		}
	}
}
