package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.Loan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PreOwnedCarLoanUI extends JFrame {

	private JPanel contentPane;
	private static Customer c;
	private static Loan loan;
	private static String carName;
	private JTextField textPrincipal;
	private JTextField textCarPrice;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel labelEMI; 
	JLabel labelTPayable;
	JLabel labelTInterest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreOwnedCarLoanUI frame = new PreOwnedCarLoanUI(c,carName,loan);
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
	public PreOwnedCarLoanUI(Customer c, String carName,Loan loan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pre Owned Car Loan");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1055, 75);
		contentPane.add(lblNewLabel);
		
		JLabel labelPrincipalAmount = new JLabel("Amount you want to lend: ");
		labelPrincipalAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPrincipalAmount.setBackground(new Color(255, 255, 255));
		labelPrincipalAmount.setForeground(new Color(0, 0, 0));
		labelPrincipalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPrincipalAmount.setBounds(22, 221, 215, 31);
		contentPane.add(labelPrincipalAmount);
		
		JLabel labelDisplayEMI = new JLabel("Monthly EMI: ");
		labelDisplayEMI.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelDisplayEMI.setHorizontalAlignment(SwingConstants.CENTER);
		labelDisplayEMI.setBounds(727, 196, 130, 36);
		contentPane.add(labelDisplayEMI);
		
		textPrincipal = new JTextField();
		textPrincipal.setBounds(307, 224, 202, 27);
		contentPane.add(textPrincipal);
		textPrincipal.setColumns(10);
		
		JLabel labelDisplayTotalInterest = new JLabel("Total Interest Amount: ");
		labelDisplayTotalInterest.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelDisplayTotalInterest.setHorizontalAlignment(SwingConstants.CENTER);
		labelDisplayTotalInterest.setBounds(702, 304, 178, 23);
		contentPane.add(labelDisplayTotalInterest);
		
		JLabel labelTotalPAyable = new JLabel("Total Amount Payable:");
		labelTotalPAyable.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTotalPAyable.setHorizontalAlignment(SwingConstants.CENTER);
		labelTotalPAyable.setBounds(692, 385, 202, 36);
		contentPane.add(labelTotalPAyable);
		
		JButton btnNewButton_1 = new JButton("Go to Dashboard");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
				cdbui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 647, 178, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Go to Apply Loan");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyLoanUI aplui = new ApplyLoanUI(c);
				aplui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(262, 647, 152, 31);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Rs.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(275, 223, 34, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelCarPrice = new JLabel("Price of your Car: ");
		labelCarPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCarPrice.setBounds(69, 446, 168, 23);
		contentPane.add(labelCarPrice);
		
		textCarPrice = new JTextField();
		textCarPrice.setBounds(307, 443, 202, 31);
		contentPane.add(textCarPrice);
		textCarPrice.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Rs.");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(275, 445, 34, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Rs.");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(659, 243, 34, 27);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Rs.");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(659, 350, 34, 27);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Rs.");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(659, 427, 34, 27);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2 = new JLabel("Loan Down Payment: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(69, 172, 168, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2000");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(307, 170, 202, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_7 = new JLabel("Rs.");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setBounds(262, 175, 34, 27);
		contentPane.add(lblNewLabel_1_7);
		
		JRadioButton rb96 = new JRadioButton("ROI of 14% for Loan Term of 96 months\r\n");
		rb96.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rb96.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rb96);
		rb96.setBounds(143, 303, 339, 25);
		contentPane.add(rb96);
		
		JRadioButton rb86 = new JRadioButton("ROI of 15.5% for Loan Term of 86 Months");
		rb86.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rb86.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rb86);
		rb86.setBounds(143, 331, 339, 25);
		contentPane.add(rb86);
		
		JRadioButton rb77 = new JRadioButton("ROI of 16% for a Loan Term of 77 Months");
		rb77.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rb77.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rb77);
		rb77.setBounds(143, 361, 339, 25);
		contentPane.add(rb77);
		
		JRadioButton rb74 = new JRadioButton("ROI of 17% for a Loan Term of 74 Months");
		rb74.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rb74.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rb74);
		rb74.setBounds(143, 391, 339, 25);
		contentPane.add(rb74);
		
		JButton buttonEMI = new JButton("Calculate EMI");
		buttonEMI.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonEMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				double priceCar = Double.parseDouble(textCarPrice.getText());
				double principal = Double.parseDouble(textPrincipal.getText());
				if(textCarPrice.getText().isEmpty() || textPrincipal.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Loan Amount or Car Price Field Cannot be Empty.");
				}else {
					int el = lsl.checkLoanEligibiltyPreOwnedCar(principal, priceCar);
					if(el==1) {
						if(rb96.isSelected()) {
							double rate = 14;
							int term = 96;
							
							double emi = lsl.CalculateEMI(principal, rate, term);
							Float emif = (float) emi;
							String emid = Float.toString(emif);
							double tp = lsl.TotalAmountPayable(principal, rate, term);
							double totalInterest = tp-principal;
							Float tif = (float) totalInterest;
							String tid = Float.toString(tif);
							Float tpf = (float) tp;
							String tpd = Float.toString(tpf);
							
							labelEMI.setText(emid);
							labelTPayable.setText(tpd);
							labelTInterest.setText(tid);
							
						}else if(rb86.isSelected()) {
							double rate = 15.5;
							int term = 86;
							double emi = lsl.CalculateEMI(principal, rate, term);
							Float emif = (float) emi;
							String emid = Float.toString(emif);
							double tp = lsl.TotalAmountPayable(principal, rate, term);
							double totalInterest = tp-principal;
							Float tif = (float) totalInterest;
							String tid = Float.toString(tif);
							Float tpf = (float) tp;
							String tpd = Float.toString(tpf);
							
							labelEMI.setText(emid);
							labelTPayable.setText(tpd);
							labelTInterest.setText(tid);
						}else if(rb77.isSelected()) {
							double rate = 16;
							int term = 77;
							double emi = lsl.CalculateEMI(principal, rate, term);
							Float emif = (float) emi;
							String emid = Float.toString(emif);
							double tp = lsl.TotalAmountPayable(principal, rate, term);
							double totalInterest = tp-principal;
							Float tif = (float) totalInterest;
							String tid = Float.toString(tif);
							Float tpf = (float) tp;
							String tpd = Float.toString(tpf);
							
							labelEMI.setText(emid);
							labelTPayable.setText(tpd);
							labelTInterest.setText(tid);
						}else if(rb74.isSelected()) {
							double rate = 17;
							int term = 74;
							double emi = lsl.CalculateEMI(principal, rate, term);
							Float emif = (float) emi;
							String emid = Float.toString(emif);
							double tp = lsl.TotalAmountPayable(principal, rate, term);
							double totalInterest = tp-principal;
							Float tif = (float) totalInterest;
							String tid = Float.toString(tif);
							Float tpf = (float) tp;
							String tpd = Float.toString(tpf);
							
							labelEMI.setText(emid);
							labelTPayable.setText(tpd);
							labelTInterest.setText(tid);
						}
						else {
							JOptionPane.showMessageDialog(null, "Please choose a loan plan.");
						}
					}else if(el==2) {
						JOptionPane.showMessageDialog(null, "Loan Amount cannot be greater 85% of than price of the car. Read Loan Details for further information.");
					}
				}
				
				
				/*
				 * double rate = 10; int term = 78; double emi = lsl.CalculateEMI(principal,
				 * rate, term); Float emif = (float) emi; String emid = Float.toString(emif);
				 * labelEMI.setText(emid);
				 */
				
			}
		});
		buttonEMI.setBounds(329, 487, 147, 49);
		contentPane.add(buttonEMI);
		
		labelEMI = new JLabel("");
		labelEMI.setFont(new Font("Cambria Math", Font.BOLD, 22));
		labelEMI.setHorizontalAlignment(SwingConstants.CENTER);
		labelEMI.setBackground(new Color(255, 255, 255));
		labelEMI.setBounds(692, 236, 202, 48);
		contentPane.add(labelEMI);
		
		JLabel lblChooseLoanPlan = new JLabel("Choose Loan Plan: ");
		lblChooseLoanPlan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseLoanPlan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChooseLoanPlan.setForeground(Color.BLACK);
		lblChooseLoanPlan.setBackground(Color.WHITE);
		lblChooseLoanPlan.setBounds(69, 265, 168, 31);
		contentPane.add(lblChooseLoanPlan);
		
		labelTInterest = new JLabel("");
		labelTInterest.setFont(new Font("Cambria Math", Font.BOLD, 22));
		labelTInterest.setHorizontalAlignment(SwingConstants.CENTER);
		labelTInterest.setBounds(692, 340, 202, 46);
		contentPane.add(labelTInterest);
		
		labelTPayable = new JLabel("");
		labelTPayable.setHorizontalAlignment(SwingConstants.CENTER);
		labelTPayable.setFont(new Font("Cambria Math", Font.BOLD, 22));
		labelTPayable.setBounds(692, 418, 202, 44);
		contentPane.add(labelTPayable);
		
		JButton buttonApplyLoan = new JButton("Apply for Loan");
		buttonApplyLoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonApplyLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				double priceCar = Double.parseDouble(textCarPrice.getText());
				double principal = Double.parseDouble(textPrincipal.getText());
				if(textCarPrice.getText().isEmpty() || textPrincipal.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Loan Amount or Car Price Field Cannot be Empty.");
				}else {
					int el = lsl.checkLoanEligibiltyPreOwnedCar(principal, priceCar);
					if(el==1) {
						if(rb96.isSelected()) {
							double rate = 14;
							int term = 96;
							
							double emi = lsl.CalculateEMI(principal, rate, term);
							ApplicationServiceLayer asl = new ApplicationServiceLayer();
							int h = asl.addApplication(c, loan, principal, rate, term, carName);
							if(h>0) {
								JOptionPane.showMessageDialog(null, "Loan Application has been sent to the Manager for Approval. Redirecting to Dashboard.");
								CustomerDashBoardUI cd = new CustomerDashBoardUI(c);
								cd.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "Loan Application was unsuccessful. Please try again.");
							}
						}else if(rb86.isSelected()) {
							double rate = 15.5;
							int term = 86;
							double emi = lsl.CalculateEMI(principal, rate, term);
							ApplicationServiceLayer asl = new ApplicationServiceLayer();
							int h = asl.addApplication(c, loan, principal, rate, term, carName);
							if(h>0) {
								JOptionPane.showMessageDialog(null, "Loan Application has been sent to the Manager for Approval. Redirecting to Dashboard.");
								CustomerDashBoardUI cd = new CustomerDashBoardUI(c);
								cd.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "Loan Application was unsuccessful. Please try again.");
							}
							
						}else if(rb77.isSelected()) {
							double rate = 16;
							int term = 77;
							double emi = lsl.CalculateEMI(principal, rate, term);
							ApplicationServiceLayer asl = new ApplicationServiceLayer();
							int h = asl.addApplication(c, loan, principal, rate, term, carName);
							if(h>0) {
								JOptionPane.showMessageDialog(null, "Loan Application has been sent to the Manager for Approval. Redirecting to Dashboard.");
								CustomerDashBoardUI cd = new CustomerDashBoardUI(c);
								cd.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "Loan Application was unsuccessful. Please try again.");
							}
							
						}else if(rb74.isSelected()) {
							double rate = 17;
							int term = 74;
							ApplicationServiceLayer asl = new ApplicationServiceLayer();
							int h = asl.addApplication(c, loan, principal, rate, term, carName);
							if(h>0) {
								JOptionPane.showMessageDialog(null, "Loan Application has been sent to the Manager for Approval. Redirecting to Dashboard.");
								CustomerDashBoardUI cd = new CustomerDashBoardUI(c);
								cd.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "Loan Application was unsuccessful. Please try again.");
							}
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Please choose a loan plan.");
						}
					}else if(el==2) {
						JOptionPane.showMessageDialog(null, "Loan Amount cannot be greater than price of the car.");
					}
				}
			}
		});
		buttonApplyLoan.setBackground(new Color(255, 255, 255));
		buttonApplyLoan.setBounds(727, 592, 167, 46);
		contentPane.add(buttonApplyLoan);
		
	}
	
}
