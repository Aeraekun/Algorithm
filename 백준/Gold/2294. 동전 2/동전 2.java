import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        System.out.println(dp[k] != Integer.MAX_VALUE - 1 ? dp[k] : -1);
    }
}