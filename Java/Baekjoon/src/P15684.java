import java.util.*;
import java.io.*;

public class P15684 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int M;
    static int H;

    static int[][] graph;
    static int answer;
    static int cnt;

    static boolean[][] isVisited;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H + 1][N + 1];
        isVisited = new boolean[H + 1][N + 1];

        answer = Integer.MAX_VALUE;
        cnt = 0;

        // graph 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                graph[j][i] =  i;
            }
        }

//        printGraph();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            setBar(x, y);
        }

//        printGraph();
//        printIsVisited();

    }

    /***
     * 그래프 프린트
     */
    static void printGraph() {
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    /***
     * isAlready 프린트
     */
    static void printIsVisited() {
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(isVisited[i][j] + " ");
            }
            System.out.println();
        }
    }

    /***
     * 사다리의 세로선을 양쪽으로 연결하는 함수
     * @param x
     * @param y
     * @throws IOException
     */
    static void setBar(int x, int y) throws IOException {
        graph[y][x] = x + 1;
        graph[y][x + 1] = x;
        isVisited[y][x] = true;
        isVisited[y][x + 1] = true;
    }

    static void removeBar(int x, int y) throws IOException {
        graph[y][x] = x;
        graph[y][x + 1] = x + 1;
        isVisited[y][x] = false;
        isVisited[y][x + 1] = false;

    }

    static boolean canSetBar(int x, int y) {
//        System.out.println("canSetBar : " + x + "," + y);
        if (!isVisited[y][x] && !isVisited[y][x + 1]) {
            return true;
        }
        return false;
    }

    static boolean isInRange(int x, int y) {
        if (1 <= y && y <= H && 1 <= x && x <= N) {
            return true;
        }
        return false;
    }

//    static void dfs(int curX, int curY) throws IOException {
//        if (simulation()) {
//            answer = Math.min(answer, cnt);
//            System.out.println(answer);
//            return;
//        }
//
////        for (int y = 1; y <= H; y++) {
////            for (int x = 1; x <= N; x++) {
////                if (isInRange(x, y) && canSetBar(x, y)) {
////                    setBar(x, y);
////
////                }
////            }
////        }
//
////        System.out.println("dfs: " + curX + " | " + curY);
////        printGraph();
////        printIsVisited();
////
////        System.out.println(isInRange(curX, curY + 1));
////        System.out.println(canSetBar(curX, curY + 1));
//
//        for (int y = 1; y <= H; y++) {
//            for (int x = 1; x <= N; x++) {
//                if (isInRange(x, y) && canSetBar(x, y)) {
//                    cnt++;
//                    setBar(curX, curY + 1);
//                    dfs(curX, curY + 1);
//                    removeBar(curX, curY + 1);
//                }
//
//            }
//
//        }
//
//    }

    static void dfs(int curX, int curY) throws IOException {
        if (cnt > 3) return;

        if (simulation()) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int y = curY; y <= H; y++) {
            for (int x = 1; x < N; x++) { // 가로선은 N-1까지만 가능
                if (canSetBar(x, y)) {
                    setBar(x, y);
                    cnt++;
                    dfs(x, y);  // 현재 좌표 기준으로 다시 탐색
                    removeBar(x, y);
                    cnt--;
                }
            }
        }
    }


    /***
     * 시뮬레이션을 돌렸을 때, i번 사다리 결과가 i인 경우 return true/ 아니면 false
     * @return
     * @throws IOException
     */
    static boolean simulation() throws IOException {
        // 1번 ~ N번 사다리 직접 시뮬레이션
        for (int n = 1; n <= N; n++) {
            int curX = n;
            for (int h = 1; h <= H; h++) {
                curX = graph[h][curX];
            }
            if (curX != n) {
                return false;
            }
        }
        return true;
    }

    static void solve() throws IOException {
//        System.out.println(simulation());

        dfs(1, 1);

        if (answer == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(answer + "");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
