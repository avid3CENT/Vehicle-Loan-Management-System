package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ManagerSettingsUI extends JFrame {

	private JPanel contentPane;
	private JTextField textempName;
	private JTextField textempusername;
	private JTextField textemppassowrd;
	private JTextField textempcontact;
	private JTextField textAdminusername;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerSettingsUI frame = new ManagerSettingsUI();
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
	public ManagerSettingsUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Settings");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 0, 1055, 140);
		contentPane.add(lblNewLabel);
		
		JLabel labelGiveEmp = new JLabel("Give Employee Database Permission: ");
		labelGiveEmp.setForeground(Color.DARK_GRAY);
		labelGiveEmp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelGiveEmp.setHorizontalAlignment(SwingConstants.CENTER);
		labelGiveEmp.setBounds(53, 167, 326, 50);
		contentPane.add(labelGiveEmp);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(56, 241, 110, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee username: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(34, 296, 132, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Employee password: ");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setBounds(34, 349, 132, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Employee Job Title: ");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_2.setBounds(34, 402, 132, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Employee contact: ");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_3.setBounds(34, 457, 132, 27);
		contentPane.add(lblNewLabel_2_3);
		
		textempName = new JTextField();
		textempName.setBounds(178, 243, 181, 22);
		contentPane.add(textempName);
		textempName.setColumns(10);
		
		textempusername = new JTextField();
		textempusername.setColumns(10);
		textempusername.setBounds(178, 298, 181, 22);
		contentPane.add(textempusername);
		
		textemppassowrd = new JTextField();
		textemppassowrd.setColumns(10);
		textemppassowrd.setBounds(178, 351, 181, 22);
		contentPane.add(textemppassowrd);
		
		textempcontact = new JTextField();
		textempcontact.setColumns(10);
		textempcontact.setBounds(178, 459, 181, 22);
		contentPane.add(textempcontact);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("staff member");
		comboBox.addItem("manager");
		comboBox.setBounds(227, 404, 132, 22);
		contentPane.add(comboBox);
		
		JButton buttonAddEmployee = new JButton("Add employee");
		buttonAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonAddEmployee.setBounds(211, 528, 148, 25);
		contentPane.add(buttonAddEmployee);
		
		JLabel lblPersonalSettings = new JLabel("Personal Settings: ");
		lblPersonalSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalSettings.setForeground(Color.DARK_GRAY);
		lblPersonalSettings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPersonalSettings.setBounds(652, 167, 326, 50);
		contentPane.add(lblPersonalSettings);
		
		JLabel labelChangeUsername = new JLabel("Change username: ");
		labelChangeUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		labelChangeUsername.setBounds(637, 272, 132, 16);
		contentPane.add(labelChangeUsername);
		
		JLabel lblChangePassword = new JLabel("Change password: ");
		lblChangePassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblChangePassword.setBounds(652, 323, 117, 16);
		contentPane.add(lblChangePassword);
		
		textAdminusername = new JTextField();
		textAdminusername.setBounds(800, 269, 165, 22);
		contentPane.add(textAdminusername);
		textAdminusername.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmPassword.setBounds(652, 373, 117, 16);
		contentPane.add(lblConfirmPassword);
		
		JButton buttonSaveChanges = new JButton("Save changes");
		buttonSaveChanges.setBounds(833, 436, 132, 25);
		contentPane.add(buttonSaveChanges);
		
		JButton buttonDashboard = new JButton("Back to Dashboard");
		buttonDashboard.setBounds(782, 623, 181, 27);
		contentPane.add(buttonDashboard);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(800, 320, 165, 22);
		contentPane.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(800, 370, 165, 22);
		contentPane.add(passwordField2);
	}
}
