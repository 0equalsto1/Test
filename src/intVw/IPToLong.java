package intVw;

public class IPToLong {

    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += (long) ip << (3 - i) * 8;//byte to long conversion
        }
        return result;
    }

    public static int ipToInt(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        int result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip << (3 - i) * 8;//byte to int conversion
        }
        return result;
    }

    public static String longToIp(long ip) {
        String[] parts = new String[4];
        for (int i = 0; i < 4; i++) {
            parts[i] = String.valueOf((ip >>> (24 - 8 * i)) & 0xFF);
        }
        return String.join(".", parts);
    }

    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        long ipAsLong = ipToLong(ipAddress);
        System.out.println("The IP address " + ipAddress + " is equal to the long " + ipAsLong);
    }
}