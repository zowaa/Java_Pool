import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        char[] line_t = line.toCharArray();
        char[] char_T = new char[line.length()];
        int[] occurr_count = new int[line.length()];
        int[] heights = new int[10];
        int size, chart_col;

        size = count_occurrences(line_t, char_T, occurr_count);
        chart_col = size < 10 ? size : 10;
        sort_occurrences(size, char_T, occurr_count);
        calculate_heights(chart_col, heights, occurr_count);

        char[][] chart = new char[12][chart_col * 3];
        fill_chart(chart, char_T, occurr_count, heights, chart_col);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < chart_col * 3; j++) {
                System.out.print(chart[i][j]);
            }
            System.out.println();
        }
    }

    static void fill_chart(char[][] chart, char[] char_T, int[] occurr_count, int[] heights, int chart_col) {
        int k = 0;
        for (int j = 2; j < chart_col * 3; j += 3) {
            int i = 11;
            chart[i][j - 2] = ' ';
            chart[i][j - 1] = ' ';
            chart[i--][j] = char_T[k];
            while (heights[k] != 0) {
                chart[i][j - 2] = ' ';
                chart[i][j - 1] = ' ';
                chart[i--][j] = '#';
                heights[k]--;
            }
            int h = j;
            int l = 3;
            while (occurr_count[k] != 0) {
                chart[i][h--] = (char) (occurr_count[k] % 10 + '0');
                occurr_count[k] /= 10;
                l--;
            }
            while(l > 0) {
                chart[i][h--] = ' ';
                l--;
            }
            k++;
        }
    }

    static void calculate_heights(int chart_col, int[] heights, int[] occurr_count) {
        for (int i = 0; i < chart_col; i++) {
            heights[i] = (occurr_count[i] * 10) / occurr_count[0];
        }
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
