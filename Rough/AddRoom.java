package Rough;
// This java file handles adding a computer room to the ComputerRooms.txt, and adding the computer room to Database.txt
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class AddRoom extends JFrame {

	private JPanel contentPane;

	String computer_filepath = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\ComputerRooms.txt";
	String database_path = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\Database.txt";
	private JTextField roomNumTextField;
	private JTextField comNumTextField;
	BufferedReader br;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoom frame = new AddRoom();
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
	public AddRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddRoom = new JLabel("Add Room");
		lblAddRoom.setBounds(16, 6, 74, 16);
		panel.add(lblAddRoom);
		
		
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(29, 43, 102, 14);
		panel.add(lblRoomNumber);
		
		roomNumTextField = new JTextField();
		roomNumTextField.setBounds(163, 37, 130, 26);
		panel.add(roomNumTextField);
		roomNumTextField.setColumns(10);
		
		
		JLabel lblAddComputer = new JLabel("Add Computer to Room");
		lblAddComputer.setBounds(16, 80, 157, 16);
		panel.add(lblAddComputer);
		
		JLabel lblChooseRoom = new JLabel("Room Number");
		lblChooseRoom.setBounds(29, 122, 102, 16);
		panel.add(lblChooseRoom);
		
		ArrayList<String> rooms = readRoom(computer_filepath);
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(rooms.toArray(new String[0]));
		JComboBox roomComboBox = new JComboBox(comboBoxModel);
		roomComboBox.setBounds(163, 118, 120, 27);
		panel.add(roomComboBox);
		
		
		JLabel lblComputerNo = new JLabel("Computer Number");
		lblComputerNo.setBounds(29, 170, 131, 14);
		panel.add(lblComputerNo);
		
		comNumTextField = new JTextField();
		comNumTextField.setBounds(163, 164, 130, 26);
		panel.add(comNumTextField);
		comNumTextField.setColumns(10);
		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(29, 211, 46, 14);
		panel.add(lblStatus);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive"}));
		comboStatus.setBounds(162, 208, 120, 22);
		panel.add(comboStatus);
		
		// Adds the room to ComputerRooms.txt
		JButton btnAddRoom = new JButton("Add Room");
		btnAddRoom.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAddRoom.setBackground(new Color(0x7ED957));
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				boolean valid = false;
				boolean existing = false;
				
				//Checks if the room number is valid.
				if (roomNumTextField.getText().matches("\\d{3}")) {
					valid = true; 
				}
				// Reads from the file to check if the room inputted already exists in ComputerRooms.txt
				if(checkRoom(computer_filepath, roomNumTextField.getText())) {
					existing = true;
				}
				
				try {
					if (valid && (existing == false)) {
						String newRoom = roomNumTextField.getText();
						//addNewRoom(newRoom);
						fw = new FileWriter(computer_filepath, true);
						fw.write(newRoom + "\n");
						
						fw.flush();
						fw.close();
						JOptionPane.showMessageDialog(btnAddRoom, "Room No. " + newRoom + " Added Successfully!");
						roomNumTextField.setText("");
						updateComboBox(roomComboBox);
						
					}
					else if(valid == false) {
						JOptionPane.showMessageDialog(btnAddRoom, "Please enter a valid room number. Only composed of three digits");
						roomNumTextField.setText("");
					}
					else if(existing) {
						JOptionPane.showMessageDialog(btnAddRoom, "Inputted room already exists.");
						roomNumTextField.setText("");
					}
					else {
						JOptionPane.showMessageDialog(btnAddRoom, "An unaccounted for error has occured.");
						roomNumTextField.setText("");
					}
					
					
				}
				catch(Exception add) {
					add.printStackTrace();
				}
				
			}
		});
		btnAddRoom.setBounds(303, 39, 89, 23);
		panel.add(btnAddRoom);
		
		//Adds the computer to the selected room number.
		JButton btnAddComputer = new JButton("Add Computer");
		btnAddComputer.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAddComputer.setBackground(new Color(0x7ED957));
		btnAddComputer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				String newComputer = comNumTextField.getText();
				String room = roomComboBox.getSelectedItem().toString();
				String status = comboStatus.getSelectedItem().toString();
				
				try {
					//Checks if the inputted computer number is valid.
					if (newComputer.matches("\\d{4}")) {
						//Checks if the computer added already exists in the room.
						if (sameComputer(room, newComputer)) {
							JOptionPane.showMessageDialog(btnAddComputer, "Computer already exists.");
							comNumTextField.setText("");
						}
						else {
							fw = new FileWriter(database_path, true);
							fw.write(room + "/" + newComputer + "/" + status + "/ / " + "\n");
						
							fw.flush();
							fw.close();
							JOptionPane.showMessageDialog(btnAddComputer, "Computer " + newComputer + " added to Room " + room + " successfully!");
						}
					}
					else {
						JOptionPane.showMessageDialog(btnAddComputer, "Please enter a valid computer number.");
						comNumTextField.setText("");
					}
					
				}
				catch (Exception addCom) {
					
					addCom.printStackTrace();
				}
			}
		});
		btnAddComputer.setBounds(296, 164, 108, 26);
		panel.add(btnAddComputer);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(16, 256, 85, 21);
		panel.add(btnBack);
	}
	
	
	// CLASS METHODS
	
	private ArrayList<String> readRoom(String filePath){
		//Reads from ComputerRooms.txt for it uses each line as an option for the Room Number JCOmboBox
		ArrayList<String> rooms = new ArrayList<>();
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) {
				if(!line.trim().isEmpty()){
					rooms.add(line);
				}
			}
		}
		catch (Exception read) {
			read.printStackTrace();
		}
		
		return rooms;
	}
	
	private void updateComboBox(JComboBox roomComboBox) {
		// This function updates the Room Number combo box based on the add input from the Room Number text field.
        ArrayList<String> updatedRooms = readRoom("C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\ComputerRooms.txt");
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) roomComboBox.getModel();
        comboBoxModel.removeAllElements();
        for (String room : updatedRooms) {
            comboBoxModel.addElement(room);
        }
    }
	
	private boolean checkRoom(String roomFile, String roomNum) { 
		// This function checks if the Room already exists.
		boolean result = false;
		
		try {
			br = new BufferedReader(new FileReader(roomFile));
			String line;
			while((line = br.readLine()) != null) {
				if(line.equals(roomNum)) {
					result = true; //It means that there was a match.
				}
			}
		}
		catch (Exception check) {
			System.out.println("Error occured in checkRoom() function.");
			check.printStackTrace();
		}
		
		return result;
	}
	
	private boolean sameComputer(String roomNum, String computerNum) {
		// This function checks if the Computer added to the Room already exists.
		boolean result = false;
		
		try {
			br = new BufferedReader(new FileReader(database_path));
			String line, room, computer;
			while((line = br.readLine()) != null) {
				room = line.split("/")[0];
				computer = line.split("/")[1];
				
				if((roomNum.equals(room) && (computerNum.equals(computer)))){
					result = true;
				}
			}
		}
		catch (Exception same) {
			same.printStackTrace();
		}
		
		return result;
	}
}
