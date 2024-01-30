package Rough;
/* 	UPDATE: Changed line "LoginPage.class.getResource()" to "ImageIO.read(new File())" kasi hindi gumagana yung paghanap ng file
 *  From line 113. Also changed import block to be more general in importing, kunyari import javax.swing.*; mga ganon
 *  Changed line applies to all files. So i-re-reference ko na lang which line sa susunod na files.
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JTextField passText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setLocationRelativeTo(null);
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
	public LoginPage() {
		setTitle("Computer Defect Tracker and Record System for NU-Manila ComLabs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 600);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// ADMIN LOGIN PANEL - This panel contains and displays the login procedures if the user decides to login as an admin.
		// Contains two JLabels (User & Password), two JTextFields (for input in User & Password), and a Login JButton.
		JPanel adminLoginPanel = new JPanel();
		adminLoginPanel.setBounds(26, 371, 214, 172);
		adminLoginPanel.setOpaque(false);
		contentPane.add(adminLoginPanel);
		adminLoginPanel.setLayout(null);
		
		userText = new JTextField();
		userText.setBounds(30, 37, 154, 20);
		adminLoginPanel.add(userText);
		userText.setBackground(Color.WHITE);
		userText.setColumns(10);
		
		JLabel userLbl = new JLabel("USER");
		userLbl.setBounds(32, 17, 46, 14);
		adminLoginPanel.add(userLbl);
		userLbl.setForeground(new Color(255, 215, 0));
		userLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
		passText = new JPasswordField();
		passText.setBounds(29, 82, 154, 20);
		adminLoginPanel.add(passText);
		passText.setColumns(10);
		passText.setBackground(Color.WHITE);
		
		JLabel passwordLbl = new JLabel("PASSWORD");
		passwordLbl.setBounds(30, 63, 100, 14);
		adminLoginPanel.add(passwordLbl);
		passwordLbl.setForeground(new Color(255, 215, 0));
		passwordLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
			
		JButton loginBtn = new JButton("Login");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = userText.getText();
				String password = passText.getText();
				
				// Predefined login credentials for admin login.
				if (user.equals("admin") && password.equals("admin123")) {
					dispose();
					JOptionPane.showMessageDialog(loginBtn, "Login Successfully");
					AdminMenu admin = new AdminMenu();
					admin.setLocationRelativeTo(null);
					admin.setVisible(true);
				
				}
				else {
					JOptionPane.showMessageDialog(loginBtn, "Please enter a valid username and password.");
				}
			}
		});
		loginBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		loginBtn.setBounds(59, 129, 89, 23);
		adminLoginPanel.add(loginBtn);
		adminLoginPanel.setVisible(false);
		
		/* LOGIN PANEL - This panel contains and displays the options on whether the user wants to login as an admin or as a user.
		 * Contains two JButtons, ADMIN and USER. If user presses Admin, ADMIN LOGIN PANEL will be displayed and the user will have
		 * to sign up with the proper credentials in order to sign in as an admin. If the user presses User, they will proceed to 
		 * sign in as a normal user
		 * */
		 
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(16, 321, 241, 41);
		loginPanel.setOpaque(false);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JButton adminButton = new JButton("ADMIN");
		adminButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		adminButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminLoginPanel.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				adminButton.setBackground(new Color(0x5CE1E6));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				adminButton.setBackground(Color.WHITE);
			}
		});
		adminButton.setBounds(17, 6, 96, 29);
		loginPanel.add(adminButton);
		
		JButton userButton = new JButton("USER");
		userButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		userButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(loginBtn, "Login Succesfully");
				StudentMenu student = new StudentMenu();
				student.setLocationRelativeTo(null);
				student.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				userButton.setBackground(new Color(0x5CE1E6));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userButton.setBackground(Color.WHITE);
			}
		});
		userButton.setBounds(125, 6, 96, 29);
		loginPanel.add(userButton);
		
		//Displays the background image of the window.
		JLabel loginpg = new JLabel("");
	
		loginpg.setIcon(new ImageIcon(LoginPage.class.getResource("/Rough/images/LoginPage.png")));
		loginpg.setBounds(0, -70, 1005, 700);
		contentPane.add(loginpg);
				
	}
}