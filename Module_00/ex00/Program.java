public class Program {
    public static void main(String[] arg) {
        int n = 479598;
        int res = 0;

        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;

        System.out.println(res);
    }
}
