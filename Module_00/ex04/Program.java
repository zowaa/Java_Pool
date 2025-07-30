package Module_00.ex04;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        char[] line_t = line.toCharArray();
        char[] C = new char[line.length()];
        int[] O = new int[line.length()];
        int size;

        size = count_occurrences(line_t, C, O);


        for (int i = 0; i < size; i++){
            System.out.print(C[i] + "  ");
        }
        System.out.println("");
        for (int i = 0; i < size; i++){
            System.out.print(O[i] + " ");
        }
        System.out.println("");
        System.out.println(size);

        sort_occurrences(size, C, O);


        for (int i = 0; i < size; i++){
            System.out.print(C[i] + "  ");
        }
        System.out.println("");
        for (int i = 0; i < size; i++){
            System.out.print(O[i] + " ");
        }
        System.out.println("");
        System.out.println(size);
    }

    static void sort_occurrences(int size, char[] C, int[] O) {
        int temp;
        char tem;

        for (int i = 0; i < size - 1; i++){
            for (int j = i + 1; j < size; j++) {
                if (O[i] < O[j] || (O[i] == O[j] && C[i] > C[j])){
                    temp = O[i];
                    O[i] = O[j];
                    O[j] = temp;
                    tem = C[i];
                    C[i] = C[j];
                    C[j] = tem;
                }
            }
        }
    }

    static int count_occurrences(char[] line_t, char[] C, int[] O) {
        boolean found = false;
        int j;
        int size = 0;

        for (char c: line_t){
            found = false;
            for (j = 0; j < size; j++){
                if (C[j] == c){
                    if (O[j] < 999) {
                        O[j] += 1;
                    }
                    found = true;
                    break;
                }
            }
            if (!found){
                C[j] = c;
                O[j] = 1;
                size++;
            }
        }
        return size;
    }
}
