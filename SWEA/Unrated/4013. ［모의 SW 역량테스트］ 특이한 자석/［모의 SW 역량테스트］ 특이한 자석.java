import java.io.*;
import java.util.*;

public class Solution {
	static int K, ans;
	static List<Integer>[] magnet = new ArrayList[4];
	static boolean[] check = new boolean[3];
	static int[] turns;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			ans = 0;
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				magnet[i] = new ArrayList<>();
				for (int j = 0; j < 8; j++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int now = Integer.parseInt(st.nextToken()) - 1;
				int turn = Integer.parseInt(st.nextToken());
				if ((now % 2 == 0 && turn == 1) || (now % 2 == 1 && turn == -1)) {
					turns = new int[] { 1, -1, 1, -1 };
				} else
					turns = new int[] { -1, 1, -1, 1 };
				check[0] = true;
				for (int i = 0; i < 3; i++) {
					if (magnet[i].get(2) == magnet[i + 1].get(6))
						check[i] = false;
					else
						check[i] = true;
				}
				turn(now);
				for (int i = now; i < 3; i++) {
					if (check[i]) {
						turn(i + 1);
					} else
						break;
				}
				for (int i = now - 1; i >= 0; i--) {
					if (check[i]) {
						turn(i);
					} else
						break;
				}
			}
			if (magnet[0].get(0) == 1)
				ans += 1;
			if (magnet[1].get(0) == 1)
				ans += 2;
			if (magnet[2].get(0) == 1)
				ans += 4;
			if (magnet[3].get(0) == 1)
				ans += 8;
			System.out.println(sb.append("#").append(t).append(" ").append(ans));
		}
	}

	private static void turn(int now) {
		if (turns[now] == 1) {
			int temp = magnet[now].get(7);
			magnet[now].remove(7);
			magnet[now].add(0, temp);
		} else {
			int temp = magnet[now].get(0);
			magnet[now].remove(0);
			magnet[now].add(temp);
		}
	}
}
