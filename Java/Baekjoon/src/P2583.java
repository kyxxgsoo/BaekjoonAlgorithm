import java.util.*;
import java.io.*;

public class P2583 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    // (상, 우, 하, 좌) 순서로 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int M;
    static int N;
    static int K;
    static int[][] board;
    static ArrayList<Integer> answer;

    static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();

        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }


//        // log(start)
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        // log(end)
    }

    static boolean isInRange(int x, int y) throws IOException {
        if (0 <= x && x < N && 0 <= y && y < M) {
            return true;
        }

        return false;
    }

    static int dfs(int x, int y) throws IOException {

        // 기저사례 1. 범위를 벗어났으면 탈출 or 방문되었거나 직사각형이라면 탈출;
        if (board[y][x] != 0) {
            return 0;
        }
        board[y][x] = 2;

        int ret = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 범위 안에 들었으면 탐색
            if (isInRange(nextX, nextY)) {
                ret += dfs(nextX, nextY);
            }
        }

        return ret;
    }


    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    answer.add(dfs(j, i));
                }
            }
        }

        Collections.sort(answer);

        bw.write(answer.size() + "\n");

        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
