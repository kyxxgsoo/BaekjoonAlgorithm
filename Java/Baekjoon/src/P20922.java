import java.util.*;
import java.io.*;

public class P20922 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int K;
    static int[] arr;
    static int answer;
    static int[] numCnt;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        numCnt = new int[100001];

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() throws IOException {
        int left = 0;


        for (int right = 0; right < arr.length; right++) {
            numCnt[arr[right]]++;
            while (numCnt[arr[right]] > K) {
                numCnt[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }
        bw.write(String.valueOf(answer));
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.close();
        br.close();
    }
}
