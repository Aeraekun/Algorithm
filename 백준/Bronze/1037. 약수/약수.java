import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int m = M;
        for (int i = 1; i < j; i++) {
            int temp = Integer.parseInt(st.nextToken());
            M = Math.max(M, temp);
            m = Math.min(m, temp);
        }
        System.out.println(M * m);
    }
}