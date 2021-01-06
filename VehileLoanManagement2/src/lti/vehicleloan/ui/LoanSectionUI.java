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
import javax.swing.table.DefaultTableCellRenderer;

import com.sun.javafx.collections.ListListenerHelper;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Employee;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class LoanSectionUI extends JFrame {

	private JPanel contentPane;
	private JTable tableViewLoan;
	private JTextField textEnterLoanId;
	private ResultSet res;
	DefaultListModel DLM = new DefaultListModel();
	private JList listLoan;
	private static Employee emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanSectionUI frame = new LoanSectionUI(emp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadTable() {
		LoanServiceLayer lsl = new LoanServiceLayer();
		res = lsl.viewLoan();
	tableViewLoan.setModel(DbUtils.resultSetToTableModel(res));
	}
	/**
	 * Create the frame.
	 */
	public LoanSectionUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Car Loan Section");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1112, 86);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1090, 167);
		contentPane.add(scrollPane);
		
		tableViewLoan = new JTable();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableViewLoan.setDefaultRenderer(String.class, centerRenderer);
		tableViewLoan.setRowHeight(30);
		tableViewLoan.setFont(new Font("Calibri", Font.PLAIN, 17));
		scrollPane.setViewportView(tableViewLoan);
		
		JButton buttonViewLoan = new JButton("View Loan");
		buttonViewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textEnterLoanId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Loan ID text field cannot be blank.");
				}else {
					LoanServiceLayer lsl = new LoanServiceLayer();
					int loanId = Integer.parseInt(textEnterLoanId.getText());
					boolean isLoan = lsl.isLoan(loanId);
					DefaultListModel DLM = new DefaultListModel();

					if(isLoan) {
						res = lsl.viewLoan(loanId);
						try {
							while(res.next()) {
								DLM.addElement("<html><p>Loan ID :  "+res.getInt(1)+"</p><p>Loan Name :  "+res.getString(2)+"</p><p>Loan Type :  "+res.getString(3)+"</p><p>Loan Princpal Amount Details :  "+res.getString(7)+"</p><p>Loan Rate of Interest (%p.a.) :  "+res.getString(4)+"</p><p>Loan Term (Months) :  "+res.getInt(5)+"</p><p>Loan Down Payment :  "+res.getDouble(6)+"</p></html>");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						listLoan.setModel(DLM);
						
					}else {
						JOptionPane.showMessageDialog(null, "Loan with Loan ID not present.");
					}
				}
				
			}
		});
		buttonViewLoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonViewLoan.setBounds(871, 515, 229, 48);
		contentPane.add(buttonViewLoan);
		
		JButton buttonAddNewLoan = new JButton("Add New Loan");
		buttonAddNewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emp.getEmpJob().equalsIgnoreCase("manager")) {
					ManagerAddLoanUI malui = new ManagerAddLoanUI(emp);
					malui.setVisible(true);
					dispose();
				}else {
					buttonAddNewLoan.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Adding Loan Authority is only with the Manager.");
				}
				
			}
		});
		buttonAddNewLoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonAddNewLoan.setBounds(752, 309, 348, 48);
		contentPane.add(buttonAddNewLoan);
		
		JButton btnUpdateLoan = new JButton("Update Loan");
		btnUpdateLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emp.getEmpJob().equalsIgnoreCase("manager")) {
					if(textEnterLoanId.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Loan ID field cannot be blank.");
					}else {
						int loanId = Integer.parseInt(textEnterLoanId.getText());
						LoanServiceLayer lsl = new LoanServiceLayer();
						boolean isLoan = lsl.isLoan(loanId);
						if(isLoan) {
							ManagerUpdateLoanUI mului = new ManagerUpdateLoanUI(emp, loanId);
							mului.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Loan with Loan ID not present.");
						}
					}
				}else {
					btnUpdateLoan.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Updating Loan Authority is only with the Manager.");
				}
				
				
				
			}
		});
		btnUpdateLoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateLoan.setBounds(620, 515, 229, 48);
		contentPane.add(btnUpdateLoan);
		
		JButton btnNewButton = new JButton("Back to Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(861, 649, 208, 34);
		contentPane.add(btnNewButton);
		
		textEnterLoanId = new JTextField();
		textEnterLoanId.setBounds(620, 459, 480, 43);
		contentPane.add(textEnterLoanId);
		textEnterLoanId.setColumns(10);
		
		JLabel labelLoadId = new JLabel("Loan ID:");
		labelLoadId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLoadId.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoadId.setBounds(610, 431, 489, 29);
		contentPane.add(labelLoadId);
		
		listLoan = new JList();
		listLoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		listLoan.setBackground(new Color(240, 255, 255));
		listLoan.setFont(new Font("Calibri", Font.PLAIN, 22));
		listLoan.setBounds(39, 325, 526, 238);
		contentPane.add(listLoan);
		
		JLabel labelViewList = new JLabel("Loan Details:");
		labelViewList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelViewList.setHorizontalAlignment(SwingConstants.CENTER);
		labelViewList.setBounds(39, 279, 526, 33);
		contentPane.add(labelViewList);
		loadTable();
	}

}
