import java.io.*;
import java.util.*;

public class Main {

	static int L, C;
	static int ja, mo;
	static boolean[] visited;
	static Object[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[C];
		arr = Arrays.stream(br.readLine().split(" ")).sorted().toArray();
		comb(0, 0);
	}

	private static void comb(int start, int now) {
		if (now == L) {
			ja = mo = 0;
			sb.setLength(0);
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o")
							|| arr[i].equals("u")) {
						mo++;
					} else
						ja++;
					sb.append(arr[i]);
				}
			}
			if (mo >= 1 && ja >= 2)
				System.out.println(sb);
		}
		for (int i = start; i < C; i++) {
			visited[i] = true;
			comb(i + 1, now + 1);
			visited[i] = false;
		}
	}
}