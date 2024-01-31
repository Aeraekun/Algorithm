import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int numbers[];
	static boolean isSelected[];
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			N = list.size();
			numbers = new int[6];
			isSelected = new boolean[N];
			permutation(0,0);
			System.out.println();
		}
	}

	static void permutation(int cnt,int start) {
		if (cnt == 6) {
			for (int i : numbers)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = list.get(i);
			permutation(cnt + 1,i+1);
		}
	}
}
