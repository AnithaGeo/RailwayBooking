package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class Registration extends JFrame{

//	private JFrame frame;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField houseNo;
	private JTextField streetField;
	private JTextField district;
	private JTextField mobNoField;
	private JPasswordField pswdField;
	private JTextField firstname;
	private JTextField Gender;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registration window = new Registration();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Registration() {
		setTitle("Registration");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
		this.setBounds(100, 100, 610, 351);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(261, 81, 84, 19);
		this.setBounds(100, 100, 610, 351);
		this.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel name = new JLabel("Full Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(93, 81, 103, 19);
		this.getContentPane().add(name);
		
		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		age.setBounds(93, 106, 103, 19);
		this.getContentPane().add(age);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(93, 131, 103, 19);
		this.getContentPane().add(gender);
		
		JLabel mobno = new JLabel("Mobile Number");
		mobno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mobno.setBounds(93, 231, 103, 19);
		this.getContentPane().add(mobno);
		
		JLabel Street = new JLabel("Street");
		Street.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Street.setBounds(93, 181, 103, 19);
		this.getContentPane().add(Street);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(261, 106, 84, 19);
		this.getContentPane().add(ageField);
		
		houseNo = new JTextField();
		houseNo.setColumns(10);
		houseNo.setBounds(261, 156, 84, 19);
		this.getContentPane().add(houseNo);
		
		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(261, 181, 84, 19);
		this.getContentPane().add(streetField);
		
		JLabel registering = new JLabel("REGISTER");
		registering.setFont(new Font("Tahoma", Font.BOLD, 22));
		registering.setBounds(93, 20, 115, 27);
		this.getContentPane().add(registering);
		
		JButton registerBtn = new JButton("REGISTER");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new HomePage().setVisible(true);
				try
				{
					String password=new String(pswdField.getPassword());		
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String query="select count(userid) from users";
					
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int userid=rs.getInt(1);
					int newuserid=userid+1;
					String sql="insert into users values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,newuserid);
					ps.setString(2,firstname.getText());
					ps.setString(3, password);
					ps.setString(4,nameField.getText());
					ps.setInt(5, Integer.parseInt(ageField.getText()));
//					String es=buttonGroup.getSelection().getActionCommand();
					ps.setString(6, Gender.getText());
					ps.setInt(7, Integer.parseInt(houseNo.getText()));
					ps.setString(8, streetField.getText());
					ps.setString(9, district.getText());
					ps.setLong(10, Long.parseLong(mobNoField.getText()));
					new HomePage().setVisible(true);
					try
					{
						int i=ps.executeUpdate();
						System.out.println(i);
					}
					catch(Exception ex) 
					{
							System.out.println(ex); 
					}
			}
			catch(Exception e1) 
			{
					System.out.println(e1); }
//				this.setVisible(false);
//				new HomePage().setVisible(true);
			}
		});
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		registerBtn.setBounds(431, 153, 98, 23);
		this.getContentPane().add(registerBtn);
		
		JLabel HouseNumber = new JLabel("House Number");
		HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		HouseNumber.setBounds(93, 156, 103, 19);
		getContentPane().add(HouseNumber);
		
		district = new JTextField();
		district.setColumns(10);
		district.setBounds(261, 206, 84, 19);
		getContentPane().add(district);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDistrict.setBounds(93, 206, 103, 19);
		getContentPane().add(lblDistrict);
		
		mobNoField = new JTextField();
		mobNoField.setColumns(10);
		mobNoField.setBounds(261, 231, 84, 19);
		getContentPane().add(mobNoField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(93, 251, 103, 19);
		getContentPane().add(lblPassword);
		
		pswdField = new JPasswordField();
		pswdField.setColumns(10);
		pswdField.setBounds(261, 251, 84, 19);
		getContentPane().add(pswdField);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(93, 56, 103, 19);
		getContentPane().add(lblFirstName);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(261, 56, 84, 19);
		getContentPane().add(firstname);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		Gender.setBounds(261, 131, 84, 19);
		getContentPane().add(Gender);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\traintrain.jpeg"));
		lblNewLabel.setBounds(0, 0, 651, 351);
		getContentPane().add(lblNewLabel);
		
	}
}
