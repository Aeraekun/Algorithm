import java.io.*;
import java.util.*;

public class Main {
	static int n, ans;
	static int[][] egg;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		ans = 0;
		egg = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		search(0, 0);
		System.out.println(ans);
	}

	static void search(int idx, int cnt) {
		if (idx == n) {
			ans = Math.max(ans, cnt);
			return;
		}
		if (egg[idx][0] <= 0 || cnt == n - 1) {
			search(idx + 1, cnt);
			return;
		}
		int tempCnt = cnt;
		for (int i = 0; i < n; i++) {
			if (i == idx)
				continue;
			if (egg[i][0] <= 0)
				continue;
			hit(i, idx);
			if (egg[i][0] <= 0)
				cnt++;
			if (egg[idx][0] <= 0)
				cnt++;
			search(idx + 1, cnt);
			heal(i, idx);
			cnt = tempCnt;
		}
	}

	static void hit(int i, int j) {
		egg[j][0] -= egg[i][1];
		egg[i][0] -= egg[j][1];
	}

	static void heal(int i, int j) {
		egg[j][0] += egg[i][1];
		egg[i][0] += egg[j][1];
	}
}
