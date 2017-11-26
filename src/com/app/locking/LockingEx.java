package com.app.locking;

import java.util.concurrent.TimeUnit;

public class LockingEx {

	public static void printMessage(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}

	private static class Building {
		public synchronized void room1() {
			printMessage("Entering Room-1");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printMessage("Exting Room-1");

		}

		public synchronized void room2() {
			printMessage("Entering Room-2");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printMessage("Exting Room-2");

		}
	}

	public static void main(String[] args) {

		Building b1 = new Building();
		Building b2 = new Building();

		Runnable r1 = () -> {
			b1.room1();
		};

		Runnable r2 = () -> {
			b1.room2();
		};

		Thread t1 = new Thread(r1, "Person1");
		Thread t2 = new Thread(r2, "Person2");

		t1.start();
		t2.start();
	}

}
