package packg1;

public class ThreadTest {
public static void main(String[] args) {
	Threadbro threadbro = new Threadbro();
	Thread t1 = new Thread(threadbro);
	Thread t2 = new Thread(threadbro);
	Thread t3 = new Thread(threadbro);
	t1.start();t2.start();t3.start();
	new ShareedClass2().fun();
	new ShareedClass().pro();
	 /*String s="Sachin";  
	   s.concat(" Tendulkar");//concat() method appends the string at the end  
	   System.out.println(s);*/
}
}

class ShareedClass{
	int i=0;
	int x;
	protected class prot{}
	abstract class priv{}
	protected ShareedClass(){}
	ShareedClass(int w){
		x=w;
	}
	protected void pro(){
		System.out.println("Protected method");
	}
	 public void fun(){
		for(;i<3;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		i=0;
		new ShareedClass2().fun();
	}
}

class Threadbro implements Runnable{
	ShareedClass shareedClass = new ShareedClass(3);
	@Override
	 synchronized public void run() {
		System.out.println("++++++  "+Thread.currentThread().getName());
		shareedClass.fun();
	}
	
}
/**
 * 
 * this is a shared resource
 *@author Mahendra Rawat
 */
class ShareedClass2{
	int i=0;
	int x;
	
	 public void fun(){
			System.out.println("**********************  "+Thread.currentThread().getName());
		
		i=0;
	}
}