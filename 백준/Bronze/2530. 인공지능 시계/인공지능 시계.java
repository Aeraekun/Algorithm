import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());
        A += D / 3600;
        D = D % 3600;
        B += D / 60;
        D = D % 60;
        C += D;
        if (C >= 60) {
            C -= 60;
            B++;
        }
        if (B >= 60) {
            B -= 60;
            A++;
        }
        if (A >= 24) {
            A %= 24;
        }
        System.out.println(sb.append(A).append(' ').append(B).append(' ').append(C));
    }
}