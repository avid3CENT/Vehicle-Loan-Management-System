package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Address;
import lti.vehicleloan.entity.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class CustomerUpdateUI extends JFrame {

	private JPanel contentPane;
	private JTextField textPhn;
	private static Customer c;
	private JLabel lblSalary;
	private JLabel lblOccupation;
	private JLabel lblAadharNo;
	private JLabel lblBankAccountNo;
	private JLabel lblPanNo;
	private JLabel lblVehilceOwned;
	private JTextField textBankAcc;
	private JTextField textAadhar;
	private JTextField textOcc;
	private JTextField textSalary;
	private JTextField textPan;
	private JTextField textVehicle;
	private JButton buttonUpdate;
	private JLabel labelHouse;
	private JLabel labelBuilding;
	private JLabel labelPlace;
	private JLabel labelCity;
	private JLabel labelState;
	private JLabel labelPin;
	private JTextField textHouse;
	private JTextField textBuilding;
	private JTextField textPlace;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textPin;
	private JButton buttonAddAddress;
	 CustomerServiceLayer csl = new CustomerServiceLayer();
	 private JButton buttonPan;
	 private JButton buttonAccount;
	 private JButton buttonContact;
	 private JButton buttonAadhar;
	 private JButton buttonSalary;
	 private JButton buttonOccupation;
	 private JLabel labelHouse_1;
	 private JLabel labelBuilding_1;
	 private JLabel labelPlace_1;
	 private JLabel labelCity_1;
	 private JLabel labelState_1;
	 private JLabel labelPin_1;
	 private JTextField textHouse_1;
	 private JTextField textBuilding_1;
	 private JTextField textPlace_1;
	 private JTextField textCity_1;
	 private JTextField textState_1;
	 private JTextField textPin_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUpdateUI frame = new CustomerUpdateUI(c);
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
	public CustomerUpdateUI(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 900);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel updateInfoLabel = new JLabel("User Infomation Settings");
		updateInfoLabel.setBounds(5, 5, 947, 67);
		updateInfoLabel.setOpaque(true);
		updateInfoLabel.setBackground(SystemColor.textHighlight);
		updateInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateInfoLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(updateInfoLabel);
		
		JLabel labelPhnNo = new JLabel("Phone No.");
		labelPhnNo.setBounds(23, 104, 76, 19);
		labelPhnNo.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(labelPhnNo);
		
		textPhn = new JTextField(c.getCusContact());
		textPhn.setBounds(134, 102, 292, 22);
		contentPane.add(textPhn);
		textPhn.setColumns(10);
		
		lblSalary = new JLabel("Salary: ");
		lblSalary.setBounds(23, 184, 76, 33);
		lblSalary.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblSalary);
		
		lblOccupation = new JLabel("Occupation:");
		lblOccupation.setBounds(23, 265, 76, 33);
		lblOccupation.setHorizontalAlignment(SwingConstants.LEFT);
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblOccupation);
		
		lblAadharNo = new JLabel("Aadhar No.:");
		lblAadharNo.setBounds(23, 352, 76, 33);
		lblAadharNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAadharNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblAadharNo);
		
		lblBankAccountNo = new JLabel("Bank Account No.:");
		lblBankAccountNo.setBounds(23, 454, 109, 33);
		lblBankAccountNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblBankAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblBankAccountNo);
		
		lblPanNo = new JLabel("PAN No.:");
		lblPanNo.setBounds(23, 527, 76, 33);
		lblPanNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPanNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPanNo);
		
		lblVehilceOwned = new JLabel("Vehicle owned: ");
		lblVehilceOwned.setBounds(23, 609, 92, 33);
		lblVehilceOwned.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehilceOwned.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblVehilceOwned);
		
		textBankAcc = new JTextField(c.getCusBankAcc());
		textBankAcc.setBounds(134, 445, 292, 22);
		textBankAcc.setColumns(10);
		contentPane.add(textBankAcc);
		
		textAadhar = new JTextField(c.getCusAadhar());
		textAadhar.setBounds(134, 357, 292, 22);
		textAadhar.setColumns(10);
		contentPane.add(textAadhar);
		
		textOcc = new JTextField(c.getOccupation());
		textOcc.setBounds(134, 270, 292, 22);
		textOcc.setColumns(10);
		contentPane.add(textOcc);
		
		textSalary = new JTextField(String.valueOf(c.getCusSalary()));
		textSalary.setBounds(134, 189, 292, 22);
		textSalary.setColumns(10);
		contentPane.add(textSalary);
		
		textPan = new JTextField(c.getCusPan());
		textPan.setBounds(134, 532, 292, 22);
		textPan.setColumns(10);
		contentPane.add(textPan);
		
		textVehicle = new JTextField(c.getCusVehicle());
		textVehicle.setBounds(134, 614, 292, 22);
		textVehicle.setColumns(10);
		contentPane.add(textVehicle);
		
		buttonUpdate = new JButton("Update Vehicle");
		buttonUpdate.setBounds(282, 649, 144, 25);
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vehicle = textVehicle.getText();
				int d = csl.CustomerFillInfo(c.getCusId(), vehicle, 7);
				if(d>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Car.");
				}else {
					 JOptionPane.showMessageDialog(null, "You have unsucessfully updated your Car");
				}
				
			}
		});
		contentPane.add(buttonUpdate);
		
		labelHouse = new JLabel("House No.:");
		labelHouse.setBounds(482, 130, 76, 33);
		labelHouse.setHorizontalAlignment(SwingConstants.LEFT);
		labelHouse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelHouse);
		
		labelBuilding = new JLabel("Building no.:");
		labelBuilding.setBounds(482, 184, 76, 33);
		labelBuilding.setHorizontalAlignment(SwingConstants.LEFT);
		labelBuilding.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelBuilding);
		
		labelPlace = new JLabel("Place:");
		labelPlace.setBounds(482, 231, 76, 33);
		labelPlace.setHorizontalAlignment(SwingConstants.LEFT);
		labelPlace.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelPlace);
		
		labelCity = new JLabel("City: ");
		labelCity.setBounds(482, 277, 76, 33);
		labelCity.setHorizontalAlignment(SwingConstants.LEFT);
		labelCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelCity);
		
		labelState = new JLabel("State: ");
		labelState.setBounds(482, 323, 76, 33);
		labelState.setHorizontalAlignment(SwingConstants.LEFT);
		labelState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelState);
		
		labelPin = new JLabel("PinCode: ");
		labelPin.setBounds(482, 369, 76, 33);
		labelPin.setHorizontalAlignment(SwingConstants.LEFT);
		labelPin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(labelPin);
		
		textHouse = new JTextField();
		textHouse.setBounds(591, 135, 292, 22);
		contentPane.add(textHouse);
		textHouse.setColumns(10);
		
		textBuilding = new JTextField();
		textBuilding.setBounds(591, 184, 292, 22);
		textBuilding.setColumns(10);
		contentPane.add(textBuilding);
		
		textPlace = new JTextField();
		textPlace.setBounds(591, 236, 292, 22);
		textPlace.setColumns(10);
		contentPane.add(textPlace);
		
		textCity = new JTextField();
		textCity.setBounds(591, 282, 292, 22);
		textCity.setColumns(10);
		contentPane.add(textCity);
		
		textState = new JTextField();
		textState.setBounds(591, 328, 292, 22);
		textState.setColumns(10);
		contentPane.add(textState);
		
		textPin = new JTextField();
		textPin.setBounds(591, 374, 292, 22);
		textPin.setColumns(10);
		contentPane.add(textPin);
		
		buttonAddAddress = new JButton("Add Address");
		buttonAddAddress.setBounds(739, 421, 144, 25);
		buttonAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int cid = c.getCusId();
				 String hno = textHouse.getText();
				 String building = textBuilding.getText();
				 String place = textPlace.getText();
				 String city = textCity.getText();
				 String state = textState.getText();
				 String pin = textPin.getText();
				 Address addr = new Address(cid,hno,building,place,city,state,pin);
				 int addaddr = csl.CustomerAddAddress(cid, addr, 1);
				 if(addaddr>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully added your Address.");
				 }else {
					 JOptionPane.showMessageDialog(null, "Adding address unsuccessful.");
				 }
			}
		});
		contentPane.add(buttonAddAddress);
		
		JButton btnNewButton = new JButton("Back to Dashboard");
		btnNewButton.setBounds(49, 815, 168, 25);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerDashBoardUI cdui = new CustomerDashBoardUI(c);
			cdui.setVisible(true);
			dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		buttonPan = new JButton("Update PAN");
		buttonPan.setBounds(282, 562, 144, 25);
		buttonPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pan = textPan.getText();
				int g = csl.CustomerFillInfo(c.getCusId(),pan ,5);
				if(g>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your PAN details.");
				}else {
					 JOptionPane.showMessageDialog(null, "Unsuccessful in updating ur PAN info.");
				}
			}
		});
		contentPane.add(buttonPan);
		
		buttonAccount = new JButton("Update Account no.");
		buttonAccount.setBounds(282, 475, 144, 25);
		buttonAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bankacc = textBankAcc.getText();
				int g = csl.CustomerFillInfo(c.getCusId(),bankacc ,3);
				if(g>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Bank Account No.");
				}else {
					 JOptionPane.showMessageDialog(null, "Unsuccessful in updating ur Bank Account No.");
				}
				
			}
		});
		contentPane.add(buttonAccount);
		
		buttonContact = new JButton("Update Contact");
		buttonContact.setBounds(282, 130, 144, 25);
		buttonContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String contact = textPhn.getText();
			int g = csl.CustomerFillInfo(c.getCusId(), contact, 2);
			if(g>0) {
				 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Contact No..");
			}else {
				 JOptionPane.showMessageDialog(null, "You unsuccesful.");
			}
			
			}
		});
		contentPane.add(buttonContact);
		
		buttonAadhar = new JButton("Update Aadhar");
		buttonAadhar.setBounds(282, 392, 144, 25);
		buttonAadhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aadhar = textAadhar.getText();
				int h = csl.CustomerFillInfo(c.getCusId(), aadhar, 1);
				if(h>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Aadhar No..");
				}else {
					 JOptionPane.showMessageDialog(null, "You have unsuccessfully updated your Aadhar No..");
				}
				
			}
		});
		contentPane.add(buttonAadhar);
		
		buttonSalary = new JButton("Update Salary");
		buttonSalary.setBounds(282, 218, 144, 25);
		buttonSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String salary = textSalary.getText();
				int k = csl.CustomerFillInfo(c.getCusId(), salary, 4);
				if(k>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Salary.");
				}else {
					 JOptionPane.showMessageDialog(null, "You unsuccessfully updated your salary.");
				}
			}
		});
		contentPane.add(buttonSalary);
		
		buttonOccupation = new JButton("Update Occupation");
		buttonOccupation.setBounds(282, 301, 144, 25);
		buttonOccupation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String occ = textOcc.getText();
				int g = csl.CustomerFillInfo(c.getCusId(),occ ,6);
				if(g>0) {
					 JOptionPane.showMessageDialog(null, "You have sucessfully updated your Occupation.");
				}else {
					 JOptionPane.showMessageDialog(null, "Check Phone no..");
				}
			}
		});
		contentPane.add(buttonOccupation);
		
		JLabel lblNewLabel = new JLabel("Add Address Details:");
		lblNewLabel.setBounds(591, 85, 277, 38);
		contentPane.add(lblNewLabel);
		
		JButton buttonUpdateAddress = new JButton("Update Address");
		buttonUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int cid = c.getCusId();
				  String hno = textHouse_1.getText();
				  String building = textBuilding_1.getText();
				  String place = textPlace_1.getText();
				  String city = textCity_1.getText();
				  String state = textState_1.getText();
				  String pin = textPin_1.getText();
				  Address addr = new Address(cid,hno,building,place,city,state,pin);
				  int upadd = csl.CustomerAddAddress(cid, addr, 2);
				  if(upadd>0) {
					  JOptionPane.showMessageDialog(null, "You have sucessfully updated your Address Details.");
				  }else {
					  JOptionPane.showMessageDialog(null, "You have unsucessfully .");
				  }
			}
		});
		buttonUpdateAddress.setBounds(739, 795, 144, 25);
		contentPane.add(buttonUpdateAddress);
		
		labelHouse_1 = new JLabel("House No.:");
		labelHouse_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelHouse_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHouse_1.setBounds(482, 521, 76, 33);
		contentPane.add(labelHouse_1);
		
		labelBuilding_1 = new JLabel("Building no.:");
		labelBuilding_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelBuilding_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelBuilding_1.setBounds(482, 566, 76, 33);
		contentPane.add(labelBuilding_1);
		
		labelPlace_1 = new JLabel("Place:");
		labelPlace_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelPlace_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPlace_1.setBounds(482, 609, 76, 33);
		contentPane.add(labelPlace_1);
		
		labelCity_1 = new JLabel("City: ");
		labelCity_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCity_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCity_1.setBounds(482, 653, 76, 33);
		contentPane.add(labelCity_1);
		
		labelState_1 = new JLabel("State: ");
		labelState_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelState_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelState_1.setBounds(482, 695, 76, 33);
		contentPane.add(labelState_1);
		
		labelPin_1 = new JLabel("PinCode: ");
		labelPin_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelPin_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPin_1.setBounds(482, 741, 76, 33);
		contentPane.add(labelPin_1);
		
		textHouse_1 = new JTextField();
		textHouse_1.setColumns(10);
		textHouse_1.setBounds(591, 532, 292, 22);
		contentPane.add(textHouse_1);
		
		textBuilding_1 = new JTextField();
		textBuilding_1.setColumns(10);
		textBuilding_1.setBounds(591, 571, 292, 22);
		contentPane.add(textBuilding_1);
		
		textPlace_1 = new JTextField();
		textPlace_1.setColumns(10);
		textPlace_1.setBounds(591, 614, 292, 22);
		contentPane.add(textPlace_1);
		
		textCity_1 = new JTextField();
		textCity_1.setColumns(10);
		textCity_1.setBounds(591, 658, 292, 22);
		contentPane.add(textCity_1);
		
		textState_1 = new JTextField();
		textState_1.setColumns(10);
		textState_1.setBounds(591, 700, 292, 22);
		contentPane.add(textState_1);
		
		textPin_1 = new JTextField();
		textPin_1.setColumns(10);
		textPin_1.setBounds(591, 746, 292, 22);
		contentPane.add(textPin_1);
		
		JLabel lblNewLabel_1 = new JLabel("If you are looking to Update Address:");
		lblNewLabel_1.setBounds(591, 496, 277, 16);
		contentPane.add(lblNewLabel_1);
	}
}
