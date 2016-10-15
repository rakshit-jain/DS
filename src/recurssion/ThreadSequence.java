package recurssion;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSequence implements Runnable{

	private final int position ;
	private final int threadCount;
	private AtomicInteger counter ;
	private final int range;
	private AtomicInteger latch;
	public ThreadSequence(int position, int threadCount, AtomicInteger counter, int range, AtomicInteger latch) {
		this.position = position;
		this.threadCount = threadCount;
		this.counter = counter;
		this.range = range;
		this.latch = latch;
	}
	@Override
	public void run() {
		printSequence();
	}
	
	private  void printSequence(){
		synchronized (counter) {
			while(counter.get() < range){
				if(latch.get() == position){
					int value = counter.get() + 1;
					System.out.println("Printing output for Thread: "
							+ this.position + "  "
							+ value);
					counter.incrementAndGet();
					
					latch.set(latch.incrementAndGet()% threadCount);
					counter.notifyAll();
				}else{
					try {
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(0);
		int range = 15;
		int numberOfThread = 5;
		AtomicInteger latch =new AtomicInteger(0);;
		for(int i=0 ; i<numberOfThread; i++){
			new Thread(new ThreadSequence(i, numberOfThread, counter, range, latch)).start();
		}
		
	}
}
