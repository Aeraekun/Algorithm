import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, ans;
	static int[][] map;
	static int[][] fly;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			fly = new int[N + 1][N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					fly[i][j + 1] = fly[i][j] + map[i][j];
				}
			}
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int temp = 0;
					for (int k = 0; k < M; k++) {
						temp += fly[i + k][j + M] - fly[i + k][j];
					}
					ans = Math.max(ans, temp);
				}
			}
			System.out.println(sb.append("#").append(t).append(" ").append(ans));
		}
	}
}