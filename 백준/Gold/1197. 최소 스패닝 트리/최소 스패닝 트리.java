import java.io.*;
import java.util.*;

public class Main {
    static int V, E, cnt, ans;
    static int[] parent;
    static List<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= V; i++) parent[i] = i;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for (Node node : list) {
            if (union(node.from, node.to)) {
                ans += node.cost;
                cnt++;
            }
            if (cnt == E - 1) break;
        }

        System.out.println(ans);
    }

    private static boolean union(int from, int to) {
        int rootFrom = find(from);
        int rootTo = find(to);
        if (rootFrom == rootTo) return false;
        parent[rootTo] = rootFrom;
        return true;
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = find(parent[n]);
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}