import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value = Integer.MAX_VALUE;
		int[] ans = new int[2];
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = 0;
		int end = N - 1;
		while (end > start) {
			int now = arr[start] + arr[end];
			if (Math.abs(now) < value) {
				value = Math.abs(now);
				ans[0] = arr[start];
				ans[1] = arr[end];
				if (now == 0)
					break;
			}
			if (now > 0)
				end--;
			else
				start++;
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}