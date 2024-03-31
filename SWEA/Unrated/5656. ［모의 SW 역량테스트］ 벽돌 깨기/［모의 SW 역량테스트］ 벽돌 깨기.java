import java.io.*;
import java.util.*;

public class Solution {
    static int N, W, H, ans;
    static int[] shot;
    static int[] dh = {-1, 0, 1, 0};
    static int[] dw = {0, -1, 0, 1};
    static int[][] original;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;
            shot = new int[N];
            original = new int[H][W];
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < W; w++) {
                    original[h][w] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0);
            System.out.println(sb.append("#").append(t).append(" ").append(ans));
        }
    }

    private static void perm(int now) {
        if (now == N) {
            game();
            return;
        }
        for (int i = 0; i < W; i++) {
            shot[now] = i;
            perm(now + 1);
        }
    }

    private static void game() {
        int cnt = 0;
        int[][] map = new int[H][W];
        for (int h = 0; h < H; h++) {
            map[h] = original[h].clone();
        }
        for (int n = 0; n < N; n++) {
            visited = new boolean[H][W];
            Queue<int[]> queue = new ArrayDeque<>();
            int firstShot = -1;
            for (int h = H - 1; h >= 0; h--) {
                if (map[h][shot[n]] != 0) {
                    firstShot = h;
                } else break;
            }
            if (firstShot == -1)
                continue;
            queue.add(new int[]{firstShot, shot[n]});
            visited[firstShot][shot[n]] = true;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int nh = now[0];
                int nw = now[1];
                for (int d = 0; d < 4; d++) {
                    for (int r = 1; r < map[nh][nw]; r++) {
                        if (nh + dh[d] * r >= 0 && nh + dh[d] * r < H && nw + dw[d] * r >= 0 && nw + dw[d] * r < W) {
                            if (!visited[nh + dh[d] * r][nw + dw[d] * r]) {
                                visited[nh + dh[d] * r][nw + dw[d] * r] = true;
                                queue.add(new int[]{nh + dh[d] * r, nw + dw[d] * r});
                            }
                        }
                    }
                }
            }
            for (int w = 0; w < W; w++) {
                Queue<Integer> temp = new ArrayDeque<>();
                for (int h = H - 1; h >= 0; h--) {
                    if (map[h][w] != 0 && !visited[h][w]) {
                        temp.add(map[h][w]);
                    }
                }
                for (int h = H - 1; h >= 0; h--) {
                    if (!temp.isEmpty())
                        map[h][w] = temp.poll();
                    else map[h][w] = 0;
                }
            }
        }
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (map[h][w] != 0) cnt++;
            }
        }
        ans = Math.min(cnt, ans);
    }
}