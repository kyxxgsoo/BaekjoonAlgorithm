//import java.util.*;
//import java.io.*;
//
//public class P9095 {
//    static BufferedReader br;
//    static BufferedWriter bw;
//    static int n;
//    static int[] arr;
//    static long[] dp;
//
//    static void init() throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        n = Integer.parseInt(br.readLine());
//
//        dp = new long[11];
//
//        arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 4;
//
//    }
//
//    static void solve() throws IOException {
//        for (int i = 4; i < 11; i++) {
//            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        init();
//        solve();
//
//        for (int i = 0; i < arr.length; i++) {
//            bw.write(dp[arr[i]] + "\n");
//        }
//
//        bw.flush();
//
//        bw.close();
//        br.close();
//    }
//}

//---------------------------------------------------
import java.util.*;
import java.io.*;

public class P9095 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int ret;
    static int[] dp;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ret = Integer.MAX_VALUE;

        dp = new int[12];

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void setVariable() throws IOException {
        ret = 0;
        for (int i = 0; i <= 11; i++) {
            dp[i] = 0;
        }
    }

    static void solve(int sum) throws IOException {
        if(dp[sum] != 0) {
            return;
        }
        if(sum == 11) {
            return;
        }

        for(int i =1; i<=3; i++) {
            dp[sum] += dp[sum-i];
        }
        solve(sum+1);
    }

    public static void main(String[] args) throws IOException {

        init();

        for (int i = 0; i < arr.length; i++) {
//            System.out.println("+++++++++++++++++++++");
//            ret = 0;
            setVariable();
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            if(arr[i] <= 3) {
                bw.write(dp[arr[i]] + "\n");
            } else {
                solve(4);
                bw.write(dp[arr[i]] + "\n");
            }

        }
        bw.flush();

        bw.close();
        br.close();
    }
}
