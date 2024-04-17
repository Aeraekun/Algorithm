import java.io.*;
import java.math.BigInteger;

public class Main {
	static int N, K;
	static BigInteger ans;
	static BigInteger dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = BigInteger.ZERO;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		if (K * 2 > N)
			ans = BigInteger.ZERO;
		else if (K * 2 == N)
			ans = BigInteger.valueOf(2);
		else if (K == 1)
			ans = BigInteger.valueOf(N);
		else {
			int t = 0;
			dp = new BigInteger[N - (2 * (K - 1))];
			dp[1] = BigInteger.ONE;
			for (int i = 2; i <= N - (2 * K - 1); i++) {
				dp[i] = dp[i - 1].add(BigInteger.valueOf(i));
			}
			t = 2;
			while (t < K) {
				for (int i = 2; i <= N - (2 * K - 1); i++) {
					dp[i] = dp[i].add(dp[i - 1]);
				}
				t++;
			}
			ans = ans.add(dp[N - (2 * K - 1)].multiply(BigInteger.valueOf(2)).subtract(dp[N - (2 * K - 1) - 1]))
					.mod(BigInteger.valueOf(1000000003));
		}
		System.out.println(ans);
	}
}
