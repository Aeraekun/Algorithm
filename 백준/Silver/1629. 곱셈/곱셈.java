import java.io.*;
import java.util.*;

public class Main {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long a, long b) {
        if (b == 1) return a % C;
        long temp = pow(a, b / 2);
        if (b % 2 == 1) return (temp * temp % C) * a % C;
        return temp * temp % C;
    }
}