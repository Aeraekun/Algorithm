import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = 1, ans = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        while (true) {
            arr[now]++;
            if (arr[now] == m)
                break;
            ans++;
            if (arr[now] % 2 == 1) {
                now += l;
                if (now > n)
                    now %= n;
            } else {
                now -= l;
                if (now == 0)
                	now = n;
                if (now < 0)
                    now = (now + n) % n;
            }
        }
        System.out.println(ans);
    }
}