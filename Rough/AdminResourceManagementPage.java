package Rough;
import java.awt.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import javax.imageio.ImageIO;

import java.awt.event.*;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;


public class AdminResourceManagementPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textSearch;
	private JTextField txtComputerNo;
	private JTextField txtIssue;
	private JTextField txtEdited;
	String computer_filepath = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\ComputerRooms.txt";
	String database_path = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\Database.txt";
	BufferedReader br;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminResourceManagementPage frame = new AdminResourceManagementPage();
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
	public AdminResourceManagementPage() {
		setResizable(false);
		setTitle("ADMIN|Resource Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1068, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<String> rooms = readRoom(computer_filepath);
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(rooms.toArray(new String[0]));
		JComboBox<String> comboRoom = new JComboBox<String>(comboBoxModel);
		comboRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedRoom = (String) comboRoom.getSelectedItem();
				String input = selectedRoom.split(" ")[1];
				getRoom(input);

				
			}
		});
		
				// This button allows for the User to view the full issues that are organized under the
				// Issues cell in the table.
						JButton btnViewIssue = new JButton("View Full Issues");
						btnViewIssue.setFont(new Font("Tahoma", Font.BOLD, 10));
						btnViewIssue.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						        Resource_Data rd = new Resource_Data();
						        int selectedRow = table.getSelectedRow();
						        String issue = "";
						        
						    	

						        // ERROR HANDLING - Makes sure that the system knows how to handle when the user isn't selecting anything
						        // from the table or in the case of when the issues cell is empty.
						        if (selectedRow >= 0) {
						        	if (table.getValueAt(selectedRow, 2) == null) {
								        issue = " ";
								     }
								     else {
								        issue = table.getValueAt(selectedRow, 2).toString();
								     }
						        		
						        	if (issue.trim().isEmpty()) {
								    		JOptionPane.showMessageDialog(btnViewIssue, "No issue logged");
								    }
								    else {
										JOptionPane.showMessageDialog(btnViewIssue, issue);
									}
								    	
								}
						        else {
						        	JOptionPane.showMessageDialog(btnViewIssue, "Please select a line from the table first.");
						        }
									
						        
						

							}
						});
						btnViewIssue.setBounds(738, 252, 132, 21);
						contentPane.add(btnViewIssue);
		



		comboRoom.setBounds(275, 145, 102, 22);
		contentPane.add(comboRoom);
		
		// Create a scroll pane to hold the table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 179, 453, 374);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Computer No.", "Status", "Issue", "Edited by"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(174);
		table.getColumnModel().getColumn(3).setResizable(false);
		
		// Add the table to the scroll pane
		scrollPane.setViewportView(table);
		table.setBounds(47, 125, 393, 200);
		
		// Changes the status of the selected row/computer in the table.
		JButton btnActivate = new JButton("Activate/\r\nDeactivate");
		btnActivate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnActivate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActivate.setBackground(new Color(0x5CE1E6));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnActivate.setBackground(Color.WHITE);
			}
		});
		btnActivate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            Resource_Data rd = new Resource_Data();
		            rd.setRoomNum(((String) comboRoom.getSelectedItem()).split(" ")[1]);
		            rd.setComputerNum((String) table.getValueAt(selectedRow, 0));
		            rd.setStatus((String) table.getValueAt(selectedRow, 1));



		            try {
		                StringBuilder newLine = fileCheck(rd, database_path);

		                FileWriter fw = new FileWriter(database_path);
		                fw.write(newLine.toString());

		                fw.flush();
		                fw.close();
		                getRoom(rd.getRoomNum()); // refreshes the table to account for the new data.

		            } catch (IOException e1) {
		                e1.printStackTrace();
		            }
		        }
		        


		    }
		    
		});
		btnActivate.setBounds(738, 341, 142, 23);
		contentPane.add(btnActivate);
		
		JPanel panelEdit = new JPanel();
		panelEdit.setBounds(886, 227, 142, 205);
		panelEdit.setLayout(null);
		panelEdit.setVisible(!panelEdit.isVisible());
		contentPane.add(panelEdit);
		
		txtComputerNo = new JTextField();
		txtComputerNo.setBounds(10, 31, 96, 19);
		panelEdit.add(txtComputerNo);
		txtComputerNo.setColumns(10);
		
		JLabel lblComputer = new JLabel("Computer No.");
		lblComputer.setBounds(10, 11, 96, 13);
		panelEdit.add(lblComputer);
		
		JLabel lblIssue = new JLabel("Issue");
		lblIssue.setBounds(10, 60, 96, 13);
		panelEdit.add(lblIssue);
		
		txtIssue = new JTextField();
		txtIssue.setColumns(10);
		txtIssue.setBounds(10, 80, 96, 19);
		panelEdit.add(txtIssue);
		
		JLabel lblEdited = new JLabel("Edited by");
		lblEdited.setBounds(10, 109, 96, 13);
		panelEdit.add(lblEdited);
		
		txtEdited = new JTextField();
		txtEdited.setColumns(10);
		txtEdited.setBounds(10, 129, 96, 19);
		panelEdit.add(txtEdited);
		contentPane.add(panelEdit);
		
		// From selecting the Edit button, when the Update button is pressed the information inputted in the text fields will be written
		// to the file. Updates the information
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0x7ED957));
		btnUpdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Resource_Data rd = new Resource_Data();
		        int selectedRow = table.getSelectedRow();
		        
		        
			    if (selectedRow >= 0) {
		            rd.setRoomNum(((String) comboRoom.getSelectedItem()).split(" ")[1]);
		            rd.setComputerNum((String) table.getValueAt(selectedRow, 0));
		            
		            
		    } else {
		    	JOptionPane.showMessageDialog(btnUpdate, "Please select a line in the table first");
		    }	
			    
			    
		        try {
		            StringBuilder newLine = fileCheckEdit(rd, database_path);

		            FileWriter fw = new FileWriter(database_path);
		            fw.write(newLine.toString());

		            fw.flush();
		            fw.close();

		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }



		        // take the new values from the text fields and set to fields
		        
		        // updates the jtable
		        String selectedRoom = (String) comboRoom.getSelectedItem();
		        
		        if (selectedRow >= 0) {
		            getRoom(selectedRoom.split(" ")[1]);
		        }
		        txtComputerNo.setText(" ");
		        txtIssue.setText(" ");
		        txtEdited.setText(" ");
                panelEdit.setVisible(!panelEdit.isVisible());
        		textSearch.setEnabled(true);
				JOptionPane.showMessageDialog(btnUpdate, "Edit Successful");


		    }
		});
		
		btnUpdate.setBounds(21, 174, 85, 21);
		panelEdit.add(btnUpdate);
		
		textSearch = new JTextField();
				

		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String query = textSearch.getText();
				filter(query);
			}

		});
					
		textSearch.setBounds(416, 145, 192, 20);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		// In the selected computer from the table, you can edit the information like the computer number, issue, and submitted ID.
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setBackground(new Color(0x5CE1E6));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setBackground(Color.WHITE);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resource_Data rd = new Resource_Data();
		        int selectedRow = table.getSelectedRow();
//		        DefaultTableModel model = (DefaultTableModel) table.getModel();

				try {
		        if (selectedRow >= 0) {
			        	
			        	// set values from selected row to data fields
			        	txtComputerNo.setText(table.getValueAt(selectedRow, 0).toString());
			        	
			        	if (table.getValueAt(selectedRow, 2) == null) {
			        		txtIssue.setText("");
			        	} else {
			        		txtIssue.setText(table.getValueAt(selectedRow, 2).toString());
			        	}
			        	
			        	if(table.getValueAt(selectedRow, 3) == null) {
			        		txtIssue.setText("");
			        	} else {
			        		txtEdited.setText(table.getValueAt(selectedRow, 3).toString());
			        	}
			        	
			        	// shows the panel of text fields
		                panelEdit.setVisible(!panelEdit.isVisible());
		                //set the values of chosen row to text fields

		                
		            //put code here

						
			        } else {
						JOptionPane.showMessageDialog(btnEdit, "Please select a line in the table first");
			        }	
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}

				


			}
		});
		contentPane.add(btnEdit);
		
		btnEdit.setBounds(738, 295, 89, 23);
		contentPane.add(btnEdit);
		
		


		
		JButton btnAddRoom = new JButton("Add Room/Computer");
		btnAddRoom.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAddRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddRoom.setBackground(new Color(0x5CE1E6));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddRoom.setBackground(Color.WHITE);
			}
		});
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRoom addroom = new AddRoom();
				addroom.setLocationRelativeTo(null);
				addroom.setVisible(true);
			}
		});
		btnAddRoom.setBounds(738, 209, 136, 21);
		contentPane.add(btnAddRoom);
		
		JPanel Preview = new JPanel();
		Preview.setBackground(new Color (0x9F8B5A));
		Preview.setBounds(0, 375, 253, 153);
		contentPane.add(Preview);
		Preview.setLayout(null);
		
		JLabel roomPreview = new JLabel("Room Preview");
		roomPreview.setHorizontalAlignment(SwingConstants.CENTER);
		roomPreview.setFont(new Font("Century Gothic", Font.BOLD, 14));
		roomPreview.setBounds(0, 0, 253, 37);
		Preview.add(roomPreview);
		
		JPanel r410 = new JPanel();
		r410.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				r410.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				r410.setBackground(new Color(0x9F8B5A));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Rm410Page r410 = new Rm410Page();
				r410.setLocationRelativeTo(null);
				r410.setVisible(true);
			}
		});
		r410.setBackground(new Color (0x9F8B5A));
		r410.setBounds(0, 56, 253, 49);
		Preview.add(r410);
		r410.setLayout(null);
		
		JLabel r410btn = new JLabel("ROOM 410");
		r410btn.setHorizontalAlignment(SwingConstants.CENTER);
		r410btn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		r410btn.setBounds(80, 20, 87, 14);
		r410.add(r410btn);
		
		JPanel r413 = new JPanel();
		r413.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				r413.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				r413.setBackground(new Color(0x9F8B5A));
			}
			public void mouseClicked(MouseEvent e) {
				Rm413Page r413 = new Rm413Page();
				r413.setLocationRelativeTo(null);
				r413.setVisible(true);
			}
		});
		r413.setBackground(new Color (0x9F8B5A));
		r413.setBounds(0, 104, 253, 49);
		Preview.add(r413);
		r413.setLayout(null);
		
		JLabel r413btn = new JLabel("ROOM 413");
		r413btn.setHorizontalAlignment(SwingConstants.CENTER);
		r413btn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		r413btn.setBounds(79, 17, 87, 14);
		r413.add(r413btn);
		
		JPanel Backbutton1 = new JPanel();
		Backbutton1.setBackground(new Color (0x9F8B5A));
		Backbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminMenu AdMenu= new AdminMenu();
				AdMenu.setLocationRelativeTo(null);
				AdMenu.setVisible(true);
						
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Backbutton1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Backbutton1.setBackground(new Color(0x9F8B5A));
			}
		});
		
		
		Backbutton1.setBounds(0, 556, 253, 35);
		contentPane.add(Backbutton1);
		Backbutton1.setLayout(null);
		
		JLabel Backbtn1 = new JLabel("Back");
		Backbtn1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Backbtn1.setBounds(101, 11, 46, 14);
		Backbutton1.add(Backbtn1);
		
		JLabel ResourcePage = new JLabel("");
		ResourcePage.setIcon(new ImageIcon(AdminResourceManagementPage.class.getResource("/Rough/images/ResourceScreen.png")));
		ResourcePage.setBounds(0, 0, 1050, 591);
		contentPane.add(ResourcePage);
		
		JTextArea issuesTextArea = new JTextArea();
		issuesTextArea.setBounds(275, 431, 377, 138);
		contentPane.add(issuesTextArea);
	}

	// From inputting in the search textfield, it will automatically filter the table to display the wanted data.
	public void filter(String query) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
	}
	
	//Reads the database file, and displays the information to the table. From selecting the room number from the combo box
	// It will automatically update the table to retrieve the computers that are listed under the room.
	public void getRoom(String input) {
		ArrayList<String> computers = new ArrayList<>();
		
		try {
			br = new BufferedReader(new FileReader(database_path));
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			// stops the refresh button from adding the same data from txt file every click
			model.setRowCount(0);
			String line;
			while((line = br.readLine()) != null) {
				if(line.split("/")[0].equals(input)) {
					computers.add(line.replaceAll("^\\d+/", ""));
				}
			}
			
			Object[] tableLines = computers.toArray();
			for(int i = 0; i < tableLines.length; i++) {
				
				String lines = tableLines[i].toString().trim();
				String[] dataRow = lines.split("/");
				model.addRow(dataRow);
			}
			// Catches all exceptions
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// Handles writing information to the database file.
	public StringBuilder fileCheck(Resource_Data rd, String database_path) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(database_path));
	    StringBuilder newLine = new StringBuilder();

	    String line, code, room;
	    String[] lines;

	    while ((line = br.readLine()) != null) {
	        // Computer num code
	        int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            rd.setComputerNum((String) table.getValueAt(selectedRow, 0).toString());
	            rd.setStatus((String) table.getValueAt(selectedRow, 1).toString());
	        } else {
	            // Handle the case when no row is selected
	        }

	        room = line.split("/")[0];
	        code = line.trim().split("/")[1];

	        if ((rd.getComputerNum().equals(code)) && (rd.getRoomNum().equals(room))) {

	            if (rd.getStatus().equals("Active")) {
	                lines = line.split("/");
	                lines[2] = "Inactive";
	                line = String.join("/", lines);
	            } else if (rd.getStatus().equals("Inactive")) {
	                lines = line.split("/");
	                lines[2] = "Active";
	                line = String.join("/", lines);
	            }
	        }

	        newLine.append(line).append(System.lineSeparator());
	    }

	    br.close();
	    return newLine;
	}
	
	public StringBuilder fileCheckEdit(Resource_Data rd, String database_path) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(database_path));
	    StringBuilder newLine = new StringBuilder();

	    String line, code, room;
	    String[] lines;
	    

	    int selectedRow = table.getSelectedRow();
	    if (selectedRow >= 0) {
	        rd.setComputerNum((String) table.getValueAt(selectedRow, 0).toString());

	        if (txtComputerNo.getText().trim().isEmpty()) {
	        	rd.setEditComputer(" ");
	        }
	        else {
	        	rd.setEditComputer(txtComputerNo.getText().toString());
	        }
	        if (txtIssue.getText().trim().isEmpty()) {
	        	rd.setEditIssue(" ");
	        }
	        else {
	        	rd.setEditIssue(txtIssue.getText().toString());
	        }
	        if (txtEdited.getText().trim().isEmpty()) {
	        	rd.setEditSubmitted(" ");
	        }
	        else {
	        	rd.setEditSubmitted(txtEdited.getText().toString());
	        }
	        
	    } else {
	        // No row selected, handle the case or return an error message
	        br.close();
	        return newLine;
	    }

	    while ((line = br.readLine()) != null) {
	    	room = line.split("/")[0];
	        code = line.trim().split("/")[1];

	        if ((rd.getComputerNum().equals(code)) && (rd.getRoomNum().equals(room))) {
	            // Modify the line here based on the edited values
	            lines = line.split("/");
	            lines[1] = rd.getEditComputer();
	            lines[3] = rd.getEditIssue();
	            lines[4] = rd.getEditSubmitted();
	            line = String.join("/", lines);
	        }

	        newLine.append(line).append(System.lineSeparator());
	    }

	    br.close();
	    return newLine;
	}
	
	private ArrayList<String> readRoom(String filePath){
		ArrayList<String> rooms = new ArrayList<>();
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) {
				if(!line.trim().isEmpty()){
					rooms.add("Room " + line);
				}
			}
		}
		catch (Exception read) {
			read.printStackTrace();
		}
		
		return rooms;
	}
}