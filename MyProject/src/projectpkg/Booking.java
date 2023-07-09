package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Booking extends JFrame{

	private JFrame frame;
	private JTextField name;
	private JTextField age;
	private JTextField houseno;
	private JTextField district;
	private JTextField street;
	private JTextField mobno;
	private JTextField from;
	private JTextField date;
	
	String train_no;
	private JTextField gender;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Booking(String train_no) {
		setTitle("Bookings");
		this.train_no = train_no;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 999, 715);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Details -");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(277, 21, 260, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(34, 82, 57, 25);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(181, 89, 139, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(416, 82, 51, 25);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("House Number");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(34, 161, 132, 25);
		frame.getContentPane().add(lblGender);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistrict.setBounds(34, 196, 71, 25);
		frame.getContentPane().add(lblDistrict);
		
		JLabel lblGender_1 = new JLabel("Gender");
		lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender_1.setBounds(34, 231, 71, 25);
		frame.getContentPane().add(lblGender_1);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(581, 89, 139, 19);
		frame.getContentPane().add(age);
		
		houseno = new JTextField();
		houseno.setColumns(10);
		houseno.setBounds(181, 168, 139, 19);
		frame.getContentPane().add(houseno);
		
		district = new JTextField();
		district.setColumns(10);
		district.setBounds(181, 203, 139, 19);
		frame.getContentPane().add(district);
		
		street = new JTextField();
		street.setColumns(10);
		street.setBounds(581, 161, 139, 19);
		frame.getContentPane().add(street);
		
		JLabel lblAddress = new JLabel("Address Details");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(34, 126, 144, 25);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStreet.setBounds(416, 161, 132, 25);
		frame.getContentPane().add(lblStreet);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNationality.setBounds(416, 236, 132, 25);
		frame.getContentPane().add(lblNationality);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(34, 278, 134, 25);
		frame.getContentPane().add(lblMobileNumber);
		
		mobno = new JTextField();
		mobno.setColumns(10);
		mobno.setBounds(181, 285, 139, 19);
		frame.getContentPane().add(mobno);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFrom.setBounds(34, 329, 71, 25);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTo.setBounds(414, 329, 71, 25);
		frame.getContentPane().add(lblTo);
		
		from = new JTextField();
		from.setFont(new Font("Tahoma", Font.PLAIN, 13));
		from.setEditable(false);
		from.setText("Ernakulam");
		from.setColumns(10);
		from.setBounds(181, 329, 139, 19);
		frame.getContentPane().add(from);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(34, 376, 71, 25);
		frame.getContentPane().add(lblDate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(181, 382, 139, 19);
		frame.getContentPane().add(date);
		
		JLabel lblSeatPreference = new JLabel("Seat Preference");
		lblSeatPreference.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeatPreference.setBounds(416, 376, 139, 25);
		frame.getContentPane().add(lblSeatPreference);
		
		String s[]= {"Upper Berth", "Middle Berth", "Lower Berth"};
		JComboBox seatpref = new JComboBox(s);
		seatpref.setFont(new Font("Tahoma", Font.PLAIN, 13));
		seatpref.setBounds(581, 376, 139, 21);
		frame.getContentPane().add(seatpref);
		
		JLabel train_num = new JLabel(this.train_no);
		train_num.setFont(new Font("Tahoma", Font.BOLD, 30));
		train_num.setBounds(550, 21, 157, 37);
		getContentPane().add(train_num);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(181, 238, 139, 19);
		getContentPane().add(gender);
		
		JButton savebtn = new JButton("Save");
//		savebtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				new HomePage().setVisible(true);
//				try
//				{
////					String password=new String(pswdField.getPassword());		
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
//					Statement stmt=con.createStatement();
//					String query="select count(bookdetid) from bookdetails";
//					
//					ResultSet rs=stmt.executeQuery(query);
//					rs.next();
//					int bookdetid=rs.getInt(1);
//					int newbookid=bookdetid+1;
//					String sql="insert into bookdetails values(?,?,?,?,?,?,?,?,?,?)";
//					PreparedStatement ps=con.prepareStatement(sql);
//					ps.setInt(1,newbookid);
//					ps.setString(2,name.getText());
//					ps.setInt(3, Integer.parseInt(age.getText()));
//					ps.setInt(4, Integer.parseInt(houseNo.getText()));
//					ps.setString(5, street.getText());
//					ps.setString(6, district.getText());
//					ps.setString(7, gender.getText());
//					ps.setString(8, nationality.getText());
//					ps.setLong(9, Long.parseLong(mobno.getText()));
////					ps.setString(3, password);
//					ps.setString(10,from.getText());
//					ps.setString(11,to.getText());
//					ps.setString(12,date.getText());
//					ps.setString(13,seatpref.getText());
//
////					new HomePage().setVisible(true);
//					try
//					{
//						int i=ps.executeUpdate();
//						System.out.println(i);
//					}
//					catch(Exception ex) 
//					{
//							System.out.println(ex); 
//					}
//			}
//			catch(Exception e1) 
//			{
//					System.out.println(e1); }
////				this.setVisible(false);
////				new HomePage().setVisible(true);
//			}
//		});
		savebtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		savebtn.setBounds(416, 468, 85, 21);
		getContentPane().add(savebtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chennai", "Thiruvananthapuram", "Palakkad", "Kollam", "Bengaluru", "Mysore"}));
		comboBox.setBounds(581, 335, 139, 21);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(581, 238, 139, 19);
		getContentPane().add(textField);
	}
}
