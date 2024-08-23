package packg1;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Random;

public class TrimFunTest {
	public static void main(String[] args) throws URISyntaxException {
		String s = "nnu";

	/*	Strings ss = new Strings("     1   ", "   2   ", "   3  ", "   4   ");
		long start = System.currentTimeMillis();
		// String password = Strings.RandomPassword();
		isHexadecimal("1212121212121");
		System.out.println(" time taken by isHexadecimal: " + (System.currentTimeMillis() - start));
*/
		/*if(s.matches("^[!]([a-z A-Z]){3,}$"))
			System.out.println(true);
			else*/
				String os = System.getProperty("os.name").toLowerCase();
				if (os.indexOf("win") >= 0) {
					CodeSource codeSource = TrimFunTest.class.getProtectionDomain().getCodeSource();
					File jarFile = new File(codeSource.getLocation().toURI().getPath());
					String jarDir = jarFile.getParentFile().getPath();
					System.out.println(jarDir);
				}
	}

	public static boolean isHexadecimalReg(String text) {
		if (text != null && !text.trim().isEmpty())
			return text.matches("[0-9a-fA-F]+");
		return false;
	}

	public static boolean isHexadecimal(String text) {
		text = text.trim();

		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B',
				'C', 'D', 'E', 'F' };

		int hexDigitsCount = 0;

		for (char symbol : text.toCharArray()) {
			for (char hexDigit : hexDigits) {
				if (symbol == hexDigit) {
					hexDigitsCount++;
					break;
				}
			}
		}

		return hexDigitsCount == text.length();
	}
}

class Strings {
	public static int RandomAdjuster = 0;

	public static String RandomPassword() {
		String Password = "";
		int Seed = (int) (System.currentTimeMillis() % 20L) + 1 + RandomAdjuster;
		RandomAdjuster++;
		String PassChars = "9632452356925982498396625872873983223478932983623839437266234462983966258728739832234789329";
		Random Rand = new Random();
		Rand.setSeed(System.currentTimeMillis() * Seed);
		byte PassByte[] = new byte[6];
		Rand.nextBytes(PassByte);
		for (int i = 0; i < PassByte.length; i++) {
			if (i == 0 || i == 5) {
				Password = (new StringBuilder(String.valueOf(Password))).append(PassChars.charAt(PassByte[i] & 0x3f))
						.toString();
			} else {
				Password = (new StringBuilder(String.valueOf(Password))).append(PassChars.charAt(PassByte[i] & 0x3f))
						.toString();
			}
		}
		return Password;
	}

	String one;
	String two;
	String three;
	String four;

	public Strings(String one, String two, String three, String four) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

}