package lti.vehicleloan.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WelcomeUI extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeUI frame = new WelcomeUI();
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
	public WelcomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 100, 819, 629);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to People's Bank");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 36, 777, 96);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("And you are,");
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 219, 801, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginUI clogin = new CustomerLoginUI();
				dispose();
				clogin.setVisible(true);

			}


		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 19));
		btnNewButton.setBounds(332, 266, 142, 34);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Employee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLoginUI elogin = new EmployeeLoginUI();
				dispose();
				elogin.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 19));
		btnNewButton_1.setBounds(332, 328, 142, 34);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("App Created with Love by Avinash Prasad");
		lblNewLabel_2.setBackground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 525, 801, 57);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Car Loan Portal");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setFont(new Font("Book Antiqua", Font.BOLD, 27));
		lblNewLabel_3.setBounds(0, 114, 799, 65);
		contentPane.add(lblNewLabel_3);
	}
}
