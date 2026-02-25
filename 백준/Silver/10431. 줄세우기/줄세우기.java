import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for (int p = 1; p <= P; p++) {
            ArrayList<Child> list = new ArrayList<>();
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());
            for (int i = 0; i < 20; i++) {
                int h = Integer.parseInt(st.nextToken());
                list.add(new Child(0, h));
                for (Child c : list) {
                    if (c.height > h) c.cnt++;
                }
            }
            for (Child c : list) ans += c.cnt;
            sb.append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static class Child {
        int cnt;
        int height;

        Child(int cnt, int height) {
            this.cnt = cnt;
            this.height = height;
        }
    }
}