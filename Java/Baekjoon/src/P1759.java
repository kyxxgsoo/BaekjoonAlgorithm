import java.util.*;
import java.io.*;

public class P1759 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int L;
    static int C;
    static List<Character> alphabets;
    static List<Character> selected;


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new ArrayList<>();
        selected = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets.add(st.nextToken().charAt(0));
        }

        Collections.sort(alphabets);
    }

    static void solve() throws IOException {

        recursion(0);


    }

    static void recursion(int idx) throws IOException {
        if (selected.size() == L) {
            int vowelCount = countVowel();
            int consonantCount = selected.size() - vowelCount;
            if (vowelCount >= 1 && consonantCount >= 2) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < selected.size(); i++) {
                    sb.append(selected.get(i));
                }
                bw.write(sb.toString());
                bw.newLine();
            }
            return;
        }

        for (int i = idx; i < alphabets.size(); i++) {
            selected.add(alphabets.get(i));
            recursion(i + 1);
            selected.remove(selected.size() - 1);
        }

    }

    static int countVowel() throws IOException {
        int ret = 0;
        for (int i = 0; i < selected.size(); i++) {
            if (selected.get(i) == 'a' || selected.get(i) == 'e' || selected.get(i) == 'i' || selected.get(i) == 'o' || selected.get(i) == 'u') {
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.flush();
        bw.close();
        br.close();
    }

}
