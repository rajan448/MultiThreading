package com.app.ex;

public class SyncEx {

	private static class Counter {
		private int count;

		public int getCount() {
			return count;
		}

		public void decrement() {
			this.count -= 1;
		}

		public void increment() {
			this.count += 1;
		}
	}
	public static void main(String[] args) {
		
		Counter counter = new Counter();

		Runnable incrRun = ()->
		{
			for (int i = 0; i <= 100; i++)
				counter.increment();
		};

		Runnable decRun = () -> {
			for (int i = 0; i <= 100; i++) {
				counter.increment();
			}
		};

		Thread[] incThread = new Thread[100];
		Thread[] decThread = new Thread[100];
		for (int i = 0; i < 100; i++) {
			incThread[i] = new Thread(incrRun);
			decThread[i] = new Thread(decRun);

			incThread[i].start();
			// decThread[i].start();
		}

		for (int i = 0; i < 100; i++) {
			try {
				incThread[i].join();
				decThread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(counter.getCount());
	}
}
