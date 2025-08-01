import java.util.*;
import java.io.*;

public class P2559 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int K;

    static int[] arr;
    static int[] pSum;

    static int answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pSum = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());

        // arr 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pSum[0] = arr[0];

        // 누적합 구하기
        for (int i = 1; i < N; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
        }
    }

    static void printPrefixSum() {
        System.out.print("pSum[] : ");
        for (int i = 0; i < N; i++) {
            System.out.print(pSum[i] + " ");
        }
        System.out.println();
    }

    static void solve() throws IOException {
        // [log] pSum
//        printPrefixSum();

        answer = pSum[K - 1];
        for (int i = K; i < N; i++) {
            answer = Math.max(answer, pSum[i] - pSum[i - K]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
