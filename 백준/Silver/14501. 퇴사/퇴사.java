import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T, P;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] <= N) {
                dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}