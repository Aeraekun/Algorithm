import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] graph;
    static List<Integer>[] list;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int n = 1; n <= N; n++) list[n] = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            graph[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (graph[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');
            for(int i:list[now]) {
                graph[i]--;
                if(graph[i]==0) queue.offer(i);
            }
        }

        System.out.println(sb);
    }
}