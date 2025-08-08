import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append(cal(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
    }

    private static int cal(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[1] = 1;
            else if (i == 2) dp[2] = 2;
            else if (i == 3) dp[3] = 4;
            else dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
