package prime;

public class PrimeChecker {

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number < 4) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        // all prime numbers greater than 3 can be expressed in this form(6k ± 1)
        // Check divisibility only for numbers of the form 6k ± 1 up to the square root of 'number'
        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 6701; // Example number to check for primality
//        int number = 1777717; // Example number to check for primality

        if (isPrime(number)) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }
}
