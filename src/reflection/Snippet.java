package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Snippet {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

//		Object person = new Person("mannu", 33);
		Object person = new LastInsertId();
		Field[] fields = person.getClass().getDeclaredFields();

		List<String> actualFieldNames = getFieldNames(fields, person);
		actualFieldNames.forEach(System.out::println);

	}

	private static List<String> getFieldNames(Field[] fields, Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		List<String> fieldNames = new ArrayList<>();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.get(obj));
			fieldNames.add(field.getName());
		}
		System.out.println("==============================================");

		return fieldNames;
	}
}
