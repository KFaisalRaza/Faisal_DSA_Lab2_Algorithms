package com.paymoney.dailytarget;
/**
 * Driver class to run the paymoney application
 */
public class Main {
	public void init(DailyTargetDeterminator dailyTargetDeterminator) {
		dailyTargetDeterminator.collectTransactionValues();
		dailyTargetDeterminator.collectDailyTargets();
		dailyTargetDeterminator.determine();
	}

	public static void main(String[] args) {
		Main obj1 = new Main();
		DailyTargetDeterminator obj2 = new DailyTargetDeterminator();
		obj1.init(obj2);
	}
}
