package com.application.company.kafka.consumers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.application.company.kafka.producers.CustomerGetAllOutProducer;
import com.application.company.model.Customer;
import com.application.company.service.CustomerManagerService;
import com.google.gson.Gson;

@Component
class CustomerGetAllInConsumer {
	@Autowired
	private CustomerManagerService customerManagerService;
	
	@Autowired
	private CustomerGetAllOutProducer customerGetAllOutProducer;

    @KafkaListener(topics = "${cloudkarafka.customer.getall.in.topic}")
    public void processMessage(String message,@Header("request_id") String request_id) {
    	
    	if("12345".equals(request_id)) {
    		System.out.println("Consumed Message With request_id:12345 -> "+ message);
    		List<Customer> customers=customerManagerService.getAllCustomers();
    		 String jsonCustomers = new Gson().toJson(customers);
    		customerGetAllOutProducer.send(jsonCustomers);
    	}else {
    		System.out.println("Consumed Message Without request_id:12345 -> "+ message);
    	}
        
    }

}
