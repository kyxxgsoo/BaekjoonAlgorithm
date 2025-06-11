import java.util.*;
import java.io.*;

public class P1987 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int R;
    static int C;
    static int answer;
    static char[][] board;
    static Set<Character> isVisited;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 1;
        isVisited = new HashSet<>();

        board = new char[R][C];

        for (int i = 0 ; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

    }

    static void solve() throws IOException {
        isVisited.add(board[0][0]);
        recursion(0, 0, 1);

        bw.write(String.valueOf(answer));

    }

    static void recursion(int x, int y, int cnt) throws IOException {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 범위 내에 있고, 이전에 나왔던 알파벳이 아니면
            if (isInRange(nextX, nextY) && !isVisited.contains(board[nextY][nextX])) {
                isVisited.add(board[nextY][nextX]);
                recursion(nextX, nextY, cnt + 1);
                isVisited.remove(board[nextY][nextX]);
            }
        }

    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y < R && 0 <= x && x < C) {
            return true;
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
