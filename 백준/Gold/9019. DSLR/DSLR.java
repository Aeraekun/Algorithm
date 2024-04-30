import java.io.*;
import java.util.*;

public class Main {
	static int T, b;
	static String a;
	static boolean[] visit;

	static class Dslr {
		String str;
		String log;

		Dslr(String str, String log) {
			this.str = str;
			this.log = log;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			a = setLength(a);
			b = Integer.parseInt(st.nextToken());
			visit = new boolean[10001];
			bfs();
		}
	}

	private static String setLength(String str) {
		int len = str.length();
		if (len != 4) {
			for (int i = 0; i < 4 - len; i++) {
				str = "0" + str;
			}
		}
		return str;
	}

	private static void bfs() {
		char[] arr = { 'd', 's', 'l', 'r' };
		Queue<Dslr> queue = new ArrayDeque<>();
		queue.add(new Dslr(a, ""));
		visit[Integer.parseInt(a)] = true;
		while (!queue.isEmpty()) {
			Dslr now = queue.poll();
			for (char c : arr) {
				if (c == 'd') {
					int d = 2 * Integer.parseInt(now.str) % 10000;
					if (d == b) {
						System.out.println(now.log + "D");
						return;
					} else {
						if (visit[d])
							continue;
						String str = d + "";
						str = setLength(str);
						queue.add(new Dslr(str, now.log + "D"));
						visit[d] = true;
					}
				}
				if (c == 's') {
					int s = Integer.parseInt(now.str);
					if (s == 0)
						s = 9999;
					else
						s -= 1;
					if (s == b) {
						System.out.println(now.log + "S");
						return;
					} else {
						if (visit[s])
							continue;
						String str = s + "";
						str = setLength(str);
						queue.add(new Dslr(str, now.log + "S"));
						visit[s] = true;
					}
				}
				if (c == 'l') {
					if (now.log.length() > 0 && now.log.charAt(now.log.length() - 1) == 'R')
						continue;
					String str = now.str.substring(1) + now.str.charAt(0);
					int l = Integer.parseInt(str);
					if (l == b) {
						System.out.println(now.log + "L");
						return;
					} else {
						if (visit[l])
							continue;
						queue.add(new Dslr(str, now.log + "L"));
						visit[Integer.parseInt(str)] = true;
					}
				}
				if (c == 'r') {
					if (now.log.length() > 0 && now.log.charAt(now.log.length() - 1) == 'L')
						continue;
					String str = now.str.charAt(3) + now.str.substring(0, 3);
					int r = Integer.parseInt(str);
					if (r == b) {
						System.out.println(now.log + "R");
						return;
					} else {
						if (visit[r])
							continue;
						queue.add(new Dslr(str, now.log + "R"));
						visit[Integer.parseInt(str)] = true;
					}
				}
			}
		}
	}
}