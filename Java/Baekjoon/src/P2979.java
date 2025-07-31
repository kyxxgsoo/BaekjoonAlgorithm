import java.util.*;
import java.io.*;

public class P2979 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int A;
    static int B;
    static int C;

    static int[] time;
    static int answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        time = new int[101];
        answer = 0;
    }

//    static void print() {
//        for (int i = 1; i <= 100; i++) {
//            System.out.print(time[i] + " ");
//        }
//    }

    static void solve() throws IOException {

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                time[j] ++;
            }
        }

        for (int i = 1; i <= 100; i++) {
            if (time[i] == 1) {
                answer += A;
            } else if (time[i] == 2) {
                answer += B * 2;
            } else if (time[i] == 3) {
                answer += C * 3;
            }
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();

    }

}
