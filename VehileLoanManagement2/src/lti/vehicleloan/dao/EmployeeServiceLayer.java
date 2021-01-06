package lti.vehicleloan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import lti.vehicleloan.dbconnection.DbConnection;
import lti.vehicleloan.entity.*;

public class EmployeeServiceLayer implements EmployeeInterface {
	DbConnection db = new DbConnection();
	Connection con;
	PreparedStatement ps = null;
	
	Scanner scan = new Scanner(System.in);
	
	
	public List<Employee> EmployeeLogIn(String username, String password) {

		con = db.getConnection();
		List<Employee> emplist = null;
		String login = "select * from employee where emp_username = ? and emp_password = ?";
		try {
			ps = con.prepareStatement(login);
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet res = ps.executeQuery();
	
			emplist = new LinkedList<Employee>();
			
			  while(res.next()) 
			  { emplist.add(new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
			
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
		return emplist;
	}
}
