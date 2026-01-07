import java.io.*;

public class Main {
    static long S, N, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());
        N = 1;
        temp = 0;
        while (S >= temp + 2 * N + 1) {
            temp += N;
            N++;
        }
        System.out.println(N);
    }
}