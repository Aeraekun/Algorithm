import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        p = new int[100001];
        Arrays.fill(p, -1);
        if (N >= K) {
            System.out.println(N - K);
        } else {
            bfs();
            System.out.println(p[K]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        p[N] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now <= 50000) {
                if (p[now * 2] == -1 || p[now * 2] > p[now]) {
                    p[now * 2] = p[now];
                    if (now * 2 == K) return;
                    queue.add(now * 2);
                }
            }
            if (now > 0) {
                if (p[now - 1] == -1 || p[now - 1] > p[now] + 1) {
                    p[now - 1] = p[now] + 1;
                    if (now - 1 == K) return;
                    queue.add(now - 1);
                }
            }
            if (now < 100000) {
                if (p[now + 1] == -1 || p[now + 1] > p[now] + 1) {
                    p[now + 1] = p[now] + 1;
                    if (now + 1 == K) return;
                    queue.add(now + 1);
                }
            }
        }
    }
}