import java.util.*;
import java.io.*;

public class P1018 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static int m;
    static char[][] board;
    static int result;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        result = 64;

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void solve(int x, int y) throws IOException {
        int xEnd = x + 8;
        int yEnd = y + 8;

        char color = board[y][x];

        int cnt = 0;
        for (int i = y; i < yEnd; i++) {
            for (int j = x; j < xEnd; j++) {
//                System.out.print(j + " ");
//                System.out.print(i + " ");
//                System.out.print(board[i][j] + " ");
//                System.out.println(color);
                if (board[i][j] != color) {
                    cnt++;
                }

                if (color == 'W') {
                    color = 'B';
                } else {
                    color = 'W';
                }
            }

            if (color == 'W') {
                color = 'B';
            } else {
                color = 'W';
            }
        }

//        System.out.println(cnt);

        int min = Math.min(cnt, 64 - cnt);
        if (min < result) {
            result = min;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i + 8 <= n; i++) {
            for (int j = 0; j + 8 <= m; j++) {
                solve(j, i);
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}
