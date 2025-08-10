import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        dijkstra();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        pq.add(new Node(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int nEnd = curNode.end;
            if (check[nEnd]) continue;
            check[nEnd] = true;

            for (Node node : list[nEnd]) {
                if (dist[node.end] > dist[nEnd] + node.weight) {
                    dist[node.end] = dist[nEnd] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}