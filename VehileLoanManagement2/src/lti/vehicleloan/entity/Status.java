package lti.vehicleloan.entity;

public class Status {
	private int appId;
	private int cusId;
	private int loanId;
	private double principal;
	private double rate;
	private int term;
	private double emi;
	private String lastMonthEmiPaid;
	private double totalPaidBackAmount;
	private int termLeft;
	private double totalPayableAmount;
	private double totalPayableLeft;
	public Status(int appId, int cusId, int loanId, double principal, double rate, int term, double emi,
			String lastMonthEmiPaid, double totalPaidBackAmount, int termLeft, double totalPayableAmount,
			double totalPayableLeft) {
		super();
		this.appId = appId;
		this.cusId = cusId;
		this.loanId = loanId;
		this.principal = principal;
		this.rate = rate;
		this.term = term;
		this.emi = emi;
		this.lastMonthEmiPaid = lastMonthEmiPaid;
		this.totalPaidBackAmount = totalPaidBackAmount;
		this.termLeft = termLeft;
		this.totalPayableAmount = totalPayableAmount;
		this.totalPayableLeft = totalPayableLeft;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public String getLastMonthEmiPaid() {
		return lastMonthEmiPaid;
	}
	public void setLastMonthEmiPaid(String lastMonthEmiPaid) {
		this.lastMonthEmiPaid = lastMonthEmiPaid;
	}
	public double getTotalPaidBackAmount() {
		return totalPaidBackAmount;
	}
	public void setTotalPaidBackAmount(double totalPaidBackAmount) {
		this.totalPaidBackAmount = totalPaidBackAmount;
	}
	public int getTermLeft() {
		return termLeft;
	}
	public void setTermLeft(int termLeft) {
		this.termLeft = termLeft;
	}
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public double getTotalPayableLeft() {
		return totalPayableLeft;
	}
	public void setTotalPayableLeft(double totalPayableLeft) {
		this.totalPayableLeft = totalPayableLeft;
	}
	
}
