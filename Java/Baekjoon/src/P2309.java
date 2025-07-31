//import java.util.*;
//import java.io.*;
//
//public class P2309 {
//
//    static BufferedReader br;
//    static BufferedWriter bw;
//
//    static StringTokenizer st;
//    static int[] heights;
//    static int[] output;
//    static boolean endFlag;
//
//    static void init() throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        heights = new int[9];
//        output = new int[7];
//        endFlag = false;
//
//        for (int i = 0; i < heights.length; i++) {
//            heights[i] = Integer.parseInt(br.readLine());
//        }
//    }
//
//    static void solve() throws IOException {
//        dfs1(0);
//    }
//
//    static void swap(int a, int b) {
//        int temp = heights[a];
//        heights[a] = heights[b];
//        heights[b] = temp;
//    }
//
//    static void dfs1(int depth) throws IOException {
//        if (endFlag) {
//            return;
//        }
//
//        if (depth == 7) {
//            if (isOneHundred()) {
//                endFlag = true;
//                print();
//            }
//            return;
//        }
//
//        for (int i = depth; i < heights.length; i++) {
//            swap(depth, i);
//            dfs1(depth + 1);
//            swap(depth, i);
//        }
//    }
//
//    static void print() throws IOException {
//        for (int i = 0; i < 7; i++) {
//            output[i] = heights[i];
//        }
//        Arrays.sort(output);
//        for (int i = 0; i < 7; i++) {
//            bw.write(output[i] + "\n");
//        }
//    }
//
//    static boolean isOneHundred() {
//        int sum = 0;
//        for (int i = 0; i < 7; i++) {
//            sum += heights[i];
//        }
//        return sum == 100;
//    }
//
//    public static void main(String[] args) throws IOException {
//        init();
//        solve();
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}


// ------------------------------
import java.util.*;
import java.io.*;

public class P2309 {

    static BufferedReader br;
    static BufferedWriter bw;

    static StringTokenizer st;
    static int[] heights;
    static int[] answer;
    static boolean endFlag;
    static boolean[] isVisited;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        heights = new int[9];
        answer = new int[7];
        endFlag = false;
        isVisited = new boolean[9];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() throws IOException {
        dfs2(0);
    }

    static void dfs2(int depth) throws IOException {
        if (endFlag) {
            return;
        }

        if (depth == 7) {
            if (isOneHundred()) {
                endFlag = true;
                print();
            }
            return;
        }

        for (int i = 0; i < heights.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                answer[depth] = heights[i];
                dfs2(depth + 1);
                answer[depth] = 0; // 없어도 되는 코드 (디버깅을 위해 작성)
                isVisited[i] = false;
            }
        }
    }

    static void print() throws IOException {
        Arrays.sort(answer);
        for (int i = 0; i < 7; i++) {
            bw.write(answer[i] + "\n");
        }
    }

    static boolean isOneHundred() {
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += answer[i];
        }
        return sum == 100;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();
    }
}
