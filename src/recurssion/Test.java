package recurssion;

import recurssion.B.bendabe;

public class Test extends Threads {
	static int i = 2;

	public static String output = "";

	public void foo(int i){
		try {
			if(i==1){
				throw new Exception();
			}
			output+=1;
		} catch (Exception e) {
			output+=2;
		} finally {
			output+=3;
		}
		output+=4;
	}
	
	public static void main(String[] args) {
		Integer i = new Integer(5);
		System.out.println(i.hashCode());
		i++;
		System.out.println(i.hashCode());
	}
}


class Threads implements bendabe {
	static int i = 1;
	public void run() {
		System.out.println(i++);
	}
}

abstract class A {
	public void printA() {
		System.out.println("B");
	}
}

abstract class B extends A {
	public void printB() {
		System.out.println("A");
	}
	
	abstract interface bendabe{
		public class angle{
			public void foo(){
				
			}
		}
	}
}