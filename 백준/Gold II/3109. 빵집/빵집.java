import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans;
    static int[] d = {-1, 0, 1};
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < R; i++)
            dfs(i, 0);
        System.out.println(ans);
    }

    private static boolean dfs(int a, int b) {
        map[a][b] = 'x';
        if (b == C - 1) {
            ans++;
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (a + d[i] < 0 || a + d[i] >= R || map[a + d[i]][b + 1] == 'x') continue;
            if (dfs(a + d[i], b + 1)) return true;
        }
        return false;
    }
}