import java.io.*;
import java.util.*;

public class P1463 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    static int[] arr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[1000001];

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

    }

    static void solve() throws IOException {
        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
//                System.out.println(1);
                arr[i] = Math.min(arr[i / 3], arr[i / 2]) + 1;
            } else if (i % 3 == 0) {
//                System.out.println(2);
                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
            } else if (i % 2 == 0) {
//                System.out.println(3);
                arr[i] = Math.min(arr[i / 2], arr[i - 1])  + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(String.valueOf(arr[n]));

        bw.close();
        br.close();

    }
}
