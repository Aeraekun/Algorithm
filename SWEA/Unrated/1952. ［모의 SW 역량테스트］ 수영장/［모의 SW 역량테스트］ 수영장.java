import java.io.*;
import java.util.*;

public class Solution {
	static int[] price, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			price = new int[4];
			dp = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				int m = Integer.parseInt(st.nextToken());
				dp[i] = Math.min(price[0] * m, price[1]) + dp[i - 1];
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + price[2]);
				}

			}
			System.out.println(sb.append("#").append(t).append(" ").append(Math.min(dp[12], price[3])));
		}
	}
}