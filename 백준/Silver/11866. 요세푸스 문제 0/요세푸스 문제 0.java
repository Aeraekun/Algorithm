import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) queue.add(i);
        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) queue.add(queue.poll());
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}
