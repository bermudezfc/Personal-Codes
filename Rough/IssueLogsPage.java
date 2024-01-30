package Rough;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class IssueLogsPage extends JFrame {

    private JPanel contentPane;
    private JTextField issueText;
    private JTextField idText;
    private JComboBox<String> roomNumCb;
    private JComboBox<String> computerNumCb;
    private JComboBox<String> problemCb;

    String[] problems = {"Monitor Issues", "Mouse Issues", "Keyboard issues", "Computer No Power Issue", "Computer No Audio Issue", "No Internet Issue", "Operating System Issues", "Other Issues"};
    String computer_filepath = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\ComputerRooms.txt";
    String database_path = "C:\\Users\\HP\\eclipse-workspace\\OOP\\src\\Rough\\Database.txt";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IssueLogsPage frame = new IssueLogsPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IssueLogsPage() {
        setResizable(false);
        setTitle("Issue Logs");
        setBounds(0, 0, 1068, 630);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
         JButton addIssueBtn = new JButton("Add Issue");
         addIssueBtn.addMouseListener(new MouseAdapter() {
         	@Override
         	public void mouseEntered(MouseEvent e) {
         		addIssueBtn.setBackground(new Color(0x5CE1E6));
         	}
         	@Override
         	public void mouseExited(MouseEvent e) {
         		addIssueBtn.setBackground(Color.WHITE);
         	}
         });
         addIssueBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
         addIssueBtn.addActionListener(new ActionListener() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
        		 SystemData da = new SystemData();

                 da.setRoomNum((String) roomNumCb.getSelectedItem());
                 da.setComputerNum((String) computerNumCb.getSelectedItem());
                 da.setProblem((String) problemCb.getSelectedItem());
                 da.setIssue(issueText.getText());
                 da.setSubmitteeID(idText.getText());

                 FileWriter fw = null;
                 String chosenFile = null;

                 try {
                	 // ERROR HANDLING - The following if and else if blocks are there to account for possible errors in inputs in the adding
                	 // of issues. If there are no detected errors, it will proceed to write to the database.
                	 if (da.getSubmitteeID().trim().isEmpty()) {
                		 JOptionPane.showMessageDialog(addIssueBtn, "Please input your ID number in order to submit your issue.");
                         da.setSubmitteeID(null);
                     } else if (da.getComputerNum() == null) {
                         JOptionPane.showMessageDialog(addIssueBtn, "Issue cannot be logged for there are no chosen computer in the room.");
                         da.setComputerNum(null);
                     } else if (!(da.getProblem().equals("Other Issues")) && !(da.getIssue().isEmpty())) {
                    	 JOptionPane.showMessageDialog(addIssueBtn, "Warning! Only add an input to the issue field if you have chosen \"Other Issues\" in the Problem Encountered");
                         da.setProblem(null);
                         da.setIssue(null);
                     } else if (!(da.getIssue().matches("^[a-zA-Z0-9 ]+$")) && da.getProblem().equals("Other Issues")) {
                         JOptionPane.showMessageDialog(addIssueBtn, "Warning! Please input an issue.");
                         da.setIssue(null);
                     } else if (!(da.getSubmitteeID().matches("^\\d{4}-\\d{6}$|^\\d{2}-\\d{4}$"))) {
                    	 JOptionPane.showMessageDialog(addIssueBtn, "Warning! Please input a valid ID.");
                         da.setSubmitteeID(null);
                     } else {
                    	 JOptionPane.showMessageDialog(addIssueBtn, "Issue Logged Successfully!");

                         String chosen_room = da.getRoomNum();

                         StringBuilder newLine = fileCheck(da, chosen_room);
                         System.out.println("File Writing Finished!");

                         fw = new FileWriter(database_path);
                         fw.write(newLine.toString());

                         fw.flush();
                         fw.close();
                     }
                 } catch (Exception ex) {
                            ex.printStackTrace();
                 }

        	 }
        });
        addIssueBtn.setBounds(698, 456, 126, 45);
        contentPane.add(addIssueBtn);
        

        JLabel lblProblemEncountered = new JLabel("Problem Encountered");
        lblProblemEncountered.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProblemEncountered.setBounds(362, 328, 134, 30);
        contentPane.add(lblProblemEncountered);

        computerNumCb = new JComboBox<String>();
        computerNumCb.setBounds(513, 239, 134, 45);
        contentPane.add(computerNumCb);

        computerNumCb.setEditable(true); // Make the JComboBox editable

        issueText = new JTextField();
        issueText.setBounds(513, 422, 134, 20);
        contentPane.add(issueText);
        issueText.setColumns(10);
        issueText.setVisible(false);

        idText = new JTextField();
        idText.setColumns(10);
        idText.setBounds(513, 481, 134, 20);
        contentPane.add(idText);

        JLabel lblNewLabel = new JLabel("Computer No.");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(362, 246, 111, 30);
        contentPane.add(lblNewLabel);

        JLabel lblRoomNo = new JLabel("Room No.");
        lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRoomNo.setBounds(362, 177, 75, 30);
        contentPane.add(lblRoomNo);

        JLabel lblIssue = new JLabel("Issue");
        lblIssue.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblIssue.setBounds(362, 417, 60, 30);
        contentPane.add(lblIssue);
        lblIssue.setVisible(false);

        roomNumCb = new JComboBox<String>();
        roomNumCb.setEditable(true);
        roomNumCb.setBounds(513, 162, 134, 45);
        roomNumCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComboBox(); // updates the combo box for computer numbers based on chosen room number
            }
        });
        contentPane.add(roomNumCb);

        problemCb = new JComboBox<String>(new DefaultComboBoxModel(new String[] {"Monitor Issues", "Mouse Issues", "Keyboard issues", "Computer No Power Issue", "Computer No Audio Issue", "No Internet Issue", "Operating System Issues", "No Peripherals", "Other Issues"}));
        problemCb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String problem = problemCb.getSelectedItem().toString();

                if (problem.equals("Other Issues")) {
                    lblIssue.setVisible(true);
                    issueText.setVisible(true);
                } else {
                    lblIssue.setVisible(false);
                    issueText.setText("");
                    issueText.setVisible(false);
                }
            }
        });
        problemCb.setEditable(true);
        problemCb.setBounds(513, 321, 134, 45);
        contentPane.add(problemCb);

        JLabel lblSubmitteeID = new JLabel("Submittee's ID");
        lblSubmitteeID.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSubmitteeID.setBounds(362, 484, 111, 14);
        contentPane.add(lblSubmitteeID);
        
        JPanel Issuelogbackbtn = new JPanel();
        Issuelogbackbtn.setBackground(new Color(0x9F8B5A));
        Issuelogbackbtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		Issuelogbackbtn.setBackground(Color.WHITE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		Issuelogbackbtn.setBackground(new Color(0x9F8B5A));
        	}
        });
        Issuelogbackbtn.setBounds(0, 559, 252, 34);
        contentPane.add(Issuelogbackbtn);
        Issuelogbackbtn.setLayout(null);
        
        JLabel IssueBackbtn = new JLabel("Back");
        IssueBackbtn.setHorizontalAlignment(SwingConstants.CENTER);
        IssueBackbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        IssueBackbtn.setBounds(84, 10, 68, 13);
        Issuelogbackbtn.add(IssueBackbtn);

        JLabel IssueLogScreen = new JLabel("");
        IssueLogScreen.setIcon(new ImageIcon(IssueLogsPage.class.getResource("/Rough/images/IssueLogScreen.png")));
        IssueLogScreen.setBounds(0, 0, 1050, 591);
        contentPane.add(IssueLogScreen);
        
        
        ArrayList<String> roomNum = readRoomFile(computer_filepath);
        for (String line : roomNum) {
            roomNumCb.addItem(line);
        }
    }

    //Updates the Computer Number combo box based on the chosen room from the Room Number combo box
    public void updateComboBox() {
        computerNumCb.removeAllItems();
        BufferedReader br;
        ArrayList<String> computers = new ArrayList<>();
        String roomNumInput = roomNumCb.getSelectedItem().toString();

        try {
            br = new BufferedReader(new FileReader(database_path));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split("/")[0].equals(roomNumInput)) {
                    computers.add(line.split("/")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        computerNumCb.setModel(new DefaultComboBoxModel<>(computers.toArray(new String[0])));
    }

    // Writes the information inputted to the Issue Logs Page to the Database.txt file
    public StringBuilder fileCheck(SystemData da, String chosen_room) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(database_path));
        StringBuilder newLine = new StringBuilder();

        String line, computer, issue, room;
        String[] lines;

        
        if (da.getProblem().equals("Other Issues")) {
            issue = da.getIssue();
        } else {
            issue = da.getProblem();
        }

        while ((line = br.readLine()) != null) {
            room = line.split("/")[0];
            computer = line.split("/")[1];

            // Matches the room and computer number in the file in order to help guide the program to where it will write the newly inputted information.
            if (da.getComputerNum().equals(computer) && da.getRoomNum().equals(room)) {
                // System.out.println("Match detected!"); - For checking

            	
                if (line.split("/")[3].trim().isEmpty() && line.split("/")[4].trim().isEmpty()) {
                    lines = line.split("/");
                    lines[3] = issue;
                    lines[4] = da.getSubmitteeID();
                    line = String.join("/", lines);
                } else {
                    lines = line.split("/");
                    lines[3] = lines[3] + ", " + issue;
                    lines[4] = da.getSubmitteeID();
                    line = String.join("/", lines);
                }

            }

            newLine.append(line).append(System.lineSeparator());
        }
        br.close();

        return newLine;

    }

    private ArrayList<String> readRoomFile(String file_path) {
        ArrayList<String> rooms = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file_path));
            String line;
            while ((line = br.readLine()) != null) {
                rooms.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}
