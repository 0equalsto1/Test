package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUIDMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student s = new Student(1, "n1");
//		ser(s);
		dser();

	}

	public static void ser(Student s) throws IOException {
		FileOutputStream fos = new FileOutputStream("svi.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(s);
		oos.close();
		fos.close();

	}

	public static void dser() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("svi.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Student s = (Student) ois.readObject();
		System.out.println(s);
		ois.close();
		fis.close();
	}

}
