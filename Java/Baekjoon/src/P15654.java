import java.util.*;
import java.io.*;

public class P15654 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int m;
    static List<Integer> numbers;
    static List<Integer> selected;
    static boolean[] isVisited;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        selected = new ArrayList<>();
        isVisited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);
    }

    static void solve() throws IOException {
        recursion(0);
    }

    static void recursion(int idx) throws IOException {

        if (selected.size() == m) {
            for (int i = 0; i < selected.size(); i++) {
                bw.write(selected.get(i) + " ");
            }
            bw.newLine();
            return;
        }


        for (int i = 0; i < numbers.size(); i++) {
            if (!isVisited[i]) {
                selected.add(numbers.get(i));
                isVisited[i] = true;
                recursion(i + 1);
                selected.remove(selected.size() - 1);
                isVisited[i] = false;
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
