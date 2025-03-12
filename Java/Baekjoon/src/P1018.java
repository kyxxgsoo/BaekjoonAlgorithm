import java.util.*;
import java.io.*;

public class P1018 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static int m;
    static boolean[][] board;
    static int result;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        result = 64;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
    }

    static void solve(int x, int y) throws IOException {
        int endX = x + 8;
        int endY = y + 8;
        boolean block = true;
        int cnt = 0;

        // 'w' 계산하고, 64 - cnt 해서 'b' 계산
        for (int i = y; i < endY; i++) {
            for (int j = x; j < endX; j++) {
                // w이면
                if (board[i][j] != block) {
                    cnt++;
                }
                block = !block;
            }
            block = !block;
        }
        int min = Math.min(cnt, 64 - cnt);
        result = Math.min(min, result);
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                solve(j, i);
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
