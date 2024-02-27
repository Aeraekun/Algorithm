import java.io.*;
import java.util.*;

public class Main {
    static int N, M, F, person, left;
    static boolean success;
    static int[] position;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static boolean[][] map;
    static int[][] people;
    static List<Integer>[][] dest;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        left = M;
        success = true;
        map = new boolean[N][N];
        people = new int[N][N];
        dest = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dest[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Objects.equals(st.nextToken(), "1");
            }
        }
        st = new StringTokenizer(br.readLine());
        position = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, F};
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            people[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i + 1;
            dest[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].add(i + 1);
        }
        for (int i = 0; i < M; i++) {
            if (success)
                pBFS();
            else break;
            if (success)
                dBFS();
            else break;
        }
        if (left != 0) System.out.println(-1);
        else System.out.println(position[2]);
    }

    private static void pBFS() {
        if (people[position[0]][position[1]] != 0) {
            person = people[position[0]][position[1]];
            people[position[0]][position[1]] = 0;
            return;
        }
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            visited[i] = map[i].clone();
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(position);
        visited[position[0]][position[1]] = true;
        int[] temp = {-1, -1, -1, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (temp[2] > now[2]) {
                person = temp[3];
                people[temp[0]][temp[1]] = 0;
                position[0] = temp[0];
                position[1] = temp[1];
                position[2] = temp[2] - 1;
                return;
            }
            if (now[2] == 0)
                continue;
            for (int d = 0; d < 4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                int nf = now[2];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (people[ny][nx] != 0 && (temp[0] == -1 || temp[0] > ny || (temp[0] == ny && temp[1] > nx))) {
                        temp[3] = people[ny][nx];
                        temp[0] = ny;
                        temp[1] = nx;
                        temp[2] = nf;
                    }
                    if (!visited[ny][nx]) {
                        queue.offer(new int[]{ny, nx, nf - 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        success = false;
    }

    private static void dBFS() {
        if (dest[position[0]][position[1]].contains(person)) {
            dest[position[0]][position[1]].remove(dest[position[0]][position[1]].indexOf(person));
            left--;
            return;
        }
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            visited[i] = map[i].clone();
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(position);
        visited[position[0]][position[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[2] == 0)
                continue;
            for (int d = 0; d < 4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                int nf = now[2];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (dest[ny][nx].contains(person)) {
                        dest[ny][nx].remove(dest[ny][nx].indexOf(person));
                        position[0] = ny;
                        position[1] = nx;
                        position[2] = nf - 1 + (position[2] - (nf - 1)) * 2;
                        left--;
                        return;
                    }
                    if (!visited[ny][nx]) {
                        queue.offer(new int[]{ny, nx, nf - 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        success = false;
    }
}