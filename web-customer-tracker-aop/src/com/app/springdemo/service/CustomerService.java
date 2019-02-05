package com.app.springdemo.service;
import java.util.List;

import com.app.springdemo.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int customerId);

	public void deleteCustomer(int theId);

	public List<Customer> findCustomer(String customer);

}
