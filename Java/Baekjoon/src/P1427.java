import java.util.*;
import java.io.*;

public class P1427 {

    static BufferedReader br;
    static BufferedWriter bw;
    static String str;
    static char[] cArr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        cArr = str.toCharArray();
    }

    static String solve() throws IOException {
        Arrays.sort(cArr);
        StringBuilder sb = new StringBuilder(new String(cArr));
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        init();

        bw.write(solve());

        bw.flush();
        bw.close();
        br.close();
    }
}