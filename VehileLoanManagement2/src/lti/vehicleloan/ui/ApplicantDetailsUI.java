package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.CustomerServiceLayer;
import lti.vehicleloan.entity.Employee;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ApplicantDetailsUI extends JFrame {

	private JPanel contentPane;
	private static int appId;
	private static Employee emp;
	private ResultSet res;
	private DefaultListModel DLM;
	private JList listDetails;
	private static int cusId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantDetailsUI frame = new ApplicantDetailsUI(emp,appId,cusId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loadList(int a) {
		CustomerServiceLayer csl = new CustomerServiceLayer();
		res = csl.customerDetails(a);
		DLM = new DefaultListModel();
		try {
			while(res.next()) {
				DLM.addElement("<html><p>Applicant ID :  "+res.getInt(1)+"</p><p>Applicant Name :  "+res.getString(2)+"</p><p>Applicant Contact no. :  "+res.getString(3)+"</p><p>Applicant Salary :  "+res.getDouble(4)+"</p><p>Applicant Occupation :  "+res.getString(11)+"</p><p>Applicant Aadhar no. :  "+res.getString(7)+"</p><p>Applicant Bank Account no. :  "+res.getString(8)+"</p><p>Applicant PAN no. :  "+res.getString(9)+"</p><p>Applicant Vehicle Name :  "+res.getString(10)+"</p></html>");
			}listDetails.setModel(DLM);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public ApplicantDetailsUI(Employee emp,int appId, int cusId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818,724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelApplicationDetails = new JLabel("Applicant Details");
		labelApplicationDetails.setOpaque(true);
		labelApplicationDetails.setBackground(new Color(51, 153, 102));
		labelApplicationDetails.setFont(new Font("Calibri", Font.BOLD, 34));
		labelApplicationDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelApplicationDetails.setBounds(5, 5, 790, 64);
		contentPane.add(labelApplicationDetails);
		
		listDetails = new JList();
		listDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDetails.setBounds(15, 82, 773, 450);
		listDetails.setFont(new Font("Calibri", Font.PLAIN, 24));
		contentPane.add(listDetails);
		
		JButton buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ApplicationWindowUI mawui = new ApplicationWindowUI(emp);
				mawui.setVisible(true);
				dispose();
			}
		});
		buttonGoBack.setFont(new Font("Calibri", Font.PLAIN, 17));
		buttonGoBack.setBounds(663, 615, 111, 25);
		contentPane.add(buttonGoBack);
		loadList(cusId);
	}
}
