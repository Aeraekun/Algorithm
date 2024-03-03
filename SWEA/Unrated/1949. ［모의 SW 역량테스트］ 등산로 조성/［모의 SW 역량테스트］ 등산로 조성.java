import java.util.*;
import java.io.*;

class Solution {
    static int T, N, K, highest, ans;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            List<int[]> list = new ArrayList<>();
            ans = highest = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    highest = Math.max(highest, map[i][j]);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == highest)
                        list.add(new int[]{i, j});
                }
            }
            for (int[] now : list) {
                visited[now[0]][now[1]] = true;
                dfs(1, now[0], now[1], K, 0);
                visited[now[0]][now[1]] = false;
            }
            System.out.println(sb.append("#").append(t).append(" ").append(ans));
        }
    }

    private static void dfs(int len, int y, int x, int k, int minus) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (!visited[ny][nx]) {
                    if (map[y][x] - minus > map[ny][nx]) {
                        visited[ny][nx] = true;
                        dfs(len + 1, ny, nx, k, 0);
                    } else {
                        if (k - (map[ny][nx] - (map[y][x] - minus - 1)) >= 0) {
                            visited[ny][nx] = true;
                            dfs(len + 1, ny, nx, 0, map[ny][nx] - (map[y][x] - minus - 1));
                        }
                    }
                }
            }
            ans = Math.max(ans, len);
        }
        visited[y][x] = false;
    }
}
