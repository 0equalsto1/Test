package serialization;

import java.io.*;
class Parent{
	int i=10;
}
class GfgAccount extends Parent implements Serializable {

	private static final long serialVersionUID = -7214821442345703248L;

	String username = "gfg_admin";

	transient String pwd = "geeks";

	private void writeObject(ObjectOutputStream oos) throws Exception {
		// oos.defaultWriteObject();

		String epwd = "123" + pwd;
		oos.writeObject(username);
		oos.writeObject(epwd);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		// ois.defaultReadObject();
		username = (String) ois.readObject();
		String epwd = (String) ois.readObject();

		pwd = epwd.substring(3);
	}
}

public class CustomizedSerializationDemo {
	public static void main(String[] args) throws Exception {
		GfgAccount gfg_g1 = new GfgAccount();

		System.out.println("Username :" + gfg_g1.username + "	 Password :" + gfg_g1.pwd);

		FileOutputStream fos = new FileOutputStream("abc.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(gfg_g1);

		FileInputStream fis = new FileInputStream("abc.ser");

		ObjectInputStream ois = new ObjectInputStream(fis);

		GfgAccount gfg_g2 = (GfgAccount) ois.readObject();

		System.out.println("Username :" + gfg_g2.username + "	 Password :" + gfg_g2.pwd);
	}
}
