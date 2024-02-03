import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int ans = n;
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (o1, o2) -> {
				return o1[0] - o2[0];
			});
			int now = 0;
			for (int i = 1; i < n; i++) {
				if (arr[now][1] < arr[i][1]) {
					ans--;
				} else
					now = i;
			}
			System.out.println(ans);
		}
	}
}