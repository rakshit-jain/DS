package com.rj;

public class ThreadSequence implements Runnable{

	private final int position ;
	private final int range;
	private final NumberPrinter printer;
	
	public ThreadSequence(int position,  int range, NumberPrinter printer) {
		this.position = position;
		this.range = range;
		this.printer = printer;
	}
	@Override
	public void run() {
		int number =0;
		while(number < range){
			number = printer.printNumber(position, range);
		}
	}
	
	
	public static void main(String[] args) {
		int range = 10;
		int numberOfThread = 2;
		NumberPrinter printer = new NumberPrinter(numberOfThread);
		for(int i=0 ; i<numberOfThread; i++){
			new Thread(new ThreadSequence(i, range, printer)).start();
		}
		
	}
}
