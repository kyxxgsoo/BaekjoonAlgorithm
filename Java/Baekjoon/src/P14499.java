import java.util.*;
import java.io.*;

public class P14499 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    // 동 서 북 남
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dice;
    static int[][] map;
    static int n;
    static int m;
    static int x;
    static int y;
    static int k;
    static int[] cmd;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());



        // 주사위 초기화
        dice = new int[6];

        // 보드 초기화
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 초기화
        cmd = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void moveLeft() throws IOException {
        int temp = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[4];
        dice[4] = temp;

    }
    static void moveRight() throws IOException {
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[5];
        dice[5] = temp;
    }

    static void moveDown() throws IOException {
        int temp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = temp;
    }

    static void moveUp() throws IOException {
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = temp;
    }

    static boolean isInRange(int x, int y) throws IOException {
        if (0 <= y && y < n && 0 <= x && x < m) {
            return true;
        }
        return false;
    }

    static void compareMapAndDice() throws IOException {
        if (map[y][x] == 0) {
            map[y][x] = dice[0];
        } else {
            dice[0] = map[y][x];
            map[y][x] = 0;
        }
    }

    static void getTopOfDice() throws IOException {
//        System.out.println("y : " + y + " | x : " + x);
        bw.write(dice[2] + "\n");
    }

    static void solve() throws IOException {
        for (int i = 0; i < k; i++) {
            int nextX = x + dx[cmd[i]];
            int nextY = y + dy[cmd[i]];

            if (isInRange(nextX, nextY)) {
                x = nextX;
                y = nextY;
                if (cmd[i] == 1) {
                    moveRight();
                } else if (cmd[i] == 2) {
                    moveLeft();
                } else if (cmd[i] == 3) {
                    moveUp();
                } else if (cmd[i] == 4) {
                    moveDown();
                }
                compareMapAndDice();
                getTopOfDice();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.flush();
        bw.close();
        br.close();

    }
}
