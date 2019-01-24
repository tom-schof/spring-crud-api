package com.springboot.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.crudapi.entity.Customer;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public CustomerDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Customer> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//execute the query and get result list
		List<Customer> employees = theQuery.getResultList();
		
		//return the results
		
		return employees;
	}

	@Override
	public Customer findByCustomerId(long customerId) {
		
		//get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the customer
		Customer theCustomer = currentSession.get(Customer.class, customerId);
		
		// return customer
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(theCustomer);
		
	
		
		
	}

	@Override
	public void deleteByCustomerId(long customerId) {

		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete the object by primary key
		Query<?> theQuery = currentSession.createQuery("delete from Customer where CUSTOMER_ID=" + customerId);
	
		
		theQuery.executeUpdate();
		
	}

	

}
