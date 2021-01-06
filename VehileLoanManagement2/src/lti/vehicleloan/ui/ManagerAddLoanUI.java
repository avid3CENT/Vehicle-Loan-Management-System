package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Employee;
import lti.vehicleloan.entity.Loan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerAddLoanUI extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textType;
	private JTextField textPrincipal;
	private JTextField textRoi;
	private JTextField textTerm;
	private JTextField textDownPay;
	private Loan loan;
	private static Employee emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAddLoanUI frame = new ManagerAddLoanUI(emp);
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
	public ManagerAddLoanUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Car Loan Section");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(51, 153, 153));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		lblNewLabel.setBounds(0, 0, 755, 128);
		contentPane.add(lblNewLabel);
		
		JLabel labelLoanName = new JLabel("Loan Name:");
		labelLoanName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanName.setBounds(82, 185, 132, 37);
		contentPane.add(labelLoanName);
		
		JLabel labelLoanType = new JLabel("Loan Type");
		labelLoanType.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanType.setBounds(82, 241, 132, 37);
		contentPane.add(labelLoanType);
		
		JLabel labelLoanLimit = new JLabel("Loan Amount Limit:");
		labelLoanLimit.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanLimit.setBounds(82, 299, 132, 37);
		contentPane.add(labelLoanLimit);
		
		JLabel labelLoanRateRange = new JLabel("Loan ROI:");
		labelLoanRateRange.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanRateRange.setBounds(82, 357, 132, 37);
		contentPane.add(labelLoanRateRange);
		
		JLabel labelLoanTerm = new JLabel("Loan Term (in Months):");
		labelLoanTerm.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanTerm.setBounds(45, 414, 169, 37);
		contentPane.add(labelLoanTerm);
		
		textName = new JTextField();
		textName.setBounds(301, 185, 241, 37);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(301, 241, 241, 37);
		contentPane.add(textType);
		
		textPrincipal = new JTextField();
		textPrincipal.setColumns(10);
		textPrincipal.setBounds(301, 299, 241, 37);
		contentPane.add(textPrincipal);
		
		textRoi = new JTextField();
		textRoi.setColumns(10);
		textRoi.setBounds(301, 357, 241, 37);
		contentPane.add(textRoi);
		
		textTerm = new JTextField();
		textTerm.setColumns(10);
		textTerm.setBounds(301, 414, 241, 37);
		contentPane.add(textTerm);
		
		textDownPay = new JTextField();
		textDownPay.setColumns(10);
		textDownPay.setBounds(301, 471, 241, 36);
		contentPane.add(textDownPay);
		
		JLabel lblLoanDownPayment = new JLabel("Loan Down Payment:");
		lblLoanDownPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoanDownPayment.setBounds(45, 471, 169, 37);
		contentPane.add(lblLoanDownPayment);
		
		JLabel labelRs = new JLabel("Rs.");
		labelRs.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRs.setBounds(248, 317, 41, 16);
		contentPane.add(labelRs);
		
		JLabel labelRs_1 = new JLabel("Rs.");
		labelRs_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRs_1.setBounds(248, 481, 41, 16);
		contentPane.add(labelRs_1);
		
		JLabel lblPa = new JLabel("p.a.");
		lblPa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPa.setBounds(248, 367, 41, 16);
		contentPane.add(lblPa);
		
		JButton buttonAddLoan = new JButton("Add New Loan");
		buttonAddLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				String name = textName.getText();
				String type = textType.getText();
				String principal = textPrincipal.getText();
				String roi = textRoi.getText();
				if(textName.getText().isEmpty()||textName.getText().isEmpty()||textPrincipal.getText().isEmpty()||textRoi.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Some text fields are empty.");
				}else {
					int term = Integer.parseInt(textTerm.getText());
					double downpay = Double.parseDouble(textDownPay.getText());
					loan = new Loan(name,type,roi,term,downpay,principal);
					int add = lsl.addLoan(loan);
					if(add>0) {
						JOptionPane.showMessageDialog(null, "Loan added successfully.");
					}else {
						JOptionPane.showMessageDialog(null, "Loan adding unsuccessful.");
					}
				}
			}
		});
		buttonAddLoan.setBounds(417, 546, 125, 37);
		contentPane.add(buttonAddLoan);
		
		JButton buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanSectionUI lsui = new LoanSectionUI(emp);
				lsui.setVisible(true);
				dispose();
			}
		});
		buttonGoBack.setBounds(607, 653, 97, 25);
		contentPane.add(buttonGoBack);
	}

}
