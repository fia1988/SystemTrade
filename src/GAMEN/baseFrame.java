package GAMEN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class baseFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baseFrame frame = new baseFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public baseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1560, 960);

		showInitPanel();
	}

	public void showInitPanel(){
		getContentPane().removeAll();
		setTitle("FIAS_v4.0");

		Edit edit = new Edit();
		getContentPane().add(edit);
		edit.setLayout(null);
		setBounds(50,50,1560,960);

		//	setContentPane(contentPane);


	}
}
