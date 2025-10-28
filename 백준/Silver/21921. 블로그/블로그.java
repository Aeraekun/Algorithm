import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int now = 0;
        int max = 0;
        int count = 1;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            now += arr[i];
        }
        max = now;
        for (int i = X; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            now = now + arr[i] - arr[i - X];
            if (max == now) count++;
            if (max < now) count = 1;
            max = Math.max(now, max);
        }
        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}