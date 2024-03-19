import java.io.*;
import java.util.*;

public class Solution {
	static int N, L, ans;
	static int[][] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < (1 << N); i++) {
				int cal = 0;
				int score = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) != 0) {
						score += arr[j][0];
						cal += arr[j][1];
						if (cal > L)
							break;
					}
				}
				if (cal < L)
					ans = Math.max(ans, score);
			}
			System.out.println(sb.append("#").append(t).append(" ").append(ans));
		}
	}
}
