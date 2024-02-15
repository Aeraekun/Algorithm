import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int ans = 0;
			int[] nowA = { 0, 0 };
			int[] nowB = { 9, 9 };
			int apX, apY, apR, apP;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			int[][][] apRange = new int[A][10][10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for (int ap = 0; ap < A; ap++) {
				st = new StringTokenizer(br.readLine());
				apX = Integer.parseInt(st.nextToken()) - 1;
				apY = Integer.parseInt(st.nextToken()) - 1;
				apR = Integer.parseInt(st.nextToken());
				apP = Integer.parseInt(st.nextToken());
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (Math.abs(apX - i) + Math.abs(apY - j) <= apR)
							apRange[ap][j][i] = apP;
					}
				}
			}
			for (int m = 0; m <= M; m++) {
				int temp = 0;
				int max = 0;
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < A; j++) {
						temp = apRange[i][nowA[1]][nowA[0]] + apRange[j][nowB[1]][nowB[0]];
						if (apRange[i][nowA[1]][nowA[0]] == apRange[j][nowB[1]][nowB[0]] && i == j)
							temp /= 2;
						max = Math.max(temp, max);
					}
				}
				ans += max;
				if (m != M) {
					switch (moveA[m]) {
					case 1:
						nowA[1]--;
						break;
					case 2:
						nowA[0]++;
						break;
					case 3:
						nowA[1]++;
						break;
					case 4:
						nowA[0]--;
						break;
					}
					switch (moveB[m]) {
					case 1:
						nowB[1]--;
						break;
					case 2:
						nowB[0]++;
						break;
					case 3:
						nowB[1]++;
						break;
					case 4:
						nowB[0]--;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}