package com.application.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.company.kafka.producers.CustomerGetAllInProducer;
import com.application.company.model.Customer;
import com.application.company.service.CustomerManagerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerManagerService customerManagerService;
	
	@Autowired
	private CustomerGetAllInProducer producer;
	
	 @Value("${cloudkarafka.customer.getall.in.topic}")
	    private String topic;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerManagerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable String id){
		return customerManagerService.getCustomer(id);
	}
	
	@PostMapping("/customer")
	public String registerCustomer(@RequestBody Customer customer){
		customerManagerService.registerCustomer(customer);
		return "Customer Added with ID:"+customer.getId();
	}
	
	@PutMapping("/customer")
	public Customer updateCustomerInfo(@RequestBody Customer customer) throws Exception{
		return customerManagerService.updateCustomerInfo(customer);
	}
	
	@GetMapping("/kafka/customerintopic/{message}")
	public String kafkaCustomerInMessage(@PathVariable String message){
		
		producer.send(message);
		return "Message posted to Topic:"+topic ;
	}
	
	
	
	

}
