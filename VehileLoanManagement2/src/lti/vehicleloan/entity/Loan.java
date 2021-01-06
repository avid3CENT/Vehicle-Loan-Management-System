package lti.vehicleloan.entity;

public class Loan {
	private int loanId;
	private String loanName;
	private String loanType;
	private String interestpa;
	private int months;
	private double downPay;
	private String principal;
	
	public Loan(int loanId, String loanName) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
	}

	
	public Loan(String loanName, String loanType, String interestpa, int months, double downPay, String principal) {
		super();
		this.loanName = loanName;
		this.loanType = loanType;
		this.interestpa = interestpa;
		this.months = months;
		this.downPay = downPay;
		this.principal = principal;
	}


	public Loan(int loanId, String loanName, String loanType, String interestpa,int months,double downPay,String principal) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.loanType = loanType;
		this.interestpa = interestpa;
		this.months = months;
		this.downPay= downPay;
		this.principal=principal;
	}
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getInterestpa() {
		return interestpa;
	}
	public void setInterestpa(String interestpa) {
		this.interestpa = interestpa;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}

	public double getDownPay() {
		return downPay;
	}

	public void setDownPay(double downPay) {
		this.downPay = downPay;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	
	
}
