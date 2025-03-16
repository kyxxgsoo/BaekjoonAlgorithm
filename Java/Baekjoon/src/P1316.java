import java.io.*;
import java.util.*;

public class P1316 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static char[][] strArr;
    static int result;
    static boolean[] isVisited;
    static boolean isGroupWord;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        strArr = new char[n][];
        result = 0;

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine().toCharArray();
        }
    }

    static void setVariable() throws IOException {
        isVisited = new boolean[26];
        isGroupWord = true;
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            setVariable();
            char[] str = strArr[i];
            for (int j = 1; j < str.length; j++) {
                if (!isVisited[str[j] - 'a']) {
                    // 이전 값과 연속된 값이 아니라면 이전 값을 isVisited에 넣고 나중에 for문을 돌며 조건 탐색
                    if (str[j - 1] != str[j]) {
                        isVisited[str[j - 1] - 'a'] = true;
                    }
                } else {
                    isGroupWord = false;
                    break;
                }
            }

            if (isGroupWord) {
                result++;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
