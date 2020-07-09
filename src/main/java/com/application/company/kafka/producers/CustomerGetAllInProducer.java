package com.application.company.kafka.producers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerGetAllInProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Value("${cloudkarafka.customer.getall.in.topic}")
    private String topic;

    CustomerGetAllInProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
    	Message<String> message1 = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)               
                .setHeader("request_id", "12345")
                .build();
    	
        this.kafkaTemplate.send(message1);
        System.out.println("Sent sample message [" + message + "] to " + topic);
    }

}
