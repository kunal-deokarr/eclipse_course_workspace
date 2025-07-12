package com.kafka.producer.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.main.service.KafkaService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;
	
	
	@PostMapping("/produce")
	public ResponseEntity<?> messageService(@RequestBody String message)
	{
		kafkaService.sendMessage(message);
		return ResponseEntity.ok(Map.of("Message", message));
	}
	
}
