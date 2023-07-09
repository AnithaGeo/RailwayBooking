package projectpkg;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmR;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmR.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmR = new JFrame("Login page");
		frmR.setTitle("RAILWAYS");
		frmR.setResizable(false);
		frmR.setLocationRelativeTo(null);
		frmR.getContentPane().setBackground(new Color(0, 128, 192));
		frmR.getContentPane().setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.BOLD, 14));
		username.setBounds(24, 150, 84, 13);
		frmR.getContentPane().add(username);
		
		usernameField = new JTextField();
		usernameField.setBounds(118, 144, 96, 19);
		frmR.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(24, 173, 84, 13);
		frmR.getContentPane().add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 170, 96, 19);
		frmR.getContentPane().add(passwordField);
		
		JButton signin = new JButton("Sign in");
		signin.setFont(new Font("Tahoma", Font.BOLD, 15));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				Statement stmt=con.createStatement();
				
				String query="select * from users where username='"+usernameField.getText()+"' and password='"+passwordField.getText()+"'";
				ResultSet rs =((java.sql.Statement) stmt).executeQuery(query);
				if(rs.next())
				{
					
				frmR.setVisible(false);
				new HomePage().setVisible(true);
			}}
				catch(Exception e1)
				{
				System.out.println(e1);
			}}
		});
		signin.setBounds(65, 214, 96, 27);
		frmR.getContentPane().add(signin);
		
		JButton createaccount = new JButton("Create Account");
		createaccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		createaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		
		
			frmR.setVisible(false);
//			ContentPane.showMessageDialog(null, "Successfull login");
//			User us=new User(rs.getInt("USERID"));
			new Registration().setVisible(true);
			return;
	}
});
createaccount.setBounds(26, 245, 162, 27);
frmR.getContentPane().add(createaccount);

		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(75, 113, 74, 27);
		frmR.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\train-62849__340.jpg"));
		lblNewLabel.setBounds(0, 0, 552, 351);
		frmR.getContentPane().add(lblNewLabel);
		frmR.setBounds(100, 100, 561, 388);
		frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmR.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
}
