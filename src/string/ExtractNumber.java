package string;

import java.util.Arrays;

public class ExtractNumber {
	public static void main(String[] args) {
		String str = "1,90";
		str = str.replaceAll("[^-?0-9]+", " ");
		System.out.println(Arrays.asList(str.trim().split(" ")));
	}
}
