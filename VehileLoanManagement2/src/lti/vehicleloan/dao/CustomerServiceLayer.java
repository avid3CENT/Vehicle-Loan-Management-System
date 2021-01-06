package lti.vehicleloan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import lti.vehicleloan.dbconnection.DbConnection;
import lti.vehicleloan.entity.Address;
import lti.vehicleloan.entity.Customer;
import lti.vehicleloan.entity.CustomerExtra;

public class CustomerServiceLayer implements CustomerInterface{
	DbConnection db = new DbConnection();
	Connection con;
	PreparedStatement ps = null;
	CallableStatement cs = null;
	Scanner scan = new Scanner(System.in);
	boolean isLogin;
	boolean isUser;
	boolean isAddress;
	boolean isCustomer;
	boolean isAnswer;
	int i,j,q,ret,cid;
	int get;
	int which;
	ResultSet res;
	ResultSet res1;
	ResultSet res2;
	ResultSet res3;
	ResultSet res4;
	private String ques;
	int q1;
	double age,days,salary;
	Date checkdate;


	public List<Customer> CustomerLogIn(String username, String password) {
		con = db.getConnection();
		List<Customer> cuslist = null;
		String str = "select * from customer where cus_username = ? and cus_password = ?";
		try {
			ps = con.prepareStatement(str);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet res = ps.executeQuery();
			cuslist = new LinkedList<Customer>();
			while(res.next()) {
				cuslist.add(new Customer(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cuslist;
	}
	public boolean checkUsername(String username) {
		con = db.getConnection();
		String check = "select * from customer where cus_username = ?";
		try {
			ps = con.prepareStatement(check);
			ps.setString(1, username);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				isUser = true;
			}else {
				isUser = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUser;
	}



	public int CustomerFillInfo(int Cid, String some,int choice) {
		con = db.getConnection();
		String str;

		try {
			/*
			 * 1. for aadhar update
			 */
			if(choice==1) {
				str = "{call updateaadhar(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}
			/*
			 * 2. for contact update
			 */
			else if(choice==2) {
				str = "{call updatecontact(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}
			/*
			 * 3. for bank account no update
			 */
			else if(choice==3) {
				str = "{call updatebankacc(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}
			/*
			 * 4. for salary update
			 */
			else if(choice==4) {
				str = "{call updatesal(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}/*
			 * 5. for PAN update
			 */
			else if(choice==5) {
				str = "{call updatepan(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();	
			}
			/*
			 * 6. for Occupation update
			 */
			else if(choice==6) {
				str = "{call updateocc(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}
			/*
			 * 7. for vehicle update
			 */
			else if(choice==7) {
				str = "{call updatevehicle(?,?)}";
				cs = con.prepareCall(str);
				cs.setInt(1,Cid);
				cs.setString(2,some);
				ret = cs.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	public int CustomerAddAddress(int cus_id, Address address,int choice) {
		con = db.getConnection();
		String addaddress;

		try {
			if(choice==1) {
				addaddress = "{call ADDCUSTOMERADDR(?,?,?,?,?,?,?)}";
				cs = con.prepareCall(addaddress);
				cs.setInt(1,cus_id);
				cs.setString(2, address.getHouseNo());
				cs.setString(3, address.getBuilding());
				cs.setString(4, address.getPlace());
				cs.setString(5, address.getCity());
				cs.setString(6, address.getState());
				cs.setString(7, address.getPincode());
				q = cs.executeUpdate();
			}
			else if(choice==2) {
				addaddress = "{call UPDATECUSTOMERADDR(?,?,?,?,?,?,?)}";
				cs = con.prepareCall(addaddress);
				cs.setInt(1,cus_id);
				cs.setString(2, address.getHouseNo());
				cs.setString(3, address.getBuilding());
				cs.setString(4, address.getPlace());
				cs.setString(5, address.getCity());
				cs.setString(6, address.getState());
				cs.setString(7, address.getPincode());
				q = cs.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return q;
	}

	public boolean checkAddressPresent(int cid) {
		con = db.getConnection();
		String checkadd = "select * from custaddress where cus_id = ?";
		try {
			ps = con.prepareStatement(checkadd);
			ps.setInt(1, cid );
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				isAddress = true;
			}else {
				isAddress = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isAddress;
	}

	public int checkCustomerDetails(int cid) {
		con = db.getConnection();
		String checkdetail = "select cus_aadhar,cus_bankacc,cus_pan,cus_vehicle,cus_occ,cus_salary from customer where cus_id = ?";
		try {
			ps = con.prepareStatement(checkdetail);
			ps.setInt(1, cid);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				if(res.getString(1)==null) {
					which = 1;
				}else if(res.getString(2)==null) {
					which = 2;
				}else if(res.getString(3)==null) {
					which = 3;
				}else if(res.getString(4)==null) {
					which = 4;
				}else if(res.getString(5)==null) {
					which = 5;
				}else if(res.getString(6)==null) {
					which = 6;
				}else {
					which = 7;
				}
			}else {
				which = 8;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return which;
	}
	public ResultSet customerDetails(int cusId) {
		con = db.getConnection();
		String check = "select * from customer where cus_id = ?";
		try {
			ps = con.prepareStatement(check);
			ps.setInt(1,cusId);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet viewAllCustomer() {
		con = db.getConnection();
		String all = "select cus_id,cus_name,cus_contact,cus_salary,cus_aadhar,cus_bankacc,cus_pan,cus_vehicle,cus_occ from customer";
		try {
			ps = con.prepareStatement(all);
			res = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}



	public ResultSet viewAddress(int cusId) {
		con = db.getConnection();
		String viewAddress = "select * from custaddress where cus_id = ?";
		try {
			ps = con.prepareStatement(viewAddress);
			ps.setInt(1, cusId);
			res3 = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res3;
	}



	public boolean checkCustomer(int cusId) {
		con = db.getConnection();
		String check = "select * from customer where cus_id = ?";
		try {
			ps = con.prepareStatement(check);
			ps.setInt(1, cusId);
			res2 = ps.executeQuery();
			if(res2.next()) {
				isCustomer = true;
			}else {
				isCustomer = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return isCustomer;
	}

	public int CustomerFinalRegister(Customer customer, CustomerExtra customerExtra) {
		con = db.getConnection();
		String register = "{call ADDCUSTOMER(?,?,?,?,?,?,?,?,?) }";
		try {
			cs = con.prepareCall(register);
			cs.setString(1, customer.getCusName());
			cs.setString(2, customer.getCusContact());
			cs.setDouble(3, customer.getCusSalary());
			cs.setString(4, customer.getOccupation());
			cs.setString(5, customer.getCusUsername());
			cs.setString(6,customer.getCusPass());
			java.sql.Date sqlDate = new java.sql.Date( customerExtra.getDob().getTime() );
			cs.setDate(7, sqlDate);
			cs.setString(8, customerExtra.getSecQuestion());
			cs.setString(9, customerExtra.getSecAnswer());
			get = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return get;
	}
	
	public String getSQuesFromUser(int CId) {
		con = db.getConnection();
		String getq = "select cus_ques from customerextra where cus_id = ?";
		try {
			ps = con.prepareStatement(getq);
			ps.setInt(1, CId);
			res = ps.executeQuery();
			if(res.next()) {
				ques = res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ques;
	}
	
	
	public int getCusIdfromUser(String username) {
		con = db.getConnection();
		String getCid = "select cus_id from customer where cus_username = ?";
		try {
			ps = con.prepareStatement(getCid);
			ps.setString(1, username);
			res1 = ps.executeQuery();
			if(res1.next()) {
				cid = res1.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return cid;
	}
	
	public boolean checkQuesAns(String ques, String answer) {
		con = db.getConnection();
		String getAnswer = "select cus_answer from customerextra where cus_ques = ?";
		try {
			ps = con.prepareStatement(getAnswer);
			ps.setString(1, ques);
			res3 = ps.executeQuery();
			if(res3.next()) {
				if(res3.getString(1).equalsIgnoreCase(answer)) {
					isAnswer = true;
				}else {
					isAnswer = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAnswer;
	}
	
	public int changePassword(String username, String password) {
		con = db.getConnection();
		String change = "update customer set cus_password = ? where cus_username = ?";
		
		try {
			ps = con.prepareStatement(change);
			ps.setString(1, password);
			ps.setString(2, username);
			q1 = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return q1;
	}

	public Date checkDateDiff(int cId) {
		con = db.getConnection();
		String checkDate = "select cus_last_emi_paydate from customerextra where cus_id = ?";
		try {
			ps = con.prepareStatement(checkDate);
			ps.setInt(1, cId);
			res4 = ps.executeQuery();
			if(res4.next()) {
				checkdate = res4.getDate(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return checkdate;
	}
	
	public double customerAge(int cid) {
		con = db.getConnection();
		String ages = "select (months_between(sysdate,cus_dob)/12) from customerextra where cus_id =?";
		try {
			ps = con.prepareStatement(ages);
			ps.setInt(1, cid);
			res = ps.executeQuery();
			if(res.next()) {
				age = res.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return age;
	}
	
	public double lastemidays(int cid) {
		con = db.getConnection();
		String ages = "select (months_between(sysdate,cus_last_emi_paydate)) from customerextra where cus_id =?";
		try {
			ps = con.prepareStatement(ages);
			ps.setInt(1, cid);
			res = ps.executeQuery();
			if(res.next()) {
				days = res.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return days;
	}

	public double salaryfromCusId(int cus_id) {
		con = db.getConnection();
		String ages = "select cus_salary from customer where cus_id =?";
		try {
			ps = con.prepareStatement(ages);
			ps.setInt(1, cus_id);
			res3 = ps.executeQuery();
			if(res3.next()) {
				salary = res3.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salary;
	}

}







