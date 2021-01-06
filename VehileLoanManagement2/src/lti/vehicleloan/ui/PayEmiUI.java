package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.dao.StatusServiceLayer;
import lti.vehicleloan.entity.Customer;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PayEmiUI extends JFrame {

	private JPanel contentPane;
	private DefaultListModel DLM2;
	private ResultSet res2;
	private ResultSet res1;
	private static Customer c;
	private JList listStatus;
	private JTable tableLoan;
	private JTextField textAppId;
	private JLabel labelShowEMI;
	private double emi;
	private int appId;
	private Date checkdate;
	private JButton buttonPayEMI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayEmiUI frame = new PayEmiUI(c);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadTable(int cusId) {
		StatusServiceLayer ssl1 = new StatusServiceLayer();
		res1 = ssl1.searchStatusfromCus(cusId);
		tableLoan.setModel(DbUtils.resultSetToTableModel(res1));
	}
	public void loadList(int appId) {
		StatusServiceLayer ssl2 = new StatusServiceLayer();
		res2 = ssl2.searchStatus(appId);
		DLM2 = new DefaultListModel();
			try {
				while(res2.next()) {
					DLM2.addElement("<html><p>Application ID :  "+res2.getInt(1)+"</p><p>Loan ID :  "+res2.getInt(2)+"</p><p>Customer ID"+res2.getInt(3)+"</p><p>Loan Amount :  Rs. "+res2.getDouble(4)+"</p><p>Loan ROI :  "+res2.getDouble(5)+" %</p><p>Loan Term :  "+res2.getInt(6)+" Months</p><p>EMI :  Rs. "+res2.getDouble(7)+"</p><p>EMI paid last month :  "+res2.getString(8)+"</p><p>Loan Term left: "+res2.getInt(10)+" Months</p><p>Total Payable Amount :  Rs. "+res2.getDouble(11)+"</p><p>Total Paid Back :  Rs. "+res2.getDouble(9)+"</p><p>Total Payable Amounr left :  Rs. "+res2.getDouble(12)+"</p></html>");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		listStatus.setModel(DLM2);
		emi = ssl2.emiFromLoan(appId);
		String emistring = Double.toString(emi);
		char rupee = '\u20B9';
		labelShowEMI.setText(rupee+" "+emistring);
	}
	/**
	 * Create the frame.
	 */
	public PayEmiUI(Customer c) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Dashboard = new JLabel("Pay EMI");
		Dashboard.setForeground(SystemColor.text);
		Dashboard.setFont(new Font("Corbel", Font.PLAIN, 44));
		Dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		Dashboard.setOpaque(true);
		Dashboard.setBackground(new Color(165, 42, 42));
		Dashboard.setBounds(0, 0, 1066, 104);
		contentPane.add(Dashboard);
		
		listStatus = new JList();
		listStatus.setFont(new Font("Calibri", Font.PLAIN, 17));
		listStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		listStatus.setBackground(new Color(240, 255, 255));
		listStatus.setBounds(12, 318, 578, 313);
		contentPane.add(listStatus);
		
		JLabel lblNewLabel = new JLabel("Loan Status");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 271, 578, 34);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 117, 1009, 141);
		contentPane.add(scrollPane);
		
		tableLoan = new JTable();
		tableLoan.setFont(new Font("Calibri", Font.PLAIN, 17));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableLoan.setDefaultRenderer(String.class, centerRenderer);
		tableLoan.setRowHeight(30);
		scrollPane.setViewportView(tableLoan);
		tableLoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("Show Loan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAppId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application text field cannot be empty.");
				}else {
					appId = Integer.parseInt(textAppId.getText());
					loadList(appId);
				}
			
			}
		});
		btnNewButton.setBounds(795, 398, 97, 25);
		contentPane.add(btnNewButton);
		
		textAppId = new JTextField();
		textAppId.setBounds(778, 359, 134, 34);
		contentPane.add(textAppId);
		textAppId.setColumns(10);
		
		JLabel viewLoan = new JLabel("Show Car loan with Application ID:");
		viewLoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewLoan.setHorizontalAlignment(SwingConstants.CENTER);
		viewLoan.setBounds(705, 332, 275, 25);
		contentPane.add(viewLoan);
		
		buttonPayEMI = new JButton("Proceed to Pay EMI");
		buttonPayEMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerServiceLayer csl3 = new CustomerServiceLayer();
				//double days = csl3.lastemidays(c.getCusId());
				//if(days>1) {
					buttonPayEMI.setEnabled(true);
					EmiPaymentPortalUI emippui = new EmiPaymentPortalUI(c,emi,appId);
					emippui.setVisible(true);
					dispose();
				//}else {

				/*
				 * JOptionPane.showMessageDialog(null, "Payment already done for the month.");
				 * buttonPayEMI.setEnabled(false);
				 */
				//}

			}
		});
		buttonPayEMI.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonPayEMI.setOpaque(true);
		buttonPayEMI.setBackground(new Color(240, 230, 140));
		buttonPayEMI.setBounds(728, 548, 256, 49);
		contentPane.add(buttonPayEMI);
		
		JButton buttonDashboard = new JButton("Back to Dashboard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
				cdbui.setVisible(true);
				dispose();
			}
		});
		buttonDashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDashboard.setBounds(857, 631, 162, 34);
		contentPane.add(buttonDashboard);
		
		labelShowEMI = new JLabel(" ");
		labelShowEMI.setFont(new Font("Cambria Math", Font.BOLD, 16));
		labelShowEMI.setForeground(new Color(255, 255, 255));
		labelShowEMI.setBackground(new Color(204, 0, 102));
		labelShowEMI.setOpaque(true);
		labelShowEMI.setHorizontalAlignment(SwingConstants.CENTER);
		labelShowEMI.setBounds(728, 487, 256, 60);
		contentPane.add(labelShowEMI);
		
		loadTable(c.getCusId());
		
		
	}
}
