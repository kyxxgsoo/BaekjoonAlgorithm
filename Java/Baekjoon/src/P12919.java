import java.util.*;
import java.io.*;

public class P12919 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static String s;
    static StringBuilder t;
    static int answer;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        t = new StringBuilder(br.readLine());
        answer = 0;
    }

    static void solve() throws IOException {
        dfs(t);
    }

    static void dfs(StringBuilder t) throws IOException {

        if (t.length() == s.length()) {
            if (t.toString().equals(s)) {
                answer = 1;
            }
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            t.deleteCharAt(t.length() - 1);
            dfs(t);
            t.append('A');
        }

        if (t.charAt(0) == 'B') {
            t.reverse();
            t.deleteCharAt(t.length() - 1);
            dfs(t);
            t.append('B');
            t.reverse();
        }
    }

    /*
    A
    BA
    BAB
    BABA
     */

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();

    }
}
