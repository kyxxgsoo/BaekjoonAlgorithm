import java.util.*;
import java.io.*;

public class P14891 {

    static class Gear {
        Deque<Boolean> highGear;
        Deque<Boolean> lowGear;

        Gear(char[] gearArray) {
            this.highGear = new ArrayDeque<>();
            this.lowGear = new ArrayDeque<>();

            // 기어 윗부분
            for (int j = 0; j < gearArray.length / 2; j++) {
                this.highGear.add(gearArray[j] == '1' ? true : false);
            }

            // 기어 아랫부분
            for (int j = 4; j < gearArray.length; j++) {
                this.lowGear.add(gearArray[j] == '1' ? true : false);
            }

            rotateClockwise();
            rotateClockwise();
        }

        Gear(Gear g) {
            this.highGear = new ArrayDeque<>();
            this.lowGear = new ArrayDeque<>();

            Iterator<Boolean> highGearIter = g.highGear.iterator();
            Iterator<Boolean> lowGearIter = g.lowGear.iterator();

            while (highGearIter.hasNext()) {
                this.highGear.addLast(highGearIter.next());
            }

            while (lowGearIter.hasNext()) {
                this.lowGear.addLast(lowGearIter.next());
            }
        }

        // 시계방향
        boolean[] rotateClockwise() {
            boolean lastLeft = this.highGear.getFirst();
            boolean lastRight = this.lowGear.getFirst();
            this.highGear.addFirst(this.lowGear.removeLast());
            this.lowGear.addFirst(this.highGear.removeLast());

            return new boolean[]{lastLeft, lastRight};
        }

        // 반시계 방향
        boolean[] rotateCounterClockwise() {
            boolean lastLeft = this.highGear.getFirst();
            boolean lastRight = this.lowGear.getFirst();
            this.highGear.addLast(this.lowGear.removeFirst());
            this.lowGear.addLast(this.highGear.removeFirst());

            return new boolean[]{lastLeft, lastRight};
        }

        boolean[] rotateGear(boolean dir) {
            if (dir) {
                return rotateClockwise();
            } else {
                return rotateCounterClockwise();
            }
        }

    }

    static BufferedReader br;
    static BufferedWriter bw;
    static List<Gear> gears;
    static int answer;
    static boolean[] isVisited;

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gears = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            char[] gearArr = br.readLine().toCharArray();
            gears.add(new Gear(gearArr));
        }

        answer = 0;
        isVisited = new boolean[4];
    }


    static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        // dir : 1(시계방향) / -1(반시계방향)

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            boolean dir = st.nextToken().equals("1") ? true : false;

            // 처음은 lastDir이 없음.
            isVisited = new boolean[4];
            rotateGears(-1, gearNum - 1, dir);
        }

        answer = getScore();
    }

    /*
    beforeGearNum : 이전 기어 번호
    gearNum : 현재 기어 번호
    dir : 현재 기어가 돌아야 할 방향
    beforeLeftRight : 직전 기어의 rotate 전의 left, right 극성
     */
    static void rotateGears(int beforeGearNum, int gearNum, boolean dir) throws IOException {

        // gearNum은 0 ~ 3까지
        if (!isInRange(gearNum)) {
            return;
        }

        if (isVisited[gearNum]) {
            return;
        }

        Gear curGear = gears.get(gearNum);
        isVisited[gearNum] = true;

        boolean beforeRotateCurGearLeft = curGear.highGear.getFirst();
        boolean beforeRotateCurGearRight = curGear.lowGear.getFirst();

        curGear.rotateGear(dir);

        // 왼쪽 이동
        if (isInRange(gearNum - 1)) {
            Gear nextGear = gears.get(gearNum - 1);
            boolean nextRight = nextGear.lowGear.getFirst();
            if (beforeRotateCurGearLeft != nextRight) {
                rotateGears(gearNum, gearNum - 1, !dir);
            }
        }
        // 오른쪽 이동
        if (isInRange(gearNum + 1)) {
            Gear nextGear = gears.get(gearNum + 1);
            boolean nextLeft = nextGear.highGear.getFirst();
            if (beforeRotateCurGearRight != nextLeft) {
                rotateGears(gearNum, gearNum + 1, !dir);
            }
        }

    }

    static boolean isInRange(int gearNum) {
        if (0 <= gearNum && gearNum < 4) {
            return true;
        }
        return false;
    }

    static int getScore() throws IOException {
        List<Gear> copyGears = new ArrayList<>();
        int score = 0;
        for (int i = 0; i < gears.size(); i++) {
            copyGears.add(new Gear(gears.get(i)));
        }

        // N : false
        // S : true
        for (int i = 0; i < copyGears.size(); i++) {
            Gear gear = copyGears.get(i);
            gear.rotateCounterClockwise();
            gear.rotateCounterClockwise();

            // S극이면 점수
            if (gear.highGear.getFirst()) {
                score += Math.pow(2, i);
            }
        }

        return score;
    }


    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
