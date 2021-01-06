package lti.vehicleloan.entity;

public class Employee {
	private int empNo;
	private String empName;
	private String empUsername;
	private String empPassword;
	private String empJob;
	public Employee(int empNo, String empName, String empUsername, String empPassword, String empJob) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empJob = empJob;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpUsername() {
		return empUsername;
	}
	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	
}
