import java.io.*;
import java.util.*;

public class Main {
	static long[] cnt2, cnt5;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		cnt2 = new long[3];
		cnt5 = new long[3];
		long n = sc.nextInt();
		long m = sc.nextInt();
		cal5(n, 0);
		cal5(m, 1);
		cal5(n - m, 2);
		cal2(n, 0);
		cal2(m, 1);
		cal2(n - m, 2);
		System.out.println(Math.min(cnt5[0] - cnt5[1] - cnt5[2], cnt2[0] - cnt2[1] - cnt2[2]));
	}

	static void cal5(long n, int i) {
		if (n / 5 == 0)
			return;
		cnt5[i] += n / 5;
		cal5(n / 5, i);
	}

	static void cal2(long n, int i) {
		if (n / 2 == 0)
			return;
		cnt2[i] += n / 2;
		cal2(n / 2, i);
	}
}
