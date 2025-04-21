import java.util.*;
import java.io.*;

public class P1152 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
    }

    static int solve() throws IOException {

        return st.countTokens();
    }

    public static void main(String[] args) throws IOException {
        init();

        bw.write(String.valueOf(solve()));

        bw.flush();
        bw.close();
        br.close();

    }
}
