import java.util.*;
import java.io.*;

public class P16236 {

    static class Fish {
        int x;
        int y;
        int size;

        Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;

    static int answer;
    static int n;
    static int[][] graph;

    static List<Fish> fishes;

    static Comparator<Fish> comp = new Comparator<>() {

        @Override
        public int compare(Fish f1, Fish f2) {
            if (f1.size == f2.size) {
                if (f1.x == f2.x) {
                    return f1.y - f2.y;
                }
                return f1.x - f2.x;
            }

            return f1.size - f2.size;
        }
    };

    static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = 0;
        n = Integer.parseInt(br.readLine());

        fishes = new ArrayList<>();

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 9) {
                    // 물고기들 중 아기 상어와 가장 가까이 있는 물고기를 구하기 위해 저장
                    fishes.add(new Fish(j, i, graph[i][j]));
                }
            }
        }

        Collections.sort(fishes, comp);

    }

    static void printFishes() {
        for (int i = 0; i < fishes.size(); i++) {
            System.out.print(fishes.get(i).size + " ");
        }
    }

    // log용
    static void printGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // TODO: 구현
    static void bfs() {

    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
