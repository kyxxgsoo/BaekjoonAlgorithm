import java.util.*;
import java.io.*;

public class P6603 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int k;
    static List<Integer> numbers;
    static List<Integer> selected;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static void solve() throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            numbers = new ArrayList<>();
            selected = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            recursion(0);
            bw.newLine();
        }

    }

    static void recursion(int index) throws IOException {

        if (selected.size() >= 6) {
            for (int i = 0; i < selected.size(); i++) {
                bw.write(selected.get(i) + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = index; i < numbers.size(); i++) {
            selected.add(numbers.get(i));
            recursion(i + 1);
            selected.remove(selected.size() - 1);
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
