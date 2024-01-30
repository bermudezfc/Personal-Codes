package Rough;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutUsPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUsPage frame = new AboutUsPage();
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
	public AboutUsPage() {
		setResizable(false);
		setTitle("About Us");
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CreatorPage = new JLabel("");
		CreatorPage.setIcon(new ImageIcon(AboutUsPage.class.getResource("/Rough/images/Creator.png")));
		CreatorPage.setBounds(0, 0, 1050, 591);
		contentPane.add(CreatorPage);
	}

}