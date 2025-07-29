import java.util.Scanner;

public class Program {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum, count = 0;

        while (n != 42) {
            sum = sumDigit(n);
            if (isPrime(sum)) {
                count++;
            }
            n = in.nextInt();
        }
        System.out.println("Count of coffee-request : " + count);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int sumDigit(int n) {
        int res = 0;

        while (n != 0) {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}
