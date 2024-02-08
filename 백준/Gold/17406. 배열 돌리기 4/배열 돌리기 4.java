import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, ans;
	static int[] order;
	static int[][] map, calMap, cal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		order = new int[k];
		for (int i = 0; i < k; i++) {
			order[i] = i;
		}
		map = new int[n][m];
		calMap = new int[n][m];
		cal = new int[k][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				calMap[i][j] = temp;
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cal[i][j] = Integer.parseInt(st.nextToken()) - 1; // or -1
			}
		}
		do {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					calMap[i][j] = map[i][j];
				}
			}
			for (int t : order) {
				turn(t);
			}
			for (int i = 0; i < n; i++) {
				int temp = 0;
				for (int j = 0; j < m; j++) {
					temp += calMap[i][j];
				}
				ans = Math.min(ans, temp);
			}
		} while (np(order));
		System.out.println(ans);
	}

	public static boolean np(int[] p) {
		final int N = p.length;
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void turn(int t) {
		int R = cal[t][0];
		int C = cal[t][1];
		int S = cal[t][2] + 1;
		Queue<Integer> q = new LinkedList<>();
		for (int s = 1; s <= S; s++) {
			q.add(calMap[R - s][C + s]);
			for (int c = C + s - 1; c >= C - s; c--)
				calMap[R - s][c + 1] = calMap[R - s][c];
			q.add(calMap[R + s][C + s]);
			for (int r = R + s - 1; r > R - s; r--)
				calMap[r + 1][C + s] = calMap[r][C + s];
			calMap[R - s + 1][C + s] = q.poll();
			q.add(calMap[R + s][C - s]);
			for (int c = C - s + 1; c < C + s; c++)
				calMap[R + s][c - 1] = calMap[R + s][c];
			calMap[R + s][C + s - 1] = q.poll();
			for (int r = R - s + 1; r < R + s; r++)
				calMap[r - 1][C - s] = calMap[r][C - s];
			calMap[R + s - 1][C - s] = q.poll();
		}
	}
}
