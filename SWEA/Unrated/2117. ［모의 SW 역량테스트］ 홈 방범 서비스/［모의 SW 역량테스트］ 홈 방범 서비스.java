import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, M, K, ans;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        list.add(new int[]{i, j});
                    }
                }
            }
            if (N % 2 == 0) {
                K = N + 1;
                visited[N / 2][N / 2] = visited[N / 2 - 1][N / 2] = visited[N / 2][N / 2 - 1] = visited[N / 2 - 1][N / 2 - 1] = true;
            } else {
                K = N;
                visited[N / 2][N / 2] = true;
            }
            for (int k = K; k > 0; k--) {
                int cost = k * k + (k - 1) * (k - 1);
                boolean check = false;
                for (int i = 0; i < N; i++) {
                    if (list.size() * M <= cost) break;
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j]) continue;
                        int count = 0;
                        for (int[] point : list) {
                            if (cal(point[0], point[1], i, j) < k) count++;
                        }
                        if (count * M >= cost) {
                            check = true;
                            ans = Math.max(ans, count);
                            if (count == cost) break;
                        }
                    }
                }
                if (check) break;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visited[i][j]) continue;
                        if (K % 2 == 0) {
                            if ((cal(i, j, N / 2, N / 2) == K - k + 1) ||
                                    (cal(i, j, N / 2 - 1, N / 2) == K - k + 1) ||
                                    (cal(i, j, N / 2, N / 2 - 1) == K - k + 1) ||
                                    (cal(i, j, N / 2 - 1, N / 2 - 1) == K - k + 1)) {
                                visited[i][j] = true;
                            }
                        } else {
                            if (cal(i, j, N / 2, N / 2) == K - k + 1) {
                                visited[i][j] = true;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int cal(int a1, int b1, int a2, int b2) {
        return Math.abs(a1 - a2) + Math.abs(b1 - b2);
    }
}