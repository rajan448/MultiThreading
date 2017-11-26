package com.app.ex;

interface X {
	void apply(int a);
}

public class CreatingThread2 {

	public static void main(String[] args) {
		Runnable task = () -> {

			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		};
		Thread task1 = new Thread(task, "Thread-1");
		Thread task2 = new Thread(task, "Thread-2");
		Thread task3 = new Thread(task, "Thread-3");

		task1.start();
		task2.start();
		task3.start();

		X m = (a) -> {
			System.out.println(a * 2);
		};
		m.apply(2);


	}

}
