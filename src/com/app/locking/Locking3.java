package com.app.locking;

import java.util.concurrent.TimeUnit;

public class Locking3 {

	public static void printMessage(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}

	private static class Counter {
		private int count1 = 0;
		private int count2 = 0;

		Object key = new Object(); // Common key

		Object boyKey = new Object(); // Separate key for selective locking
		Object girlKey = new Object();

		public void increment1() {

			synchronized (boyKey) {

				printMessage("Incrementing counter 1");
				this.setCount1(this.getCount1() + 1);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printMessage("Done counter 1");
			}
		}

		public void increment2() {
			synchronized (girlKey) {

				printMessage("Incrementing counter 2");
				this.setCount2(this.getCount2() + 1);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printMessage("Done counter 2");
			}
		}

		public int getCount2() {
			return count2;
		}

		public void setCount2(int count2) {
			this.count2 = count2;
		}

		public int getCount1() {
			return count1;
		}

		public void setCount1(int count1) {
			this.count1 = count1;
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
