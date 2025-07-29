import java.util.Scanner;

public class Program {
    public static void main(String[] arg) {
        int n, i;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number :");
        n = in.nextInt();

        if (n == 1 || n <= 0) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                System.out.println("false " + (i - 1));
                System.exit(0);
            }
        }
        System.out.println("true "+ (i - 1));
    }
}
