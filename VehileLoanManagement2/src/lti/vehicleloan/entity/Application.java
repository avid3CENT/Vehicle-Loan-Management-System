package lti.vehicleloan.entity;

public class Application {
	private int appId;
	private int cusId;
	private String cusName;
	private int loanId;
	private String loanName;
	private String loanType;
	private double principal;
	private double rate;
	private int month;
	private String status;
	private String carName;
	private String carType;
	private double loanDownpay;
	public Application(int appId, int cusId, String cusName, int loanId, String loanName,
			double principal, double rate, int month, String status,String carName,String carType, double loanDownpay) {
		super();
		this.appId = appId;
		this.cusId = cusId;
		this.cusName = cusName;
		this.loanId = loanId;
		this.loanName = loanName;
		this.principal = principal;
		this.rate = rate;
		this.month = month;
		this.status = status;
		this.carName = carName;
		this.carType = carType;
		this.loanDownpay= loanDownpay;
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
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
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
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public double getLoanDownpay() {
		return loanDownpay;
	}
	public void setLoanDownpay(double loanDownpay) {
		this.loanDownpay = loanDownpay;
	}

}
