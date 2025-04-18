import java.io.*;
import java.util.*;

public class P2839 {
    static BufferedReader br;
    static BufferedWriter bw;
//    static StringTokenizer st;
    static int n;
    static int[] arr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[5001];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        arr[3] = 1;
        arr[5] = 1;
    }

    static void solve() throws IOException {
        for (int i = 6; i <= n; i++) {
            if (arr[i - 5] != Integer.MAX_VALUE && arr[i - 3] != Integer.MAX_VALUE) {
                arr[i] = Math.min(arr[i - 5], arr[i - 3]) + 1;
            } else if (arr[i - 5] != Integer.MAX_VALUE) {
                arr[i] = arr[i - 5] + 1;
            } else if (arr[i - 3] != Integer.MAX_VALUE) {
                arr[i] = arr[i - 3] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solve();

        if (arr[n] == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(arr[n]));
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
