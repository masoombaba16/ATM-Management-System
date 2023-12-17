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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Balances extends JFrame {

    private static final long serialVersionUID = 1L;
    private String Acc_No;
    private double bal;
    private String fname;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Balances frame = new Balances("Acc_No");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Balances(String Acc_No) {
    	this.Acc_No=Acc_No;
    	fetchAccount();
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
        
        JLabel lblBalancesPage = new JLabel("BALANCES PAGE");
        lblBalancesPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblBalancesPage.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblBalancesPage.setBounds(608, 200, 300, 80);
        contentPane.add(lblBalancesPage);
        
        JLabel lblAccountNo = new JLabel("ACCOUNT NO : "+ Acc_No);
        lblAccountNo.setHorizontalAlignment(SwingConstants.LEFT);
        lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblAccountNo.setBounds(460, 430, 600, 80);
        contentPane.add(lblAccountNo);
        
        JLabel lblYourBalance = new JLabel("YOUR BALANCE : "+ bal);
        lblYourBalance.setHorizontalAlignment(SwingConstants.LEFT);
        lblYourBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblYourBalance.setBounds(460, 520, 300, 80);
        contentPane.add(lblYourBalance);
        
        JLabel lblBack = new JLabel("Logout");
        lblBack.setForeground(Color.RED);
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        lblBack.setBounds(820, 620, 150, 80);
        lblBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        contentPane.add(lblBack);
        
        JLabel lblAccountHolder = new JLabel("Account Holder : "+fname);
        lblAccountHolder.setHorizontalAlignment(SwingConstants.LEFT);
        lblAccountHolder.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblAccountHolder.setBounds(460, 332, 600, 80);
        contentPane.add(lblAccountHolder);
        
        JLabel lblBack_2 = new JLabel("Back");
        lblBack_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblBack_2.setBounds(680, 620, 150, 80);
        lblBack_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Signup signFrame=new Signup(Acc_No,fname);
        		signFrame.setVisible(true);
        	}
        });
        contentPane.add(lblBack_2);
    }
    private void fetchAccount() {
        try {
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT fname, bal FROM atmjava WHERE Acc_No = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Acc_No);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                fname = resultSet.getString("fname");
                bal = resultSet.getDouble("bal");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
