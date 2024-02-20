import java.io.*;
import java.util.*;

public class Main {
	static int n, m, d, ans;
	static int[] result;
	static boolean[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] in = new int[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = Integer.parseInt(st.nextToken());
			if (count == 1)
				continue;
			for (int j = 1; j < count; j++) {
				s = e;
				e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				++in[e];
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				q.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append("\n");
			for (int i = 0, size = list[v].size(); i < size; i++) {
				int e = list[v].get(i);
				if (--in[e] == 0) {
					q.offer(e);
				}
			}
		}
		for (int i : in)
			if (i != 0) {
				System.out.println(0);
				return;
			}
		System.out.println(sb.toString());
	}
}