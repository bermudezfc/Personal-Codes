package Rough;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rm410Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rm410Page frame = new Rm410Page();
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
	public Rm410Page() {
		setResizable(false);
		setTitle("PREVIEW: ROOM 410");
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Room410BackBtn = new JLabel("");
		Room410BackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Room410BackBtn.setBounds(10, 10, 83, 72);
		contentPane.add(Room410BackBtn);
		
		JLabel rm410page = new JLabel("");
		rm410page.setIcon(new ImageIcon(Rm410Page.class.getResource("/Rough/images/Room410.png")));
		rm410page.setBounds(0, 0, 1050, 591);
		contentPane.add(rm410page);
				
	}
}