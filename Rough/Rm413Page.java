package Rough;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Rm413Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rm413Page frame = new Rm413Page();
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
	public Rm413Page() {
		setResizable(false);
		setTitle("PREVIEW: ROOM 413");
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Room413BackBtn = new JLabel("");
		Room413BackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Room413BackBtn.setBounds(10, 10, 83, 72);
		contentPane.add(Room413BackBtn);
		
		JLabel rm413page = new JLabel("");
		rm413page.setIcon(new ImageIcon(Rm413Page.class.getResource("/Rough/images/Room413.png")));
		rm413page.setBounds(0, 0, 1050, 591);
		contentPane.add(rm413page);
		
	}
}