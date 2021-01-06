package lti.vehicleloan.dao;

import java.util.List;
import lti.vehicleloan.entity.Employee;

public interface EmployeeInterface {
	List<Employee> EmployeeLogIn (String username, String password);
}
