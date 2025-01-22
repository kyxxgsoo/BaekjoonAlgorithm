import java.io.*;
import java.util.*;

public class P2178 {

    private static int n, m;
    private static int[][] maze;
    private static int[][] result;

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static class Node {
        int x;
        int y;
        int num;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n + 1][];
        result = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int[] row = input.chars().map(c -> c - '0').toArray();
            maze[i] = row;
        }
    }

    private static void solution() throws IOException {
        init();

        bfs(0, 0);

        bw.write(String.valueOf(result[n - 1][m - 1]));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) throws IOException {
        Deque<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[y][x] = true;
        q.addLast(new Node(x, y, 1));
        result[y][x] = 1;

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInRange(nextX, nextY) && !visited[nextY][nextX] && maze[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    q.addLast(new Node(nextX, nextY, curNode.num + 1));
                    result[nextY][nextX] = result[curY][curX] + 1;
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
}
