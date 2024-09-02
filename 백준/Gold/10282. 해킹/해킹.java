import java.util.*;
import java.io.*;

public class Main {
    static int TC, N, D, C;
    static int[] com;
    static boolean[] visited;
    static List<Computer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            com = new int[N + 1];
            visited = new boolean[N + 1];
            list = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                com[i] = Integer.MAX_VALUE;
                list[i] = new ArrayList<>();
            }
            for (int d = 0; d < D; d++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[b].add(new Computer(a, c));
            }
            dijkstra(C);
            int count = 0;
            int total = 0;
            for (int i = 1; i <= N; i++) {
                if (com[i] != Integer.MAX_VALUE) {
                    count++;
                    total = Math.max(total, com[i]);
                }
            }
            System.out.println(count + " " + total);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        com[start] = 0;
        pq.add(new Computer(start, 0));
        while (!pq.isEmpty()) {
            int now = pq.poll().next;
            if (!visited[now]) {
                visited[now] = true;
                for (Computer c : list[now]) {
                    if (com[c.next] > com[now] + c.time) {
                        com[c.next] = com[now] + c.time;
                        pq.add(new Computer(c.next, com[c.next]));
                    }
                }
            }
        }
    }
}

class Computer implements Comparable<Computer> {
    int next;
    int time;

    public Computer(int next, int time) {
        this.next = next;
        this.time = time;
    }

    @Override
    public int compareTo(Computer o) {
        return this.time - o.time;
    }
}