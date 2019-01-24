package com.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crudapi.dao.CustomerDAO;
import com.springboot.crudapi.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerDAO customerDAO;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findByCustomerId(long customerId) {

		return customerDAO.findByCustomerId(customerId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {

		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteByCustomerId(long customerId) {

		customerDAO.deleteByCustomerId(customerId);
	}

}
