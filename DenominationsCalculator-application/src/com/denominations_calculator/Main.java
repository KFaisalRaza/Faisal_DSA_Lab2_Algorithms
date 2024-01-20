package com.denominations_calculator;

/**
 * Driver class to run the application
 */
public class Main {

	public static void main(String[] args) {
		DenominationsCalculator calculator = new DenominationsCalculator();

		calculator.collectDenominations();
		calculator.collectPaymentAmount();
		calculator.calculate();
	}
}