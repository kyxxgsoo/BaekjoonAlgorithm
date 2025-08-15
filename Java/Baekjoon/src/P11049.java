import java.util.*;
import java.io.*;

public class P11049 {

    static class Matrics {
        int r;
        int c;

        Matrics(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static Matrics[] matrices;
    static int[] numberChain;
    static int answer;
    static int[][] cache;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        matrices = new Matrics[N];
        answer = Integer.MAX_VALUE;
        numberChain = new int[N + 1];
        cache = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrices[i] = new Matrics(r, c);
        }

        for (int i = 0; i < N; i++) {
            numberChain[i] = matrices[i].r;
        }
        numberChain[N] = matrices[N - 1].c;

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
    }

    static void solve() throws IOException {
        answer = dfs(0, N - 1);

        bw.write(answer + "");
    }

    static int dfs(int start, int end) {
        // 행렬이 하나면 비용 0
        if (start == end) {
            return 0;
        }

        // 비둘기집 원리 적용
        if (cache[start][end] != Integer.MAX_VALUE) {
            return cache[start][end];
        }

        int ret = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int left = dfs(start, i);
            int right = dfs(i + 1, end);
            int cost = numberChain[start] * numberChain[i + 1] * numberChain[end + 1];
            int total = left + right + cost;
            if (total < ret) {
                ret = total;
            }
        }

        cache[start][end] = ret;

        return ret;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
