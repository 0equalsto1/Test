package map;

import java.util.HashMap;
import java.util.Map;

public class MapInter {
	public static void main(String[] args) {
		Map<Employee, String> map = new HashMap<>();
		Employee e1 = new Employee(1, "1");
		Employee e2 = new Employee(2, "2");
		Employee e3 = new Employee(3, "3");
		Employee e4 = new Employee(4, "4");
		Employee e5 = new Employee(5, "5");
		map.put(e1, "e1");
		map.put(e2, "e2");
		map.put(e3, "e3");
		map.put(e4, "e4");
		map.put(e5, "e5");
		System.out.println(map.size());
	}

}

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}