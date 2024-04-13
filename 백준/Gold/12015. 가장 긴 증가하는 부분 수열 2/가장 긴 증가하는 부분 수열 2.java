import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0;
		list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now > list.get(list.size() - 1)) {
				list.add(now);
			} else {
				int start = 0;
				int end = list.size() - 1;
				int mid = (start + end) / 2;
				while (start < end) {
					mid = (start + end) / 2;
					if (list.get(mid) < now)
						start = mid + 1;
					else
						end = mid;
				}
				list.set(end, now);
			}
		}
		System.out.println(list.size());
	}
}
