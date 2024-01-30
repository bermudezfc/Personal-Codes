package Rough;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TroubleshootingPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TroubleshootingPage frame = new TroubleshootingPage();
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
	public TroubleshootingPage() {
		setResizable(false);
		setTitle("Troubleshooting Page");
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll pane to the text area
        scrollPane.setBounds(318, 232, 566, 333);
        contentPane.add(scrollPane);

		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Monitor Issues")){
					textArea.setText("1. Check power connection \r\n"
							+ "Ensure that the monitor is properly connected to a power source and turned on. Verify that the power cable is securely plugged into both the monitor and the power outlet. If the monitor has a separate power brick or adapter, make sure it is functioning correctly. \r\n"
							+ "\r\n"
							+ "2.  Verify the video cable connection \r\n"
							+ "Check the cable connecting your monitor to the computer (e.g., HDMI, DisplayPort, VGA). Ensure that the cable is securely connected to both the monitor and the computer's video output port. If possible, try using a different cable or port to rule out a faulty connection. \r\n"
							+ "\r\n"
							+ "3. Test the monitor on another computer:\r\n"
							+ "Connect the monitor to another computer or laptop to determine if the issue lies with the monitor itself or your computer. If the monitor works fine on another system, it suggests a problem with your computer's graphics card or settings. \r\n"
							+ "\r\n"
							+ "4. Check for physical damage: \r\n"
							+ "Inspect the monitor for any physical damage, such as cracks, loose connections, or a faulty power button. \r\n"
							+ "\r\n"
							+ "5. Perform a power cycle: \r\n"
							+ "Turn off the monitor and unplug it from the power source. Press and hold the power button for about 15 seconds to discharge any residual power. Then, plug the monitor back in and turn it on.\r\n"
							+ "");
				}
				else if (comboBox.getSelectedItem()==("Mouse Issues")){
					textArea.setText("1. Check the physical connections. \r\n"
							+ "Ensure that your mouse is properly connected to the computer. If it's a wired mouse, check that the USB or PS/2 cable is securely plugged in. \r\n"
							+ "\r\n"
							+ "2. Try a different USB port or receiver. \r\n"
							+ "If you're using a USB mouse, try plugging it into a different USB port on your computer. Sometimes, a faulty USB port can cause connection issues. \r\n"
							+ "\r\n"
							+ "3. Clean the mouse. \r\n"
							+ "Turn off your computer and clean the mouse using a soft cloth or compressed air. \r\n"
							+ "\r\n"
							+ "4. Test the mouse on another computer. \r\n"
							+ "Connect the mouse to another computer to see if the issue persists. If the mouse works fine on another computer, it suggests a problem with your current computer's settings or drivers. \r\n"
							+ "\r\n"
							+ "5. Restart your computer. \r\n"
							+ "A simple restart can often resolve temporary software glitches. Restart your computer and check if the mouse starts functioning properly afterward.\r\n"
							+ "");
					
				}
				else if (comboBox.getSelectedItem()==("Keyboard issues")){
					textArea.setText("1. Check the physical connections. \r\n"
							+ "Ensure that the keyboard is properly connected to the computer. If it's a wired keyboard, make sure the USB or PS/2 cable is securely plugged in. \r\n"
							+ "\r\n"
							+ "2. Restart your computer. \r\n"
							+ "A simple restart can resolve temporary software glitches. Restart your computer and see if the keyboard starts functioning properly afterward. \r\n"
							+ "\r\n"
							+ "3. Check for conflicting software. \r\n"
							+ "Some software applications or utilities can interfere with keyboard functionality. Temporarily disable any third-party keyboard-related software, such as keyboard customization tools or macro software, and check if the problem persists.\r\n"
							+ "\r\n"
							+ "4. Check for stuck keys. \r\n"
							+ "Press each key on your keyboard individually to check if any keys are stuck or not registering correctly. If you find a stuck key, gently press and release it multiple times to try and unstick it. \r\n"
							+ "\r\n"
							+ "5. Test with a different keyboard. \r\n"
							+ "If possible, borrow or connect a different keyboard to your computer to see if it works properly. If the replacement keyboard functions correctly, it suggests a problem with your original keyboard that may require repair or replacement.\r\n"
							+"");
					
				}
				else if (comboBox.getSelectedItem()==("Computer no Power Issue")){
					textArea.setText("1. Check the power source \r\n"
							+ "Make sure the power cable is securely plugged into both the wall outlet and the back of your computer. If you're using a power strip or surge protector, ensure that it's turned on and functioning properly. Try plugging the computer directly into a different outlet to rule out any power supply issues. \r\n"
							+ "\r\n"
							+ "2. Verify the power button. \r\n"
							+ "Ensure that you're pressing the power button correctly and firmly. Sometimes, a faulty or stuck power button can prevent the computer from turning on. Try pressing the button multiple times or holding it for a few seconds to see if that makes a difference. \r\n"
							+ "\r\n"
							+ "3. Check the power supply. \r\n"
							+ "If there are no signs of power, such as lights or fans spinning, it's possible that the power supply unit (PSU) is faulty. Look for any physical signs of damage or loose connections. \r\n"
							+ "\r\n"
							+ "4. Remove unnecessary peripherals. \r\n"
							+ "Disconnect all external devices from your computer, including USB devices, printers, external hard drives, etc. \r\n"
							+ "\r\n"
							+ "5. Check for overheating. \r\n"
							+ "If your computer is overheating, it may automatically shut down or fail to turn on. Ensure that the CPU fan and other cooling components are functioning properly and not clogged with dust. Clean any dust buildup using compressed air or a soft brush.\r\n"
							+ "");
					
				}
				else if (comboBox.getSelectedItem()==("Computer no audio issue")){
					textArea.setText("1. Check audio connections \r\n"
							+ "Ensure that your speakers or headphones are properly connected to the correct audio output port on your PC. If you're using external speakers, check that the power is turned on and the volume is set correctly. If you're using headphones, try connecting them to a different audio port to rule out a faulty port. \r\n"
							+ "\r\n"
							+ "2. Adjust the volume settings. \r\n"
							+ "Check the volume settings on your PC to ensure they are not muted or set too low. Click on the speaker icon in the system tray and increase the volume if necessary. Also, check the volume settings within any applications or media players you are using. \r\n"
							+ "\r\n"
							+ "3. Perform a system restore. \r\n"
							+ "Press Win + R, type \"rstrui.exe,\" and press Enter to open the System Restore tool. Follow the on-screen instructions to choose a restore point and restore your system. \r\n"
							+ "\r\n"
							+ "4. Check third-party audio software. \r\n"
							+ "If you have installed any third-party audio software, such as audio enhancements or equalizers, temporarily disable or uninstall them. These applications can sometimes conflict with the system's audio settings. \r\n"
							+ "\r\n"
							+ "5. Test with different audio devices. \r\n"
							+ "Try using different speakers or headphones to see if the issue is with the audio device itself. If the alternate device works, it suggests a problem with your original speakers or headphones.\r\n"
							+ "");
					
				}
				else if (comboBox.getSelectedItem()==("No internet Issue")){
					textArea.setText("1. Check all physical connections \r\n"
							+ "Ensure that all cables (Ethernet, coaxial, or phone line) are securely plugged into their respective ports on your modem/router and the wall outlets. \r\n"
							+ "\r\n"
							+ "If you're using Wi-Fi, make sure your router is powered on and broadcasting a signal. \r\n"
							+ "\r\n"
							+ "\r\n"
							+ "\r\n"
							+ "2. Test other devices \r\n"
							+ "Connect another device (e.g., smartphone, tablet, or another computer) to your network and check if it has internet access. This will help determine if the issue is isolated to a specific device or affects the entire network. \r\n"
							+ "\r\n"
							+ "3. Check network settings and software. \r\n"
							+ "Ensure that your computer's network settings are correctly configured. For Windows, you can try the built-in Network Troubleshooter, which can often resolve common connection issues automatically. \r\n"
							+ "\r\n"
							+ "4. Check for local network issues. \r\n"
							+ "Disable and re-enable Wi-Fi or try connecting via Ethernet cable (if available) to see if that makes a difference. \r\n"
							+ "disable VPN or proxy.\r\n"
							+ "");
					
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Monitor Issues", "Mouse Issues", "Keyboard issues", "Computer no Power Issue", "Computer no audio issue", "No internet Issue"}));
		comboBox.setBounds(398, 155, 220, 34);
		contentPane.add(comboBox);
		
	
		
		JLabel lblTroubleShoot = new JLabel("Issue :");
		lblTroubleShoot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTroubleShoot.setBounds(318, 143, 150, 53);
		contentPane.add(lblTroubleShoot);
		
		JPanel troubleshootbackBtn = new JPanel();
		troubleshootbackBtn.setBackground(new Color(0x9F8B5A));
		troubleshootbackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				troubleshootbackBtn.setBackground(new Color(0x9F8B5A));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				troubleshootbackBtn.setBackground(Color.WHITE);
			}
		});
		troubleshootbackBtn.setBounds(0, 544, 253, 51);
		contentPane.add(troubleshootbackBtn);
		troubleshootbackBtn.setLayout(null);
		
		JLabel troubleshootback = new JLabel("Back");
		troubleshootback.setHorizontalAlignment(SwingConstants.CENTER);
		troubleshootback.setFont(new Font("Tahoma", Font.BOLD, 14));
		troubleshootback.setBounds(81, 10, 74, 31);
		troubleshootbackBtn.add(troubleshootback);
		
		JLabel TroubleshootingScreen = new JLabel("");
		TroubleshootingScreen.setIcon(new ImageIcon(TroubleshootingPage.class.getResource("/Rough/images/Troubleshooting.png")));
		TroubleshootingScreen.setBounds(0, 0, 1050, 591);
		contentPane.add(TroubleshootingScreen);
		
		

		
	}
}