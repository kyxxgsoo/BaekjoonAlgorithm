import java.util.*;
import java.io.*;

public class P14888 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int[] A;
    static int[] operCnt;
    static int min;
    static int max;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        min = 1000000001;
        max = -1000000001;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        operCnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operCnt[i] = Integer.parseInt(st.nextToken());
        }
    }

    // idx(몇 번째 순서인지), oper(어떤 연산자를 사용해야 하는지)
    static void recursion(int idx, int ret) throws IOException {

        // 기저 사례 1. N번째 숫자까지 모두 더한 경우
        if (idx == N - 1) {
            min = Math.min(ret, min);
            max = Math.max(ret, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operCnt[i] > 0) {
                operCnt[i]--;
                if (i == 0) {
                    recursion(idx + 1, ret + A[idx + 1]);
                } else if (i == 1) {
                    recursion(idx + 1, ret - A[idx + 1]);
                } else if (i == 2) {
                    recursion(idx + 1, ret * A[idx + 1]);
                } else if (i == 3) {
                    recursion(idx + 1, ret / A[idx + 1]);
                }
                operCnt[i]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        init();

        recursion(0, A[0]);

        bw.write(max + "\n" + min);

        bw.flush();
        bw.close();
        br.close();

    }
}
