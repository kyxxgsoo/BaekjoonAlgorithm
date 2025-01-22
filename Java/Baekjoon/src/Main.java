import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 분할 -> split()보다 빠름 (한 줄에 여러 개의 입력을 받아서 분할할 때)
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 하나 입력
//        int n = Integer.parseInt(br.readLine());

        // 2. 여러 줄 입력 후 split()
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            // 출력
            // BufferWriter로 출력할 때는 무조건 String으로 변경해서 사용해야 한다.
            bw.write(String.valueOf(n));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
