import java.io.*;
import java.util.*;

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int R, C, ans = 0;
    static int left = Integer.MAX_VALUE;
    static int right = Integer.MIN_VALUE;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visited;
    static char[][] map;
    static int[][] melt;
    static int[][] swan = {{-1, -1}, {-1, -1}};
    static Deque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        melt = new int[R][C];
        for (int r = 0; r < R; r++) {
            Arrays.fill(melt[r], Integer.MAX_VALUE);
        }

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] != 'X') {
                    if (map[r][c] == 'L') {
                        if (swan[0][0] == -1) {
                            swan[0][0] = r;
                            swan[0][1] = c;
                        } else {
                            swan[1][0] = r;
                            swan[1][1] = c;
                        }
                    }
                    melt[r][c] = 0;
                    deque.offer(new Node(r, c));
                }
            }
        }
        cal();
        bfs();
        System.out.println(ans);
    }

    private static void cal() {
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            int nr = node.r;
            int nc = node.c;

            for (int d = 0; d < 4; d++) {
                if (nr + dr[d] < 0 || nr + dr[d] >= R || nc + dc[d] < 0 || nc + dc[d] >= C) continue;
                if (melt[nr + dr[d]][nc + dc[d]] == Integer.MAX_VALUE) {
                    melt[nr + dr[d]][nc + dc[d]] = melt[nr][nc] + 1;
                    deque.offer(new Node(nr + dr[d], nc + dc[d]));
                }
            }
        }
    }

    private static void bfs() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                left = Math.min(left, melt[r][c]);
                right = Math.max(right, melt[r][c]);
            }
        }
        while (left <= right) {
            boolean possible = false;
            int mid = (left + right) / 2;
            visited = new boolean[R][C];
            deque.offer(new Node(swan[0][0], swan[0][1]));
            visited[swan[0][0]][swan[0][1]] = true;
            while (!deque.isEmpty()) {
                Node node = deque.poll();
                int nr = node.r;
                int nc = node.c;

                for (int d = 0; d < 4; d++) {
                    if (nr + dr[d] == swan[1][0] && nc + dc[d] == swan[1][1]) {
                        possible = true;
                        break;
                    }
                    if (nr + dr[d] < 0 || nr + dr[d] >= R || nc + dc[d] < 0 || nc + dc[d] >= C) continue;
                    if (!visited[nr + dr[d]][nc + dc[d]] && melt[nr + dr[d]][nc + dc[d]] <= mid) {
                        visited[nr + dr[d]][nc + dc[d]] = true;
                        deque.offer(new Node(nr + dr[d], nc + dc[d]));
                    }
                }
            }
            if (possible) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
    }
}
