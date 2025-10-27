import java.util.*;
import java.io.*;

public class P2206 {

    static class Node {
        int x;
        int y;
        int cnt;
        int isBroken;

        Node(int x, int y, int cnt, int isBroken) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isBroken = isBroken;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static int n;
    static int m;
    static int answer;

    static int[][] map;

    static List<Node> walls;



    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        walls = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                walls.add(new Node(j, i, 0, 0));
            }
        }
    }

    static void solve() throws IOException {
        int temp = bfs();
        if (temp != -1) {
            answer = Math.min(answer, temp);
        }
        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "");
    }

    static int bfs() {
        boolean[][][] isVisited = new boolean[n][m][2];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0));
        isVisited[0][0][0] = true;
        int ans = -1;

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;
            int curCnt = curNode.cnt;
            int curIsBroken = curNode.isBroken;

            if (curY == n - 1 && curX == m - 1) {
                ans = curCnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 벽이 아니라면 그냥 이동
                if (isInRange(nextX, nextY) && !isVisited[nextY][nextX][curIsBroken] && map[nextY][nextX] == 0) {
                    q.add(new Node(nextX, nextY, curCnt + 1, curIsBroken));
                    isVisited[nextY][nextX][curIsBroken] = true;
                }

                // 다음 칸이 벽이면서 아직 벽을 안부쉈다면
                if (isInRange(nextX, nextY) && curIsBroken == 0 && !isVisited[nextY][nextX][1] && map[nextY][nextX] == 1) {
                    q.add(new Node(nextX, nextY, curCnt + 1, 1));
                    isVisited[nextY][nextX][1] = true;
                }
            }
        }

        return ans;
    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y < n && 0 <= x && x < m) {
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
