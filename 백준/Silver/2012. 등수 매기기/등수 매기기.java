import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		long ans = 0;
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
			ans += Math.abs(arr[i] - i - 1);
		System.out.println(ans);
	}
}