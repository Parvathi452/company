package com.application.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.company.model.Customer;
import com.application.company.repo.CustomerRepository;

@Service
public class CustomerManagerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomer(String id) {
		return customerRepository.findById(id);
	}
	
	public Customer registerCustomer(Customer customer){
		return customerRepository.insert(customer);
	}
	
	public Customer updateCustomerInfo(Customer customer) throws Exception{
		if(customerRepository.findById(customer.getId()).isPresent())
		return customerRepository.save(customer);
		else
			throw new Exception("No Valid customer Found");
	}

}
