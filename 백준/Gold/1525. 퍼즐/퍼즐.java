import java.io.*;
import java.util.*;

public class Main {
    static String ans = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }
        map.put(sb.toString(), 0);
        System.out.println(bfs(sb.toString()));
    }

    private static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        while (!queue.isEmpty()) {
            String now = queue.poll();
            int move = map.get(now);
            int empty = now.indexOf('0');
            int py = empty / 3;
            int px = empty % 3;
            if (now.equals(ans)) return move;
            for (int d = 0; d < 4; d++) {
                int ny = dy[d] + py;
                int nx = dx[d] + px;
                if (nx < 0 || ny < 0 || nx > 2 || ny > 2) continue;
                int nNow = ny * 3 + nx;
                StringBuilder next = new StringBuilder(now);
                next.setCharAt(empty, now.charAt(nNow));
                next.setCharAt(nNow, '0');

                String nextString = next.toString();
                if (!map.containsKey(nextString)) {
                    queue.add(nextString);
                    map.put(nextString, move + 1);
                }
            }
        }
        return -1;
    }
}