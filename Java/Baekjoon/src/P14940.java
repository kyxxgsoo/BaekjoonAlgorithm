import java.util.*;
import java.io.*;

public class P14940 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int n;
    static int m;
    static int[][] board;
    static int startX;
    static int startY;

    static int[][] answer;
    static boolean[][] isVisited;



    static class Node {
        int x;
        int y;
        int cnt;

        Node() {
            this.x = 0;
            this.y = 0;
            this.cnt = 0;
        }

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        board = new int[n][m];
        answer = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

    }
    static void testPrintArr(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printAnswer() throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    bw.write("0 ");
                } else if (board[i][j] == 1 && !isVisited[i][j]) {
                    bw.write("-1 ");
                } else {
                    bw.write(answer[i][j] + " ");
                }
            }
            bw.write("\n");
        }
    }

    static void solve() throws IOException {
        bfs();
        printAnswer();
    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y < n && 0 <= x && x < m) {
            return true;
        }
        return false;
    }

    static void bfs() throws IOException {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startX, startY, 0));
        answer[startY][startX] = 0;
        isVisited[startY][startX] = true;

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;
            int curCnt = curNode.cnt;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (isInRange(nextX, nextY) && board[nextY][nextX] == 1 && !isVisited[nextY][nextX]) {
                    q.add(new Node(nextX, nextY, curCnt + 1));
                    answer[nextY][nextX] = curCnt + 1;
                    isVisited[nextY][nextX] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
