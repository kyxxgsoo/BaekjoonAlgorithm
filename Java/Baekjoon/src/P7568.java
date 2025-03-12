import java.util.*;
import java.io.*;

public class P7568 {

    static class Human {
        int weight;
        int height;

        Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        Human() {
            this.weight = 0;
            this.height = 0;
        }

    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n;
    static Human[] arr;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new Human[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i] = new Human(w, h);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < arr.length; i++) {
            int rank = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
