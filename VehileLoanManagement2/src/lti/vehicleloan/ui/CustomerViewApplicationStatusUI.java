package lti.vehicleloan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import lti.vehicleloan.dao.ApplicationServiceLayer;
import lti.vehicleloan.entity.Customer;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class CustomerViewApplicationStatusUI extends JFrame {

	private JPanel contentPane;
	private static Customer c;
	private JTable tableApplication;
	private ResultSet res;
	private JButton buttonShowApplication;
	private JButton buttonGoBack;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerViewApplicationStatusUI frame = new CustomerViewApplicationStatusUI(c);
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
	public CustomerViewApplicationStatusUI(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 738);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Dashboard = new JLabel("View Loan Application Status");
		Dashboard.setForeground(SystemColor.text);
		Dashboard.setFont(new Font("Corbel", Font.PLAIN, 44));
		Dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		Dashboard.setOpaque(true);
		Dashboard.setBackground(SystemColor.textHighlight);
		Dashboard.setBounds(0, 0, 1055, 93);
		contentPane.add(Dashboard);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 1033, 326);
		contentPane.add(scrollPane);
		
		tableApplication = new JTable();
		tableApplication.setFont(new Font("Calibri", Font.PLAIN, 18));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableApplication.setDefaultRenderer(String.class, centerRenderer);
		tableApplication.setRowHeight(30);
		scrollPane.setViewportView(tableApplication);
		
		buttonShowApplication = new JButton("Show Application Status");
		buttonShowApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationServiceLayer asl = new ApplicationServiceLayer();
				res = asl.customerSearchApplication(c);
				tableApplication.setModel(DbUtils.resultSetToTableModel(res));
			}
		});
		buttonShowApplication.setBounds(365, 466, 324, 25);
		contentPane.add(buttonShowApplication);
		
		buttonGoBack = new JButton("Go Back");
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashBoardUI cdbui = new CustomerDashBoardUI(c);
				cdbui.setVisible(true);
				dispose();
			}
		});
		buttonGoBack.setBounds(912, 621, 97, 25);
		contentPane.add(buttonGoBack);
		
		
	}
}
