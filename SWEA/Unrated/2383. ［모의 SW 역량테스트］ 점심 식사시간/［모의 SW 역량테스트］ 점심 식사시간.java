import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, P, ans;
	static boolean[] isSelected;
	static int[][] map;
	static List<int[]> person, stairInfo;
	static Queue<Integer> stair1, stair2, time1, time2, wait1, wait2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			ans = Integer.MAX_VALUE;
			person = new ArrayList<>();
			stairInfo = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						person.add(new int[] { i, j, 0 });
					else if (map[i][j] != 0)
						stairInfo.add(new int[] { i, j, map[i][j] });
				}
			}
			isSelected = new boolean[person.size()];
			stair1 = new ArrayDeque<>();
			stair2 = new ArrayDeque<>();
			time1 = new ArrayDeque<>();
			time2 = new ArrayDeque<>();
			wait1 = new ArrayDeque<>();
			wait2 = new ArrayDeque<>();
			subSet(0);
			System.out.println(sb.append("#").append(t).append(" ").append(ans));
		}
	}

	private static void subSet(int cnt) {
		if (cnt == person.size()) {
			cal();
			return;
		}
		isSelected[cnt] = true;
		subSet(cnt + 1);
		isSelected[cnt] = false;
		subSet(cnt + 1);
	}

	private static void cal() {
		P = person.size();
		int now = 0;
		for (int i = 0; i < P; i++) {
			if (isSelected[i]) {
				person.get(i)[2] = Math.abs(stairInfo.get(0)[0] - person.get(i)[0])
						+ Math.abs(stairInfo.get(0)[1] - person.get(i)[1]);
			} else {
				person.get(i)[2] = Math.abs(stairInfo.get(1)[0] - person.get(i)[0])
						+ Math.abs(stairInfo.get(1)[1] - person.get(i)[1]);
			}
		}
		while (P != 0) {
			now++;
			if (time1.size() > 0) {
				int sSize = stair1.size();
				int wSize = wait1.size();
				for (int i = 0; i < sSize; i++) {
					int temp = time1.poll() - 1;
					if (temp == 0) {
						stair1.poll();
						P--;
					} else
						time1.add(temp);
				}
				if (wait1.size() > 0 && stair1.size() < 3) {
					sSize = stair1.size();
					wSize = wait1.size();
					for (int i = 0; i < Math.min(3 - sSize, wSize); i++) {
						stair1.add(wait1.poll());
						time1.add(stairInfo.get(0)[2]);
					}
				}
			}
			if (time2.size() > 0) {
				int sSize = stair2.size();
				int wSize = wait2.size();
				for (int i = 0; i < sSize; i++) {
					int temp = time2.poll() - 1;
					if (temp == 0) {
						stair2.poll();
						P--;
					} else
						time2.add(temp);
				}
				if (wait2.size() > 0 && stair2.size() < 3) {
					sSize = stair2.size();
					wSize = wait2.size();
					for (int i = 0; i < Math.min(3 - sSize, wSize); i++) {
						stair2.add(wait2.poll());
						time2.add(stairInfo.get(1)[2]);
					}
				}
			}
			for (int i = 0; i < person.size(); i++) {
				person.get(i)[2]--;
				if (person.get(i)[2] == -1) {
					if (isSelected[i]) {
						if (stair1.size() < 3) {
							stair1.add(i);
							time1.add(stairInfo.get(0)[2]);
						} else {
							wait1.add(i);
						}
					} else {
						if (stair2.size() < 3) {
							stair2.add(i);
							time2.add(stairInfo.get(1)[2]);
						} else {
							wait2.add(i);
						}
					}
				}
			}
		}
		ans = Math.min(ans, now);
	}
}
