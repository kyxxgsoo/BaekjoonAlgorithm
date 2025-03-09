import java.io.*;
import java.util.StringTokenizer;

public class P2798 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static int m;
    static int result;
    static int[] cards;
    static boolean[] isSelected;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isSelected = new boolean[n];
        result = 0;

        cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void dfs(int cnt, int sum) throws IOException {
        if (sum > m) {
            return;
        }
        if (cnt == 3) {
            if (m - sum < m - result) {
                result = sum;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                sum += cards[i];
                dfs(cnt + 1, sum);
                isSelected[i] = false;
                sum -= cards[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        dfs(0, 0);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}
