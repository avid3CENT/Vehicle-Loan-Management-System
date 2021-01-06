package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.entity.Employee;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class ManagerViewAppliSepUI extends JFrame {

	private JPanel contentPane;
	private ResultSet res;
	private static Employee emp;
	private static int appId;
	private DefaultListModel DLM1;
	private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerViewAppliSepUI frame = new ManagerViewAppliSepUI(emp,appId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadList(int appId) {
		ApplicationServiceLayer asl = new ApplicationServiceLayer();
		res = asl.managerShowParticularApplication(appId);
		DLM1 = new DefaultListModel();
		try {
			while(res.next()) {
				DLM1.addElement("<html><p>Application ID :  "+res.getInt(1)+"</p><p>Customer ID :  "+res.getInt(2)+"</p><p>Applicant Name :  "+res.getString(3)+"</p><p>Loan ID :  "+res.getInt(4)+"</p><p>Loan Name :  "+res.getString(5)+"</p><p>Loan Amount :  Rs."+res.getFloat(6)+"</p><p>Loan rate of interest (p.a.) :  "+res.getFloat(7)+"%</p><p>Loan Term (in months) :  "+res.getInt(8)+"</p><p>Loan Application Status :  "+res.getString(9)+"</p><p>Applicant Car Name :  "+res.getString(10)+"</p><p>Loan Down Payment :  Rs."+res.getFloat(12)+"</p></html>");
			} 
			list.setModel(DLM1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public ManagerViewAppliSepUI(Employee emp,int appId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application No.: "+appId);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(51, 153, 102));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 33));
		lblNewLabel.setBounds(0, 0, 800, 72);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Calibri", Font.PLAIN, 24));
		list.setBounds(12, 86, 776, 473);
		contentPane.add(list);
		
		JButton buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationWindowUI mawui = new ApplicationWindowUI(emp);
				dispose();
				mawui.setVisible(true);
			
			}
		});
		buttonGoBack.setFont(new Font("Calibri", Font.PLAIN, 17));
		buttonGoBack.setBounds(663, 615, 111, 25);
		contentPane.add(buttonGoBack);
	loadList(appId);
	}
}
