import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[w][h];
			visited = new boolean[w][h];
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
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
		for (int i = 0; i < 8; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0 && y + dy[i] < h) {
				if (map[x + dx[i]][y + dy[i]] == 1 && !visited[x + dx[i]][y + dy[i]]) {
					dfs(x + dx[i], y + dy[i]);
				}
			}
		}
	}
}