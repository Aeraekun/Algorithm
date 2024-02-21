import java.io.*;
import java.util.*;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] originVisited;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Stack<Integer[]> stack = new Stack<>();
	static List<Integer[]> cctv = new LinkedList<>();
	static int[] way = { 0, 4, 2, 4, 4, 1 };
	static int[] a = { 0, 1, 2, 3 };
	static int[][] b = { { 0, 2 }, { 1, 3 } };
	static int[][] c = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
	static int[][] d = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } };
	static int[] e = { 0, 1, 2, 3 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		originVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp != 0) {
					visited[i][j] = true;
					if (temp != 6)
						cctv.add(new Integer[] { i, j, temp });
				}
			}
		}
		for (int i = 0; i < N; i++) {
			originVisited[i] = visited[i].clone();
		}
		comb(0);
		System.out.println(ans);
	}

	private static void comb(int now) {
		if (now == cctv.size()) {
			calc();
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j])
						temp++;
				}
			}
			ans = Math.min(ans, temp);
			return;
		}
		for (int i = 0; i < way[cctv.get(now)[2]]; i++) {
			stack.add(new Integer[] { cctv.get(now)[2], i });
			comb(now + 1);
			stack.pop();
		}
	}

	private static void calc() {
		for (int i = 0; i < N; i++) {
			visited[i] = originVisited[i].clone();
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			Integer[] temp = stack.get(size - 1 - i);
			int y = cctv.get(cctv.size() - 1 - i)[0];
			int x = cctv.get(cctv.size() - 1 - i)[1];
			switch (temp[0]) {
			case 1:
				switch (temp[1]) {
				case 0:
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 1:
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				case 2:
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 3:
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				}
				break;
			case 2:
				switch (temp[1]) {
				case 0:
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 1:
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				}
				break;
			case 3:
				switch (temp[1]) {
				case 0:
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				case 1:
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 2:
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				case 3:
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				}
				break;
			case 4:
				switch (temp[1]) {
				case 0:
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 1:
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				case 2:
					for (int j = y; j < N; j++) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					break;
				case 3:
					for (int j = x; j >= 0; j--) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					for (int j = y; j >= 0; j--) {
						if (map[j][x] == 6)
							break;
						visited[j][x] = true;
					}
					for (int j = x; j < M; j++) {
						if (map[y][j] == 6)
							break;
						visited[y][j] = true;
					}
					break;
				}
				break;
			case 5:
				for (int j = y; j >= 0; j--) {
					if (map[j][x] == 6)
						break;
					visited[j][x] = true;
				}
				for (int j = x; j < M; j++) {
					if (map[y][j] == 6)
						break;
					visited[y][j] = true;
				}
				for (int j = y; j < N; j++) {
					if (map[j][x] == 6)
						break;
					visited[j][x] = true;
				}
				for (int j = x; j >= 0; j--) {
					if (map[y][j] == 6)
						break;
					visited[y][j] = true;
				}
				break;
			}
		}
	}
}