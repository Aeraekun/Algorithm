import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        cal();
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

    private static void cal() {
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }
    }
}
