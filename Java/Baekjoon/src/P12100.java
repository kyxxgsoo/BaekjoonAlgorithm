import java.util.*;
import java.io.*;

public class P12100 {

    static class Node {
        int num;
        boolean isMerged;

        Node() {
            this.num = 0;
            this.isMerged = false;
        }

        Node(int num, boolean isMerged) {
            this.num = num;
            this.isMerged = isMerged;
        }
    }

    static class Phase {
        Node[][] board;
        int cnt;

        Phase(Node[][] board, int cnt) {
            this.board = new Node[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.board[i][j] = new Node(board[i][j].num, board[i][j].isMerged);
                }
            }
            this.cnt = cnt;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    // 상, 우, 하, 좌 (시계 방향)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int n;
    static Node[][] board;
    static int result;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new Node[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = new Node(Integer.parseInt(st.nextToken()), false);
            }
        }

        // 하나도 합쳐지지 않았을 때를 대비해서 초기화를 첫 board의 가장 큰 값으로 하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, board[i][j].num);
            }
        }
    }

    static void getMaxNum(Node[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(board[i][j].num, result);
            }
        }
    }

    static void move(Node[][] board, int x, int y, int dir) {
        Node tempNode = board[y][x];
        board[y][x] = board[y + dy[dir]][x + dx[dir]];
        board[y + dy[dir]][x + dx[dir]] = tempNode;
    }

    static void merge(Node[][] board, int x, int y, int dir) {
        Node mergeNode = board[y + dy[dir]][x + dx[dir]];
        mergeNode.num += board[y][x].num;
        mergeNode.isMerged = true;
        board[y][x].num = 0;
        board[y][x].isMerged = false;
    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y < n && 0 <= x && x < n) {
            return true;
        }
        return false;
    }

    // 로그용
    static void printBoard(Node[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j].num + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    static boolean moveBlocks(Node[][] board, int dir, int cnt) {
        boolean isMoved = false;

        // 위 or 왼쪽
        if (dir == 0 || dir == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int nextX = j + dx[dir];
                    int nextY = i + dy[dir];
                    // 0일때는 그냥 이동
                    while (isInRange(nextX, nextY) && board[i][j].num != 0) {
                        if (board[nextY][nextX].num == 0) {
                            move(board, j, i, dir);
                            isMoved = true;
                            nextX += dx[dir];
                            nextY += dy[dir];
                            j += dx[dir];
                            i += dy[dir];
                        } else {
                            // 이 부분에서 문제 있었음.. 한 블럭이라도 merge된 상태이면 다른 블럭과 합쳐질 수 없어야 함.
                            if (board[i][j].num == board[nextY][nextX].num && !board[nextY][nextX].isMerged && !board[i][j].isMerged) {
                                merge(board, j, i, dir);
                                isMoved = true;
                            }
                            break;
                        }
                    }
                }
            }
        } else {
            // 아래 or 오른쪽
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int nextX = j + dx[dir];
                    int nextY = i + dy[dir];
                    // 0일때는 그냥 이동
                    while (isInRange(nextX, nextY) && board[i][j].num != 0) {
                        if (board[nextY][nextX].num == 0) {
                            move(board, j, i, dir);
                            isMoved = true;
                            nextX += dx[dir];
                            nextY += dy[dir];
                            j += dx[dir];
                            i += dy[dir];
                        } else {
                            if (board[i][j].num == board[nextY][nextX].num && !board[nextY][nextX].isMerged && !board[i][j].isMerged) {
                                merge(board, j, i, dir);
                                isMoved = true;
                            }
                            break;
                        }
                    }
                }
            }
        }

        // 다음 연산을 위해 isMerged 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j].isMerged = false;
            }
        }

        return isMoved;
    }

    static void bfs() throws IOException {
        Deque<Phase> q = new ArrayDeque<>();
        q.add(new Phase(board, 0));

        while (!q.isEmpty()) {
            Phase curPhase = q.remove();

            // 5번 이동이 끝났으면 max와 비교해서 result 갱신
            if (curPhase.cnt >= 5) {
                getMaxNum(curPhase.board);
                continue;
            }

            // 상하좌우 bfs 돌리기
            for (int i = 0; i < 4; i++) {
                Phase nextPhase = new Phase(curPhase.board, curPhase.cnt);
                // 이동시키기
                boolean isMoved = moveBlocks(nextPhase.board, i, nextPhase.cnt);

                if (isMoved) {
                    nextPhase.cnt++;
                    q.add(nextPhase);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        bfs();

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}
