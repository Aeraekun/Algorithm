import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans = Integer.MAX_VALUE;
	static ArrayList<int[]> hList = new ArrayList<>();
	static ArrayList<int[]> cList = new ArrayList<>();
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1) {
					hList.add(new int[] { i, j });
				} else if (v == 2) {
					cList.add(new int[] { i, j });
				}
			}
		}

		comb(0, 0);
		System.out.println(ans);
	}

	static int dist(int[] home, int[] chi) {
		return Math.abs(home[0] - chi[0]) + Math.abs(home[1] - chi[1]);
	}

	static void comb(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < hList.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					minDist = Math.min(minDist, dist(hList.get(i), cList.get(selected[j])));
				}
				sum += minDist;
			}
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < cList.size(); i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}