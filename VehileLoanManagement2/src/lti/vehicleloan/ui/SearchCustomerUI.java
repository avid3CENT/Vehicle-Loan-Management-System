package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Employee;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class SearchCustomerUI extends JFrame {

	private JPanel contentPane;
	private JTable tableViewCustomer;
	private JTextField textCustomerId;
	private JButton buttonDashboard;
	private ResultSet res;
	private ResultSet res1;
	private ResultSet res2;
	private DefaultListModel DLM1;
	private DefaultListModel DLM2;
	private JScrollPane scrollPane;
	private JList listCustomer;
	private JList listCustAddress;
	
	private JLabel labelCustomerDetails;
	private JLabel lblCustomerPerAddress;
	private static Employee emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCustomerUI frame = new SearchCustomerUI(emp);
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
	public void loadTable() {
		CustomerServiceLayer csl = new CustomerServiceLayer();
		res = csl.viewAllCustomer();
		tableViewCustomer.setModel(DbUtils.resultSetToTableModel(res));
	}
	public SearchCustomerUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Customer");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(51, 153, 153));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		lblNewLabel.setBounds(0, 0, 1055, 123);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 1033, 190);
		contentPane.add(scrollPane);
		
		tableViewCustomer = new JTable();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableViewCustomer.setDefaultRenderer(String.class, centerRenderer);
		tableViewCustomer.setRowHeight(30);
		tableViewCustomer.setFont(new Font("Calibri", Font.PLAIN, 17));
		scrollPane.setViewportView(tableViewCustomer);
		
		JButton buttonSearchId = new JButton("Search");
		buttonSearchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textCustomerId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Customer ID text field cannot be empty.");
				}else {
					CustomerServiceLayer csl = new CustomerServiceLayer();
					int cusId = Integer.parseInt(textCustomerId.getText());
					boolean isCustomer = csl.checkCustomer(cusId);
					if(isCustomer) {
						res1 = csl.customerDetails(cusId);
						res2 = csl.viewAddress(cusId);
						DLM1 = new DefaultListModel();
						DLM2 = new DefaultListModel();
						try {
							while(res2.next()) {
								DLM2.addElement("<html><p>  "+res2.getString(2)+"</p><p>  "+res2.getString(3)+"</p><p>  "+res2.getString(4)+"</p><p>  "+res2.getString(5)+"</p><p>  "+res2.getString(6)+"</p><p>  "+res2.getString(7)+"</p></html>");
							}
							while(res1.next()) {
								DLM1.addElement("<html><p>Customer ID :  "+res1.getInt(1)+"</p><p>Customer Name :  "+res1.getString(2)+"</p><p>Customer Contact no. :  "+res1.getString(3)+"</p><p>Customer Salary :  "+res1.getDouble(4)+"</p><p>Customer Occupation :  "+res1.getString(11)+"</p><p>Customer Aadhar no. :  "+res1.getString(7)+"</p><p>Customer Bank Account no. :  "+res1.getString(8)+"</p><p>Customer PAN no. :  "+res1.getString(9)+"%</p><p>Customer Vehicle Owned :  "+res1.getString(10)+"</p></html>");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						listCustomer.setModel(DLM1);
						listCustAddress.setModel(DLM2);
					}else {
						JOptionPane.showMessageDialog(null, "Customer with this Customer ID not present.");
					}
				}
				
	
			}
		});
		buttonSearchId.setBounds(872, 544, 116, 34);
		contentPane.add(buttonSearchId);
		
		textCustomerId = new JTextField();
		textCustomerId.setBounds(872, 506, 116, 25);
		contentPane.add(textCustomerId);
		textCustomerId.setColumns(10);
		
		JLabel labelCustomerId = new JLabel("Customer ID:");
		labelCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCustomerId.setBounds(872, 475, 116, 25);
		contentPane.add(labelCustomerId);
		
		buttonDashboard = new JButton("Go to Dashboard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emp.getEmpJob().equalsIgnoreCase("manager")) {
				ManagerDashBoardUI mdbui = new ManagerDashBoardUI(emp);
				mdbui.setVisible(true);
				dispose();
			}else if(emp.getEmpJob().equalsIgnoreCase("staff member")) {
				StaffDashBoard sdb = new StaffDashBoard(emp);
				sdb.setVisible(true);
				dispose();
			}
		}
		});
		buttonDashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDashboard.setBounds(835, 631, 174, 34);
		contentPane.add(buttonDashboard);
		
		listCustomer = new JList();
		listCustomer.setBackground(new Color(240, 255, 255));
		listCustomer.setFont(new Font("Calibri", Font.PLAIN, 17));
		listCustomer.setBounds(33, 391, 334, 274);
		contentPane.add(listCustomer);
		
		listCustAddress = new JList();
		listCustAddress.setBackground(new Color(240, 255, 255));
		listCustAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		listCustAddress.setBounds(379, 391, 334, 274);
		contentPane.add(listCustAddress);
		
		labelCustomerDetails = new JLabel("Customer Personal Information:");
		labelCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomerDetails.setBounds(33, 353, 334, 25);
		contentPane.add(labelCustomerDetails);
		
		lblCustomerPerAddress = new JLabel("Customer Address Information:");
		lblCustomerPerAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerPerAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerPerAddress.setBounds(379, 353, 334, 25);
		contentPane.add(lblCustomerPerAddress);
		
		loadTable();
	}
}
