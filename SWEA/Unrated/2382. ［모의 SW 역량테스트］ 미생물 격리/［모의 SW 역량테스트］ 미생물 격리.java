import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K, ans;
    static int[][] arr;
    static int[] dx = {0, 0, 0, -1, 1}; // 0, 상, 하, 좌, 우
    static int[] dy = {0, -1, 1, 0, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 맵 사이즈
            M = Integer.parseInt(st.nextToken()); // 시간
            K = Integer.parseInt(st.nextToken()); // 군집 수
            ans = 0;
            arr = new int[K][4];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // y
                arr[i][1] = Integer.parseInt(st.nextToken()); // x
                arr[i][2] = Integer.parseInt(st.nextToken()); // 미생물 양
                arr[i][3] = Integer.parseInt(st.nextToken()); // 방향
            }
            for (int m = 0; m < M; m++) {
                ArrayList<Integer>[][] list = new ArrayList[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        list[i][j] = new ArrayList<>();
                    }
                }
                for (int k = 0; k < K; k++) {
                    if (arr[k][0] == -1)
                        continue;
                    list[arr[k][0] + dy[arr[k][3]]][arr[k][1] + dx[arr[k][3]]].add(k);
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (list[i][j].size() == 1) {
                            int temp = list[i][j].get(0);
                            arr[temp][0] += dy[arr[temp][3]];
                            arr[temp][1] += dx[arr[temp][3]];
                            if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                                arr[temp][2] /= 2;
                                if (arr[temp][3] == 1) {
                                    arr[temp][3] = 2;
                                } else if (arr[temp][3] == 2) {
                                    arr[temp][3] = 1;
                                } else if (arr[temp][3] == 3) {
                                    arr[temp][3] = 4;
                                } else if (arr[temp][3] == 4) {
                                    arr[temp][3] = 3;
                                }
                            }
                        } else if (list[i][j].size() > 1) {
                            int idx = list[i][j].get(0);
                            int sum = arr[list[i][j].get(0)][2];
                            int max = arr[list[i][j].get(0)][2];
                            for (int s = 1; s < list[i][j].size(); s++) {
                                sum += arr[list[i][j].get(s)][2];
                                if (max < arr[list[i][j].get(s)][2]) {
                                    arr[idx][0] = -1;
                                    arr[idx][1] = -1;
                                    arr[idx][2] = 0;
                                    max = arr[list[i][j].get(s)][2];
                                    idx = list[i][j].get(s);
                                } else {
                                    arr[list[i][j].get(s)][0] = -1;
                                    arr[list[i][j].get(s)][1] = -1;
                                    arr[list[i][j].get(s)][2] = 0;
                                }
                            }
                            arr[idx][0] += dy[arr[idx][3]];
                            arr[idx][1] += dx[arr[idx][3]];
                            arr[idx][2] = sum;
                        }
                    }
                }
            }
            for (int i = 0; i < K; i++) {
                ans += arr[i][2];
            }
            System.out.printf("#%d %d\n", t, ans);
        }

    }
}