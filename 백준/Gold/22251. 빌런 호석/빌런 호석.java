import java.io.*;
import java.util.*;

public class Main {
	static int N, K, P, X, count;
	static int[][] arr = { { 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		count = 0;
		String first = X + "";
		String end = "";
		while (first.length() + end.length() < K) {
			end += "0";
		}
		end += first;
		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			String str = "";
			String value = i + "";
			while (str.length() + value.length() < K) {
				str += "0";
			}
			str += value;
			int sum = 0;
			for (int j = 0; j < str.length(); j++) {
				int[] a = arr[end.charAt(j) - '0'];
				int[] b = arr[str.charAt(j) - '0'];
				for (int t = 0; t < a.length; t++) {
					if (a[t] != b[t])
						sum++;
				}
			}
			if (sum <= P)
				count++;
		}
		System.out.println(count);
	}
}