import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) maxHeap.offer(Integer.parseInt(br.readLine()));
            else minHeap.offer(Integer.parseInt(br.readLine()));

            if (i > 0 && maxHeap.peek() > minHeap.peek()) {
                int t1 = maxHeap.poll();
                int t2 = minHeap.poll();
                maxHeap.offer(t2);
                minHeap.offer(t1);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.print(sb);
    }
}