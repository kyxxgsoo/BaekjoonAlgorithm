import java.util.*;
import java.io.*;

public class P2231 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int n;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
    }

    static int solve(int num) throws IOException {
        for (int i = 1; i < num; i++) {
            int sum = i;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == num) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        init();

        bw.write(String.valueOf(solve(n)));

        bw.flush();
        bw.close();
        br.close();
    }

}
