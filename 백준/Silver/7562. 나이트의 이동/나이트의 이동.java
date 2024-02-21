import java.io.*;
import java.util.*;

public class Main {

	static int I;
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] start, end;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			I = Integer.parseInt(br.readLine());
			visited = new boolean[I][I];
			st = new StringTokenizer(br.readLine());
			start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };
			st = new StringTokenizer(br.readLine());
			end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };
			Queue<int[]> queue = new LinkedList<>();
			queue.add(start);
			visited[start[0]][start[1]] = true;
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				if (now[0] == end[0] && now[1] == end[1]) {
					System.out.println(now[2]);
					break;
				}
				for (int d = 0; d < 8; d++) {
					if (now[0] + dy[d] >= 0 && now[0] + dy[d] < I && now[1] + dx[d] >= 0 && now[1] + dx[d] < I) {
						if (!visited[now[0] + dy[d]][now[1] + dx[d]]) {
							queue.offer(new int[] { now[0] + dy[d], now[1] + dx[d], now[2] + 1 });
							visited[now[0] + dy[d]][now[1] + dx[d]] = true;
						}
					}
				}
			}
		}
	}
}