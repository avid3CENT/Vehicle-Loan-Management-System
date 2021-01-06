package lti.vehicleloan.entity;

import java.util.Date;

public class CustomerExtra {
	private int cusId;
	private Date dob;
	private Date lastPaidEmi;
	private String secQuestion;
	private String secAnswer;
	public CustomerExtra(int cusId, Date dob, String secQuestion, String secAnswer) {
		super();
		this.cusId = cusId;
		this.dob = dob;
		this.secQuestion = secQuestion;
		this.secAnswer = secAnswer;
	}
	public CustomerExtra(Date dob, String secQuestion, String secAnswer) {
		super();
		this.dob = dob;
		this.secQuestion = secQuestion;
		this.secAnswer = secAnswer;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getLastPaidEmi() {
		return lastPaidEmi;
	}
	public void setLastPaidEmi(Date lastPaidEmi) {
		this.lastPaidEmi = lastPaidEmi;
	}
	public String getSecQuestion() {
		return secQuestion;
	}
	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}
	public String getSecAnswer() {
		return secAnswer;
	}
	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}
}
