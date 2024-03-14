import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static List<xy> chi, home;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[] isSelected;
    static boolean[][] visited;

    static class xy {
        int y;
        int x;

        xy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new int[N][N];
        chi = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    home.add(new xy(i, j));
                else if (map[i][j] == 2)
                    chi.add(new xy(i, j));
            }
        }
        isSelected = new boolean[chi.size()];
        comb(0, 0);
        System.out.println(ans);
    }

    private static void comb(int start, int now) {
        if (now == M) {
            bfs();
            return;
        }
        for (int i = start; i < chi.size(); i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                comb(i + 1, now + 1);
                isSelected[i] = false;
            }
        }
    }

    private static void bfs() {
        int temp = 0;
        for (int h = 0; h < home.size(); h++) {
            int mt = Integer.MAX_VALUE;
            for (int c = 0; c < chi.size(); c++) {
                if (isSelected[c]) {
                    mt = Math.min(mt, Math.abs(chi.get(c).y - home.get(h).y) + Math.abs(chi.get(c).x - home.get(h).x));
                }
            }
            temp += mt;
        }
        ans = Math.min(ans, temp);
    }
}