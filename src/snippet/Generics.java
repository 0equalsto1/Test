package snippet;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public void addAnimal(List<Animal> animals) {
		System.out.println(animals.size());
		animals.add(new Cat()); 
		System.out.println(animals.size());
		
	}
	public void addObject(List<? super Animal> animals) {
		System.out.println(animals.size());
		animals.add(new Cat()); 
		System.out.println(animals.size());
		
	}

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Dog());
		animals.add(new Dog());
		animals.add(new Cat());
		/*Generics doc = new Generics();
		doc.addAnimal(animals);*/
		
		List<Object> obj = new ArrayList<>();
		obj.add("acvb");
		System.out.println(obj);
		Generics docc = new Generics();
		docc.addObject(obj);
		
		List<? super String > wild = new ArrayList<>();
		wild.add("");
	}
}
