package lti.vehicleloan.dao;

import java.sql.CallableStatement;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import lti.vehicleloan.dbconnection.DbConnection;
import lti.vehicleloan.entity.Application;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.Loan;

public class ApplicationServiceLayer implements ApplicationInterface {
	DbConnection db = new DbConnection();
	private Connection con;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;
	Scanner scan = new Scanner(System.in);
	private ResultSet res;
	private ResultSet res1;
	private ResultSet res3;
	int i,k;
	int cusId;
	boolean isPresent;
	boolean isThere;
	boolean isEligible;
	List<Customer> customer;
	List<Application> appp;
	double principal;
	double emi;
	double rate;
	int term;

	public int addApplication(Customer customer, Loan loan,double principal,double rate,int month,String car_name) {
		con = db.getConnection();
		String addApplicant = "insert into application(app_id,cus_id,cus_name,loan_id,loan_name,principal,rate,term,status,car_name,car_type,LOAN_DOWNPAY) values(application_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(addApplicant);
			ps.setInt(1, customer.getCusId());
			ps.setString(2, customer.getCusName());
			ps.setInt(3, loan.getLoanId());
			ps.setString(4, loan.getLoanName());
			ps.setDouble(5, principal);
			ps.setDouble(6,rate);
			ps.setInt(7,month);
			ps.setString(8, "pending");
			ps.setString(9, car_name);
			ps.setString(10, loan.getLoanType());
			ps.setDouble(11, loan.getDownPay());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	public ResultSet viewApplication() {
		
		return null;
	}

	
	public List<Application> searchApplication(Customer c) {
		con = db.getConnection();
		List<Application> appsearchlist = null;
		String searchApp = "select * from application where cus_id=?";
		try {
			ps = con.prepareStatement(searchApp);
			ps.setInt(1, c.getCusId());
			res = ps.executeQuery();
			appsearchlist = new LinkedList<Application>();
			while(res.next()) {
				appsearchlist.add(new Application(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getString(5),res.getDouble(6),res.getDouble(7),res.getInt(8),res.getString(9),res.getString(10),res.getString(11),res.getDouble(12)));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return appsearchlist;
	}

	
	public ResultSet customerSearchApplication(Customer c) {
		con = db.getConnection();
		String customersearch = "select APP_ID,CUS_NAME,LOAN_NAME,CAR_NAME,PRINCIPAL,RATE,TERM,STATUS,LOAN_DOWNPAY from application where cus_id = ?";
		try {
			ps = con.prepareStatement(customersearch);
			ps.setInt(1, c.getCusId());
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public ResultSet managerViewApplication() {
		con = db.getConnection();
		String manView = "select APP_ID, CUS_ID, CUS_NAME, LOAN_NAME, PRINCIPAL, RATE, TERM, STATUS, CAR_NAME, CAR_TYPE FROM APPLICATION ";
		try {
			ps = con.prepareStatement(manView);
			res = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}


	public ResultSet managerPendingApplication() {
		con = db.getConnection();
		String pendingApp = "select APP_ID, CUS_ID, CUS_NAME, LOAN_NAME, PRINCIPAL, RATE, TERM, STATUS, CAR_NAME, CAR_TYPE FROM APPLICATION WHERE STATUS = 'pending'";
		try {
			ps = con.prepareStatement(pendingApp);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public ResultSet managerApprovedApplication() {
		con = db.getConnection();
		String approvedApp = "select APP_ID, CUS_ID, CUS_NAME, LOAN_NAME, PRINCIPAL, RATE, TERM, STATUS, CAR_NAME, CAR_TYPE FROM APPLICATION WHERE STATUS = 'approved'";
		try {
			ps = con.prepareStatement(approvedApp);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet managerShowParticularApplication(int appId) {
		con = db.getConnection();
		String particularApp = "SELECT * FROM APPLICATION WHERE APP_ID = ?";
		try {
			ps = con.prepareStatement(particularApp);
			ps.setInt(1, appId);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public boolean managerSearchApplication(int appId) {
		con = db.getConnection();
		String searchApp = "SELECT * FROM APPLICATION WHERE APP_ID= ?";
		try {
			ps = con.prepareStatement(searchApp);
			ps.setInt(1, appId);
			res = ps.executeQuery();
			if(res.next()) {
				isPresent = true;
			}else {
				isPresent = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isPresent;
	}

	public int managerCusfromApplicant(int appId) {
		con = db.getConnection();
		String getcus = "{call GETCUSID(?,?)}";
		
		try {
			cs = con.prepareCall(getcus);
			cs.setInt(1, appId);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.executeUpdate();
			cusId = cs.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cusId;
	}

	
	public List<Application> searchApplication(int appId) {
		con = db.getConnection();
		String particularApp = "SELECT * FROM APPLICATION WHERE APP_ID = ?";
		try {
			ps = con.prepareStatement(particularApp);
			ps.setInt(1, appId);
			res = ps.executeQuery();
			appp = new LinkedList<Application>();
			while(res.next()) {
				appp.add(new Application(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4), res.getString(5), res.getDouble(6), res.getDouble(7), res.getInt(8), res.getString(9), res.getString(10), res.getString(11), res.getDouble(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return appp;
		
	}

	public boolean chechIfApproved(int appID) {
		con = db.getConnection();
		String chec = "select status from application where app_id = ?";
		try {
			ps = con.prepareStatement(chec);
			ps.setInt(1, appID);
			res1 = ps.executeQuery();
			if(res1.next()) {
				if(res1.getString(1).equalsIgnoreCase("approved")) {
					isThere = true;
				}else {
					isThere = false;
				}
				
			}else {
				isThere = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isThere;
	}

	
	public int checkEligibility(int appId) {
		con = db.getConnection();
		String emil = "select principal,rate,term from application where app_id = ?";
		try {
			ps = con.prepareStatement(emil);
			ps.setInt(1, appId);
			res3 = ps.executeQuery();
			if(res3.next()) {
				principal = res3.getDouble(1);
				rate = res3.getDouble(2);
				term = res3.getInt(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double emi = CalculateEMI(principal, rate, term); 
		CustomerServiceLayer csl = new CustomerServiceLayer();
		int cus_id = managerCusfromApplicant(appId);
		double cus_age = csl.customerAge(cus_id);
		double sal = csl.salaryfromCusId(cus_id);
		if(cus_age<60) {
			if(emi < 0.65*sal) {
				i = 1;
			}else {
				i = 2;
			}
		}else {
			i = 3;

		}
		return i;
	}
	public double CalculateEMI(double principal, double rate, int month) {
		double rateMonthly = ((rate/12)/100);
		double emi;
		double pow1 = Math.pow((1+rateMonthly),month);
		emi = (principal*rateMonthly*pow1)/((pow1)-1);
		return emi;
	}

	public int appIdfromCusId(int cId) {
		con = db.getConnection();
		String getApp = "select app_id from application where cus_id = ?";
		try {
			ps = con.prepareStatement(getApp);
			ps.setInt(1, cId);
			res = ps.executeQuery();
			if(res.next()) {
				cusId = res.getInt(1);
			}else {
				cusId = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cusId ;
	}

}
