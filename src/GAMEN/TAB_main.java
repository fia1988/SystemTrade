package GAMEN;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class TAB_main extends JPanel {
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public TAB_main() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(48, 79, 136, 25);
		add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(64, 141, 183, 110);
		add(textPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(229, 78, 119, 27);
		add(btnNewButton);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			TAB_PROPATY.textField.setText("aaaa");
		}
	}
}
