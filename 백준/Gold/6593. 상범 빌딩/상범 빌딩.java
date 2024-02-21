import java.io.*;
import java.util.*;

public class Main {
	static int L, R, C;
	static int[] dl = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };
	static Integer[] start, end;
	static boolean[][][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0)
				break;
			visited = new boolean[L][R][C];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String str = br.readLine();
					for (int c = 0; c < C; c++) {
						char temp = str.charAt(c);
						if (temp == 'S')
							start = new Integer[] { l, r, c, 0 };
						else if (temp == 'E')
							end = new Integer[] { l, r, c, 0 };
						else if (temp == '#')
							visited[l][r][c] = true;
					}
				}
				br.readLine();
			}
			bfs();
		}
	}

	private static void bfs() throws IOException {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]][start[2]] = true;
		while (!queue.isEmpty()) {
			Integer[] now = queue.poll();
			if (now[0] == end[0] && now[1] == end[1] && now[2] == end[2]) {
				System.out.printf("Escaped in %d minute(s).\n", now[3]);
				return;
			}
			for (int d = 0; d < 6; d++) {
				int nl = now[0] + dl[d];
				int nr = now[1] + dr[d];
				int nc = now[2] + dc[d];
				if (nl >= 0 && nr >= 0 && nc >= 0 && nl < L && nr < R && nc < C && !visited[nl][nr][nc]
						&& !visited[nl][nr][nc]) {
					queue.add(new Integer[] { nl, nr, nc, now[3] + 1 });
					visited[nl][nr][nc] = true;
				}
			}
		}
		System.out.println("Trapped!");
	}
}