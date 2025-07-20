import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        K = Math.min(K, N - K);
        if (K == 0) {
            System.out.println(1);
        } else {
            int a = N;
            int b = 1;
            for (int i = 1; i < K; i++) {
                a *= N - i;
                b *= i + 1;
            }
            System.out.println(a / b);
        }
    }
}
