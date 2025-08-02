import java.util.*;
import java.io.*;

public class P1940 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] ingredient;

    static int answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ingredient = new int[N];

        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() throws IOException {
        if (200000 < M) {
            bw.write("0");
        } else {
            for (int i = 0; i < N; i++) {
//                if (ingredient[i] == -1) {
//                    continue;
//                }
                for (int j = i + 1; j < N; j++) {
//                    if (ingredient[j] == -1) {
//                        continue;
//                    }
                    if (ingredient[i] + ingredient[j] == M) {
                        answer++;
//                        ingredient[i] = -1;
//                        ingredient[j] = -1;
                    }
                }
            }
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
