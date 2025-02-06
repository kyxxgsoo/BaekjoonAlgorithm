import java.util.*;
import java.io.*;

public class P1932 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n;

    private static int[][] origin;
    private static int[][] dp;
    private static int answer;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        origin = new int[n][n];
        dp = new int[n][n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    private static void solution() throws IOException {
        init();
        dp[0][0] = origin[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tempLeft = dp[i - 1][j] + origin[i][j];
                int tempRight = dp[i - 1][j] + origin[i][j + 1];
                if (tempLeft > dp[i][j]) {
                    dp[i][j] = tempLeft;
                }
                if (tempRight > dp[i][j + 1]) {
                    dp[i][j + 1] = tempRight;
                }
            }
        }
            // log
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[n - 1][i]) {
                max = dp[n - 1][i];
            }
        }
        answer = max;
    }
    public static void main(String[] args) throws IOException {
        solution();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
