import java.io.*;
import java.util.*;

public class P15686 {

    static class Pos {
        int x;
        int y;
        int dist;

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static int m;
    static int answer;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] city;
    static boolean[][] isVisited;

    static List<Pos> chickenHouse;
    static List<Pos> selectedChickenHouses;
    static List<Pos> house;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        city = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];

        chickenHouse = new ArrayList<>();
        selectedChickenHouses = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    house.add(new Pos(j, i, 0));
                }
                if (city[i][j] == 2){
                    chickenHouse.add(new Pos(j, i, 0));
                }
            }
        }
    }

    static void printSelectedChickenHouse() {
        for (int i = 0; i < selectedChickenHouses.size(); i++) {
            Pos pos = selectedChickenHouses.get(i);
            System.out.println(pos.x + " " + pos.y + " ");
        }
    }

    // dfs
    static void solve(int index) throws IOException {

        if (selectedChickenHouses.size() >= m) {
//            printSelectedChickenHouse();
            answer = Math.min(answer, getChickenDistance());
            return;
        }

        for (int i = index; i < chickenHouse.size(); i++) {
            selectedChickenHouses.add(chickenHouse.get(i));
            solve(i + 1);
            selectedChickenHouses.remove(selectedChickenHouses.size() - 1);
        }
    }


    // bfs
    static int getChickenDistance() throws IOException {
        Deque<Pos> q = new ArrayDeque<>();
        isVisited = new boolean[n + 1][n + 1];
        int cnt = house.size();
        int totalDistance = 0;
        for (int i = 0; i < selectedChickenHouses.size(); i++) {
            Pos pos = selectedChickenHouses.get(i);
            isVisited[pos.y][pos.x] = true;
            q.add(pos);
        }

        while (!q.isEmpty() && cnt > 0) {
            Pos cur = q.pop();
            int curX = cur.x;
            int curY = cur.y;
            int curDist = cur.dist;

//            System.out.println(curX + " " + curY + " " + curDist);

            if (city[curY][curX] == 1) {
                cnt--;
                totalDistance += curDist;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInRange(nextX, nextY) && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    q.add(new Pos(nextX, nextY, curDist + 1));
                }

            }
        }
        return totalDistance;
    }

    static boolean isInRange(int x, int y) {
        if (0 <= y && y <= n && 0 <= x && x <= n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve(0);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
