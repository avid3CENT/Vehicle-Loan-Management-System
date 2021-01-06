package lti.vehicleloan.entity;

public class Customer {
	private int cusId;
	private String cusName;
	private String cusContact;
	private Double cusSalary;
	private String CusUsername;
	private String CusPass;
	private String cusBankAcc;
	private String cusAadhar;
	private String cusPan;
	private String occupation;
	private Address address;
	private String cusVehicle;
	
	/*
	 * public Customer(int cusId, Double cusSalary) { super(); this.cusId = cusId;
	 * this.cusSalary = cusSalary; }
	 * 
	 * public Customer(int cusId, String cusContact) { super(); this.cusId = cusId;
	 * this.cusAadhar = cusContact; this.cusAadhar = cusContact; this.cusAadhar =
	 * cusContact; this.cusContact = cusContact; this.cusAadhar = cusContact; }
	 */

	public Customer(int cusId, String cusName, String cusContact, Double cusSalary,	String occupation, String cusBankAcc, String cusAadhar, String cusPan) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.cusSalary = cusSalary;
		this.cusBankAcc = cusBankAcc;
		this.cusAadhar = cusAadhar;
		this.cusPan = cusPan;
		this.occupation=occupation;
	}
	
	public Customer(int cusId, String cusName, String cusContact, Double cusSalary,	String cusBankAcc, String cusAadhar, String cusPan) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.cusSalary = cusSalary;
		this.cusBankAcc = cusBankAcc;
		this.cusAadhar = cusAadhar;
		this.cusPan = cusPan;
	}
	public Customer(String cusName, String cusContact, Double cusSalary,String occupation, String cusUsername, String cusPass) {
		super();
		
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.cusSalary = cusSalary;
		this.occupation = occupation;
		this.CusUsername = cusUsername;
		this.CusPass = cusPass;
	}
	
	public Customer(int cusId, String cusName, String cusContact, Double cusSalary, String cusUsername, String cusPass,
			String cusBankAcc, String cusAadhar, String cusPan,String occupation) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.cusSalary = cusSalary;
		CusUsername = cusUsername;
		CusPass = cusPass;
		this.cusBankAcc = cusBankAcc;
		this.cusAadhar = cusAadhar;
		this.cusPan = cusPan;
		this.occupation = occupation;
		
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
	public String getCusContact() {
		return cusContact;
	}
	public void setCusContact(String cusContact) {
		this.cusContact = cusContact;
	}
	public Double getCusSalary() {
		return cusSalary;
	}
	public void setCusSalary(Double cusSalary) {
		this.cusSalary = cusSalary;
	}
	public String getCusUsername() {
		return CusUsername;
	}
	public void setCusUsername(String cusUsername) {
		CusUsername = cusUsername;
	}
	public String getCusPass() {
		return CusPass;
	}
	public void setCusPass(String cusPass) {
		CusPass = cusPass;
	}
	public String getCusBankAcc() {
		return cusBankAcc;
	}
	public void setCusBankAcc(String cusBankAcc) {
		this.cusBankAcc = cusBankAcc;
	}
	public String getCusAadhar() {
		return cusAadhar;
	}
	public void setCusAadhar(String cusAadhar) {
		this.cusAadhar = cusAadhar;
	}
	public String getCusPan() {
		return cusPan;
	}
	public void setCusPan(String cusPan) {
		this.cusPan = cusPan;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean checkUsername(String username) {
		if(this.CusUsername.equals(username)) {
			return false;
		}else {
			return true;
		}
	}

	public String getCusVehicle() {
		return cusVehicle;
	}

	public void setCusVehicle(String cusVehicle) {
		this.cusVehicle = cusVehicle;
	}
}
