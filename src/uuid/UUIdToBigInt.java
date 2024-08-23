package uuid;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;

import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;

public class UUIdToBigInt {
	public static final BigInteger B = BigInteger.ONE.shiftLeft(64); // 2^64
	public static final BigInteger L = BigInteger.valueOf(Long.MAX_VALUE);

	public static BigInteger uuidToBigInt(UUID id) {
		BigInteger lo = BigInteger.valueOf(id.getLeastSignificantBits());
		BigInteger hi = BigInteger.valueOf(id.getMostSignificantBits());

		// If any of lo/hi parts is negative interpret as unsigned

		if (hi.signum() < 0)
			hi = hi.add(B);

		if (lo.signum() < 0)
			lo = lo.add(B);

		return lo.add(hi.multiply(B));
	}

	public static UUID bigIntToUUID(BigInteger x) {
		BigInteger[] parts = x.divideAndRemainder(B);
		BigInteger hi = parts[0];
		BigInteger lo = parts[1];

		if (L.compareTo(lo) < 0)
			lo = lo.subtract(B);

		if (L.compareTo(hi) < 0)
			hi = hi.subtract(B);

		return new UUID(hi.longValueExact(), lo.longValueExact());
	}

	public static void main(String[] args) throws IOException {
//		UUID uuid = UUID.randomUUID();
		UUID uuid = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate();
		System.out.println(uuid);

		BigInteger convertToBigInteger = uuidToBigInt(uuid);
		System.out.println("UUID to bigInt : "+convertToBigInteger);
//		System.out.println(Math.abs(uuid.hashCode()));
//		System.out.println(Math.abs(uuid.toString().hashCode()));
		System.out.println(Math.abs(convertToBigInteger.longValue()));
//		System.out.println("bigInt to UUID : "+bigIntToUUID(convertToBigInteger));
		System.out.println(UUID.fromString(uuid.toString()));
	}
}
