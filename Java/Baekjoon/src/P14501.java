//import java.util.*;
//import java.io.*;
//
//public class P14501 {
//
//    static class Counsel {
//        int time;
//        int price;
//
//        Counsel() {
//            this.time = 0;
//            this.price = 0;
//        }
//        Counsel(int time, int price) {
//            this.time = time;
//            this.price = price;
//        }
//    }
//
//    static BufferedReader br;
//    static BufferedWriter bw;
//    static StringTokenizer st;
//    static int n;
//    static int result;
//    static Counsel[] counsels;
//    static boolean[] isVisited;
//
//    static void init() throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        n = Integer.parseInt(br.readLine());
//        result = 0;
//        // 1 ~ n일까지니까 사용하기 쉽게 n + 1로 정의
//        counsels = new Counsel[n + 1];
//        isVisited = new boolean[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int time = Integer.parseInt(st.nextToken());
//            int price = Integer.parseInt(st.nextToken());
//            counsels[i] = new Counsel(time, price);
//        }
//    }
//
//    static void solve(int day, int sum) throws IOException {
//        if (day > n + 1) {
//            return;
//        }
//        if (day == n + 1) {
//            result = Math.max(result, sum);
//            return;
//        }
//
//        // 상담하기
//        solve(day + counsels[day].time, sum + counsels[day].price);
//
//        // 상담 안하고 다음날로 넘어가기
//        solve(day + 1, sum);
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        init();
//
//        solve(1, 0);
//
//        bw.write(String.valueOf(result));
//
//        bw.flush();
//        bw.close();
//        br.close();
//
//
//    }
//}

// -----------------------------

import java.util.*;
import java.io.*;

public class P14501 {

    static class Counsel {
        int time;
        int price;

        Counsel() {
            this.time = 0;
            this.price = 0;
        }

        Counsel(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static Counsel[] counsels;
    static int[] dp;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        // 1 ~ n일까지니까 사용하기 쉽게 n + 1로 정의
        counsels = new Counsel[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            counsels[i] = new Counsel(time, price);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // 상담이 완료 가능하면
            if (counsels[i].time + i <= n) {
                // 가능하고, 상담 했을 때 - dp[i + counsels[i].time] + counsels[i].price : 상담했던 최대값 + 현재 상담값
                // 가능하지만, 상담 안했을 때 - dp[i + 1]
                dp[i] = Math.max(dp[i + counsels[i].time] + counsels[i].price, dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        bw.write(String.valueOf(dp[0]));

        bw.flush();
        bw.close();
        br.close();

    }
}
