import java.util.*;
import java.io.*;

public class P1065 {


    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int result;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        result = 0;

    }

    static boolean isHansu(int num) throws IOException {
        if (num < 10) {
            return true;
        }

        char[] charArr = String.valueOf(num).toCharArray();

        int distance = charArr[0] - charArr[1];

        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i - 1] - charArr[i] != distance) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            if (isHansu(i)) {
                result++;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
