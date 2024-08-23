package serialization;

import java.io.Serializable;

public class Student implements Serializable {
	/*
	  
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String add;
	/* private static final ObjectStreamField[] serialPersistentFields
     = {new ObjectStreamField("id", int.class),new ObjectStreamField("name", String.class)};
	*/
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Student(int id, String name,String add) {
		this.id = id;
		this.name = name;
		this.add = add;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}