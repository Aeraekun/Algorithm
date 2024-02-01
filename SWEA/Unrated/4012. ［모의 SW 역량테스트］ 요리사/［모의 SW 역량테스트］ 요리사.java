import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N, t;
    static int ans;
    static int[] numbers;
    static int[][] arr;
    static boolean[] boolArr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (t = 1; t <= tc; t++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            numbers = new int[N / 2];
            boolArr = new boolean[N];
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0, 0);
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void combination(int cnt, int start) {
        if (cnt == N / 2) {
            count();
            return;
        }
        for (int i = start; i < N; i++) {
            if (cnt == 0 && i != 0) break;
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void count() {
        int a = 0;
        int b = 0;
        boolean[] exists = new boolean[N];
        for (int num : numbers) {
            exists[num] = true;
        }
        int count = 0;
        for (boolean exist : exists) {
            if (!exist) {
                count++;
            }
        }
        int[] bList = new int[count];
        int index = 0;
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                bList[index++] = i;
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                a += arr[numbers[i]][numbers[j]];
                b += arr[bList[i]][bList[j]];
            }
        }
        ans = Math.min(Math.abs(a - b), ans);
    }
}