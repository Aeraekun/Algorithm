import java.io.*;
import java.util.*;

public class Solution {
	static int ans, N;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map, wh1, wh2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine().trim());
			ans = 0;
			map = new int[N][N];
			wh1 = new int[][] { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };
			wh2 = new int[][] { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if (temp > 5) {
						if (wh1[temp % 5][0] == -1) {
							wh1[temp % 5][0] = i;
							wh1[temp % 5][1] = j;
						} else {
							wh2[temp % 5][0] = i;
							wh2[temp % 5][1] = j;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0)
						game(i, j);
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void game(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y;
			int nx = x;
			int nd = d;
			int point = 0;
			while (true) {
				ny += dy[nd];
				nx += dx[nd];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
					point++;
					nd = (nd + 2) % 4;
				} else if (map[ny][nx] == -1) {
					break;
				} else if (map[ny][nx] > 0 && map[ny][nx] <= 5) {
					point++;
					nd = dirCal(map[ny][nx], nd);
				} else if (map[ny][nx] > 5) {
					int ty = ny;
					int tx = nx;
					if (ny == wh1[map[ny][nx] % 5][0] && nx == wh1[map[ny][nx] % 5][1]) {
						ty = wh2[map[ny][nx] % 5][0];
						tx = wh2[map[ny][nx] % 5][1];
					} else {
						ty = wh1[map[ny][nx] % 5][0];
						tx = wh1[map[ny][nx] % 5][1];
					}
					ny = ty;
					nx = tx;
				}
				if (ny == y && nx == x)
					break;
			}
			ans = Math.max(ans, point);
		}
	}

	private static int dirCal(int block, int nd) {
		if (nd == 0) {
			if (block == 1)
				return 2;
			if (block == 2)
				return 1;
			if (block == 3)
				return 3;
			if (block == 4)
				return 2;
			else
				return 2;
		} else if (nd == 1) {
			if (block == 1)
				return 3;
			if (block == 2)
				return 3;
			if (block == 3)
				return 2;
			if (block == 4)
				return 0;
			else
				return 3;
		} else if (nd == 2) {
			if (block == 1)
				return 1;
			if (block == 2)
				return 0;
			if (block == 3)
				return 0;
			if (block == 4)
				return 3;
			else
				return 0;
		} else {
			if (block == 1)
				return 0;
			if (block == 2)
				return 2;
			if (block == 3)
				return 1;
			if (block == 4)
				return 1;
			else
				return 1;
		}
	}
}