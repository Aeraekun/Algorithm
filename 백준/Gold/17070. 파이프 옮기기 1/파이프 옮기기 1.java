import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = 0;
	static boolean[][] map;
	static int[][] pipe = { { 1, 0 }, { 1, 1 }, { 0, 1 } };
	static int[][] move = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().equals("0") ? true : false;
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 1, 2 });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int m : move[now[2]]) {
				int ny = now[0] + pipe[m][0];
				int nx = now[1] + pipe[m][1];
				if (ny < N && nx < N && map[ny][nx]) {
					if ((m == 1 && map[now[0] + 1][now[1]] && map[now[0]][now[1] + 1]) || m != 1) {
						if (ny == N - 1 && nx == N - 1)
							ans++;
						else
							queue.offer(new int[] { ny, nx, m });
					}
				}
			}
		}
		System.out.println(ans);
	}
}