import java.io.*;
import java.util.*;

public class Solution {

	static Integer[] parents;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new Integer[N + 1];
			makeSet();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for (int n = 1; n <= N; n++) {
				find(n);
			}
			Set<Integer> set = new HashSet<Integer>(Arrays.asList(parents));
			System.out.printf("#%d %d\n", t, set.size() - 1);
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		parents[bRoot] = aRoot;
	}

	private static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
}