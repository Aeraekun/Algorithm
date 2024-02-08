import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		int[] input = new int[N];
		boolean search = false;
		boolean print = false;
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
			arr[i] = input[i];
		}
		Arrays.sort(arr, Collections.reverseOrder());
		if (Arrays.toString(arr).equals(Arrays.toString(input)))
			System.out.println(-1);
		else {
			np(input);
			for (int i : input)
				sb.append(i).append(" ");
			System.out.println(sb);
		}
	}

	public static boolean np(int[] p) {
		final int N = p.length;
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
