package com.kafka.consumer.main.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerConfig.class);

	@KafkaListener(topics = "myTopic", groupId = "myGroup")
	public void getMessage(String message)
	{
		log.info(String.format("Message Received -> %s", message));
	}
}
