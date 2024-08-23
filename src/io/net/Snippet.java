package io.net;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class Snippet {
	public static void main(String[] args) {
		printMACaddrs();
	}

	public static void printMACaddrs() {
		try {
			Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
			while (en.hasMoreElements()) {
				NetworkInterface nint = en.nextElement();
				if (!nint.isLoopback()) {
					byte[] data = nint.getHardwareAddress();
					if (data != null && data.length == 6) {
						System.out.println(new String(data));
					}
				}
			}
		} catch (java.net.SocketException e) {
			// fine, let's take is as signal of not having any interfaces
		}
	}
}
