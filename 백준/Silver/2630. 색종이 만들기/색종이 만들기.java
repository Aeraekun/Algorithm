import java.util.Scanner;

public class Main {
	static int[][] map;
	static int white, blue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solve(int i, int j, int n) {
		int sum = 0;
		for (int r = i; r < i + n; r++) {
			for (int c = j; c < j + n; c++) {
				sum += map[r][c];
			}
		}
		if (sum == 0) {
			++white;
		} else if (sum == n * n) {
			++blue;
		} else {
			int size = n / 2;
			solve(i, j, size);
			solve(i, j + size, size);
			solve(i + size, j, size);
			solve(i + size, j + size, size);
		}
	}
}
