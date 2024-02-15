import java.io.*;
import java.util.*;

public class Main {
	static int r, c, ans = 1;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] alphabet;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		alphabet = new boolean[26];
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int len) {
		alphabet[arr[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c)
				continue;
			if (alphabet[arr[nx][ny] - 'A'])
				continue;
			ans = Math.max(ans, len + 1);
			dfs(nx, ny, len + 1);
		}
		alphabet[arr[x][y] - 'A'] = false;
	}
}