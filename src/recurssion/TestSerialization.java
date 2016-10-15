package recurssion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("serialize.ser"));
		Person person = new Person("babay");
		person.setAge(2);
		person.setMarks(50l);
		person.setNumber(40.5d);
		System.out.println(person);
		stream.writeObject(person);
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialize.ser"));{
			Person personRead = (Person) inputStream.readObject();
			System.out.println(personRead.getMarks());
		}
	}
	
	
}
