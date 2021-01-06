package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.dao.StatusServiceLayer;
import lti.vehicleloan.entity.Employee;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckLoanStatusUI extends JFrame {

	private JPanel contentPane;
	private JTable tableViewApprovedLoans;
	private ResultSet res;
	private JScrollPane scrollPane;
	private JButton buttonViewParticular;
	private JTextField textAppId;
	private JLabel labelAppId;
	private JLabel lblNewLabel_1;
	private JButton buttonDashboard;
	private ResultSet res1;
	private ResultSet res2;
	private DefaultListModel DLM;
	private DefaultListModel DLM2;
	private JList listStatus;
	private static Employee emp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckLoanStatusUI frame = new CheckLoanStatusUI(emp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadTable() {
		StatusServiceLayer ssl = new StatusServiceLayer();
		res = ssl.viewStatus();
		tableViewApprovedLoans.setModel(DbUtils.resultSetToTableModel(res));
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
	}
	/**
	 * Create the frame.
	 */
	public CheckLoanStatusUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loan Status Section");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1055, 86);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1033, 183);
		contentPane.add(scrollPane);

		tableViewApprovedLoans = new JTable();
		tableViewApprovedLoans.setFont(new Font("Calibri", Font.PLAIN, 17));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableViewApprovedLoans.setDefaultRenderer(String.class, centerRenderer);
		tableViewApprovedLoans.setRowHeight(30);
		scrollPane.setViewportView(tableViewApprovedLoans);

		buttonViewParticular = new JButton("View Status");
		buttonViewParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textAppId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application ID text field cannot be blank.");
				}else {
					StatusServiceLayer ssl = new StatusServiceLayer();
					int appId = Integer.parseInt(textAppId.getText());
					boolean isStatus = ssl.checkStatus(appId);
					if(isStatus) {
						loadList(appId);
					}else {
						JOptionPane.showMessageDialog(null, "No loan status this Application ID.");
					}

				}
			}
		});
		buttonViewParticular.setBounds(823, 423, 178, 41);
		contentPane.add(buttonViewParticular);

		textAppId = new JTextField();
		textAppId.setBounds(823, 369, 178, 41);
		contentPane.add(textAppId);
		textAppId.setColumns(10);

		labelAppId = new JLabel("Enter Application ID: ");
		labelAppId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAppId.setHorizontalAlignment(SwingConstants.CENTER);
		labelAppId.setBounds(823, 329, 178, 32);
		contentPane.add(labelAppId);

		lblNewLabel_1 = new JLabel("Application Loan Status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(44, 308, 514, 32);
		contentPane.add(lblNewLabel_1);

		buttonDashboard = new JButton("Go to Dashboard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emp.getEmpJob().equalsIgnoreCase("manager")) {
					ManagerDashBoardUI mdbui = new ManagerDashBoardUI(emp);
					mdbui.setVisible(true);
					dispose();

				}else if(emp.getEmpJob().equalsIgnoreCase("staff member")) {
					StaffDashBoard sdf = new StaffDashBoard(emp);
					sdf.setVisible(true);
					dispose();
				}
			}
		});
		buttonDashboard.setBounds(793, 611, 208, 32);
		contentPane.add(buttonDashboard);

		listStatus = new JList();
		listStatus.setFont(new Font("Calibri", Font.PLAIN, 17));
		listStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		listStatus.setBackground(new Color(240, 255, 255));
		listStatus.setBounds(32, 353, 526, 300);
		contentPane.add(listStatus);
		loadTable();



	}

}
