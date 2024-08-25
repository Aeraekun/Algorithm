import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int lo = 1;
        int hi = home[N - 1];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int position = 0;
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (home[i] - home[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }
            if (cnt < C) {
                hi = mid - 1;
                continue;
            }
            lo = mid + 1;
        }
        System.out.println(lo - 1);
    }
}
