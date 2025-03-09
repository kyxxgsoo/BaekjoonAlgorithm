import java.util.*;
import java.io.*;

public class P4673 {

    static BufferedWriter bw;
    static boolean[] result;

    static void init() throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new boolean[10001];
    }

    static void dfs(int selfNumber) throws IOException {
        int sum = selfNumber;

        while (selfNumber > 0) {
            sum += selfNumber % 10;
            selfNumber /= 10;
            if (sum > 10000) {
                return;
            }
        }

        result[sum] = true;
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i < 10001; i++) {
            dfs(i);
        }

        for (int i = 1; i < 10001; i++) {
            if (!result[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();

    }
}
