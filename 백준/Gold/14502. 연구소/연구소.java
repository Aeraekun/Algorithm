import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans;
	static int[][] wall, map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[n][m];
		wall = new int[3][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(ans);

	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			bfs(wall);
			return;
		}
		for (int i = start; i < n * m; i++) {
			int x = i / m;
			int y = i % m;
			if (map[x][y] == 0) {
				wall[cnt][0] = x;
				wall[cnt][1] = y;
				comb(cnt + 1, i + 1);
			}
		}
	}

	private static void bfs(int[][] wall) {
		int[][] copyMap = new int[n][m];
		for (int i = 0; i < n; i++)
			copyMap[i] = map[i].clone();
		for (int i = 0; i < 3; i++)
			copyMap[wall[i][0]][wall[i][1]] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0 || copyMap[i][j] == 1)
					continue;
				queue.offer(new int[] { i, j });
				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					for (int k = 0; k < 4; k++) {
						if (now[0] + dx[k] >= 0 && now[0] + dx[k] < n && now[1] + dy[k] >= 0 && now[1] + dy[k] < m) {
							if (copyMap[now[0] + dx[k]][now[1] + dy[k]] == 0) {
								queue.add(new int[] { now[0] + dx[k], now[1] + dy[k] });
								copyMap[now[0] + dx[k]][now[1] + dy[k]] = 2;
							}
						}
					}
				}
			}
		}
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0)
					temp++;
			}
		}
		ans = Math.max(ans, temp);
	}
}