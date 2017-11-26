package com.app.locking;

import java.util.concurrent.TimeUnit;

public class Locking2 {

	public static void printMessage(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}
	private static class Counter {
		private int count1 = 0;
		private int count2 = 0;

		public synchronized void increment1() {

			printMessage("Incrementing counter 1");
			this.count1 += 1;
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printMessage("Done counter 1");
		}

		public synchronized void increment2() {
			printMessage("Incrementing counter 2");
			this.count2 += 1;
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printMessage("Done counter 2");
		}
	}

	public static void main(String[] args) {
		Counter cnt = new Counter();

		Runnable inc1 = () -> {
			cnt.increment1();
		};

		Runnable inc2 = () -> {
			cnt.increment2();
		};
		Thread t1 = new Thread(inc1, "Boys");
		Thread t2 = new Thread(inc2, "Girls");

		t1.start();
		t2.start();
	}
}
