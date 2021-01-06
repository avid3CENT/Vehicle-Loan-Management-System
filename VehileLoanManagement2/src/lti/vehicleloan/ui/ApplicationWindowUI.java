package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.dao.StatusServiceLayer;
import lti.vehicleloan.entity.Application;
import lti.vehicleloan.entity.Employee;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ApplicationWindowUI extends JFrame {

	private JPanel contentPane;
	private JTable tableApplication;
	private ResultSet res;
	private ResultSet res1;
	private ResultSet res2;
	private ResultSet res3;
	private JTextField textAppID;
	private List cus;
	int cus_id;
	private List<Application> appp;
	private Application application;
	private static Employee emp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindowUI frame = new ApplicationWindowUI(emp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loadTable() {
		ApplicationServiceLayer asl = new ApplicationServiceLayer();
		res = asl.managerViewApplication();
		tableApplication.setModel(DbUtils.resultSetToTableModel(res));
	}
	/**
	 * Create the frame.
	 */
	public ApplicationWindowUI(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loan Application Window");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1112, 86);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1090, 382);
		contentPane.add(scrollPane);

		tableApplication = new JTable();
		
		//Centred format of Cell text 
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableApplication.setDefaultRenderer(String.class, centerRenderer);
		
		//Increasing cell size
		tableApplication.setRowHeight(30);
		
		//cell text font
		tableApplication.setFont(new Font("Calibri", Font.PLAIN, 17));
		scrollPane.setViewportView(tableApplication);
		tableApplication.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));

		JButton btnNewButton = new JButton("Go to Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emp.getEmpJob().equalsIgnoreCase("manager")) {
					ManagerDashBoardUI mdbui = new ManagerDashBoardUI(emp);
					mdbui.setVisible(true);

				}else if(emp.getEmpJob().equalsIgnoreCase("staff member")) {
					StaffDashBoard sdf = new StaffDashBoard(emp);
					sdf.setVisible(true);

				}
				dispose();
			}
		});
		btnNewButton.setBounds(944, 658, 143, 25);
		contentPane.add(btnNewButton);

		JButton buttonShowApplication = new JButton("Show All");
		buttonShowApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				res = asl.managerViewApplication();
				tableApplication.setModel(DbUtils.resultSetToTableModel(res));
			}
		});
		buttonShowApplication.setBounds(27, 509, 131, 25);
		contentPane.add(buttonShowApplication);

		JButton btnNewButton_2 = new JButton("Show Pending");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				res1 = asl.managerPendingApplication();
				tableApplication.setModel(DbUtils.resultSetToTableModel(res1));
			}
		});
		btnNewButton_2.setBounds(27, 555, 131, 25);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Show Approved");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				res2 = asl.managerApprovedApplication();
				tableApplication.setModel(DbUtils.resultSetToTableModel(res2));
			}
		});
		btnNewButton_1.setBounds(27, 599, 131, 25);
		contentPane.add(btnNewButton_1);

		textAppID = new JTextField();
		textAppID.setBounds(229, 520, 750, 40);
		contentPane.add(textAppID);
		textAppID.setColumns(10);

		JButton buttonSeaprateView = new JButton("View Separately");
		buttonSeaprateView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				if(textAppID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application ID field cannot be blank.");
				}else {
					int appId = Integer.parseInt(textAppID.getText());

					ManagerViewAppliSepUI mvasui = new ManagerViewAppliSepUI(emp,appId);
					mvasui.setVisible(true);	
				}
			}

		});
		buttonSeaprateView.setBounds(229, 573, 131, 25);
		contentPane.add(buttonSeaprateView);

		JLabel lableApplicationID = new JLabel("Application ID:");
		lableApplicationID.setFont(new Font("Calibri", Font.PLAIN, 15));
		lableApplicationID.setHorizontalAlignment(SwingConstants.CENTER);
		lableApplicationID.setBounds(229, 494, 750, 25);
		contentPane.add(lableApplicationID);

		JButton buttonViewApplicant = new JButton("View Applicant Details");
		buttonViewApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAppID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application ID field cannot be blank.");
				}else {
					ApplicationServiceLayer asl = new ApplicationServiceLayer();
					int appId = Integer.parseInt(textAppID.getText());
					int cusId = asl.managerCusfromApplicant(appId);
					ApplicantDetailsUI madui = new ApplicantDetailsUI(emp,appId,cusId);
					madui.setVisible(true);	

				}
			}
		});
		buttonViewApplicant.setBounds(385, 573, 188, 25);
		contentPane.add(buttonViewApplicant);

		JButton buttonEligibility = new JButton("Check Eligibility");
		buttonEligibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAppID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application ID field should not be empty.");
				}else {
					int appId = Integer.parseInt(textAppID.getText());
					ApplicationServiceLayer asl = new ApplicationServiceLayer();
					int i = asl.checkEligibility(appId);
					if(i==1) {
						JOptionPane.showMessageDialog(null, "Application is eligible for loan.");
					}else if(i==2) {
						JOptionPane.showMessageDialog(null, "Application not eligible. EMI to salary constraint.");
					}else if(i==3) {
						JOptionPane.showMessageDialog(null, "Application not eligible. Age Constraint.");
					}
				}


			}
		});
		buttonEligibility.setBounds(596, 573, 168, 25);
		contentPane.add(buttonEligibility);

		JButton buttonApprove = new JButton("Approve Application");
		buttonApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAppID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Application ID field should not be empty.");
				}else {
					ApplicationServiceLayer asl = new ApplicationServiceLayer();
					int appId = Integer.parseInt(textAppID.getText());
					int j = asl.checkEligibility(appId);
					if(j==1) {
						if(emp.getEmpJob().equalsIgnoreCase("manager")) {
							boolean isThere = asl.chechIfApproved(appId);
							if(isThere) {
								JOptionPane.showMessageDialog(null, "Application ID already approved.");
							}else {
								boolean isPresent = asl.managerSearchApplication(appId);
								if(isPresent) {
									appp = new LinkedList<Application>(); 
									appp= asl.searchApplication(appId);
									for(Application a:appp) {
										application = new Application(a.getAppId(),a.getCusId(),a.getCusName(),a.getLoanId(),a.getLoanName(),a.getPrincipal(),a.getRate(),a.getMonth(),a.getStatus(),a.getCarName(),a.getCarType(),a.getLoanDownpay());
									}
									StatusServiceLayer ssl = new StatusServiceLayer();
									int add = ssl.addStatus(application);
									if(add>0) {
										JOptionPane.showMessageDialog(null, "Application apporved.");
									}else {
										JOptionPane.showMessageDialog(null, "Application was unable to approve.");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Applicant with this Application ID not present.");
								}
							}
						}else if(emp.getEmpJob().equalsIgnoreCase("staff member")) {
							JOptionPane.showMessageDialog(null, "Approving Application Authority is only with the Manager.");
							buttonApprove.setEnabled(false);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Application not eligible. Check Applicant Details.");
					}

				}
			}
		});
		buttonApprove.setBounds(791, 573, 188, 25);
		contentPane.add(buttonApprove);
		loadTable();
		dispose();
	}

}
