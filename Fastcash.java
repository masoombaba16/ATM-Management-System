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
import javax.swing.JButton;

public class Fastcash extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fastcash frame = new Fastcash("Acc_No");
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
    private double getbalance(String Acc_No) {
        double bal = 0.0;
        try {
            // Replace these values with your database connection details
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";

            Connection connection = DriverManager.getConnection(url, username, password);

            // Modify the SQL query according to your database schema
            String query = "SELECT bal FROM atmjava WHERE Acc_No = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Acc_No);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                bal = resultSet.getDouble("bal");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bal;
    }

    public Fastcash(String Acc_No) {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBank = new JLabel("<html><center>BANK<br><br>ATM Management System</center></html>");
        lblBank.setBounds(10, 0, 1516, 150);
        lblBank.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblBank.setOpaque(true);
        lblBank.setBackground(new Color(0, 128, 255));
        lblBank.setForeground(Color.BLACK);
        lblBank.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblBank);
        
        JLabel lblNewLabel = new JLabel("FASTCASH PAGE");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBounds(633, 150, 250, 80);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Rs 100");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton.setBounds(300, 350, 250, 80);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,100);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Rs 500");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setBounds(966, 350, 250, 80);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,500);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Rs 1000");
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_2.setBackground(Color.WHITE);
        btnNewButton_2.setBounds(300, 470, 250, 80);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,1000);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_4 = new JButton("Rs 5000");
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_4.setBackground(Color.WHITE);
        btnNewButton_4.setBounds(300, 590, 250, 80);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,5000);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Rs 10000");
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_5.setBackground(Color.WHITE);
        btnNewButton_5.setBounds(966, 590, 250, 80);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,10000);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_5);
        
        JButton btnNewButton_3 = new JButton("Rs 2000");
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_3.setBackground(Color.WHITE);
        btnNewButton_3.setBounds(966, 470, 250, 80);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,2000);
                withFrame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel_1 = new JLabel("Logout");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_1.setBounds(683, 670, 150, 50);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Bank..");
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(new Color(0, 128, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 730, 1516, 60);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblBalance = new JLabel("BALANCE");
        lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblBalance.setForeground(Color.BLACK);
        lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblBalance.setBounds(633, 470, 250, 80);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Balances balFrame=new Balances(Acc_No);
        		balFrame.setVisible(true);
        	}
        });
        contentPane.add(lblBalance);
        
        JLabel lblNewLabel_3 = new JLabel("Account No : " + Acc_No);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_3.setBounds(580, 250, 600, 60);
        contentPane.add(lblNewLabel_3);
    }
}
