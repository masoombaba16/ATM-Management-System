package masoomjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Deposit extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private String Acc_No;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Deposit frame = new Deposit("Acc_No");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Deposit(String Acc_No) {
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
        
        JLabel lblNewLabel = new JLabel("DEPOSIT PAGE");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(608, 200, 300, 80);
        contentPane.add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Amount :");
        lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAmount.setBounds(570, 325, 150, 50);
        contentPane.add(lblAmount);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(750, 322, 200, 60);
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel lblBack = new JLabel("Logout");
        lblBack.setForeground(Color.RED);
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        lblBack.setBounds(800, 561, 150, 80);
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
        
        JButton btnNewButton = new JButton("Deposit");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnNewButton.setBounds(683, 470, 150, 60);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositAmount();
            }
        });
        contentPane.add(btnNewButton);
        
        JLabel lblBack_2 = new JLabel("back");
        lblBack_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblBack_2.setBounds(570, 561, 150, 80);
        lblBack_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		fetchFname();
        	}
        });
        contentPane.add(lblBack_2);
    }
    private void fetchFname() {
        try {
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT fname FROM atmjava WHERE Acc_No = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Acc_No);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String fname = resultSet.getString("fname");
                Signup signFrame = new Signup(Acc_No, fname);
                signFrame.setVisible(true);
                dispose();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void depositAmount() {
        try {
            double depAmount = Double.parseDouble(textField.getText());
            if (depAmount <= 0) {
                System.out.println("Invalid deposit amount");
                return;
            }
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String updateQuery = "UPDATE atmjava SET bal = bal + ? WHERE Acc_No = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setDouble(1, depAmount);
                    updateStatement.setString(2, Acc_No);
                    int rowsUpdated = updateStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Deposit successful");
                        textField.setText("0");
                    } else {
                        System.out.println("Deposit failed");
                    }
                }
            }
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}