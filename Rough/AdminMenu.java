package Rough;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	private JLabel ResourceBtn;
	private JLabel IssueBtn;
	private JLabel Faq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setResizable(false);
		setTitle("ADMIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SideBar = new JPanel();
		SideBar.setBounds(0, 171, 172, 420);
		contentPane.add(SideBar);
		SideBar.setBackground(new Color (0xEDDEC4));
		SideBar.setLayout(null);
		
		JPanel Resource = new JPanel();
		Resource.setBackground(new Color (0xEDDEC4));
		Resource.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Resource.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Resource.setBackground(new Color (0xEDDEC4));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminResourceManagementPage rmPage = new AdminResourceManagementPage();
				rmPage.setLocationRelativeTo(null);
				rmPage.setVisible(true);
				dispose();

			}
		});
		Resource.setBounds(0, 109, 172, 45);
		SideBar.add(Resource);
		Resource.setLayout(new BorderLayout(0, 0));
		
		ResourceBtn = new JLabel("RESOURCE MANAGEMENT");
		ResourceBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		ResourceBtn.setHorizontalAlignment(SwingConstants.CENTER);
		Resource.add(ResourceBtn, BorderLayout.CENTER);
		
		JPanel IssueLog = new JPanel();
		IssueLog.setBackground(new Color (0xEDDEC4));
		IssueLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IssueLog.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IssueLog.setBackground(new Color (0xEDDEC4));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				IssueLogsPage issue = new IssueLogsPage();
				issue.setLocationRelativeTo(null);
				issue.setVisible(true);
			}
		});
		IssueLog.setBounds(0, 153, 172, 45);
		SideBar.add(IssueLog);
		IssueLog.setLayout(new BorderLayout(0, 0));
		
		IssueBtn = new JLabel("ISSUE LOGS");
		IssueBtn.setHorizontalAlignment(SwingConstants.CENTER);
		IssueBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		IssueLog.add(IssueBtn, BorderLayout.CENTER);
		
		JPanel Troubleshoot = new JPanel();
		Troubleshoot.setBackground(new Color (0xEDDEC4));
		Troubleshoot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Troubleshoot.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Troubleshoot.setBackground(new Color (0xEDDEC4));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TroubleshootingPage tsp = new TroubleshootingPage();
				tsp.setLocationRelativeTo(null);
				tsp.setVisible(true);
			}
		});
		Troubleshoot.setBounds(0, 197, 172, 45);
		SideBar.add(Troubleshoot);
		Troubleshoot.setLayout(new BorderLayout(0, 0));
		
		Faq = new JLabel("TROUBLESHOOTING");
		Faq.setHorizontalAlignment(SwingConstants.CENTER);
		Faq.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Troubleshoot.add(Faq, BorderLayout.CENTER);
		
		JPanel Logout = new JPanel();
		Logout.setBackground(new Color (0xEDDEC4));
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Logout.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Logout.setBackground(new Color (0xEDDEC4));
			}
		});
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to sign out?", "Sign out", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
                    // Perform sign-out actions here
                    JOptionPane.showMessageDialog(null, "You have been signed out successfully.");
                    dispose();
                    LoginPage log = new LoginPage();
					log.setLocationRelativeTo(null);
                    log.setVisible(true);
			}}
		});
		Logout.setBounds(0, 386, 172, 34);
		SideBar.add(Logout);
		Logout.setLayout(new BorderLayout(0, 0));
		
		JLabel SignOutBtn = new JLabel("Sign Out");
		SignOutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		SignOutBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Logout.add(SignOutBtn, BorderLayout.CENTER);
		
		JPanel AboutUs = new JPanel();
		AboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutUsPage abt = new AboutUsPage();
				abt.setLocationRelativeTo(null);
				abt.setVisible(true);
			}
		});
		AboutUs.setBackground(new Color (0xEDDEC4));
		AboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AboutUs.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AboutUs.setBackground(new Color (0xEDDEC4));
			}
		});
		AboutUs.setBounds(0, 354, 172, 34);
		SideBar.add(AboutUs);
		AboutUs.setLayout(new BorderLayout(0, 0));
		
		JLabel AboutUsBtn = new JLabel("About us");
		AboutUsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		AboutUsBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		AboutUs.add(AboutUsBtn, BorderLayout.CENTER);
		
		JLabel HomePageScreen = new JLabel("");
		HomePageScreen.setIcon(new ImageIcon(AdminMenu.class.getResource("/Rough/images/MenuPage.png")));
		HomePageScreen.setBounds(0, 0, 1050, 591);
		contentPane.add(HomePageScreen);
		
		
	}
}