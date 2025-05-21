import java.util.*;
import java.io.*;

public class P1504 {

    // Class
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    // Variable
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int e;
    static int v1;
    static int v2;
    static int answer;

    static Map<Integer, List<Edge>> graph;

    static Comparator<Node> comp = new Comparator<>() {
        // pq cost기준 오름차순 정렬
        @Override
        public int compare(Node n1, Node n2) {
            return n1.cost - n2.cost;
        }
    };

    // Method
    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        answer = 0;

        graph = new HashMap<>();
    }

    static void addEdge(int u, int v, int w) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, w));
    }

    static void printGraph() {

        for (int i = 1; i <= n; i++) {
            System.out.println("<" + i + ">");
            for (Edge e: graph.getOrDefault(i, Collections.emptyList())) {
                System.out.println(e.to + " " + e.weight);
            }
        }
    }

    static void solve() throws IOException {


        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 그래프에 간선 추가(무방향)
            addEdge(u, v, w);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int firstPathResult = mergePath(dijkstra(1, v1), dijkstra(v1, v2), dijkstra(v2, n));
        int secondPathResult = mergePath(dijkstra(1, v2), dijkstra(v2, v1), dijkstra(v1, n));

        answer = Math.min(firstPathResult, secondPathResult) != Integer.MAX_VALUE ? Math.min(firstPathResult, secondPathResult) : -1;
    }

    static int mergePath(int p1, int p2, int p3) {
        if (p1 != -1 && p2 != -1 && p3 != -1) {
            return p1 + p2 + p3;
        }
        return Integer.MAX_VALUE;
    }

    static int dijkstra(int start, int end) throws IOException {
        Queue<Node> pq = new PriorityQueue<>(comp);
        Map<Integer, Integer> distances = new HashMap<>();
        pq.offer(new Node(start, 0));
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            Node curNode = pq.remove();
            int curNum = curNode.num;
            int curCost = curNode.cost;

            // default가 나오면 무조건 거짓이 됨으로 스킵하지 않고 실행 가능
            if (curCost > distances.getOrDefault(curNum, Integer.MAX_VALUE)) {
                continue;
            }

            for (Edge edge: graph.getOrDefault(curNum, Collections.emptyList())) {
                int nextNum = edge.to;
                int nextCost = curCost + edge.weight;

                // 계산한 nextCost가 현재 방문된 Node의 Cost보다 작을 경우 pq에 넣기
                if (nextCost < distances.getOrDefault(nextNum, Integer.MAX_VALUE)) {
                    pq.offer(new Node(nextNum, nextCost));
                    distances.put(nextNum, nextCost);
                }
            }
        }
        return distances.getOrDefault(end, -1);
    }

    public static void main(String[] args) throws IOException {

        init();
        solve();

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
