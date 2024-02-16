import java.io.*;
import java.util.*;

public class Main {
	static int M, N, ans = 0;
	static int[] dm = { 1, 0, -1, 0 };
	static int[] dn = { 0, 1, 0, -1 };
	static int[][] tomato;
	static boolean[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		tomato = new int[M][N];
		queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == -1)
					visited[i][j] = true;
				if (tomato[i][j] == 1)
					queue.offer(new int[] { i, j });
			}
		}
		bfs();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans - 1);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nM = now[0] + dm[d];
					int nN = now[1] + dn[d];
					if (nM >= 0 && nM < M && nN >= 0 && nN < N && tomato[nM][nN] == 0) {
						tomato[nM][nN] = -1;
						queue.offer(new int[] { nM, nN });
					}
				}
			}
			ans++;
		}
	}
}