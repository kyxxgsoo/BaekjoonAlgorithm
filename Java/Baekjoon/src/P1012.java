import java.util.*;
import java.io.*;

public class P1012 {

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int[][] graph;
    private static int t;
    private static int m;
    private static int n;
    private static int k;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static ArrayList<Node> nodes;

    private static boolean[][] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];
        nodes = new ArrayList<>();
        visited = new boolean[n + 1][m + 1];
        answer = 0;

        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y][x] = 1;
            nodes.add(new Node(x, y));
        }
    }

    private static void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            init();
            for (int j = 0; j < nodes.size(); j++) {
                Node node = nodes.get(j);
                if (!visited[node.y][node.x]) {
                    answer++;
                    bfs(node.x, node.y);
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(int x, int y) throws IOException {
        Deque<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.remove();
            int curX = node.x;
            int curY = node.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (isInRange(nextX, nextY) && !visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                    q.add(new Node(nextX, nextY));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    private static boolean isInRange(int x, int y) throws IOException {
        if (0 <= x && x < m && 0 <= y && y < n){
            return true;
        }
        return false;
    }
}
