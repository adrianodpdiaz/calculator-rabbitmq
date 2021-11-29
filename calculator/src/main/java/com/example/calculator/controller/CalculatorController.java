package com.example.calculator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import consts.RabbitMQConsts;
import dto.ResultDTO;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.service.RabbitMQService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculator;
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@GetMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultDTO> sum(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		ResultDTO result = new ResultDTO(calculator.sum(a, b));
		rabbitMQService.sendMessage(RabbitMQConsts.CALCULATIONS_QUEUE.getValue(), result);
		System.out.println(result.getResult());
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/subtract", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultDTO> subtract(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new ResultDTO(calculator.subtract(a, b)));
	}
	
	@GetMapping(value = "/multiply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultDTO> multiply(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new ResultDTO(calculator.multiply(a, b)));
	}

	@GetMapping(value = "/divide", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultDTO> divide(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new ResultDTO(calculator.divide(a, b)));
	}

}
