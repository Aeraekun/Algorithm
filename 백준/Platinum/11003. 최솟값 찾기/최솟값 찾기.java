import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > now)
                deque.pollLast();
            deque.add(new Node(i, now));
            if (deque.peek().index <= i - l) deque.poll();
            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}