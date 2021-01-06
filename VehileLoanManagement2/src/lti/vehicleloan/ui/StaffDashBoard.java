package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.entity.Employee;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffDashBoard extends JFrame {

	private JPanel contentPane;
	private static Employee emp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffDashBoard frame = new StaffDashBoard(emp);
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
	public StaffDashBoard(Employee emp) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Staff Dashboard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.menuText);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		lblNewLabel.setBounds(0, 0, 442, 691);
		contentPane.add(lblNewLabel);
		
		JButton buttonCustomer = new JButton("Search Customer");
		buttonCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCustomer.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				SearchCustomerUI mscui = new SearchCustomerUI(emp);
				mscui.setVisible(true);
				dispose();
			}
		});
		buttonCustomer.setBounds(505, 198, 497, 69);
		contentPane.add(buttonCustomer);
		
		JLabel lblNewLabel_1 = new JLabel("Logged in with: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel_1.setBounds(442, 0, 613, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID: "+emp.getEmpNo()+"       Name: "+emp.getEmpName());
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 21));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(442, 51, 613, 58);
		contentPane.add(lblNewLabel_2);
		
		JButton buttonCarLoan = new JButton("Car Loan Section");
		buttonCarLoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCarLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanSectionUI lsui = new LoanSectionUI(emp);
				lsui.setVisible(true);
				dispose();
			}
		});
		buttonCarLoan.setBounds(505, 297, 497, 69);
		contentPane.add(buttonCarLoan);
		
		JButton buttonViewApplication = new JButton("View Loan Applications");
		buttonViewApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationWindowUI awui = new ApplicationWindowUI(emp);
				awui.setVisible(true);
				dispose();
			}
		});
		buttonViewApplication.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonViewApplication.setForeground(new Color(0, 0, 0));
		buttonViewApplication.setBounds(505, 399, 497, 69);
		contentPane.add(buttonViewApplication);
		
		JButton buttonLoanStatus = new JButton("Check Approved Loan Status");
		buttonLoanStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckLoanStatusUI clsui = new CheckLoanStatusUI(emp);
				clsui.setVisible(true);
				dispose();
			}
		});
		buttonLoanStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonLoanStatus.setBounds(505, 499, 497, 69);
		contentPane.add(buttonLoanStatus);
		
		JButton btnNewButton_6 = new JButton("Employee Login");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLoginUI elui = new EmployeeLoginUI();
				elui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setBounds(872, 633, 130, 31);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Home");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeUI welcome = new WelcomeUI();
				welcome.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(505, 633, 108, 31);
		contentPane.add(btnNewButton_7);
		
	}
}
