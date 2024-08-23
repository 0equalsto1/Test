package oops;

public class TestPrivate extends PrivateData{
	{
		System.out.println("TestPrivate init block..");
	}
	
	public TestPrivate() {
		System.out.println("TestPrivate constructor....");
	}

	public static void main(String[] args) {
//		PrivateData pd = new PrivateData();
		TestPrivate pt = new TestPrivate();
		System.out.println(pt.getData());
		pt.setData(20);
		System.out.println(pt.getData());
	}

}
