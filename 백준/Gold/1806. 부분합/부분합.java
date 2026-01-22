import java.io.*;
import java.util.*;

public class Main {

    static int N, S, start, end, temp, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            if (arr[n] >= S) {
                System.out.println(1);
                return;
            }
        }
        while (true) {
            if (temp >= S) {
                ans = Math.min(ans, end - start);
                temp -= arr[start++];
            } else if (end == N) {
                break;
            } else {
                temp += arr[end++];
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}