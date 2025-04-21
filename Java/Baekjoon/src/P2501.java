import java.util.*;
import java.io.*;

public class P2501 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int K;
    static int answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = -1;

    }

    static void solve() throws IOException {

        int num = 1;
        int cnt = 0;
        while (true) {

            if (num > N) {
                answer = 0;
                break;
            }

            if (N % num == 0) {
                cnt++;
            }

            if (cnt == K) {
                answer = num;
                break;
            }
            num++;
        }

    }

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
