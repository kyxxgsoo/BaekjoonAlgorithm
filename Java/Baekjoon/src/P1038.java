import java.util.*;
import java.io.*;

public class P1038 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static List<Long> numbers;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();

    }

    static void solve() throws IOException {
        // 일단 감소하는 모든 수들을 넣은 후 정렬
        // 어차피 감소 가능한 가장 큰 수는 9876543210
        // 즉, 10C1 ~ 10C10까지 모든 수를 더한 값이 전체 나올 수 있는 경우의 수임.
        for (int i = 0; i < 10; i++) {
            dfs(1, i);
        }

        Collections.sort(numbers);

        if (N >= numbers.size()) {
            bw.write(-1 + "");
        } else {
            bw.write(numbers.get(N) + "");
        }

    }

    static void dfs(int digit, long num) throws IOException {
        if (digit > 10) {
            return;
        }

        numbers.add(num);

        for (int i = 0; i < num % 10; i++) {
            dfs(digit + 1, num * 10 + i);
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
