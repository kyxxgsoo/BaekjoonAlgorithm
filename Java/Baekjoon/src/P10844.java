import java.util.*;
import java.io.*;

public class P10844 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static final int MOD = 1_000_000_000;

    static int N;
    static int answer;
    static int[][] cache;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cache = new int[N + 1][10];
        answer = 0;
    }

    static void solve() throws IOException {
        for (int i = 1; i < 10; i++) {
            // N-1 부터 시작하는 이유는 이미 i 하나를 고르고 시작하기 때문.
            answer = (answer + dfs(N - 1, i)) % MOD;
        }

        bw.write(answer + "");

    }

    // N - 1 -> 0으로 top-down 형식으로 구현
    // depth : 선택 할 수 있는 자리 수, num : 마지막에 선택된 숫자
    static int dfs(int depth, int num) throws IOException {
        if (depth == 0) {
            return 1;
        }

        // 비둘기 집 원리 적용
        if (cache[depth][num] != 0) {
            return cache[depth][num];
        }

        int ret = 0;

        if (num > 0) {
            ret = (ret + dfs(depth - 1, num - 1)) % MOD;
        }
        if (num < 9) {
            ret = (ret + dfs(depth - 1, num + 1)) % MOD;
        }

        cache[depth][num] = ret;

        return ret;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }

    /*
    N = 2인 경우),,
    12
    23
    34
    45
    56
    67
    78
    89

    10
    21
    32
    43
    54
    65
    76
    87
    98

     */
}
