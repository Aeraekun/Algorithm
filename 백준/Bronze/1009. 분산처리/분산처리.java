import java.io.*;
import java.util.*;

public class Main {
    static int N, a, b, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a % 10 == 0) {
                System.out.println(10);
                continue;
            }
            if (a % 10 == 1) {
                System.out.println(1);
                continue;
            }
            ans = a % 10;
            for (int j = 0; j < b - 1; j++) {
                ans = ans * a % 10;
            }
            System.out.println(ans);
        }
    }
}
