package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.CheckServiceLayer;
import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.CustomerExtra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import com.toedter.calendar.JDateChooser;

public class CustomerRegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField cusName;
	private JTextField cusPhn;
	private JTextField cusSal;
	private JTextField cusOcc;
	private JTextField cusUsername;
	private JPasswordField cusPass1;
	private boolean b;
	private JTextField textSeQues;
	private JTextField textSeqAns;
	private JPasswordField Pass2;
	private JDateChooser dobChooser;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegisterUI frame = new CustomerRegisterUI();
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
	public CustomerRegisterUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 763);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register as a new Customer");
		lblNewLabel.setForeground(UIManager.getColor("window"));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setBounds(0, 0, 785, 79);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer Full Name*: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(93, 135, 146, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone Number*: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(114, 190, 125, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Salary* (annual): ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(114, 241, 125, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Occupation*:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(114, 345, 125, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Choose username*: ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(114, 390, 125, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Choose password*: ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(114, 442, 125, 16);
		contentPane.add(lblNewLabel_6);

		cusName = new JTextField();
		cusName.setBounds(378, 132, 252, 22);
		contentPane.add(cusName);
		cusName.setColumns(10);

		cusPhn = new JTextField();
		cusPhn.setBounds(378, 187, 252, 22);
		contentPane.add(cusPhn);
		cusPhn.setColumns(10);

		cusSal = new JTextField();
		cusSal.setBounds(378, 238, 252, 22);
		contentPane.add(cusSal);
		cusSal.setColumns(10);

		cusOcc = new JTextField();
		cusOcc.setBounds(378, 342, 252, 22);
		contentPane.add(cusOcc);
		cusOcc.setColumns(10);

		cusUsername = new JTextField();
		cusUsername.setBounds(378, 387, 252, 22);
		contentPane.add(cusUsername);
		cusUsername.setColumns(10);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);

		btnNewButton.addActionListener(new ActionListener() { 
			public void
			actionPerformed(ActionEvent e) { 
				CheckServiceLayer chsl = new CheckServiceLayer();
				CustomerServiceLayer csl = new CustomerServiceLayer();
				Date dob = dobChooser.getDate();
				if(cusName.getText().isEmpty()||cusPhn.getText().isEmpty()||cusSal.getText().isEmpty()||cusOcc.getText().isEmpty()||cusUsername.getText().isEmpty()||cusPass1.getText().isEmpty()||Pass2.getText().isEmpty()||textSeQues.getText().isEmpty()||textSeqAns.getText().isEmpty()||dob==null) {
					JOptionPane.showMessageDialog(null, "Registered unsuccessful. Check if none of rhe fields are kept empty");

				}else {
					String cusname = comboBox.getSelectedItem()+" "+ cusName.getText();
					String cusphn = cusPhn.getText();
					String cussal = cusSal.getText();
					double cusdou = Double.parseDouble(cussal);
					String cusocc = cusOcc.getText();
					String cususer = cusUsername.getText();
					String pass1 = cusPass1.getText();
					String pass2 = Pass2.getText();
					String secQues = textSeQues.getText();
					String secAns = textSeqAns.getText();
					Date today = new Date();
					//boolean isString = chsl.checkString(cusname);
					
						boolean isMob = chsl.checkMobileNo(cusphn);
						if(isMob) {
							if(today.compareTo(dob)<0) {
								JOptionPane.showMessageDialog(null, "Date of Birth cannot be of the future.");
							}else {
								boolean isUser = csl.checkUsername(cususer);

								if(isUser) {
									JOptionPane.showMessageDialog(null, "Username already exists. Choose another");

								}else {
									if(pass1.equals(pass2)) {
										b = true;
									}else {
										b = false;
									}
									if(b==true && isUser==false) {
										Customer customer = new Customer(cusname,cusphn,cusdou,cusocc,cususer,pass1);
										CustomerExtra customerExtra= new CustomerExtra(dob,secQues,secAns);
										int k = csl.CustomerFinalRegister(customer, customerExtra);
										if(k>0) {
											JOptionPane.showMessageDialog(null, "You have registered successfully. Please Sign In.");
											CustomerLoginUI clui = new CustomerLoginUI();
											clui.setVisible(true);
											dispose();
										}else {
											JOptionPane.showMessageDialog(null, "Registered unsuccessful. Please try again");
										}
									}else {
										JOptionPane.showMessageDialog(null, "Passwords do not match.");
									}
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Customer Mobile Number is not valid.");
						}
					
				}
			} 
		});

		btnNewButton.setBounds(526, 655, 104, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("Rs.");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setBounds(310, 241, 56, 16);
		contentPane.add(lblNewLabel_7);

		cusPass1 = new JPasswordField();
		cusPass1.setBounds(378, 438, 252, 25);
		contentPane.add(cusPass1);

		JLabel lblNewLabel_8 = new JLabel("Re-enter password*:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(114, 488, 125, 16);
		contentPane.add(lblNewLabel_8);

		comboBox = new JComboBox();
		comboBox.setOpaque(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Mr");
		comboBox.addItem("Mrs");
		comboBox.addItem("Ms");
		comboBox.setBounds(310, 132, 56, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel_9 = new JLabel("+91");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setBounds(310, 190, 56, 16);
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton_1 = new JButton("Go back to Customer LogIn");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginUI clui = new CustomerLoginUI();
				clui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(48, 655, 210, 36);
		contentPane.add(btnNewButton_1);

		JLabel labelDOB = new JLabel("Dater of Birth:");
		labelDOB.setHorizontalAlignment(SwingConstants.TRAILING);
		labelDOB.setBounds(114, 293, 125, 16);
		contentPane.add(labelDOB);

		dobChooser = new JDateChooser();
		dobChooser.setBounds(378, 287, 252, 22);
		contentPane.add(dobChooser);

		JLabel lblNewLabel_10 = new JLabel("Security Question: ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10.setBounds(114, 537, 125, 16);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Security Answer: ");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_11.setBounds(114, 581, 125, 16);
		contentPane.add(lblNewLabel_11);

		textSeQues = new JTextField();
		textSeQues.setBounds(378, 534, 252, 22);
		contentPane.add(textSeQues);
		textSeQues.setColumns(10);

		textSeqAns = new JTextField();
		textSeqAns.setColumns(10);
		textSeqAns.setBounds(378, 578, 252, 22);
		contentPane.add(textSeqAns);

		Pass2 = new JPasswordField();
		Pass2.setBounds(378, 485, 252, 22);
		contentPane.add(Pass2);

	}
}
