import java.util.*;
import java.io.*;

public class P2667 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int n;
    private static int[][] graph;
    private static int resultCnt;
    private static ArrayList<Integer> resultArr;
    private static ArrayList<Node> nodes;
    private static boolean visited[][];
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][];
        resultCnt = 0;
        resultArr = new ArrayList<>();
        visited = new boolean[n + 1][n + 1];
        nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] row = br.readLine().chars().map(c -> c - '0').toArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    nodes.add(new Node(j ,i));
                }
            }
            graph[i] = row;
        }
    }

    private static void solution() throws IOException {
        init();

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (!visited[node.y][node.x]) {
                resultCnt++;
                bfs(node.x, node.y);
            }
        }
        bw.write(String.valueOf(resultCnt) + "\n");

        Collections.sort(resultArr);

        for (int i = 0; i < resultArr.size(); i++) {
            bw.write(String.valueOf(resultArr.get(i)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) throws IOException {
        Deque<Node> q = new LinkedList<>();
        int cnt = 0;

        visited[y][x] = true;
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            cnt++;
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];


                if (isInRange(nextX, nextY) && !visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    q.add(new Node(nextX, nextY));
                }
            }
        }
        resultArr.add(cnt);
    }

    private static boolean isInRange(int x, int y)
    {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }
        return false;
    }
}
