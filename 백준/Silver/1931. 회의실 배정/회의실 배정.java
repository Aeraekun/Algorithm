import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		int end = 0;
		int n = Integer.parseInt(br.readLine());
		int[][] meet = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(meet, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
		for (int i = 0; i < meet.length; i++) {
			if (meet[i][0] >= end) {
				ans++;
				end = meet[i][1];
			}
		}
		System.out.println(ans);
	}
}
