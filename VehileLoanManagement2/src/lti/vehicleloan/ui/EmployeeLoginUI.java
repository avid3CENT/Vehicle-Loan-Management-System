package lti.vehicleloan.ui;

import lti.vehicleloan.dao.EmployeeServiceLayer;
import lti.vehicleloan.dbconnection.*;
import lti.vehicleloan.entity.Employee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EmployeeLoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLoginUI frame = new EmployeeLoginUI();
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
	public EmployeeLoginUI() {
		introduce();
	}
	

	public void introduce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login as Employee");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(0, 204, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 466, 708);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 204, 0));
		lblNewLabel_1.setBounds(513, 290, 91, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2.setBackground(new Color(0, 204, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(513, 342, 91, 39);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(610, 289, 249, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				EmployeeServiceLayer esl = new EmployeeServiceLayer();
				List<Employee> isLogin = esl.EmployeeLogIn(username, password);
				if(isLogin.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Log in unsuccessful. Check username and password");
					
				}else {
					dispose();
					JOptionPane.showMessageDialog(null, "You have sucessfully logged in.");
					for(Employee emp:isLogin) {
						if(emp.getEmpJob().equalsIgnoreCase("manager")) {
							ManagerDashBoardUI mdb = new ManagerDashBoardUI(emp);
							mdb.setVisible(true);
						}else {
							StaffDashBoard sdb = new StaffDashBoard(emp);
							sdb.setVisible(true);
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Corbel", Font.BOLD, 14));
		btnNewButton.setBounds(762, 415, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeUI welcome = new WelcomeUI();
				welcome.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(875, 653, 97, 25);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(610, 342, 249, 39);
		contentPane.add(passwordField);
	}
}
