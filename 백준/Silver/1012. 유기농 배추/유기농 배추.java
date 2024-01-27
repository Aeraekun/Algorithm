import java.io.*;
import java.util.*;
public class Main {

	static int M, N, K;
	static int map[][];
	static int dx[]= {0,1,0,-1}, dy[]= {1,0,-1,0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			int cnt=0;
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
						que.add(new Node(i,j));
						bfs();
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);

		}
	}

	public static void bfs() {
		while(!que.isEmpty()) {
			Node n =que.poll();
			int x = n.nx;
			int y = n.ny;
			for(int i=0;i<4;i++) {
				int rx = x+dx[i];
				int ry = y+dy[i];
				if(isRange(rx, ry) && map[rx][ry]==1) {
					map[rx][ry]=0;
					que.add(new Node(rx, ry));
				}
			}
		}
	}
	static boolean isRange(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) {
			return false;
		}		
		return true;
	}
	
	static class Node {
		int nx, ny;
		public Node(int x, int y) {
			nx = x; ny = y;
		}
	}
}

