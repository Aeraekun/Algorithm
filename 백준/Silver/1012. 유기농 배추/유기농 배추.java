import java.io.*;
import java.util.*;

public class Main {
	static int m, n, k;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for (int t = 0; t < tc; t++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			visited = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n) {
				if (map[x + dx[i]][y + dy[i]] == 1 && !visited[x + dx[i]][y + dy[i]]) {
					dfs(x + dx[i], y + dy[i]);
				}
			}
		}
	}
}