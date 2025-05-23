import java.util.*;
import java.io.*;

public class P1753 {

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

    static int V;
    static int E;
    static int K;

    static int answer;

    static Map<Integer, List<Edge>> graph;
    static Set<Integer> nodeNumbers;

    static Comparator<Node> comp = new Comparator<>() {
      @Override
      public int compare(Node n1, Node n2) {
          return n1.cost - n2.cost;
      }
    };

    // Method
    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new HashMap<>();
        nodeNumbers = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

    }

    static void solve() throws IOException {

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            addEdge(u, v, w);
        }

        List<Integer> sortedNodeNumbers = new ArrayList<>(nodeNumbers);
        Collections.sort(sortedNodeNumbers);

        Map<Integer, Integer> result = dijkstra();

        for (int i = 1; i <= V; i++) {
            bw.write(result.getOrDefault(i, Integer.MAX_VALUE) != Integer.MAX_VALUE ? String.valueOf(result.getOrDefault(i, Integer.MAX_VALUE)) : "INF");
            bw.newLine();
        }

    }

    static Map<Integer, Integer> dijkstra() throws IOException {

        Queue<Node> pq = new PriorityQueue<>(comp);
        Map<Integer, Integer> distances = new HashMap<>();
        pq.offer(new Node(K, 0));

        distances.put(K, 0);

        while (!pq.isEmpty()) {
            Node curNode = pq.remove();
            int curNum = curNode.num;
            int curCost = curNode.cost;

            if (curCost > distances.getOrDefault(curNum, Integer.MAX_VALUE)) {
                continue;
            }

            for (Edge edge: graph.getOrDefault(curNum, Collections.emptyList())) {
                int nextNum = edge.to;
                int nextCost = curCost + edge.weight;

                if (nextCost < distances.getOrDefault(nextNum, Integer.MAX_VALUE)) {
                    pq.offer(new Node(nextNum, nextCost));
                    distances.put(nextNum, nextCost);
                }
            }
        }
        return distances;
    }

    static void addEdge(int u, int v, int w) throws IOException {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
        nodeNumbers.add(u);
        nodeNumbers.add(v);
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }

}
