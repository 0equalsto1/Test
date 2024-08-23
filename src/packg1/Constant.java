package packg1;

public class Constant {
	public static String url = "abc";
	public  String aaa = "+++++++++++++++";

	public static void main(String[] args) {
		// System.out.println("String is hexaDecimal "+isHex("asd98"));
		System.out.println(new Constant().aaa);
		long startTime = System.currentTimeMillis();
		System.out.println("String is validateMobileNo " + validateMobileNo("99528764233") + "  time taken :"
				+ (System.currentTimeMillis() - startTime));
	}

	public static boolean isHex(String strImei) {
		if (strImei != null && !strImei.trim().isEmpty())
			return strImei.matches("[0-9a-f]+");
		return false;
		

	}

	public static boolean checkIsValidImeiNo1(String strImei) {
		if (strImei != null && !strImei.trim().isEmpty())
			return strImei.matches("[0-9]{15}");
		return false;
	}

	public static boolean validateMobileNo(String mob) {
		boolean st = true;
		if ((mob.substring(0, 1).equals("9")) || (mob.substring(0, 1).equals("8"))
				|| (mob.substring(0, 1).equals("7"))) {
			if (mob.length() > 12 || mob.length() < 10) {
				st = false;
			} else {
				for (int i = 0; i < mob.length(); i++) {
					if (!Character.isDigit(mob.charAt(i))) {
						st = false;
						break;
					}
				}
			}
		} else {
			return false;
		}
		if (st == true) {
			return true;
		}
		return false;
	}

}
