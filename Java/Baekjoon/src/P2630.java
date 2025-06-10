import java.util.*;
import java.io.*;

public class P2630 {


    static BufferedReader br;
    static BufferedWriter bw;
    static int N;

    static int[][] paper;

    static int white;
    static int blue;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());


        paper = new int[N + 1][N + 1];

        for (int y = 1; y <= N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void solve() throws IOException {
        white = recursion(1, 1, N, 0);
        blue = recursion(1, 1, N, 1);
    }

    static int recursion(int x, int y, int length, int color) throws IOException {

        // 한 변의 길이가 1이면 무조건 1 리턴
        if ((length == 1 || isOnlyOneColor(x, y, length)) && paper[y][x] == color) {
            return 1;
        }

        int ret = 0;

        if (length > 1) {
            int lengthOfHalf = length / 2;
            ret += recursion(x, y, lengthOfHalf, color);
            ret += recursion(x + lengthOfHalf, y, lengthOfHalf, color);
            ret += recursion(x, y + lengthOfHalf, lengthOfHalf, color);
            ret += recursion(x + lengthOfHalf, y + lengthOfHalf, lengthOfHalf, color);
        }



        return ret;
    }

    static boolean isOnlyOneColor(int x, int y, int length) {
        int color = paper[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(white + "\n" + blue);

        bw.flush();
        bw.close();
        br.close();


    }
}
