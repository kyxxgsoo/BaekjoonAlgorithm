import java.util.*;
import java.io.*;

public class P14889 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N;
    static int[][] S;

    static int totalScore;
    static boolean[] isChecked;
    static int answer;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        totalScore = 0;
        isChecked = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
                totalScore += S[i][j];
            }
        }
    }

    static int calcScoreGap() throws IOException {
        int startScore = 0;
        int linkScore = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isChecked[i] && isChecked[j]) {
                    startScore += S[i][j] + S[j][i];
                }
                if (!isChecked[i] && !isChecked[j]) {
                    linkScore += S[i][j] + S[j][i];
                }
            }
        }

//        System.out.println(Math.abs(startScore - linkScore));

        return Math.abs(startScore - linkScore);
    }

    static void recursion(int cnt, int idx) throws IOException {

        // 정확히 팀을 반으로 나눴을 때 탈출
        if (cnt == N / 2) {
            // 점수 계산
            answer = Math.min(answer, calcScoreGap());
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                recursion(cnt + 1, i);
                isChecked[i] = false;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        init();

        recursion(0, 0);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
