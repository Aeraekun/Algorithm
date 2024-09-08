import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
        System.out.println(ans);
    }
}