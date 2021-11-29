package com.example.calculator.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ResultDTO;

@Service
public class RabbitMQService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String queueName, ResultDTO message) {
		this.rabbitTemplate.convertAndSend(queueName, message);
	}

}
