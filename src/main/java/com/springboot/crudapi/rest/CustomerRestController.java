package com.springboot.crudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapi.entity.Customer;
import com.springboot.crudapi.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		this.customerService = theCustomerService;
	}
	
	//get All customer
	@GetMapping("/customers")
	public List<Customer> findAll() {
		
		return customerService.findAll();
	}
	
	
	//returns a single customer by Id
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable long customerId) throws RuntimeException {
		Customer theCustomer = customerService.findByCustomerId(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}
		
		return theCustomer;
	}
	
	// Add a new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//also just in case they pass an id in JSON ...set id to 0
		// this is to force a save of new item
		
		
//		theCustomer.setCustomerId((long) 0);
	
		customerService.save(theCustomer);
		
		return theCustomer;	
	}
	
	//add mapping for PUT /customer - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	
	//deletes a single customer by Id
		@DeleteMapping("/customers/{customerId}")
		public String deleteCustomer(@PathVariable long customerId) throws RuntimeException {
			Customer theCustomer = customerService.findByCustomerId(customerId);
			
			if (theCustomer == null) {
				throw new CustomerNotFoundException("Customer id not found: " + customerId);
			}
			
			customerService.deleteByCustomerId(customerId);
			
			
			return "Deleted customer id : " + customerId;
		}
	
}
