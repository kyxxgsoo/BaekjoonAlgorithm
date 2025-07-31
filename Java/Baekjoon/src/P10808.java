import java.util.*;
import java.io.*;

public class P10808 {

    static BufferedReader br;
    static BufferedWriter bw;
    static String input;

    static Map<Character, Integer> map;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new HashMap<>();

        input = br.readLine();
    }

    static void solve() throws IOException {

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            bw.write(map.getOrDefault(alphabet, 0) + " ");
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
