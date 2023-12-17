package masoomjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;

public class Signp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textFieldDOB;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    private Choice educationChoice;
    private ButtonGroup genderGroup;
    private JTextField textField_5;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Signp frame = new Signp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Signp() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JLabel lblBank = new JLabel("<html><center>ATM Management System</center></html>");
        lblBank.setBounds(10, 0, 1516, 120);
        lblBank.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank.setOpaque(true);
        lblBank.setBackground(new Color(0, 128, 255));
        lblBank.setForeground(Color.BLACK);
        lblBank.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblBank);

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Signup Page..");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNewLabel.setBounds(683, 160, 200, 50);
        contentPane.add(lblNewLabel);

        JLabel lblAccNo = new JLabel("Account No.");
        lblAccNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccNo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAccNo.setBounds(150, 250, 200, 50);
        contentPane.add(lblAccNo);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField.setBounds(350, 250, 250, 50);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblPin = new JLabel("PIN");
        lblPin.setHorizontalAlignment(SwingConstants.CENTER);
        lblPin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPin.setBounds(900, 250, 200, 50);
        contentPane.add(lblPin);

        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(1100, 250, 250, 50);
        contentPane.add(textField_1);

        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblFullName.setBounds(130, 350, 200, 50);
        contentPane.add(lblFullName);

        textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField_2.setColumns(10);
        textField_2.setBounds(320, 350, 280, 50);
        contentPane.add(textField_2);

        JLabel lblDateOfBirth = new JLabel("Date of Birth");
        lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
        lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblDateOfBirth.setBounds(900, 350, 200, 50);
        contentPane.add(lblDateOfBirth);

        textFieldDOB = new JTextField("");
        textFieldDOB.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
        textFieldDOB.setColumns(10);
        textFieldDOB.setBounds(1100, 350, 250, 50);
        contentPane.add(textFieldDOB);

        JLabel lblEducation = new JLabel("Education");
        lblEducation.setHorizontalAlignment(SwingConstants.CENTER);
        lblEducation.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblEducation.setBounds(130, 450, 200, 50);
        contentPane.add(lblEducation);

        educationChoice = new Choice();
        educationChoice.setFont(new Font("Dialog", Font.ITALIC, 20));
        educationChoice.setBounds(350, 460, 200, 18);

        educationChoice.add("");
        educationChoice.add("Below 10th");
        educationChoice.add("SSC");
        educationChoice.add("Intermediate");
        educationChoice.add("Bachelor's Degree");
        educationChoice.add("Master's Degree");
        educationChoice.add("Ph.D.");
        educationChoice.add("Illiterate");

        contentPane.add(educationChoice);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblGender.setBounds(900, 450, 200, 50);
        contentPane.add(lblGender);

        genderGroup = new ButtonGroup();

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setSelected(true);
        maleRadioButton.setForeground(new Color(0, 0, 0));
        maleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        maleRadioButton.setBounds(1080, 450, 100, 50);
        genderGroup.add(maleRadioButton);
        contentPane.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBackground(Color.WHITE);
        femaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        femaleRadioButton.setBounds(1200, 450, 100, 50);
        genderGroup.add(femaleRadioButton);
        contentPane.add(femaleRadioButton);

        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBackground(Color.WHITE);
        otherRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        otherRadioButton.setBounds(1320, 450, 100, 50);
        genderGroup.add(otherRadioButton);
        contentPane.add(otherRadioButton);

        ActionListener genderListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedGender = "";
                if (maleRadioButton.isSelected()) {
                    selectedGender = "Male";
                } else if (femaleRadioButton.isSelected()) {
                    selectedGender = "Female";
                } else if (otherRadioButton.isSelected()) {
                    selectedGender = "Other";
                }
                System.out.println("Selected Gender: " + selectedGender);
            }
        };

        maleRadioButton.addActionListener(genderListener);
        femaleRadioButton.addActionListener(genderListener);
        otherRadioButton.addActionListener(genderListener);

        JLabel lblPhoneNo = new JLabel("Phone No.");
        lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPhoneNo.setBounds(900, 550, 200, 50);
        contentPane.add(lblPhoneNo);

        textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_3.setBounds(1100, 550, 200, 50);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblEducation_1 = new JLabel("Occupation");
        lblEducation_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEducation_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblEducation_1.setBounds(130, 550, 200, 50);
        contentPane.add(lblEducation_1);

        textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField_4.setColumns(10);
        textField_4.setBounds(340, 550, 250, 50);
        contentPane.add(textField_4);

        JLabel lblBank_1 = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank_1.setOpaque(true);
        lblBank_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBank_1.setForeground(Color.BLACK);
        lblBank_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank_1.setBackground(new Color(0, 128, 255));
        lblBank_1.setBounds(10, 707, 1516, 100);
        contentPane.add(lblBank_1);

        JButton btnLogin_1 = new JButton("Login-->");
        btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogin_1.setBackground(Color.WHITE);
        btnLogin_1.setBounds(808, 625, 150, 60);
        contentPane.add(btnLogin_1);

        JButton btnSignup = new JButton("Signup");
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnSignup.setBackground(Color.WHITE);
        btnSignup.setBounds(558, 625, 150, 60);
        contentPane.add(btnSignup);
        
        JLabel lblOpeningBalance = new JLabel("Opening Balance - ");
        lblOpeningBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblOpeningBalance.setBounds(993, 160, 200, 50);
        contentPane.add(lblOpeningBalance);
        
        textField_5 = new JTextField("2500");
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField_5.setColumns(10);
        textField_5.setBounds(1180, 160, 150, 50);
        contentPane.add(textField_5);
        btnLogin_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                dispose();
            }
        });
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String accNoStr = textField.getText();
                String pinStr = textField_1.getText();
                String fullName = textField_2.getText();
                String dob = textFieldDOB.getText();
                String education = educationChoice.getSelectedItem();
                String gender = getSelectedGender();
                String phnoStr = textField_3.getText();
                String occupation = textField_4.getText();
                String balstr = textField_5.getText();
                try {
                    long accNo = Long.parseLong(accNoStr);
                    int pin = Integer.parseInt(pinStr);
                    long phno = Long.parseLong(phnoStr);
                    int bal = Integer.parseInt(balstr);
                    insertData(accNo, pin, fullName, dob, education, gender, phno, occupation, bal);
                    System.out.println("Data inserted successfully.");

                    Login loginFrame = new Login();
                    loginFrame.setVisible(true);
                    dispose();
                }
                     catch (NumberFormatException e) {
                    resetTextFields();
                    System.out.println("Invalid input format. Please enter valid numbers.");
                }
            }
        });
    }
        private void resetTextFields() {
            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
            textFieldDOB.setText("");
            educationChoice.select(0);
            maleRadioButton.setSelected(true);
            textField_3.setText("");
            textField_4.setText("");
            textField_5.setText("2500");
        }

    private static void insertData(long accNo, int pin, String fullName, String dob, String education,String gender, long phno, String occupation,int bal) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Masoom@16");

            String insertSQL = "INSERT INTO atmjava (Acc_No, pin, fname, dob, education, gender, phno, occupation,bal) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

            try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
                pstmt.setLong(1, accNo);
                pstmt.setInt(2, pin);
                pstmt.setString(3, fullName);
                pstmt.setString(4, dob);
                pstmt.setString(5, education);
                pstmt.setString(6, gender);
                pstmt.setLong(7, phno);
                pstmt.setString(8, occupation);
                pstmt.setInt(9, bal);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("No rows affected. Data may not have been inserted.");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private String getSelectedGender() {
        if (maleRadioButton.isSelected()) {
            return "Male";
        } else if (femaleRadioButton.isSelected()) {
            return "Female";
        } else if (otherRadioButton.isSelected()) {
            return "Other";
        }
        return "";
    }
}