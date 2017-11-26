package com.app.ex;

import java.util.concurrent.TimeUnit;

public class DeadLockEx {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		Runnable runnable1 = () -> {
			a.method1();
		};

		Runnable runnable2 = () -> {
			b.method2();
		};
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);

	}

	public static class A {

		public void method1() {
			System.out.println("Inside A method1");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void method2() {
			System.out.println("Imside A method2");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class B {
		public void method1() {
			System.out.println("Inside B method1");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void method2() {
			System.out.println("Imside B method2");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
