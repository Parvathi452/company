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
class CustomerGetAllOutConsumer {
	@Autowired
	private CustomerManagerService customerManagerService;
	
	@Autowired
	private CustomerGetAllOutProducer customerGetAllOutProducer;

    @KafkaListener(topics = "${cloudkarafka.customer.getall.out.topic}")
    public void processMessage(String message) {
    	
    	System.out.println("List of Customers -> "+ message);
        
    }

}
