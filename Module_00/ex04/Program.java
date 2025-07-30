import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        char[] line_t = line.toCharArray();
        char[] char_T = new char[line.length()];
        int[] occurr_count = new int[line.length()];
        int size;

        size = count_occurrences(line_t, char_T, occurr_count);
        sort_occurrences(size, char_T, occurr_count);


//        for (int i = 0; i < size; i++){
//            System.out.print(char_T[i] + "  ");
//        }
//        System.out.println("");
//        for (int i = 0; i < size; i++){
//            System.out.print(occurr_count[i] + " ");
//        }
//        System.out.println("");
    }

    static void sort_occurrences(int size, char[] char_T, int[] occurr_count) {
        int tmp_int;
        char tmp_char;

        for (int i = 0; i < size - 1; i++){
            for (int j = i + 1; j < size; j++) {
                if (occurr_count[i] < occurr_count[j] || (occurr_count[i] == occurr_count[j] && char_T[i] > char_T[j])){
                    tmp_int = occurr_count[i];
                    occurr_count[i] = occurr_count[j];
                    occurr_count[j] = tmp_int;
                    tmp_char = char_T[i];
                    char_T[i] = char_T[j];
                    char_T[j] = tmp_char;
                }
            }
        }
    }

    static int count_occurrences(char[] line_t, char[] char_T, int[] occurr_count) {
        boolean found;
        int j;
        int size = 0;

        for (char c: line_t){
            found = false;
            for (j = 0; j < size; j++){
                if (char_T[j] == c){
                    if (occurr_count[j] < 999) {
                        occurr_count[j] += 1;
                    }
                    found = true;
                    break;
                }
            }
            if (!found){
                char_T[j] = c;
                occurr_count[j] = 1;
                size++;
            }
        }
        return size;
    }
}
