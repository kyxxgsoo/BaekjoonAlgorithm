import java.util.*;
import java.io.*;

public class P3190 {
    static class Command {
        int phase;
        char cmd;

        Command(int phase, char cmd) {
            this.phase = phase;
            this.cmd = cmd;
        }
    }

    static class Snake {
        int y;
        int x;
        /*
        상, 하, 좌, 우
        0, 1, 2, 3
         */
        int dir;

        Snake(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    // 우, 하, 좌, 상
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static BufferedReader br;
    static BufferedWriter bw;

    static StringTokenizer st;
    static int n;
    static int k;
    static int l;
    static int[][] board;
    static Deque<Snake> snake;
    static Deque<Command> commands;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        // 1부터 시작하니 1 ~ n까지 만들고 0은 버리기.
        board = new int[n + 2][n + 2];
        snake = new ArrayDeque<>();
        // 초기값 (1, 1)에 오른쪽 보게 설정
        snake.add(new Snake(1, 1, 0));

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            // 사과가 있는 보드는 1로 표시
            board[row][col] = 1;
        }
        l = Integer.parseInt(br.readLine());
        commands = new ArrayDeque<>();

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            commands.add(new Command(x, command));
        }
    }

    static boolean isInRange(int x, int y) {
        if (1 <= y && y <= n && 1 <= x && x <= n) {
            return true;
        }
        return false;
    }

    static boolean isCrush() {
        Iterator<Snake> iter = snake.descendingIterator();
        // 머리의 길이는 무조건 1이 있다고 가정.
        Snake head = iter.next();
        // 머리가 보드 내에 있으면
        if (isInRange(head.x, head.y)) {
            // 머리에 부딪힌 몸통이 없는지?
            while (iter.hasNext()) {
                Snake body = iter.next();
                // 머리와 부딪힌 몸통이 있으면 false
                if (head.y ==body.y && head.x == body.x) {
                    return true;
                }
            }
            // 모두 통과하면 true;
            return false;
        }
        // 머리가 보드 바깥에 있으면 false
        return true;
    }

    public static void main(String[] args) throws IOException {
        init();

        // --------------- log ---------------
//        Iterator<Snake> iter = snake.iterator();
//        while (iter.hasNext()) {
//            Snake part = iter.next();
//            System.out.println(part.y + " " + part.x + " " + part.dir);
//        }
        // --------------- log ---------------

        int phase = 0;
        while (true) {
            phase++;
            Snake head = snake.getLast();
            int nextY = head.y + dy[head.dir];
            int nextX = head.x + dx[head.dir];
            int nextDir = head.dir;


//            // --------------- log ---------------
//            System.out.println("phase : " + phase);
//            if (!commands.isEmpty()) {
//                System.out.println(commands.getFirst().phase + " " + commands.getFirst().cmd);
//            }
//            // --------------- log ---------------

            // 커맨드가 해당 페이즈에서 명령되어야되면
            if (!commands.isEmpty() && commands.getFirst().phase == phase) {
//                // --------------- log ---------------
//                System.out.println("COMMAND ON");
//                // --------------- log ---------------
                if (commands.getFirst().cmd == 'D') {
                    nextDir = (nextDir + 1) % 4;
                } else if (commands.getFirst().cmd == 'L') {
//                // ---------  ------ log ---------------
//                    System.out.println(nextDir);
//                // --------------- log ---------------
                    nextDir = nextDir - 1;
                    if (nextDir < 0) {
                        nextDir = nextDir + 4;
                    }
                }
                commands.removeFirst();
            }
            snake.addLast(new Snake(nextY, nextX, nextDir));
            if (isCrush()) {
                break;
            }

            Snake newHead = snake.getLast();

            // 사과가 없으면 꼬리 한칸 없애기
            if (board[newHead.y][newHead.x] == 1) {
                board[newHead.y][newHead.x] = 0;
            } else {
                snake.removeFirst();
            }

//            // log
//            Iterator<Snake> iter1 = snake.iterator();
//            while (iter1.hasNext()) {
//                Snake body = iter1.next();
//                System.out.println(body.y + " " + body.x + " " + body.dir);
//            }
//            // log
        }

        bw.write(String.valueOf(phase));

        bw.flush();
        bw.close();
        br.close();
    }
}
