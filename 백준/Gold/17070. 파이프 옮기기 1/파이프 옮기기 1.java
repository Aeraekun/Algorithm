import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		dp = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().equals("0") ? true : false;
			}
		}
		dp[0][1][0] = 1;
		for (int y = 0; y < N; y++) {
			for (int x = 2; x < N; x++) {
				if (!map[y][x])
					continue;
				if (x - 1 >= 0)
					dp[y][x][0] += dp[y][x - 1][0] + dp[y][x - 1][1];
				if (y - 1 >= 0)
					dp[y][x][2] += dp[y - 1][x][2] + dp[y - 1][x][1];
				if (x - 1 >= 0 && y - 1 >= 0 && map[y][x - 1] && map[y - 1][x]) {
					for (int i = 0; i < 3; i++)
						dp[y][x][1] += dp[y - 1][x - 1][i];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}
}