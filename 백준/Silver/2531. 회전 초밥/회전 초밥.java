import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int[] kind;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        kind = new int[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        twoPoint();
        System.out.println(ans);
    }

    private static void twoPoint() {
//        Deque<Integer> deque = new ArrayDeque<>();
        int temp = 0;
        int end = 0;
        for (int i = 0; i < k; i++) {
            if (kind[sushi[i]] == 0) temp++;
            kind[sushi[i]]++;
        }

        if (kind[c] == 0) ans = temp + 1;
        else ans = temp;

        for (int start = 1; start < N; start++) {
            if (kind[sushi[start - 1]] == 1) temp--;
            kind[sushi[start - 1]]--;

            end = (start + k - 1) % N;
            if (kind[sushi[end]] == 0) temp++;
            kind[sushi[end]]++;

            int count;
            if (kind[c] == 0) count = temp + 1;
            else count = temp;

            ans = Math.max(ans, count);
        }
    }
}
