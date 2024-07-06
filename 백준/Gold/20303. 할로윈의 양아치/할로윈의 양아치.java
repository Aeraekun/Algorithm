import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] candy, parent, candySum, friendCount;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        parent = new int[N + 1];
        candySum = new int[N + 1];
        friendCount = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i; // 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            candySum[root] += candy[i];
            friendCount[root]++;
        }

        List<int[]> groups = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                groups.add(new int[]{candySum[i], friendCount[i]});
            }
        }

        dp = new int[groups.size() + 1][K];

        for (int i = 1; i <= groups.size(); i++) {
            int candy = groups.get(i - 1)[0];
            int count = groups.get(i - 1)[1];
            for (int j = 1; j < K; j++) {
                if (count > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - count] + candy);
                }
            }
        }

        System.out.println(dp[groups.size()][K - 1]);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
