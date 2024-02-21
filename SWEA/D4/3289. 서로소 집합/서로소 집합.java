import java.io.*;
import java.util.*;

public class Solution {

	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.setLength(0);
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			makeSet();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("1")) {
					if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
						sb.append(1);
					else
						sb.append(0);
				} else {
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}
			System.out.printf("#%d %s\n", t, sb);
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