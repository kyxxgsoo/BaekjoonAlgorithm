import java.util.*;
import java.io.*;

public class P9663 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int answer;
    static int[] board; // board의 index가 y, value가 x

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N];
        answer = 0;
    }

    static boolean isPossible(int x, int y) {
        for (int i = 0; i < y; i++) {
            if (board[i] == x || Math.abs((y - i)) == Math.abs(x - board[i])) {
                return false;
            }
        }
        return true;
    }

    static void recursion(int y) {

        if (y == N) {
            answer++;
            return;
        }


        for (int x = 0; x < N; x++) {
            if (isPossible(x, y)) {
                board[y] = x;
                recursion(y + 1);
            }
        }



    }


    public static void main(String[] args) throws IOException {
        init();

        recursion(0);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();

    }
}
