import java.util.*;
import java.io.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    static int n;
    static double ans;
    static int[] parent;
    static Point[] points;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;
        parent = new int[n];
        points = new Point[n];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent[i] = i;
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i, x, y);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double len = sqrt(pow(points[i].x - points[j].x, 2) + pow(points[i].y - points[j].y, 2));
                pq.add(new Edge(points[i].num, points[j].num, len));
            }
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.start) != find(e.end)) {
                ans += e.len;
                int x = find(e.start);
                int y = find(e.end);
                if (x != y) parent[y] = x;
            }
        }
        System.out.println(ans);
    }

    public static int find(int num) {
        if (num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }

    public static class Point {
        int num;
        double x;
        double y;

        Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double len;

        public Edge(int start, int end, double len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        public int compareTo(Edge e) {
            if (this.len > e.len) {
                return 1;
            }
            return -1;
        }
    }
}