import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> danji = new ArrayList<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (map[x][y] == 0 || visited[x][y])
					continue;
				int size = 1;
				queue.add(new int[] { x, y });
				visited[x][y] = true;
				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					visited[now[0]][now[1]] = true;
					for (int i = 0; i < 4; i++) {
						if (now[0] + dx[i] >= 0 && now[0] + dx[i] < n && now[1] + dy[i] >= 0 && now[1] + dy[i] < n) {
							if (visited[now[0] + dx[i]][now[1] + dy[i]])
								continue;
							if (map[now[0] + dx[i]][now[1] + dy[i]] == 1) {
								queue.add(new int[] { now[0] + dx[i], now[1] + dy[i] });
								size++;
								visited[now[0] + dx[i]][now[1] + dy[i]] = true;
							}
						}
					}
				}
				if (size != 0)
					danji.add(size);
			}
		}
		danji.sort(null);
		System.out.println(danji.size());
		for (int i : danji)
			System.out.println(i);
	}
}