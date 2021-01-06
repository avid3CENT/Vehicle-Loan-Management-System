package lti.vehicleloan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import lti.vehicleloan.dbconnection.DbConnection;
import lti.vehicleloan.entity.Loan;

public class LoanServiceLayer implements LoanInterface {
	Connection con = null;
	DbConnection db = new DbConnection();
	PreparedStatement ps = null;
	CallableStatement cs = null;
	List<Loan> loanlist;
	List<Loan> searchlist;
	int i,h;
	ResultSet res1;
	private Loan loan = null;
	boolean isLoan;
	ResultSet res;
	private int ret;
	
	public int addLoan(Loan loan) {
		con = db.getConnection();
		String add ="insert into loan(LOAN_ID,LOAN_NAME,LOAN_TYPE,LOAN_RATE,LOAN_TERM,LOAN_DOWNPAY,LOAN_PRINCIPAL) values(loan_id_seq.nextval,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(add);
			ps.setString(1,loan.getLoanName());
			ps.setString(2,loan.getLoanType());
			ps.setString(3,loan.getInterestpa());
			ps.setInt(4, loan.getMonths());
			ps.setDouble(5, loan.getDownPay());
			ps.setString(6, loan.getPrincipal());
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

	
	public ResultSet viewLoan() {
		
		con = db.getConnection();
		String list = "select loan_id as \"Loan ID\",loan_name as \"Loan Name\",loan_type as \"Loan Type\",loan_rate as \"Loan Interest Rate(p.a.) upto\",loan_term as \"Loan Term upto (in Months)\",loan_principal \"Max Amounnt\" ,loan_downpay \"Loan DownPayment\" from loan";
		try {
			ps = con.prepareStatement(list);
			res = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
		
		
	}

	public List<Loan> searchLoan(int loanId) {
		con = db.getConnection();
		String search = "select * from loan where loan_id = ?";
		try {
			ps = con.prepareStatement(search);
			ps.setInt(1,loanId);
			ResultSet res = ps.executeQuery();
			List<Loan>searchlist = new ArrayList<Loan>();
			while(res.next()) {
				searchlist.add(new Loan(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getString(5)));
			}
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
		return searchlist;
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

	public int checkLoanEligibiltyNewCar(double principal,double costOfCar) {
		if(principal<=costOfCar) {
			h=1;
		}else {
			h=2;
		}

		return h;
	}

	public Loan searchLoanOnLoanType(String loanType) {
		con = db.getConnection();
		String search = "select * from loan where loan_name = ?";
		
			try {
				ps = con.prepareStatement(search);
				ps.setString(1,loanType);
				res1 = ps.executeQuery();
			while(res1.next()) {
				loan = new Loan(res1.getInt(1),res1.getString(2),res1.getString(3),res1.getString(4),res1.getInt(5),res1.getDouble(6),res1.getString(7));
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return loan;
	}

	public ResultSet viewLoan(int loanId) {
		con = db.getConnection();
		String search = "select * from loan where loan_id = ?";
		try {
			ps = con.prepareStatement(search);
			ps.setInt(1, loanId);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public boolean isLoan(int loanId) {
		con = db.getConnection();
		String search = "select * from loan where loan_id = ?";
		try {
			ps = con.prepareStatement(search);
			ps.setInt(1, loanId);
			res = ps.executeQuery();
			if(res.next()) {
				isLoan = true;
			}else {
				isLoan = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isLoan;
	}

	public Loan searchLoanOnLoanId(int loanId) {
		con = db.getConnection();
		String search = "select * from loan where loan_id = ?";
		
			try {
				ps = con.prepareStatement(search);
				ps.setInt(1,loanId);
				res1 = ps.executeQuery();
			while(res1.next()) {
				loan = new Loan(res1.getInt(1),res1.getString(2),res1.getString(3),res1.getString(4),res1.getInt(5),res1.getDouble(6),res1.getString(7));
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return loan;
	}
	public int UpdateLoan(int loanId, String some,int choice) {
		con = db.getConnection();
		String str;

		try {
			/*
			 * 1. for principal
			 */
			if(choice==1) {
				str = "{call updateloanamount(?,?)}";
				cs = con.prepareCall(str);
				cs.setString(1,some);
				cs.setInt(2,loanId);
				ret = cs.executeUpdate();
			}
			/*
			 * 2. for roi
			 */
			else if(choice==2) {
				str = "{call updateloanroi(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(2,loanId);
				cs.setString(1,some);
				ret = cs.executeUpdate();
			}
			/*
			 * 3. for term
			 */
			else if(choice==3) {
				int term = Integer.parseInt(some);
				str = "{call updateloanterm(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(2,loanId);
				cs.setInt(1,term);
				ret = cs.executeUpdate();
			}
			/*
			 * 4. for down payment
			 */
			else if(choice==4) {
				double downpay = Double.parseDouble(some);
				str = "{call updatesal(?,?)}";
				cs = con.prepareCall(str);
				cs.setDouble(1,downpay);
				cs.setInt(2,loanId);
				ret = cs.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}


	@Override
	public int checkLoanEligibiltyPreOwnedCar(double principal, double costOfCar) {
		if(principal<=0.85*costOfCar) {
			h=1;
		}else {
			h=2;
		}

		return h;
	}

}
