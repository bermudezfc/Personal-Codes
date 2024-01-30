package Rough;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceManagementPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textSearch;
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
					ResourceManagementPage frame = new ResourceManagementPage();
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
	public ResourceManagementPage() {
		setResizable(false);
		setTitle("Resource Management");
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
		
				// COPY THIS LINE TO STUDENT RESOURCE MANAGEMENT
						JButton btnViewIssue = new JButton("View Full Issues");
						btnViewIssue.setFont(new Font("Tahoma", Font.BOLD, 10));
						btnViewIssue.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						        Resource_Data rd = new Resource_Data();
						        int selectedRow = table.getSelectedRow();
						        String issue = "";
						        
						    	

						        
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
						btnViewIssue.setBounds(847, 292, 132, 21);
						contentPane.add(btnViewIssue);
//		comboRoom.setModel(new DefaultComboBoxModel(new String[] {"Room 410", "Room 413"}));
		comboRoom.setBounds(275, 196, 88, 22);
		contentPane.add(comboRoom);
		
		// Create a scroll pane to hold the table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 234, 555, 328);
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
		

		



		

				textSearch = new JTextField();
				

					textSearch.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							String query = textSearch.getText();
							filter(query);
						}

					});
					
					textSearch.setBounds(414, 198, 110, 20);
					contentPane.add(textSearch);
					textSearch.setColumns(10);
		
		


		

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
				StudentMenu student = new StudentMenu();
				student.setLocationRelativeTo(null);
				student.setVisible(true);
						
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
	}


	public void filter(String query) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
	}
	
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