import java.util.*;
import java.io.*;

public class P1629 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static long A;
    static long B;
    static long C;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
    }

    static void solve() throws IOException {
        /*
        Math.pow(i, N)는 O(N)의 시간 복잡도를 가진다.
        따라서 해당 연산을 사용하게 되면 for(int i = 0 ~ N)까지 도는 것과 같다.
        다만 해당 문제에서 A, B, C의 범위는 Integer.MAX_VALUE이므로 해당 문제를
        위와 같은 방식으로 풀게 되면 시간초과가 날 수 밖에 없다.
         */

        /*
        또한, 정수론 개념 중
        "(A + B) % C = A % C + B % C" 와 같고
        "(A * B) % C = A % C * B % C" 와 같다.
         */

//        bw.write((long)((Math.pow(A % C, B % C))) + "");

        // 따라서 재귀를 통한 분할 정복을 써야된다.

        bw.write(dfs(B) + "");

    }

    static long dfs(long power) {
        if (power == 1) {
            return A % C;
        }

        long ret = dfs(power / 2);

        ret = (ret * ret) % C;


        // b가 홀수면 마지막에 한 번 더 곱하기
        if (power % 2 != 0) {
            ret *= A % C;
        }

        return ret % C;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
