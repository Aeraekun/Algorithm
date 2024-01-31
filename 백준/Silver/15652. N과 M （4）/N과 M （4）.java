import java.io.*;
import java.util.*;

public class Main {
	static int N, R;
	static int numbers[];
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[R];
		isSelected = new boolean[N];
		combination(0, 1);
	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			for (int i : numbers)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i);
		}
	}
}
