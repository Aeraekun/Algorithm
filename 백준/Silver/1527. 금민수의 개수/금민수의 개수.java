import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        int ans = 0;
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        list.add(4L);
        list.add(7L);
        int idx = 0;
        while (list.get(idx) <= 1000000000) {
            list.add(Long.parseLong(list.get(idx).toString() + "4"));
            list.add(Long.parseLong(list.get(idx).toString() + "7"));
            idx++;
        }
        for (long i : list) {
            if (i < a) continue;
            if (i > b) break;
            ans++;
        }
        System.out.println(ans);
    }
}