package recurssion;

public class Person extends Parent  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4347482089866038165L;
	/**
	 * 
	 */
	private String name;
	private int age;
	private double number;
	private  long marks;
	
	public Person( String name) {
		this.name= name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public long getMarks() {
		return marks;
	}

	public void setMarks(long marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
