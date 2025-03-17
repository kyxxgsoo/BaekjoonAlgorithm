import java.io.*;
import java.util.*;

public class P14500 {

    static class Node {
        int x;
        int y;
        int cnt;
        int sum;

        Node(int x, int y, int cnt, int sum) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] board;
    static int result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] isVisited;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;

        // 보드 초기화
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // isVisited 초기화
        isVisited = new boolean[n][m];
    }

    static boolean isInRange(int x, int y) throws IOException {
        if (0 <= y && y < n && 0 <= x && x < m) {
            return true;
        }
        return false;
    }

    // 'ㅗ' 모양을 제외한 값 구하기
    static void dfs(int cnt, int sum, int curX, int curY) throws IOException {
        if (cnt >= 4) {
            if (result < sum) {
                result = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            // 범위 찾기 && 방문하지 않은 노드만 방문
            if (isInRange(nextX, nextY) && !isVisited[nextY][nextX]) {
                // ㅗ 모양을 만들기 위해 2일때, 다시 제자리에서 탐색
                if (cnt == 2) {
                    isVisited[nextY][nextX] = true;
                    dfs(cnt + 1, sum + board[nextY][nextX], curX, curY);
                    isVisited[nextY][nextX] = false;
                }
                isVisited[nextY][nextX] = true;
                dfs(cnt + 1, sum + board[nextY][nextX], nextX, nextY);
                isVisited[nextY][nextX] = false;

            }
        }
    }

    public static void main(String[] args) throws IOException {

        init();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = true;
                dfs(1, board[i][j], j, i);
                isVisited[i][j] = false;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
