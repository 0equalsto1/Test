package comprator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestComprator {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			Address a = new Address(rand.nextInt(20), "address" + i + 1);
			Employee e = new Employee(rand.nextInt(30), "name" + i + 1, a);
			list.add(e);
		}
		list.stream().forEach(System.out::println);
		System.out.println("=========================================================");
		Collections.sort(list, new EmpComprator());
		list.stream().forEach(System.out::println);

	}

}
