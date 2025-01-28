import java.util.*;
import java.io.*;

public class P1697 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int n;
    private static int k;
    private static int[] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solution();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        visited = new boolean[100001];

    }

    private static void solution() throws IOException {
        init();
        bfs();
        bw.write(String.valueOf(arr[k]));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Deque<Integer> q = new LinkedList<>();
        q.add(n);
        arr[n] = 0;
        visited[n] = true;

        while (!q.isEmpty()) {
            int curX = q.remove();

            for (int i = 0; i < 3; i++) {
                int nextX = curX;
                if (i == 0) {
                    nextX++;
                } else if (i == 1) {
                    nextX--;
                } else if (i == 2) {
                    nextX *= 2;
                }

                if (isInRange(nextX) && !visited[nextX]) {
                    q.add(nextX);
                    arr[nextX] = arr[curX] + 1;
                    visited[nextX] = true;
                    if (nextX == k) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean isInRange(int x) {
        if (0 <= x && x <= 100000) {
            return true;
        }
        return false;
    }
}
