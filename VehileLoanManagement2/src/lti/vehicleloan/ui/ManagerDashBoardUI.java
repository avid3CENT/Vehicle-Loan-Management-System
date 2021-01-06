package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.entity.Employee;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerDashBoardUI extends JFrame {

	private JPanel contentPane;
	private static Employee emp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerDashBoardUI frame = new ManagerDashBoardUI(emp);
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
	public ManagerDashBoardUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manager Dashboard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 442, 691);
		contentPane.add(lblNewLabel);

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

		JButton btnNewButton = new JButton("Settings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(946, 117, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_6 = new JButton("Employee Login");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLoginUI elui = new EmployeeLoginUI();
				elui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setBounds(875, 641, 127, 25);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Home");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeUI welcome = new WelcomeUI();
				welcome.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(506, 641, 97, 25);
		contentPane.add(btnNewButton_7);

		JButton buttonListAllApplications = new JButton("Loan Application Section");
		buttonListAllApplications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationWindowUI mawui = new ApplicationWindowUI(emp);
				dispose();
				mawui.setVisible(true);
			}
		});
		buttonListAllApplications.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonListAllApplications.setBounds(536, 223, 435, 58);
		contentPane.add(buttonListAllApplications);

		JButton btnNewButton_2 = new JButton("Seach Customer");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerUI mscui = new SearchCustomerUI(emp);
				mscui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(536, 315, 435, 58);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Car Loan Section");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanSectionUI lsui = new LoanSectionUI(emp);
				lsui.setVisible(true);
				dispose();

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(536, 408, 435, 58);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2_1 = new JButton("Check Approved Loan Status");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckLoanStatusUI clsui = new CheckLoanStatusUI(emp);
				clsui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(536, 500, 435, 58);
		contentPane.add(btnNewButton_2_1);
	}

}
