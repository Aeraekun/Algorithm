import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) continue;
                if (i == N - 1 && j == N - 1) continue;
                int tj = j + map[i][j];
                int ti = i + map[i][j];
                if (tj < N) dp[i][tj] += dp[i][j];
                if (ti < N) dp[ti][j] += dp[i][j];
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
