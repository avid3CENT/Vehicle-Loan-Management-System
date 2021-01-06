package lti.vehicleloan.entity;

public class Address {
	private int cusId;
	private String houseNo;
	private String building;
	private String place;
	private String city;
	private String state;
	private String pincode;
	
	public Address(int cusId, String houseNo, String building, String place, String city, String state,
			String pincode) {
		super();
		this.cusId = cusId;
		this.houseNo = houseNo;
		this.building = building;
		this.place = place;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
