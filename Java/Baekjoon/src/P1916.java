import java.util.*;
import java.io.*;

public class P1916 {

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
    static int m;
    static int answer;

    static int start;
    static int target;

    static Map<Integer, List<Edge>> graph;
    static Map<Integer, Integer> distances;

    static Comparator<Node> comp = new Comparator<>() {
      @Override
      public int compare(Node n1, Node n2) {

          // 이렇게 해야 오름차순
          return n1.cost - n2.cost;
      }
    };

    // Method

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        answer = 0;

        graph = new HashMap<>();
        distances = new HashMap<>();

    }

    // 간선이 단방향(버스가 한 방향으로만 흐른다.)
    static void addEdge(int v1, int v2, int w) {
        graph.computeIfAbsent(v1, k -> new ArrayList<>()).add(new Edge(v2, w));
    }

    static void solve() throws IOException {
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            addEdge(v1, v2, w);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra() throws IOException {
        Queue<Node> pq = new PriorityQueue<>(comp);
        // pq: 앞으로 갈 수 있는 노드들
        // distances: 현재까지 방문한 노드들의 최단거리
        // 두 개를 모두 cost가 0인 상태로 초기화 후 시작
        pq.offer(new Node(start, 0));
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            Node curNode = pq.remove();
            int curNum = curNode.num;
            int curCost = curNode.cost;

            // 현재 방문한 노드의 누적 비용이 기존 비용보다 더 크면 스킵, 아니면 진행. (그러나 안나왔으면 정수형 최댓값을 집어넣어 아직 이전에 방문되지 않았음을 표시)
            if (curCost > distances.getOrDefault(curNum, Integer.MAX_VALUE)) {
                continue;
            }

            // 그래프에서 현재 노드에 연결된 리스트들을 불러오기. (만약 연결된 리스트들이 없다면 빈 리스트를 반환)
            for (Edge edge: graph.getOrDefault(curNum, Collections.emptyList())) {
                int nextNum = edge.to;
                int nextCost = curCost + edge.weight;

                // 다음 코스트가 distances에 해당 노드까지 도달하는데 가장 작다고 저장된 비용보다 적으면 갱신
                if (nextCost < distances.getOrDefault(nextNum, Integer.MAX_VALUE)) {
                    pq.offer(new Node(nextNum, nextCost));
                    distances.put(nextNum, nextCost);
                }
            }
        }

    }

    static public void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(String.valueOf(distances.get(target)));

        bw.flush();
        bw.close();
        br.close();


    }
}
