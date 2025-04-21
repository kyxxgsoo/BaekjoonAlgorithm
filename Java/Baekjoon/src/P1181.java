import java.util.*;
import java.io.*;

public class P1181 {

    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<String> arr;
    static int N;

    // 정렬 시 원시 타입을 객체 타입으로 (ex. int -> Integer) 바꿔 정렬하는게 편하다.
    // Comparator를 선언하여 여러 종류의 정렬을 한 꺼번에 처리할 수 있다.
    // 이 때, compare를 꼭 Override 해줘야 한다.
    static Comparator<String> comp = new Comparator<>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                // compareTo를 사용하면 사전식 정렬을 할 수 있다.
//                for (int i = 0; i < s1.length(); i++) {
//                    if (s1.charAt(i) == s2.charAt(i)) {
//                        continue;
//                    }
//                    return s1.charAt(i) - s2.charAt(i);
//                }
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        }
    };

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }
    }

    static void solve() throws IOException {
        Collections.sort(arr, comp);
    }

    public static void main(String[] args) throws IOException {

        init();
        solve();

        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                bw.write(arr.get(i) + "\n");
            } else if (!arr.get(i).equals(arr.get(i - 1))) {
                bw.write(arr.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
