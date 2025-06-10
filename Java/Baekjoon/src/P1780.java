import java.util.*;
import java.io.*;

public class P1780 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int[][] paper;
    static int[] answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        answer = new int[3];

        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() throws IOException {
        recursion(0, 0, n);
    }

    static void recursion(int x, int y, int length) throws IOException {
        if (length == 1) {
            answer[paper[y][x] + 1]++;
            return;
        }

        if (isClearPaper(x, y, length)) {
            answer[paper[y][x] + 1]++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextLength = length / 3;
                recursion(x + j * nextLength, y + i * nextLength, nextLength);
            }
        }
    }

    // 모든 조각이 동일하면 true / 한 조각이라도 다르면 false;
    static boolean isClearPaper(int x, int y, int length) {
        int firstPiece = paper[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (firstPiece != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(answer[0] + "\n" + answer[1] + "\n" + answer[2]);

        bw.flush();
        bw.close();
        br.close();
    }


}
