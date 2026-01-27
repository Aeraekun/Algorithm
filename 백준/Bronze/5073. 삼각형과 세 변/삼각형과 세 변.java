import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
            a = pq.poll();
            b = pq.poll();
            c = pq.poll();
            if (a == 0 && b == 0 && c == 0) break;
            else if (a == b && b == c) sb.append("Equilateral\n");
            else {
                if (c >= a + b) sb.append("Invalid\n");
                else if (a == b || b == c) sb.append("Isosceles\n");
                else sb.append("Scalene\n");
            }
        }
        System.out.print(sb);
    }
}