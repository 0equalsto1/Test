package Instanseof;

public class InstanseOf {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class<?> cl = Integer.class;
		Object newInstance = Class.forName(cl.getName()).newInstance();
		System.out.println(newInstance.getClass());
		if (newInstance instanceof String)
			System.out.println("String");
		
	}

}
