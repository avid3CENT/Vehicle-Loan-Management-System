package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Employee;
import lti.vehicleloan.entity.Loan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerUpdateLoanUI extends JFrame {

	private JPanel contentPane;
	private JTextField textLoanAmount;
	private JTextField textROI;
	private JTextField textLoanTerm;
	private JTextField textLoanDownPaymnt;
	private static int loanId;
	private static Employee emp;
	private Loan l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUpdateLoanUI frame = new ManagerUpdateLoanUI(emp,loanId);
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
	public ManagerUpdateLoanUI(Employee emp,int loanId) {
		LoanServiceLayer lsl = new LoanServiceLayer();
		l = lsl.searchLoanOnLoanId(loanId);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Loan");
		lblNewLabel.setBounds(0, 0, 766, 79);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(51, 153, 153));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 48));
		contentPane.add(lblNewLabel);
		JLabel labelLoanName = new JLabel("Loan Name: "+l.getLoanName());
		labelLoanName.setFont(new Font("Calibri", Font.BOLD, 17));
		labelLoanName.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoanName.setBounds(248, 142, 294, 37);
		contentPane.add(labelLoanName);
		
		JLabel labelLoanType = new JLabel("Loan Type: "+l.getLoanType());
		labelLoanType.setFont(new Font("Calibri", Font.BOLD, 17));
		labelLoanType.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoanType.setBounds(248, 181, 294, 43);
		contentPane.add(labelLoanType);
		
		JLabel labelLoanLimit = new JLabel("Loan Amount Limit:");
		labelLoanLimit.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanLimit.setBounds(65, 285, 132, 47);
		contentPane.add(labelLoanLimit);
		
		JLabel labelLoanRateRange = new JLabel("Loan ROI:");
		labelLoanRateRange.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanRateRange.setBounds(65, 345, 132, 37);
		contentPane.add(labelLoanRateRange);
		
		JLabel labelLoanTerm = new JLabel("Loan Term:");
		labelLoanTerm.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLoanTerm.setBounds(28, 403, 169, 37);
		contentPane.add(labelLoanTerm);
		
		textLoanAmount = new JTextField();
		textLoanAmount.setColumns(10);
		textLoanAmount.setBounds(279, 287, 241, 43);
		contentPane.add(textLoanAmount);
		
		textROI = new JTextField();
		textROI.setColumns(10);
		textROI.setBounds(279, 343, 241, 43);
		contentPane.add(textROI);
		
		textLoanTerm = new JTextField();
		textLoanTerm.setColumns(10);
		textLoanTerm.setBounds(279, 399, 241, 44);
		contentPane.add(textLoanTerm);
		
		textLoanDownPaymnt = new JTextField();
		textLoanDownPaymnt.setColumns(10);
		textLoanDownPaymnt.setBounds(279, 457, 241, 43);
		contentPane.add(textLoanDownPaymnt);
		
		JLabel lblLoanDownPayment = new JLabel("Loan Down Payment:");
		lblLoanDownPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoanDownPayment.setBounds(28, 460, 169, 37);
		contentPane.add(lblLoanDownPayment);
		
		JLabel labelRs = new JLabel("Rs.");
		labelRs.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRs.setBounds(226, 300, 41, 16);
		contentPane.add(labelRs);
		
		JLabel labelRs_1 = new JLabel("Rs.");
		labelRs_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRs_1.setBounds(226, 470, 41, 16);
		contentPane.add(labelRs_1);
		
		JLabel lblPa = new JLabel("p.a.");
		lblPa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPa.setBounds(226, 355, 41, 16);
		contentPane.add(lblPa);
		
		JButton buttonUpdateAmount = new JButton("Update Loan Amount");
		buttonUpdateAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				String principal = textLoanAmount.getText();
				int ret = lsl.UpdateLoan(loanId, principal, 1);
				if(ret>0) {
					JOptionPane.showMessageDialog(null, "Loan Amount updated successfully.");
				}else {
					JOptionPane.showMessageDialog(null, "Loan Amount update unsuccessful.");
				}
			}
		});
		buttonUpdateAmount.setBounds(532, 290, 222, 37);
		contentPane.add(buttonUpdateAmount);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Loan ID: "+loanId);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(248, 92, 294, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblInMonths = new JLabel("Months:");
		lblInMonths.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInMonths.setBounds(209, 413, 63, 16);
		contentPane.add(lblInMonths);
		
		JButton buttonUpdateROI = new JButton("Update Loan ROI");
		buttonUpdateROI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();	
				String roi = textROI.getText();
				int ret = lsl.UpdateLoan(loanId, roi, 2);
				if(ret>0) {
					JOptionPane.showMessageDialog(null, "Loan ROI updated successfully.");
				}else {
					JOptionPane.showMessageDialog(null, "Loan ROI update unsuccessful.");
				}
			}
		});
		buttonUpdateROI.setBounds(532, 345, 222, 37);
		contentPane.add(buttonUpdateROI);
		
		JButton btnUpdateLoanTerm = new JButton("Update Loan Term");
		btnUpdateLoanTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();	
				String term = textLoanTerm.getText();
				int ret = lsl.UpdateLoan(loanId, term, 3);
				if(ret>0) {
					JOptionPane.showMessageDialog(null, "Loan Term updated successfully.");
				}else {
					JOptionPane.showMessageDialog(null, "Loan Term update unsuccessful.");
				}
			}
		});
		btnUpdateLoanTerm.setBounds(532, 403, 222, 37);
		contentPane.add(btnUpdateLoanTerm);
		
		JButton btnUpdateLoanDown = new JButton("Update Loan Down Payment");
		btnUpdateLoanDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();	
				String downpay = textLoanDownPaymnt.getText();
				int ret = lsl.UpdateLoan(loanId, downpay, 4);
				if(ret>0) {
					JOptionPane.showMessageDialog(null, "Loan Down Payment updated successfully.");
				}else {
					JOptionPane.showMessageDialog(null, "Loan Down Payment update unsuccessful.");
				}
			}
		});
		btnUpdateLoanDown.setBounds(532, 460, 222, 37);
		contentPane.add(btnUpdateLoanDown);
		
	}

}
