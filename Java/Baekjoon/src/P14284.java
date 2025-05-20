import java.util.*;
import java.io.*;

public class P14284 {

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

    static BufferedReader br;
    static BufferedWriter bw;


    static int n;
    static int m;
    static int answer;

    static int s;
    static int t;

    static Map<Integer, List<Edge>> map;
    static Map<Integer, Integer> distants;

    static Comparator<Node> comp = new Comparator<>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.cost - n2.cost;
        }
    };

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new HashMap<>();

    }

    static void dijkstra() throws IOException {
        // 다익스트라에 사용할 시작 점과 해당 노드에 대한 가중치(default: 0)를 초기화
        // PriorityQueue는 현재 접근 가능한 가장 가까운 정점을 "거리순"으로 꺼내기 위해서
        Queue<Node> pq = new PriorityQueue<>(comp);
        // distants: 최단 거리 테이블 -> start부터 각 정점까지 최소 비용을 저장
        // (bfs의 isVisited랑 비슷하다 보면 된다. 단, 방문 여부만 저장하는 것이 아니라 현재까지의 누적 cost도 같이 저장.)
        distants = new HashMap<>();
        pq.offer(new Node(s, 0));
        distants.put(s, 0);

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            // 현재 노드 번호
            int curNum = curNode.num;
            // 현재까지 도달하기 위한 누적 cost
            int curCost = curNode.cost;


            // 현재 노드까지의 누적 cost보다 이전에 더 짧은 거리로 도달할 수 있는 경우(distants에 미리 저장되어 있는게 더 작다면)이면 스킵(이미 더 짧은 거리로 현재 노드까지 왔을 때) skip;
            // distants.getOrDefault()에서 발견되지 않았다면 Integer.MAX_VALUE를 반환하는 이유는 distants는 현재까지 발견된 노드들에 도달하기 위한
            // 최소 cost 경로인데, distants에서 get()할 수 없다는 것은 아직 발견되지 않았다는 것이므로 무조건 distants값을 갱신해야 한다.
            // 즉, skip을 하면 안되므로 curCost보다 무조건 큰 Integer.MAX_VALUE 값을 넣어 스킵하지 않고 아래 코드에서 distants를 갱신해야 한다.
            if (curCost > distants.getOrDefault(curNum, Integer.MAX_VALUE)) {
                continue;
            }

            for (Edge edge: map.getOrDefault(curNode.num, Collections.emptyList())) {
                int nextNum = edge.to;
                int nextCost = curCost + edge.weight;

                // 현재 노드까지의 Cost와 간선의 가중치를 더해 nextCost를 갱신한 후,
                // distants에서 getOrDefault()를 통해 이전에 방문했는지? (value가 있는지?) 방문했다면 이전의 cost와 비교해서 더 작은지? (더 작아야만 갱신)
                // 비교하고 방금 계산한 nextCost가 이전에 방문한 가중치의 누적합보다 작다면 distants 갱신 및 pq에 해당 상태를 추가.
                if (nextCost < distants.getOrDefault(nextNum, Integer.MAX_VALUE)) {
                    distants.put(nextNum, nextCost);
                    pq.offer(new Node(nextNum, nextCost));
                }
            }
        }
    }

    static void addEdge(int v1, int v2, int weight) throws IOException {
        map.computeIfAbsent(v1, k -> new ArrayList<>()).add(new Edge(v2, weight));
        map.computeIfAbsent(v2, k -> new ArrayList<>()).add(new Edge(v1, weight));
    }

    static void solve() throws IOException {

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            addEdge(v1, v2, weight);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dijkstra();

        answer = distants.get(t);

    }

    public static void main(String[] args) throws IOException {

        init();
        solve();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
