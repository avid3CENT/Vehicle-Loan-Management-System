package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Application;
import lti.vehicleloan.entity.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerDashBoardUI extends JFrame {

	private JPanel contentPane;
	private static Customer c;
	private List<Application> lapplist;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDashBoardUI frame = new CustomerDashBoardUI(c);
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
	public CustomerDashBoardUI(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Dashboard = new JLabel("Customer DashBoard");
		Dashboard.setForeground(SystemColor.text);
		Dashboard.setFont(new Font("Corbel", Font.PLAIN, 48));
		Dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		Dashboard.setOpaque(true);
		Dashboard.setBackground(SystemColor.textHighlight);
		Dashboard.setBounds(0, 0, 442, 691);
		contentPane.add(Dashboard);
		
		JLabel LogTitle = new JLabel("Logged in by: ");
		LogTitle.setFont(new Font("Calibri", Font.BOLD, 22));
		LogTitle.setForeground(SystemColor.text);
		LogTitle.setOpaque(true);
		LogTitle.setBackground(SystemColor.textHighlight);
		LogTitle.setBounds(441, 0, 614, 47);
		contentPane.add(LogTitle);
		
		JLabel Loginfo = new JLabel("ID: "+c.getCusId()+"       Name: "+c.getCusName());
		Loginfo.setFont(new Font("Calibri", Font.ITALIC, 21));
		Loginfo.setOpaque(true);
		Loginfo.setBackground(SystemColor.textHighlight);
		Loginfo.setBounds(441, 47, 614, 47);
		contentPane.add(Loginfo);
		
		JButton buttonApplyLoan = new JButton("Apply for a Car Loan");
		buttonApplyLoan.setBackground(new Color(255, 255, 255));
		buttonApplyLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyLoanUI alui = new ApplyLoanUI(c);
				alui.setVisible(true);
				dispose();
			}
		});
		buttonApplyLoan.setBounds(504, 348, 510, 59);
		contentPane.add(buttonApplyLoan);
		
		JButton buttonUpdateInfo = new JButton("User Information Settings");
		buttonUpdateInfo.setBackground(new Color(255, 255, 255));
		buttonUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUpdateUI cui = new CustomerUpdateUI(c);
				cui.setVisible(true);
				dispose();
			}
		});
		buttonUpdateInfo.setBounds(504, 425, 510, 59);
		contentPane.add(buttonUpdateInfo);
		
		JButton buttonPayLoanEMI = new JButton("Pay Loan EMI");
		buttonPayLoanEMI.setBackground(new Color(255, 255, 255));
		buttonPayLoanEMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				int appId = asl.appIdfromCusId(c.getCusId());
				if(appId==0) {
					JOptionPane.showMessageDialog(null, "No Application has be sent for approval. Please apply for a loan to view this page");
				}else {
					boolean isApproved = asl.chechIfApproved(appId);
					if(isApproved) {
						PayEmiUI pemiui = new PayEmiUI(c);
						pemiui.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Application not yet approved.");
					}
				}
				
			}
		});
		buttonPayLoanEMI.setBounds(504, 503, 510, 59);
		contentPane.add(buttonPayLoanEMI);
		
		JButton buttonlogout = new JButton("Logout");
		buttonlogout.setBackground(new Color(255, 255, 255));
		buttonlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginUI clui = new CustomerLoginUI();
				dispose();
				JOptionPane.showMessageDialog(null, "You have sucessfully logged out.");
				clui.setVisible(true);
				
			}
		});
		buttonlogout.setBounds(917, 640, 97, 25);
		contentPane.add(buttonlogout);
		
		JButton buttonViewApp = new JButton("View your Loan Application Status");
		buttonViewApp.setBackground(new Color(255, 255, 255));
		buttonViewApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				lapplist = asl.searchApplication(c);
				if(lapplist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Apply for a Loan to view Loan Application Status.");
				}else {
					CustomerViewApplicationStatusUI cvasui = new CustomerViewApplicationStatusUI(c);
					 cvasui.setVisible(true);
					 dispose();
				}
			}
		});
		buttonViewApp.setBounds(504, 266, 510, 59);
		contentPane.add(buttonViewApp);
	}
}


/*buttonApplyLoan.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
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
				
				ApplyLoanUI apui = new ApplyLoanUI(c);
				apui.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Please fill your Address details.");
			}
		}else if(checkdetail==8) {
			JOptionPane.showMessageDialog(null, "Please fill all your details.");
		}
		
	}
});*/