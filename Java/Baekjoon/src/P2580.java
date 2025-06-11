import java.util.*;
import java.io.*;

public class P2580 {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] board;
    static List<Node> blanks;
    static boolean endFlag;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        board = new int[9][9];
        blanks = new ArrayList<>();
        endFlag = false;

        for (int y = 0; y < 9; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 9; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());

                if (board[y][x] == 0) {
                    blanks.add(new Node(x, y));
                }
            }
        }
    }

    static void solve() throws IOException {
        recursion(0);
    }

    static void recursion(int blankNum) throws IOException {
        if (endFlag) {
            return;
        }

        // blankNum이 blanks.size()와 같아졌다는 것은 모든 blank에 유효한 값이 제대로 들어갔음을 의미
        // 여러 경우의 수 중 첫 번째 경우의 수에 걸려서 들어왔을 것임.
        if (blankNum == blanks.size()) {
            printBoard();

            // 최초로 나오는 경우의 수만 출력하면 되므로 endFlag를 활성화시켜 이후 경우의 수를 따지지 않고 recursion을 모두 종료하도록 하자
            // System.exit(0); 을 통해서 시스템을 종료할 수도 있지만 기존에 내가 사용하던 정해진 형식을 지키기 위해
            // endFlag를 활성화시키고, main 메서드에서 종료하도록 하기 위해 이렇게 구현했다.
            endFlag = true;
            return;
        }

        Node blank = blanks.get(blankNum);

        // 1~9까지 숫자중에 나오지 않은 수만 선택하며 빈 칸에 값을 채워넣어간다.
        // blankNum을 1씩 더해가며 마지막 blankNum을 채울 때까지 재귀를 반복한다.
        // 앞에 선택된 blank에 들어갈 num은 다음 blank에 채워질 num에 계속 누적하여 영향을 끼친다.
        for (int i = 1; i <= 9; i++) {
            if (checkValidNum(blank.x, blank.y, i)) {
                board[blank.y][blank.x] = i;
                recursion(blankNum + 1);
                board[blank.y][blank.x] = 0;
            }
        }
    }

    // 스도쿠 보드를 출력하는 메서드.
    static void printBoard() throws IOException {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                bw.write(board[y][x] + " ");
            }
            bw.newLine();
        }
    }

    // blank의 가로, 세로, 해당 blank를 포함하는 정사각형 구역에서 주어진 num이 나오지 않았는지를 판별하는 메서드
    static boolean checkValidNum(int x, int y, int num) throws IOException {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == num || board[i][x] == num) {
                return false;
            }
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int dy = 0 ; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                if (board[startY + dy][startX + dx] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();
    }
}
