package com.rj;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List<Object> queue = new LinkedList<>();
	private int size = 10;
	
	public BlockingQueue(int size) {
		this.size= size;
	}
	
	public synchronized void enqueue(Object object) throws InterruptedException{
		while(queue.size()== size){
			this.wait();
		}
		if(queue.size()==0){
			notifyAll();
		}
		queue.add(object);
	}
	
	public synchronized Object dequeue(Object object) throws InterruptedException{
		while(queue.size()==0){
			this.wait();
		}
		if(queue.size() == size){
			notifyAll();
		}
		return queue.remove(object);
	}
}
