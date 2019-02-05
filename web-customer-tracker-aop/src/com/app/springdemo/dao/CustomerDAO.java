package com.app.springdemo.dao;

import java.util.List;

import com.app.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int theId);

	public List<Customer> findCustomer(String customer);


}
