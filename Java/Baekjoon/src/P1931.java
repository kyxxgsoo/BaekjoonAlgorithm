import java.util.*;
import java.io.*;

public class P1931 {
    static class MeetingRoom {
        int start;
        int end;

        MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n;

    private static List<MeetingRoom> rooms;
    private static int answer;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        rooms = new LinkedList<>();
        answer = 0;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms.add(new MeetingRoom(start, end));
        }

        // 이런식으로 하면 복합정렬 && 내림차순 정렬이 가능
//        rooms.sort(Comparator.comparingInt((MeetingRoom r) -> r.end)
//                .reversed()
//                .thenComparingInt(r -> r.start));

        rooms.sort(Comparator.comparingInt((MeetingRoom r) -> r.end)
                .thenComparingInt((MeetingRoom r) -> r.start));
    }

    private static void solution() throws IOException {
        init();

        Iterator<MeetingRoom> iter = rooms.iterator();

        MeetingRoom usingRoom = iter.next();
        answer++;

        while (iter.hasNext()) {
            MeetingRoom curRoom = iter.next();
            if (curRoom.start >= usingRoom.end) {
                answer++;
                usingRoom = curRoom;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
