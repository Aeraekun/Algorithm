import java.io.*;
import java.util.*;

public class Main {
	static int n, ans;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 0;
		map = new int[n];
		backtracking(0);
		System.out.println(ans);
	}

	static void backtracking(int now) {
		if (now == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			map[now] = i;
			if (check(now))
				backtracking(now + 1);
		}
	}

	static boolean check(int now) {
		for (int i = 0; i < now; i++) {
			if (map[i] == map[now])
				return false;
			if (now - i == Math.abs(map[now] - map[i]))
				return false;
		}
		return true;
	}
}
