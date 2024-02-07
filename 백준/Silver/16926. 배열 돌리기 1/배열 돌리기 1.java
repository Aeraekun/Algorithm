import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int R, C, rotateCnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = line[0];
		C = line[1];
		rotateCnt = line[2];
		inputMap();
		rotateMap();
		printMap();
	}

	private static void rotateMap() {
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int loopCnt = Math.min(R, C) / 2;
		for (int cnt = 0; cnt < loopCnt; cnt++) {
			int rCnt = rotateCnt % ((R - cnt * 2) * 2 + (C - cnt * 2) * 2 - 4);
			for (int n = 1; n <= rCnt; n++) {
				int r = cnt, c = cnt, temp = map[r][c];
				for (int d = 0; d < 4; d++) {
					while (true) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < cnt || nc < cnt || nr >= R - cnt || nc >= C - cnt)
							break;
						int swap = map[nr][nc];
						map[nr][nc] = temp;
						temp = swap;
						r = nr;
						c = nc;
					}
				}
			}
		}
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(map).forEach(row -> {
			Arrays.stream(row).forEach(v -> sb.append(v).append(" "));
			sb.append("\n");
		});
		System.out.println(sb);
	}

	private static void inputMap() throws IOException {
		map = new int[R][];
		for (int i = 0; i < R; i++)
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}