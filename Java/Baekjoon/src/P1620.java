import java.util.*;
import java.io.*;

public class P1620 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int M;

    static Map<String, Integer> map;
    static String[] arr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            arr[i] = name;
            map.put(name, i);
        }
    }

    static void solve() throws IOException {

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();
            if (Character.isDigit(cmd.charAt(0))) {
                int number = Integer.parseInt(cmd);
                bw.write(arr[number] + "\n");
            } else {
                String str = cmd;
                bw.write(map.get(str) + "\n");
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
