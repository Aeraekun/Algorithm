import java.io.*;
import java.util.*;

public class Main {
	static int M, N, H, ans = 0;
	static int[] dm = { 1, 0, 0, -1, 0, 0 };
	static int[] dn = { 0, 1, 0, 0, -1, 0 };
	static int[] dh = { 0, 0, 1, 0, 0, -1 };
	static int[][][] tomato;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][M][N];
		queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					tomato[h][i][j] = Integer.parseInt(st.nextToken());
					if (tomato[h][i][j] == 1)
						queue.offer(new int[] { h, i, j });
				}
			}
		}
		bfs();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (tomato[h][i][j] == 0) {
						System.out.println(-1);
						return;
					}
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
				for (int d = 0; d < 6; d++) {
					int nH = now[0] + dh[d];
					int nM = now[1] + dm[d];
					int nN = now[2] + dn[d];
					if (nH >= 0 && nH < H && nM >= 0 && nM < M && nN >= 0 && nN < N && tomato[nH][nM][nN] == 0) {
						tomato[nH][nM][nN] = -1;
						queue.offer(new int[] { nH, nM, nN });
					}
				}
			}
			ans++;
		}
	}
}