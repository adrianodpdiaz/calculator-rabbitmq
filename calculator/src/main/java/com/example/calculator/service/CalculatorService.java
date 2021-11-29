package com.example.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public BigDecimal sum(Double a, Double b) {
		return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
	}
	
	public BigDecimal subtract(Double a, Double b) {
		return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
	}
	
	public BigDecimal multiply(Double a, Double b) {
		return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
	}
	
	public BigDecimal divide(Double a, Double b) {
		return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
	}

}
