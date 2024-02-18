import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] now;
    static boolean[][] line;
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        line = new boolean[2][n];
        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                line[i][j] = str.charAt(j) == '1';
            }
        }
        bfs();
    }

    private static void bfs() {
        queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now[2] >= n - 1 || now[2] + k >= n) {
                System.out.println(1);
                return;
            }
            if (now[2] + 1 <= n - 1 && line[now[1]][now[2] + 1]) {
                queue.offer(new int[]{now[0] + 1, now[1], now[2] + 1});
                line[now[1]][now[2] + 1] = false;
            }
            if (now[2] - 1 > now[0] && line[now[1]][now[2] - 1]) {
                queue.offer(new int[]{now[0] + 1, now[1], now[2] - 1});
                line[now[1]][now[2] - 1] = false;
            }
            if (now[2] + k <= n - 1 && line[(now[1] + 1) % 2][now[2] + k]) {
                queue.offer(new int[]{now[0] + 1, (now[1] + 1) % 2, now[2] + k});
                line[(now[1] + 1) % 2][now[2] + k] = false;
            }
        }
        System.out.println(0);
    }
}
