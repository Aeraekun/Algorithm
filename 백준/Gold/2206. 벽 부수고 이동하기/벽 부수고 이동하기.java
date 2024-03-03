import java.io.*;
import java.util.*;

class Main {
    static int N, M, ans;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new int[N][];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        bfs();
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] == N - 1 && now[2] == M - 1) {
                ans = Math.min(ans, now[0]);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int ny = now[1] + dy[d];
                int nx = now[2] + dx[d];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 0) {
                        if (now[3] == 0 && !visited[ny][nx][0]) {
                            visited[ny][nx][0] = true;
                            queue.add(new int[]{now[0] + 1, ny, nx, 0});
                        } else if (now[3] == 1 && !visited[ny][nx][1]) {
                            visited[ny][nx][1] = true;
                            queue.add(new int[]{now[0] + 1, ny, nx, 1});
                        }
                    } else {
                        if (now[3] == 0 && !visited[ny][nx][1]) {
                            visited[ny][nx][1] = true;
                            queue.add(new int[]{now[0] + 1, ny, nx, 1});
                        }
                    }
                }
            }
        }
    }
}