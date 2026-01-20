import java.io.*;
import java.util.*;

public class Main {

    static int N, ans;
    static int[] dp, T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        cal();
        System.out.println(ans);
    }

    private static void cal() {
        for (int i = 0; i < N; i++) {
            if (i + T[i] == N) ans = Math.max(ans, dp[i] + P[i]);
            if (i + T[i] >= N) ans = Math.max(ans, dp[i]);
            else dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            if (i + 1 < N) dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
    }
}