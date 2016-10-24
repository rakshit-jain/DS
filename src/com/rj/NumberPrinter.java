package com.rj;

public class NumberPrinter {

	private int latch = 0;
	private final int numberOfThreads;
	private volatile int counter = 0;

	public NumberPrinter(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	int printNumber(int threadPosition, int range) {
		synchronized (this) {
			while (latch != threadPosition && counter < range) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(counter < range){
				latch=((latch+1) % numberOfThreads);
				System.out.println("Printing Counter for Thread " + threadPosition + " -> " + counter++);
			}
			notifyAll();
		}
		return counter;
	}
}
