package string;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Snippet {
	public static void main(String args[]) throws UnknownHostException {
		/*
		 * System.out.println("str".equals("str".intern()));
		 * 
		 * String text = "This - text ! has \\ /allot # of % special % characters.";
		 * text = text.replaceAll("[^a-zA-Z0-9\\s+]", ""); System.out.println(text);
		 * 
		 * String html = "This is bold"; System.out.println(html.getBytes().length);
		 * html = html.replaceAll("[^a-zA-Z0-9\\s+]", "");
		 */
		InetAddress localhost = InetAddress.getLocalHost();
		String hostAddress = localhost.getHostAddress();
		System.out.println("System IP Address : " + hostAddress);
		long ipToLong = ipToLong(hostAddress);
		System.out.println(ipToLong);
		System.out.println(longToIp(ipToLong));
	}

	public static String longToIp(long ip) {

		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);

	}

	public static long ipToLong(String ipAddress) {

		long result = 0;

		String[] ipAddressInArray = ipAddress.split("\\.");

		for (int i = 3; i >= 0; i--) {

			long ip = Long.parseLong(ipAddressInArray[3 - i]);
			result |= ip << (i * 8);

		}

		return result;
	}
}
