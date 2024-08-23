package bitset;

import java.util.BitSet;

public class Bitset {

	public static void main(String[] args) {
		BitSet bitSet = new BitSet();
		bitSet.set(15, 25);

		bitSet.stream().forEach(System.out::println);
	}

}
