import java.util.*;
import java.io.*;

public class P1927 {

    static BufferedReader br;
    static BufferedWriter bw;
    static Queue<Integer> pq;
    static int n;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        pq = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());

    }

    static void solve() throws IOException {
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.remove() + "\n");
                }
            } else {
                pq.add(input);
            }
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
