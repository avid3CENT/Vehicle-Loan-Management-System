package lti.vehicleloan.ui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Customer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class CalculateEmiUI extends JFrame {
	
	private static Customer c;
	private JPanel contentPane;
	private JTextField textFieldPrincipal;
	private JLabel labelShowEMI;
	private JSlider sliderLoanTerm;
	private JLabel labelShowPayable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateEmiUI frame = new CalculateEmiUI(c);
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
	public CalculateEmiUI(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 712);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculate EMI");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 714, 70);
		contentPane.add(lblNewLabel);
		
		textFieldPrincipal = new JTextField();
		textFieldPrincipal.setFont(new Font("Cambria Math", Font.PLAIN, 21));
		textFieldPrincipal.setBounds(229, 83, 299, 40);
		contentPane.add(textFieldPrincipal);
		textFieldPrincipal.setColumns(10);
		
		JLabel labelPrincipleAm = new JLabel("Principal Amount (Rs.): ");
		labelPrincipleAm.setFont(new Font("Corbel", Font.BOLD, 15));
		labelPrincipleAm.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPrincipleAm.setBounds(-32, 85, 249, 40);
		contentPane.add(labelPrincipleAm);
		
		JSlider sliderInterestRate = new JSlider();
		sliderInterestRate.setBackground(Color.WHITE);
		
		sliderInterestRate.setSnapToTicks(true);
		sliderInterestRate.setMinimum(8);
		sliderInterestRate.setPaintTicks(true);
		sliderInterestRate.setPaintLabels(true);
		sliderInterestRate.setValue(1/100);
		sliderInterestRate.setMajorTickSpacing(1);
		sliderInterestRate.setMaximum(14);
		sliderInterestRate.setBounds(58, 186, 551, 48);
		contentPane.add(sliderInterestRate);
		
		JLabel labelInterestRate = new JLabel("Rate of Interest (p.a): ");
		labelInterestRate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelInterestRate.setFont(new Font("Corbel", Font.BOLD, 15));
		labelInterestRate.setBounds(48, 136, 156, 48);
		contentPane.add(labelInterestRate);
		
		sliderLoanTerm = new JSlider();
		sliderLoanTerm.setBackground(Color.WHITE);
		sliderLoanTerm.setSnapToTicks(true);
		sliderLoanTerm.setMajorTickSpacing(6);
		sliderLoanTerm.setValue(6);
		sliderLoanTerm.setPaintTicks(true);
		sliderLoanTerm.setPaintLabels(true);
		sliderLoanTerm.setMinimum(6);
		sliderLoanTerm.setMaximum(84);
		sliderLoanTerm.setBounds(55, 307, 554, 48);
		contentPane.add(sliderLoanTerm);
		
		JLabel lblNewLabel_1 = new JLabel("Loan Term (months): ");
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_1.setBounds(65, 266, 249, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelEMI = new JLabel("EMI");
		labelEMI.setHorizontalAlignment(SwingConstants.CENTER);
		labelEMI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEMI.setBounds(70, 400, 209, 32);
		contentPane.add(labelEMI);
		
		JLabel lblTotalPayableAmount = new JLabel("Total Payable Amount");
		lblTotalPayableAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPayableAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalPayableAmount.setBounds(400, 400, 209, 32);
		contentPane.add(lblTotalPayableAmount);
		
		JButton buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyLoanUI aplui = new ApplyLoanUI(c);
				aplui.setVisible(true);
				dispose();
			}
		});
		buttonGoBack.setBounds(512, 613, 97, 25);
		contentPane.add(buttonGoBack);
		
		JButton buttonCalEMI = new JButton("Calculate EMI");
		buttonCalEMI.setFont(new Font("Calibri", Font.BOLD, 20));
		buttonCalEMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				
				double principal = Double.valueOf(textFieldPrincipal.getText());
				int month = sliderLoanTerm.getValue();
				double rate = (double)(sliderInterestRate.getValue()); 
				double emi = lsl.CalculateEMI(principal, rate, month);
				float emif = (float) (emi);
				String answer = Float.toString(emif);
				labelShowEMI.setText(answer);
			}
		});
		buttonCalEMI.setBounds(70, 530, 229, 48);
		contentPane.add(buttonCalEMI);
		
		labelShowPayable = new JLabel("");
		labelShowPayable.setOpaque(true);
		labelShowPayable.setBackground(UIManager.getColor("Button.light"));
		labelShowPayable.setFont(new Font("Cambria Math", Font.BOLD, 21));
		labelShowPayable.setBounds(400, 445, 229, 72);
		contentPane.add(labelShowPayable);
		
		labelShowEMI = new JLabel("");
		labelShowEMI.setOpaque(true);
		labelShowEMI.setBackground(UIManager.getColor("Button.light"));
		labelShowEMI.setHorizontalAlignment(SwingConstants.LEFT);
		labelShowEMI.setFont(new Font("Cambria Math", Font.BOLD, 21));
		labelShowEMI.setBounds(77, 445, 222, 72);
		contentPane.add(labelShowEMI);
		
		JButton btnNewButton = new JButton("Calculate Total Amount");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				double principal = Double.valueOf(textFieldPrincipal.getText());
				int month = sliderLoanTerm.getValue();
				double rate = (double)(sliderInterestRate.getValue()); 
				double amount = lsl.TotalAmountPayable(principal, rate, month);
				float amountf = (float) amount;
				String answer = Float.toString(amountf);
				labelShowPayable.setText(answer);				
			}
		});
		btnNewButton.setBounds(400, 530, 229, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Rs.");
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(9, 482, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rs.");
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 21));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(333, 482, 56, 16);
		contentPane.add(lblNewLabel_3);
	}
}
