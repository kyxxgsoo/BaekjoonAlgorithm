import java.util.*;
import java.io.*;

public class P14002 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int[] A;
    static int answer;
    static int[] lengthCache;
    static int[] traceArr;
    static int startIdx;

    static List<Integer> lis;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        lengthCache = new int[N];
        traceArr = new int[N];
        lis = new ArrayList<>();

        answer = 1;
        startIdx = 0;  // 첫 번째 원소로 초기화

        Arrays.fill(lengthCache, 1);
        // idx = -1인 경우는 존재할 수 없기 때문에 기저사례로 선택
        Arrays.fill(traceArr, -1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void trace(int idx) {
        if (idx == -1) {
            return;
        }
        
        trace(traceArr[idx]);
        lis.add(A[idx]);
    }

    static void solve() throws IOException {

        for (int cur = 0; cur < A.length; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                // 증가하는 수열이면서, 기존 길이보다 커야함.(작거나 같으면 갱신)
                if (A[prev] < A[cur] && lengthCache[cur] <= lengthCache[prev]) {
                    lengthCache[cur] = lengthCache[prev] + 1;
                    traceArr[cur] = prev;
                }
            }

            if (answer < lengthCache[cur]) {
                answer = lengthCache[cur];
                startIdx = cur;
            }
        }

        bw.write(answer + "\n");
        trace(startIdx);

        for (int i = 0; i < lis.size(); i++) {
            bw.write(lis.get(i) + " ");
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
