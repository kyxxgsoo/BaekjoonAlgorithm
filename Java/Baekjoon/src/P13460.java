import java.util.*;
import java.io.*;

public class P13460 {

    static class Ball {
        int x;
        int y;

        Ball() {
            this.x = 0;
            this.y = 0;
        }

        Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Ball(Ball other) {
            this.x = other.x;
            this.y = other.y;
        }
    }

    static class BallSet {
        Ball red;
        Ball blue;
        int cnt;

        BallSet() {
            this.red = new Ball();
            this.blue = new Ball();
            this.cnt = 0;
        }

        BallSet(int redX, int redY, int blueX, int blueY, int cnt) {
            this.red = new Ball(redX, redY);
            this.blue = new Ball(blueX, blueY);
            this.cnt = cnt;
        }
    }

    static class Flags {
        boolean isMovedDone;
        boolean isGoal;
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int m;
    static char[][] board;
    static boolean isFinished;
    static int result;

    static int[] ballPos;

    // 상, 우, 하, 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        isFinished = false;
        result = -1;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ballPos = new int[4];
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }


        // R, B 시작값 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    ballPos[0] = j; // redX
                    ballPos[1] = i; // redY
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    ballPos[2] = j; // blueX
                    ballPos[3] = i; // blueY
                    board[i][j] = '.';
                }
            }
        }
    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y < n && 0 <= x && x < m) {
            return true;
        }
        return false;
    }

    // dir: 0(상) / 1(우) / 2(하) / 3(좌)
    static Ball move(Ball ball, int dir) throws IOException {
        Ball b = new Ball(ball);
        int nextX = b.x;
        int nextY = b.y;
        while (true) {
            if (isInRange(nextX, nextY)) {
                // .이면 계속 이동
                nextX += dx[dir];
                nextY += dy[dir];
                if (board[nextY][nextX] == '.') {
                    b.x = nextX;
                    b.y = nextY;
                } else if (board[nextY][nextX] == 'O') {
                    b.x = nextX;
                    b.y = nextY;
                    break;
                } else {
                    break;
                }
            }
        }
        return b;
    }

    static void bfs() throws IOException {
        Deque<BallSet> q = new ArrayDeque<>();
        q.add(new BallSet(ballPos[0], ballPos[1], ballPos[2], ballPos[3], 0));

        while (!q.isEmpty()) {
            BallSet ballSet = q.remove();
            Ball curRed = ballSet.red;
            Ball curBlue = ballSet.blue;
            if (ballSet.cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                Ball movedRed = move(curRed, i);
                Ball movedBlue = move(curBlue, i);
//                System.out.println(movedRed.y + " " + movedRed.x + " " + movedBlue.y + " " + movedBlue.x + " " + ballSet.cnt);

                // 움직이지 않았다면
                if (curRed.x == movedRed.x && curRed.y == movedRed.y && curBlue.x == movedBlue.x && curBlue.y == movedBlue.y) {
                    continue;
                } else if (board[movedBlue.y][movedBlue.x] == 'O') {
                    // 파란 구슬이 구멍에 들어갔다면
                    continue;
                } else if (board[movedRed.y][movedRed.x] == 'O' && board[movedBlue.y][movedBlue.x] != 'O') {
                    // 하나만 구멍에 들어갔다면
                    result = ballSet.cnt + 1;
//                    System.out.println(movedRed.y + " " + movedRed.x);
                    return;
                }

                // 구슬이 겹치면 더 먼 거리를 이동한 구슬을 뒤로 한 칸 보내기
                if (movedRed.x == movedBlue.x && movedRed.y == movedBlue.y) {
                    int movedRedDistance = Math.abs(curRed.x - movedRed.x) + Math.abs(curRed.y - movedRed.y);
                    int movedBlueDistance = Math.abs(curBlue.x - movedBlue.x) + Math.abs(curBlue.y - movedBlue.y);
                    if (movedRedDistance > movedBlueDistance) {
                        movedRed.x -= dx[i];
                        movedRed.y -= dy[i];
                    } else {
                        movedBlue.x -= dx[i];
                        movedBlue.y -= dy[i];
                    }
                }

                q.add(new BallSet(movedRed.x, movedRed.y, movedBlue.x, movedBlue.y, ballSet.cnt + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        bfs();

        bw.write(String.valueOf(result));

        bw.close();
        br.close();

    }
}
