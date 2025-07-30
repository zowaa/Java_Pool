import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int weekIndex = 1;
        int grade, min;
        String res;

        while (weekIndex <= 18 && !input.equals("42")) {
            if (!input.equals("Week " + weekIndex)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            sb.append(input).append(" ");

            min = 9;
            for(int i = 0; i < 5; i++) {
                grade = in.nextInt();
                if (grade < min) {
                    min = grade;
                }
            }
            input = in.nextLine();

            for (int i = 0; i < min; i++) {
                sb.append("=");
            }
            sb.append(">\n");

            weekIndex++;
            if (weekIndex <= 18){
                input = in.nextLine();
            }
        }

        res = sb.toString();
        System.out.println(res);
    }
}
