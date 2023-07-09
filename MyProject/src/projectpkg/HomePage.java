package projectpkg;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {

//	private JFrame frame;
	private JTable table;
	private final JPanel train_list = 
			new JPanel();
	private JComboBox from;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		this = new JFrame();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(new Color(128, 128, 192));
		toppanel.setBounds(0, 0, 1555, 217);
		this.getContentPane().add(toppanel);
		toppanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Trains");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(465, 20, 251, 37);
		toppanel.add(lblNewLabel);
//		
		train_list.setBackground(new Color(128, 128, 128));
		JScrollPane sp = new JScrollPane(train_list);
		sp.setBounds(0, 216, 1540, 629);
		train_list.setLayout(new GridLayout(3,2,10,10));
		this.getContentPane().add(sp);
					
//		List<Map<String, String>> trains = new ArrayList<Map<String, String>>();
//		for(int i=0;i< 6;i++) {
//			HashMap<String, String> h = new HashMap<>();
//			h.put("num",String.valueOf(i+1));
//			trains.add(h);
//		}
		
//		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
			Statement stmt=con.createStatement();
			String query="select * from trains";
			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				JPanel panel_2 = new JPanel();
				panel_2.setPreferredSize(new Dimension(300,300));
				train_list.add(panel_2);
//				panel_2.setLayout(new GridLayout(5, 1, 0, 0));
				panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
				panel_2.setPreferredSize(new Dimension(300,300));
//				panel_2.setPreferredSize(new Dimension(300,300));
				train_list.add(panel_2);
				panel_2.setLayout(new GridLayout(6, 1, 0, 0));
						
//				System.out.println(trains[i]);
				JLabel name = new JLabel(rs.getString(1));
				name.setAlignmentX(Component.CENTER_ALIGNMENT);
				name.setFont(new Font("Segoe UI", Font.PLAIN, 24));
				panel_2.add(name);
				
				name = new JLabel(rs.getString(2));
				name.setAlignmentX(Component.CENTER_ALIGNMENT);
				name.setFont(new Font("Segoe UI", Font.PLAIN, 24));
				panel_2.add(name);
				
				JLabel desti = new JLabel(rs.getString(3)+" -> "+rs.getString(4));
				desti.setAlignmentX(Component.CENTER_ALIGNMENT);
				desti.setFont(new Font("Segoe UI", Font.PLAIN, 24));
				panel_2.add(desti);
				
				JLabel lblNewLabel_1 = new JLabel(rs.getString(5)+" - "+rs.getString(6));
				lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
				panel_2.add(lblNewLabel_1);
				
				JLabel amount = new JLabel("Amount: "+rs.getString(7));
				amount.setAlignmentX(Component.CENTER_ALIGNMENT);
				amount.setFont(new Font("Segoe UI", Font.PLAIN, 30));
				panel_2.add(amount);
				
				
				String num = rs.getString(1);
				JButton btn = new JButton("Book");
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Booking(num).setVisible(true);
					}
				});
				panel_2.add(btn);
			}
		}catch(Exception e) {
			
		}
		JButton cancelbtn = new JButton("CANCEL");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		cancelbtn.setPreferredSize(new Dimension(300,100));
		train_list.add(cancelbtn);
		

	}
}
