package GAMEN;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proparty.S;
import sql.createDB;

public class TAB_PROPATY extends JPanel {
	static JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public TAB_PROPATY() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(157, 5, 136, 25);
		add(textField);
		textField.setColumns(10);

		JButton btnDb = new JButton("DBを作る");
		btnDb.setAction(action);
		btnDb.setBounds(46, 101, 119, 27);
		add(btnDb);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "DBを作る");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			S s = new S();
			createDB a = new createDB();
			a.CreateDB(s);

		}
	}
}
