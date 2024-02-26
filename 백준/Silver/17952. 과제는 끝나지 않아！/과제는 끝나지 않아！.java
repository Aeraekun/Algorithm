import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int[] now = new int[2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				if (now[0] != 0) {
					stack.add(new int[] { now[0], now[1] });
				}
				now[0] = Integer.parseInt(st.nextToken());
				now[1] = Integer.parseInt(st.nextToken());

			} else {
				if (!stack.isEmpty()) {
					if (now[0] == 0)
						now = stack.pop();
				}
			}
			if (now[0] != 0)
				now[1]--;
			if (now[1] == 0) {
				ans += now[0];
				now[0] = 0;
			}
		}
		System.out.println(ans);
	}
}
