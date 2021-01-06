package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.Loan;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class NewCarLoanScreenUI extends JFrame {

	private JPanel contentPane;
	private static Customer c;
	private static String carName;
	private static Loan loan;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCarLoanScreenUI frame = new NewCarLoanScreenUI(c,carName,loan);
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
	public NewCarLoanScreenUI(Customer c,String carName,Loan loan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Car Loan");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1055, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><p>Looking to buy a new car? People Bank\u2019s New Car Loan offers car loans from Rs. 1 Lakh upto 100% on-road price along with a host of benefits that include attractive interest rates, comfortable tenure. Before applying for a car loan online, make sure to use the car loan calculator to find out your EMI. Apply for an People Bank's New Car Loan and make your dream of owning a car come true.</p></html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(153, 0, 102));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(195, 123, 392, 339);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check your Eligibility");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Salaried individuals who are eligible for a car loan\r\n" + 
						"Minimum 21 years of age\r\n" + 
						"Maximum 60 years of age at maturity (conditions apply)\r\n" + 
						"Minimum Net Monthly Salary of should be greater that \r\n" + 
						"Income eligibility based on latest salary slip and Form 16\r\n" + 
						"Minimum of 1 year continuous employment");
			}
		});
		btnNewButton.setForeground(new Color(153, 0, 102));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 23));
		btnNewButton.setBounds(10, 503, 325, 109);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Interest Rate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 22));
		btnNewButton_1.setForeground(new Color(153, 0, 102));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(360, 503, 325, 109);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Got Query?");
		btnNewButton_1_1.setForeground(new Color(153, 0, 102));
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD, 22));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(718, 503, 325, 109);
		contentPane.add(btnNewButton_1_1);
		
		JButton buttonProceed = new JButton("Proceed");
		buttonProceed.setBackground(new Color(255, 255, 255));
		buttonProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCarLoan2UI nclsui = new NewCarLoan2UI(c,carName,loan);
				nclsui.setVisible(true);
				dispose();
				
			}
		});
		buttonProceed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonProceed.setBounds(849, 638, 151, 40);
		contentPane.add(buttonProceed);
		
		JButton buttonDashboard = new JButton("Go to Dashboard");
		buttonDashboard.setBackground(new Color(255, 255, 255));
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
				cdbui.setVisible(true);
				dispose();
			}
		});
		buttonDashboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonDashboard.setBounds(56, 638, 151, 40);
		contentPane.add(buttonDashboard);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		textArea.setEditable(false);
		textArea.setBounds(10, 279, 1033, 202);
		contentPane.add(textArea);
		
	}
}
