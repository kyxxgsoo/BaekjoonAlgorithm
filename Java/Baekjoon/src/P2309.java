import java.util.*;
import java.io.*;

public class P2309 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] arr;
    static boolean[] check;
    static ArrayList<Integer> result;
    static boolean isFind;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[9];
        check = new boolean[9];
        result = new ArrayList<>();
        isFind = false;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }
    }

    static void solve(int cnt, int sum) throws IOException {
        if (cnt == 7 && sum == 100) {
            // 오름차순 정렬
            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                bw.write(String.valueOf(result.get(i)));
                bw.newLine();
            }
            isFind = true;
            return;
        }

        if (isFind) {
            return;
        }
        if (cnt >= 7) {
            return;
        }
        if (sum >= 100) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                check[i] = true;
                result.add(arr[i]);
                solve(cnt + 1, sum + arr[i]);
                check[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solve(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}
