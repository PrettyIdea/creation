package service;

import java.sql.SQLException;

import dao.CustomerDao;
import entity.Customer;

/**
 * customerµÄÒµÎñÂß¼­bean
 * @author DELL
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao(); 
	
	public void update(String password,String real_name,String email) throws SQLException {
		this.customerDao.update(password,real_name,email);
	}

	public void save(Customer customer) throws SQLException {
		this.customerDao.save(customer);
	}

	public boolean check(String name, String password) {
		Customer customer = null;
		try {
			customer = this.customerDao.findByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(customer != null && customer.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
		
	}

	public String findPassword(String name, String question, String answer) throws SQLException {
		return this.customerDao.findPassword(name, question, answer);
	}
}