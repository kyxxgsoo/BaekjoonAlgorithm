import java.util.*;
import java.io.*;

public class P1094 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int answer;
    static int X;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = 0;
        X = Integer.parseInt(br.readLine());
    }

    static void recursion(int sum, int len, int cnt) throws IOException {

        if (sum + len == X) {
            answer = cnt;
            return;
        }

        // 현재까지 막대의 길이의 합이 X보다 크거나 같다면 하나 버리기
        if (sum + (len / 2) >= X) {
            recursion(sum, len / 2, cnt);
        } else {
            recursion(sum + len / 2, len / 2, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        recursion(0, 64, 1);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();

    }
}
