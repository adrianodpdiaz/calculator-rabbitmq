package com.example.calculator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.controller.dto.Result;
import com.example.calculator.service.Calculator;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> sum(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new Result(calculator.sum(a, b)));
	}
	
	@GetMapping(value = "/subtract", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> subtract(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new Result(calculator.subtract(a, b)));
	}
	
	@GetMapping(value = "/multiply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> multiply(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new Result(calculator.multiply(a, b)));
	}

	@GetMapping(value = "/divide", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> divide(
			@RequestParam @Valid Double a, @RequestParam @Valid Double b) {
		return ResponseEntity.ok(new Result(calculator.divide(a, b)));
	}

}
