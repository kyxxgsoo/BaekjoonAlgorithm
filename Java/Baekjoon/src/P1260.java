import java.io.*;
import java.util.*;

public class P1260 {

    private static int n, m, v;
    private static ArrayList<ArrayList<Integer>> graph;

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void init() {

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }

    }

    public static void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        init();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = 0;
            int v2 = 0;
            while (st.hasMoreTokens()) {
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] dfsVisited = new boolean[n + 1];
        dfs(dfsVisited, v);

        bw.newLine();
        boolean[] bfsVisited = new boolean[n + 1];
        bfs(bfsVisited, v);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(boolean[] visited, int cur) throws IOException {
        if (visited[cur]) {
            return;
        }

        visited[cur] = true;
        bw.write(String.valueOf(cur) + " ");

        for (int i = 0; i < graph.get(cur).size(); i++) {
            int next = graph.get(cur).get(i);
            if (!visited[next]) {
                dfs(visited, next);
            }
        }
    }

    private static void bfs(boolean[] visited, int start) throws IOException {
        Deque<Integer> q = new LinkedList<>();

        visited[start] = true;
        bw.write(String.valueOf(start) + " ");
        q.addLast(start);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    bw.write(String.valueOf(next) + " ");
                    q.addLast(next);
                }
            }
        }
    }
}
