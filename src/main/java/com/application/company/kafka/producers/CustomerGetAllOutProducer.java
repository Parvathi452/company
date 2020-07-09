package com.application.company.kafka.producers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerGetAllOutProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Value("${cloudkarafka.customer.getall.out.topic}")
    private String topic;

    CustomerGetAllOutProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
    	Message<String> message1 = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
    	
        this.kafkaTemplate.send(message1);
        System.out.println("Sent sample message [" + message + "] to " + topic);
    }

}
