import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        int[][] arr = new int[6][2];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b - 1][a]++;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] % 2 == 1) {
                    ans++;
                }
                ans += arr[i][j] / 2;
            }
        }
        System.out.println(ans);
    }
}