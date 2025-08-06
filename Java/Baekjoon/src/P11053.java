import java.util.*;
import java.io.*;

public class P11053 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int[] A;
    static int[] cache;
    static int[] traceIdx;
    static int answer;
    static int startIdx;

    static List<Integer> lis;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        cache = new int[N];
        traceIdx = new int[N];
        answer = 1;
        startIdx = -1;
        lis = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 길이가 1이므로 1로 초기화.
        Arrays.fill(cache, 1);
        // cache[curIdx] = prevIdx에 대한 정보를
        // 저장하기 위한 용도로 사용.
        // 방문하지 않았음을 표시해야하므로 -1로 초기화
        Arrays.fill(traceIdx, -1);

    }

    static void trace(int idx) {
        if (idx == -1) {
            return;
        }

        trace(traceIdx[idx]);

        lis.add(A[idx]);
    }

    static void solve() throws IOException {

        for (int cur = 0; cur < A.length; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (A[prev] < A[cur] && cache[cur] < cache[prev] + 1) {
                    cache[cur] = cache[prev] + 1;
                    traceIdx[cur] = prev;
                    // 최댓값 갱신
                    if (answer < cache[cur]) {
                        answer = cache[cur];
                        startIdx = cur;
                    }
                }
            }
        }

        bw.write(answer + "\n");

//        trace(startIdx);
//        for (int i = 0; i < lis.size(); i++) {
//            bw.write(lis.get(i) + " ");
//        }

    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
