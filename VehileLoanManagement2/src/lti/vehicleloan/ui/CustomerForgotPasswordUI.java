package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.CustomerServiceLayer;
import w.cs;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerForgotPasswordUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textAnswer;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private boolean isUsername;
	private boolean isAnswer;
	private boolean validate;
	private boolean change;
	private JLabel lableShowQues;
	JButton buttonFindUsername;
	JButton buttonValidate;
	JButton buttonChangepass;
	String str = "yes";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForgotPasswordUI frame = new CustomerForgotPasswordUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * public void validate() { do { buttonFindUsername.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent e) {
	 * CustomerServiceLayer csl = new CustomerServiceLayer();
	 * isUsername=csl.checkUsername(textUsername.getText()); if(isUsername) {
	 * textUsername.setText(textUsername.getText()); validate = true; change =
	 * false; int cid = csl.getCusIdfromUser(textUsername.getText()); String text =
	 * csl.getSQuesFromUser(cid); lableShowQues.setText(text); str = "yes"; }else {
	 * JOptionPane.showMessageDialog(null, "No username found.");
	 * textUsername.setBackground(new Color(204, 102, 102)); validate = false;
	 * change = false; str = "no"; } } }); buttonValidate.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent e) { if(validate)
	 * { buttonValidate.setEnabled(true); String answer = textAnswer.getText();
	 * CustomerServiceLayer csl1 = new CustomerServiceLayer(); boolean isAnswer =
	 * csl1.checkQuesAns(lableShowQues.getText(), answer); if(isAnswer) { change =
	 * true; }else { JOptionPane.showMessageDialog(null, "Answer is wrong.");
	 * textAnswer.setBackground(new Color(204, 51, 51)); change = false; str = "no";
	 * } }else { buttonValidate.setEnabled(false); change = false; str = "no"; } }
	 * }); buttonChangepass.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent e) { if(change==true && validate == true) {
	 * buttonChangepass.setEnabled(true); String p1 = pass1.getText(); String p2 =
	 * pass2.getText(); if(p1.equals(p2)) { CustomerServiceLayer csl2 = new
	 * CustomerServiceLayer(); int u = csl2.changePassword(textUsername.getText(),
	 * p1); if(u>0) { JOptionPane.showMessageDialog(null,
	 * "Password changed successfully. Please login again."); str = "yes"; }else {
	 * JOptionPane.showMessageDialog(null, "Password change unsuccessful."); str =
	 * "no"; }
	 * 
	 * }else { JOptionPane.showMessageDialog(null, "Password do not match."); str =
	 * "no"; }
	 * 
	 * }else { buttonChangepass.setEnabled(false); str = "no"; } } });
	 * }while(str.equalsIgnoreCase("no")); }
	 */
	/**
	 * Create the frame.
	 */
	public CustomerForgotPasswordUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 767);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Change password");
		lblNewLabel.setForeground(UIManager.getColor("window"));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setBounds(0, 0, 561, 79);
		contentPane.add(lblNewLabel);
		
		JLabel labelUser = new JLabel("Ussername: ");
		labelUser.setHorizontalAlignment(SwingConstants.TRAILING);
		labelUser.setBounds(79, 145, 121, 31);
		contentPane.add(labelUser);
		
		JLabel labelSecQues = new JLabel("Security Question: ");
		labelSecQues.setHorizontalAlignment(SwingConstants.TRAILING);
		labelSecQues.setBounds(79, 250, 121, 31);
		contentPane.add(labelSecQues);
		
		JLabel labelSeAns = new JLabel("Security Answer: ");
		labelSeAns.setHorizontalAlignment(SwingConstants.TRAILING);
		labelSeAns.setBounds(79, 289, 121, 31);
		contentPane.add(labelSeAns);
		
		textUsername = new JTextField();
		textUsername.setBounds(212, 147, 174, 26);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textAnswer = new JTextField();
		
		textAnswer.setBounds(212, 291, 174, 26);
		contentPane.add(textAnswer);
		textAnswer.setColumns(10);
		
		buttonFindUsername = new JButton("Find username");
		buttonFindUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerServiceLayer csl = new CustomerServiceLayer();
				isUsername=csl.checkUsername(textUsername.getText());
				if(isUsername) {
					textUsername.setText(textUsername.getText());
					validate = true;
					change = false;
					int cid = csl.getCusIdfromUser(textUsername.getText());
					String text = csl.getSQuesFromUser(cid);
					lableShowQues.setText(text);
				}else {
					JOptionPane.showMessageDialog(null, "No username found.");
					textUsername.setBackground(new Color(204, 102, 102));
					validate = false;
					change = false;
				}
			}
		});
		buttonFindUsername.setBackground(SystemColor.window);
		buttonFindUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonFindUsername.setBounds(222, 186, 164, 25);
		contentPane.add(buttonFindUsername);
		
		buttonValidate = new JButton("Validate Answer");
		buttonValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validate) {
					buttonValidate.setEnabled(true);
					String answer = textAnswer.getText();
					CustomerServiceLayer csl1 = new CustomerServiceLayer();
					boolean isAnswer = csl1.checkQuesAns(lableShowQues.getText(), answer);
					if(isAnswer) {
						change = true;
					}else {
						JOptionPane.showMessageDialog(null, "Answer is wrong.");
						textAnswer.setBackground(new Color(204, 51, 51));
						change = false;
					}
				}else {
					buttonValidate.setEnabled(false);
					change = false;
				}
			}
		});
		
		buttonValidate.setBackground(SystemColor.window);
		buttonValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonValidate.setBounds(253, 330, 133, 25);
		contentPane.add(buttonValidate);
		
		pass1 = new JPasswordField();
		pass1.setBounds(212, 400, 174, 26);
		contentPane.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(212, 439, 174, 26);
		contentPane.add(pass2);
		
		JLabel labelReEnter = new JLabel("Re-enter password: ");
		labelReEnter.setHorizontalAlignment(SwingConstants.TRAILING);
		labelReEnter.setBounds(46, 439, 154, 26);
		contentPane.add(labelReEnter);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choose new password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setBounds(46, 400, 154, 26);
		contentPane.add(lblNewLabel_1_1);
		
		buttonChangepass = new JButton("Change Password");
		buttonChangepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(change==true && validate == true) {
					buttonChangepass.setEnabled(true);
					String p1 = pass1.getText();
					String p2 = pass2.getText();
					if(p1.equals(p2)) {
						CustomerServiceLayer csl2 = new CustomerServiceLayer();
						int u = csl2.changePassword(textUsername.getText(), p1);
						if(u>0) {
							JOptionPane.showMessageDialog(null, "Password changed successfully. Please login again.");
						}else {
							JOptionPane.showMessageDialog(null, "Password change unsuccessful.");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Password do not match.");
					}
					
				}else {
					buttonChangepass.setEnabled(false);
				}
			}
		});
		buttonChangepass.setBackground(SystemColor.window);
		buttonChangepass.setBounds(212, 478, 174, 25);
		contentPane.add(buttonChangepass);
		
		JButton buttonLogin = new JButton("Back to Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginUI clui = new CustomerLoginUI();
				clui.setVisible(true);
				dispose();
			}
		});
		buttonLogin.setBackground(SystemColor.text);
		buttonLogin.setBounds(45, 656, 121, 31);
		contentPane.add(buttonLogin);
		
		lableShowQues = new JLabel("");
		lableShowQues.setBounds(212, 253, 174, 24);
		contentPane.add(lableShowQues);
		validate();
	}
}
