import java.util.*;
import java.io.*;

public class P11055 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int[] A;
    static int[] sum;
    static int maxSum;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        sum = new int[N];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // sum값을 A로 초기화(최악의 경우 자기 자신이 가장 큰 값)
            sum[i] = A[i];
        }
    }

    static void solve() throws IOException {

        for (int cur = 0; cur < A.length; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (A[prev] < A[cur]) {
                    sum[cur] = Math.max(sum[cur], sum[prev] + A[cur]);
                }
            }
            maxSum = Math.max(maxSum, sum[cur]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(sum[i] + " ");
        }

        bw.write(maxSum + "");

    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
