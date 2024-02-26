import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer> ans = new ArrayList<>();
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		ans.add(1);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i <= N; i++) {
				if (!ans.contains(i) && (map[temp][i] || map[i][temp])) {
					queue.offer(i);
					ans.add(i);
				}
			}
		}
		System.out.println(ans.size() - 1);
	}
}
