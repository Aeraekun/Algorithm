import java.io.*;
import java.util.*;

public class Main {
    static int N, T, P;
    static double S, M, L, XL, XXL, XXXL;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Double.parseDouble(st.nextToken());
        M = Double.parseDouble(st.nextToken());
        L = Double.parseDouble(st.nextToken());
        XL = Double.parseDouble(st.nextToken());
        XXL = Double.parseDouble(st.nextToken());
        XXXL = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        System.out.println((int) (Math.ceil(S / T) + Math.ceil(M / T)
                + Math.ceil(L / T) + Math.ceil(XL / T)
                + Math.ceil(XXL / T) + Math.ceil(XXXL / T)));
        System.out.print(N / P + " " + N % P);
    }
}
