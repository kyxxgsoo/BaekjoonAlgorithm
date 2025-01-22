import java.util.*;
import java.io.*;

public class P2606 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n;
    private static int m;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int result;


    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    private static void solution() throws IOException {
        init();

        bfs(1);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int num) {
        Deque<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        visited[num] = true;
        q.add(num);

        while (!q.isEmpty()) {
            int curNum = q.remove();

            for (int i = 0; i < graph.get(curNum).size(); i++) {
                int nextNum = graph.get(curNum).get(i);
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    q.add(nextNum);
                    result++;
                }
            }
        }
    }

}
