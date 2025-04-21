import java.util.*;
import java.io.*;

public class P11720 {

    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder sb;

    static int N;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder(br.readLine());
    }

    static int solve() throws IOException {
        int sum = 0;

        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        init();

        bw.write(String.valueOf(solve()));

        bw.flush();
        bw.close();
        br.close();
    }
}
