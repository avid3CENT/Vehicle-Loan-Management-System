package lti.vehicleloan.dao;

import java.sql.ResultSet;
import java.util.List;
import lti.vehicleloan.entity.Loan;

interface LoanInterface {
	int addLoan(Loan loan);
	ResultSet viewLoan();
	List<Loan> searchLoan(int loanId);
	double CalculateEMI(double principal,double rate,int month);
	double TotalAmountPayable(double principal,double rate,int month);
	int checkLoanEligibiltyNewCar(double principal, double costOfCar);
	Loan searchLoanOnLoanType(String loanType);
	ResultSet viewLoan(int loanId);
	boolean isLoan(int loanId);
	Loan searchLoanOnLoanId(int loanId);
	int UpdateLoan(int loanId, String some,int choice);
	int checkLoanEligibiltyPreOwnedCar(double principal, double costOfCar);
}
