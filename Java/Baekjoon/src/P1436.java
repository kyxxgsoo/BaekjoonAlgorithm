import java.util.*;
import java.io.*;

public class P1436 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static ArrayList<Integer> arr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        init();

        int num = 666;

        while (arr.size() <= 10000) {
            if (String.valueOf(num).contains("666")) {
                arr.add(num);
            }
            num++;
        }

        bw.write(String.valueOf(arr.get(n - 1)));
        bw.flush();
        bw.close();
        br.close();
    }
}
