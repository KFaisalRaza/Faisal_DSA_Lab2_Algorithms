package com.denominations_calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class contains the implementation logic of denominations calculator
 * application
 */
public class DenominationsCalculator {

	private Integer[] denominations;
	private Integer paymentAmount;
	private Scanner input;
	private Integer balanceAmount;
	private Integer count;
	private boolean flag = true;

	public DenominationsCalculator() {
		input = new Scanner(System.in);
	}

	void collectDenominations() {
		System.out.println("Denominations : ");
		System.out.println("Enter the size of currency denominations");
		Integer denominationsSize = input.nextInt();
		denominations = new Integer[denominationsSize];

		System.out.println("Enter the currency denominations value");
		for (int index = 0; index < denominationsSize; index++) {
			System.out.printf("Denomination Value : %d / %d", (index + 1), denominationsSize);
			System.out.println();
			denominations[index] = input.nextInt();
		}
	}

	void collectPaymentAmount() {
		System.out.println("Enter the amount you want to pay.");
		paymentAmount = input.nextInt();
	}

	public void calculate() {
		Arrays.sort(denominations, Collections.reverseOrder());
		int i = 0;
		if (paymentAmount < denominations[denominations.length - 1])
			flag = false;
		if (flag == true)
			System.out.println("Your payment approach in order to give min no of notes will be");
		while (paymentAmount > 0) {
			if ((paymentAmount / denominations[i]) > 0) {
				count = paymentAmount / denominations[i];
				balanceAmount = paymentAmount % denominations[i];
				paymentAmount = balanceAmount;
				System.out.println(denominations[i] + ":" + count);
			} else if (i >= denominations.length - 1) {
				System.out.println("Cannot divide completely");
				balanceAmount = paymentAmount;
				System.out.println("Balance: " + balanceAmount);
				break;
			} else {
				i++;
			}
		}
	}
}
