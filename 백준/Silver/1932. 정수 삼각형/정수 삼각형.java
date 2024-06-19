import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp = new int[500];
    static int[] temp = new int[500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        N = Integer.parseInt(br.readLine());
        dp[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    temp[0] = dp[0] + Integer.parseInt(st.nextToken());
                } else if (j == i) {
                    temp[j] = dp[j - 1] + Integer.parseInt(st.nextToken());
                } else {
                    temp[j] = Math.max(dp[j - 1], dp[j]) + Integer.parseInt(st.nextToken());
                }
            }
            dp = temp.clone();
        }
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}