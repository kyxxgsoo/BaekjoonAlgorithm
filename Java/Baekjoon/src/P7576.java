import java.util.*;
import java.io.*;

public class P7576 {

    private static class Node {
        int x;
        int y;
        int day;

        Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int n;
    private static int m;
    private static int[][] graph;
    private static ArrayList<Node> nodes;
    private static boolean[][] visited;
    private static int answer;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solution();

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];
        nodes = new ArrayList<>();
        visited = new boolean[n + 1][m + 1];
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    nodes.add(new Node(j, i, 0));
                }
            }
        }
    }

    private static void solution() throws IOException {
        init();

        bfs();

        bw.write(String.valueOf(getAnswer()));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Deque<Node> q = new LinkedList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            q.add(node);
            visited[node.y][node.x] = true;
        }

        while (!q.isEmpty()) {
            Node node = q.remove();
            int curX = node.x;
            int curY = node.y;
            int curDay = node.day;
            answer = curDay;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInRange(nextX, nextY) && !visited[nextY][nextX] && graph[nextY][nextX] != -1) {
                    q.add(new Node(nextX, nextY, curDay + 1));
                    visited[nextY][nextX] = true;
                    graph[nextY][nextX] = 1;
                }
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            return true;
        }
        return false;
    }

    private static int getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }
}
