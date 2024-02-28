import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, ans, sy, sx, coreCnt, coreAns, lineAns;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int[][] map;
	static int[][] core;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = coreCnt = coreAns = lineAns = 0;
			sy = sx = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextToken().equals("1")) {
						visited[i][j] = true;
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							map[i][j] = 2;
						} else {
							map[i][j] = 1;
							coreCnt++;
							if (sy == -1) {
								sy = i;
								sx = j;
							}
						}
					}
				}
			}
			core = new int[coreCnt][2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						core[idx][0] = i;
						core[idx][1] = j;
						idx++;
					}
				}
			}
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, lineAns);
		}
	}

	private static void dfs(int idx, int c, int l) {
		if (coreCnt - idx + c < coreAns)
			return;
		if (idx == coreCnt) {
			if (c > coreAns || (c == coreAns && l < lineAns)) {
				coreAns = c;
				lineAns = l;
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ny = core[idx][0] + dy[d];
			int nx = core[idx][1] + dx[d];
			int tempL = l;
			if (!visited[ny][nx]) {
				boolean check = true;
				if (d == 0) {
					for (int y = ny; y >= 0; y--) {
						if (visited[y][nx]) {
							check = false;
							break;
						}
					}
					if (check) {
						for (int y = ny; y >= 0; y--) {
							visited[y][nx] = true;
							tempL++;
						}
						dfs(idx + 1, c + 1, tempL);
						for (int y = ny; y >= 0; y--) {
							visited[y][nx] = false;
							tempL--;
						}
					}
				} else if (d == 1) {
					for (int x = nx; x < N; x++) {
						if (visited[ny][x]) {
							check = false;
							break;
						}
					}
					if (check) {
						for (int x = nx; x < N; x++) {
							visited[ny][x] = true;
							tempL++;
						}
						dfs(idx + 1, c + 1, tempL);
						for (int x = nx; x < N; x++) {
							visited[ny][x] = false;
							tempL--;
						}
					}
				} else if (d == 2) {
					for (int y = ny; y < N; y++) {
						if (visited[y][nx]) {
							check = false;
							break;
						}
					}
					if (check) {
						for (int y = ny; y < N; y++) {
							visited[y][nx] = true;
							tempL++;
						}
						dfs(idx + 1, c + 1, tempL);
						for (int y = ny; y < N; y++) {
							visited[y][nx] = false;
							tempL--;
						}
					}
				} else if (d == 3) {
					for (int x = nx; x >= 0; x--) {
						if (visited[ny][x]) {
							check = false;
							break;
						}
					}
					if (check) {
						for (int x = nx; x >= 0; x--) {
							visited[ny][x] = true;
							tempL++;
						}
						dfs(idx + 1, c + 1, tempL);
						for (int x = nx; x >= 0; x--) {
							visited[ny][x] = false;
							tempL--;
						}
					}
				}
				dfs(idx + 1, c, tempL);
			}
		}
	}
}