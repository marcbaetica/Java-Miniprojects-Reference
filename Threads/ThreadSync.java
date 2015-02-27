//this is a simple producer-consumer thread project
//NOTE: not adding synchronized on the methods will cause the production and consumption to happen randomly due to your processor's scheduling
//can force some outcomes (filling the stack or consuming the stack by adding Thread.sleep(200) - see Producer or Consumer for loop. Usually it takes more to produce something than consuming it

import java.util.Stack;

public class ThreadSync {

	
	//need to use a shared data structure to show utilization
	private Stack<String> myStack = new Stack<String>(); //we parametized it as string to get rid of the warning
	
	public static void main (String[] args) {
		ThreadSync ts = new ThreadSync();
		
		//instantiating and starting a producer thread
		Producer p = ts.new Producer(); //not adding the instance ts. will give an error we would be trying to run an inner class without an instance
		p.start();
		
		//now we need a way to test what happens when the two threads are acting upon the sared resource
		Consumer c = ts.new Consumer();
		c.start();
	}
	
	private class Producer extends Thread { // see video before for more details
		
		public void run() {
			try {
				for (int i=0; i<10; i++, Thread.sleep(200)) { //pushes 9 values into the stack
					System.out.println("Producing... value" + i);
					myStack.push("value" + i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private class Consumer extends Thread { //essentially a consumer that acts on the myStack stack
		
		public void run(){
			try {
				for (int i=0; i<10; i++, Thread.sleep(100)) {
					System.out.println("Consuming.. value" + i);
					myStack.pop();
					System.out.println("Consumed: value" + i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
