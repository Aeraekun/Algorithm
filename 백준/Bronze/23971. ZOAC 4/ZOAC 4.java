import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0, b = 0;
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (H % (N + 1) != 0) a = H / (N + 1) + 1;
        else a = H / (N + 1);
        if (W % (M + 1) != 0) b = W / (M + 1) + 1;
        else b = W / (M + 1);
        System.out.println(a * b);
    }
}