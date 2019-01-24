package com.springboot.crudapi.service;

import java.util.List;

import com.springboot.crudapi.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findByCustomerId(long customerId);
	
	public void save(Customer theCustomer);
	
	public void deleteByCustomerId(long customerId);

}
