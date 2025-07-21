import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = 0;
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[N - i - 1];
        }
        System.out.println(ans);
    }
}