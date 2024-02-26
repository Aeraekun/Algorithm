import java.io.*;
import java.util.*;

public class Main {
    static int N, X, K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] cup = new boolean[N];
        cup[X - 1] = true;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            boolean temp = cup[a];
            cup[a] = cup[b];
            cup[b] = temp;
        }
        for (int n = 0; n < N; n++) {
            if (cup[n]) {
                System.out.println(n + 1);
                break;
            }
        }
    }
}
