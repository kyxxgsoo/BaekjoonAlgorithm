import java.util.*;
import java.io.*;

public class P5430 {

    static BufferedReader br;
    static BufferedWriter bw;
//    static StringTokenizer st;

    static int t;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
    }

    static String solve() throws IOException {
        char[] commands = br.readLine().toCharArray();
        Deque<Integer> intDeque = new ArrayDeque<>();
        boolean forwardDirection = true;
        int n = Integer.parseInt(br.readLine());
        String arrStr = br.readLine();
        // 정규표현식
        String[] strArr = arrStr.split(",|\\[|\\]");

        for (int i = 1 ; i < strArr.length; i++) {
            // 맨 앞에 공백때문에 1부터 시작
            intDeque.add(Integer.parseInt(strArr[i]));
        }

        for (int i = 0; i < commands.length; i++) {

            if (commands[i] == 'R') {
                forwardDirection = !forwardDirection;
            } else if (commands[i] == 'D') {
                if (intDeque.isEmpty()) {
                    return "error";
                } else {
                    if (forwardDirection) {
                        intDeque.removeFirst();
                    } else {
                        intDeque.removeLast();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (!forwardDirection) {
            List<Integer> tempList = new ArrayList<>(intDeque);
            Collections.reverse(tempList);
            intDeque = new ArrayDeque<>(tempList);
        }
        Iterator<Integer> iter = intDeque.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");


        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < t; i++) {
            bw.write(solve() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
