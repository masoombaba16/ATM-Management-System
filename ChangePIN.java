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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChangePIN extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private String Acc_No;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChangePIN frame = new ChangePIN("Acc_No");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChangePIN(String Acc_No) {
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
        
        JLabel lblNewLabel = new JLabel("Change Your PIN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(608, 160, 300, 80);
        contentPane.add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Account No : " + Acc_No);
        lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAmount.setBounds(550, 260, 600, 50);
        contentPane.add(lblAmount);
        
        JButton btnNewButton = new JButton("Change PIN");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnNewButton.setBounds(633, 520, 250, 60);
        btnNewButton.addActionListener(e -> changePIN());
        contentPane.add(btnNewButton);
        
        JLabel lblBack = new JLabel("Logout");
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBack.setBounds(683, 600, 150, 80);
        lblBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        contentPane.add(lblBack);
        
        JLabel lblBank_1 = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank_1.setOpaque(true);
        lblBank_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBank_1.setForeground(Color.BLACK);
        lblBank_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank_1.setBackground(new Color(0, 128, 255));
        lblBank_1.setBounds(10, 700, 1516, 100);
        contentPane.add(lblBank_1);
        
        JLabel lblNewPin = new JLabel("New PIN :");
        lblNewPin.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewPin.setBounds(550, 340, 200, 50);
        contentPane.add(lblNewPin);
        
        JLabel lblConfirmPin = new JLabel("Confirm PIN :");
        lblConfirmPin.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmPin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblConfirmPin.setBounds(550, 420, 200, 50);
        contentPane.add(lblConfirmPin);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField.setColumns(10);
        textField.setBounds(760, 330, 200, 60);
        contentPane.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(760, 420, 200, 60);
        contentPane.add(textField_1);
    }
    private void changePIN() {
        try {
            String newPIN = textField.getText();
            String confirmPIN = textField_1.getText();

            if (newPIN.equals(confirmPIN)) {
                String url = "jdbc:mysql://localhost:3306/ATM";
                String username = "root";
                String password = "Masoom@16";

                Connection connection = DriverManager.getConnection(url, username, password);

                // Update the PIN in the database
                String updateQuery = "UPDATE atmjava SET PIN = ? WHERE Acc_No = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, newPIN);
                updateStatement.setString(2, Acc_No);
                int rowsUpdated = updateStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("PIN changed successfully");
                    textField.setText("0");
                    textField_1.setText("0");
                } else {
                    System.out.println("PIN change failed");
                }

                updateStatement.close();
                connection.close();
            } else {
                System.out.println("PINs do not match");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}