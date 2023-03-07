import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class adminModule {
	private static final LayoutManager FlowLayout = null;
	//Containers
	JFrame adminMenu = new JFrame("Admin Menu | National University Philippines");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();


	//Components
	JLabel lblCourse = new JLabel("Course Code");
	JLabel lblCourseTitle = new JLabel("Course TItle");
	JLabel lblCourseUnits = new JLabel("Course Units");

	JTextField txtCourses = new JTextField(15); 
	JTextField txtCoursesTitle = new JTextField(10); 
	JTextField txtCourseUnits = new JTextField(15); 
	JTextField viewCourses = new JTextField(15);

	JButton bttnAdd = new JButton("Add Course");
	JButton bttnView = new JButton("View Course");
	JButton bttnLogout = new JButton("Logout");

     AddCourseButtonHandler acbHandler;
	 LogoutButtonHandler loHandler;

	 String inCourse = "";
	 String inCourseTitle = "";
	 String inCourseUnits = "";

	 File inputFile = new File("Courses.txt");
	 FileWriter fw = null;

	
	public adminModule() {
		adminMenu.setLayout(new GridLayout());
		adminMenu.setSize(950, 700);
		adminMenu.setResizable(false);
		adminMenu.setDefaultCloseOperation(adminMenu.EXIT_ON_CLOSE);
				
		Toolkit tk = adminMenu.getToolkit();
		Dimension size = tk.getScreenSize();
		adminMenu.setLocation(size.width / 2 - adminMenu.getWidth() / 2, size.height / 2 - adminMenu.getHeight() / 2);

		adminMenu.setVisible(true);
		
		//Panel 1
		panel1.add(bttnAdd);
		panel1.add(bttnView);
		panel1.add(bttnLogout);
		adminMenu.getContentPane().add(panel1, BorderLayout.WEST);
		
		//Panel 2
		panel2.add(lblCourse);
		panel2.add(txtCourses);
		adminMenu.getContentPane().add(panel2, BorderLayout.EAST);
	
		panel2.add(lblCourseTitle);
		panel2.add(txtCoursesTitle);
		adminMenu.getContentPane().add(panel2, BorderLayout.EAST);

		panel2.add(lblCourseUnits);
		panel2.add(txtCourseUnits);
		adminMenu.getContentPane().add(panel2, BorderLayout.EAST);

		//Panel 3
		panel3.add(viewCourses);
		adminMenu.add(panel3, BorderLayout.EAST);
		panel3.setLayout(null);
		panel3.setBounds(0,0,200,200);


		// Action Listeners


		loHandler = new LogoutButtonHandler();
		bttnLogout.addActionListener(loHandler);

		acbHandler = new AddCourseButtonHandler();
		bttnAdd.addActionListener(acbHandler);

	

	}
		//ActionListener Methods
		private class AddCourseButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				//This method checks if the text box is not empty, if it is not, it will register the account
				//then goes to the fileIn() method.
				
				inCourse = txtCourses.getText();
				inCourseTitle = txtCoursesTitle.getText();
				inCourseUnits = txtCourseUnits.getText();
	
				//If else statement checking if the textbox are empty
				if(!(inCourse.isEmpty()) && !(inCourseTitle.isEmpty() && !(inCourseUnits.isEmpty()))) { //Checks if the textfield is not empty.
					try { //If not it calls fileIn()
						fileIn();
					}catch (IOException e1) {
						System.out.println("An error has occured: "+e1.getMessage());
					}
					//If it is not empty, it shows a dialogue that the account is registered.
					JOptionPane.showMessageDialog(null, "Course '"+inCourse+"' Added. Press OK to proceed.", "Course Added",JOptionPane.INFORMATION_MESSAGE);
					adminMenu.dispose();
					adminModule admin = new adminModule(); //goes back to admin menu			
					}else { //Popup error message if textfield is empty.
					JOptionPane.showMessageDialog(null, "Input empty.", "Register Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		//fileIn method, this creates the file and inserts the data from the textbox in said file.
		private void fileIn() throws FileNotFoundException, IOException {
			try {
				if(!inputFile.exists()) { //Checks if file exists, if not create a new one.
					System.out.println("We had to make a new file...");
					inputFile.createNewFile();
				}else {
					fw = new FileWriter(inputFile, true);
					
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(inCourse + " " + inCourseTitle + " " + inCourseUnits + "\n");
					bw.close();
					System.out.println("Completed.");
				}
			}
			catch(IOException e) {
				System.out.println("An error has occured: "+e.getMessage());
			}
			finally{
			try {fw.close();} catch(Exception e) {}	
			}
		}
	

	// Action Listener for Logout Button
	private class LogoutButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adminMenu.dispose(); //closes current screen
			Login startMenu = new Login(); //goes back to login menu
		}
	}
}
