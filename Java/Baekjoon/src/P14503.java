import java.util.*;
import java.io.*;

public class P14503 {

    //                 북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int m;
    static int x;
    static int y;
    static int dir;
    static int[][] room;
    static boolean[][] isVisited;
    static int result;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        result = 0;


        // 방 초기화
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // isVisited 초기화
        isVisited = new boolean[n][m];
    }

    // 후진하는 메서드
    static void goBack() throws IOException {
//        System.out.println("goBack");
        y += dy[(dir + 2) % 4];
        x += dx[(dir + 2) % 4];
    }

    static void goForward() throws IOException {
//        System.out.println("goForward");
        y += dy[dir];
        x += dx[dir];
    }

    // 반시계 방향으로 회전하는 메서드
    static void rotateRobot() throws IOException {
//        System.out.println("rotateRobot");
        dir = dir - 1;
        if (dir < 0) {
            dir += 4;
        }
    }

    // 청소할 수 있는 구역인지 판단하는 메서드 (범위, 벽 판단)
    static boolean canClean() throws IOException {
        int nextX = x + dx[dir];
        int nextY = y + dy[dir];
        if ((0 <= nextY && nextY < n && 0 <= nextX && nextX < m) && room[nextY][nextX] == 0) {
            return true;
        }
        return false;
    }


    static boolean canGoBack() throws IOException {
        int backX = x + dx[(dir + 2) % 4];
        int backY = y + dy[(dir + 2) % 4];
        if ((0 <= backY && backY < n && 0 <= backX && backX < m) && room[backY][backX] != 1) {
            return true;
        }
        return false;
    }

    // 현재 칸 청소 메서드 (0 : 청소 X / 1 : 벽 / -1 : 청소 O)
    static void clean() throws IOException {
        room[y][x] = -1;
        result++;
    }

    // 주변 4칸 탐색하면서 갈 수 있는 칸 중 청소되지 않는 칸이 있다면 true / 없다면 false
    static boolean searchAround() throws IOException {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (room[nextY][nextX] == 0) {
                return true;
            }
        }
        return false;
    }

    static void printRoom() throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }



    static void solve() throws IOException {

        while (true) {
            if (room[y][x] == 0) {
                clean();
            }
//            printRoom();
//            System.out.println("x : " + x + " | y : " + y + " | result : " + result + " | dir : " + dir);

            // 청소되지 않는 빈 칸이 있는 경우
            if (searchAround()) {
                rotateRobot();
                if (canClean()) {
                    goForward();
                }
            } else {    // 청소되지 않는 빈 칸이 없는 경우
                if (canGoBack()) {
                    goBack();
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}
