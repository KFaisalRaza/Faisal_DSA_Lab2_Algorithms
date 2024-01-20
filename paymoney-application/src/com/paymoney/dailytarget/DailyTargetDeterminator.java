package com.paymoney.dailytarget;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains the implementation logic of application.
 */

public class DailyTargetDeterminator {
	private Integer[] transactionsList;

	private Integer[] dailyTargets;

	private Scanner input;

	public DailyTargetDeterminator() {
		input = new Scanner(System.in);
	}

	void collectTransactionValues() {
		System.out.println("Enter the Transactions-List Size");
		Integer transactionsListSize = input.nextInt();
		transactionsList = new Integer[transactionsListSize];

		for (int index = 0; index < transactionsListSize; index++) {
			System.out.printf("Transaction Value : %d / %d", (index + 1), transactionsListSize);
			System.out.println();
			transactionsList[index] = input.nextInt();
		}

	}

	void collectDailyTarget() {

		System.out.println("Enter the size of daily target list.");
		int size = input.nextInt();
		dailyTargets = new Integer[size];
		System.out.println("Enter daily targets");
		for (int i = 0; i < dailyTargets.length; i++) {
			dailyTargets[i] = input.nextInt();
			if (i == dailyTargets.length - 1)
				System.out.println("Daily target " + (i + 1) + " entered.");
			else
				System.out.println("Daily target " + (i + 1) + " entered." + "Enter next value.");
		}
	}

	void collectDailyTargets() {
		System.out.println("Enter the Total No Of Daily Targets that need to be verified");
		Integer totalNoOfDailyTargets = input.nextInt();
		this.dailyTargets = new Integer[totalNoOfDailyTargets];

		for (int index = 0; index < totalNoOfDailyTargets; index++) {
			System.out.printf("Daily Target : %d / %d", (index + 1), totalNoOfDailyTargets);
			System.out.println();
			this.dailyTargets[index] = input.nextInt();
		}
	}

	void determine() {
		for (int index = 0; index < dailyTargets.length; index++) {
			System.out.println("----------------------------------------");
			Integer dailyTarget = dailyTargets[index];
			System.out.printf("Performing Check for the TransactionsList %s and for the Daily Target %d",
					Arrays.toString(transactionsList), dailyTarget);
			System.out.println();
			determine(dailyTarget);
		}
	}

	void determine(Integer dailyTarget) {
		boolean dailyTargetAchieved = false;
		Integer overallSumOfTransactionValues = 0;
		int transactionInstancesCounter = 0;

		for (int index = 0; index < transactionsList.length; index++) {
			transactionInstancesCounter++;
			Integer trasactionValue = transactionsList[index];
			overallSumOfTransactionValues = overallSumOfTransactionValues + trasactionValue;
			if (overallSumOfTransactionValues >= dailyTarget) {
				dailyTargetAchieved = true;
				break;
			}
		}

		if (dailyTargetAchieved) {
			System.out.printf("Target achieved after %d transactions.", transactionInstancesCounter);
			System.out.println();

		} else {
			System.out.println("Given target is not achieved.");
		}
	}
}