package oops;

public class PrivateData {
	private int data = 10;
	
	{
		System.out.println("PrivateData init block..");
	}
	public PrivateData() {
		System.out.println("PrivateData constructor...");
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
