import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[1000001];
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(1000001); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int a = 3;
            int b = n - 3;
            boolean t = false;
            while (a <= b) {
                if (!prime[a] && !prime[b]) {
                    t = true;
                    break;
                }
                a += 2;
                b -= 2;
            }
            if (t) sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
            else sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.print(sb);
    }
}