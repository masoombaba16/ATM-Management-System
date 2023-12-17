package masoomjava;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class Signup extends JFrame {
    private JLabel lblAccountHolder;
    private JLabel lblNewLabel;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signup frame = new Signup("your_account_number", "your_firstname");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private double getbalance(String Acc_No) {
        double bal = 0.0;
        try {
            String url = "jdbc:mysql://localhost:3306/ATM";
            String username = "root";
            String password = "Masoom@16";

            Connection connection = DriverManager.getConnection(url, username, password);
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


    public Signup(String Acc_No,String fname) {
    	
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBank = new JLabel("<html><center>\r\nEngineerEdu Finance Gateway<br><br>\"SecureSwipe: Revolutionizing Access to Your Finances\"</center></html>");
        lblBank.setBounds(10, 0, 1516, 150);
        lblBank.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblBank.setOpaque(true);
        lblBank.setBackground(Color.YELLOW);
        lblBank.setForeground(Color.BLACK);
        lblBank.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblBank);
        
        lblNewLabel = new JLabel("Account No :  "+Acc_No);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(382, 240, 1000, 80);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Deposit");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 Deposit depFrame = new Deposit(Acc_No);
                 depFrame.setVisible(true);
             }
         });
        btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton.setBounds(300, 350, 250, 80);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Withdraw");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double bal = getbalance(Acc_No); // You can pass any default value since it's not used in the method
                Withdraw withFrame = new Withdraw(Acc_No, bal,0);
                withFrame.setVisible(true);
            }
        });

    
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setBounds(750, 350, 250, 80);
        contentPane.add(btnNewButton_1);
        
        
        JButton btnNewButton_2 = new JButton("Fastcash");
        btnNewButton_2.addActionListener(new ActionListener() {
           	 public void actionPerformed(ActionEvent e) {
                    Fastcash fastFrame = new Fastcash(Acc_No);
                    fastFrame.setVisible(true);
                }
            });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_2.setBackground(Color.WHITE);
        btnNewButton_2.setBounds(300, 470, 250, 80);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_4 = new JButton("Change PIN");
        btnNewButton_4.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
                ChangePIN changeFrame = new ChangePIN(Acc_No);
                changeFrame.setVisible(true);
            }
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_4.setBackground(Color.WHITE);
        btnNewButton_4.setBounds(300, 590, 250, 80);
        contentPane.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Balance");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Balances changeFrame = new Balances(Acc_No);
                changeFrame.setVisible(true);
            }
        });
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_5.setBackground(Color.WHITE);
        btnNewButton_5.setBounds(750, 470, 250, 80);
        contentPane.add(btnNewButton_5);
        
        JButton btnNewButton_3 = new JButton("Edit");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updates MiniFrame=new updates(Acc_No);
        		MiniFrame.setVisible(true);
        	}
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_3.setBackground(Color.WHITE);
        btnNewButton_3.setBounds(750, 590, 250, 80);
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel_1 = new JLabel("Logout");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login LoginFrame=new Login();
        		LoginFrame.setVisible(true);
        	}
        });
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 25));
        lblNewLabel_1.setBounds(575, 680, 150, 50);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Bank..");
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(new Color(0, 128, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 730, 1516, 60);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setBounds(1100, 320, 300, 350); 
        ImageIcon imageIcon = new ImageIcon(Signup.class.getResource("/atm1.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(315, 370, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        lblNewLabel_3.setIcon(scaledImageIcon);
        contentPane.add(lblNewLabel_3);
        
        lblAccountHolder = new JLabel("Account Holder :  "+fname);
        lblAccountHolder.setForeground(Color.BLACK);
        lblAccountHolder.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblAccountHolder.setBounds(370, 170, 1000, 80);
        contentPane.add(lblAccountHolder);
    }
}
