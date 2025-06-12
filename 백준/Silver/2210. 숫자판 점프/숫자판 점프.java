import java.io.*;
import java.util.*;

public class Main {
    static int map[][] = new int[5][5];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j);
            }
        }
        System.out.println(set.size());
    }

    private static void dfs(int i, int j) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(i, j, new StringBuffer().append(map[i][j])));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (int d = 0; d < 4; d++) {
                int nx = node.nx + dx[d];
                int ny = node.ny + dy[d];
                if (!(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)) {
                    StringBuffer nsb = new StringBuffer(node.nsb);
                    nsb.append(map[nx][ny]);
                    if (nsb.length() == 6) {
                        set.add(nsb.toString());
                    } else {
                        stack.push(new Node(nx, ny, nsb));
                    }
                }
            }
        }
    }

    private static class Node {
        int nx;
        int ny;
        StringBuffer nsb;

        Node(int x, int y, StringBuffer sb) {
            nx = x;
            ny = y;
            nsb = sb;
        }
    }
}
