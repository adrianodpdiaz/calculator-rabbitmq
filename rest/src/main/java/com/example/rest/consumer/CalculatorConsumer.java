package com.example.rest.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import dto.ResultDTO;

@Component
public class CalculatorConsumer {
	
	@RabbitListener(queues = "CALCULATIONS")
	public void consumer(ResultDTO result) {
		System.out.println(result.getResult());
	}

}
