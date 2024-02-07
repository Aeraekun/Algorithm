import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		List<Integer> cal = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			cal.add(Integer.parseInt(st.nextToken()));
		}
		while (true) {
			boolean update = false;
			for (int i = cal.size() - 1; i > 0; i--) {
				switch (cal.get(i)) {
				case 1:
					if (cal.size() != 0 && cal.get(i - 1) == 1) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				case 2:
					if (cal.size() != 0 && cal.get(i - 1) == 2) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				case 3:
					if (cal.size() != 0 && cal.get(i - 1) == 4) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				case 4:
					if (cal.size() != 0 && cal.get(i - 1) == 3) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				case 5:
					if (cal.size() != 0 && cal.get(i - 1) == 6) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				case 6:
					if (cal.size() != 0 && cal.get(i - 1) == 5) {
						cal.remove(i);
						cal.remove(i - 1);
						i--;
						update = true;
					}
					break;
				}
			}
			if (!update)
				break;
		}
		for (int c : cal) {
			n = map.length;
			m = map[0].length;
			int iHalf, jHalf;
			int[][] temp;
			switch (c) {
			case 1:
				temp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[n - i - 1][j] = map[i][j];
					}
				}
				map = temp;
				break;
			case 2:
				temp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[i][m - j - 1] = map[i][j];
					}
				}
				map = temp;
				break;
			case 3:
				temp = new int[m][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[j][n - i - 1] = map[i][j];
					}
				}
				map = temp;
				break;
			case 4:
				temp = new int[m][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[m - j - 1][i] = map[i][j];
					}
				}
				map = temp;
				break;
			case 5:
				temp = new int[n][m];
				iHalf = n / 2;
				jHalf = m / 2;
				for (int i = 0; i < iHalf; i++) {
					for (int j = 0; j < jHalf; j++) {
						temp[i][j + jHalf] = map[i][j];
						temp[i + iHalf][j + jHalf] = map[i][j + jHalf];
						temp[i + iHalf][j] = map[i + iHalf][j + jHalf];
						temp[i][j] = map[i + iHalf][j];
					}
				}
				map = temp;
				break;
			case 6:
				temp = new int[n][m];
				iHalf = n / 2;
				jHalf = m / 2;
				for (int i = 0; i < iHalf; i++) {
					for (int j = 0; j < jHalf; j++) {
						temp[i + iHalf][j] = map[i][j];
						temp[i][j] = map[i][j + jHalf];
						temp[i][j + jHalf] = map[i + iHalf][j + jHalf];
						temp[i + iHalf][j + jHalf] = map[i + iHalf][j];
					}
				}
				map = temp;
				break;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}