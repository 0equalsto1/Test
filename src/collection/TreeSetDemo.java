package collection;
import java.util.*; 
  
class TreeSetDemo { 
    public static void main(String[] args) 
    { 
    	System.out.println("a".compareTo(""));
        TreeSet<String> ts1 = new TreeSet<String>(); 
//        ts1.add(null);
        ts1.add("A"); 
        ts1.add("B"); 
        ts1.add("C"); 
  
        ts1.add("C"); 
        
        // Elements get stored in default natural 
        // Sorting Order(Ascending) 
        System.out.println(ts1); 
    } 
} 