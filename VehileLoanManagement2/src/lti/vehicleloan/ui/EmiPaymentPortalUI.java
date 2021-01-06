package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.StatusServiceLayer;
import lti.vehicleloan.entity.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class EmiPaymentPortalUI extends JFrame {

	private JPanel contentPane;
	private JLabel infolabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Customer c;
	private static double emi;
	private static int appId;
	int j;
	TmerThread timer = new TmerThread();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmiPaymentPortalUI frame = new EmiPaymentPortalUI(c,emi,appId);
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
	public EmiPaymentPortalUI(Customer c,double emi,int appId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Dashboard = new JLabel("EMI Payment Portal");
		Dashboard.setForeground(SystemColor.text);
		Dashboard.setFont(new Font("Corbel", Font.PLAIN, 44));
		Dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		Dashboard.setOpaque(true);
		Dashboard.setBackground(new Color(165, 42, 42));
		Dashboard.setBounds(0, 0, 1055, 104);
		contentPane.add(Dashboard);
		
		JLabel lblNewLabel = new JLabel("Choose your Payment Method:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(73, 128, 324, 58);
		contentPane.add(lblNewLabel);
		
		JRadioButton NetBanking = new JRadioButton("     Net Banking");
		NetBanking.setActionCommand("Net Banking");
		buttonGroup.add(NetBanking);
		NetBanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infolabel.setText("<html><p><b>Step 1</b>: Select your bank</p><p></p><p><b>Step 2</b>: Confirm payment</p><p>&#9830 Enter your authentication as requested</p><p></p><p><b>Step 3</b>: Receive online confirmation</p><p>&#9830You will receive a Transaction Reference Number on</p><p>      successful completion of the transaction</p><p></p></html>");
			}
		});
		NetBanking.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NetBanking.setBackground(Color.WHITE);
		NetBanking.setBounds(73, 224, 324, 25);
		contentPane.add(NetBanking);
		
		JRadioButton DebitCard = new JRadioButton("     Debit Card");
		DebitCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infolabel.setText("<html><p><b>Step 1: </b> Select your bank</p><p>&#9830 Select your Debit Card type from which you would like to make your payment</p><p></p><p><b>Step 2: </b> Confirm payment</p><p>&#9830Enter your authentication as requested</p><p>&#9830 Your Debit Card will get debited instantaneously</p><p></p><p><b>Step 3:</b> Receive online confirmation</p><p>&#9830 You will receive a Transaction Reference Number on successful completion of the transaction</p></html>");
			}
		});
		buttonGroup.add(DebitCard);
		DebitCard.setActionCommand("Debit Card");
		DebitCard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DebitCard.setBackground(Color.WHITE);
		DebitCard.setBounds(73, 279, 324, 25);
		contentPane.add(DebitCard);
		
		
		JRadioButton UPI = new JRadioButton("     UPI Paytm");
		UPI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infolabel.setText("<html><p><b>Step 1: </b>Verify you loan account number twice.</p><p></p><p><b>Step 2: </b> Check all details populated on your screen.</p><p></p><p><b>Step 3: </b> Enter amount you wish to pay. (To avoid future late payment charges please clear the entire overdue amount)</p><p></p><p><b>Step 4:</b> Click on Generate QR Code</p><p></p><p><b>Step 6: </b> Proceed for payment in the Paytm app.</p><p></p><p><b>Step 7: </b> You will get success confirmation with transaction number on your mobile screen.</p><p></p><p>Daily Money transfer limit is of Rs. </p></html>");
			}
		});
		buttonGroup.add(UPI);
		UPI.setActionCommand("Paytm");
		UPI.setFont(new Font("Tahoma", Font.PLAIN, 17));
		UPI.setBackground(Color.WHITE);
		UPI.setBounds(73, 332, 324, 25);
		contentPane.add(UPI);
		
		infolabel = new JLabel("<html><b>Click on the radio box to view details</b></html>");
		infolabel.setFont(new Font("Calibri", Font.PLAIN, 23));
		infolabel.setVerticalAlignment(SwingConstants.TOP);
		infolabel.setBounds(442, 201, 579, 315);
		contentPane.add(infolabel);
		
		JButton buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayEmiUI pemiui = new PayEmiUI(c);
				pemiui.setVisible(true);
				dispose();
			}
		});
		buttonGoBack.setBackground(Color.WHITE);
		buttonGoBack.setBounds(57, 628, 156, 37);
		contentPane.add(buttonGoBack);
		char rupee = '\u20B9';
		String amount = Double.toString(emi);
		JButton btnNewButton_1 = new JButton("Proceed to pay "+rupee+amount);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.getSelection()==null) {
					JOptionPane.showMessageDialog(null, "Please select a payment method.");
				}else {
					JOptionPane.showMessageDialog(null, "Redirecting you the "+buttonGroup.getSelection().getActionCommand()+ " portal.");
					timer.run();
					if(UPI.isSelected()) {
					
						StatusServiceLayer ssl = new StatusServiceLayer();
						j = ssl.emiPaid(appId, c.getCusId());
						if(j>0) {
							JOptionPane.showMessageDialog(null, "Payment done using Paytm UPI. Redirecting to Dashboard.");
							CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
							cdbui.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "There was an error processing your Payment.Please try again.");
						}
						
					}else if(NetBanking.isSelected()) {
						StatusServiceLayer ssl = new StatusServiceLayer();
						j = ssl.emiPaid(appId, c.getCusId());
						if(j>0) {
							JOptionPane.showMessageDialog(null, "Payment done using Net Banking. Redirecting to Dashboard.");
							CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
							cdbui.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "There was an error processing your Payment.Please try again.");
						}
					}if(DebitCard.isSelected()) {
						StatusServiceLayer ssl = new StatusServiceLayer();
						j = ssl.emiPaid(appId, c.getCusId());
						if(j>0) {
							JOptionPane.showMessageDialog(null, "Payment done using Debit Card. Redirecting to Dashboard.");
							CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
							cdbui.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "There was an error processing your Payment.Please try again.");
						}
					}	
				}
			}
		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(750, 622, 251, 43);
		contentPane.add(btnNewButton_1);
	}
}
