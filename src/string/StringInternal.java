package string;

public class StringInternal {

	public static void main(String[] args) throws InterruptedException {
		long t1=System.currentTimeMillis();
		String s="abc";
		String s1="bca";
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s.hashCode()%10);
		System.out.println(System.currentTimeMillis()-t1);
		
	}

}
