package string;

public class StringConcat {

	public static void main(String[] args) {
		String s = "{\"foo\":\"bar\"}";
		System.out.println(s.charAt(0) == '{');
		String.format("First %s and then %s", "foo", "bar");

		String platForm = "aawapcc";

		System.out.println(platForm.matches("website|wap|speaker"));
		System.out.println(Integer.toString(132).matches("2|3|5|14"));
		System.out.println("rl_123".contains("rl"));
		System.out.println("xxxx".split("-")[0]);
		System.out.println("==========================");
		final Long fromCache = getFromCache("12", Long.class);
		System.out.println(fromCache);

	}

	public static <T> T getFromCache(Object v, Class<T> returnType) {
		T value = null;
		try {
			if (Number.class.isAssignableFrom(returnType) || String.class.isAssignableFrom(returnType)) {
				String valueOf = String.valueOf(v);
				value = returnType.cast(getTypeValue(returnType, valueOf));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return value;
	}

	private static <T> Object getTypeValue(Class<T> returnType, String value) {
		String typeName = returnType.getSimpleName();
		switch (typeName) {
		case "Long":
			return new Long(value);
		case "Integer":
			return new Integer(value);
		case "Float":
			return new Float(value);
		case "Double":
			return new Double(value);
		}

		return value;
	}

}
