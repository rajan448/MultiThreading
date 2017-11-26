package com.app.ex;

import java.util.concurrent.TimeUnit;

public class ThreadJoiningEx {

	public static void main(String[] args) {

		Runnable tnrTask = () -> {

			System.out.println("Finding solution.");
			try {
				TimeUnit.SECONDS.sleep(10); // will take 10 s to provide solution
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Here is your solution ");

		};

		Runnable studentTask = () -> {
			System.out.println("Doing work...");
			System.out.println("Got doubt");
			Thread tnrThread = new Thread(tnrTask);

			tnrThread.start();
			try {
				tnrThread.join(5000); // Wait for tnrThread for 5 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thanks for the solution");

		};

		Thread studentThread = new Thread(studentTask);
		studentThread.start();

	}

}
