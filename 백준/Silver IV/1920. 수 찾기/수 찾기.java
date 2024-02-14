import java.io.*;
import java.util.*;

public class Main {
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			binarySearch(0, n - 1, Integer.parseInt(st.nextToken()));
		}
	}

	private static void binarySearch(int start, int end, int target) {
		if (start > end) {
			System.out.println(0);
			return;
		}
		int mid = (start + end) / 2;
		if (target == a[mid]) {
			System.out.println(1);
			return;
		} else if (target > a[mid]) {
			binarySearch(mid + 1, end, target);
		} else {
			binarySearch(start, mid - 1, target);
		}
	}
}
