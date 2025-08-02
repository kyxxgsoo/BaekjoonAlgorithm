import java.util.*;
import java.io.*;

public class P1213 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static String input;
    static int[] arr;
    static StringBuilder right;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();
        arr = new int[26];
        right = new StringBuilder();

    }

    static void solve() throws IOException {

        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'A']++;
        }

        if (isOverOddCnt()) {
            bw.write("I'm Sorry Hansoo");
            return;
        }

        char oddChar = ' ';
        for (int i = 0; i < 26; i++) {
            // 홀수면 하나 빼놓기
            if (arr[i] % 2 != 0) {
                oddChar = (char)(i + 'A');
                arr[i]--;
            }
        }

        for (int i = 25; i >= 0; i--) {
            char alphabet = (char)(i + 'A');
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    right.append(alphabet);
                }
            }
        }

        StringBuilder left = new StringBuilder(right);
        left.reverse();

        // 홀수가 있었으면 중간에 끼워넣기
        if (oddChar != ' ') {
            left.append(oddChar);
        }

        bw.write(left.toString() + right.toString());

    }

    static boolean isOverOddCnt() {
        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCnt++;
            }
            if (oddCnt >= 2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
