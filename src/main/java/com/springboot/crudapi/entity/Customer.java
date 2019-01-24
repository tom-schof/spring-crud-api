package com.springboot.crudapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="customer")
public class Customer {

	//define fields
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="CUSTOMER_ID")
	private Long customerId;

	@Column(name = "CUSTOMER_INFO_GUID")
	private String customer_info_guid;

	@Column(name = "FIRST_NAME")
	private String first_name;

	@Column(name = "LAST_NAME")
	private String last_name;

	@Column(name = "PHONE_NUMBER")
	private String phone_number;

	@Column(name = "STREET_ADDRESS")
	private String street_address;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP")
	private String zip;

	//default constructor
	public Customer() {
	}

	//getters and setters
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomer_info_guid() {
		return customer_info_guid;
	}

	public void setCustomer_info_guid(String customer_info_guid) {
		this.customer_info_guid = customer_info_guid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	
	//toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customer_info_guid=" + customer_info_guid + ", first_name="
				+ first_name + ", last_name=" + last_name + ", phone_number=" + phone_number + ", street_address="
				+ street_address + ", state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}
	
}
