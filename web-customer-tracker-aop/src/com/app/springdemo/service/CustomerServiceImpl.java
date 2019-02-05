package com.app.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springdemo.dao.CustomerDAO;
import com.app.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
	
		
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Transactional
	@Override
	public Customer getCustomer(int customerId) {
		Customer customer=customerDAO.getCustomer(customerId);
		
		return customer;
	}

	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> findCustomer(String customer) {
		
		return customerDAO.findCustomer(customer);
	}

}
