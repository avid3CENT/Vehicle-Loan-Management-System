package lti.vehicleloan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import lti.vehicleloan.dbconnection.DbConnection;
import lti.vehicleloan.entity.Application;

public class StatusServiceLayer implements StatusInterface {
	DbConnection db = new DbConnection();
	private Connection con;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;
	Scanner scan = new Scanner(System.in);
	private ResultSet res;
	private ResultSet res1;
	int i,j;
	boolean isStatus;
	double emi;
	
	public int addStatus(Application app) {
		con = db.getConnection();
		double emi = CalculateEMI(app.getPrincipal(), app.getRate(), app.getMonth());
		double totalPayable = TotalAmountPayable(app.getPrincipal(), app.getRate(), app.getMonth());
		String addStatus = "{call ADDLOANSTATUS(?,?,?,?,?,?,?,?,?,?,?,?)}";
		//String addStatus = "INSERT INTO STATUS(APP_ID, CUS_ID, LOAN_ID, PRINCIPAL, RATE, TERM, EMI, LAST_MONTH_EMI_PAID, TOTAL_PAID_BACK, TERM_LEFT, TOTAL_PAYABLE_AMOUNT, TOTAL_PAYABLE_LEFT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		    try {
				cs = con.prepareCall(addStatus);
				cs.setInt(1, app.getAppId());
				cs.setInt(2, app.getCusId());
				cs.setInt(3, app.getLoanId());
				cs.setDouble(4, app.getPrincipal());
				cs.setDouble(5, app.getRate());
				cs.setInt(6, app.getMonth());
				cs.setDouble(7,emi);
				cs.setString(8,"no");
				cs.setDouble(9, 0d);
				cs.setInt(10,app.getMonth());
				cs.setDouble(11,totalPayable);
				cs.setDouble(12, totalPayable);
				i = cs.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
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



	public double TotalAmountPayable(double principal, double rate, int month) {
		double rateMonthly = ((rate/12)/100);
		double emi;
		double pow1 = Math.pow((1+rateMonthly),month);
		emi = (principal*rateMonthly*pow1)/((pow1)-1);
		double amount = emi*month;
		return amount;
	}
	public ResultSet viewStatus() {
		con = db.getConnection();
		String viewall = "select * from status";
		try {
			ps = con.prepareStatement(viewall);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public ResultSet searchStatus(int appId) {
		con = db.getConnection();
		String searchstatus = "select * from status where app_id = ?";
		try {
			ps = con.prepareStatement(searchstatus);
			ps.setInt(1, appId);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public boolean checkStatus(int appId) {
		con = db.getConnection();
		String checkstatus = "select * from status where app_id = ?";
		try {
			ps = con.prepareStatement(checkstatus);
			ps.setInt(1, appId);
			res = ps.executeQuery();
			if(res.next()) {
				isStatus = true;
			}else {
				isStatus = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isStatus;
	}
	public ResultSet searchStatusfromCus(int cusId) {
		con = db.getConnection();
		String searchstatus = "select * from status where cus_id = ?";
		try {
			ps = con.prepareStatement(searchstatus);
			ps.setInt(1, cusId);
			res1 = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res1;
	}
	
	public double emiFromLoan(int appId) {
		con = db.getConnection();
		String emiloan = "select emi from status where app_id = ?";
		try {
			ps = con.prepareStatement(emiloan);
			ps.setInt(1, appId);
			res = ps.executeQuery();
			if(res.next()) {
			emi = res.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emi;
	}
	
	public int emiPaid(int appId,int cusId) {
		con = db.getConnection();
		String paid = "{call PAIDEMI(?,?)}";
		try {
			cs = con.prepareCall(paid);
			cs.setInt(1, appId);
			cs.setInt(2, cusId);
			j = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}

}
