package com.kafka.producer.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	
	private static final Logger log = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void sendMessage(String message)
	{
		log.info(String.format("Message sent -> %s", message));
		kafkaTemplate.send("myTopic", message);
	}
	
	
	
	
}
