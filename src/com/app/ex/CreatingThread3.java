package com.app.ex;

import java.util.stream.IntStream;

public class CreatingThread3 {

	private static int count;

	public static void main(String[] args) {

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				count += 1;
			}
		};

		Thread[] threads = new Thread[1000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(task);
			threads[i].start();

			// try {
			// threads[i].join();
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
		System.out.println(count); // Count wont be as expected

		// Counting threads that are still alive
		int[] aliveStatus = new int[threads.length];
		for (int i = 0; i < threads.length; i++) {
			if (threads[i].isAlive()) {
				aliveStatus[i] = 1;
			}
			else
				aliveStatus[i] = 0;
		}

		System.out.println("Threads still counting: " + IntStream.of(aliveStatus).sum());
		System.out.println(count);

	}

}
