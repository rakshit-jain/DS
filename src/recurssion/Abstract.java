package recurssion;

public abstract class Abstract {

	{
		System.out.println("Instance Block");
	}
	static {
		System.out.println("static Instance block");
	}
	public Abstract() {
		System.out.println("In Constructor");
	}
	public int a =10;
	public  class inner{
		public inner() {
			System.out.println("hi there inner");
		}
		
		public void fun(){
			System.out.println("fun");
		}
	}
	
	
	
}
