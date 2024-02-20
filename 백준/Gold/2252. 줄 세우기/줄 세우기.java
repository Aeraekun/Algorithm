import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [] in = new int [N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i=1; i<=M; i++) {
			String [] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			list[s].add(e);
			++in[e];
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) {
			if (in[i] == 0) {
				q.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");
			for (int i=0, size = list[v].size(); i < size; i++) {
				int e = list[v].get(i);
				if (--in[e] == 0) {
					q.offer(e);
				}
			}
		}
		System.out.println(sb.toString().trim());
	}
}
