package pack3;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MyClone implements Cloneable{
	private String name;
	public MyClone(){
		name = "vikki";
	}
public static void main(String[] args) throws IOException {
	URL stockURL = new URL("http://103.248.83.253:4444/sms-profiling/report/phones/2017-10-24/");
	BufferedReader br = new BufferedReader(new InputStreamReader(stockURL.openStream()));
//	FileOutputStream out = new File
	

		String sCurrentLine = "";
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
}
}
