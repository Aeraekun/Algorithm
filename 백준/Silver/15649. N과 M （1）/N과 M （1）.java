import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] check;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        count(0);
    }

    private static void count(int len) {
        if (len == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(stack.get(i)).append(' ');
            }
            System.out.println(sb);
            check[stack.pop()] = false;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (check[i]) continue;
            else {
                check[i] = true;
                stack.push(i);
                count(len + 1);
            }
        }
        if (!stack.isEmpty()) check[stack.pop()] = false;
    }
}