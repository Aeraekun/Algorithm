import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		prime = new boolean[n + 1];
		ans = 0;
		getPrime(n);
		cal(n);
		System.out.println(ans);
	}

	private static void getPrime(int n) {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

	private static void cal(int n) {
		int i = 2;
		int j = 2;
		int sum = 2;
		while (j < n || i < n) {
			if (sum < n) {
				do {
					j++;
				} while (prime[j] && j < n);
				sum += j;
			} else if (sum > n) {
				sum -= i;
				do {
					i++;
				} while (prime[i] && i < n);
			} else {
				ans++;
				do {
					j++;
				} while (prime[j] && j < n - 1);
				sum += j;
			}
		}
		if (!prime[n])
			ans++;
	}
}