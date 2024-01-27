import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				for (int j = 1; j <= n; j++) {
					if (j * b > n)
						break;
					if (arr[j * b - 1] == 1)
						arr[j * b - 1] = 0;
					else
						arr[j * b - 1] = 1;
				}
			} else {
				for (int j = 0; j < n; j++) {
					if (b + j > n || b - j <= 0) {
						break;
					}
					if (arr[b + j - 1] == arr[b - j - 1]) {
						if (arr[b + j - 1] == 1) {
							arr[b + j - 1] = 0;
							arr[b - j - 1] = 0;
						} else {
							arr[b + j - 1] = 1;
							arr[b - j - 1] = 1;
						}
					} else
						break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (i!=0 && i % 20 == 0)
				System.out.println();
			System.out.print(arr[i] + " ");
		}
	}
}
