import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int weekIndex = 1;
        String s;

        while (weekIndex <= 18 && !input.equals("42")) {
            if (!input.equals("Week " + weekIndex)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            sb.append(input).append(" ");

//            input = in.nextLine();
//            for(int i = 0; i < 9; i += 2) {
//                int n = (int) input[i];
//            }


            weekIndex++;
            input = in.nextLine();
        }
//            System.out.println("hh"+ sb);
    }
}
