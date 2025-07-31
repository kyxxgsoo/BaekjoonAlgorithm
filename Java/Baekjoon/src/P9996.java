import java.util.*;
import java.io.*;

public class P9996 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static String pattern;
    static String prefix;
    static String suffix;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        pattern = br.readLine();
    }

    static void solve() throws IOException {
        String[] strings = pattern.split("\\*");

        prefix = strings[0];
        suffix = strings[1];

//        System.out.println(prefix);
//        System.out.println(suffix);
        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            if (fileName.length() < prefix.length() + suffix.length()) {
                /*
                위 조건은
                pattern = "ab*ab"
                fileName = "ab"
                과 같은 반례를 처리하기 위해 사용된다.
                 */
                bw.write("NE\n");
            } else {
                if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
                    bw.write("DA\n");
                } else {
                    bw.write("NE\n");
                }
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
