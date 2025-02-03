import java.util.*;
import java.io.*;

public class P14502 {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int n;
    private static int m;
    private static char[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int answer;
    private static ArrayList<Node> virus;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        virus = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '2') {
                    virus.add(new Node(j, i));
                }
            }
        }
    }

    private static void solution() {
        setWall(0);
    }

    private static void setWall(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    map[i][j] = '1';
                    setWall(wallCount + 1);
                    map[i][j] = '0';
                }
            }
        }
    }

    private static void bfs() {
        Deque<Node> q = new LinkedList<>();
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < virus.size(); i++) {
            Node v = virus.get(i);
            q.add(v);
            visited[v.y][v.x] = true;
        }

        char[][] copyMap = deepCopyMap(map);

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInRange(nextX, nextY) && !visited[nextY][nextX]) {
                    if (copyMap[nextY][nextX] == '0') {
                        copyMap[nextY][nextX] = '2';
                        q.add(new Node(nextX, nextY));
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == '0') {
                    count++;
                }
            }
        }

        if (count > answer) {
            answer = count;
        }

    }

    private static boolean isInRange(int x, int y) {
        if (0 <= y && y < n && 0 <= x && x < m) {
            return true;
        }
        return false;
    }

    private static char[][] deepCopyMap(char[][] origin) {
        char[][] newMap = new char[n][m];
        for (int i = 0; i < origin.length; i++) {
            // System.arraycopy(원본 배열, 원본 배열의 복사를 시작할 인덱스, 새로운 배열, 새로운 배열에서 복사를 시작할 인덱스, 복사할 요소 개수);
            System.arraycopy(origin[i], 0, newMap[i], 0, origin[i].length);
        }
        return newMap;
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
