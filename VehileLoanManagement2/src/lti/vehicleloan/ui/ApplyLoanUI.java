package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.dao.LoanServiceLayer;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.Loan;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
public class ApplyLoanUI extends JFrame {
	
	private static Customer c;
	private JPanel contentPane;
	private JTable LoanTable;
	private JButton ButtonCalcEMI;
	private ResultSet res;
	private DefaultTableModel table_model;
	private JTextField textFieldCarName;
	private JRadioButton radioButtonAccept;
	private JComboBox comboBoxCarType; 
	private Loan l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyLoanUI frame = new ApplyLoanUI(c);
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
	public ApplyLoanUI(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Loans");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1055, 75);
		contentPane.add(lblNewLabel);
		Object[] column = {"Loan ID","Loan Name","Loan Type","Loan Rate of Interest upto (p.a.)","Loan Term upto (months)"};
		table_model = new DefaultTableModel();
		table_model.setColumnIdentifiers(column);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 136, 1055, 105);
		contentPane.add(scrollPane);
		
		LoanTable = new JTable(table_model);
		scrollPane.setViewportView(LoanTable);
		LoanTable.setFont(new Font("Calibri", Font.PLAIN, 20));
		LoanTable.setModel(table_model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		LoanTable.setDefaultRenderer(String.class, centerRenderer);
		LoanTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		LoanTable.setRowHeight(30);
		
		JButton buttonShowLoans = new JButton("Show Loans");
		buttonShowLoans.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonShowLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanServiceLayer lsl = new LoanServiceLayer();
				res = lsl.viewLoan();
				LoanTable.setModel(DbUtils.resultSetToTableModel(res));
				
			}
		});
		buttonShowLoans.setBounds(432, 88, 179, 35);
		contentPane.add(buttonShowLoans);
		
		ButtonCalcEMI = new JButton("Calculate EMI");
		ButtonCalcEMI.setFont(new Font("Calibri", Font.BOLD, 25));
		ButtonCalcEMI.setBackground(new Color(255, 255, 51));
		ButtonCalcEMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateEmiUI cemiui = new CalculateEmiUI(c);
				cemiui.setVisible(true);
			}
		});
		ButtonCalcEMI.setBounds(74, 583, 329, 81);
		contentPane.add(ButtonCalcEMI);
		
		JButton buttonProceed = new JButton("Proceed to Apply Loan");
		buttonProceed.setForeground(new Color(255, 255, 255));
		buttonProceed.setBackground(new Color(204, 0, 51));
		buttonProceed.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		buttonProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			String vehicleType = (String)comboBoxCarType.getSelectedItem(); 
			String nameCar = textFieldCarName.getText();	
			int cid = c.getCusId();
			CustomerServiceLayer csl = new CustomerServiceLayer();
			boolean chec =  csl.checkAddressPresent(cid);
			int checkdetail = csl.checkCustomerDetails(cid);
			if(checkdetail==1) {
				JOptionPane.showMessageDialog(null, "Please fill your Aadhar details.");
			}else if(checkdetail==2) {
				JOptionPane.showMessageDialog(null, "Please fill your BankAccount details.");
			}else if(checkdetail==3) {
				JOptionPane.showMessageDialog(null, "Please fill your PAN details.");
			}else if(checkdetail==4) {
				JOptionPane.showMessageDialog(null, "Please fill your Vehicle details.");
			}else if(checkdetail==5) {
				JOptionPane.showMessageDialog(null, "Please fill your Occupation details.");
			}else if(checkdetail==6) {
				JOptionPane.showMessageDialog(null, "Please fill your Salary details.");
			}else if(checkdetail==7) {
				if(chec) {
					if(textFieldCarName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Fill the Car Name blank");
					}else {
						if(radioButtonAccept.isSelected())  {
								if(vehicleType.equalsIgnoreCase("New Car")) {
									LoanServiceLayer lsl = new LoanServiceLayer();
									l = lsl.searchLoanOnLoanType("New Car Loan");
										JOptionPane.showMessageDialog(null, "Proceed Successful"); 
										NewCarLoan2UI alscui = new NewCarLoan2UI(c,nameCar,l); 
										alscui.setVisible(true);
										dispose();
									
								}else if(vehicleType.equalsIgnoreCase("Pre-Owned Car")) {
									LoanServiceLayer lsl = new LoanServiceLayer();
									l = lsl.searchLoanOnLoanType("Pre-Owned Car Loan");
										JOptionPane.showMessageDialog(null, "Proceed Successful"); 
										PreOwnedCarLoanUI pocui = new PreOwnedCarLoanUI(c,nameCar,l); 
										pocui.setVisible(true);
										dispose();
										
								}
						}else {
							JOptionPane.showMessageDialog(null,"Please click on accept all terms and condition button after reading it.");
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please fill your Address details.");
				}
			}else if(checkdetail==8) {
				JOptionPane.showMessageDialog(null, "Please fill all your details.");
			}
		} }); 
				
		buttonProceed.setBounds(792, 504, 223, 49);
		contentPane.add(buttonProceed);
		
		JLabel labelVehicle = new JLabel("Type of Vehicle: ");
		labelVehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVehicle.setHorizontalAlignment(SwingConstants.TRAILING);
		labelVehicle.setBounds(635, 307, 143, 35);
		contentPane.add(labelVehicle);
		
		JButton buttonBackDashBoard = new JButton("Back to Dash Board");
		buttonBackDashBoard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonBackDashBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
				cdbui.setVisible(true);
				dispose();
			}
		});
		buttonBackDashBoard.setForeground(SystemColor.menuText);
		buttonBackDashBoard.setBackground(new Color(255, 255, 255));
		buttonBackDashBoard.setBounds(819, 635, 196, 43);
		contentPane.add(buttonBackDashBoard);
		
		radioButtonAccept = new JRadioButton("I accept all the terms and conditions.");
		radioButtonAccept.setBackground(Color.WHITE);
		radioButtonAccept.setBounds(699, 439, 316, 25);
		contentPane.add(radioButtonAccept);
		
		comboBoxCarType = new JComboBox();
		comboBoxCarType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCarType.addItem("Pre-Owned Car");
		comboBoxCarType.addItem("New Car");
		comboBoxCarType.setBounds(836, 310, 179, 28);
		contentPane.add(comboBoxCarType);
		
		JLabel lblNewLabel_2 = new JLabel("Name of Car:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(662, 365, 116, 32);
		contentPane.add(lblNewLabel_2);
		
		textFieldCarName = new JTextField();
		textFieldCarName.setBounds(836, 364, 179, 35);
		contentPane.add(textFieldCarName);
		textFieldCarName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<html><p>Looking to buy a new car? People Bank\u2019s New Car Loan offers car loans from Rs. 1 Lakh upto 100% on-road price along with a host of benefits that include attractive interest rates, comfortable tenure. </p>\r\n<p></p>\r\n<p>Before applying for a car loan online, make sure to use the car loan calculator to find out your EMI. Apply for an People Bank's New Car Loan and make your dream of owning a car come true.</p></html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(153, 0, 102));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(0, 241, 488, 343);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
