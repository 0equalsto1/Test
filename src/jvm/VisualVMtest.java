package jvm;

public class VisualVMtest {

	public static void main(String[] args) {

		while(true){
			new String(""+Math.random());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
