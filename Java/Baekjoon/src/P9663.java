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
        // 현재 y보다 윗 행에 대한 값들에 대해서 겹치는게 없는지 비교
        for (int i = 0; i < y; i++) {
            // 같은 열 or 같은 대각선에 겹치는게 없는지 비교
            if (board[i] == x || Math.abs(board[i] - x) == Math.abs(i - y)) {
                return false;
            }
        }
        return true;
    }

    static void recursion(int y) throws IOException {

        // 1. 기저 사례
        if (y == N) {
            answer++;
            return;
        }

        // 2. 값 초기화


        // 3. 경우의 수(재귀)
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
