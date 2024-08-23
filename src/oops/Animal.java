package oops;

public class Animal {
	public void say() {
		System.out.println("Animal says:");
	}

	private Animal() {
		System.out.println("Animal private constructor...");
	}

	public static class Cat extends Animal {
		public Cat() {
			System.out.println("Cat public constructor...");

		}

		@Override
		public void say() {
			super.say();
			System.out.println("Meow");
		}
	}

	public static void main(String[] args) {
		Long L = new Long(77);
		long l = L;
		int i = (int) l;
		Animal a = new Animal();
		Cat c = new Cat();

	}
}

/*class Dog extends Animal {
	public Dog() {
		super();
	} // compilation error here: The constructor Animal() is not visible

	@Override
	public void say() {
		super.say();
		System.out.printLn("Wuf");
	}
}*/