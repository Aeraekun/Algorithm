import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		toString(0, 0, n);
		System.out.println(sb);
	}

	static void toString(int x, int y, int n) {
		if (check(x, y, n)) {
			sb.append(arr[x][y]);
			return;
		}
		n = n / 2;
		sb.append("(");
		toString(x, y, n);
		toString(x, y + n, n);
		toString(x + n, y, n);
		toString(x + n, y + n, n);
		sb.append(")");
	}

	static boolean check(int x, int y, int n) {
		int temp = arr[x][y];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i + x][j + y] != temp) {
					return false;
				}
			}
		}
		return true;
	}
}
