import java.util.*;
import java.io.*;

public class P2573 {

    static class Node {
        int x;
        int y;
        int h;

        Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static boolean[][] isVisited;
    static int[][] map;

    static int n;
    static int m;

//    static int cnt;
    static int answer;

    static List<Node> nodes;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n][m];
        map = new int[n][m];

//        cnt = 0;
        answer = 0;

        nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                if (h > 0) {
                    nodes.add(new Node(j, i, h));
                }
            }
        }
    }

    static void solve() throws IOException {

//        printMap();
        while (true) {
            isVisited = new boolean[n][m];
            int cnt = 0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!isVisited[y][x] && map[y][x] > 0) {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }

            // 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 0을 출력
            if (cnt == 0) {
                answer = 0;
                break;
            }

            // 두 덩어리 이상으로 분리되는 최초의 시간
            if (cnt >= 2) {
                break;
            }

            answer++;
            bfs();
//            printMap();
        }

        bw.write(answer + "");
    }

    static void dfs(int x, int y) {
        isVisited[y][x] = true;

        for (int i = 0; i < 4; i ++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!isVisited[nextY][nextX] && map[nextY][nextX] > 0) {
                dfs(nextX, nextY);
            }
        }

    }

//    static void printMap() throws IOException {
//        System.out.println("==========================");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    static void bfs() throws IOException {
        Deque<Node> q = new ArrayDeque<>();
        isVisited = new boolean[n][m];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            q.add(new Node(node.x, node.y, node.h));
        }

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (isInRange(nextX, nextY) && !isVisited[nextY][nextX] && map[nextY][nextX] != 0) {
                    // 여기서 Queue에 add를 안하는 이유는, 그래야만 한 페이즈씩 끊어서 빙산의 개수를 확인할 수 있다.
                    decreaseHeight(nextX, nextY);
                    isVisited[nextY][nextX] = true;
                }
            }
        }

    }

    static void decreaseHeight(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isInRange(nextX, nextY) && !isVisited[nextY][nextX] && map[nextY][nextX] == 0) {
                if (1 <= map[y][x]) {
                    map[y][x]--;
                }
            }
        }
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
