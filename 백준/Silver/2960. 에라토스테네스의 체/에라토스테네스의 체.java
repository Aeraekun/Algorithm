import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int ans = 0;
        int a = 2;
        while (k > 0) {
            for (int i = 1; i <= n; i++) {
                if (i * a > n) break;
                if (arr[i * a] == 0) {
                    arr[i * a] = 1;
                    k--;
                    if (k == 0) {
                        ans = i * a;
                        break;
                    }
                }
            }
            if (k == 0) break;
            a++;
        }
        System.out.println(ans);
    }
}