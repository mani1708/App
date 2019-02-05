package com.app.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//execute query and get resultset
		List<Customer> customers=theQuery.getResultList();
		
		
		//resturn results		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	}


	public Customer getCustomer(int customerId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Customer customer=currentSession.get(Customer.class, customerId);
		
		return customer;
	}


	@Override
	public void deleteCustomer(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		
		query.executeUpdate();

		
	}


	@Override
	public List<Customer> findCustomer(String customer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query query=null;
		if(!customer.isEmpty() && customer.trim().length()>0) {
		query=currentSession.createQuery("from Customer where firstName like:custName",Customer.class);
		query.setParameter("custName","%" +customer+ "%");
		
		}
		else {
			query=currentSession.createQuery("from Customer order by lastName",Customer.class);
		}
		
		List<Customer> customers=query.getResultList();
		
		return customers;
	}

}
