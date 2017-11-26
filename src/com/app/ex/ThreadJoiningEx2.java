package com.app.ex;

public class ThreadJoiningEx2 {

	public static void main(String[] args) {

		// --------------------------------------------------
		Runnable task = () -> {
			printMessage("Child Counting");
			// Count till 100; return if interrupted
			for (int i = 1; i <= 1000; i++) {
				printMessage(new Integer(i).toString());

				if (Thread.interrupted()) {
					printMessage("Interrupted");
					return;
				}
				// try {
				// TimeUnit.MILLISECONDS.sleep(200);
				// } catch (InterruptedException e) {
				// printMessage("Interrupted");
				// }
			}
			printMessage("Counting ends..");
		};

		// ----------------------------------------------------
		Thread childThread = new Thread(task, "Child");
		childThread.start();

		try {
			childThread.join(1);
			if (childThread.isAlive()) {
				System.out.println("Still Waiting");

				childThread.interrupt();
			}
		} catch (InterruptedException e) {
			printMessage("Interrupted");
		}
		printMessage("OK Good");
	}

	public static void printMessage(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}
}
