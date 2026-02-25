import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static int[] rock;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        rock = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) rock[i] = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;
        visit(start, 0);
        for (int i = 0; i < n; i++) if (visited[i]) ans++;
        System.out.println(ans);
    }

    static private void visit(int now, int temp) {
        if (now >= n || now < 0 || visited[now]) return;
        visited[now] = true;
        temp++;
        visit(now + rock[now], temp);
        visit(now - rock[now], temp);
    }
}