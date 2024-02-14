import java.io.*;
import java.util.*;

public class Main {
	static long A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		if(A==B) {
			System.out.println(A + " " + B);
			return;
		}
		long a = 0;
		long b = Long.MAX_VALUE;
		List<Long> list = new ArrayList<>();
		for (long i = 1; i < Math.sqrt(B); i++) {
			if (B % i == 0) {
				list.add(i);
				list.add(B / i);
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				if (cal(list.get(i), list.get(j))) {
					if (list.get(j) + list.get(i) < b + a) {
						a = list.get(i);
						b = list.get(j);
					}
				}
			}
		}
		System.out.println(a + " " + b);
	}

	private static boolean cal(long a, long b) {
		long temp = gcd(a, b);
		if (A != temp)
			return false;
		if (B != (a * b) / temp)
			return false;
		return true;
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}