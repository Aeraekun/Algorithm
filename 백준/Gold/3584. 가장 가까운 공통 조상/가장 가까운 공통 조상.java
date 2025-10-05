import java.io.*;
import java.util.*;

public class Main {
    static int T, N, n1, n2;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            for (int n = 0; n < N - 1; n++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                parent[Integer.parseInt(st.nextToken())] = p;
            }
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            System.out.println(check());
        }
    }

    private static int check() {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        int now = n1;
        deque1.add(now);
        while (parent[now] != 0) {
            deque1.add(parent[now]);
            now = parent[now];
        }

        now = n2;
        deque2.add(now);
        while (parent[now] != 0) {
            deque2.add(parent[now]);
            now = parent[now];
        }

        while (deque1.size() != deque2.size()) {
            (deque1.size() > deque2.size() ? deque1 : deque2).poll();
        }

        int ans = 0;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            if (Objects.equals(deque1.peekLast(), deque2.pollLast())) ans = deque1.pollLast();
            else break;
        }
        return ans;
    }
}
