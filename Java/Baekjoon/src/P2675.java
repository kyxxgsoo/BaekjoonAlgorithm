import java.util.*;
import java.io.*;

public class P2675 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
    }

    static String solve() throws IOException {

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder(st.nextToken());
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < R; j++) {
                ret.append(sb.charAt(i));
            }
            // String.repeat()이라는 함수도 있지만 반복문(for)으로 해결하는게 좀 더 빠르다.
//            ret.append(String.valueOf(sb.charAt(i)).repeat(R));
        }

        return ret.toString();
    }

    public static void main(String[] args) throws IOException {

        init();

        for (int i = 0; i < T; i++) {
            bw.write(solve() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
