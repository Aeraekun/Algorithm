import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
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