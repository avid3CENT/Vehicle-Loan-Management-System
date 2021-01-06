package lti.vehicleloan.dao;

import java.sql.ResultSet;

import lti.vehicleloan.entity.Application;

public interface StatusInterface {
	int addStatus(Application app);
	ResultSet viewStatus();
	ResultSet searchStatus(int appId);
	boolean checkStatus(int appId);
	ResultSet searchStatusfromCus(int cusId);
	double emiFromLoan(int appId);
	int emiPaid(int appId,int cusId);
}
