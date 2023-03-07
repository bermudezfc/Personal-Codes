import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class studentModule {

	//Containers
	JFrame studentMenu = new JFrame("Student Menu | National University Philippines");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();


	//Components
	JTextField txtCourses = new JTextField(15); 
	JButton bttnEnroll = new JButton("Enroll Course");
	JButton bttnView = new JButton("View Course");
	JButton bttnLogout = new JButton("Logout");
	public studentModule() {
		studentMenu.setLayout(new GridLayout());
		studentMenu.setSize(950, 700);
		studentMenu.setResizable(false);
		studentMenu.setDefaultCloseOperation(studentMenu.EXIT_ON_CLOSE);
		
		// to center the panel
		Toolkit tk = studentMenu.getToolkit();
		Dimension size = tk.getScreenSize();
		studentMenu.setLocation(size.width / 2 - studentMenu.getWidth() / 2, size.height / 2 - studentMenu.getHeight() / 2);
		
		studentMenu.setVisible(true);

		
		//Panel 1
		panel1.add(bttnEnroll);
		panel1.add(bttnView);
		panel1.add(bttnLogout);
		studentMenu.getContentPane().add(panel1, BorderLayout.WEST);
		
		//Panel 2
		panel2.add(txtCourses);
		studentMenu.getContentPane().add(panel2, BorderLayout.EAST);
	}
}


