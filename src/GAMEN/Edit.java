package GAMEN;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Edit extends JPanel {


	/**
	 * Create the panel.
	 */
	public Edit() {
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 15, 1438, 828);
		add(tabbedPane);

		//JPanel TOP_MAIN = new JPanel();
		TAB_main TOP_MAIN = new TAB_main();
		tabbedPane.addTab("メインTAB", null, TOP_MAIN, null);
		TOP_MAIN.setLayout(null);

		TAB_PROPATY property = new TAB_PROPATY();
		tabbedPane.addTab("設定", null, property, null);
		property.setLayout(null);

		TAB_test test = new TAB_test();
		tabbedPane.addTab("テスト", null, test, null);
		test.setLayout(null);
		



	}
}
