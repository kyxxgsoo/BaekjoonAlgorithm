import java.util.*;
import java.io.*;

public class P15989 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int t;

    static int[][] cache;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
    }

    static int recursion(int sum, int cur) throws IOException {

        // 비둘기 집 원리 적용
        if (cache[sum][cur] != -1) {
            return cache[sum][cur];
        }

        if (sum == n) {
            return 1;
        }

        int ret = 0;

        // 순열 X, 조합 O -> 원소가 같으면 순서 상관없이 하나로 생각.
        for (int i = cur; i <= 3; i++) {
            if (sum + i <= n) {
                ret += recursion(sum + i, i);
            }
        }

        cache[sum][cur] = ret;

        return cache[sum][cur];
    }

    static void setVariable() {
        cache = new int[n + 1][4];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j <= 3; j++) {
                cache[i][j] = -1;
            }
        }
    }

//    static void printCache() {
//
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j <= 3; j++) {
//                System.out.print(cache[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            setVariable();
            bw.write(recursion(0, 1) + "\n");
//            printCache();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}



// 완탐
//import java.util.*;
//import java.io.*;
//
//public class P15989 {
//
//    static BufferedReader br;
//    static BufferedWriter bw;
//    static StringTokenizer st;
//    static int n;
//    static int t;
//
//    static void init() throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        t = Integer.parseInt(br.readLine());
//    }
//
//    static int recursion(int sum, int cur) throws IOException {
//
//        if (sum == n) {
//            return 1;
//        }
//
//        int ret = 0;
//
//        // 순열 X, 조합 O -> 원소가 같으면 순서 상관없이 하나로 생각.
//        for (int i = cur; i <= 3; i++) {
//            if (sum + i <= n) {
//                ret += recursion(sum + i, i);
//            }
//        }
//
//        return ret;
//    }
//
//    public static void main(String[] args) throws IOException {
//        init();
//
//        for (int i = 0; i < t; i++) {
//            n = Integer.parseInt(br.readLine());
//            bw.write(recursion(0, 1) + "\n");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//}
