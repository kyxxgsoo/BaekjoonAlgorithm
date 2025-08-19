import java.util.*;
import java.io.*;

public class P11404 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static int m;
    static long[][] dist;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (cost < dist[from][to]) {
                dist[from][to] = cost;
            }

        }

    }

    static void solve() throws IOException {

        // 경유지
        for (int mid = 1; mid <= n; mid++) {
            // 출발지
            for (int from = 1; from <= n; from++) {
                // 도착지
                for (int to = 1; to <= n; to++) {
                    dist[from][to] = Math.min(dist[from][to], dist[from][mid] + dist[mid][to]);
                }
            }
        }

        for (int from = 1; from <= n; from++) {
            for (int to = 1; to <= n; to++) {
                if (dist[from][to] == Integer.MAX_VALUE) {
                    bw.write("0 ");
                } else {
                    bw.write(dist[from][to] + " ");
                }
            }
            bw.write("\n");
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
