package com.example.calculator.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import consts.RabbitMQConsts;

@Component
public class RabbitMQConnection {
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	private Queue queue(String queueName) {
		return new Queue(queueName, true, false, false);
	}
	
	private DirectExchange directExchange() {
		return new DirectExchange(RabbitMQConsts.EXCHANGE_NAME.getValue());
	}
	
	private Binding relation(Queue queue, DirectExchange directExchange) {
		return new Binding(
				queue.getName(),
				Binding.DestinationType.QUEUE,
				directExchange.getName(),
				queue.getName(),
				null);
	}
	
	@PostConstruct
	private void add() {
		Queue calculationsQueue = this.queue(RabbitMQConsts.CALCULATIONS_QUEUE.getValue());
		DirectExchange directExchange = this.directExchange();
		Binding relation = this.relation(calculationsQueue, directExchange);
		
		this.amqpAdmin.declareQueue(calculationsQueue);
		this.amqpAdmin.declareExchange(directExchange);
		this.amqpAdmin.declareBinding(relation);
	}

}
