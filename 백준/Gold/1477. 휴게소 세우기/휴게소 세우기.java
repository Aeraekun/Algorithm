import java.util.*;
import java.io.*;

public class Main {
    static int N, M, L;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);
        int left = 1, right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 1; i < arr.length; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }
            if (sum > M) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
}