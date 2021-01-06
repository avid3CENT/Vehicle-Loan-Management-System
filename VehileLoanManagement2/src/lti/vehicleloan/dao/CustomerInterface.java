package lti.vehicleloan.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import lti.vehicleloan.entity.Address;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.CustomerExtra;

public interface CustomerInterface {
	List<Customer> CustomerLogIn(String username,String password);
	int CustomerFillInfo(int Cid, String some,int choice);
	boolean checkUsername(String username);
	int CustomerAddAddress(int i,Address address,int choice);
	boolean checkAddressPresent(int cid);
	int checkCustomerDetails(int cid);
	ResultSet customerDetails(int cusId);
	ResultSet viewAllCustomer();
	ResultSet viewAddress(int cusId);
	boolean checkCustomer(int cusId);
	int CustomerFinalRegister(Customer customer,CustomerExtra customerExtra);
	String getSQuesFromUser(int Cid);
	int getCusIdfromUser(String username);
	boolean checkQuesAns(String ques, String answer);
	int changePassword(String username, String password);
	Date checkDateDiff(int cId);
	double customerAge(int cid);
	double lastemidays(int cid);
	double salaryfromCusId(int cus_id);
}
