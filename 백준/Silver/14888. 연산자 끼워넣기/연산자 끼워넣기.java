import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] num;
    static int[] operator = new int[4];
    static int[] count = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
        dfs(num[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int now, int order) {
        if (order == N) {
            max = Math.max(now, max);
            min = Math.min(now, min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                if (i == 0) dfs(now + num[order], order + 1);
                else if (i == 1) dfs(now - num[order], order + 1);
                else if (i == 2) dfs(now * num[order], order + 1);
                else dfs(now / num[order], order + 1);
                operator[i]++;
            }
        }
    }
}