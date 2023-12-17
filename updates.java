package masoomjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class updates extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String Acc_No;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private Choice educationChoice;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                updates frame = new updates("Acc_No");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public updates(String Acc_No) {
    	this.Acc_No=Acc_No;
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); 
        JLabel lblBank = new JLabel("<html><center>BANK<br><br>ATM Management System..!!</center></html>");
        lblBank.setBounds(10, 0, getWidth() - 20, 150);
        lblBank.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblBank.setOpaque(true);
        lblBank.setBackground(new Color(0, 128, 255));
        lblBank.setForeground(Color.BLACK);
        lblBank.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(lblBank);

        JLabel lblNewLabel = new JLabel("Update Details.");
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(608, 160, 300, 80);
        contentPane.add(lblNewLabel);

        JLabel lblBank_1 = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank_1.setOpaque(true);
        lblBank_1.setHorizontalAlignment(JLabel.CENTER);
        lblBank_1.setForeground(Color.BLACK);
        lblBank_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank_1.setBackground(new Color(0, 128, 255));
        lblBank_1.setBounds(10, 700, 1516, 100);
        contentPane.add(lblBank_1);
        
        JLabel lblNewLabel_1 = new JLabel("Account No : " + Acc_No);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(600, 250, 600, 60);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setForeground(Color.RED);
        lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        lblLogout.setBounds(700, 630, 150, 80);
        lblLogout.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        contentPane.add(lblLogout);
        
        JLabel lblNewLabel_2 = new JLabel("FullName :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(400, 380, 200, 60);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Occupation :");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_2_1.setBounds(916, 380, 200, 60);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Education :");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_2_2.setBounds(400, 459, 200, 60);
        contentPane.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("Mobile No :");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_2_2_1.setBounds(916, 459, 200, 60);
        contentPane.add(lblNewLabel_2_2_1);
        
        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton.setBounds(700, 550, 150, 60);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitUpdates();
            }
        });
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("\"Empowering dreams, securing futures—your financial journey, our steadfast partnership.\"");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
        lblNewLabel_3.setBounds(308, 300, 900, 50);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(550, 385, 250, 50);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(1078, 385, 250, 50);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_2.setColumns(10);
        textField_2.setBounds(1078, 465, 250, 50);
        contentPane.add(textField_2);
        
        this.educationChoice = new Choice();
        educationChoice.setFont(new Font("Dialog", Font.ITALIC, 20));
        educationChoice.setBounds(550, 475, 250, 60);
        educationChoice.add("");
        educationChoice.add("Below 10th");
        educationChoice.add("SSC");
        educationChoice.add("Intermediate");
        educationChoice.add("Bachelor's Degree");
        educationChoice.add("Master's Degree");
        educationChoice.add("Ph.D.");
        educationChoice.add("Illiterate");
        contentPane.add(educationChoice);
    }

    private void submitUpdates() {
        try {
            String fname = textField.getText();
            String occupation = textField_1.getText();
            String selectedEducation = educationChoice.getSelectedItem();
            String phno = textField_2.getText();
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";
            Connection connection = DriverManager.getConnection(url, username, password);
            String updateQuery = "UPDATE atmjava SET fname=?, occupation=?, education=?,phno=? WHERE Acc_No=?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, fname);
                updateStatement.setString(2, occupation);
                updateStatement.setString(3, selectedEducation);
                updateStatement.setString(4, phno);
                updateStatement.setString(5, Acc_No);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Details updated successfully");
                    textField.setText("");
                    textField_1.setText("");
                    educationChoice.select(0);
                    textField_2.setText("");
                } else {
                    System.out.println("Update failed");
                }
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}