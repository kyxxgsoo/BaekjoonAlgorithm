import java.util.*;
import java.io.*;

public class P13023 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int M;
    static int answer;
    static int maxLength;
    static int endFriend;
    static boolean endFlag;

    static Map<Integer, ArrayList<Integer>> graph;
    static Set<Integer> isVisited;

    static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        maxLength = 1;
        endFriend = 0;

        graph = new HashMap<>();
        isVisited = new HashSet<>();
    }

    static void addFriends(int f1, int f2) throws IOException {
        graph.computeIfAbsent(f1, k -> new ArrayList<>()).add(f2);
        graph.computeIfAbsent(f2, k -> new ArrayList<>()).add(f1);
    }

    static void solve() throws IOException {

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            addFriends(f1, f2);
        }

//        System.out.println(graph);

        for (int i = 0; i < N; i++) {
            isVisited = new HashSet<>();
            dfs(i, 0);
        }
        // dfs를 두 번 돌려 가장 멀리 있는 친구끼리의 길이가 얼마나 되는지 확인
        isVisited.add(0);
        dfs(0, 1);
        isVisited = new HashSet<>();
        isVisited.add(endFriend);
        dfs(endFriend, 1);

        bw.write(String.valueOf(answer));
    }

    static void dfs(int cur, int cnt) throws IOException {
        if (endFlag) {
            answer = 1;
            return;
        }
        if (cnt > maxLength) {
            maxLength = cnt;
            endFriend = cur;
            if (cnt == 5) {
                endFlag = true;
                return;
            }
        }

        List<Integer> friends = graph.getOrDefault(cur, new ArrayList<>());

        for (int i = 0; i < friends.size(); i++) {
            int friend = friends.get(i);
            if (!isVisited.contains(friend)) {
                isVisited.add(friend);
                dfs(friend, cnt + 1);
                isVisited.remove(friend);
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
