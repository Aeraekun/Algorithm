import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		bfs();
		bfs2();
	}

	private static void bfs() {
		int ans = 0;
		boolean[][] visited = new boolean[n][n];
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					stack.push(new int[] { i, j });
					while (!stack.isEmpty()) {
						int[] now = stack.pop();
						visited[now[0]][now[1]] = true;
						for (int d = 0; d < 4; d++) {
							if (now[0] + dx[d] >= 0 && now[0] + dx[d] < n && now[1] + dy[d] >= 0
									&& now[1] + dy[d] < n) {
								if (map[i][j] == map[now[0] + dx[d]][now[1] + dy[d]]
										&& !visited[now[0] + dx[d]][now[1] + dy[d]]) {
									stack.push(new int[] { now[0] + dx[d], now[1] + dy[d] });
									visited[now[0] + dx[d]][now[1] + dy[d]] = true;
								}
							}
						}
					}
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs2() {
		int ans = 0;
		boolean[][] visited = new boolean[n][n];
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					stack.push(new int[] { i, j });
					while (!stack.isEmpty()) {
						int[] now = stack.pop();
						visited[now[0]][now[1]] = true;
						for (int d = 0; d < 4; d++) {
							if (now[0] + dx[d] >= 0 && now[0] + dx[d] < n && now[1] + dy[d] >= 0
									&& now[1] + dy[d] < n) {
								if (((map[i][j] == 'B' && map[i][j] == map[now[0] + dx[d]][now[1] + dy[d]])
										|| (map[i][j] != 'B' && map[now[0] + dx[d]][now[1] + dy[d]] != 'B'))
										&& (!visited[now[0] + dx[d]][now[1] + dy[d]])) {
									stack.push(new int[] { now[0] + dx[d], now[1] + dy[d] });
									visited[now[0] + dx[d]][now[1] + dy[d]] = true;
								}
							}
						}
					}
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}