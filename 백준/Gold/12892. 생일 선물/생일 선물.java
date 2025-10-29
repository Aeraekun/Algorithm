import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static long ans = 0;
    static PriorityQueue<Present> pq = new PriorityQueue<>();
    static Deque<Present> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Present(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        cal();

        System.out.println(ans);
    }

    private static void cal() {
        long now = 0;
        while (!pq.isEmpty()) {
            Present temp = pq.poll();
            deque.add(temp);
            now += temp.V;
            while (deque.peekLast().P - deque.peekFirst().P >= D) {
                temp = deque.pollFirst();
                now -= temp.V;
            }
            ans = Math.max(ans, now);
        }
    }

    static class Present implements Comparable<Present> {
        int P, V;

        Present(int P, int V) {
            this.P = P;
            this.V = V;
        }

        @Override
        public int compareTo(Present p) {
            if (P == p.P) return p.V - V;
            return P - p.P;
        }
    }
}