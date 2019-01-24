package com.springboot.crudapi.dao;

import java.util.List;

import com.springboot.crudapi.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();
	
	public Customer findByCustomerId(long customerId);
	
	public void save(Customer theCustomer);
	
	public void deleteByCustomerId(long customerId);
	
}
