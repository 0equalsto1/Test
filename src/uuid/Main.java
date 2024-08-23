package uuid;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		/*
		 * for (int i = 0; i < 10; i++) { System.out.println(getUniqueId()); }
		 */
		System.out.println(null+"ajsajs");
		printUniqueId();
	}

	private static BigInteger getUniqueId() {
		final UUID uid = UUID.randomUUID();
		final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
		buffer.putLong(uid.getLeastSignificantBits());
		buffer.putLong(uid.getMostSignificantBits());
		return new BigInteger(buffer.array()).abs();
	}

	private static void printUniqueId() {
		Set<String> set = new HashSet<>();
		int limit=1000;
		CountDownLatch cl = new CountDownLatch(limit);
		for (int i = 0; i < limit; i++) {
			Thread t1 = new Thread() {
				@Override
				public void run() {
					set.add(Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate().toString());
					cl.countDown();
//					System.out.println(Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate());
				}
			};
			t1.start();
		}
		try {
			cl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set.size());		
	}
}
