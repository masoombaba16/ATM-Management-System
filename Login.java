package masoomjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
     
    private boolean validateLogin(String accountNo, char[] pin) {
        boolean isValid = false;
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Masoom@16");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM atmjava WHERE Acc_No = ? AND pin = ?");
        ) {
            statement.setString(1, accountNo);
            statement.setString(2, new String(pin)); 
            try (ResultSet resultSet = statement.executeQuery()) {
                isValid = resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
    private String[] getAccountInformation(String accountNo) {
        String[] accountInfo = new String[2];

        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Masoom@16");
            PreparedStatement statement = connection.prepareStatement("SELECT fname, Acc_No FROM atmjava WHERE Acc_No = ?");
        ) {
            statement.setString(1, accountNo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    accountInfo[0] = resultSet.getString("fname");
                    accountInfo[1] = resultSet.getString("Acc_No");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountInfo;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblBank = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank.setBounds(10, 0, 1516, 150);
        lblBank.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank.setOpaque(true);
        lblBank.setBackground(new Color(0, 128, 255));
        lblBank.setForeground(Color.BLACK);
        lblBank.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblBank);
        
        JLabel lblNewLabel = new JLabel("Account No : ");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(450, 250, 200, 100);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField.setBounds(660, 280, 250, 50);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblPassword = new JLabel("ATM PIN");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setBounds(420, 370, 200, 100);
        contentPane.add(lblPassword);
        
        JLabel lblLoginSignup = new JLabel("Login & Signup");
        lblLoginSignup.setForeground(Color.BLACK);
        lblLoginSignup.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblLoginSignup.setBackground(Color.BLACK);
        lblLoginSignup.setBounds(633, 160, 250, 100);
        contentPane.add(lblLoginSignup);
        
        JButton btnSignup = new JButton("Signup-->");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Signp SignupFrame = new Signp();
                SignupFrame.setVisible(true);
                dispose();
            }
        });
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnSignup.setBackground(Color.WHITE);
        btnSignup.setBounds(808, 540, 200, 60);
        contentPane.add(btnSignup);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(558, 540, 150, 60);
        contentPane.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNo = textField.getText();
                char[] pin = passwordField.getPassword();
                if (validateLogin(accountNo, pin)) {
                    String[] accountInfo = getAccountInformation(accountNo);

                    System.out.println("Login successful!");
                    Signup signupFrame = new Signup(accountInfo[1], accountInfo[0]);
                    signupFrame.setVisible(true);
                    dispose();
                } else {
                    textField.setText("");
                    passwordField.setText("");
                    System.out.println("Login failed. Invalid credentials.");
                }
            }
        });
   
        JLabel lblBank_1 = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank_1.setOpaque(true);
        lblBank_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBank_1.setForeground(Color.BLACK);
        lblBank_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank_1.setBackground(new Color(0, 128, 255));
        lblBank_1.setBounds(10, 670, 1516, 120);
        contentPane.add(lblBank_1);
        
        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(660, 400, 250, 50);
        contentPane.add(passwordField);

    }
}
