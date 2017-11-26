package com.app.ex;

class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Doing task 1");
	}

}

class Task2 extends Thread {

	@Override
	public void run() {
		System.out.println("Doing task 2");

	}

}

public class CreatingThread {

	public static void main(String[] args) {

		// Thread Creation using Runnable Instance
		Thread t1 = new Thread(new Task1());
		t1.start();

		// Thread creation using extending Thread

		Thread t2 = new Thread();
		// t2.run();
		t2.start();

	}

}
