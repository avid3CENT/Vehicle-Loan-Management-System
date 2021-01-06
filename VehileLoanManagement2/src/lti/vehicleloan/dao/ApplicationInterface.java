package lti.vehicleloan.dao;

import java.sql.ResultSet;
import java.util.List;

import lti.vehicleloan.entity.Application;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.Loan;

public interface ApplicationInterface {
	int addApplication(Customer customer,Loan loan,double principle,double rate,int month,String car_name);
	ResultSet viewApplication();
	List<Application> searchApplication(Customer c);
	ResultSet customerSearchApplication(Customer c);
	ResultSet managerViewApplication();
	ResultSet managerPendingApplication();
	ResultSet managerApprovedApplication();
	ResultSet managerShowParticularApplication(int appId);
	boolean managerSearchApplication(int appId);
	int managerCusfromApplicant(int appId);
	List<Application> searchApplication(int appId);
	boolean chechIfApproved(int appID);
	int checkEligibility(int appId);
	int appIdfromCusId(int cId);
}
