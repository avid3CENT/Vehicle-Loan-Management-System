 package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CustomerLoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginUI frame = new CustomerLoginUI();
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
	public CustomerLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login as Customer");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 204, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 466, 708);
		contentPane.add(lblNewLabel);
		
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setFont(new Font("Corbel", Font.BOLD, 14));
		labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsername.setOpaque(true);
		labelUsername.setBackground(SystemColor.text);
		labelUsername.setBounds(513, 290, 91, 39);
		contentPane.add(labelUsername);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Corbel", Font.BOLD, 15));
		labelPassword.setBackground(SystemColor.text);
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelPassword.setOpaque(true);
		labelPassword.setBounds(513, 342, 91, 39);
		contentPane.add(labelPassword);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setBounds(610, 289, 249, 39);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(610, 342, 249, 39);
		contentPane.add(passwordField);
		
		JButton buttonHome = new JButton("Home");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeUI welcome = new WelcomeUI();
				welcome.setVisible(true);
				dispose();
				
			}
		});
		buttonHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonHome.setBounds(875, 653, 97, 25);
		contentPane.add(buttonHome);
		
		JButton buttonSignin = new JButton("Sign in");
		buttonSignin.setBackground(Color.WHITE);
		buttonSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUsername.getText();
				String password = passwordField.getText();
				CustomerServiceLayer csl = new CustomerServiceLayer();
				List<Customer> cuslist = csl.CustomerLogIn(username, password);
				if(cuslist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "log in unsuccessful. Check username and password.");
					
				}else {
					dispose();
					JOptionPane.showMessageDialog(null, "You have sucessfully logged in.");
					for(Customer c:cuslist) {
						CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
						cdbui.setVisible(true);
					}
				}
			}
		});
		buttonSignin.setBounds(762, 405, 97, 33);
		contentPane.add(buttonSignin);
		
		JButton buttonRegister = new JButton("Register?");
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegisterUI crui = new CustomerRegisterUI();
				crui.setVisible(true);
				dispose();
			}
		});
		buttonRegister.setOpaque(true);
		buttonRegister.setBackground(Color.WHITE);
		buttonRegister.setBounds(762, 498, 97, 33);
		contentPane.add(buttonRegister);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(661, 468, 249, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton buttonForgotPass = new JButton("Forgot password?");
		buttonForgotPass.setForeground(SystemColor.window);
		buttonForgotPass.setBackground(SystemColor.textHighlight);
		buttonForgotPass.setOpaque(true);
		buttonForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerForgotPasswordUI cf = new CustomerForgotPasswordUI();
				cf.setVisible(true);
				dispose();
			}
		});
		buttonForgotPass.setBounds(513, 407, 145, 29);
		contentPane.add(buttonForgotPass);
		
	}
}
