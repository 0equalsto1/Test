package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateFile {
	static Random r = new Random();

	public static void main(String[] args) {
		String pathname = "/home/mahendra/workspace/doc/SPARK/exm/data.txt";
		try (FileWriter writer = new FileWriter(pathname, true); BufferedWriter bw = new BufferedWriter(writer)) {
			for (int i = 0; i < 15009; i++) {
				int content = getRandomNumberInRange(1, 15000);
				bw.write(content+"");
				bw.newLine();
			}

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return r.nextInt((max - min) + 1) + min;
	}

}
