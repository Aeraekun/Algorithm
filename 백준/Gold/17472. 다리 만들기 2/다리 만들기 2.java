import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static int island = 1;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[][] map, bridge;
	static boolean[][] visited;

	static class Vertex implements Comparable<Vertex> {
		int no;
		int weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1)
					bfs(i, j);
			}
		}

		bridge = new int[island][island];
		for (int i = 0; i < island; i++)
			Arrays.fill(bridge[i], Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					makeBridge(i, j);
			}
		}

		if (!isConnected()) {
			System.out.println(-1);
			return;
		}

		prim();
		System.out.println(result);
	}

	private static boolean isConnected() {
		boolean[] visited = new boolean[island];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i < island; i++) {
				if (!visited[i] && bridge[current][i] != Integer.MAX_VALUE) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

		for (int i = 1; i < island; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void makeBridge(int a, int b) {
		int now = map[a][b];
		for (int d = 0; d < 4; d++) {
			int dest = -1;
			int len = 0;
			int ny = a + dy[d];
			int nx = b + dx[d];
			while (ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if (map[ny][nx] == 0) {
					len++;
					ny += dy[d];
					nx += dx[d];
					continue;
				} else if (map[ny][nx] == now) {
					break;
				} else {
					dest = map[ny][nx];
					break;
				}
			}
			if (dest == -1 || len < 2)
				continue;
			bridge[now][dest] = Math.min(bridge[now][dest], len);
			bridge[dest][now] = bridge[now][dest];
		}
	}

	private static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { a, b });
		visited[a][b] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			map[now[0]][now[1]] = island;
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 1 && !visited[ny][nx]) {
					queue.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
		}
		island++;
	}

	private static void prim() {
		boolean[] visited = new boolean[island];
		int[] minEdge = new int[island];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		pq.offer(new Vertex(1, minEdge[1]));
		int c = 0;
		while (!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if (visited[minVertex.no])
				continue;
			result += minVertex.weight;
			visited[minVertex.no] = true;
			if (++c == island)
				break;
			for (int i = 0; i < island; i++) {
				if (!visited[i] && bridge[minVertex.no][i] != 0 && bridge[minVertex.no][i] < minEdge[i]) {
					minEdge[i] = bridge[minVertex.no][i];
					pq.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
	}
}
