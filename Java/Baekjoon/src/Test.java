import java.util.*;

public class Test {


    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return x + ", " + y;
        }

        @Override
        public boolean equals(Object o) {
            // 자기 자신이라면 true
            if (this == o) {
                return true;
            }

            // o가 null이거나 클래스가 다를 경우 false
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Node other = (Node) o;

            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Node n1 = new Node(1, 2);
        Node n2 = new Node(1, 2);

        System.out.println(n1.toString());

        set.add(n1.toString());
        System.out.println(set.contains(n2.toString()));

    }
}
