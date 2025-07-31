import java.util.*;
import java.io.*;

public class P10988 {

    static BufferedReader br;
    static BufferedWriter bw;

    static String input;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();

    }

    static void solve() throws IOException {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        String reversedInput = sb.toString();

        if (input.equals(reversedInput)) {
            bw.write(1 + "");
        } else {
            bw.write(0 + "");
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
