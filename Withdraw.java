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

public class Withdraw extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private String Acc_No;
    private static double bal;
    private static double with;
    private JLabel lblYourBalance;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Withdraw frame = new Withdraw("Acc_No",bal,with);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Withdraw(String Acc_No,double bal,double with) {
    	this.Acc_No = Acc_No;
        Withdraw.bal = bal;
        Withdraw.with=with;
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
        
        JLabel lblBank_1 = new JLabel("<html><center>ATM Management System..!</center></html>");
        lblBank_1.setOpaque(true);
        lblBank_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBank_1.setForeground(Color.BLACK);
        lblBank_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblBank_1.setBackground(new Color(0, 128, 255));
        lblBank_1.setBounds(10, 700, 1516, 100);
        contentPane.add(lblBank_1);
        
        JLabel lblWithdrawPage = new JLabel("WITHDRAW PAGE");
        lblWithdrawPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblWithdrawPage.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblWithdrawPage.setBounds(608, 160, 300, 80);
        contentPane.add(lblWithdrawPage);
        
        JLabel lblAccountNo = new JLabel("ACCOUNT NO : "+Acc_No);
        lblAccountNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblAccountNo.setBounds(400, 250, 600, 80);
        contentPane.add(lblAccountNo);
        
        lblYourBalance = new JLabel("YOUR BALANCE : "+ bal);
        lblYourBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblYourBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblYourBalance.setBounds(520, 340, 300, 80);
        contentPane.add(lblYourBalance);
        
        JLabel lblBack = new JLabel("Logout");
        lblBack.setForeground(Color.RED);
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        lblBack.setBounds(800, 620, 150, 80);
        lblBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        contentPane.add(lblBack);
        
        JLabel lblAmount = new JLabel("Amount : ");
        lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblAmount.setBounds(480, 450, 300, 80);
        contentPane.add(lblAmount);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));
        textField.setBounds(710, 466, 200, 50);
        textField.setText(String.valueOf(with));
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnWithdraw.setBackground(Color.WHITE);
        btnWithdraw.setBounds(658, 560, 200, 60);
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawAmount();
            }
        });
        contentPane.add(btnWithdraw);
        
        JLabel lblBack_2 = new JLabel("back");
        lblBack_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblBack_2.setBounds(550, 620, 150, 80);
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
                dispose();  // Close the current frame (Withdraw)
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void withdrawAmount() {
        try {
            double withdrawalAmount = Double.parseDouble(textField.getText());
            if (withdrawalAmount <= 0) {
                System.out.println("Invalid withdrawal amount");
                return;
            }
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";
            Connection connection = DriverManager.getConnection(url, username, password);
            String updateQuery = "UPDATE atmjava SET bal = bal - ? WHERE Acc_No = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setDouble(1, withdrawalAmount);
            updateStatement.setString(2, Acc_No);
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Withdrawal successful");
                textField.setText("0");
                String selectQuery = "SELECT bal FROM atmjava WHERE Acc_No = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, Acc_No);
                ResultSet resultSet = selectStatement.executeQuery();
                if (resultSet.next()) {
                    bal = resultSet.getDouble("bal");
                    lblYourBalance.setText("YOUR BALANCE : " + bal);
                }
                selectStatement.close();
            } else {
                System.out.println("Withdrawal failed");
            }
            updateStatement.close();
            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}