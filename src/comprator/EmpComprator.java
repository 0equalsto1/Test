package comprator;

import java.util.Comparator;

public class EmpComprator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		Address add1 = o1.getAdd();
		Address add2 = o2.getAdd();
		if (add1.getAddId() == add2.getAddId())
			return 0;
		if (add1.getAddId() > add2.getAddId())
			return 1;
		else
			return -1;

	}

}
